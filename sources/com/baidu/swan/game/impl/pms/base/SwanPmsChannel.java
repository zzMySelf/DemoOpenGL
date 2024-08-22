package com.baidu.swan.game.impl.pms.base;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.DefaultPackageCallback;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SwanPmsChannel extends RequestParams.Channel {
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String PMS_CHANNEL_RUN_TYPE_PREFIX = "aps_";
    private static final String TAG = "SwanPmsChannel";
    /* access modifiers changed from: private */
    public String mChannelId;
    /* access modifiers changed from: private */
    public List<? extends SwanBasePackage> mPmsPackages;

    public SwanPmsChannel(SwanBasePackage pkg) {
        this(pkg.getChannelId(), Collections.singletonList(pkg));
    }

    public SwanPmsChannel(String channelId, List<? extends SwanBasePackage> pkgs) {
        super(channelId, getPmsPackageNameList(pkgs), (PackageCallback) null);
        this.mChannelId = channelId;
        this.mPmsPackages = pkgs;
        setCallback(new SwanPmsPackageCallback());
        if (DEBUG) {
            Log.d(TAG, "Constructor init: " + this.mChannelId);
        }
    }

    /* access modifiers changed from: private */
    public void deletePackageInfoIfNeeded(String logFrom) {
        for (SwanBasePackage pkg : this.mPmsPackages) {
            boolean isNeeRetry = pkg.isNeedToRetryInNextTime();
            if (DEBUG) {
                Log.d(TAG, String.format("deletePackageInfo: %b, %s: %s", new Object[]{Boolean.valueOf(isNeeRetry), pkg.getPackageName(), logFrom}));
            }
            if (isNeeRetry) {
                PmsManager.getInstance().deletePackageInfo(this.mChannelId, pkg.getPackageName());
            }
        }
    }

    private class SwanPmsPackageCallback extends DefaultPackageCallback {
        private SwanPmsPackageCallback() {
        }

        public void onResultData(ResultData resultData) {
            if (resultData == null) {
                SwanPmsChannel.this.deletePackageInfoIfNeeded("onResultData: null");
                return;
            }
            List<PackageInfo> mergeList = new ArrayList<>();
            if (!SwanPmsChannel.this.isEmpty(resultData.addList)) {
                mergeList.addAll(resultData.addList);
            }
            if (!SwanPmsChannel.this.isEmpty(resultData.updateList)) {
                mergeList.addAll(resultData.updateList);
            }
            List<PackageInfo> filterList = resultData.filterList != null ? resultData.filterList : new ArrayList<>();
            if (SwanPmsChannel.DEBUG) {
                Log.i(SwanPmsChannel.TAG, "onResultData: " + SwanPmsChannel.this.mChannelId + ",new: " + mergeList.size() + ",filter: " + filterList.size());
            }
            for (SwanBasePackage pkg : SwanPmsChannel.this.mPmsPackages) {
                pkg.onFetchSuccess(mergeList, filterList);
            }
        }

        public void onFetchError(ErrorInfo errorInfo) {
            SwanPmsChannel.this.deletePackageInfoIfNeeded("onFetchError: " + errorInfo);
        }
    }

    /* access modifiers changed from: private */
    public boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    private static List<String> getPmsPackageNameList(List<? extends SwanBasePackage> pkgs) {
        List<String> list = new ArrayList<>();
        for (SwanBasePackage pkg : pkgs) {
            list.add(pkg.getPackageName());
        }
        return list;
    }

    public static void executePmsPackageRequest(SwanBasePackage pkg) {
        PmsManager.getInstance().execute(new RequestParams().setRunType("aps_" + pkg.getChannelId()).addChannel(new SwanPmsChannel(pkg)));
    }
}
