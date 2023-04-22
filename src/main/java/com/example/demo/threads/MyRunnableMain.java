package com.example.demo.threads;

import java.util.ArrayList;

public class MyRunnableMain {
    /**
     * here, we use the `Thread` class directly
     * and it has the following disadvantages:
     *      1. create a new thread causes some performance overhead
     *      2. too many threads can lead to reduced performance, as the CPU needs to switch between these threads
     *      3. we cannot easily control the number of threads, therefore we may run into `out of memory` errors due to too many threads
     */
    public static void main(String[] args) {
        /**
         * we will create 500 threads, set the name of each thread
         * start the thread by calling `start()` method on `Thread worker`
         * remember the thread for later usage, by adding to the list of thread
         */
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 500; i++) {
            MyRunnable task = new MyRunnable(100000 + i);
            Thread worker = new Thread(task);
            worker.setName(String.valueOf(i));
            worker.start();
            System.out.println("Current thread running: worker.getName(): " + worker.getName());
            threads.add(worker);
        }
        int running = 0;
        /**
         * we check the number of running threads to ensure that the program does not exit prematurely
         * before all the work is done
         * when a thread is started using the `start()` method, it does not immediately complete its
         * task and terminate. instead, the thread is scheduled by the operating system to run
         * concurrently with other threads. this means that even though a thread has been started,
         * it may not have completed its task yet, and could still be running
         */
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {

                    running++;
                }
            }
            System.out.println("We have " + running + " running threads");
        } while (running > 0);
    }
}