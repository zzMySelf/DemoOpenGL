package com.baidu.android.oem;

final class Base64Coder {
    private static final String SYSTEM_LINE_SEPARATOR = System.getProperty("line.separator");
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];

    static {
        int i2 = 0;
        char c2 = 'A';
        while (c2 <= 'Z') {
            map1[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            map1[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            map1[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = map1;
        int i3 = i2 + 1;
        cArr[i2] = '+';
        int i4 = i3 + 1;
        cArr[i3] = '/';
        int i5 = 0;
        while (true) {
            byte[] bArr = map2;
            if (i5 >= bArr.length) {
                break;
            }
            bArr[i5] = -1;
            i5++;
        }
        for (int i6 = 0; i6 < 64; i6++) {
            map2[map1[i6]] = (byte) i6;
        }
    }

    public static String encodeString(String s) {
        return new String(encode(s.getBytes()));
    }

    public static String encodeLines(byte[] in) {
        return encodeLines(in, 0, in.length, 76, SYSTEM_LINE_SEPARATOR);
    }

    public static String encodeLines(byte[] in, int iOff, int iLen, int lineLen, String lineSeparator) {
        int blockLen = (lineLen * 3) / 4;
        if (blockLen > 0) {
            StringBuilder buf = new StringBuilder((((iLen + 2) / 3) * 4) + (lineSeparator.length() * (((iLen + blockLen) - 1) / blockLen)));
            int ip = 0;
            while (ip < iLen) {
                int l = Math.min(iLen - ip, blockLen);
                buf.append(encode(in, iOff + ip, l));
                buf.append(lineSeparator);
                ip += l;
            }
            return buf.toString();
        }
        throw new IllegalArgumentException();
    }

    public static char[] encode(byte[] in) {
        return encode(in, 0, in.length);
    }

    public static char[] encode(byte[] in, int iLen) {
        return encode(in, 0, iLen);
    }

    public static char[] encode(byte[] in, int iOff, int iLen) {
        int ip;
        int ip2;
        int ip3;
        int ip4;
        int oDataLen = ((iLen * 4) + 2) / 3;
        char[] out = new char[(((iLen + 2) / 3) * 4)];
        int ip5 = iOff;
        int iEnd = iOff + iLen;
        int op = 0;
        while (ip5 < iEnd) {
            int ip6 = ip5 + 1;
            int i0 = in[ip5] & 255;
            if (ip6 < iEnd) {
                ip = ip6 + 1;
                ip2 = in[ip6] & 255;
            } else {
                ip = ip6;
                ip2 = 0;
            }
            if (ip < iEnd) {
                ip4 = ip + 1;
                ip3 = in[ip] & 255;
            } else {
                int i2 = ip;
                ip3 = 0;
                ip4 = i2;
            }
            int o2 = ((ip2 & 15) << 2) | (ip3 >>> 6);
            int o3 = ip3 & 63;
            int op2 = op + 1;
            char[] cArr = map1;
            out[op] = cArr[i0 >>> 2];
            int op3 = op2 + 1;
            out[op2] = cArr[((i0 & 3) << 4) | (ip2 >>> 4)];
            char c2 = '=';
            out[op3] = op3 < oDataLen ? cArr[o2] : '=';
            int op4 = op3 + 1;
            if (op4 < oDataLen) {
                c2 = cArr[o3];
            }
            out[op4] = c2;
            op = op4 + 1;
            ip5 = ip4;
        }
        return out;
    }

    public static String decodeString(String s) {
        return new String(decode(s));
    }

    public static byte[] decodeLines(String s) {
        char[] buf = new char[s.length()];
        int p = 0;
        for (int ip = 0; ip < s.length(); ip++) {
            char c2 = s.charAt(ip);
            if (!(c2 == ' ' || c2 == 13 || c2 == 10 || c2 == 9)) {
                buf[p] = c2;
                p++;
            }
        }
        return decode(buf, 0, p);
    }

    public static byte[] decode(String s) {
        return decode(s.toCharArray());
    }

    public static byte[] decode(char[] in) {
        return decode(in, 0, in.length);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r7v3, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r9v3, types: [char] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decode(char[] r19, int r20, int r21) {
        /*
            int r0 = r21 % 4
            if (r0 != 0) goto L_0x00ae
            r0 = r21
        L_0x0006:
            if (r0 <= 0) goto L_0x0015
            int r1 = r20 + r0
            int r1 = r1 + -1
            char r1 = r19[r1]
            r2 = 61
            if (r1 != r2) goto L_0x0015
            int r0 = r0 + -1
            goto L_0x0006
        L_0x0015:
            int r1 = r0 * 3
            int r1 = r1 / 4
            byte[] r2 = new byte[r1]
            r3 = r20
            int r4 = r20 + r0
            r5 = 0
        L_0x0020:
            if (r3 >= r4) goto L_0x00ad
            int r6 = r3 + 1
            char r3 = r19[r3]
            int r7 = r6 + 1
            char r6 = r19[r6]
            r8 = 65
            if (r7 >= r4) goto L_0x0033
            int r9 = r7 + 1
            char r7 = r19[r7]
            goto L_0x0035
        L_0x0033:
            r9 = r7
            r7 = r8
        L_0x0035:
            if (r9 >= r4) goto L_0x003c
            int r8 = r9 + 1
            char r9 = r19[r9]
            goto L_0x0041
        L_0x003c:
            r18 = r9
            r9 = r8
            r8 = r18
        L_0x0041:
            java.lang.String r10 = "Illegal character in Base64 encoded data."
            r11 = 127(0x7f, float:1.78E-43)
            if (r3 > r11) goto L_0x00a1
            if (r6 > r11) goto L_0x00a1
            if (r7 > r11) goto L_0x00a1
            if (r9 > r11) goto L_0x00a1
            byte[] r11 = map2
            byte r12 = r11[r3]
            byte r13 = r11[r6]
            byte r14 = r11[r7]
            byte r11 = r11[r9]
            if (r12 < 0) goto L_0x0095
            if (r13 < 0) goto L_0x0095
            if (r14 < 0) goto L_0x0095
            if (r11 < 0) goto L_0x0095
            int r10 = r12 << 2
            int r15 = r13 >>> 4
            r10 = r10 | r15
            r15 = r13 & 15
            int r15 = r15 << 4
            int r16 = r14 >>> 2
            r15 = r15 | r16
            r16 = r14 & 3
            int r16 = r16 << 6
            r21 = r0
            r0 = r16 | r11
            r16 = r3
            int r3 = r5 + 1
            r17 = r4
            byte r4 = (byte) r10
            r2[r5] = r4
            if (r3 >= r1) goto L_0x0085
            int r4 = r3 + 1
            byte r5 = (byte) r15
            r2[r3] = r5
            r3 = r4
        L_0x0085:
            if (r3 >= r1) goto L_0x008e
            int r4 = r3 + 1
            byte r5 = (byte) r0
            r2[r3] = r5
            r5 = r4
            goto L_0x008f
        L_0x008e:
            r5 = r3
        L_0x008f:
            r0 = r21
            r3 = r8
            r4 = r17
            goto L_0x0020
        L_0x0095:
            r21 = r0
            r16 = r3
            r17 = r4
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r10)
            throw r0
        L_0x00a1:
            r21 = r0
            r16 = r3
            r17 = r4
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r10)
            throw r0
        L_0x00ad:
            return r2
        L_0x00ae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Length of Base64 encoded input string is not a multiple of 4."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.oem.Base64Coder.decode(char[], int, int):byte[]");
    }

    private Base64Coder() {
    }
}
