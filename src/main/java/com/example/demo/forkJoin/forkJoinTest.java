package com.example.demo.forkJoin;

import java.util.concurrent.ForkJoinPool;

public class forkJoinTest {

    public static void main(String[] args) {
        RandomGeneratorProblem test = new RandomGeneratorProblem();

        // check the number of available processors
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(numberOfThreads);
        Solver solver = new Solver(test.getList());
        ForkJoinPool pool = new ForkJoinPool(numberOfThreads);
        pool.invoke(solver);
        long result = solver.getRawResult();
        System

    }
}
