package fe.fe.pf.rg.ad;

public class qw {
    public static final byte[][] qw = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};

    /* renamed from: fe.fe.pf.rg.ad.qw$qw  reason: collision with other inner class name */
    public static class C0132qw {
        public byte[] qw;

        public C0132qw(byte[] bArr, int i2) {
            this.qw = bArr;
        }

        public byte[] qw() {
            return this.qw;
        }
    }

    public static C0132qw ad(byte[] bArr) {
        int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
        int i2 = length / 8;
        if (length % 8 > 0) {
            i2++;
        }
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        int i4 = 8;
        for (int i5 = 0; i5 < bArr.length - 1; i5 += 2) {
            byte b = (byte) (((bArr[i5] * 3) + bArr[i5 + 1]) & 255);
            for (int i6 = 2; i6 >= 0; i6--) {
                if (i4 <= 0) {
                    i3++;
                    i4 = 8;
                }
                if (i3 >= i2) {
                    break;
                }
                bArr2[i3] = (byte) ((bArr2[i3] << 1) | ((b >> i6) & 1));
                i4--;
            }
        }
        if (i4 > 0 && i3 < i2) {
            bArr2[i3] = (byte) (bArr2[i3] << i4);
        }
        return new C0132qw(bArr2, length);
    }

    public static byte[] de(byte[] bArr, int i2) {
        byte b;
        int i3;
        int i4 = i2 % 3;
        if (i4 == 1) {
            i3 = i2 + 2;
            b = 2;
        } else if (i4 == 2) {
            i3 = i2 + 1;
            b = 1;
        } else {
            i3 = i2;
            b = 0;
        }
        int i5 = (i3 / 3) * 2;
        if (b > 0) {
            i5++;
        }
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        for (byte b2 : bArr) {
            for (int i8 = 7; i8 >= 0; i8--) {
                bArr2[i6] = (byte) ((bArr2[i6] << 1) | ((b2 >> i8) & 1));
                if (i7 % 3 == 2) {
                    byte[][] bArr3 = qw;
                    bArr2[i6 + 1] = bArr3[bArr2[i6]][1];
                    bArr2[i6] = bArr3[bArr2[i6]][0];
                    i6 += 2;
                }
                i7++;
                if (i7 == i2) {
                    break;
                }
            }
            if (i7 == i2) {
                break;
            }
        }
        if (b > 0) {
            bArr2[i6] = (byte) (bArr2[i6] << b);
            byte[][] bArr4 = qw;
            bArr2[i6 + 1] = bArr4[bArr2[i6]][1];
            bArr2[i6] = bArr4[bArr2[i6]][0];
            bArr2[i6 + 2] = b;
        }
        return bArr2;
    }

    public static int qw(int i2) {
        int i3 = i2 % 3;
        char c = 1;
        if (i3 == 1) {
            i2 += 2;
            c = 2;
        } else if (i3 == 2) {
            i2++;
        } else {
            c = 0;
        }
        int i4 = (i2 / 3) * 2;
        return c > 0 ? i4 + 1 : i4;
    }
}
