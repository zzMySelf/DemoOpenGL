package com.baidu.searchbox.video.channel.tab.talos.common;

import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.video.channel.tab.ChannelVideoFlowBaseComponent;
import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/talos/common/ChannelTalosCommonFlowComponent;", "Lcom/baidu/searchbox/video/channel/tab/ChannelVideoFlowBaseComponent;", "()V", "createArchDetailFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "createStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTalosCommonFlowComponent.kt */
public final class ChannelTalosCommonFlowComponent extends ChannelVideoFlowBaseComponent {
    /* access modifiers changed from: protected */
    public IArchDetailFactory createArchDetailFactory() {
        return new ChannelTalosCommonFlowFactory();
    }

    /* access modifiers changed from: protected */
    public AbsStore<CommonState> createStore() {
        return new ChannelTalosFlowStore(new CommonState(new LinkedHashMap()));
    }
}
