package com.baidu.sofire.l;

import android.text.TextUtils;
import com.baidu.sofire.a.a;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.google.common.base.Ascii;
import java.security.MessageDigest;

public final class k {
    public static final String[] a = {"0", "1", "2", "3", "4", BannerBaseItemInfo.TYPE_LOGIN, BannerBaseItemInfo.TYPE_SCHEME, "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(byte[] r6) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r6.length
            if (r1 >= r2) goto L_0x002e
            byte r2 = r6[r1]
            if (r2 >= 0) goto L_0x000f
            int r2 = r2 + 256
        L_0x000f:
            int r3 = r2 / 16
            int r2 = r2 % 16
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String[] r5 = a
            r3 = r5[r3]
            r4.append(r3)
            r2 = r5[r2]
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.append(r2)
            int r1 = r1 + 1
            goto L_0x0006
        L_0x002e:
            java.lang.String r6 = r0.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.k.a(byte[]):java.lang.String");
    }

    public static String b(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            int i3 = i2 * 2;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            cArr2[i3 + 1] = cArr[b & Ascii.SI];
        }
        return new String(cArr2);
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str3 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
            } catch (Throwable unused) {
                str2 = str3;
                int i2 = a.a;
                return str2;
            }
        } catch (Throwable unused2) {
            int i22 = a.a;
            return str2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|(2:24|25)|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0040, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0041, code lost:
        if (r2 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0047, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0049, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x004a
            boolean r1 = r5.exists()
            if (r1 != 0) goto L_0x000a
            goto L_0x004a
        L_0x000a:
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ all -> 0x0034 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0034 }
            r2.<init>(r5)     // Catch:{ all -> 0x0034 }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0035 }
        L_0x0019:
            int r3 = r2.read(r5)     // Catch:{ all -> 0x0035 }
            r4 = -1
            if (r3 == r4) goto L_0x0025
            r4 = 0
            r1.update(r5, r4, r3)     // Catch:{ all -> 0x0035 }
            goto L_0x0019
        L_0x0025:
            byte[] r5 = r1.digest()     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = b(r5)     // Catch:{ all -> 0x0035 }
            r2.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0033
        L_0x0031:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0033:
            return r5
        L_0x0034:
            r2 = r0
        L_0x0035:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            r2.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x003f
        L_0x003d:
            int r5 = com.baidu.sofire.a.a.a
        L_0x003f:
            return r0
        L_0x0040:
            r5 = move-exception
            if (r2 == 0) goto L_0x0049
            r2.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x0049
        L_0x0047:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0049:
            throw r5
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.k.a(java.io.File):java.lang.String");
    }
}
