package com.example.demo.threads;

import java.util.ArrayList;

public class MyRunnableMain {
    /**
     * here, we use the `Thread` class directly
     * and it has the following disadvantages:
     *      1. create a new thread causes some performance overhead
     *      2. too many threads can lead to reduced performance, as the CPU needs to switch between these threads
     *      3. we cannot easily control the number of threads, therefore we may run into `out of memory` errors due to too many threads
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        // we will create 500 threads
        for (int i = 0; i < 500; i++) {
            MyRunnable task = new MyRunnable(100000 + i);
            Thread worker = new Thread(task);
            // we can set the name of the thread
            worker.setName(String.valueOf(i));
            // start the thread, never call method run() directly
            worker.start();
            System.out.println("Current thread running: worker.getName(): " + worker.getName());
            // remember the thread for later usage
            threads.add(worker);
        }
        int running = 0;
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