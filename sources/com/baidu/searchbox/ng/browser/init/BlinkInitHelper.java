package com.baidu.searchbox.ng.browser.init;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.abtestv2.processor.AbTestDataManager;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.common.matrixstyle.PrivacyMode;
import com.baidu.common.matrixstyle.PrivacyModeRuntime;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.deviceinfo.IDevicePortraitManager;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.libsimcard.helper.ISimBindObserver;
import com.baidu.searchbox.libsimcard.helper.ISimCardObserver;
import com.baidu.searchbox.libsimcard.helper.SimBindHelper;
import com.baidu.searchbox.libsimcard.helper.SimCardHelper;
import com.baidu.searchbox.libsimcard.model.SimCardData;
import com.baidu.searchbox.ng.browser.NgWebViewConfig;
import com.baidu.searchbox.ng.browser.abtest.BlinkAbTestManager;
import com.baidu.searchbox.ng.browser.cloudsetting.ZeusCloudSettingListener;
import com.baidu.searchbox.ng.browser.impl.NgWebViewRuntime;
import com.baidu.searchbox.ng.browser.init.location.GeolocationServiceClient;
import com.baidu.searchbox.ng.browser.listener.BlinkInitListener;
import com.baidu.searchbox.ng.browser.pms.ZeusPMSChannel;
import com.baidu.searchbox.ng.browser.statistic.zeus.StatisticsTransmissionImpl;
import com.baidu.searchbox.ng.browser.upload.BOSUploadBridge;
import com.baidu.searchbox.ng.browser.yalog.ZeusYalogImpl;
import com.baidu.searchbox.perfconfig.logger.LoggerConfigConstant;
import com.baidu.searchbox.perfconfig.logger.LoggerPreferenceWrapper;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.util.CuidCookieSync;
import com.baidu.webkit.engine.ZeusLauncher;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.jschecker.BdJsCallInfo;
import com.baidu.webkit.sdk.jschecker.BdJsCheckPolicy;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class BlinkInitHelper {
    private static final String COOKIE_DOMAIN = ".baidu.com";
    private static final String COOKIE_KEY = "matrixstyle";
    private static final String COOKIE_URL = "*.baidu.com";
    public static final boolean CRASHPAD_ENABLE_DEFAULT = false;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = NgWebViewConfig.GLOBAL_DEBUG;
    private static final int DEFAULT_APP_VERSION = 0;
    private static final boolean DEFAULT_ZEUS_UNUSED_DOWNLOAD_FILES_CLEARED_VALUE = false;
    public static final String EXCEPTION_WAIT_WEBKIT_INIT_TIMEOUT = "wait_webkit_init_timeout";
    public static final String INIT_BWEBKIT_APPID = "baiduboxapp";
    public static final int INIT_BWEBKIT_DEFAULT = 0;
    public static final int INIT_BWEBKIT_FORCE_T7 = 1;
    public static final int INIT_BWEBKIT_FOR_USER = 2;
    public static final int LAUNCH_TYPE_NEWINSTALL = 2;
    public static final int LAUNCH_TYPE_NORMAL = 0;
    private static final String LAUNCH_TYPE_PREFIX = "S";
    private static final String LAUNCH_TYPE_SUFFIX = " ";
    public static final int LAUNCH_TYPE_UPGRADE = 1;
    private static final int LOWEST_HTTP_CACHE_SIZE = 20;
    private static final String LOW_DEVICE_LEVEL_USE_LOWEST_HTTP_CACHE_SIZE_KEY = "webkit_low_device_level_use_lowest_http_cache_size";
    private static final int LOW_HTTP_CACHE_SIZE = 40;
    private static final String LOW_HTTP_CACHE_SIZE_KEY = "webkit_low_http_cache_size";
    private static final int MAX_WAIT_INIT_COUNT = 5;
    private static final int NORMAL_HTTP_CACHE_SIZE = 80;
    private static final String NORMAL_HTTP_CACHE_SIZE_KEY = "webkit_normal_http_cache_size";
    private static final String PRIVACY_MODE_COOKIE_KEY = "bdenvmode";
    public static final String SEARCHBOX_CRASHPAD_ENABLE = "searchbox_crashpad_enable";
    private static final String SWAN_APP_PROCESS_SUFFIX_0 = ":swan0";
    private static final String SWAN_APP_PROCESS_SUFFIX_1 = ":swan1";
    private static final String SWAN_MAIN_HTTP_CACHE_SIZE_KEY = "swan_main_webkit_http_cache_size";
    private static final String SWAN_OTHER_HTTP_CACHE_SIZE_KEY = "swan_other_webkit_http_cache_size";
    private static final String TAG = "BlinkInitHelper";
    public static final String UPLOAD_CRASHPAD_LOG_TO_KERNEL_ENABLE = "upload_crashpad_log_to_kernel";
    public static final boolean UPLOAD_CRASHPAD_LOG_TO_KERNEL_ENABLE_DEFAULT = true;
    private static final int WAIT_TIMEOUT_MS = 1000;
    private static final String ZEUS_DOWNLOAD_DIR_NAME = "zeusupdate";
    public static final int ZEUS_INSTALL_DEFAULT_DELAY_TIME = 15000;
    public static final String ZEUS_INSTALL_DELAY_TIME_KEY = "zeus_install_delay_time";
    public static final String ZEUS_INSTALL_TYPE_AB_KEY = "zeus_install_type";
    public static final int ZEUS_INSTALL_TYPE_DEFAULT = 0;
    public static final int ZEUS_INSTALL_TYPE_DELAY = 1;
    public static final int ZEUS_INSTALL_TYPE_DELAY_BY_SCHEDULE = 2;
    private static final String ZEUS_UNUSED_DOWNLOAD_FILES_CLEARED = "zeus_unused_download_files_cleared";
    private static volatile boolean mIsHasSetWebViewDataDirectory = false;
    private static volatile BlinkInitHelper sInstance;
    /* access modifiers changed from: private */
    public final Object backgroundInitLock = new Object();
    private HashMap<BlinkInitListener, WaitBlinkInit> extWaitMap = new HashMap<>();
    private boolean hasCallInitBWebkit = false;
    /* access modifiers changed from: private */
    public volatile boolean isBWebkitInited = false;
    /* access modifiers changed from: private */
    public boolean isBackgroundInited = false;
    private final Object mInitWebkitLock = new Object();
    private int mLaunchType = -1;
    /* access modifiers changed from: private */
    public String mLaunchTypeStr;
    private ArrayList<BlinkInitListener> mListeners = new ArrayList<>();
    private int mLowDeviceZeusInstallType = 0;

    private BlinkInitHelper(Context context) {
    }

    public static synchronized BlinkInitHelper getInstance(Context context) {
        BlinkInitHelper blinkInitHelper;
        synchronized (BlinkInitHelper.class) {
            if (sInstance == null) {
                sInstance = new BlinkInitHelper(context);
            }
            blinkInitHelper = sInstance;
        }
        return blinkInitHelper;
    }

    public void onTerminate() {
        if (isBWebkitInited()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void onAppUpgrade(int oldVersion, int newVersion) {
        if (oldVersion == 0) {
            this.mLaunchType = 2;
        } else if (newVersion > oldVersion) {
            this.mLaunchType = 1;
        } else {
            this.mLaunchType = 0;
        }
        this.mLaunchTypeStr = "S" + this.mLaunchType + " ";
    }

    public void initBWebkitAsync(boolean isMainProcess) {
        initBWebkit(false, isMainProcess);
    }

    public void initBWebkit() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, this.mLaunchTypeStr + "sync initBWebkit start. thread-name: " + Thread.currentThread().getName());
        }
        initBWebkit(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
        if (z) {
            Log.d(TAG, this.mLaunchTypeStr + "sync initBWebkit end. thread-name: " + Thread.currentThread().getName());
        }
    }

    private void initBWebkit(boolean isNeedWait, final boolean isMainProcess) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, this.mLaunchTypeStr + "initBWebkit isBWebkitInited: " + this.isBWebkitInited + " thread-name: " + Thread.currentThread().getName());
        }
        if (!this.isBWebkitInited) {
            synchronized (this.mInitWebkitLock) {
                if (!this.hasCallInitBWebkit) {
                    setWebViewDataDirectorySuffix();
                    if (z) {
                        Log.d(TAG, this.mLaunchTypeStr + "initBWebkit AsyncTaskAssistant call execute.");
                    }
                    ExecutorUtilsExt.postOnElastic(new Runnable() {
                        public void run() {
                            long start = System.currentTimeMillis();
                            if (BlinkInitHelper.DEBUG) {
                                Log.d(BlinkInitHelper.TAG, BlinkInitHelper.this.mLaunchTypeStr + "initBWebkit doInitBWebkit start.");
                            }
                            BlinkInitHelper.this.doInitBWebkit(isMainProcess);
                            if (BlinkInitHelper.DEBUG) {
                                Log.d(BlinkInitHelper.TAG, BlinkInitHelper.this.mLaunchTypeStr + "initBWebkit doInitBWebkit end.");
                            }
                            SpeedStatsManager.getInstance().setTaskRunTime("doInitBWebkit", System.currentTimeMillis() - start);
                            NgWebViewRuntime.getNgWebViewContext().saveWebkitKernelStatics(AppRuntime.getAppContext());
                            boolean unused = BlinkInitHelper.this.isBWebkitInited = true;
                            BlinkInitHelper.this.setCuidCookie();
                            BlinkInitHelper.this.setCuid();
                            BlinkInitHelper.this.setTeenagerCookie();
                            BlinkInitHelper.this.setPrivaceModeCookie();
                            BlinkInitHelper.this.updateUserPrivacyConfirm2T7Kernel();
                            HashMap<String, String> map = WebKitFactory.getStatisticParams();
                            if (map != null && !map.isEmpty()) {
                                ZwCrashpad.setStatisticParam(map.toString());
                            }
                            ZwCrashpad.setAbExpInfos(AbTestManager.getInstance().getExpInfos());
                            ZwCrashpad.setZeusVersion(WebKitFactory.getZeusVersionNamekernel());
                            ZwCrashpad.setCyberVersion(WebKitFactory.getCyberSdkVersion());
                            ZwCrashpad.setProcessType(WebKitFactory.checkProcessType());
                            if (isMainProcess) {
                                String zeusVer = BdSailor.getInstance().getZeusVersionName();
                                AbTestDataManager.getInstance().saveZeusVersion(zeusVer);
                                String zeusSdkVer = WebKitFactory.getSdkVersionName();
                                AbTestDataManager.getInstance().saveZeusSdkVersion(zeusSdkVer);
                                if (BlinkInitHelper.DEBUG) {
                                    Log.d(BlinkInitHelper.TAG, "update zeus version = " + zeusVer + ",zeus sdk version =" + zeusSdkVer);
                                }
                            }
                            synchronized (BlinkInitHelper.this.backgroundInitLock) {
                                boolean unused2 = BlinkInitHelper.this.isBackgroundInited = true;
                                BlinkInitHelper.this.backgroundInitLock.notifyAll();
                                BlinkInitHelper.this.notifyBlinkLoaded();
                                if (BlinkInitHelper.DEBUG) {
                                    Log.d(BlinkInitHelper.TAG, BlinkInitHelper.this.mLaunchTypeStr + "initBWebkit notifyAll");
                                }
                            }
                        }
                    }, "doInitBWebkit", 2);
                    this.hasCallInitBWebkit = true;
                }
            }
            if (isNeedWait) {
                if (z) {
                    Log.d(TAG, this.mLaunchTypeStr + "initBWebkit start wait thread-name: " + Thread.currentThread().getName());
                }
                synchronized (this.backgroundInitLock) {
                    int waitCount = 0;
                    while (true) {
                        if (this.isBackgroundInited) {
                            break;
                        }
                        waitCount++;
                        try {
                            if (shouldCollectWaitInfo(waitCount)) {
                                collectWaitInfos();
                                break;
                            }
                            this.backgroundInitLock.wait(1000);
                        } catch (InterruptedException e2) {
                            if (DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d(TAG, this.mLaunchTypeStr + "initBWebkit end wait thread-name: " + Thread.currentThread().getName());
                }
            }
        }
    }

    private boolean shouldCollectWaitInfo(int waitCount) {
        return false;
    }

    private void collectWaitInfos() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(AppRuntime.getAppContext().getFilesDir(), EXCEPTION_WAIT_WEBKIT_INIT_TIMEOUT));
            fw.write("CurrentThreadId: " + Thread.currentThread().getId() + "\n");
            fw.write("CurrentThreadName: " + Thread.currentThread().getName() + "\n");
            fw.write("CurrentStatckTrace:");
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            for (int i2 = 0; i2 < length; i2++) {
                fw.write("\nat " + stackTrace[i2]);
            }
            fw.write("\n\n");
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                fw.write("ThreadId: " + entry.getKey().getId() + "\n");
                fw.write("ThreadName: " + entry.getKey().getName() + "\n");
                fw.write("ThreadCallStack:");
                StackTraceElement[] stackTrace2 = entry.getValue();
                int i3 = 0;
                while (stackTrace2 != null && i3 < stackTrace2.length) {
                    fw.write("\nat " + stackTrace2[i3]);
                    i3++;
                }
                fw.write("\n\n");
            }
            try {
                fw.close();
            } catch (IOException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e4) {
                    if (DEBUG) {
                        e4.printStackTrace();
                    }
                }
            }
        } catch (Throwable e5) {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e6) {
                    if (DEBUG) {
                        e6.printStackTrace();
                    }
                }
            }
            throw e5;
        }
        if (DEBUG) {
            throw new RuntimeException(this.mLaunchTypeStr + "init webkit already reached wait max count.");
        }
    }

    /* access modifiers changed from: private */
    public void doInitBWebkit(boolean isMainProcess) {
        long timeOnBdSailorInitialized;
        int httpCacheSize;
        int httpCacheSize2;
        long timeOnStart = System.currentTimeMillis();
        if (isMainProcess) {
            try {
                Abi64WebViewCompat.deleteWebViewGpuCacheIfNeed();
                if (!LoggerPreferenceWrapper.getInstance().getBoolean(ZEUS_UNUSED_DOWNLOAD_FILES_CLEARED, false)) {
                    clearZeusPMSUnusedDownloadFilesIfNeeded();
                }
            } catch (Throwable e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        BaiduIdentityManager manager = BaiduIdentityManager.getInstance();
        if (!isMainProcess) {
            WebKitFactory.setNeedDownloadCloudResource(false);
        }
        String processName = ProcessUtils.getCurProcessName();
        if (isMainProcess) {
            WebKitFactory.setProcessType("0");
        } else if (!TextUtils.isEmpty(processName)) {
            WebKitFactory.setProcessType("1");
        } else {
            WebKitFactory.setProcessType("-1");
        }
        setZid();
        if (WarmTipsManager.hasConfirmDialog()) {
            BdSailor.getInstance().init(AppRuntime.getAppContext(), (String) null, manager.getUid());
        } else {
            updateUserPrivacyConfirm2T7Kernel();
            BdSailor.getInstance().init(AppRuntime.getAppContext(), (String) null);
        }
        long timeOnBdSailorInitialized2 = System.currentTimeMillis() - timeOnStart;
        boolean useSysWebKit = QuickPersistConfig.getInstance().getBoolean("use_sys_webkit", false) || BlinkAbTestManager.SwanAppBlinkAbTest.isSwanAppUseSysWebView() || shouldAsyncInstallZeus();
        if (useSysWebKit) {
            boolean z = DEBUG;
            if (z) {
                Log.d(BlinkAbTestManager.TAG, "doInitBWebkit use sys webview.");
            }
            BdSailor.getInstance().setWebkitEnable(false);
            if (z) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 19) {
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    }
                });
            }
        }
        long timeOnWebkitConfigured = System.currentTimeMillis() - timeOnStart;
        String enableMultipleProcess = QuickPersistConfig.getInstance().getString(QuickPersistConfigConst.KEY_ENABLE_MULTIPLE_PROCESS, "");
        if (!TextUtils.isEmpty(enableMultipleProcess)) {
            WebKitFactory.setEnableMultiprocess(Boolean.parseBoolean(enableMultipleProcess));
        }
        BdSailor.getInstance().setSailorClient(new GeolocationServiceClient(AppRuntime.getAppContext()));
        long timeOnGeoLocationConfigured = System.currentTimeMillis() - timeOnStart;
        boolean z2 = DEBUG;
        if (z2) {
            Log.d("ZeusInstallABLog", "LaunchType: " + this.mLaunchTypeStr + " initBWebkit call initWebkit start.");
        }
        BdSailor.getInstance().setSailorCloudSettingInterface(ZeusCloudSettingListener.getCloudSettingImpl());
        BdSailor.getInstance().setSailorAbTestInterface(NgWebViewRuntime.getNgWebViewContext().getAbTestInterface());
        BdSailor.getInstance().setSailorPMSDownloadInterface(ZeusPMSChannel.getPMSDownloadImpl());
        BdSailor.getInstance().setSailorUploadInterface(new BOSUploadBridge());
        BdSailor.getInstance().setSailorYalogInterface(ZeusYalogImpl.getInstance());
        SessionMonitorEngine.getInstance().setStatisticsTransmission(StatisticsTransmissionImpl.getInstance());
        long timeOnGeoLocationConfigured2 = timeOnGeoLocationConfigured;
        long timeOnWebkitConfigured2 = timeOnWebkitConfigured;
        if (!BlinkAbTestManager.SearchBrowserAbTest.isZeusSdkRefactorEnable()) {
            if (isMainProcess) {
                httpCacheSize2 = getHttpCacheSizeByDiskLevel();
            } else {
                httpCacheSize2 = getSwanHttpCacheSizeByDiskLevel();
            }
            timeOnBdSailorInitialized = timeOnBdSailorInitialized2;
            BdSailor.getInstance().initWebkit("baiduboxapp", NgWebViewRuntime.getNgWebViewContext().isBuildinFileExist(), 0, httpCacheSize2);
            if (z2) {
                Log.i(TAG, "getHttpCacheSizeByDiskLevel=" + httpCacheSize2 + "====process=" + processName);
            }
        } else {
            timeOnBdSailorInitialized = timeOnBdSailorInitialized2;
            if (isMainProcess) {
                httpCacheSize = getHttpCacheSizeByDiskLevel();
            } else {
                httpCacheSize = getSwanHttpCacheSizeByDiskLevel();
            }
            if (z2) {
                Log.i(TAG, "getHttpCacheSizeByDiskLevel=" + httpCacheSize + "====process=" + processName);
            }
            ZeusLauncher.setZeusSdkRefactorEnabled(true);
            ZeusLauncher.Config.Builder builder = new ZeusLauncher.Config.Builder();
            builder.setApplicationContext(AppRuntime.getAppContext()).setAppId("baiduboxapp").setUseSystemWebKit(useSysWebKit).setIsLowDevice(isLowEndDevice()).setUserPrivacyConfirm(WarmTipsManager.hasConfirmDialog()).setHttpCacheSize(httpCacheSize).setDeviceScore(deviceScore(), lowMidThreshold(), highMidThreshold()).setLaunchType(this.mLaunchType);
            if (WarmTipsManager.hasConfirmDialog()) {
                builder.setCuid(manager.getUid());
            }
            if (!TextUtils.isEmpty(enableMultipleProcess)) {
                builder.setEnableMultiProcess(Boolean.parseBoolean(enableMultipleProcess));
            }
            ZeusLauncher.getInstance().start(builder.build(), new ZeusLauncher.IWebKitListener() {
                public void onWebkitInitFinished(boolean isZeusProvider) {
                }
            });
        }
        long timeOnWebkitInitialized = System.currentTimeMillis() - timeOnStart;
        if (z2) {
            Log.d(TAG, this.mLaunchTypeStr + "initBWebkit call initWebkit end.");
        }
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (z2) {
                Log.d(TAG, "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (z2) {
            Log.d(TAG, "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        BdSailor.initCookieSyncManager(AppRuntime.getAppContext());
        if (NgWebViewRuntime.getNgWebViewContext().isDefaultEnableJsPrompt()) {
            BdSailorWebSettings.setDefaultEnableJsPromptSailor(true);
        } else {
            BdSailorWebSettings.setDefaultEnableJsPromptSailor(false);
        }
        if (z2) {
            BdSailorWebSettings.setDefaultJsCheckPolicySailor(new BdJsCheckPolicy() {
                public void onJsCheckFinished(BdJsCallInfo bdJsCallInfo) {
                }

                public void onJsCheckUnFinished(final BdJsCallInfo bdJsCallInfo) {
                    ExecutorUtilsExt.getElasticExecutor("onJsCheckUnFinished", 2).execute(new Runnable() {
                        public void run() {
                            throw new RuntimeException(bdJsCallInfo.getJsMethodDeclaration() + " must call JsCallInfoChecker check() method.");
                        }
                    });
                }
            });
        }
        if (z2) {
            Log.d(TAG, "abtest sid=" + manager.getSid());
        }
        WebKitFactory.addStatisticParam("searchbox_sid", manager.getSid());
        WebKitFactory.setAbExpInfos(AbTestManager.getInstance().getExpInfos());
        if (ProcessUtils.isMainProcess()) {
            boolean crashpadEnable = AbTestManager.getInstance().getSwitch(SEARCHBOX_CRASHPAD_ENABLE, false);
            LoggerPreferenceWrapper.getInstance().putBoolean(LoggerConfigConstant.SEARCHBOX_CRASHPAD_SWITCHER, crashpadEnable);
            boolean crashpadUploadEnable = AbTestManager.getInstance().getSwitch("upload_crashpad_log_to_kernel", true);
            LoggerPreferenceWrapper.getInstance().putBoolean("upload_crashpad_log_to_kernel", crashpadUploadEnable);
            if (z2) {
                Log.d(TAG, "CRASHPAD doInitBWebkit crashpadEnable:" + crashpadEnable + ", upload_crashpad_log_to_kernel=" + crashpadUploadEnable + ", sid: " + manager.getSid() + ", ProcessUtils.getCurProcessName():" + ProcessUtils.getCurProcessName());
            }
        }
        SimCardHelper.getInstance().register(new ISimCardObserver() {
            public void updateSimCardData(boolean isFreeFlowSimCard, SimCardData simCardData) {
                boolean isMobileNet = NetWorkUtils.isMobileNetworkConnected();
                boolean isMobcomNet = SimCardHelper.getInstance().isMobcomFreeCard();
                boolean isSimBindStatus = SimBindHelper.getInstance().getSimBindStatusFromDisk();
                WebSettings.setFreeFlow(isMobileNet && !isMobcomNet && (isFreeFlowSimCard || isSimBindStatus));
                if (BlinkInitHelper.DEBUG) {
                    Log.d(BlinkInitHelper.TAG, "WebSettings.setFreeFlow: freeFlowSim:" + isFreeFlowSimCard + "  mobileNet：" + isMobileNet + "  simBindStatus:" + isSimBindStatus);
                }
            }
        });
        ExecutorUtilsExt.getElasticExecutor("notifySimCardObservers", 2).execute(new Runnable() {
            public void run() {
                if (BlinkInitHelper.DEBUG) {
                    Log.d(BlinkInitHelper.TAG, "notifySimCardObservers after register");
                }
                SimCardHelper.getInstance().notifySimCardObservers();
            }
        });
        SimBindHelper.getInstance().register(new ISimBindObserver() {
            public void updateSimBindStatus(boolean isSimBindStatus) {
                WebSettings.setVideoPlayerMode(isSimBindStatus);
                if (BlinkInitHelper.DEBUG) {
                    Log.d(BlinkInitHelper.TAG, "WebSettings.setVideoPlayerMode: simBindStatus:" + isSimBindStatus);
                }
            }
        });
        ExecutorUtilsExt.getElasticExecutor("notifySimBindObservers", 2).execute(new Runnable() {
            public void run() {
                if (BlinkInitHelper.DEBUG) {
                    Log.d(BlinkInitHelper.TAG, "notifySimBindObservers after register");
                }
                SimBindHelper.getInstance().notifySimBindObservers();
            }
        });
        if (z2) {
            Object[] objArr = new Object[6];
            objArr[0] = useSysWebKit ? "SYS" : "_T7";
            objArr[1] = Long.valueOf(System.currentTimeMillis() - timeOnStart);
            objArr[2] = Long.valueOf(timeOnBdSailorInitialized);
            objArr[3] = Long.valueOf(timeOnWebkitConfigured2);
            objArr[4] = Long.valueOf(timeOnGeoLocationConfigured2);
            objArr[5] = Long.valueOf(timeOnWebkitInitialized);
            Log.i(TAG, String.format("Webkit init with: %s -> %d \n step1[%d] OnBdSailorInitialized \n step2[%d] OnWebkitConfigured \n step3[%d] OnGeoLocationConfigured \n step4[%d] OnWebkitInitialized", objArr));
        }
    }

    private void clearZeusPMSUnusedDownloadFilesIfNeeded() {
        File[] downloadFiles;
        try {
            File zeusPMSDownloadDir = new File(AppRuntime.getAppContext().getFilesDir().getAbsolutePath(), ZEUS_DOWNLOAD_DIR_NAME);
            if (zeusPMSDownloadDir.exists() && zeusPMSDownloadDir.isDirectory() && (downloadFiles = zeusPMSDownloadDir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.contains("com.baidu.zeus");
                }
            })) != null) {
                long ddlTime = new SimpleDateFormat("yyyy-MM-dd").parse("2023-11-01").getTime();
                for (File file : downloadFiles) {
                    if (DEBUG) {
                        Log.d(TAG, "clearZeusPMSUnusedDownloadFilesIfNeeded ddl time=" + ddlTime + ", file.lastModified()=" + file.lastModified());
                    }
                    if (file.exists() && file.isFile() && file.lastModified() < ddlTime) {
                        file.delete();
                    }
                }
            }
            LoggerPreferenceWrapper.getInstance().putBoolean(ZEUS_UNUSED_DOWNLOAD_FILES_CLEARED, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getLowDeviceZeusInstallType() {
        return this.mLowDeviceZeusInstallType;
    }

    private boolean shouldAsyncInstallZeus() {
        return this.mLaunchType == 2 && isLowEndDevice() && ProcessUtils.isMainProcess();
    }

    private float deviceScore() {
        IDevicePortraitManager devicePortraitManager = (IDevicePortraitManager) ServiceManager.getService(IDevicePortraitManager.SERVICE_REFERENCE);
        if (devicePortraitManager != null) {
            return devicePortraitManager.getStaticDeviceScore(AppRuntime.getAppContext());
        }
        return -1.0f;
    }

    private float lowMidThreshold() {
        IDevicePortraitManager devicePortraitManager = (IDevicePortraitManager) ServiceManager.getService(IDevicePortraitManager.SERVICE_REFERENCE);
        if (devicePortraitManager != null) {
            return devicePortraitManager.getDefaultScoreThreshold(IDevicePortraitManager.ThresholdType.LOW_MID);
        }
        return -1.0f;
    }

    private float highMidThreshold() {
        IDevicePortraitManager devicePortraitManager = (IDevicePortraitManager) ServiceManager.getService(IDevicePortraitManager.SERVICE_REFERENCE);
        if (devicePortraitManager != null) {
            return devicePortraitManager.getDefaultScoreThreshold(IDevicePortraitManager.ThresholdType.MID_HIGH);
        }
        return -1.0f;
    }

    private boolean isLowEndDevice() {
        IDevicePortraitManager devicePortraitManager = (IDevicePortraitManager) ServiceManager.getService(IDevicePortraitManager.SERVICE_REFERENCE);
        if (devicePortraitManager == null) {
            return false;
        }
        float deviceScore = devicePortraitManager.getStaticDeviceScore(AppRuntime.getAppContext());
        float lowMidThreshold = devicePortraitManager.getDefaultScoreThreshold(IDevicePortraitManager.ThresholdType.LOW_MID);
        if (DEBUG) {
            Log.d("ZeusInstallABLog", "deviceScore " + deviceScore + " lowMidThreshold " + lowMidThreshold);
        }
        if (deviceScore < lowMidThreshold) {
            return true;
        }
        return false;
    }

    public boolean isBWebkitInited() {
        return this.isBWebkitInited;
    }

    public void addBlinkInitListener(BlinkInitListener listener) {
        synchronized (this.backgroundInitLock) {
            if (DEBUG) {
                Log.d(TAG, "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(listener)) {
                this.mListeners.add(listener);
                if (!this.isBackgroundInited) {
                    WaitBlinkInit waitInfo = new WaitBlinkInit();
                    waitInfo.updateStartInfo();
                    this.extWaitMap.put(listener, waitInfo);
                }
            }
            if (this.isBackgroundInited) {
                notifyBlinkLoaded();
            }
        }
    }

    @Deprecated
    public void delBlinkInitListener(BlinkInitListener listener) {
    }

    public void notifyBlinkLoaded() {
        synchronized (this.backgroundInitLock) {
            if (DEBUG) {
                Log.d(TAG, "notifyBlinkLoaded.");
            }
            Iterator<BlinkInitListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                BlinkInitListener listener = it.next();
                WaitBlinkInit info = this.extWaitMap.remove(listener);
                if (info != null) {
                    info.updateEndInfo();
                    info.doBlinkWaitUBC();
                }
                listener.onInitFinished();
                if (DEBUG) {
                    Log.d(TAG, "onInitFinished. listener: " + listener);
                }
                it.remove();
            }
        }
    }

    public int getLaunchType() {
        return this.mLaunchType;
    }

    public void setZidForWebKit() {
        setZid();
    }

    private class WaitBlinkInit {
        public long mDuration;
        long mEndTime;
        long mStartTime;

        private WaitBlinkInit() {
        }

        public void updateStartInfo() {
            this.mStartTime = System.currentTimeMillis();
            this.mEndTime = -1;
        }

        public void updateEndInfo() {
            long currentTimeMillis = System.currentTimeMillis();
            this.mEndTime = currentTimeMillis;
            this.mDuration = currentTimeMillis - this.mStartTime;
        }

        public void doBlinkWaitUBC() {
            JSONObject json = new JSONObject();
            try {
                json.put("waitWebkit", this.mDuration);
                json.put("waitDetail", getTimeDetail());
            } catch (JSONException e2) {
                if (BlinkInitHelper.DEBUG) {
                    e2.printStackTrace();
                }
            }
            ExternalTransferSpeedStats.setValueWithJson(json);
        }

        private JSONObject getTimeDetail() {
            JSONObject json = new JSONObject();
            try {
                json.put("startTime", this.mStartTime);
                json.put("endTime", this.mEndTime);
            } catch (JSONException e2) {
                if (BlinkInitHelper.DEBUG) {
                    e2.printStackTrace();
                }
            }
            return json;
        }
    }

    public void setCuidCookie() {
        if (WarmTipsManager.isPermissionGrantedForProcess()) {
            new CuidCookieSync().setCUIDCookie();
            if (DEBUG) {
                Log.i(TAG, "WarmConfirm is agreed ,setCuidCookie");
            }
        } else if (DEBUG) {
            Log.i(TAG, "WarmConfirm is not agreed!");
        }
    }

    public void setCuid() {
        if (WarmTipsManager.hasConfirmDialog()) {
            BdSailor.getInstance().setCuid(BaiduIdentityManager.getInstance().getUid());
            ZwCrashpad.setCuid(WebKitFactory.getCUIDString());
            if (DEBUG) {
                Log.i(TAG, "WarmConfirm is agreed ,setCuid: " + BaiduIdentityManager.getInstance().getUid());
            }
        } else if (DEBUG) {
            Log.i(TAG, "WarmConfirm is not agreed!");
        }
    }

    /* access modifiers changed from: private */
    public void setTeenagerCookie() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                NgWebViewRuntime.getNgWebViewContext().setCookieManualNoBdussOperate(BlinkInitHelper.COOKIE_URL, UrlUtil.getCookieStr(".baidu.com", BlinkInitHelper.COOKIE_KEY, String.valueOf(StyleMode.INSTANCE.getCurrentStyle()), 314496000), true, "");
            }
        }, "setTeenagerCookie", 2);
    }

    /* access modifiers changed from: private */
    public void setPrivaceModeCookie() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (!PrivacyMode.INSTANCE.isSwitchOn()) {
                    int currentState = PrivacyMode.INSTANCE.getCurrentState();
                    PrivacyModeRuntime.getPrivactModeContext().clearCookie(currentState);
                    if (BlinkInitHelper.DEBUG) {
                        Log.i(BlinkInitHelper.TAG, "WarmConfirm is agreed ,setPrivacyModeCookie currentState = " + currentState);
                        return;
                    }
                    return;
                }
                NgWebViewRuntime.getNgWebViewContext().setCookieManualNoBdussOperate(BlinkInitHelper.COOKIE_URL, UrlUtil.getCookieStr(".baidu.com", BlinkInitHelper.PRIVACY_MODE_COOKIE_KEY, String.valueOf(PrivacyMode.INSTANCE.getCurrentState()), 314496000), false, "");
            }
        }, "setPrivacyModeCookie", 2);
    }

    public void setZid() {
        if (WarmTipsManager.hasConfirmDialog()) {
            WebKitFactory.setZID(BaiduIdentityManager.getInstance().getZid());
            if (DEBUG) {
                Log.i(TAG, "WarmConfirm is agreed ,setZid: " + BaiduIdentityManager.getInstance().getZid());
            }
        } else if (DEBUG) {
            Log.i(TAG, "WarmConfirm is not agreed!");
        }
    }

    public void updateUserPrivacyConfirm2T7Kernel() {
        BdSailor.getInstance().notifyUserPrivacyConfirmIfNeeded(WarmTipsManager.hasConfirmDialog());
    }

    private int getHttpCacheSizeByDiskLevel() {
        if (isLowDeviceLevelUseLowestHttpCacheSize()) {
            IDeviceScore iDeviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
            IDeviceScore deviceScoreService = iDeviceScore;
            if (iDeviceScore != null && deviceScoreService.getScoreLevel(AppRuntime.getAppContext()) == 1) {
                return 20;
            }
        }
        if (DiskManager.INSTANCE.getDiskLevel() == DiskManager.DiskLevel.WARNING) {
            return getLowHttpCacheSizeABValue();
        }
        if (DiskManager.INSTANCE.getDiskLevel() == DiskManager.DiskLevel.CRITICAL) {
            return 20;
        }
        return getNormalHttpCacheSizeABValue();
    }

    private int getNormalHttpCacheSizeABValue() {
        return AbTestManager.getInstance().getSwitch(NORMAL_HTTP_CACHE_SIZE_KEY, 80);
    }

    private int getLowHttpCacheSizeABValue() {
        return AbTestManager.getInstance().getSwitch(LOW_HTTP_CACHE_SIZE_KEY, 40);
    }

    private boolean isLowDeviceLevelUseLowestHttpCacheSize() {
        return AbTestManager.getInstance().getSwitch(LOW_DEVICE_LEVEL_USE_LOWEST_HTTP_CACHE_SIZE_KEY, true);
    }

    private int getSwanHttpCacheSizeByDiskLevel() {
        if (isFrequencySwanProcess()) {
            return getSwanMainHttpCacheSizeABValue();
        }
        return getSwanOtherHttpCacheSizeABValue();
    }

    private int getSwanMainHttpCacheSizeABValue() {
        return AbTestManager.getInstance().getSwitch(SWAN_MAIN_HTTP_CACHE_SIZE_KEY, 20);
    }

    private int getSwanOtherHttpCacheSizeABValue() {
        return AbTestManager.getInstance().getSwitch(SWAN_OTHER_HTTP_CACHE_SIZE_KEY, 15);
    }

    private boolean isFrequencySwanProcess() {
        String processName = ProcessUtils.getCurProcessName();
        if (TextUtils.isEmpty(processName)) {
            return false;
        }
        if (processName.contains(SWAN_APP_PROCESS_SUFFIX_0) || processName.contains(SWAN_APP_PROCESS_SUFFIX_1)) {
            return true;
        }
        return false;
    }

    public static void setWebViewDataDirectorySuffix() {
        try {
            if (!mIsHasSetWebViewDataDirectory) {
                WebViewFactory.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
                mIsHasSetWebViewDataDirectory = true;
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
