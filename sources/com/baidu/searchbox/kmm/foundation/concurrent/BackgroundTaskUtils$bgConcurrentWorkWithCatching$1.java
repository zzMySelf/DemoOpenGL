package com.baidu.searchbox.kmm.foundation.concurrent;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackgroundTaskUtils.kt */
final class BackgroundTaskUtils$bgConcurrentWorkWithCatching$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CancelableTask $cancelableTask;
    final /* synthetic */ Function0<Unit> $exceptionCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundTaskUtils$bgConcurrentWorkWithCatching$1(CancelableTask cancelableTask, Function0<Unit> function0) {
        super(0);
        this.$cancelableTask = cancelableTask;
        this.$exceptionCallback = function0;
    }

    public final void invoke() {
        Object obj;
        CancelableTask cancelableTask = this.$cancelableTask;
        try {
            Result.Companion companion = Result.Companion;
            cancelableTask.execute();
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable $this$invoke_u24lambda_u2d1 = Result.m8974exceptionOrNullimpl(obj);
        if ($this$invoke_u24lambda_u2d1 != null) {
            Function0<Unit> function0 = this.$exceptionCallback;
            $this$invoke_u24lambda_u2d1.printStackTrace();
            if (function0 != null) {
                function0.invoke();
            }
        }
    }
}
