package com.baidu.searchbox.comment.video;

import com.baidu.searchbox.comment.definition.BDCommentRequestCallback;
import com.baidu.searchbox.comment.model.CommentVideoAuthModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "result", "Lcom/baidu/searchbox/comment/model/CommentVideoAuthModel;", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "", "onCompleted"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentUploadVideoManager.kt */
final class CommentUploadVideoManager$fetchVideoAuth$2$1<T> implements BDCommentRequestCallback {
    final /* synthetic */ CancellableContinuation<CommentVideoAuthModel> $cancellableContinuation;

    CommentUploadVideoManager$fetchVideoAuth$2$1(CancellableContinuation<? super CommentVideoAuthModel> cancellableContinuation) {
        this.$cancellableContinuation = cancellableContinuation;
    }

    public final void onCompleted(int i2, CommentVideoAuthModel result, String str) {
        if (result == null || !result.isValid()) {
            Result.Companion companion = Result.Companion;
            this.$cancellableContinuation.resumeWith(Result.m8971constructorimpl((Object) null));
            return;
        }
        Result.Companion companion2 = Result.Companion;
        this.$cancellableContinuation.resumeWith(Result.m8971constructorimpl(result));
    }
}
