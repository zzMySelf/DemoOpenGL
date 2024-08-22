package com.baidu.searchbox.video.channel.flow.detail.video;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.detail.frame.Store;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ChannelFlowVideoItemLayoutManager$$ExternalSyntheticLambda14 implements Observer {
    public final /* synthetic */ Store f$0;
    public final /* synthetic */ ChannelFlowVideoItemLayoutManager f$1;
    public final /* synthetic */ ChannelFlowVideoItemLayoutState f$2;

    public /* synthetic */ ChannelFlowVideoItemLayoutManager$$ExternalSyntheticLambda14(Store store, ChannelFlowVideoItemLayoutManager channelFlowVideoItemLayoutManager, ChannelFlowVideoItemLayoutState channelFlowVideoItemLayoutState) {
        this.f$0 = store;
        this.f$1 = channelFlowVideoItemLayoutManager;
        this.f$2 = channelFlowVideoItemLayoutState;
    }

    public final void onChanged(Object obj) {
        ChannelFlowVideoItemLayoutManager.m4775initManager$lambda18$lambda4(this.f$0, this.f$1, this.f$2, (Boolean) obj);
    }
}
