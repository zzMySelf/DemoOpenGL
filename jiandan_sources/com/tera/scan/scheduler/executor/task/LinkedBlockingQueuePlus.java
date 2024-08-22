package com.tera.scan.scheduler.executor.task;

import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/tera/scan/scheduler/executor/task/LinkedBlockingQueuePlus;", "E", "Ljava/util/concurrent/LinkedBlockingQueue;", "()V", "take", "()Ljava/lang/Object;", "lib-task-scheduler_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LinkedBlockingQueuePlus<E> extends LinkedBlockingQueue<E> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @Nullable
    public E take() {
        try {
            Result.Companion companion = Result.Companion;
            return super.take();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            E r0 = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            if (Result.m1161isFailureimpl(r0)) {
                return null;
            }
            return r0;
        }
    }
}
