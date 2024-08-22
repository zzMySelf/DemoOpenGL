package com.baidu.searchbox.video.feedflow.detail.payment.shortplay;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.PlayletFloatLayerModel;
import com.baidu.searchbox.flowvideo.shortplaypayment.repos.ShortPlayPaymentRepository;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.export.IVideoPaymentUtils;
import com.baidu.searchbox.video.detail.utils.VidUtilsKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.FlowDetailState;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerState;
import com.baidu.searchbox.video.feedflow.detail.bottom.BottomBarReducerAdapterAction;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0002J(\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\u0017\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010\u0019\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J&\u0010\u001a\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\u001e\u0010\u001e\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0016\u0010\u001f\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/shortplay/ShortPlayPaymentGuideMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "hasFling", "", "mRepos", "Lcom/baidu/searchbox/flowvideo/shortplaypayment/repos/ShortPlayPaymentRepository;", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getCurrentCollId", "", "handleAlsUpload", "", "type", "", "result", "handlePayPanelBottomBarClick", "handlePayPanelResult", "status", "isNeedUploadAls", "setIsChooseVirtualPayAutoUnlock", "resultJson", "Lorg/json/JSONObject;", "collId", "shortPlayGuideShowCommon", "updatePlayerUbcContentAction", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPaymentGuideMiddleware.kt */
public final class ShortPlayPaymentGuideMiddleware implements Middleware<CommonState> {
    private boolean hasFling;
    /* access modifiers changed from: private */
    public final ShortPlayPaymentRepository mRepos = DIFactory.INSTANCE.makeShortPlayRepos();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v45, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v46, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v50, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v51, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v52, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v53, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v55, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v58, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x0514, code lost:
        if (r0.containsNid((r12 == null || (r10 = r12.getData()) == null || (r10 = r10.getBottomEntry()) == null || (r10 = r10.getNextColl()) == null || (r10 = r10.getData()) == null || (r10 = r10.getUnLockCollInfo()) == null || (r10 = r10.getPlayLetUnids()) == null || (r5 = kotlin.text.StringsKt.split$default(r10, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null)) == null) ? null : (java.lang.String) kotlin.collections.CollectionsKt.getOrNull(r5, 0)) != false) goto L_0x0516;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r20, com.baidu.searchbox.feed.detail.frame.Action r21, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r22) {
        /*
            r19 = this;
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0071
            r0 = r8
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r0 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r0
            java.lang.Object r0 = r0.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel
            if (r4 == 0) goto L_0x002f
            r3 = r0
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r3 = (com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel) r3
        L_0x002f:
            if (r3 == 0) goto L_0x084a
            r0 = r3
            r3 = 0
            r19.updatePlayerUbcContentAction(r20)
            java.lang.String r4 = r0.getPlayLetType()
            java.lang.String r5 = "1"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0049
            boolean r4 = r0.getPlayLetUnlocked()
            if (r4 != 0) goto L_0x0049
            r2 = r1
        L_0x0049:
            r6.shortPlayGuideShowCommon(r7, r2)
            boolean r4 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r20)
            if (r4 == 0) goto L_0x005e
            if (r2 == 0) goto L_0x005e
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayGuideShowAction r4 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayGuideShowAction
            r4.<init>(r1)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r4)
        L_0x005e:
            com.baidu.searchbox.video.feedflow.di.DIFactory r1 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware$apply$1$1 r4 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware$apply$1$1
            r4.<init>(r7)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r1.post(r4)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x084a
        L_0x0071:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.OnItemStartFling
            if (r0 == 0) goto L_0x00e2
            boolean r0 = com.baidu.searchbox.video.feedflow.detail.search.utils.SearchBoxAbUtilsKt.searchBoxAbEnable((com.baidu.searchbox.feed.detail.frame.Store<?>) r20)
            if (r0 == 0) goto L_0x084a
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0089
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x008a
        L_0x0089:
            r5 = r3
        L_0x008a:
            if (r5 == 0) goto L_0x0093
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r10 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x0094
        L_0x0093:
            r5 = r3
        L_0x0094:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x00a7
            int r0 = r5.getPosition()
            r4 = r8
            com.baidu.searchbox.feed.detail.arch.ext.OnItemStartFling r4 = (com.baidu.searchbox.feed.detail.arch.ext.OnItemStartFling) r4
            int r4 = r4.getPosition()
            if (r0 != r4) goto L_0x00a7
            r0 = r1
            goto L_0x00a8
        L_0x00a7:
            r0 = r2
        L_0x00a8:
            if (r0 == 0) goto L_0x084a
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x00b8
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00b9
        L_0x00b8:
            r5 = r3
        L_0x00b9:
            if (r5 == 0) goto L_0x00c1
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r5.select(r3)
        L_0x00c1:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r0 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r3)
            if (r0 == 0) goto L_0x00d1
            boolean r0 = r0.isPayTypeAndLocked()
            if (r0 != r1) goto L_0x00d1
            r0 = r1
            goto L_0x00d2
        L_0x00d1:
            r0 = r2
        L_0x00d2:
            if (r0 == 0) goto L_0x084a
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$SwitchEnableNoPost r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$SwitchEnableNoPost
            r0.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            r7.dispatch(r0)
            r6.hasFling = r1
            goto L_0x084a
        L_0x00e2:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.flow.search.SearchMarkFlowAction.OnSwitchBoxFail
            if (r0 == 0) goto L_0x011d
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x00f4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00f5
        L_0x00f4:
            r5 = r3
        L_0x00f5:
            if (r5 == 0) goto L_0x00fd
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r5.select(r3)
        L_0x00fd:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r0 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r3)
            if (r0 == 0) goto L_0x010c
            boolean r0 = r0.isPayTypeAndLocked()
            if (r0 != r1) goto L_0x010c
            goto L_0x010d
        L_0x010c:
            r1 = r2
        L_0x010d:
            if (r1 == 0) goto L_0x0119
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$SwitchEnableNoPost r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$SwitchEnableNoPost
            r0.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            r7.dispatch(r0)
        L_0x0119:
            r6.hasFling = r2
            goto L_0x084a
        L_0x011d:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected
            if (r0 == 0) goto L_0x02ac
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x012f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0130
        L_0x012f:
            r5 = r3
        L_0x0130:
            if (r5 == 0) goto L_0x0139
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r10 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x013a
        L_0x0139:
            r5 = r3
        L_0x013a:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r5 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r5
            if (r5 != 0) goto L_0x013f
            goto L_0x0142
        L_0x013f:
            r5.setHasReceived(r2)
        L_0x0142:
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0150
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0151
        L_0x0150:
            r5 = r3
        L_0x0151:
            if (r5 == 0) goto L_0x015a
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r10 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x015b
        L_0x015a:
            r5 = r3
        L_0x015b:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r5 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r5
            if (r5 == 0) goto L_0x0167
            boolean r0 = r5.getVisible()
            if (r0 != r1) goto L_0x0167
            r0 = r1
            goto L_0x0168
        L_0x0167:
            r0 = r2
        L_0x0168:
            if (r0 == 0) goto L_0x019f
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayGuideShowAction r0 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayGuideShowAction
            r0.<init>(r1)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0182
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0183
        L_0x0182:
            r5 = r3
        L_0x0183:
            if (r5 == 0) goto L_0x018c
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r10 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x018d
        L_0x018c:
            r5 = r3
        L_0x018d:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r5 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r5
            if (r5 == 0) goto L_0x0196
            androidx.lifecycle.MutableLiveData r0 = r5.getAutoShowPayPanel()
            goto L_0x0197
        L_0x0196:
            r0 = r3
        L_0x0197:
            if (r0 != 0) goto L_0x019a
            goto L_0x019f
        L_0x019a:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r0.setValue(r4)
        L_0x019f:
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x01ad
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x01ae
        L_0x01ad:
            r5 = r3
        L_0x01ae:
            if (r5 == 0) goto L_0x01b7
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r10 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x01b8
        L_0x01b7:
            r5 = r3
        L_0x01b8:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x01ca
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r0 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r5)
            if (r0 == 0) goto L_0x01ca
            boolean r0 = r0.isPayTypeAndLocked()
            if (r0 != r1) goto L_0x01ca
            r0 = r1
            goto L_0x01cb
        L_0x01ca:
            r0 = r2
        L_0x01cb:
            if (r0 == 0) goto L_0x01d0
            r6.shortPlayGuideShowCommon(r7, r1)
        L_0x01d0:
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x01de
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x01df
        L_0x01de:
            r5 = r3
        L_0x01df:
            if (r5 == 0) goto L_0x01e8
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r10 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x01e9
        L_0x01e8:
            r5 = r3
        L_0x01e9:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x01fb
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r0 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r5)
            if (r0 == 0) goto L_0x01fb
            boolean r0 = r0.isCollectionLockType()
            if (r0 != r1) goto L_0x01fb
            r0 = r1
            goto L_0x01fc
        L_0x01fb:
            r0 = r2
        L_0x01fc:
            if (r0 == 0) goto L_0x0224
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideDownload r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideDownload
            r0.<init>(r1)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayVideoAction r0 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayVideoAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideCopyLink r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideCopyLink
            r0.<init>(r1)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideShare r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideShare
            r0.<init>(r1)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            goto L_0x0275
        L_0x0224:
            boolean r0 = com.baidu.searchbox.video.feedflow.detail.challenge.challengefromcomment.ChallengeUtilsKt.isFromCommentChallenge$default((com.baidu.searchbox.feed.detail.frame.Store) r7, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3, (int) r1, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x0275
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideDownload r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideDownload
            r0.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0242
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0243
        L_0x0242:
            r5 = r3
        L_0x0243:
            if (r5 == 0) goto L_0x024c
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r10 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x024d
        L_0x024c:
            r5 = r3
        L_0x024d:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r5 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r5
            if (r5 == 0) goto L_0x025e
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = r5.getData()
            if (r0 == 0) goto L_0x025e
            boolean r0 = r0.isShareShow()
            if (r0 != r1) goto L_0x025e
            goto L_0x025f
        L_0x025e:
            r1 = r2
        L_0x025f:
            if (r1 == 0) goto L_0x0275
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideCopyLink r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideCopyLink
            r0.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideShare r0 = new com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction$HideShare
            r0.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
        L_0x0275:
            r19.updatePlayerUbcContentAction(r20)
            r0 = r20
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0286
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0287
        L_0x0286:
            r4 = r3
        L_0x0287:
            if (r4 == 0) goto L_0x028f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r3 = r4.select(r3)
        L_0x028f:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r3 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r3
            if (r3 == 0) goto L_0x084a
            r0 = r3
            r1 = 0
            boolean r3 = r0.getVisible()
            if (r3 == 0) goto L_0x02a6
            androidx.lifecycle.MutableLiveData r3 = r0.getViewStatusChange()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3.setValue(r2)
        L_0x02a6:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x084a
        L_0x02ac:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            if (r0 == 0) goto L_0x02e3
            r0 = r20
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x02be
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x02bf
        L_0x02be:
            r4 = r3
        L_0x02bf:
            if (r4 == 0) goto L_0x02c7
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r3 = r4.select(r3)
        L_0x02c7:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r3 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r3
            if (r3 == 0) goto L_0x084a
            r0 = r3
            r1 = 0
            boolean r3 = r0.isTryOpenPaymentPanel()
            if (r3 == 0) goto L_0x02dd
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$CancelPayment r3 = com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.CancelPayment.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r7.dispatch(r3)
            r0.setTryOpenPaymentPanel(r2)
        L_0x02dd:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x084a
        L_0x02e3:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoViewCoveredChanged
            if (r0 == 0) goto L_0x0323
            r0 = r20
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x02f5
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x02f6
        L_0x02f5:
            r4 = r3
        L_0x02f6:
            if (r4 == 0) goto L_0x02fe
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r3 = r4.select(r3)
        L_0x02fe:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r3 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r3
            if (r3 == 0) goto L_0x084a
            r0 = r3
            r1 = 0
            boolean r3 = r0.isTryOpenPaymentPanel()
            if (r3 == 0) goto L_0x031d
            r3 = r8
            com.baidu.searchbox.video.feedflow.flow.list.VideoViewCoveredChanged r3 = (com.baidu.searchbox.video.feedflow.flow.list.VideoViewCoveredChanged) r3
            boolean r3 = r3.isCovered()
            if (r3 == 0) goto L_0x031d
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$CancelPayment r3 = com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.CancelPayment.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r7.dispatch(r3)
            r0.setTryOpenPaymentPanel(r2)
        L_0x031d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x084a
        L_0x0323:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.DetailModelDispatchSuccess
            if (r0 == 0) goto L_0x034d
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.DetailModelDispatchSuccess r0 = (com.baidu.searchbox.video.feedflow.detail.DetailModelDispatchSuccess) r0
            boolean r0 = r0.isActive()
            if (r0 == 0) goto L_0x084a
            com.baidu.searchbox.feed.detail.frame.State r0 = r20.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            java.lang.String r0 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPd(r0)
            boolean r0 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isPdFromFeedAd(r0)
            if (r0 == 0) goto L_0x084a
            r2 = 0
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r19
            r1 = r20
            handleAlsUpload$default(r0, r1, r2, r3, r4, r5)
            goto L_0x084a
        L_0x034d:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction
            r4 = -1
            if (r0 == 0) goto L_0x0577
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0360
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0361
        L_0x0360:
            r10 = r3
        L_0x0361:
            if (r10 == 0) goto L_0x036a
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x036b
        L_0x036a:
            r10 = r3
        L_0x036b:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 == 0) goto L_0x0377
            boolean r0 = r10.getVisible()
            if (r0 != r1) goto L_0x0377
            r0 = r1
            goto L_0x0378
        L_0x0377:
            r0 = r2
        L_0x0378:
            if (r0 == 0) goto L_0x0436
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction r0 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction) r0
            r5 = r20
            r10 = 0
            com.baidu.searchbox.feed.detail.frame.State r11 = r5.getState()
            boolean r12 = r11 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r12 == 0) goto L_0x038b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            goto L_0x038c
        L_0x038b:
            r11 = r3
        L_0x038c:
            if (r11 == 0) goto L_0x0395
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r12 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r11 = r11.select(r12)
            goto L_0x0396
        L_0x0395:
            r11 = r3
        L_0x0396:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r11 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r11
            if (r11 == 0) goto L_0x039f
            java.lang.String r5 = r11.getNid()
            goto L_0x03a0
        L_0x039f:
            r5 = r3
        L_0x03a0:
            boolean r0 = r0.containsNid(r5)
            if (r0 == 0) goto L_0x0436
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x03b4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x03b5
        L_0x03b4:
            r10 = r3
        L_0x03b5:
            if (r10 == 0) goto L_0x03be
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x03bf
        L_0x03be:
            r10 = r3
        L_0x03bf:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 == 0) goto L_0x03cb
            boolean r0 = r10.getHasReceived()
            if (r0 != 0) goto L_0x03cb
            r0 = r1
            goto L_0x03cc
        L_0x03cb:
            r0 = r2
        L_0x03cc:
            if (r0 == 0) goto L_0x0436
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x03dc
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x03dd
        L_0x03dc:
            r10 = r3
        L_0x03dd:
            if (r10 == 0) goto L_0x03e6
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x03e7
        L_0x03e6:
            r10 = r3
        L_0x03e7:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 != 0) goto L_0x03ec
            goto L_0x03ef
        L_0x03ec:
            r10.setHasReceived(r1)
        L_0x03ef:
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x03fd
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x03fe
        L_0x03fd:
            r10 = r3
        L_0x03fe:
            if (r10 == 0) goto L_0x0407
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r11 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x0408
        L_0x0407:
            r10 = r3
        L_0x0408:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r10 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r10
            if (r10 == 0) goto L_0x0417
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r10.getRunTimeStatus()
            if (r0 == 0) goto L_0x0417
            int r0 = r0.getPosition()
            goto L_0x0418
        L_0x0417:
            r0 = r4
        L_0x0418:
            if (r0 < 0) goto L_0x0430
            com.baidu.searchbox.video.feedflow.detail.RequestDetailData r5 = new com.baidu.searchbox.video.feedflow.detail.RequestDetailData
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 30
            r18 = 0
            r10 = r5
            r11 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            com.baidu.searchbox.feed.detail.frame.Action r5 = (com.baidu.searchbox.feed.detail.frame.Action) r5
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r5)
        L_0x0430:
            r19.updatePlayerUbcContentAction(r20)
            r6.shortPlayGuideShowCommon(r7, r2)
        L_0x0436:
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0444
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0445
        L_0x0444:
            r10 = r3
        L_0x0445:
            if (r10 == 0) goto L_0x044e
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x044f
        L_0x044e:
            r10 = r3
        L_0x044f:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 == 0) goto L_0x045b
            boolean r0 = r10.getHasReceived()
            if (r0 != 0) goto L_0x045b
            r0 = r1
            goto L_0x045c
        L_0x045b:
            r0 = r2
        L_0x045c:
            if (r0 == 0) goto L_0x084a
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction r0 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction) r0
            r5 = r20
            r10 = 0
            com.baidu.searchbox.feed.detail.frame.State r11 = r5.getState()
            boolean r12 = r11 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r12 == 0) goto L_0x046f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            goto L_0x0470
        L_0x046f:
            r11 = r3
        L_0x0470:
            if (r11 == 0) goto L_0x0479
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r12 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r11 = r11.select(r12)
            goto L_0x047a
        L_0x0479:
            r11 = r3
        L_0x047a:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r11 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r11
            java.lang.String r5 = ","
            if (r11 == 0) goto L_0x04ab
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r10 = r11.getData()
            if (r10 == 0) goto L_0x04ab
            com.baidu.searchbox.flowvideo.detail.repos.UnLockCollInfoModel r10 = r10.getUnLockCollInfo()
            if (r10 == 0) goto L_0x04ab
            java.lang.String r10 = r10.getPlayLetUnids()
            if (r10 == 0) goto L_0x04ab
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.String[] r12 = new java.lang.String[]{r5}
            r13 = 0
            r14 = 0
            r15 = 6
            r16 = 0
            java.util.List r10 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r11, (java.lang.String[]) r12, (boolean) r13, (int) r14, (int) r15, (java.lang.Object) r16)
            if (r10 == 0) goto L_0x04ab
            java.lang.Object r10 = kotlin.collections.CollectionsKt.getOrNull(r10, r2)
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x04ac
        L_0x04ab:
            r10 = r3
        L_0x04ac:
            boolean r0 = r0.containsNid(r10)
            if (r0 != 0) goto L_0x0516
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction r0 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction) r0
            r10 = r20
            r11 = 0
            com.baidu.searchbox.feed.detail.frame.State r12 = r10.getState()
            boolean r13 = r12 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r13 == 0) goto L_0x04c3
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r12 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r12
            goto L_0x04c4
        L_0x04c3:
            r12 = r3
        L_0x04c4:
            if (r12 == 0) goto L_0x04cd
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r13 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r12 = r12.select(r13)
            goto L_0x04ce
        L_0x04cd:
            r12 = r3
        L_0x04ce:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r12 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r12
            if (r12 == 0) goto L_0x050f
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r10 = r12.getData()
            if (r10 == 0) goto L_0x050f
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailBottomEntryModel r10 = r10.getBottomEntry()
            if (r10 == 0) goto L_0x050f
            com.baidu.searchbox.flowvideo.detail.repos.NextCollItemModel r10 = r10.getNextColl()
            if (r10 == 0) goto L_0x050f
            com.baidu.searchbox.flowvideo.detail.repos.NextCollVideoDataModel r10 = r10.getData()
            if (r10 == 0) goto L_0x050f
            com.baidu.searchbox.flowvideo.detail.repos.UnLockCollInfoModel r10 = r10.getUnLockCollInfo()
            if (r10 == 0) goto L_0x050f
            java.lang.String r10 = r10.getPlayLetUnids()
            if (r10 == 0) goto L_0x050f
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.String[] r12 = new java.lang.String[]{r5}
            r13 = 0
            r14 = 0
            r15 = 6
            r16 = 0
            java.util.List r5 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r11, (java.lang.String[]) r12, (boolean) r13, (int) r14, (int) r15, (java.lang.Object) r16)
            if (r5 == 0) goto L_0x050f
            java.lang.Object r2 = kotlin.collections.CollectionsKt.getOrNull(r5, r2)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0510
        L_0x050f:
            r2 = r3
        L_0x0510:
            boolean r0 = r0.containsNid(r2)
            if (r0 == 0) goto L_0x084a
        L_0x0516:
            r0 = r20
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0524
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0525
        L_0x0524:
            r5 = r3
        L_0x0525:
            if (r5 == 0) goto L_0x052e
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r10 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x052f
        L_0x052e:
            r5 = r3
        L_0x052f:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r5 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r5
            if (r5 != 0) goto L_0x0534
            goto L_0x0537
        L_0x0534:
            r5.setHasReceived(r1)
        L_0x0537:
            r0 = r20
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r2 = r0.getState()
            boolean r5 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0545
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x0546
        L_0x0545:
            r2 = r3
        L_0x0546:
            if (r2 == 0) goto L_0x054e
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r2.select(r3)
        L_0x054e:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            if (r3 == 0) goto L_0x055c
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r3.getRunTimeStatus()
            if (r0 == 0) goto L_0x055c
            int r4 = r0.getPosition()
        L_0x055c:
            r0 = r4
            if (r0 < 0) goto L_0x084a
            com.baidu.searchbox.video.feedflow.detail.RequestDetailData r1 = new com.baidu.searchbox.video.feedflow.detail.RequestDetailData
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 30
            r18 = 0
            r10 = r1
            r11 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r1)
            goto L_0x084a
        L_0x0577:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction
            if (r0 == 0) goto L_0x0766
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction r0 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction) r0
            boolean r0 = r0.isUnlockAllSuccess()
            if (r0 == 0) goto L_0x069a
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0592
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0593
        L_0x0592:
            r10 = r3
        L_0x0593:
            if (r10 == 0) goto L_0x059c
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x059d
        L_0x059c:
            r10 = r3
        L_0x059d:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 == 0) goto L_0x05a9
            boolean r0 = r10.getVisible()
            if (r0 != r1) goto L_0x05a9
            r0 = r1
            goto L_0x05aa
        L_0x05a9:
            r0 = r2
        L_0x05aa:
            if (r0 == 0) goto L_0x069a
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x05ba
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x05bb
        L_0x05ba:
            r10 = r3
        L_0x05bb:
            if (r10 == 0) goto L_0x05c4
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r11 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x05c5
        L_0x05c4:
            r10 = r3
        L_0x05c5:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r10 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r10
            if (r10 == 0) goto L_0x05da
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = r10.getData()
            if (r0 == 0) goto L_0x05da
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailBottomEntryModel r0 = r0.getBottomEntry()
            if (r0 == 0) goto L_0x05da
            java.lang.String r0 = r0.getCollId()
            goto L_0x05db
        L_0x05da:
            r0 = r3
        L_0x05db:
            r5 = r8
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction r5 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction) r5
            java.lang.String r5 = r5.getCollId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x069a
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x05f6
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x05f7
        L_0x05f6:
            r10 = r3
        L_0x05f7:
            if (r10 == 0) goto L_0x0600
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x0601
        L_0x0600:
            r10 = r3
        L_0x0601:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 == 0) goto L_0x060d
            boolean r0 = r10.getHasReceived()
            if (r0 != 0) goto L_0x060d
            r0 = r1
            goto L_0x060e
        L_0x060d:
            r0 = r2
        L_0x060e:
            if (r0 == 0) goto L_0x069a
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x061e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x061f
        L_0x061e:
            r10 = r3
        L_0x061f:
            if (r10 == 0) goto L_0x0628
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x0629
        L_0x0628:
            r10 = r3
        L_0x0629:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 != 0) goto L_0x062e
            goto L_0x0631
        L_0x062e:
            r10.setHasReceived(r1)
        L_0x0631:
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x063f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0640
        L_0x063f:
            r10 = r3
        L_0x0640:
            if (r10 == 0) goto L_0x0649
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x064a
        L_0x0649:
            r10 = r3
        L_0x064a:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 == 0) goto L_0x0653
            r10.reset()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0653:
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0661
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0662
        L_0x0661:
            r10 = r3
        L_0x0662:
            if (r10 == 0) goto L_0x066b
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r11 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x066c
        L_0x066b:
            r10 = r3
        L_0x066c:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r10 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r10
            if (r10 == 0) goto L_0x067b
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r10.getRunTimeStatus()
            if (r0 == 0) goto L_0x067b
            int r0 = r0.getPosition()
            goto L_0x067c
        L_0x067b:
            r0 = r4
        L_0x067c:
            if (r0 < 0) goto L_0x0694
            com.baidu.searchbox.video.feedflow.detail.RequestDetailData r5 = new com.baidu.searchbox.video.feedflow.detail.RequestDetailData
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 30
            r18 = 0
            r10 = r5
            r11 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            com.baidu.searchbox.feed.detail.frame.Action r5 = (com.baidu.searchbox.feed.detail.frame.Action) r5
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r5)
        L_0x0694:
            r19.updatePlayerUbcContentAction(r20)
            r6.shortPlayGuideShowCommon(r7, r2)
        L_0x069a:
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction r0 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction) r0
            boolean r0 = r0.isUnlockAllSuccess()
            if (r0 == 0) goto L_0x084a
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x06b1
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x06b2
        L_0x06b1:
            r10 = r3
        L_0x06b2:
            if (r10 == 0) goto L_0x06bb
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r11 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x06bc
        L_0x06bb:
            r10 = r3
        L_0x06bc:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r10 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r10
            if (r10 == 0) goto L_0x06d1
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = r10.getData()
            if (r0 == 0) goto L_0x06d1
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailBottomEntryModel r0 = r0.getBottomEntry()
            if (r0 == 0) goto L_0x06d1
            java.lang.String r0 = r0.getCollId()
            goto L_0x06d2
        L_0x06d1:
            r0 = r3
        L_0x06d2:
            r5 = r8
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction r5 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction) r5
            java.lang.String r5 = r5.getCollId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x084a
            r0 = r20
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x06ed
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x06ee
        L_0x06ed:
            r10 = r3
        L_0x06ee:
            if (r10 == 0) goto L_0x06f7
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x06f8
        L_0x06f7:
            r10 = r3
        L_0x06f8:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 == 0) goto L_0x0703
            boolean r0 = r10.getHasReceived()
            if (r0 != 0) goto L_0x0703
            r2 = r1
        L_0x0703:
            if (r2 == 0) goto L_0x084a
            r0 = r20
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0713
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0714
        L_0x0713:
            r5 = r3
        L_0x0714:
            if (r5 == 0) goto L_0x071d
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r10 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x071e
        L_0x071d:
            r5 = r3
        L_0x071e:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r5 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r5
            if (r5 != 0) goto L_0x0723
            goto L_0x0726
        L_0x0723:
            r5.setHasReceived(r1)
        L_0x0726:
            r0 = r20
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r2 = r0.getState()
            boolean r5 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0734
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x0735
        L_0x0734:
            r2 = r3
        L_0x0735:
            if (r2 == 0) goto L_0x073d
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r2.select(r3)
        L_0x073d:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            if (r3 == 0) goto L_0x074b
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r3.getRunTimeStatus()
            if (r0 == 0) goto L_0x074b
            int r4 = r0.getPosition()
        L_0x074b:
            r0 = r4
            if (r0 < 0) goto L_0x084a
            com.baidu.searchbox.video.feedflow.detail.RequestDetailData r1 = new com.baidu.searchbox.video.feedflow.detail.RequestDetailData
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 30
            r18 = 0
            r10 = r1
            r11 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r1)
            goto L_0x084a
        L_0x0766:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.ext.common.RequestAction
            if (r0 == 0) goto L_0x0799
            r0 = r8
            com.baidu.searchbox.feed.detail.ext.common.RequestAction r0 = (com.baidu.searchbox.feed.detail.ext.common.RequestAction) r0
            com.baidu.searchbox.feed.detail.ext.common.RequestParam r0 = r0.getParams()
            boolean r1 = r0 instanceof com.baidu.searchbox.flowvideo.shortplaypayment.repos.ShortPlayPaymentParam
            if (r1 == 0) goto L_0x0778
            com.baidu.searchbox.flowvideo.shortplaypayment.repos.ShortPlayPaymentParam r0 = (com.baidu.searchbox.flowvideo.shortplaypayment.repos.ShortPlayPaymentParam) r0
            goto L_0x0779
        L_0x0778:
            r0 = r3
        L_0x0779:
            if (r0 == 0) goto L_0x084a
            r1 = 0
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            r10 = r2
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            r11 = r2
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            r12 = 0
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware$apply$5$1 r2 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware$apply$5$1
            r2.<init>(r6, r0, r7, r3)
            r13 = r2
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r14 = 2
            r15 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)
            goto L_0x084a
        L_0x0799:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged
            if (r0 == 0) goto L_0x07df
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged r0 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged) r0
            boolean r0 = r0.isFullScreen()
            if (r0 != 0) goto L_0x084a
            r0 = r20
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x07b4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x07b5
        L_0x07b4:
            r5 = r3
        L_0x07b5:
            if (r5 == 0) goto L_0x07bd
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r5.select(r3)
        L_0x07bd:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            if (r3 == 0) goto L_0x07ce
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r0 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r3)
            if (r0 == 0) goto L_0x07ce
            boolean r0 = r0.isPayTypeAndLocked()
            if (r0 != r1) goto L_0x07ce
            goto L_0x07cf
        L_0x07ce:
            r1 = r2
        L_0x07cf:
            if (r1 == 0) goto L_0x084a
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware$apply$6 r1 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware$apply$6
            r1.<init>(r7)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r0.post(r1)
            goto L_0x084a
        L_0x07df:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PayPanelResult
            if (r0 == 0) goto L_0x084a
            r0 = r8
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayPanelResult r0 = (com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PayPanelResult) r0
            java.lang.String r0 = r0.getResult()
            if (r0 == 0) goto L_0x0839
            r3 = 0
            r4 = r8
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayPanelResult r4 = (com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PayPanelResult) r4
            int r4 = r4.getStatus()
            int r5 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_ORDER_CREATED
            if (r4 != r5) goto L_0x07fb
            r5 = r1
            goto L_0x0802
        L_0x07fb:
            int r5 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_RECHARGE_ORDER_CREATED
            if (r4 != r5) goto L_0x0801
            r5 = r1
            goto L_0x0802
        L_0x0801:
            r5 = r2
        L_0x0802:
            if (r5 == 0) goto L_0x0815
            r2 = r8
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayPanelResult r2 = (com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PayPanelResult) r2
            int r2 = r2.getStatus()
            boolean r2 = r6.isNeedUploadAls(r7, r2)
            if (r2 == 0) goto L_0x0834
            r6.handleAlsUpload(r7, r1, r0)
            goto L_0x0834
        L_0x0815:
            int r5 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_RECHARGE_SUCCESS
            if (r4 != r5) goto L_0x081b
            goto L_0x0821
        L_0x081b:
            int r5 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_SUCCESS
            if (r4 != r5) goto L_0x0820
            goto L_0x0821
        L_0x0820:
            r1 = r2
        L_0x0821:
            if (r1 == 0) goto L_0x0834
            r1 = r8
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayPanelResult r1 = (com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PayPanelResult) r1
            int r1 = r1.getStatus()
            boolean r1 = r6.isNeedUploadAls(r7, r1)
            if (r1 == 0) goto L_0x0834
            r1 = 2
            r6.handleAlsUpload(r7, r1, r0)
        L_0x0834:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0839:
            r0 = r8
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayPanelResult r0 = (com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PayPanelResult) r0
            int r0 = r0.getStatus()
            r1 = r8
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayPanelResult r1 = (com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PayPanelResult) r1
            java.lang.String r1 = r1.getResult()
            r6.handlePayPanelResult(r7, r0, r1)
        L_0x084a:
            com.baidu.searchbox.feed.detail.frame.Action r0 = r9.next(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x019b A[SYNTHETIC, Splitter:B:132:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x023d A[Catch:{ JSONException -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x025e A[Catch:{ JSONException -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0261 A[Catch:{ JSONException -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0264 A[Catch:{ JSONException -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x026b A[Catch:{ JSONException -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0270 A[Catch:{ JSONException -> 0x02a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:258:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handlePayPanelResult(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r25, int r26, java.lang.String r27) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            int r0 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_AGAIN
            r5 = 0
            r6 = 1
            if (r3 == r0) goto L_0x0015
            int r0 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_SUCCESS
            if (r3 != r0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = r5
            goto L_0x0016
        L_0x0015:
            r0 = r6
        L_0x0016:
            r7 = r0
            r8 = 0
            if (r7 != 0) goto L_0x003f
            int r0 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_PANEL_DISMISS
            if (r3 == r0) goto L_0x003f
            r0 = r25
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x002c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x002d
        L_0x002c:
            r10 = r8
        L_0x002d:
            if (r10 == 0) goto L_0x0036
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x0037
        L_0x0036:
            r10 = r8
        L_0x0037:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 != 0) goto L_0x003c
            goto L_0x003f
        L_0x003c:
            r10.setPayResult(r5)
        L_0x003f:
            int r0 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_AGAIN
            if (r3 != r0) goto L_0x0064
            r0 = r25
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0051
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0052
        L_0x0051:
            r10 = r8
        L_0x0052:
            if (r10 == 0) goto L_0x005b
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x005c
        L_0x005b:
            r10 = r8
        L_0x005c:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r10 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r10
            if (r10 != 0) goto L_0x0061
            goto L_0x0064
        L_0x0061:
            r10.setPayAgain(r6)
        L_0x0064:
            r0 = r25
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r0.getState()
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x0072
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10
            goto L_0x0073
        L_0x0072:
            r10 = r8
        L_0x0073:
            if (r10 == 0) goto L_0x007c
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r11 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r10 = r10.select(r11)
            goto L_0x007d
        L_0x007c:
            r10 = r8
        L_0x007d:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r10 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r10
            if (r10 == 0) goto L_0x0092
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = r10.getData()
            if (r0 == 0) goto L_0x0092
            com.baidu.searchbox.flowvideo.detail.repos.PlayletFloatLayerModel r0 = r0.getPaidPlayletFloatLayer()
            if (r0 == 0) goto L_0x0092
            java.lang.String r0 = r0.getCollId()
            goto L_0x0093
        L_0x0092:
            r0 = r8
        L_0x0093:
            java.lang.String r9 = ""
            if (r0 != 0) goto L_0x0098
            r0 = r9
        L_0x0098:
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x00a3
            r10 = r6
            goto L_0x00a4
        L_0x00a3:
            r10 = r5
        L_0x00a4:
            if (r10 == 0) goto L_0x00fe
            r10 = r25
            r11 = 0
            com.baidu.searchbox.feed.detail.frame.State r12 = r10.getState()
            boolean r13 = r12 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r13 == 0) goto L_0x00b4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r12 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r12
            goto L_0x00b5
        L_0x00b4:
            r12 = r8
        L_0x00b5:
            if (r12 == 0) goto L_0x00be
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.banner.BannerState> r13 = com.baidu.searchbox.video.feedflow.detail.banner.BannerState.class
            java.lang.Object r12 = r12.select(r13)
            goto L_0x00bf
        L_0x00be:
            r12 = r8
        L_0x00bf:
            com.baidu.searchbox.video.feedflow.detail.banner.BannerState r12 = (com.baidu.searchbox.video.feedflow.detail.banner.BannerState) r12
            if (r12 == 0) goto L_0x00ce
            com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModel r10 = r12.getModel()
            if (r10 == 0) goto L_0x00ce
            java.lang.String r10 = r10.getJumpType()
            goto L_0x00cf
        L_0x00ce:
            r10 = r8
        L_0x00cf:
            boolean r10 = com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModelKt.isShortPlayCashierType(r10)
            if (r10 == 0) goto L_0x00fe
            r10 = r25
            r11 = 0
            com.baidu.searchbox.feed.detail.frame.State r12 = r10.getState()
            boolean r13 = r12 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r13 == 0) goto L_0x00e3
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r12 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r12
            goto L_0x00e4
        L_0x00e3:
            r12 = r8
        L_0x00e4:
            if (r12 == 0) goto L_0x00ed
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.banner.BannerState> r13 = com.baidu.searchbox.video.feedflow.detail.banner.BannerState.class
            java.lang.Object r12 = r12.select(r13)
            goto L_0x00ee
        L_0x00ed:
            r12 = r8
        L_0x00ee:
            com.baidu.searchbox.video.feedflow.detail.banner.BannerState r12 = (com.baidu.searchbox.video.feedflow.detail.banner.BannerState) r12
            if (r12 == 0) goto L_0x00f7
            java.lang.String r10 = r12.getCollId()
            goto L_0x00f8
        L_0x00f7:
            r10 = r8
        L_0x00f8:
            if (r10 != 0) goto L_0x00fb
            r10 = r9
        L_0x00fb:
            r0 = r10
            goto L_0x0160
        L_0x00fe:
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0109
            r10 = r6
            goto L_0x010a
        L_0x0109:
            r10 = r5
        L_0x010a:
            if (r10 == 0) goto L_0x0160
            r10 = r25
            r11 = 0
            com.baidu.searchbox.feed.detail.frame.State r12 = r10.getState()
            boolean r13 = r12 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r13 == 0) goto L_0x011a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r12 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r12
            goto L_0x011b
        L_0x011a:
            r12 = r8
        L_0x011b:
            if (r12 == 0) goto L_0x0124
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState> r13 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState.class
            java.lang.Object r12 = r12.select(r13)
            goto L_0x0125
        L_0x0124:
            r12 = r8
        L_0x0125:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState r12 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState) r12
            if (r12 == 0) goto L_0x0132
            boolean r10 = r12.isSupportShortPlayPayBtn()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x0133
        L_0x0132:
            r10 = r8
        L_0x0133:
            boolean r10 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r10)
            if (r10 == 0) goto L_0x0160
            r10 = r25
            r11 = 0
            com.baidu.searchbox.feed.detail.frame.State r12 = r10.getState()
            boolean r13 = r12 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r13 == 0) goto L_0x0147
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r12 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r12
            goto L_0x0148
        L_0x0147:
            r12 = r8
        L_0x0148:
            if (r12 == 0) goto L_0x0151
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState> r13 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState.class
            java.lang.Object r12 = r12.select(r13)
            goto L_0x0152
        L_0x0151:
            r12 = r8
        L_0x0152:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState r12 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState) r12
            if (r12 == 0) goto L_0x015b
            java.lang.String r10 = r12.getShortPlayCollId()
            goto L_0x015c
        L_0x015b:
            r10 = r8
        L_0x015c:
            if (r10 != 0) goto L_0x015f
            r10 = r9
        L_0x015f:
            r0 = r10
        L_0x0160:
            java.lang.String r10 = "sv_"
            r11 = 2
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r0, r10, r5, r11, r8)
            if (r12 == 0) goto L_0x016c
            r10 = r0
            goto L_0x017d
        L_0x016c:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.StringBuilder r10 = r12.append(r10)
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r10 = r10.toString()
        L_0x017d:
            if (r4 == 0) goto L_0x018b
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            r0 = r0 ^ r6
            if (r0 != r6) goto L_0x018b
            r0 = r6
            goto L_0x018c
        L_0x018b:
            r0 = r5
        L_0x018c:
            if (r0 == 0) goto L_0x0194
            int r0 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_SUCCESS
            if (r3 != r0) goto L_0x0194
            r0 = r6
            goto L_0x0195
        L_0x0194:
            r0 = r5
        L_0x0195:
            r12 = r0
            java.lang.String r0 = "completeInfo"
            if (r12 == 0) goto L_0x02b0
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02ab }
            r13.<init>(r4)     // Catch:{ JSONException -> 0x02ab }
            java.lang.String r14 = "pay_type"
            java.lang.String r14 = r13.optString(r14)     // Catch:{ JSONException -> 0x02ab }
            java.lang.String r15 = "nids"
            java.lang.String r15 = r13.optString(r15)     // Catch:{ JSONException -> 0x02ab }
            r1.setIsChooseVirtualPayAutoUnlock(r2, r13, r10)     // Catch:{ JSONException -> 0x02ab }
            java.lang.String r11 = "single_whole"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x02ab }
            if (r11 == 0) goto L_0x01f1
            com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper r0 = com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper.Impl.get()     // Catch:{ JSONException -> 0x01ec }
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockEvent r9 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockEvent     // Catch:{ JSONException -> 0x01ec }
            r9.<init>(r6, r10, r8)     // Catch:{ JSONException -> 0x01ec }
            r0.post(r9)     // Catch:{ JSONException -> 0x01ec }
            r0 = r25
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r11 = r0.getState()     // Catch:{ JSONException -> 0x01ec }
            boolean r8 = r11 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x01ec }
            if (r8 == 0) goto L_0x01d4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11     // Catch:{ JSONException -> 0x01ec }
            goto L_0x01d5
        L_0x01d4:
            r11 = 0
        L_0x01d5:
            if (r11 == 0) goto L_0x01de
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r8 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r8 = r11.select(r8)     // Catch:{ JSONException -> 0x01ec }
            goto L_0x01df
        L_0x01de:
            r8 = 0
        L_0x01df:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r8 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r8     // Catch:{ JSONException -> 0x01ec }
            if (r8 != 0) goto L_0x01e7
        L_0x01e3:
            r17 = r7
            goto L_0x0324
        L_0x01e7:
            r0 = 3
            r8.setPayResult(r0)     // Catch:{ JSONException -> 0x01ec }
            goto L_0x01e3
        L_0x01ec:
            r0 = move-exception
            r17 = r7
            goto L_0x0324
        L_0x01f1:
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap     // Catch:{ JSONException -> 0x02ab }
            r8.<init>()     // Catch:{ JSONException -> 0x02ab }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ JSONException -> 0x02ab }
            r11 = r15
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ JSONException -> 0x02ab }
            if (r11 == 0) goto L_0x0206
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ JSONException -> 0x01ec }
            if (r11 == 0) goto L_0x0204
            goto L_0x0206
        L_0x0204:
            r11 = r5
            goto L_0x0207
        L_0x0206:
            r11 = r6
        L_0x0207:
            java.lang.String r6 = "nidListString"
            if (r11 == 0) goto L_0x023d
            r11 = r25
            r16 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r11.getState()     // Catch:{ JSONException -> 0x02ab }
            r17 = r7
            boolean r7 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x02a8 }
            if (r7 == 0) goto L_0x021d
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5     // Catch:{ JSONException -> 0x02a8 }
            goto L_0x021e
        L_0x021d:
            r5 = 0
        L_0x021e:
            if (r5 == 0) goto L_0x0227
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r7 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r5 = r5.select(r7)     // Catch:{ JSONException -> 0x02a8 }
            goto L_0x0228
        L_0x0227:
            r5 = 0
        L_0x0228:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r5 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r5     // Catch:{ JSONException -> 0x02a8 }
            if (r5 == 0) goto L_0x0237
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r5 = r5.getData()     // Catch:{ JSONException -> 0x02a8 }
            if (r5 == 0) goto L_0x0237
            java.lang.String r5 = r5.getNid()     // Catch:{ JSONException -> 0x02a8 }
            goto L_0x0238
        L_0x0237:
            r5 = 0
        L_0x0238:
            if (r5 != 0) goto L_0x023b
            goto L_0x0243
        L_0x023b:
            r9 = r5
            goto L_0x0243
        L_0x023d:
            r17 = r7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r6)     // Catch:{ JSONException -> 0x02a8 }
            r9 = r15
        L_0x0243:
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x02a8 }
            com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper r0 = com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper.Impl.get()     // Catch:{ JSONException -> 0x02a8 }
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockEvent r5 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockEvent     // Catch:{ JSONException -> 0x02a8 }
            r7 = 0
            r5.<init>(r7, r10, r8)     // Catch:{ JSONException -> 0x02a8 }
            r0.post(r5)     // Catch:{ JSONException -> 0x02a8 }
            r0 = r25
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r0.getState()     // Catch:{ JSONException -> 0x02a8 }
            boolean r9 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x02a8 }
            if (r9 == 0) goto L_0x0261
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7     // Catch:{ JSONException -> 0x02a8 }
            goto L_0x0262
        L_0x0261:
            r7 = 0
        L_0x0262:
            if (r7 == 0) goto L_0x026b
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r9 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r7 = r7.select(r9)     // Catch:{ JSONException -> 0x02a8 }
            goto L_0x026c
        L_0x026b:
            r7 = 0
        L_0x026c:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r7 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r7     // Catch:{ JSONException -> 0x02a8 }
            if (r7 == 0) goto L_0x02a6
            r0 = r7
            r5 = 0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r6)     // Catch:{ JSONException -> 0x02a8 }
            r18 = r15
            java.lang.CharSequence r18 = (java.lang.CharSequence) r18     // Catch:{ JSONException -> 0x02a8 }
            java.lang.String r6 = ","
            java.lang.String[] r19 = new java.lang.String[]{r6}     // Catch:{ JSONException -> 0x02a8 }
            r20 = 0
            r21 = 0
            r22 = 6
            r23 = 0
            java.util.List r6 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r18, (java.lang.String[]) r19, (boolean) r20, (int) r21, (int) r22, (java.lang.Object) r23)     // Catch:{ JSONException -> 0x02a8 }
            r0.setNidList(r6)     // Catch:{ JSONException -> 0x02a8 }
            java.util.List r6 = r0.getNidList()     // Catch:{ JSONException -> 0x02a8 }
            if (r6 == 0) goto L_0x0299
            int r6 = r6.size()     // Catch:{ JSONException -> 0x02a8 }
            goto L_0x029a
        L_0x0299:
            r6 = 0
        L_0x029a:
            r7 = 1
            if (r6 <= r7) goto L_0x029f
            r11 = 2
            goto L_0x02a0
        L_0x029f:
            r11 = 1
        L_0x02a0:
            r0.setPayResult(r11)     // Catch:{ JSONException -> 0x02a8 }
            goto L_0x0324
        L_0x02a6:
            goto L_0x0324
        L_0x02a8:
            r0 = move-exception
            goto L_0x0324
        L_0x02ab:
            r0 = move-exception
            r17 = r7
            goto L_0x0324
        L_0x02b0:
            r17 = r7
            int r5 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_AGAIN
            if (r3 != r5) goto L_0x031d
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.Map r5 = (java.util.Map) r5
            r6 = r25
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r6.getState()
            boolean r11 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r11 == 0) goto L_0x02cb
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x02cc
        L_0x02cb:
            r8 = 0
        L_0x02cc:
            if (r8 == 0) goto L_0x02d5
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r11 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r8 = r8.select(r11)
            goto L_0x02d6
        L_0x02d5:
            r8 = 0
        L_0x02d6:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r8 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r8
            if (r8 == 0) goto L_0x02e5
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r6 = r8.getData()
            if (r6 == 0) goto L_0x02e5
            java.lang.String r6 = r6.getNid()
            goto L_0x02e6
        L_0x02e5:
            r6 = 0
        L_0x02e6:
            if (r6 != 0) goto L_0x02e9
            goto L_0x02ea
        L_0x02e9:
            r9 = r6
        L_0x02ea:
            r5.put(r0, r9)
            com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper r0 = com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper.Impl.get()
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockEvent r6 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockEvent
            r7 = 0
            r6.<init>(r7, r10, r5)
            r0.post(r6)
            r0 = r25
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r0.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0308
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0309
        L_0x0308:
            r7 = 0
        L_0x0309:
            if (r7 == 0) goto L_0x0312
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r8 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0313
        L_0x0312:
            r7 = 0
        L_0x0313:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r7 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r7
            if (r7 != 0) goto L_0x0318
            goto L_0x0324
        L_0x0318:
            r6 = 1
            r7.setPayResult(r6)
            goto L_0x0324
        L_0x031d:
            int r0 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_PANEL_BOTTOM_BAR_CLICK
            if (r3 != r0) goto L_0x0324
            r1.handlePayPanelBottomBarClick(r2, r4)
        L_0x0324:
            r0 = r25
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0332
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0333
        L_0x0332:
            r6 = 0
        L_0x0333:
            if (r6 == 0) goto L_0x033c
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r7 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r8 = r6.select(r7)
            goto L_0x033d
        L_0x033c:
            r8 = 0
        L_0x033d:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r8 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r8
            if (r8 == 0) goto L_0x0374
            r0 = r8
            r5 = 0
            if (r12 == 0) goto L_0x034d
            boolean r6 = r0.isSupportBeanPay()
            if (r6 == 0) goto L_0x034d
            r7 = 1
            goto L_0x034e
        L_0x034d:
            r7 = 0
        L_0x034e:
            r6 = r7
            int r7 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_PANEL_SHOW
            if (r3 != r7) goto L_0x0360
            androidx.lifecycle.MutableLiveData r7 = r0.getPayPanelVisible()
            r8 = 1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r7.setValue(r8)
            goto L_0x0372
        L_0x0360:
            int r7 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_PANEL_DISMISS
            if (r3 == r7) goto L_0x0366
            if (r6 == 0) goto L_0x0372
        L_0x0366:
            androidx.lifecycle.MutableLiveData r7 = r0.getPayPanelVisible()
            r8 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r7.setValue(r8)
        L_0x0372:
        L_0x0374:
            int r0 = com.baidu.searchbox.video.detail.export.IVideoPaymentUtils.PAY_PANEL_DISMISS
            if (r3 != r0) goto L_0x037f
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShortPlayPayToastAction r0 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShortPlayPayToastAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r2, r0)
        L_0x037f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware.handlePayPanelResult(com.baidu.searchbox.feed.detail.frame.Store, int, java.lang.String):void");
    }

    private final void handlePayPanelBottomBarClick(Store<CommonState> store, String result) {
        CharSequence charSequence = result;
        if (!(charSequence == null || charSequence.length() == 0)) {
            try {
                Result.Companion companion = Result.Companion;
                ShortPlayPaymentGuideMiddleware shortPlayPaymentGuideMiddleware = this;
                JSONObject $this$handlePayPanelBottomBarClick_u24lambda_u2d9_u24lambda_u2d8 = new JSONObject(result);
                String optString = $this$handlePayPanelBottomBarClick_u24lambda_u2d9_u24lambda_u2d8.optString("bottom_click_x");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(\"bottom_click_x\")");
                float x = Float.parseFloat(optString);
                String optString2 = $this$handlePayPanelBottomBarClick_u24lambda_u2d9_u24lambda_u2d8.optString("bottom_click_y");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"bottom_click_y\")");
                StoreExtKt.post(store, new ShortPlayPayPanelBottomClick(new Pair(Float.valueOf(x), Float.valueOf(Float.parseFloat(optString2)))));
                Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    private final void updatePlayerUbcContentAction(Store<CommonState> store) {
        DIFactory.INSTANCE.post(new ShortPlayPaymentGuideMiddleware$updatePlayerUbcContentAction$1(store));
    }

    private final void shortPlayGuideShowCommon(Store<CommonState> store, boolean status) {
        if (CommonStateExtKt.isActive(store)) {
            StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchToOnlyBackStyle(false, status));
            CommonState state = store.getState();
            MutableLiveData<Boolean> mutableLiveData = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            ShortPlayPaymentGuideState shortPlayPaymentGuideState = (ShortPlayPaymentGuideState) (commonState != null ? commonState.select(ShortPlayPaymentGuideState.class) : null);
            if (shortPlayPaymentGuideState != null) {
                mutableLiveData = shortPlayPaymentGuideState.getGuideEnable();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(!status));
            }
            if (!this.hasFling) {
                StoreExtKt.post(store, new MoreFlowAction.SwitchEnable(!status));
            }
            this.hasFling = false;
        }
    }

    private final boolean isNeedUploadAls(Store<CommonState> store, int status) {
        if (status == IVideoPaymentUtils.PAY_SUCCESS || status == IVideoPaymentUtils.PAY_ORDER_CREATED) {
            CommonState state = store.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            if (commonState != null) {
                obj = commonState.select(ShortPlayPaymentGuideState.class);
            }
            ShortPlayPaymentGuideState shortPlayPaymentGuideState = (ShortPlayPaymentGuideState) obj;
            if (shortPlayPaymentGuideState != null && shortPlayPaymentGuideState.isSupportBeanPay()) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void handleAlsUpload$default(ShortPlayPaymentGuideMiddleware shortPlayPaymentGuideMiddleware, Store store, int i2, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "";
        }
        shortPlayPaymentGuideMiddleware.handleAlsUpload(store, i2, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleAlsUpload(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r16, int r17, java.lang.String r18) {
        /*
            r15 = this;
            r9 = r18
            r0 = 0
            java.lang.String r1 = ""
            r0 = 0
            java.lang.String r2 = ""
            r0 = 0
            java.lang.String r3 = ""
            r0 = 0
            java.lang.String r4 = ""
            r5 = 1
            r6 = 0
            if (r17 == 0) goto L_0x007a
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x001d
            r0 = r5
            goto L_0x001e
        L_0x001d:
            r0 = r6
        L_0x001e:
            if (r0 == 0) goto L_0x007a
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x006b }
            r0 = r15
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware r0 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware) r0     // Catch:{ all -> 0x006b }
            r7 = 0
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x006b }
            r8.<init>(r9)     // Catch:{ all -> 0x006b }
            r10 = r8
            r11 = 0
            java.lang.String r12 = "order_id"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ all -> 0x006b }
            java.lang.String r13 = "optString(KEY_RESULT_ORDER_ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ all -> 0x006b }
            r2 = r12
            java.lang.String r12 = "pay_price"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ all -> 0x006b }
            java.lang.String r13 = "optString(KEY_RESULT_PAY_PRICE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ all -> 0x006b }
            r3 = r12
            java.lang.String r12 = "pay_type"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ all -> 0x006b }
            java.lang.String r13 = "optString(KEY_RESULT_PAY_TYPE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ all -> 0x006b }
            r4 = r12
            java.lang.String r12 = "nids"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ all -> 0x006b }
            java.lang.String r13 = "optString(KEY_RESULT_NID_LIST)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ all -> 0x006b }
            r1 = r12
            kotlin.Result.m8971constructorimpl(r8)     // Catch:{ all -> 0x006b }
            goto L_0x0075
        L_0x006b:
            r0 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x0075:
            r0 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            goto L_0x007e
        L_0x007a:
            r0 = r1
            r10 = r2
            r11 = r3
            r12 = r4
        L_0x007e:
            java.lang.String r1 = "single_whole"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r1)
            java.lang.String r2 = ""
            r3 = 0
            if (r1 == 0) goto L_0x008d
            r5 = r2
            goto L_0x00c2
        L_0x008d:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r5 = r6
        L_0x0098:
            if (r5 == 0) goto L_0x00c1
            r1 = r16
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r1.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x00a8
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00a9
        L_0x00a8:
            r5 = r3
        L_0x00a9:
            if (r5 == 0) goto L_0x00b2
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r6 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x00b3
        L_0x00b2:
            r5 = r3
        L_0x00b3:
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5
            if (r5 == 0) goto L_0x00ba
            java.lang.String r1 = r5.nid
            goto L_0x00bb
        L_0x00ba:
            r1 = r3
        L_0x00bb:
            if (r1 != 0) goto L_0x00bf
            r5 = r2
            goto L_0x00c2
        L_0x00bf:
            r5 = r1
            goto L_0x00c2
        L_0x00c1:
            r5 = r0
        L_0x00c2:
            if (r17 != 0) goto L_0x00ee
            r1 = r16
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r1.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x00d3
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x00d4
        L_0x00d3:
            r6 = r3
        L_0x00d4:
            if (r6 == 0) goto L_0x00dd
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x00de
        L_0x00dd:
            r6 = r3
        L_0x00de:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x00e7
            java.lang.String r1 = com.baidu.searchbox.video.detail.core.IntextDataExtKt.getAuthorCollId(r6)
            goto L_0x00e8
        L_0x00e7:
            r1 = r3
        L_0x00e8:
            if (r1 != 0) goto L_0x00ec
            r4 = r2
            goto L_0x00f7
        L_0x00ec:
            r4 = r1
            goto L_0x00f7
        L_0x00ee:
            java.lang.String r1 = r15.getCurrentCollId(r16)
            if (r1 != 0) goto L_0x00f6
            r4 = r2
            goto L_0x00f7
        L_0x00f6:
            r4 = r1
        L_0x00f7:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayAlsAction r13 = new com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayAlsAction
            r1 = r16
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r1.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x010a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x010b
        L_0x010a:
            r7 = r3
        L_0x010b:
            if (r7 == 0) goto L_0x0114
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0115
        L_0x0114:
            r7 = r3
        L_0x0115:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x011c
            java.lang.String r1 = r7.adExt
            goto L_0x011d
        L_0x011c:
            r1 = r3
        L_0x011d:
            if (r1 != 0) goto L_0x0121
            r6 = r2
            goto L_0x0122
        L_0x0121:
            r6 = r1
        L_0x0122:
            r1 = r16
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r1.getState()
            boolean r14 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r14 == 0) goto L_0x0132
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x0133
        L_0x0132:
            r8 = r3
        L_0x0133:
            if (r8 == 0) goto L_0x013c
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r14 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r8 = r8.select(r14)
            goto L_0x013d
        L_0x013c:
            r8 = r3
        L_0x013d:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r8 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r8
            if (r8 == 0) goto L_0x0151
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r1 = r8.getData()
            if (r1 == 0) goto L_0x0151
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailAuthorModel r1 = r1.getAuthor()
            if (r1 == 0) goto L_0x0151
            java.lang.String r3 = r1.getId()
        L_0x0151:
            if (r3 != 0) goto L_0x0155
            r7 = r2
            goto L_0x0156
        L_0x0155:
            r7 = r3
        L_0x0156:
            r1 = r13
            r2 = r17
            r3 = r6
            r6 = r7
            r7 = r10
            r8 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            com.baidu.searchbox.feed.detail.frame.Action r13 = (com.baidu.searchbox.feed.detail.frame.Action) r13
            r1 = r16
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideMiddleware.handleAlsUpload(com.baidu.searchbox.feed.detail.frame.Store, int, java.lang.String):void");
    }

    private final String getCurrentCollId(Store<CommonState> store) {
        FlowDetailModel data;
        PlayletFloatLayerModel paidPlayletFloatLayer;
        CommonState state = store.getState();
        String str = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        CollectionPanelState collectionPanelState = (CollectionPanelState) (commonState != null ? commonState.select(CollectionPanelState.class) : null);
        String collId = collectionPanelState != null ? collectionPanelState.getShortPlayCollId() : null;
        String str2 = "";
        if (collId == null) {
            collId = str2;
        }
        boolean z = true;
        if (collId.length() == 0) {
            CommonState state2 = store.getState();
            CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
            FlowDetailState flowDetailState = (FlowDetailState) (commonState2 != null ? commonState2.select(FlowDetailState.class) : null);
            String collId2 = (flowDetailState == null || (data = flowDetailState.getData()) == null || (paidPlayletFloatLayer = data.getPaidPlayletFloatLayer()) == null) ? null : paidPlayletFloatLayer.getCollId();
            if (collId2 == null) {
                collId2 = str2;
            }
            collId = collId2;
        }
        if (collId.length() != 0) {
            z = false;
        }
        if (z) {
            CommonState state3 = store.getState();
            CommonState commonState3 = state3 instanceof CommonState ? state3 : null;
            BannerState bannerState = (BannerState) (commonState3 != null ? commonState3.select(BannerState.class) : null);
            if (bannerState != null) {
                str = bannerState.getCollId();
            }
            if (str != null) {
                str2 = str;
            }
            collId = str2;
        }
        return VidUtilsKt.vid2Nid(collId);
    }

    private final void setIsChooseVirtualPayAutoUnlock(Store<CommonState> store, JSONObject resultJson, String collId) {
        Pair<Boolean, String> shortPlayVirtualPayAutoUnlock;
        JSONObject $this$setIsChooseVirtualPayAutoUnlock_u24lambda_u2d12 = resultJson;
        if ($this$setIsChooseVirtualPayAutoUnlock_u24lambda_u2d12.has("auto_unlock")) {
            CommonState state = store.getState();
            Boolean originAutoUnlock = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            FlowState curFlowState = (FlowState) (commonState != null ? commonState.select(FlowState.class) : null);
            boolean isAutoUnlock = Intrinsics.areEqual((Object) $this$setIsChooseVirtualPayAutoUnlock_u24lambda_u2d12.optString("auto_unlock"), (Object) "1");
            if (!(curFlowState == null || (shortPlayVirtualPayAutoUnlock = curFlowState.getShortPlayVirtualPayAutoUnlock()) == null)) {
                originAutoUnlock = shortPlayVirtualPayAutoUnlock.getFirst();
            }
            if (!Intrinsics.areEqual((Object) Boolean.valueOf(isAutoUnlock), (Object) originAutoUnlock) && curFlowState != null) {
                curFlowState.setShortPlayVirtualPayAutoUnlock(new Pair(Boolean.valueOf(isAutoUnlock), collId));
            }
        }
    }
}
