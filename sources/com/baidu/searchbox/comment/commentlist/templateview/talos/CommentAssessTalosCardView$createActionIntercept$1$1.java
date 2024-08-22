package com.baidu.searchbox.comment.commentlist.templateview.talos;

import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.talos.lite.ITalosLiteActionInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/comment/commentlist/templateview/talos/CommentAssessTalosCardView$createActionIntercept$1$1", "Lcom/baidu/searchbox/talos/lite/ITalosLiteActionInterceptor;", "onIntercept", "", "paramsJson", "Lorg/json/JSONObject;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentAssessTalosCardView.kt */
public final class CommentAssessTalosCardView$createActionIntercept$1$1 implements ITalosLiteActionInterceptor {
    final /* synthetic */ CommentAssessTalosCardView this$0;

    CommentAssessTalosCardView$createActionIntercept$1$1(CommentAssessTalosCardView $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onIntercept(JSONObject paramsJson) {
        if (paramsJson != null) {
            CommentAssessTalosCardView commentAssessTalosCardView = this.this$0;
            JSONObject args = paramsJson.optJSONObject("args");
            if (Intrinsics.areEqual((Object) args != null ? args.optString("name") : null, (Object) "commentAgileClose")) {
                JSONObject params = args.optJSONObject("params");
                boolean z = false;
                if (params != null && params.optBoolean("isSelected")) {
                    DefaultSharedPrefsWrapper.getInstance().putInt("assess_close", 0);
                } else {
                    int nowTime = DefaultSharedPrefsWrapper.getInstance().getInt("assess_close", 0) + 1;
                    String access$getQuit$p = commentAssessTalosCardView.quit;
                    if (access$getQuit$p != null && nowTime == Integer.parseInt(access$getQuit$p)) {
                        z = true;
                    }
                    if (z) {
                        DefaultSharedPrefsWrapper.getInstance().putLong("assess_quit", System.currentTimeMillis());
                    }
                    DefaultSharedPrefsWrapper.getInstance().putInt("assess_close", nowTime);
                }
                commentAssessTalosCardView.closeItemView();
            }
        }
        return true;
    }
}
