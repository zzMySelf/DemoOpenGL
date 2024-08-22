package com.baidu.searchbox.video.channel.assemble.provider;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.channel.flow.detail.video.paymentplayer.ChannelPaymentPlayerUnit;
import com.baidu.searchbox.video.feedflow.provider.IChannelPaymentVideoItemUnitProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/channel/assemble/provider/ChannelPaymentVideoItemProvider;", "Lcom/baidu/searchbox/video/feedflow/provider/IChannelPaymentVideoItemUnitProvider;", "()V", "getPlayerUnit", "Lcom/baidu/searchbox/feed/detail/arch/SlotComponentUnit;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelPaymentVideoItemProvider.kt */
public final class ChannelPaymentVideoItemProvider implements IChannelPaymentVideoItemUnitProvider {
    public SlotComponentUnit<CommonState> getPlayerUnit() {
        return ChannelPaymentPlayerUnit.INSTANCE;
    }
}
