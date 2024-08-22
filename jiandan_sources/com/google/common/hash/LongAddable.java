package com.google.common.hash;

public interface LongAddable {
    void add(long j);

    void increment();

    long sum();
}
