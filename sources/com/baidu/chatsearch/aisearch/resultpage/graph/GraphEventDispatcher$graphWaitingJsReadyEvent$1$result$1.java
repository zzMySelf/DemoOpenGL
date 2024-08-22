package com.baidu.chatsearch.aisearch.resultpage.graph;

import com.baidu.chatsearch.aisearch.resultpage.SSAiResultPageBrowserView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.chatsearch.aisearch.resultpage.graph.GraphEventDispatcher$graphWaitingJsReadyEvent$1$result$1", f = "GraphEventDispatcher.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GraphEventDispatcher.kt */
final class GraphEventDispatcher$graphWaitingJsReadyEvent$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ SSAiResultPageBrowserView $browserView;
    int label;
    final /* synthetic */ GraphEventDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphEventDispatcher$graphWaitingJsReadyEvent$1$result$1(GraphEventDispatcher graphEventDispatcher, SSAiResultPageBrowserView sSAiResultPageBrowserView, Continuation<? super GraphEventDispatcher$graphWaitingJsReadyEvent$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = graphEventDispatcher;
        this.$browserView = sSAiResultPageBrowserView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphEventDispatcher$graphWaitingJsReadyEvent$1$result$1(this.this$0, this.$browserView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GraphEventDispatcher$graphWaitingJsReadyEvent$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        GraphEventDispatcher$graphWaitingJsReadyEvent$1$result$1 graphEventDispatcher$graphWaitingJsReadyEvent$1$result$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                graphEventDispatcher$graphWaitingJsReadyEvent$1$result$1 = this;
                break;
            case 1:
                graphEventDispatcher$graphWaitingJsReadyEvent$1$result$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!graphEventDispatcher$graphWaitingJsReadyEvent$1$result$1.this$0.isChatSearchJsReady(graphEventDispatcher$graphWaitingJsReadyEvent$1$result$1.$browserView)) {
            graphEventDispatcher$graphWaitingJsReadyEvent$1$result$1.label = 1;
            if (DelayKt.delay(50, graphEventDispatcher$graphWaitingJsReadyEvent$1$result$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return "Finished";
    }
}
