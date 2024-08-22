package fe.fe.pf.rg.rg;

public class ad {

    /* renamed from: fe.fe.pf.rg.rg.ad$ad  reason: collision with other inner class name */
    public static class C0137ad extends qw {

        /* renamed from: th  reason: collision with root package name */
        public static final int[] f2869th = new int[256];

        /* renamed from: de  reason: collision with root package name */
        public int f2870de = 0;

        /* renamed from: fe  reason: collision with root package name */
        public int f2871fe = 0;

        /* renamed from: rg  reason: collision with root package name */
        public final int[] f2872rg = f2869th;

        static {
            int i2;
            int i3 = 0;
            while (true) {
                if (i3 >= 64) {
                    break;
                }
                f2869th[i3] = i3;
                i3++;
            }
            for (i2 = 64; i2 < 256; i2++) {
                f2869th[i2] = -1;
            }
        }

        public C0137ad(int i2, byte[] bArr) {
            this.qw = bArr;
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x00f1 A[EDGE_INSN: B:70:0x00f1->B:53:0x00f1 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean qw(byte[] r17, int r18, int r19, boolean r20) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.f2870de
                r2 = 0
                r3 = 6
                if (r1 != r3) goto L_0x0009
                return r2
            L_0x0009:
                int r4 = r19 + r18
                int r5 = r0.f2871fe
                byte[] r6 = r0.qw
                int[] r7 = r0.f2872rg
                r8 = r5
                r9 = 0
                r5 = r1
                r1 = r18
            L_0x0016:
                r10 = 3
                r11 = 4
                r12 = 2
                r13 = 1
                if (r1 >= r4) goto L_0x00f1
                if (r5 != 0) goto L_0x0063
            L_0x001e:
                int r14 = r1 + 4
                if (r14 > r4) goto L_0x005f
                byte r8 = r17[r1]
                r8 = r8 & 255(0xff, float:3.57E-43)
                r8 = r7[r8]
                int r8 = r8 << 18
                int r15 = r1 + 1
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << 12
                r8 = r8 | r15
                int r15 = r1 + 2
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << r3
                r8 = r8 | r15
                int r15 = r1 + 3
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                r8 = r8 | r15
                if (r8 < 0) goto L_0x005f
                int r1 = r9 + 2
                byte r15 = (byte) r8
                r6[r1] = r15
                int r1 = r9 + 1
                int r15 = r8 >> 8
                byte r15 = (byte) r15
                r6[r1] = r15
                int r1 = r8 >> 16
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 3
                r1 = r14
                goto L_0x001e
            L_0x005f:
                if (r1 < r4) goto L_0x0063
                goto L_0x00f1
            L_0x0063:
                int r14 = r1 + 1
                byte r1 = r17[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                r1 = r7[r1]
                r15 = 5
                r2 = -1
                if (r5 == 0) goto L_0x00e1
                if (r5 == r13) goto L_0x00d5
                r13 = -2
                if (r5 == r12) goto L_0x00c1
                if (r5 == r10) goto L_0x008e
                if (r5 == r11) goto L_0x0082
                if (r5 == r15) goto L_0x007c
                goto L_0x00ed
            L_0x007c:
                if (r1 == r2) goto L_0x00ed
                r0.f2870de = r3
            L_0x0080:
                r10 = 0
                return r10
            L_0x0082:
                r10 = 0
                if (r1 != r13) goto L_0x0089
                int r5 = r5 + 1
                goto L_0x00ed
            L_0x0089:
                if (r1 == r2) goto L_0x00ed
                r0.f2870de = r3
                return r10
            L_0x008e:
                if (r1 < 0) goto L_0x00a9
                int r2 = r8 << 6
                r1 = r1 | r2
                int r2 = r9 + 2
                byte r5 = (byte) r1
                r6[r2] = r5
                int r2 = r9 + 1
                int r5 = r1 >> 8
                byte r5 = (byte) r5
                r6[r2] = r5
                int r2 = r1 >> 16
                byte r2 = (byte) r2
                r6[r9] = r2
                int r9 = r9 + 3
                r8 = r1
                r5 = 0
                goto L_0x00ed
            L_0x00a9:
                if (r1 != r13) goto L_0x00bb
                int r1 = r9 + 1
                int r2 = r8 >> 2
                byte r2 = (byte) r2
                r6[r1] = r2
                int r1 = r8 >> 10
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 2
                r5 = 5
                goto L_0x00ed
            L_0x00bb:
                if (r1 == r2) goto L_0x00ed
                r0.f2870de = r3
            L_0x00bf:
                r1 = 0
                return r1
            L_0x00c1:
                if (r1 < 0) goto L_0x00c4
                goto L_0x00d8
            L_0x00c4:
                if (r1 != r13) goto L_0x00d0
                int r1 = r9 + 1
                int r2 = r8 >> 4
                byte r2 = (byte) r2
                r6[r9] = r2
                r9 = r1
                r5 = 4
                goto L_0x00ed
            L_0x00d0:
                if (r1 == r2) goto L_0x00ed
                r0.f2870de = r3
                goto L_0x0080
            L_0x00d5:
                r10 = 0
                if (r1 < 0) goto L_0x00dc
            L_0x00d8:
                int r2 = r8 << 6
                r1 = r1 | r2
                goto L_0x00e4
            L_0x00dc:
                if (r1 == r2) goto L_0x00ed
                r0.f2870de = r3
                return r10
            L_0x00e1:
                r10 = 0
                if (r1 < 0) goto L_0x00e8
            L_0x00e4:
                int r5 = r5 + 1
                r8 = r1
                goto L_0x00ed
            L_0x00e8:
                if (r1 == r2) goto L_0x00ed
                r0.f2870de = r3
                return r10
            L_0x00ed:
                r1 = r14
                r2 = 0
                goto L_0x0016
            L_0x00f1:
                if (r20 != 0) goto L_0x00fa
                r0.f2870de = r5
                r0.f2871fe = r8
                r0.f2881ad = r9
                return r13
            L_0x00fa:
                if (r5 == r13) goto L_0x0122
                if (r5 == r12) goto L_0x0115
                if (r5 == r10) goto L_0x0106
                if (r5 == r11) goto L_0x0103
                goto L_0x011d
            L_0x0103:
                r0.f2870de = r3
                goto L_0x00bf
            L_0x0106:
                int r1 = r9 + 1
                int r2 = r8 >> 10
                byte r2 = (byte) r2
                r6[r9] = r2
                int r9 = r1 + 1
                int r2 = r8 >> 2
                byte r2 = (byte) r2
                r6[r1] = r2
                goto L_0x011d
            L_0x0115:
                int r1 = r9 + 1
                int r2 = r8 >> 4
                byte r2 = (byte) r2
                r6[r9] = r2
                r9 = r1
            L_0x011d:
                r0.f2870de = r5
                r0.f2881ad = r9
                return r13
            L_0x0122:
                r0.f2870de = r3
                goto L_0x00bf
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.rg.rg.ad.C0137ad.qw(byte[], int, int, boolean):boolean");
        }
    }

    public static class de extends qw {

        /* renamed from: o  reason: collision with root package name */
        public static final byte[] f2873o = new byte[64];

        /* renamed from: de  reason: collision with root package name */
        public final byte[] f2874de;

        /* renamed from: fe  reason: collision with root package name */
        public int f2875fe;

        /* renamed from: i  reason: collision with root package name */
        public final byte[] f2876i;

        /* renamed from: rg  reason: collision with root package name */
        public int f2877rg;

        /* renamed from: th  reason: collision with root package name */
        public final boolean f2878th;

        /* renamed from: uk  reason: collision with root package name */
        public final boolean f2879uk;

        /* renamed from: yj  reason: collision with root package name */
        public final boolean f2880yj;

        static {
            for (int i2 = 0; i2 < 64; i2++) {
                f2873o[i2] = (byte) i2;
            }
        }

        public de(int i2, byte[] bArr) {
            this.qw = bArr;
            boolean z = true;
            this.f2878th = (i2 & 1) == 0;
            this.f2880yj = (i2 & 2) == 0;
            this.f2879uk = (i2 & 4) == 0 ? false : z;
            this.f2876i = f2873o;
            this.f2874de = new byte[2];
            this.f2875fe = 0;
            this.f2877rg = this.f2880yj ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01b5  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00e6 A[SYNTHETIC] */
        public boolean qw(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.f2876i
                byte[] r2 = r0.qw
                int r3 = r0.f2877rg
                int r4 = r20 + r19
                int r5 = r0.f2875fe
                r6 = -1
                r7 = 0
                r8 = 2
                r9 = 1
                if (r5 == r9) goto L_0x0031
                if (r5 == r8) goto L_0x0015
                goto L_0x0050
            L_0x0015:
                int r5 = r19 + 1
                if (r5 > r4) goto L_0x0050
                byte[] r10 = r0.f2874de
                byte r11 = r10[r7]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.f2875fe = r7
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.f2874de
                byte r5 = r5[r7]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.f2875fe = r7
                goto L_0x0053
            L_0x0050:
                r11 = r19
                r10 = -1
            L_0x0053:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r6) goto L_0x008f
                int r6 = r10 >> 18
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r7] = r6
                int r6 = r10 >> 12
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r10 >> 6
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r8] = r6
                r6 = r10 & 63
                byte r6 = r1[r6]
                r10 = 3
                r2[r10] = r6
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x008d
                boolean r3 = r0.f2879uk
                if (r3 == 0) goto L_0x0085
                r3 = 5
                r2[r12] = r13
                goto L_0x0086
            L_0x0085:
                r3 = 4
            L_0x0086:
                int r6 = r3 + 1
                r2[r3] = r14
            L_0x008a:
                r3 = 19
                goto L_0x0090
            L_0x008d:
                r6 = 4
                goto L_0x0090
            L_0x008f:
                r6 = 0
            L_0x0090:
                int r10 = r11 + 3
                if (r10 > r4) goto L_0x00e6
                byte r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                byte r5 = r18[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                byte r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r5 = r5 & 63
                byte r5 = r1[r5]
                r2[r11] = r5
                int r6 = r6 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e4
                boolean r3 = r0.f2879uk
                if (r3 == 0) goto L_0x00dd
                int r3 = r6 + 1
                r2[r6] = r13
                r6 = r3
            L_0x00dd:
                int r3 = r6 + 1
                r2[r6] = r14
                r6 = r3
                r11 = r10
                goto L_0x008a
            L_0x00e4:
                r11 = r10
                goto L_0x0090
            L_0x00e6:
                if (r21 == 0) goto L_0x01b5
                int r5 = r0.f2875fe
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0136
                if (r5 <= 0) goto L_0x00fa
                byte[] r4 = r0.f2874de
                byte r4 = r4[r7]
                r7 = 1
                goto L_0x00fc
            L_0x00fa:
                byte r4 = r18[r11]
            L_0x00fc:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r12
                int r5 = r0.f2875fe
                int r5 = r5 - r7
                r0.f2875fe = r5
                int r5 = r6 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r5] = r1
                boolean r1 = r0.f2878th
                if (r1 == 0) goto L_0x0122
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L_0x0122:
                boolean r1 = r0.f2880yj
                if (r1 == 0) goto L_0x01de
                boolean r1 = r0.f2879uk
                if (r1 == 0) goto L_0x012f
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x012f:
                int r1 = r6 + 1
                r2[r6] = r14
            L_0x0133:
                r6 = r1
                goto L_0x01de
            L_0x0136:
                int r10 = r11 - r5
                int r4 = r4 - r8
                if (r10 != r4) goto L_0x019c
                if (r5 <= r9) goto L_0x0143
                byte[] r4 = r0.f2874de
                byte r4 = r4[r7]
                r7 = 1
                goto L_0x0149
            L_0x0143:
                int r4 = r11 + 1
                byte r5 = r18[r11]
                r11 = r4
                r4 = r5
            L_0x0149:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r14
                int r5 = r0.f2875fe
                if (r5 <= 0) goto L_0x0158
                byte[] r5 = r0.f2874de
                int r10 = r7 + 1
                byte r5 = r5[r7]
                r7 = r10
                goto L_0x015a
            L_0x0158:
                byte r5 = r18[r11]
            L_0x015a:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r8
                r4 = r4 | r5
                int r5 = r0.f2875fe
                int r5 = r5 - r7
                r0.f2875fe = r5
                int r5 = r6 + 1
                int r7 = r4 >> 12
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r5] = r7
                int r5 = r6 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r6] = r1
                boolean r1 = r0.f2878th
                if (r1 == 0) goto L_0x0188
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L_0x0188:
                boolean r1 = r0.f2880yj
                if (r1 == 0) goto L_0x019a
                boolean r1 = r0.f2879uk
                if (r1 == 0) goto L_0x0195
                int r1 = r5 + 1
                r2[r5] = r13
                r5 = r1
            L_0x0195:
                int r1 = r5 + 1
                r2[r5] = r14
                r5 = r1
            L_0x019a:
                r6 = r5
                goto L_0x01de
            L_0x019c:
                boolean r1 = r0.f2880yj
                if (r1 == 0) goto L_0x01de
                if (r6 <= 0) goto L_0x01de
                r1 = 19
                if (r3 == r1) goto L_0x01de
                boolean r1 = r0.f2879uk
                if (r1 == 0) goto L_0x01af
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x01af:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L_0x0133
            L_0x01b5:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01c6
                byte[] r1 = r0.f2874de
                int r2 = r0.f2875fe
                int r4 = r2 + 1
                r0.f2875fe = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x01de
            L_0x01c6:
                int r4 = r4 - r8
                if (r11 != r4) goto L_0x01de
                byte[] r1 = r0.f2874de
                int r2 = r0.f2875fe
                int r4 = r2 + 1
                r0.f2875fe = r4
                byte r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.f2875fe = r2
                int r11 = r11 + r9
                byte r2 = r18[r11]
                r1[r4] = r2
            L_0x01de:
                r0.f2881ad = r6
                r0.f2877rg = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.rg.rg.ad.de.qw(byte[], int, int, boolean):boolean");
        }
    }

    public static abstract class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f2881ad;
        public byte[] qw;
    }

    public static byte[] ad(byte[] bArr, int i2, int i3) {
        C0137ad adVar = new C0137ad(19, new byte[((i3 * 3) / 4)]);
        if (adVar.qw(bArr, i2, i3, true)) {
            int i4 = adVar.f2881ad;
            byte[] bArr2 = adVar.qw;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] de(byte[] bArr) {
        return fe(bArr, 0, bArr.length);
    }

    public static byte[] fe(byte[] bArr, int i2, int i3) {
        de deVar = new de(19, (byte[]) null);
        int i4 = (i3 / 3) * 4;
        int i5 = 2;
        if (!deVar.f2878th) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i4 += 2;
            } else if (i6 == 2) {
                i4 += 3;
            }
        } else if (i3 % 3 > 0) {
            i4 += 4;
        }
        if (deVar.f2880yj && i3 > 0) {
            int i7 = ((i3 - 1) / 57) + 1;
            if (!deVar.f2879uk) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        deVar.qw = new byte[i4];
        deVar.qw(bArr, i2, i3, true);
        return deVar.qw;
    }

    public static byte[] qw(byte[] bArr) {
        return ad(bArr, 0, bArr.length);
    }

    public static int rg(int i2) {
        de deVar = new de(19, (byte[]) null);
        int i3 = (i2 / 3) * 4;
        int i4 = 2;
        if (!deVar.f2878th) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i3 += 2;
            } else if (i5 == 2) {
                i3 += 3;
            }
        } else if (i2 % 3 > 0) {
            i3 += 4;
        }
        if (!deVar.f2880yj || i2 <= 0) {
            return i3;
        }
        int i6 = ((i2 - 1) / 57) + 1;
        if (!deVar.f2879uk) {
            i4 = 1;
        }
        return i3 + (i6 * i4);
    }
}
