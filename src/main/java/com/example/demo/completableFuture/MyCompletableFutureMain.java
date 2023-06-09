package com.example.demo.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MyCompletableFutureMain {
    /**
     * any time-consuming task should be preferably done asynchronously
     * two basic approaches to asynchronous task handling are available to a java application
     *
     * application logic blocks until a task completes
     * application logic is called once the task completes, this is called a non-blocking approach
     *
     * `CompletableFuture` is a type of `Future` that represents a computation that may or may not be complete.
     * it provides a way to perform operations asynchronously, wihtout blocking the calling thread,
     * and then to handle the results of those operations when they become available. it allows you to create a
     * chain of tasks that execute one after the other, where each task can be either complete successfully
     * or fail with an exception.
     *
     *
     * `CompletableFuture` provides a number of methods that allow you to create and manipulate asynchronous
     * computations. for example, we can use
     * CompletableFuture.supplyAsync(this::doSomething) to create an asynchronous computation that returns a value
     * and the
     * CompletableFuture.thenApply() to chain another computation that depends on the result of the first one
     */

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(() -> {
            try {
                // simulate long-running task
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            return 20;
            }
        );
        return futureCount;
    }

    public static void main(String[] args) {
        // start timer
        long started = System.currentTimeMillis();

        // configure CompletableFuture
        // use sleep function to simulate a long-running task
        CompletableFuture<Integer> futureCount = createCompletableFuture();

        /**
         * continue to do other work in parallel while waiting for the long-running task to complete
         * other work here is simulated by printing out a message indicating that some other work is
         * being done
         * took ~ 4 to 5 milliseconds
         */
        System.out.println("Took " + (System.currentTimeMillis() - started) + " milliseconds to do other work");

        // now its time to get the result
        try {
            int count = futureCount.get();
            System.out.println("CompletableFuture took " + (System.currentTimeMillis() - started) + " milliseconds to do long-running task");
            System.out.println("Result: " + count);
        } catch (InterruptedException | ExecutionException ex) {
            // Exceptions from the future should be handled here
        }

    }
}
