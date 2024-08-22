package com.baidu.searchbox.gamecore.base.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.base.utils.NetWorkUtils;
import com.baidu.searchbox.gamecore.list.model.GameAppItemData;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.aps.preload.SwanAppPreDownload;
import com.baidu.swan.pms.PMS;
import com.baidu.swan.pms.database.PMSDB;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSError;
import com.baidu.swan.pms.network.reuqest.PMSGetPkgRequest;
import java.util.ArrayList;
import java.util.List;

public class GamePrefetchManager {
    public static final int PREFETCH_MAX_COUNT = 15;
    private static final String TAG = "GamePrefetchManager";
    public static final int VERSION_COMPARE_ERROR = -1;
    private List<GamePrefetchData> mPrefetchDataList;
    public List<GamePrefetchData> mPrefetchSuccessDataList;
    /* access modifiers changed from: private */
    public GamePrefetchData mPrefetchSuccessItem;

    public interface NetConfig {
        public static final String PREDOWNLOAD_NET_ALL = "1";
        public static final String PREDOWNLOAD_NET_WIFI_ONLY = "0";
    }

    private GamePrefetchManager() {
        this.mPrefetchDataList = new ArrayList(15);
        this.mPrefetchSuccessDataList = new ArrayList(15);
    }

    private static class SingletonInstance {
        /* access modifiers changed from: private */
        public static final GamePrefetchManager INSTANCE = new GamePrefetchManager();

        private SingletonInstance() {
        }
    }

    public static GamePrefetchManager getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private class NAGameCenterPreFetchCallback extends SwanGamesPkgPreDownloadCallback {
        public NAGameCenterPreFetchCallback(String appId, SwanAppPreDownload.DownloadCallback callback) {
            super(appId, callback);
        }

        public void onFetchError(PMSError error) {
            super.onFetchError(error);
            GamePrefetchManager.this.prefetchNext();
        }

        public void onTotalPkgDownloadFinish() {
            super.onTotalPkgDownloadFinish();
            if (GamePrefetchManager.this.mPrefetchSuccessItem != null) {
                if (SwanAppLibConfig.DEBUG) {
                    Log.e(GamePrefetchManager.TAG, "预下载成功 item 的appId " + GamePrefetchManager.this.mPrefetchSuccessItem.appID);
                }
                GamePrefetchManager.this.mPrefetchSuccessDataList.add(GamePrefetchManager.this.mPrefetchSuccessItem);
            }
            GamePrefetchManager.this.prefetchNext();
        }
    }

    public void updatePrefetchList(List<GamePrefetchData> prefetchList) {
        this.mPrefetchDataList.clear();
        this.mPrefetchDataList.addAll(prefetchList);
    }

    public synchronized void preFetch() {
        List<GamePrefetchData> list = this.mPrefetchDataList;
        if (list != null && list.size() > 0) {
            prefetchGamePkg(this.mPrefetchDataList.get(0));
        }
    }

    /* access modifiers changed from: private */
    public void prefetchNext() {
        List<GamePrefetchData> list = this.mPrefetchDataList;
        if (list != null && list.size() > 0) {
            this.mPrefetchDataList.remove(0);
        }
        preFetch();
    }

    public synchronized void cancelPrefetch() {
        this.mPrefetchDataList.clear();
    }

    public synchronized void resetPrefetchSuccessList() {
        this.mPrefetchSuccessDataList.clear();
    }

    private void prefetchGamePkg(GamePrefetchData prefetchData) {
        if (prefetchData == null) {
            prefetchNext();
        } else if (!isCurrentNetOK(String.valueOf(prefetchData.netConf))) {
            prefetchNext();
        } else {
            PMSAppInfo pmsAppInfo = PMSDB.getInstance().querySwanApp(prefetchData.appID);
            if (TextUtils.isEmpty(prefetchData.appVersion) || pmsAppInfo == null || TextUtils.isEmpty(pmsAppInfo.versionName) || isLowerVersion(pmsAppInfo.versionName, prefetchData.appVersion)) {
                PMSGetPkgRequest request = new PMSGetPkgRequest(prefetchData.appID, prefetchData.category);
                request.setFrom("1");
                this.mPrefetchSuccessItem = prefetchData;
                request.setScene("11");
                PMS.getAppPackage(request, new NAGameCenterPreFetchCallback(prefetchData.appID, (SwanAppPreDownload.DownloadCallback) null));
                return;
            }
            prefetchNext();
        }
    }

    public static boolean isCurrentNetOK(String netConfig) {
        if (TextUtils.equals(netConfig, "0")) {
            if (NetWorkUtils.isWifiNetworkConnected()) {
                return true;
            }
            return false;
        } else if (TextUtils.equals(netConfig, "1")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLowerVersion(String curVersion, String targetVersion) {
        try {
            return compareVersion(curVersion, targetVersion) > 0;
        } catch (IllegalArgumentException e2) {
            return false;
        }
    }

    private long compareVersion(String curVersion, String targetVersion) throws IllegalArgumentException {
        if (TextUtils.isEmpty(curVersion) || TextUtils.isEmpty(targetVersion) || !TextUtils.isDigitsOnly(curVersion) || !TextUtils.isDigitsOnly(targetVersion)) {
            return -1;
        }
        return Long.parseLong(curVersion) - Long.parseLong(targetVersion);
    }

    public void addToPrefetchQueue(GameAppItemData appItemData, List<GamePrefetchData> prefetchDataList) {
        if (appItemData.prefetchData != null) {
            appItemData.prefetchData.appID = appItemData.resourceKey;
            List<GamePrefetchData> prefetchSuccessDataList = getInstance().mPrefetchSuccessDataList;
            if (!isContains(prefetchDataList, appItemData.prefetchData) && !isContains(prefetchSuccessDataList, appItemData.prefetchData) && prefetchSuccessDataList.size() <= 15) {
                if (SwanAppLibConfig.DEBUG) {
                    Log.e(TAG, "进入预下载队列的item appId " + appItemData.prefetchData.appID);
                }
                prefetchDataList.add(appItemData.prefetchData);
            }
        }
    }

    private boolean isContains(List<GamePrefetchData> prefetchDataList, GamePrefetchData prefetchData) {
        if (prefetchDataList == null || prefetchDataList.size() <= 0 || prefetchData == null) {
            return false;
        }
        for (GamePrefetchData data : prefetchDataList) {
            if (TextUtils.equals(prefetchData.appID, data.appID)) {
                return true;
            }
        }
        return false;
    }
}
