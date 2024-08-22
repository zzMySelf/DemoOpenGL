package com.baidu.searchbox.openwidget;

import com.baidu.searchbox.openwidget.model.OpenWidgetConfig;
import com.baidu.searchbox.openwidget.model.OpenWidgetInfo;
import com.baidu.searchbox.openwidget.pin.WidgetPinResponse;
import com.baidu.searchbox.openwidget.statistic.StatisticManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.openwidget.OpenWidgetManagerImpl$requestPinWidget$5$onFailure$1", f = "OpenWidgetManagerImpl.kt", i = {}, l = {308, 310}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OpenWidgetManagerImpl.kt */
final class OpenWidgetManagerImpl$requestPinWidget$5$onFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WrapAddOpenWidgetCallback $callback;
    final /* synthetic */ WidgetPinResponse $errorResponse;
    final /* synthetic */ Ref.ObjectRef<OpenWidgetConfig> $updateConfig;
    final /* synthetic */ OpenWidgetInfo $widget;
    int label;
    final /* synthetic */ OpenWidgetManagerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenWidgetManagerImpl$requestPinWidget$5$onFailure$1(OpenWidgetManagerImpl openWidgetManagerImpl, OpenWidgetInfo openWidgetInfo, Ref.ObjectRef<OpenWidgetConfig> objectRef, WrapAddOpenWidgetCallback wrapAddOpenWidgetCallback, WidgetPinResponse widgetPinResponse, Continuation<? super OpenWidgetManagerImpl$requestPinWidget$5$onFailure$1> continuation) {
        super(2, continuation);
        this.this$0 = openWidgetManagerImpl;
        this.$widget = openWidgetInfo;
        this.$updateConfig = objectRef;
        this.$callback = wrapAddOpenWidgetCallback;
        this.$errorResponse = widgetPinResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpenWidgetManagerImpl$requestPinWidget$5$onFailure$1(this.this$0, this.$widget, this.$updateConfig, this.$callback, this.$errorResponse, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OpenWidgetManagerImpl$requestPinWidget$5$onFailure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OpenWidgetManagerImpl$requestPinWidget$5$onFailure$1 openWidgetManagerImpl$requestPinWidget$5$onFailure$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.this$0.isQuickConfEnabled()) {
                    this.label = 2;
                    if (this.this$0.cleanupOnFailure(this) != coroutine_suspended) {
                        openWidgetManagerImpl$requestPinWidget$5$onFailure$1 = this;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 1;
                    if (this.this$0.setupQuickConf(this.$widget, (OpenWidgetConfig) this.$updateConfig.element, this) != coroutine_suspended) {
                        openWidgetManagerImpl$requestPinWidget$5$onFailure$1 = this;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
            case 1:
                openWidgetManagerImpl$requestPinWidget$5$onFailure$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                openWidgetManagerImpl$requestPinWidget$5$onFailure$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        StatisticManager.INSTANCE.onWidgetPostAdd();
        OpenWidgetManagerImpl.notifyError$default(openWidgetManagerImpl$requestPinWidget$5$onFailure$1.this$0, openWidgetManagerImpl$requestPinWidget$5$onFailure$1.$callback, openWidgetManagerImpl$requestPinWidget$5$onFailure$1.$errorResponse.getStatusCode(), (Throwable) null, 2, (Object) null);
        return Unit.INSTANCE;
    }
}
