package com.alipay.sdk.m.p;

import com.alipay.sdk.m.l.a;
import com.alipay.sdk.m.n.b;
import com.alipay.sdk.m.n.d;
import com.alipay.sdk.m.n.e;
import com.alipay.sdk.m.u.n;
import java.util.Locale;

public final class c {
    public boolean a;
    public String b = n.a(24);

    public c(boolean z) {
        this.a = z;
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        return e.b(str, bArr, str2);
    }

    public d a(b bVar, boolean z, String str) {
        byte[] bArr;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.b().getBytes();
        byte[] bytes2 = bVar.a().getBytes();
        if (z) {
            try {
                bytes2 = b.a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        if (this.a) {
            bArr = a(bytes, a(this.b, a.f), b(this.b, bytes2, str));
        } else {
            bArr = a(bytes, bytes2);
        }
        return new d(z, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A[SYNTHETIC, Splitter:B:29:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b A[SYNTHETIC, Splitter:B:41:0x007b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.p.d r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            byte[] r2 = r6.a()     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            r2 = 5
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x005b }
            r1.read(r3)     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x005b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x005b }
            int r3 = a((java.lang.String) r4)     // Catch:{ Exception -> 0x005b }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x005b }
            r1.read(r3)     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x005b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x005b }
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0059 }
            r1.read(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0059 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0059 }
            int r2 = a((java.lang.String) r3)     // Catch:{ Exception -> 0x0059 }
            if (r2 <= 0) goto L_0x0052
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0059 }
            r1.read(r2)     // Catch:{ Exception -> 0x0059 }
            boolean r3 = r5.a     // Catch:{ Exception -> 0x0059 }
            if (r3 == 0) goto L_0x0042
            java.lang.String r3 = r5.b     // Catch:{ Exception -> 0x0059 }
            byte[] r2 = a((java.lang.String) r3, (byte[]) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x0059 }
        L_0x0042:
            boolean r6 = r6.b()     // Catch:{ Exception -> 0x0059 }
            if (r6 == 0) goto L_0x004c
            byte[] r2 = com.alipay.sdk.m.n.b.b(r2)     // Catch:{ Exception -> 0x0059 }
        L_0x004c:
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0059 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0059 }
            goto L_0x0053
        L_0x0052:
            r6 = r0
        L_0x0053:
            r1.close()     // Catch:{ Exception -> 0x0057 }
            goto L_0x006c
        L_0x0057:
            goto L_0x006c
        L_0x0059:
            r6 = move-exception
            goto L_0x0063
        L_0x005b:
            r6 = move-exception
            r4 = r0
            goto L_0x0063
        L_0x005e:
            r6 = move-exception
            goto L_0x0079
        L_0x0060:
            r6 = move-exception
            r1 = r0
            r4 = r1
        L_0x0063:
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            r6 = r0
        L_0x006c:
            if (r4 != 0) goto L_0x0071
            if (r6 != 0) goto L_0x0071
            return r0
        L_0x0071:
            com.alipay.sdk.m.p.b r7 = new com.alipay.sdk.m.p.b
            r7.<init>(r4, r6)
            return r7
        L_0x0077:
            r6 = move-exception
            r0 = r1
        L_0x0079:
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.p.c.a(com.alipay.sdk.m.p.d, java.lang.String):com.alipay.sdk.m.p.b");
    }

    public static byte[] a(String str, String str2) {
        return d.a(str, str2);
    }

    public static byte[] a(String str, byte[] bArr, String str2) {
        return e.a(str, bArr, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004f, code lost:
        if (r2 == null) goto L_0x0054;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004a A[SYNTHETIC, Splitter:B:30:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0059 A[SYNTHETIC, Splitter:B:40:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0060 A[SYNTHETIC, Splitter:B:44:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[]... r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0064
            int r1 = r7.length
            if (r1 != 0) goto L_0x0008
            goto L_0x0064
        L_0x0008:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r1.<init>()     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            int r3 = r7.length     // Catch:{ Exception -> 0x0036 }
            r4 = 0
        L_0x0014:
            if (r4 >= r3) goto L_0x002a
            r5 = r7[r4]     // Catch:{ Exception -> 0x0036 }
            int r6 = r5.length     // Catch:{ Exception -> 0x0036 }
            java.lang.String r6 = a((int) r6)     // Catch:{ Exception -> 0x0036 }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x0036 }
            r2.write(r6)     // Catch:{ Exception -> 0x0036 }
            r2.write(r5)     // Catch:{ Exception -> 0x0036 }
            int r4 = r4 + 1
            goto L_0x0014
        L_0x002a:
            r2.flush()     // Catch:{ Exception -> 0x0036 }
            byte[] r7 = r1.toByteArray()     // Catch:{ Exception -> 0x0036 }
            r1.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r0 = r7
            goto L_0x0051
        L_0x0036:
            r7 = move-exception
            goto L_0x0045
        L_0x0038:
            r7 = move-exception
            r2 = r0
        L_0x003a:
            r0 = r1
            goto L_0x0057
        L_0x003c:
            r7 = move-exception
            r2 = r0
            goto L_0x0045
        L_0x003f:
            r7 = move-exception
            r2 = r0
            goto L_0x0057
        L_0x0042:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x0045:
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r7)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ Exception -> 0x004e }
            goto L_0x004f
        L_0x004e:
        L_0x004f:
            if (r2 == 0) goto L_0x0054
        L_0x0051:
            r2.close()     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            return r0
        L_0x0055:
            r7 = move-exception
            goto L_0x003a
        L_0x0057:
            if (r0 == 0) goto L_0x005e
            r0.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x005e
        L_0x005d:
        L_0x005e:
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            throw r7
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.p.c.a(byte[][]):byte[]");
    }

    public static String a(int i2) {
        return String.format(Locale.getDefault(), "%05d", new Object[]{Integer.valueOf(i2)});
    }

    public static int a(String str) {
        return Integer.parseInt(str);
    }
}
