package com.baidu.searchbox.newhome.content.tips;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.home.HomePublicSharedPrefsUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/newhome/content/tips/NewHomeTipsForbidPreviousStateListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeTipsForbidPreviousStateListener.kt */
public final class NewHomeTipsForbidPreviousStateListener extends JSONObjectCommandListener {
    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        if (action != null && postData != null && postData.getVersion() != null) {
            postData.getVersion().put(action, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        String str = null;
        if ((value != null ? (JSONObject) value.data : null) == null || !TextUtils.equals(action, "tips_forbid_recover_previous_state") || TextUtils.equals(value.version, getLocalVersion(context, module, action))) {
            return false;
        }
        if (AppConfig.isDebug()) {
            StringBuilder append = new StringBuilder().append("ccs result: ");
            JSONObject jSONObject = (JSONObject) value.data;
            if (jSONObject != null) {
                str = jSONObject.toString();
            }
            Log.d("NewHomeTipsForbid", append.append(str).toString());
        }
        if (Intrinsics.areEqual((Object) value.version, (Object) "-1") || value.data == null) {
            HomePublicSharedPrefsUtils.getInstance().remove(NewHomeTipsForbidPreviousStateListenerKt.SP_SWITCH_KEY);
            return true;
        }
        HomePublicSharedPrefsUtils.getInstance().putInt(NewHomeTipsForbidPreviousStateListenerKt.SP_SWITCH_KEY, ((JSONObject) value.data).optInt("switch", 0));
        HomePublicSharedPrefsUtils.getInstance().putString("tips_forbid_recover_previous_state_version", value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string;
        if (action == null || (string = HomePublicSharedPrefsUtils.getInstance().getString("tips_forbid_recover_previous_state_version", "0")) == null) {
            return "0";
        }
        return string;
    }
}
