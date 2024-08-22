package fe.fe.fe.fe.qw;

import com.baidu.cesium.c.a.a;
import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;

public final class qw implements a {
    public static final int[] aaa = new int[256];
    public static final int[] ddd = new int[256];
    public static final int[] ggg = new int[256];

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f1864i = new byte[256];

    /* renamed from: if  reason: not valid java name */
    public static final int[] f41if = new int[256];
    public static final int[] mmm = new int[256];
    public static final int[] nn = new int[256];

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f1865o = new byte[256];

    /* renamed from: pf  reason: collision with root package name */
    public static final int[] f1866pf = new int[256];
    public static final int[] ppp = new int[256];
    public static final byte[] qqq = new byte[30];

    /* renamed from: switch  reason: not valid java name */
    public static final int[] f42switch = new int[256];

    /* renamed from: uk  reason: collision with root package name */
    public static int[] f1867uk;
    public static final int[] vvv = new int[256];
    public static final int[] when = new int[256];
    public static final int[] xxx = new int[256];

    /* renamed from: yj  reason: collision with root package name */
    public static int[] f1868yj;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f1869ad = false;

    /* renamed from: de  reason: collision with root package name */
    public boolean f1870de = false;

    /* renamed from: fe  reason: collision with root package name */
    public Object[] f1871fe = null;

    /* renamed from: rg  reason: collision with root package name */
    public int[] f1872rg = null;

    /* renamed from: th  reason: collision with root package name */
    public int f1873th = 0;

