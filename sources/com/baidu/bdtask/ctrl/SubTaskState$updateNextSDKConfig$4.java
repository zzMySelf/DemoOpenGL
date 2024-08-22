package com.baidu.bdtask.ctrl;

import com.baidu.bdtask.model.response.NextTaskRule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class SubTaskState$updateNextSDKConfig$4 extends Lambda implements Function0<String> {
    final /* synthetic */ NextTaskRule $rule;
    final /* synthetic */ SubTaskState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubTaskState$updateNextSDKConfig$4(SubTaskState subTaskState, NextTaskRule nextTaskRule) {
        super(0);
        this.this$0 = subTaskState;
        this.$rule = nextTaskRule;
    }

    public final String invoke() {
        return "stay rule is replaced: old stay rule " + this.this$0.getTaskInfo().getTaskRule().getStay() + " => new stay rule:" + (this.$rule.getStay() * 1000);
    }
}
