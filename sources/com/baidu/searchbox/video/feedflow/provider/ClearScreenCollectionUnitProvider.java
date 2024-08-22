package com.baidu.searchbox.video.feedflow.provider;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/provider/ClearScreenCollectionUnitProvider;", "", "getBottomBarUnit", "Lcom/baidu/searchbox/feed/detail/arch/SlotComponentUnit;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getFlowDataSourceSwitchUnit", "Lcom/baidu/searchbox/feed/detail/arch/SlotUnit;", "getGlobalMuteUnit", "getLeftSlidePersonPageUnit", "getMoreSlot", "getSearchMarkUnit", "getVideoFlowTcStatisticUnit", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenCollectionUnitProvider.kt */
public interface ClearScreenCollectionUnitProvider {
    SlotComponentUnit<CommonState> getBottomBarUnit();

    SlotUnit<CommonState> getFlowDataSourceSwitchUnit();

    SlotUnit<CommonState> getGlobalMuteUnit();

    SlotUnit<CommonState> getLeftSlidePersonPageUnit();

    SlotComponentUnit<CommonState> getMoreSlot();

    SlotComponentUnit<CommonState> getSearchMarkUnit();

    SlotUnit<CommonState> getVideoFlowTcStatisticUnit();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearScreenCollectionUnitProvider.kt */
    public static final class DefaultImpls {
        public static SlotUnit<CommonState> getVideoFlowTcStatisticUnit(ClearScreenCollectionUnitProvider clearScreenCollectionUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getFlowDataSourceSwitchUnit(ClearScreenCollectionUnitProvider clearScreenCollectionUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getGlobalMuteUnit(ClearScreenCollectionUnitProvider clearScreenCollectionUnitProvider) {
            return null;
        }
    }
}
