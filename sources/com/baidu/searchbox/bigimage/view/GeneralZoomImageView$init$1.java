package com.baidu.searchbox.bigimage.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "dx", "", "dy", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GeneralZoomImageView.kt */
final class GeneralZoomImageView$init$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ GeneralZoomImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GeneralZoomImageView$init$1(GeneralZoomImageView generalZoomImageView) {
        super(2);
        this.this$0 = generalZoomImageView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Number) p1).intValue(), ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int dx, int dy) {
        if (this.this$0.flingEnable) {
            this.this$0.scrollBy(-dx, -dy);
        }
    }
}
