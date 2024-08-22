package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;

public class SapiDeviceUtils {
    public static String mImei;

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[SYNTHETIC, Splitter:B:27:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkHosts(android.content.Context r6) {
        /*
            java.lang.String r0 = "SAPI"
            r1 = 0
            if (r6 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r6 = 0
            r2 = 1
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x004f }
            java.lang.String r4 = "/system/etc/hosts"
            r3.<init>(r4)     // Catch:{ all -> 0x004f }
            int r6 = r3.available()     // Catch:{ all -> 0x004d }
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x004d }
            r3.read(r6)     // Catch:{ all -> 0x004d }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x004d }
            r4.<init>(r6)     // Catch:{ all -> 0x004d }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x004d }
            if (r6 != 0) goto L_0x003c
            java.lang.String r6 = "passport.baidu.com"
            boolean r6 = r4.contains(r6)     // Catch:{ all -> 0x004d }
            if (r6 == 0) goto L_0x003c
            r3.close()     // Catch:{ Exception -> 0x002f }
            goto L_0x003b
        L_0x002f:
            r6 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r6 = r6.toString()
            r3[r1] = r6
            com.baidu.sapi2.utils.Log.e((java.lang.String) r0, (java.lang.Object[]) r3)
        L_0x003b:
            return r2
        L_0x003c:
            r3.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x004c
        L_0x0040:
            r6 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r6 = r6.toString()
            r2[r1] = r6
            com.baidu.sapi2.utils.Log.e((java.lang.String) r0, (java.lang.Object[]) r2)
        L_0x004c:
            return r1
        L_0x004d:
            r6 = move-exception
            goto L_0x0053
        L_0x004f:
            r3 = move-exception
            r5 = r3
            r3 = r6
            r6 = r5
        L_0x0053:
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0071 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0071 }
            r4[r1] = r6     // Catch:{ all -> 0x0071 }
            com.baidu.sapi2.utils.Log.e((java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0070
            r3.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0070
        L_0x0064:
            r6 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r6 = r6.toString()
            r2[r1] = r6
            com.baidu.sapi2.utils.Log.e((java.lang.String) r0, (java.lang.Object[]) r2)
        L_0x0070:
            return r1
        L_0x0071:
            r6 = move-exception
            if (r3 == 0) goto L_0x0084
            r3.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x0084
        L_0x0078:
            r3 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r3.toString()
            r2[r1] = r3
            com.baidu.sapi2.utils.Log.e((java.lang.String) r0, (java.lang.Object[]) r2)
        L_0x0084:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.SapiDeviceUtils.checkHosts(android.content.Context):boolean");
    }

    public static String getBrandName() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMEI(Context context) {
        return "";
    }

    public static boolean isForbidDangerousPermissionApp(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("com.baidu.(.*)input(.*)");
        String packageName = context.getPackageName();
        for (String matches : arrayList) {
            if (packageName.matches(matches)) {
                return true;
            }
        }
        return false;
    }
}
