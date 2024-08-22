package com.baidu.bdtask;

import com.baidu.bdtask.event.TaskBusinessEventCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 1, 9})
final class BDPTask$INSTANCE$registerTaskBusinessEventListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $actionId;
    final /* synthetic */ TaskBusinessEventCallback $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BDPTask$INSTANCE$registerTaskBusinessEventListener$1(String str, TaskBusinessEventCallback taskBusinessEventCallback) {
        super(0);
        this.$actionId = str;
        this.$callback = taskBusinessEventCallback;
    }

    public final Unit invoke() {
        BDPTask access$getInstance$p = BDPTask.INSTANCE.getInstance();
        if (access$getInstance$p == null) {
            return null;
        }
        access$getInstance$p.registerTaskBusinessEventListener(this.$actionId, this.$callback);
        return Unit.INSTANCE;
    }
}
