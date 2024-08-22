package com.baidu.searchbox.introduction;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.browser.BrowserType;
import com.baidu.fsg.base.restnet.beans.business.core.utils.CollectionUtils;
import com.baidu.helios.ids.oid.cert.a;
import com.baidu.nadcore.debug.LogEx;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.ad.dazzle.tools.JsonTools;
import com.baidu.searchbox.ad.lightbrowser.splash.SplashConfig;
import com.baidu.searchbox.ad.util.AdQuickPersistConfig;
import com.baidu.searchbox.ad.util.IpDxServiceManager;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.ApkStateManager;
import com.baidu.searchbox.feed.ad.IAdRuntime;
import com.baidu.searchbox.feed.ad.IAdSearchContext;
import com.baidu.searchbox.introduction.data.MobileDownloadStrategy;
import com.baidu.searchbox.introduction.data.SplashData;
import com.baidu.searchbox.introduction.data.SplashDataManager;
import com.baidu.searchbox.introduction.data.SplashPolicyRecorder;
import com.baidu.searchbox.introduction.data.SplashSource;
import com.baidu.searchbox.introduction.data.SplashType;
import com.baidu.searchbox.introduction.hotboot.HotSplashManager;
import com.baidu.searchbox.introduction.utils.DeviceUAUtil;
import com.baidu.searchbox.nadbrowser.NadIntentConstants;
import com.baidu.searchbox.ng.browser.init.BlinkInitHelper;
import com.baidu.searchbox.ng.browser.listener.BlinkInitListener;
import com.baidu.searchbox.settings.extend.ISettingsFun;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.usergrowth.active.ActiveTimeInfo;
import com.baidu.searchbox.usergrowth.active.BaiduActiveManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.talos.core.container.InitProps;
import com.baidu.util.Base64Encoder;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SplashUtils {
    private static final int BUFF_SIZE = 2048;
    private static final long CLEAR_CACHE_TIME_LIMIT = 86400000;
    private static String COLD_BOOT = "3";
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String EASYBROWSE_ACTIVITY_CLASS = "com.baidu.searchbox.lightbrowser.LightBrowserActivity";
    private static final String EASYBROWSE_OPEN = "/easybrowse/open?";
    public static final String FILTER_PARAMS_SEPARATOR = ",";
    private static final String HISTORY_EXTRA_SOURCE = "read_splash";
    private static final String HISTORY_SPLASH_TPL_ID = "splash_image";
    private static String ICE_BOOT = "0";
    private static final String KEY_BACKGROUND_DURATION = "key_background_duration";
    public static final String KEY_CACHE_DIR = "cacheDir";
    private static final String KEY_HISTORY_CMD = "cmd";
    private static final String KEY_HISTORY_EXTRA = "extra";
    private static final String KEY_HISTORY_IMAGE = "image";
    private static final String KEY_HISTORY_LABEL = "source";
    private static final String KEY_HISTORY_TITLE = "title";
    private static final String KEY_HISTORY_TPL_ID = "tplId";
    private static final String KEY_HISTORY_UBC = "ubcjson";
    private static final String KEY_HISTORY_UBC_SOURCE = "source";
    private static final String KEY_HISTORY_UKEY = "ukey";
    private static final String KEY_HOT_SHOW_TIME = "key_hot_show_time";
    private static final String KEY_HOT_START_TIME = "key_hot_start_time";
    private static final String KEY_LAST_CLEAR_SPLASH_TIME = "last_clear_splash_time";
    private static final String KEY_LAST_CLEAR_TIME_NEW = "last_clear_time_new";
    private static final String KEY_REAL_SCREENSIZE = "realScreenSize";
    public static final String KEY_SPLASH_HTML_URL_FILTER_PARAMS = "html_url_filter_params";
    private static String KEY_SPLASH_LAUNCH_TYPE = NadIntentConstants.KEY_SPLASH_LAUNCH_TYPE;
    private static final String KEY_SPLASH_ORIGIN_URL = "lp_real_url";
    private static final String KEY_SPLASH_REAL_CLICK_TIME = "ad_click_real_time";
    private static final String KEY_SPLASH_SHOW_TIME = "SplashShowTime";
    private static final String MODE_ACCESSIBILITY_TAG = "talkback";
    private static final int NETWORK_2G = 2;
    private static final int NETWORK_3G = 3;
    private static final int NETWORK_4G = 4;
    private static final int NETWORK_UNKNOWN = 0;
    public static final int NETWORK_WIFI = 1;
    private static final int OPERATOR_CHINA_MOBILE = 1;
    private static final int OPERATOR_CHINA_TELECOM = 3;
    private static final int OPERATOR_CHINA_UNICOM = 2;
    private static final int OPERATOR_UNKNOWN = 0;
    private static final String SCENE_SPLASH = "splash";
    private static final String SPLASH_QUERY_WORDS = "splash_query_words";
    private static final String TAG = "SplashUtils";
    private static String WARM_BOOT = "1";
    private static final String __ECMALOGID__ = "__ECMALOGID__";
    private static final String __ECMATimeStamp__ = "__ECMATimeStamp__";
    private static boolean isColdBoot = true;
    private static String sDefaultUserAgent = "";

    public static final class SplashNetworkType {
        public static final int ALL = 0;
        public static final int UNWIFI = 2;
        public static final int WIFI = 1;
    }

    public static void switchToHotBoot() {
        isColdBoot = false;
    }

    public static boolean isColdBoot() {
        return isColdBoot;
    }

    public static String getFileMd5(File file) {
        FileInputStream in = null;
        try {
            FileInputStream in2 = new FileInputStream(file);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[16384];
            while (true) {
                int read = in2.read(buffer);
                int len = read;
                if (read <= 0) {
                    break;
                }
                md5.update(buffer, 0, len);
            }
            String bufferToHex = bufferToHex(md5.digest());
            try {
                in2.close();
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            return bufferToHex;
        } catch (Exception e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            if (in == null) {
                return null;
            }
            try {
                in.close();
                return null;
            } catch (Exception e22) {
                if (!DEBUG) {
                    return null;
                }
                e22.printStackTrace();
                return null;
            }
        } catch (Throwable th2) {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e23) {
                    if (DEBUG) {
                        e23.printStackTrace();
                    }
                }
            }
            throw th2;
        }
    }

    public static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    public static String bufferToHex(byte[] bytes, int start, int len) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuffer stringbuffer = new StringBuffer(len * 2);
        int k = start + len;
        for (int l = start; l < k; l++) {
            appendHexPair(hexDigits, bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    public static void appendHexPair(char[] hexDigits, byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 240) >> 4];
        char c1 = hexDigits[bt & 15];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    public static void setForbidConfig(boolean blockApp, String injectJs, String logId) {
        SplashConfig.getInstance().setBlockApp(blockApp);
        long time = System.currentTimeMillis();
        if (!TextUtils.isEmpty(injectJs)) {
            SplashConfig.getInstance().setInjectJs(injectJs.replaceAll("(?i)__ECMALOGID__", logId).replaceAll("(?i)__ECMATimeStamp__", String.valueOf(time)));
        }
    }

    public static void setCacheDir(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            SplashConfig.getInstance().setLocalCacheDir(file);
            QuickPersistConfig.getInstance().putString(KEY_CACHE_DIR, file.getAbsolutePath());
        }
    }

    public static void executeSchemeorCmd(Context ctx, String command, SplashData data) {
        String splashLaunchType;
        if (command != null && !TextUtils.isEmpty(command)) {
            String command2 = getReplaceShowTimeKey(command, data);
            Bundle bundle = new Bundle();
            bundle.putString("source", "splash");
            if (HotSplashManager.getInstance().isHotBoot()) {
                splashLaunchType = WARM_BOOT;
            } else {
                splashLaunchType = isColdBoot ? ICE_BOOT : COLD_BOOT;
            }
            bundle.putString(KEY_SPLASH_LAUNCH_TYPE, splashLaunchType);
            String originUrl = data == null ? "" : data.originUrl;
            bundle.putString("lp_real_url", originUrl);
            String realClickTime = String.valueOf(System.currentTimeMillis());
            bundle.putString("ad_click_real_time", realClickTime);
            String[] filterParams = data == null ? null : data.filterParams;
            if (filterParams != null && filterParams.length > 0) {
                bundle.putString("html_url_filter_params", TextUtils.join(",", filterParams));
            }
            if (command2.trim().startsWith(UnitedSchemeConstants.UNITED_SCHEME)) {
                Uri.Builder builder = Uri.parse(command2).buildUpon();
                if (command2.contains(EASYBROWSE_OPEN)) {
                    builder.appendQueryParameter("source", "splash").appendQueryParameter(KEY_SPLASH_LAUNCH_TYPE, splashLaunchType).appendQueryParameter("lp_real_url", originUrl).appendQueryParameter("ad_click_real_time", realClickTime);
                    if (filterParams != null && filterParams.length > 0) {
                        builder.appendQueryParameter("html_url_filter_params", TextUtils.join(",", filterParams));
                    }
                }
                Uri uri = builder.build();
                if (SplashPolicyRecorder.getInstance().skipSchemeCheck()) {
                    Router.invokeScheme(ctx, uri, "inside");
                } else if (Router.isSchemeAvailable(ctx, uri, "inside")) {
                    Router.invokeScheme(ctx, uri, "inside");
                }
            } else if (CommandUtils.isCommandAvailable(ctx, command2)) {
                CommandUtils.invokeCommand(ctx, command2, bundle);
            }
        }
    }

    public static String generateLogId(String key) {
        return MD5Utils.toMd5((key + System.currentTimeMillis()).getBytes(), false);
    }

    public static int isBlockSplash(Context context) {
        if (isAccessibilityServiceOpen(context)) {
            return 1;
        }
        return -1;
    }

    private static boolean isAccessibilityServiceOpen(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            List<AccessibilityServiceInfo> accessibilityServices = accessibilityManager.getEnabledAccessibilityServiceList(-1);
            if (CollectionUtils.isEmpty((Collection<?>) accessibilityServices)) {
                return false;
            }
            for (AccessibilityServiceInfo info : accessibilityServices) {
                if (info.getId().toLowerCase(Locale.getDefault()).contains(MODE_ACCESSIBILITY_TAG)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void initDefaultUserAgent() {
        String agent;
        String agent2 = System.getProperty("http.agent");
        if (TextUtils.isEmpty(agent2)) {
            agent = "";
        } else {
            StringBuffer sb = new StringBuffer();
            int length = agent2.length();
            for (int i2 = 0; i2 < length; i2++) {
                char c2 = agent2.charAt(i2);
                if (c2 <= 31 || c2 >= 127) {
                    sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c2)}));
                } else {
                    sb.append(c2);
                }
            }
            agent = sb.toString();
        }
        sDefaultUserAgent = BaiduIdentityManager.getInstance().processUserAgent(agent, BrowserType.OTHER);
    }

    public static String getDefaultUserAgent() {
        if (TextUtils.isEmpty(sDefaultUserAgent)) {
            initDefaultUserAgent();
        }
        return sDefaultUserAgent;
    }

    public static String getRealScreenSize() {
        WindowManager windowMgr;
        String realScreenSize = QuickPersistConfig.getInstance().getString(KEY_REAL_SCREENSIZE, "");
        if (!TextUtils.isEmpty(realScreenSize) || (windowMgr = (WindowManager) AppRuntime.getAppContext().getSystemService("window")) == null) {
            return realScreenSize;
        }
        DisplayMetrics sDisplayMetrics = new DisplayMetrics();
        if (DeviceUtil.OSInfo.hasJellyBeanMR1()) {
            windowMgr.getDefaultDisplay().getRealMetrics(sDisplayMetrics);
        } else {
            windowMgr.getDefaultDisplay().getMetrics(sDisplayMetrics);
        }
        String realScreenSize2 = sDisplayMetrics.widthPixels + "_" + sDisplayMetrics.heightPixels;
        QuickPersistConfig.getInstance().putString(KEY_REAL_SCREENSIZE, realScreenSize2);
        return realScreenSize2;
    }

    private static int[] getRealScreenSize2() {
        int[] size = new int[2];
        String sizeStr = getRealScreenSize();
        if (!TextUtils.isEmpty(sizeStr)) {
            String[] split = sizeStr.split("_");
            if (split.length > 1) {
                try {
                    int height = Integer.parseInt(split[1]);
                    size[0] = Integer.parseInt(split[0]);
                    size[1] = height;
                } catch (NumberFormatException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return size;
    }

    public static int getRealScreenHeight() {
        return Math.max(getRealScreenSize2()[0], getRealScreenSize2()[1]);
    }

    public static int getRealScreenWidth() {
        return Math.min(getRealScreenSize2()[0], getRealScreenSize2()[1]);
    }

    public static int getNetworkType() {
        switch (AnonymousClass3.$SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType[NetWorkUtils.getNetworkType().ordinal()]) {
            case 1:
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 4;
            default:
                return 0;
        }
    }

    /* renamed from: com.baidu.searchbox.introduction.SplashUtils$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType;

        static {
            int[] iArr = new int[NetWorkUtils.NetType.values().length];
            $SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType = iArr;
            try {
                iArr[NetWorkUtils.NetType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType[NetWorkUtils.NetType.UNKOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType[NetWorkUtils.NetType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType[NetWorkUtils.NetType._2G.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType[NetWorkUtils.NetType._3G.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$android$util$devices$NetWorkUtils$NetType[NetWorkUtils.NetType._4G.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int getBatteryInfo() {
        Intent intent = AppRuntime.getAppContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intent == null) {
            return 0;
        }
        return (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cf, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r1.closeEntry();
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d7, code lost:
        if (r0 == null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d9, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00dd, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00de, code lost:
        r3.printStackTrace();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unzipFile(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r11 = createSeparator(r11)
            r0 = 0
            r1 = 0
            r2 = 0
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x00e4 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00e4 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00e4 }
            r5.<init>(r10)     // Catch:{ IOException -> 0x00e4 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00e4 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00e4 }
            r1 = r3
            r3 = 2048(0x800, float:2.87E-42)
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x00e4 }
        L_0x001b:
            java.util.zip.ZipEntry r4 = r1.getNextEntry()     // Catch:{ IOException -> 0x00e4 }
            r5 = r4
            if (r4 == 0) goto L_0x00cf
            java.lang.String r4 = r5.getName()     // Catch:{ IOException -> 0x00e4 }
            boolean r6 = DEBUG     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r7 = "SplashUtils"
            if (r6 == 0) goto L_0x0043
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e4 }
            r8.<init>()     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r9 = "ze.getName() = "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r8 = r8.append(r4)     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x00e4 }
            android.util.Log.d(r7, r8)     // Catch:{ IOException -> 0x00e4 }
        L_0x0043:
            java.lang.String r8 = "../"
            boolean r8 = r4.contains(r8)     // Catch:{ IOException -> 0x00e4 }
            r9 = 0
            if (r8 == 0) goto L_0x005f
            r1.closeEntry()     // Catch:{ IOException -> 0x005a }
            r1.close()     // Catch:{ IOException -> 0x005a }
            if (r0 == 0) goto L_0x0059
            r0.close()     // Catch:{ IOException -> 0x005a }
        L_0x0059:
            goto L_0x005e
        L_0x005a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005e:
            return r9
        L_0x005f:
            createSubFolders(r4, r11)     // Catch:{ IOException -> 0x00e4 }
            boolean r8 = r5.isDirectory()     // Catch:{ IOException -> 0x00e4 }
            if (r8 == 0) goto L_0x0082
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e4 }
            r7.<init>()     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r7 = r7.append(r11)     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r7 = r7.append(r4)     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00e4 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00e4 }
            r6.mkdirs()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x001b
        L_0x0082:
            if (r6 == 0) goto L_0x009f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e4 }
            r6.<init>()     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r8 = "unzip file = "
            java.lang.StringBuilder r6 = r6.append(r8)     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r6 = r6.append(r11)     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r6 = r6.append(r4)     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x00e4 }
            android.util.Log.d(r7, r6)     // Catch:{ IOException -> 0x00e4 }
        L_0x009f:
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00e4 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e4 }
            r8.<init>()     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r8 = r8.append(r11)     // Catch:{ IOException -> 0x00e4 }
            java.lang.StringBuilder r8 = r8.append(r4)     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x00e4 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x00e4 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00e4 }
            r0 = r6
        L_0x00bb:
            int r6 = r1.read(r3)     // Catch:{ IOException -> 0x00e4 }
            r7 = r6
            r8 = -1
            if (r6 == r8) goto L_0x00c7
            r0.write(r3, r9, r7)     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00bb
        L_0x00c7:
            r0.flush()     // Catch:{ IOException -> 0x00e4 }
            r0.close()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x001b
        L_0x00cf:
            r2 = 1
            r1.closeEntry()     // Catch:{ IOException -> 0x00dd }
            r1.close()     // Catch:{ IOException -> 0x00dd }
            if (r0 == 0) goto L_0x00dc
            r0.close()     // Catch:{ IOException -> 0x00dd }
        L_0x00dc:
            goto L_0x00f6
        L_0x00dd:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x00f6
        L_0x00e2:
            r3 = move-exception
            goto L_0x00f7
        L_0x00e4:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x00f0
            r1.closeEntry()     // Catch:{ IOException -> 0x00dd }
            r1.close()     // Catch:{ IOException -> 0x00dd }
        L_0x00f0:
            if (r0 == 0) goto L_0x00dc
            r0.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00dc
        L_0x00f6:
            return r2
        L_0x00f7:
            if (r1 == 0) goto L_0x0102
            r1.closeEntry()     // Catch:{ IOException -> 0x0100 }
            r1.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0102
        L_0x0100:
            r4 = move-exception
            goto L_0x0108
        L_0x0102:
            if (r0 == 0) goto L_0x010c
            r0.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x010c
        L_0x0108:
            r4.printStackTrace()
            goto L_0x010d
        L_0x010c:
        L_0x010d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.introduction.SplashUtils.unzipFile(java.lang.String, java.lang.String):boolean");
    }

    private static void createSubFolders(String filename, String path) {
        String[] subFolders = filename.split("/");
        if (subFolders.length > 1) {
            String pathNow = path;
            for (int i2 = 0; i2 < subFolders.length - 1; i2++) {
                pathNow = pathNow + subFolders[i2] + "/";
                File fmd = new File(pathNow);
                if (!fmd.exists()) {
                    fmd.mkdirs();
                }
            }
        }
    }

    private static String createSeparator(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (path.endsWith("/")) {
            return path;
        }
        return path + '/';
    }

    public static String getBase64OAIDCheckMapping() {
        DeviceIdBag deviceIdBag = DeviceInfoManager.INSTANCE.getOAID("splash", "splash");
        if (deviceIdBag == null) {
            return "";
        }
        String oaid = deviceIdBag.deviceId;
        if (TextUtils.isEmpty(oaid)) {
            return "";
        }
        int errorCode = deviceIdBag.errorCode;
        if (DEBUG) {
            Log.d(TAG, "oaid_errorCode:" + errorCode);
        }
        if (errorCode == 3) {
            return "";
        }
        return new String(Base64.encode(oaid.getBytes(), 2));
    }

    public static String getLaunchType() {
        if (HotSplashManager.getInstance().isHotBoot()) {
            return WARM_BOOT;
        }
        return isColdBoot ? ICE_BOOT : COLD_BOOT;
    }

    public static boolean deleteFile(File file, List<String> excludeList) {
        if (excludeList == null || excludeList.size() == 0) {
            return FileUtils.deleteFile(file);
        }
        if (file == null) {
            return false;
        }
        boolean isDeletedAll = true;
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            if (!excludeList.contains(file.getAbsolutePath())) {
                return true & file.delete();
            }
            return true;
        } else if (!file.isDirectory()) {
            return true;
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File deleteFile : files) {
                    isDeletedAll &= deleteFile(deleteFile, excludeList);
                }
            }
            return isDeletedAll & file.delete();
        }
    }

    public static boolean isH5LandingPage(String cmd) {
        if (TextUtils.isEmpty(cmd)) {
            return false;
        }
        if (JsonTools.isValidJson(cmd) && cmd.contains("com.baidu.searchbox.lightbrowser.LightBrowserActivity")) {
            return true;
        }
        if (!cmd.startsWith(UnitedSchemeConstants.UNITED_SCHEME) || !cmd.contains(EASYBROWSE_OPEN)) {
            return false;
        }
        return true;
    }

    public static void startBrowserProcess() {
        if (BlinkInitHelper.getInstance(AppRuntime.getAppContext()).isBWebkitInited()) {
            WebViewFactory.startBrowserProcess();
        } else {
            BlinkInitHelper.getInstance(AppRuntime.getAppContext()).addBlinkInitListener(new BlinkInitListener() {
                public void onInitFinished() {
                    WebViewFactory.startBrowserProcess();
                }
            });
        }
    }

    private static String generateHistoryJson(SplashData splashData) {
        JSONObject historyJson = new JSONObject();
        if (splashData != null) {
            try {
                historyJson.put("ukey", splashData.sourceUrl);
                historyJson.put("tplId", "splash_image");
                historyJson.put("title", splashData.historyTitle);
                historyJson.put("source", splashData.historyLabel);
                historyJson.put("image", splashData.historySource);
                historyJson.put("cmd", splashData.command);
                JSONObject ubcObject = new JSONObject();
                ubcObject.put("source", HISTORY_EXTRA_SOURCE);
                JSONObject extObject = new JSONObject();
                extObject.put("ubcjson", ubcObject);
                historyJson.put("extra", extObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return historyJson.toString();
    }

    public static void addSplashToHistory(SplashData splashData) {
        AdRuntimeHolder.getAdHistoryRuntime().addAdHistory(generateHistoryJson(splashData));
    }

    public static boolean persistToFile(String str, File dest) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(dest);
            writer.write(str);
            try {
                writer.close();
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.d(TAG, "persistToFile() writer.close() Exception e: ");
                    e2.printStackTrace();
                }
            }
            return true;
        } catch (Exception e3) {
            if (DEBUG) {
                Log.d(TAG, "persistToFile() Exception e: ");
                e3.printStackTrace();
            }
            if (writer == null) {
                return false;
            }
            try {
                writer.close();
                return false;
            } catch (Exception e22) {
                if (!DEBUG) {
                    return false;
                }
                Log.d(TAG, "persistToFile() writer.close() Exception e: ");
                e22.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e23) {
                    if (DEBUG) {
                        Log.d(TAG, "persistToFile() writer.close() Exception e: ");
                        e23.printStackTrace();
                    }
                }
            }
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (DEBUG == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        if (DEBUG == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileContent(java.io.File r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x002d }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x002d }
            r3.<init>(r5)     // Catch:{ Exception -> 0x002d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x002d }
            r1 = r2
            r2 = 0
        L_0x0012:
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x002d }
            r2 = r3
            if (r3 == 0) goto L_0x001d
            r0.append(r2)     // Catch:{ Exception -> 0x002d }
            goto L_0x0012
        L_0x001d:
            r1.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0021:
            goto L_0x0041
        L_0x0022:
            r2 = move-exception
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0021
        L_0x0027:
            r2.printStackTrace()
            goto L_0x0021
        L_0x002b:
            r2 = move-exception
            goto L_0x0046
        L_0x002d:
            r2 = move-exception
            boolean r3 = DEBUG     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0035
            r2.printStackTrace()     // Catch:{ all -> 0x002b }
        L_0x0035:
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ Exception -> 0x003b }
            goto L_0x0021
        L_0x003b:
            r2 = move-exception
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0021
            goto L_0x0027
        L_0x0041:
            java.lang.String r2 = r0.toString()
            return r2
        L_0x0046:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ Exception -> 0x004c }
            goto L_0x0054
        L_0x004c:
            r3 = move-exception
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x0054
            r3.printStackTrace()
        L_0x0054:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.introduction.SplashUtils.getFileContent(java.io.File):java.lang.String");
    }

    public static void setPreviewFlag(boolean preview) {
        QuickPersistConfig.getInstance().putBoolean("splash_preview", preview);
    }

    public static boolean getPreviewFlag() {
        return QuickPersistConfig.getInstance().getBoolean("splash_preview", false);
    }

    public static String map2UrlParams(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map.size() > 0) {
            for (String key : map.keySet()) {
                try {
                    key = URLEncoder.encode(key, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                sb.append(key).append("=");
                if (TextUtils.isEmpty(map.get(key))) {
                    sb.append("&");
                } else {
                    String value = map.get(key);
                    try {
                        value = URLEncoder.encode(value, "UTF-8");
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                    }
                    sb.append(value).append("&");
                }
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String getTopViewKey(String key) {
        String[] keys = key.split("_");
        if (!SplashData.isFeedTopView(SplashData.getTopViewType(keys))) {
            if (keys == null || keys.length < 16) {
                return "";
            }
            return keys[15];
        } else if (keys == null || keys.length < 6) {
            return "";
        } else {
            return keys[5];
        }
    }

    public static String getPlanId(String key) {
        String[] keys = key.split("_");
        if (keys == null || keys.length < 16) {
            return "";
        }
        return keys[15];
    }

    public static String getIdeaId(SplashData splashData) {
        String[] keys;
        if (splashData == null) {
            return "";
        }
        String key = splashData.key;
        if (!TextUtils.isEmpty(key) && (keys = key.split("_")) != null && keys.length >= 5) {
            return keys[5];
        }
        return "";
    }

    public static boolean isWarmBoot() {
        return !HotSplashManager.getInstance().isHotBoot() && !isColdBoot();
    }

    public static void saveHotBootStartTime(long hotBootStartTime) {
        QuickPersistConfig.getInstance().putLong(KEY_HOT_START_TIME, hotBootStartTime);
    }

    public static void saveHotBootShowTime(long hotBootShowTime) {
        QuickPersistConfig.getInstance().putLong(KEY_HOT_SHOW_TIME, hotBootShowTime);
    }

    public static String getHotBeforeShowTime() {
        long hotBootStartTime = QuickPersistConfig.getInstance().getLong(KEY_HOT_START_TIME, 0);
        long hotBootShowTime = QuickPersistConfig.getInstance().getLong(KEY_HOT_SHOW_TIME, 0);
        if (hotBootStartTime == 0 || hotBootShowTime == 0 || hotBootStartTime > hotBootShowTime) {
            return "";
        }
        return String.format(Locale.getDefault(), "%.2f", new Object[]{Double.valueOf((((double) (hotBootShowTime - hotBootStartTime)) * 1.0d) / 1000.0d)});
    }

    public static void saveBackgroundDuration(long backgroundDuration) {
        QuickPersistConfig.getInstance().putLong(KEY_BACKGROUND_DURATION, backgroundDuration);
    }

    public static String getBackgroundDuration() {
        return String.format(Locale.getDefault(), "%.2f", new Object[]{Double.valueOf((((double) getBackgroundDurationMills()) * 1.0d) / 1000.0d)});
    }

    public static long getBackgroundDurationMills() {
        return QuickPersistConfig.getInstance().getLong(KEY_BACKGROUND_DURATION, 0);
    }

    public static void saveClearSplashTime(long timeStamp) {
        QuickPersistConfig.getInstance().putLong(KEY_LAST_CLEAR_SPLASH_TIME, timeStamp);
    }

    public static boolean clearOverTimeLimit(long timeStamp) {
        if (timeStamp - QuickPersistConfig.getInstance().getLong(KEY_LAST_CLEAR_SPLASH_TIME, 0) > 86400000) {
            return true;
        }
        return false;
    }

    public static boolean isTwiceShowInSameDay() {
        return DateTimeUtils.isSameDay(QuickPersistConfig.getInstance().getLong(QuickPersistConfigConst.KEY_SPLASH_SPLIT_TIME, 0), System.currentTimeMillis());
    }

    public static boolean isSameIdea(String ideaId) {
        return TextUtils.equals(ideaId, QuickPersistConfig.getInstance().getString(SplashPolicyRecorder.KEY_SHOW_IDEA_ID, ""));
    }

    public static int afterFewDays(long time) {
        return (int) ((System.currentTimeMillis() - (time - ((((long) TimeZone.getDefault().getRawOffset()) + time) % 86400000))) / 86400000);
    }

    public static String getReplaceShowTimeKey(String key, SplashData data) {
        if (data == null || TextUtils.isEmpty(key)) {
            return "";
        }
        return key.replace(KEY_SPLASH_SHOW_TIME, String.valueOf(data.lastShowTimeMillis));
    }

    public static boolean checkDownloadSizeOn4g(SplashSource splashSource) {
        int downloadType;
        if (!DEBUG && getNetworkType() == 1) {
            return true;
        }
        if (splashSource.SourceType == SplashType.SourceType.ZIP) {
            downloadType = 2;
        } else {
            downloadType = 1;
        }
        return MobileDownloadStrategy.getInstance().hasBalanceForDownload(downloadType, splashSource.sourceUrl, splashSource.key);
    }

    public static void recordDownloadSize(SplashSource splashSource, String downloadUrl, long streamSize) {
        int downloadType;
        if (splashSource.SourceType == SplashType.SourceType.ZIP) {
            downloadType = 2;
        } else {
            downloadType = 1;
        }
        MobileDownloadStrategy.getInstance().updateRealUsage(downloadType, downloadUrl, streamSize);
    }

    public static String getMaterialPostParams() {
        JSONObject data = new JSONObject();
        try {
            String oaid = getBase64OAIDCheckMapping();
            if (!TextUtils.isEmpty(oaid)) {
                data.put(a.f13390e, oaid);
            }
            String ipdxInfo = IpDxServiceManager.getInstance().getIpDxOriginalData();
            if (!TextUtils.isEmpty(ipdxInfo)) {
                data.put("ipdx", ipdxInfo);
            }
            ActiveTimeInfo activeTimeInfo = BaiduActiveManager.getInstance().getActiveTimeInfo();
            if (activeTimeInfo != null) {
                data.put("client_request_time", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(activeTimeInfo.getRequestTime())));
            }
            if (!TextUtils.isEmpty(ApkStateManager.getApkStateEx())) {
                data.put("iadex", ApkStateManager.getApkStateEx());
            }
            data.put("adinfo", SplashDataManager.getInstance().getAdInfo());
            String realScreenSize = getRealScreenSize();
            if (!TextUtils.isEmpty(realScreenSize)) {
                data.put(InitProps.KEY_SCREEN_INFO, realScreenSize);
            }
            data.put("query_log_info", SplashPolicyRecorder.getInstance().getQueryLogInfo());
            if (SplashPolicyRecorder.getInstance().isSendSysUA() && BlinkInitHelper.getInstance(AppRuntime.getAppContext()).isBWebkitInited()) {
                data.put("sys_ua", DeviceUAUtil.getSystemUserUA());
            }
            if (SplashPolicyRecorder.getInstance().getUpdateUploadSensorAvailableOpt()) {
                data.put("sensor_available", getSystemSensorAvailable(AppRuntime.getAppContext()) ? "1" : "0");
            }
            return data.toString();
        } catch (JSONException e2) {
            return "";
        }
    }

    public static void saveClearSplashTimeNew(long timeStamp) {
        AdQuickPersistConfig.Companion.getInstance().putLong(KEY_LAST_CLEAR_TIME_NEW, timeStamp);
    }

    public static boolean clearOverSplitTime(long timeStamp) {
        return ((float) (timeStamp - AdQuickPersistConfig.Companion.getInstance().getLong(KEY_LAST_CLEAR_TIME_NEW, 0))) > SplashPolicyRecorder.getInstance().getCleanSplitTime() * 3600000.0f;
    }

    public static String deleteUrlParams(String url, String... key) {
        int length = key.length;
        for (int i2 = 0; i2 < length; i2++) {
            url = url.replaceAll("&?" + key[i2] + "=[^&]*", "");
        }
        return url;
    }

    public static void cacheQueryWords() {
        JSONArray queryHis;
        if (SplashPolicyRecorder.getInstance().isQuerySearchInfoOn()) {
            try {
                if (IAdRuntime.Impl.get().isQueryEnable() && (queryHis = IAdSearchContext.Impl.get().getFormatQueryHistory()) != null && queryHis.length() > 0) {
                    AdQuickPersistConfig.Companion.getInstance().putString(SPLASH_QUERY_WORDS, new String(Base64Encoder.B64Encode(queryHis.toString().getBytes())));
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static String getQueryWords() {
        return AdQuickPersistConfig.Companion.getInstance().getString(SPLASH_QUERY_WORDS, "");
    }

    public static boolean isHomeRecommendTab() {
        boolean isRecommendTab = false;
        boolean isHomeFeed = false;
        ISettingsFun iSettingsFun = (ISettingsFun) ServiceManager.getService(ISettingsFun.Companion.getSERVICE_REFERENCE());
        if (iSettingsFun != null && TextUtils.equals("Feed", iSettingsFun.getColdLaunchDefaultTab())) {
            isHomeFeed = true;
        }
        if (AdRuntimeHolder.getFeedProxy().isMainFeedTab()) {
            isRecommendTab = true;
        }
        return isHomeFeed && isRecommendTab;
    }

    public static String getPreConfigWithArrayString(String arrStr) {
        if (TextUtils.isEmpty(arrStr)) {
            return "";
        }
        for (String str : arrStr.split("&")) {
            if (!TextUtils.isEmpty(str)) {
                String[] tempArr = str.split("_");
                if (tempArr.length != 3) {
                    continue;
                } else {
                    try {
                        long startTime = Long.parseLong(tempArr[1]);
                        long endTime = Long.parseLong(tempArr[2]);
                        long currentTime = System.currentTimeMillis() / 1000;
                        if (currentTime >= startTime && currentTime <= endTime) {
                            return tempArr[0];
                        }
                    } catch (NumberFormatException e2) {
                        LogEx.e(TAG, "getPreConfigWithArrayString error", e2);
                    }
                }
            }
        }
        return "";
    }

    public static boolean getSystemSensorAvailable(Context context) {
        SensorManager sensorManager;
        Sensor sensor;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null || (sensor = sensorManager.getDefaultSensor(1)) == null) {
            return false;
        }
        SensorEventListener sensorEventListener = new SensorEventListener() {
            public void onSensorChanged(SensorEvent event) {
            }

            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        List<Sensor> sensorList = sensorManager.getSensorList(-1);
        if (sensorList == null) {
            return false;
        }
        boolean isSensorAvailable = false;
        if (sensorList.size() >= 128) {
            return false;
        }
        try {
            isSensorAvailable = sensorManager.registerListener(sensorEventListener, sensor, 3);
            sensorManager.unregisterListener(sensorEventListener, sensor);
            return isSensorAvailable;
        } catch (Exception e2) {
            LogEx.e(TAG, "getPreConfigWithArrayString error", e2);
            return isSensorAvailable;
        }
    }
}
