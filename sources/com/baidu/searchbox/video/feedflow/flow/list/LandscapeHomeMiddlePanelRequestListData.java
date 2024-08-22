package com.baidu.searchbox.video.feedflow.flow.list;

import com.baidu.searchbox.feed.detail.frame.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/LandscapeHomeMiddlePanelRequestListData;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "direction", "", "itemModelList", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "(ILjava/util/List;)V", "getDirection", "()I", "getItemModelList", "()Ljava/util/List;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowActionManifest.kt */
public final class LandscapeHomeMiddlePanelRequestListData implements Action {
    private final int direction;
    private final List<ItemModel<?>> itemModelList;

    public LandscapeHomeMiddlePanelRequestListData(int direction2, List<ItemModel<?>> itemModelList2) {
        Intrinsics.checkNotNullParameter(itemModelList2, "itemModelList");
        this.direction = direction2;
        this.itemModelList = itemModelList2;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final List<ItemModel<?>> getItemModelList() {
        return this.itemModelList;
    }
}
