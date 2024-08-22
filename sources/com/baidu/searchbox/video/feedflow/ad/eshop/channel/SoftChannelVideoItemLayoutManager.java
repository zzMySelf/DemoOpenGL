package com.baidu.searchbox.video.feedflow.ad.eshop.channel;

import com.baidu.searchbox.video.feedflow.ad.AdVideoItemLayoutManager;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/eshop/channel/SoftChannelVideoItemLayoutManager;", "Lcom/baidu/searchbox/video/feedflow/ad/AdVideoItemLayoutManager;", "()V", "needBottomContainer", "", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SoftChannelVideoItemLayoutManager.kt */
public final class SoftChannelVideoItemLayoutManager extends AdVideoItemLayoutManager {
    public boolean needBottomContainer() {
        return DIFactory.INSTANCE.isPadStyle();
    }
}
