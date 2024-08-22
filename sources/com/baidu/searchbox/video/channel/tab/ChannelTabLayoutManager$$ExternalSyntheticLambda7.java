package com.baidu.searchbox.video.channel.tab;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.detail.frame.Store;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ChannelTabLayoutManager$$ExternalSyntheticLambda7 implements Observer {
    public final /* synthetic */ ChannelTabLayoutManager f$0;
    public final /* synthetic */ Store f$1;
    public final /* synthetic */ ChannelTabLayoutState f$2;

    public /* synthetic */ ChannelTabLayoutManager$$ExternalSyntheticLambda7(ChannelTabLayoutManager channelTabLayoutManager, Store store, ChannelTabLayoutState channelTabLayoutState) {
        this.f$0 = channelTabLayoutManager;
        this.f$1 = store;
        this.f$2 = channelTabLayoutState;
    }

    public final void onChanged(Object obj) {
        ChannelTabLayoutManager.m4964initManager$lambda15$lambda11(this.f$0, this.f$1, this.f$2, (Boolean) obj);
    }
}
