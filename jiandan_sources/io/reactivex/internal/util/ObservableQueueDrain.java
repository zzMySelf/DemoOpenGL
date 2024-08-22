package io.reactivex.internal.util;

import io.reactivex.Observer;

public interface ObservableQueueDrain<T, U> {
    Throwable ad();

    int de(int i2);

    boolean fe();

    void qw(Observer<? super U> observer, T t);

    boolean rg();
}
