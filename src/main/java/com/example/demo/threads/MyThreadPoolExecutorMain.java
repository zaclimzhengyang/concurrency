package com.example.demo.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutorMain {
    private static final int numberOfThreads = 10;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(100000 + i);
            executor.execute(worker);
        }
        // wait until all threads are finished
        executor.awaitTermination(5L, TimeUnit.SECONDS);
        // this will make the executor not accept any new threads
        // and final all existing threads in the queue
        executor.shutdown();
        System.out.println("Finished all threads");
    }
}
