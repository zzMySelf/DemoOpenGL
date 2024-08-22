package com.mars.united.core.util.scheduler;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001(B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010 \u001a\u00020\u0010J.\u0010!\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0018H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/mars/united/core/util/scheduler/BaseMultiTask;", "", "name", "", "initTasks", "", "Lcom/mars/united/core/util/scheduler/BaseMultiTask$ChildrenMultiTask;", "priority", "Lcom/mars/united/core/util/scheduler/ThreadPriority;", "createTime", "", "(Ljava/lang/String;Ljava/util/List;Lcom/mars/united/core/util/scheduler/ThreadPriority;J)V", "getCreateTime", "()J", "finishHandler", "Lkotlin/Function0;", "", "getFinishHandler", "()Lkotlin/jvm/functions/Function0;", "setFinishHandler", "(Lkotlin/jvm/functions/Function0;)V", "getInitTasks", "()Ljava/util/List;", "isCancelCallback", "", "setCancelCallback", "isCancelled", "()Z", "getName", "()Ljava/lang/String;", "getPriority", "()Lcom/mars/united/core/util/scheduler/ThreadPriority;", "finish", "handleTaskResult", "taskName", "resultCode", "Lcom/mars/united/core/util/scheduler/BaseTask$TaskResult;", "result", "onFinished", "isFromCancel", "ChildrenMultiTask", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BaseMultiTask {

    public static abstract class qw<T> extends BaseTask {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(@NotNull String str, int i2, long j) {
            super(str, i2, j);
            Intrinsics.checkNotNullParameter(str, "name");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public qw(@NotNull String str, int i2) {
            this(str, i2, System.currentTimeMillis());
            Intrinsics.checkNotNullParameter(str, "name");
        }
    }

    public BaseMultiTask(@NotNull String str, @NotNull List<? extends qw<?>> list, @NotNull ThreadPriority threadPriority, long j) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "initTasks");
        Intrinsics.checkNotNullParameter(threadPriority, "priority");
        BaseMultiTask$isCancelCallback$1 baseMultiTask$isCancelCallback$1 = BaseMultiTask$isCancelCallback$1.INSTANCE;
        BaseMultiTask$finishHandler$1 baseMultiTask$finishHandler$1 = BaseMultiTask$finishHandler$1.INSTANCE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseMultiTask(String str, List list, ThreadPriority threadPriority, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i2 & 4) != 0 ? ThreadPriority.MIDDLE : threadPriority, (i2 & 8) != 0 ? System.currentTimeMillis() : j);
    }
}
