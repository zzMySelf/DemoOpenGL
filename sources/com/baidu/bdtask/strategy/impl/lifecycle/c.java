package com.baidu.bdtask.strategy.impl.lifecycle;

import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.b;
import com.baidu.bdtask.framework.redux.d;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.response.TaskProcessData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/bdtask/strategy/impl/lifecycle/InitiativeLifecycleStrategy;", "Lcom/baidu/bdtask/strategy/impl/lifecycle/BaseLifecycleStrategy;", "store", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "(Lcom/baidu/bdtask/framework/redux/Store;)V", "onFinished", "", "subState", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class c extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d<b, com.baidu.bdtask.ctrl.c> dVar) {
        super(dVar);
        Intrinsics.checkParameterIsNotNull(dVar, "store");
    }

    public void h(SubTaskState subTaskState) {
        Intrinsics.checkParameterIsNotNull(subTaskState, "subState");
        super.h(subTaskState);
        if (!k(subTaskState)) {
            subTaskState.setFinishedRequestingStatus(false);
            l(subTaskState);
            TaskProcessData processData = a(subTaskState).getResponse().getProcessData();
            DebugTrace.INSTANCE.debug((Function0<String>) new InitiativeLifecycleStrategy$onFinished$1(processData));
            if (processData.isDone()) {
                BDPTask.INSTANCE.unregisterTaskWithActionId(a(subTaskState).getActionId());
                return;
            }
            SubTaskState b2 = a().b(a(subTaskState).getSingleKey());
            if (b2 != null) {
                b2.reset2Running(false);
            }
        }
    }
}
