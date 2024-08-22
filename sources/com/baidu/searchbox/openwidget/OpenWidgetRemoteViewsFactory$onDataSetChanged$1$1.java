package com.baidu.searchbox.openwidget;

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
@DebugMetadata(c = "com.baidu.searchbox.openwidget.OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1", f = "OpenWidgetRemoteViewsFactory.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OpenWidgetRemoteViewsFactory.kt */
final class OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenWidgetRemoteViewsFactory $this_runCatching;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1(OpenWidgetRemoteViewsFactory openWidgetRemoteViewsFactory, Continuation<? super OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = openWidgetRemoteViewsFactory;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1(this.$this_runCatching, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.baidu.searchbox.openwidget.OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1$1", f = "OpenWidgetRemoteViewsFactory.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.baidu.searchbox.openwidget.OpenWidgetRemoteViewsFactory$onDataSetChanged$1$1$1  reason: invalid class name */
    /* compiled from: OpenWidgetRemoteViewsFactory.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(openWidgetRemoteViewsFactory, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (OpenWidgetRenderService.Companion.submitRenderRequest$lib_openwidget_release(openWidgetRemoteViewsFactory.context, openWidgetRemoteViewsFactory.getAppWidgetId$lib_openwidget_release(), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final OpenWidgetRemoteViewsFactory openWidgetRemoteViewsFactory = this.$this_runCatching;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
