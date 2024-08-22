package com.baidu.searchbox.video.feedflow.detail.payment;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/PaymentItemLayoutReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentItemLayoutReducer.kt */
public final class PaymentItemLayoutReducer implements Reducer<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: androidx.lifecycle.MutableLiveData<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX WARNING: type inference failed for: r1v14, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r9, com.baidu.searchbox.feed.detail.frame.Action r10) {
        /*
            r8 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle
            r1 = 0
            if (r0 == 0) goto L_0x0033
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x001f
            androidx.lifecycle.MutableLiveData r1 = r0.getSwitchLayoutStyle()
        L_0x001f:
            if (r1 != 0) goto L_0x0023
            goto L_0x023f
        L_0x0023:
            r0 = r10
            com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle r0 = (com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle) r0
            boolean r0 = r0.isLandscapeFlow()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
            goto L_0x023f
        L_0x0033:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent
            if (r0 == 0) goto L_0x005d
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x0045
            androidx.lifecycle.MutableLiveData r1 = r0.getUpdateLayoutFromPage()
        L_0x0045:
            if (r1 != 0) goto L_0x0049
            goto L_0x023f
        L_0x0049:
            r0 = r9
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            java.lang.String r0 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPage(r0)
            boolean r0 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFeedLayoutStyle(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
            goto L_0x023f
        L_0x005d:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00bf
            r0 = r10
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r0 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r0
            java.lang.Object r0 = r0.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel
            if (r4 == 0) goto L_0x0071
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = (com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel) r0
            goto L_0x0072
        L_0x0071:
            r0 = r1
        L_0x0072:
            if (r0 == 0) goto L_0x023f
            r4 = 0
            boolean r5 = r0.isOffLineVideo()
            if (r5 != 0) goto L_0x00bc
            java.lang.String r5 = r0.getBanner()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x00bc
            r5 = r9
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState> r7 = com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState r5 = (com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState) r5
            if (r5 == 0) goto L_0x009e
            r6 = r9
            com.baidu.searchbox.feed.detail.frame.AbsState r6 = (com.baidu.searchbox.feed.detail.frame.AbsState) r6
            boolean r5 = r5.isPaymentCollectionPanelColumn(r6)
            if (r5 != r2) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r2 = r3
        L_0x009f:
            if (r2 == 0) goto L_0x00bc
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r2 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r2 = r9.select(r2)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r2 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r2
            if (r2 == 0) goto L_0x00b1
            androidx.lifecycle.MutableLiveData r1 = r2.getUpdateBannerContainerBottomMargin()
        L_0x00b1:
            if (r1 != 0) goto L_0x00b5
            goto L_0x00bc
        L_0x00b5:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r1.setValue(r2)
        L_0x00bc:
            goto L_0x023f
        L_0x00bf:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnBindData
            if (r0 == 0) goto L_0x00f2
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x00d2
            androidx.lifecycle.MutableLiveData r0 = r0.getUpdateBannerContainerBottomMargin()
            goto L_0x00d3
        L_0x00d2:
            r0 = r1
        L_0x00d3:
            if (r0 != 0) goto L_0x00d7
            goto L_0x023f
        L_0x00d7:
            com.baidu.searchbox.video.feedflow.di.DIFactory r2 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r2 = r2.getAppContext()
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x00ed
            int r1 = com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X083
            int r1 = r2.getDimensionPixelSize(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x00ed:
            r0.setValue(r1)
            goto L_0x023f
        L_0x00f2:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.error.NetErrorVisibleChanged
            if (r0 == 0) goto L_0x010f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x0102
            goto L_0x023f
        L_0x0102:
            r1 = r10
            com.baidu.searchbox.video.feedflow.detail.error.NetErrorVisibleChanged r1 = (com.baidu.searchbox.video.feedflow.detail.error.NetErrorVisibleChanged) r1
            boolean r1 = r1.isVisible()
            r1 = r1 ^ r2
            r0.setWeakAnimEnable(r1)
            goto L_0x023f
        L_0x010f:
            boolean r0 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            if (r0 == 0) goto L_0x0131
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x0120
            r0.weakAnimShow(r3)
        L_0x0120:
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x012c
            goto L_0x023f
        L_0x012c:
            r0.setColumnLastFrameShowing(r3)
            goto L_0x023f
        L_0x0131:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameShownAction
            if (r0 == 0) goto L_0x0146
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x0141
            goto L_0x023f
        L_0x0141:
            r0.setColumnLastFrameShowing(r2)
            goto L_0x023f
        L_0x0146:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameShownAction
            if (r0 == 0) goto L_0x015b
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x0156
            goto L_0x023f
        L_0x0156:
            r0.setColumnLastFrameShowing(r2)
            goto L_0x023f
        L_0x015b:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameHiddenAction
            if (r0 == 0) goto L_0x0170
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x016b
            goto L_0x023f
        L_0x016b:
            r0.setColumnLastFrameShowing(r3)
            goto L_0x023f
        L_0x0170:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameHiddenAction
            if (r0 == 0) goto L_0x0185
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x0180
            goto L_0x023f
        L_0x0180:
            r0.setColumnLastFrameShowing(r3)
            goto L_0x023f
        L_0x0185:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged
            if (r0 == 0) goto L_0x01e1
            r0 = r10
            com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged r0 = (com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged) r0
            int r0 = r0.getScrollState()
            switch(r0) {
                case 0: goto L_0x01d1;
                case 1: goto L_0x0194;
                default: goto L_0x0193;
            }
        L_0x0193:
            goto L_0x01e0
        L_0x0194:
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState> r0 = com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState r0 = (com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState) r0
            if (r0 == 0) goto L_0x01a6
            boolean r0 = r0.isFullScreen()
            if (r0 != 0) goto L_0x01a6
            r0 = r2
            goto L_0x01a7
        L_0x01a6:
            r0 = r3
        L_0x01a7:
            if (r0 == 0) goto L_0x023f
            boolean r0 = r9.isActive()
            if (r0 == 0) goto L_0x023f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x01c0
            boolean r0 = r0.getColumnLastFrameShowing()
            if (r0 != r2) goto L_0x01c0
            r3 = r2
        L_0x01c0:
            if (r3 != 0) goto L_0x023f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x023f
            r0.weakAnimShow(r2)
            goto L_0x023f
        L_0x01d1:
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r0 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r9.select(r0)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x01e0
            r0.weakAnimShow(r3)
            goto L_0x023f
        L_0x01e0:
            goto L_0x023f
        L_0x01e1:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.player.OnKernelPivotResetAction
            if (r0 == 0) goto L_0x020e
            r0 = r9
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r4 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x01f5
            androidx.lifecycle.MutableLiveData r1 = r0.getOnKernelPivotReset()
        L_0x01f5:
            if (r1 != 0) goto L_0x01f8
            goto L_0x01fd
        L_0x01f8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
        L_0x01fd:
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r2 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x020a
            goto L_0x023f
        L_0x020a:
            r0.setScaling(r3)
            goto L_0x023f
        L_0x020e:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerTouchBeginGestureAction
            if (r0 == 0) goto L_0x0223
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 != 0) goto L_0x021f
            goto L_0x023f
        L_0x021f:
            r0.setScaling(r2)
            goto L_0x023f
        L_0x0223:
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarHeightChange
            if (r0 == 0) goto L_0x023f
            r0 = r9
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState r0 = (com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutState) r0
            if (r0 == 0) goto L_0x0237
            androidx.lifecycle.MutableLiveData r1 = r0.getUpdateBottomBarLayout()
        L_0x0237:
            if (r1 != 0) goto L_0x023a
            goto L_0x023f
        L_0x023a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
        L_0x023f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemLayoutReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
