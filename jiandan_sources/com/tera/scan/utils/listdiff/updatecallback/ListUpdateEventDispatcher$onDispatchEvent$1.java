package com.tera.scan.utils.listdiff.updatecallback;

import fe.mmm.qw.j.nn.de.de;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "E", "it", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateEvent;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher$onDispatchEvent$1", f = "ListUpdateEventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ListUpdateEventDispatcher$onDispatchEvent$1 extends SuspendLambda implements Function2<de, Continuation<? super Unit>, Object> {
    public int label;

    public ListUpdateEventDispatcher$onDispatchEvent$1(Continuation<? super ListUpdateEventDispatcher$onDispatchEvent$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ListUpdateEventDispatcher$onDispatchEvent$1(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull de deVar, @Nullable Continuation<? super Unit> continuation) {
        return ((ListUpdateEventDispatcher$onDispatchEvent$1) create(deVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
