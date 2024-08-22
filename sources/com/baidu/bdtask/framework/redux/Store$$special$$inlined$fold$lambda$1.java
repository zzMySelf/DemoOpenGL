package com.baidu.bdtask.framework.redux;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "State", "Lcom/baidu/bdtask/framework/redux/StateType;", "AT", "Lcom/baidu/bdtask/framework/redux/Action;", "action", "invoke"}, k = 3, mv = {1, 1, 9})
final class Store$$special$$inlined$fold$lambda$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ d this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Store$$special$$inlined$fold$lambda$1(d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(a action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        this.this$0.a(action);
    }
}
