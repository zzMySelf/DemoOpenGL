package com.baidu.searchbox.plugins.helper;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import com.baidu.searchbox.plugin.api.InvokeListener;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.searchbox.plugins.helper.IMPluginHelper;
import com.baidu.searchbox.plugins.utils.PluginPreLoadManager;
import org.json.JSONException;
import org.json.JSONObject;

public final class DumiPluginHelper {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = (AppConfig.isDebug() & true);
    public static final String DUMI_PACKAGE_NAME = "com.baidu.robot";
    public static final String METHOD_NAME_DUMI_ACTIVE_XIAODU_SERVICE = "callXiaoduService";
    public static final String METHOD_NAME_DUMI_NOTIFICATION_CALL_DUMI = "callXiaoDuNotificaiton";
    public static final String METHOD_NAME_DUMI_RECEIVE_MSG = "receiverMsg";
    public static final String METHOD_NAME_VOICE_START_ROBOT = "callXiaoDu";
    private static final String TAG = "DumiPluginHelper";

    private DumiPluginHelper() {
    }

    public static void sendMsg2Dumi(String msgJson) {
        if (DEBUG) {
            Log.i(TAG, "sendMsg2Dumi msgJson:" + msgJson);
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("msgs", msgJson);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(jsonObject.toString())) {
            PluginInvoker.invokePlugin(AppRuntime.getAppContext(), "com.baidu.robot", METHOD_NAME_DUMI_RECEIVE_MSG, "searchbox", jsonObject.toString(), new InvokeCallback() {
                public void onResult(int statusCode, String result) {
                    if (DumiPluginHelper.DEBUG) {
                        Log.i(DumiPluginHelper.TAG, "sendMsg2Dumi result statusCode:" + statusCode + ",result:" + result);
                    }
                    if (statusCode < 0 && DumiPluginHelper.DEBUG) {
                        Log.w(DumiPluginHelper.TAG, "sendMsg2Dumi failure statusCode:" + statusCode);
                    }
                }
            }, (InvokeListener[]) null);
        }
    }

    public static void activeXiaoduService() {
        if (PluginPreLoadManager.getInstance().checkCanUpdate("com.baidu.robot")) {
            Log.d(TAG, "Dumi Plugin need update, cancel wakeup Xiaodu Alarm Service");
            return;
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("method", "syncAlarm");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(jsonObject.toString())) {
            final long startTime = System.currentTimeMillis();
            PluginInvoker.invokePlugin(AppRuntime.getAppContext(), "com.baidu.robot", METHOD_NAME_DUMI_ACTIVE_XIAODU_SERVICE, "searchbox", jsonObject.toString(), new InvokeCallback() {
                public void onResult(int statusCode, String result) {
                    long endTime = System.currentTimeMillis();
                    if (DumiPluginHelper.DEBUG) {
                        Log.i(DumiPluginHelper.TAG, "CallXiaoduService result statusCode:" + statusCode + ", result:" + result + ", cost time:" + (endTime - startTime) + "ms");
                    }
                }
            }, (InvokeListener[]) null);
            if (DEBUG) {
                Log.d(TAG, "CallXiaoduService, active dumi alarm");
            }
        }
    }

    public static void invokeRobot(String paramsJSONStr, final IMPluginHelper.Callback callback) {
        TTSRuntime.getInstance().postInterruptedEvent("InvokeDumi");
        PluginInvoker.invokePlugin(AppRuntime.getAppContext(), "com.baidu.robot", "callXiaoDu", "searchbox:home", paramsJSONStr, new InvokeCallback() {
            public void onResult(int statusCode, String result) {
                IMPluginHelper.Callback callback = IMPluginHelper.Callback.this;
                if (callback != null) {
                    if (statusCode == 0) {
                        callback.onResult(0);
                    } else {
                        callback.onResult(statusCode);
                    }
                }
            }
        }, (InvokeListener[]) null);
    }
}
