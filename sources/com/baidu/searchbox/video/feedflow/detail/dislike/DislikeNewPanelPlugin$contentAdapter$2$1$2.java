package com.baidu.searchbox.video.feedflow.detail.dislike;

import com.baidu.searchbox.video.feedflow.detail.dislike.adapter.IPanelShowListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/dislike/DislikeNewPanelPlugin$contentAdapter$2$1$2", "Lcom/baidu/searchbox/video/feedflow/detail/dislike/adapter/IPanelShowListener;", "onPopDismiss", "", "onPopShow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DislikeNewPanelPlugin.kt */
public final class DislikeNewPanelPlugin$contentAdapter$2$1$2 implements IPanelShowListener {
    final /* synthetic */ DislikeNewPanelPlugin this$0;

    DislikeNewPanelPlugin$contentAdapter$2$1$2(DislikeNewPanelPlugin $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPopShow() {
        /*
            r7 = this;
            com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelPlugin r0 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002c
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0017
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0018
        L_0x0017:
            r4 = r6
        L_0x0018:
            if (r4 == 0) goto L_0x0020
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelState> r5 = com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x0020:
            com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelState r6 = (com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelState) r6
            if (r6 == 0) goto L_0x002c
            boolean r0 = r6.isVisibleToUser()
            if (r0 != 0) goto L_0x002c
            r0 = r1
            goto L_0x002d
        L_0x002c:
            r0 = r2
        L_0x002d:
            if (r0 == 0) goto L_0x0052
            com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelPlugin r0 = r7.this$0
            com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionPanelPopupWindow r0 = r0.popupWindow
            if (r0 == 0) goto L_0x003e
            boolean r0 = r0.isShowing()
            if (r0 != r1) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r1 == 0) goto L_0x004c
            com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelPlugin r0 = r7.this$0
            com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionPanelPopupWindow r0 = r0.popupWindow
            if (r0 == 0) goto L_0x004c
            r0.dismiss()
        L_0x004c:
            com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelPlugin r0 = r7.this$0
            r0.cancelCurToast()
            goto L_0x0064
        L_0x0052:
            com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelPlugin r0 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            if (r0 == 0) goto L_0x0064
            com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelVisibleChangedAction r2 = new com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelVisibleChangedAction
            r2.<init>(r1)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r2)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelPlugin$contentAdapter$2$1$2.onPopShow():void");
    }

    public void onPopDismiss() {
    }
}
