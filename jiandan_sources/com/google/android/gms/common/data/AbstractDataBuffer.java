package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    public final DataHolder mDataHolder;

    @KeepForSdk
    public AbstractDataBuffer(DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    public final void close() {
        release();
    }

    public abstract T get(int i2);

    public int getCount() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    public Bundle getMetadata() {
        return this.mDataHolder.getMetadata();
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.mDataHolder;
        return dataHolder == null || dataHolder.isClosed();
    }

    public Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }

    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new SingleRefDataBufferIterator(this);
    }
}
