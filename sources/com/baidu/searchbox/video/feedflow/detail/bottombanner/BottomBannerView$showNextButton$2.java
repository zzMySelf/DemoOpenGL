package com.baidu.searchbox.video.feedflow.detail.bottombanner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "alpha", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBannerView.kt */
final class BottomBannerView$showNextButton$2 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ BottomBannerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomBannerView$showNextButton$2(BottomBannerView bottomBannerView) {
        super(1);
        this.this$0 = bottomBannerView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float alpha) {
        this.this$0.tvNext.setAlpha(alpha);
    }
}
