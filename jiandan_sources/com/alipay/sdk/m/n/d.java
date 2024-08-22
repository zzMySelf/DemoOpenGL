package com.alipay.sdk.m.n;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class d {
    public static final String a = "RSA";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048 A[SYNTHETIC, Splitter:B:22:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A[SYNTHETIC, Splitter:B:30:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            java.lang.String r1 = "RSA"
            java.security.PublicKey r6 = b(r1, r6)     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            java.lang.String r1 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            r2 = 1
            r1.init(r2, r6)     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            int r6 = r1.getBlockSize()     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            r2.<init>()     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            r3 = 0
        L_0x0021:
            int r4 = r5.length     // Catch:{ Exception -> 0x003d }
            if (r3 >= r4) goto L_0x0035
            int r4 = r5.length     // Catch:{ Exception -> 0x003d }
            int r4 = r4 - r3
            if (r4 >= r6) goto L_0x002b
            int r4 = r5.length     // Catch:{ Exception -> 0x003d }
            int r4 = r4 - r3
            goto L_0x002c
        L_0x002b:
            r4 = r6
        L_0x002c:
            byte[] r4 = r1.doFinal(r5, r3, r4)     // Catch:{ Exception -> 0x003d }
            r2.write(r4)     // Catch:{ Exception -> 0x003d }
            int r3 = r3 + r6
            goto L_0x0021
        L_0x0035:
            byte[] r0 = r2.toByteArray()     // Catch:{ Exception -> 0x003d }
            r2.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x003d:
            r5 = move-exception
            goto L_0x0043
        L_0x003f:
            r5 = move-exception
            goto L_0x0053
        L_0x0041:
            r5 = move-exception
            r2 = r0
        L_0x0043:
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x0050
            r2.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r5 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r5)
        L_0x0050:
            return r0
        L_0x0051:
            r5 = move-exception
            r0 = r2
        L_0x0053:
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r6 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r6)
        L_0x005d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.n.d.a(java.lang.String, java.lang.String):byte[]");
    }

    public static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
    }
}
