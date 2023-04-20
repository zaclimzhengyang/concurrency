package com.example.demo.forkJoin;

import java.lang.reflect.Array;
import java.util.Arrays;
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
            int midpoint = list.length / 2;
            int[] list1 = Arrays.copyOfRange(list, 0, midpoint);
            int[] list2 = Arrays.copyOfRange(list, midpoint, list.length);
            Solver solver1 = new Solver(list1);
            Solver solver2 = new Solver(list2);
//            forkJoin(solver1, solver2);
            result = solver1.result + solver2.result;
        }
    }
}
