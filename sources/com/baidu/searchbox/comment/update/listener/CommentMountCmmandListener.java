package com.baidu.searchbox.comment.update.listener;

import android.content.Context;
import com.baidu.searchbox.comment.sp.CommentSpUtils;
import com.baidu.searchbox.comment.util.CommentLogUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J&\u0010\u0012\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/comment/update/listener/CommentMountCmmandListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "ctx", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "moudle", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentMountCmmandListener.kt */
public final class CommentMountCmmandListener extends JSONObjectCommandListener {
    public void addPostData(Context ctx, String module, String action, CommandPostData postData) {
        CharSequence charSequence = module;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = action;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z && postData != null) {
                postData.getVersion().put("mount", getLocalVersion(ctx, module, action));
            }
        }
    }

    public boolean executeCommand(Context ctx, String moudle, String action, ActionData<JSONObject> value) {
        CharSequence charSequence = moudle;
        if (!(charSequence == null || charSequence.length() == 0) && Intrinsics.areEqual((Object) action, (Object) "mount")) {
            if ((value != null ? (JSONObject) value.data : null) != null) {
                if (Intrinsics.areEqual((Object) value.version, (Object) getLocalVersion(ctx, moudle, action))) {
                    CommentLogUtils.d("CommentMountCmmandListener", "版本号一致，不处理评论挂载配置ccs");
                    return false;
                }
                CommentSpUtils.setStringPreference(CommentMountCmmandListenerKt.KEY_COMMENT_MOUNT_VERSION, value.version);
                String forceShowType = ((JSONObject) value.data).optString("force_show_search_rec", "0");
                CommentSpUtils.setStringPreference(CommentMountCmmandListenerKt.SP_FORCE_SHOW_SEARCH_REC, forceShowType);
                CommentLogUtils.d("CommentMountCmmandListener", "ccs配置设置强制展示评论标题区 talos lite 卡片类型: " + forceShowType);
                return true;
            }
        }
        return false;
    }

    public String getLocalVersion(Context ctx, String module, String action) {
        String stringPreference = CommentSpUtils.getStringPreference(CommentMountCmmandListenerKt.KEY_COMMENT_MOUNT_VERSION, "0");
        Intrinsics.checkNotNullExpressionValue(stringPreference, "getStringPreference(KEY_…VERSION, DEFAULT_VERSION)");
        return stringPreference;
    }
}
