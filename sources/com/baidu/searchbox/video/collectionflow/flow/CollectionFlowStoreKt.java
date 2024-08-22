package com.baidu.searchbox.video.collectionflow.flow;

import androidx.lifecycle.MutableLiveData;
import com.baidu.browser.core.data.BdDXXmlParser;
import com.baidu.searchbox.ad.position.list.AdListState;
import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreReducer;
import com.baidu.searchbox.feed.detail.arch.ext.InterceptorToChildReducer;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.collectionflow.autoplay.CollectionAutoPlayAdapterMiddleware;
import com.baidu.searchbox.video.collectionflow.flow.lazy.CollectionFlowLazyInflateReducer;
import com.baidu.searchbox.video.collectionflow.flow.lazy.SecondaryPageDowngradeUtilsKt;
import com.baidu.searchbox.video.collectionflow.flow.list.CollectionDataInterceptMiddleware;
import com.baidu.searchbox.video.collectionflow.flow.list.CollectionFlowMiddleware;
import com.baidu.searchbox.video.collectionflow.flow.list.CollectionFlowReducer;
import com.baidu.searchbox.video.collectionflow.flow.list.CollectionFlowScrollMiddleware;
import com.baidu.searchbox.video.collectionflow.flow.toptitle.TitleInfoUnit;
import com.baidu.searchbox.video.collectionflow.flow.ubc.CollectionFlowUbcReducer;
import com.baidu.searchbox.video.collectionflow.flow.unit.CollectionContentPanelUnit;
import com.baidu.searchbox.video.collectionflow.flow.unit.CollectionShowClickUploadUnit;
import com.baidu.searchbox.video.collectionflow.unit.CollectionBackAbilityUnit;
import com.baidu.searchbox.video.collectionflow.unit.CollectionDurationUnit;
import com.baidu.searchbox.video.collectionflow.unit.CollectionScreenKeepOnUnit;
import com.baidu.searchbox.video.collectionflow.unit.CollectionSearch843DurationUnit;
import com.baidu.searchbox.video.collectionflow.unit.FlowArrivalUnit;
import com.baidu.searchbox.video.component.audiofocus.AudioFocusReducer;
import com.baidu.searchbox.video.component.autoplay.AutoPlayReducer;
import com.baidu.searchbox.video.component.datachannel.DataChannelMiddleware;
import com.baidu.searchbox.video.component.datachannel.DataChannelReducer;
import com.baidu.searchbox.video.component.router.RouterReducer;
import com.baidu.searchbox.video.component.toast.ToastReducer;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.ad.position.AdListLabel;
import com.baidu.searchbox.video.feedflow.ad.position.AdPositionMiddleware;
import com.baidu.searchbox.video.feedflow.ad.position.AdPositionReducer;
import com.baidu.searchbox.video.feedflow.ad.position.AdStrategyState;
import com.baidu.searchbox.video.feedflow.ad.position.colllanding.AdCollLandingState;
import com.baidu.searchbox.video.feedflow.common.IntentDataReducer;
import com.baidu.searchbox.video.feedflow.common.LogMiddleware;
import com.baidu.searchbox.video.feedflow.common.ParamExtMiddleware;
import com.baidu.searchbox.video.feedflow.common.downgrade.FastModeMiddleware;
import com.baidu.searchbox.video.feedflow.common.downgrade.FastModeState;
import com.baidu.searchbox.video.feedflow.common.downgrade.FastModeStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.common.downgrade.FastModeStatus;
import com.baidu.searchbox.video.feedflow.config.ConfigUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.air.AirPlayStatusReducer;
import com.baidu.searchbox.video.feedflow.detail.air.AirPlayStatusState;
import com.baidu.searchbox.video.feedflow.detail.air.AirPlayTransformMiddleware;
import com.baidu.searchbox.video.feedflow.detail.banner.freq.BannerFreqControlFlowMiddleware;
import com.baidu.searchbox.video.feedflow.detail.challenge.toastandretry.ChallengeToastAndRetryUnit;
import com.baidu.searchbox.video.feedflow.detail.favorquerycontrol.FavorQueryControlUnit;
import com.baidu.searchbox.video.feedflow.detail.floating.FloatingTransformMiddleware;
import com.baidu.searchbox.video.feedflow.detail.floating.goback.FloatingPageGoBackUnit;
import com.baidu.searchbox.video.feedflow.detail.guide.FlowVideoScaleGestureUnit;
import com.baidu.searchbox.video.feedflow.detail.interactiveasyncmessage.InteractiveAsyncMessageUnit;
import com.baidu.searchbox.video.feedflow.detail.night.NightModeReducer;
import com.baidu.searchbox.video.feedflow.detail.offline.OfflineTransformMiddleware;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutounlockAllUnit;
import com.baidu.searchbox.video.feedflow.detail.pinch.VideoPinchSummaryUnit;
import com.baidu.searchbox.video.feedflow.detail.shortplay.ShortPlayWatchingTabOrFlowState;
import com.baidu.searchbox.video.feedflow.detail.toast.TipMiddleware;
import com.baidu.searchbox.video.feedflow.detail.toast.TipReducer;
import com.baidu.searchbox.video.feedflow.detail.trafficdemote.TrafficDemoteUnit;
import com.baidu.searchbox.video.feedflow.detail.ttsguide.TTSToastGuideUnit;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedMiddleware;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedReducer;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.airplay.AirPlayBehaviorUploadUnit;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.BaikePanelMiddleware;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.BaikePanelReducer;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.BaikePanelState;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.statistic.BaikePanelStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.flow.barrage.BarrageButtonSwitchSyncState;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarFlowMiddleware;
import com.baidu.searchbox.video.feedflow.flow.bottom.barrageinputbar.BarrageSwitchSyncMiddleware;
import com.baidu.searchbox.video.feedflow.flow.bottom.utils.TopBackUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.coldlaunch.ColdLaunchRestoreUnit;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelMiddleware;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelReducer;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionRequestFlowMiddleware;
import com.baidu.searchbox.video.feedflow.flow.collection.SimilarCollectionListMiddleware;
import com.baidu.searchbox.video.feedflow.flow.collection.SimilarCollectionRequestMiddleware;
import com.baidu.searchbox.video.feedflow.flow.collection.SimilarCollectionRequestSuccessAction;
import com.baidu.searchbox.video.feedflow.flow.collection.SimilarCollectionState;
import com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord.CollectionRecordMiddleware;
import com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord.CollectionRecordReducer;
import com.baidu.searchbox.video.feedflow.flow.collection.landscape.CollectionFlowDataSwitchReducer;
import com.baidu.searchbox.video.feedflow.flow.collection.statistic.CollectionPanelStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.flow.collectionfold.FoldCollectionPanelReducer;
import com.baidu.searchbox.video.feedflow.flow.exc.ExcReducer;
import com.baidu.searchbox.video.feedflow.flow.extlog.ModifyExtMiddleware;
import com.baidu.searchbox.video.feedflow.flow.extlog.ModifyExtReducer;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.UpdateFlowStyleOuterMiddleware;
import com.baidu.searchbox.video.feedflow.flow.foldscreen.FoldScreenOuterMiddleware;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeReducer;
import com.baidu.searchbox.video.feedflow.flow.gohome.GoHomeReducer;
import com.baidu.searchbox.video.feedflow.flow.innerouteractiontransform.InnerOuterActionTransformMiddleware;
import com.baidu.searchbox.video.feedflow.flow.intelligentfillscreen.IntelligentFillScreenMiddleware;
import com.baidu.searchbox.video.feedflow.flow.intelligentfillscreen.IntelligentFillScreenReducer;
import com.baidu.searchbox.video.feedflow.flow.intelligentfillscreen.IntelligentFillScreenState;
import com.baidu.searchbox.video.feedflow.flow.lagfluency.DebugAutoScroll4FpsReducer;
import com.baidu.searchbox.video.feedflow.flow.lagfluency.FpsConfigManager;
import com.baidu.searchbox.video.feedflow.flow.lagfluency.FpsMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.FlowActionTransformMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollInterceptActionMiddleware;
import com.baidu.searchbox.video.feedflow.flow.listenvideo.ListenVideoUnit;
import com.baidu.searchbox.video.feedflow.flow.offline.OfflineFlowReducer;
import com.baidu.searchbox.video.feedflow.flow.operation.FlowFunctionPositionCalculateUnit;
import com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationActivityUnit;
import com.baidu.searchbox.video.feedflow.flow.payment.authentication.AuthenticationMiddleware;
import com.baidu.searchbox.video.feedflow.flow.payment.authentication.AuthenticationReducer;
import com.baidu.searchbox.video.feedflow.flow.payment.pay.PayMiddleware;
import com.baidu.searchbox.video.feedflow.flow.payment.pay.PayReducer;
import com.baidu.searchbox.video.feedflow.flow.payment.secondJump.PaymentSecondJumpGlobalState;
import com.baidu.searchbox.video.feedflow.flow.prefetch.PrefetchUnit;
import com.baidu.searchbox.video.feedflow.flow.rewardTask.FlowRewardTaskMiddleware;
import com.baidu.searchbox.video.feedflow.flow.rewardTask.FlowRewardTaskReducer;
import com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.PagesContentClickType;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayMoreRequestMiddleware;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelUnit;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel;
import com.baidu.searchbox.video.feedflow.flow.speed.SpeedPanelSyncReducer;
import com.baidu.searchbox.video.feedflow.flow.swan.HalfScreenViewSwanUnit;
import com.baidu.searchbox.video.feedflow.flow.sync.eventbus.EventBusMiddleware;
import com.baidu.searchbox.video.feedflow.flow.sync.linkage.LinkageReducer;
import com.baidu.searchbox.video.feedflow.flow.task.FlowTaskOperationReducer;
import com.baidu.searchbox.video.feedflow.flow.task.FlowTaskOperationSyncState;
import com.baidu.searchbox.video.feedflow.flow.task.toast.FlowTaskCompleteToastReducer;
import com.baidu.searchbox.video.feedflow.flow.task.toast.FlowTaskToastStatisticMiddleware;
import com.baidu.searchbox.video.feedflow.flow.taskreport.TaskReportUnit;
import com.baidu.searchbox.video.feedflow.provider.CollectionUnitProvider;
import com.baidu.searchbox.video.feedflow.tab.back.BackAbilityState;
import com.baidu.searchbox.video.feedflow.tab.playletrecord.PlayletRecordMiddleware;
import com.baidu.searchbox.video.feedflow.tab.quickSlide.UserBehaviorMiddleWare;
import com.baidu.searchbox.video.feedflow.tab.wealth.itemselected.WealthTaskItemSelectedUnit;
import com.baidu.searchbox.video.feedflow.trace.PageIdManagerUnit;
import com.baidu.searchbox.video.feedflow.unit.DurationPadUnit;
import com.baidu.searchbox.video.middleware.NetCheckMiddleware;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u001a\u001a\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\r"}, d2 = {"collectReducer", "", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "provider", "Lcom/baidu/searchbox/video/feedflow/provider/CollectionUnitProvider;", "collectionMiddleware", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "initState", "", "state", "", "", "collection-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowStore.kt */
public final class CollectionFlowStoreKt {
    static /* synthetic */ void initState$default(CommonState commonState, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        initState(commonState, list);
    }

