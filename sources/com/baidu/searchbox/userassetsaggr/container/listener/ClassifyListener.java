package com.baidu.searchbox.userassetsaggr.container.listener;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.userassetsaggr.container.data.UserAssetsSharedPrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/userassetsaggr/container/listener/ClassifyListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "Companion", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassifyListener.kt */
public final class ClassifyListener extends JSONObjectCommandListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CLASSIFY = "_classify";
    public static final String KEY_VERSION = "_version";
    public static final String VALUE_ACTION = "assets_favorhis_classification";
    public static final String VALUE_MODULE = "favorhis_classify";

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        if (postData != null) {
            CommandPostData commandPostData = postData;
            CommandPostData $this$addPostData_u24lambda_u2d1 = module != null ? postData : null;
            if ($this$addPostData_u24lambda_u2d1 != null) {
                String version = getLocalVersion(context, module, action);
                if (action != null) {
                    $this$addPostData_u24lambda_u2d1.getVersion().put(action, version);
                }
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if ((value != null ? (JSONObject) value.data : null) == null || TextUtils.equals(getLocalVersion(context, module, VALUE_ACTION), value.version) || value.data == null) {
            return false;
        }
        UserAssetsSharedPrefs userAssetsSharedPrefs = UserAssetsSharedPrefs.INSTANCE;
        Companion companion = Companion;
        userAssetsSharedPrefs.putString(companion.getVersionKey(), value.version);
        UserAssetsSharedPrefs.INSTANCE.putString(companion.getActionKey(), ((JSONObject) value.data).toString());
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = UserAssetsSharedPrefs.INSTANCE.getString(Companion.getVersionKey(), "0");
        return string == null ? "0" : string;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/userassetsaggr/container/listener/ClassifyListener$Companion;", "", "()V", "KEY_CLASSIFY", "", "KEY_VERSION", "VALUE_ACTION", "VALUE_MODULE", "getActionKey", "getVersionKey", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClassifyListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getVersionKey() {
            return "assets_favorhis_classification_version";
        }

        public final String getActionKey() {
            return "assets_favorhis_classification_classify";
        }
    }
}
