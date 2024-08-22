package com.baidu.searchbox.personalcenter.commandlistener;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.utils.PersonalCenterSpUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/personalcenter/commandlistener/PersonalPublishSchemeListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "Companion", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPublishSchemeListener.kt */
public final class PersonalPublishSchemeListener extends JSONObjectCommandListener {
    public static final String ACTION = "personal_publish_scheme";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_VERSION = "0";
    public static final String MODULE = "personal_center";
    public static final String PERSONAL_PUBLISH_SCHEME = "personal_center_publish_scheme";
    private static final String PUBLISH_SCHEME = "personal_center_publish_scheme";
    private static final String PUBLISH_SCHEME_VERSION = "version_personal_center_publish_scheme";
    private static final String TAG = "PersonalPublishScheme";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/personalcenter/commandlistener/PersonalPublishSchemeListener$Companion;", "", "()V", "ACTION", "", "DEFAULT_VERSION", "MODULE", "PERSONAL_PUBLISH_SCHEME", "PUBLISH_SCHEME", "PUBLISH_SCHEME_VERSION", "TAG", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalPublishSchemeListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject version;
        String localVersion = getLocalVersion(context, module, action);
        if (postData != null && (version = postData.getVersion()) != null) {
            version.put(ACTION, localVersion);
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        JSONObject data = value != null ? (JSONObject) value.data : null;
        if (data == null || !TextUtils.equals(action, ACTION)) {
            return false;
        }
        String localVersion = getLocalVersion(context, module, action);
        if (TextUtils.isEmpty(value.version) || TextUtils.equals(value.version, localVersion)) {
            return false;
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "executeCommand: " + data);
        }
        PersonalCenterSpUtils.putString("personal_center_publish_scheme", data.optString("personal_center_publish_scheme", ""));
        PersonalCenterSpUtils.putString(PUBLISH_SCHEME_VERSION, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String localVersion = PersonalCenterSpUtils.getString(PUBLISH_SCHEME_VERSION, "0");
        if (localVersion == null) {
            return "0";
        }
        return localVersion;
    }
}
