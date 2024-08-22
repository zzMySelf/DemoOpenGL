package com.baidu.searchbox.video.feedflow.detail.graphicgenre.pic;

import com.baidu.searchbox.feed.detail.frame.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isStarted", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicPicComponent.kt */
final class GraphicPicComponent$initCarouselPicView$1$10 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ GraphicPicComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphicPicComponent$initCarouselPicView$1$10(GraphicPicComponent graphicPicComponent) {
        super(1);
        this.this$0 = graphicPicComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isStarted) {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new OnGraphicPicRefreshStateChangedAction(isStarted));
        }
    }
}
