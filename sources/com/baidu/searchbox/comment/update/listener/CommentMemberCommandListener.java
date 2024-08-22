package com.baidu.searchbox.comment.update.listener;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J(\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/comment/update/listener/CommentMemberCommandListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentMemberCommandListener.kt */
public final class CommentMemberCommandListener extends JSONObjectCommandListener {
    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        CharSequence charSequence = module;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = action;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z && postData != null) {
                postData.getVersion().put(CommentMemberCommandListenerKt.COMMENT_MEMBER_ACTION, getLocalVersion(context, module, action));
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        CharSequence charSequence = module;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = action;
            if ((charSequence2 == null || charSequence2.length() == 0) || !TextUtils.equals(CommentMemberCommandListenerKt.COMMENT_MEMBER_ACTION, action) || value == null || value.data == null || TextUtils.equals(getLocalVersion(context, module, action), value.version)) {
                return false;
            }
            DefaultSharedPrefsWrapper.getInstance().putString("key_comment_input_version", value.version);
            DefaultSharedPrefsWrapper.getInstance().putInt(CommentMemberCommandListenerKt.KEY_COMMENT_MEMBER_COUNT, ((JSONObject) value.data).optInt("count"));
            return true;
        }
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return DefaultSharedPrefsWrapper.getInstance().getString("key_comment_input_version", "0");
    }
}
