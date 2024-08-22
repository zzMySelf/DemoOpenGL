package com.baidu.searchbox.video.channel.flow.flow.pelatedpreview;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewReducer;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/flow/pelatedpreview/ChannelRelatedPreviewReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/relatedpreview/RelatedPreviewReducer;", "()V", "isFirstVideo", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelRelatedPreviewReducer.kt */
public final class ChannelRelatedPreviewReducer extends RelatedPreviewReducer {
    /* access modifiers changed from: protected */
    public boolean isFirstVideo(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ItemModel itemModel = (ItemModel) state.select(ItemModel.class);
        RunTimeStatus runTimeStatus = itemModel != null ? itemModel.getRunTimeStatus() : null;
        return (runTimeStatus != null && runTimeStatus.getPosition() == 0) && !runTimeStatus.isDetachedOnce();
    }
}
