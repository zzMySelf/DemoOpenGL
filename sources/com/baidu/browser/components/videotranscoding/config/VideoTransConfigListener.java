package com.baidu.browser.components.videotranscoding.config;

import android.content.Context;
import com.baidu.browser.utils.SearchPreferenceUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/browser/components/videotranscoding/config/VideoTransConfigListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "actionData", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTransConfigListener.kt */
public final class VideoTransConfigListener extends JSONObjectCommandListener {
    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject version;
        if (postData != null && (version = postData.getVersion()) != null) {
            version.put("video_trans_img_and", getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> actionData) {
        JSONObject $this$executeCommand_u24lambda_u2d2;
        boolean z = false;
        if (!Intrinsics.areEqual((Object) "video_trans_img_and", (Object) action) || actionData == null || ($this$executeCommand_u24lambda_u2d2 = (JSONObject) actionData.data) == null) {
            return false;
        }
        SearchPreferenceUtils.getInstance().putInt("search_video_trans_image_switch", $this$executeCommand_u24lambda_u2d2.optInt("search_video_trans_image_switch", 1));
        SearchPreferenceUtils.getInstance().putInt(VideoTransConfigListenerKt.SEARCH_VIDEO_TRANS_IMAGE_COUNT, $this$executeCommand_u24lambda_u2d2.optInt(VideoTransConfigListenerKt.SEARCH_VIDEO_TRANS_IMAGE_COUNT, 60));
        JSONArray $this$executeCommand_u24lambda_u2d2_u24lambda_u2d0 = $this$executeCommand_u24lambda_u2d2.optJSONArray(VideoTransConfigListenerKt.SEARCH_VIDEO_TRANS_IMAGE_CONTAINS);
        if ($this$executeCommand_u24lambda_u2d2_u24lambda_u2d0 != null) {
            Intrinsics.checkNotNullExpressionValue($this$executeCommand_u24lambda_u2d2_u24lambda_u2d0, "optJSONArray(SEARCH_VIDEO_TRANS_IMAGE_CONTAINS)");
            SearchPreferenceUtils.getInstance().putString(VideoTransConfigListenerKt.SEARCH_VIDEO_TRANS_IMAGE_CONTAINS, $this$executeCommand_u24lambda_u2d2_u24lambda_u2d0.toString());
        }
        JSONArray $this$executeCommand_u24lambda_u2d2_u24lambda_u2d1 = $this$executeCommand_u24lambda_u2d2.optJSONArray(VideoTransConfigListenerKt.SEARCH_VIDEO_TRANS_IMAGE_EXCLUDES);
        if ($this$executeCommand_u24lambda_u2d2_u24lambda_u2d1 != null) {
            Intrinsics.checkNotNullExpressionValue($this$executeCommand_u24lambda_u2d2_u24lambda_u2d1, "optJSONArray(SEARCH_VIDEO_TRANS_IMAGE_EXCLUDES)");
            SearchPreferenceUtils.getInstance().putString(VideoTransConfigListenerKt.SEARCH_VIDEO_TRANS_IMAGE_EXCLUDES, $this$executeCommand_u24lambda_u2d2_u24lambda_u2d1.toString());
        }
        CharSequence charSequence = actionData.version;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (!z) {
            SearchPreferenceUtils.getInstance().putString("search_video_trans_config_version", actionData.version);
        }
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = SearchPreferenceUtils.getInstance().getString("search_video_trans_config_version", "0");
        return string == null ? "0" : string;
    }
}
