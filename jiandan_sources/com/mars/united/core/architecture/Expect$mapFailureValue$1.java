package com.mars.united.core.architecture;

import fe.ggg.ad.qw.qw.qw;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.mars.united.core.architecture.Expect", f = "Expect.kt", i = {}, l = {44}, m = "mapFailureValue", n = {}, s = {})
public final class Expect$mapFailureValue$1<C> extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ qw<ERROR, SUCCESS> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Expect$mapFailureValue$1(qw<? extends ERROR, ? extends SUCCESS> qwVar, Continuation<? super Expect$mapFailureValue$1> continuation) {
        super(continuation);
        this.this$0 = qwVar;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        this.this$0.qw((Function2) null, this);
        throw null;
    }
}
