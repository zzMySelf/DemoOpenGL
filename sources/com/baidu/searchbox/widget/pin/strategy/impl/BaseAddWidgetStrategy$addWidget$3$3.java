package com.baidu.searchbox.widget.pin.strategy.impl;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import com.baidu.searchbox.widget.pin.WidgetPinData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy$addWidget$3$3", f = "BaseAddWidgetStrategy.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseAddWidgetStrategy.kt */
final class BaseAddWidgetStrategy$addWidget$3$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ AppWidgetManager $it;
    final /* synthetic */ WidgetPinData $pinData;
    final /* synthetic */ String $source;
    final /* synthetic */ BaseAddWidgetStrategy$addWidget$widgetAddCallback$1 $widgetAddCallback;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ BaseAddWidgetStrategy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAddWidgetStrategy$addWidget$3$3(BaseAddWidgetStrategy baseAddWidgetStrategy, AppWidgetManager appWidgetManager, Activity activity, WidgetPinData widgetPinData, BaseAddWidgetStrategy$addWidget$widgetAddCallback$1 baseAddWidgetStrategy$addWidget$widgetAddCallback$1, String str, Continuation<? super BaseAddWidgetStrategy$addWidget$3$3> continuation) {
        super(2, continuation);
        this.this$0 = baseAddWidgetStrategy;
        this.$it = appWidgetManager;
        this.$activity = activity;
        this.$pinData = widgetPinData;
        this.$widgetAddCallback = baseAddWidgetStrategy$addWidget$widgetAddCallback$1;
        this.$source = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseAddWidgetStrategy$addWidget$3$3(this.this$0, this.$it, this.$activity, this.$pinData, this.$widgetAddCallback, this.$source, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseAddWidgetStrategy$addWidget$3$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = r6.buildCustomGuideModel$lib_widget_release(r2, r4);
        com.baidu.searchbox.widget.pin.WidgetPinStrategyManager.INSTANCE.getWidgetPinStrategy().tryToAddWidget(r3, (com.baidu.searchbox.widget.pin.WidgetPinData) r12, r5, r2);
        r12 = kotlin.Result.m8971constructorimpl(kotlin.Unit.INSTANCE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007f, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0080, code lost:
        r10 = r1;
        r1 = r12;
        r12 = r0;
        r0 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            switch(r1) {
                case 0: goto L_0x0030;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0011:
            r0 = r11
            r1 = 0
            java.lang.Object r2 = r0.L$4
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.L$3
            com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy$addWidget$widgetAddCallback$1 r3 = (com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy$addWidget$widgetAddCallback$1) r3
            java.lang.Object r4 = r0.L$2
            com.baidu.searchbox.widget.pin.WidgetPinData r4 = (com.baidu.searchbox.widget.pin.WidgetPinData) r4
            java.lang.Object r5 = r0.L$1
            android.app.Activity r5 = (android.app.Activity) r5
            java.lang.Object r6 = r0.L$0
            com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy r6 = (com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy) r6
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x002e }
            r8 = r1
            r1 = r0
            r0 = r12
            goto L_0x0066
        L_0x002e:
            r1 = move-exception
            goto L_0x0089
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r11
            com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy r6 = r1.this$0
            android.appwidget.AppWidgetManager r2 = r1.$it
            android.app.Activity r5 = r1.$activity
            com.baidu.searchbox.widget.pin.WidgetPinData r4 = r1.$pinData
            com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy$addWidget$widgetAddCallback$1 r3 = r1.$widgetAddCallback
            java.lang.String r7 = r1.$source
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            r8 = 0
            r9 = r3
            com.baidu.searchbox.widget.pin.IWidgetAddCallback r9 = (com.baidu.searchbox.widget.pin.IWidgetAddCallback) r9     // Catch:{ all -> 0x0085 }
            r6.startPinChecker(r2, r5, r4, r9)     // Catch:{ all -> 0x0085 }
            r2 = r3
            com.baidu.searchbox.widget.pin.IWidgetAddCallback r2 = (com.baidu.searchbox.widget.pin.IWidgetAddCallback) r2     // Catch:{ all -> 0x0085 }
            r6.registerAddReceiver(r2)     // Catch:{ all -> 0x0085 }
            r1.L$0 = r6     // Catch:{ all -> 0x0085 }
            r1.L$1 = r5     // Catch:{ all -> 0x0085 }
            r1.L$2 = r4     // Catch:{ all -> 0x0085 }
            r1.L$3 = r3     // Catch:{ all -> 0x0085 }
            r1.L$4 = r7     // Catch:{ all -> 0x0085 }
            r2 = 1
            r1.label = r2     // Catch:{ all -> 0x0085 }
            java.lang.Object r2 = r6.rebuildPinData$lib_widget_release(r7, r4, r1)     // Catch:{ all -> 0x0085 }
            if (r2 != r0) goto L_0x0063
            return r0
        L_0x0063:
            r0 = r12
            r12 = r2
            r2 = r7
        L_0x0066:
            com.baidu.searchbox.widget.pin.WidgetPinData r12 = (com.baidu.searchbox.widget.pin.WidgetPinData) r12     // Catch:{ all -> 0x007f }
            com.baidu.searchbox.widget.guide.bean.CustomGuideModel r2 = r6.buildCustomGuideModel$lib_widget_release(r2, r4)     // Catch:{ all -> 0x007f }
            com.baidu.searchbox.widget.pin.WidgetPinStrategyManager r4 = com.baidu.searchbox.widget.pin.WidgetPinStrategyManager.INSTANCE     // Catch:{ all -> 0x007f }
            com.baidu.searchbox.widget.pin.IWidgetPinStrategy r4 = r4.getWidgetPinStrategy()     // Catch:{ all -> 0x007f }
            com.baidu.searchbox.widget.pin.IWidgetAddCallback r3 = (com.baidu.searchbox.widget.pin.IWidgetAddCallback) r3     // Catch:{ all -> 0x007f }
            r4.tryToAddWidget(r3, r12, r5, r2)     // Catch:{ all -> 0x007f }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007f }
            java.lang.Object r12 = kotlin.Result.m8971constructorimpl(r12)     // Catch:{ all -> 0x007f }
            goto L_0x0097
        L_0x007f:
            r12 = move-exception
            r10 = r1
            r1 = r12
            r12 = r0
            r0 = r10
            goto L_0x0089
        L_0x0085:
            r0 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L_0x0089:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m8971constructorimpl(r1)
            r10 = r0
            r0 = r12
            r12 = r1
            r1 = r10
        L_0x0097:
            com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy r2 = r1.this$0
            java.lang.Throwable r12 = kotlin.Result.m8974exceptionOrNullimpl(r12)
            if (r12 == 0) goto L_0x00a5
            r12 = 0
            r2.release()
        L_0x00a5:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.widget.pin.strategy.impl.BaseAddWidgetStrategy$addWidget$3$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
