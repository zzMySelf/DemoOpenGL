package com.baidu.searchbox.video.assemble.provider;

import com.baidu.searchbox.video.assemble.config.FeedCollectionAbConfig;
import com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig;
import com.baidu.searchbox.video.assemble.config.FeedCollectionLocalConfig;
import com.baidu.searchbox.video.config.SmartPlayPolicyConfig;
import com.baidu.searchbox.video.feedflow.abtest.RightZoneBarrageInputBarABSwitcher;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.common.config.AirPlayOptSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayNewStyleConfig;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfig;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowDetainmentGuideConfig;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowDetainmentGuideLocalConfig;
import com.baidu.searchbox.video.feedflow.detail.diversion.TabDiversionSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeInsertItemModel;
import com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeTalosBundleModel;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendShowNextContentConfig;
import com.baidu.searchbox.video.feedflow.detail.publish.PublishEntrySwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.recommend.RelatedRecommendSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewConfig;
import com.baidu.searchbox.video.feedflow.detail.search.SearchBoxConfig;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.FirstJumpGuideConfig;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.share.ShareStrengthenConfig;
import com.baidu.searchbox.video.feedflow.detail.shareenhance.ShareEnhanceSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpConfig;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.collection.LandscapePanelAutoplayModel;
import com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend.LandscapeRelatedRecommendModel;
import com.baidu.searchbox.video.feedflow.flow.listenvideo.model.ListenVideoSwitchConfig;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"COLLECTION_MUTE_PROPERTY_GROUP_NAME", "", "collectClearScreenCollectionInitState", "", "", "collection-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedClearScreenCollectionUnitProvider.kt */
public final class FeedClearScreenCollectionUnitProviderKt {
    private static final String COLLECTION_MUTE_PROPERTY_GROUP_NAME = "collection_video_landing_mute_group";

    public static final List<Object> collectClearScreenCollectionInitState() {
        List arrayList = new ArrayList();
        List $this$collectClearScreenCollectionInitState_u24lambda_u2d0 = arrayList;
        $this$collectClearScreenCollectionInitState_u24lambda_u2d0.add(new FlowSwitchState(true, true, (ListenVideoSwitchConfig) null, false, DIFactory.INSTANCE.getConfig().getFullPlaySwitchConfig(), COLLECTION_MUTE_PROPERTY_GROUP_NAME, DIFactory.INSTANCE.getConfig().getShowPlayerSpeedOutSwitch(), 0, (RelatedRecommendSwitchConfig) null, (RelatedPreviewConfig) null, (SearchBoxConfig) null, DIFactory.INSTANCE.getConfig().getFlowCommentBubbleConfig(), DIFactory.INSTANCE.getConfig().getTitleLineConfig(), (AutoplayConfig) null, DIFactory.INSTANCE.getConfig().getFlowVideoToolbarCommentEmojiSwitch(), (SecondJumpSwitchConfig) null, false, (WindowMovingUpConfig) null, (AutoPlayNewStyleConfig) null, false, 0, false, false, false, 0, false, (FlowDetainmentGuideConfig) null, (FlowDetainmentGuideLocalConfig) null, (GuessLikeInsertItemModel) null, (GuessLikeTalosBundleModel) null, (String) null, DIFactory.INSTANCE.getConfig().getClearScreenConfig(), RightZoneBarrageInputBarABSwitcher.INSTANCE.isBarrageInputBarABEnable(), DIFactory.INSTANCE.getConfig().getCardioidPraiseGuideSwitcher(), DIFactory.INSTANCE.getConfig().getCardioidPraiseGuideText(), DIFactory.INSTANCE.getConfig().getBarragePlaceholderTypeSwitcher(), DIFactory.INSTANCE.getConfig().getPortraitProgressFollowFinger(), false, false, false, false, false, DIFactory.INSTANCE.getConfig().getLongPressNewMenuConfig(), (ShareStrengthenConfig) null, (SmartPlayPolicyConfig) null, false, false, 0, (PublishEntrySwitchConfig) null, (RecommendShowNextContentConfig) null, false, 0, 0, 0, 0, 0, DIFactory.INSTANCE.getConfig().getCommentPreloadDelayTime(), (ShareEnhanceSwitchConfig) null, (LandscapeRelatedRecommendModel) null, (LandscapePanelAutoplayModel) null, 0, (TabDiversionSwitchConfig) null, false, (FirstJumpGuideConfig) null, DIFactory.INSTANCE.getConfig().getLongPressSpeedMenuSwitch(), (Pair) null, DIFactory.INSTANCE.getConfig().getAdvanceAgeSwitch(), DIFactory.INSTANCE.getConfig().getLongPressMenuTTSPosition(), DIFactory.INSTANCE.getConfig().getClearGuideSwitch(), 0, (String) null, (Boolean) null, (Float) null, (AirPlayOptSwitchConfig) null, false, DIFactory.INSTANCE.getConfig().getSlideStopShowScaleGuideSwitch(), VideoFlowUtilsKt.parseVideoSizeConfigRatio(DIFactory.INSTANCE.getConfig().getPanelHeightConfigRatio()), 2147461000, -16778272, 2018, (DefaultConstructorMarker) null));
        $this$collectClearScreenCollectionInitState_u24lambda_u2d0.add(new FeedCollectionAbConfig());
        $this$collectClearScreenCollectionInitState_u24lambda_u2d0.add(new FeedCollectionGcpConfig());
        $this$collectClearScreenCollectionInitState_u24lambda_u2d0.add(new FeedCollectionLocalConfig());
        return arrayList;
    }
}
