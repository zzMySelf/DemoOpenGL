package com.baidu.searchbox.search.webvideo.update;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.search.tab.utils.SearchVideoPreferenceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J(\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/update/SearchH5SnifferBannerExpiringListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "p0", "p1", "p2", "Companion", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5SnifferBannerExpiringListener.kt */
public final class SearchH5SnifferBannerExpiringListener extends JSONObjectCommandListener {
    public static final String ACTION = "snifferboard_banner_expiring";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_VERSION = "0";
    public static final String KEY_SWITCH = "snifferboard_banner_duvip_expiring_tips_disabled";
    private static final String KEY_VERSION = "snifferboard_banner_expiring_version";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/update/SearchH5SnifferBannerExpiringListener$Companion;", "", "()V", "ACTION", "", "DEFAULT_VERSION", "KEY_SWITCH", "KEY_VERSION", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchH5SnifferBannerExpiringListener.kt */
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
        JSONObject dataJson = value != null ? (JSONObject) value.data : null;
        if (dataJson == null || !TextUtils.equals(action, ACTION)) {
            return false;
        }
        String localVersion = getLocalVersion(context, module, action);
        if (TextUtils.isEmpty(value.version) || TextUtils.equals(value.version, localVersion)) {
            return false;
        }
        SearchVideoPreferenceUtils.Companion.getInstance().putString(KEY_VERSION, value.version);
        SearchVideoPreferenceUtils.Companion.getInstance().putBoolean(KEY_SWITCH, dataJson.optBoolean(KEY_SWITCH, true));
        return true;
    }

    public String getLocalVersion(Context p0, String p1, String p2) {
        return SearchVideoPreferenceUtils.Companion.getInstance().getString(KEY_VERSION, "0");
    }
}
