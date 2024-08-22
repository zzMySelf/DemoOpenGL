package com.baidu.searchbox.introduction.afd;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.launch.stats.LaunchStatsUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.ad.exp.adconfig.AfdBootRequester;
import com.baidu.searchbox.ad.model.FeedAdGestureLottieModel;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.gamecore.hybrid.model.PackageDownloadInfo;
import com.baidu.searchbox.introduction.IntroductionAdStatusChannel;
import com.baidu.searchbox.introduction.SplashUtils;
import com.baidu.searchbox.introduction.afd.PerformanceLogModel;
import com.baidu.searchbox.introduction.data.SplashData;
import com.baidu.searchbox.introduction.data.SplashDataManager;
import com.baidu.searchbox.introduction.data.SplashPolicyRecorder;
import com.baidu.searchbox.introduction.data.SplashType;
import com.baidu.searchbox.introduction.hotboot.HotSplashManager;
import com.baidu.searchbox.introduction.rtload.SplashRtLoadManager;
import com.baidu.searchbox.introduction.statistic.SplashReportUtils;
import com.baidu.searchbox.settings.extend.ISettingsFun;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashAfdManager {
    private static final String AFD_QUERY = "afd_query";
    private static final String BOOT_TYPE = "boot_type";
    private static final String CMD = "cmd";
    public static final int COLD_BOOT = 0;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String DOWNLOAD_INFO = "download_info";
    private static final long ELOG_TASK_DELAY = 3000;
    private static final String ELOG_TASK_NAME = "splash_query_elog";
    private static final String EXT_INFO = "ext_info";
    private static final String EXT_KEY = "k";
    private static final String EXT_VALUE = "v";
    private static final String HOT_BACKGROUND_TIME = "hot_background_time";
    private static final String HOT_BG_TIME = "hot_background_time";
    private static final int HOT_BOOT = 1;
    private static final String INVALID_UKEY_INFO = "invalid_ukey_info";
    private static final String KEY_AFTER_TOMORROW_QUERY_INFO = "after_tomorrow_query_info";
    private static final String KEY_CACHE_QUERY_INFO = "cache_query_info";
    private static final String KEY_CACHE_QUERY_INFO_TIME = "cache_query_info_time";
    private static final String KEY_CURRENT_QUERY_INFO = "current_query_info";
    private static final String KEY_DIFF_SPLIT_QUERY_INFO = "diff_splittime_query_info";
    private static final String KEY_HOT_BG_TIME = "key_hot_bg_time";
    private static final String KEY_PRE_HOT_BG_TIME = "key_pre_hot_bg_time";
    private static final String KEY_PRE_QUERY_DELAY_COLD_TIME = "key_pre_query_delay_cold_time";
    private static final String KEY_PRE_QUERY_DELAY_WARM_TIME = "key_pre_query_delay_warm_time";
    private static final String KEY_PRE_QUERY_HOT_TIMEOUT = "key_pre_query_hot_timeout";
    private static final String KEY_PRE_QUERY_SWITCH_OPT = "key_pre_query_switch_opt";
    private static final String KEY_QUERY_DELAY_COLD_TIME = "key_query_delay_cold_time";
    private static final String KEY_QUERY_DELAY_WARM_TIME = "key_query_delay_warm_time";
    private static final String KEY_QUERY_HOT_TIMEOUT_NEW = "key_query_hot_timeout_new";
    private static final String KEY_QUERY_LOG_OPT = "key_query_log_opt";
    private static final String KEY_QUERY_SWITCH_OPT_NEW = "key_query_switch_opt_new";
    private static final String KEY_SAME_SPLIT_QUERY_INFO = "same_splittime_query_info";
    private static final String KEY_TOMORROW_QUERY_INFO = "tomorrow_query_info";
    private static final String LOG_ID = "logid";
    private static final String PID_CONTENT = "1573559779244";
    private static final String PRE_HOT_BG_TIME = "pre_hot_background_time";
    private static final String PRE_QUERY_DELAY_COLD_TIME = "pre_query_delay_cold_time";
    private static final String PRE_QUERY_DELAY_WARM_TIME = "pre_query_delay_warm_time";
    private static final String PRE_QUERY_HOT_TIMEOUT = "pre_query_hot_timeout";
    private static final String PRE_QUERY_SWITCH_OPT = "pre_query_switch_opt";
    private static final String QUERY = "query";
    private static final String QUERY_BOOT_TYPE = "QUERY_BOOT_TYPE";
    private static final String QUERY_DEFAULT_TAB = "QUERY_DEFAULT_TAB";
    private static final String QUERY_DELAY_COLD_TIME = "query_delay_cold_time";
    private static final int QUERY_DELAY_MAX_TIME = 1000;
    private static final String QUERY_DELAY_WARM_TIME = "query_delay_warm_time";
    public static final int QUERY_FAIL = 0;
    private static final int QUERY_FAIL_NO_CHANCE = 2;
    private static final String QUERY_HOT_BACKGROUND_TIME = "QUERY_HOT_BACKGROUND_TIME";
    private static final String QUERY_HOT_TIMEOUT = "query_hot_timeout";
    private static final String QUERY_LOG_ID = "QUERY_LOG_ID";
    private static final String QUERY_LOG_OPT = "query_log_opt";
    public static final int QUERY_SUCCESS = 1;
    private static final int QUERY_SUCCESS_NO_CHANGE = 3;
    private static final int QUERY_SWITCH_ABANDON = 2;
    private static final int QUERY_SWITCH_KEEP = 1;
    private static final String QUERY_SWITCH_OPT = "query_switch_opt";
    private static final int SHOW_FROM_OTHER = 0;
    private static final int SHOW_FROM_QUERY = 1;
    private static final int SHOW_FROM_RT = 3;
    private static final int SPLASH_CHECK_OK = 0;
    private static final String TAG = "SplashAfdManager";
    private static final int WARM_BOOT = 2;
    private boolean isReportEvery;
    /* access modifiers changed from: private */
    public boolean isRequestEmptyUkey;
    /* access modifiers changed from: private */
    public boolean isResponseEmptyUkey;
    /* access modifiers changed from: private */
    public long mBootEndTime;
    /* access modifiers changed from: private */
    public int mBootType;
    /* access modifiers changed from: private */
    public long mColdBootTime;
    /* access modifiers changed from: private */
    public String mDpLogId;
    /* access modifiers changed from: private */
    public int mFromQuery;
    /* access modifiers changed from: private */
    public long mGetUrlTime;
    /* access modifiers changed from: private */
    public boolean mIsNewBuild;
    private boolean mIsQueryTimeout;
    private boolean mIsSendQuery;
    /* access modifiers changed from: private */
    public String mLogId;
    private ArrayList<String> mPreLinkUrlList;
    /* access modifiers changed from: private */
    public long mQueryEndTime;
    /* access modifiers changed from: private */
    public JSONObject mQueryMergeData;
    private final Object mQueryMonitor;
    /* access modifiers changed from: private */
    public String mQueryResult;
    /* access modifiers changed from: private */
    public long mQueryStartTime;
    /* access modifiers changed from: private */
    public int mQueryStatus;
    private String mQueryUkey;
    /* access modifiers changed from: private */
    public long mRequestStartTime;
    private double mRtHotSensitivity;
    private double mRtSensitivity;
    private double mRtShakeActionDelayTime;
    private int mRtShakeDirectionCount;
    private int mRtShakeInterval;
    /* access modifiers changed from: private */
    public boolean mSendQuery;
    private int mShowFrom;
    /* access modifiers changed from: private */
    public volatile int mState;
    /* access modifiers changed from: private */
    public int mTotalDelayTime;
    /* access modifiers changed from: private */
    public String mUkey;

    private SplashAfdManager() {
        this.mState = 1;
        this.mQueryMonitor = new Object();
        this.mPreLinkUrlList = new ArrayList<>();
        this.mRtSensitivity = 0.0d;
        this.mRtHotSensitivity = 0.0d;
        this.mRtShakeInterval = 0;
        this.mRtShakeDirectionCount = 0;
        this.mRtShakeActionDelayTime = 0.0d;
    }

    public static SplashAfdManager getInstance() {
        return InnerHolder.INSTANCE;
    }

    private static class InnerHolder {
        /* access modifiers changed from: private */
        public static final SplashAfdManager INSTANCE = new SplashAfdManager();

        private InnerHolder() {
        }
    }

    public void coldBootQuery() {
        try {
            queryAfd(0);
            AfdBootRequester.requestOnColdBoot();
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "coldBootQuery: 问询时机早于IOC注入导致NPE!");
            }
        }
    }

    public void hotBootQuery() {
        this.mState = 4;
        queryAfd(1);
    }

    public void warmBootQuery() {
        queryAfd(2);
    }

    private void queryAfd(final int bootType) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (bootType == 0) {
                    SplashAfdManager.this.preloadSplashDataList();
                }
                if (SplashAfdManager.this.isQueryEnable()) {
                    int unused = SplashAfdManager.this.mFromQuery = 0;
                    final String logId = String.valueOf(System.currentTimeMillis());
                    long unused2 = SplashAfdManager.this.mQueryStartTime = System.currentTimeMillis();
                    boolean unused3 = SplashAfdManager.this.mSendQuery = true;
                    if (bootType == 1) {
                        IntroductionAdStatusChannel.updateShouldWaitHotSplash(true);
                    }
                    HotSplashManager.getInstance().resetShowHotSplashFlag();
                    int unused4 = SplashAfdManager.this.mState = 4;
                    SplashRtLoadManager.getInstance().tryQueryMergeRequest(logId, bootType, new SplashRtLoadManager.SplashQueryCallBack() {
                        public void querySuccess(JSONObject data, String message) {
                            if (data != null) {
                                SplashAfdManager.this.parseRtShakeParams(data);
                                JSONObject unused = SplashAfdManager.this.mQueryMergeData = data;
                                String unused2 = SplashAfdManager.this.mUkey = data.optString("ukey");
                                if (data.has("ukey") && TextUtils.isEmpty(SplashAfdManager.this.mUkey)) {
                                    boolean unused3 = SplashAfdManager.this.isResponseEmptyUkey = true;
                                }
                                if (SplashAfdManager.DEBUG) {
                                    Log.d(SplashAfdManager.TAG, "querySuccess:" + SplashAfdManager.this.mUkey);
                                }
                            }
                            int unused4 = SplashAfdManager.this.mState = 2;
                            int unused5 = SplashAfdManager.this.mBootType = bootType;
                            long unused6 = SplashAfdManager.this.mQueryEndTime = System.currentTimeMillis();
                            String unused7 = SplashAfdManager.this.mLogId = logId;
                            String unused8 = SplashAfdManager.this.mDpLogId = logId;
                            String unused9 = SplashAfdManager.this.mQueryResult = message;
                            SplashAfdManager.this.tryPostEveryLog();
                        }

                        public void queryFail(String message) {
                            int unused = SplashAfdManager.this.mState = 3;
                            int unused2 = SplashAfdManager.this.mBootType = bootType;
                            long unused3 = SplashAfdManager.this.mQueryEndTime = System.currentTimeMillis();
                            String unused4 = SplashAfdManager.this.mLogId = logId;
                            String unused5 = SplashAfdManager.this.mDpLogId = logId;
                            String unused6 = SplashAfdManager.this.mQueryResult = message;
                            SplashAfdManager.this.notifyQueryMonitor();
                            SplashAfdManager.this.tryPostEveryLog();
                        }
                    });
                } else if (bootType == 1) {
                    IntroductionAdStatusChannel.updateShouldWaitHotSplash(false);
                }
            }
        }, AFD_QUERY, 2);
        tryDspPreLink();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0148 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getExtra(boolean r19, long r20) {
        /*
            r18 = this;
            java.lang.String r1 = ""
            java.lang.String r0 = "v"
            java.lang.String r2 = "k"
            r3 = 0
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x0138 }
            r6.<init>()     // Catch:{ Exception -> 0x0138 }
            r3 = r6
            com.baidu.searchbox.introduction.data.SplashDataManager r6 = com.baidu.searchbox.introduction.data.SplashDataManager.getInstance()     // Catch:{ Exception -> 0x0138 }
            com.baidu.searchbox.introduction.data.SplashType$DataType r7 = com.baidu.searchbox.introduction.data.SplashType.DataType.SPLASH     // Catch:{ Exception -> 0x0138 }
            java.util.List r6 = r6.getSplashDataList(r7)     // Catch:{ Exception -> 0x0138 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0138 }
            r7.<init>()     // Catch:{ Exception -> 0x0138 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0138 }
            r8.<init>()     // Catch:{ Exception -> 0x0138 }
            r4 = r8
            boolean r8 = com.baidu.fsg.base.utils.CollectionUtils.isEmpty((java.util.Collection<?>) r6)     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x00a2
            java.util.Iterator r8 = r6.iterator()     // Catch:{ Exception -> 0x0138 }
        L_0x0034:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x0138 }
            if (r9 == 0) goto L_0x0099
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x0138 }
            com.baidu.searchbox.introduction.data.SplashData r9 = (com.baidu.searchbox.introduction.data.SplashData) r9     // Catch:{ Exception -> 0x0138 }
            java.lang.String r10 = r9.ukey     // Catch:{ Exception -> 0x0138 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0138 }
            if (r10 != 0) goto L_0x008e
            com.baidu.searchbox.introduction.data.SplashDataManager r10 = com.baidu.searchbox.introduction.data.SplashDataManager.getInstance()     // Catch:{ Exception -> 0x0138 }
            r11 = r19
            r12 = r20
            int r10 = r10.checkSplashDataCanShowable(r9, r11, r12)     // Catch:{ Exception -> 0x0089 }
            if (r10 != 0) goto L_0x007f
            r14 = r18
            boolean r15 = r14.checkSplashDataUseBackupSourceUrl(r9)     // Catch:{ Exception -> 0x0136 }
            if (r15 == 0) goto L_0x0076
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0136 }
            r15.<init>()     // Catch:{ Exception -> 0x0136 }
            r16 = r6
            java.lang.String r6 = r9.ukey     // Catch:{ Exception -> 0x0136 }
            java.lang.StringBuilder r6 = r15.append(r6)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r15 = "-1"
            java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0136 }
            goto L_0x007a
        L_0x0076:
            r16 = r6
            java.lang.String r6 = r9.ukey     // Catch:{ Exception -> 0x0136 }
        L_0x007a:
            r7.add(r6)     // Catch:{ Exception -> 0x0136 }
            goto L_0x0096
        L_0x007f:
            r14 = r18
            r16 = r6
            java.lang.String r6 = r9.ukey     // Catch:{ Exception -> 0x0136 }
            r4.put(r6, r10)     // Catch:{ Exception -> 0x0136 }
            goto L_0x0096
        L_0x0089:
            r0 = move-exception
            r14 = r18
            goto L_0x013f
        L_0x008e:
            r14 = r18
            r11 = r19
            r12 = r20
            r16 = r6
        L_0x0096:
            r6 = r16
            goto L_0x0034
        L_0x0099:
            r14 = r18
            r11 = r19
            r12 = r20
            r16 = r6
            goto L_0x00aa
        L_0x00a2:
            r14 = r18
            r11 = r19
            r12 = r20
            r16 = r6
        L_0x00aa:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0136 }
            r6.<init>()     // Catch:{ Exception -> 0x0136 }
            java.lang.String r8 = "ukey"
            r6.put(r2, r8)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r8 = ","
            java.lang.String r8 = android.text.TextUtils.join(r8, r7)     // Catch:{ Exception -> 0x0136 }
            r6.put(r0, r8)     // Catch:{ Exception -> 0x0136 }
            r3.put(r6)     // Catch:{ Exception -> 0x0136 }
            r8 = 0
            com.baidu.searchbox.introduction.data.SplashPolicyRecorder r9 = com.baidu.searchbox.introduction.data.SplashPolicyRecorder.getInstance()     // Catch:{ Exception -> 0x0136 }
            boolean r9 = r9.isMaterialDownloadReport()     // Catch:{ Exception -> 0x0136 }
            if (r9 == 0) goto L_0x00e2
            com.baidu.searchbox.config.QuickPersistConfig r10 = com.baidu.searchbox.config.QuickPersistConfig.getInstance()     // Catch:{ Exception -> 0x0136 }
            java.lang.String r15 = "SPLASH_DATA_DOWNLOAD_SUCCESS_INFO"
            java.lang.String r10 = r10.getString(r15, r1)     // Catch:{ Exception -> 0x0136 }
            boolean r15 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0136 }
            if (r15 != 0) goto L_0x00e2
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x0136 }
            r15.<init>(r10)     // Catch:{ Exception -> 0x0136 }
            r8 = r15
        L_0x00e2:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0136 }
            r10.<init>()     // Catch:{ Exception -> 0x0136 }
            java.lang.String r15 = "cmd"
            r10.put(r2, r15)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r15 = "query"
            r10.put(r0, r15)     // Catch:{ Exception -> 0x0136 }
            r3.put(r10)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r15 = "boot_type"
            r17 = r6
            java.lang.String r6 = "QUERY_BOOT_TYPE"
            r5.put(r15, r6)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r6 = "logid"
            java.lang.String r15 = "QUERY_LOG_ID"
            r5.put(r6, r15)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r6 = "hot_background_time"
            java.lang.String r15 = "QUERY_HOT_BACKGROUND_TIME"
            r5.put(r6, r15)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r6 = "default_tab"
            java.lang.String r15 = "QUERY_DEFAULT_TAB"
            r5.put(r6, r15)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r6 = "invalid_ukey_info"
            r5.put(r6, r4)     // Catch:{ Exception -> 0x0136 }
            if (r9 == 0) goto L_0x0124
            if (r8 == 0) goto L_0x0124
            java.lang.String r6 = "download_info"
            r5.put(r6, r8)     // Catch:{ Exception -> 0x0136 }
        L_0x0124:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0136 }
            r6.<init>()     // Catch:{ Exception -> 0x0136 }
            java.lang.String r15 = "ext_info"
            r6.put(r2, r15)     // Catch:{ Exception -> 0x0136 }
            r6.put(r0, r5)     // Catch:{ Exception -> 0x0136 }
            r3.put(r6)     // Catch:{ Exception -> 0x0136 }
            goto L_0x0146
        L_0x0136:
            r0 = move-exception
            goto L_0x013f
        L_0x0138:
            r0 = move-exception
            r14 = r18
            r11 = r19
            r12 = r20
        L_0x013f:
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x0146
            r0.printStackTrace()
        L_0x0146:
            if (r3 != 0) goto L_0x0149
            return r1
        L_0x0149:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.introduction.afd.SplashAfdManager.getExtra(boolean, long):java.lang.String");
    }

    public void resetQueryState() {
        this.mState = 1;
        this.mUkey = "";
        this.isReportEvery = false;
        this.mBootEndTime = 0;
        this.mGetUrlTime = 0;
        this.mRequestStartTime = 0;
        this.mLogId = "";
        this.mSendQuery = false;
        this.mFromQuery = 0;
        this.mQueryMergeData = null;
        this.isResponseEmptyUkey = false;
        this.isRequestEmptyUkey = false;
        ArrayList<String> arrayList = this.mPreLinkUrlList;
        if (arrayList != null) {
            arrayList.clear();
        }
        resetRtShakeParams();
        if (DEBUG) {
            Log.d(TAG, "resetQueryState");
        }
    }

    public void saveQueryConfig(JSONObject conf) {
        saveQuerySwitch(conf);
        saveHotBootTimeOut(conf);
        saveQueryLogSwitch(conf);
        saveHotBackgroundTime(conf);
        savePreHotBackgroundTime(conf);
        saveQueryColdDelayTime(conf);
        saveQueryWarmDelayTime(conf);
        saveQueryPreConfig(conf);
    }

    public void saveQueryPreConfig(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig.getInstance().putString(KEY_PRE_QUERY_SWITCH_OPT, conf.optString(PRE_QUERY_SWITCH_OPT, "0"));
            QuickPersistConfig.getInstance().putString(KEY_PRE_QUERY_HOT_TIMEOUT, conf.optString(PRE_QUERY_HOT_TIMEOUT, "0"));
            QuickPersistConfig.getInstance().putString(KEY_PRE_QUERY_DELAY_COLD_TIME, conf.optString(PRE_QUERY_DELAY_COLD_TIME, "0"));
            QuickPersistConfig.getInstance().putString(KEY_PRE_QUERY_DELAY_WARM_TIME, conf.optString(PRE_QUERY_DELAY_WARM_TIME, "0"));
        }
    }

    private float getQueryOpt(String preKey, String key, boolean needConvert) {
        String[] keys = QuickPersistConfig.getInstance().getString(preKey, "0").split("_");
        if (keys == null || keys.length != 3) {
            return (float) QuickPersistConfig.getInstance().getInt(key, 0);
        }
        String querySwitch = keys[0];
        String startTime = keys[1];
        String endTime = keys[2];
        try {
            if (System.currentTimeMillis() / 1000 < Long.parseLong(startTime) || System.currentTimeMillis() / 1000 > Long.parseLong(endTime)) {
                return (float) QuickPersistConfig.getInstance().getInt(key, 0);
            }
            if (needConvert) {
                return Float.parseFloat(querySwitch) * 1000.0f;
            }
            return Float.parseFloat(querySwitch);
        } catch (NumberFormatException e2) {
            return (float) QuickPersistConfig.getInstance().getInt(key, 0);
        }
    }

    public void saveQuerySwitch(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig.getInstance().putInt(KEY_QUERY_SWITCH_OPT_NEW, conf.optInt(QUERY_SWITCH_OPT, 0));
        }
    }

    public void saveHotBootTimeOut(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig.getInstance().putInt(KEY_QUERY_HOT_TIMEOUT_NEW, (int) (conf.optDouble(QUERY_HOT_TIMEOUT) * 1000.0d));
        }
    }

    public void saveQueryLogSwitch(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig instance = QuickPersistConfig.getInstance();
            boolean z = false;
            if (conf.optInt(QUERY_LOG_OPT, 0) == 1) {
                z = true;
            }
            instance.putBoolean(KEY_QUERY_LOG_OPT, z);
        }
    }

    public void saveHotBackgroundTime(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig.getInstance().putFloat(KEY_HOT_BG_TIME, (float) conf.optDouble("hot_background_time", 0.0d));
        }
    }

    public void savePreHotBackgroundTime(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig.getInstance().putString(KEY_PRE_HOT_BG_TIME, conf.optString(PRE_HOT_BG_TIME, ""));
        }
    }

    public void saveQueryColdDelayTime(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig.getInstance().putInt(KEY_QUERY_DELAY_COLD_TIME, conf.optInt(QUERY_DELAY_COLD_TIME, 0));
        }
    }

    public void saveQueryWarmDelayTime(JSONObject conf) {
        if (conf != null) {
            QuickPersistConfig.getInstance().putInt(KEY_QUERY_DELAY_WARM_TIME, conf.optInt(QUERY_DELAY_WARM_TIME, 0));
        }
    }

    private int getQuerySwitch() {
        int querySwitchOpt = (int) getQueryOpt(KEY_PRE_QUERY_SWITCH_OPT, KEY_QUERY_SWITCH_OPT_NEW, false);
        if (DEBUG) {
            Log.d(TAG, "query_switch_opt:" + querySwitchOpt);
        }
        return querySwitchOpt;
    }

    public int getHotBootTimeOut() {
        int hotBootTimeOut = (int) getQueryOpt(KEY_PRE_QUERY_HOT_TIMEOUT, KEY_QUERY_HOT_TIMEOUT_NEW, true);
        if (DEBUG) {
            Log.d(TAG, "query_hot_time_out:" + hotBootTimeOut);
        }
        return hotBootTimeOut;
    }

    private boolean isQueryLogEnable() {
        return QuickPersistConfig.getInstance().getBoolean(KEY_QUERY_LOG_OPT, false);
    }

    public float getHotBackgroundTime() {
        Float preHotBackgroundTime = getPreHotBackgroundTime();
        if (preHotBackgroundTime != null) {
            return preHotBackgroundTime.floatValue();
        }
        return QuickPersistConfig.getInstance().getFloat(KEY_HOT_BG_TIME, 0.0f);
    }

    public Float getPreHotBackgroundTime() {
        String preHotBackgroundTime = QuickPersistConfig.getInstance().getString(KEY_PRE_HOT_BG_TIME, "");
        if (TextUtils.isEmpty(preHotBackgroundTime)) {
            return null;
        }
        String preValue = SplashUtils.getPreConfigWithArrayString(preHotBackgroundTime);
        if (TextUtils.isEmpty(preValue)) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(preValue));
        } catch (NumberFormatException e2) {
            return null;
        }
    }

    public int getQueryDelayTime(boolean isWarmBoot) {
        if (isWarmBoot) {
            return getQueryWarmDelayTime();
        }
        return getQueryColdDelayTime();
    }

    private int getQueryColdDelayTime() {
        int queryColdDelayTime = (int) getQueryOpt(KEY_PRE_QUERY_DELAY_COLD_TIME, KEY_QUERY_DELAY_COLD_TIME, false);
        if (queryColdDelayTime > 1000) {
            queryColdDelayTime = 1000;
        }
        if (DEBUG) {
            Log.d(TAG, "query_delay_cold_time:" + queryColdDelayTime);
        }
        return queryColdDelayTime;
    }

    private int getQueryWarmDelayTime() {
        int queryWarmDelayTime = (int) getQueryOpt(KEY_PRE_QUERY_DELAY_WARM_TIME, KEY_QUERY_DELAY_WARM_TIME, false);
        if (queryWarmDelayTime > 1000) {
            queryWarmDelayTime = 1000;
        }
        if (DEBUG) {
            Log.d(TAG, "query_delay_warm_time:" + queryWarmDelayTime);
        }
        return queryWarmDelayTime;
    }

    public int getQueryState() {
        return this.mState;
    }

    public String getQueryLogId() {
        return TextUtils.isEmpty(this.mLogId) ? "" : this.mLogId;
    }

    public String getDpQueryLogId() {
        return TextUtils.isEmpty(this.mDpLogId) ? "" : this.mDpLogId;
    }

    public void resetDpQueryLogId() {
        this.mDpLogId = "";
    }

    public boolean shouldWait() {
        return this.mState == 4 || (this.mState == 2 && SplashRtLoadManager.getInstance().shouldWaitSyncLoad());
    }

    public void waitForQueryComplete(long timeout) {
        if (timeout > 0 && shouldWait()) {
            synchronized (this.mQueryMonitor) {
                if (shouldWait()) {
                    try {
                        this.mQueryMonitor.wait(timeout);
                    } catch (InterruptedException e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void notifyQueryMonitor() {
        synchronized (this.mQueryMonitor) {
            this.mQueryMonitor.notifyAll();
        }
        if (HotSplashManager.getInstance().isHotBoot() && SplashPolicyRecorder.getInstance().isQueryHotOptimize()) {
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Activity activity = HotSplashManager.getInstance().getShowAbleActivity();
                    if (activity != null) {
                        if (SplashAfdManager.DEBUG) {
                            Log.d("HotOptimize", "query end tryShow");
                        }
                        HotSplashManager.getInstance().tryShow(activity);
                    }
                }
            });
        }
    }

    public void setBootEndTime(long endTime) {
        this.mBootEndTime = endTime;
    }

    public void setQueryStatus(int queryStatus) {
        this.mQueryStatus = queryStatus;
    }

    public boolean isQuerySwitchOn() {
        int querySwitch = getQuerySwitch();
        return querySwitch == 1 || querySwitch == 2;
    }

    public boolean isQueryEnable() {
        return AdRuntimeHolder.getAppRuntime().hasConfirmDialog() && isQuerySwitchOn() && SplashDataManager.getInstance().checkSplashChance() == 0;
    }

    public void tryPostEveryLog() {
        if ((DEBUG || isQueryLogEnable()) && !this.isReportEvery && this.mBootEndTime != 0) {
            this.isReportEvery = true;
            ExecutorUtilsExt.delayPostOnSerial(new Runnable() {
                public void run() {
                    String str;
                    String str2;
                    String str3;
                    String str4 = "1";
                    SplashAfdManager splashAfdManager = SplashAfdManager.this;
                    long unused = splashAfdManager.mColdBootTime = splashAfdManager.mBootEndTime - LaunchStatsUtils.getAppCreateTime();
                    long responseTime = SplashAfdManager.this.mQueryEndTime - SplashAfdManager.this.mQueryStartTime;
                    long queryTime = SplashAfdManager.this.mBootEndTime - SplashAfdManager.this.mQueryStartTime;
                    long realRequestTime = SplashAfdManager.this.mQueryEndTime - SplashAfdManager.this.mRequestStartTime;
                    String key = SplashPolicyRecorder.getInstance().getLogInfo();
                    SplashRtLoadManager.getInstance().setRtLoadLogParams();
                    String realLoadLogParams = SplashRtLoadManager.getInstance().getRtLoadLogParams();
                    JSONObject queryExt = new JSONObject();
                    try {
                        if (SplashAfdManager.this.mSendQuery) {
                            str = str4;
                        } else {
                            str = "0";
                        }
                        queryExt.put("is_send_query", str);
                        if (SplashAfdManager.this.isRequestEmptyUkey) {
                            str2 = str4;
                        } else {
                            str2 = "0";
                        }
                        queryExt.put("request_empty_ukey", str2);
                        if (SplashAfdManager.this.isResponseEmptyUkey) {
                            str3 = str4;
                        } else {
                            str3 = "0";
                        }
                        queryExt.put("response_empty_ukey", str3);
                    } catch (JSONException e2) {
                        if (SplashAfdManager.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    PerformanceLogModel.Builder key2 = new PerformanceLogModel.Builder().setBootType(SplashAfdManager.this.mBootType).setLogId(SplashAfdManager.this.mLogId).setPid("1573559779244").setResponseResult(SplashAfdManager.this.mQueryResult).setResponseTime(responseTime).setQueryExt(queryExt.toString()).setQueryTime(queryTime).setColdBootTime(SplashAfdManager.this.mColdBootTime).setQueryStatus(SplashAfdManager.this.mQueryStatus).setExtraTime(SplashAfdManager.this.mGetUrlTime).setRequestTime(realRequestTime).setTotalDelayTime(SplashAfdManager.this.mTotalDelayTime).setKey(key);
                    if (!SplashAfdManager.this.mIsNewBuild) {
                        str4 = "0";
                    }
                    PerformanceLogModel model = key2.setNewBuild(str4).setRtLoadInfo(realLoadLogParams).build();
                    if (HotSplashManager.getInstance().isHotBoot() || SplashAfdManager.this.isAlsModelValid(model)) {
                        AfdQueryAlsLogger.sendPerformanceLog(model);
                    }
                }
            }, ELOG_TASK_NAME, 3000);
        }
    }

    public SplashData getQuerySplashData() {
        return getQuerySplashData(0);
    }

    public SplashData getQuerySplashData(int delayTime) {
        setBootEndTime(System.currentTimeMillis());
        SplashRtLoadManager.getInstance().handleRtLoad();
        if (DEBUG) {
            Log.i(TAG, "实时问询耗时: " + delayTime);
        }
        setQueryParamsWhenShow();
        if (this.mState == 2) {
            return handleQueryMergeResultSuccess(delayTime);
        }
        return handleQueryMergeResultFail(delayTime);
    }

    private SplashData handleQueryMergeResultSuccess(int delayTime) {
        SplashData splashData = null;
        if (!HotSplashManager.getInstance().isHotBoot() || !HotSplashManager.getInstance().isSchemeOrPushInvoke()) {
            this.mQueryStatus = 1;
        } else {
            this.mQueryStatus = 3;
        }
        this.mTotalDelayTime = delayTime;
        tryPostEveryLog();
        JSONObject queryMergeData = this.mQueryMergeData;
        if (queryMergeData == null) {
            return null;
        }
        if (queryMergeData.has("mt")) {
            if (SplashRtLoadManager.getInstance().isRtLoadReady() && SplashRtLoadManager.getInstance().getRtLoadSplashData() != null) {
                this.mFromQuery = 3;
                splashData = SplashRtLoadManager.getInstance().getRtLoadSplashData();
            } else if (queryMergeData.has("ukey")) {
                if (TextUtils.isEmpty(this.mUkey)) {
                    SplashReportUtils.executeSplashWithoutMaterialShowStatistics(9, 1024);
                    return null;
                }
                this.mFromQuery = 1;
                splashData = SplashDataManager.getInstance().getSplashDataByUkey(this.mUkey);
            } else if (getQuerySwitch() == 2) {
                SplashReportUtils.executeSplashWithoutMaterialShowStatistics(9, 2048);
                return null;
            } else {
                this.mFromQuery = 0;
                splashData = SplashDataManager.getInstance().peekASplashDataItem();
            }
        } else if (queryMergeData.has("mt") || !queryMergeData.has("ukey")) {
            if (!queryMergeData.has("mt") && !queryMergeData.has("ukey")) {
                if (getQuerySwitch() == 2) {
                    SplashReportUtils.executeSplashWithoutMaterialShowStatistics(9, 2048);
                    return null;
                }
                this.mFromQuery = 0;
                splashData = SplashDataManager.getInstance().peekASplashDataItem();
            }
        } else if (TextUtils.isEmpty(this.mUkey)) {
            SplashReportUtils.executeSplashWithoutMaterialShowStatistics(9, 1024);
            return null;
        } else {
            this.mFromQuery = 1;
            splashData = SplashDataManager.getInstance().getSplashDataByUkey(this.mUkey);
        }
        if (DEBUG) {
            Log.d(TAG, "show from：" + this.mFromQuery);
        }
        setShowFrom();
        return splashData;
    }

    private SplashData handleQueryMergeResultFail(int delayTime) {
        if (!HotSplashManager.getInstance().isHotBoot() || !HotSplashManager.getInstance().isSchemeOrPushInvoke()) {
            this.mQueryStatus = 0;
        } else {
            this.mQueryStatus = 2;
        }
        this.mTotalDelayTime = delayTime;
        if (getQuerySwitch() == 2) {
            SplashReportUtils.executeSplashWithoutMaterialShowStatistics(9, 2048);
            return null;
        }
        this.mFromQuery = 0;
        SplashData splashData = SplashDataManager.getInstance().peekASplashDataItem();
        if (DEBUG) {
            Log.d(TAG, "show from：" + this.mFromQuery);
        }
        setShowFrom();
        return splashData;
    }

    /* access modifiers changed from: private */
    public boolean isAlsModelValid(PerformanceLogModel model) {
        return model != null && model.queryTime > 0 && model.queryTime <= model.coldBootTime;
    }

    /* access modifiers changed from: private */
    public void preloadSplashDataList() {
        if (SplashPolicyRecorder.getInstance().isParseWithCache()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    SplashDataManager.getInstance().getSplashDataList(SplashType.DataType.SPLASH);
                }
            }, "preload splash data list", 2);
        }
    }

    public void setIsNewBuild(boolean isNewBuild) {
        this.mIsNewBuild = isNewBuild;
    }

    private void setQueryParamsWhenShow() {
        this.mIsSendQuery = this.mSendQuery;
        this.mIsQueryTimeout = this.mState != 2;
        this.mQueryUkey = this.mUkey;
    }

    public boolean getSendQuery() {
        return this.mIsSendQuery;
    }

    public boolean getQueryTimeOut() {
        return this.mIsQueryTimeout;
    }

    public String getQueryUkey() {
        return this.mQueryUkey;
    }

    private void setShowFrom() {
        this.mShowFrom = this.mFromQuery;
    }

    public int getShowFrom() {
        return this.mShowFrom;
    }

    public synchronized void cacheQueryInfo() {
        synchronized (this) {
            long current = System.currentTimeMillis();
            String currentQueryInfo = getExtra(true, current);
            long afterSameSplit = SplashPolicyRecorder.getInstance().getSplashSplitTime(true) + current;
            String sameSplitQueryInfo = getExtra(true, afterSameSplit);
            String diffSplitQueryInfo = getExtra(true, SplashPolicyRecorder.getInstance().getSplashSplitTime(false) + current);
            String tomorrowQueryInfo = getExtra(true, 86400000 + current);
            long j2 = afterSameSplit;
            long afterTomorrow = current + 172800000;
            String afterTomorrowQueryInfo = getExtra(false, afterTomorrow);
            if (DEBUG) {
                long j3 = afterTomorrow;
                Log.d(TAG, "currentQueryInfo:" + currentQueryInfo);
                Log.d(TAG, "sameSplitQueryInfo:" + sameSplitQueryInfo);
                Log.d(TAG, "diffSplitQueryInfo:" + diffSplitQueryInfo);
                Log.d(TAG, "tomorrowQueryInfo:" + tomorrowQueryInfo);
                Log.d(TAG, "afterTomorrowQueryInfo:" + afterTomorrowQueryInfo);
            }
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(KEY_CURRENT_QUERY_INFO, currentQueryInfo);
                jsonObject.put(KEY_SAME_SPLIT_QUERY_INFO, sameSplitQueryInfo);
                jsonObject.put(KEY_DIFF_SPLIT_QUERY_INFO, diffSplitQueryInfo);
                jsonObject.put(KEY_TOMORROW_QUERY_INFO, tomorrowQueryInfo);
                jsonObject.put(KEY_AFTER_TOMORROW_QUERY_INFO, afterTomorrowQueryInfo);
                jsonObject.put(KEY_CACHE_QUERY_INFO_TIME, current);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            QuickPersistConfig.getInstance().putString(KEY_CACHE_QUERY_INFO, jsonObject.toString());
        }
    }

    public String getCacheQueryInfo(String logId, String bootType) {
        String queryInfo;
        String queryInfoJsonObj = QuickPersistConfig.getInstance().getString(KEY_CACHE_QUERY_INFO, "");
        if (TextUtils.isEmpty(queryInfoJsonObj)) {
            return "";
        }
        try {
            JSONObject jsonObject = new JSONObject(queryInfoJsonObj);
            long cacheTime = jsonObject.optLong(KEY_CACHE_QUERY_INFO_TIME);
            long current = System.currentTimeMillis();
            long sameSplit = SplashPolicyRecorder.getInstance().getSplashSplitTime(true);
            long diffSplit = SplashPolicyRecorder.getInstance().getSplashSplitTime(false);
            long cacheSplit = current - cacheTime;
            int afterFewDays = SplashUtils.afterFewDays(cacheTime);
            if (afterFewDays >= 2) {
                queryInfo = jsonObject.optString(KEY_AFTER_TOMORROW_QUERY_INFO);
                if (DEBUG) {
                    Log.d(TAG, "after tomorrow");
                }
            } else if (afterFewDays == 1) {
                queryInfo = jsonObject.optString(KEY_TOMORROW_QUERY_INFO);
                if (DEBUG) {
                    Log.d(TAG, "tomorrow");
                }
            } else if (cacheSplit > sameSplit) {
                queryInfo = jsonObject.optString(KEY_SAME_SPLIT_QUERY_INFO);
                if (DEBUG) {
                    Log.d(TAG, "same");
                }
            } else if (cacheSplit <= diffSplit || cacheSplit > sameSplit) {
                queryInfo = jsonObject.optString(KEY_CURRENT_QUERY_INFO);
                if (DEBUG) {
                    Log.d(TAG, "current");
                }
            } else {
                queryInfo = jsonObject.optString(KEY_DIFF_SPLIT_QUERY_INFO);
                if (DEBUG) {
                    Log.d(TAG, PackageDownloadInfo.TYPE_diff);
                }
            }
        } catch (JSONException e2) {
            queryInfo = "";
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        String defaultTab = "";
        ISettingsFun iSettingsFun = (ISettingsFun) ServiceManager.getService(ISettingsFun.Companion.getSERVICE_REFERENCE());
        if (iSettingsFun != null) {
            defaultTab = iSettingsFun.getColdLaunchDefaultTab();
            if (TextUtils.isEmpty(defaultTab)) {
                defaultTab = "";
            }
        }
        if (!TextUtils.isEmpty(queryInfo)) {
            return queryInfo.replace(QUERY_BOOT_TYPE, bootType).replace(QUERY_LOG_ID, logId).replace(QUERY_HOT_BACKGROUND_TIME, SplashUtils.getBackgroundDuration()).replace(QUERY_DEFAULT_TAB, defaultTab);
        }
        String str = logId;
        String str2 = bootType;
        return queryInfo;
    }

    private void tryDspPreLink() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                try {
                    JSONArray jsonArray = SplashAfdManager.this.getPreLinkUrl(DateTimeUtils.getFormatDateTime(DateTimeUtils.getCurrDate(), "yyyyMMdd"));
                    if (jsonArray == null) {
                        return;
                    }
                    if (jsonArray.length() > 0) {
                        for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                            SplashAfdManager.this.tryDspPreLink(jsonArray.optString(i2));
                        }
                    }
                } catch (Exception e2) {
                    if (SplashAfdManager.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }, "dsp_prelink", 2);
    }

    /* access modifiers changed from: private */
    public void tryDspPreLink(String preLinkUrl) {
        long preLinkStart = System.currentTimeMillis();
        if (!TextUtils.isEmpty(preLinkUrl)) {
            HttpURLConnection conn = null;
            try {
                URL url = new URL(preLinkUrl);
                HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
                conn2.setRequestMethod("HEAD");
                conn2.connect();
                if (conn2.getResponseCode() == 200) {
                    this.mPreLinkUrlList.add(url.getHost());
                }
                long preLinkEnd = System.currentTimeMillis();
                if (DEBUG) {
                    Log.d(TAG, "preLink cost: " + (preLinkEnd - preLinkStart) + "ms");
                }
            } catch (Exception e2) {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }
    }

    public ArrayList<String> getPreLinkSuccessUrlList() {
        return this.mPreLinkUrlList;
    }

    /* access modifiers changed from: private */
    public JSONArray getPreLinkUrl(String date) {
        JSONObject preLinkUrlInfo = SplashPolicyRecorder.getInstance().getPreLinkUrlInfo();
        if (DEBUG) {
            Log.d(TAG, "preLinkUrlInfo:" + preLinkUrlInfo);
        }
        if (preLinkUrlInfo == null) {
            return null;
        }
        return preLinkUrlInfo.optJSONArray(date);
    }

    public ArrayList<String> getPreLinkUrlList() {
        JSONArray jsonArray = getPreLinkUrl(DateTimeUtils.getFormatDateTime(DateTimeUtils.getCurrDate(), "yyyyMMdd"));
        if (jsonArray == null || jsonArray.length() <= 0) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i2 = 0; i2 < jsonArray.length(); i2++) {
            try {
                list.add(new URL(jsonArray.optString(i2)).getHost());
            } catch (MalformedURLException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return list;
    }

    public void checkEmptyUkey(String queryInfo) {
        if (TextUtils.isEmpty(queryInfo)) {
            this.isRequestEmptyUkey = true;
            return;
        }
        try {
            JSONArray queryInfoJsonArray = new JSONArray(queryInfo);
            if (queryInfoJsonArray.length() <= 0) {
                this.isRequestEmptyUkey = true;
                return;
            }
            JSONObject ukey = queryInfoJsonArray.optJSONObject(0);
            if (ukey == null) {
                this.isRequestEmptyUkey = true;
            } else {
                this.isRequestEmptyUkey = TextUtils.isEmpty(ukey.optString("v"));
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public boolean isRequestEmptyUkey() {
        return this.isRequestEmptyUkey;
    }

    private boolean checkSplashDataUseBackupSourceUrl(SplashData splashDataItem) {
        File backupSourceUrlFile;
        if (!SplashPolicyRecorder.getInstance().isUseBackupSourceUrl() || splashDataItem == null) {
            return false;
        }
        if (SplashPolicyRecorder.getInstance().isDownloadPreLoad() && (splashDataItem.isTopview() || splashDataItem.isFlowVideoTopView())) {
            return false;
        }
        File file = SplashDataManager.getInstance().getSplashSourceFile(splashDataItem.sourceUrl);
        if ((file == null || !file.exists()) && (backupSourceUrlFile = SplashDataManager.getInstance().getBackupSourceUrlFile(splashDataItem)) != null && backupSourceUrlFile.exists()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void parseRtShakeParams(JSONObject data) {
        this.mRtSensitivity = data.optDouble("gesture_lottie_sensitivity", 0.0d);
        this.mRtHotSensitivity = data.optDouble("hot_shake_sensitivity", 0.0d);
        this.mRtShakeInterval = data.optInt(FeedAdGestureLottieModel.SHAKE_UPDATE_INTERVAL, 0);
        this.mRtShakeDirectionCount = data.optInt(FeedAdGestureLottieModel.SHAKE_DIRECTION_COUNT, 0);
        this.mRtShakeActionDelayTime = data.optDouble("shake_action_delay_time", 0.0d);
        if (DEBUG) {
            Log.d("SplashShake", "gesture_lottie_sensitivity:" + this.mRtSensitivity + " ,hot_shake_sensitivity:" + this.mRtHotSensitivity + " ,shake_update_interval:" + this.mRtShakeInterval + " ,shake_direction_count:" + this.mRtShakeDirectionCount + " ,shake_action_delay_time:" + this.mRtShakeActionDelayTime);
        }
    }

    private void resetRtShakeParams() {
        this.mRtSensitivity = 0.0d;
        this.mRtHotSensitivity = 0.0d;
        this.mRtShakeInterval = 0;
        this.mRtShakeDirectionCount = 0;
        this.mRtShakeActionDelayTime = 0.0d;
    }

    private boolean isRtShakeParamsValid() {
        return (this.mRtSensitivity > 0.0d || this.mRtHotSensitivity > 0.0d) && this.mRtShakeInterval > 0 && this.mRtShakeDirectionCount > 0;
    }

    public double getRtSensitivity() {
        if (isRtShakeParamsValid()) {
            return this.mRtSensitivity;
        }
        return 0.0d;
    }

    public double getRtHotSensitivity() {
        if (isRtShakeParamsValid()) {
            return this.mRtHotSensitivity;
        }
        return 0.0d;
    }

    public int getRtShakeInterval() {
        if (isRtShakeParamsValid()) {
            return this.mRtShakeInterval;
        }
        return 0;
    }

    public int getRtShakeDirectionCount() {
        if (isRtShakeParamsValid()) {
            return this.mRtShakeDirectionCount;
        }
        return 0;
    }

    public double getRtShakeActionDelayTime() {
        return this.mRtShakeActionDelayTime;
    }
}
