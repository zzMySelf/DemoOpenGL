package com.baidu.searchbox.personalcenter.commandlistener;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.personal.manager.UpgradeMgr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/personalcenter/commandlistener/PersonalCenterUpgradeConfigListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterUpgradeConfigListener.kt */
public final class PersonalCenterUpgradeConfigListener extends JSONObjectCommandListener {
    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject version;
        String localVersion = getLocalVersion(context, module, action);
        if (postData != null && (version = postData.getVersion()) != null) {
            version.put("personal_upgrade_config", localVersion);
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (!TextUtils.equals(action, "personal_upgrade_config")) {
            return false;
        }
        JSONObject jSONObject = null;
        String version = value != null ? value.version : null;
        String localVersion = getLocalVersion(context, module, action);
        if (TextUtils.isEmpty(version) || TextUtils.equals(version, localVersion)) {
            return false;
        }
        if (Intrinsics.areEqual((Object) version, (Object) "-1")) {
            UpgradeMgr.INSTANCE.saveUpgradeConfig$lib_personal_center_release((JSONObject) null);
            PreferenceUtils.setString("personal_upgrade_config_version", "-1");
            return true;
        }
        UpgradeMgr upgradeMgr = UpgradeMgr.INSTANCE;
        if (value != null) {
            jSONObject = (JSONObject) value.data;
        }
        upgradeMgr.saveUpgradeConfig$lib_personal_center_release(jSONObject);
        PreferenceUtils.setString("personal_upgrade_config_version", version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String localVersion = PreferenceUtils.getString("personal_upgrade_config_version", "0");
        if (localVersion == null) {
            return "0";
        }
        return localVersion;
    }
}
