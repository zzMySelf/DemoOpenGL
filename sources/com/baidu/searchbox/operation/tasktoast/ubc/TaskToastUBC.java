package com.baidu.searchbox.operation.tasktoast.ubc;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskToastUBC {
    private static final String KEY_CLICK = "click";
    private static final String KEY_FROM = "from";
    private static final String KEY_SHOW = "show";
    private static final String KEY_TOOL = "tool";
    private static final String KEY_TYPE = "type";
    private static final String TAG = "TaskToastUBC";
    private static final String UBC_TASK_TOAST_ID = "902";

    public static void show() {
        JSONObject ubcData = new JSONObject();
        try {
            ubcData.put("from", "tool");
            ubcData.put("type", "show");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (AppConfig.isDebug()) {
            Log.e(TAG, "show =" + ubcData.toString());
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_TASK_TOAST_ID, ubcData.toString());
    }

    public static void click() {
        JSONObject ubcData = new JSONObject();
        try {
            ubcData.put("from", "tool");
            ubcData.put("type", "click");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (AppConfig.isDebug()) {
            Log.e(TAG, "click =" + ubcData.toString());
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_TASK_TOAST_ID, ubcData.toString());
    }
}
