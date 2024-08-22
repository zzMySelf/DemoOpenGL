package com.baidu.searchbox.socialshare.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class SharePanelCommandListener extends JSONObjectCommandListener {
    public static final String ACTION_SHARE_PANEL = "share_panel";
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "ShareCommandListener";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put("share_panel", ShareOperationPreferenceUtils.getPanelVersion());
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, "share_panel")) {
            return false;
        }
        if (DEBUG) {
            Log.d("ShareCommandListener", "action == " + action + "version = " + value.version + " config = " + value.data);
        }
        saveSharePanelData((JSONObject) value.data, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return ShareOperationPreferenceUtils.getBannerVersion();
    }

    private void saveSharePanelData(JSONObject json, String version) {
        ShareOperationPreferenceUtils.setPanelVersion(version);
        try {
            ShareOperationPreferenceUtils.setPanelIconList(json.optString("icon_list"));
            ShareOperationPreferenceUtils.setScreenShotConf(json.optString("screen_shot_conf"));
            ShareOperationPreferenceUtils.setPanelLoadingTime(json.optInt(ShareOperationPreferenceUtils.KEY_SHARE_LOADING_TIME));
            ShareOperationPreferenceUtils.saveChannelConfig(json.optString(ShareOperationPreferenceUtils.KEY_CHANNEL_CONFIG));
            ShareOperationPreferenceUtils.setResizeOptions((float) json.optDouble("resize_options"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        savePanelItemAnimationData(json);
        ShareOperationPreferenceUtils.setWeiboShareResultSwitch(TextUtils.equals(json.optString("weibo_share_result_switch", "1"), "1"));
    }

    private void savePanelItemAnimationData(JSONObject json) {
        try {
            String displayEffect = json.getString(ShareOperationPreferenceUtils.KEY_DISPLAY_EFFECT);
            JSONObject tempJson = json.getJSONObject(ShareOperationPreferenceUtils.KEY_DISPLAY_EFFECT_CONTROL);
            String displayEffectControlPeriod = tempJson.getString("period");
            String displayEffectControlTimes = tempJson.getString("limit");
            String withoutShareDay = json.getString(ShareOperationPreferenceUtils.KEY_WITHOUT_SHARE_DAY);
            String inuseSource = json.getString(ShareOperationPreferenceUtils.KEY_INUSE_SOURCE);
            ShareOperationPreferenceUtils.setDisplayEffect(displayEffect);
            ShareOperationPreferenceUtils.setDisplayEffectControlPeriod(displayEffectControlPeriod);
            ShareOperationPreferenceUtils.setDisplayEffectControlTimes(displayEffectControlTimes);
            ShareOperationPreferenceUtils.setWithoutShareDay(withoutShareDay);
            ShareOperationPreferenceUtils.setInuseSource(inuseSource);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
