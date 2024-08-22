package com.baidu.bdtask.ctrl.actions.dotask.visit;

import com.baidu.bdtask.callbacks.TaskCallback;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.b;
import com.baidu.bdtask.framework.redux.a;
import com.baidu.bdtask.framework.utils.DebugTrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aH\u00122\u00120\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00010\u000124\u0010\t\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "Lkotlin/ParameterName;", "name", "action", "", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", "dispatch", "<anonymous parameter 0>", "getState", "Lkotlin/Function0;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "invoke"}, k = 3, mv = {1, 1, 9})
final class TaskExecVisitMiddleware$taskExecVisitMiddleWare$1 extends Lambda implements Function2<Function1<? super a, ? extends Unit>, Function0<? extends b>, Function1<? super Function1<? super a, ? extends Unit>, ? extends Function1<? super a, ? extends Unit>>> {
    public static final TaskExecVisitMiddleware$taskExecVisitMiddleWare$1 INSTANCE = new TaskExecVisitMiddleware$taskExecVisitMiddleWare$1();

    TaskExecVisitMiddleware$taskExecVisitMiddleWare$1() {
        super(2);
    }

    public final Function1<Function1<? super a, Unit>, Function1<a, Unit>> invoke(Function1<? super a, Unit> $noName_0, final Function0<b> getState) {
        Intrinsics.checkParameterIsNotNull($noName_0, "<anonymous parameter 0>");
        Intrinsics.checkParameterIsNotNull(getState, "getState");
        return new Function1<Function1<? super a, ? extends Unit>, Function1<? super a, ? extends Unit>>() {
            public final Function1<a, Unit> invoke(final Function1<? super a, Unit> next) {
                Intrinsics.checkParameterIsNotNull(next, "next");
                return new Function1<a, Unit>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((a) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(a action) {
                        SubTaskState b2;
                        Intrinsics.checkParameterIsNotNull(action, "action");
                        if (((a) (!(action instanceof a) ? null : action)) != null) {
                            b bVar = (b) getState.invoke();
                            if (bVar != null && (b2 = bVar.b(((a) action).c())) != null) {
                                if (!b2.getTaskStatus().isEnable()) {
                                    DebugTrace.debug$default(DebugTrace.INSTANCE, "task is not enable", "state", (Function0) null, 4, (Object) null);
                                    Function1 function1 = next;
                                    a aVar = (a) action;
                                    aVar.a(305);
                                    aVar.a(TaskCallback.ERROR_NO_TASK_INVALID_ERROR_MSG);
                                    function1.invoke(action);
                                    return;
                                }
                                next.invoke(action);
                                return;
                            }
                            return;
                        }
                        Unit unit = (Unit) next.invoke(action);
                    }
                };
            }
        };
    }
}
