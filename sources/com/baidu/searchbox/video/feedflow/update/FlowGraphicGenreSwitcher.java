package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.player.ab.UpdateConfig;
import com.baidu.searchbox.video.feedflow.detail.graphicgenre.GraphicGenreDetailSwitchConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/update/FlowGraphicGenreSwitcher;", "Lcom/baidu/searchbox/player/ab/UpdateConfig;", "Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/GraphicGenreDetailSwitchConfig;", "()V", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowGraphicGenreSwitcher.kt */
public final class FlowGraphicGenreSwitcher extends UpdateConfig<GraphicGenreDetailSwitchConfig> {
    public static final FlowGraphicGenreSwitcher INSTANCE = new FlowGraphicGenreSwitcher();

    private FlowGraphicGenreSwitcher() {
        super("flow_news_conf", AnonymousClass1.INSTANCE, (String) null, (String) null, (String) null, "flow_video_news_conf", (String) null, 92, (DefaultConstructorMarker) null);
    }
}
