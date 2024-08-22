package com.baidu.wallet.core;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.domain.b;
import com.baidu.wallet.core.domain.c;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.util.Properties;

public final class DebugConfig {
    public static Boolean[] A = {Boolean.FALSE};
    public static String B = DomainConfig.getInstance().getCometHost(A);
    public static String C = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
    public static DebugConfig D = null;
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    public static final String G = "https://www.baifubao.com";
    public static String LBS_HOST = DomainConfig.getInstance().getZhiFuHost(A);
    public static final String PASS_COMPLETE_VERIFY = "pass_complete_verify";
    public static final String SERVER_COMPLETE_VERIFY = "http://wappass.baidu.com/v2/?bindingret";
    public static final String SERVICE = "service";
    public static final String VOICE_API_HOST_DFT = "https://wallet.baidu.com";
    public static final String VOICE_SERVICE_URL_DFT = "https://wallet.baidu.com";
    public static boolean a = false;
    public static final String b = "wallet_config.properties";
    public static final String c = "wallet_https_host";
    public static final String d = "wallet_passport_host";
    public static final String e = "environment";
    public static final String f = "wallet_plugin_host";
    public static final String g = "wallet_nfc_host";
    public static final String h = "wallet_web_cache_host";

    /* renamed from: i  reason: collision with root package name */
    public static final String f3545i = "voiceprint_service";
    public static final String j = "voiceprint_host";
    public static final String k = "wallet_stat_host";
    public static final String l = "wallet_stat_strategy_host";
    public static final String m = "wallet_sensor_stat_host";
    public static final String n = "wallet_coupon_host";

    /* renamed from: o  reason: collision with root package name */
    public static final String f3546o = "wallet_comet_push_host";
    public static String p = "https://www.baifubao.com";
    public static String q = "http://www.baifubao.com";
    public static String r = "http://wappass.baidu.com/passport";
    public static String s = "https://chong.baidu.com";
    public static String t = "https://wallet.baidu.com";
    public static String u = "https://wallet.baidu.com";
    public static String v = "https://wallet.baidu.com";
    public static String w = "https://www.baifubao.com";
    public static String x = "https://www.baifubao.com";
    public static String y = "https://www.baifubao.com";
    public static String z = "https://datasink.dxmpay.com";
    public File E = null;
    public Properties F;

