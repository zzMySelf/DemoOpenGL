package com.baidu.searchbox.video.channel.flow.detail.live;

import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.menu.LongPressNewMoreUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelLiveItemComponentRegister.kt */
final class ChannelLiveItemComponentRegister$collectPlugin$6 extends Lambda implements Function0<IPlugin> {
    public static final ChannelLiveItemComponentRegister$collectPlugin$6 INSTANCE = new ChannelLiveItemComponentRegister$collectPlugin$6();

    ChannelLiveItemComponentRegister$collectPlugin$6() {
        super(0);
    }

    public final IPlugin invoke() {
        return LongPressNewMoreUnit.INSTANCE.createPlugin();
    }
}
