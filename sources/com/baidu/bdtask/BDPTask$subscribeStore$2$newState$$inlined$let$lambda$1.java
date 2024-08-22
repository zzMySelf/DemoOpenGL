package com.baidu.bdtask;

import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.SubTaskState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class BDPTask$subscribeStore$2$newState$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SubTaskState $state$inlined;
    final /* synthetic */ BDPTask.a this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BDPTask$subscribeStore$2$newState$$inlined$let$lambda$1(BDPTask.a aVar, SubTaskState subTaskState) {
        super(0);
        this.this$0 = aVar;
        this.$state$inlined = subTaskState;
    }

    public final void invoke() {
        this.this$0.f10713a.dispatchState(this.$state$inlined);
    }
}
