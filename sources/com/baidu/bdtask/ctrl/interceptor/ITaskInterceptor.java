package com.baidu.bdtask.ctrl.interceptor;

import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.framework.ui.toast.ToastLayoutParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&¨\u0006\r"}, d2 = {"Lcom/baidu/bdtask/ctrl/interceptor/ITaskInterceptor;", "", "getFinishedToastLayoutParams", "Lcom/baidu/bdtask/framework/ui/toast/ToastLayoutParams;", "getRegisteredToastLayoutParams", "onComplete", "", "taskState", "Lcom/baidu/bdtask/TaskState;", "nextAction", "Lkotlin/Function0;", "onFinished", "onRegistered", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 9})
public interface ITaskInterceptor {
    ToastLayoutParams getFinishedToastLayoutParams();

    ToastLayoutParams getRegisteredToastLayoutParams();

    void onComplete(TaskState taskState, Function0<Unit> function0);

    void onFinished(TaskState taskState, Function0<Unit> function0);

    void onRegistered(TaskState taskState, Function0<Unit> function0);
}