    static {
        Class<byte> cls = byte.class;
        int[] iArr = new int[256];
        f1868yj = iArr;
        f1867uk = new int[256];
        iArr[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int[] iArr2 = f1868yj;
            int i3 = i2 - 1;
            int i4 = iArr2[i3] ^ (iArr2[i3] << 1);
            if ((i4 & 256) != 0) {
                i4 ^= 283;
            }
            f1868yj[i2] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            f1867uk[f1868yj[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance(cls, new int[]{256, 8});
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = f1868yj[255 - f1867uk[i6]];
            for (int i8 = 0; i8 < 8; i8++) {
                bArr3[i6][i8] = (byte) ((i7 >>> (7 - i8)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance(cls, new int[]{256, 8});
        for (int i9 = 0; i9 < 256; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr4[i9][i10] = bArr2[i10];
                for (int i11 = 0; i11 < 8; i11++) {
                    byte[] bArr5 = bArr4[i9];
                    bArr5[i10] = (byte) (bArr5[i10] ^ (bArr[i10][i11] * bArr3[i9][i11]));
                }
            }
        }
        for (int i12 = 0; i12 < 256; i12++) {
            f1864i[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = f1864i;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            f1865o[f1864i[i12] & 255] = (byte) i12;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance(cls, new int[]{4, 8});
        for (int i14 = 0; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 4; i15++) {
                bArr8[i14][i15] = bArr7[i14][i15];
            }
            bArr8[i14][i14 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(cls, new int[]{4, 4});
        for (int i16 = 0; i16 < 4; i16++) {
            byte b = bArr8[i16][i16];
            if (b == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 != 4) {
                    for (int i18 = 0; i18 < 8; i18++) {
                        byte b2 = bArr8[i16][i18];
                        bArr8[i16][i18] = bArr8[i17][i18];
                        bArr8[i17][i18] = b2;
                    }
                    b = bArr8[i16][i16];
                } else {
                    throw new RuntimeException("G matrix is not invertible");
                }
            }
            for (int i19 = 0; i19 < 8; i19++) {
                if (bArr8[i16][i19] != 0) {
                    byte[] bArr10 = bArr8[i16];
                    int[] iArr3 = f1868yj;
                    int[] iArr4 = f1867uk;
                    bArr10[i19] = (byte) iArr3[((iArr4[bArr8[i16][i19] & 255] + 255) - iArr4[b & 255]) % 255];
                }
            }
            for (int i20 = 0; i20 < 4; i20++) {
                if (i16 != i20) {
                    for (int i21 = i16 + 1; i21 < 8; i21++) {
                        byte[] bArr11 = bArr8[i20];
                        bArr11[i21] = (byte) (bArr11[i21] ^ ad(bArr8[i16][i21], bArr8[i20][i16]));
                    }
                    bArr8[i20][i16] = 0;
                }
            }
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                bArr9[i22][i23] = bArr8[i22][i23 + 4];
            }
        }
        for (int i24 = 0; i24 < 256; i24++) {
            byte b3 = f1864i[i24];
            f1866pf[i24] = de(b3, bArr7[0]);
            f41if[i24] = de(b3, bArr7[1]);
            f42switch[i24] = de(b3, bArr7[2]);
            when[i24] = de(b3, bArr7[3]);
            byte b4 = f1865o[i24];
            ppp[i24] = de(b4, bArr9[0]);
            ggg[i24] = de(b4, bArr9[1]);
            vvv[i24] = de(b4, bArr9[2]);
            xxx[i24] = de(b4, bArr9[3]);
            ddd[i24] = de(i24, bArr9[0]);
            nn[i24] = de(i24, bArr9[1]);
            mmm[i24] = de(i24, bArr9[2]);
            aaa[i24] = de(i24, bArr9[3]);
        }
        int i25 = 1;
        qqq[0] = 1;
        for (int i26 = 1; i26 < 30; i26++) {
            i25 = ad(2, i25);
            qqq[i26] = (byte) i25;
        }
        f1867uk = null;
        f1868yj = null;
    }

    public static final int ad(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = f1868yj;
        int[] iArr2 = f1867uk;
        return iArr[(iArr2[i2 & 255] + iArr2[i3 & 255]) % 255];
    }

    public static final int de(int i2, byte[] bArr) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        int[] iArr = f1867uk;
        int i4 = iArr[i2 & 255];
        int i5 = bArr[0] != 0 ? f1868yj[(iArr[bArr[0] & 255] + i4) % 255] & 255 : 0;
        int i6 = bArr[1] != 0 ? f1868yj[(f1867uk[bArr[1] & 255] + i4) % 255] & 255 : 0;
        int i7 = bArr[2] != 0 ? f1868yj[(f1867uk[bArr[2] & 255] + i4) % 255] & 255 : 0;
        if (bArr[3] != 0) {
            i3 = f1868yj[(i4 + f1867uk[bArr[3] & 255]) % 255] & 255;
        }
        return (i5 << 24) | (i6 << 16) | (i7 << 8) | i3;
    }

    public static int i(int i2) {
        return (i2 >> 2) + 6;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object[] uk(byte[] r17) {
        /*
            r0 = r17
            java.lang.Class<int> r1 = int.class
            if (r0 == 0) goto L_0x018f
            int r2 = r0.length
            boolean r2 = yj(r2)
            if (r2 == 0) goto L_0x0172
            int r2 = r0.length
            int r2 = i(r2)
            int r3 = r2 + 1
            int r4 = r3 * 4
            r5 = 2
            int[] r6 = new int[r5]
            r7 = 1
            r8 = 4
            r6[r7] = r8
            r9 = 0
            r6[r9] = r3
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r1, r6)
            int[][] r6 = (int[][]) r6
            int[] r10 = new int[r5]
            r10[r7] = r8
            r10[r9] = r3
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r10)
            int[][] r1 = (int[][]) r1
            int r3 = r0.length
            int r3 = r3 / r8
            int[] r10 = new int[r3]
            r11 = 0
            r12 = 0
        L_0x0038:
            r13 = 8
            if (r11 >= r3) goto L_0x005f
            byte r14 = r0[r12]
            int r14 = r14 << 24
            int r15 = r12 + 1
            byte r15 = r0[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << 16
            r14 = r14 | r15
            int r15 = r12 + 2
            byte r15 = r0[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r15 << 8
            r13 = r13 | r14
            int r14 = r12 + 3
            byte r14 = r0[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r13 = r13 | r14
            r10[r11] = r13
            int r11 = r11 + 1
            int r12 = r12 + r8
            goto L_0x0038
        L_0x005f:
            r0 = 0
            r11 = 0
        L_0x0061:
            if (r0 >= r3) goto L_0x007c
            if (r11 >= r4) goto L_0x007c
            int r12 = r11 / 4
            r14 = r6[r12]
            int r15 = r11 % 4
            r16 = r10[r0]
            r14[r15] = r16
            int r12 = r2 - r12
            r12 = r1[r12]
            r14 = r10[r0]
            r12[r15] = r14
            int r0 = r0 + 1
            int r11 = r11 + 1
            goto L_0x0061
        L_0x007c:
            r0 = 0
        L_0x007d:
            if (r11 >= r4) goto L_0x0133
            int r12 = r3 + -1
            r12 = r10[r12]
            r14 = r10[r9]
            byte[] r15 = f1864i
            int r5 = r12 >>> 16
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = r15[r5]
            int r5 = r5 << 24
            int r8 = r12 >>> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = r15[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << 16
            r5 = r5 ^ r8
            r8 = r12 & 255(0xff, float:3.57E-43)
            byte r8 = r15[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r13
            r5 = r5 ^ r8
            int r8 = r12 >>> 24
            byte r8 = r15[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r5 = r5 ^ r8
            byte[] r8 = qqq
            int r12 = r0 + 1
            byte r0 = r8[r0]
            int r0 = r0 << 24
            r0 = r0 ^ r5
            r0 = r0 ^ r14
            r10[r9] = r0
            r0 = 1
            r5 = 0
            if (r3 == r13) goto L_0x00c6
        L_0x00b9:
            if (r0 >= r3) goto L_0x0111
            r8 = r10[r0]
            r14 = r10[r5]
            r8 = r8 ^ r14
            r10[r0] = r8
            int r0 = r0 + 1
            int r5 = r5 + r7
            goto L_0x00b9
        L_0x00c6:
            int r8 = r3 / 2
            if (r0 >= r8) goto L_0x00d5
            r8 = r10[r0]
            r14 = r10[r5]
            r8 = r8 ^ r14
            r10[r0] = r8
            int r0 = r0 + 1
            int r5 = r5 + r7
            goto L_0x00c6
        L_0x00d5:
            int r0 = r8 + -1
            r0 = r10[r0]
            r5 = r10[r8]
            byte[] r14 = f1864i
            r15 = r0 & 255(0xff, float:3.57E-43)
            byte r15 = r14[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r9 = r0 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = r14[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r13
            r9 = r9 ^ r15
            int r15 = r0 >>> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r14[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << 16
            r9 = r9 ^ r15
            int r0 = r0 >>> 24
            byte r0 = r14[r0]
            int r0 = r0 << 24
            r0 = r0 ^ r9
            r0 = r0 ^ r5
            r10[r8] = r0
            int r0 = r8 + 1
        L_0x0104:
            if (r0 >= r3) goto L_0x0111
            r5 = r10[r0]
            r9 = r10[r8]
            r5 = r5 ^ r9
            r10[r0] = r5
            int r0 = r0 + 1
            int r8 = r8 + r7
            goto L_0x0104
        L_0x0111:
            r0 = 0
        L_0x0112:
            if (r0 >= r3) goto L_0x012d
            if (r11 >= r4) goto L_0x012d
            int r5 = r11 / 4
            r8 = r6[r5]
            int r9 = r11 % 4
            r14 = r10[r0]
            r8[r9] = r14
            int r5 = r2 - r5
            r5 = r1[r5]
            r8 = r10[r0]
            r5[r9] = r8
            int r0 = r0 + 1
            int r11 = r11 + 1
            goto L_0x0112
        L_0x012d:
            r0 = r12
            r5 = 2
            r8 = 4
            r9 = 0
            goto L_0x007d
        L_0x0133:
            r0 = 1
        L_0x0134:
            if (r0 >= r2) goto L_0x0169
            r3 = 0
            r4 = 4
        L_0x0138:
            if (r3 >= r4) goto L_0x0166
            r5 = r1[r0]
            r5 = r5[r3]
            r8 = r1[r0]
            int[] r9 = ddd
            int r10 = r5 >>> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            r9 = r9[r10]
            int[] r10 = nn
            int r11 = r5 >>> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10[r11]
            r9 = r9 ^ r10
            int[] r10 = mmm
            int r11 = r5 >>> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10[r11]
            r9 = r9 ^ r10
            int[] r10 = aaa
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r10[r5]
            r5 = r5 ^ r9
            r8[r3] = r5
            int r3 = r3 + 1
            goto L_0x0138
        L_0x0166:
            int r0 = r0 + 1
            goto L_0x0134
        L_0x0169:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            r0[r2] = r6
            r0[r7] = r1
            return r0
        L_0x0172:
            java.security.InvalidKeyException r1 = new java.security.InvalidKeyException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid AES key length: "
            r2.append(r3)
            int r0 = r0.length
            r2.append(r0)
            java.lang.String r0 = " bytes"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x018f:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r1 = "Empty key"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.fe.fe.qw.qw.uk(byte[]):java.lang.Object[]");
    }

    public static final boolean yj(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = a.qw;
            if (i3 >= iArr.length) {
                return false;
            }
            if (i2 == iArr[i3]) {
                return true;
            }
            i3++;
        }
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fe(boolean r13) {
        /*
            r12 = this;
            java.lang.Object[] r0 = r12.f1871fe
            r0 = r0[r13]
            int[][] r0 = (int[][]) r0
            int r1 = r0.length
            int r2 = r1 * 4
            int[] r2 = new int[r2]
            r12.f1872rg = r2
            r2 = 0
            r3 = 0
        L_0x000f:
            r4 = 4
            if (r3 >= r1) goto L_0x0026
            r5 = 0
        L_0x0013:
            if (r5 >= r4) goto L_0x0023
            int[] r6 = r12.f1872rg
            int r7 = r3 * 4
            int r7 = r7 + r5
            r8 = r0[r3]
            r8 = r8[r5]
            r6[r7] = r8
            int r5 = r5 + 1
            goto L_0x0013
        L_0x0023:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0026:
            r0 = 1
            if (r13 == 0) goto L_0x0056
            int[] r13 = r12.f1872rg
            int r3 = r13.length
            int r3 = r3 - r4
            r3 = r13[r3]
            int r5 = r13.length
            r6 = 3
            int r5 = r5 - r6
            r5 = r13[r5]
            int r7 = r13.length
            r8 = 2
            int r7 = r7 - r8
            r7 = r13[r7]
            int r9 = r13.length
            int r9 = r9 - r0
            r9 = r13[r9]
            int r13 = r13.length
            int r13 = r13 - r0
        L_0x003f:
            if (r13 <= r6) goto L_0x004c
            int[] r10 = r12.f1872rg
            int r11 = r13 + -4
            r11 = r10[r11]
            r10[r13] = r11
            int r13 = r13 + -1
            goto L_0x003f
        L_0x004c:
            int[] r13 = r12.f1872rg
            r13[r2] = r3
            r13[r0] = r5
            r13[r8] = r7
            r13[r6] = r9
        L_0x0056:
            r13 = 13
            if (r1 < r13) goto L_0x005c
            r13 = 1
            goto L_0x005d
        L_0x005c:
            r13 = 0
        L_0x005d:
            r12.f1869ad = r13
            r13 = 15
            if (r1 != r13) goto L_0x0064
            r2 = 1
        L_0x0064:
            r12.f1870de = r2
            int r1 = r1 + -1
            int r1 = r1 * 4
            r12.f1873th = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.fe.fe.qw.qw.fe(boolean):void");
    }

    public void o(byte[] bArr, int i2, byte[] bArr2, int i3) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        int i4;
        int i5 = i2 + 1;
        int i6 = i5 + 1;
        byte b5 = ((bArr[i5] & 255) << Ascii.DLE) | (bArr[i2] << Ascii.CAN);
        int i7 = i6 + 1;
        byte b6 = b5 | ((bArr[i6] & 255) << 8);
        int i8 = i7 + 1;
        byte b7 = b6 | (bArr[i7] & 255);
        int[] iArr = this.f1872rg;
        byte b8 = b7 ^ iArr[4];
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        byte b9 = (bArr[i8] << Ascii.CAN) | ((bArr[i9] & 255) << Ascii.DLE);
        int i11 = i10 + 1;
        byte b10 = b9 | ((bArr[i10] & 255) << 8);
        int i12 = i11 + 1;
        byte b11 = (b10 | (bArr[i11] & 255)) ^ iArr[5];
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        byte b12 = ((bArr[i13] & 255) << Ascii.DLE) | (bArr[i12] << Ascii.CAN);
        int i15 = i14 + 1;
        byte b13 = b12 | ((bArr[i14] & 255) << 8);
        int i16 = i15 + 1;
        byte b14 = (b13 | (bArr[i15] & 255)) ^ iArr[6];
        int i17 = i16 + 1;
        int i18 = i17 + 1;
        byte b15 = (((((bArr[i17] & 255) << Ascii.DLE) | (bArr[i16] << Ascii.CAN)) | ((bArr[i18] & 255) << 8)) | (bArr[i18 + 1] & 255)) ^ iArr[7];
        if (this.f1869ad) {
            int[] iArr2 = ppp;
            int i19 = iArr2[b8 >>> Ascii.CAN];
            int[] iArr3 = ggg;
            int i20 = i19 ^ iArr3[(b15 >>> Ascii.DLE) & 255];
            int[] iArr4 = vvv;
            int i21 = i20 ^ iArr4[(b14 >>> 8) & 255];
            int[] iArr5 = xxx;
            int i22 = (i21 ^ iArr5[b11 & 255]) ^ iArr[8];
            int i23 = (((iArr3[(b8 >>> Ascii.DLE) & 255] ^ iArr2[b11 >>> Ascii.CAN]) ^ iArr4[(b15 >>> 8) & 255]) ^ iArr5[b14 & 255]) ^ iArr[9];
            int i24 = (((iArr3[(b11 >>> Ascii.DLE) & 255] ^ iArr2[b14 >>> Ascii.CAN]) ^ iArr4[(b8 >>> 8) & 255]) ^ iArr5[b15 & 255]) ^ iArr[10];
            int i25 = iArr2[b15 >>> Ascii.CAN];
            int i26 = iArr4[(b11 >>> 8) & 255];
            int i27 = (iArr5[b8 & 255] ^ (i26 ^ (iArr3[(b14 >>> Ascii.DLE) & 255] ^ i25))) ^ iArr[11];
            b3 = iArr[12] ^ (((iArr2[i22 >>> 24] ^ iArr3[(i27 >>> 16) & 255]) ^ iArr4[(i24 >>> 8) & 255]) ^ iArr5[i23 & 255]);
            b2 = (((iArr2[i23 >>> 24] ^ iArr3[(i22 >>> 16) & 255]) ^ iArr4[(i27 >>> 8) & 255]) ^ iArr5[i24 & 255]) ^ iArr[13];
            b = (((iArr2[i24 >>> 24] ^ iArr3[(i23 >>> 16) & 255]) ^ iArr4[(i22 >>> 8) & 255]) ^ iArr5[i27 & 255]) ^ iArr[14];
            byte b16 = (((iArr2[i27 >>> 24] ^ iArr3[(i24 >>> 16) & 255]) ^ iArr4[(i23 >>> 8) & 255]) ^ iArr5[i22 & 255]) ^ iArr[15];
            if (this.f1870de) {
                int i28 = (((iArr2[b3 >>> Ascii.CAN] ^ iArr3[(b16 >>> Ascii.DLE) & 255]) ^ iArr4[(b >>> 8) & 255]) ^ iArr5[b2 & 255]) ^ iArr[16];
                int i29 = iArr[17] ^ (((iArr2[b2 >>> Ascii.CAN] ^ iArr3[(b3 >>> Ascii.DLE) & 255]) ^ iArr4[(b16 >>> 8) & 255]) ^ iArr5[b & 255]);
                int i30 = (((iArr2[b >>> Ascii.CAN] ^ iArr3[(b2 >>> Ascii.DLE) & 255]) ^ iArr4[(b3 >>> 8) & 255]) ^ iArr5[b16 & 255]) ^ iArr[18];
                int i31 = (((iArr2[b16 >>> Ascii.CAN] ^ iArr3[(b >>> Ascii.DLE) & 255]) ^ iArr4[(b2 >>> 8) & 255]) ^ iArr5[b3 & 255]) ^ iArr[19];
                b3 = iArr[20] ^ (((iArr2[i28 >>> 24] ^ iArr3[(i31 >>> 16) & 255]) ^ iArr4[(i30 >>> 8) & 255]) ^ iArr5[i29 & 255]);
                b2 = (((iArr2[i29 >>> 24] ^ iArr3[(i28 >>> 16) & 255]) ^ iArr4[(i31 >>> 8) & 255]) ^ iArr5[i30 & 255]) ^ iArr[21];
                b = (((iArr2[i30 >>> 24] ^ iArr3[(i29 >>> 16) & 255]) ^ iArr4[(i28 >>> 8) & 255]) ^ iArr5[i31 & 255]) ^ iArr[22];
                b4 = (((iArr2[i31 >>> 24] ^ iArr3[(i30 >>> 16) & 255]) ^ iArr4[(i29 >>> 8) & 255]) ^ iArr5[i28 & 255]) ^ iArr[23];
                i4 = 24;
            } else {
                b4 = b16;
                i4 = 16;
            }
        } else {
            b4 = b15;
            b = b14;
            b2 = b11;
            b3 = b8;
            i4 = 8;
        }
        int[] iArr6 = ppp;
        int i32 = iArr6[b3 >>> Ascii.CAN];
        int[] iArr7 = ggg;
        int i33 = i32 ^ iArr7[(b4 >>> Ascii.DLE) & 255];
        int[] iArr8 = vvv;
        int i34 = i33 ^ iArr8[(b >>> 8) & 255];
        int[] iArr9 = xxx;
        int i35 = i34 ^ iArr9[b2 & 255];
        int[] iArr10 = this.f1872rg;
        int i36 = i4 + 1;
        int i37 = iArr10[i4] ^ i35;
        int i38 = i36 + 1;
        int i39 = (((iArr6[b2 >>> Ascii.CAN] ^ iArr7[(b3 >>> Ascii.DLE) & 255]) ^ iArr8[(b4 >>> 8) & 255]) ^ iArr9[b & 255]) ^ iArr10[i36];
        int i40 = i38 + 1;
        char c = (((iArr6[b >>> Ascii.CAN] ^ iArr7[(b2 >>> Ascii.DLE) & 255]) ^ iArr8[(b3 >>> 8) & 255]) ^ iArr9[b4 & 255]) ^ iArr10[i38];
        int i41 = ((iArr6[b4 >>> Ascii.CAN] ^ iArr7[(b >>> Ascii.DLE) & 255]) ^ iArr8[(b2 >>> 8) & 255]) ^ iArr9[b3 & 255];
        int i42 = i40 + 1;
        int i43 = i41 ^ iArr10[i40];
        int i44 = i42 + 1;
        int i45 = iArr10[i42] ^ (((iArr6[i37 >>> 24] ^ iArr7[(i43 >>> 16) & 255]) ^ iArr8[(c >>> 8) & 255]) ^ iArr9[i39 & 255]);
        int i46 = i44 + 1;
        int i47 = (((iArr6[i39 >>> 24] ^ iArr7[(i37 >>> 16) & 255]) ^ iArr8[(i43 >>> 8) & 255]) ^ iArr9[c & 255]) ^ iArr10[i44];
        int i48 = i46 + 1;
        int i49 = (((iArr6[c >>> 24] ^ iArr7[(i39 >>> 16) & 255]) ^ iArr8[(i37 >>> 8) & 255]) ^ iArr9[i43 & 255]) ^ iArr10[i46];
        int i50 = iArr9[i37 & 255] ^ ((iArr6[i43 >>> 24] ^ iArr7[(c >>> 16) & 255]) ^ iArr8[(i39 >>> 8) & 255]);
        int i51 = i48 + 1;
        int i52 = i50 ^ iArr10[i48];
        int i53 = i51 + 1;
        char c2 = iArr10[i51] ^ (((iArr6[i45 >>> 24] ^ iArr7[(i52 >>> 16) & 255]) ^ iArr8[(i49 >>> 8) & 255]) ^ iArr9[i47 & 255]);
        int i54 = i53 + 1;
        int i55 = (((iArr6[i47 >>> 24] ^ iArr7[(i45 >>> 16) & 255]) ^ iArr8[(i52 >>> 8) & 255]) ^ iArr9[i49 & 255]) ^ iArr10[i53];
        int i56 = i54 + 1;
        int i57 = (((iArr6[i49 >>> 24] ^ iArr7[(i47 >>> 16) & 255]) ^ iArr8[(i45 >>> 8) & 255]) ^ iArr9[i52 & 255]) ^ iArr10[i54];
        int i58 = ((iArr6[i52 >>> 24] ^ iArr7[(i49 >>> 16) & 255]) ^ iArr8[(i47 >>> 8) & 255]) ^ iArr9[i45 & 255];
        int i59 = i56 + 1;
        int i60 = i58 ^ iArr10[i56];
        int i61 = i59 + 1;
        int i62 = iArr10[i59] ^ (((iArr6[c2 >>> 24] ^ iArr7[(i60 >>> 16) & 255]) ^ iArr8[(i57 >>> 8) & 255]) ^ iArr9[i55 & 255]);
        int i63 = i61 + 1;
        int i64 = (((iArr6[i55 >>> 24] ^ iArr7[(c2 >>> 16) & 255]) ^ iArr8[(i60 >>> 8) & 255]) ^ iArr9[i57 & 255]) ^ iArr10[i61];
        int i65 = i63 + 1;
        int i66 = (((iArr6[i57 >>> 24] ^ iArr7[(i55 >>> 16) & 255]) ^ iArr8[(c2 >>> 8) & 255]) ^ iArr9[i60 & 255]) ^ iArr10[i63];
        int i67 = ((iArr6[i60 >>> 24] ^ iArr7[(i57 >>> 16) & 255]) ^ iArr8[(i55 >>> 8) & 255]) ^ iArr9[c2 & 255];
        int i68 = i65 + 1;
        int i69 = i67 ^ iArr10[i65];
        int i70 = i68 + 1;
        int i71 = iArr10[i68] ^ (((iArr6[i62 >>> 24] ^ iArr7[(i69 >>> 16) & 255]) ^ iArr8[(i66 >>> 8) & 255]) ^ iArr9[i64 & 255]);
        int i72 = i70 + 1;
        int i73 = (((iArr6[i64 >>> 24] ^ iArr7[(i62 >>> 16) & 255]) ^ iArr8[(i69 >>> 8) & 255]) ^ iArr9[i66 & 255]) ^ iArr10[i70];
        int i74 = i72 + 1;
        int i75 = (((iArr6[i66 >>> 24] ^ iArr7[(i64 >>> 16) & 255]) ^ iArr8[(i62 >>> 8) & 255]) ^ iArr9[i69 & 255]) ^ iArr10[i72];
        int i76 = ((iArr6[i69 >>> 24] ^ iArr7[(i66 >>> 16) & 255]) ^ iArr8[(i64 >>> 8) & 255]) ^ iArr9[i62 & 255];
        int i77 = i74 + 1;
        int i78 = i76 ^ iArr10[i74];
        int i79 = i77 + 1;
        int i80 = iArr10[i77] ^ (((iArr6[i71 >>> 24] ^ iArr7[(i78 >>> 16) & 255]) ^ iArr8[(i75 >>> 8) & 255]) ^ iArr9[i73 & 255]);
        int i81 = i79 + 1;
        int i82 = (((iArr6[i73 >>> 24] ^ iArr7[(i71 >>> 16) & 255]) ^ iArr8[(i78 >>> 8) & 255]) ^ iArr9[i75 & 255]) ^ iArr10[i79];
        int i83 = i81 + 1;
        int i84 = (((iArr6[i75 >>> 24] ^ iArr7[(i73 >>> 16) & 255]) ^ iArr8[(i71 >>> 8) & 255]) ^ iArr9[i78 & 255]) ^ iArr10[i81];
        int i85 = ((iArr6[i78 >>> 24] ^ iArr7[(i75 >>> 16) & 255]) ^ iArr8[(i73 >>> 8) & 255]) ^ iArr9[i71 & 255];
        int i86 = i83 + 1;
        int i87 = i85 ^ iArr10[i83];
        int i88 = i86 + 1;
        int i89 = iArr10[i86] ^ (((iArr6[i80 >>> 24] ^ iArr7[(i87 >>> 16) & 255]) ^ iArr8[(i84 >>> 8) & 255]) ^ iArr9[i82 & 255]);
        int i90 = i88 + 1;
        int i91 = (((iArr6[i82 >>> 24] ^ iArr7[(i80 >>> 16) & 255]) ^ iArr8[(i87 >>> 8) & 255]) ^ iArr9[i84 & 255]) ^ iArr10[i88];
        int i92 = i90 + 1;
        int i93 = (((iArr6[i84 >>> 24] ^ iArr7[(i82 >>> 16) & 255]) ^ iArr8[(i80 >>> 8) & 255]) ^ iArr9[i87 & 255]) ^ iArr10[i90];
        int i94 = ((iArr6[i87 >>> 24] ^ iArr7[(i84 >>> 16) & 255]) ^ iArr8[(i82 >>> 8) & 255]) ^ iArr9[i80 & 255];
        int i95 = i92 + 1;
        int i96 = i94 ^ iArr10[i92];
        int i97 = i95 + 1;
        int i98 = iArr10[i95] ^ (((iArr6[i89 >>> 24] ^ iArr7[(i96 >>> 16) & 255]) ^ iArr8[(i93 >>> 8) & 255]) ^ iArr9[i91 & 255]);
        int i99 = i97 + 1;
        int i100 = (((iArr6[i91 >>> 24] ^ iArr7[(i89 >>> 16) & 255]) ^ iArr8[(i96 >>> 8) & 255]) ^ iArr9[i93 & 255]) ^ iArr10[i97];
        int i101 = i99 + 1;
        int i102 = (((iArr6[i93 >>> 24] ^ iArr7[(i91 >>> 16) & 255]) ^ iArr8[(i89 >>> 8) & 255]) ^ iArr9[i96 & 255]) ^ iArr10[i99];
        int i103 = ((iArr6[i96 >>> 24] ^ iArr7[(i93 >>> 16) & 255]) ^ iArr8[(i91 >>> 8) & 255]) ^ iArr9[i89 & 255];
        int i104 = i101 + 1;
        int i105 = i103 ^ iArr10[i101];
        int i106 = i104 + 1;
        int i107 = iArr10[i104] ^ (((iArr6[i98 >>> 24] ^ iArr7[(i105 >>> 16) & 255]) ^ iArr8[(i102 >>> 8) & 255]) ^ iArr9[i100 & 255]);
        int i108 = i106 + 1;
        int i109 = (((iArr6[i100 >>> 24] ^ iArr7[(i98 >>> 16) & 255]) ^ iArr8[(i105 >>> 8) & 255]) ^ iArr9[i102 & 255]) ^ iArr10[i106];
        int i110 = (((iArr6[i102 >>> 24] ^ iArr7[(i100 >>> 16) & 255]) ^ iArr8[(i98 >>> 8) & 255]) ^ iArr9[i105 & 255]) ^ iArr10[i108];
        int i111 = (((iArr6[i105 >>> 24] ^ iArr7[(i102 >>> 16) & 255]) ^ iArr8[(i100 >>> 8) & 255]) ^ iArr9[i98 & 255]) ^ iArr10[i108 + 1];
        int i112 = iArr10[0];
        int i113 = i3 + 1;
        byte[] bArr3 = f1865o;
        bArr2[i3] = (byte) (bArr3[i107 >>> 24] ^ (i112 >>> 24));
        int i114 = i113 + 1;
        bArr2[i113] = (byte) (bArr3[(i111 >>> 16) & 255] ^ (i112 >>> 16));
        int i115 = i114 + 1;
        bArr2[i114] = (byte) (bArr3[(i110 >>> 8) & 255] ^ (i112 >>> 8));
        int i116 = i115 + 1;
        bArr2[i115] = (byte) (i112 ^ bArr3[i109 & 255]);
        int i117 = iArr10[1];
        int i118 = i116 + 1;
        bArr2[i116] = (byte) (bArr3[i109 >>> 24] ^ (i117 >>> 24));
        int i119 = i118 + 1;
        bArr2[i118] = (byte) (bArr3[(i107 >>> 16) & 255] ^ (i117 >>> 16));
        int i120 = i119 + 1;
        bArr2[i119] = (byte) (bArr3[(i111 >>> 8) & 255] ^ (i117 >>> 8));
        int i121 = i120 + 1;
        bArr2[i120] = (byte) (i117 ^ bArr3[i110 & 255]);
        int i122 = iArr10[2];
        int i123 = i121 + 1;
        bArr2[i121] = (byte) (bArr3[i110 >>> 24] ^ (i122 >>> 24));
        int i124 = i123 + 1;
        bArr2[i123] = (byte) (bArr3[(i109 >>> 16) & 255] ^ (i122 >>> 16));
        int i125 = i124 + 1;
        bArr2[i124] = (byte) (bArr3[(i107 >>> 8) & 255] ^ (i122 >>> 8));
        int i126 = i125 + 1;
        bArr2[i125] = (byte) (i122 ^ bArr3[i111 & 255]);
        int i127 = iArr10[3];
        int i128 = i126 + 1;
        bArr2[i126] = (byte) (bArr3[i111 >>> 24] ^ (i127 >>> 24));
        int i129 = i128 + 1;
        bArr2[i128] = (byte) (bArr3[(i110 >>> 16) & 255] ^ (i127 >>> 16));
        bArr2[i129] = (byte) (bArr3[(i109 >>> 8) & 255] ^ (i127 >>> 8));
        bArr2[i129 + 1] = (byte) (bArr3[i107 & 255] ^ i127);
    }

    public int qw() {
        return 16;
    }

    public void rg(boolean z, String str, byte[] bArr) {
        if (yj(bArr.length)) {
            this.f1871fe = uk(bArr);
            fe(z);
            return;
        }
        throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
    }

    public void th(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        byte b = ((bArr[i4] & 255) << Ascii.DLE) | (bArr[i2] << Ascii.CAN);
        int i6 = i5 + 1;
        byte b2 = b | ((bArr[i5] & 255) << 8);
        int i7 = i6 + 1;
        byte b3 = b2 | (bArr[i6] & 255);
        int[] iArr = this.f1872rg;
        byte b4 = b3 ^ iArr[0];
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        byte b5 = (bArr[i7] << Ascii.CAN) | ((bArr[i8] & 255) << Ascii.DLE);
        int i10 = i9 + 1;
        byte b6 = b5 | ((bArr[i9] & 255) << 8);
        int i11 = i10 + 1;
        byte b7 = (b6 | (bArr[i10] & 255)) ^ iArr[1];
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b8 = ((bArr[i12] & 255) << Ascii.DLE) | (bArr[i11] << Ascii.CAN);
        int i14 = i13 + 1;
        byte b9 = b8 | ((bArr[i13] & 255) << 8);
        int i15 = i14 + 1;
        byte b10 = (b9 | (bArr[i14] & 255)) ^ iArr[2];
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = iArr[3];
        byte b11 = i18 ^ (((((bArr[i16] & 255) << Ascii.DLE) | (bArr[i15] << Ascii.CAN)) | ((bArr[i17] & 255) << 8)) | (bArr[i17 + 1] & 255));
        int i19 = 4;
        while (i19 < this.f1873th) {
            int[] iArr2 = f1866pf;
            int i20 = iArr2[b4 >>> Ascii.CAN];
            int[] iArr3 = f41if;
            byte b12 = i20 ^ iArr3[(b7 >>> Ascii.DLE) & 255];
            int[] iArr4 = f42switch;
            byte b13 = b12 ^ iArr4[(b10 >>> 8) & 255];
            int[] iArr5 = when;
            byte b14 = b13 ^ iArr5[b11 & 255];
            int[] iArr6 = this.f1872rg;
            int i21 = i19 + 1;
            byte b15 = iArr6[i19] ^ b14;
            int i22 = i21 + 1;
            byte b16 = (((iArr2[b7 >>> Ascii.CAN] ^ iArr3[(b10 >>> Ascii.DLE) & 255]) ^ iArr4[(b11 >>> 8) & 255]) ^ iArr5[b4 & 255]) ^ iArr6[i21];
            byte b17 = ((iArr2[b10 >>> Ascii.CAN] ^ iArr3[(b11 >>> Ascii.DLE) & 255]) ^ iArr4[(b4 >>> 8) & 255]) ^ iArr5[b7 & 255];
            int i23 = i22 + 1;
            byte b18 = (((iArr3[(b4 >>> Ascii.DLE) & 255] ^ iArr2[b11 >>> Ascii.CAN]) ^ iArr4[(b7 >>> 8) & 255]) ^ iArr5[b10 & 255]) ^ iArr6[i23];
            b7 = b16;
            b10 = b17 ^ iArr6[i22];
            b11 = b18;
            b4 = b15;
            i19 = i23 + 1;
        }
        int[] iArr7 = this.f1872rg;
        int i24 = i19 + 1;
        int i25 = iArr7[i19];
        int i26 = i3 + 1;
        byte[] bArr3 = f1864i;
        bArr2[i3] = (byte) (bArr3[b4 >>> Ascii.CAN] ^ (i25 >>> 24));
        int i27 = i26 + 1;
        bArr2[i26] = (byte) (bArr3[(b7 >>> Ascii.DLE) & 255] ^ (i25 >>> 16));
        int i28 = i27 + 1;
        bArr2[i27] = (byte) (bArr3[(b10 >>> 8) & 255] ^ (i25 >>> 8));
        int i29 = i28 + 1;
        bArr2[i28] = (byte) (i25 ^ bArr3[b11 & 255]);
        int i30 = i24 + 1;
        int i31 = iArr7[i24];
        int i32 = i29 + 1;
        bArr2[i29] = (byte) (bArr3[b7 >>> Ascii.CAN] ^ (i31 >>> 24));
        int i33 = i32 + 1;
        bArr2[i32] = (byte) (bArr3[(b10 >>> Ascii.DLE) & 255] ^ (i31 >>> 16));
        int i34 = i33 + 1;
        bArr2[i33] = (byte) (bArr3[(b11 >>> 8) & 255] ^ (i31 >>> 8));
        int i35 = i34 + 1;
        bArr2[i34] = (byte) (i31 ^ bArr3[b4 & 255]);
        int i36 = i30 + 1;
        int i37 = iArr7[i30];
        int i38 = i35 + 1;
        bArr2[i35] = (byte) (bArr3[b10 >>> Ascii.CAN] ^ (i37 >>> 24));
        int i39 = i38 + 1;
        bArr2[i38] = (byte) (bArr3[(b11 >>> Ascii.DLE) & 255] ^ (i37 >>> 16));
        int i40 = i39 + 1;
        bArr2[i39] = (byte) (bArr3[(b4 >>> 8) & 255] ^ (i37 >>> 8));
        int i41 = i40 + 1;
        bArr2[i40] = (byte) (i37 ^ bArr3[b7 & 255]);
        int i42 = iArr7[i36];
        int i43 = i41 + 1;
        bArr2[i41] = (byte) (bArr3[b11 >>> Ascii.CAN] ^ (i42 >>> 24));
        int i44 = i43 + 1;
        bArr2[i43] = (byte) (bArr3[(b4 >>> Ascii.DLE) & 255] ^ (i42 >>> 16));
        bArr2[i44] = (byte) (bArr3[(b7 >>> 8) & 255] ^ (i42 >>> 8));
        bArr2[i44 + 1] = (byte) (bArr3[b10 & 255] ^ i42);
    }
}
