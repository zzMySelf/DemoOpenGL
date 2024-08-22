package com.baidu.searchbox.video.feedflow.flow.task;

import com.baidu.searchbox.video.feedflow.tab.wealth.service.IWealthTaskService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowTaskOperationPlugin.kt */
final class FlowTaskOperationPlugin$taskStatusCallback$1$onTaskRunning$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FlowTaskOperationPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowTaskOperationPlugin$taskStatusCallback$1$onTaskRunning$1(FlowTaskOperationPlugin flowTaskOperationPlugin) {
        super(0);
        this.this$0 = flowTaskOperationPlugin;
    }

    public final void invoke() {
        IWealthTaskService $this$invoke_u24lambda_u2d0 = (IWealthTaskService) this.this$0.getManager().getService(IWealthTaskService.class);
        if ($this$invoke_u24lambda_u2d0 != null) {
            FlowTaskOperationPlugin flowTaskOperationPlugin = this.this$0;
            if ($this$invoke_u24lambda_u2d0.isWealthTaskComponentShowing() && !flowTaskOperationPlugin.mutualFlowTask(true)) {
                $this$invoke_u24lambda_u2d0.cancelWealthVideoTask();
            }
        }
    }
}
