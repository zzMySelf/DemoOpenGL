package com.baidu.searchbox.comment.template.follow;

import com.baidu.searchbox.follow.button.BdFollowButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/comment/template/follow/CommentFollowView$bindData$3", "Lcom/baidu/searchbox/follow/button/BdFollowButton$FollowStatusUpdateListener;", "onUpdate", "", "result", "Lcom/baidu/searchbox/follow/button/BdFollowButton$Result;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentFollowView.kt */
public final class CommentFollowView$bindData$3 implements BdFollowButton.FollowStatusUpdateListener {
    final /* synthetic */ CommentFollowView this$0;

    CommentFollowView$bindData$3(CommentFollowView $receiver) {
        this.this$0 = $receiver;
    }

    public void onUpdate(BdFollowButton.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.currentFollowState = result.isFollowed();
    }
}
