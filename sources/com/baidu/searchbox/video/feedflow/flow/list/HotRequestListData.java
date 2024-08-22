package com.baidu.searchbox.video.feedflow.flow.list;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/HotRequestListData;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "direction", "", "itemModelList", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "isMustNewEventId", "", "(ILjava/util/List;Z)V", "getDirection", "()I", "()Z", "getItemModelList", "()Ljava/util/List;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: FlowActionManifest.kt */
public final class HotRequestListData implements Action {
    private final int direction;
    private final boolean isMustNewEventId;
    private final List<ItemModel<?>> itemModelList;

    public HotRequestListData(int direction2, List<ItemModel<?>> itemModelList2, boolean isMustNewEventId2) {
        Intrinsics.checkNotNullParameter(itemModelList2, "itemModelList");
        this.direction = direction2;
        this.itemModelList = itemModelList2;
        this.isMustNewEventId = isMustNewEventId2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotRequestListData(int i2, List list, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, list, (i3 & 4) != 0 ? false : z);
    }

    public final int getDirection() {
        return this.direction;
    }

    public final List<ItemModel<?>> getItemModelList() {
        return this.itemModelList;
    }

    public final boolean isMustNewEventId() {
        return this.isMustNewEventId;
    }
}
