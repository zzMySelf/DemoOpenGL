package com.baidu.searchbox.player.pool;

import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.utils.BdVideoLog;

public class FIFOPool<T extends IPoolItem> implements IPool<T> {
    private static final int DEFAULT_SIZE = 2;
    private static final int INVALID_INDEX = -1;
    private static final String TAG = "FIFOPool";
    private int mActive = 0;
    private final int mMaxSize;
    private final Object[] mPool;
    private int mPoolSize;

    public FIFOPool(int maxPoolSize) {
        maxPoolSize = maxPoolSize <= 0 ? 2 : maxPoolSize;
        this.mMaxSize = maxPoolSize;
        this.mPool = new Object[maxPoolSize];
    }

    public T acquire() {
        if (this.mPoolSize <= 0) {
            return null;
        }
        if (this.mActive >= this.mMaxSize) {
            BdVideoLog.w("acquire(), active player is overSize : " + this.mMaxSize);
        }
        int i2 = this.mPoolSize;
        int lastPooledIndex = i2 - 1;
        T[] tArr = this.mPool;
        T instance = (IPoolItem) tArr[lastPooledIndex];
        tArr[lastPooledIndex] = null;
        this.mPoolSize = i2 - 1;
        this.mActive++;
        instance.onInit();
        return instance;
    }

    public T acquire(String type) {
        if (this.mPoolSize <= 0) {
            return null;
        }
        if (this.mActive >= this.mMaxSize) {
            BdVideoLog.w("acquire(" + type + "), active player is overSize : " + this.mMaxSize);
        }
        int hitIndex = -1;
        for (int i2 = 0; i2 < this.mPoolSize; i2++) {
            if (((IPoolItem) this.mPool[i2]).verify(type)) {
                hitIndex = i2;
            }
        }
        if (hitIndex == -1) {
            return null;
        }
        this.mActive++;
        T[] tArr = this.mPool;
        T retInstance = (IPoolItem) tArr[hitIndex];
        tArr[hitIndex] = null;
        int j2 = hitIndex;
        while (true) {
            int i3 = this.mPoolSize;
            if (j2 < i3 - 1) {
                Object[] objArr = this.mPool;
                objArr[j2] = objArr[j2 + 1];
                j2++;
            } else {
                this.mPool[i3 - 1] = null;
                this.mPoolSize = i3 - 1;
                retInstance.onInit();
                return retInstance;
            }
        }
    }

    public void release(T instance) {
        if (!isInPool(instance)) {
            addElement(instance);
            this.mActive--;
            instance.onRelease();
        }
    }

    private boolean isInPool(T instance) {
        for (int i2 = 0; i2 < this.mPoolSize; i2++) {
            if (this.mPool[i2] == instance) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void add(T instance) {
        if (!isInPool(instance)) {
            addElement(instance);
            instance.onInit();
        }
    }

    private void addElement(T instance) {
        if (!isInPool(instance)) {
            int i2 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i2 < objArr.length) {
                objArr[i2] = instance;
                this.mPoolSize = i2 + 1;
                return;
            }
            int i3 = 0;
            while (true) {
                Object[] objArr2 = this.mPool;
                if (i3 < objArr2.length - 1) {
                    objArr2[i3] = objArr2[i3 + 1];
                    i3++;
                } else {
                    objArr2[this.mPoolSize - 1] = instance;
                    return;
                }
            }
        }
    }
}
