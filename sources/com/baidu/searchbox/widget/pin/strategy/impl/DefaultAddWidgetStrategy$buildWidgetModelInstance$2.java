package com.baidu.searchbox.widget.pin.strategy.impl;

import com.baidu.searchbox.widget.model.WidgetModelInstance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/widget/model/WidgetModelInstance;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.widget.pin.strategy.impl.DefaultAddWidgetStrategy$buildWidgetModelInstance$2", f = "DefaultAddWidgetStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultAddWidgetStrategy.kt */
final class DefaultAddWidgetStrategy$buildWidgetModelInstance$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetModelInstance>, Object> {
    int label;

    DefaultAddWidgetStrategy$buildWidgetModelInstance$2(Continuation<? super DefaultAddWidgetStrategy$buildWidgetModelInstance$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultAddWidgetStrategy$buildWidgetModelInstance$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WidgetModelInstance> continuation) {
        return ((DefaultAddWidgetStrategy$buildWidgetModelInstance$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return WidgetModelInstance.Companion.getEmptyWidgetModelInstance();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
