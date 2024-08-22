package com.baidu.searchbox.rewardsystem.newtimer.cloud;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.rewardsystem.newtimer.cloud.manager.TimerTaskConfigManager;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class MissionTaskConfigListener extends JSONObjectCommandListener {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String DEFAULT_VERSION = "0";
    public static final String MISSION_TASK_CONFIG_ACTION = "mission_task_config";
    public static final String MISSION_TASK_CONFIG_MODULE = "mission_task";
    private static final String TAG = "TaskConfigListener";

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        if (postData != null && postData.getVersion() != null) {
            try {
                postData.getVersion().put(MISSION_TASK_CONFIG_ACTION, getLocalVersion(context, module, action));
                if (AppConfig.isDebug()) {
                    TaskDebugUtil.debugLog("【MissionTaskConfigListener】【计时器云控数据】【入参】postData :" + postData.getData().toString());
                }
            } catch (JSONException exception) {
                if (DEBUG) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || value.version == null || !TextUtils.equals(action, MISSION_TASK_CONFIG_ACTION) || !TextUtils.equals(module, "mission_task")) {
            return false;
        }
        if (AppConfig.isDebug()) {
            TaskDebugUtil.debugLog("【MissionTaskConfigListener】【计时器云控数据】【response】action: " + action + " data " + value.data);
        }
        updateVersion(TimerTaskConfigManager.getInstance().commandUpdate(context, module, action, value), value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return PreferenceUtils.getString(MISSION_TASK_CONFIG_ACTION, "0");
    }

    /* access modifiers changed from: protected */
    public void updateVersion(boolean updated, String version) {
        if (updated) {
            PreferenceUtils.setString(MISSION_TASK_CONFIG_ACTION, version);
        }
    }
}
