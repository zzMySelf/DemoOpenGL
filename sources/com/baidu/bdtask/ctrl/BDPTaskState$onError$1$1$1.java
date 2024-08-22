package com.baidu.bdtask.ctrl;

import com.baidu.bdtask.callbacks.TaskCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class BDPTaskState$onError$1$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ TaskCallback $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BDPTaskState$onError$1$1$1(TaskCallback taskCallback) {
        super(0);
        this.$it = taskCallback;
    }

    public final String invoke() {
        return "BDPTaskState:onError:callback:" + this.$it;
    }
}
