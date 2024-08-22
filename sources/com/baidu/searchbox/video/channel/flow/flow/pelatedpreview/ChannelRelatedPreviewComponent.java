package com.baidu.searchbox.video.channel.flow.flow.pelatedpreview;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelComponent;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.tab.TabState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/flow/pelatedpreview/ChannelRelatedPreviewComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/relatedpreview/RelatedPreviewPanelComponent;", "()V", "isCurTabShow", "", "isFirstVideo", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelRelatedPreviewComponent.kt */
public final class ChannelRelatedPreviewComponent extends RelatedPreviewPanelComponent {
    /* access modifiers changed from: protected */
    public boolean isFirstVideo() {
        ItemModel itemModel;
        String nid;
        Store $this$select$iv = getStore();
        Boolean bool = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            itemModel = (ItemModel) (commonState != null ? commonState.select(ItemModel.class) : null);
        } else {
            itemModel = null;
        }
        ItemModel itemModel2 = itemModel;
        RunTimeStatus runTimeStatus = itemModel2 != null ? itemModel2.getRunTimeStatus() : null;
        if (DIFactory.INSTANCE.getConfig().getFlowCacheSwitch()) {
            if ((runTimeStatus != null && runTimeStatus.getPosition() == 0) && !runTimeStatus.isFromCache()) {
                return true;
            }
            if (itemModel2 == null || (nid = itemModel2.getNid()) == null) {
                return false;
            }
            IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
            if (iFlowComponentService != null) {
                bool = Boolean.valueOf(iFlowComponentService.isFirstVideoAfterCacheVideo(nid));
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return runTimeStatus != null && runTimeStatus.getPosition() == 0;
    }

    /* access modifiers changed from: protected */
    public boolean isCurTabShow() {
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(TabState.class);
            }
            TabState tabState = (TabState) obj;
            if (tabState != null && tabState.isCurrentRecommendTab()) {
                return true;
            }
        }
        return false;
    }
}
