package com.example.demo.forkJoin;

import java.util.Random;

public class RandomGeneratorProblem {
    private final int[] list = new int[100000];

    public void randomGeneratorMethod() {
        Random generator = new Random(200000);
        for (int i = 0; i < list.length; i++) {
            list[i] = generator.nextInt(50000);
            System.out.println(list[i]);
        }
    }

    public int[] getList() {
        return list;
    }
}
