package com.example.demo.nonBlocking;

import java.util.concurrent.atomic.AtomicInteger;

public class NonBlockingCounter {
    private AtomicInteger value = new AtomicInteger();

    public int getValue() {
        return value.get();
    }

    public int increment() {
        return value.incrementAndGet();
    }
}
