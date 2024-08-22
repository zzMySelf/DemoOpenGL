package com.sdk.h;

public class a extends d {
    public static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static final byte[] b = new byte[256];
    public byte[] c = new byte[4];

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 255; i3++) {
            b[i3] = -1;
        }
        while (true) {
            char[] cArr = a;
            if (i2 < cArr.length) {
                b[cArr[i2]] = (byte) i2;
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.io.PushbackInputStream r10, java.io.OutputStream r11, int r12) {
        /*
            r9 = this;
            r0 = 2
            if (r12 < r0) goto L_0x00d5
        L_0x0003:
            int r1 = r10.read()
            r2 = -1
            if (r1 == r2) goto L_0x00cf
            r3 = 10
            if (r1 == r3) goto L_0x0003
            r3 = 13
            if (r1 == r3) goto L_0x0003
            byte[] r3 = r9.c
            byte r1 = (byte) r1
            r4 = 0
            r3[r4] = r1
            int r1 = r12 + -1
            r5 = 0
        L_0x001b:
            if (r5 >= r1) goto L_0x002f
            int r6 = r10.read()
            if (r6 != r2) goto L_0x0029
            if (r5 != 0) goto L_0x0027
            r1 = -1
            goto L_0x002f
        L_0x0027:
            r1 = r5
            goto L_0x002f
        L_0x0029:
            int r5 = r5 + 1
            byte r6 = (byte) r6
            r3[r5] = r6
            goto L_0x001b
        L_0x002f:
            if (r1 == r2) goto L_0x00c9
            r10 = 61
            r1 = 3
            if (r12 <= r1) goto L_0x003d
            byte[] r3 = r9.c
            byte r3 = r3[r1]
            if (r3 != r10) goto L_0x003d
            r12 = 3
        L_0x003d:
            if (r12 <= r0) goto L_0x0046
            byte[] r3 = r9.c
            byte r3 = r3[r0]
            if (r3 != r10) goto L_0x0046
            r12 = 2
        L_0x0046:
            r10 = 4
            if (r12 == r0) goto L_0x0069
            if (r12 == r1) goto L_0x005b
            if (r12 == r10) goto L_0x0051
            r3 = -1
            r4 = -1
            r7 = -1
            goto L_0x007f
        L_0x0051:
            byte[] r2 = b
            byte[] r3 = r9.c
            byte r3 = r3[r1]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r2 = r2[r3]
        L_0x005b:
            byte[] r3 = b
            byte[] r5 = r9.c
            byte r5 = r5[r0]
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r3 = r3[r5]
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x006a
        L_0x0069:
            r3 = -1
        L_0x006a:
            byte[] r5 = b
            byte[] r6 = r9.c
            r7 = 1
            byte r7 = r6[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r5[r7]
            byte r4 = r6[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = r5[r4]
            r8 = r3
            r3 = r2
            r2 = r4
            r4 = r8
        L_0x007f:
            if (r12 == r0) goto L_0x00bc
            if (r12 == r1) goto L_0x00a6
            if (r12 == r10) goto L_0x0086
            goto L_0x00c8
        L_0x0086:
            int r12 = r2 << 2
            r12 = r12 & 252(0xfc, float:3.53E-43)
            int r0 = r7 >>> 4
            r0 = r0 & r1
            r12 = r12 | r0
            byte r12 = (byte) r12
            r11.write(r12)
            int r10 = r7 << 4
            r10 = r10 & 240(0xf0, float:3.36E-43)
            int r12 = r3 >>> 2
            r12 = r12 & 15
            r10 = r10 | r12
            byte r10 = (byte) r10
            r11.write(r10)
            int r10 = r3 << 6
            r10 = r10 & 192(0xc0, float:2.69E-43)
            r12 = r4 & 63
            goto L_0x00ba
        L_0x00a6:
            int r12 = r2 << 2
            r12 = r12 & 252(0xfc, float:3.53E-43)
            int r2 = r7 >>> 4
            r1 = r1 & r2
            r12 = r12 | r1
            byte r12 = (byte) r12
            r11.write(r12)
            int r10 = r7 << 4
            r10 = r10 & 240(0xf0, float:3.36E-43)
            int r12 = r3 >>> 2
            r12 = r12 & 15
        L_0x00ba:
            r10 = r10 | r12
            goto L_0x00c4
        L_0x00bc:
            int r12 = r2 << 2
            r12 = r12 & 252(0xfc, float:3.53E-43)
            int r10 = r7 >>> 4
            r10 = r10 & r1
            r10 = r10 | r12
        L_0x00c4:
            byte r10 = (byte) r10
            r11.write(r10)
        L_0x00c8:
            return
        L_0x00c9:
            com.sdk.h.c r10 = new com.sdk.h.c
            r10.<init>()
            throw r10
        L_0x00cf:
            com.sdk.h.c r10 = new com.sdk.h.c
            r10.<init>()
            throw r10
        L_0x00d5:
            com.sdk.h.b r10 = new com.sdk.h.b
            java.lang.String r11 = "BASE64Decoder: Not enough bytes for an atom."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.h.a.a(java.io.PushbackInputStream, java.io.OutputStream, int):void");
    }
}
