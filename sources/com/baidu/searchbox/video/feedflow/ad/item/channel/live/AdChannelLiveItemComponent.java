package com.baidu.searchbox.video.feedflow.ad.item.channel.live;

import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.ad.live.NadLiveItemComponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/item/channel/live/AdChannelLiveItemComponent;", "Lcom/baidu/searchbox/video/feedflow/ad/live/NadLiveItemComponent;", "()V", "createArchDetailFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdChannelLiveItemComponent.kt */
public final class AdChannelLiveItemComponent extends NadLiveItemComponent {
    /* access modifiers changed from: protected */
    public IArchDetailFactory createArchDetailFactory() {
        Store store = getStore();
        if (!(store instanceof Store)) {
            store = null;
        }
        return new AdChannelLiveItemFactory(store);
    }
}