    /* access modifiers changed from: private */
    public static final void initState(CommonState state, List<? extends Object> initState) {
        CommonState commonState = state;
        List<? extends Object> $this$forEach$iv = initState;
        commonState.put(new PlayerOrientationState(false, false, 3, (DefaultConstructorMarker) null));
        commonState.put(new BarrageButtonSwitchSyncState(DIFactory.INSTANCE.getConfig().getBarrageSwitch()));
        commonState.put(new FlowTaskOperationSyncState(false, (Map) null, 2, (DefaultConstructorMarker) null));
        commonState.put(new PaymentSecondJumpGlobalState(false));
        commonState.put(new AirPlayStatusState(false, false, false, 6, (DefaultConstructorMarker) null));
        commonState.put(new IntelligentFillScreenState((MutableLiveData) null, (MutableLiveData) null, 3, (DefaultConstructorMarker) null));
        commonState.put(new CollectionPanelState((MutableLiveData) null, (MutableLiveData) null, false, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (MutableLiveData) null, (List) null, (MutableLiveData) null, (String) null, (MutableLiveData) null, false, (MutableLiveData) null, (Set) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, false, (MutableLiveData) null, false, (MutableLiveData) null, (CollectionFlowModel) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, false, false, false, (MutableLiveData) null, false, 0, (MutableLiveData) null, (List) null, false, (MutableLiveData) null, (MutableLiveData) null, false, 0, false, (MutableLiveData) null, -1, 65535, (DefaultConstructorMarker) null));
        commonState.put(new SimilarCollectionState(false, (SimilarCollectionRequestSuccessAction) null, (List) null, false, 0, (String) null, 63, (DefaultConstructorMarker) null));
        commonState.put(new BaikePanelState((MutableLiveData) null, (MutableLiveData) null, (List) null, false, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, false, (Set) null, (String) null, BdDXXmlParser.BYTE_2_PROPERTY, (DefaultConstructorMarker) null));
        commonState.put(new ShortPlayPanelState((MutableLiveData) null, (ShortPlayIntroduceModel) null, (List) null, (MutableLiveData) null, (CollectionFlowModel) null, false, (PagesContentClickType) null, false, false, (CollectionFlowModel) null, false, false, false, BdDXXmlParser.BYTE_1_PROPERTY, (DefaultConstructorMarker) null));
        for (Object element$iv : $this$forEach$iv) {
            commonState.put(element$iv);
        }
        if (TopBackUtilsKt.isTopBackSwitch()) {
            commonState.put(new BackAbilityState((MutableLiveData) null, 0, (String) null, (String) null, (MutableLiveData) null, (List) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2047, (DefaultConstructorMarker) null));
        }
        ConfigUtilsKt.initConfigs($this$forEach$iv, commonState);
        commonState.put(new FastModeState((FastModeStatus) null, false, false, false, false, 31, (DefaultConstructorMarker) null));
        SecondaryPageDowngradeUtilsKt.addCollectionFeatureManager(state);
        commonState.put(new AdStrategyState((MutableLiveData) null, (AdListState) null, (AdListState) null, (MutableLiveData) null, (MutableLiveData) null, AdListLabel.COLLECTION_FLOW, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2015, (DefaultConstructorMarker) null));
        commonState.put(new ShortPlayWatchingTabOrFlowState());
        if (AdReduxExpManager.INSTANCE.getFlowAdCollInsertAdUpdateSwitch()) {
            commonState.put(new AdCollLandingState((List) null, (MutableLiveData) null, 3, (DefaultConstructorMarker) null));
        }
    }

