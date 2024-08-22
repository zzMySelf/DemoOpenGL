package com.baidu.swan.apps.core.pms;

import com.baidu.swan.apps.trace.ErrCode;
import com.baidu.swan.pms.model.PMSError;
import com.baidu.swan.pms.model.PMSPackage;
import com.baidu.swan.pms.model.PMSPkgSub;
import com.baidu.swan.pms.model.PMSPlugin;
import com.baidu.swan.pms.network.response.PMSGetPkgListResponse;

public abstract class BatchDownloadCallback {
    private static final String TAG = "BatchDownloadCallback";

    public void onFetchError(int errCode) {
        logInfo("#onFetchError errCode=" + errCode);
    }

    public void onTotalPkgDownloadFinish() {
        logInfo("#onTotalPkgDownloadFinish");
    }

    public void onNoPackage() {
        logWarn("#onNoPackage", (Throwable) null);
    }

    public void onSingleFetchError(PMSError error) {
        if (error != null && error.errorNo != 1010) {
            logError("#onSingleFetchError error=" + error, new Exception("stack"));
        }
    }

    public void onMainPkgSuccess(PMSGetPkgListResponse.Item item) {
    }

    public void onSubPkgSuccess(PMSPkgSub pmsPkgSub) {
        logInfo("#onSubPkgSuccess subPkg=" + pmsPkgSub);
    }

    public void onPluginPkgSuccess(PMSPlugin plugin) {
        logInfo("#onPluginPkgSuccess plugin=" + plugin);
    }

    public void onAllPkgSuccess() {
        logInfo("#onAllPkgSuccess");
    }

    public void onSinglePkgFail(PMSPackage pkg, ErrCode errCode) {
        logInfo("#onSinglePkgFail, pkg=" + pkg + ", error=" + errCode);
    }

    /* access modifiers changed from: protected */
    public void logInfo(String msg) {
        SwanPMSLogger.logInfo(getLogTag(), msg);
    }

    public void logWarn(String msg, Throwable t) {
        SwanPMSLogger.logWarn(getLogTag(), msg, t);
    }

    /* access modifiers changed from: protected */
    public void logError(String msg, Throwable t) {
        SwanPMSLogger.logError(getLogTag(), msg, t);
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return TAG;
    }
}
