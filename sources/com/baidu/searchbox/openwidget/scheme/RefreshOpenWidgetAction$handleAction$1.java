package com.baidu.searchbox.openwidget.scheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetAction$handleAction$1", f = "RefreshOpenWidgetAction.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RefreshOpenWidgetAction.kt */
final class RefreshOpenWidgetAction$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WeakReference<Context> $activityRef;
    final /* synthetic */ UnitedSchemeEntity $entity;
    final /* synthetic */ WeakReference<CallbackHandler> $handlerRef;
    final /* synthetic */ long $openWidgetId;
    final /* synthetic */ int $widgetId;
    int label;
    final /* synthetic */ RefreshOpenWidgetAction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RefreshOpenWidgetAction$handleAction$1(int i2, RefreshOpenWidgetAction refreshOpenWidgetAction, WeakReference<CallbackHandler> weakReference, UnitedSchemeEntity unitedSchemeEntity, WeakReference<Context> weakReference2, long j2, Continuation<? super RefreshOpenWidgetAction$handleAction$1> continuation) {
        super(2, continuation);
        this.$widgetId = i2;
        this.this$0 = refreshOpenWidgetAction;
        this.$handlerRef = weakReference;
        this.$entity = unitedSchemeEntity;
        this.$activityRef = weakReference2;
        this.$openWidgetId = j2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RefreshOpenWidgetAction$handleAction$1(this.$widgetId, this.this$0, this.$handlerRef, this.$entity, this.$activityRef, this.$openWidgetId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RefreshOpenWidgetAction$handleAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 1
            switch(r1) {
                case 0: goto L_0x0019;
                case 1: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0012:
            r0 = r11
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r0
            r0 = r12
            goto L_0x003b
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r11
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetAction$handleAction$1$allInstances$1 r4 = new com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetAction$handleAction$1$allInstances$1
            long r5 = r1.$openWidgetId
            r7 = 0
            r4.<init>(r5, r7)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.label = r2
            java.lang.Object r3 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r5)
            if (r3 != r0) goto L_0x0039
            return r0
        L_0x0039:
            r0 = r12
            r12 = r3
        L_0x003b:
            java.util.List r12 = (java.util.List) r12
            int r3 = r1.$widgetId
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            boolean r3 = com.baidu.searchbox.openwidget.utils.WidgetsKt.isValidWidgetId(r3)
            if (r3 == 0) goto L_0x007e
            r3 = r12
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            int r4 = r1.$widgetId
            r12 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            r6 = 0
            java.util.Iterator r7 = r3.iterator()
        L_0x005b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0078
            java.lang.Object r3 = r7.next()
            r8 = r3
            com.baidu.searchbox.openwidget.model.OpenWidgetInstance r8 = (com.baidu.searchbox.openwidget.model.OpenWidgetInstance) r8
            r9 = 0
            int r10 = r8.getId()
            if (r10 != r4) goto L_0x0071
            r8 = r2
            goto L_0x0072
        L_0x0071:
            r8 = 0
        L_0x0072:
            if (r8 == 0) goto L_0x005b
            r5.add(r3)
            goto L_0x005b
        L_0x0078:
            r2 = r5
            java.util.List r2 = (java.util.List) r2
            r12 = r2
            goto L_0x007f
        L_0x007e:
        L_0x007f:
            boolean r2 = r12.isEmpty()
            if (r2 == 0) goto L_0x00c4
            boolean r12 = com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetActionKt.DEBUG
            if (r12 == 0) goto L_0x00a7
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r2 = "找不到widget, id="
            java.lang.StringBuilder r12 = r12.append(r2)
            int r2 = r1.$widgetId
            java.lang.StringBuilder r12 = r12.append(r2)
            java.lang.String r12 = r12.toString()
            java.lang.String r2 = "RefreshOpenWidget"
            android.util.Log.d(r2, r12)
        L_0x00a7:
            com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetAction r12 = r1.this$0
            r2 = r12
            com.baidu.searchbox.openwidget.scheme.BaseOpenWidgetSchemeAction r2 = (com.baidu.searchbox.openwidget.scheme.BaseOpenWidgetSchemeAction) r2
            java.lang.ref.WeakReference<com.baidu.searchbox.unitedscheme.CallbackHandler> r12 = r1.$handlerRef
            java.lang.Object r12 = r12.get()
            r3 = r12
            com.baidu.searchbox.unitedscheme.CallbackHandler r3 = (com.baidu.searchbox.unitedscheme.CallbackHandler) r3
            com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r4 = r1.$entity
            r5 = 2001(0x7d1, float:2.804E-42)
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            com.baidu.searchbox.openwidget.scheme.BaseOpenWidgetSchemeAction.doCallback$default(r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00c4:
            java.lang.ref.WeakReference<android.content.Context> r2 = r1.$activityRef
            java.lang.Object r2 = r2.get()
            android.content.Context r2 = (android.content.Context) r2
            if (r2 != 0) goto L_0x00d2
            android.content.Context r2 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
        L_0x00d2:
            r3 = r12
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetAction r4 = r1.this$0
            r12 = 0
            java.util.Iterator r5 = r3.iterator()
        L_0x00dc:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x00f3
            java.lang.Object r3 = r5.next()
            r6 = r3
            com.baidu.searchbox.openwidget.model.OpenWidgetInstance r6 = (com.baidu.searchbox.openwidget.model.OpenWidgetInstance) r6
            r7 = 0
            java.lang.String r8 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            r4.sendRefreshBroadcast(r2, r6)
            goto L_0x00dc
        L_0x00f3:
            com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetAction r12 = r1.this$0
            r3 = r12
            com.baidu.searchbox.openwidget.scheme.BaseOpenWidgetSchemeAction r3 = (com.baidu.searchbox.openwidget.scheme.BaseOpenWidgetSchemeAction) r3
            java.lang.ref.WeakReference<com.baidu.searchbox.unitedscheme.CallbackHandler> r12 = r1.$handlerRef
            java.lang.Object r12 = r12.get()
            r4 = r12
            com.baidu.searchbox.unitedscheme.CallbackHandler r4 = (com.baidu.searchbox.unitedscheme.CallbackHandler) r4
            com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r5 = r1.$entity
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 24
            r10 = 0
            com.baidu.searchbox.openwidget.scheme.BaseOpenWidgetSchemeAction.doCallback$default(r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.openwidget.scheme.RefreshOpenWidgetAction$handleAction$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
