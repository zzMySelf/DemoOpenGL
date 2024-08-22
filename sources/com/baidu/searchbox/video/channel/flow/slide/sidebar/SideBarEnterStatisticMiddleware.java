package com.baidu.searchbox.video.channel.flow.slide.sidebar;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.sidebar.SideBarAction;
import com.baidu.searchbox.video.feedflow.sidebar.SideBarConfigManager;
import com.baidu.searchbox.video.feedflow.sidebar.SideBarDrawerStatus;
import com.baidu.searchbox.video.feedflow.tab.TabComponentAction;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/slide/sidebar/SideBarEnterStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SideBarEnterStatisticMiddleware.kt */
public final class SideBarEnterStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof TabComponentAction.TabRenderComplete) {
            if (SideBarConfigManager.INSTANCE.isHideSwitcher()) {
                VideoFlowUBCHelper.upload6381Ubc$default(VideoFlowUBCHelper.INSTANCE, store, "show", "entrance", (String) null, (String) null, 24, (Object) null);
            }
        } else if (action instanceof SideBarAction.OnSideBarEnterClickAction) {
            VideoFlowUBCHelper.upload6381Ubc$default(VideoFlowUBCHelper.INSTANCE, store, "click", "entrance", (String) null, (String) null, 24, (Object) null);
        } else if ((action instanceof SideBarAction.OnDrawerOpen) && !((SideBarAction.OnDrawerOpen) action).isAuto() && !Intrinsics.areEqual((Object) ((SideBarAction.OnDrawerOpen) action).getOldStatus(), (Object) SideBarDrawerStatus.Open.INSTANCE)) {
            VideoFlowUBCHelper.upload6381Ubc$default(VideoFlowUBCHelper.INSTANCE, store, "slide", "entrance", (String) null, (String) null, 24, (Object) null);
        }
        return next.next(store, action);
    }
}
