package org.json.alipay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class c {
    public int a;
    public Reader b;
    public char c;
    public boolean d;

    public c(Reader reader) {
        this.b = !reader.markSupported() ? new BufferedReader(reader) : reader;
        this.d = false;
        this.a = 0;
    }

    public c(String str) {
        this((Reader) new StringReader(str));
    }

    private String a(int i2) {
        if (i2 == 0) {
            return "";
        }
        char[] cArr = new char[i2];
        int i3 = 0;
        if (this.d) {
            this.d = false;
            cArr[0] = this.c;
            i3 = 1;
        }
        while (i3 < i2) {
            try {
                int read = this.b.read(cArr, i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new JSONException((Throwable) e);
            }
        }
        this.a += i3;
        if (i3 >= i2) {
            this.c = cArr[i2 - 1];
            return new String(cArr);
        }
        throw a("Substring bounds error");
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i2;
        if (this.d || (i2 = this.a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.a = i2 - 1;
        this.d = true;
    }

    public final char b() {
        if (this.d) {
            this.d = false;
            if (this.c != 0) {
                this.a++;
            }
            return this.c;
        }
        try {
            int read = this.b.read();
            if (read <= 0) {
                this.c = 0;
                return 0;
            }
            this.a++;
            char c2 = (char) read;
            this.c = c2;
            return c2;
        } catch (IOException e) {
            throw new JSONException((Throwable) e);
        }
    }

    public final char c() {
        char b2;
        char b3;
        char b4;
        while (true) {
            b2 = b();
            if (b2 == '/') {
                char b5 = b();
                if (b5 != '*') {
                    if (b5 == '/') {
                        do {
                            b4 = b();
                            if (b4 == 10 || b4 == 13) {
                                break;
                            }
                        } while (b4 != 0);
                    } else {
                        a();
                        return '/';
                    }
                } else {
                    while (true) {
                        char b6 = b();
                        if (b6 != 0) {
                            if (b6 == '*') {
                                if (b() == '/') {
                                    break;
                                }
                                a();
                            }
                        } else {
                            throw a("Unclosed comment");
                        }
                    }
                }
            } else if (b2 == '#') {
                do {
                    b3 = b();
                    if (b3 == 10 || b3 == 13) {
                        break;
                    }
                } while (b3 != 0);
            } else if (b2 == 0 || b2 > ' ') {
                return b2;
            }
        }
        return b2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:56|57|58) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:42|(2:51|52)(3:48|49|50))|53|54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bd, code lost:
        return new java.lang.Long(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c3, code lost:
        return new java.lang.Double(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
        return r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00b8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00be */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d() {
        /*
            r10 = this;
            char r0 = r10.c()
            r1 = 120(0x78, float:1.68E-43)
            r2 = 8
            r3 = 16
            r4 = 2
            r5 = 34
            if (r0 == r5) goto L_0x00de
            r5 = 91
            if (r0 == r5) goto L_0x00d5
            r5 = 123(0x7b, float:1.72E-43)
            if (r0 == r5) goto L_0x00cc
            r5 = 39
            if (r0 == r5) goto L_0x00de
            r5 = 40
            if (r0 == r5) goto L_0x00d5
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
            r6 = r0
        L_0x0025:
            r7 = 32
            if (r6 < r7) goto L_0x0039
            java.lang.String r7 = ",:]}/\\\"[{;=#"
            int r7 = r7.indexOf(r6)
            if (r7 >= 0) goto L_0x0039
            r5.append(r6)
            char r6 = r10.b()
            goto L_0x0025
        L_0x0039:
            r10.a()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.trim()
            java.lang.String r6 = ""
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x00c5
            java.lang.String r6 = "true"
            boolean r6 = r5.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0057
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x0057:
            java.lang.String r6 = "false"
            boolean r6 = r5.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0062
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        L_0x0062:
            java.lang.String r6 = "null"
            boolean r6 = r5.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x006d
            java.lang.Object r0 = org.json.alipay.b.a
            return r0
        L_0x006d:
            r6 = 48
            if (r0 < r6) goto L_0x0075
            r7 = 57
            if (r0 <= r7) goto L_0x0083
        L_0x0075:
            r7 = 46
            if (r0 == r7) goto L_0x0083
            r7 = 45
            if (r0 == r7) goto L_0x0083
            r7 = 43
            if (r0 != r7) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            return r5
        L_0x0083:
            if (r0 != r6) goto L_0x00b2
            int r0 = r5.length()
            if (r0 <= r4) goto L_0x00a8
            r0 = 1
            char r6 = r5.charAt(r0)
            if (r6 == r1) goto L_0x009a
            char r0 = r5.charAt(r0)
            r1 = 88
            if (r0 != r1) goto L_0x00a8
        L_0x009a:
            java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r1 = r5.substring(r4)     // Catch:{ Exception -> 0x00b2 }
            int r1 = java.lang.Integer.parseInt(r1, r3)     // Catch:{ Exception -> 0x00b2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00b2 }
            return r0
        L_0x00a8:
            java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00b2 }
            int r1 = java.lang.Integer.parseInt(r5, r2)     // Catch:{ Exception -> 0x00b2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00b2 }
            return r0
        L_0x00b2:
            java.lang.Integer r0 = new java.lang.Integer     // Catch:{ Exception -> 0x00b8 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00b8 }
            return r0
        L_0x00b8:
            java.lang.Long r0 = new java.lang.Long     // Catch:{ Exception -> 0x00be }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00be }
            return r0
        L_0x00be:
            java.lang.Double r0 = new java.lang.Double     // Catch:{ Exception -> 0x00c4 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00c4 }
            return r0
        L_0x00c4:
            return r5
        L_0x00c5:
            java.lang.String r0 = "Missing value"
            org.json.alipay.JSONException r0 = r10.a((java.lang.String) r0)
            throw r0
        L_0x00cc:
            r10.a()
            org.json.alipay.b r0 = new org.json.alipay.b
            r0.<init>((org.json.alipay.c) r10)
            return r0
        L_0x00d5:
            r10.a()
            org.json.alipay.a r0 = new org.json.alipay.a
            r0.<init>((org.json.alipay.c) r10)
            return r0
        L_0x00de:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
        L_0x00e3:
            char r6 = r10.b()
            if (r6 == 0) goto L_0x0140
            r7 = 10
            if (r6 == r7) goto L_0x0140
            r8 = 13
            if (r6 == r8) goto L_0x0140
            r9 = 92
            if (r6 == r9) goto L_0x00fc
            if (r6 != r0) goto L_0x011a
            java.lang.String r0 = r5.toString()
            return r0
        L_0x00fc:
            char r6 = r10.b()
            r9 = 98
            if (r6 == r9) goto L_0x013c
            r9 = 102(0x66, float:1.43E-43)
            if (r6 == r9) goto L_0x0139
            r9 = 110(0x6e, float:1.54E-43)
            if (r6 == r9) goto L_0x0135
            r7 = 114(0x72, float:1.6E-43)
            if (r6 == r7) goto L_0x0131
            if (r6 == r1) goto L_0x0127
            r7 = 116(0x74, float:1.63E-43)
            if (r6 == r7) goto L_0x0124
            r7 = 117(0x75, float:1.64E-43)
            if (r6 == r7) goto L_0x011e
        L_0x011a:
            r5.append(r6)
            goto L_0x00e3
        L_0x011e:
            r6 = 4
            java.lang.String r6 = r10.a((int) r6)
            goto L_0x012b
        L_0x0124:
            r6 = 9
            goto L_0x011a
        L_0x0127:
            java.lang.String r6 = r10.a((int) r4)
        L_0x012b:
            int r6 = java.lang.Integer.parseInt(r6, r3)
            char r6 = (char) r6
            goto L_0x011a
        L_0x0131:
            r5.append(r8)
            goto L_0x00e3
        L_0x0135:
            r5.append(r7)
            goto L_0x00e3
        L_0x0139:
            r6 = 12
            goto L_0x011a
        L_0x013c:
            r5.append(r2)
            goto L_0x00e3
        L_0x0140:
            java.lang.String r0 = "Unterminated string"
            org.json.alipay.JSONException r0 = r10.a((java.lang.String) r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.d():java.lang.Object");
    }

    public final String toString() {
        return " at character " + this.a;
    }
}
