package com.example.demo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyExecutorServiceMain {
    /**
     * when we create an `Executor` using the static factory methods in the `Executors` class,
     * such as `newFixedThreadPool()` or `newCachedThreadPool()`, it creates a `ThreadPoolExecutor`
     * instance to do the actual work of executing tasks
     *
     * the `Executors` class provides a set of convenience methods for creating different types of
     * `Executor` instance, such as fixed thread pool, cached thread pools, single thread executors,
     * and scheduled executors. these methods use a `ThreadPoolExecutor` under the hood to create
     * and manage the threads that execute the submitted tasks
     *
     * e.g. the `newFixedThreadPool(int nThreads)` method creates a new `ThreadPoolExecutor` instance
     * with a fixed pool size of `nThreads`, meaning that the thread pool will have a fixed number of
     * worker threads that will execute tasks submitted to it.
     * similarly, the `newCachedThreadPool()` method creates a new `ThreadPoolExecutor` instance with an
     * unbounded pool size, meaning that the thread will create new threads as needed to execute tasks,
     * and reuse idle threads when possible.
     *
     * by using the `Executor` interface and the `Executors` class, we can easily create and manage a thread
     * pool without having to deal with the low-level details of thread management. the `ThreadPoolExecutor`
     * provides a flexible and powerful implementation of the `Executor` interface that can be customized to
     * meet the needs of a wide range of use cases
     */
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
