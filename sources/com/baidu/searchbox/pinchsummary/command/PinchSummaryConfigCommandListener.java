package com.baidu.searchbox.pinchsummary.command;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J(\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/pinchsummary/command/PinchSummaryConfigCommandListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "pinch-summary_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchSummaryGenerateConfigCommandListener.kt */
public final class PinchSummaryConfigCommandListener extends JSONObjectCommandListener {
    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject version;
        if (postData != null && (version = postData.getVersion()) != null) {
            version.put("pinch_summary_generate_config", getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || ((JSONObject) value.data) == null || value.version == null || TextUtils.equals(value.version, getLocalVersion(context, module, action))) {
            return false;
        }
        if (TextUtils.equals("-1", value.version)) {
            new SharedPrefsWrapper(PinchSummaryCommandConstantKt.PINCH_SUMMARY_SP_FILE).remove(PinchSummaryGenerateConfigCommandListenerKt.KEY_PINCH_SUMMARY_CONFIG_SHOW_TYPE);
            PreferenceUtils.setString("pinch_summary_generate_config", value.version);
            return true;
        }
        new SharedPrefsWrapper(PinchSummaryCommandConstantKt.PINCH_SUMMARY_SP_FILE).putString(PinchSummaryGenerateConfigCommandListenerKt.KEY_PINCH_SUMMARY_CONFIG_SHOW_TYPE, ((JSONObject) value.data).optString(PinchSummaryGenerateConfigCommandListenerKt.KEY_PINCH_SUMMARY_CONFIG_SHOW_TYPE, ""));
        PreferenceUtils.setString("pinch_summary_generate_config", value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return PreferenceUtils.getString("pinch_summary_generate_config", "0");
    }
}
