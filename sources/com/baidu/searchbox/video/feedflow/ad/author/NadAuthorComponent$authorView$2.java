package com.baidu.searchbox.video.feedflow.ad.author;

import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/ad/author/NadAuthorView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadAuthorComponent.kt */
final class NadAuthorComponent$authorView$2 extends Lambda implements Function0<NadAuthorView> {
    final /* synthetic */ NadAuthorComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadAuthorComponent$authorView$2(NadAuthorComponent nadAuthorComponent) {
        super(0);
        this.this$0 = nadAuthorComponent;
    }

    public final NadAuthorView invoke() {
        return new NadAuthorView(this.this$0.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }
}
