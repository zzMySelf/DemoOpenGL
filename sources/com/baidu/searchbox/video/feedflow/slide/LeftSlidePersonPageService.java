package com.baidu.searchbox.video.feedflow.slide;

import com.baidu.searchbox.video.feedflow.flow.slide.ILeftSlidePersonPageListener;
import com.baidu.searchbox.video.feedflow.flow.slide.ILeftSlidePersonPageService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/slide/LeftSlidePersonPageService;", "Lcom/baidu/searchbox/video/feedflow/flow/slide/ILeftSlidePersonPageService;", "plugin", "Lcom/baidu/searchbox/video/feedflow/slide/LeftSlidePersonPagePlugin;", "(Lcom/baidu/searchbox/video/feedflow/slide/LeftSlidePersonPagePlugin;)V", "getPlugin", "()Lcom/baidu/searchbox/video/feedflow/slide/LeftSlidePersonPagePlugin;", "addLeftSlidePersonPageListener", "", "listener", "Lcom/baidu/searchbox/video/feedflow/flow/slide/ILeftSlidePersonPageListener;", "isPersonPageViewVisible", "", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlidePersonPageService.kt */
public final class LeftSlidePersonPageService implements ILeftSlidePersonPageService {
    private final LeftSlidePersonPagePlugin plugin;

    public LeftSlidePersonPageService(LeftSlidePersonPagePlugin plugin2) {
        Intrinsics.checkNotNullParameter(plugin2, "plugin");
        this.plugin = plugin2;
    }

    public final LeftSlidePersonPagePlugin getPlugin() {
        return this.plugin;
    }

    public void addLeftSlidePersonPageListener(ILeftSlidePersonPageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.plugin.addLeftSlidePersonPageListener(listener);
    }

    public boolean isPersonPageViewVisible() {
        return this.plugin.isPersonPageViewVisible();
    }
}
