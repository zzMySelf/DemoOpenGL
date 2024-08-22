package com.baidu.searchbox.video.feedflow.provider;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0018\u00010\u001bH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\u0010\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/video/feedflow/provider/ItemUnitProvider;", "", "getBottomBannerUnit", "Lcom/baidu/searchbox/feed/detail/arch/SlotComponentUnit;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getDetainmentGuideUnit", "Lcom/baidu/searchbox/feed/detail/arch/SlotUnit;", "getFavorUnit", "getGestureUnit", "getLongPressNewGuideUnit", "getLongPressNewMoreUnit", "getMoveUpUnit", "getOcrSummaryPanelDurationUnit", "getOcrSummaryPanelUnit", "getOcrSummaryUnit", "getPersonalizedTipsUnit", "getPlayerUnit", "getRecommendNextContentUnit", "getSearchFirstJumpRecUnit", "getSearchVideoEnterAnimUnit", "getSearchVideoOuterAnimUnit", "getSecondJumpSwitchUnit", "getSeekBarUnit", "getShareUnit", "getSpeedOutUnit", "getVideoFlowCommonUnit", "getVideoItemTcStatisticMiddleware", "", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "getVideoSettingUnit", "getVideoSummaryNewUnit", "getWindowMovingUpGuideUnit", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemUnitProvider.kt */
public interface ItemUnitProvider {
    SlotComponentUnit<CommonState> getBottomBannerUnit();

    SlotUnit<CommonState> getDetainmentGuideUnit();

    SlotUnit<CommonState> getFavorUnit();

    SlotComponentUnit<CommonState> getGestureUnit();

    SlotUnit<CommonState> getLongPressNewGuideUnit();

    SlotUnit<CommonState> getLongPressNewMoreUnit();

    SlotUnit<CommonState> getMoveUpUnit();

    SlotUnit<CommonState> getOcrSummaryPanelDurationUnit();

    SlotComponentUnit<CommonState> getOcrSummaryPanelUnit();

    SlotComponentUnit<CommonState> getOcrSummaryUnit();

    SlotComponentUnit<CommonState> getPersonalizedTipsUnit();

    SlotComponentUnit<CommonState> getPlayerUnit();

    SlotUnit<CommonState> getRecommendNextContentUnit();

    SlotUnit<CommonState> getSearchFirstJumpRecUnit();

    SlotUnit<CommonState> getSearchVideoEnterAnimUnit();

    SlotUnit<CommonState> getSearchVideoOuterAnimUnit();

    SlotComponentUnit<CommonState> getSecondJumpSwitchUnit();

    SlotComponentUnit<CommonState> getSeekBarUnit();

    SlotUnit<CommonState> getShareUnit();

    SlotComponentUnit<CommonState> getSpeedOutUnit();

    SlotUnit<CommonState> getVideoFlowCommonUnit();

    List<Middleware<CommonState>> getVideoItemTcStatisticMiddleware();

    SlotUnit<CommonState> getVideoSettingUnit();

    SlotComponentUnit<CommonState> getVideoSummaryNewUnit();

    SlotComponentUnit<CommonState> getWindowMovingUpGuideUnit();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ItemUnitProvider.kt */
    public static final class DefaultImpls {
        public static SlotComponentUnit<CommonState> getVideoSummaryNewUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getSearchVideoEnterAnimUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getSearchVideoOuterAnimUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static List<Middleware<CommonState>> getVideoItemTcStatisticMiddleware(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotComponentUnit<CommonState> getSpeedOutUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getDetainmentGuideUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getVideoFlowCommonUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getSearchFirstJumpRecUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotComponentUnit<CommonState> getWindowMovingUpGuideUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotComponentUnit<CommonState> getOcrSummaryUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotComponentUnit<CommonState> getOcrSummaryPanelUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotUnit<CommonState> getOcrSummaryPanelDurationUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }

        public static SlotComponentUnit<CommonState> getPersonalizedTipsUnit(ItemUnitProvider itemUnitProvider) {
            return null;
        }
    }
}
