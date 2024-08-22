package com.baidu.sofire.xclient.privacycontrol;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.PCMH;
import com.baidu.sofire.xclient.privacycontrol.PrivacyControlConfig;
import com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper;
import com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper;
import com.baidu.sofire.xclient.privacycontrol.lib.TelephonyHelper;
import com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper;
import com.baidu.sofire.xclient.privacycontrol.ui.DoubleListActivity;
import com.baidu.sofire.xclient.privacycontrol.ui.IDoubleListCallBack;
import com.baidu.sofire.xclient.privacycontrol.ui.PassportHelper;
import com.baidu.sofire.xclient.privacycontrol.ui.ThirdLibActivity;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.lightapp.base.LightappConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class PrvControlManager {
    public static final int STATE_PARAM_ERROR = -1;
    public static final int STATE_SUCCESS = 0;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile PrvControlManager sInstance;
    public PrivacyControlConfig mConfig = createDefaultConfig();
    public Context mContext;
    public boolean mInit;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                if (!PrvControlManager.this.isCuidSdkExit() && PrvControlManager.this.mConfig != null && TextUtils.isEmpty(PrvControlManager.this.mConfig.c)) {
                    boolean z = PrvControlManager.this.mConfig.a;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b implements IDoubleListCallBack {
        public final /* synthetic */ IDoubleListCallBack a;
        public final /* synthetic */ Context b;

        public b(IDoubleListCallBack iDoubleListCallBack, Context context) {
            this.a = iDoubleListCallBack;
            this.b = context;
        }

        public void onLoginFail(WebAuthResult webAuthResult) {
            IDoubleListCallBack iDoubleListCallBack = this.a;
            if (iDoubleListCallBack != null) {
                iDoubleListCallBack.onLoginFail(webAuthResult);
            }
        }

        public void onLoginSuccess(WebAuthResult webAuthResult) {
            IDoubleListCallBack iDoubleListCallBack = this.a;
            if (iDoubleListCallBack != null) {
                iDoubleListCallBack.onLoginSuccess(webAuthResult);
            }
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            DoubleListActivity.a(this.b, session.uid, session.bduss, (String) null, 1);
        }

        public void onPassNotInit() {
        }
    }

    private void checkAndCacheDeviceId() {
        try {
            com.baidu.sofire.xclient.privacycontrol.h.a.a().post(new a());
        } catch (Throwable unused) {
        }
    }

    private PrivacyControlConfig createDefaultConfig() {
        PrivacyControlConfig.Builder builder = new PrivacyControlConfig.Builder();
        builder.setDebugModel(false);
        builder.setCacheSwitch(false);
        return builder.build();
    }

    public static PrvControlManager getInstance() {
        if (sInstance == null) {
            synchronized (PrvControlManager.class) {
                if (sInstance == null) {
                    sInstance = new PrvControlManager();
                }
            }
        }
        return sInstance;
    }

    public static void gotoDoubleListThirdPage(Context context) {
        int i2 = ThirdLibActivity.c;
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        intent.setComponent(new ComponentName(context, ThirdLibActivity.class));
        context.startActivity(intent);
    }

    public static int gotoDoubleListUserPage(Context context, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return -1;
        }
        DoubleListActivity.a(context, (String) null, (String) null, jSONObject.toString(), 2);
        return 0;
    }

    public static void gotoDoubleListUserPage(Context context, IDoubleListCallBack iDoubleListCallBack) {
        try {
            if (PassportHelper.isPassLogin()) {
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                DoubleListActivity.a(context, session.uid, session.bduss, (String) null, 1);
                return;
            }
            PassportHelper.login(context, new b(iDoubleListCallBack, context));
        } catch (Throwable unused) {
            if (iDoubleListCallBack != null) {
                iDoubleListCallBack.onPassNotInit();
            }
        }
    }

    private void loadLocalPrvConfig() {
        String str;
        try {
            try {
                str = F.getInstance().getCustomMutiProcessSharedPreferences(this.mContext, "xclient_prv_c_s").getString("ck", "default_flag");
                if (!TextUtils.isEmpty(str)) {
                    if (!"default_flag".equals(str)) {
                        str = PCMH.localDecrypt(str);
                    }
                }
            } catch (Throwable unused) {
                str = null;
            }
            if (!"default_flag".equals(str)) {
                HashMap<String, com.baidu.sofire.xclient.privacycontrol.a.b> hashMap = com.baidu.sofire.xclient.privacycontrol.a.a.a;
                com.baidu.sofire.xclient.privacycontrol.a.a.a(str);
            }
        } catch (Throwable unused2) {
        }
    }

    private void registerPolicyCallBack() {
        com.baidu.sofire.xclient.privacycontrol.a.a.a("1", TelephonyHelper.getConfigCallBack());
        com.baidu.sofire.xclient.privacycontrol.a.a.a(BannerBaseItemInfo.TYPE_LOGIN, TelephonyHelper.getConfigCallBack());
        com.baidu.sofire.xclient.privacycontrol.a.a.a("2", DeviceIdHelper.getConfigCallBack());
        com.baidu.sofire.xclient.privacycontrol.a.a.a("3", WifiInfoHelper.getConfigCallBack());
        com.baidu.sofire.xclient.privacycontrol.a.a.a("4", OaidHelper.getConfigCallBack());
        com.baidu.sofire.xclient.privacycontrol.e.b c = com.baidu.sofire.xclient.privacycontrol.e.b.c();
        c.getClass();
        try {
            com.baidu.sofire.xclient.privacycontrol.a.a.a("r", c);
        } catch (Throwable unused) {
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public PrivacyControlConfig getPrivacyControlConfig() {
        if (this.mConfig == null) {
            this.mConfig = createDefaultConfig();
        }
        return this.mConfig;
    }

    public Map<String, String> getReportData(int i2) {
        try {
            return com.baidu.sofire.xclient.privacycontrol.e.b.c().a(i2 * 5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Bundle handleProviderCall(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_METHOD_NAME);
            String string2 = bundle.getString("value");
            if ("reportLog".equals(string)) {
                com.baidu.sofire.xclient.privacycontrol.e.b.c().a(string2);
                return null;
            } else if (!"offline_report".equals(string)) {
                return null;
            } else {
                com.baidu.sofire.xclient.privacycontrol.e.b.c().b(string2, bundle.getString("logId"));
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2.a = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (com.baidu.sofire.ac.PCMH.isMainProcess(r0) == false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r2.d();
        r2.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000c, code lost:
        r1.mContext = r2.getApplicationContext();
        r2 = com.baidu.sofire.xclient.privacycontrol.e.b.c();
        r0 = r1.mContext;
        r2.getClass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0030
            boolean r0 = r1.mInit     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0008
            goto L_0x0030
        L_0x0008:
            r0 = 1
            r1.mInit = r0     // Catch:{ all -> 0x0032 }
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            android.content.Context r2 = r2.getApplicationContext()
            r1.mContext = r2
            com.baidu.sofire.xclient.privacycontrol.e.b r2 = com.baidu.sofire.xclient.privacycontrol.e.b.c()
            android.content.Context r0 = r1.mContext
            r2.getClass()
            r2.a = r0     // Catch:{ all -> 0x0029 }
            boolean r0 = com.baidu.sofire.ac.PCMH.isMainProcess(r0)     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0029
            r2.d()     // Catch:{ all -> 0x0029 }
            r2.a()     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r1.registerPolicyCallBack()
            r1.loadLocalPrvConfig()
            return
        L_0x0030:
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.PrvControlManager.init(android.content.Context):void");
    }

    public boolean isCuidSdkExit() {
        try {
            DeviceId.class.toString();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void notifyReportSuccess(List<String> list) {
        if (list != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String split : list) {
                    for (String str : split.split("%")) {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                arrayList.add(Integer.valueOf(str));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
                com.baidu.sofire.xclient.privacycontrol.e.b.c().a((List<Integer>) arrayList);
            } catch (Throwable unused2) {
            }
        }
    }

    public void setPrivacyControlConfig(PrivacyControlConfig privacyControlConfig) {
        this.mConfig = privacyControlConfig;
        checkAndCacheDeviceId();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0034 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateConfig(java.lang.String r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x0039 }
            boolean r1 = com.baidu.sofire.ac.PCMH.isMainProcess(r0)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0034
            com.baidu.sofire.ac.F r1 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "xclient_prv_c_s"
            android.content.SharedPreferences r0 = r1.getCustomMutiProcessSharedPreferences(r0, r2)     // Catch:{ all -> 0x0034 }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "ck"
            if (r1 == 0) goto L_0x0025
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = ""
            android.content.SharedPreferences$Editor r0 = r0.putString(r2, r1)     // Catch:{ all -> 0x0034 }
            goto L_0x0031
        L_0x0025:
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = com.baidu.sofire.ac.PCMH.localEncrypt(r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r0 = r0.putString(r2, r1)     // Catch:{ all -> 0x0034 }
        L_0x0031:
            r0.commit()     // Catch:{ all -> 0x0034 }
        L_0x0034:
            java.util.HashMap<java.lang.String, com.baidu.sofire.xclient.privacycontrol.a.b> r0 = com.baidu.sofire.xclient.privacycontrol.a.a.a     // Catch:{ all -> 0x0039 }
            com.baidu.sofire.xclient.privacycontrol.a.a.a(r4)     // Catch:{ all -> 0x0039 }
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.PrvControlManager.updateConfig(java.lang.String):void");
    }
}
