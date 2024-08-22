package com.baidu.cesium.c.a;

import javax.crypto.ShortBufferException;
import kotlin.UByte;

final class h implements i {

    /* renamed from: a  reason: collision with root package name */
    private int f11396a;

    h(int i2) {
        this.f11396a = i2;
    }

    public int a(int i2) {
        int i3 = this.f11396a;
        return i3 - (i2 % i3);
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 + i3 <= bArr.length) {
                byte b2 = (byte) (i3 & 255);
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr[i4 + i2] = b2;
                }
                return;
            }
            throw new ShortBufferException("Buffer too small to hold padding");
        }
    }

    public int b(byte[] bArr, int i2, int i3) {
        int i4;
        if (bArr == null || i3 == 0) {
            return 0;
        }
        int i5 = i3 + i2;
        byte b2 = bArr[i5 - 1];
        byte b3 = b2 & UByte.MAX_VALUE;
        if (b3 < 1 || b3 > this.f11396a || (i4 = i5 - b3) < i2) {
            return -1;
        }
        for (int i6 = 0; i6 < b3; i6++) {
            if (bArr[i4 + i6] != b2) {
                return -1;
            }
        }
        return i4;
    }
}
