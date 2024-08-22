package com.itextpdf.text.pdf;

import com.itextpdf.text.exceptions.InvalidPdfException;
import fe.when.ad.c.qw;
import fe.when.ad.f.e2;
import java.io.IOException;

public class PRTokeniser {

    /* renamed from: yj  reason: collision with root package name */
    public static final boolean[] f6536yj = {true, true, false, false, false, false, false, false, false, false, true, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, false, false, true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    /* renamed from: ad  reason: collision with root package name */
    public TokenType f6537ad;

    /* renamed from: de  reason: collision with root package name */
    public String f6538de;

    /* renamed from: fe  reason: collision with root package name */
    public int f6539fe;
    public final e2 qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f6540rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f6541th;

    public enum TokenType {
        NUMBER,
        STRING,
        NAME,
        COMMENT,
        START_ARRAY,
        END_ARRAY,
        START_DIC,
        END_DIC,
        REF,
        OTHER,
        ENDOFFILE
    }

    public PRTokeniser(e2 e2Var) {
        this.qw = e2Var;
    }

    /* renamed from: switch  reason: not valid java name */
    public static final boolean m678switch(int i2) {
        return when(i2, true);
    }

    public static int th(int i2) {
        if (i2 >= 48 && i2 <= 57) {
            return i2 - 48;
        }
        int i3 = 65;
        if (i2 < 65 || i2 > 70) {
            i3 = 97;
            if (i2 < 97 || i2 > 102) {
                return -1;
            }
        }
        return (i2 - i3) + 10;
    }

    public static final boolean when(int i2, boolean z) {
        return (z && i2 == 0) || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32;
    }

    public void aaa(String str) throws IOException {
        throw new InvalidPdfException(qw.ad("1.at.file.pointer.2", str, String.valueOf(this.qw.qw())));
    }

    public void ad() throws IOException {
        this.qw.close();
    }

    public boolean ddd(byte[] bArr, boolean z) throws IOException {
        boolean z2;
        int i2;
        int length = bArr.length;
        if (length > 0) {
            do {
                i2 = xxx();
            } while (when(i2, z));
            z2 = false;
        } else {
            z2 = false;
            i2 = -1;
        }
        int i3 = 0;
        while (!z2 && i3 < length) {
            if (!(i2 == -1 || i2 == 10)) {
                if (i2 != 13) {
                    bArr[i3] = (byte) i2;
                    i3++;
                    if (z2 || length <= i3) {
                        break;
                    }
                    i2 = xxx();
                } else {
                    long fe2 = fe();
                    if (xxx() != 10) {
                        mmm(fe2);
                    }
                }
            }
            z2 = true;
            i2 = xxx();
        }
        if (i3 >= length) {
            boolean z3 = false;
            while (!z3) {
                i2 = xxx();
                if (!(i2 == -1 || i2 == 10)) {
                    if (i2 == 13) {
                        long fe3 = fe();
                        if (xxx() != 10) {
                            mmm(fe3);
                        }
                    }
                }
                z3 = true;
            }
        }
        if (i2 == -1 && i3 == 0) {
            return false;
        }
        if (i3 + 2 <= length) {
            bArr[i3] = 32;
            bArr[i3 + 1] = 88;
        }
        return true;
    }

    public e2 de() {
        return this.qw;
    }

    public long fe() throws IOException {
        return this.qw.qw();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public boolean ggg() throws java.io.IOException {
        /*
            r14 = this;
        L_0x0000:
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            r1 = -1
            if (r0 == r1) goto L_0x000f
            boolean r2 = m678switch(r0)
            if (r2 != 0) goto L_0x0000
        L_0x000f:
            r2 = 0
            if (r0 != r1) goto L_0x0017
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.ENDOFFILE
            r14.f6537ad = r0
            return r2
        L_0x0017:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r14.f6538de = r4
            r4 = 37
            r5 = 13
            r6 = 10
            r7 = 1
            if (r0 == r4) goto L_0x0241
            java.lang.String r4 = "error.reading.string"
            r8 = 0
            r9 = 40
            r10 = 48
            if (r0 == r9) goto L_0x017b
            r5 = 47
            if (r0 == r5) goto L_0x0141
            r5 = 60
            r6 = 62
            if (r0 == r5) goto L_0x00d2
            if (r0 == r6) goto L_0x00b8
            r4 = 91
            if (r0 == r4) goto L_0x00b2
            r4 = 93
            if (r0 == r4) goto L_0x00ac
            r3.setLength(r2)
            r4 = 57
            r5 = 46
            r6 = 45
            if (r0 == r6) goto L_0x0073
            r8 = 43
            if (r0 == r8) goto L_0x0073
            if (r0 == r5) goto L_0x0073
            if (r0 < r10) goto L_0x005c
            if (r0 > r4) goto L_0x005c
            goto L_0x0073
        L_0x005c:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r2 = com.itextpdf.text.pdf.PRTokeniser.TokenType.OTHER
            r14.f6537ad = r2
        L_0x0060:
            char r0 = (char) r0
            r3.append(r0)
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            boolean[] r2 = f6536yj
            int r4 = r0 + 1
            boolean r2 = r2[r4]
            if (r2 == 0) goto L_0x0060
            goto L_0x00a5
        L_0x0073:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r8 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER
            r14.f6537ad = r8
            if (r0 != r6) goto L_0x0088
        L_0x0079:
            r2 = r2 ^ r7
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            if (r0 == r6) goto L_0x0079
            if (r2 == 0) goto L_0x0092
            r3.append(r6)
            goto L_0x0092
        L_0x0088:
            char r0 = (char) r0
            r3.append(r0)
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
        L_0x0092:
            if (r0 == r1) goto L_0x00a5
            if (r0 < r10) goto L_0x0098
            if (r0 <= r4) goto L_0x009a
        L_0x0098:
            if (r0 != r5) goto L_0x00a5
        L_0x009a:
            char r0 = (char) r0
            r3.append(r0)
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            goto L_0x0092
        L_0x00a5:
            if (r0 == r1) goto L_0x0251
            r14.qw(r0)
            goto L_0x0251
        L_0x00ac:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.END_ARRAY
            r14.f6537ad = r0
            goto L_0x0251
        L_0x00b2:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_ARRAY
            r14.f6537ad = r0
            goto L_0x0251
        L_0x00b8:
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            if (r0 != r6) goto L_0x00c6
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.END_DIC
            r14.f6537ad = r0
            goto L_0x0251
        L_0x00c6:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "greaterthan.not.expected"
            java.lang.String r0 = fe.when.ad.c.qw.ad(r1, r0)
            r14.aaa(r0)
            throw r8
        L_0x00d2:
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            if (r0 != r5) goto L_0x00e0
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_DIC
            r14.f6537ad = r0
            goto L_0x0251
        L_0x00e0:
            r3.setLength(r2)
            com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING
            r14.f6537ad = r1
            r14.f6541th = r7
            r1 = 0
        L_0x00ea:
            boolean r5 = m678switch(r0)
            if (r5 == 0) goto L_0x00f7
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            goto L_0x00ea
        L_0x00f7:
            if (r0 != r6) goto L_0x00fa
            goto L_0x0123
        L_0x00fa:
            int r0 = th(r0)
            if (r0 >= 0) goto L_0x0101
            goto L_0x0123
        L_0x0101:
            fe.when.ad.f.e2 r1 = r14.qw
            int r1 = r1.read()
        L_0x0107:
            boolean r5 = m678switch(r1)
            if (r5 == 0) goto L_0x0114
            fe.when.ad.f.e2 r1 = r14.qw
            int r1 = r1.read()
            goto L_0x0107
        L_0x0114:
            if (r1 != r6) goto L_0x011d
            int r5 = r0 << 4
            char r5 = (char) r5
            r3.append(r5)
            goto L_0x0123
        L_0x011d:
            int r1 = th(r1)
            if (r1 >= 0) goto L_0x0133
        L_0x0123:
            if (r0 < 0) goto L_0x0129
            if (r1 < 0) goto L_0x0129
            goto L_0x0251
        L_0x0129:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r0 = fe.when.ad.c.qw.ad(r4, r0)
            r14.aaa(r0)
            throw r8
        L_0x0133:
            int r0 = r0 << 4
            int r0 = r0 + r1
            char r0 = (char) r0
            r3.append(r0)
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            goto L_0x00ea
        L_0x0141:
            r3.setLength(r2)
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NAME
            r14.f6537ad = r0
        L_0x0148:
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            boolean[] r1 = f6536yj
            int r2 = r0 + 1
            boolean r1 = r1[r2]
            if (r1 == 0) goto L_0x015b
            r14.qw(r0)
            goto L_0x0251
        L_0x015b:
            r1 = 35
            if (r0 != r1) goto L_0x0176
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            int r0 = th(r0)
            int r0 = r0 << 4
            fe.when.ad.f.e2 r1 = r14.qw
            int r1 = r1.read()
            int r1 = th(r1)
            int r0 = r0 + r1
        L_0x0176:
            char r0 = (char) r0
            r3.append(r0)
            goto L_0x0148
        L_0x017b:
            r3.setLength(r2)
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING
            r14.f6537ad = r0
            r14.f6541th = r2
            r0 = 0
        L_0x0185:
            fe.when.ad.f.e2 r11 = r14.qw
            int r11 = r11.read()
            if (r11 != r1) goto L_0x018f
            goto L_0x022e
        L_0x018f:
            if (r11 != r9) goto L_0x0195
            int r0 = r0 + 1
            goto L_0x022c
        L_0x0195:
            r12 = 41
            if (r11 != r12) goto L_0x019d
            int r0 = r0 + -1
            goto L_0x022c
        L_0x019d:
            r13 = 92
            if (r11 != r13) goto L_0x021a
            fe.when.ad.f.e2 r11 = r14.qw
            int r11 = r11.read()
            if (r11 == r6) goto L_0x0212
            if (r11 == r5) goto L_0x0207
            if (r11 == r13) goto L_0x0205
            r13 = 98
            if (r11 == r13) goto L_0x0203
            r13 = 102(0x66, float:1.43E-43)
            if (r11 == r13) goto L_0x0200
            r13 = 110(0x6e, float:1.54E-43)
            if (r11 == r13) goto L_0x01fd
            r13 = 114(0x72, float:1.6E-43)
            if (r11 == r13) goto L_0x01fa
            r13 = 116(0x74, float:1.63E-43)
            if (r11 == r13) goto L_0x01f7
            if (r11 == r9) goto L_0x0205
            if (r11 == r12) goto L_0x0205
            if (r11 < r10) goto L_0x0205
            r12 = 55
            if (r11 <= r12) goto L_0x01cc
            goto L_0x0205
        L_0x01cc:
            int r11 = r11 + -48
            fe.when.ad.f.e2 r13 = r14.qw
            int r13 = r13.read()
            if (r13 < r10) goto L_0x01f3
            if (r13 <= r12) goto L_0x01d9
            goto L_0x01f3
        L_0x01d9:
            int r11 = r11 << 3
            int r11 = r11 + r13
            int r11 = r11 - r10
            fe.when.ad.f.e2 r13 = r14.qw
            int r13 = r13.read()
            if (r13 < r10) goto L_0x01ef
            if (r13 <= r12) goto L_0x01e8
            goto L_0x01ef
        L_0x01e8:
            int r11 = r11 << 3
            int r11 = r11 + r13
            int r11 = r11 - r10
            r11 = r11 & 255(0xff, float:3.57E-43)
            goto L_0x0205
        L_0x01ef:
            r14.qw(r13)
            goto L_0x0205
        L_0x01f3:
            r14.qw(r13)
            goto L_0x0205
        L_0x01f7:
            r11 = 9
            goto L_0x0205
        L_0x01fa:
            r11 = 13
            goto L_0x0205
        L_0x01fd:
            r11 = 10
            goto L_0x0205
        L_0x0200:
            r11 = 12
            goto L_0x0205
        L_0x0203:
            r11 = 8
        L_0x0205:
            r12 = 0
            goto L_0x0213
        L_0x0207:
            fe.when.ad.f.e2 r11 = r14.qw
            int r11 = r11.read()
            if (r11 == r6) goto L_0x0212
            r14.qw(r11)
        L_0x0212:
            r12 = 1
        L_0x0213:
            if (r12 == 0) goto L_0x0217
            goto L_0x0185
        L_0x0217:
            if (r11 >= 0) goto L_0x022c
            goto L_0x022e
        L_0x021a:
            if (r11 != r5) goto L_0x022c
            fe.when.ad.f.e2 r11 = r14.qw
            int r11 = r11.read()
            if (r11 >= 0) goto L_0x0225
            goto L_0x022e
        L_0x0225:
            if (r11 == r6) goto L_0x022c
            r14.qw(r11)
            r11 = 10
        L_0x022c:
            if (r0 != r1) goto L_0x023b
        L_0x022e:
            if (r11 == r1) goto L_0x0231
            goto L_0x0251
        L_0x0231:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r0 = fe.when.ad.c.qw.ad(r4, r0)
            r14.aaa(r0)
            throw r8
        L_0x023b:
            char r11 = (char) r11
            r3.append(r11)
            goto L_0x0185
        L_0x0241:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.COMMENT
            r14.f6537ad = r0
        L_0x0245:
            fe.when.ad.f.e2 r0 = r14.qw
            int r0 = r0.read()
            if (r0 == r1) goto L_0x0251
            if (r0 == r5) goto L_0x0251
            if (r0 != r6) goto L_0x0245
        L_0x0251:
            java.lang.String r0 = r3.toString()
            r14.f6538de = r0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PRTokeniser.ggg():boolean");
    }

    public String i() {
        return this.f6538de;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m679if() {
        return this.f6541th;
    }

    public void mmm(long j) throws IOException {
        this.qw.when(j);
    }

    public String nn(int i2) throws IOException {
        int xxx;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0 && (xxx = xxx()) != -1) {
                sb.append((char) xxx);
                i2 = i3;
            }
        }
        return sb.toString();
    }

    public TokenType o() {
        return this.f6537ad;
    }

    public int pf() {
        return Integer.parseInt(this.f6538de);
    }

    public long ppp() throws IOException {
        return this.qw.ad();
    }

    public void qw(int i2) {
        if (i2 != -1) {
            this.qw.de((byte) i2);
        }
    }

    public int rg() {
        return this.f6540rg;
    }

    public e2 uk() {
        return new e2(this.qw);
    }

    public void vvv() throws IOException {
        String str = null;
        String str2 = null;
        long j = 0;
        int i2 = 0;
        while (ggg()) {
            TokenType tokenType = this.f6537ad;
            if (tokenType != TokenType.COMMENT) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (tokenType != TokenType.OTHER || !this.f6538de.equals("R")) {
                            this.qw.when(j);
                            this.f6537ad = TokenType.NUMBER;
                            this.f6538de = str;
                            return;
                        }
                        this.f6537ad = TokenType.REF;
                        this.f6539fe = Integer.parseInt(str);
                        this.f6540rg = Integer.parseInt(str2);
                        return;
                    } else if (tokenType != TokenType.NUMBER) {
                        this.qw.when(j);
                        this.f6537ad = TokenType.NUMBER;
                        this.f6538de = str;
                        return;
                    } else {
                        str2 = this.f6538de;
                    }
                } else if (tokenType == TokenType.NUMBER) {
                    j = this.qw.qw();
                    str = this.f6538de;
                } else {
                    return;
                }
                i2++;
            }
        }
        if (i2 == 1) {
            this.f6537ad = TokenType.NUMBER;
        }
    }

    public int xxx() throws IOException {
        return this.qw.read();
    }

    public int yj() {
        return this.f6539fe;
    }
}
