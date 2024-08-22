package com.baidu.searchbox.widget.model;

import com.baidu.searchbox.widget.debug.WidgetDebugKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.widget.model.WidgetModelProvider$onDeleted$1$deleteJob$1", f = "WidgetModelProvider.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WidgetModelProvider.kt */
final class WidgetModelProvider$onDeleted$1$deleteJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appWidgetId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WidgetModelProvider$onDeleted$1$deleteJob$1(int i2, Continuation<? super WidgetModelProvider$onDeleted$1$deleteJob$1> continuation) {
        super(2, continuation);
        this.$appWidgetId = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WidgetModelProvider$onDeleted$1$deleteJob$1(this.$appWidgetId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetModelProvider$onDeleted$1$deleteJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        WidgetModelProvider$onDeleted$1$deleteJob$1 widgetModelProvider$onDeleted$1$deleteJob$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                widgetModelProvider$onDeleted$1$deleteJob$1 = this;
                widgetModelProvider$onDeleted$1$deleteJob$1.label = 1;
                Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new WidgetModelProvider$onDeleted$1$deleteJob$1$deleteResult$1(widgetModelProvider$onDeleted$1$deleteJob$1.$appWidgetId, (Continuation<? super WidgetModelProvider$onDeleted$1$deleteJob$1$deleteResult$1>) null), widgetModelProvider$onDeleted$1$deleteJob$1);
                if (withContext != coroutine_suspended) {
                    Object obj = $result;
                    $result = withContext;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                widgetModelProvider$onDeleted$1$deleteJob$1 = this;
                Object obj2 = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean deleteResult = ((Boolean) $result).booleanValue();
        WidgetDebugKt.printLog("onDelete,deleteResult=" + deleteResult);
        if (deleteResult) {
            WidgetModelInstanceManager.Companion.getInstance().removeCache(widgetModelProvider$onDeleted$1$deleteJob$1.$appWidgetId);
        }
        return Unit.INSTANCE;
    }
}
