package org.apache.commons.codec.digest4util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
    public static final boolean DEBUG = false;
    public static final String ENCRYPT_MD5 = "MD5";
    public static final String ENCRYPT_SHA1 = "SHA-1";
    public static final String ENCRYPT_SHA256 = "SHA-256";
    public static final String ENCRYPT_SHA384 = "SHA-384";
    public static final String ENCRYPT_SHA512 = "SHA-512";
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;

    public static String encrypt(String str, byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.reset();
            instance.update(bArr);
            return toHexString(instance.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

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

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0042, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0046, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036 A[SYNTHETIC, Splitter:B:21:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encrypt(java.lang.String r4, java.io.File r5, boolean r6) {
        /*
            r0 = 0
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0045, FileNotFoundException -> 0x0041, IOException -> 0x003a, all -> 0x0033 }
            r4.reset()     // Catch:{ NoSuchAlgorithmException -> 0x0045, FileNotFoundException -> 0x0041, IOException -> 0x003a, all -> 0x0033 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0045, FileNotFoundException -> 0x0041, IOException -> 0x003a, all -> 0x0033 }
            r1.<init>(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0045, FileNotFoundException -> 0x0041, IOException -> 0x003a, all -> 0x0033 }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ NoSuchAlgorithmException -> 0x0031, FileNotFoundException -> 0x002f, IOException -> 0x002d, all -> 0x002a }
        L_0x0011:
            int r2 = r1.read(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0031, FileNotFoundException -> 0x002f, IOException -> 0x002d, all -> 0x002a }
            if (r2 <= 0) goto L_0x001c
            r3 = 0
            r4.update(r5, r3, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0031, FileNotFoundException -> 0x002f, IOException -> 0x002d, all -> 0x002a }
            goto L_0x0011
        L_0x001c:
            byte[] r4 = r4.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0031, FileNotFoundException -> 0x002f, IOException -> 0x002d, all -> 0x002a }
            java.lang.String r5 = ""
            java.lang.String r4 = toHexString(r4, r5, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0031, FileNotFoundException -> 0x002f, IOException -> 0x002d, all -> 0x002a }
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            return r4
        L_0x002a:
            r4 = move-exception
            r0 = r1
            goto L_0x0034
        L_0x002d:
            goto L_0x003b
        L_0x002f:
            goto L_0x0042
        L_0x0031:
            goto L_0x0046
        L_0x0033:
            r4 = move-exception
        L_0x0034:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            throw r4
        L_0x003a:
            r1 = r0
        L_0x003b:
            if (r1 == 0) goto L_0x0049
        L_0x003d:
            r1.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0049
        L_0x0041:
            r1 = r0
        L_0x0042:
            if (r1 == 0) goto L_0x0049
            goto L_0x003d
        L_0x0045:
            r1 = r0
        L_0x0046:
            if (r1 == 0) goto L_0x0049
            goto L_0x003d
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest4util.EncryptUtils.encrypt(java.lang.String, java.io.File, boolean):java.lang.String");
    }
}
