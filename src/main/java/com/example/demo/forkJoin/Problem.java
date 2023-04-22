package com.example.demo.forkJoin;

import java.util.Random;

public class Problem {
    private final int[] list = new int[2147483];

    /**
     * constructor that initializes the array by first creating a `Random` object with a seed of 100
     * then, a loop is executed 10 times to generate a random integer between 0 and 99 using the `nextInt` method
     * of the `Random` class. the generated integer is assigned to the current index of the array `list`
     */
    public Problem() {
        Random generator = new Random(2147483647);
        for (int i = 0; i < list.length; i++) {
            list[i] = generator.nextInt(2147483647);
            System.out.println("Number " + (i + 1) + " element on the list is: " + list[i]);
        }
    }

    public int[] getList() {
        return list;
    }
}
