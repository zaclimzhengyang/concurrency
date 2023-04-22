package com.example.demo.nonBlocking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.*;

public class NonBlockingCounterTest {
    /**
     * this test class is to test the functionality of a non-blocking counter
     *
     * `Callable` is used for more complex tasks that require a return value
     * or can throw checked exceptions
     */
    private static final int numberOfThreads = 10;

    public static void main(String[] args) {
        /**
         * we initialize the number of threads to 10, and then create an instance of a non-blocking counter object
         * an ArrayList is then initialized to hold a list of Futures.
         * a `Future` represents the result of an asynchronous computation. and in this case,
         * it is used to represent the value returned by the non-blocking counter
         *
         * next, an ExecutorService is created using the Executor.newFixedThreadPool() method,
         * which creates a thread pool with a fixed number of threads. in this case, it creates a thread pool with 10 threads
         */
        final NonBlockingCounter counter = new NonBlockingCounter();
        ArrayList<Future<Integer>> list = new ArrayList<Future<Integer>>();

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        /**
         * enter a for loop that runs 500 times, each time creating a new `Callable` object that is submitted
         * to the thread pool for execution. the `Callable` object is responsible for incrementing the
         * non-blocking counter and returning the new value
         * after incrementing the counter, the `Callable` object prints the new value to the console
         * the `Future` object returned by the submit() method is added to the ArrayList
         *
         */
        for (int i = 0; i < 500; i++) {
            Callable<Integer> worker = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    // introduce a random delay between 1 to 500 milliseconds to increase chances of possibility of double-entries exception
                    // Thread.sleep((long)(Math.random()*500) + 1);
                    int number = counter.increment();
                    System.out.println(number);
                    return number;
                }
            };
            Future<Integer> submit = executor.submit(worker);
            list.add(submit);
        }

        /**
         * this will make the executor not accept any new threads and finish all existing threads in the queue
         * after all the `Callables` have been submitted to the thread pool, the executor is shutdown using the
         * shutdown() method, which prevents any new threads from being accepted and waits for all the
         * currently executing threads to finish
         */
        executor.shutdown();

        /**
         * a while loop then waits for all the threads in the thread pool to terminate by repeatedly calling the
         * isTerminated() method on the ExecutorService until it returns true
         * once all the threads have finished, a hashset is used to store the unique values returned
         * by the `Callables`. this is done to check if there are any duplicate values returned by the non-blocking counter
         *
         */
        while (!executor.isTerminated()) {
        }

        /**
         * finally, we check if the size of the list of `Futures` is equal to the size of the HashSet.
         * if the sizes are not equal, then the program will throw a RungtimeException indicating that
         * there are double-entries in the set, which emans that the non-blocking counter is not functioning properly
         */
        HashSet<Integer> set = new HashSet<Integer>();
        for (Future<Integer> future: list) {
            try {
                set.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        if (list.size() != set.size()) {
            throw new RuntimeException("Double-entries!");
        }

    }
}
