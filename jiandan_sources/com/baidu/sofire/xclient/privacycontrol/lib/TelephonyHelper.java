package com.baidu.sofire.xclient.privacycontrol.lib;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import com.baidu.sofire.xclient.privacycontrol.a.b;
import com.baidu.sofire.xclient.privacycontrol.b.c;
import com.baidu.sofire.xclient.privacycontrol.b.d;
import com.baidu.sofire.xclient.privacycontrol.c.f;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;

public class TelephonyHelper {
    public static final b CONFIG_CALL_BACK = new b() {
        public void onConfigUpdate(String str, String str2) {
            if ("1".equals(str)) {
                c unused = TelephonyHelper.sImeiControlPolicy = com.baidu.sofire.xclient.privacycontrol.b.b.a(str2);
            } else if (BannerBaseItemInfo.TYPE_LOGIN.equals(str)) {
                c unused2 = TelephonyHelper.sImsiControlPolicy = com.baidu.sofire.xclient.privacycontrol.b.b.a(str2);
            }
        }
    };
    public static c sImeiControlPolicy = c.a();
    public static c sImsiControlPolicy = c.a();

    public static b getConfigCallBack() {
        return CONFIG_CALL_BACK;
    }

    @SuppressLint({"MissingPermission"})
    public static String getDeviceId(TelephonyManager telephonyManager) {
        long currentTimeMillis;
        final long[][] jArr;
        final int[] iArr = {2};
        try {
            if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
                "invoke telephonyManager.getDeviceId:" + Log.getStackTraceString(new Throwable());
            }
            currentTimeMillis = System.currentTimeMillis();
            jArr = new long[][]{null};
            try {
                d dVar = new d("device_id");
                c cVar = sImeiControlPolicy;
                com.baidu.sofire.xclient.privacycontrol.c.c cVar2 = new com.baidu.sofire.xclient.privacycontrol.c.c("device_id", cVar);
                final TelephonyManager telephonyManager2 = telephonyManager;
                AnonymousClass5 r0 = new d.a<String>() {
                    public String invokeDefaultMethod() {
                        iArr[0] = 3;
                        return "";
                    }

                    public String invokeOriginMethod() {
                        iArr[0] = 1;
                        return telephonyManager2.getDeviceId();
                    }

                    public void onProcessConsume(long[] jArr) {
                        jArr[0] = jArr;
                    }
                };
                dVar.f = cVar2;
                String str = (String) dVar.a((StackTraceElement[]) null, true, cVar, r0);
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sImeiControlPolicy, 1, "device_id", System.currentTimeMillis() - currentTimeMillis, jArr[0], str, iArr[0], Constant.LOCAL_CACHE_DEVICE_ID);
                return str;
            } catch (Throwable th2) {
                th = th2;
                TelephonyManager telephonyManager3 = telephonyManager;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sImeiControlPolicy, 1, "device_id", System.currentTimeMillis() - currentTimeMillis, jArr[0], (String) null, iArr[0], Constant.LOCAL_CACHE_DEVICE_ID);
                throw th;
            }
        } catch (Throwable unused) {
            return iArr[0] == 1 ? "" : telephonyManager.getDeviceId();
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getImei(TelephonyManager telephonyManager) {
        long currentTimeMillis;
        final long[][] jArr;
        final int[] iArr = {2};
        try {
            if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
                "invoke telephonyManager.getImei:" + Log.getStackTraceString(new Throwable());
            }
            currentTimeMillis = System.currentTimeMillis();
            jArr = new long[][]{null};
            try {
                d dVar = new d("imei");
                c cVar = sImeiControlPolicy;
                com.baidu.sofire.xclient.privacycontrol.c.c cVar2 = new com.baidu.sofire.xclient.privacycontrol.c.c("imei", cVar);
                final TelephonyManager telephonyManager2 = telephonyManager;
                AnonymousClass4 r0 = new d.a<String>() {
                    public String invokeDefaultMethod() {
                        iArr[0] = 3;
                        return "";
                    }

                    public String invokeOriginMethod() {
                        iArr[0] = 1;
                        return telephonyManager2.getImei();
                    }

                    public void onProcessConsume(long[] jArr) {
                        jArr[0] = jArr;
                    }
                };
                dVar.f = cVar2;
                String str = (String) dVar.a((StackTraceElement[]) null, true, cVar, r0);
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sImeiControlPolicy, 1, "imei", System.currentTimeMillis() - currentTimeMillis, jArr[0], str, iArr[0], Constant.LOCAL_CACHE_IMEI);
                return str;
            } catch (Throwable th2) {
                th = th2;
                TelephonyManager telephonyManager3 = telephonyManager;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sImeiControlPolicy, 1, "imei", System.currentTimeMillis() - currentTimeMillis, jArr[0], (String) null, iArr[0], Constant.LOCAL_CACHE_IMEI);
                throw th;
            }
        } catch (Throwable unused) {
            return iArr[0] == 1 ? "" : telephonyManager.getImei();
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getImsi(TelephonyManager telephonyManager) {
        long currentTimeMillis;
        final long[][] jArr;
        final int[] iArr = {2};
        try {
            if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
                "invoke telephonyManager.getSubscriberId:" + Log.getStackTraceString(new Throwable());
            }
            currentTimeMillis = System.currentTimeMillis();
            jArr = new long[][]{null};
            try {
                d dVar = new d("imsi");
                c cVar = sImsiControlPolicy;
                com.baidu.sofire.xclient.privacycontrol.c.c cVar2 = new com.baidu.sofire.xclient.privacycontrol.c.c("imsi", cVar);
                final TelephonyManager telephonyManager2 = telephonyManager;
                AnonymousClass6 r0 = new d.a<String>() {
                    public String invokeDefaultMethod() {
                        iArr[0] = 3;
                        return "";
                    }

                    @SuppressLint({"HardwareIds"})
                    public String invokeOriginMethod() {
                        iArr[0] = 1;
                        return telephonyManager2.getSubscriberId();
                    }

                    public void onProcessConsume(long[] jArr) {
                        jArr[0] = jArr;
                    }
                };
                dVar.f = cVar2;
                String str = (String) dVar.a((StackTraceElement[]) null, true, cVar, r0);
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sImsiControlPolicy, 5, "imsi", System.currentTimeMillis() - currentTimeMillis, jArr[0], str, iArr[0], Constant.LOCAL_CACHE_IMSI);
                return str;
            } catch (Throwable th2) {
                th = th2;
                TelephonyManager telephonyManager3 = telephonyManager;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(sImsiControlPolicy, 5, "imsi", System.currentTimeMillis() - currentTimeMillis, jArr[0], (String) null, iArr[0], Constant.LOCAL_CACHE_IMSI);
                throw th;
            }
        } catch (Throwable unused) {
            return iArr[0] == 1 ? "" : telephonyManager.getSubscriberId();
        }
    }

    public static String getDeviceId(TelephonyManager telephonyManager, int i2) {
        long currentTimeMillis;
        final long[][] jArr;
        final int i3 = i2;
        final int[] iArr = {2};
        try {
            if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
                "invoke telephonyManager.getDeviceId(index):" + Log.getStackTraceString(new Throwable());
            }
            currentTimeMillis = System.currentTimeMillis();
            jArr = new long[][]{null};
            try {
                d dVar = new d("device_id_index");
                c cVar = sImeiControlPolicy;
                com.baidu.sofire.xclient.privacycontrol.c.b bVar = new com.baidu.sofire.xclient.privacycontrol.c.b(cVar, i3);
                final TelephonyManager telephonyManager2 = telephonyManager;
                AnonymousClass3 r12 = new d.a<String>() {
                    public String invokeDefaultMethod() {
                        iArr[0] = 3;
                        return "";
                    }

                    @SuppressLint({"MissingPermission"})
                    public String invokeOriginMethod() {
                        iArr[0] = 1;
                        return telephonyManager2.getDeviceId(i3);
                    }

                    public void onProcessConsume(long[] jArr) {
                        jArr[0] = jArr;
                    }
                };
                dVar.f = bVar;
                String str = (String) dVar.a((StackTraceElement[]) null, true, cVar, r12);
                long[] jArr2 = jArr[0];
                long currentTimeMillis2 = System.currentTimeMillis();
                c cVar2 = sImeiControlPolicy;
                long j = currentTimeMillis2 - currentTimeMillis;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(cVar2, 1, "device_id_index", j, jArr2, str, iArr[0], Constant.LOCAL_CACHE_DEVICE_ID_INDEX + i3);
                return str;
            } catch (Throwable th2) {
                th = th2;
                TelephonyManager telephonyManager3 = telephonyManager;
                long[] jArr3 = jArr[0];
                long currentTimeMillis3 = System.currentTimeMillis();
                c cVar3 = sImeiControlPolicy;
                long j2 = currentTimeMillis3 - currentTimeMillis;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(cVar3, 1, "device_id_index", j2, jArr3, (String) null, iArr[0], Constant.LOCAL_CACHE_DEVICE_ID_INDEX + i3);
                throw th;
            }
        } catch (Throwable unused) {
            return iArr[0] == 1 ? "" : telephonyManager.getDeviceId(i2);
        }
    }

    public static String getImei(TelephonyManager telephonyManager, int i2) {
        long currentTimeMillis;
        final long[][] jArr;
        final int i3 = i2;
        final int[] iArr = {2};
        try {
            if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
                "invoke telephonyManager.getImei(index):" + Log.getStackTraceString(new Throwable());
            }
            currentTimeMillis = System.currentTimeMillis();
            jArr = new long[][]{null};
            try {
                d dVar = new d("imei_index");
                c cVar = sImeiControlPolicy;
                f fVar = new f(cVar, i3);
                final TelephonyManager telephonyManager2 = telephonyManager;
                AnonymousClass2 r12 = new d.a<String>() {
                    public String invokeDefaultMethod() {
                        iArr[0] = 3;
                        return "";
                    }

                    @SuppressLint({"MissingPermission"})
                    public String invokeOriginMethod() {
                        iArr[0] = 1;
                        return telephonyManager2.getImei(i3);
                    }

                    public void onProcessConsume(long[] jArr) {
                        jArr[0] = jArr;
                    }
                };
                dVar.f = fVar;
                String str = (String) dVar.a((StackTraceElement[]) null, true, cVar, r12);
                long[] jArr2 = jArr[0];
                long currentTimeMillis2 = System.currentTimeMillis();
                c cVar2 = sImeiControlPolicy;
                long j = currentTimeMillis2 - currentTimeMillis;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(cVar2, 1, "imei_index", j, jArr2, str, iArr[0], Constant.LOCAL_CACHE_IMEI_INDEX + i3);
                return str;
            } catch (Throwable th2) {
                th = th2;
                TelephonyManager telephonyManager3 = telephonyManager;
                long[] jArr3 = jArr[0];
                long currentTimeMillis3 = System.currentTimeMillis();
                c cVar3 = sImeiControlPolicy;
                long j2 = currentTimeMillis3 - currentTimeMillis;
                com.baidu.sofire.xclient.privacycontrol.b.b.a(cVar3, 1, "imei_index", j2, jArr3, (String) null, iArr[0], Constant.LOCAL_CACHE_IMEI_INDEX + i3);
                throw th;
            }
        } catch (Throwable unused) {
            return iArr[0] == 1 ? "" : telephonyManager.getImei(i2);
        }
    }
}
