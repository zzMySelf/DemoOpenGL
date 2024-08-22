package com.baidu.searchbox.widget.listener;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.widget.AndroidOWidgetDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J(\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/widget/listener/AddSearchWidgetListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "p0", "p1", "p2", "Companion", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddSearchWidgetListener.kt */
public final class AddSearchWidgetListener extends JSONObjectCommandListener {
    public static final String ACTION = "add_search_widget";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_VERSION = "0";
    public static final String KEY_VERSION = "add_search_widget_version";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/widget/listener/AddSearchWidgetListener$Companion;", "", "()V", "ACTION", "", "DEFAULT_VERSION", "KEY_VERSION", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddSearchWidgetListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        if ((postData != null ? postData.getVersion() : null) != null) {
            postData.getVersion().put(ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if ((value != null ? (JSONObject) value.data : null) == null || !TextUtils.equals(action, ACTION)) {
            return false;
        }
        if (((JSONObject) value.data).getInt("is_target") == 1) {
            AndroidOWidgetDispatcher.sIsTarget = true;
            PreferenceUtils.setBoolean(AddSearchWidgetListenerKt.KEY_TARGET_USER, true);
        } else {
            PreferenceUtils.setBoolean(AddSearchWidgetListenerKt.KEY_TARGET_USER, false);
        }
        int firstInterval = ((JSONObject) value.data).optInt("first_interval");
        if (firstInterval > 0) {
            PreferenceUtils.setInt(AndroidOWidgetDispatcher.KEY_FIRST_INTERVAL, firstInterval);
        }
        int frequency = ((JSONObject) value.data).optInt("frequency");
        if (frequency > 0) {
            PreferenceUtils.setInt(AndroidOWidgetDispatcher.KEY_TRIGGER_FREQUENCY, frequency);
        }
        PreferenceUtils.setInt(AndroidOWidgetDispatcher.KEY_MAX_NOTIFY_TIMES, ((JSONObject) value.data).optInt(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_MAX_TIMES));
        PreferenceUtils.setString(KEY_VERSION, value.version);
        if (AppConfig.isDebug()) {
            Log.d(ACTION, "executeCommand: " + value.data);
        }
        return true;
    }

    public String getLocalVersion(Context p0, String p1, String p2) {
        return PreferenceUtils.getString(KEY_VERSION, "0");
    }
}
