package com.baidu.searchbox.flex.core;

public class Output<T> {
    private T mT;

    public void set(T t) {
        this.mT = t;
    }

    public T get() {
        return this.mT;
    }
}
