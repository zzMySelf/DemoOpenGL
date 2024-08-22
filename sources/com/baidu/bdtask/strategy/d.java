package com.baidu.bdtask.strategy;

import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.strategy.impl.lifecycle.b;
import com.baidu.bdtask.strategy.impl.lifecycle.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/bdtask/strategy/LifecycleStrategyImpl;", "Lcom/baidu/bdtask/strategy/ILifecycleStrategy;", "store", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "(Lcom/baidu/bdtask/framework/redux/Store;)V", "daemonLifecycleStrategy", "Lcom/baidu/bdtask/strategy/impl/lifecycle/DaemonLifecycleStrategy;", "initiativeLifecycleStrategy", "Lcom/baidu/bdtask/strategy/impl/lifecycle/InitiativeLifecycleStrategy;", "passiveLifecycleStrategy", "Lcom/baidu/bdtask/strategy/impl/lifecycle/PassiveLifecycleStrategy;", "getTaskInfo", "Lcom/baidu/bdtask/model/info/TaskInfo;", "subState", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "onFinished", "", "onRegistered", "onRunning", "onSilenceRegistered", "onTaskInterrupted", "onUnRegistered", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11007a = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final c f11008b;

    /* renamed from: c  reason: collision with root package name */
    private final com.baidu.bdtask.strategy.impl.lifecycle.d f11009c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11010d;

    /* renamed from: e  reason: collision with root package name */
    private final com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, com.baidu.bdtask.ctrl.c> f11011e;

    private d(com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, com.baidu.bdtask.ctrl.c> dVar) {
        this.f11011e = dVar;
        this.f11008b = new c(dVar);
        this.f11009c = new com.baidu.bdtask.strategy.impl.lifecycle.d(dVar);
        this.f11010d = new b(dVar);
    }

    public /* synthetic */ d(com.baidu.bdtask.framework.redux.d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/bdtask/strategy/LifecycleStrategyImpl$Companion;", "", "()V", "with", "Lcom/baidu/bdtask/strategy/LifecycleStrategyImpl;", "store", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a(com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, com.baidu.bdtask.ctrl.c> dVar) {
            Intrinsics.checkParameterIsNotNull(dVar, "store");
            return new d(dVar, (DefaultConstructorMarker) null);
        }
    }

    public void a(SubTaskState subTaskState) {
        Intrinsics.checkParameterIsNotNull(subTaskState, "subState");
        if (g(subTaskState).isPassiveTask()) {
            this.f11009c.e(subTaskState);
        } else if (g(subTaskState).isInitiActiveTask()) {
            this.f11008b.e(subTaskState);
        } else if (g(subTaskState).isDaemonTask()) {
            this.f11010d.e(subTaskState);
        }
    }

    public void b(SubTaskState subTaskState) {
        Intrinsics.checkParameterIsNotNull(subTaskState, "subState");
        if (g(subTaskState).isPassiveTask()) {
            this.f11009c.g(subTaskState);
        } else if (g(subTaskState).isInitiActiveTask()) {
            this.f11008b.g(subTaskState);
        } else if (g(subTaskState).isDaemonTask()) {
            this.f11010d.g(subTaskState);
        }
    }

    public void c(SubTaskState subTaskState) {
        Intrinsics.checkParameterIsNotNull(subTaskState, "subState");
        if (g(subTaskState).isPassiveTask()) {
            this.f11009c.h(subTaskState);
        } else if (g(subTaskState).isInitiActiveTask()) {
            this.f11008b.h(subTaskState);
        } else if (g(subTaskState).isDaemonTask()) {
            this.f11010d.h(subTaskState);
        }
    }

    public void d(SubTaskState subTaskState) {
        Intrinsics.checkParameterIsNotNull(subTaskState, "subState");
        if (g(subTaskState).isPassiveTask()) {
            this.f11009c.i(subTaskState);
        } else if (g(subTaskState).isInitiActiveTask()) {
            this.f11008b.i(subTaskState);
        } else if (g(subTaskState).isDaemonTask()) {
            this.f11010d.i(subTaskState);
        }
    }

    public void e(SubTaskState subTaskState) {
        Intrinsics.checkParameterIsNotNull(subTaskState, "subState");
        if (g(subTaskState).isPassiveTask()) {
            this.f11009c.j(subTaskState);
        } else if (g(subTaskState).isInitiActiveTask()) {
            this.f11008b.j(subTaskState);
        } else if (g(subTaskState).isDaemonTask()) {
            this.f11010d.j(subTaskState);
        }
    }

    public void f(SubTaskState subTaskState) {
        Intrinsics.checkParameterIsNotNull(subTaskState, "subState");
        if (g(subTaskState).isPassiveTask()) {
            this.f11009c.f(subTaskState);
        } else if (g(subTaskState).isInitiActiveTask()) {
            this.f11008b.f(subTaskState);
        } else if (g(subTaskState).isDaemonTask()) {
            this.f11010d.f(subTaskState);
        }
    }

    private final TaskInfo g(SubTaskState subTaskState) {
        return subTaskState.getTaskInfo();
    }
}
