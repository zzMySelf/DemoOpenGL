package com.baidu.talos.core.common;

import androidx.core.util.Pools;

public class ClearableSynchronizedPool<T> implements Pools.Pool<T> {
    private final Object[] mPool;
    private int mSize = 0;

    public ClearableSynchronizedPool(int maxSize) {
        this.mPool = new Object[maxSize];
    }

    public synchronized T acquire() {
        int i2 = this.mSize;
        if (i2 == 0) {
            return null;
        }
        int lastIndex = i2 - 1;
        this.mSize = lastIndex;
        T[] tArr = this.mPool;
        T toReturn = tArr[lastIndex];
        tArr[lastIndex] = null;
        return toReturn;
    }

    public synchronized boolean release(T obj) {
        int i2 = this.mSize;
        Object[] objArr = this.mPool;
        if (i2 == objArr.length) {
            return false;
        }
        objArr[i2] = obj;
        this.mSize = i2 + 1;
        return true;
    }

    public synchronized void clear() {
        for (int i2 = 0; i2 < this.mSize; i2++) {
            this.mPool[i2] = null;
        }
        this.mSize = 0;
    }
}
