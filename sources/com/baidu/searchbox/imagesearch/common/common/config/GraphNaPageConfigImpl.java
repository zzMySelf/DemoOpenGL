package com.baidu.searchbox.imagesearch.common.common.config;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.imagesearch.common.common.ImageSearchConfigSpUtil;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/imagesearch/common/common/config/GraphNaPageConfigImpl;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "commandPostData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "actionData", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "saveNaPageConfig", "json", "lib-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphNaPageConfigImpl.kt */
public final class GraphNaPageConfigImpl extends JSONObjectCommandListener {
    public void addPostData(Context context, String module, String action, CommandPostData commandPostData) {
        JSONObject version;
        try {
            String version2 = getLocalVersion(context, module, action);
            if (commandPostData != null && (version = commandPostData.getVersion()) != null) {
                version.put(UpdateConfigManager.KEY_NA_PAGE_CONFIG, version2);
            }
        } catch (Exception e2) {
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> actionData) {
        JSONObject jSONObject;
        if (actionData != null) {
            try {
                jSONObject = (JSONObject) actionData.data;
            } catch (Exception e2) {
                return false;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (TextUtils.equals(action, UpdateConfigManager.KEY_NA_PAGE_CONFIG)) {
                if (TextUtils.equals(actionData.version, getLocalVersion(context, module, action))) {
                    return false;
                }
                ImageSearchConfigSpUtil imageSearchConfigSpUtil = ImageSearchConfigSpUtil.INSTANCE;
                String str = actionData.version;
                Intrinsics.checkNotNullExpressionValue(str, "actionData.version");
                imageSearchConfigSpUtil.setConfigVersion("napage_load_more_delay_time_version", str);
                T t = actionData.data;
                Intrinsics.checkNotNullExpressionValue(t, "actionData.data");
                saveNaPageConfig((JSONObject) t);
                return true;
            }
        }
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return UpdateConfigManager.INSTANCE.getUpdateConfigVersion("napage_load_more_delay_time_version");
    }

    private final void saveNaPageConfig(JSONObject json) {
        try {
            if (json.has(UpdateConfigManager.KEY_NA_PAGE_LOADMORE_DELAY_TIME)) {
                ImageSearchConfigSpUtil imageSearchConfigSpUtil = ImageSearchConfigSpUtil.INSTANCE;
                String optString = json.optString(UpdateConfigManager.KEY_NA_PAGE_LOADMORE_DELAY_TIME);
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(UpdateCon…PAGE_LOADMORE_DELAY_TIME)");
                imageSearchConfigSpUtil.setUpdateConfig(UpdateConfigManager.KEY_NA_PAGE_LOADMORE_DELAY_TIME, optString);
            }
        } catch (Exception e2) {
        }
    }
}
