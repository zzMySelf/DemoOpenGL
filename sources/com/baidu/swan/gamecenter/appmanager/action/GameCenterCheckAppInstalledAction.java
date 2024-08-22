package com.baidu.swan.gamecenter.appmanager.action;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.gamecenter.IGameCenterCallback;
import com.baidu.swan.gamecenter.appmanager.download.AppConstants;
import com.baidu.swan.gamecenter.main.GameCenterAction;
import org.json.JSONObject;

public class GameCenterCheckAppInstalledAction extends GameCenterAction {
    private static final String API_NAME = "checkAppInstalled";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String KEY_DATA = "data";
    private static final String PARAM_PACKAGE_NAME = "packageName";
    private static final String RET_VERSION_CORE = "versionCode";
    private static final String RET_VERSION_NAME = "versionName";
    private static final String TAG = "checkAppInstalled";

    public GameCenterCheckAppInstalledAction() {
        super("checkAppInstalled");
    }

    public SwanApiResult handle(JSONObject paramsJson, IGameCenterCallback callback) {
        boolean z = DEBUG;
        if (z) {
            Log.d("checkAppInstalled", "handle: " + paramsJson);
        }
        String packageName = paramsJson.optString("packageName");
        if (TextUtils.isEmpty(packageName)) {
            callback.onFail(AppConstants.STATUS_PACKAGE_NAME_IS_EMPTY, AppConstants.MSG_PACKAGE_NAME_IS_EMPTY);
            return null;
        }
        try {
            PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(packageName, 0);
            if (z) {
                Log.d("checkAppInstalled", "packageInfo: " + packageInfo);
            }
            if (packageInfo != null) {
                JSONObject jsonObject = new JSONObject();
                JSONObject data = new JSONObject();
                data.put("versionName", packageInfo.versionName);
                data.put("versionCode", packageInfo.versionCode);
                jsonObject.put("data", data);
                callback.onSuccess(jsonObject);
            } else {
                callback.onFail(AppConstants.STATUS_NO_PACKAGE_INFO, AppConstants.MSG_NO_PACKAGE_INFO);
            }
        } catch (Exception e2) {
            callback.onFail(AppConstants.STATUS_PACKAGE_IS_NOT_INSTALLED, AppConstants.MSG_PACKAGE_IS_NOT_INSTALLED);
        }
        return null;
    }
}
