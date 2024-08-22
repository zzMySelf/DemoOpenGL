package com.baidu.searchbox.video.feedflow.detail.lazy;

import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u0012\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u0004\u0018\u00010\u0002\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u0004¨\u0006\u0007"}, d2 = {"toFlowDetailModel", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "toItemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "toVideoItemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/VideoItemModel;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoItemLazyInflateState.kt */
public final class VideoItemLazyInflateStateKt {
    public static final FlowDetailModel toFlowDetailModel(Action $this$toFlowDetailModel) {
        if (!($this$toFlowDetailModel instanceof NetAction.Success)) {
            return null;
        }
        Object data = ((NetAction.Success) $this$toFlowDetailModel).getData();
        if (data instanceof FlowDetailModel) {
            return (FlowDetailModel) data;
        }
        return null;
    }

    public static final VideoItemModel toVideoItemModel(ItemModel<?> $this$toVideoItemModel) {
        Object data = $this$toVideoItemModel != null ? $this$toVideoItemModel.getData() : null;
        if (data instanceof VideoItemModel) {
            return (VideoItemModel) data;
        }
        return null;
    }

    public static final ItemModel<?> toItemModel(Action $this$toItemModel) {
        if (!($this$toItemModel instanceof NestedAction.OnBindData)) {
            return null;
        }
        Object data = ((NestedAction.OnBindData) $this$toItemModel).getData();
        if (data instanceof ItemModel) {
            return (ItemModel) data;
        }
        return null;
    }
}
