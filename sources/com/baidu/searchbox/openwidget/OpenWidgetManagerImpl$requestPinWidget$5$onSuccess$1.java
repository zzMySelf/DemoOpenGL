package com.baidu.searchbox.openwidget;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.openwidget.model.OpenWidgetInstance;
import com.baidu.searchbox.openwidget.statistic.StatisticManager;
import com.baidu.searchbox.openwidget.utils.IntentsKt;
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
@DebugMetadata(c = "com.baidu.searchbox.openwidget.OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1", f = "OpenWidgetManagerImpl.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OpenWidgetManagerImpl.kt */
final class OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appWidgetId;
    final /* synthetic */ WrapAddOpenWidgetCallback $callback;
    final /* synthetic */ OpenWidgetInstance $newInstance;
    final /* synthetic */ Class<?> $provider;
    int label;
    final /* synthetic */ OpenWidgetManagerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1(int i2, Class<?> cls, WrapAddOpenWidgetCallback wrapAddOpenWidgetCallback, OpenWidgetInstance openWidgetInstance, OpenWidgetManagerImpl openWidgetManagerImpl, Continuation<? super OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1> continuation) {
        super(2, continuation);
        this.$appWidgetId = i2;
        this.$provider = cls;
        this.$callback = wrapAddOpenWidgetCallback;
        this.$newInstance = openWidgetInstance;
        this.this$0 = openWidgetManagerImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1(this.$appWidgetId, this.$provider, this.$callback, this.$newInstance, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.baidu.searchbox.openwidget.OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1$1", f = "OpenWidgetManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.baidu.searchbox.openwidget.OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1$1  reason: invalid class name */
    /* compiled from: OpenWidgetManagerImpl.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(openWidgetManagerImpl, i2, openWidgetInstance, cls, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    openWidgetManagerImpl.addWidgetAfterCheck(i2, openWidgetInstance, cls);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        OpenWidgetManagerImpl$requestPinWidget$5$onSuccess$1 openWidgetManagerImpl$requestPinWidget$5$onSuccess$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final OpenWidgetManagerImpl openWidgetManagerImpl = this.this$0;
                final int i2 = this.$appWidgetId;
                final OpenWidgetInstance openWidgetInstance = this.$newInstance;
                final Class<?> cls = this.$provider;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
                    openWidgetManagerImpl$requestPinWidget$5$onSuccess$1 = this;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                openWidgetManagerImpl$requestPinWidget$5$onSuccess$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        StatisticManager.INSTANCE.onWidgetPostAdd();
        AppRuntime.getAppContext().sendBroadcast(IntentsKt.buildRefreshIntent(openWidgetManagerImpl$requestPinWidget$5$onSuccess$1.$appWidgetId, openWidgetManagerImpl$requestPinWidget$5$onSuccess$1.$provider));
        openWidgetManagerImpl$requestPinWidget$5$onSuccess$1.$callback.onAddSuccess(openWidgetManagerImpl$requestPinWidget$5$onSuccess$1.$newInstance);
        return Unit.INSTANCE;
    }
}
