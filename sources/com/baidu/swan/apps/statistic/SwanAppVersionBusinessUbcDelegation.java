package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.database.SwanAppDbInfo;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.process.delegate.delegation.SwanAppMessengerDelegation;
import com.baidu.swan.apps.process.messaging.client.SwanAppMessengerClient;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppBusinessUbc;
import com.baidu.swan.apps.util.SwanAppUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppVersionBusinessUbcDelegation extends SwanAppMessengerDelegation {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String ILLEGAL_VERSION = "0";
    private static final String KEY_REPORT_INFO = "key_report_info";
    private static final String KEY_SWAN_APPID = "key_swan_appid";
    private static final String TAG = "VersionBusinessUbc";

    public void execCall(Bundle params) {
        SwanAppDbInfo appDbInfo;
        String reportInfo = "";
        String swanAppId = params.getString(KEY_SWAN_APPID, reportInfo);
        String reportInfo2 = params.getString(KEY_REPORT_INFO, reportInfo);
        if (!TextUtils.isEmpty(reportInfo2)) {
            reportInfo = reportInfo2;
        }
        JSONObject reportInfoJo = null;
        try {
            reportInfoJo = new JSONObject(reportInfo);
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "execCall: ", e2);
            }
            e2.printStackTrace();
        }
        if (reportInfoJo == null) {
            reportInfoJo = new JSONObject();
        }
        if (!TextUtils.isEmpty(swanAppId) && (appDbInfo = SwanAppDbControl.getInstance(AppRuntime.getAppContext()).querySwanAppItem(swanAppId)) != null) {
            try {
                reportInfoJo.put("appDbInfo", appDbInfo.toShortString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d(TAG, "report info: " + reportInfoJo.toString());
        }
        new SwanAppBusinessUbc.Builder(10002).buildInfo(reportInfoJo.toString()).report();
        finish();
    }

    public static boolean isInvalidVersion(String version) {
        return TextUtils.isEmpty(version) || TextUtils.equals("0", version);
    }

    public static void reportInfoForClient(String appId, String version, JSONObject reportExtInfo) {
        Bundle data;
        if (isInvalidVersion(version)) {
            JSONObject reportInfo = new JSONObject();
            String str = "null";
            try {
                reportInfo.put("version", version == null ? str : version);
                reportInfo.put("appId", appId == null ? str : appId);
                SwanApp swanApp = SwanApp.get();
                if (swanApp != null) {
                    SwanAppLaunchInfo launchInfo = swanApp.getLaunchInfo();
                    reportInfo.put("launchInfo", launchInfo == null ? str : launchInfo.toShortString());
                    ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
                    SwanAppLaunchInfo launchInfoIntent = null;
                    if (!(frameContainer == null || (data = frameContainer.getBundleData()) == null)) {
                        launchInfoIntent = new SwanAppLaunchInfo.Impl().update(data);
                    }
                    if (launchInfoIntent != null) {
                        str = launchInfoIntent.toShortString();
                    }
                    reportInfo.put("launchInfoIntent", str);
                } else {
                    reportInfo.put("swanApp", str);
                }
                reportInfo.put("stackTrace", SwanAppUtils.getStackTrace());
                if (reportExtInfo != null) {
                    reportInfo.put("reportExtInfo", reportExtInfo);
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            SwanAppMessengerClient client = Swan.get().getMsgClient();
            if (client != null) {
                Bundle data2 = new Bundle();
                data2.putString(KEY_SWAN_APPID, appId);
                data2.putString(KEY_REPORT_INFO, reportInfo.toString());
                client.sendDelegationMessage(data2, SwanAppVersionBusinessUbcDelegation.class);
            }
        }
    }
}
