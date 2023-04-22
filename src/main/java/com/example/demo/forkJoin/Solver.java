package com.example.demo.forkJoin;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class Solver extends RecursiveAction {
    private int[] list;
    public long result;

    public Solver(int[] array) {
        this.list = array;
    }

    @Override
    protected void compute() {
        if (list.length == 1) {
            result = list[0];
        } else {
            /**
             * these two Solver objects are created by splitting the input list into two halves
             * and recursively calling the compute method on each half
             */
            int midpoint = list.length / 2;
            int[] list1 = Arrays.copyOfRange(list, 0, midpoint);
            int[] list2 = Arrays.copyOfRange(list, midpoint, list.length);
            Solver solver1 = new Solver(list1);
            Solver solver2 = new Solver(list2);

            // forkJoin is used to initiate the computation of two sub-problems in parallel
            forkJoin(solver1, solver2);
            result = solver1.result + solver2.result;
        }
    }

    /**
     * helper method that is used to submit tasks to the ForkJoinPool
     * it uses the invokeAll method of the ForkJoinTask to submit the given tasks
     * to the pool and wait for their completion
     */
    protected static void forkJoin(RecursiveAction task1, RecursiveAction task2) {
        ForkJoinTask.invokeAll(task1, task2);
    }

    public long getResult(){
        return result;
    }
}
