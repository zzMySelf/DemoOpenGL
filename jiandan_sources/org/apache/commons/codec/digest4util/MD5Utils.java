package org.apache.commons.codec.digest4util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static final boolean DEBUG = false;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return toHexString(instance.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003d, code lost:
        if (r2 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0044, code lost:
        if (r2 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0048, code lost:
        if (r2 != null) goto L_0x003f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[SYNTHETIC, Splitter:B:21:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toMd5(java.io.File r5, boolean r6) {
        /*
            r0 = 0
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0047, FileNotFoundException -> 0x0043, IOException -> 0x003c, all -> 0x0035 }
            r1.reset()     // Catch:{ NoSuchAlgorithmException -> 0x0047, FileNotFoundException -> 0x0043, IOException -> 0x003c, all -> 0x0035 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0047, FileNotFoundException -> 0x0043, IOException -> 0x003c, all -> 0x0035 }
            r2.<init>(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0047, FileNotFoundException -> 0x0043, IOException -> 0x003c, all -> 0x0035 }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ NoSuchAlgorithmException -> 0x0033, FileNotFoundException -> 0x0031, IOException -> 0x002f, all -> 0x002c }
        L_0x0013:
            int r3 = r2.read(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0033, FileNotFoundException -> 0x0031, IOException -> 0x002f, all -> 0x002c }
            if (r3 <= 0) goto L_0x001e
            r4 = 0
            r1.update(r5, r4, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0033, FileNotFoundException -> 0x0031, IOException -> 0x002f, all -> 0x002c }
            goto L_0x0013
        L_0x001e:
            byte[] r5 = r1.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0033, FileNotFoundException -> 0x0031, IOException -> 0x002f, all -> 0x002c }
            java.lang.String r1 = ""
            java.lang.String r5 = toHexString(r5, r1, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0033, FileNotFoundException -> 0x0031, IOException -> 0x002f, all -> 0x002c }
            r2.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return r5
        L_0x002c:
            r5 = move-exception
            r0 = r2
            goto L_0x0036
        L_0x002f:
            goto L_0x003d
        L_0x0031:
            goto L_0x0044
        L_0x0033:
            goto L_0x0048
        L_0x0035:
            r5 = move-exception
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            throw r5
        L_0x003c:
            r2 = r0
        L_0x003d:
            if (r2 == 0) goto L_0x004b
        L_0x003f:
            r2.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004b
        L_0x0043:
            r2 = r0
        L_0x0044:
            if (r2 == 0) goto L_0x004b
            goto L_0x003f
        L_0x0047:
            r2 = r0
        L_0x0048:
            if (r2 == 0) goto L_0x004b
            goto L_0x003f
        L_0x004b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest4util.MD5Utils.toMd5(java.io.File, boolean):java.lang.String");
    }
}
