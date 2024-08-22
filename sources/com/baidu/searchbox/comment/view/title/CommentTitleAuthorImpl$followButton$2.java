package com.baidu.searchbox.comment.view.title;

import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.template.follow.CommentFollowView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/comment/template/follow/CommentFollowView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentTitleAuthorImpl.kt */
final class CommentTitleAuthorImpl$followButton$2 extends Lambda implements Function0<CommentFollowView> {
    final /* synthetic */ CommentTitleAuthorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommentTitleAuthorImpl$followButton$2(CommentTitleAuthorImpl commentTitleAuthorImpl) {
        super(0);
        this.this$0 = commentTitleAuthorImpl;
    }

    public final CommentFollowView invoke() {
        return (CommentFollowView) this.this$0.findViewById(R.id.comment_follow_layout);
    }
}