    public static final List<Middleware<CommonState>> collectionMiddleware(CollectionUnitProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        List arrayList = new ArrayList();
        List $this$collectionMiddleware_u24lambda_u2d6 = arrayList;
        $this$collectionMiddleware_u24lambda_u2d6.add(new LogMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new NetCheckMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new ScrollInterceptActionMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new ParamExtMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new AdPositionMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionRequestFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionDataInterceptMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new EventBusMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new UpdateFlowStyleOuterMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(provider.getLeftSlidePersonPageUnit().createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new DataChannelMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new ModifyExtMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new InnerOuterActionTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(provider.getMoreSlot().createMiddlewares());
        SlotComponentUnit $this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d2 = provider.getSearchMarkUnit();
        if ($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d2 != null) {
            $this$collectionMiddleware_u24lambda_u2d6.addAll($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d2.createMiddlewares());
        }
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionAutoPlayAdapterMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new SimilarCollectionListMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new SimilarCollectionRequestMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionPanelMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionPanelStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new BaikePanelMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new BaikePanelStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FlowTaskToastStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FlowRewardTaskMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new OfflineTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FoldScreenOuterMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new AirPlayTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new AuthenticationMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new TipMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionRecordMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(CollectionDurationUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(DurationPadUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new IntelligentFillScreenMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FlowActionTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(ColdLaunchRestoreUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionFlowScrollMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(CollectionScreenKeepOnUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(CollectionShowClickUploadUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(FloatingPageGoBackUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FloatingTransformMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new PayMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(TitleInfoUnit.INSTANCE.createMiddlewares());
        SlotComponentUnit $this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d3 = provider.getGlobalMuteGuideUnit();
        if ($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d3 != null) {
            $this$collectionMiddleware_u24lambda_u2d6.addAll($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d3.createMiddlewares());
        }
        $this$collectionMiddleware_u24lambda_u2d6.addAll(HalfScreenViewSwanUnit.INSTANCE.createMiddlewares());
        SlotUnit $this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d4 = provider.getClearScreenUnit();
        if ($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d4 != null) {
            $this$collectionMiddleware_u24lambda_u2d6.addAll($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d4.createMiddlewares());
        }
        $this$collectionMiddleware_u24lambda_u2d6.addAll(PageIdManagerUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(ListenVideoUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FpsMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new UserBehaviorMiddleWare());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(PrefetchUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(FlowOperationActivityUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(FlowFunctionPositionCalculateUnit.INSTANCE.createMiddlewares());
        SlotUnit $this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d5 = provider.getVideoFlowTcStatisticUnit();
        if ($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d5 != null) {
            $this$collectionMiddleware_u24lambda_u2d6.addAll($this$collectionMiddleware_u24lambda_u2d6_u24lambda_u2d5.createMiddlewares());
        }
        $this$collectionMiddleware_u24lambda_u2d6.add(new BottomBarFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new BarrageSwitchSyncMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(CollectionContentPanelUnit.INSTANCE.createMiddlewares());
        if (TopBackUtilsKt.isTopBackSwitch()) {
            $this$collectionMiddleware_u24lambda_u2d6.addAll(CollectionBackAbilityUnit.INSTANCE.createMiddlewares());
        }
        $this$collectionMiddleware_u24lambda_u2d6.addAll(ChallengeToastAndRetryUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(TTSToastGuideUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(FlowVideoScaleGestureUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FastModeMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new FastModeStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(AirPlayBehaviorUploadUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(TrafficDemoteUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new UninterestedMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.add(new BannerFreqControlFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(TaskReportUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new ShortPlayMoreRequestMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(ShortPlayPanelUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new CollectionFlowStatisticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(VideoPinchSummaryUnit.INSTANCE.createMiddlewares());
        $this$collectionMiddleware_u24lambda_u2d6.add(new PlayletRecordMiddleware());
        $this$collectionMiddleware_u24lambda_u2d6.addAll(FavorQueryControlUnit.INSTANCE.createMiddlewares());
        return arrayList;
    }

    public static final List<Reducer<CommonState>> collectReducer(CollectionUnitProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        List arrayList = new ArrayList();
        List $this$collectReducer_u24lambda_u2d15 = arrayList;
        $this$collectReducer_u24lambda_u2d15.add(new IntentDataReducer());
        $this$collectReducer_u24lambda_u2d15.add(new CollectionFlowUbcReducer());
        $this$collectReducer_u24lambda_u2d15.add(new ExcReducer());
        $this$collectReducer_u24lambda_u2d15.add(new CollectionFlowReducer());
        $this$collectReducer_u24lambda_u2d15.add(new ModifyExtReducer());
        $this$collectReducer_u24lambda_u2d15.add(CollectionDurationUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(DurationPadUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(FlowArrivalUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(new CollectionFlowLazyInflateReducer());
        $this$collectReducer_u24lambda_u2d15.add(new NightModeReducer());
        $this$collectReducer_u24lambda_u2d15.add(new RouterReducer());
        SlotUnit $this$collectReducer_u24lambda_u2d15_u24lambda_u2d7 = provider.getDataInterWorkingUnit();
        if ($this$collectReducer_u24lambda_u2d15_u24lambda_u2d7 != null) {
            $this$collectReducer_u24lambda_u2d15.add($this$collectReducer_u24lambda_u2d15_u24lambda_u2d7.createReducer());
        }
        $this$collectReducer_u24lambda_u2d15.add(new FontSizeReducer());
        $this$collectReducer_u24lambda_u2d15.add(new InterceptorToChildReducer());
        $this$collectReducer_u24lambda_u2d15.add(new ToastReducer());
        $this$collectReducer_u24lambda_u2d15.add(new LinkageReducer());
        $this$collectReducer_u24lambda_u2d15.add(new GoHomeReducer());
        $this$collectReducer_u24lambda_u2d15.add(new CoreReducer());
        $this$collectReducer_u24lambda_u2d15.add(new SpeedPanelSyncReducer());
        $this$collectReducer_u24lambda_u2d15.add(provider.getLeftSlidePersonPageUnit().createReducer());
        $this$collectReducer_u24lambda_u2d15.add(new DataChannelReducer());
        $this$collectReducer_u24lambda_u2d15.add(new CollectionPanelReducer());
        $this$collectReducer_u24lambda_u2d15.add(new BaikePanelReducer());
        $this$collectReducer_u24lambda_u2d15.add(new FoldCollectionPanelReducer());
        $this$collectReducer_u24lambda_u2d15.add(provider.getMoreSlot().createReducer());
        SlotComponentUnit $this$collectReducer_u24lambda_u2d15_u24lambda_u2d9 = provider.getSearchMarkUnit();
        if ($this$collectReducer_u24lambda_u2d15_u24lambda_u2d9 != null) {
            $this$collectReducer_u24lambda_u2d15.add($this$collectReducer_u24lambda_u2d15_u24lambda_u2d9.createReducer());
        }
        $this$collectReducer_u24lambda_u2d15.add(new OfflineFlowReducer());
        $this$collectReducer_u24lambda_u2d15.add(new AdPositionReducer());
        $this$collectReducer_u24lambda_u2d15.add(new AutoPlayReducer());
        $this$collectReducer_u24lambda_u2d15.add(new FlowRewardTaskReducer());
        $this$collectReducer_u24lambda_u2d15.add(new FlowTaskOperationReducer());
        $this$collectReducer_u24lambda_u2d15.add(new FlowTaskCompleteToastReducer());
        $this$collectReducer_u24lambda_u2d15.add(new AudioFocusReducer());
        SlotUnit $this$collectReducer_u24lambda_u2d15_u24lambda_u2d10 = provider.getPageMuteSlot();
        if ($this$collectReducer_u24lambda_u2d15_u24lambda_u2d10 != null) {
            $this$collectReducer_u24lambda_u2d15.add($this$collectReducer_u24lambda_u2d15_u24lambda_u2d10.createReducer());
        }
        SlotUnit $this$collectReducer_u24lambda_u2d15_u24lambda_u2d11 = provider.getGlobalMuteUnit();
        if ($this$collectReducer_u24lambda_u2d15_u24lambda_u2d11 != null) {
            $this$collectReducer_u24lambda_u2d15.add($this$collectReducer_u24lambda_u2d15_u24lambda_u2d11.createReducer());
        }
        SlotComponentUnit $this$collectReducer_u24lambda_u2d15_u24lambda_u2d12 = provider.getGlobalMuteGuideUnit();
        if ($this$collectReducer_u24lambda_u2d15_u24lambda_u2d12 != null) {
            $this$collectReducer_u24lambda_u2d15.add($this$collectReducer_u24lambda_u2d15_u24lambda_u2d12.createReducer());
        }
        $this$collectReducer_u24lambda_u2d15.add(new TipReducer());
        $this$collectReducer_u24lambda_u2d15.add(new AirPlayStatusReducer());
        $this$collectReducer_u24lambda_u2d15.add(new PayReducer());
        $this$collectReducer_u24lambda_u2d15.add(new AuthenticationReducer());
        $this$collectReducer_u24lambda_u2d15.add(new CollectionRecordReducer());
        $this$collectReducer_u24lambda_u2d15.add(ColdLaunchRestoreUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(new IntelligentFillScreenReducer());
        $this$collectReducer_u24lambda_u2d15.add(CollectionScreenKeepOnUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(CollectionShowClickUploadUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(FloatingPageGoBackUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(TitleInfoUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(HalfScreenViewSwanUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(PageIdManagerUnit.INSTANCE.createReducer());
        SlotUnit $this$collectReducer_u24lambda_u2d15_u24lambda_u2d13 = provider.getClearScreenUnit();
        if ($this$collectReducer_u24lambda_u2d15_u24lambda_u2d13 != null) {
            $this$collectReducer_u24lambda_u2d15.add($this$collectReducer_u24lambda_u2d15_u24lambda_u2d13.createReducer());
        }
        $this$collectReducer_u24lambda_u2d15.add(ListenVideoUnit.INSTANCE.createReducer());
        SlotUnit $this$collectReducer_u24lambda_u2d15_u24lambda_u2d14 = provider.getFlowDataSourceSwitchUnit();
        if ($this$collectReducer_u24lambda_u2d15_u24lambda_u2d14 != null) {
            $this$collectReducer_u24lambda_u2d15.add($this$collectReducer_u24lambda_u2d15_u24lambda_u2d14.createReducer());
        }
        if (FpsConfigManager.INSTANCE.getDebugAutoScrollSwitch()) {
            $this$collectReducer_u24lambda_u2d15.add(new DebugAutoScroll4FpsReducer());
        }
        $this$collectReducer_u24lambda_u2d15.add(PrefetchUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(FlowOperationActivityUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(FlowFunctionPositionCalculateUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(CollectionContentPanelUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(new CollectionFlowDataSwitchReducer());
        $this$collectReducer_u24lambda_u2d15.add(InteractiveAsyncMessageUnit.INSTANCE.createReducer());
        if (TopBackUtilsKt.isTopBackSwitch()) {
            $this$collectReducer_u24lambda_u2d15.add(CollectionBackAbilityUnit.INSTANCE.createReducer());
        }
        $this$collectReducer_u24lambda_u2d15.add(ChallengeToastAndRetryUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(TTSToastGuideUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(FlowVideoScaleGestureUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(AirPlayBehaviorUploadUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(TrafficDemoteUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(ShortPlayAutounlockAllUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(WealthTaskItemSelectedUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(new UninterestedReducer());
        $this$collectReducer_u24lambda_u2d15.add(CollectionSearch843DurationUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(TaskReportUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(ShortPlayPanelUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(VideoPinchSummaryUnit.INSTANCE.createReducer());
        $this$collectReducer_u24lambda_u2d15.add(FavorQueryControlUnit.INSTANCE.createReducer());
        return arrayList;
    }
}
