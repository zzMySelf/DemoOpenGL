package com.google.zxing.common;

public final class BitSource {
    public int bitOffset;
    public int byteOffset;
    public final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i2) {
        if (i2 <= 0 || i2 > 32 || i2 > available()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i3 = this.bitOffset;
        byte b = 0;
        if (i3 > 0) {
            int i4 = 8 - i3;
            int i5 = i2 < i4 ? i2 : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.bytes;
            int i7 = this.byteOffset;
            int i8 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            i2 -= i5;
            int i9 = this.bitOffset + i5;
            this.bitOffset = i9;
            if (i9 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + 1;
            }
            b = i8;
        }
        if (i2 <= 0) {
            return b;
        }
        while (i2 >= 8) {
            int i10 = b << 8;
            byte[] bArr2 = this.bytes;
            int i11 = this.byteOffset;
            b = (bArr2[i11] & 255) | i10;
            this.byteOffset = i11 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return b;
        }
        int i12 = 8 - i2;
        int i13 = (b << i2) | ((((255 >> i12) << i12) & this.bytes[this.byteOffset]) >> i12);
        this.bitOffset += i2;
        return i13;
    }
}
