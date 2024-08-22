package com.yy.mediaframework.model;

import com.yy.mediaframework.utils.YMFLog;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class YYPeripheralsVideoSampleAllocator {
    private static Object mLock = new Object();
    private static volatile YYPeripheralsVideoSampleAllocator s_instance = null;
    private ConcurrentLinkedQueue<DecodeVideoSample> mFreeDeque = new ConcurrentLinkedQueue<>();

    static {
        instance();
    }

    public static YYPeripheralsVideoSampleAllocator instance() {
        if (s_instance == null) {
            synchronized (mLock) {
                if (s_instance == null) {
                    s_instance = new YYPeripheralsVideoSampleAllocator();
                }
            }
        }
        return s_instance;
    }

    private YYPeripheralsVideoSampleAllocator() {
        init(30);
    }

    public DecodeVideoSample alloc() {
        DecodeVideoSample sample;
        try {
            sample = this.mFreeDeque.poll();
        } catch (NoSuchElementException e2) {
            YMFLog.info(this, "[Util    ]", "allocate sample buffer exception:" + e2.toString());
            sample = null;
        }
        if (sample == null) {
            sample = newMediaSample();
            YMFLog.info(this, "[Util    ]", "alloc new sample size:" + this.mFreeDeque.size());
        }
        sample.addRef();
        return sample;
    }

    public void free(DecodeVideoSample sample) {
        YMFLog.debug((Object) this, "[Util    ]", "free");
        resetSample(sample);
        this.mFreeDeque.add(sample);
        int size = this.mFreeDeque.size();
    }

    private void resetSample(DecodeVideoSample sample) {
        sample.reset();
    }

    private DecodeVideoSample newMediaSample() {
        DecodeVideoSample sample = new DecodeVideoSample();
        resetSample(sample);
        return sample;
    }

    private void init(int capacity) {
        for (int i2 = 0; i2 < capacity; i2++) {
            this.mFreeDeque.add(newMediaSample());
        }
    }
}
