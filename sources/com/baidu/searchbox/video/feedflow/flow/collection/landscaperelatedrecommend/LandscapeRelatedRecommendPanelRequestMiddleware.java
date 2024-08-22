package com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.ext.common.RequestAction;
import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.flow.api.FlowListBean;
import com.baidu.searchbox.flowvideo.recommend.repos.RelatedRecommendPanelParam;
import com.baidu.searchbox.flowvideo.recommend.repos.RelatedRecommendPanelRepository;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend.LandscapeRelatedRecommendPanelAction;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.LandscapeRelatedRecommendPanelRequestListData;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/landscaperelatedrecommend/LandscapeRelatedRecommendPanelRequestMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isRequestCurrent", "", "isRequestNext", "isRequestPre", "mRepos", "Lcom/baidu/searchbox/flowvideo/recommend/repos/RelatedRecommendPanelRepository;", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "sendLandscapeRelatedRecommendPanelRequest", "", "param", "Lcom/baidu/searchbox/flowvideo/recommend/repos/RelatedRecommendPanelParam;", "sendLandscapeRelatedRecommendRequestAction", "direction", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeRelatedRecommendPanelRequestMiddleware.kt */
public final class LandscapeRelatedRecommendPanelRequestMiddleware implements Middleware<CommonState> {
    /* access modifiers changed from: private */
    public boolean isRequestCurrent;
    /* access modifiers changed from: private */
    public boolean isRequestNext;
    /* access modifiers changed from: private */
    public boolean isRequestPre;
    /* access modifiers changed from: private */
    public final RelatedRecommendPanelRepository mRepos = DIFactory.INSTANCE.makeRelatedRecommendRepos();

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof NetAction.Failure) {
            if (!DIFactory.INSTANCE.isNetConnected() && Intrinsics.areEqual((Object) ((NetAction.Failure) action).getClazz(), (Object) LandscapeRelatedRecommendPanelRequestListData.class)) {
                StoreExtKt.post(store, ToastAction.NetExc.INSTANCE);
            }
        } else if (action instanceof LandscapeRelatedRecommendPanelRequestListData) {
            sendLandscapeRelatedRecommendRequestAction(store, ((LandscapeRelatedRecommendPanelRequestListData) action).getDirection());
        } else if (action instanceof RequestAction) {
            RequestParam params = ((RequestAction) action).getParams();
            RelatedRecommendPanelParam param = params instanceof RelatedRecommendPanelParam ? (RelatedRecommendPanelParam) params : null;
            if (param != null) {
                sendLandscapeRelatedRecommendPanelRequest(store, param);
            }
        }
        return next.next(store, action);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r7 == null) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sendLandscapeRelatedRecommendRequestAction(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r19, int r20) {
        /*
            r18 = this;
            com.baidu.searchbox.feed.detail.frame.State r0 = r19.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r2 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r0.select(r2)
            r1 = r0
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            r0 = 0
            if (r1 == 0) goto L_0x0016
            java.lang.String r2 = r1.pd
            goto L_0x0017
        L_0x0016:
            r2 = r0
        L_0x0017:
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x001d
            r5 = r3
            goto L_0x001e
        L_0x001d:
            r5 = r2
        L_0x001e:
            com.baidu.searchbox.feed.detail.frame.State r2 = r19.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r2 = r2.select(r6)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r2 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r2
            r4 = 0
            if (r2 == 0) goto L_0x004b
            java.util.List r2 = r2.getFlowList()
            if (r2 == 0) goto L_0x004b
            r6 = 0
            int r7 = r2.size()
            if (r7 <= 0) goto L_0x0048
            java.lang.Object r7 = r2.get(r4)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r7
            java.lang.String r7 = r7.getId()
            goto L_0x0049
        L_0x0048:
            r7 = r3
        L_0x0049:
            if (r7 != 0) goto L_0x004c
        L_0x004b:
            r7 = r3
        L_0x004c:
            if (r1 == 0) goto L_0x0052
            java.lang.String r2 = r1.page
            goto L_0x0053
        L_0x0052:
            r2 = r0
        L_0x0053:
            if (r2 != 0) goto L_0x0057
            r6 = r3
            goto L_0x0058
        L_0x0057:
            r6 = r2
        L_0x0058:
            r2 = r19
            r8 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r2.getState()
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0066
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9
            goto L_0x0067
        L_0x0066:
            r9 = r0
        L_0x0067:
            if (r9 == 0) goto L_0x0070
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r10 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r9 = r9.select(r10)
            goto L_0x0071
        L_0x0070:
            r9 = r0
        L_0x0071:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r9 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r9
            if (r9 == 0) goto L_0x0079
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r9.getCurItemModel()
        L_0x0079:
            r2 = r0
            if (r2 == 0) goto L_0x0085
            java.lang.String r0 = r2.getId()
            if (r0 != 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r8 = r0
            goto L_0x0086
        L_0x0085:
            r8 = r3
        L_0x0086:
            if (r2 == 0) goto L_0x00af
            com.baidu.searchbox.video.feedflow.flow.list.CommonItemData r0 = r2.getCommonItemData()     // Catch:{ JSONException -> 0x00b6 }
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = r0.getExtRequest()     // Catch:{ JSONException -> 0x00b6 }
            if (r0 == 0) goto L_0x00af
            r3 = 0
            r9 = r0
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ JSONException -> 0x00b6 }
            int r9 = r9.length()     // Catch:{ JSONException -> 0x00b6 }
            if (r9 <= 0) goto L_0x00a0
            r4 = 1
        L_0x00a0:
            if (r4 == 0) goto L_0x00a8
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b6 }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x00b6 }
            goto L_0x00ad
        L_0x00a8:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b6 }
            r4.<init>()     // Catch:{ JSONException -> 0x00b6 }
        L_0x00ad:
            goto L_0x00b4
        L_0x00af:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b6 }
            r4.<init>()     // Catch:{ JSONException -> 0x00b6 }
        L_0x00b4:
            r14 = r4
            goto L_0x00bd
        L_0x00b6:
            r0 = move-exception
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r14 = r3
        L_0x00bd:
            com.baidu.searchbox.flowvideo.recommend.repos.RelatedRecommendPanelParam r0 = new com.baidu.searchbox.flowvideo.recommend.repos.RelatedRecommendPanelParam
            r9 = 0
            int r12 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.getPlayQualityScore()
            float r13 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.getDeviceStaticScore()
            org.json.JSONObject r15 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.buildAppInfo()
            r16 = 16
            r17 = 0
            java.lang.String r11 = "1"
            r4 = r0
            r10 = r20
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.baidu.searchbox.feed.detail.ext.common.RequestAction r3 = new com.baidu.searchbox.feed.detail.ext.common.RequestAction
            r4 = r0
            com.baidu.searchbox.feed.detail.ext.common.RequestParam r4 = (com.baidu.searchbox.feed.detail.ext.common.RequestParam) r4
            r3.<init>(r4)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r4 = r19
            r4.dispatch(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend.LandscapeRelatedRecommendPanelRequestMiddleware.sendLandscapeRelatedRecommendRequestAction(com.baidu.searchbox.feed.detail.frame.Store, int):void");
    }

    private final void sendLandscapeRelatedRecommendPanelRequest(Store<CommonState> store, RelatedRecommendPanelParam param) {
        switch (param.getDirection()) {
            case -1:
                if (!this.isRequestPre) {
                    this.isRequestPre = true;
                    break;
                } else {
                    return;
                }
            case 0:
                if (!this.isRequestCurrent) {
                    this.isRequestCurrent = true;
                    break;
                } else {
                    return;
                }
            case 1:
                if (!this.isRequestNext) {
                    this.isRequestNext = true;
                    break;
                } else {
                    return;
                }
        }
        CommonState state = store.getState();
        FlowListBean flowListBean = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        FlowState flowState = (FlowState) (commonState != null ? commonState.select(FlowState.class) : null);
        ItemModel curItemModel = flowState != null ? flowState.getCurItemModel() : null;
        if (!Intrinsics.areEqual((Object) curItemModel != null ? curItemModel.getId() : null, (Object) param.getVid()) || param.getDirection() != 0) {
            Store<CommonState> store2 = store;
        } else {
            Object data = curItemModel.getData();
            VideoItemModel videoItemModel = data instanceof VideoItemModel ? (VideoItemModel) data : null;
            if (videoItemModel != null) {
                flowListBean = videoItemModel.getCacheLandscapeRelatedRecommendDataList();
            }
            FlowListBean cacheDataList = flowListBean;
            if (cacheDataList != null) {
                store.dispatch(new LandscapeRelatedRecommendPanelAction.RequestSuccessAction(cacheDataList, 3));
                this.isRequestCurrent = false;
                return;
            }
            Store<CommonState> store3 = store;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new LandscapeRelatedRecommendPanelRequestMiddleware$sendLandscapeRelatedRecommendPanelRequest$1(this, param, store, RelatedRecommendPanelParam.class, (Continuation<? super LandscapeRelatedRecommendPanelRequestMiddleware$sendLandscapeRelatedRecommendPanelRequest$1>) null), 2, (Object) null);
    }
}
