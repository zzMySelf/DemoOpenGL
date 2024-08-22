package com.baidu.searchbox.comment.input.aiimage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.definition.OnLoginStatusListener;
import com.baidu.searchbox.comment.util.CommentUtilsExtensionsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/comment/input/aiimage/AiPicViewModel$getAiPic$1", "Lcom/baidu/searchbox/comment/definition/OnLoginStatusListener;", "loginEventSuccess", "", "loginFail", "loginSuccess", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPicViewModel.kt */
public final class AiPicViewModel$getAiPic$1 implements OnLoginStatusListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $isH5;
    final /* synthetic */ String $opType;
    final /* synthetic */ String $prompt;
    final /* synthetic */ AiPicViewModel this$0;

    AiPicViewModel$getAiPic$1(String $opType2, AiPicViewModel $receiver, Context $context2, String $prompt2, String $isH52) {
        this.$opType = $opType2;
        this.this$0 = $receiver;
        this.$context = $context2;
        this.$prompt = $prompt2;
        this.$isH5 = $isH52;
    }

    public void loginEventSuccess() {
        if (TextUtils.equals(this.$opType, AiGeneratePicModule.CHECK_TIMES)) {
            this.this$0.checkAiPicRemainedTimes(this.$context, this.$prompt, this.$opType, this.$isH5);
        } else {
            this.this$0.getAfterLoginAiPic(this.$context, this.$prompt, this.$opType, this.$isH5);
        }
    }

    public void loginSuccess() {
        if (TextUtils.equals(this.$opType, AiGeneratePicModule.CHECK_TIMES)) {
            this.this$0.checkAiPicRemainedTimes(this.$context, this.$prompt, this.$opType, this.$isH5);
        } else {
            this.this$0.getAfterLoginAiPic(this.$context, this.$prompt, this.$opType, this.$isH5);
        }
    }

    public void loginFail() {
        CommentUtilsExtensionsKt.showToastRes$default(this, R.string.comment_erniebot_login_failure_toast, 0, 2, (Object) null);
    }
}
