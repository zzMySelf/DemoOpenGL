package com.baidu.searchbox.comment.commentlist.templateview;

import com.baidu.searchbox.comment.definition.CommentChangeCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/comment/commentlist/templateview/CommentHeaderTitleView$onSetBusinessManager$1", "Lcom/baidu/searchbox/comment/definition/CommentChangeCallback;", "onCommentCountChange", "", "totalCount", "", "onExistValidComment", "exist", "", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentHeaderTitleView.kt */
public final class CommentHeaderTitleView$onSetBusinessManager$1 implements CommentChangeCallback {
    final /* synthetic */ CommentHeaderTitleView this$0;

    CommentHeaderTitleView$onSetBusinessManager$1(CommentHeaderTitleView $receiver) {
        this.this$0 = $receiver;
    }

    public void onCommentCountChange(int totalCount) {
        this.this$0.commentCount = totalCount >= 0 ? totalCount : 0;
    }

    public void onExistValidComment(boolean exist) {
        this.this$0.existValidComment = exist;
        this.this$0.updateHeaderSwitcherVisibility(exist);
    }
}
