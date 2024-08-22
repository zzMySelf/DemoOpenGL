package fe.fe.nn.ppp;

import androidx.exifinterface.media.ExifInterface;

public class o {
    public static byte[] ad(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return fe(bArr, bArr2);
    }

    public static byte[] de(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return fe(bArr, bArr2);
    }

    public static byte[] fe(byte[] bArr, byte[] bArr2) {
        byte[] qw = qw(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i2 = 0;
        byte b = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 = (i2 + 1) & 255;
            b = ((qw[i2] & 255) + b) & 255;
            byte b2 = qw[i2];
            qw[i2] = qw[b];
            qw[b] = b2;
            bArr3[i3] = (byte) (qw[((qw[i2] & 255) + (qw[b] & 255)) & 255] ^ bArr[i3]);
            bArr3[i3] = (byte) (bArr3[i3] ^ ExifInterface.START_CODE);
        }
        return bArr3;
    }

    public static byte[] qw(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) i2;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            i4 = ((bArr[i3] & 255) + (bArr2[i5] & 255) + i4) & 255;
            byte b = bArr2[i5];
            bArr2[i5] = bArr2[i4];
            bArr2[i4] = b;
            i3 = (i3 + 1) % bArr.length;
        }
        return bArr2;
    }
}
