package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.Permission;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PollInitUtils;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.wallet.utils.LbAbilityNewWayUtils;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class SdkInitResponse implements IBeanResponse {
    public static final String DEFAULT_JS_HOOK_URL = "https://wap.duxiaoman.com/content/umoney/jspatch/hook-js.f0caeff.zip";
    public static final String KEY_ENABLE_NETWORK_STAT = "enable_network_stat";
    public static final String SID_JS_HOOK_URL = "js_hook_url";
    public static final String SID_OFFLINE_CACHE_CONFIG = "offline_cache_config";
    public static final String a = "langbridge_speed_up";
    public static final String b = "pass_auth_url";
    public static final String c = "key_paycode_url";
    public static final String d = "key_balance_home_url";
    public static final String e = "key_cookies_sync_domain_list";
    public static final String f = "white_screen_config";
    public static final String g = "key_loading_duration_interval";
    public static final String h = "key_transaction_records_url";

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f3599i = true;
    public String JSHookURL = "";
    public String LangbridgeSettings = "";
    public String appDomainConfig = "";
    public int attemptDelay;
    public String balanceHomeUrl = "";
    public String certWhiteList = "";
    public String cleanHomePageCache = "0";
    public String cookiesSyncDomainList = "";
    public String domainConfig = "";
    public String domainSwitch = "";
    public String enableHE = "1";
    public String enableJsNameVerify = "";
    public String enableNetStat = "1";
    public String enableNetworkStatForHttp2 = "0";
    public String fp = "";
    public String interval_millis = "";
    public boolean j = false;
    public String jsipc = "";
    public String kefuPhoneNum = "";
    public String langbridgeCheckProtocol = "";
    public String langbridgeSafeCheckFromURL = "0";
    public String langbridgeSpeedUp = "";
    public String langbridge_permission_dialog = "";
    public String lbNewMethods;
    public String loadingDurationInterval = "";
    public JSONObject loginUrl;
    public int multipleMaxCount = 9;
    public String needShowLoadingInterval = "";
    public String newHomepage = "1";
    public String offlineCacheConfig = "";
    public String passAuthUrl = "";
    public String paymentCodeUrl = "";
    public String permissionAllowDomainList = "";
    public String permission_dialog_audio = "";
    public String permission_dialog_camera = "";
    public String permission_dialog_contacts = "";
    public String permission_dialog_info = "";
    public String permission_dialog_location = "";
    public String permission_dialog_storage = "";
    public String polling_switch = "true";
    public String publicKeyPins = "";
    public String rpa_pages_config;
    public String rtcConfig = "";
    public double samplingRate = 0.1d;
    public String scanCodePEImageCollectFromAlbum = "";
    public String scanCodePEImageCollectInterval = "";
    public String scanCodePEImageCollectLimit = "";
    public String scanCodePEImageDynamicCrop;
    public String scanCodePEOptimization = "";
    public String sdk_permission_dialog = "";
    public String sign = "";
    public String supportBarCode = "0";
    public String supportZxingScanCode = "0";
    public String takePicWaitTime = "";
    public String transactionRecordsUrl = "";
    public String useOkHttp = "1";
    public String whiteScreenConfig = "";

    public static class OfflineCacheConfig implements NoProguard {
        public boolean useOfflineCache = true;
        public boolean usePreSetCookie;
        public boolean usePreload;

        public boolean isUseOfflineCache() {
            return this.useOfflineCache;
        }
    }

    public static final class a {
        public static final SdkInitResponse a = new SdkInitResponse();
    }

    private void a(SdkInitResponse sdkInitResponse) {
        if (sdkInitResponse != null && TextUtils.equals("1", sdkInitResponse.cleanHomePageCache) && !a.a.j) {
            try {
                File file = new File(BaiduWalletDelegate.getInstance().getAppContext().getCacheDir(), PayPreferenceManager.getUserToken());
                if (file.exists()) {
                    File file2 = new File(file, "sdk_home_tab_life600.cfg");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    a.a.j = true;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static SdkInitResponse getInstance() {
        return a.a;
    }

    public static boolean isEnableJsNameVerify() {
        if (TextUtils.isEmpty(a.a.enableJsNameVerify)) {
            return false;
        }
        return "1".equals(a.a.enableJsNameVerify);
    }

    public static boolean isLangBridgeCheckUrlProtocol() {
        if (TextUtils.isEmpty(a.a.langbridgeCheckProtocol)) {
            return true;
        }
        return "1".equals(a.a.langbridgeCheckProtocol);
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public String getBalanceHomeUrl(Context context) {
        if (TextUtils.isEmpty(this.balanceHomeUrl)) {
            this.balanceHomeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, d, "");
        }
        return this.balanceHomeUrl;
    }

    public String getCookiesSyncDomainList(Context context) {
        if (TextUtils.isEmpty(this.cookiesSyncDomainList)) {
            this.cookiesSyncDomainList = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, e, "");
            LogUtil.d("Cookie", "use cache: " + this.cookiesSyncDomainList);
        } else {
            LogUtil.d("Cookie", "use online: " + this.cookiesSyncDomainList);
        }
        return this.cookiesSyncDomainList;
    }

    public String getJsHookURl(Context context) {
        if (!TextUtils.isEmpty(a.a.JSHookURL)) {
            return a.a.JSHookURL;
        }
        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "cache jsHookUrl = " + ((String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL)));
        return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, DEFAULT_JS_HOOK_URL);
    }

    public String getLoadingDurationInterval(Context context) {
        if (TextUtils.isEmpty(this.loadingDurationInterval) && context != null) {
            this.loadingDurationInterval = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, g, "");
        }
        return this.loadingDurationInterval;
    }

    public String getLoginUrl(String str) {
        DXMSdkSAUtils.onEvent("event_get_bindurl");
        JSONObject jSONObject = this.loginUrl;
        if (jSONObject == null) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public int getMultipleMaxCount() {
        String simpleName = SdkInitResponse.class.getSimpleName();
        LogUtil.d(simpleName, "multipleMaxCount = " + a.a.multipleMaxCount);
        return a.a.multipleMaxCount;
    }

    public String getOfflineCacheConfig(Context context) {
        return a.a.offlineCacheConfig;
    }

    public String getPassAuthUrl(Context context) {
        String str = DomainConfig.getInstance().getCOHost(new Boolean[]{Boolean.FALSE}) + "/content/resource/pass_normal/index.html";
        if (!TextUtils.isEmpty(a.a.passAuthUrl)) {
            return a.a.passAuthUrl;
        }
        String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, b, "");
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public String getPayCodeUrl(Context context) {
        if (TextUtils.isEmpty(this.paymentCodeUrl)) {
            this.paymentCodeUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, c, "");
        }
        return this.paymentCodeUrl;
    }

    public int getTakePicWaitTime() {
        if (!TextUtils.isEmpty(a.a.takePicWaitTime)) {
            return Integer.valueOf(a.a.takePicWaitTime).intValue();
        }
        return 2000;
    }

    public String getTransactionRecordsUrl(Context context) {
        if (TextUtils.isEmpty(this.transactionRecordsUrl)) {
            this.transactionRecordsUrl = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, h, "");
        }
        return this.transactionRecordsUrl;
    }

    public String getWhiteScreenConfig(Context context) {
        if (!TextUtils.isEmpty(a.a.whiteScreenConfig)) {
            return a.a.whiteScreenConfig;
        }
        return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f, "");
    }

    public boolean isLangbridgeSpeedUpEnable(Context context) {
        if (!TextUtils.isEmpty(a.a.langbridgeSpeedUp)) {
            return "1".equals(a.a.langbridgeSpeedUp);
        }
        String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, a, "");
        if (!TextUtils.isEmpty(str)) {
            return "1".equals(str);
        }
        return false;
    }

    public boolean isSupportBarCode() {
        LogUtil.d("zxing", "isSupportBarCode = " + a.a.supportBarCode);
        return "1".equals(a.a.supportBarCode);
    }

    public boolean isSupportZxingScanCode() {
        LogUtil.d("zxing", "isSupportZxingScanCode = " + a.a.supportZxingScanCode);
        return "1".equals(a.a.supportZxingScanCode);
    }

    public void storeResponse(Context context) {
        LogUtil.d("okhttp", "initResponse: " + toString());
        a(this);
        if (!TextUtils.isEmpty(this.offlineCacheConfig)) {
            a.a.offlineCacheConfig = this.offlineCacheConfig;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_OFFLINE_CACHE_CONFIG, this.offlineCacheConfig);
            updateOfflineCacheConfig(context, this.offlineCacheConfig);
        }
        RestDebugConfig.setEnableOkHttp("1".equals(this.useOkHttp));
        RestDebugConfig.setEnableHappyEyeballs("1".equals(this.enableHE));
        RestDebugConfig.setEnableNetworkStats("1".equals(this.enableNetStat));
        RestDebugConfig.updateOkHttpEventListenerFactory(this.samplingRate);
        int i2 = this.attemptDelay;
        if (i2 > 0) {
            RestDebugConfig.setOkHttpAttemptConnectionDelay(i2);
        }
        RestDebugConfig.setEnableNetworkStatForHttp2("1".equals(this.enableNetworkStatForHttp2));
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, BeanConstants.PREFS_KEY_USE_NEW_HOME, Boolean.valueOf(TextUtils.equals("1", this.newHomepage)));
        if (!TextUtils.isEmpty(this.interval_millis) && Integer.valueOf(this.interval_millis).intValue() > 0) {
            PollInitUtils.getInstance().updateIntervalTime(this.interval_millis);
        }
        if (!TextUtils.isEmpty(this.polling_switch)) {
            PollInitUtils.getInstance().updatePollingSwitch(this.polling_switch);
        }
        LogUtil.i("mwsettings", "LangbridgeSettings  " + this.LangbridgeSettings);
        if (!TextUtils.isEmpty(this.LangbridgeSettings)) {
            a.a.LangbridgeSettings = this.LangbridgeSettings;
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_updateSettings").data("config", this.LangbridgeSettings), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        }
        if (!TextUtils.isEmpty(this.JSHookURL)) {
            a.a.JSHookURL = this.JSHookURL;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, SID_JS_HOOK_URL, this.JSHookURL);
            LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "init config JSHookURL = " + this.JSHookURL);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data(SavedStateHandle.KEYS, new String[]{"common", "multi-webview"}), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        }
        if (f3599i) {
            f3599i = false;
            if (!TextUtils.isEmpty(this.fp)) {
                String decrypt = SafePay.getInstance().decrypt(this.fp);
                if (!TextUtils.isEmpty(decrypt) && !decrypt.equals(BdWalletUtils.getDeviceFP(context))) {
                    BdWalletUtils.setDeviceFP(context, decrypt);
                }
            }
            if (!TextUtils.isEmpty(this.kefuPhoneNum)) {
                BdWalletUtils.setKefuPhoneNumToSP(context, this.kefuPhoneNum);
            }
            if (!TextUtils.isEmpty(this.langbridgeSpeedUp)) {
                a.a.langbridgeSpeedUp = this.langbridgeSpeedUp;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, a, this.langbridgeSpeedUp);
            }
            if (!TextUtils.isEmpty(this.passAuthUrl)) {
                a.a.passAuthUrl = this.passAuthUrl;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, b, this.passAuthUrl);
            }
            a.a.paymentCodeUrl = this.paymentCodeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, c, this.paymentCodeUrl);
            a.a.transactionRecordsUrl = this.transactionRecordsUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, h, this.transactionRecordsUrl);
            a.a.balanceHomeUrl = this.balanceHomeUrl;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, d, this.balanceHomeUrl);
            if (!TextUtils.isEmpty(this.whiteScreenConfig)) {
                a.a.whiteScreenConfig = this.whiteScreenConfig;
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f, this.whiteScreenConfig);
            }
            a.a.fp = this.fp;
            a.a.kefuPhoneNum = this.kefuPhoneNum;
            a.a.enableJsNameVerify = this.enableJsNameVerify;
            a.a.loginUrl = this.loginUrl;
            a.a.certWhiteList = this.certWhiteList;
            a.a.jsipc = this.jsipc;
            a.a.publicKeyPins = this.publicKeyPins;
            a.a.langbridgeSpeedUp = this.langbridgeSpeedUp;
            a.a.langbridgeCheckProtocol = this.langbridgeCheckProtocol;
            a.a.passAuthUrl = this.passAuthUrl;
            a.a.domainSwitch = this.domainSwitch;
            a.a.domainConfig = this.domainConfig;
            a.a.rtcConfig = this.rtcConfig;
            a.a.paymentCodeUrl = this.paymentCodeUrl;
            a.a.balanceHomeUrl = this.balanceHomeUrl;
            a.a.transactionRecordsUrl = this.transactionRecordsUrl;
            a.a.takePicWaitTime = this.takePicWaitTime;
            a.a.cookiesSyncDomainList = this.cookiesSyncDomainList;
            a.a.sdk_permission_dialog = this.sdk_permission_dialog;
            a.a.langbridge_permission_dialog = this.langbridge_permission_dialog;
            a.a.permission_dialog_info = this.permission_dialog_info;
            a.a.permission_dialog_contacts = this.permission_dialog_contacts;
            a.a.permission_dialog_location = this.permission_dialog_location;
            a.a.permission_dialog_camera = this.permission_dialog_camera;
            a.a.permission_dialog_audio = this.permission_dialog_audio;
            a.a.permission_dialog_storage = this.permission_dialog_storage;
            a.a.supportZxingScanCode = this.supportZxingScanCode;
            a.a.supportBarCode = this.supportBarCode;
            a.a.multipleMaxCount = this.multipleMaxCount;
            a.a.scanCodePEOptimization = this.scanCodePEOptimization;
            a.a.scanCodePEImageDynamicCrop = this.scanCodePEImageDynamicCrop;
            a.a.scanCodePEImageCollectInterval = this.scanCodePEImageCollectInterval;
            a.a.scanCodePEImageCollectLimit = this.scanCodePEImageCollectLimit;
            a.a.scanCodePEImageCollectFromAlbum = this.scanCodePEImageCollectFromAlbum;
            a.a.cleanHomePageCache = this.cleanHomePageCache;
            a.a.j = false;
            a.a.permissionAllowDomainList = this.permissionAllowDomainList;
            if (!TextUtils.isEmpty(this.cookiesSyncDomainList)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, e, this.cookiesSyncDomainList);
            }
            a.a.needShowLoadingInterval = this.needShowLoadingInterval;
            a.a.loadingDurationInterval = this.loadingDurationInterval;
            if (!TextUtils.isEmpty(this.loadingDurationInterval)) {
                SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, g, this.loadingDurationInterval);
            }
            a.a.langbridgeSafeCheckFromURL = this.langbridgeSafeCheckFromURL;
            a.a.enableNetworkStatForHttp2 = this.enableNetworkStatForHttp2;
            if (!TextUtils.isEmpty(this.rpa_pages_config) && !TextUtils.equals(a.a.rpa_pages_config, this.rpa_pages_config)) {
                a.a.rpa_pages_config = this.rpa_pages_config;
                if (LocalRouter.getInstance(context).isProviderExisted("rpaAutomationProvider")) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("rpaAutomationProvider").action("rpaAutomationFileDownload").data("rpaConfig", this.rpa_pages_config), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                        }
                    });
                }
            }
            try {
                LogUtil.d("Domains", "parse the online jsipc: " + this.jsipc);
                Domains.getInstance().setDomainsPermissionConfig(Permission.parseDomainsConfig(this.jsipc));
            } catch (JSONException e2) {
                LogUtil.logd(e2.getMessage());
            }
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_setJsNameVerfiy").data("enableJsNameVerify", this.enableJsNameVerify), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                }
            });
            if (!TextUtils.equals(a.a.lbNewMethods, this.lbNewMethods)) {
                a.a.lbNewMethods = this.lbNewMethods;
                LbAbilityNewWayUtils.setAbilityNewWayMethods(a.a.lbNewMethods);
            }
        }
    }

    public String toString() {
        return ExtendedMessageFormat.START_FE + super.toString() + ", useOkHttp='" + this.useOkHttp + ExtendedMessageFormat.QUOTE + ", enableHE='" + this.enableHE + ExtendedMessageFormat.QUOTE + ", enableNetStat='" + this.enableNetStat + ExtendedMessageFormat.QUOTE + ", attemptDelay=" + this.attemptDelay + ExtendedMessageFormat.QUOTE + ", mwSettings=" + this.LangbridgeSettings + ExtendedMessageFormat.QUOTE + ", supportZxingScanCode" + this.supportZxingScanCode + ExtendedMessageFormat.QUOTE + ", supportBarCode" + this.supportBarCode + ExtendedMessageFormat.QUOTE + ", scanCodePEOptimization" + this.scanCodePEOptimization + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    public void updateOfflineCacheConfig(Context context, String str) {
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("langbrige").action("langbrige_offlineCacheConfig").data("config", str), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }
}
