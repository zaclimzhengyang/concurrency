package com.example.demo.concurrency;

public class ConcurrencyBasics {
    /**
     * concurrency is the ability to run several programs or several parts of a
     * program in parallel
     * if a time-consuming task can be performed asynchoronously or in paralle,
     * this improves the throughput and the interactivity of the program
     *
     *
     * a process runs independently and isoalted of other processes
     * it cannot directly access shared data in other processes
     * the resources of the process e.g. memory and CPU time, are allocated to it via the operating system
     *
     * a thread is a lightweight process. it has its own call stack, but can
     * access shared data of other threads in the same process
     * every thread has its own memory cache
     * if a thread reads shared data, it stores this data in its own memory cache
     *
     * a java application runs by default in one process
     * within a java application, we work with several threads to achieve parallel processing or asynchronous behaviour
     */
}
