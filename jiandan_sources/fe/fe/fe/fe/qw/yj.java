package fe.fe.fe.fe.qw;

import javax.crypto.ShortBufferException;

public final class yj implements uk {
    public int qw;

    public yj(int i2) {
        this.qw = i2;
    }

    public int a(int i2) {
        int i3 = this.qw;
        return i3 - (i2 % i3);
    }

    public void ad(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 + i3 <= bArr.length) {
                byte b = (byte) (i3 & 255);
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr[i4 + i2] = b;
                }
                return;
            }
            throw new ShortBufferException("Buffer too small to hold padding");
        }
    }

    public int qw(byte[] bArr, int i2, int i3) {
        int i4;
        if (bArr == null || i3 == 0) {
            return 0;
        }
        int i5 = i3 + i2;
        byte b = bArr[i5 - 1];
        byte b2 = b & 255;
        if (b2 < 1 || b2 > this.qw || (i4 = i5 - b2) < i2) {
            return -1;
        }
        for (int i6 = 0; i6 < b2; i6++) {
            if (bArr[i4 + i6] != b) {
                return -1;
            }
        }
        return i4;
    }
}
