package com.baidu.searchbox.feed.ioc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/feed/ioc/IFeedFlowVideoKt$FEED_FLOW_VIDEO_EMPTY$1", "Lcom/baidu/searchbox/feed/ioc/IFeedFlowVideo;", "createVideoSession", "", "getVideoInfoParseSwitch", "", "isInvokeFlowDetailScheme", "scheme", "isInvokeFlowDetailSchemeAndPreRenderOpened", "preRequestVideoFlowData", "", "params", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IFeedFlowVideo.kt */
public final class IFeedFlowVideoKt$FEED_FLOW_VIDEO_EMPTY$1 implements IFeedFlowVideo {
    IFeedFlowVideoKt$FEED_FLOW_VIDEO_EMPTY$1() {
    }

    public boolean isInvokeFlowDetailSchemeAndPreRenderOpened(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return false;
    }

    public boolean isInvokeFlowDetailScheme(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return false;
    }

    public boolean getVideoInfoParseSwitch() {
        return false;
    }

    public void preRequestVideoFlowData(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public String createVideoSession() {
        return "";
    }
}
