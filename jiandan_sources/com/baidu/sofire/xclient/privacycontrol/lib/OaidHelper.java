package com.baidu.sofire.xclient.privacycontrol.lib;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.baidu.helios.OnGetIdResultCallback;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import com.baidu.sofire.xclient.privacycontrol.a.b;
import com.baidu.sofire.xclient.privacycontrol.b.c;
import com.bun.miitmdid.interfaces.IdSupplier;
import fe.fe.pf.ad;

public class OaidHelper {
    public static final b CONFIG_CALL_BACK = new b() {
        public void onConfigUpdate(String str, String str2) {
            if ("4".equals(str)) {
                c unused = OaidHelper.sOaidControlPolicy = com.baidu.sofire.xclient.privacycontrol.b.b.a(str2);
            }
        }
    };
    public static final int FROM_LOOPER = 2;
    public static final int FROM_NO_LOOPER = 1;
    public static long sLastGetOaidFromSdk;
    public static c sOaidControlPolicy = c.a();

    public interface OriginInvoker {
        String invoke();
    }

    public static b getConfigCallBack() {
        return CONFIG_CALL_BACK;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getOaid(com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper.OriginInvoker r21) {
        /*
            java.lang.String r0 = "oaid_origin"
            r1 = 1
            int[] r2 = new int[r1]
            r3 = 2
            r4 = 0
            r2[r4] = r3
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0046 }
            long[][] r3 = new long[r1][]     // Catch:{ all -> 0x0046 }
            r7 = 0
            r3[r4] = r7     // Catch:{ all -> 0x0046 }
            com.baidu.sofire.xclient.privacycontrol.b.d r8 = new com.baidu.sofire.xclient.privacycontrol.b.d     // Catch:{ all -> 0x0046 }
            r8.<init>(r0)     // Catch:{ all -> 0x0046 }
            com.baidu.sofire.xclient.privacycontrol.c.c r9 = new com.baidu.sofire.xclient.privacycontrol.c.c     // Catch:{ all -> 0x0046 }
            com.baidu.sofire.xclient.privacycontrol.b.c r10 = sOaidControlPolicy     // Catch:{ all -> 0x0046 }
            r9.<init>(r0, r10)     // Catch:{ all -> 0x0046 }
            com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper$6 r0 = new com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper$6     // Catch:{ all -> 0x0046 }
            r11 = r21
            r0.<init>(r2, r11, r3)     // Catch:{ all -> 0x0044 }
            r8.f = r9     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r8.a(r7, r1, r10, r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0044 }
            r17 = r3[r4]     // Catch:{ all -> 0x0044 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0044 }
            com.baidu.sofire.xclient.privacycontrol.b.c r12 = sOaidControlPolicy     // Catch:{ all -> 0x0044 }
            r13 = 4
            java.lang.String r14 = "oaid_origin"
            long r15 = r7 - r5
            r19 = r2[r4]     // Catch:{ all -> 0x0044 }
            java.lang.String r20 = "local_c_oi"
            r18 = r0
            com.baidu.sofire.xclient.privacycontrol.b.b.a(r12, r13, r14, r15, r17, r18, r19, r20)     // Catch:{ all -> 0x0044 }
            return r0
        L_0x0044:
            goto L_0x0048
        L_0x0046:
            r11 = r21
        L_0x0048:
            r0 = r2[r4]
            if (r0 != r1) goto L_0x004f
            java.lang.String r0 = ""
            return r0
        L_0x004f:
            java.lang.String r0 = r21.invoke()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper.getOaid(com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper$OriginInvoker):java.lang.String");
    }

    public static void invokeRealRequestOid(int i2, ad adVar, final OnGetIdResultCallback<String> onGetIdResultCallback, Looper looper) {
        AnonymousClass2 r0 = new OnGetIdResultCallback<String>() {
            public void onError(int i2, Throwable th2, Bundle bundle) {
                OnGetIdResultCallback onGetIdResultCallback = OnGetIdResultCallback.this;
                if (onGetIdResultCallback != null) {
                    onGetIdResultCallback.onError(i2, th2, bundle);
                }
                com.baidu.sofire.xclient.privacycontrol.b.b.a(OaidHelper.sOaidControlPolicy, 4, "oaid_cuid_request", 0, new long[9], "", 1, Constant.LOCAL_CACHE_OAID_CUID_REQUEST);
            }

            public void onResult(String str, Bundle bundle) {
                OnGetIdResultCallback onGetIdResultCallback = OnGetIdResultCallback.this;
                if (onGetIdResultCallback != null) {
                    onGetIdResultCallback.onResult(str, bundle);
                }
                if (System.currentTimeMillis() - OaidHelper.sLastGetOaidFromSdk > 500) {
                    com.baidu.sofire.xclient.privacycontrol.b.b.a(OaidHelper.sOaidControlPolicy, 4, "oaid_cuid_request", 0, new long[9], str, 1, Constant.LOCAL_CACHE_OAID_CUID_REQUEST);
                }
            }
        };
        if (i2 == 2) {
            adVar.ggg(r0, looper);
        } else {
            adVar.ppp(r0);
        }
    }

    public static void requestOid(ad adVar, OnGetIdResultCallback onGetIdResultCallback) {
        if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
            "invoke heliosManager.requestOid:" + Log.getStackTraceString(new Throwable());
        }
        invokeRealRequestOid(1, adVar, onGetIdResultCallback, (Looper) null);
    }

    public static String getOaid(final IdSupplier idSupplier) {
        if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
            "invoke idSupplier.getOAID:" + Log.getStackTraceString(new Throwable());
        }
        return getOaid((OriginInvoker) new OriginInvoker() {
            public String invoke() {
                return IdSupplier.this.getOAID();
            }
        });
    }

    public static void requestOid(ad adVar, OnGetIdResultCallback<String> onGetIdResultCallback, Looper looper) {
        if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
            "invoke heliosManager.requestOid:" + Log.getStackTraceString(new Throwable());
        }
        invokeRealRequestOid(2, adVar, onGetIdResultCallback, looper);
    }

    public static String getOaid(final com.bun.miitmdid.supplier.IdSupplier idSupplier) {
        if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
            "invoke idSupplier.getOAID:" + Log.getStackTraceString(new Throwable());
        }
        return getOaid((OriginInvoker) new OriginInvoker() {
            public String invoke() {
                return idSupplier.getOAID();
            }
        });
    }

    public static String getOaid(final com.bun.supplier.IdSupplier idSupplier) {
        if (PrvControlManager.getInstance().getPrivacyControlConfig().a) {
            "invoke idSupplier.getOAID:" + Log.getStackTraceString(new Throwable());
        }
        return getOaid((OriginInvoker) new OriginInvoker() {
            public String invoke() {
                return com.bun.supplier.IdSupplier.this.getOAID();
            }
        });
    }
}
