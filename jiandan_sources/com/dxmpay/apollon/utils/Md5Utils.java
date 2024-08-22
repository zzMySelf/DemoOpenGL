package com.dxmpay.apollon.utils;

import android.annotation.SuppressLint;
import com.dxmpay.wallet.core.NoProguard;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Md5Utils implements NoProguard {
    public static final String TAG = "Md5Utils";
    public static char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String bytesToHexString(byte[] bArr, Character ch) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * (ch == null ? 2 : 3));
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] >>> 4) & 15;
            byte b = bArr[i2] & Ascii.SI;
            if (i2 > 0 && ch != null) {
                stringBuffer.append(ch.charValue());
            }
            stringBuffer.append(hexChars[i3]);
            stringBuffer.append(hexChars[b]);
        }
        return stringBuffer.toString();
    }

    public static synchronized String encrypt(byte[] bArr) {
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
                LogUtil.e(TAG, e.getMessage(), e);
                return null;
            }
        }
        return sb;
    }

    public static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a A[SYNTHETIC, Splitter:B:25:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0059 A[SYNTHETIC, Splitter:B:32:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005f A[SYNTHETIC, Splitter:B:36:0x005f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0050=Splitter:B:29:0x0050, B:22:0x0041=Splitter:B:22:0x0041} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMd5FromFile(java.lang.String r6) {
        /*
            java.lang.String r0 = "Md5Utils"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x006c
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x003f, all -> 0x003d }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x003f, all -> 0x003d }
            java.security.MessageDigest r6 = getDigest()     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0039 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0039 }
        L_0x0016:
            int r4 = r2.read(r3)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0039 }
            if (r4 <= 0) goto L_0x0021
            r5 = 0
            r6.update(r3, r5, r4)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0039 }
            goto L_0x0016
        L_0x0021:
            byte[] r6 = r6.digest()     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0039 }
            java.lang.String r1 = md5Hex((byte[]) r6)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0039 }
            r2.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x005c
        L_0x002d:
            r6 = move-exception
            java.lang.String r2 = r6.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r2, r6)
            goto L_0x005c
        L_0x0036:
            r6 = move-exception
            r1 = r2
            goto L_0x005d
        L_0x0039:
            r6 = move-exception
            goto L_0x0041
        L_0x003b:
            r6 = move-exception
            goto L_0x0050
        L_0x003d:
            r6 = move-exception
            goto L_0x005d
        L_0x003f:
            r6 = move-exception
            r2 = r1
        L_0x0041:
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x0036 }
            com.dxmpay.apollon.utils.LogUtil.e(r0, r3, r6)     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x005c
        L_0x004e:
            r6 = move-exception
            r2 = r1
        L_0x0050:
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x0036 }
            com.dxmpay.apollon.utils.LogUtil.e(r0, r3, r6)     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ IOException -> 0x002d }
        L_0x005c:
            return r1
        L_0x005d:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006b
        L_0x0063:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r2, r1)
        L_0x006b:
            throw r6
        L_0x006c:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "file path is empty"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.Md5Utils.getMd5FromFile(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[SYNTHETIC, Splitter:B:21:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[SYNTHETIC, Splitter:B:27:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMd5FromFileV2(java.lang.String r6) {
        /*
            java.lang.String r0 = "Md5Utils"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x006d
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0045 }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0045 }
            java.lang.String r1 = getMd5FromInputStream(r2)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            java.lang.String r4 = "downDxmLivenessSoAndModel下载文件路径="
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            r3.append(r6)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            java.lang.String r6 = "/Md5="
            r3.append(r6)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            java.lang.String r6 = r3.toString()     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            com.dxmpay.apollon.utils.LogUtil.errord(r6)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x003b }
            r2.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x005d
        L_0x0032:
            r6 = move-exception
            java.lang.String r2 = r6.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r2, r6)
            goto L_0x005d
        L_0x003b:
            r6 = move-exception
            r1 = r2
            goto L_0x005e
        L_0x003e:
            r6 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0047
        L_0x0043:
            r6 = move-exception
            goto L_0x005e
        L_0x0045:
            r6 = move-exception
            r2 = r1
        L_0x0047:
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x0043 }
            com.dxmpay.apollon.utils.LogUtil.e(r0, r3, r6)     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x005c
        L_0x0054:
            r6 = move-exception
            java.lang.String r1 = r6.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r1, r6)
        L_0x005c:
            r1 = r2
        L_0x005d:
            return r1
        L_0x005e:
            if (r1 == 0) goto L_0x006c
            r1.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r2, r1)
        L_0x006c:
            throw r6
        L_0x006d:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "file path is empty"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.Md5Utils.getMd5FromFileV2(java.lang.String):java.lang.String");
    }

    public static String getMd5FromInputStream(InputStream inputStream) {
        int i2;
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest digest = getDigest();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                digest.update(bArr, 0, read);
            }
            for (byte b : digest.digest()) {
                sb.append(Integer.toHexString((b & 255) | -256).substring(6));
            }
        } catch (IOException e) {
            LogUtil.e(TAG, e.getMessage(), e);
        }
        return sb.toString();
    }

    public static byte[] md5(byte[] bArr) {
        return getDigest().digest(bArr);
    }

    public static String md5Hex(byte[] bArr) {
        return bytesToHexString(md5(bArr), (Character) null);
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

    public static String toMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return encrypt(str.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return null;
        }
    }

    public static String toMD5NoEncode(String str) {
        if (str != null) {
            return encrypt(str.getBytes());
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String toMD5UCS2(String str) {
        if (str == null) {
            return null;
        }
        try {
            return encrypt(new String(str.getBytes("GBK"), "GBK").getBytes("UTF-16LE"));
        } catch (UnsupportedEncodingException e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return null;
        }
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

    public static byte[] md5(String str) {
        return md5(str.getBytes());
    }

    public static String md5Hex(String str) {
        return bytesToHexString(md5(str), (Character) null);
    }

    public static String toMD5(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return encrypt(str.getBytes(str2));
        } catch (UnsupportedEncodingException e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return null;
        }
    }
}
