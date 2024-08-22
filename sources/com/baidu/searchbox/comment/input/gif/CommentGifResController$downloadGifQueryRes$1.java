package com.baidu.searchbox.comment.input.gif;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.comment.BDCommentInputController;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.util.CommentUtilsExtensionsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/comment/input/gif/CommentGifResController$downloadGifQueryRes$1", "Lcom/baidu/searchbox/comment/input/gif/GifQueryCallback;", "onCancel", "", "onFailure", "onSuccess", "gifFile", "Ljava/io/File;", "callbackInfo", "Lcom/baidu/searchbox/comment/input/gif/CallbackInfo;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentGifResController.kt */
public final class CommentGifResController$downloadGifQueryRes$1 implements GifQueryCallback {
    final /* synthetic */ GifDownloadListener $downloadListener;
    final /* synthetic */ CommentGifResController this$0;

    CommentGifResController$downloadGifQueryRes$1(CommentGifResController $receiver, GifDownloadListener $downloadListener2) {
        this.this$0 = $receiver;
        this.$downloadListener = $downloadListener2;
    }

    public void onSuccess(File gifFile, CallbackInfo callbackInfo) {
        UiThreadUtils.runOnUiThread(new CommentGifResController$downloadGifQueryRes$1$$ExternalSyntheticLambda2(this.this$0, gifFile, this.$downloadListener, callbackInfo));
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m16819onSuccess$lambda0(CommentGifResController this$02, File $gifFile, GifDownloadListener $downloadListener2, CallbackInfo $callbackInfo) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.inputPicUploadPath = $gifFile != null ? $gifFile.getPath() : null;
        this$02.gifQueryResDownloading = false;
        this$02.gifQueryResReady = true;
        if ($downloadListener2 != null) {
            $downloadListener2.onDownLoadSuccess($gifFile, $callbackInfo);
        }
    }

    public void onFailure() {
        UiThreadUtils.runOnUiThread(new CommentGifResController$downloadGifQueryRes$1$$ExternalSyntheticLambda1(this.this$0, this.$downloadListener));
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1  reason: not valid java name */
    public static final void m16818onFailure$lambda1(CommentGifResController this$02, GifDownloadListener $downloadListener2) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.gifQueryResDownloading = false;
        this$02.gifQueryResReady = false;
        if ($downloadListener2 != null) {
            $downloadListener2.onDownloadFail();
        }
    }

    public void onCancel() {
        UiThreadUtils.runOnUiThread(new CommentGifResController$downloadGifQueryRes$1$$ExternalSyntheticLambda0(this.this$0, this.$downloadListener, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCancel$lambda-2  reason: not valid java name */
    public static final void m16817onCancel$lambda2(CommentGifResController this$02, GifDownloadListener $downloadListener2, CommentGifResController$downloadGifQueryRes$1 this$1) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        this$02.gifQueryResDownloading = false;
        this$02.gifQueryResReady = false;
        if ($downloadListener2 != null) {
            $downloadListener2.onDownloadFail();
        }
        if (BDCommentInputController.isSendingComment()) {
            CommentUtilsExtensionsKt.showToastRes$default(this$1, R.string.bdcomment_send_error_tip, 0, 2, (Object) null);
            CommentGifResControllerCallback callback = this$02.getCallback();
            if (callback != null) {
                callback.onSendFail();
            }
        }
    }
}
