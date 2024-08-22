package fe.when.ad.f.n2;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.codec.TIFFDirectory;
import com.itextpdf.text.pdf.codec.TIFFField;
import fe.when.ad.c.qw;
import fe.when.ad.f.e2;
import fe.when.ad.i;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

public class o {
    public static void ad(byte[] bArr, int i2, int i3, int i4, int i5) {
        if (i2 == 2) {
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = ((i6 * i3) + 1) * i5;
                for (int i8 = i5; i8 < i3 * i5; i8++) {
                    bArr[i7] = (byte) (bArr[i7] + bArr[i7 - i5]);
                    i7++;
                }
            }
        }
    }

    public static void de(byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr2.length) {
            try {
                int i4 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0 && b <= Byte.MAX_VALUE) {
                    int i5 = 0;
                    while (i5 < b + 1) {
                        bArr2[i2] = bArr[i4];
                        i5++;
                        i2++;
                        i4++;
                    }
                    i3 = i4;
                } else if (b > -1 || b < -127) {
                    i3 = i4 + 1;
                } else {
                    int i6 = i4 + 1;
                    byte b2 = bArr[i4];
                    int i7 = 0;
                    while (i7 < (-b) + 1) {
                        int i8 = i2 + 1;
                        bArr2[i2] = b2;
                        i7++;
                        i2 = i8;
                    }
                    i3 = i6;
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public static long[] fe(TIFFDirectory tIFFDirectory, int i2) {
        TIFFField field = tIFFDirectory.getField(i2);
        if (field == null) {
            return null;
        }
        if (field.getType() == 4) {
            return field.getAsLongs();
        }
        char[] asChars = field.getAsChars();
        long[] jArr = new long[asChars.length];
        for (int i3 = 0; i3 < asChars.length; i3++) {
            jArr[i3] = (long) asChars[i3];
        }
        return jArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01c3 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0306 A[SYNTHETIC, Splitter:B:148:0x0306] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0325 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009b A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ba A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0105 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010c A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0120 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0122 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128 A[Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0184 A[ADDED_TO_REGION, Catch:{ RuntimeException -> 0x0265, InvalidImageException -> 0x0223, Exception -> 0x0338 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.when.ad.i i(fe.when.ad.f.e2 r46, boolean r47, int r48, boolean r49) {
        /*
            r1 = r46
            r2 = r47
            r0 = r48
            r3 = 1
            r4 = 0
            if (r0 < r3) goto L_0x033f
            com.itextpdf.text.pdf.codec.TIFFDirectory r5 = new com.itextpdf.text.pdf.codec.TIFFDirectory     // Catch:{ Exception -> 0x0338 }
            int r0 = r0 - r3
            r5.<init>(r1, r0)     // Catch:{ Exception -> 0x0338 }
            r0 = 322(0x142, float:4.51E-43)
            boolean r0 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x0338 }
            if (r0 != 0) goto L_0x0329
            r0 = 259(0x103, float:3.63E-43)
            long r6 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x0338 }
            int r7 = (int) r6     // Catch:{ Exception -> 0x0338 }
            r6 = 32771(0x8003, float:4.5922E-41)
            r8 = 4
            r9 = 3
            r10 = 2
            if (r7 == r10) goto L_0x0032
            if (r7 == r9) goto L_0x0032
            if (r7 == r8) goto L_0x0032
            if (r7 == r6) goto L_0x0032
            fe.when.ad.i r0 = o(r5, r1)     // Catch:{ Exception -> 0x0338 }
            return r0
        L_0x0032:
            r0 = 274(0x112, float:3.84E-43)
            boolean r11 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x0338 }
            r12 = 8
            r13 = 5
            if (r11 == 0) goto L_0x0067
            long r14 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x0338 }
            int r0 = (int) r14     // Catch:{ Exception -> 0x0338 }
            if (r0 == r9) goto L_0x0060
            if (r0 != r8) goto L_0x0047
            goto L_0x0060
        L_0x0047:
            if (r0 == r13) goto L_0x0059
            if (r0 != r12) goto L_0x004c
            goto L_0x0059
        L_0x004c:
            r11 = 6
            if (r0 == r11) goto L_0x0052
            r11 = 7
            if (r0 != r11) goto L_0x0067
        L_0x0052:
            r0 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            r11 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x0068
        L_0x0059:
            r0 = 1070141403(0x3fc90fdb, float:1.5707964)
            r11 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x0068
        L_0x0060:
            r0 = 1078530011(0x40490fdb, float:3.1415927)
            r11 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x0068
        L_0x0067:
            r11 = 0
        L_0x0068:
            r0 = 257(0x101, float:3.6E-43)
            long r14 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x0338 }
            int r15 = (int) r14     // Catch:{ Exception -> 0x0338 }
            r14 = 256(0x100, float:3.59E-43)
            long r12 = r5.getFieldAsLong(r14)     // Catch:{ Exception -> 0x0338 }
            int r13 = (int) r12     // Catch:{ Exception -> 0x0338 }
            r12 = 296(0x128, float:4.15E-43)
            boolean r17 = r5.isTagPresent(r12)     // Catch:{ Exception -> 0x0338 }
            if (r17 == 0) goto L_0x0084
            long r0 = r5.getFieldAsLong(r12)     // Catch:{ Exception -> 0x0338 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0338 }
            goto L_0x0085
        L_0x0084:
            r1 = 2
        L_0x0085:
            r0 = 282(0x11a, float:3.95E-43)
            com.itextpdf.text.pdf.codec.TIFFField r0 = r5.getField(r0)     // Catch:{ Exception -> 0x0338 }
            int r0 = rg(r0, r1)     // Catch:{ Exception -> 0x0338 }
            r12 = 283(0x11b, float:3.97E-43)
            com.itextpdf.text.pdf.codec.TIFFField r12 = r5.getField(r12)     // Catch:{ Exception -> 0x0338 }
            int r12 = rg(r12, r1)     // Catch:{ Exception -> 0x0338 }
            if (r1 != r3) goto L_0x00a6
            if (r12 == 0) goto L_0x00a1
            float r0 = (float) r0     // Catch:{ Exception -> 0x0338 }
            float r1 = (float) r12     // Catch:{ Exception -> 0x0338 }
            float r0 = r0 / r1
            goto L_0x00a2
        L_0x00a1:
            r0 = 0
        L_0x00a2:
            r12 = r0
            r1 = 0
            r14 = 0
            goto L_0x00a9
        L_0x00a6:
            r1 = r0
            r14 = r12
            r12 = 0
        L_0x00a9:
            r0 = 278(0x116, float:3.9E-43)
            boolean r19 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x0338 }
            if (r19 == 0) goto L_0x00b7
            long r8 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x0338 }
            int r0 = (int) r8     // Catch:{ Exception -> 0x0338 }
            goto L_0x00b8
        L_0x00b7:
            r0 = r15
        L_0x00b8:
            if (r0 <= 0) goto L_0x00bf
            if (r0 <= r15) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r8 = r0
            goto L_0x00c0
        L_0x00bf:
            r8 = r15
        L_0x00c0:
            r0 = 273(0x111, float:3.83E-43)
            long[] r9 = fe(r5, r0)     // Catch:{ Exception -> 0x0338 }
            r0 = 279(0x117, float:3.91E-43)
            long[] r0 = fe(r5, r0)     // Catch:{ Exception -> 0x0338 }
            r22 = 0
            if (r0 == 0) goto L_0x00e7
            int r6 = r0.length     // Catch:{ Exception -> 0x0338 }
            if (r6 != r3) goto L_0x00fa
            r24 = r0[r4]     // Catch:{ Exception -> 0x0338 }
            int r6 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r6 == 0) goto L_0x00e7
            r24 = r0[r4]     // Catch:{ Exception -> 0x0338 }
            r26 = r9[r4]     // Catch:{ Exception -> 0x0338 }
            long r24 = r24 + r26
            long r26 = r46.ad()     // Catch:{ Exception -> 0x0338 }
            int r6 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            if (r6 <= 0) goto L_0x00fa
        L_0x00e7:
            if (r15 != r8) goto L_0x00fa
            long[] r0 = new long[r3]     // Catch:{ Exception -> 0x0338 }
            long r24 = r46.ad()     // Catch:{ Exception -> 0x0338 }
            r26 = r11
            r10 = r9[r4]     // Catch:{ Exception -> 0x0338 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x0338 }
            long r10 = (long) r11     // Catch:{ Exception -> 0x0338 }
            long r24 = r24 - r10
            r0[r4] = r24     // Catch:{ Exception -> 0x0338 }
            goto L_0x00fc
        L_0x00fa:
            r26 = r11
        L_0x00fc:
            r10 = r0
            r0 = 266(0x10a, float:3.73E-43)
            com.itextpdf.text.pdf.codec.TIFFField r0 = r5.getField(r0)     // Catch:{ Exception -> 0x0338 }
            if (r0 == 0) goto L_0x010c
            int r0 = r0.getAsInt(r4)     // Catch:{ Exception -> 0x0338 }
            r11 = r0
            r6 = 2
            goto L_0x010e
        L_0x010c:
            r6 = 2
            r11 = 1
        L_0x010e:
            r0 = 262(0x106, float:3.67E-43)
            boolean r24 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x0338 }
            r27 = 1
            if (r24 == 0) goto L_0x0122
            long r24 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x0338 }
            int r0 = (r24 > r27 ? 1 : (r24 == r27 ? 0 : -1))
            if (r0 != 0) goto L_0x0122
            r0 = 1
            goto L_0x0123
        L_0x0122:
            r0 = 0
        L_0x0123:
            r24 = 4
            r6 = 2
            if (r7 == r6) goto L_0x0179
            r6 = 3
            if (r7 == r6) goto L_0x0151
            r6 = 4
            if (r7 == r6) goto L_0x013b
            r6 = 32771(0x8003, float:4.5922E-41)
            if (r7 == r6) goto L_0x0179
            r27 = r22
            r29 = r27
            r6 = 0
        L_0x0138:
            r22 = r0
            goto L_0x0182
        L_0x013b:
            r6 = 293(0x125, float:4.1E-43)
            com.itextpdf.text.pdf.codec.TIFFField r6 = r5.getField(r6)     // Catch:{ Exception -> 0x0338 }
            if (r6 == 0) goto L_0x014a
            long r27 = r6.getAsLong(r4)     // Catch:{ Exception -> 0x0338 }
            r29 = r22
            goto L_0x014e
        L_0x014a:
            r27 = r22
            r29 = r27
        L_0x014e:
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0138
        L_0x0151:
            r0 = r0 | 12
            r6 = 292(0x124, float:4.09E-43)
            com.itextpdf.text.pdf.codec.TIFFField r6 = r5.getField(r6)     // Catch:{ Exception -> 0x0338 }
            if (r6 == 0) goto L_0x017b
            long r29 = r6.getAsLong(r4)     // Catch:{ Exception -> 0x0338 }
            long r27 = r29 & r27
            int r6 = (r27 > r22 ? 1 : (r27 == r22 ? 0 : -1))
            if (r6 == 0) goto L_0x016a
            r6 = 258(0x102, float:3.62E-43)
            r17 = 258(0x102, float:3.62E-43)
            goto L_0x016c
        L_0x016a:
            r17 = 257(0x101, float:3.6E-43)
        L_0x016c:
            long r27 = r29 & r24
            int r6 = (r27 > r22 ? 1 : (r27 == r22 ? 0 : -1))
            if (r6 == 0) goto L_0x0174
            r0 = r0 | 2
        L_0x0174:
            r6 = r17
            r27 = r22
            goto L_0x0138
        L_0x0179:
            r0 = r0 | 10
        L_0x017b:
            r27 = r22
            r29 = r27
            r6 = 257(0x101, float:3.6E-43)
            goto L_0x0138
        L_0x0182:
            if (r49 == 0) goto L_0x01b1
            if (r8 != r15) goto L_0x01b1
            r7 = r10[r4]     // Catch:{ Exception -> 0x0338 }
            int r0 = (int) r7     // Catch:{ Exception -> 0x0338 }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0338 }
            r7 = r9[r4]     // Catch:{ Exception -> 0x0338 }
            r2 = r46
            r2.when(r7)     // Catch:{ Exception -> 0x0338 }
            r2.readFully(r0)     // Catch:{ Exception -> 0x0338 }
            r18 = 0
            r16 = r13
            r17 = r15
            r19 = r6
            r20 = r22
            r21 = r0
            fe.when.ad.i r0 = fe.when.ad.i.G(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0338 }
            r0.B0(r3)     // Catch:{ Exception -> 0x0338 }
            r2 = r1
            r38 = r5
            r4 = r12
            r5 = r14
            r6 = r26
            goto L_0x02f5
        L_0x01b1:
            r4 = r46
            fe.when.ad.f.n2.ad r3 = new fe.when.ad.f.n2.ad     // Catch:{ Exception -> 0x0338 }
            r3.<init>(r13)     // Catch:{ Exception -> 0x0338 }
            r38 = r5
            r41 = r12
            r12 = r15
            r39 = r29
            r5 = 0
        L_0x01c0:
            int r0 = r9.length     // Catch:{ Exception -> 0x0338 }
            if (r5 >= r0) goto L_0x02d9
            r42 = r1
            r0 = r10[r5]     // Catch:{ Exception -> 0x0338 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0338 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0338 }
            r43 = r14
            r18 = r15
            r14 = r9[r5]     // Catch:{ Exception -> 0x0338 }
            r4.when(r14)     // Catch:{ Exception -> 0x0338 }
            r4.readFully(r1)     // Catch:{ Exception -> 0x0338 }
            int r14 = java.lang.Math.min(r8, r12)     // Catch:{ Exception -> 0x0338 }
            fe.when.ad.f.n2.yj r15 = new fe.when.ad.f.n2.yj     // Catch:{ Exception -> 0x0338 }
            r15.<init>(r11, r13, r14)     // Catch:{ Exception -> 0x0338 }
            r15.m1108switch(r2)     // Catch:{ Exception -> 0x0338 }
            int r0 = r13 + 7
            r16 = 8
            int r0 = r0 / 8
            int r0 = r0 * r14
            r44 = r11
            byte[] r11 = new byte[r0]     // Catch:{ Exception -> 0x0338 }
            r49 = r5
            r5 = 2
            if (r7 == r5) goto L_0x02aa
            r5 = 3
            if (r7 == r5) goto L_0x022c
            r5 = 4
            if (r7 == r5) goto L_0x0210
            r5 = 32771(0x8003, float:4.5922E-41)
            if (r7 == r5) goto L_0x01ff
            goto L_0x0256
        L_0x01ff:
            r29 = r7
            r4 = r41
            r2 = r42
            r5 = r43
            r7 = 0
            r45 = r26
            r26 = r6
            r6 = r45
            goto L_0x02b9
        L_0x0210:
            r5 = 32771(0x8003, float:4.5922E-41)
            r34 = 0
            r31 = r15
            r32 = r11
            r33 = r1
            r35 = r14
            r36 = r27
            r31.th(r32, r33, r34, r35, r36)     // Catch:{ InvalidImageException -> 0x0223 }
            goto L_0x0227
        L_0x0223:
            r0 = move-exception
            r1 = r0
            if (r2 == 0) goto L_0x022b
        L_0x0227:
            r3.rg(r11, r14)     // Catch:{ Exception -> 0x0338 }
            goto L_0x0256
        L_0x022b:
            throw r1     // Catch:{ Exception -> 0x0338 }
        L_0x022c:
            r5 = 32771(0x8003, float:4.5922E-41)
            r32 = 0
            r29 = r15
            r30 = r11
            r31 = r1
            r33 = r14
            r34 = r39
            r29.de(r30, r31, r32, r33, r34)     // Catch:{ RuntimeException -> 0x023f }
            goto L_0x0253
        L_0x023f:
            r0 = move-exception
            r21 = r0
            long r39 = r39 ^ r24
            r32 = 0
            r29 = r15
            r30 = r11
            r31 = r1
            r33 = r14
            r34 = r39
            r29.de(r30, r31, r32, r33, r34)     // Catch:{ RuntimeException -> 0x0265 }
        L_0x0253:
            r3.rg(r11, r14)     // Catch:{ Exception -> 0x0338 }
        L_0x0256:
            r29 = r7
            r4 = r41
            r2 = r42
            r5 = r43
            r45 = r26
            r26 = r6
            r6 = r45
            goto L_0x02bf
        L_0x0265:
            if (r2 == 0) goto L_0x02a9
            r1 = 1
            if (r8 == r1) goto L_0x02a8
            r1 = 0
            r2 = r10[r1]     // Catch:{ Exception -> 0x0338 }
            int r0 = (int) r2     // Catch:{ Exception -> 0x0338 }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0338 }
            r1 = r9[r1]     // Catch:{ Exception -> 0x0338 }
            r4.when(r1)     // Catch:{ Exception -> 0x0338 }
            r4.readFully(r0)     // Catch:{ Exception -> 0x0338 }
            r1 = 0
            r16 = r13
            r17 = r18
            r18 = r1
            r19 = r6
            r20 = r22
            r21 = r0
            fe.when.ad.i r0 = fe.when.ad.i.G(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0338 }
            r1 = 1
            r0.B0(r1)     // Catch:{ Exception -> 0x0338 }
            r2 = r42
            r1 = r43
            r0.y0(r2, r1)     // Catch:{ Exception -> 0x0338 }
            r1 = r41
            r0.K0(r1)     // Catch:{ Exception -> 0x0338 }
            r1 = 5
            r0.D0(r1)     // Catch:{ Exception -> 0x0338 }
            r1 = 0
            int r1 = (r26 > r1 ? 1 : (r26 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x02a7
            r1 = r26
            r0.A0(r1)     // Catch:{ Exception -> 0x0338 }
        L_0x02a7:
            return r0
        L_0x02a8:
            throw r21     // Catch:{ Exception -> 0x0338 }
        L_0x02a9:
            throw r21     // Catch:{ Exception -> 0x0338 }
        L_0x02aa:
            r4 = r41
            r2 = r42
            r5 = r43
            r45 = r26
            r26 = r6
            r6 = r45
            r29 = r7
            r7 = 0
        L_0x02b9:
            r15.ad(r11, r1, r7, r14)     // Catch:{ Exception -> 0x0338 }
            r3.rg(r11, r14)     // Catch:{ Exception -> 0x0338 }
        L_0x02bf:
            int r12 = r12 - r8
            int r0 = r49 + 1
            r1 = r2
            r41 = r4
            r14 = r5
            r15 = r18
            r7 = r29
            r11 = r44
            r4 = r46
            r2 = r47
            r5 = r0
            r45 = r26
            r26 = r6
            r6 = r45
            goto L_0x01c0
        L_0x02d9:
            r2 = r1
            r5 = r14
            r18 = r15
            r6 = r26
            r4 = r41
            byte[] r21 = r3.de()     // Catch:{ Exception -> 0x0338 }
            r0 = 0
            r19 = 256(0x100, float:3.59E-43)
            r1 = 1
            r20 = r22 & 1
            r16 = r13
            r17 = r18
            r18 = r0
            fe.when.ad.i r0 = fe.when.ad.i.G(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0338 }
        L_0x02f5:
            r0.y0(r2, r5)     // Catch:{ Exception -> 0x0338 }
            r0.K0(r4)     // Catch:{ Exception -> 0x0338 }
            r1 = 34675(0x8773, float:4.859E-41)
            r2 = r38
            boolean r3 = r2.isTagPresent(r1)     // Catch:{ Exception -> 0x0338 }
            if (r3 == 0) goto L_0x031c
            com.itextpdf.text.pdf.codec.TIFFField r1 = r2.getField(r1)     // Catch:{ RuntimeException -> 0x031c }
            byte[] r1 = r1.getAsBytes()     // Catch:{ RuntimeException -> 0x031c }
            fe.when.ad.f.mmm r1 = fe.when.ad.f.mmm.ad(r1)     // Catch:{ RuntimeException -> 0x031c }
            int r2 = r1.fe()     // Catch:{ RuntimeException -> 0x031c }
            r3 = 1
            if (r2 != r3) goto L_0x031c
            r0.L0(r1)     // Catch:{ RuntimeException -> 0x031c }
        L_0x031c:
            r1 = 5
            r0.D0(r1)     // Catch:{ Exception -> 0x0338 }
            r1 = 0
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0328
            r0.A0(r6)     // Catch:{ Exception -> 0x0338 }
        L_0x0328:
            return r0
        L_0x0329:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0338 }
            java.lang.String r1 = "tiles.are.not.supported"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0338 }
            java.lang.String r1 = fe.when.ad.c.qw.ad(r1, r2)     // Catch:{ Exception -> 0x0338 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0338 }
            throw r0     // Catch:{ Exception -> 0x0338 }
        L_0x0338:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x033f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "the.page.number.must.be.gt.eq.1"
            java.lang.String r1 = fe.when.ad.c.qw.ad(r2, r1)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.o.i(fe.when.ad.f.e2, boolean, int, boolean):fe.when.ad.i");
    }

    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r2v9, types: [fe.when.ad.i] */
    /* JADX WARNING: type inference failed for: r1v22, types: [fe.when.ad.when, fe.when.ad.i] */
    /* JADX WARNING: type inference failed for: r1v28, types: [fe.when.ad.when] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0190 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01c3 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01cb A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01d1 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01d5 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01e6 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01f1 A[ADDED_TO_REGION, Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0218 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0224 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x022d A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0281 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x041b A[SYNTHETIC, Splitter:B:226:0x041b] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0439 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x04d1 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x04d9 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x04e0 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b1 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c0 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c8 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d3 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d4 A[Catch:{ Exception -> 0x04f8 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.when.ad.i o(com.itextpdf.text.pdf.codec.TIFFDirectory r39, fe.when.ad.f.e2 r40) {
        /*
            r0 = r39
            r1 = r40
            r2 = 259(0x103, float:3.63E-43)
            long r2 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x04f8 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x04f8 }
            r2 = 32773(0x8005, float:4.5925E-41)
            r4 = 32946(0x80b2, float:4.6167E-41)
            r5 = 6
            r6 = 7
            r7 = 5
            r8 = 8
            r9 = 1
            if (r3 == r9) goto L_0x0032
            if (r3 == r2) goto L_0x0032
            if (r3 == r4) goto L_0x0032
            if (r3 == r7) goto L_0x0032
            if (r3 == r5) goto L_0x0032
            if (r3 == r6) goto L_0x0032
            if (r3 != r8) goto L_0x0026
            goto L_0x0032
        L_0x0026:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "the.compression.1.is.not.supported"
            java.lang.String r1 = fe.when.ad.c.qw.qw(r1, r3)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x0032:
            r10 = 262(0x106, float:3.67E-43)
            long r10 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f8 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x04f8 }
            r10 = 3
            r12 = 2
            if (r11 == 0) goto L_0x0056
            if (r11 == r9) goto L_0x0056
            if (r11 == r12) goto L_0x0056
            if (r11 == r10) goto L_0x0056
            if (r11 == r7) goto L_0x0056
            if (r3 == r5) goto L_0x0056
            if (r3 != r6) goto L_0x004a
            goto L_0x0056
        L_0x004a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "the.photometric.1.is.not.supported"
            java.lang.String r1 = fe.when.ad.c.qw.qw(r1, r11)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x0056:
            r13 = 274(0x112, float:3.84E-43)
            boolean r14 = r0.isTagPresent(r13)     // Catch:{ Exception -> 0x04f8 }
            r15 = 4
            r16 = 0
            if (r14 == 0) goto L_0x0080
            long r13 = r0.getFieldAsLong(r13)     // Catch:{ Exception -> 0x04f8 }
            int r14 = (int) r13     // Catch:{ Exception -> 0x04f8 }
            if (r14 == r10) goto L_0x007c
            if (r14 != r15) goto L_0x006b
            goto L_0x007c
        L_0x006b:
            if (r14 == r7) goto L_0x0078
            if (r14 != r8) goto L_0x0070
            goto L_0x0078
        L_0x0070:
            if (r14 == r5) goto L_0x0074
            if (r14 != r6) goto L_0x0080
        L_0x0074:
            r13 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x0081
        L_0x0078:
            r13 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x0081
        L_0x007c:
            r13 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x0081
        L_0x0080:
            r13 = 0
        L_0x0081:
            r14 = 284(0x11c, float:3.98E-43)
            boolean r17 = r0.isTagPresent(r14)     // Catch:{ Exception -> 0x04f8 }
            r2 = 0
            if (r17 == 0) goto L_0x00a3
            long r18 = r0.getFieldAsLong(r14)     // Catch:{ Exception -> 0x04f8 }
            r20 = 2
            int r14 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r14 == 0) goto L_0x0095
            goto L_0x00a3
        L_0x0095:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "planar.images.are.not.supported"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = fe.when.ad.c.qw.ad(r1, r2)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x00a3:
            r14 = 338(0x152, float:4.74E-43)
            boolean r14 = r0.isTagPresent(r14)     // Catch:{ Exception -> 0x04f8 }
            r6 = 277(0x115, float:3.88E-43)
            boolean r18 = r0.isTagPresent(r6)     // Catch:{ Exception -> 0x04f8 }
            if (r18 == 0) goto L_0x00b7
            long r5 = r0.getFieldAsLong(r6)     // Catch:{ Exception -> 0x04f8 }
            int r6 = (int) r5     // Catch:{ Exception -> 0x04f8 }
            goto L_0x00b8
        L_0x00b7:
            r6 = 1
        L_0x00b8:
            r5 = 258(0x102, float:3.62E-43)
            boolean r19 = r0.isTagPresent(r5)     // Catch:{ Exception -> 0x04f8 }
            if (r19 == 0) goto L_0x00c8
            r26 = r11
            long r10 = r0.getFieldAsLong(r5)     // Catch:{ Exception -> 0x04f8 }
            int r5 = (int) r10     // Catch:{ Exception -> 0x04f8 }
            goto L_0x00cb
        L_0x00c8:
            r26 = r11
            r5 = 1
        L_0x00cb:
            if (r5 == r9) goto L_0x00e0
            if (r5 == r12) goto L_0x00e0
            if (r5 == r15) goto L_0x00e0
            if (r5 != r8) goto L_0x00d4
            goto L_0x00e0
        L_0x00d4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "bits.per.sample.1.is.not.supported"
            java.lang.String r1 = fe.when.ad.c.qw.qw(r1, r5)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x00e0:
            r10 = 257(0x101, float:3.6E-43)
            long r10 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f8 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x04f8 }
            r10 = 256(0x100, float:3.59E-43)
            r27 = r5
            long r4 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f8 }
            int r5 = (int) r4     // Catch:{ Exception -> 0x04f8 }
            r4 = 296(0x128, float:4.15E-43)
            boolean r10 = r0.isTagPresent(r4)     // Catch:{ Exception -> 0x04f8 }
            if (r10 == 0) goto L_0x00fe
            long r7 = r0.getFieldAsLong(r4)     // Catch:{ Exception -> 0x04f8 }
            int r4 = (int) r7     // Catch:{ Exception -> 0x04f8 }
            goto L_0x00ff
        L_0x00fe:
            r4 = 2
        L_0x00ff:
            r7 = 282(0x11a, float:3.95E-43)
            com.itextpdf.text.pdf.codec.TIFFField r7 = r0.getField(r7)     // Catch:{ Exception -> 0x04f8 }
            int r7 = rg(r7, r4)     // Catch:{ Exception -> 0x04f8 }
            r8 = 283(0x11b, float:3.97E-43)
            com.itextpdf.text.pdf.codec.TIFFField r8 = r0.getField(r8)     // Catch:{ Exception -> 0x04f8 }
            int r4 = rg(r8, r4)     // Catch:{ Exception -> 0x04f8 }
            r8 = 266(0x10a, float:3.73E-43)
            com.itextpdf.text.pdf.codec.TIFFField r8 = r0.getField(r8)     // Catch:{ Exception -> 0x04f8 }
            if (r8 == 0) goto L_0x0120
            int r8 = r8.getAsInt(r2)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x0121
        L_0x0120:
            r8 = 1
        L_0x0121:
            if (r8 != r12) goto L_0x0125
            r8 = 1
            goto L_0x0126
        L_0x0125:
            r8 = 0
        L_0x0126:
            r10 = 278(0x116, float:3.9E-43)
            boolean r20 = r0.isTagPresent(r10)     // Catch:{ Exception -> 0x04f8 }
            if (r20 == 0) goto L_0x0136
            r28 = r13
            long r12 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f8 }
            int r10 = (int) r12     // Catch:{ Exception -> 0x04f8 }
            goto L_0x0139
        L_0x0136:
            r28 = r13
            r10 = r11
        L_0x0139:
            if (r10 <= 0) goto L_0x0140
            if (r10 <= r11) goto L_0x013e
            goto L_0x0140
        L_0x013e:
            r12 = r10
            goto L_0x0141
        L_0x0140:
            r12 = r11
        L_0x0141:
            r10 = 273(0x111, float:3.83E-43)
            long[] r13 = fe(r0, r10)     // Catch:{ Exception -> 0x04f8 }
            r10 = 279(0x117, float:3.91E-43)
            long[] r10 = fe(r0, r10)     // Catch:{ Exception -> 0x04f8 }
            if (r10 == 0) goto L_0x0168
            int r15 = r10.length     // Catch:{ Exception -> 0x04f8 }
            if (r15 != r9) goto L_0x017b
            r22 = r10[r2]     // Catch:{ Exception -> 0x04f8 }
            r24 = 0
            int r15 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r15 == 0) goto L_0x0168
            r22 = r10[r2]     // Catch:{ Exception -> 0x04f8 }
            r24 = r13[r2]     // Catch:{ Exception -> 0x04f8 }
            long r22 = r22 + r24
            long r24 = r40.ad()     // Catch:{ Exception -> 0x04f8 }
            int r15 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r15 <= 0) goto L_0x017b
        L_0x0168:
            if (r11 != r12) goto L_0x017b
            long[] r10 = new long[r9]     // Catch:{ Exception -> 0x04f8 }
            long r22 = r40.ad()     // Catch:{ Exception -> 0x04f8 }
            r15 = r10
            r9 = r13[r2]     // Catch:{ Exception -> 0x04f8 }
            int r10 = (int) r9     // Catch:{ Exception -> 0x04f8 }
            long r9 = (long) r10     // Catch:{ Exception -> 0x04f8 }
            long r22 = r22 - r9
            r15[r2] = r22     // Catch:{ Exception -> 0x04f8 }
            r9 = r15
            goto L_0x017c
        L_0x017b:
            r9 = r10
        L_0x017c:
            r10 = 5
            if (r3 == r10) goto L_0x0188
            r15 = 32946(0x80b2, float:4.6167E-41)
            if (r3 == r15) goto L_0x0188
            r10 = 8
            if (r3 != r10) goto L_0x01c3
        L_0x0188:
            r10 = 317(0x13d, float:4.44E-43)
            com.itextpdf.text.pdf.codec.TIFFField r10 = r0.getField(r10)     // Catch:{ Exception -> 0x04f8 }
            if (r10 == 0) goto L_0x01c3
            int r10 = r10.getAsInt(r2)     // Catch:{ Exception -> 0x04f8 }
            r15 = 1
            if (r10 == r15) goto L_0x01a9
            r15 = 2
            if (r10 != r15) goto L_0x019b
            goto L_0x01aa
        L_0x019b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "illegal.value.for.predictor.in.tiff.file"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = fe.when.ad.c.qw.ad(r1, r2)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x01a9:
            r15 = 2
        L_0x01aa:
            if (r10 != r15) goto L_0x01bf
            r15 = r27
            r2 = 8
            if (r15 != r2) goto L_0x01b3
            goto L_0x01c1
        L_0x01b3:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "1.bit.samples.are.not.supported.for.horizontal.differencing.predictor"
            java.lang.String r1 = fe.when.ad.c.qw.qw(r1, r15)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x01bf:
            r15 = r27
        L_0x01c1:
            r2 = r10
            goto L_0x01c6
        L_0x01c3:
            r15 = r27
            r2 = 1
        L_0x01c6:
            r29 = 0
            r10 = 5
            if (r3 != r10) goto L_0x01d1
            fe.when.ad.f.n2.i r10 = new fe.when.ad.f.n2.i     // Catch:{ Exception -> 0x04f8 }
            r10.<init>(r5, r2, r6)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x01d3
        L_0x01d1:
            r10 = r29
        L_0x01d3:
            if (r14 <= 0) goto L_0x01e6
            r22 = r10
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x04f8 }
            r10.<init>()     // Catch:{ Exception -> 0x04f8 }
            r30 = r4
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x04f8 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x04f8 }
            r31 = r10
            goto L_0x01ee
        L_0x01e6:
            r30 = r4
            r22 = r10
            r4 = r29
            r31 = r4
        L_0x01ee:
            r10 = 1
            if (r15 != r10) goto L_0x0207
            if (r6 != r10) goto L_0x0207
            r10 = r26
            r26 = r7
            r7 = 3
            if (r10 == r7) goto L_0x020b
            fe.when.ad.f.n2.ad r7 = new fe.when.ad.f.n2.ad     // Catch:{ Exception -> 0x04f8 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x04f8 }
            r32 = r11
            r33 = r29
            r34 = r33
            r11 = r7
            goto L_0x022a
        L_0x0207:
            r10 = r26
            r26 = r7
        L_0x020b:
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x04f8 }
            r7.<init>()     // Catch:{ Exception -> 0x04f8 }
            r32 = r11
            r11 = 6
            if (r3 == r11) goto L_0x0224
            r11 = 7
            if (r3 == r11) goto L_0x0224
            java.util.zip.DeflaterOutputStream r11 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x04f8 }
            r11.<init>(r7)     // Catch:{ Exception -> 0x04f8 }
            r34 = r7
            r33 = r11
            r11 = r29
            goto L_0x022a
        L_0x0224:
            r34 = r7
            r11 = r29
            r33 = r11
        L_0x022a:
            r7 = 6
            if (r3 != r7) goto L_0x0281
            r2 = 513(0x201, float:7.19E-43)
            boolean r7 = r0.isTagPresent(r2)     // Catch:{ Exception -> 0x04f8 }
            if (r7 == 0) goto L_0x0272
            long r7 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x04f8 }
            int r2 = (int) r7     // Catch:{ Exception -> 0x04f8 }
            long r7 = r40.ad()     // Catch:{ Exception -> 0x04f8 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x04f8 }
            int r8 = r8 - r2
            r7 = 514(0x202, float:7.2E-43)
            boolean r11 = r0.isTagPresent(r7)     // Catch:{ Exception -> 0x04f8 }
            if (r11 == 0) goto L_0x0252
            long r7 = r0.getFieldAsLong(r7)     // Catch:{ Exception -> 0x04f8 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x04f8 }
            r7 = 0
            r11 = r9[r7]     // Catch:{ Exception -> 0x04f8 }
            int r7 = (int) r11     // Catch:{ Exception -> 0x04f8 }
            int r8 = r8 + r7
        L_0x0252:
            long r11 = r40.ad()     // Catch:{ Exception -> 0x04f8 }
            int r7 = (int) r11     // Catch:{ Exception -> 0x04f8 }
            int r7 = r7 - r2
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ Exception -> 0x04f8 }
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x04f8 }
            long r8 = r40.qw()     // Catch:{ Exception -> 0x04f8 }
            int r9 = (int) r8     // Catch:{ Exception -> 0x04f8 }
            int r9 = r9 + r2
            long r8 = (long) r9     // Catch:{ Exception -> 0x04f8 }
            r1.when(r8)     // Catch:{ Exception -> 0x04f8 }
            r1.readFully(r7)     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.when r1 = new fe.when.ad.when     // Catch:{ Exception -> 0x04f8 }
            r1.<init>((byte[]) r7)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x02ed
        L_0x0272:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "missing.tag.s.for.ojpeg.compression"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = fe.when.ad.c.qw.ad(r1, r2)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x0281:
            r7 = 7
            if (r3 != r7) goto L_0x0301
            int r2 = r9.length     // Catch:{ Exception -> 0x04f8 }
            r7 = 1
            if (r2 > r7) goto L_0x02f4
            r2 = 0
            r7 = r9[r2]     // Catch:{ Exception -> 0x04f8 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x04f8 }
            byte[] r7 = new byte[r8]     // Catch:{ Exception -> 0x04f8 }
            r11 = r13[r2]     // Catch:{ Exception -> 0x04f8 }
            r1.when(r11)     // Catch:{ Exception -> 0x04f8 }
            r1.readFully(r7)     // Catch:{ Exception -> 0x04f8 }
            r1 = 347(0x15b, float:4.86E-43)
            com.itextpdf.text.pdf.codec.TIFFField r1 = r0.getField(r1)     // Catch:{ Exception -> 0x04f8 }
            if (r1 == 0) goto L_0x02df
            byte[] r1 = r1.getAsBytes()     // Catch:{ Exception -> 0x04f8 }
            int r2 = r1.length     // Catch:{ Exception -> 0x04f8 }
            r9 = 0
            byte r11 = r1[r9]     // Catch:{ Exception -> 0x04f8 }
            r9 = -1
            if (r11 != r9) goto L_0x02b4
            r9 = 1
            byte r11 = r1[r9]     // Catch:{ Exception -> 0x04f8 }
            r9 = -40
            if (r11 != r9) goto L_0x02b4
            int r2 = r2 + -2
            r9 = 2
            goto L_0x02b5
        L_0x02b4:
            r9 = 0
        L_0x02b5:
            int r11 = r1.length     // Catch:{ Exception -> 0x04f8 }
            r12 = 2
            int r11 = r11 - r12
            byte r11 = r1[r11]     // Catch:{ Exception -> 0x04f8 }
            r12 = -1
            if (r11 != r12) goto L_0x02c8
            int r11 = r1.length     // Catch:{ Exception -> 0x04f8 }
            r12 = 1
            int r11 = r11 - r12
            byte r11 = r1[r11]     // Catch:{ Exception -> 0x04f8 }
            r12 = -39
            if (r11 != r12) goto L_0x02c8
            int r2 = r2 + -2
        L_0x02c8:
            byte[] r11 = new byte[r2]     // Catch:{ Exception -> 0x04f8 }
            r12 = 0
            java.lang.System.arraycopy(r1, r9, r11, r12, r2)     // Catch:{ Exception -> 0x04f8 }
            int r1 = r8 + r2
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x04f8 }
            r9 = 2
            java.lang.System.arraycopy(r7, r12, r1, r12, r9)     // Catch:{ Exception -> 0x04f8 }
            java.lang.System.arraycopy(r11, r12, r1, r9, r2)     // Catch:{ Exception -> 0x04f8 }
            int r2 = r2 + r9
            int r8 = r8 - r9
            java.lang.System.arraycopy(r7, r9, r1, r2, r8)     // Catch:{ Exception -> 0x04f8 }
            r7 = r1
        L_0x02df:
            fe.when.ad.when r1 = new fe.when.ad.when     // Catch:{ Exception -> 0x04f8 }
            r1.<init>((byte[]) r7)     // Catch:{ Exception -> 0x04f8 }
            r2 = 2
            if (r10 != r2) goto L_0x02ec
            r7 = 0
            r1.w0(r7)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x02ed
        L_0x02ec:
            r7 = 0
        L_0x02ed:
            r2 = r1
            r35 = r4
            r0 = r5
            r1 = r10
            goto L_0x0403
        L_0x02f4:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = "compression.jpeg.is.only.supported.with.a.single.strip.this.image.has.1.strips"
            int r2 = r9.length     // Catch:{ Exception -> 0x04f8 }
            java.lang.String r1 = fe.when.ad.c.qw.qw(r1, r2)     // Catch:{ Exception -> 0x04f8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f8 }
            throw r0     // Catch:{ Exception -> 0x04f8 }
        L_0x0301:
            r7 = 0
            r20 = r10
            r10 = r32
        L_0x0306:
            int r0 = r13.length     // Catch:{ Exception -> 0x04f8 }
            if (r7 >= r0) goto L_0x03c2
            r35 = r4
            r0 = r5
            r4 = r9[r7]     // Catch:{ Exception -> 0x04f8 }
            int r5 = (int) r4     // Catch:{ Exception -> 0x04f8 }
            byte[] r4 = new byte[r5]     // Catch:{ Exception -> 0x04f8 }
            r5 = r8
            r36 = r9
            r8 = r13[r7]     // Catch:{ Exception -> 0x04f8 }
            r1.when(r8)     // Catch:{ Exception -> 0x04f8 }
            r1.readFully(r4)     // Catch:{ Exception -> 0x04f8 }
            int r8 = java.lang.Math.min(r12, r10)     // Catch:{ Exception -> 0x04f8 }
            r9 = 1
            if (r3 == r9) goto L_0x0334
            int r9 = r0 * r15
            int r9 = r9 * r6
            r17 = 7
            int r9 = r9 + 7
            r23 = 8
            int r9 = r9 / 8
            int r9 = r9 * r8
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x04f8 }
            goto L_0x0336
        L_0x0334:
            r9 = r29
        L_0x0336:
            if (r5 == 0) goto L_0x033b
            fe.when.ad.f.n2.yj.m1107if(r4)     // Catch:{ Exception -> 0x04f8 }
        L_0x033b:
            r1 = 1
            if (r3 == r1) goto L_0x037a
            r1 = 5
            if (r3 == r1) goto L_0x0369
            r37 = r5
            r38 = r13
            r1 = r20
            r5 = r22
            r13 = 8
            if (r3 == r13) goto L_0x035f
            r13 = 32773(0x8005, float:4.5925E-41)
            if (r3 == r13) goto L_0x0358
            r13 = 32946(0x80b2, float:4.6167E-41)
            if (r3 == r13) goto L_0x0362
            goto L_0x0377
        L_0x0358:
            r13 = 32946(0x80b2, float:4.6167E-41)
            de(r4, r9)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x0377
        L_0x035f:
            r13 = 32946(0x80b2, float:4.6167E-41)
        L_0x0362:
            pf(r4, r9)     // Catch:{ Exception -> 0x04f8 }
            ad(r9, r2, r0, r8, r6)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x0377
        L_0x0369:
            r37 = r5
            r38 = r13
            r1 = r20
            r5 = r22
            r13 = 32946(0x80b2, float:4.6167E-41)
            r5.fe(r4, r9, r8)     // Catch:{ Exception -> 0x04f8 }
        L_0x0377:
            r4 = r9
        L_0x0378:
            r9 = 1
            goto L_0x0386
        L_0x037a:
            r37 = r5
            r38 = r13
            r1 = r20
            r5 = r22
            r13 = 32946(0x80b2, float:4.6167E-41)
            goto L_0x0378
        L_0x0386:
            if (r15 != r9) goto L_0x0391
            if (r6 != r9) goto L_0x0391
            r9 = 3
            if (r1 == r9) goto L_0x0391
            r11.rg(r4, r8)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x03a4
        L_0x0391:
            if (r14 <= 0) goto L_0x03a7
            r19 = r33
            r20 = r35
            r21 = r4
            r22 = r6
            r23 = r15
            r24 = r0
            r25 = r8
            qw(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x04f8 }
        L_0x03a4:
            r8 = r33
            goto L_0x03ac
        L_0x03a7:
            r8 = r33
            r8.write(r4)     // Catch:{ Exception -> 0x04f8 }
        L_0x03ac:
            int r10 = r10 - r12
            int r7 = r7 + 1
            r20 = r1
            r22 = r5
            r33 = r8
            r4 = r35
            r9 = r36
            r8 = r37
            r13 = r38
            r1 = r40
            r5 = r0
            goto L_0x0306
        L_0x03c2:
            r35 = r4
            r0 = r5
            r1 = r20
            r8 = r33
            r2 = 1
            if (r15 != r2) goto L_0x03e9
            if (r6 != r2) goto L_0x03e9
            r4 = 3
            if (r1 == r4) goto L_0x03e9
            r21 = 0
            r22 = 256(0x100, float:3.59E-43)
            if (r1 != r2) goto L_0x03da
            r23 = 1
            goto L_0x03dc
        L_0x03da:
            r23 = 0
        L_0x03dc:
            byte[] r24 = r11.de()     // Catch:{ Exception -> 0x04f8 }
            r19 = r0
            r20 = r32
            fe.when.ad.i r2 = fe.when.ad.i.G(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x04f8 }
            goto L_0x0403
        L_0x03e9:
            r8.close()     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.if r2 = new fe.when.ad.if     // Catch:{ Exception -> 0x04f8 }
            int r22 = r6 - r14
            byte[] r24 = r34.toByteArray()     // Catch:{ Exception -> 0x04f8 }
            r19 = r2
            r20 = r0
            r21 = r32
            r23 = r15
            r19.<init>(r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x04f8 }
            r4 = 1
            r2.x0(r4)     // Catch:{ Exception -> 0x04f8 }
        L_0x0403:
            r4 = r26
            r5 = r30
            r2.y0(r4, r5)     // Catch:{ Exception -> 0x04f8 }
            r4 = 6
            if (r3 == r4) goto L_0x04cf
            r4 = 7
            if (r3 == r4) goto L_0x04cf
            r3 = 34675(0x8773, float:4.859E-41)
            r4 = r39
            boolean r5 = r4.isTagPresent(r3)     // Catch:{ Exception -> 0x04f8 }
            if (r5 == 0) goto L_0x0431
            com.itextpdf.text.pdf.codec.TIFFField r3 = r4.getField(r3)     // Catch:{ RuntimeException -> 0x0431 }
            byte[] r3 = r3.getAsBytes()     // Catch:{ RuntimeException -> 0x0431 }
            fe.when.ad.f.mmm r3 = fe.when.ad.f.mmm.ad(r3)     // Catch:{ RuntimeException -> 0x0431 }
            int r6 = r6 - r14
            int r5 = r3.fe()     // Catch:{ RuntimeException -> 0x0431 }
            if (r6 != r5) goto L_0x0431
            r2.L0(r3)     // Catch:{ RuntimeException -> 0x0431 }
        L_0x0431:
            r3 = 320(0x140, float:4.48E-43)
            boolean r3 = r4.isTagPresent(r3)     // Catch:{ Exception -> 0x04f8 }
            if (r3 == 0) goto L_0x04cb
            r3 = 320(0x140, float:4.48E-43)
            com.itextpdf.text.pdf.codec.TIFFField r3 = r4.getField(r3)     // Catch:{ Exception -> 0x04f8 }
            char[] r3 = r3.getAsChars()     // Catch:{ Exception -> 0x04f8 }
            int r4 = r3.length     // Catch:{ Exception -> 0x04f8 }
            byte[] r5 = new byte[r4]     // Catch:{ Exception -> 0x04f8 }
            int r6 = r3.length     // Catch:{ Exception -> 0x04f8 }
            r7 = 3
            int r6 = r6 / r7
            int r7 = r6 * 2
            r8 = 0
        L_0x044c:
            if (r8 >= r6) goto L_0x046f
            int r9 = r8 * 3
            char r10 = r3[r8]     // Catch:{ Exception -> 0x04f8 }
            r11 = 8
            int r10 = r10 >>> r11
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x04f8 }
            r5[r9] = r10     // Catch:{ Exception -> 0x04f8 }
            int r10 = r9 + 1
            int r12 = r8 + r6
            char r12 = r3[r12]     // Catch:{ Exception -> 0x04f8 }
            int r12 = r12 >>> r11
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x04f8 }
            r5[r10] = r12     // Catch:{ Exception -> 0x04f8 }
            int r9 = r9 + 2
            int r10 = r8 + r7
            char r10 = r3[r10]     // Catch:{ Exception -> 0x04f8 }
            int r10 = r10 >>> r11
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x04f8 }
            r5[r9] = r10     // Catch:{ Exception -> 0x04f8 }
            int r8 = r8 + 1
            goto L_0x044c
        L_0x046f:
            r8 = 0
        L_0x0470:
            if (r8 >= r4) goto L_0x047b
            byte r9 = r5[r8]     // Catch:{ Exception -> 0x04f8 }
            if (r9 == 0) goto L_0x0478
            r4 = 0
            goto L_0x047c
        L_0x0478:
            int r8 = r8 + 1
            goto L_0x0470
        L_0x047b:
            r4 = 1
        L_0x047c:
            if (r4 == 0) goto L_0x049d
            r4 = 0
        L_0x047f:
            if (r4 >= r6) goto L_0x049d
            int r8 = r4 * 3
            char r9 = r3[r4]     // Catch:{ Exception -> 0x04f8 }
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x04f8 }
            r5[r8] = r9     // Catch:{ Exception -> 0x04f8 }
            int r9 = r8 + 1
            int r10 = r4 + r6
            char r10 = r3[r10]     // Catch:{ Exception -> 0x04f8 }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x04f8 }
            r5[r9] = r10     // Catch:{ Exception -> 0x04f8 }
            int r8 = r8 + 2
            int r9 = r4 + r7
            char r9 = r3[r9]     // Catch:{ Exception -> 0x04f8 }
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x04f8 }
            r5[r8] = r9     // Catch:{ Exception -> 0x04f8 }
            int r4 = r4 + 1
            goto L_0x047f
        L_0x049d:
            fe.when.ad.f.k r3 = new fe.when.ad.f.k     // Catch:{ Exception -> 0x04f8 }
            r3.<init>()     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.g2     // Catch:{ Exception -> 0x04f8 }
            r3.qqq(r4)     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.f.s0 r4 = fe.when.ad.f.s0.w0     // Catch:{ Exception -> 0x04f8 }
            r3.qqq(r4)     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.f.v0 r4 = new fe.when.ad.f.v0     // Catch:{ Exception -> 0x04f8 }
            r7 = 1
            int r6 = r6 - r7
            r4.<init>((int) r6)     // Catch:{ Exception -> 0x04f8 }
            r3.qqq(r4)     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.f.w1 r4 = new fe.when.ad.f.w1     // Catch:{ Exception -> 0x04f8 }
            r4.<init>((byte[]) r5)     // Catch:{ Exception -> 0x04f8 }
            r3.qqq(r4)     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.f.x r4 = new fe.when.ad.f.x     // Catch:{ Exception -> 0x04f8 }
            r4.<init>()     // Catch:{ Exception -> 0x04f8 }
            fe.when.ad.f.s0 r5 = fe.when.ad.f.s0.T     // Catch:{ Exception -> 0x04f8 }
            r4.h(r5, r3)     // Catch:{ Exception -> 0x04f8 }
            r2.v0(r4)     // Catch:{ Exception -> 0x04f8 }
        L_0x04cb:
            r3 = 5
            r2.D0(r3)     // Catch:{ Exception -> 0x04f8 }
        L_0x04cf:
            if (r1 != 0) goto L_0x04d5
            r1 = 1
            r2.B0(r1)     // Catch:{ Exception -> 0x04f8 }
        L_0x04d5:
            int r1 = (r28 > r16 ? 1 : (r28 == r16 ? 0 : -1))
            if (r1 == 0) goto L_0x04de
            r13 = r28
            r2.A0(r13)     // Catch:{ Exception -> 0x04f8 }
        L_0x04de:
            if (r14 <= 0) goto L_0x04f7
            r35.close()     // Catch:{ Exception -> 0x04f8 }
            byte[] r1 = r31.toByteArray()     // Catch:{ Exception -> 0x04f8 }
            r3 = r32
            r4 = 1
            fe.when.ad.i r0 = fe.when.ad.i.E(r0, r3, r4, r15, r1)     // Catch:{ Exception -> 0x04f8 }
            r0.n0()     // Catch:{ Exception -> 0x04f8 }
            r0.x0(r4)     // Catch:{ Exception -> 0x04f8 }
            r2.z0(r0)     // Catch:{ Exception -> 0x04f8 }
        L_0x04f7:
            return r2
        L_0x04f8:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.n2.o.o(com.itextpdf.text.pdf.codec.TIFFDirectory, fe.when.ad.f.e2):fe.when.ad.i");
    }

    public static void pf(byte[] bArr, byte[] bArr2) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        try {
            inflater.inflate(bArr2);
        } catch (DataFormatException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static i qw(DeflaterOutputStream deflaterOutputStream, DeflaterOutputStream deflaterOutputStream2, byte[] bArr, int i2, int i3, int i4, int i5) throws IOException {
        if (i3 == 8) {
            int i6 = i4 * i5;
            byte[] bArr2 = new byte[i6];
            int i7 = i6 * i2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i7) {
                int i11 = 0;
                while (i11 < i2 - 1) {
                    bArr[i9] = bArr[i8 + i11];
                    i11++;
                    i9++;
                }
                i8 += i2;
                bArr2[i10] = bArr[i8 - 1];
                i10++;
            }
            deflaterOutputStream.write(bArr, 0, i9);
            deflaterOutputStream2.write(bArr2, 0, i10);
            return null;
        }
        throw new IllegalArgumentException(qw.ad("extra.samples.are.not.supported", new Object[0]));
    }

    public static int rg(TIFFField tIFFField, int i2) {
        double d;
        if (tIFFField == null) {
            return 0;
        }
        long[] asRational = tIFFField.getAsRational(0);
        float f = ((float) asRational[0]) / ((float) asRational[1]);
        if (i2 == 1 || i2 == 2) {
            d = (double) f;
        } else if (i2 != 3) {
            return 0;
        } else {
            d = ((double) f) * 2.54d;
        }
        return (int) (d + 0.5d);
    }

    public static i th(e2 e2Var, int i2) {
        return yj(e2Var, i2, false);
    }

    public static i uk(e2 e2Var, boolean z, int i2) {
        return i(e2Var, z, i2, false);
    }

    public static i yj(e2 e2Var, int i2, boolean z) {
        return i(e2Var, false, i2, z);
    }
}
