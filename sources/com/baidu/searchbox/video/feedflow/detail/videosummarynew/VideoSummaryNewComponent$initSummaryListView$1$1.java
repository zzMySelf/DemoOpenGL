package com.baidu.searchbox.video.feedflow.detail.videosummarynew;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryItemModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.videosummary.OnVideoSummaryListener;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryItemShowAction;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryLeftBtnViewClickAction;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryLeftViewType;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryNewUnFoldAction;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryRecyclerViewDraggingAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/videosummarynew/VideoSummaryNewComponent$initSummaryListView$1$1", "Lcom/baidu/searchbox/video/feedflow/detail/videosummary/OnVideoSummaryListener;", "onDragging", "", "curShowVideoSummaryType", "", "onFoldChanged", "isFold", "", "onItemClick", "position", "", "itemModel", "Lcom/baidu/searchbox/flowvideo/detail/repos/VideoSummaryItemModel;", "onItemSelected", "onItemShow", "onLeftButtonViewClick", "type", "Lcom/baidu/searchbox/video/feedflow/detail/videosummary/VideoSummaryLeftViewType;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSummaryNewComponent.kt */
public final class VideoSummaryNewComponent$initSummaryListView$1$1 implements OnVideoSummaryListener {
    final /* synthetic */ VideoSummaryNewView $this_apply;
    final /* synthetic */ VideoSummaryNewComponent this$0;

    VideoSummaryNewComponent$initSummaryListView$1$1(VideoSummaryNewComponent $receiver, VideoSummaryNewView $receiver2) {
        this.this$0 = $receiver;
        this.$this_apply = $receiver2;
    }

    public void onFoldChanged(boolean isFold) {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(VideoSummaryNewUnFoldAction.INSTANCE);
        }
    }

    public void onItemSelected(int position, VideoSummaryItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(int r18, com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryItemModel r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            java.lang.String r2 = "itemModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            r4 = 1
            r5 = 0
            boolean r2 = com.baidu.searchbox.video.detail.utils.ReClickUtilKt.isFastClick$default(r2, r4, r5)
            if (r2 == 0) goto L_0x0014
            return
        L_0x0014:
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r2 = r0.this$0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r2.getStore()
            if (r2 == 0) goto L_0x002f
            com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryItemClickedAction r3 = new com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryItemClickedAction
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r4 = r0.this$0
            boolean r4 = r4.getVideoSummaryPanelSwitch()
            r6 = r18
            r3.<init>(r6, r1, r4)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r2.dispatch(r3)
            goto L_0x0031
        L_0x002f:
            r6 = r18
        L_0x0031:
            int r2 = r19.getSummaryTime()
            if (r2 < 0) goto L_0x004d
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r2 = r0.this$0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r2.getStore()
            if (r2 == 0) goto L_0x004d
            com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryUpdatePlayerProgress r3 = new com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryUpdatePlayerProgress
            int r4 = r19.getSummaryTime()
            r3.<init>(r4)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r2.dispatch(r3)
        L_0x004d:
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r2 = r0.this$0
            boolean r2 = r2.onClickCanShowOcrPanel(r1)
            if (r2 == 0) goto L_0x00f1
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r2 = r0.this$0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r2.getStore()
            boolean r2 = com.baidu.searchbox.video.feedflow.utils.VideoFlowPadUtilsKt.isPadStyleAndLandScope(r2)
            if (r2 == 0) goto L_0x0071
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewView r2 = r0.$this_apply
            android.content.Context r2 = r2.getContext()
            android.app.Activity r2 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.getActivity(r2)
            if (r2 == 0) goto L_0x0071
            r3 = 0
            com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.setStatusBarVisible(r2, r3)
        L_0x0071:
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r2 = r0.this$0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r2.getStore()
            if (r2 == 0) goto L_0x00f1
            com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrSummaryAction$OcrSummaryPanelShowAction r3 = new com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrSummaryAction$OcrSummaryPanelShowAction
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r4 = r0.this$0
            com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrExt$OcrPanelScene r8 = r4.getShowPanelScene(r1)
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r4 = r0.this$0
            com.baidu.searchbox.feed.detail.frame.Store r4 = r4.getStore()
            if (r4 == 0) goto L_0x00c1
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r4.getState()
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0095
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9
            goto L_0x0096
        L_0x0095:
            r9 = r5
        L_0x0096:
            if (r9 == 0) goto L_0x009f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryState> r10 = com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryState.class
            java.lang.Object r9 = r9.select(r10)
            goto L_0x00a0
        L_0x009f:
            r9 = r5
        L_0x00a0:
            com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryState r9 = (com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryState) r9
            if (r9 == 0) goto L_0x00c1
            androidx.lifecycle.MutableLiveData r4 = r9.getModel()
            if (r4 == 0) goto L_0x00c1
            java.lang.Object r4 = r4.getValue()
            com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryModel r4 = (com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryModel) r4
            if (r4 == 0) goto L_0x00c1
            java.util.List r4 = r4.getItems()
            if (r4 == 0) goto L_0x00c1
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00c2
        L_0x00c1:
            r4 = r5
        L_0x00c2:
            int r9 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r4)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent r4 = r0.this$0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r4.getManager()
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r14 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r4 = r4.getService(r14)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r4 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r4
            if (r4 == 0) goto L_0x00e3
            int r4 = r4.getCurProgress()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
        L_0x00e3:
            r14 = r5
            r15 = 44
            r16 = 0
            r7 = r3
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r2, r3)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.videosummarynew.VideoSummaryNewComponent$initSummaryListView$1$1.onItemClick(int, com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryItemModel):void");
    }

    public void onDragging(String curShowVideoSummaryType) {
        Intrinsics.checkNotNullParameter(curShowVideoSummaryType, "curShowVideoSummaryType");
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new VideoSummaryRecyclerViewDraggingAction(curShowVideoSummaryType));
        }
    }

    public void onItemShow(int position, VideoSummaryItemModel itemModel) {
        Store access$getStore;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (CommonStateExtKt.isActive(this.this$0.getStore()) && (access$getStore = this.this$0.getStore()) != null) {
            StoreExtKt.post(access$getStore, new VideoSummaryItemShowAction(position, itemModel));
        }
    }

    public void onLeftButtonViewClick(VideoSummaryLeftViewType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new VideoSummaryLeftBtnViewClickAction(type));
        }
    }
}
