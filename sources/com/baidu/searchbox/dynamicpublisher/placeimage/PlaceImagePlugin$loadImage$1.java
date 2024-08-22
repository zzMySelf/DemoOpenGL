package com.baidu.searchbox.dynamicpublisher.placeimage;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.dynamicpublisher.placeimage.PlaceImagePlugin$loadImage$1", f = "PlaceImagePlugin.kt", i = {0, 1, 1, 1, 1, 1}, l = {139, 155, 159}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "placeImageStruct", "imageArray", "imageNum", "index"}, s = {"L$0", "L$0", "L$1", "L$4", "I$0", "I$1"})
/* compiled from: PlaceImagePlugin.kt */
final class PlaceImagePlugin$loadImage$1 extends SuspendLambda implements Function2<FlowCollector<? super LoadStatus>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ PlaceImagePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaceImagePlugin$loadImage$1(PlaceImagePlugin placeImagePlugin, Continuation<? super PlaceImagePlugin$loadImage$1> continuation) {
        super(2, continuation);
        this.this$0 = placeImagePlugin;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlaceImagePlugin$loadImage$1 placeImagePlugin$loadImage$1 = new PlaceImagePlugin$loadImage$1(this.this$0, continuation);
        placeImagePlugin$loadImage$1.L$0 = obj;
        return placeImagePlugin$loadImage$1;
    }

    public final Object invoke(FlowCollector<? super LoadStatus> flowCollector, Continuation<? super Unit> continuation) {
        return ((PlaceImagePlugin$loadImage$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006a, code lost:
        r6 = new java.util.ArrayList();
        r0 = r2.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r7 = kotlin.Result.Companion;
        r0 = kotlin.Result.m8971constructorimpl(new org.json.JSONArray(r0.imageJsonStr));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0083, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0084, code lost:
        r7 = kotlin.Result.Companion;
        r0 = kotlin.Result.m8971constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0122 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r0 = r19
            int r2 = r0.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x004c;
                case 1: goto L_0x003d;
                case 2: goto L_0x001d;
                case 3: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0014:
            r0 = r19
            r1 = r20
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0124
        L_0x001d:
            r0 = r19
            r2 = r20
            r4 = 0
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$4
            org.json.JSONArray r7 = (org.json.JSONArray) r7
            java.lang.Object r8 = r0.L$3
            com.baidu.searchbox.dynamicpublisher.placeimage.PlaceImagePlugin r8 = (com.baidu.searchbox.dynamicpublisher.placeimage.PlaceImagePlugin) r8
            java.lang.Object r9 = r0.L$2
            java.lang.Object r10 = r0.L$1
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00fe
        L_0x003d:
            r0 = r19
            r2 = r20
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r2)
            r5 = r4
            r4 = r2
            r2 = r0
            goto L_0x006a
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r20)
            r0 = r19
            r2 = r20
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            com.baidu.searchbox.dynamicpublisher.placeimage.LoadStatus$Start r5 = com.baidu.searchbox.dynamicpublisher.placeimage.LoadStatus.Start.INSTANCE
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.emit(r5, r6)
            if (r5 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r5 = r4
            r4 = r2
            r2 = r0
        L_0x006a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6 = r0
            com.baidu.searchbox.dynamicpublisher.placeimage.PlaceImagePlugin r0 = r2.this$0
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            r7 = 0
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ all -> 0x0083 }
            java.lang.String r0 = r0.imageJsonStr     // Catch:{ all -> 0x0083 }
            r8.<init>(r0)     // Catch:{ all -> 0x0083 }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r8)     // Catch:{ all -> 0x0083 }
            goto L_0x008e
        L_0x0083:
            r0 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x008e:
            com.baidu.searchbox.dynamicpublisher.placeimage.PlaceImagePlugin r7 = r2.this$0
            boolean r8 = kotlin.Result.m8978isSuccessimpl(r0)
            if (r8 == 0) goto L_0x0104
            r8 = r0
            org.json.JSONArray r8 = (org.json.JSONArray) r8
            r9 = 0
            int r10 = com.baidu.searchbox.ugc.utils.SelectUtil.MAX_SELECTED_DEFAULT
            int r11 = r8.length()
            int r10 = java.lang.Math.min(r10, r11)
            r11 = 0
            r15 = r9
            r9 = r0
            r0 = r2
            r2 = r4
            r4 = r15
            r16 = r11
            r11 = r5
            r5 = r16
            r17 = r10
            r10 = r6
            r6 = r17
            r18 = r8
            r8 = r7
            r7 = r18
        L_0x00b9:
            if (r5 >= r6) goto L_0x0100
            java.lang.String r12 = r7.optString(r5)
            boolean r13 = r8.uriValidation(r12)
            if (r13 == 0) goto L_0x00dc
            java.lang.String r13 = "uriStr"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            com.baidu.searchbox.ugc.model.ImageStruct r12 = r8.generateImageStruct(r12)
            if (r12 == 0) goto L_0x00dc
            r13 = 0
            com.baidu.searchbox.ugc.utils.SelectUtil.saveSelectedImages(r12)
            boolean r12 = r10.add(r12)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
        L_0x00dc:
            com.baidu.searchbox.dynamicpublisher.placeimage.LoadStatus$Progress r12 = new com.baidu.searchbox.dynamicpublisher.placeimage.LoadStatus$Progress
            int r13 = r5 + 1
            float r13 = (float) r13
            float r14 = (float) r6
            float r13 = r13 / r14
            r12.<init>(r13)
            r0.L$0 = r11
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r8
            r0.L$4 = r7
            r0.I$0 = r6
            r0.I$1 = r5
            r13 = 2
            r0.label = r13
            java.lang.Object r12 = r11.emit(r12, r0)
            if (r12 != r1) goto L_0x00fe
            return r1
        L_0x00fe:
            int r5 = r5 + r3
            goto L_0x00b9
        L_0x0100:
            r6 = r10
            r5 = r11
            goto L_0x0106
        L_0x0104:
            r0 = r2
            r2 = r4
        L_0x0106:
            com.baidu.searchbox.dynamicpublisher.placeimage.LoadStatus$Done r3 = new com.baidu.searchbox.dynamicpublisher.placeimage.LoadStatus$Done
            r3.<init>(r6)
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.L$4 = r7
            r7 = 3
            r0.label = r7
            java.lang.Object r3 = r5.emit(r3, r4)
            if (r3 != r1) goto L_0x0123
            return r1
        L_0x0123:
            r1 = r2
        L_0x0124:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.placeimage.PlaceImagePlugin$loadImage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
