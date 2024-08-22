package org.jetbrains.anko.sdk19.coroutines;

import android.view.View;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "org/jetbrains/anko/sdk19/coroutines/__View_OnAttachStateChangeListener$onViewDetachedFromWindow$1", f = "ListenersWithCoroutines.kt", i = {}, l = {55, 57}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ListenersWithCoroutines.kt */
final class __View_OnAttachStateChangeListener$onViewDetachedFromWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $handler;
    final /* synthetic */ View $v;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    __View_OnAttachStateChangeListener$onViewDetachedFromWindow$1(Function3 function3, View view2, Continuation continuation) {
        super(2, continuation);
        this.$handler = function3;
        this.$v = view2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        __View_OnAttachStateChangeListener$onViewDetachedFromWindow$1 __view_onattachstatechangelistener_onviewdetachedfromwindow_1 = new __View_OnAttachStateChangeListener$onViewDetachedFromWindow$1(this.$handler, this.$v, continuation);
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        __view_onattachstatechangelistener_onviewdetachedfromwindow_1.p$ = (CoroutineScope) obj;
        return __view_onattachstatechangelistener_onviewdetachedfromwindow_1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((__View_OnAttachStateChangeListener$onViewDetachedFromWindow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (!(result instanceof Result.Failure)) {
                    CoroutineScope coroutineScope = this.p$;
                    Function3 function3 = this.$handler;
                    View view2 = this.$v;
                    this.label = 1;
                    if (function3.invoke(coroutineScope, view2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw ((Result.Failure) result).exception;
                }
                break;
            case 1:
                if (result instanceof Result.Failure) {
                    throw ((Result.Failure) result).exception;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
