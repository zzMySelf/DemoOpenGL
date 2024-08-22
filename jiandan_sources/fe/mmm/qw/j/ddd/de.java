package fe.mmm.qw.j.ddd;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import fe.mmm.qw.h.de.qw;

public class de {
    public static int ad(int i2) {
        if (i2 == 6) {
            return 90;
        }
        if (i2 == 3) {
            return 180;
        }
        return i2 == 8 ? 270 : 0;
    }

    public static String de(Context context) {
        return new qw().yj(context);
    }

    public static String fe(String str, String str2) {
        return new qw().th(str2, 0);
    }

    public static int qw(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0061, code lost:
        if (r3 <= 8) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        r2 = yj(r10, r1, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        if (r2 == 1229531648) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006f, code lost:
        if (r2 == 1296891946) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0071, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        if (r2 != 1229531648) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0075, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0076, code lost:
        r2 = yj(r10, r1 + 4, 4, r5) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007f, code lost:
        if (r2 < 10) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0081, code lost:
        if (r2 <= r3) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0084, code lost:
        r1 = r1 + r2;
        r3 = r3 - r2;
        r2 = yj(r10, r1 - 2, 2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
        r4 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008e, code lost:
        if (r2 <= 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0092, code lost:
        if (r3 < 12) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009a, code lost:
        if (yj(r10, r1, 2, r5) != 274) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009c, code lost:
        r10 = yj(r10, r1 + 8, 2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a2, code lost:
        if (r10 == 3) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a5, code lost:
        if (r10 == 6) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a7, code lost:
        if (r10 == 8) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a9, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00aa, code lost:
        return 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ad, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b0, code lost:
        return 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b3, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b9, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int rg(byte[] r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
        L_0x0005:
            int r2 = r1 + 3
            int r3 = r10.length
            r4 = 4
            r5 = 1
            r6 = 8
            r7 = 2
            if (r2 >= r3) goto L_0x0060
            int r2 = r1 + 1
            byte r1 = r10[r1]
            r3 = 255(0xff, float:3.57E-43)
            r1 = r1 & r3
            if (r1 != r3) goto L_0x005f
            byte r1 = r10[r2]
            r1 = r1 & r3
            if (r1 != r3) goto L_0x001e
            goto L_0x005d
        L_0x001e:
            int r2 = r2 + 1
            r3 = 216(0xd8, float:3.03E-43)
            if (r1 == r3) goto L_0x005d
            if (r1 != r5) goto L_0x0027
            goto L_0x005d
        L_0x0027:
            r3 = 217(0xd9, float:3.04E-43)
            if (r1 == r3) goto L_0x005f
            r3 = 218(0xda, float:3.05E-43)
            if (r1 != r3) goto L_0x0030
            goto L_0x005f
        L_0x0030:
            int r3 = yj(r10, r2, r7, r0)
            if (r3 < r7) goto L_0x005c
            int r8 = r2 + r3
            int r9 = r10.length
            if (r8 <= r9) goto L_0x003c
            goto L_0x005c
        L_0x003c:
            r9 = 225(0xe1, float:3.15E-43)
            if (r1 != r9) goto L_0x005a
            if (r3 < r6) goto L_0x005a
            int r1 = r2 + 2
            int r1 = yj(r10, r1, r4, r0)
            r9 = 1165519206(0x45786966, float:3974.5874)
            if (r1 != r9) goto L_0x005a
            int r1 = r2 + 6
            int r1 = yj(r10, r1, r7, r0)
            if (r1 != 0) goto L_0x005a
            int r1 = r2 + 8
            int r3 = r3 + -8
            goto L_0x0061
        L_0x005a:
            r1 = r8
            goto L_0x0005
        L_0x005c:
            return r0
        L_0x005d:
            r1 = r2
            goto L_0x0005
        L_0x005f:
            r1 = r2
        L_0x0060:
            r3 = 0
        L_0x0061:
            if (r3 <= r6) goto L_0x00b9
            int r2 = yj(r10, r1, r4, r0)
            r8 = 1229531648(0x49492a00, float:823968.0)
            if (r2 == r8) goto L_0x0072
            r9 = 1296891946(0x4d4d002a, float:2.14958752E8)
            if (r2 == r9) goto L_0x0072
            return r0
        L_0x0072:
            if (r2 != r8) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r5 = 0
        L_0x0076:
            int r2 = r1 + 4
            int r2 = yj(r10, r2, r4, r5)
            int r2 = r2 + r7
            r4 = 10
            if (r2 < r4) goto L_0x00b9
            if (r2 <= r3) goto L_0x0084
            goto L_0x00b9
        L_0x0084:
            int r1 = r1 + r2
            int r3 = r3 - r2
            int r2 = r1 + -2
            int r2 = yj(r10, r2, r7, r5)
        L_0x008c:
            int r4 = r2 + -1
            if (r2 <= 0) goto L_0x00b9
            r2 = 12
            if (r3 < r2) goto L_0x00b9
            int r2 = yj(r10, r1, r7, r5)
            r8 = 274(0x112, float:3.84E-43)
            if (r2 != r8) goto L_0x00b3
            int r1 = r1 + r6
            int r10 = yj(r10, r1, r7, r5)
            r1 = 3
            if (r10 == r1) goto L_0x00b0
            r1 = 6
            if (r10 == r1) goto L_0x00ad
            if (r10 == r6) goto L_0x00aa
            return r0
        L_0x00aa:
            r10 = 270(0x10e, float:3.78E-43)
            return r10
        L_0x00ad:
            r10 = 90
            return r10
        L_0x00b0:
            r10 = 180(0xb4, float:2.52E-43)
            return r10
        L_0x00b3:
            int r1 = r1 + 12
            int r3 = r3 + -12
            r2 = r4
            goto L_0x008c
        L_0x00b9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.j.ddd.de.rg(byte[]):int");
    }

    public static boolean th(Context context) {
        String configuration = context.getResources().getConfiguration().toString();
        if (!TextUtils.isEmpty(configuration)) {
            return configuration.contains("hwMultiwindow-magic") || configuration.contains("hw-magic-windows");
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4 A[SYNTHETIC, Splitter:B:35:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[Catch:{ IOException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd A[SYNTHETIC, Splitter:B:46:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d5 A[Catch:{ IOException -> 0x00d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] uk(byte[] r13, int r14, int r15, java.io.File r16, int r17) {
        /*
            r0 = r13
            r4 = r14
            r3 = r15
            r6 = r16
            java.lang.String r7 = "CameraExif"
            r8 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            int r2 = r0.length     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r9 = 0
            java.lang.System.arraycopy(r13, r9, r1, r9, r2)     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            int r0 = r3 * r4
            int r0 = r0 * 3
            int r0 = r0 / 2
            byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r0 = 0
        L_0x0019:
            if (r0 >= r4) goto L_0x0057
            r5 = 0
        L_0x001c:
            if (r5 >= r3) goto L_0x0054
            int r10 = r0 * r3
            int r10 = r10 + r5
            int r11 = r3 + -1
            int r11 = r11 - r5
            int r12 = r11 * r4
            int r12 = r12 + r0
            byte r12 = r1[r12]     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r2[r10] = r12     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            int r10 = r0 % 2
            if (r10 != 0) goto L_0x0051
            int r10 = r5 % 2
            if (r10 != 0) goto L_0x0051
            int r11 = r11 / 2
            int r11 = r11 + r3
            int r11 = r11 * r4
            int r10 = r0 / 2
            int r10 = r10 + r4
            int r10 = r10 * r3
            int r10 = r10 + r5
            int r11 = r11 + r5
            byte r12 = r1[r11]     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r2[r10] = r12     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            int r10 = r0 / 2
            int r10 = r10 + r4
            int r10 = r10 * r3
            int r10 = r10 + r5
            int r10 = r10 + 1
            int r11 = r11 + 1
            byte r11 = r1[r11]     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r2[r10] = r11     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
        L_0x0051:
            int r5 = r5 + 1
            goto L_0x001c
        L_0x0054:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x0057:
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r10.<init>(r6)     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            android.graphics.YuvImage r11 = new android.graphics.YuvImage     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            r5 = 0
            r0 = r11
            r1 = r2
            r2 = r17
            r3 = r15
            r4 = r14
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            int r1 = r11.getWidth()     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            int r2 = r11.getHeight()     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            r0.<init>(r9, r9, r1, r2)     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            r1 = 100
            r11.compressToJpeg(r0, r1, r10)     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            long r0 = r16.length()     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            int r1 = (int) r0     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00a1, all -> 0x009e }
            r2.read(r1)     // Catch:{ Exception -> 0x009c }
            r2.close()     // Catch:{ Exception -> 0x009c }
            r2.close()     // Catch:{ IOException -> 0x0093 }
            r10.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x009b
        L_0x0093:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            fe.mmm.qw.i.qw.ad(r7, r0)
        L_0x009b:
            return r1
        L_0x009c:
            r0 = move-exception
            goto L_0x00ab
        L_0x009e:
            r0 = move-exception
            r1 = r0
            goto L_0x00cb
        L_0x00a1:
            r0 = move-exception
            r2 = r8
            goto L_0x00ab
        L_0x00a4:
            r0 = move-exception
            r1 = r0
            r10 = r8
            goto L_0x00cb
        L_0x00a8:
            r0 = move-exception
            r2 = r8
            r10 = r2
        L_0x00ab:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00c8 }
            fe.mmm.qw.i.qw.ad(r7, r0)     // Catch:{ all -> 0x00c8 }
            if (r2 == 0) goto L_0x00ba
            r2.close()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00ba
        L_0x00b8:
            r0 = move-exception
            goto L_0x00c0
        L_0x00ba:
            if (r10 == 0) goto L_0x00c7
            r10.close()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00c7
        L_0x00c0:
            java.lang.String r0 = r0.getMessage()
            fe.mmm.qw.i.qw.ad(r7, r0)
        L_0x00c7:
            return r8
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            r8 = r2
        L_0x00cb:
            if (r8 == 0) goto L_0x00d3
            r8.close()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d3
        L_0x00d1:
            r0 = move-exception
            goto L_0x00d9
        L_0x00d3:
            if (r10 == 0) goto L_0x00e0
            r10.close()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00e0
        L_0x00d9:
            java.lang.String r0 = r0.getMessage()
            fe.mmm.qw.i.qw.ad(r7, r0)
        L_0x00e0:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.j.ddd.de.uk(byte[], int, int, java.io.File, int):byte[]");
    }

    public static int yj(byte[] bArr, int i2, int i3, boolean z) {
        int i4;
        if (z) {
            i2 += i3 - 1;
            i4 = -1;
        } else {
            i4 = 1;
        }
        byte b = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return b;
            }
            b = (bArr[i2] & 255) | (b << 8);
            i2 += i4;
            i3 = i5;
        }
    }
}
