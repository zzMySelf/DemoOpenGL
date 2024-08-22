package com.baidu.searchbox.comment.template.image;

import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.view.CommentGIFView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/comment/view/CommentGIFView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentImageView.kt */
final class CommentImageView$gifView$2 extends Lambda implements Function0<CommentGIFView> {
    final /* synthetic */ CommentImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommentImageView$gifView$2(CommentImageView commentImageView) {
        super(0);
        this.this$0 = commentImageView;
    }

    public final CommentGIFView invoke() {
        return (CommentGIFView) this.this$0.findViewById(R.id.comment_image_view);
    }
}
