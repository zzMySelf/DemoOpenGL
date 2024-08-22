package com.baidu.searchbox.video.feedflow.detail.graphicgenre.pic;

import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.ICarouselPicClipService;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "whRatio", "", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "invoke", "(FLcom/facebook/drawee/view/SimpleDraweeView;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicPicComponent.kt */
final class GraphicPicComponent$initCarouselPicView$1$9 extends Lambda implements Function2<Float, SimpleDraweeView, Boolean> {
    final /* synthetic */ GraphicPicComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphicPicComponent$initCarouselPicView$1$9(GraphicPicComponent graphicPicComponent) {
        super(2);
        this.this$0 = graphicPicComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke(((Number) p1).floatValue(), (SimpleDraweeView) p2);
    }

    public final Boolean invoke(float whRatio, SimpleDraweeView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        ICarouselPicClipService iCarouselPicClipService = (ICarouselPicClipService) this.this$0.getManager().getService(ICarouselPicClipService.class);
        boolean z = true;
        if (iCarouselPicClipService == null || !iCarouselPicClipService.clipPic(whRatio, imageView)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
