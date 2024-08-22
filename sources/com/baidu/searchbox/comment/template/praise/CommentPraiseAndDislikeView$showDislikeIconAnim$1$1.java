package com.baidu.searchbox.comment.template.praise;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentPraiseAndDislikeView.kt */
final class CommentPraiseAndDislikeView$showDislikeIconAnim$1$1 extends Lambda implements Function1<AnimatedDrawable2, Unit> {
    final /* synthetic */ CommentPraiseAndDislikeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommentPraiseAndDislikeView$showDislikeIconAnim$1$1(CommentPraiseAndDislikeView commentPraiseAndDislikeView) {
        super(1);
        this.this$0 = commentPraiseAndDislikeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AnimatedDrawable2) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedDrawable2 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.dislikeAnim = it;
    }
}
