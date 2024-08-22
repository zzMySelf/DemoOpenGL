package com.sdk.d;

import com.sdk.o.a;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class d extends FutureTask<Result> {
    public final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar, Callable callable) {
        super(callable);
        this.a = eVar;
    }

    public void done() {
        try {
            e.b(this.a, super.get());
        } catch (Exception e) {
            e.b(this.a, (Object) null);
            a.a("PriorityAsyncTask", e.getMessage(), this.a.h);
        }
    }
}
