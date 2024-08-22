package com.baidu.bdtask;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class BDPTask$addActionWithActionId$1 extends Lambda implements Function0<String> {
    final /* synthetic */ TaskInfo $taskInfo;
    final /* synthetic */ TaskStatus $taskStatus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BDPTask$addActionWithActionId$1(TaskInfo taskInfo, TaskStatus taskStatus) {
        super(0);
        this.$taskInfo = taskInfo;
        this.$taskStatus = taskStatus;
    }

    public final String invoke() {
        return "addActionWithActionId:" + this.$taskInfo + ' ' + this.$taskStatus;
    }
}
