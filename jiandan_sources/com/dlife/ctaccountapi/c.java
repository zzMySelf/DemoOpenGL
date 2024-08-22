package com.dlife.ctaccountapi;

import android.content.Context;
import java.io.File;

public class c {
    public static File a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File file = new File(context.getFilesDir() + "/eAccount/Log/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "ipa_ol.ds");
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str) {
        File b = b(context);
        if (b == null || !b.exists()) {
            a(a(context), str);
        } else {
            a(b, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0043 A[SYNTHETIC, Splitter:B:32:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0059 A[SYNTHETIC, Splitter:B:43:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0063 A[SYNTHETIC, Splitter:B:48:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.File r3, java.lang.String r4) {
        /*
            if (r3 == 0) goto L_0x006c
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x006c
            r0 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            r2 = 0
            r1.<init>(r3, r2)     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0034, all -> 0x0031 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0034, all -> 0x0031 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            if (r0 == 0) goto L_0x001c
            java.lang.String r4 = ""
        L_0x001c:
            r3.write(r4)     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            r3.flush()     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            r3.close()     // Catch:{ Exception -> 0x0026 }
            goto L_0x004d
        L_0x0026:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x004d
        L_0x002b:
            r4 = move-exception
            r0 = r3
            goto L_0x0057
        L_0x002e:
            r4 = move-exception
            r0 = r3
            goto L_0x003e
        L_0x0031:
            r3 = move-exception
            r4 = r3
            goto L_0x0057
        L_0x0034:
            r3 = move-exception
            r4 = r3
            goto L_0x003e
        L_0x0037:
            r3 = move-exception
            r4 = r3
            r1 = r0
            goto L_0x0057
        L_0x003b:
            r3 = move-exception
            r4 = r3
            r1 = r0
        L_0x003e:
            r4.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x004b
            r0.close()     // Catch:{ Exception -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r3 = move-exception
            r3.printStackTrace()
        L_0x004b:
            if (r1 == 0) goto L_0x006c
        L_0x004d:
            r1.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x006c
        L_0x0051:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x006c
        L_0x0056:
            r4 = move-exception
        L_0x0057:
            if (r0 == 0) goto L_0x0061
            r0.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0061:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ Exception -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r3 = move-exception
            r3.printStackTrace()
        L_0x006b:
            throw r4
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.c.a(java.io.File, java.lang.String):void");
    }

    public static File b(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir() + "/eAccount/Log/");
                if (!file.exists()) {
                    return null;
                }
                File file2 = new File(file, "ipa_ol.ds");
                if (!file2.exists()) {
                    return null;
                }
                return file2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0056 A[SYNTHETIC, Splitter:B:35:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0060 A[SYNTHETIC, Splitter:B:40:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r5) {
        /*
            java.io.File r5 = b(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r5 == 0) goto L_0x0098
            boolean r1 = r5.exists()
            if (r1 != 0) goto L_0x0013
            goto L_0x0098
        L_0x0013:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004e }
            r2.<init>(r5)     // Catch:{ all -> 0x004e }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x004a }
            r5.<init>(r2)     // Catch:{ all -> 0x004a }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0044 }
            r3.<init>(r5)     // Catch:{ all -> 0x0044 }
        L_0x0023:
            java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x002d
            r0.append(r1)     // Catch:{ all -> 0x003e }
            goto L_0x0023
        L_0x002d:
            r3.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0035:
            r5.close()     // Catch:{ Exception -> 0x0039 }
            goto L_0x006b
        L_0x0039:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x006b
        L_0x003e:
            r1 = move-exception
            r4 = r2
            r2 = r5
            r5 = r1
            r1 = r3
            goto L_0x0048
        L_0x0044:
            r3 = move-exception
            r4 = r2
            r2 = r5
            r5 = r3
        L_0x0048:
            r3 = r4
            goto L_0x0051
        L_0x004a:
            r5 = move-exception
            r3 = r2
            r2 = r1
            goto L_0x0051
        L_0x004e:
            r5 = move-exception
            r2 = r1
            r3 = r2
        L_0x0051:
            r5.printStackTrace()     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ Exception -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005e:
            if (r2 == 0) goto L_0x0068
            r2.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0068:
            if (r3 == 0) goto L_0x0073
            r2 = r3
        L_0x006b:
            r2.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0073:
            java.lang.String r5 = r0.toString()
            return r5
        L_0x0078:
            r5 = move-exception
            if (r1 == 0) goto L_0x0083
            r1.close()     // Catch:{ Exception -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0083:
            if (r2 == 0) goto L_0x008d
            r2.close()     // Catch:{ Exception -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r0 = move-exception
            r0.printStackTrace()
        L_0x008d:
            if (r3 == 0) goto L_0x0097
            r3.close()     // Catch:{ Exception -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0097:
            throw r5
        L_0x0098:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.c.c(android.content.Context):java.lang.String");
    }
}
