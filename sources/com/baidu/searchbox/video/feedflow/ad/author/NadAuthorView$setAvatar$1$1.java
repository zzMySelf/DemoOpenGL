package com.baidu.searchbox.video.feedflow.ad.author;

import com.baidu.searchbox.video.feedflow.ad.author.NadAuthorView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/facebook/drawee/view/SimpleDraweeView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadAuthorView.kt */
final class NadAuthorView$setAvatar$1$1 extends Lambda implements Function1<SimpleDraweeView, Unit> {
    final /* synthetic */ NadAuthorView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadAuthorView$setAvatar$1$1(NadAuthorView nadAuthorView) {
        super(1);
        this.this$0 = nadAuthorView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SimpleDraweeView) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SimpleDraweeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NadAuthorView.IActionListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onAvatarClick();
        }
    }
}
