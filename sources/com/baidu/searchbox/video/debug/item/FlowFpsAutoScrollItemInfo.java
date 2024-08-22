package com.baidu.searchbox.video.debug.item;

import com.baidu.searchbox.debug.data.CheckDebugItemInfo;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.video.feedflow.flow.lagfluency.FpsConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/debug/item/FlowFpsAutoScrollItemInfo;", "Lcom/baidu/searchbox/video/debug/item/VideoItemInfo;", "title", "", "(Ljava/lang/String;)V", "getItemInfo", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "video-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowFpsAutoScrollItemInfo.kt */
public final class FlowFpsAutoScrollItemInfo extends VideoItemInfo {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowFpsAutoScrollItemInfo(String title) {
        super(title, "");
        Intrinsics.checkNotNullParameter(title, "title");
    }

    public DebugItemInfo getItemInfo() {
        return new CheckDebugItemInfo(getItemName(), FpsConfigManager.INSTANCE.getDebugAutoScrollSwitch(), FlowFpsAutoScrollItemInfo$getItemInfo$1.INSTANCE);
    }
}
