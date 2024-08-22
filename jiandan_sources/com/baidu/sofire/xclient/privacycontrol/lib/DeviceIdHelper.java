package com.baidu.sofire.xclient.privacycontrol.lib;

import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import com.baidu.sofire.xclient.privacycontrol.a.b;
import com.baidu.sofire.xclient.privacycontrol.b.c;
import com.baidu.sofire.xclient.privacycontrol.b.d;

public class DeviceIdHelper {
    public static final b CONFIG_CALL_BACK = new b() {
        public void onConfigUpdate(String str, String str2) {
            if ("2".equals(str)) {
                c unused = DeviceIdHelper.sAndroidControlPolicy = com.baidu.sofire.xclient.privacycontrol.b.b.a(str2);
            }
        }
    };
    public static c sAndroidControlPolicy = c.a();

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAndroidIdFromSettingSecure(android.content.ContentResolver r22, java.lang.String r23) {
        /*
            java.lang.String r0 = "secure_android_id"
            r1 = 1
            int[] r2 = new int[r1]
            r3 = 2
            r4 = 0
            r2[r4] = r3
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0048 }
            long[][] r3 = new long[r1][]     // Catch:{ all -> 0x0048 }
            r7 = 0
            r3[r4] = r7     // Catch:{ all -> 0x0048 }
            com.baidu.sofire.xclient.privacycontrol.b.d r8 = new com.baidu.sofire.xclient.privacycontrol.b.d     // Catch:{ all -> 0x0048 }
            r8.<init>(r0)     // Catch:{ all -> 0x0048 }
            com.baidu.sofire.xclient.privacycontrol.c.c r9 = new com.baidu.sofire.xclient.privacycontrol.c.c     // Catch:{ all -> 0x0048 }
            com.baidu.sofire.xclient.privacycontrol.b.c r10 = sAndroidControlPolicy     // Catch:{ all -> 0x0048 }
            r9.<init>(r0, r10)     // Catch:{ all -> 0x0048 }
            com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper$3 r0 = new com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper$3     // Catch:{ all -> 0x0048 }
            r11 = r22
            r12 = r23
            r0.<init>(r2, r11, r12, r3)     // Catch:{ all -> 0x0046 }
            r8.f = r9     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r8.a(r7, r1, r10, r0)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0046 }
            r18 = r3[r4]     // Catch:{ all -> 0x0046 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0046 }
            com.baidu.sofire.xclient.privacycontrol.b.c r13 = sAndroidControlPolicy     // Catch:{ all -> 0x0046 }
            r14 = 2
            java.lang.String r15 = "secure_android_id"
            long r16 = r7 - r5
            r20 = r2[r4]     // Catch:{ all -> 0x0046 }
            java.lang.String r21 = "local_c_andid"
            r19 = r0
            com.baidu.sofire.xclient.privacycontrol.b.b.a(r13, r14, r15, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x0046 }
            return r0
        L_0x0046:
            goto L_0x004c
        L_0x0048:
            r11 = r22
            r12 = r23
        L_0x004c:
            r0 = r2[r4]
            if (r0 != r1) goto L_0x0053
            java.lang.String r0 = ""
            return r0
        L_0x0053:
            java.lang.String r0 = android.provider.Settings.Secure.getString(r22, r23)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper.getAndroidIdFromSettingSecure(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    public static String getAndroidIdFromSettingSystem(ContentResolver contentResolver, String str) {
        final int[] iArr = {2};
        try {
            long currentTimeMillis = System.currentTimeMillis();
            final long[][] jArr = {null};
            d dVar = new d("setting_android_id");
            c cVar = sAndroidControlPolicy;
            com.baidu.sofire.xclient.privacycontrol.c.c cVar2 = new com.baidu.sofire.xclient.privacycontrol.c.c("setting_android_id", cVar);
            final ContentResolver contentResolver2 = contentResolver;
            final String str2 = str;
            try {
                AnonymousClass2 r0 = new d.a<String>() {
                    public String invokeDefaultMethod() {
                        iArr[0] = 3;
                        return "";
                    }

                    public String invokeOriginMethod() {
                        iArr[0] = 1;
                        return Settings.System.getString(contentResolver2, str2);
                    }

                    public void onProcessConsume(long[] jArr) {
                        jArr[0] = jArr;
                    }
                };
                dVar.f = cVar2;
                String str3 = (String) dVar.a((StackTraceElement[]) null, true, cVar, r0);
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sAndroidControlPolicy, 2, "setting_android_id", System.currentTimeMillis() - currentTimeMillis, jArr[0], str3, iArr[0], Constant.LOCAL_CACHE_ANDROID_ID);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            ContentResolver contentResolver3 = contentResolver;
            String str4 = str;
        }
        return iArr[0] == 1 ? "" : Settings.System.getString(contentResolver, str);
    }

    public static b getConfigCallBack() {
        return CONFIG_CALL_BACK;
    }

    public static String getStringFromSettingSecure(ContentResolver contentResolver, String str) {
        if (!"android_id".equals(str)) {
            return Settings.Secure.getString(contentResolver, str);
        }
        if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
            "invoke Settings.Secure.getString androidId:" + Log.getStackTraceString(new Throwable());
        }
        return getAndroidIdFromSettingSecure(contentResolver, str);
    }

    public static String getStringFromSettingSystem(ContentResolver contentResolver, String str) {
        if (!"android_id".equals(str)) {
            return Settings.System.getString(contentResolver, str);
        }
        if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
            "invoke Settings.System.getString androidId:" + Log.getStackTraceString(new Throwable());
        }
        return getAndroidIdFromSettingSystem(contentResolver, str);
    }
}
