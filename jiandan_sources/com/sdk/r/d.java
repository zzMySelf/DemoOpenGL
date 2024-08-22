package com.sdk.r;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public class d {
    public static char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, ExifInterface.WEBP_VP8L_SIGNATURE, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079 A[LOOP:0: B:1:0x000f->B:28:0x0079, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083 A[EDGE_INSN: B:33:0x0083->B:29:0x0083 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0083 A[EDGE_INSN: B:34:0x0083->B:29:0x0083 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A[EDGE_INSN: B:36:0x0083->B:29:0x0083 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083 A[EDGE_INSN: B:37:0x0083->B:29:0x0083 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A[LOOP:2: B:7:0x0025->B:10:0x0032, LOOP_START, PHI: r4 
      PHI: (r4v1 int) = (r4v0 int), (r4v8 int) binds: [B:6:0x0021, B:10:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r8) {
        /*
            java.nio.charset.Charset r0 = java.nio.charset.Charset.defaultCharset()
            byte[] r8 = r8.getBytes(r0)
            int r0 = r8.length
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>(r0)
            r2 = 0
        L_0x000f:
            if (r2 >= r0) goto L_0x0083
        L_0x0011:
            byte[] r3 = b
            int r4 = r2 + 1
            byte r2 = r8[r2]
            byte r2 = r3[r2]
            r3 = -1
            if (r4 >= r0) goto L_0x0021
            if (r2 == r3) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r2 = r4
            goto L_0x0011
        L_0x0021:
            if (r2 != r3) goto L_0x0025
            goto L_0x0083
        L_0x0025:
            byte[] r5 = b
            int r6 = r4 + 1
            byte r4 = r8[r4]
            byte r4 = r5[r4]
            if (r6 >= r0) goto L_0x0034
            if (r4 == r3) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r4 = r6
            goto L_0x0025
        L_0x0034:
            if (r4 != r3) goto L_0x0037
            goto L_0x0083
        L_0x0037:
            int r2 = r2 << 2
            r5 = r4 & 48
            int r5 = r5 >>> 4
            r2 = r2 | r5
            r1.write(r2)
        L_0x0041:
            int r2 = r6 + 1
            byte r5 = r8[r6]
            r6 = 61
            if (r5 != r6) goto L_0x004a
            goto L_0x0083
        L_0x004a:
            byte[] r7 = b
            byte r5 = r7[r5]
            if (r2 >= r0) goto L_0x0055
            if (r5 == r3) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r6 = r2
            goto L_0x0041
        L_0x0055:
            if (r5 != r3) goto L_0x0058
            goto L_0x0083
        L_0x0058:
            r4 = r4 & 15
            int r4 = r4 << 4
            r7 = r5 & 60
            int r7 = r7 >>> 2
            r4 = r4 | r7
            r1.write(r4)
        L_0x0064:
            int r4 = r2 + 1
            byte r2 = r8[r2]
            if (r2 != r6) goto L_0x006b
            goto L_0x0083
        L_0x006b:
            byte[] r7 = b
            byte r2 = r7[r2]
            if (r4 >= r0) goto L_0x0076
            if (r2 == r3) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r2 = r4
            goto L_0x0064
        L_0x0076:
            if (r2 != r3) goto L_0x0079
            goto L_0x0083
        L_0x0079:
            r3 = r5 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            r1.write(r2)
            r2 = r4
            goto L_0x000f
        L_0x0083:
            byte[] r8 = r1.toByteArray()
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = java.nio.charset.Charset.defaultCharset()
            r0.<init>(r8, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.r.d.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        r0.append(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r8) {
        /*
            java.lang.String r0 = "utf-8"
            byte[] r8 = r8.getBytes(r0)
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r8.length
            r2 = 0
        L_0x000d:
            if (r2 >= r1) goto L_0x009b
            int r3 = r2 + 1
            byte r2 = r8[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            if (r3 != r1) goto L_0x0031
            char[] r8 = a
            int r1 = r2 >>> 2
            char r8 = r8[r1]
            r0.append(r8)
            char[] r8 = a
            r1 = r2 & 3
            int r1 = r1 << 4
            char r8 = r8[r1]
            r0.append(r8)
            java.lang.String r8 = "=="
        L_0x002d:
            r0.append(r8)
            goto L_0x009b
        L_0x0031:
            int r4 = r3 + 1
            byte r3 = r8[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            if (r4 != r1) goto L_0x0060
            char[] r8 = a
            int r1 = r2 >>> 2
            char r8 = r8[r1]
            r0.append(r8)
            char[] r8 = a
            r1 = r2 & 3
            int r1 = r1 << 4
            r2 = r3 & 240(0xf0, float:3.36E-43)
            int r2 = r2 >>> 4
            r1 = r1 | r2
            char r8 = r8[r1]
            r0.append(r8)
            char[] r8 = a
            r1 = r3 & 15
            int r1 = r1 << 2
            char r8 = r8[r1]
            r0.append(r8)
            java.lang.String r8 = "="
            goto L_0x002d
        L_0x0060:
            int r5 = r4 + 1
            byte r4 = r8[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            char[] r6 = a
            int r7 = r2 >>> 2
            char r6 = r6[r7]
            r0.append(r6)
            char[] r6 = a
            r2 = r2 & 3
            int r2 = r2 << 4
            r7 = r3 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >>> 4
            r2 = r2 | r7
            char r2 = r6[r2]
            r0.append(r2)
            char[] r2 = a
            r3 = r3 & 15
            int r3 = r3 << 2
            r6 = r4 & 192(0xc0, float:2.69E-43)
            int r6 = r6 >>> 6
            r3 = r3 | r6
            char r2 = r2[r3]
            r0.append(r2)
            char[] r2 = a
            r3 = r4 & 63
            char r2 = r2[r3]
            r0.append(r2)
            r2 = r5
            goto L_0x000d
        L_0x009b:
            java.lang.String r8 = r0.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.r.d.b(java.lang.String):java.lang.String");
    }
}
