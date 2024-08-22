package com.baidu.searchbox.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/update/PrivacyEntranceCtlListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "actionDataEntry", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "setLocalVersion", "version", "Companion", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrivacyEntranceCtlListener.kt */
public final class PrivacyEntranceCtlListener extends JSONObjectCommandListener {
    public static final String CTL_ACTION = "privacy_entrance";
    public static final String CTL_MODULE = "settings";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATA_KEY_PRIVACY_COLLECTION_ENTRANCE_SHOW = "privacy_collection_show";
    public static final String DATA_KEY_PRIVACY_COLLECTION_NEED_LOGIN = "need_login";
    public static final String DATA_KEY_PRIVACY_COLLECTION_URL = "privacy_collection_url";
    public static final String DATA_KEY_PRIVACY_POLICY_ENTRANCE_SHOW = "privacy_policy_show";
    public static final String DATA_KEY_PRIVACY_POLICY_URL = "privacy_policy_url";
    public static final String DATA_VALUE_FALSE = "0";
    public static final String DATA_VALUE_TRUE = "1";
    public static final String DEFAULT_COLLECTION_LIST_URL = "https://mbd.baidu.com/baiduapp/privacyList";
    public static final String DEFAULT_PRIVACY_SUMMARY_URL = "https://mbd.baidu.com/baiduapp/privacyList/summary/new";
    public static final String SP_KEY_PRIVACY_COLLECTION_ENTRANCE_SHOW = "privacy_collection_ctl_entrance_show";
    public static final String SP_KEY_PRIVACY_COLLECTION_NEED_LOGIN = "privacy_collection_ctl_need_login";
    public static final String SP_KEY_PRIVACY_COLLECTION_URL = "privacy_collection_ctl_target_url";
    public static final String SP_KEY_PRIVACY_POLICY_ENTRANCE_SHOW = "privacy_policy_ctl_entrance show";
    public static final String SP_KEY_PRIVACY_POLICY_URL = "privacy_policy_ctl_url";
    public static final String SP_KEY_VERSION = "privacy_entrance_ctl_version";
    public static final String TAG = "PrivacyEntranceCtlListener";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/update/PrivacyEntranceCtlListener$Companion;", "", "()V", "CTL_ACTION", "", "CTL_MODULE", "DATA_KEY_PRIVACY_COLLECTION_ENTRANCE_SHOW", "DATA_KEY_PRIVACY_COLLECTION_NEED_LOGIN", "DATA_KEY_PRIVACY_COLLECTION_URL", "DATA_KEY_PRIVACY_POLICY_ENTRANCE_SHOW", "DATA_KEY_PRIVACY_POLICY_URL", "DATA_VALUE_FALSE", "DATA_VALUE_TRUE", "DEFAULT_COLLECTION_LIST_URL", "DEFAULT_PRIVACY_SUMMARY_URL", "SP_KEY_PRIVACY_COLLECTION_ENTRANCE_SHOW", "SP_KEY_PRIVACY_COLLECTION_NEED_LOGIN", "SP_KEY_PRIVACY_COLLECTION_URL", "SP_KEY_PRIVACY_POLICY_ENTRANCE_SHOW", "SP_KEY_PRIVACY_POLICY_URL", "SP_KEY_VERSION", "TAG", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrivacyEntranceCtlListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        if (TextUtils.equals(action, CTL_ACTION) && postData != null) {
            JSONObject version = postData.getVersion();
            if (version != null) {
                Intrinsics.checkNotNullExpressionValue(version, "version");
                version.put(CTL_ACTION, getLocalVersion(context, module, action));
            }
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, "addPostData error!!! action=" + action + ", is postData empty: " + (postData == null));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> actionDataEntry) {
        if (actionDataEntry != null) {
            ActionData actionData = actionDataEntry;
            String str = actionData.version;
            if (TextUtils.equals(str, getLocalVersion(context, module, action))) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "executeCommand - same version -- " + str + ", will exit!!");
                }
            } else {
                JSONObject dataEntry = (JSONObject) actionData.data;
                if (dataEntry != null) {
                    Intrinsics.checkNotNullExpressionValue(dataEntry, "data");
                    String collectionUrl = dataEntry.optString(DATA_KEY_PRIVACY_COLLECTION_URL, DEFAULT_COLLECTION_LIST_URL);
                    String collectionNeedLogin = dataEntry.optString(DATA_KEY_PRIVACY_COLLECTION_NEED_LOGIN, "0");
                    String collectionEntranceShow = dataEntry.optString(DATA_KEY_PRIVACY_COLLECTION_ENTRANCE_SHOW, "1");
                    CharSequence charSequence = collectionNeedLogin;
                    boolean z = false;
                    if (charSequence == null || StringsKt.isBlank(charSequence)) {
                        collectionNeedLogin = "0";
                    }
                    CharSequence charSequence2 = collectionEntranceShow;
                    if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                        collectionEntranceShow = "1";
                    }
                    CharSequence charSequence3 = collectionUrl;
                    if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
                        collectionUrl = DEFAULT_COLLECTION_LIST_URL;
                    }
                    String policyUrl = dataEntry.optString(DATA_KEY_PRIVACY_POLICY_URL, DEFAULT_PRIVACY_SUMMARY_URL);
                    String policyEntranceShow = dataEntry.optString(DATA_KEY_PRIVACY_POLICY_ENTRANCE_SHOW, "1");
                    CharSequence charSequence4 = policyEntranceShow;
                    if (charSequence4 == null || StringsKt.isBlank(charSequence4)) {
                        policyEntranceShow = "1";
                    }
                    CharSequence charSequence5 = policyUrl;
                    if (charSequence5 == null || StringsKt.isBlank(charSequence5)) {
                        z = true;
                    }
                    if (z) {
                        policyUrl = DEFAULT_PRIVACY_SUMMARY_URL;
                    }
                    PreferenceUtils.setString(SP_KEY_PRIVACY_COLLECTION_URL, collectionUrl);
                    PreferenceUtils.setBoolean(SP_KEY_PRIVACY_COLLECTION_ENTRANCE_SHOW, TextUtils.equals(collectionEntranceShow, "1"));
                    PreferenceUtils.setBoolean(SP_KEY_PRIVACY_COLLECTION_NEED_LOGIN, TextUtils.equals(collectionNeedLogin, "1"));
                    PreferenceUtils.setString(SP_KEY_PRIVACY_POLICY_URL, policyUrl);
                    PreferenceUtils.setBoolean(SP_KEY_PRIVACY_POLICY_ENTRANCE_SHOW, TextUtils.equals(policyEntranceShow, "1"));
                    Intrinsics.checkNotNullExpressionValue(str, "version");
                    setLocalVersion(str);
                }
            }
        }
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = PreferenceUtils.getString(SP_KEY_VERSION, "0");
        Intrinsics.checkNotNullExpressionValue(string, "getString(SP_KEY_VERSION, \"0\")");
        return string;
    }

    public final void setLocalVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        PreferenceUtils.setString(SP_KEY_VERSION, version);
    }
}
