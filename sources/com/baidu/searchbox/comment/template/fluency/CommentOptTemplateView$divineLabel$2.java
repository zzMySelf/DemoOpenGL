package com.baidu.searchbox.comment.template.fluency;

import com.baidu.searchbox.comment.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentOptTemplateView.kt */
final class CommentOptTemplateView$divineLabel$2 extends Lambda implements Function0<SimpleDraweeView> {
    final /* synthetic */ CommentOptTemplateView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommentOptTemplateView$divineLabel$2(CommentOptTemplateView commentOptTemplateView) {
        super(0);
        this.this$0 = commentOptTemplateView;
    }

    public final SimpleDraweeView invoke() {
        return (SimpleDraweeView) this.this$0.findViewById(R.id.divine_comment_label);
    }
}
