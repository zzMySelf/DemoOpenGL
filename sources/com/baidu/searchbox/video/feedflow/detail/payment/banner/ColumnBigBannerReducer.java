package com.baidu.searchbox.video.feedflow.detail.payment.banner;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/banner/ColumnBigBannerReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColumnBigBannerReducer.kt */
public final class ColumnBigBannerReducer implements Reducer<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v91, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX WARNING: type inference failed for: r1v23, types: [com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r8, com.baidu.searchbox.feed.detail.frame.Action r9) {
        /*
            r7 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            r1 = 0
            if (r0 == 0) goto L_0x0046
            r0 = r9
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r0 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r0
            java.lang.Object r0 = r0.getData()
            boolean r2 = r0 instanceof com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel
            if (r2 == 0) goto L_0x001f
            r1 = r0
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r1 = (com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel) r1
        L_0x001f:
            if (r1 == 0) goto L_0x0044
            r0 = r1
            r1 = 0
            r2 = r8
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r4 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r2 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r2
            if (r2 == 0) goto L_0x0043
            r3 = 0
            com.baidu.searchbox.flowvideo.detail.repos.PaymentModel r4 = r0.getPaymentModel()
            if (r4 == 0) goto L_0x0043
            r5 = 0
            androidx.lifecycle.MutableLiveData r6 = r2.getData()
            r6.setValue(r4)
            r2.setPaymentModel(r4)
        L_0x0043:
        L_0x0044:
            goto L_0x01fd
        L_0x0046:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.payment.banner.OnColumnBigBannerShownAction
            if (r0 == 0) goto L_0x0059
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x01fd
            r0.onViewShown()
            goto L_0x01fd
        L_0x0059:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.payment.banner.OnColumnBigBannerHiddenAction
            r2 = 0
            if (r0 == 0) goto L_0x006f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 != 0) goto L_0x006a
            goto L_0x01fd
        L_0x006a:
            r0.setShowing(r2)
            goto L_0x01fd
        L_0x006f:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim
            r3 = 1
            if (r0 == 0) goto L_0x0099
            r0 = r8
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r4 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x0084
            androidx.lifecycle.MutableLiveData r1 = r0.getAnimatorShowView()
        L_0x0084:
            if (r1 != 0) goto L_0x0088
            goto L_0x01fd
        L_0x0088:
            r0 = r9
            com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim r0 = (com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim) r0
            boolean r0 = r0.isStart()
            r0 = r0 ^ r3
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
            goto L_0x01fd
        L_0x0099:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerLongPressSpeed
            if (r0 == 0) goto L_0x00d7
            r0 = r8
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r4 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x00ad
            androidx.lifecycle.MutableLiveData r1 = r0.getAnimatorShowView()
        L_0x00ad:
            if (r1 != 0) goto L_0x00b0
            goto L_0x00bf
        L_0x00b0:
            r0 = r9
            com.baidu.searchbox.video.feedflow.detail.player.PlayerLongPressSpeed r0 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerLongPressSpeed) r0
            boolean r0 = r0.isStart()
            r0 = r0 ^ r3
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
        L_0x00bf:
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 != 0) goto L_0x00cb
            goto L_0x01fd
        L_0x00cb:
            r1 = r9
            com.baidu.searchbox.video.feedflow.detail.player.PlayerLongPressSpeed r1 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerLongPressSpeed) r1
            boolean r1 = r1.isStart()
            r0.setLongPressSpeed(r1)
            goto L_0x01fd
        L_0x00d7:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationLockClick
            if (r0 == 0) goto L_0x0100
            r0 = r8
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r4 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x00eb
            androidx.lifecycle.MutableLiveData r1 = r0.getAnimatorShowView()
        L_0x00eb:
            if (r1 != 0) goto L_0x00ef
            goto L_0x01fd
        L_0x00ef:
            r0 = r9
            com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationLockClick r0 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationLockClick) r0
            boolean r0 = r0.isLock()
            r0 = r0 ^ r3
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
            goto L_0x01fd
        L_0x0100:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.flow.list.WindowFocusChanged
            if (r0 == 0) goto L_0x0131
            r0 = r8
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            boolean r0 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r0)
            if (r0 == 0) goto L_0x01fd
            r0 = r8
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x011d
            androidx.lifecycle.MutableLiveData r1 = r0.getAnimatorShowView()
        L_0x011d:
            if (r1 != 0) goto L_0x0121
            goto L_0x01fd
        L_0x0121:
            r0 = r9
            com.baidu.searchbox.video.feedflow.flow.list.WindowFocusChanged r0 = (com.baidu.searchbox.video.feedflow.flow.list.WindowFocusChanged) r0
            boolean r0 = r0.getHasFocus()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
            goto L_0x01fd
        L_0x0131:
            boolean r0 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnBindData
            if (r0 == 0) goto L_0x0144
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x01fd
            r0.reset()
            goto L_0x01fd
        L_0x0144:
            boolean r0 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            if (r0 == 0) goto L_0x0157
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x01fd
            r0.resetSetting()
            goto L_0x01fd
        L_0x0157:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle
            if (r0 == 0) goto L_0x0174
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x0169
            androidx.lifecycle.MutableLiveData r1 = r0.getUpdateViewUI()
        L_0x0169:
            if (r1 != 0) goto L_0x016d
            goto L_0x01fd
        L_0x016d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
            goto L_0x01fd
        L_0x0174:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.payment.banner.OnColumnBigBannerExitBtnClickAction
            if (r0 == 0) goto L_0x0189
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 != 0) goto L_0x0184
            goto L_0x01fd
        L_0x0184:
            r0.setExitClicked(r3)
            goto L_0x01fd
        L_0x0189:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.night.NightModeChanged
            if (r0 == 0) goto L_0x01a4
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x019b
            androidx.lifecycle.MutableLiveData r1 = r0.getChangeNightMode()
        L_0x019b:
            if (r1 != 0) goto L_0x019e
            goto L_0x01fd
        L_0x019e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
            goto L_0x01fd
        L_0x01a4:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.payment.lastframe.ColumnLastFrameTimerCompleteAction
            if (r0 == 0) goto L_0x01c1
            r0 = r8
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x01b8
            androidx.lifecycle.MutableLiveData r1 = r0.getTimerComplete()
        L_0x01b8:
            if (r1 != 0) goto L_0x01bb
            goto L_0x01fd
        L_0x01bb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
            goto L_0x01fd
        L_0x01c1:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction.PaySuccess
            if (r0 == 0) goto L_0x01d9
            boolean r0 = r8.isActive()
            if (r0 == 0) goto L_0x01fd
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r8.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x01fd
            r0.reset()
            goto L_0x01fd
        L_0x01d9:
            boolean r0 = r9 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame
            if (r0 == 0) goto L_0x01fd
            r0 = r8
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState> r4 = com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerState) r0
            if (r0 == 0) goto L_0x01fd
            r1 = 0
            com.baidu.searchbox.flowvideo.detail.repos.PaymentModel r4 = r0.getPaymentModel()
            if (r4 == 0) goto L_0x01f7
            boolean r4 = r4.isPaid()
            if (r4 != r3) goto L_0x01f7
            r2 = r3
        L_0x01f7:
            if (r2 == 0) goto L_0x01fc
            r0.reset()
        L_0x01fc:
        L_0x01fd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.banner.ColumnBigBannerReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
