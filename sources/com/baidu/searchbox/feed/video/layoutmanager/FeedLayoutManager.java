package com.baidu.searchbox.feed.video.layoutmanager;

import android.widget.RelativeLayout;
import com.baidu.searchbox.video.detail.DefaultLayoutManager;
import com.baidu.searchbox.video.detail.core.ComponentManager;
import com.baidu.searchbox.video.detail.plugin.component.toolbar.ToolBarComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/video/layoutmanager/FeedLayoutManager;", "Lcom/baidu/searchbox/video/detail/DefaultLayoutManager;", "()V", "layout", "", "root", "Landroid/widget/RelativeLayout;", "componentManager", "Lcom/baidu/searchbox/video/detail/core/ComponentManager;", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedLayoutManager.kt */
public class FeedLayoutManager extends DefaultLayoutManager {
    public void layout(RelativeLayout root, ComponentManager componentManager) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        super.layout(root, componentManager);
        addView(this.mContainer, componentManager.getComponent(ToolBarComponent.class));
    }
}
