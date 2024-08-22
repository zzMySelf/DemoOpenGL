package com.baidu.searchbox.video.feedflow.ad.author;

import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadTopAuthorComponent.kt */
final class NadTopAuthorComponent$authorView$2 extends Lambda implements Function0<NadTopAuthorView> {
    final /* synthetic */ NadTopAuthorComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadTopAuthorComponent$authorView$2(NadTopAuthorComponent nadTopAuthorComponent) {
        super(0);
        this.this$0 = nadTopAuthorComponent;
    }

    public final NadTopAuthorView invoke() {
        NadTopAuthorView $this$invoke_u24lambda_u2d0 = new NadTopAuthorView(this.this$0.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$invoke_u24lambda_u2d0.registerActionListener(new NadTopAuthorComponent$authorView$2$1$1(this.this$0));
        return $this$invoke_u24lambda_u2d0;
    }
}
