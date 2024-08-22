package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
public abstract class AbstractHasher implements Hasher {
    public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    public final Hasher putBoolean(boolean z) {
        return putByte(z ? (byte) 1 : 0);
    }

    public Hasher putChar(char c) {
        putByte((byte) c);
        putByte((byte) (c >>> 8));
        return this;
    }

    public final Hasher putDouble(double d) {
        return putLong(Double.doubleToRawLongBits(d));
    }

    public final Hasher putFloat(float f) {
        return putInt(Float.floatToRawIntBits(f));
    }

    public Hasher putInt(int i2) {
        putByte((byte) i2);
        putByte((byte) (i2 >>> 8));
        putByte((byte) (i2 >>> 16));
        putByte((byte) (i2 >>> 24));
        return this;
    }

    public Hasher putLong(long j) {
        for (int i2 = 0; i2 < 64; i2 += 8) {
            putByte((byte) ((int) (j >>> i2)));
        }
        return this;
    }

    public Hasher putShort(short s) {
        putByte((byte) s);
        putByte((byte) (s >>> 8));
        return this;
    }

    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            putChar(charSequence.charAt(i2));
        }
        return this;
    }

    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    public Hasher putBytes(byte[] bArr, int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
        for (int i4 = 0; i4 < i3; i4++) {
            putByte(bArr[i2 + i4]);
        }
        return this;
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            putBytes(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                putByte(byteBuffer.get());
            }
        }
        return this;
    }
}
