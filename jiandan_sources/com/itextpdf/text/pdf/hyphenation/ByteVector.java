package com.itextpdf.text.pdf.hyphenation;

import java.io.Serializable;

public class ByteVector implements Serializable {
    public static final int DEFAULT_BLOCK_SIZE = 2048;
    public static final long serialVersionUID = -1096301185375029343L;
    public byte[] array;
    public int blockSize;
    public int n;

    public ByteVector() {
        this(2048);
    }

    public int alloc(int i2) {
        int i3 = this.n;
        byte[] bArr = this.array;
        int length = bArr.length;
        if (i3 + i2 >= length) {
            byte[] bArr2 = new byte[(this.blockSize + length)];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            this.array = bArr2;
        }
        this.n += i2;
        return i3;
    }

    public int capacity() {
        return this.array.length;
    }

    public byte get(int i2) {
        return this.array[i2];
    }

    public byte[] getArray() {
        return this.array;
    }

    public int length() {
        return this.n;
    }

    public void put(int i2, byte b) {
        this.array[i2] = b;
    }

    public void trimToSize() {
        int i2 = this.n;
        byte[] bArr = this.array;
        if (i2 < bArr.length) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.array = bArr2;
        }
    }

    public ByteVector(int i2) {
        if (i2 > 0) {
            this.blockSize = i2;
        } else {
            this.blockSize = 2048;
        }
        this.array = new byte[this.blockSize];
        this.n = 0;
    }

    public ByteVector(byte[] bArr) {
        this.blockSize = 2048;
        this.array = bArr;
        this.n = 0;
    }

    public ByteVector(byte[] bArr, int i2) {
        if (i2 > 0) {
            this.blockSize = i2;
        } else {
            this.blockSize = 2048;
        }
        this.array = bArr;
        this.n = 0;
    }
}
