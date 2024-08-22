package com.baidu.searchbox.video.feedflow.ad.tailframe;

import com.baidu.searchbox.ad.tailframe.ITailActionListener;
import com.baidu.searchbox.feed.template.appdownload.NadRectCommandBtnView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/feed/template/appdownload/NadRectCommandBtnView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoAdTailFrameView.kt */
final class FlowVideoAdTailFrameView$setNadRectButton$2 extends Lambda implements Function1<NadRectCommandBtnView, Unit> {
    final /* synthetic */ FlowVideoAdTailFrameView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowVideoAdTailFrameView$setNadRectButton$2(FlowVideoAdTailFrameView flowVideoAdTailFrameView) {
        super(1);
        this.this$0 = flowVideoAdTailFrameView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((NadRectCommandBtnView) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(NadRectCommandBtnView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ITailActionListener access$getActionListener$p = this.this$0.actionListener;
        if (access$getActionListener$p != null) {
            access$getActionListener$p.onCommandButtonClick("detailbtn");
        }
    }
}
