package com.baidu.searchbox.video.channel.tab.theater;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.ad.position.list.AdListState;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreReducer;
import com.baidu.searchbox.feed.detail.arch.ext.InterceptorToChildReducer;
import com.baidu.searchbox.feed.detail.arch.ext.InterceptorToParentReducer;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.channel.flow.detail.unit.ChannelFlowAutoPlayToastUnit;
import com.baidu.searchbox.video.channel.flow.flow.ChannelFirstJumpMiddleware;
import com.baidu.searchbox.video.channel.flow.flow.ChannelFirstJumpReducer;
import com.baidu.searchbox.video.channel.flow.flow.ChannelFlowLayoutReducer;
import com.baidu.searchbox.video.channel.flow.flow.cache.ChannelCacheMiddleware;
import com.baidu.searchbox.video.channel.flow.flow.exc.ChannelFlowExcMiddleware;
import com.baidu.searchbox.video.channel.flow.flow.list.ChannelFlowDataInterceptMiddleware;
import com.baidu.searchbox.video.channel.flow.flow.list.ChannelFlowListExtMiddleware;
import com.baidu.searchbox.video.channel.flow.flow.list.ChannelFlowListExtReducer;
import com.baidu.searchbox.video.channel.flow.flow.unit.ChannelCacheUnit;
import com.baidu.searchbox.video.channel.flow.flow.unit.ChannelFlowAutoPlayUnit;
import com.baidu.searchbox.video.channel.flow.flow.unit.ChannelFlowExcUnit;
import com.baidu.searchbox.video.channel.flow.flow.unit.ChannelFlowTimeOutStatUnit;
import com.baidu.searchbox.video.channel.flow.flow.unit.ChannelPlayModeUnit;
import com.baidu.searchbox.video.channel.flow.pageview.ChannelFlowPageFlowMiddleware;
import com.baidu.searchbox.video.channel.flow.pageview.ChannelFlowPageFlowReducer;
import com.baidu.searchbox.video.channel.flow.scheme.ChannelSchemeJumpNaTabMiddleware;
import com.baidu.searchbox.video.channel.flow.unit.ChannelRecommendNextContentDataUnit;
import com.baidu.searchbox.video.channel.flow.unit.ChannelShowClickUploadUnit;
import com.baidu.searchbox.video.channel.flow.unit.ChannelTheaterFlowUnit;
import com.baidu.searchbox.video.channel.flow.unit.ChannelTheaterTabTopContainerUnit;
import com.baidu.searchbox.video.channel.flow.unit.ChannelTheaterTabTopEntranceUnit;
import com.baidu.searchbox.video.channel.flow.utils.ChannelAttentionFlowRefreshUnit;
import com.baidu.searchbox.video.channel.tab.hometab.HomeNaTabOperationMiddleware;
import com.baidu.searchbox.video.channel.tab.hotlaunch.ChannelHotLaunchRefreshFlowMiddleware;
import com.baidu.searchbox.video.channel.tab.lazy.ChannelLazyTheaterFlowLayoutReducer;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel;
import com.baidu.searchbox.video.feedflow.ad.position.AdListLabel;
import com.baidu.searchbox.video.feedflow.ad.position.AdPositionMiddleware;
import com.baidu.searchbox.video.feedflow.ad.position.AdPositionReducer;
import com.baidu.searchbox.video.feedflow.ad.position.AdStrategyState;
import com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState;
import com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextMiddleware;
import com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextReducer;
import com.baidu.searchbox.video.feedflow.common.IntentDataReducer;
import com.baidu.searchbox.video.feedflow.common.LogMiddleware;
import com.baidu.searchbox.video.feedflow.common.ParamExtMiddleware;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.detail.banner.freq.BannerFreqControlFlowMiddleware;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.ChannelDetainmentUnit;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowVideoDetainmentGuideFlowStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.detail.flowstyle.UpdateFlowStyleInnerMiddleware;
import com.baidu.searchbox.video.feedflow.detail.guide.CommonScaleGestureGuideReducer;
import com.baidu.searchbox.video.feedflow.detail.guide.FlowVideoScaleGestureGuideMiddleware;
import com.baidu.searchbox.video.feedflow.detail.offline.OfflineTransformMiddleware;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpSwitchFlowStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.detail.ubc.FlowDetailUbcReducer;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedMiddleware;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedReducer;
import com.baidu.searchbox.video.feedflow.flow.FlowLayoutMiddleware;
import com.baidu.searchbox.video.feedflow.flow.autoplay.FlowAutoplayHelperMiddleware;
import com.baidu.searchbox.video.feedflow.flow.batch.BatchCardListLinkageMiddleware;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarFlowMiddleware;
import com.baidu.searchbox.video.feedflow.flow.bottom.barrageinputbar.BarrageSwitchSyncMiddleware;
import com.baidu.searchbox.video.feedflow.flow.extlog.ModifyExtMiddleware;
import com.baidu.searchbox.video.feedflow.flow.extlog.ModifyExtReducer;
import com.baidu.searchbox.video.feedflow.flow.fastslide.FastSlideUnit;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.FlowDataSwitchReducer;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeReducer;
import com.baidu.searchbox.video.feedflow.flow.guide.statistic.ScrollUpGuideFlowStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.FlowActionTransformMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.FlowListMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.FlowListStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.FlowScrollMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollInterceptActionMiddleware;
import com.baidu.searchbox.video.feedflow.flow.live.LiveFlowReducer;
import com.baidu.searchbox.video.feedflow.flow.loading.FlowLoadingReducer;
import com.baidu.searchbox.video.feedflow.flow.more.MoreFlowReducerAdapterMiddleware;
import com.baidu.searchbox.video.feedflow.flow.offline.OfflineFlowReducer;
import com.baidu.searchbox.video.feedflow.flow.prefetch.PrefetchUnit;
import com.baidu.searchbox.video.feedflow.flow.pvext.PvExtMiddleware;
import com.baidu.searchbox.video.feedflow.flow.search.SearchMarkFlowMiddleware;
import com.baidu.searchbox.video.feedflow.tab.FlowTabState;
import com.baidu.searchbox.video.feedflow.tab.TabInfoModel;
import com.baidu.searchbox.video.feedflow.tab.theater.top.error.TheaterNetErrorReducer;
import com.baidu.searchbox.video.middleware.NetCheckMiddleware;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002¨\u0006\t"}, d2 = {"collectReducer", "", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "collectionMiddleware", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "initState", "", "state", "video-channel_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTheaterFlowStore.kt */
public final class ChannelTheaterFlowStoreKt {
    /* access modifiers changed from: private */
    public static final void initState(CommonState state) {
        CommonState commonState = state;
        commonState.put(new FlowTabState((TabInfoModel) null, 0, (MutableLiveData) null, 7, (DefaultConstructorMarker) null));
        commonState.put(new AdStrategyState((MutableLiveData) null, (AdListState) null, (AdListState) null, (MutableLiveData) null, (MutableLiveData) null, AdListLabel.CHANNEL_THEATER_FLOW, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2015, (DefaultConstructorMarker) null));
        if (AdReduxExpManager.INSTANCE.getFlowCollAdSwitch()) {
            commonState.put(new AdCollListState((MutableLiveData) null, (ItemModel) null, (ItemModel) null, 0, (AdItemModel) null, 0, 0, 0, 255, (DefaultConstructorMarker) null));
        }
    }

