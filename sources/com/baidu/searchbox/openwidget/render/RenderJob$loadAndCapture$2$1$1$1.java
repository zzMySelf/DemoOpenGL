package com.baidu.searchbox.openwidget.render;

import com.baidu.searchbox.openwidget.engine.web.OpenWidgetWebViewEngine;
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
@DebugMetadata(c = "com.baidu.searchbox.openwidget.render.RenderJob$loadAndCapture$2$1$1$1", f = "RenderJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RenderJob.kt */
final class RenderJob$loadAndCapture$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenWidgetWebViewEngine $engine;
    int label;
    final /* synthetic */ RenderJob this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderJob$loadAndCapture$2$1$1$1(RenderJob renderJob, OpenWidgetWebViewEngine openWidgetWebViewEngine, Continuation<? super RenderJob$loadAndCapture$2$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = renderJob;
        this.$engine = openWidgetWebViewEngine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RenderJob$loadAndCapture$2$1$1$1(this.this$0, this.$engine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RenderJob$loadAndCapture$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (RenderJobKt.DEBUG) {
                    this.this$0.log("start prepare");
                }
                this.$engine.prepare();
                if (RenderJobKt.DEBUG) {
                    this.this$0.log("end prepare");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
