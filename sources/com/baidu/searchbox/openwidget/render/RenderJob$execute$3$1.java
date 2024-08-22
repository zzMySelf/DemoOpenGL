package com.baidu.searchbox.openwidget.render;

import com.baidu.searchbox.openwidget.StatefulWidget;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.openwidget.render.RenderJob$execute$3$1", f = "RenderJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RenderJob.kt */
final class RenderJob$execute$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Throwable $it;
    final /* synthetic */ StatefulWidget $widget;
    int label;
    final /* synthetic */ RenderJob this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderJob$execute$3$1(StatefulWidget statefulWidget, Throwable th2, RenderJob renderJob, Continuation<? super RenderJob$execute$3$1> continuation) {
        super(2, continuation);
        this.$widget = statefulWidget;
        this.$it = th2;
        this.this$0 = renderJob;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RenderJob$execute$3$1(this.$widget, this.$it, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RenderJob$execute$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.$widget.onRenderFail(this.$it, this.this$0.getTracer().dump());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
