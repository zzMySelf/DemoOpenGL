package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
public abstract class HashCode {
    public static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public static final class BytesHashCode extends HashCode implements Serializable {
        public static final long serialVersionUID = 0;
        public final byte[] bytes;

        public BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }

        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        public int asInt() {
            Preconditions.checkState(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
            byte[] bArr = this.bytes;
            return ((bArr[3] & 255) << Ascii.CAN) | ((bArr[1] & 255) << 8) | (bArr[0] & 255) | ((bArr[2] & 255) << Ascii.DLE);
        }

        public long asLong() {
            Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
            return padToLong();
        }

        public int bits() {
            return this.bytes.length * 8;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            if (this.bytes.length != hashCode.getBytesInternal().length) {
                return false;
            }
            int i2 = 0;
            boolean z = true;
            while (true) {
                byte[] bArr = this.bytes;
                if (i2 >= bArr.length) {
                    return z;
                }
                z &= bArr[i2] == hashCode.getBytesInternal()[i2];
                i2++;
            }
        }

        public byte[] getBytesInternal() {
            return this.bytes;
        }

        public long padToLong() {
            long j = (long) (this.bytes[0] & 255);
            for (int i2 = 1; i2 < Math.min(this.bytes.length, 8); i2++) {
                j |= (((long) this.bytes[i2]) & 255) << (i2 * 8);
            }
            return j;
        }

        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            System.arraycopy(this.bytes, 0, bArr, i2, i3);
        }
    }

    public static final class IntHashCode extends HashCode implements Serializable {
        public static final long serialVersionUID = 0;
        public final int hash;

        public IntHashCode(int i2) {
            this.hash = i2;
        }

        public byte[] asBytes() {
            int i2 = this.hash;
            return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
        }

        public int asInt() {
            return this.hash;
        }

        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        public int bits() {
            return 32;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asInt();
        }

        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) (this.hash >> (i4 * 8));
            }
        }
    }

    public static final class LongHashCode extends HashCode implements Serializable {
        public static final long serialVersionUID = 0;
        public final long hash;

        public LongHashCode(long j) {
            this.hash = j;
        }

        public byte[] asBytes() {
            long j = this.hash;
            return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
        }

        public int asInt() {
            return (int) this.hash;
        }

        public long asLong() {
            return this.hash;
        }

        public int bits() {
            return 64;
        }

        public boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asLong();
        }

        public long padToLong() {
            return this.hash;
        }

        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) ((int) (this.hash >> (i4 * 8)));
            }
        }
    }

    public static int decode(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c);
    }

    public static HashCode fromBytes(byte[] bArr) {
        boolean z = true;
        if (bArr.length < 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bArr.clone());
    }

    public static HashCode fromBytesNoCopy(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode fromInt(int i2) {
        return new IntHashCode(i2);
    }

    public static HashCode fromLong(long j) {
        return new LongHashCode(j);
    }

    public static HashCode fromString(String str) {
        boolean z = true;
        Preconditions.checkArgument(str.length() >= 2, "input string (%s) must have at least 2 characters", (Object) str);
        if (str.length() % 2 != 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "input string (%s) must have an even number of characters", (Object) str);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            bArr[i2 / 2] = (byte) ((decode(str.charAt(i2)) << 4) + decode(str.charAt(i2 + 1)));
        }
        return fromBytesNoCopy(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (bits() != hashCode.bits() || !equalsSameBits(hashCode)) {
            return false;
        }
        return true;
    }

    public abstract boolean equalsSameBits(HashCode hashCode);

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytesInternal = getBytesInternal();
        byte b = bytesInternal[0] & 255;
        for (int i2 = 1; i2 < bytesInternal.length; i2++) {
            b |= (bytesInternal[i2] & 255) << (i2 * 8);
        }
        return b;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] bytesInternal = getBytesInternal();
        StringBuilder sb = new StringBuilder(bytesInternal.length * 2);
        for (byte b : bytesInternal) {
            sb.append(hexDigits[(b >> 4) & 15]);
            sb.append(hexDigits[b & Ascii.SI]);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i2, int i3) {
        int min = Ints.min(i3, bits() / 8);
        Preconditions.checkPositionIndexes(i2, i2 + min, bArr.length);
        writeBytesToImpl(bArr, i2, min);
        return min;
    }

    public abstract void writeBytesToImpl(byte[] bArr, int i2, int i3);
}
