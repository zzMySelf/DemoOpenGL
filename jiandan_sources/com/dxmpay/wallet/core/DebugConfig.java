package com.dxmpay.wallet.core;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.wallet.core.domain.c;
import com.dxmpay.apollon.restnet.RestDebugConfig;
import com.dxmpay.wallet.core.domain.DomainConfig;
import fe.i.ad.ad.ad.ad;
import java.io.File;
import java.util.Properties;

public final class DebugConfig {
    public static final String CONFIG_FILE = "dxm_wallet_config.properties";
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    public static final String PASS_COMPLETE_VERIFY = "pass_complete_verify";
    public static final String SERVER_COMPLETE_VERIFY = "http://wappass.baidu.com/v2/?bindingret";
    public static final String SERVICE = "service";

    /* renamed from: fe  reason: collision with root package name */
    public static boolean f4242fe = false;

    /* renamed from: rg  reason: collision with root package name */
    public static DebugConfig f4243rg;

    /* renamed from: ad  reason: collision with root package name */
    public File f4244ad = null;

    /* renamed from: de  reason: collision with root package name */
    public Properties f4245de;
    public Context qw;

    public DebugConfig(Context context) {
        this.qw = context;
    }

    public static synchronized DebugConfig getInstance(Context context) {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (f4243rg == null) {
                f4243rg = new DebugConfig(context);
            }
            debugConfig = f4243rg;
        }
        return debugConfig;
    }

    public final void ad() {
        ad.qw().ad(qw("app_host"));
        ad.qw().de(qw(c.t));
        ad.qw().th(qw("app_spare_pay_host"));
        ad.qw().fe(qw(c.x));
        ad.qw().rg(qw("rtc_host"));
        ad.qw().uk(qw(com.baidu.wallet.core.DebugConfig.m));
        ad.qw().yj(qw("record_host"));
        DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA);
    }

    public void changeOnline() {
        f4242fe = false;
        DEFAULT_ENVIRONMENT = "ONLINE";
    }

    public void changeQA() {
        f4242fe = true;
        DEFAULT_ENVIRONMENT = "QA";
        Context context = this.qw;
        if (context == null || context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            this.f4244ad = new File(String.valueOf(Environment.getExternalStorageDirectory()), CONFIG_FILE);
        } else {
            File externalFilesDir = this.qw.getExternalFilesDir("");
            if (externalFilesDir != null && !externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            this.f4244ad = new File(externalFilesDir, CONFIG_FILE);
        }
        this.f4245de = de();
        readConfigHost(f4242fe);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c A[SYNTHETIC, Splitter:B:13:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0022 A[SYNTHETIC, Splitter:B:19:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Properties de() {
        /*
            r4 = this;
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0020, all -> 0x0019 }
            java.io.File r3 = r4.f4244ad     // Catch:{ Exception -> 0x0020, all -> 0x0019 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0020, all -> 0x0019 }
            r0.load(r2)     // Catch:{ Exception -> 0x0017, all -> 0x0014 }
            r2.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0025
        L_0x0014:
            r0 = move-exception
            r1 = r2
            goto L_0x001a
        L_0x0017:
            r1 = r2
            goto L_0x0020
        L_0x0019:
            r0 = move-exception
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            throw r0
        L_0x0020:
            if (r1 == 0) goto L_0x0025
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.core.DebugConfig.de():java.util.Properties");
    }

    public String getEnvironment() {
        if (f4242fe) {
            return qw(com.baidu.wallet.core.DebugConfig.e);
        }
        return DEFAULT_ENVIRONMENT;
    }

    public String getProperty(String str, String str2) {
        if (!f4242fe) {
            "没有打开DEBUG开关 返回默认值=" + str2;
            return str2;
        }
        String qw2 = qw(str);
        if (TextUtils.isEmpty(qw2)) {
            "配置文件没有配置 返回默认值=" + str2;
            return str2;
        }
        "返回配置文件的值 value=" + qw2;
        return qw2;
    }

    public boolean isOnline() {
        return "ONLINE".equals(getEnvironment());
    }

    public final String qw(String str) {
        Properties de2 = de();
        this.f4245de = de2;
        return de2.getProperty(str);
    }

    public void readConfigHost(boolean z) {
        f4242fe = z;
        if (z) {
            ad();
        }
        RestDebugConfig.getInstance().setQAEnv(z);
    }

    public static synchronized DebugConfig getInstance() {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (f4243rg == null) {
                f4243rg = new DebugConfig((Context) null);
            }
            debugConfig = f4243rg;
        }
        return debugConfig;
    }
}
