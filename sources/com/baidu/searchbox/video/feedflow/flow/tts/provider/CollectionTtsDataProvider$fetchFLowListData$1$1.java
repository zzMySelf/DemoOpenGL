package com.baidu.searchbox.video.feedflow.flow.tts.provider;

import com.baidu.searchbox.flowvideo.collection.repos.CollectionFlowListParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.video.feedflow.flow.tts.provider.CollectionTtsDataProvider$fetchFLowListData$1$1", f = "CollectionTtsDataProvider.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CollectionTtsDataProvider.kt */
final class CollectionTtsDataProvider$fetchFLowListData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $direction;
    final /* synthetic */ CollectionFlowListParam $params;
    int label;
    final /* synthetic */ CollectionTtsDataProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionTtsDataProvider$fetchFLowListData$1$1(CollectionTtsDataProvider collectionTtsDataProvider, CollectionFlowListParam collectionFlowListParam, int i2, Continuation<? super CollectionTtsDataProvider$fetchFLowListData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionTtsDataProvider;
        this.$params = collectionFlowListParam;
        this.$direction = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionTtsDataProvider$fetchFLowListData$1$1(this.this$0, this.$params, this.$direction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionTtsDataProvider$fetchFLowListData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            switch(r1) {
                case 0: goto L_0x0018;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0011:
            r0 = r7
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r0
            r0 = r8
            goto L_0x0035
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            com.baidu.searchbox.video.feedflow.flow.tts.provider.CollectionTtsDataProvider r2 = r1.this$0
            com.baidu.searchbox.flowvideo.collection.repos.CollectionFlowListRepository r2 = r2.repos
            if (r2 == 0) goto L_0x0038
            com.baidu.searchbox.flowvideo.collection.repos.CollectionFlowListParam r3 = r1.$params
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 1
            r1.label = r5
            java.lang.Object r2 = r2.getCollectionFlowListData(r3, r4)
            if (r2 != r0) goto L_0x0033
            return r0
        L_0x0033:
            r0 = r8
            r8 = r2
        L_0x0035:
            com.baidu.searchbox.feed.detail.ext.common.Result r8 = (com.baidu.searchbox.feed.detail.ext.common.Result) r8
            goto L_0x003c
        L_0x0038:
            r0 = 0
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x003c:
            boolean r2 = r8 instanceof com.baidu.searchbox.feed.detail.ext.common.Result.Success
            if (r2 == 0) goto L_0x0071
            r2 = r8
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r2 = (com.baidu.searchbox.feed.detail.ext.common.Result.Success) r2
            java.lang.Object r2 = r2.getData()
            com.baidu.searchbox.flowvideo.collection.repos.CollectionListModel r2 = (com.baidu.searchbox.flowvideo.collection.repos.CollectionListModel) r2
            java.lang.String r2 = r2.getCollId()
            com.baidu.searchbox.flowvideo.collection.repos.CollectionFlowListParam r3 = r1.$params
            java.lang.String r3 = r3.getCollId()
            boolean r2 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.equalsVid(r2, r3)
            if (r2 == 0) goto L_0x0071
            com.baidu.searchbox.video.feedflow.flow.tts.provider.CollectionTtsDataProvider r2 = r1.this$0
            int r3 = r1.$direction
            com.baidu.searchbox.video.feedflow.flow.collection.mapper.CollectionFlowMapper r4 = com.baidu.searchbox.video.feedflow.flow.collection.mapper.CollectionFlowMapper.INSTANCE
            r5 = r8
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r5 = (com.baidu.searchbox.feed.detail.ext.common.Result.Success) r5
            java.lang.Object r5 = r5.getData()
            com.baidu.searchbox.flowvideo.collection.repos.CollectionListModel r5 = (com.baidu.searchbox.flowvideo.collection.repos.CollectionListModel) r5
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r4 = r4.map((com.baidu.searchbox.flowvideo.collection.repos.CollectionListModel) r5)
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowModel) r4
            r2.updateDataSource(r3, r4)
        L_0x0071:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.tts.provider.CollectionTtsDataProvider$fetchFLowListData$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
