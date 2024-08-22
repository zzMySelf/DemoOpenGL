package com.baidu.searchbox.video.feedflow.flow.list;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/flow/list/FlowListAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowComponent.kt */
final class FlowComponent$adapter$2 extends Lambda implements Function0<FlowListAdapter> {
    final /* synthetic */ FlowComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowComponent$adapter$2(FlowComponent flowComponent) {
        super(0);
        this.this$0 = flowComponent;
    }

    public final FlowListAdapter invoke() {
        FlowListAdapter $this$invoke_u24lambda_u2d0 = this.this$0.getListAdapter();
        $this$invoke_u24lambda_u2d0.registerAdapterDataObserver(new FlowComponent$adapter$2$1$1(this.this$0));
        return $this$invoke_u24lambda_u2d0;
    }
}
