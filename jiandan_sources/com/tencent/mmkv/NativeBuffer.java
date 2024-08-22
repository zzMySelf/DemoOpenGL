package com.tencent.mmkv;

public final class NativeBuffer {
    public long pointer;
    public int size;

    public NativeBuffer(long j, int i2) {
        this.pointer = j;
        this.size = i2;
    }
}
