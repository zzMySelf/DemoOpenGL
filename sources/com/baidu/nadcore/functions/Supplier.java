package com.baidu.nadcore.functions;

@FunctionalInterface
public interface Supplier<T> {
    T get() throws Throwable;
}
