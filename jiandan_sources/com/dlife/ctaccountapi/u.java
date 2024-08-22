package com.dlife.ctaccountapi;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public class u {
    public static String a = "u";
    public static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, ExifInterface.WEBP_VP8L_SIGNATURE, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static byte[] a(String str) {
        try {
            return b(str);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[LOOP:0: B:1:0x000d->B:31:0x0082, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0049 A[EDGE_INSN: B:34:0x0049->B:16:0x0049 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0049 A[EDGE_INSN: B:35:0x0049->B:16:0x0049 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0049 A[EDGE_INSN: B:37:0x0049->B:16:0x0049 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0049 A[EDGE_INSN: B:38:0x0049->B:16:0x0049 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024 A[LOOP:2: B:8:0x0024->B:11:0x0031, LOOP_START, PHI: r5 
      PHI: (r5v1 int) = (r5v0 int), (r5v9 int) binds: [B:7:0x0021, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(java.lang.String r9) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "US-ASCII"
            byte[] r9 = r9.getBytes(r1)
            int r1 = r9.length
            r2 = 0
        L_0x000d:
            java.lang.String r3 = "iso8859-1"
            if (r2 >= r1) goto L_0x0049
        L_0x0011:
            byte[] r4 = b
            int r5 = r2 + 1
            byte r2 = r9[r2]
            byte r2 = r4[r2]
            r4 = -1
            if (r5 >= r1) goto L_0x0021
            if (r2 == r4) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r2 = r5
            goto L_0x0011
        L_0x0021:
            if (r2 != r4) goto L_0x0024
            goto L_0x0049
        L_0x0024:
            byte[] r6 = b
            int r7 = r5 + 1
            byte r5 = r9[r5]
            byte r5 = r6[r5]
            if (r7 >= r1) goto L_0x0033
            if (r5 == r4) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r5 = r7
            goto L_0x0024
        L_0x0033:
            if (r5 != r4) goto L_0x0036
            goto L_0x0049
        L_0x0036:
            int r2 = r2 << 2
            r6 = r5 & 48
            int r6 = r6 >>> 4
            r2 = r2 | r6
            char r2 = (char) r2
            r0.append(r2)
        L_0x0041:
            int r2 = r7 + 1
            byte r6 = r9[r7]
            r7 = 61
            if (r6 != r7) goto L_0x0052
        L_0x0049:
            java.lang.String r9 = r0.toString()
            byte[] r9 = r9.getBytes(r3)
            return r9
        L_0x0052:
            byte[] r8 = b
            byte r6 = r8[r6]
            if (r2 >= r1) goto L_0x005d
            if (r6 == r4) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r7 = r2
            goto L_0x0041
        L_0x005d:
            if (r6 != r4) goto L_0x0060
            goto L_0x0049
        L_0x0060:
            r5 = r5 & 15
            int r5 = r5 << 4
            r8 = r6 & 60
            int r8 = r8 >>> 2
            r5 = r5 | r8
            char r5 = (char) r5
            r0.append(r5)
        L_0x006d:
            int r5 = r2 + 1
            byte r2 = r9[r2]
            if (r2 != r7) goto L_0x0074
            goto L_0x0049
        L_0x0074:
            byte[] r8 = b
            byte r2 = r8[r2]
            if (r5 >= r1) goto L_0x007f
            if (r2 == r4) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r2 = r5
            goto L_0x006d
        L_0x007f:
            if (r2 != r4) goto L_0x0082
            goto L_0x0049
        L_0x0082:
            r3 = r6 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            char r2 = (char) r2
            r0.append(r2)
            r2 = r5
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.u.b(java.lang.String):byte[]");
    }
}
