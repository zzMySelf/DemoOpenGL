package com.dxmpay.wallet.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ISecurityListener;
import com.baidu.wallet.api.IWalletBaseFacade;
import com.baidu.wallet.api.IWalletInvokeHostListener;
import com.baidu.wallet.api.IWalletListener;
import com.baidu.wallet.api.IWalletQRScannerCallback;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.ChannelUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.BaiduWalletServiceController;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.nopassauth.OtpTokenUtils;
import com.dxmpay.wallet.core.DebugConfig;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.statistics.impl.SensorsSyncHttpImpl;
import com.dxmpay.wallet.statistics.impl.StatConfig;
import com.dxmpay.wallet.utils.BdWalletUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaiduWalletDelegate implements IWalletBaseFacade {

    /* renamed from: rg  reason: collision with root package name */
    public static final String f4123rg = "BaiduWalletDelegate";

    /* renamed from: th  reason: collision with root package name */
    public static volatile AtomicBoolean f4124th = new AtomicBoolean(false);

    /* renamed from: ad  reason: collision with root package name */
    public Context f4125ad;

    /* renamed from: de  reason: collision with root package name */
    public Domain f4126de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4127fe;
    public ISecurityListener qw;

    public class ad extends GlobalCallback {
        public final /* synthetic */ Context qw;

        public ad(Context context) {
            this.qw = context;
        }

        public void onLoginStatusChange() {
        }

        public void onNeedInitPassSdk() {
            BaiduWalletDelegate.this.de(this.qw);
        }
    }

    public class de implements RouterCallback {
        public de(BaiduWalletDelegate baiduWalletDelegate) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class fe implements PassUtil.IPassNormalize {
        public fe(BaiduWalletDelegate baiduWalletDelegate) {
        }

        public boolean onNormalize(Context context, int i2, Map<String, String> map) {
            WalletLoginHelper.getInstance().onLoginChanaged(context, map);
            return false;
        }
    }

    public class i implements RouterCallback {
        public i(BaiduWalletDelegate baiduWalletDelegate) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class o implements RouterCallback {
        public o(BaiduWalletDelegate baiduWalletDelegate) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public static class pf {
        public static final BaiduWalletDelegate qw = new BaiduWalletDelegate((ad) null);
    }

    public class qw implements RouterCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ IWalletQRScannerCallback f4129ad;

        public qw(BaiduWalletDelegate baiduWalletDelegate, IWalletQRScannerCallback iWalletQRScannerCallback) {
            this.f4129ad = iWalletQRScannerCallback;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResult(int r7, java.util.HashMap r8) {
            /*
                r6 = this;
                r0 = 2
                r1 = 1
                java.lang.String r2 = ""
                r3 = -1
                java.lang.String r4 = "失败"
                if (r7 != 0) goto L_0x001f
                if (r8 == 0) goto L_0x001f
                java.lang.String r7 = "value"
                java.lang.Object r7 = r8.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                boolean r8 = android.text.TextUtils.isEmpty(r7)
                if (r8 != 0) goto L_0x0051
                r8 = 0
                java.lang.String r4 = "成功"
                r2 = r7
                r0 = 0
                goto L_0x0052
            L_0x001f:
                r5 = 5
                if (r7 != r5) goto L_0x0026
                java.lang.String r4 = "扫码模块不存在"
                r0 = 1
                goto L_0x0052
            L_0x0026:
                if (r7 != r1) goto L_0x0051
                if (r8 == 0) goto L_0x0051
                java.lang.String r7 = "errCode"
                java.lang.Object r7 = r8.get(r7)
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r7 = r7.intValue()
                java.lang.String r1 = "errorMsg"
                java.lang.Object r8 = r8.get(r1)
                java.lang.String r8 = (java.lang.String) r8
                if (r7 != r0) goto L_0x004b
                java.lang.String r1 = "camera_permission_denied"
                boolean r8 = android.text.TextUtils.equals(r8, r1)
                if (r8 == 0) goto L_0x004b
                java.lang.String r4 = "没有访问相机的权限"
                goto L_0x0052
            L_0x004b:
                if (r7 != 0) goto L_0x0051
                r0 = 3
                java.lang.String r4 = "用户取消"
                goto L_0x0052
            L_0x0051:
                r0 = -1
            L_0x0052:
                com.baidu.wallet.api.IWalletQRScannerCallback r7 = r6.f4129ad
                if (r7 == 0) goto L_0x0059
                r7.onResult(r0, r4, r2)
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.api.BaiduWalletDelegate.qw.onResult(int, java.util.HashMap):void");
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f4130ad;

        public rg(Context context) {
            this.f4130ad = context;
        }

        public void run() {
            if (SecurePay.getInstance().prepareCompleted()) {
                StatApi.init(this.f4130ad.getApplicationContext(), StatConfig.getInstance(this.f4130ad.getApplicationContext()));
                StatApi.setSyncHttpImpl(new SensorsSyncHttpImpl());
                new SMManagerDelegate().initSM(this.f4130ad.getApplicationContext());
                BdWalletUtils.loadDeviceFP(this.f4130ad.getApplicationContext());
                BaiduWalletDelegate.this.rg(this.f4130ad);
            }
        }
    }

    public class th implements RouterCallback {
        public th(BaiduWalletDelegate baiduWalletDelegate) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class uk implements RouterCallback {
        public uk(BaiduWalletDelegate baiduWalletDelegate) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class yj implements RouterCallback {
        public yj(BaiduWalletDelegate baiduWalletDelegate) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public /* synthetic */ BaiduWalletDelegate(ad adVar) {
        this();
    }

    public static final BaiduWalletDelegate getInstance() {
        return pf.qw;
    }

    public void callQRCodeScanner(Context context, IWalletQRScannerCallback iWalletQRScannerCallback) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("saoyisao").action("qrcodescanresult"), new qw(this, iWalletQRScannerCallback));
        BaiduWalletServiceController.getInstance().gotoWalletService(context, "32768", "");
    }

    public Pair<Integer, Object> checkSecurityEvn() {
        ISecurityListener iSecurityListener = this.qw;
        if (iSecurityListener != null) {
            return iSecurityListener.onCheck();
        }
        return null;
    }

    public final void de(Context context) {
        boolean z;
        if (this.f4126de == null) {
            this.f4126de = Domain.DOMAIN_ONLINE;
            if ("QA".equalsIgnoreCase(DebugConfig.getInstance(context).getEnvironment())) {
                this.f4126de = Domain.DOMAIN_QA;
                z = true;
            } else {
                z = false;
            }
            SapiConfiguration.Builder initialShareStrategy = new SapiConfiguration.Builder(context).setProductLineInfo("bdwalletsdk", "1", "3s9y80v8ipz8huoh9k06hurn2lia5eez").setRuntimeEnvironment(this.f4126de).setSocialBindType(BindType.EXPLICIT).initialShareStrategy(LoginShareStrategy.DISABLED);
            Switch switchR = Switch.ON;
            SapiConfiguration build = initialShareStrategy.smsLoginConfig(new SapiConfiguration.SmsLoginConfig(switchR, switchR, switchR)).configurableViewLayout(Switch.ON).setSupportFaceLogin(false).sofireSdkConfig("600000", "69a0826db896e8c99e5d7bf63a14de3d", 600000).debug(z).build();
            if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
                DxmPassManagerDelegate.getInstance().dxmInitSdk(context, build);
            } else {
                SapiAccountManager.getInstance().init(build);
            }
        }
    }

    public void doBusCardChargeNFC(Context context, Parcelable parcelable) {
        if (Build.VERSION.SDK_INT <= 9) {
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_low_sdkversion_tip"));
            return;
        }
        BaiduWalletServiceController.getInstance().accessBusCardChargeNFC(context, parcelable);
        th(context);
    }

    public Context getAppContext() {
        return this.f4125ad;
    }

    public String getBindUrl(String str) {
        return SdkInitResponse.getInstance().getLoginUrl(str);
    }

    public void gotoWalletService(Context context, String str, String str2) {
        BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2, true);
    }

    public void initLangBrige(IWalletListener iWalletListener) {
        LocalRouter.getInstance(this.f4125ad).route(this.f4125ad, new RouterRequest().provider("langbrige").action("langbrige_init").data("wallet_listener", iWalletListener), new o(this));
    }

    public void initWallet(Context context) {
        initWallet(context, "simplify");
    }

    public void invokeBdWalletNative(Activity activity, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
    }

    public void invokeHostNative(String str, String str2) {
        if (WalletLoginHelper.getInstance() != null && (WalletLoginHelper.getInstance() instanceof IWalletInvokeHostListener) && !TextUtils.isEmpty(str)) {
            try {
                ((IWalletInvokeHostListener) WalletLoginHelper.getInstance()).invokeHostNative(Long.parseLong(str), str2);
            } catch (Exception e) {
                LogUtil.e(f4123rg, e.getMessage(), e);
            }
        }
    }

    public void logout(Context context) {
        WalletLoginHelper.getInstance().logout();
        if (context != null) {
            AccountManager.getInstance(context.getApplicationContext()).logout();
        }
    }

    public void openH5Module(Context context, String str, boolean z) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", (Object) null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)), new th(this));
    }

    public final void qw(Context context) {
        SapiAccountManager.setGlobalCallback(new ad(context));
    }

    public void removeH5LifeCycleCb(Context context, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (context != null) {
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("langbrige").action("langbrige_removeLifeCycleCb").data("lifeCycleCb", activityLifecycleCallbacks).data("activty", context), new de(this));
        }
    }

    public final void rg(Context context) {
        long syncTime = OtpTokenUtils.syncTime(OtpTokenUtils.getmSyncWithServerTime(context));
        "sync server time: detatime is " + syncTime;
        OtpTokenUtils.setmSyncWithServerTime(context, syncTime);
    }

    public void setAppContext(Context context) {
        this.f4125ad = context;
    }

    public void setDebugOn(Context context, boolean z) {
        if (z) {
            DebugConfig.getInstance(context).changeQA();
        } else {
            DebugConfig.getInstance(context).changeOnline();
        }
    }

    public void setPassDomain(Domain domain) {
        this.f4126de = domain;
    }

    public boolean startWallet(Context context) {
        StatisticManager.onEvent("#startWallet");
        return BaiduWalletServiceController.getInstance().startWallet(context, true, false);
    }

    public final void th(Context context) {
        if (!this.f4127fe) {
            this.f4127fe = true;
        }
    }

    public BaiduWalletDelegate() {
    }

    public void initWallet(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            qw(context);
            de(context);
            initWallet((IWalletListener) null, context, str);
            return;
        }
        throw new IllegalArgumentException("The channel number can not be empty.");
    }

    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", (Object) null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)).data("bundle", bundle), new yj(this));
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        if (!TextUtils.isEmpty(str)) {
            this.qw = iSecurityListener;
            initWallet(iWalletListener, context, str);
            return;
        }
        throw new IllegalArgumentException("The channel number can not be empty.");
    }

    public void openH5Module(Context context, String str, String str2, boolean z, boolean z2) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", str2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)), new uk(this));
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The channel number can not be empty.");
        } else if (context != null && f4124th.compareAndSet(false, true)) {
            WalletLoginHelper.getInstance().init(context, iWalletListener);
            BeanConstants.CHANNEL_ID = str;
            String str2 = "BaiduWallet-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
            BeanConstants.SDK_VERSION = str2;
            ChannelUtils.initBussinessParams(str2, false);
            PassUtil.registerPassNormalize(new fe(this));
            DomainConfig.getInstance().setDxmPayContext(context.getApplicationContext());
            if (DebugConfig.getInstance().isOnline()) {
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", ""));
                if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                    fe.i.qw.de.qw.i().uk(true);
                }
            } else {
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", ""));
                if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                    fe.i.qw.de.qw.i().uk(true);
                }
            }
            new Thread(new rg(context), "DxmPaySDK").start();
            this.f4125ad = context.getApplicationContext();
        }
    }

    public void openH5Module(Context context, Bundle bundle) {
        if (bundle != null && bundle.containsKey("url") && !TextUtils.isEmpty(bundle.getString("url"))) {
            String string = bundle.getString("url");
            String string2 = bundle.containsKey("title") ? bundle.getString("title") : null;
            boolean z = true;
            boolean z2 = bundle.containsKey("withAnim") ? bundle.getBoolean("withAnim") : true;
            if (bundle.containsKey("show_share")) {
                z = bundle.getBoolean("show_share");
            }
            bundle.remove("url");
            bundle.remove("title");
            bundle.remove("withAnim");
            bundle.remove("show_share");
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", string).data("title", string2).data("with_anim", Boolean.valueOf(z2)).data("show_share", Boolean.valueOf(z)).data("bundle", bundle), new i(this));
        }
    }

    public void openH5Module(Context context, String str) {
        openH5Module(context, str, true);
    }
}
