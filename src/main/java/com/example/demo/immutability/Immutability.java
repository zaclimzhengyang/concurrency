package com.example.demo.immutability;

public class Immutability {
    /**
     * the simplest way to avoid problems with concurrency is to share only immutable data between threads
     * immutable data is data which cannot be changed
     * to make a class immutable, ensure:
     *      fields are final
     *      private
     *      have no setter method
     *      be copied in the constructor if it is a mutable object to avoid changes of this data from outside
     *      never be directly returned or otherwise exposed to a caller
     *      not change or if a change happens, this change must noe be visible outside
     */
    private final String immutableVariable = new String();
}
