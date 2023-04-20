package com.example.demo.issuesAndImprovements;

public class ConcurrencyIssues {
    /**
     * threads have their own call stack, but can also access shared data
     * therefore,we have two basic problems here, visiblity and access problems
     *
     * visibility problem:
     * if thread A reads shared data which is later changed by thread B and thread A is unaware of this change
     *
     * access problem:
     * if several threads access and change the same shared data at the same time
     *
     * both these two problems can lead to:
     * liveness failure: the program does not react anymore due to problems in the concurrent access of data e.g. deadlocks
     * safety failure: the program creates incorrect data
     */
}
