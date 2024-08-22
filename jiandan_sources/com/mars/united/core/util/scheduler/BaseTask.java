package com.mars.united.core.util.scheduler;

import com.mars.kotlin.extension.Logger;
import com.mars.united.core.debug.DevelopException;
import fe.ggg.ad.qw.ad.qw;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010#\u001a\u00020\u001cH&J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015RL\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u0002\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0019\u0012\b\b\u0002\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/mars/united/core/util/scheduler/BaseTask;", "", "name", "", "type", "", "(Ljava/lang/String;I)V", "createTimeMillis", "", "(Ljava/lang/String;IJ)V", "getCreateTimeMillis", "()J", "isCancelCallback", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "setCancelCallback", "(Lkotlin/jvm/functions/Function0;)V", "isCancelled", "()Z", "getName", "()Ljava/lang/String;", "observerTaskResult", "Lkotlin/Function2;", "Lcom/mars/united/core/util/scheduler/BaseTask$TaskResult;", "Lkotlin/ParameterName;", "resultCode", "result", "", "getObserverTaskResult", "()Lkotlin/jvm/functions/Function2;", "setObserverTaskResult", "(Lkotlin/jvm/functions/Function2;)V", "getType", "()I", "performStart", "setResult", "Companion", "TaskResult", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BaseTask {
    @NotNull
    public final String qw;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/mars/united/core/util/scheduler/BaseTask$TaskResult;", "", "(Ljava/lang/String;I)V", "RESULT_OK", "RESULT_FAILED", "RESULT_ERROR", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum TaskResult {
        RESULT_OK,
        RESULT_FAILED,
        RESULT_ERROR
    }

    public BaseTask(@NotNull String str, int i2, long j) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.qw = str;
        if (Logger.INSTANCE.getEnable() && qw.qw.ad()) {
            if (!(qw().length() > 0)) {
                String str2 = "task name not allow empty";
                if (str2.length() == 0) {
                    StackTraceElement[] stackTrace = new Exception().getStackTrace();
                    Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                    str2 = "开发异常\n" + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 0)) + 10 + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 1));
                }
                throw new DevelopException(str2);
            }
        }
        BaseTask$isCancelCallback$1 baseTask$isCancelCallback$1 = BaseTask$isCancelCallback$1.INSTANCE;
        BaseTask$observerTaskResult$1 baseTask$observerTaskResult$1 = BaseTask$observerTaskResult$1.INSTANCE;
    }

    @NotNull
    public final String qw() {
        return this.qw;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseTask(@NotNull String str, int i2) {
        this(str, i2, System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(str, "name");
    }
}