    public static final List<Middleware<CommonState>> collectionMiddleware() {
        List arrayList = new ArrayList();
        List $this$collectionMiddleware_u24lambda_u2d0 = arrayList;
        $this$collectionMiddleware_u24lambda_u2d0.add(new LogMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new NetCheckMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ScrollInterceptActionMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelFirstJumpMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ParamExtMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new PvExtMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new AdPositionMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelAttentionFlowRefreshUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelFlowPageFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelTheaterFlowUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelFlowDataInterceptMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelFlowListExtMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowLayoutMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new UpdateFlowStyleInnerMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowVideoScaleGestureGuideMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowScrollMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowListMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowListStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new UninterestedMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new OfflineTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowAutoplayHelperMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new AutoplayStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowActionTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new SecondJumpSwitchFlowStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ScrollUpGuideFlowStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FlowVideoDetainmentGuideFlowStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelShowClickUploadUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.add(new BatchCardListLinkageMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new MoreFlowReducerAdapterMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new SearchMarkFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelFlowAutoPlayUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelPlayModeUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelFlowExcMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ModifyExtMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelCacheUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelCacheMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new HomeNaTabOperationMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelTheaterTabTopEntranceUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelTheaterTabTopContainerUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelSchemeJumpNaTabMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new ChannelHotLaunchRefreshFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelFlowAutoPlayToastUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(ChannelDetainmentUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(PrefetchUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d0.add(new BottomBarFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new BarrageSwitchSyncMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new BannerFreqControlFlowMiddleware());
        if (AdReduxExpManager.INSTANCE.getFlowCollAdSwitch()) {
            $this$collectionMiddleware_u24lambda_u2d0.add(new AdCollectionNextMiddleware());
        }
        return arrayList;
    }

    public static final List<Reducer<CommonState>> collectReducer() {
        List arrayList = new ArrayList();
        List $this$collectReducer_u24lambda_u2d1 = arrayList;
        $this$collectReducer_u24lambda_u2d1.add(new CoreReducer());
        $this$collectReducer_u24lambda_u2d1.add(new IntentDataReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FlowDetailUbcReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelFlowExcUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelFlowTimeOutStatUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelTheaterFlowUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(new ChannelLazyTheaterFlowLayoutReducer());
        $this$collectReducer_u24lambda_u2d1.add(new ChannelFlowListExtReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelAttentionFlowRefreshUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(new ChannelFlowPageFlowReducer());
        $this$collectReducer_u24lambda_u2d1.add(new InterceptorToChildReducer());
        $this$collectReducer_u24lambda_u2d1.add(new InterceptorToParentReducer());
        $this$collectReducer_u24lambda_u2d1.add(new CommonScaleGestureGuideReducer());
        $this$collectReducer_u24lambda_u2d1.add(new LiveFlowReducer());
        $this$collectReducer_u24lambda_u2d1.add(new UninterestedReducer());
        $this$collectReducer_u24lambda_u2d1.add(new OfflineFlowReducer());
        $this$collectReducer_u24lambda_u2d1.add(new AdPositionReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelShowClickUploadUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FlowLoadingReducer());
        $this$collectReducer_u24lambda_u2d1.add(new TheaterNetErrorReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelFlowAutoPlayToastUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelFlowAutoPlayUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelPlayModeUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(new ModifyExtReducer());
        $this$collectReducer_u24lambda_u2d1.add(new ChannelFirstJumpReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelTheaterTabTopEntranceUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelTheaterTabTopContainerUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelRecommendNextContentDataUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FlowDataSwitchReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FontSizeReducer());
        $this$collectReducer_u24lambda_u2d1.add(new ChannelFlowLayoutReducer());
        $this$collectReducer_u24lambda_u2d1.add(ChannelDetainmentUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(PrefetchUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d1.add(FastSlideUnit.INSTANCE.createReducer());
        if (AdReduxExpManager.INSTANCE.getFlowCollAdSwitch()) {
            $this$collectReducer_u24lambda_u2d1.add(new AdCollectionNextReducer());
        }
        return arrayList;
    }
}
