package com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic;

import com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "canScrollHorizontally", "", "hitHotRect", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselPicComponent.kt */
final class CarouselPicComponent$initCarouselPicView$1$24 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ CarouselPicView $this_apply;
    final /* synthetic */ CarouselPicComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselPicComponent$initCarouselPicView$1$24(CarouselPicView carouselPicView, CarouselPicComponent carouselPicComponent) {
        super(2);
        this.$this_apply = carouselPicView;
        this.this$0 = carouselPicComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean canScrollHorizontally, boolean hitHotRect) {
        if ((!canScrollHorizontally && this.$this_apply.isLastPage()) || hitHotRect) {
            this.this$0.scrollLeftSlide(hitHotRect);
        }
    }
}
