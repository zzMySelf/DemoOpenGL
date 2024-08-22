package com.baidu.searchbox.video.feedflow.tab.hot.tophotlist;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.hot.repos.CommonListPanelParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListMiddleware$fetchData$1$1", f = "HotTopListMiddleware.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HotTopListMiddleware.kt */
final class HotTopListMiddleware$fetchData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstSelected;
    final /* synthetic */ CommonListPanelParam $param;
    final /* synthetic */ Store<CommonState> $store;
    int label;
    final /* synthetic */ HotTopListMiddleware this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HotTopListMiddleware$fetchData$1$1(HotTopListMiddleware hotTopListMiddleware, CommonListPanelParam commonListPanelParam, Store<CommonState> store, boolean z, Continuation<? super HotTopListMiddleware$fetchData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = hotTopListMiddleware;
        this.$param = commonListPanelParam;
        this.$store = store;
        this.$isFirstSelected = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotTopListMiddleware$fetchData$1$1(this.this$0, this.$param, this.$store, this.$isFirstSelected, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HotTopListMiddleware$fetchData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            r3 = 0
            switch(r1) {
                case 0: goto L_0x001a;
                case 1: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0013:
            r0 = r7
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r0
            r0 = r8
            goto L_0x0036
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListMiddleware r4 = r1.this$0
            com.baidu.searchbox.flowvideo.hot.repos.CommonListPanelRepository r4 = r4.hotTopicListRepos
            if (r4 == 0) goto L_0x0039
            com.baidu.searchbox.flowvideo.hot.repos.CommonListPanelParam r5 = r1.$param
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.label = r2
            java.lang.Object r4 = r4.getCommonListPanelData(r5, r6)
            if (r4 != r0) goto L_0x0034
            return r0
        L_0x0034:
            r0 = r8
            r8 = r4
        L_0x0036:
            com.baidu.searchbox.feed.detail.ext.common.Result r8 = (com.baidu.searchbox.feed.detail.ext.common.Result) r8
            goto L_0x003b
        L_0x0039:
            r0 = r8
            r8 = r3
        L_0x003b:
            boolean r4 = r8 instanceof com.baidu.searchbox.feed.detail.ext.common.Result.Success
            if (r4 == 0) goto L_0x007a
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelHotTabModelMapper r4 = com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelHotTabModelMapper.INSTANCE
            r5 = r8
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r5 = (com.baidu.searchbox.feed.detail.ext.common.Result.Success) r5
            java.lang.Object r5 = r5.getData()
            com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean r5 = (com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean) r5
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotTabModel r8 = r4.map((com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean) r5)
            java.util.List r4 = r8.getList()
            if (r4 == 0) goto L_0x005c
            int r3 = r4.size()
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
        L_0x005c:
            int r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r3)
            if (r3 <= 0) goto L_0x007c
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r3 = r1.$store
            com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListAction$RequestSuccess r4 = new com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListAction$RequestSuccess
            r4.<init>(r8)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r3, r4)
            boolean r8 = r1.$isFirstSelected
            if (r8 == 0) goto L_0x007c
            com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListMiddleware r8 = r1.this$0
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r3 = r1.$store
            r8.postExpandStartAction(r3, r2)
            goto L_0x007c
        L_0x007a:
            boolean r2 = r8 instanceof com.baidu.searchbox.feed.detail.ext.common.Result.Failure
        L_0x007c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListMiddleware$fetchData$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
