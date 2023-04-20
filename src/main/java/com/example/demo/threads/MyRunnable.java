package com.example.demo.threads;

public class MyRunnable implements Runnable {
    /**
     * `Runnable` is an interface that defines the run() method
     * this method is called by the `Thread` object and contains the work which should be done
     * therefore, the `Runnable` is the task to perform
     * the `Thread` is the worker who is doing this task
     *
     * MyRunnable will count the sum of the number from 1 to the number given in the parameter
     * countUntil and then write the result to the console
     */

    private final int countUntil;

    MyRunnable(int countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i=1; i < countUntil; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
