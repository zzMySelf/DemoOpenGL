package com.baidu.swan.gamecenter.appmanager.install;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.gamecenter.appmanager.GameCenterAppManager;
import com.baidu.swan.gamecenter.appmanager.action.GameCenterAppManagerAction;
import com.baidu.swan.gamecenter.appmanager.download.AppConstants;
import com.baidu.swan.gamecenter.appmanager.listener.InstallListener;
import com.baidu.swan.gamecenter.appmanager.model.OperateResult;
import com.baidu.swan.gamecenter.appmanager.statistics.CommonStatsParams;
import com.baidu.swan.gamecenter.appmanager.statistics.GameCenterStatistic;
import com.baidu.swan.games.ioc.SwanGameRuntime;
import org.json.JSONObject;

public class InstallAppDelegation extends ActivityDelegation {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "InstallAppDelegation";
    private String mPackageName;
    private InstallResultListener mResultListener = new InstallResultListener();
    private JSONObject mUbcParams;

    /* access modifiers changed from: protected */
    public boolean onExec() {
        if (DEBUG) {
            Log.d(TAG, "onExec mParams" + this.mParams);
        }
        this.mUbcParams = SwanAppJSONUtils.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject paramsJson = SwanAppJSONUtils.parseString(this.mParams.getString("data", ""));
        this.mPackageName = paramsJson.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        GameCenterAppManagerAction.sExecutorService.execute(new ExecuteInstallRunnable(paramsJson, this.mUbcParams, this.mResultListener, (Activity) getAgent()));
        return false;
    }

    /* access modifiers changed from: private */
    public static void handleInstallApp(Activity activity, JSONObject paramsJson, InstallListener listener) {
        String url = paramsJson.optString("url");
        boolean isNeedBdDownload = paramsJson.optBoolean(GameCenterAppManagerAction.PARAM_BAIDU_APP_DOWNLOAD);
        String packageName = paramsJson.optString("packageName");
        if (GameCenterAppManager.getInstance().queryOneDownloadRecordByUrl(url) != null || !isNeedBdDownload) {
            GameCenterAppManager.getInstance().installApp(activity, url, packageName, listener);
        } else if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(packageName)) {
            SwanGameRuntime.getGameDownloadRuntime().handleInstallApp(url, packageName);
        }
    }

    /* access modifiers changed from: private */
    public void setResult(OperateResult resultData) {
        if (resultData != null) {
            this.mResult.putString("functionType", resultData.getFunctionType());
            this.mResult.putString("resultData", resultData.getResult());
            this.mResult.putInt("resultStatus", resultData.getStatus());
            if (!resultData.isSuccessFunc()) {
                GameCenterStatistic.doAppManagerStats(this.mPackageName, "installApp", "fail", String.valueOf(resultData.getStatus()), new CommonStatsParams(this.mUbcParams));
            }
        }
        release();
        finish();
    }

    public void onAgentDestroy() {
        if (DEBUG) {
            Log.d(TAG, "onAgentDestroy mPackageName:" + this.mPackageName);
        }
        release();
    }

    public void onSelfFinish() {
        if (DEBUG) {
            Log.d(TAG, "onSelfFinish mPackageName:" + this.mPackageName);
        }
        int errorCode = AppConstants.STATUS_INSTALL_CANCEL;
        if (getAgent() instanceof InstallPluginDelegateActivity) {
            errorCode = ((InstallPluginDelegateActivity) getAgent()).getErrorCode();
        }
        GameCenterStatistic.doAppManagerStats(this.mPackageName, "installApp", "fail", String.valueOf(errorCode), new CommonStatsParams(this.mUbcParams));
        release();
    }

    private void release() {
        if (this.mResultListener != null) {
            GameCenterAppManager.getInstance().removeInstalledListener(this.mPackageName, this.mResultListener);
            this.mResultListener = null;
        }
        this.mResultListener = null;
    }

    public class InstallResultListener implements InstallListener {
        private String mFilePath;
        private String mPackageName;

        public InstallResultListener() {
        }

        public void onResult(OperateResult resultData) {
            if (InstallAppDelegation.DEBUG) {
                Log.d(InstallAppDelegation.TAG, "onResult mPackageName:" + this.mPackageName);
            }
            InstallAppDelegation.this.setResult(resultData);
            GameCenterAppManagerAction.sExecutorService.execute(new AfterInstallRunnable(this.mFilePath, this.mPackageName));
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public void setPackageName(String packageName) {
            this.mPackageName = packageName;
        }

        public String getFilePath() {
            return this.mFilePath;
        }

        public void setFilePath(String filePath) {
            this.mFilePath = filePath;
        }
    }

    private static class ExecuteInstallRunnable implements Runnable {
        Activity mActivity;
        private InstallListener mInstallListener;
        private JSONObject mParamsJson;
        private JSONObject mUbcParams;

        private ExecuteInstallRunnable(JSONObject paramsJson, JSONObject ubcParams, InstallListener listener, Activity activity) {
            this.mParamsJson = paramsJson;
            this.mUbcParams = ubcParams;
            this.mInstallListener = listener;
            this.mActivity = activity;
        }

        public void run() {
            GameCenterAppManager.getInstance().setUbcParams(this.mUbcParams);
            GameCenterStatistic.doAppManagerStats(this.mParamsJson.optString("packageName"), "installApp", (String) null, (String) null, new CommonStatsParams(this.mUbcParams));
            InstallAppDelegation.handleInstallApp(this.mActivity, this.mParamsJson, this.mInstallListener);
        }
    }

    private static class AfterInstallRunnable implements Runnable {
        private String mFilePath;
        private String mPackageName;

        private AfterInstallRunnable(String filePath, String packageName) {
            this.mFilePath = filePath;
            this.mPackageName = packageName;
        }

        public void run() {
            GameCenterAppManager.getInstance().notificationCancel(this.mPackageName);
            GameCenterAppManager.getInstance().deleteApkFile(this.mFilePath);
            GameCenterAppManager.getInstance().clearInstalledHistoryByLimit();
        }
    }
}
