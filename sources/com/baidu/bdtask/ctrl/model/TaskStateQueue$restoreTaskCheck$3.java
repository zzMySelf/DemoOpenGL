package com.baidu.bdtask.ctrl.model;

import com.baidu.bdtask.model.info.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class TaskStateQueue$restoreTaskCheck$3 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.ObjectRef $errorMsg;
    final /* synthetic */ TaskInfo $taskInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskStateQueue$restoreTaskCheck$3(Ref.ObjectRef objectRef, TaskInfo taskInfo) {
        super(0);
        this.$errorMsg = objectRef;
        this.$taskInfo = taskInfo;
    }

    public final String invoke() {
        return "" + ((String) this.$errorMsg.element) + " task info :" + this.$taskInfo;
    }
}
