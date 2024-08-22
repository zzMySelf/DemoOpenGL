package com.baidu.webkit.internal.blink;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.cloudsetting.CloudSettingSDK;
import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.internal.daemon.QuicPreConnect;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.utils.DeviceInfo;
import com.baidu.webkit.internal.utils.ProcessUtils;
import com.baidu.webkit.internal.whiteandblacklist.WhiteAndBlackListSDK;
import com.baidu.webkit.internal.whiteandblacklist.a;
import com.baidu.webkit.net.BdNetEngine;
import com.baidu.webkit.sdk.ICronetListenerInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.abtest.ABTestSDK;
import com.unionpay.tsmservice.mi.data.Constant;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSettingsGlobalBlink implements INoProGuard {
    private static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    private static final String DEFAULT_MULTIPROCESS_MODELS = "TRT-AL00A,TRT-AL00,TRT-TL10A,TRT-TL10,SLA-AL00,SLA-TL10,DLI-AL10,DLI-TL20,SM-C5000";
    private static final String DEFAULT_SECRECT_KEY = "SFIyRVI=";
    private static final String ENGINE_STAT_URL = "https://browserkernel.baidu.com/timing_txt/browser7_7.searchbox8_3.js.encrypt";
    private static final String FAKE_BAIDU_URL = "https://browserkernel.baidu.com/fakebaidu";
    private static final String HTTP_DNS_URL_HOST = "https://httpsdns.baidu.com/v6/0010";
    private static final String HTTP_DNS_URL_IP = "https://180.76.76.112/v6/0010";
    private static final String KEY_GUM_WHITE_LIST = "gum_white_list";
    protected static final String LOGTAG = "WebSettingsGlobalBlink";
    private static final String MF_JS_URL = "https://browserkernel.baidu.com/adblock/magicfilter.js?";
    private static final String ML_MODEL_URL = "https://browserkernel.baidu.com/ml_model/";
    private static final int MP_MIN_AVAILABLE_MEMORY = 500;
    private static final String PAC_URL = "https://browserkernel.baidu.com/pac-version2.0/spdy.conf.txt";
    private static String PREF_KEY_MULTIPROCESS_DISABLED = "zeus_multiprocess_disabled";
    private static String PREF_KEY_RENDER_CRASHES = "zeus_render_crashes";
    private static String PREF_NAME_MULTIPROCESS = "zeus_preferences_multiprocess";
    private static long RENDER_CRASH_LOG_TIMEOUT = 3600000;
    private static final String SESSION_UPLOAD_URL = "https://browserkernel.baidu.com/kw?r_en=true&type=";
    protected static final String SETTING_IMPL_CLASS = "com.baidu.blink.WebSettingsGlobalProxy";
    private static final String SKELENTON_JS_URL = "https://browserkernel.baidu.com/skeleton/collect_link.js?";
    private static final String ZEUS_RESOURCE_URL = "https://browserkernel.baidu.com/integration.php";
    public static int httpDnsSource = 0;
    private static String mBrowserVersion = null;
    private static boolean mChromiumNetInit = false;
    private static boolean mCronetEnable = true;
    private static final String mDateFomat = "yyyy-MM-dd HH:mm:ss";
    private static HashSet<String> mFCCheatBlackList = new HashSet<>();
    private static boolean mFirstGetLogEnable;
    private static HashMap<String, Boolean> mGetUserMediaConfirmed = new HashMap<>();
    private static boolean mHijackEnv;
    private static Map<String, String> mHttpDnsCacheMap = new HashMap();
    /* access modifiers changed from: private */
    public static boolean mHttpDnsNetChangedAfterPause;
    /* access modifiers changed from: private */
    public static long mHttpDnsUpdateTime;
    /* access modifiers changed from: private */
    public static boolean mHttpDnsUpdated;
    private static boolean mIpv6HttpdnsEnv;
    /* access modifiers changed from: private */
    public static boolean mIsAlive = true;
    private static boolean mLogEnable;
    private static WebSettings.ProxyType mProxyType = WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY;
    private static long mQuicCheckTime;
    private static boolean mQuicDefaultOpen;
    private static boolean mQuicInit;
    private static Object mSelfLock = new Object();
    private static long mSoHandler;
    private static long mTotalMem = 2048;
    private static boolean mUseT5Log;
    private static Map<String, JSONArray> mWhiteAndBlackList = new HashMap();
    private static HashSet<String> sBlackListModels;
    private static HashSet<String> sDeviceSet;
    private static boolean sDitingMaxHit;
    private static JSONObject sMf30InitInfo;
    private static Boolean sMultiprocessEnabled;
    private static long sNativeV8FunctionTablePointer;
    private static final List<ValueCallback<Long>> sOnCronetThreadInitializedListenerList = new ArrayList();
    public static int zeusNetLogLevel;
    public static boolean zeusNetLogLevelSetted;

    public static boolean getDitingMaxHit() {
        return sDitingMaxHit;
    }

    public static void setDitingMaxHit(boolean z) {
        sDitingMaxHit = z;
    }

    static void reset() {
    }

    public static void kernelLog(String str, String str2) {
        if (!mFirstGetLogEnable && WebKitFactory.getCurEngine() == 1) {
            mLogEnable = getPFLogEnabled();
            Log.i(LOGTAG, "mLogEnable " + mLogEnable);
            mFirstGetLogEnable = true;
        }
        if (mLogEnable) {
            Log.i(str, str2);
        }
    }

    public static boolean getPFLogEnabled() {
        try {
            if (WebKitFactory.getCurEngine() != 1 || !WebViewFactory.hasProvider()) {
                return false;
            }
            return WebViewFactory.getProvider().getSettingsStatics().getPFLogEnabled();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            Log.e(LOGTAG, "getPFLogEnabled error:".concat(String.valueOf(th2)));
            return false;
        }
    }

    public static int getLogLevel() {
        try {
            if (WebKitFactory.getCurEngine() != 1 || !WebViewFactory.hasProvider()) {
                return -1;
            }
            return WebViewFactory.getProvider().getSettingsStatics().getLogLevel();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return -1;
        } catch (Throwable th2) {
            Log.e(LOGTAG, "getLogLevel error:".concat(String.valueOf(th2)));
            return -1;
        }
    }

    public static boolean getChromiunNetInit() {
        try {
            if (WebKitFactory.getCurEngine() != 1 || !WebViewFactory.hasProvider()) {
                return false;
            }
            if (mChromiumNetInit) {
                return true;
            }
            boolean chromiunNetInit = WebViewFactory.getProvider().getSettingsStatics().getChromiunNetInit();
            mChromiumNetInit = chromiunNetInit;
            return chromiunNetInit;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            Log.e(LOGTAG, "getChromiunNetInit error:".concat(String.valueOf(th2)));
            return false;
        }
    }

    public static void notifyPause() {
        mHttpDnsNetChangedAfterPause = false;
        mIsAlive = false;
        setAppStatus(false);
    }

    public static void notifyResume() {
        mIsAlive = true;
        setAppStatus(true);
        if (WebKitFactory.getNeedDownloadCloudResource() && mHttpDnsNetChangedAfterPause && getHttpDnsUpdateEnabled()) {
            mHttpDnsUpdateTime = System.currentTimeMillis();
            Log.i(LOGTAG, "notifyResume tryToUpdateHttpDnsCache");
            HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
        }
    }

    public static void initCronet(Context context) {
        if (WebViewFactory.isProviderValid()) {
            WebViewFactory.getProvider().getSettingsStatics().initCronet(context);
        }
    }

    public static Context getKernelContext() {
        if (!WebViewFactory.isProviderValid()) {
            return null;
        }
        return WebViewFactory.getProvider().getSettingsStatics().getKernelContext();
    }

    public static boolean useCronet() {
        if (WebKitFactory.getCurEngine() != 1 || !WebViewFactory.hasProvider()) {
            return false;
        }
        return WebViewFactory.getProvider().getSettingsStatics().useCronet();
    }

    public static HttpURLConnection getHttpUrlConnection(String str) {
        if (!WebViewFactory.isProviderValid()) {
            return null;
        }
        return WebViewFactory.getProvider().getSettingsStatics().getHttpUrlConnection(str);
    }

    public static String resolveHost(String str, boolean z, int i2) {
        if (!WebViewFactory.isProviderValid()) {
            return null;
        }
        return WebViewFactory.getProvider().getSettingsStatics().resolveHost(str, z, i2);
    }

    public static String getBDLog(HttpURLConnection httpURLConnection) {
        if (!WebViewFactory.isProviderValid()) {
            return null;
        }
        return WebViewFactory.getProvider().getSettingsStatics().getBDLog(httpURLConnection);
    }

    public static int getErrorCode(IOException iOException) {
        if (!WebViewFactory.hasProvider() || WebKitFactory.getCurEngine() != 1) {
            return 0;
        }
        return WebViewFactory.getProvider().getSettingsStatics().getErrorCode(iOException);
    }

    public static void setBDLogPreparedCallback(HttpURLConnection httpURLConnection, Runnable runnable) {
        if (WebViewFactory.isProviderValid()) {
            WebViewFactory.getProvider().getSettingsStatics().setBDLogPreparedCallback(httpURLConnection, runnable);
        }
    }

    public static boolean getCronetEnable() {
        try {
            if (!CloudSettingSDK.isOpppEnabledCronetEnabled() || Build.VERSION.SDK_INT != 23 || DeviceInfo.MODEL.indexOf("OPPO") == -1) {
                if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                    boolean z = CfgFileUtils.get(CfgFileUtils.KEY_CRONET_AB_STAT, true);
                    mCronetEnable = z;
                    if (!z) {
                        return false;
                    }
                    Log.e(LOGTAG, "mCronetEnable");
                    boolean cronetEnable = WebViewFactory.getProvider().getSettingsStatics().getCronetEnable();
                    mCronetEnable = cronetEnable;
                    return cronetEnable;
                }
                return false;
            }
            Log.e(LOGTAG, "mCronetEnable false");
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Log.e(LOGTAG, "getCronetEnable error:".concat(String.valueOf(th2)));
        }
    }

    public static void initNet() {
        Log.e(LOGTAG, "initNet1");
        if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
            Log.e(LOGTAG, "initNet2");
            WebViewFactory.getProvider().initNet();
            Log.e(LOGTAG, "initNet3");
        }
    }

    public static void chromiumNetInit(long j2) {
        initCronet(getKernelContext());
        mSoHandler = j2;
        synchronized (BdNetEngine.mSelfLock) {
            Log.w(LOGTAG, "chromiunNetInit notifyAll");
            BdNetEngine.mSelfLock.notifyAll();
        }
        String str = null;
        try {
            str = CfgFileUtils.get(CfgFileUtils.KEY_ALT_SERVICE, (String) null);
        } catch (Throwable th2) {
            Log.e(LOGTAG, "get KEY_ALT_SERVICE error: ".concat(String.valueOf(th2)));
        }
        if (str != null) {
            setAltServiceToBlink(str);
        }
        setNeedDownloadCloudResource(WebKitFactory.getNeedDownloadCloudResource());
        ICronetListenerInterface cronetListenerInterface = WebViewFactory.getCronetListenerInterface();
        if (cronetListenerInterface != null) {
            Log.e(LOGTAG, "ICronetListenerInterface not null");
            cronetListenerInterface.notifyCronetInit();
            return;
        }
        Log.e(LOGTAG, "ICronetListenerInterface null");
    }

    public static void addOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        List<ValueCallback<Long>> list = sOnCronetThreadInitializedListenerList;
        Log.i(LOGTAG, "addOnCronetThreadInitializedListener. listener=%s, list size=%d", valueCallback, Integer.valueOf(list.size()));
        synchronized (list) {
            long j2 = sNativeV8FunctionTablePointer;
            if (j2 != 0) {
                valueCallback.onReceiveValue(Long.valueOf(j2));
            } else {
                list.add(valueCallback);
            }
        }
    }

    public static void removeOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        List<ValueCallback<Long>> list = sOnCronetThreadInitializedListenerList;
        synchronized (list) {
            list.remove(valueCallback);
        }
    }

    public static void notifyAllOnCronetThreadInitializedListener(long j2) {
        List<ValueCallback<Long>> list = sOnCronetThreadInitializedListenerList;
        Log.i(LOGTAG, "NotifyAllOnCronetThreadInitializedListener. nativeTablePointer=%d, list size=%d", Long.valueOf(j2), Integer.valueOf(list.size()));
        synchronized (list) {
            sNativeV8FunctionTablePointer = j2;
            for (ValueCallback<Long> onReceiveValue : list) {
                onReceiveValue.onReceiveValue(Long.valueOf(j2));
            }
            sOnCronetThreadInitializedListenerList.clear();
        }
    }

    public static void updateHttpDns() {
        ZeusThreadPoolUtil.execute(new Runnable() {
            public final void run() {
                if (WebKitFactory.getNeedDownloadCloudResource() && WebSettingsGlobalBlink.getHttpDnsUpdateEnabled()) {
                    if (!WebSettingsGlobalBlink.mHttpDnsUpdated) {
                        boolean unused = WebSettingsGlobalBlink.mHttpDnsUpdated = true;
                        Log.i(WebSettingsGlobalBlink.LOGTAG, "updateHttpDns first download");
                        long unused2 = WebSettingsGlobalBlink.mHttpDnsUpdateTime = System.currentTimeMillis();
                        HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
                    } else if (WebSettingsGlobalBlink.mIsAlive) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        Log.i(WebSettingsGlobalBlink.LOGTAG, "updateHttpDns net change");
                        long unused3 = WebSettingsGlobalBlink.mHttpDnsUpdateTime = System.currentTimeMillis();
                        HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
                    } else {
                        Log.i(WebSettingsGlobalBlink.LOGTAG, "updateHttpDns net background");
                        boolean unused4 = WebSettingsGlobalBlink.mHttpDnsNetChangedAfterPause = true;
                    }
                }
            }
        });
    }

    public static void setAltService(String str) {
        CfgFileUtils.set(CfgFileUtils.KEY_ALT_SERVICE, str);
    }

    public static void setMagicFilterModelSize(long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mf_size", j2);
            jSONObject.put("type", 16391);
            SessionMonitorEngine.getInstance().recordImmediately("sailor_monitor", jSONObject.toString());
        } catch (Throwable th2) {
            Log.printStackTrace(th2);
        }
    }

    public static void uploadBuildinJsInfo(String str, String str2, String str3) {
        if (str2.equals("checked_by_max")) {
            setDitingMaxHit(true);
            if (!matchCloudSettingSampling(CloudSettingSDK.getDitingMaxUploadRateValue())) {
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("requestUrl", "buildin");
                jSONObject.put("feature", str2);
                if (str3.length() > 100) {
                    jSONObject.put("file_data", new String(Base64.encode(str3.getBytes(), 0)));
                }
                jSONObject.put("type", 12301);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            Log.i(LOGTAG, "[diting] recordImmediately :" + jSONObject.toString());
            SessionMonitorEngine.getInstance().recordImmediately("sailor_monitor", jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void uploadMF30InitInfo(long j2, long j3, long j4, long j5, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vm_size_in_smaps", j2);
                jSONObject.put("vm_max_slice", j3);
                jSONObject.put("vm_size_available", j4);
                jSONObject.put("pm_size_available", j5);
                jSONObject.put("in_good_state", z ? 1 : 0);
                jSONObject.put("type", 12303);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            sMf30InitInfo = jSONObject;
            Log.i(LOGTAG, "uploadMF30InitInfo :" + jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setMf30InitInfo(JSONObject jSONObject) {
        sMf30InitInfo = jSONObject;
    }

    public static JSONObject getMf30InitInfo() {
        return sMf30InitInfo;
    }

    public static void checkHttpDnsUpdate() {
        if (WebKitFactory.getNeedDownloadCloudResource() && getHttpDnsUpdateEnabled()) {
            int httpdnsCheckIntervalValue = CloudSettingSDK.getHttpdnsCheckIntervalValue();
            Log.i(LOGTAG, "defaultHttpDnsInterval ".concat(String.valueOf(httpdnsCheckIntervalValue)));
            if (System.currentTimeMillis() - mHttpDnsUpdateTime > ((long) (httpdnsCheckIntervalValue * 1000))) {
                mHttpDnsUpdateTime = System.currentTimeMillis();
                HttpDnsCache.tryToUpdateHttpDnsCacheStaticIP(WebViewFactory.getContext());
            }
        }
    }

    public static long getChromiumHandle() {
        return mSoHandler;
    }

    public static int getSavingBytes() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSavingBytes();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            Log.w(LOGTAG, "getSavingBytes error:".concat(String.valueOf(th2)));
            return 0;
        }
    }

    public static void clearSavingBytes() {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().clearSavingBytes();
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Log.w(LOGTAG, "clearSavingBytes error:".concat(String.valueOf(th2)));
        }
    }

    public static int getNetworkFlow() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getNetworkFlow();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            Log.w(LOGTAG, "getNetworkFlow error:".concat(String.valueOf(th2)));
            return 0;
        }
    }

    public static int getUpTraffic() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getUpTraffic();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            Log.w(LOGTAG, "getUpTraffic error:".concat(String.valueOf(th2)));
            return 0;
        }
    }

    public static int getDownTraffic() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getDownTraffic();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            Log.w(LOGTAG, "getDownTraffic error:".concat(String.valueOf(th2)));
            return 0;
        }
    }

    public static void clearNetworkFlow() {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().clearNetworkFlow();
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Log.w(LOGTAG, "clearNetworkFlow error:".concat(String.valueOf(th2)));
        }
    }

    public static void setEnableSpdy(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEnableSpdy(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setCronetEnable(boolean z) {
        Log.w(LOGTAG, "setCronetEnable ".concat(String.valueOf(z)));
        mCronetEnable = z;
        CfgFileUtils.set(CfgFileUtils.KEY_CRONET_AB_STAT, z);
    }

    public static void setConThreshold(int i2) {
        try {
            Log.w(LOGTAG, "setConThreshold ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setConThreshold(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setQuicThreshold(int i2) {
        try {
            Log.w(LOGTAG, "setQuicThreshold ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setQuicThreshold(i2);
                if (i2 != -1 && !WebViewFactory.getProvider().getSettingsStatics().getQuicInit()) {
                    QuicPreConnect.tryToQuicPreConnect(WebKitFactory.getContext());
                }
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void checkQuicConnection() {
        try {
            if (WebViewFactory.hasProvider() && mQuicDefaultOpen && !mQuicInit && System.currentTimeMillis() - mQuicCheckTime > 10000) {
                Log.w(LOGTAG, "checkQuicConnection1 ");
                boolean quicInit = WebViewFactory.getProvider().getSettingsStatics().getQuicInit();
                mQuicInit = quicInit;
                if (!quicInit) {
                    Log.w(LOGTAG, "checkQuicConnection2 ");
                    mQuicCheckTime = System.currentTimeMillis();
                    QuicPreConnect.tryToQuicPreConnect(WebKitFactory.getContext());
                }
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setKeepAliveTime(int i2) {
        try {
            Log.w(LOGTAG, "setKeepAliveTime ".concat(String.valueOf(i2)));
            CfgFileUtils.set(CfgFileUtils.KEY_KEEP_ALIVE_TIME, String.valueOf(i2));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setKeepAliveTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setBackupJobDelayTime(int i2) {
        try {
            Log.w(LOGTAG, "setBackupJobDelayTime ".concat(String.valueOf(i2)));
            CfgFileUtils.set(CfgFileUtils.KEY_BACK_DNS_TIME, String.valueOf(i2));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setBackupJobDelayTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setBackupDnsJobDelayTime(int i2) {
        try {
            Log.w(LOGTAG, "setBackupDnsJobDelayTime ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setBackupDnsJobDelayTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setBackupLandingJobDelayTime(int i2) {
        try {
            Log.w(LOGTAG, "setBackupLandingJobDelayTime ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setBackupLandingJobDelayTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setSocketGroupNumber(int i2) {
        try {
            Log.w(LOGTAG, "setSocketGroupNumber ".concat(String.valueOf(i2)));
            CfgFileUtils.set(CfgFileUtils.KEY_SOCKET_GROUP_NUMBER, String.valueOf(i2));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSocketGroupNumber(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setIPV6Timeout(int i2) {
        try {
            Log.w(LOGTAG, "setIPV6Timeout ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setIPV6Timeout(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setIPV6CheckList(String str) {
        try {
            Log.w(LOGTAG, "setIPV6CheckList ".concat(String.valueOf(str)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setIPV6CheckList(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setPreConnectEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setPreConnectEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPreConnectEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void addPreConnectPrefixes(String str) {
        try {
            Log.w(LOGTAG, "addPreConnectPrefixes ".concat(String.valueOf(str)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().addPreConnectPrefixes(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setPopupWindowOptEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setPopupWindowOptEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPopupWindowOptEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setSearchFrameQuicEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setSearchFrameQuicEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSearchFrameQuicEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setQuicDefaultOpen(boolean z) {
        try {
            Log.w(LOGTAG, "setQuicDefaultOpen ".concat(String.valueOf(z)));
            mQuicDefaultOpen = z;
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setQuicDefaultOpen(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setIpv6HttpdnsEnv(boolean z) {
        Log.w(LOGTAG, "setIpv6HttpdnsEnv ".concat(String.valueOf(z)));
        try {
            CfgFileUtils.set(CfgFileUtils.KEY_HTTP_DNS_IPV6_ENV, z);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean getIpv6HttpdnsEnv() {
        try {
            boolean z = CfgFileUtils.get(CfgFileUtils.KEY_HTTP_DNS_IPV6_ENV, false);
            Log.i(LOGTAG, "getIpv6HttpdnsEnv ".concat(String.valueOf(z)));
            return z;
        } catch (Exception e2) {
            Log.e(LOGTAG, "getIpv6HttpdnsEnv error: ".concat(String.valueOf(e2)));
            return false;
        }
    }

    public static void setIpv6First(boolean z) {
        try {
            Log.w(LOGTAG, "setIpv6First ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setIpv6First(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setFileInIOEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setFileInIOEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setFileInIOEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setNetWorkChangeNotifyEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setNetWorkChangeNotifyEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setNetWorkChangeNotifyEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setMulripleConnectEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setMulripleConnectEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setMulripleConnectEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setWormholeEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setWormholeEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setWormholeEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setNeedDownloadCloudResource(boolean z) {
        try {
            Log.w(LOGTAG, "setNeedDownloadCloudResource ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setNeedDownloadCloudResource(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setTcSpeedUpEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setTcSpeedUpEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setTcSpeedUpEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setAppStatus(boolean z) {
        try {
            Log.w(LOGTAG, "setAppStatus ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setAppStatus(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setHttpDnsUpdateEnabled(boolean z) {
        Log.w(LOGTAG, "setHttpDnsUpdateEnabled ".concat(String.valueOf(z)));
        CfgFileUtils.set(CfgFileUtils.KEY_HTTPDNS_AB_STAT, z);
    }

    public static boolean getHttpDnsUpdateEnabled() {
        try {
            return CfgFileUtils.get(CfgFileUtils.KEY_HTTPDNS_AB_STAT, true);
        } catch (Throwable th2) {
            Log.e(LOGTAG, "getHttpDnsUpdateEnabled error:".concat(String.valueOf(th2)));
            return false;
        }
    }

    public static void setSubResourceMonitorEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setSubResourceMonitorEnabled ".concat(String.valueOf(z)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSubResourceMonitorEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setFreeFlow(boolean z) {
        Log.w(LOGTAG, "setFreeFlow ".concat(String.valueOf(z)));
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setFreeFlow(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setVideoPlayerMode(int i2) {
        Log.w(LOGTAG, "setVideoPlayerMode ".concat(String.valueOf(i2)));
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setVideoPlayerMode(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean canUseFreeFlow() {
        Log.w(LOGTAG, "canUseFreeFlow called");
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().canUseFreeFlow();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void setClientIP(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setClientIP(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean isFeedProxyAdUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().isFeedProxyAdUrl(str);
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean isFeedNoProxyAdUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().isFeedNoProxyAdUrl(str);
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void setMainLinkDirectEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setMainLinkDirectEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setSpdyCompressEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSpdyCompressEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setWebessenseEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setWebessenseEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setSessionHeaderEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSessionHeaderEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setOnePacketEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setOnePacketEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setSpdyEncryptionEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSpdyEncryptionEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setPacData(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPacData(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setPacDataFreeFlow(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPacDataFreeFlow(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setAltServiceToBlink(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setAltServiceToBlink(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setCloudSettingsToT5(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setCloudSettingsToT5(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setHttpDnsCache(String str, int i2) {
        try {
            httpDnsSource = i2;
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setHttpDnsCache(str, i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setHttpDnsDnFailed(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setHttpDnsDnFailed(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getDnsInfoEngine(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getDnsInfo(str);
            }
            return "";
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static void removeDnsInfoEngine(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().removeDnsInfo(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getHttpDnsUrlIP() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getHttpDnsUrl();
            }
            if (str == null || str.length() <= 0) {
                return HTTP_DNS_URL_IP;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return HTTP_DNS_URL_IP;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return HTTP_DNS_URL_IP;
        }
    }

    public static String getHttpDnsUrlHOST() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getHttpDnsUrl();
            }
            if (str == null || str.length() <= 0) {
                return HTTP_DNS_URL_HOST;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return HTTP_DNS_URL_HOST;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return HTTP_DNS_URL_HOST;
        }
    }

    public static boolean getMainLinkDirectEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMainLinkDirectEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean getWebessenseEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWebessenseEnabled();
            }
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public static boolean getSessionHeaderEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSessionHeaderEnabled();
            }
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public static boolean getOnePacketEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getOnePacketEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean getSpdyEncryptionEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSpdyEncryptionEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean getSpdyCompressEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSpdyCompressEnabled();
            }
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public static boolean getSysProxyEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSysProxyEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static int getPopupWindowNum() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getPopupWindowNum();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public static int getKeepAliveTime() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getKeepAliveTime();
            }
            return -1;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return -1;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static int getSocketGroupNumber() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSocketGroupNumber();
            }
            return -1;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return -1;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static int getQuicThreshold() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getQuicThreshold();
            }
            return -1;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return -1;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static boolean getSendRequestEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSendRequestEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void setEnableEngineStat(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEnableEngineStat(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setT5SDKSpdyEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setT5SDKSpdyEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean getEnableSpdy() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableSpdy();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean getEnableEngineStat() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableEngineStat();
            }
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public static void setEnableProxy(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEnableProxy(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean getEnableProxy() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableProxy();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean shouldAccessNetworkOverSpdy(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().shouldAccessNetworkOverSpdy(str);
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static int getNetworkSpeed() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getNetworkSpeed();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public static int getSearchDnsMiss() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSearchDnsMiss();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public static int getNetworkRtt() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getNetworkRtt();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public static boolean getSpdy31Enabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSpdy31Enabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean getHttp2Enabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getHttp2Enabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean getWormholeEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWormholeEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean getIpv6Env() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getIpv6Env();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static int getNQE() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getNQE();
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public static boolean getSubResourceMonitorEnabled() {
        return CloudSettingSDK.isSubResourceMonitorEnabled();
    }

    public static String getWormholeForbidenHost() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWormholeForbidenHost();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String getPageFeature(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getPageFeature(str);
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static int getWormholeNum(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWormholeNum(i2);
            }
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public static void setImgQuality(WebSettings.ImgQuality imgQuality) {
    }

    public static WebSettings.ImgQuality getImgQuality() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getImgQuality();
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return WebSettings.ImgQuality.NO_COMPRESS;
    }

    public static void setGifOneFrameEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setGifOneFrameEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean getGifOneFrameEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getGifOneFrameEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setRemoveAdLevel(removeAdLevel);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static WebSettings.RemoveAdLevel getRemoveAdLevel() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getRemoveAdLevel();
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return WebSettings.RemoveAdLevel.DISABLE;
    }

    public static void setStatisticParam(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setStatisticParam(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setCuid(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setCuid(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getCuid() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getCuid();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static void setAppId(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setAppId(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getHttpDnsCache() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getHttpDnsCache();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String getPacUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getPacUrl();
            }
            if (str == null || str.length() <= 0) {
                return PAC_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return PAC_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return PAC_URL;
        }
    }

    public static String getMfJsUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getMfJsUrl();
            }
            if (str == null || str.length() <= 0) {
                return MF_JS_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return MF_JS_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return MF_JS_URL;
        }
    }

    public static String getEngineStatUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getEngineStatUrl();
            }
            if (str == null || str.length() <= 0) {
                return ENGINE_STAT_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return ENGINE_STAT_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return ENGINE_STAT_URL;
        }
    }

    public static String getFakeBaiduUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getFakeBaiduUrl();
            }
            if (str == null || str.length() <= 0) {
                return FAKE_BAIDU_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return FAKE_BAIDU_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return FAKE_BAIDU_URL;
        }
    }

    public static String getMLModelUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getMLModelUrl();
            }
            if (str == null || str.length() <= 0) {
                return ML_MODEL_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return ML_MODEL_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return ML_MODEL_URL;
        }
    }

    public static boolean getMF30Inited() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMF30Inited();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public static boolean getInNovelSiteList(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getInNovelSiteList(str);
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public static boolean getInVideoSiteList(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getInVideoSiteList(str);
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static String getSubResourceTiming() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSubResourceTiming();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String getQuicInfo() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getQuicInfo();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String getCloudSettingUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getCloudSettingUrl();
            }
            if (str == null || str.length() <= 0) {
                return CLOUD_SETTING_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return CLOUD_SETTING_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return CLOUD_SETTING_URL;
        }
    }

    public static String getSessionUploadUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getSessionUploadUrl();
            }
            if (TextUtils.isEmpty(str)) {
                str = CloudSettingSDK.getSessionUploadUrlValue();
            }
        } catch (Throwable th2) {
            Log.printStackTrace(th2);
        }
        return !TextUtils.isEmpty(str) ? str : SESSION_UPLOAD_URL;
    }

    public static String getRc4SecrectKey() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getRc4SecrectKey();
            }
            if (str == null || str.length() <= 0) {
                return new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0));
            }
            return new String(Base64.decode(str.getBytes(), 0));
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0));
        }
    }

    public static String getCloudHost() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getCloudHost();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String getQuicHost() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getQuicHost();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String getLocalDns() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getLocalDns();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String getHttpCode() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getHttpCode();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static void setPacUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPacUrl(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setEngineStatUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEngineStatUrl(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getAppId() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getAppId();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static void setProxyInfo(String str, String[] strArr) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setProxyInfo(str, strArr);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getProxyInfo() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getProxyInfo();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static void setSendEngineUsageInfoEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSendEngineUsageInfoEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Deprecated
    public static boolean getSendEngineUsageInfoEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSendEngineUsageInfoEnabled();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void setEnableZeusManager(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEnableZeusManager(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean getEnableZeusManager() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableZeusManager();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void setZeusManagerPkgName(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setZeusManagerPkgName(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getZeusManagerPkgName() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getZeusManagerPkgName();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static void setSpdyTimeout(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSpdyTimeout(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setTimgConfUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setTimgConfUrl(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setFastPac(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setFastPac(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getTimgConfUrl() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getTimgConfUrl();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static void setTimgConfData(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setTimgConfData(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void kernelEncrypt(byte[] bArr, int i2, byte[] bArr2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().kernelEncrypt(bArr, i2, bArr2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setHijackEnv(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setHijackEnv(z);
                mHijackEnv = z;
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getZeusResourceUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getZeusResourceUrl();
                Log.i("ZeusSkeletonController", " getZeusResourceUrl url = ".concat(String.valueOf(str)));
            }
            if (str == null || str.length() <= 0) {
                return ZEUS_RESOURCE_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return ZEUS_RESOURCE_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return ZEUS_RESOURCE_URL;
        }
    }

    public static String getSkeletonJsUrl() {
        String str = null;
        try {
            if (WebViewFactory.hasProvider()) {
                str = WebViewFactory.getProvider().getSettingsStatics().getSkeletonJsUrl();
                Log.i("ZeusSkeletonController", " getSkeletonJsUrl url = ".concat(String.valueOf(str)));
            }
            if (str == null || str.length() <= 0) {
                return SKELENTON_JS_URL;
            }
            return str;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return SKELENTON_JS_URL;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return SKELENTON_JS_URL;
        }
    }

    public static boolean getHijackEnv() {
        return mHijackEnv;
    }

    public static void setProxyType(WebSettings.ProxyType proxyType) {
        try {
            if (WebViewFactory.hasProvider()) {
                Log.w(LOGTAG, "setProxyType ".concat(String.valueOf(proxyType)));
                if (WebSettings.ProxyType.NO_PROXY == proxyType) {
                    WebViewFactory.getProvider().getSettingsStatics().setProxyType(0);
                } else if (WebSettings.ProxyType.SPDY_PROXY == proxyType) {
                    WebViewFactory.getProvider().getSettingsStatics().setProxyType(1);
                } else if (WebSettings.ProxyType.OVERSEAS_PROXY == proxyType) {
                    WebViewFactory.getProvider().getSettingsStatics().setProxyType(2);
                } else if (WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY == proxyType) {
                    WebViewFactory.getProvider().getSettingsStatics().setProxyType(3);
                }
                mProxyType = proxyType;
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static WebSettings.ProxyType getProxyType() {
        return mProxyType;
    }

    public static void setNavigationInterceptionEnable(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setNavigationInterceptionEnable(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String getMainFrameIdInfo(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdInfo(i2);
            }
            return "";
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static String getMainFrameIdReferrer(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdReferrer(i2);
            }
            return "";
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static void removeMainFrameIdInfo(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().removeMainFrameIdInfo(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setShowWebProviderBy(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setShowWebProviderBy(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean isShowWebProviderBy() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().isShowWebProviderBy();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static String getDNSStatistic() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getDNSStatistic();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static void onZeusEnableWillChange(boolean z, boolean z2) {
        if (z != z2) {
            EngineManager.getInstance().setNeedKillProcess(true);
        }
    }

    public static void setFakeBaiduWhiteList(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setFakeBaiduWhiteList(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setMLModel(String str, String str2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setMLModel(str, str2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setEvilPageWhiteBlackListPath(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEvilPageWhiteBlackListPath(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static long generateBKDRHash(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().generateBKDRHash(str);
            }
            return -1;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return -1;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static void setDitingMaxEnabled(boolean z, boolean z2, boolean z3) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setDitingMaxEnabled(z, z2, z3);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void setInPageJudgeWhiteList(boolean z, boolean z2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setInPageJudgeWhiteList(z, z2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean isEffectiveDate(Date date, Date date2, Date date3) {
        if (date.getTime() == date2.getTime() || date.getTime() == date3.getTime()) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        Calendar instance3 = Calendar.getInstance();
        instance3.setTime(date3);
        if (!instance.after(instance2) || !instance.before(instance3)) {
            return false;
        }
        return true;
    }

    public static boolean matchCloudSettingSampling(double d2) {
        if (d2 >= 0.0d && d2 <= 1.0d) {
            return Math.random() < d2;
        }
        throw new IllegalArgumentException("defPercent must between [0.0f, 1.0f]");
    }

    public static void restoreHttpDnsCacheFromCfg() {
        HttpDnsCache.restoreLastCacheFromCfg();
    }

    public static void shouldReLoadHttpDns(boolean z) {
        if (!z) {
            try {
                if (CloudSettingSDK.isHttpDnsEnabled()) {
                    HttpDnsCache.tryToUpdateHttpDnsCache(WebKitFactory.getContext());
                }
            } catch (Throwable th2) {
                Log.w(LOGTAG, "shouldReLoadHttpDns error ".concat(String.valueOf(th2)));
            }
        }
    }

    public static String getDnsInfo(String str) {
        if (str == null) {
            return "";
        }
        try {
            String dnsInfoEngine = getDnsInfoEngine(Uri.parse(str).getHost());
            if (dnsInfoEngine != null) {
                return dnsInfoEngine;
            }
            return "";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static void removeDnsInfo(String str) {
        try {
            removeDnsInfoEngine(Uri.parse(str).getHost());
        } catch (Throwable th2) {
            Log.w(LOGTAG, "removeDnsInfo error ".concat(String.valueOf(th2)));
        }
    }

    public static void setBrowserVersion(String str) {
        mBrowserVersion = str;
    }

    public static String getBrowserVersion() {
        return mBrowserVersion;
    }

    public static boolean isSessionDataEnable() {
        return true;
    }

    public static String getPageWormHoleErrors() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getPageWormHoleErrors();
            }
            return null;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static void setGetUserMediaConfirmed(String str, Boolean bool) {
        if (str != null) {
            mGetUserMediaConfirmed.put(stripQueryAndAnchor(str), bool);
        }
    }

    @Deprecated
    public static Boolean getGetUserMediaConfirmed(String str) {
        String stripQueryAndAnchor = stripQueryAndAnchor(str);
        if (!mGetUserMediaConfirmed.containsKey(stripQueryAndAnchor) || !mGetUserMediaConfirmed.get(stripQueryAndAnchor).booleanValue()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private static String stripQueryAndAnchor(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(GameCenterUtils.SCHEME_SWAN_SUFFIX);
        if (indexOf < 0) {
            indexOf = str.indexOf("#");
        }
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private static boolean isWhiteListedDevice() {
        try {
            if (!CloudSettingSDK.isMultipleProcessDevicesEnabled()) {
                return false;
            }
        } catch (Throwable th2) {
            Log.w(LOGTAG, "isWhiteListedDevice error ".concat(String.valueOf(th2)));
        }
        boolean match = WhiteAndBlackListSDK.getInstance().match("multi_process_white_list", "MultiProcessDevice", new a(), 1);
        android.util.Log.d(LOGTAG, "isWhiteListedDevice, isMatchedrule=".concat(String.valueOf(match)));
        return match;
    }

    private static boolean isMatchedDevice(JSONObject jSONObject) throws JSONException {
        android.util.Log.d(LOGTAG, "isMatchedDevice, rule=".concat(String.valueOf(jSONObject)));
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.getString(next);
            if ("manufacturer".equals(next)) {
                if (!DeviceInfo.MANUFACTURER.equals(jSONObject.getString(next))) {
                    return false;
                }
            } else if ("model".equals(next)) {
                if (sBlackListModels == null) {
                    sBlackListModels = new HashSet<>();
                    for (String add : jSONObject.getString(next).split(",")) {
                        sBlackListModels.add(add);
                    }
                }
                Log.i(LOGTAG, "blacklist: " + sBlackListModels);
                if (!sBlackListModels.contains(DeviceInfo.MODEL)) {
                    return false;
                }
            } else if (!"sdk_int".equals(next)) {
                Log.w(LOGTAG, "unknown key: ".concat(String.valueOf(next)));
                return false;
            } else if (Build.VERSION.SDK_INT != jSONObject.getInt(next)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBlackListedDevice() {
        android.util.Log.d(LOGTAG, "manufacturer: " + DeviceInfo.MANUFACTURER);
        android.util.Log.d(LOGTAG, "build host: " + DeviceInfo.HOST);
        android.util.Log.d(LOGTAG, "version: " + Build.VERSION.INCREMENTAL);
        android.util.Log.d(LOGTAG, "SDK_INT: " + Build.VERSION.SDK_INT);
        android.util.Log.d(LOGTAG, "model: " + DeviceInfo.MODEL);
        if (!CloudSettingSDK.isMultipleProcessDevicesEnabled()) {
            return false;
        }
        boolean match = WhiteAndBlackListSDK.getInstance().match("multi_process_black_list", "MultiProcessDevice", new a(), 1);
        boolean z = (Constant.DEVICE_XIAOMI.equals(DeviceInfo.MANUFACTURER) || DeviceInfo.HOST.contains("miui")) && Build.VERSION.INCREMENTAL.split("\\.").length == 3;
        android.util.Log.d(LOGTAG, "isBlackListedDevice, isMatchedrule=" + match + " isMatchedSpecialRule=" + z);
        if (match || z) {
            return true;
        }
        return false;
    }

    public static void setRefererPattern(String str, String str2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setRefererPattern(str, str2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Log.w(LOGTAG, "getSavingBytes error:".concat(String.valueOf(th2)));
        }
    }

    public static boolean isMultiProcessEnabled() {
        Boolean bool = sMultiprocessEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!WebViewFactory.isMainAppProcess()) {
            Log.i(LOGTAG, "multiprocess not enabled for current process");
            Boolean bool2 = Boolean.FALSE;
            sMultiprocessEnabled = bool2;
            return bool2.booleanValue();
        }
        boolean z = true;
        if (WebKitFactory.getEnableMultipleProcess() != WebKitFactory.SwitchState.Invalid) {
            Log.i(LOGTAG, "multiprocess %s", WebKitFactory.getEnableMultipleProcess());
            if (WebKitFactory.getEnableMultipleProcess() != WebKitFactory.SwitchState.On) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            sMultiprocessEnabled = valueOf;
            return valueOf.booleanValue();
        }
        int minRenderEnableSdkValue = CloudSettingSDK.getMinRenderEnableSdkValue();
        if (ABTestSDK.isReady()) {
            minRenderEnableSdkValue = ABTestSDK.getZeusRenderMinSdkValue();
        }
        int maxRenderEnableSdkValue = CloudSettingSDK.getMaxRenderEnableSdkValue();
        if (ABTestSDK.isReady()) {
            maxRenderEnableSdkValue = ABTestSDK.getZeusRenderMaxSdkValue();
        }
        if (Build.VERSION.SDK_INT < minRenderEnableSdkValue || Build.VERSION.SDK_INT > maxRenderEnableSdkValue) {
            Log.i(LOGTAG, "multiprocess not enabled for current SDK version");
            Boolean bool3 = Boolean.FALSE;
            sMultiprocessEnabled = bool3;
            return bool3.booleanValue();
        }
        ActivityManager activityManager = (ActivityManager) WebViewFactory.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            android.util.Log.d(LOGTAG, "MemoryInfo.totalMem: " + (memoryInfo.totalMem >> 20) + " MB");
            android.util.Log.d(LOGTAG, "MemoryInfo.threshold: " + (memoryInfo.threshold >> 20) + " MB");
            android.util.Log.d(LOGTAG, "MemoryInfo.availMem: " + (memoryInfo.availMem >> 20) + " MB");
            android.util.Log.d(LOGTAG, "MemoryInfo.lowMemory: " + memoryInfo.lowMemory);
            if ((memoryInfo.totalMem >> 20) < mTotalMem) {
                Log.i(LOGTAG, "multiprocess not enabled for low memory device");
                Boolean bool4 = Boolean.FALSE;
                sMultiprocessEnabled = bool4;
                return bool4.booleanValue();
            }
            if (memoryInfo.availMem >= memoryInfo.threshold * 2) {
                if ((memoryInfo.availMem >> 20) >= 500) {
                    if (isBlackListedDevice()) {
                        sMultiprocessEnabled = Boolean.FALSE;
                        Log.i(LOGTAG, "multiprocess disabled for device");
                        return sMultiprocessEnabled.booleanValue();
                    } else if (isWhiteListedDevice()) {
                        Log.i(LOGTAG, "multiprocess enabled for device");
                        Boolean bool5 = Boolean.TRUE;
                        sMultiprocessEnabled = bool5;
                        return bool5.booleanValue();
                    } else {
                        try {
                            if (!CloudSettingSDK.isMultipleProcessEnabled()) {
                                Log.i(LOGTAG, "multiprocess cloud settings off");
                                Boolean bool6 = Boolean.FALSE;
                                sMultiprocessEnabled = bool6;
                                return bool6.booleanValue();
                            }
                        } catch (Throwable th2) {
                            Log.w(LOGTAG, "isMultiProcessEnabled error ".concat(String.valueOf(th2)));
                        }
                        if (!ABTestSDK.isReady()) {
                            Log.i(LOGTAG, "multiprocess AbTestInterface not set");
                            Boolean bool7 = Boolean.FALSE;
                            sMultiprocessEnabled = bool7;
                            return bool7.booleanValue();
                        } else if (ABTestSDK.isMultipleProcessEnabled() || (!ProcessUtils.isProcess64Bit() && ABTestSDK.isMultipleProcess32Enabled())) {
                            if (shouldBockFrequentCrash()) {
                                Boolean valueOf2 = Boolean.valueOf(!WebViewFactory.getContext().getSharedPreferences(PREF_NAME_MULTIPROCESS, 0).getBoolean(PREF_KEY_MULTIPROCESS_DISABLED, false));
                                sMultiprocessEnabled = valueOf2;
                                if (!valueOf2.booleanValue()) {
                                    Log.i(LOGTAG, "multiprocess blocked");
                                }
                            } else {
                                sMultiprocessEnabled = Boolean.TRUE;
                            }
                            Log.i(LOGTAG, "multiprocess enabled: " + sMultiprocessEnabled);
                            return sMultiprocessEnabled.booleanValue();
                        } else {
                            Log.i(LOGTAG, "multiprocess Ab test off");
                            Boolean bool8 = Boolean.FALSE;
                            sMultiprocessEnabled = bool8;
                            return bool8.booleanValue();
                        }
                    }
                }
            }
            Log.i(LOGTAG, "multiprocess not enabled for low memory");
            Boolean bool9 = Boolean.FALSE;
            sMultiprocessEnabled = bool9;
            return bool9.booleanValue();
        } catch (RuntimeException e2) {
            Log.w(LOGTAG, "Failed to get memory info due to a runtime exception: %s", (Throwable) e2);
        }
    }

    public static Boolean shouldUploadResponseBySmartDetector(String str) {
        try {
            String host = new URL(str).getHost();
            String[] split = CloudSettingSDK.getSmartDetectorWhiteHostsValue().split(";");
            int i2 = 0;
            while (i2 < split.length) {
                if ("".equals(split[i2]) || host.indexOf(split[i2]) < 0) {
                    i2++;
                } else {
                    Log.d(LOGTAG, "url : " + str + " match white host: " + split[i2]);
                    return Boolean.TRUE;
                }
            }
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public static boolean isSFSwitchEnabled() {
        return CloudSettingSDK.isSpringFestivalSwitchEnabled();
    }

    private static boolean shouldBockFrequentCrash() {
        if (CloudSettingSDK.isFrequentCrashBlockEnabled()) {
            return true;
        }
        Log.i(LOGTAG, "frequent crash block disabled.");
        return false;
    }

    public static int recordRenderCrash() {
        int i2 = 1;
        if (!shouldBockFrequentCrash()) {
            return 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Context context = WebViewFactory.getContext();
        Log.d(LOGTAG, "recordRenderCrash()");
        if (context == null) {
            return 1;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME_MULTIPROCESS, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(currentTimeMillis));
        String string = sharedPreferences.getString(PREF_KEY_RENDER_CRASHES, (String) null);
        Log.d(LOGTAG, "  existing crashes: ".concat(String.valueOf(string)));
        if (string != null) {
            int i3 = 1;
            for (String str : string.split(",")) {
                if (currentTimeMillis - Long.parseLong(str, 10) < RENDER_CRASH_LOG_TIMEOUT) {
                    i3++;
                    sb.append(",");
                    sb.append(str);
                }
            }
            int maxRenderProcFccValue = CloudSettingSDK.getMaxRenderProcFccValue();
            Log.i(LOGTAG, "  recent crash count: " + i3 + " max crash count = " + maxRenderProcFccValue);
            if (i3 >= maxRenderProcFccValue) {
                Log.i(LOGTAG, "  too many crashes recently, disabling multiprocess");
                edit.putBoolean(PREF_KEY_MULTIPROCESS_DISABLED, true);
                edit.remove(PREF_KEY_RENDER_CRASHES);
                edit.commit();
                return i3;
            }
            i2 = i3;
        }
        Log.d(LOGTAG, "  new crashes: " + sb.toString());
        edit.putString(PREF_KEY_RENDER_CRASHES, sb.toString());
        edit.commit();
        Log.d(LOGTAG, "  done");
        return i2;
    }

    public static int getHttpDnsSource() {
        return httpDnsSource;
    }

    @Deprecated
    public static void setWhiteAndBlackList(String str, JSONArray jSONArray) {
        mWhiteAndBlackList.put(str, jSONArray);
        if ("gum_white_list".equals(str)) {
            for (String next : getWhiteAndBlackList(str)) {
                if (Uri.parse(next).getHost().endsWith(".baidu.com")) {
                    mGetUserMediaConfirmed.put(next, Boolean.TRUE);
                    Log.i(LOGTAG, "adding gum white list: ".concat(String.valueOf(next)));
                }
            }
        }
    }

    @Deprecated
    public static void setWhiteAndBlackListToNative(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setWhiteAndBlackList(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Deprecated
    public static List<String> getWhiteAndBlackList(String str) {
        JSONArray jSONArray = mWhiteAndBlackList.get(str);
        if (jSONArray == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.getString(i2));
            }
            return arrayList;
        } catch (JSONException e2) {
            Log.w(LOGTAG, "parserData JSONTokener error ".concat(String.valueOf(e2)));
            return null;
        }
    }

    @Deprecated
    public static boolean isInFCCheatBlackList(String str) {
        JSONArray jSONArray;
        if (mFCCheatBlackList.isEmpty() && (jSONArray = mWhiteAndBlackList.get("FC_Landing_Cheat")) != null) {
            try {
                synchronized (mFCCheatBlackList) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        mFCCheatBlackList.add(jSONArray.getString(i2).toLowerCase());
                    }
                }
            } catch (JSONException e2) {
                Log.w(LOGTAG, "parserData JSONTokener error ".concat(String.valueOf(e2)));
            }
        }
        return mFCCheatBlackList.contains(str.toLowerCase());
    }

    public static void updateFixAdblockLevelInfo(String str, int i2, int i3) {
        Log.i(LOGTAG, "updateFixAdblockLevelInfo host: %s, siteType: %d, level: %d  ", str, Integer.valueOf(i2), Integer.valueOf(i3));
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().updateFixAdblockLevelInfo(str, i2, i3);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static int getSiteTypeInfo(String str) {
        int i2 = -1;
        try {
            if (WebViewFactory.hasProvider()) {
                i2 = WebViewFactory.getProvider().getSettingsStatics().getSiteTypeInfo(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Log.i(LOGTAG, "getSiteTypeInfo host: %s, siteType: %d", str, Integer.valueOf(i2));
        return i2;
    }

    public static int getLevelInfo(String str) {
        int i2 = -1;
        try {
            if (WebViewFactory.hasProvider()) {
                i2 = WebViewFactory.getProvider().getSettingsStatics().getLevelInfo(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Log.i(LOGTAG, "getLevelInfo host: %s, level: %d", str, Integer.valueOf(i2));
        return i2;
    }

    public static ByteBuffer kernelBrotliCreate(long[] jArr) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().kernelBrotliCreate(jArr);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return ByteBuffer.allocate(0);
    }

    public static void kernelBrotliPush(long[] jArr, int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().kernelBrotliPush(jArr, i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static ByteBuffer kernelBrotliPull(long[] jArr) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().kernelBrotliPull(jArr);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return ByteBuffer.allocate(0);
    }

    public static void kernelBrotliDestroy(long[] jArr) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().kernelBrotliDestroy(jArr);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean hasQuicAltService(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().hasQuicAltService(str);
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }
}
