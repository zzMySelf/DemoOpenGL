package com.baidu.searchbox.video.feedflow.assemble.provider;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.FlowDataSourceSwitchUnit;
import com.baidu.searchbox.video.feedflow.flow.list.RecommendVideoFlowUnit;
import com.baidu.searchbox.video.feedflow.provider.RecommendUnitProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/assemble/provider/FeedRecommendUnitProvider;", "Lcom/baidu/searchbox/video/feedflow/provider/RecommendUnitProvider;", "()V", "getRecommendFlowDataSourceSwitchUnit", "Lcom/baidu/searchbox/video/feedflow/flow/flowstyle/FlowDataSourceSwitchUnit;", "getRecommendVideoFlowUnit", "Lcom/baidu/searchbox/video/feedflow/flow/list/RecommendVideoFlowUnit;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedRecommendUnitProvider.kt */
public final class FeedRecommendUnitProvider implements RecommendUnitProvider {
    public SlotUnit<CommonState> getRecommendFlowBackUnit() {
        return RecommendUnitProvider.DefaultImpls.getRecommendFlowBackUnit(this);
    }

    public SlotComponentUnit<CommonState> getSearchPersonalTipUnit() {
        return RecommendUnitProvider.DefaultImpls.getSearchPersonalTipUnit(this);
    }

    public SlotUnit<CommonState> getVideoFlowTcStatisticUnit() {
        return RecommendUnitProvider.DefaultImpls.getVideoFlowTcStatisticUnit(this);
    }

    public FlowDataSourceSwitchUnit getRecommendFlowDataSourceSwitchUnit() {
        return FlowDataSourceSwitchUnit.INSTANCE;
    }

    public RecommendVideoFlowUnit getRecommendVideoFlowUnit() {
        return RecommendVideoFlowUnit.INSTANCE;
    }
}
