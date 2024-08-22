package com.baidu.searchbox.video.channel.flow.slide;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.video.feedflow.flow.slide.IPersonPageService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/slide/ChannelPersonPageServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/flow/slide/IPersonPageService;", "component", "Lcom/baidu/searchbox/video/channel/flow/slide/ChannelFlowLeftSlidePersonPagePlugin;", "(Lcom/baidu/searchbox/video/channel/flow/slide/ChannelFlowLeftSlidePersonPagePlugin;)V", "getComponent", "()Lcom/baidu/searchbox/video/channel/flow/slide/ChannelFlowLeftSlidePersonPagePlugin;", "addView", "", "contentView", "Landroid/view/View;", "lp", "Landroid/view/ViewGroup$LayoutParams;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelPersonPageServiceImpl.kt */
public final class ChannelPersonPageServiceImpl implements IPersonPageService {
    private final ChannelFlowLeftSlidePersonPagePlugin component;

    public ChannelPersonPageServiceImpl(ChannelFlowLeftSlidePersonPagePlugin component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final ChannelFlowLeftSlidePersonPagePlugin getComponent() {
        return this.component;
    }

    public void addView(View contentView, ViewGroup.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.component.addView(contentView, lp);
    }
}
