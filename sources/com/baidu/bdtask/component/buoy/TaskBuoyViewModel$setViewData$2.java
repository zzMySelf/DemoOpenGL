package com.baidu.bdtask.component.buoy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class TaskBuoyViewModel$setViewData$2 extends Lambda implements Function0<String> {
    final /* synthetic */ TaskBuoyViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskBuoyViewModel$setViewData$2(TaskBuoyViewModel taskBuoyViewModel) {
        super(0);
        this.this$0 = taskBuoyViewModel;
    }

    public final String invoke() {
        return "dispatch new process:" + this.this$0.getTaskProcessInfoLivingData().getValue() + " taskinfo:actionID:" + this.this$0.getTaskInfo().getActionId() + " actID:" + this.this$0.getTaskInfo().getActTaskId();
    }
}
