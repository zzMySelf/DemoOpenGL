package com.baidu.searchbox.video.search.provider;

import com.baidu.searchbox.video.config.SmartPlayPolicyConfig;
import com.baidu.searchbox.video.feedflow.abtest.RightZoneBarrageInputBarABSwitcher;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenConfig;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.common.config.AirPlayOptSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayNewStyleConfig;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfig;
import com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleConf;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowDetainmentGuideConfig;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowDetainmentGuideLocalConfig;
import com.baidu.searchbox.video.feedflow.detail.diversion.TabDiversionSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.fullplay.FullPlaySwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeInsertItemModel;
import com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeTalosBundleModel;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.model.LongPressNewMenuModel;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendShowNextContentConfig;
import com.baidu.searchbox.video.feedflow.detail.publish.PublishEntrySwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.recommend.RelatedRecommendSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewConfig;
import com.baidu.searchbox.video.feedflow.detail.search.SearchBoxConfig;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.FirstJumpGuideConfig;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.share.ShareStrengthenConfig;
import com.baidu.searchbox.video.feedflow.detail.shareenhance.ShareEnhanceSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.summary.TitleLineConfig;
import com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpConfig;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.collection.LandscapePanelAutoplayModel;
import com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend.LandscapeRelatedRecommendModel;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelper;
import com.baidu.searchbox.video.feedflow.flow.listenvideo.model.ListenVideoSwitchConfig;
import com.baidu.searchbox.video.search.config.SearchCollectionAbConfig;
import com.baidu.searchbox.video.search.config.SearchCollectionGcpConfig;
import com.baidu.searchbox.video.search.config.SearchCollectionLocalConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"SEARCH_COLLECTION_MUTE_PROPERTY_GROUP_NAME", "", "collectSearchCollectionInitState", "", "", "search-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchCollectionUnitProvider.kt */
public final class SearchCollectionUnitProviderKt {
    private static final String SEARCH_COLLECTION_MUTE_PROPERTY_GROUP_NAME = "search_collection_mute_property_group_name";

    public static final List<Object> collectSearchCollectionInitState() {
        List arrayList = new ArrayList();
        List $this$collectSearchCollectionInitState_u24lambda_u2d0 = arrayList;
        FullPlaySwitchConfig fullPlaySwitchConfig = DIFactory.INSTANCE.getConfig().getFullPlaySwitchConfig();
        boolean searchFlowSettingGlobalMuteSwitch = GlobalMuteGuideHelper.INSTANCE.getSearchFlowSettingGlobalMuteSwitch();
        boolean searchShowPlayerSpeedOutSwitch = DIFactory.INSTANCE.getConfig().getSearchShowPlayerSpeedOutSwitch();
        TitleLineConfig titleLineConfig = DIFactory.INSTANCE.getConfig().getTitleLineConfig();
        CommentBubbleConf flowCommentBubbleConfig = DIFactory.INSTANCE.getConfig().getFlowCommentBubbleConfig();
        ClearScreenConfig clearScreenConfig = DIFactory.INSTANCE.getConfig().getClearScreenConfig();
        boolean cardioidPraiseGuideSwitcher = DIFactory.INSTANCE.getConfig().getCardioidPraiseGuideSwitcher();
        String cardioidPraiseGuideText = DIFactory.INSTANCE.getConfig().getCardioidPraiseGuideText();
        String barragePlaceholderTypeSwitcher = DIFactory.INSTANCE.getConfig().getBarragePlaceholderTypeSwitcher();
        boolean portraitProgressFollowFinger = DIFactory.INSTANCE.getConfig().getPortraitProgressFollowFinger();
        LongPressNewMenuModel longPressNewMenuConfig = DIFactory.INSTANCE.getConfig().getLongPressNewMenuConfig();
        ShareStrengthenConfig shareStrengthConfig = DIFactory.INSTANCE.getConfig().getShareStrengthConfig("search");
        SmartPlayPolicyConfig smartPlayPolicyConfig = DIFactory.INSTANCE.getConfig().getSmartPlayPolicyConfig();
        boolean isBarrageInputBarABEnable = RightZoneBarrageInputBarABSwitcher.INSTANCE.isBarrageInputBarABEnable();
        LandscapePanelAutoplayModel landscapePanelAutoplayModel = DIFactory.INSTANCE.getConfig().getLandscapePanelAutoplayModel();
        boolean longPressSpeedMenuSwitch = DIFactory.INSTANCE.getConfig().getLongPressSpeedMenuSwitch();
        $this$collectSearchCollectionInitState_u24lambda_u2d0.add(new FlowSwitchState(searchFlowSettingGlobalMuteSwitch, true, (ListenVideoSwitchConfig) null, false, fullPlaySwitchConfig, SEARCH_COLLECTION_MUTE_PROPERTY_GROUP_NAME, searchShowPlayerSpeedOutSwitch, 0, (RelatedRecommendSwitchConfig) null, (RelatedPreviewConfig) null, (SearchBoxConfig) null, flowCommentBubbleConfig, titleLineConfig, (AutoplayConfig) null, false, (SecondJumpSwitchConfig) null, false, (WindowMovingUpConfig) null, (AutoPlayNewStyleConfig) null, false, 0, false, false, false, 0, false, (FlowDetainmentGuideConfig) null, (FlowDetainmentGuideLocalConfig) null, (GuessLikeInsertItemModel) null, (GuessLikeTalosBundleModel) null, DIFactory.INSTANCE.getConfig().getOcrShowStyle(), clearScreenConfig, isBarrageInputBarABEnable, cardioidPraiseGuideSwitcher, cardioidPraiseGuideText, barragePlaceholderTypeSwitcher, portraitProgressFollowFinger, false, false, false, false, false, longPressNewMenuConfig, shareStrengthConfig, smartPlayPolicyConfig, DIFactory.INSTANCE.getConfig().getVideoSummaryPanelSwitch(), DIFactory.INSTANCE.getConfig().getVideoSummaryPrioritySwitch(), 0, (PublishEntrySwitchConfig) null, (RecommendShowNextContentConfig) null, false, 0, 0, 0, 0, 0, 0, (ShareEnhanceSwitchConfig) null, (LandscapeRelatedRecommendModel) null, landscapePanelAutoplayModel, 0, (TabDiversionSwitchConfig) null, false, (FirstJumpGuideConfig) null, longPressSpeedMenuSwitch, (Pair) null, false, 0, false, 0, (String) null, (Boolean) null, (Float) null, (AirPlayOptSwitchConfig) null, false, false, (Float) null, 1073735560, -134249504, 8190, (DefaultConstructorMarker) null));
        $this$collectSearchCollectionInitState_u24lambda_u2d0.add(new SearchCollectionAbConfig());
        $this$collectSearchCollectionInitState_u24lambda_u2d0.add(new SearchCollectionGcpConfig());
        $this$collectSearchCollectionInitState_u24lambda_u2d0.add(new SearchCollectionLocalConfig());
        return arrayList;
    }
}
