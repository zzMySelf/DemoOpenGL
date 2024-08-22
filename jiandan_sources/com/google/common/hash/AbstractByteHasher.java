package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@CanIgnoreReturnValue
public abstract class AbstractByteHasher extends AbstractHasher {
    public final ByteBuffer scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public abstract void update(byte b);

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public Hasher putByte(byte b) {
        update(b);
        return this;
    }

    public Hasher putChar(char c) {
        this.scratch.putChar(c);
        return update(2);
    }

    public Hasher putInt(int i2) {
        this.scratch.putInt(i2);
        return update(4);
    }

    public Hasher putLong(long j) {
        this.scratch.putLong(j);
        return update(8);
    }

    public Hasher putShort(short s) {
        this.scratch.putShort(s);
        return update(2);
    }

    public void update(byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            update(bArr[i4]);
        }
    }

    public void update(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            update(byteBuffer.get());
        }
    }

    public Hasher putBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        update(bArr);
        return this;
    }

    public Hasher putBytes(byte[] bArr, int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
        update(bArr, i2, i3);
        return this;
    }

    private Hasher update(int i2) {
        try {
            update(this.scratch.array(), 0, i2);
            return this;
        } finally {
            this.scratch.clear();
        }
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        update(byteBuffer);
        return this;
    }
}
