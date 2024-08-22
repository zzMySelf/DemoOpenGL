package com.baidu.sofire.xclient.privacycontrol.lib;

import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.util.Log;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import com.baidu.sofire.xclient.privacycontrol.a.b;
import com.baidu.sofire.xclient.privacycontrol.b.c;
import com.baidu.sofire.xclient.privacycontrol.b.d;

public class WifiInfoHelper {
    public static final b CONFIG_CALL_BACK = new b() {
        public void onConfigUpdate(String str, String str2) {
            if ("3".equals(str)) {
                c unused = WifiInfoHelper.sMacControlPolicy = com.baidu.sofire.xclient.privacycontrol.b.b.a(str2);
            }
        }
    };
    public static c sMacControlPolicy = c.a();

    public static b getConfigCallBack() {
        return CONFIG_CALL_BACK;
    }

    public static String getMac(WifiInfo wifiInfo) {
        long currentTimeMillis;
        final long[][] jArr;
        final int[] iArr = {2};
        try {
            if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
                "invoke wifoInfo.getMacAddress():" + Log.getStackTraceString(new Throwable());
            }
            currentTimeMillis = System.currentTimeMillis();
            jArr = new long[][]{null};
            try {
                d dVar = new d("mac");
                c cVar = sMacControlPolicy;
                com.baidu.sofire.xclient.privacycontrol.c.c cVar2 = new com.baidu.sofire.xclient.privacycontrol.c.c("mac", cVar);
                final WifiInfo wifiInfo2 = wifiInfo;
                AnonymousClass2 r0 = new d.a<String>() {
                    public String invokeDefaultMethod() {
                        iArr[0] = 3;
                        return "";
                    }

                    @SuppressLint({"MissingPermission", "HardwareIds"})
                    public String invokeOriginMethod() {
                        iArr[0] = 1;
                        return wifiInfo2.getMacAddress();
                    }

                    public void onProcessConsume(long[] jArr) {
                        jArr[0] = jArr;
                    }
                };
                dVar.f = cVar2;
                String str = (String) dVar.a((StackTraceElement[]) null, true, cVar, r0);
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sMacControlPolicy, 3, "mac", System.currentTimeMillis() - currentTimeMillis, jArr[0], str, iArr[0], Constant.LOCAL_CACHE_MAC_WIFI);
                return str;
            } catch (Throwable th2) {
                th = th2;
                WifiInfo wifiInfo3 = wifiInfo;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sMacControlPolicy, 3, "mac", System.currentTimeMillis() - currentTimeMillis, jArr[0], (String) null, iArr[0], Constant.LOCAL_CACHE_MAC_WIFI);
                throw th;
            }
        } catch (Throwable unused) {
            return iArr[0] == 1 ? "" : wifiInfo.getMacAddress();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ec A[Catch:{ all -> 0x00cc, all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ed A[Catch:{ all -> 0x00cc, all -> 0x00fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getMac(java.net.NetworkInterface r22) {
        /*
            r1 = r22
            java.lang.String r2 = ""
            java.lang.String r3 = "local_c_mc_net_"
            r4 = 1
            int[] r5 = new int[r4]
            r0 = 2
            r6 = 0
            r5[r6] = r0
            com.baidu.sofire.xclient.privacycontrol.PrvControlManager r0 = com.baidu.sofire.xclient.privacycontrol.PrvControlManager.getInstance()     // Catch:{ all -> 0x00fd }
            com.baidu.sofire.xclient.privacycontrol.PrivacyControlConfig r0 = r0.getPrivacyControlConfig()     // Catch:{ all -> 0x00fd }
            boolean r0 = r0.a     // Catch:{ all -> 0x00fd }
            if (r0 == 0) goto L_0x0032
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r0.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r7 = "invoke networkInterface.getHardwareAddress():"
            r0.append(r7)     // Catch:{ all -> 0x00fd }
            java.lang.Throwable r7 = new java.lang.Throwable     // Catch:{ all -> 0x00fd }
            r7.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)     // Catch:{ all -> 0x00fd }
            r0.append(r7)     // Catch:{ all -> 0x00fd }
            r0.toString()     // Catch:{ all -> 0x00fd }
        L_0x0032:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fd }
            long[][] r9 = new long[r4][]     // Catch:{ all -> 0x00fd }
            r10 = 0
            r9[r6] = r10     // Catch:{ all -> 0x00fd }
            com.baidu.sofire.xclient.privacycontrol.b.d r0 = new com.baidu.sofire.xclient.privacycontrol.b.d     // Catch:{ all -> 0x00d0 }
            java.lang.String r11 = "mac_net"
            r0.<init>(r11)     // Catch:{ all -> 0x00d0 }
            com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper$3 r11 = new com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper$3     // Catch:{ all -> 0x00d0 }
            r11.<init>(r5, r1, r9)     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x004b
            r12 = 1
            goto L_0x004c
        L_0x004b:
            r12 = 0
        L_0x004c:
            if (r12 == 0) goto L_0x0066
            java.lang.String r12 = r22.getName()     // Catch:{ all -> 0x00d0 }
            com.baidu.sofire.xclient.privacycontrol.c.d r13 = new com.baidu.sofire.xclient.privacycontrol.c.d     // Catch:{ all -> 0x0060 }
            com.baidu.sofire.xclient.privacycontrol.b.c r14 = sMacControlPolicy     // Catch:{ all -> 0x0060 }
            r13.<init>(r12, r14)     // Catch:{ all -> 0x0060 }
            r0.f = r13     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.a(r10, r4, r14, r11)     // Catch:{ all -> 0x0060 }
            goto L_0x006d
        L_0x0060:
            r0 = move-exception
            r17 = r10
        L_0x0063:
            r10 = r12
            goto L_0x00d3
        L_0x0066:
            com.baidu.sofire.xclient.privacycontrol.b.c r12 = sMacControlPolicy     // Catch:{ all -> 0x00d0 }
            java.lang.Object r0 = r0.a(r10, r6, r12, r11)     // Catch:{ all -> 0x00d0 }
            r12 = r10
        L_0x006d:
            r11 = r0
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0060 }
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x00a0
            byte[] r0 = new byte[r6]     // Catch:{ all -> 0x00cc }
            r18 = r9[r6]     // Catch:{ all -> 0x00fd }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fd }
            com.baidu.sofire.xclient.privacycontrol.b.c r13 = sMacControlPolicy     // Catch:{ all -> 0x00fd }
            r14 = 3
            java.lang.String r15 = "mac_net"
            long r16 = r9 - r7
            r20 = r5[r6]     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r7.<init>()     // Catch:{ all -> 0x00fd }
            r7.append(r3)     // Catch:{ all -> 0x00fd }
            if (r12 != 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r2 = r12
        L_0x0093:
            r7.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r21 = r7.toString()     // Catch:{ all -> 0x00fd }
            r19 = r11
            com.baidu.sofire.xclient.privacycontrol.b.b.a(r13, r14, r15, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x00fd }
            return r0
        L_0x00a0:
            byte[] r0 = android.util.Base64.decode(r11, r6)     // Catch:{ all -> 0x00cc }
            r18 = r9[r6]     // Catch:{ all -> 0x00fd }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fd }
            com.baidu.sofire.xclient.privacycontrol.b.c r13 = sMacControlPolicy     // Catch:{ all -> 0x00fd }
            r14 = 3
            java.lang.String r15 = "mac_net"
            long r16 = r9 - r7
            r20 = r5[r6]     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r7.<init>()     // Catch:{ all -> 0x00fd }
            r7.append(r3)     // Catch:{ all -> 0x00fd }
            if (r12 != 0) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r2 = r12
        L_0x00bf:
            r7.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r21 = r7.toString()     // Catch:{ all -> 0x00fd }
            r19 = r11
            com.baidu.sofire.xclient.privacycontrol.b.b.a(r13, r14, r15, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x00fd }
            return r0
        L_0x00cc:
            r0 = move-exception
            r17 = r11
            goto L_0x0063
        L_0x00d0:
            r0 = move-exception
            r17 = r10
        L_0x00d3:
            r16 = r9[r6]     // Catch:{ all -> 0x00fd }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fd }
            com.baidu.sofire.xclient.privacycontrol.b.c r9 = sMacControlPolicy     // Catch:{ all -> 0x00fd }
            r13 = 3
            java.lang.String r14 = "mac_net"
            long r7 = r11 - r7
            r18 = r5[r6]     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r11.<init>()     // Catch:{ all -> 0x00fd }
            r11.append(r3)     // Catch:{ all -> 0x00fd }
            if (r10 != 0) goto L_0x00ed
            goto L_0x00ee
        L_0x00ed:
            r2 = r10
        L_0x00ee:
            r11.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r19 = r11.toString()     // Catch:{ all -> 0x00fd }
            r11 = r9
            r12 = r13
            r13 = r14
            r14 = r7
            com.baidu.sofire.xclient.privacycontrol.b.b.a(r11, r12, r13, r14, r16, r17, r18, r19)     // Catch:{ all -> 0x00fd }
            throw r0     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r0 = r5[r6]
            if (r0 != r4) goto L_0x0104
            byte[] r0 = new byte[r6]
            return r0
        L_0x0104:
            byte[] r0 = r22.getHardwareAddress()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper.getMac(java.net.NetworkInterface):byte[]");
    }
}
