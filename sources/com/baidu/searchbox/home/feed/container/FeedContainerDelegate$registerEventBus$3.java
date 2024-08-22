package com.baidu.searchbox.home.feed.container;

import com.baidu.common.matrixstyle.StyleModeEvent;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.feed.controller.SearchBackToHomeManager;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.music.MiniPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/home/feed/container/FeedContainerDelegate$registerEventBus$3", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/common/matrixstyle/StyleModeEvent;", "call", "", "event", "lib-feed-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedContainerDelegate.kt */
public final class FeedContainerDelegate$registerEventBus$3 implements Action<StyleModeEvent> {
    FeedContainerDelegate$registerEventBus$3() {
    }

    public void call(StyleModeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TabController.INSTANCE.setHomeState(0);
        MiniPlayerView.getInstance().finishMiniPlayer(true);
        SearchBackToHomeManager.getInstance().clear();
    }
}