    public DebugConfig(Context context) {
        if (context != null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                    File externalFilesDir = context.getExternalFilesDir("");
                    if (externalFilesDir != null && !externalFilesDir.exists()) {
                        externalFilesDir.mkdirs();
                    }
                    this.E = new File(externalFilesDir, b);
                    this.F = b();
                }
            } catch (Exception unused) {
                return;
            }
        }
        this.E = new File(String.valueOf(Environment.getExternalStorageDirectory()), b);
        this.F = b();
    }

    private void a() {
        c.a().a(a("life_host"));
        c.a().d(a("app_host"));
        c.a().f(a(c.t));
        c.a().h(a(c.v));
        c.a().k(a("comet_host"));
        c.a().c(a(c.q));
        c.a().g(a(c.u));
        c.a().e(a("nfc_host"));
        c.a().b(a("my_host"));
        c.a().i(a(c.w));
        c.a().j(a(c.x));
        c.a().l(a("wallet_web_cache_host"));
        c.a().m(a("rtc_host"));
        c.a().n(a("record_host"));
        DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA);
        String a2 = a(k);
        w = a2;
        if (TextUtils.isEmpty(a2)) {
            w = "https://www.baifubao.com";
        }
        String a3 = a(l);
        x = a3;
        if (TextUtils.isEmpty(a3)) {
            x = "https://www.baifubao.com";
        }
        String a4 = a(m);
        z = a4;
        if (TextUtils.isEmpty(a4)) {
            z = "https://datasink.dxmpay.com";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024 A[SYNTHETIC, Splitter:B:17:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002a A[SYNTHETIC, Splitter:B:22:0x002a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Properties b() {
        /*
            r4 = this;
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x001b }
            java.io.File r3 = r4.E     // Catch:{ Exception -> 0x001b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001b }
            r0.load(r2)     // Catch:{ Exception -> 0x0017, all -> 0x0014 }
            r2.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0027
        L_0x0014:
            r0 = move-exception
            r1 = r2
            goto L_0x0028
        L_0x0017:
            r1 = r2
            goto L_0x001b
        L_0x0019:
            r0 = move-exception
            goto L_0x0028
        L_0x001b:
            java.lang.String r2 = "DebugConfig"
            java.lang.String r3 = "the wallet_config.properties is not exist!!"
            com.baidu.wallet.core.utils.LogUtil.d(r2, r3)     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x0027
            r1.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return r0
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.DebugConfig.b():java.util.Properties");
    }

    public static synchronized DebugConfig getInstance(Context context) {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (D == null) {
                D = new DebugConfig(context);
            }
            debugConfig = D;
        }
        return debugConfig;
    }

    public void changeOnline() {
        a = false;
        p = "https://www.baifubao.com";
        r = "https://wappass.baidu.com/passport/";
        s = b.w;
        LBS_HOST = DomainConfig.getInstance().getZhiFuHost(A);
        t = "https://wallet.baidu.com";
        DEFAULT_ENVIRONMENT = "ONLINE";
        B = DomainConfig.getInstance().getCometHost(A);
        u = "https://wallet.baidu.com";
        v = "https://wallet.baidu.com";
        w = "https://www.baifubao.com";
        x = "https://www.baifubao.com";
        y = "https://www.baifubao.com";
    }

    public void changeQA() {
        a = true;
        DEFAULT_ENVIRONMENT = "QA";
        readConfigHost(true);
    }

    public String getCometPushHttps() {
        return B;
    }

    public String getCouponHost() {
        return t;
    }

    public String getEnvironment() {
        if (a) {
            return a(e);
        }
        return DEFAULT_ENVIRONMENT;
    }

    public String getFixedWalletHttpsHostForH5() {
        return "https://www.baifubao.com";
    }

    public String getProperty(String str, String str2) {
        if (!a) {
            LogUtil.logd("没有打开DEBUG开关 返回默认值=" + str2);
            return str2;
        }
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            LogUtil.logd("配置文件没有配置 返回默认值=" + str2);
            return str2;
        }
        LogUtil.logd("返回配置文件的值 value=" + a2);
        return a2;
    }

    public String getSenorStatisticsHost() {
        return z;
    }

    public String getStatStrategyHost() {
        if (isOnline()) {
            return DomainConfig.getInstance().getLifeHost(A);
        }
        return x;
    }

    public String getStatisticsHost() {
        if (isOnline()) {
            return DomainConfig.getInstance().getAppHost(A);
        }
        return w;
    }

    public String getVoiceprintHost() {
        return v;
    }

    public String getVoiceprintServiceUrl() {
        return u;
    }

    public String getWalletHttpsHost() {
        return p;
    }

    public String getWalletNfcHost() {
        return s;
    }

    public String getWalletPassportHost() {
        return r;
    }

    public String getWalletPluginHost() {
        return C;
    }

    public String getWebCacheHost() {
        return y;
    }

    public boolean isOnline() {
        return "ONLINE".equals(getEnvironment());
    }

    public void readConfigHost(boolean z2) {
        a = z2;
        if (z2) {
            a();
        } else {
            p = "https://www.baifubao.com";
            r = "https://wappass.baidu.com/passport/";
            C = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
            s = b.w;
            t = "https://wallet.baidu.com";
            B = DomainConfig.getInstance().getCometHost(A);
            u = "https://wallet.baidu.com";
            v = "https://wallet.baidu.com";
            w = "https://www.baifubao.com";
            x = "https://www.baifubao.com";
            y = "https://www.baifubao.com";
            z = "https://datasink.dxmpay.com";
        }
        RestDebugConfig.getInstance().setQAEnv(z2);
    }

    public void setCometPushHttps(String str) {
        B = str;
    }

    public void setWalletHttpsHost(String str) {
        p = str;
    }

    public static synchronized DebugConfig getInstance() {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (D == null) {
                D = new DebugConfig((Context) null);
            }
            debugConfig = D;
        }
        return debugConfig;
    }

    private String a(String str) {
        Properties b2 = b();
        this.F = b2;
        return b2.getProperty(str);
    }
}
