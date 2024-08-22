package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Md5Utils {
    public static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static synchronized String a(byte[] bArr) {
        String sb;
        synchronized (Md5Utils.class) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                byte[] digest = instance.digest();
                StringBuilder sb2 = new StringBuilder();
                for (byte b : digest) {
                    sb2.append(Integer.toHexString((b & 255) | -256).substring(6));
                }
                sb = sb2.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
        return sb;
    }

    public static byte[] b(byte[] bArr) {
        return a().digest(bArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[SYNTHETIC, Splitter:B:23:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0048 A[SYNTHETIC, Splitter:B:30:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0050 A[SYNTHETIC, Splitter:B:36:0x0050] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0043=Splitter:B:27:0x0043, B:20:0x0038=Splitter:B:20:0x0038} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMd5FromFile(java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0059
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x0036, all -> 0x0034 }
            r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x0036, all -> 0x0034 }
            java.security.MessageDigest r5 = a()     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030 }
        L_0x0014:
            int r3 = r1.read(r2)     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030 }
            if (r3 <= 0) goto L_0x001f
            r4 = 0
            r5.update(r2, r4, r3)     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030 }
            goto L_0x0014
        L_0x001f:
            byte[] r5 = r5.digest()     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030 }
            java.lang.String r0 = md5Hex((byte[]) r5)     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030 }
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x004b
        L_0x002b:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x004b
        L_0x0030:
            r5 = move-exception
            goto L_0x0038
        L_0x0032:
            r5 = move-exception
            goto L_0x0043
        L_0x0034:
            r5 = move-exception
            goto L_0x004e
        L_0x0036:
            r5 = move-exception
            r1 = r0
        L_0x0038:
            r5.printStackTrace()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x004b
        L_0x0041:
            r5 = move-exception
            r1 = r0
        L_0x0043:
            r5.printStackTrace()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ IOException -> 0x002b }
        L_0x004b:
            return r0
        L_0x004c:
            r5 = move-exception
            r0 = r1
        L_0x004e:
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0058:
            throw r5
        L_0x0059:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "file path is empty"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.Md5Utils.getMd5FromFile(java.lang.String):java.lang.String");
    }

    public static String md5Hex(byte[] bArr) {
        return a(b(bArr), (Character) null);
    }

    public static String toMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(str.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toMD5NoEncode(String str) {
        if (str != null) {
            return a(str.getBytes());
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String toMD5UCS2(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new String(str.getBytes("GBK"), "GBK").getBytes("UTF-16LE"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String md5Hex(String str) {
        return a(a(str), (Character) null);
    }

    public static String toMD5(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return a(str.getBytes(str2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MessageDigest a() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] a(String str) {
        return b(str.getBytes());
    }

    public static String a(byte[] bArr, Character ch) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * (ch == null ? 2 : 3));
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] >>> 4) & 15;
            byte b = bArr[i2] & Ascii.SI;
            if (i2 > 0 && ch != null) {
                stringBuffer.append(ch.charValue());
            }
            stringBuffer.append(a[i3]);
            stringBuffer.append(a[b]);
        }
        return stringBuffer.toString();
    }
}
