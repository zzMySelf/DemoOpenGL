package com.baidu.searchbox.net.update.listener;

import android.content.Context;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.performance.speed.SpeedStats;
import org.json.JSONException;
import org.json.JSONObject;

public class FirstStartListener extends JSONObjectCommandListener {
    public static final String ACTION_FIRST_START_TYPE = "firstart";
    private static boolean sHasNotUpload = true;

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        JSONObject dataJson = postData.getPubData();
        if (sHasNotUpload) {
            sHasNotUpload = false;
            switch (SpeedStats.getInstance().getLaunchType()) {
                case 1:
                    dataJson.put(ACTION_FIRST_START_TYPE, "0");
                    return;
                case 2:
                    dataJson.put(ACTION_FIRST_START_TYPE, "1");
                    return;
                default:
                    return;
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> actionData) {
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return null;
    }
}
