package com.baidu.searchbox.taskapi.business.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskSdkBDPTaskWrapper.kt */
final class TaskSdkBDPTaskWrapper$taskCallback$1$onChanged$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TaskSdkData $taskSdkData;
    final /* synthetic */ TaskSdkBDPTaskWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskSdkBDPTaskWrapper$taskCallback$1$onChanged$5(TaskSdkBDPTaskWrapper taskSdkBDPTaskWrapper, TaskSdkData taskSdkData) {
        super(0);
        this.this$0 = taskSdkBDPTaskWrapper;
        this.$taskSdkData = taskSdkData;
    }

    public final Unit invoke() {
        ISdkStatusCallback access$getStatusCallback$p = this.this$0.statusCallback;
        if (access$getStatusCallback$p == null) {
            return null;
        }
        access$getStatusCallback$p.onAllTaskIsFinish(this.$taskSdkData);
        return Unit.INSTANCE;
    }
}
