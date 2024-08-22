package com.mars.united.core.util.scheduler;

import com.mars.united.core.util.scheduler.BaseTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/mars/united/core/util/scheduler/BaseTask$TaskResult;", "<anonymous parameter 1>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class BaseTask$observerTaskResult$1 extends Lambda implements Function2<BaseTask.TaskResult, Object, Unit> {
    public static final BaseTask$observerTaskResult$1 INSTANCE = new BaseTask$observerTaskResult$1();

    public BaseTask$observerTaskResult$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((BaseTask.TaskResult) obj, obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BaseTask.TaskResult taskResult, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(taskResult, "$noName_0");
    }
}
