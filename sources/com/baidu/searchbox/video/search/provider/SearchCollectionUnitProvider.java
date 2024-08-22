package com.baidu.searchbox.video.search.provider;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.abtest.SearchForbidABSwitcher;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenNewUnit;
import com.baidu.searchbox.video.feedflow.flow.datainter.DataInterWorkingUnit;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelper;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideUnit;
import com.baidu.searchbox.video.feedflow.provider.CollectionUnitProvider;
import com.baidu.searchbox.video.feedflow.unit.GlobalMuteUnit;
import com.baidu.searchbox.video.search.unit.SearchFeedCollectionTabMoreUnit;
import com.baidu.searchbox.video.search.unit.SearchFeedLeftSlidePersonPageUnit;
import com.baidu.searchbox.video.search.unit.SearchFeedSearchMarkUnit;
import com.baidu.searchbox.video.search.unit.SearchFlowBackUnit;
import com.baidu.searchbox.video.search.unit.SearchFlowDataSourceSwitchUnit;
import com.baidu.searchbox.video.search.unit.SearchPageMuteUnit;
import com.baidu.searchbox.video.search.unit.VideoFlowTcStatisticUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/search/provider/SearchCollectionUnitProvider;", "Lcom/baidu/searchbox/video/feedflow/provider/CollectionUnitProvider;", "()V", "getClearScreenUnit", "Lcom/baidu/searchbox/feed/detail/arch/SlotUnit;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getDataInterWorkingUnit", "getFlowDataSourceSwitchUnit", "getGlobalMuteGuideUnit", "Lcom/baidu/searchbox/feed/detail/arch/SlotComponentUnit;", "getGlobalMuteUnit", "getLeftSlidePersonPageUnit", "getMoreSlot", "getPageMuteSlot", "getRecommendFlowBackUnit", "getSearchMarkUnit", "getVideoFlowTcStatisticUnit", "Lcom/baidu/searchbox/video/search/unit/VideoFlowTcStatisticUnit;", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchCollectionUnitProvider.kt */
public final class SearchCollectionUnitProvider implements CollectionUnitProvider {
    public VideoFlowTcStatisticUnit getVideoFlowTcStatisticUnit() {
        return VideoFlowTcStatisticUnit.INSTANCE;
    }

    public SlotUnit<CommonState> getFlowDataSourceSwitchUnit() {
        return SearchFlowDataSourceSwitchUnit.INSTANCE;
    }

    public SlotUnit<CommonState> getPageMuteSlot() {
        if (!GlobalMuteGuideHelper.INSTANCE.getSearchFlowSettingGlobalMuteSwitch()) {
            return SearchPageMuteUnit.INSTANCE;
        }
        return null;
    }

    public SlotUnit<CommonState> getClearScreenUnit() {
        return ClearScreenNewUnit.INSTANCE;
    }

    public SlotUnit<CommonState> getDataInterWorkingUnit() {
        return DataInterWorkingUnit.INSTANCE;
    }

    public SlotComponentUnit<CommonState> getGlobalMuteGuideUnit() {
        if (GlobalMuteGuideHelper.INSTANCE.getSearchFlowSettingGlobalMuteSwitch()) {
            return GlobalMuteGuideUnit.INSTANCE;
        }
        return null;
    }

    public SlotUnit<CommonState> getGlobalMuteUnit() {
        if (GlobalMuteGuideHelper.INSTANCE.getSearchFlowSettingGlobalMuteSwitch()) {
            return GlobalMuteUnit.INSTANCE;
        }
        return null;
    }

    public SlotComponentUnit<CommonState> getSearchMarkUnit() {
        if (!SearchForbidABSwitcher.INSTANCE.forbidSearch()) {
            return SearchFeedSearchMarkUnit.INSTANCE;
        }
        SlotComponentUnit slotComponentUnit = null;
        return null;
    }

    public SlotComponentUnit<CommonState> getMoreSlot() {
        return SearchFeedCollectionTabMoreUnit.INSTANCE;
    }

    public SlotUnit<CommonState> getLeftSlidePersonPageUnit() {
        return SearchFeedLeftSlidePersonPageUnit.INSTANCE;
    }

    public SlotUnit<CommonState> getRecommendFlowBackUnit() {
        return SearchFlowBackUnit.INSTANCE;
    }
}
