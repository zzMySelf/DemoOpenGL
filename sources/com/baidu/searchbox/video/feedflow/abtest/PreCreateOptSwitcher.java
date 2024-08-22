package com.baidu.searchbox.video.feedflow.abtest;

import com.baidu.searchbox.player.ab.AbConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/abtest/PreCreateOptSwitcher;", "Lcom/baidu/searchbox/player/ab/AbConfig;", "Lcom/baidu/searchbox/video/feedflow/abtest/PreCreateConfig;", "()V", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreCreateOptSwitcher.kt */
public final class PreCreateOptSwitcher extends AbConfig<PreCreateConfig> {
    public static final PreCreateOptSwitcher INSTANCE = new PreCreateOptSwitcher();

    private PreCreateOptSwitcher() {
        super("feedvideo_pre_create_option", AnonymousClass1.INSTANCE, "", "");
    }
}
