package com.baidu.searchbox.video.channel.tab.theater;

import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.video.channel.tab.ChannelVideoFlowBaseComponent;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerAction;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/theater/ChannelTheaterFlowComponent;", "Lcom/baidu/searchbox/video/channel/tab/ChannelVideoFlowBaseComponent;", "()V", "createArchDetailFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "createStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "onSelected", "", "position", "", "isUp", "", "tag", "", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTheaterFlowComponent.kt */
public final class ChannelTheaterFlowComponent extends ChannelVideoFlowBaseComponent {
    /* access modifiers changed from: protected */
    public IArchDetailFactory createArchDetailFactory() {
        return new ChannelTheaterFlowFactory();
    }

    /* access modifiers changed from: protected */
    public AbsStore<CommonState> createStore() {
        return new ChannelTheaterFlowStore(new CommonState(new LinkedHashMap()));
    }

    /* access modifiers changed from: protected */
    public void onSelected(int position, boolean isUp, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        super.onSelected(position, isUp, tag);
        StoreExtKt.post(getItemStore(), TheaterTopContainerAction.RequestData.INSTANCE);
    }
}
