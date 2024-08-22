package com.baidu.bdtask.ctrl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class SubTaskState$cleanAllCallbacks$$inlined$withLock$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ SubTaskState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubTaskState$cleanAllCallbacks$$inlined$withLock$lambda$1(SubTaskState subTaskState) {
        super(0);
        this.this$0 = subTaskState;
    }

    public final String invoke() {
        return "clean " + this.this$0.getTaskInfo().getActionId() + " callbacks:" + this.this$0.callbacks.size() + " weakCallbacks:" + this.this$0.weakCallbacks.size();
    }
}
