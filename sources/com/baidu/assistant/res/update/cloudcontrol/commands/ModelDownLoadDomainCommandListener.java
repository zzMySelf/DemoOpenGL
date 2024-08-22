package com.baidu.assistant.res.update.cloudcontrol.commands;

import android.content.Context;
import com.baidu.assistant.res.update.cloudcontrol.files.ModelFileConfig;
import com.baidu.assistant.res.update.models.ActionModelDownloadDomain;
import com.baidu.pyramid.runtime.multiprocess.AppProcessManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J6\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J&\u0010\u0015\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/assistant/res/update/cloudcontrol/commands/ModelDownLoadDomainCommandListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "DEFAULT_MODEL_DOWNLOAD_DOMAIN_VERSION", "", "KEY_MODEL_DOWNLOAD_DOMAIN_VERSION", "TAG", "kotlin.jvm.PlatformType", "addPostData", "", "context", "Landroid/content/Context;", "module", "action", "commandPostData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "actionData", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "lib-assistant-update_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModelDownLoadDomainCommandListener.kt */
public final class ModelDownLoadDomainCommandListener extends JSONObjectCommandListener {
    private final String DEFAULT_MODEL_DOWNLOAD_DOMAIN_VERSION = "0";
    private final String KEY_MODEL_DOWNLOAD_DOMAIN_VERSION = "model_download_domain_v";
    private final String TAG = ModelDownLoadDomainCommandListener.class.getSimpleName();

    public void addPostData(Context context, String module, String action, CommandPostData commandPostData) {
        if (AppProcessManager.isDefaultProcess()) {
            if ((commandPostData != null ? commandPostData.getVersion() : null) != null) {
                commandPostData.getVersion().put(ModelFileConfig.MODEL_DOWNLOAD_DOMAIN_KEY, getLocalVersion(context, module, action));
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> actionData) {
        JSONObject it;
        String it2;
        try {
            if (Intrinsics.areEqual((Object) action, (Object) ModelFileConfig.MODEL_DOWNLOAD_DOMAIN_KEY)) {
                if ((actionData != null ? (JSONObject) actionData.data : null) != null) {
                    String localVersion = getLocalVersion(context, module, action);
                    String str = actionData.version;
                    Intrinsics.checkNotNullExpressionValue(str, "actionData.version");
                    if (Long.parseLong(str) <= Long.parseLong(localVersion)) {
                        return false;
                    }
                    if (!(actionData == null || (it = (JSONObject) actionData.data) == null || (it2 = ((ActionModelDownloadDomain) new Gson().fromJson(it.toString(), ActionModelDownloadDomain.class)).getDownload_domain()) == null)) {
                        DefaultSharedPrefsWrapper.getInstance().putString(ModelFileConfig.MODEL_DOWNLOAD_DOMAIN_KEY, it2);
                    }
                    DefaultSharedPrefsWrapper.getInstance().putString(this.KEY_MODEL_DOWNLOAD_DOMAIN_VERSION, actionData.version);
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = DefaultSharedPrefsWrapper.getInstance().getString(this.KEY_MODEL_DOWNLOAD_DOMAIN_VERSION, this.DEFAULT_MODEL_DOWNLOAD_DOMAIN_VERSION);
        if (string == null) {
            return this.DEFAULT_MODEL_DOWNLOAD_DOMAIN_VERSION;
        }
        return string;
    }
}
