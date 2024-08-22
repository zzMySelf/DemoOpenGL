package com.baidu.searchbox.util.upgrade;

import android.content.Context;
import android.os.Build;
import android.preference.PreferenceManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.search.fastsearch.utils.FastSearchABTestUtils;
import com.baidu.searchbox.SearchBox;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.database.SearchCategoryControl;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.widget.FeedBubbleManager;
import com.baidu.searchbox.introduction.SplashAdFacade;
import com.baidu.searchbox.plugins.kernels.webview.WebkitKernelPlugin;
import com.baidu.searchbox.push.PushUtil;
import com.baidu.searchbox.speed.box.speedtask.LaunchTaskExecutor;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.swan.api.SwanAppApi;
import java.io.File;
import org.json.JSONArray;

public class SearchboxUpgradeManager extends UpgradeManager {
    public static final String ACTION_USRC_UPDATE_SUC = "action_usrc_update_suc";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = (SearchBox.GLOBAL_DEBUG & true);
    public static final int DEFAULT_SERVICE_URLS_DATA_VERSION = 2;
    public static final String DEFAULT_SERVICE_URLS_VERSION = (Build.VERSION.SDK_INT + "_" + 2);
    public static final String NEW_HEADER_BACKGROUND_NOTIFITION = "new_header_background_notify";
    public static final String SERVICE_URLS_VERSION = "service_urls_version";
    private static final String TAG = "SearchboxUpgradeManager";
    /* access modifiers changed from: private */
    public Context mContext = null;

    public SearchboxUpgradeManager(Context ctx) {
        super(ctx);
        this.mContext = ctx;
    }

    public void onUpgrade(int newVersionCode, int oldVersionCode) {
        if (DEBUG) {
            Log.d(TAG, "process onUpgrade");
        }
        if (!SearchBox.GLOBAL_DEBUG) {
            AppConfig.sNeedSkipAndRemoveExternalConfig = true;
        }
        SplashAdFacade.onAppUpgrade(oldVersionCode, newVersionCode);
        asyncInitBaiduIdentity();
        delOldServiceDataIfNeed();
        delOldSharedPreferencesIfNeed();
        LaunchTaskExecutor.execute(new Runnable() {
            public void run() {
                WebkitKernelPlugin plugin = WebkitKernelPlugin.getInstance(SearchboxUpgradeManager.this.mContext);
                DownloadManagerExt manager = plugin.getDownloadManager();
                DownloadBean bean = manager.queryDownloadData(plugin.getUri());
                if (bean == null) {
                    return;
                }
                if (DownloadState.DOWNLOADING == bean.getDownloadState() || DownloadState.DOWNLOAD_PAUSED == bean.getDownloadState()) {
                    manager.cancelDownload(plugin.getUri());
                    QuickPersistConfig.getInstance().putBoolean(QuickPersistConfigConst.KEY_KERNEL_WEBKIT_STATE, false);
                    plugin.setVersion("0");
                }
            }
        }, "remove kernel download record.");
        PreferenceUtils.setBoolean(ACTION_USRC_UPDATE_SUC, false);
        resetBubbleShownState();
        SwanAppApi.getFrameworkRuntime().performHostUpgrade(oldVersionCode, newVersionCode);
        FastSearchABTestUtils.setUpgradeFirstStart(true);
    }

    private void resetBubbleShownState() {
        FeedBubbleManager.setHasShownBubble(false);
    }

    private void delOldServiceDataIfNeed() {
        String str = DEFAULT_SERVICE_URLS_VERSION;
        String[] data = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString(SERVICE_URLS_VERSION, "0").split("_");
        if (data.length == 2) {
            int osVersion = Integer.parseInt(data[0]);
            int dataVersion = Integer.parseInt(data[1]);
            if (osVersion < Build.VERSION.SDK_INT || (osVersion == Build.VERSION.SDK_INT && dataVersion <= 2)) {
                SearchCategoryControl.getInstance(this.mContext).updateSearchableTypes((JSONArray) null);
            }
        }
    }

    private void delOldSharedPreferencesIfNeed() {
        if (BuildConfigManager.getBoolean("NBSwitcher", "SWITCH_HEADER_NEW")) {
            PreferenceUtils.removeKey(NEW_HEADER_BACKGROUND_NOTIFITION);
        }
        this.mContext.getSharedPreferences(PushUtil.PUSHSERVICE_SETTINGS_PREFERENCE, 0).edit().remove(PushUtil.PUSH_BIND_DATE).commit();
        QuickPersistConfig.getInstance().remove(QuickPersistConfigConst.KEY_WEBKIT_DO_BUILDIN_INSTALL);
    }

    public void onDowngrade(int newVersionCode, int oldVersionCode) {
        if (DEBUG) {
            Log.d(TAG, "process onDowngrade newVersionCode=" + newVersionCode + " /oldVersionCode=" + oldVersionCode);
        }
        asyncInitBaiduIdentity();
        clearAllData(this.mContext);
    }

    public void onNothingChanged() {
    }

    private void clearAllData(Context ctx) {
        String filename = ctx.getApplicationInfo().dataDir;
        if (DEBUG) {
            Log.d(TAG, "clearAllData():" + filename);
        }
        FileUtils.deleteFile(new File(filename));
    }

    public void onNewInstalled(int newVersionCode) {
        if (!SearchBox.GLOBAL_DEBUG) {
            AppConfig.sNeedSkipAndRemoveExternalConfig = true;
        }
        asyncInitBaiduIdentity();
        QuickPersistConfig.getInstance().putBoolean(QuickPersistConfigConst.OLD_VIDEO_HISTORY_EXECUTE, true);
        QuickPersistConfig.getInstance().putLong(QuickPersistConfigConst.KEY_NEW_USER_INSTALL_TIME, System.currentTimeMillis());
        SwanAppApi.getFrameworkRuntime().performHostUpgrade(0, newVersionCode);
    }

    private void asyncInitBaiduIdentity() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                BaiduIdentityManager.getInstance(SearchboxUpgradeManager.this.mContext).checkTnTrace();
                if (SearchboxUpgradeManager.DEBUG) {
                    Log.d(SearchboxUpgradeManager.TAG, "async init baidu identity in thread: " + Thread.currentThread().getId());
                }
            }
        }, "initBaiduIdentity", 3);
    }
}
