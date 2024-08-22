package com.baidu.searchbox.comment.template.additionInfo;

import com.baidu.searchbox.comment.model.CommentModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/comment/template/additionInfo/CommentAdditionInfoCallback;", "", "onReplyClick", "", "onSourceClick", "origin", "Lcom/baidu/searchbox/comment/model/CommentModel$CommentOrigin;", "onTitleExtensionSourceClick", "scheme", "", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentAdditionInfoCallback.kt */
public interface CommentAdditionInfoCallback {
    void onReplyClick();

    void onSourceClick(CommentModel.CommentOrigin commentOrigin);

    void onTitleExtensionSourceClick(String str);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommentAdditionInfoCallback.kt */
    public static final class DefaultImpls {
        public static void onReplyClick(CommentAdditionInfoCallback commentAdditionInfoCallback) {
        }

        public static void onSourceClick(CommentAdditionInfoCallback commentAdditionInfoCallback, CommentModel.CommentOrigin origin) {
        }

        public static void onTitleExtensionSourceClick(CommentAdditionInfoCallback commentAdditionInfoCallback, String scheme) {
        }
    }
}
