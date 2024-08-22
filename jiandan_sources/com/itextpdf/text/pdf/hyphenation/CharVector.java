package com.itextpdf.text.pdf.hyphenation;

import java.io.Serializable;

public class CharVector implements Cloneable, Serializable {
    public static final int DEFAULT_BLOCK_SIZE = 2048;
    public static final long serialVersionUID = -4875768298308363544L;
    public char[] array;
    public int blockSize;
    public int n;

    public CharVector() {
        this(2048);
    }

    public int alloc(int i2) {
        int i3 = this.n;
        char[] cArr = this.array;
        int length = cArr.length;
        if (i3 + i2 >= length) {
            char[] cArr2 = new char[(this.blockSize + length)];
            System.arraycopy(cArr, 0, cArr2, 0, length);
            this.array = cArr2;
        }
        this.n += i2;
        return i3;
    }

    public int capacity() {
        return this.array.length;
    }

    public void clear() {
        this.n = 0;
    }

    public Object clone() {
        CharVector charVector = new CharVector((char[]) this.array.clone(), this.blockSize);
        charVector.n = this.n;
        return charVector;
    }

    public char get(int i2) {
        return this.array[i2];
    }

    public char[] getArray() {
        return this.array;
    }

    public int length() {
        return this.n;
    }

    public void put(int i2, char c) {
        this.array[i2] = c;
    }

    public void trimToSize() {
        int i2 = this.n;
        char[] cArr = this.array;
        if (i2 < cArr.length) {
            char[] cArr2 = new char[i2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.array = cArr2;
        }
    }

    public CharVector(int i2) {
        if (i2 > 0) {
            this.blockSize = i2;
        } else {
            this.blockSize = 2048;
        }
        this.array = new char[this.blockSize];
        this.n = 0;
    }

    public CharVector(char[] cArr) {
        this.blockSize = 2048;
        this.array = cArr;
        this.n = cArr.length;
    }

    public CharVector(char[] cArr, int i2) {
        if (i2 > 0) {
            this.blockSize = i2;
        } else {
            this.blockSize = 2048;
        }
        this.array = cArr;
        this.n = cArr.length;
    }
}
