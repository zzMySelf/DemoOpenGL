package com.baidu.live.arch.thread;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/baidu/live/arch/thread/MiniElasticExecutor;", "", "()V", "execute", "", "runnable", "Ljava/lang/Runnable;", "taskName", "", "priority", "", "executeBackground", "executeImmediate", "executeIntime", "executeSerial", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MiniElasticExecutor.kt */
public final class MiniElasticExecutor {
    public static final MiniElasticExecutor INSTANCE = new MiniElasticExecutor();

    private MiniElasticExecutor() {
    }

    public final void executeImmediate(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 0);
    }

    public final void execute(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 1);
    }

    public final void execute(Runnable runnable, String taskName, int priority) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        Intrinsics.checkParameterIsNotNull(taskName, "taskName");
        ExecutorUtilsExt.postOnElastic(runnable, taskName, priority);
    }

    public final void executeIntime(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 2);
    }

    public final void executeBackground(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 3);
    }

    public final void executeSerial(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        ExecutorUtilsExt.postOnElastic(runnable, "bd-live-runtime", 4);
    }
}
