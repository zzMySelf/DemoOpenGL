package com.baidu.searchbox.video.feedflow.flow.guide;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/guide/FlowScrollUpGuideMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowScrollUpGuideMiddleware.kt */
public final class FlowScrollUpGuideMiddleware implements Middleware<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r11, com.baidu.searchbox.feed.detail.frame.Action r12, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = r12 instanceof com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x00da
            r0 = r12
            com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess r0 = (com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess) r0
            java.lang.Object r0 = r0.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.flowvideo.flow.api.FlowListBean
            if (r4 == 0) goto L_0x0026
            com.baidu.searchbox.flowvideo.flow.api.FlowListBean r0 = (com.baidu.searchbox.flowvideo.flow.api.FlowListBean) r0
            goto L_0x0027
        L_0x0026:
            r0 = r3
        L_0x0027:
            if (r0 == 0) goto L_0x0161
            r4 = 0
            r5 = r12
            com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess r5 = (com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess) r5
            int r5 = r5.getType()
            boolean r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowActionManifestKt.isRequestFromFlow(r5)
            if (r5 == 0) goto L_0x006d
            java.util.List r5 = r0.getItems()
            if (r5 == 0) goto L_0x0042
            int r5 = r5.size()
            goto L_0x0043
        L_0x0042:
            r5 = r2
        L_0x0043:
            if (r5 <= 0) goto L_0x006d
            r5 = r11
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r5.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0052
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0053
        L_0x0052:
            r7 = r3
        L_0x0053:
            if (r7 == 0) goto L_0x005c
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x005d
        L_0x005c:
            r7 = r3
        L_0x005d:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x0064
            java.lang.String r5 = r7.page
            goto L_0x0065
        L_0x0064:
            r5 = r3
        L_0x0065:
            boolean r5 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromSearch(r5)
            if (r5 != 0) goto L_0x006d
            r5 = r1
            goto L_0x006e
        L_0x006d:
            r5 = r2
        L_0x006e:
            r6 = r12
            com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess r6 = (com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess) r6
            int r6 = r6.getType()
            boolean r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowActionManifestKt.isRequestFromFlow(r6)
            if (r6 == 0) goto L_0x00ba
            java.util.List r6 = r0.getItems()
            if (r6 == 0) goto L_0x0087
            int r6 = r6.size()
            goto L_0x0088
        L_0x0087:
            r6 = r2
        L_0x0088:
            if (r6 <= 0) goto L_0x00ba
            r6 = r11
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r6.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x0097
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x0098
        L_0x0097:
            r8 = r3
        L_0x0098:
            if (r8 == 0) goto L_0x00a1
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r9 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x00a2
        L_0x00a1:
            r8 = r3
        L_0x00a2:
            com.baidu.searchbox.video.detail.core.model.IntentData r8 = (com.baidu.searchbox.video.detail.core.model.IntentData) r8
            if (r8 == 0) goto L_0x00a8
            java.lang.String r3 = r8.page
        L_0x00a8:
            boolean r3 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromSearch(r3)
            if (r3 == 0) goto L_0x00ba
            com.baidu.searchbox.video.feedflow.common.FlowSwitchState r3 = com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt.flowSwitchState((com.baidu.searchbox.feed.detail.frame.Store<?>) r11)
            boolean r3 = r3.getFlowUnDownCountSwitch()
            if (r3 == 0) goto L_0x00ba
            r3 = r1
            goto L_0x00bb
        L_0x00ba:
            r3 = r2
        L_0x00bb:
            com.baidu.searchbox.feed.detail.frame.State r6 = r11.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState> r8 = com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState.class
            java.lang.Object r6 = r6.select(r8)
            com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState r6 = (com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState) r6
            if (r6 != 0) goto L_0x00ce
            goto L_0x00d7
        L_0x00ce:
            if (r5 != 0) goto L_0x00d4
            if (r3 == 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r1 = r2
        L_0x00d4:
            r6.setCanShowGuide(r1)
        L_0x00d7:
            goto L_0x0161
        L_0x00da:
            boolean r0 = r12 instanceof com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged
            if (r0 == 0) goto L_0x011e
            r0 = r12
            com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged r0 = (com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged) r0
            int r0 = r0.getScrollState()
            if (r0 != r1) goto L_0x0161
            r0 = r11
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x00f4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x00f5
        L_0x00f4:
            r4 = r3
        L_0x00f5:
            if (r4 == 0) goto L_0x00fd
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState> r3 = com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState.class
            java.lang.Object r3 = r4.select(r3)
        L_0x00fd:
            com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState r3 = (com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState) r3
            if (r3 == 0) goto L_0x0161
            r0 = r3
            r2 = 0
            androidx.lifecycle.MutableLiveData r3 = r0.isShowGuide()
            java.lang.Object r3 = r3.getValue()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x011c
            com.baidu.searchbox.video.feedflow.flow.guide.StopScrollUpGuideAction r1 = com.baidu.searchbox.video.feedflow.flow.guide.StopScrollUpGuideAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r11, r1)
        L_0x011c:
            goto L_0x0161
        L_0x011e:
            boolean r0 = r12 instanceof com.baidu.searchbox.video.component.guide.GuideAction.OnGuideScrollUpStartAction
            r4 = 2
            if (r0 == 0) goto L_0x012e
            com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction r0 = new com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction
            r0.<init>(r1, r2, r4, r3)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r11, r0)
            goto L_0x0161
        L_0x012e:
            boolean r0 = r12 instanceof com.baidu.searchbox.video.component.guide.GuideAction.OnGuideScrollUpStopAction
            if (r0 == 0) goto L_0x013d
            com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction r0 = new com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction
            r0.<init>(r2, r2, r4, r3)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r11, r0)
            goto L_0x0161
        L_0x013d:
            boolean r0 = r12 instanceof com.baidu.searchbox.video.feedflow.detail.player.OnVulcanThreeDivideGuideVisibleChangedAction
            if (r0 == 0) goto L_0x0153
            com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction r0 = new com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction
            r1 = r12
            com.baidu.searchbox.video.feedflow.detail.player.OnVulcanThreeDivideGuideVisibleChangedAction r1 = (com.baidu.searchbox.video.feedflow.detail.player.OnVulcanThreeDivideGuideVisibleChangedAction) r1
            boolean r1 = r1.isVisible()
            r0.<init>(r1, r2, r4, r3)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r11, r0)
            goto L_0x0161
        L_0x0153:
            boolean r0 = r12 instanceof com.baidu.searchbox.video.feedflow.flow.guide.SevenDayUnScrollUpStartGuideAction
            if (r0 == 0) goto L_0x0161
            com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction r0 = new com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction
            r0.<init>(r1, r1)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r11, r0)
        L_0x0161:
            com.baidu.searchbox.feed.detail.frame.Action r0 = r13.next(r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }
}
