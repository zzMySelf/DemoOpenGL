package fe.fe.fe.qw;

import org.apache.commons.codec.digest4util.XXHash32;

public class uk {

    /* renamed from: ad  reason: collision with root package name */
    public final byte[] f1890ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f1891de;

    /* renamed from: fe  reason: collision with root package name */
    public int f1892fe;
    public final int[] qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f1893rg;

    public uk() {
        this(0);
    }

    public uk(int i2) {
        this.qw = new int[4];
        this.f1890ad = new byte[16];
        this.f1891de = i2;
        th();
    }

    public static long fe(byte[] bArr, int i2, int i3) {
        if (i3 <= 8) {
            long j = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                j |= (((long) bArr[i2 + i4]) & 255) << (i4 * 8);
            }
            return j;
        }
        throw new IllegalArgumentException("can't read more than eight bytes into a long value");
    }

    public static int qw(byte[] bArr, int i2) {
        return (int) (fe(bArr, i2, 4) & 4294967295L);
    }

    public void ad(byte[] bArr, int i2, int i3) {
        if (i3 > 0) {
            this.f1892fe += i3;
            int i4 = i2 + i3;
            int i5 = this.f1893rg;
            if (i5 + i3 < 16) {
                System.arraycopy(bArr, i2, this.f1890ad, i5, i3);
                this.f1893rg += i3;
                return;
            }
            if (i5 > 0) {
                int i6 = 16 - i5;
                System.arraycopy(bArr, i2, this.f1890ad, i5, i6);
                rg(this.f1890ad, 0);
                i2 += i6;
            }
            int i7 = i4 - 16;
            while (i2 <= i7) {
                rg(bArr, i2);
                i2 += 16;
            }
            if (i2 < i4) {
                int i8 = i4 - i2;
                this.f1893rg = i8;
                System.arraycopy(bArr, i2, this.f1890ad, 0, i8);
            }
        }
    }

    public long de() {
        int i2 = 0;
        int rotateLeft = (this.f1892fe > 16 ? Integer.rotateLeft(this.qw[0], 1) + Integer.rotateLeft(this.qw[1], 7) + Integer.rotateLeft(this.qw[2], 12) + Integer.rotateLeft(this.qw[3], 18) : this.qw[2] + XXHash32.PRIME5) + this.f1892fe;
        int i3 = this.f1893rg - 4;
        while (i2 <= i3) {
            rotateLeft = Integer.rotateLeft(rotateLeft + (qw(this.f1890ad, i2) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
            i2 += 4;
        }
        while (i2 < this.f1893rg) {
            rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f1890ad[i2] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
            i2++;
        }
        int i4 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
        int i5 = (i4 ^ (i4 >>> 13)) * XXHash32.PRIME3;
        return ((long) (i5 ^ (i5 >>> 16))) & 4294967295L;
    }

    public final void rg(byte[] bArr, int i2) {
        int[] iArr = this.qw;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int rotateLeft = Integer.rotateLeft(i3 + (qw(bArr, i2) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft2 = Integer.rotateLeft(i4 + (qw(bArr, i2 + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft3 = Integer.rotateLeft(i5 + (qw(bArr, i2 + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft4 = Integer.rotateLeft(i6 + (qw(bArr, i2 + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int[] iArr2 = this.qw;
        iArr2[0] = rotateLeft;
        iArr2[1] = rotateLeft2;
        iArr2[2] = rotateLeft3;
        iArr2[3] = rotateLeft4;
        this.f1893rg = 0;
    }

    public final void th() {
        int[] iArr = this.qw;
        int i2 = this.f1891de;
        iArr[0] = i2 + XXHash32.PRIME1 + XXHash32.PRIME2;
        iArr[1] = XXHash32.PRIME2 + i2;
        iArr[2] = i2;
        iArr[3] = i2 - XXHash32.PRIME1;
    }
}
