package com.dxmbumptech.glide.load.engine.bitmap_recycle;

public interface ArrayPool {
    void ad();

    <T> T de(int i2, Class<T> cls);

    <T> T fe(int i2, Class<T> cls);

    <T> void put(T t);

    void qw(int i2);
}
