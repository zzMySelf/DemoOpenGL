package com.baidu.searchbox.video.detail.plugin.service;

import com.baidu.searchbox.video.detail.plugin.component.previousnextplay.PlayPreviousNextPlugin;
import com.baidu.searchbox.video.detail.service.adapter.PlayPreviousNextServiceAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/service/PlayPreviousNextService;", "Lcom/baidu/searchbox/video/detail/service/adapter/PlayPreviousNextServiceAdapter;", "plugin", "Lcom/baidu/searchbox/video/detail/plugin/component/previousnextplay/PlayPreviousNextPlugin;", "(Lcom/baidu/searchbox/video/detail/plugin/component/previousnextplay/PlayPreviousNextPlugin;)V", "getPlugin", "()Lcom/baidu/searchbox/video/detail/plugin/component/previousnextplay/PlayPreviousNextPlugin;", "addHasPlayVideoInfo", "", "setAutoNextVideoData", "data", "", "setCollectNextVideoData", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayPreviousNextService.kt */
public final class PlayPreviousNextService extends PlayPreviousNextServiceAdapter {
    private final PlayPreviousNextPlugin plugin;

    public PlayPreviousNextService(PlayPreviousNextPlugin plugin2) {
        Intrinsics.checkNotNullParameter(plugin2, "plugin");
        this.plugin = plugin2;
    }

    public final PlayPreviousNextPlugin getPlugin() {
        return this.plugin;
    }

    public void addHasPlayVideoInfo() {
        this.plugin.addHasPlayVideoInfo();
    }

    public void setAutoNextVideoData(Object data) {
        this.plugin.setAutoNextVideoData(data);
    }

    public void setCollectNextVideoData(Object data) {
        this.plugin.setCollectionNextVideoData(data);
    }
}
