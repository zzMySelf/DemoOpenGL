package com.baidu.searchbox.video.feedflow.detail.nextbigcard;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.widget.PanelDragStatus;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardAction;
import com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardPanelView;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/nextbigcard/NextBigCardComponent$initNextBigCardPanelView$1$1", "Lcom/baidu/searchbox/video/feedflow/detail/nextbigcard/NextBigCardPanelView$INextBigCardListener;", "onClickNonPanelArea", "", "onClickPanelArea", "onCloseBtnClick", "onDismiss", "onEndDragging", "panelState", "Lcom/baidu/searchbox/player/widget/PanelDragStatus;", "isUp", "", "isClick", "onPanelStatusChanged", "oldPanelStatus", "newPanelStatus", "onStartDragging", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NextBigCardComponent.kt */
public final class NextBigCardComponent$initNextBigCardPanelView$1$1 implements NextBigCardPanelView.INextBigCardListener {
    final /* synthetic */ NextBigCardPanelView $this_apply;
    final /* synthetic */ NextBigCardComponent this$0;

    NextBigCardComponent$initNextBigCardPanelView$1$1(NextBigCardComponent $receiver, NextBigCardPanelView $receiver2) {
        this.this$0 = $receiver;
        this.$this_apply = $receiver2;
    }

    public void onVerticalDrag(int distance, PanelDragStatus panelState) {
        NextBigCardPanelView.INextBigCardListener.DefaultImpls.onVerticalDrag(this, distance, panelState);
    }

    public void onStartDragging() {
        this.this$0.stopCountDownTime();
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, NextBigCardAction.OnPanelStartDragAction.INSTANCE);
        }
    }

    public void onEndDragging(PanelDragStatus panelState, boolean isUp, boolean isClick) {
        Intrinsics.checkNotNullParameter(panelState, "panelState");
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new NextBigCardAction.OnPanelDragEndAction(panelState, isUp, isClick));
        }
    }

    public void onDismiss() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new NextBigCardAction.NextBigCardPanelShowOrHide(false));
        }
        this.$this_apply.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        r5 = r5.getBaseConfigData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCloseBtnClick() {
        /*
            r7 = this;
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardComponent r0 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            if (r0 == 0) goto L_0x000f
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardAction$OnClickCloseBtnAction r1 = com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardAction.OnClickCloseBtnAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x000f:
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardComponent r0 = r7.this$0
            com.baidu.searchbox.video.feedflow.detail.relatedsearch.switcher.ConfigRecordData r0 = r0.getRecordData()
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardComponent r1 = r7.this$0
            r2 = 0
            int r3 = r0.getRecordCloseBtnClick()
            r4 = 1
            int r3 = r3 + r4
            r0.setRecordCloseBtnClick(r3)
            int r3 = r0.getRecordCloseBtnClick()
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.switcher.NextBigCardConfigData r5 = r1.getConfig()
            if (r5 == 0) goto L_0x003a
            com.baidu.searchbox.video.feedflow.detail.relatedsearch.switcher.BaseConfigData r5 = r5.getBaseConfigData()
            if (r5 == 0) goto L_0x003a
            int r5 = r5.getCloseBtnClick()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x003b
        L_0x003a:
            r5 = 0
        L_0x003b:
            int r5 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r5)
            r6 = 0
            if (r4 > r5) goto L_0x0045
            if (r5 > r3) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r4 = r6
        L_0x0046:
            if (r4 == 0) goto L_0x004f
            long r3 = com.baidu.searchbox.video.detail.utils.TimeUtilsKt.getCurDayZeroHourS()
            r0.setRecordCloseTime(r3)
        L_0x004f:
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.switcher.NextBigCardSpHelper r3 = com.baidu.searchbox.video.feedflow.detail.nextbigcard.switcher.NextBigCardSpHelper.INSTANCE
            java.lang.String r1 = r1.getSceneConfig()
            r3.updateNextBigCardRecordData(r1, r0)
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardPanelView r0 = r7.$this_apply
            r0.closePanel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardComponent$initNextBigCardPanelView$1$1.onCloseBtnClick():void");
    }

    public void onClickPanelArea() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, NextBigCardAction.OnClickPanelAreaAction.INSTANCE);
        }
        IFlowComponentService iFlowComponentService = (IFlowComponentService) this.this$0.getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService != null) {
            iFlowComponentService.scrollToNext();
        }
    }

    public void onClickNonPanelArea() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, NextBigCardAction.OnClickPanelNonAreaAction.INSTANCE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPanelStatusChanged(com.baidu.searchbox.player.widget.PanelDragStatus r6, com.baidu.searchbox.player.widget.PanelDragStatus r7) {
        /*
            r5 = this;
            java.lang.String r0 = "oldPanelStatus"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "newPanelStatus"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardComponent r0 = r5.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x002c
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0021
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0022
        L_0x0021:
            r3 = r1
        L_0x0022:
            if (r3 == 0) goto L_0x002a
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState> r1 = com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x002a:
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState r1 = (com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardState) r1
        L_0x002c:
            if (r1 != 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            r0 = 0
            r1.setAnimShowing(r0)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardComponent$initNextBigCardPanelView$1$1.onPanelStatusChanged(com.baidu.searchbox.player.widget.PanelDragStatus, com.baidu.searchbox.player.widget.PanelDragStatus):void");
    }
}
