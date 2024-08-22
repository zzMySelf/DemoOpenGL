package com.baidu.wallet.utils;

import com.google.common.base.Ascii;

public class a {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f A[SYNTHETIC, Splitter:B:24:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004a A[SYNTHETIC, Splitter:B:31:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0055 A[SYNTHETIC, Splitter:B:38:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005d A[SYNTHETIC, Splitter:B:44:0x005d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0050=Splitter:B:35:0x0050, B:28:0x0045=Splitter:B:28:0x0045, B:21:0x003a=Splitter:B:21:0x003a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r4, java.lang.String r5) {
        /*
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x0066
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, NoSuchAlgorithmException -> 0x0038, all -> 0x0036 }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0043, NoSuchAlgorithmException -> 0x0038, all -> 0x0036 }
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r5)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x0030 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x0030 }
        L_0x0014:
            int r2 = r1.read(r5)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x0030 }
            if (r2 <= 0) goto L_0x001f
            r3 = 0
            r4.update(r5, r3, r2)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x0030 }
            goto L_0x0014
        L_0x001f:
            byte[] r4 = r4.digest()     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x0030 }
            java.lang.String r0 = a((byte[]) r4, (java.lang.Character) r0)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032, NoSuchAlgorithmException -> 0x0030 }
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0058
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0058
        L_0x0030:
            r4 = move-exception
            goto L_0x003a
        L_0x0032:
            r4 = move-exception
            goto L_0x0045
        L_0x0034:
            r4 = move-exception
            goto L_0x0050
        L_0x0036:
            r4 = move-exception
            goto L_0x005b
        L_0x0038:
            r4 = move-exception
            r1 = r0
        L_0x003a:
            r4.printStackTrace()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0058
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0058
        L_0x0043:
            r4 = move-exception
            r1 = r0
        L_0x0045:
            r4.printStackTrace()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0058
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0058
        L_0x004e:
            r4 = move-exception
            r1 = r0
        L_0x0050:
            r4.printStackTrace()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0058
            r1.close()     // Catch:{ IOException -> 0x002b }
        L_0x0058:
            return r0
        L_0x0059:
            r4 = move-exception
            r0 = r1
        L_0x005b:
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0065:
            throw r4
        L_0x0066:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "file is not exists"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.utils.a.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr, Character ch) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * (ch == null ? 2 : 3));
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] >>> 4) & 15;
            byte b = bArr[i2] & Ascii.SI;
            if (i2 > 0 && ch != null) {
                stringBuffer.append(ch);
            }
            stringBuffer.append(cArr[i3]);
            stringBuffer.append(cArr[b]);
        }
        return stringBuffer.toString();
    }
}
