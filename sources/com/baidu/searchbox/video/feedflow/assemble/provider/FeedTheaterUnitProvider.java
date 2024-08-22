package com.baidu.searchbox.video.feedflow.assemble.provider;

import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.provider.TheaterUnitProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/assemble/provider/FeedTheaterUnitProvider;", "Lcom/baidu/searchbox/video/feedflow/provider/TheaterUnitProvider;", "()V", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTheaterUnitProvider.kt */
public final class FeedTheaterUnitProvider implements TheaterUnitProvider {
    public SlotUnit<CommonState> getVideoFlowTcStatisticUnit() {
        return TheaterUnitProvider.DefaultImpls.getVideoFlowTcStatisticUnit(this);
    }
}
