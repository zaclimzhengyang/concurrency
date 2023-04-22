package com.example.demo.forkJoin;

import java.util.concurrent.ForkJoinPool;

public class Test {

    public static void main(String[] args) {
        /**
         * create an instance of the `Problem` class, which generates a long list
         * of random integers
         * get the number of available processors on the system by calling
         * `Runtime.getRuntime().availableProcessors()`
         * then create a `ForkJoinPool` with the number of threads equal to the
         * number of available processors
         * invoke the `Solver` instance using the `ForkJoinPool.invoke()` method
         * this will execute the `compute()` method of the `Solver` instance in parallel
         * using the `forkJoin` framework
         */
        long startTime = System.currentTimeMillis();
        Problem test = new Problem();
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(numberOfThreads);
        Solver solver = new Solver(test.getList());
        pool.invoke(solver);
        long result = solver.getResult();
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time using fork join in milliseconds: " + timeElapsed);
        System.out.println("Done. Result: " + result);

        /**
         * compute the sum of the list of the integers using a sequential
         * loop, to check that the result is correct
         */
        long startTime2 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < test.getList().length; i ++) {
            sum += test.getList()[i];
        }
        long endTime2 = System.currentTimeMillis();
        long timeElapsed2 = endTime2 - startTime2;
        System.out.println("Execution time using for loop in milliseconds: " + timeElapsed);
        System.out.println("Done: Result: " + result);

    }
}
