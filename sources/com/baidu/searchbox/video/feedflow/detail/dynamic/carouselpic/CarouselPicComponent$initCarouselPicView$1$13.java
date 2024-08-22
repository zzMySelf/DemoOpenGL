package com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic;

import com.baidu.searchbox.feed.detail.frame.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselPicComponent.kt */
final class CarouselPicComponent$initCarouselPicView$1$13 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CarouselPicComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselPicComponent$initCarouselPicView$1$13(CarouselPicComponent carouselPicComponent) {
        super(0);
        this.this$0 = carouselPicComponent;
    }

    public final void invoke() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(OnCarouselPicMultipleGestureEnd.INSTANCE);
        }
    }
}
