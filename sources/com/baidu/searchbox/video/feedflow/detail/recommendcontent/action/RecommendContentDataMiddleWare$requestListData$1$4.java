package com.baidu.searchbox.video.feedflow.detail.recommendcontent.action;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.searchrecommend.repo.SearchRecommendParam;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentDataMiddleWare$requestListData$1$4", f = "RecommendContentDataMiddleWare.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RecommendContentDataMiddleWare.kt */
final class RecommendContentDataMiddleWare$requestListData$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemModel<?> $itemModel;
    final /* synthetic */ SearchRecommendParam $param;
    final /* synthetic */ Store<CommonState> $store;
    int label;
    final /* synthetic */ RecommendContentDataMiddleWare this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecommendContentDataMiddleWare$requestListData$1$4(RecommendContentDataMiddleWare recommendContentDataMiddleWare, SearchRecommendParam searchRecommendParam, Store<CommonState> store, ItemModel<?> itemModel, Continuation<? super RecommendContentDataMiddleWare$requestListData$1$4> continuation) {
        super(2, continuation);
        this.this$0 = recommendContentDataMiddleWare;
        this.$param = searchRecommendParam;
        this.$store = store;
        this.$itemModel = itemModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RecommendContentDataMiddleWare$requestListData$1$4(this.this$0, this.$param, this.$store, this.$itemModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RecommendContentDataMiddleWare$requestListData$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r16
            int r2 = r1.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x001e;
                case 1: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            r0 = r16
            r1 = r17
            kotlin.ResultKt.throwOnFailure(r1)
            r2 = r1
            goto L_0x003d
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r17)
            r1 = r16
            r2 = r17
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentDataMiddleWare r5 = r1.this$0
            com.baidu.searchbox.flowvideo.searchrecommend.repo.SearchRecommendRepository r5 = r5.mRepos
            if (r5 == 0) goto L_0x0040
            com.baidu.searchbox.flowvideo.searchrecommend.repo.SearchRecommendParam r6 = r1.$param
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r1.label = r3
            java.lang.Object r5 = r5.getSearchRecommendData(r6, r7)
            if (r5 != r0) goto L_0x003b
            return r0
        L_0x003b:
            r0 = r1
            r1 = r5
        L_0x003d:
            com.baidu.searchbox.feed.detail.ext.common.Result r1 = (com.baidu.searchbox.feed.detail.ext.common.Result) r1
            goto L_0x0042
        L_0x0040:
            r0 = r1
            r1 = r4
        L_0x0042:
            boolean r5 = r1 instanceof com.baidu.searchbox.feed.detail.ext.common.Result.Success
            if (r5 == 0) goto L_0x00a5
            r3 = r1
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r3 = (com.baidu.searchbox.feed.detail.ext.common.Result.Success) r3
            java.lang.Object r3 = r3.getData()
            boolean r1 = r3 instanceof com.baidu.searchbox.flowvideo.flow.api.FlowListBean
            if (r1 == 0) goto L_0x0054
            com.baidu.searchbox.flowvideo.flow.api.FlowListBean r3 = (com.baidu.searchbox.flowvideo.flow.api.FlowListBean) r3
            goto L_0x0055
        L_0x0054:
            r3 = r4
        L_0x0055:
            if (r3 == 0) goto L_0x00dd
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r1 = r0.$store
            com.baidu.searchbox.flowvideo.searchrecommend.repo.SearchRecommendParam r5 = r0.$param
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r6 = r0.$itemModel
            r7 = 0
            com.baidu.searchbox.video.feedflow.flow.list.mapper.FlowMapper r8 = com.baidu.searchbox.video.feedflow.flow.list.mapper.FlowMapper.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r12 = r8.map((com.baidu.searchbox.flowvideo.flow.api.FlowListBean) r3)
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelRequestAction$RequestContentSuccessAction r8 = new com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelRequestAction$RequestContentSuccessAction
            java.lang.String r10 = r5.getDirection()
            java.lang.String r11 = r5.getPanelType()
            long r13 = r5.getRequestTimeForAutoShow()
            java.lang.String r15 = r5.getExtQuery()
            r9 = r8
            r9.<init>(r10, r11, r12, r13, r15)
            com.baidu.searchbox.feed.detail.frame.Action r8 = (com.baidu.searchbox.feed.detail.frame.Action) r8
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r8)
            java.lang.String r1 = r5.getPanelType()
            java.lang.String r8 = "4"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r8)
            if (r1 != 0) goto L_0x0098
            java.lang.String r1 = r5.getPanelType()
            java.lang.String r5 = "8"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x00a3
        L_0x0098:
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.model.RecommendContentModelExt r1 = com.baidu.searchbox.video.feedflow.detail.recommendcontent.model.RecommendContentModelExt.INSTANCE
            if (r6 == 0) goto L_0x00a0
            java.lang.String r4 = r6.getId()
        L_0x00a0:
            r1.setRecommendFlowDataCache(r4, r3)
        L_0x00a3:
            goto L_0x00dd
        L_0x00a5:
            boolean r4 = r1 instanceof com.baidu.searchbox.feed.detail.ext.common.Result.Failure
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L_0x00c5
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r1 = r0.$store
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelRequestAction$RequestContentFailureAction r4 = new com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelRequestAction$RequestContentFailureAction
            com.baidu.searchbox.flowvideo.searchrecommend.repo.SearchRecommendParam r8 = r0.$param
            long r8 = r8.getRequestTimeForAutoShow()
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r3 = r5
        L_0x00bc:
            r4.<init>(r3)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r4)
            goto L_0x00dd
        L_0x00c5:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r1 = r0.$store
            com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelRequestAction$RequestContentFailureAction r4 = new com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelRequestAction$RequestContentFailureAction
            com.baidu.searchbox.flowvideo.searchrecommend.repo.SearchRecommendParam r8 = r0.$param
            long r8 = r8.getRequestTimeForAutoShow()
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00d4
            goto L_0x00d5
        L_0x00d4:
            r3 = r5
        L_0x00d5:
            r4.<init>(r3)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r4)
        L_0x00dd:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentDataMiddleWare$requestListData$1$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
