package com.baidu.searchbox.video.feedflow.ad;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.baidu.nadcore.model.NadSlidingTagModel;
import com.baidu.searchbox.ad.model.AdNormandyModel;
import com.baidu.searchbox.ad.model.NadSicilyModel;
import com.baidu.searchbox.ad.position.list.AdListState;
import com.baidu.searchbox.feed.ad.model.AdLpParams;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.flowvideo.ad.api.AdListServiceImpl;
import com.baidu.searchbox.flowvideo.ad.repos.AdListRepositoryImpl;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import com.baidu.searchbox.video.feedflow.ad.detail.AdData;
import com.baidu.searchbox.video.feedflow.ad.detail.AdDataState;
import com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel;
import com.baidu.searchbox.video.feedflow.ad.policy.AdPolicyState;
import com.baidu.searchbox.video.feedflow.ad.position.AdAbsReduxPosPlaceHelper;
import com.baidu.searchbox.video.feedflow.ad.position.AdListLabel;
import com.baidu.searchbox.video.feedflow.ad.position.AdStrategyState;
import com.baidu.searchbox.video.feedflow.ad.position.FlowVideoHelper;
import com.baidu.searchbox.video.feedflow.ad.position.FlowVideoLandscapeHelper;
import com.baidu.searchbox.video.feedflow.ad.position.channel.ChannelFlowHelper;
import com.baidu.searchbox.video.feedflow.ad.position.channel.ChannelFlowLandscapeHelper;
import com.baidu.searchbox.video.feedflow.ad.position.discovery.DiscoveryFlowHelper;
import com.baidu.searchbox.video.feedflow.ad.position.discovery.DiscoveryFlowLandscapeHelper;
import com.baidu.searchbox.video.feedflow.ad.position.feedad.FeedAdFlowHelper;
import com.baidu.searchbox.video.feedflow.detail.FlowDetailState;
import com.baidu.searchbox.video.feedflow.di.INadFirstPosForEcommerceListener;
import com.baidu.searchbox.video.feedflow.di.INadFirstPosServiceForEcommerce;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.FloorPolicyModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayMode;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayModePluginKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0017\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010\u001f\u001a\u00020\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u001f\u001a\u00020\u001e2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010 \u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010!\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\"\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0014\u0010#\u001a\u00020\u00112\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006J\u0012\u0010$\u001a\u00020%2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010$\u001a\u00020%2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0002J(\u0010&\u001a\u00020'2\u0018\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030*j\u0006\u0012\u0002\b\u0003`+0)2\u0006\u0010,\u001a\u00020-J\u0014\u0010.\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010*J\u0010\u00100\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u00100\u001a\u00020'2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0016\u00101\u001a\u00020'2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0016\u00102\u001a\u00020'2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u00102\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u00010\u000bJ\u0010\u00104\u001a\u00020'2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u00105\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u001a\u00105\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u00106\u001a\u0004\u0018\u00010\u0011J\u0010\u00107\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u00108\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u00108\u001a\u00020'2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0014\u00109\u001a\u00020'2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0016\u0010:\u001a\u00020'2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010;\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010<\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010=\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010=\u001a\u00020'2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010>\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010>\u001a\u00020'2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u0010\u0010?\u001a\u00020'2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010\u000f¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/AdRedux;", "", "()V", "beforeSwitchComponentManager", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "itemStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "getAdData", "Lcom/baidu/searchbox/video/feedflow/ad/detail/AdData;", "state", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "getCurAdItemModel", "Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;", "getEntryTabId", "", "getEntryVideoType", "getFlowActionType", "getFlowStyle", "Lcom/baidu/searchbox/video/feedflow/ad/FlowStyle;", "getFlowTabId", "getFromFullscreen", "getHelper", "Lcom/baidu/searchbox/video/feedflow/ad/position/AdAbsReduxPosPlaceHelper;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "flowStyle", "getListState", "Lcom/baidu/searchbox/ad/position/list/AdListState;", "getListStateLandscape", "getPage", "getPd", "getPlaceId", "getPlayMode", "getStrategyState", "Lcom/baidu/searchbox/video/feedflow/ad/position/AdStrategyState;", "ifPosBannedByFloorPolicy", "", "list", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "Lcom/baidu/searchbox/video/feedflow/ad/FlowItem;", "pos", "", "isAd", "item", "isChannelPlace", "isDiscoveryFeedPlace", "isDownload", "adData", "isEcommerceCallbackNotNull", "isFirstJumpAd", "adNid", "isFromAdVideo", "isLandscape", "isLeftSlideToAuthorProfile", "isMainFeedPlace", "isMiniVideo", "isPaidInvoke", "isPortrait", "isSearchPlace", "isShortVideo", "makeAdListRepos", "Lcom/baidu/searchbox/flowvideo/ad/repos/AdListRepositoryImpl;", "removeComponentsWhenGoodsBannerValid", "ad", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdRedux.kt */
public final class AdRedux {
    public static final AdRedux INSTANCE = new AdRedux();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdRedux.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FlowStyle.values().length];
            iArr[FlowStyle.PORTRAIT.ordinal()] = 1;
            iArr[FlowStyle.LANDSCAPE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PlayMode.values().length];
            iArr2[PlayMode.LOOP_PLAY.ordinal()] = 1;
            iArr2[PlayMode.CONTINUE_PLAY.ordinal()] = 2;
            iArr2[PlayMode.AI_PLAY.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private AdRedux() {
    }

    public final AdListRepositoryImpl makeAdListRepos() {
        return new AdListRepositoryImpl(new AdListServiceImpl());
    }

    public final boolean isAd(ItemModel<?> item) {
        return item != null && ItemTypeManifestKt.isAdsItem(item);
    }

    public final String getPd(AbsState state) {
        VideoBusiness videoBusiness;
        IntentData intentData;
        String str;
        if (state != null && (intentData = (IntentData) state.select(IntentData.class)) != null && (str = intentData.pd) != null) {
            return str;
        }
        if (state == null || (videoBusiness = (VideoBusiness) state.select(VideoBusiness.class)) == null) {
            return "feed";
        }
        return videoBusiness.pd();
    }

    public final String getFlowActionType(Store<AbsState> store) {
        if (store == null) {
            return null;
        }
        AbsState state = store.getState();
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
        if (intentData != null) {
            return intentData.getActionType();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = (r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r4.select(com.baidu.searchbox.video.detail.core.model.IntentData.class)).extRequest;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getEntryTabId(com.baidu.searchbox.feed.detail.frame.AbsState r4) {
        /*
            r3 = this;
            java.lang.String r0 = "1"
            if (r4 == 0) goto L_0x001a
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r1 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r1 = r4.select(r1)
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            if (r1 == 0) goto L_0x001a
            org.json.JSONObject r1 = r1.extRequest
            if (r1 == 0) goto L_0x001a
            java.lang.String r2 = "tab_id"
            java.lang.String r1 = r1.optString(r2, r0)
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            if (r1 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.getEntryTabId(com.baidu.searchbox.feed.detail.frame.AbsState):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r2.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getEntryVideoType(com.baidu.searchbox.feed.detail.frame.AbsState r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0011
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r0 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r2.select(r0)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.getResourceType()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = "miniVideo"
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.getEntryVideoType(com.baidu.searchbox.feed.detail.frame.AbsState):java.lang.String");
    }

    public final String getPage(AbsState state) {
        VideoBusiness videoBusiness;
        IntentData intentData;
        String str;
        if (state != null && (intentData = (IntentData) state.select(IntentData.class)) != null && (str = intentData.page) != null) {
            return str;
        }
        if (state == null || (videoBusiness = (VideoBusiness) state.select(VideoBusiness.class)) == null) {
            return "feed_video_landing";
        }
        return videoBusiness.page();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = (r0 = (com.baidu.searchbox.video.feedflow.tab.TabState) r2.select(com.baidu.searchbox.video.feedflow.tab.TabState.class)).getCurrentTabId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getFlowTabId(com.baidu.searchbox.feed.detail.frame.AbsState r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0012
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r0 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r0 = r2.select(r0)
            com.baidu.searchbox.video.feedflow.tab.TabState r0 = (com.baidu.searchbox.video.feedflow.tab.TabState) r0
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getCurrentTabId()
            if (r0 != 0) goto L_0x0014
        L_0x0012:
            java.lang.String r0 = "1"
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.getFlowTabId(com.baidu.searchbox.feed.detail.frame.AbsState):java.lang.String");
    }

    public final String getFromFullscreen(AbsState state) {
        return IVideoScreenInfoUtils.Impl.get().isScreenLand() ? "1" : "0";
    }

    public static /* synthetic */ AdAbsReduxPosPlaceHelper getHelper$default(AdRedux adRedux, ComponentArchManager componentArchManager, FlowStyle flowStyle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            flowStyle = adRedux.getFlowStyle((Store<AbsState>) componentArchManager.getStore());
        }
        return adRedux.getHelper(componentArchManager, flowStyle);
    }

    public final AdAbsReduxPosPlaceHelper getHelper(ComponentArchManager manager, FlowStyle flowStyle) {
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
        Intrinsics.checkNotNullParameter(flowStyle, "flowStyle");
        Store store = manager.getStore();
        if (isFromAdVideo(store != null ? (AbsState) store.getState() : null)) {
            switch (WhenMappings.$EnumSwitchMapping$0[flowStyle.ordinal()]) {
                case 1:
                    return new FeedAdFlowHelper(manager);
                case 2:
                    return new FlowVideoLandscapeHelper(manager);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (isChannelPlace((Store<AbsState>) manager.getStore())) {
            switch (WhenMappings.$EnumSwitchMapping$0[flowStyle.ordinal()]) {
                case 1:
                    return new ChannelFlowHelper(manager);
                case 2:
                    return new ChannelFlowLandscapeHelper(manager);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else if (isDiscoveryFeedPlace(manager.getStore())) {
            switch (WhenMappings.$EnumSwitchMapping$0[flowStyle.ordinal()]) {
                case 1:
                    return new DiscoveryFlowHelper(manager);
                case 2:
                    return new DiscoveryFlowLandscapeHelper(manager);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[flowStyle.ordinal()]) {
                case 1:
                    return new FlowVideoHelper(manager);
                case 2:
                    return new FlowVideoLandscapeHelper(manager);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final boolean isFromAdVideo(AbsState state) {
        return TextUtils.equals(getEntryVideoType(state), AdReduxKt.ENTRY_VIDEO_TYPE_AD_VIDEO);
    }

    private final AdStrategyState getStrategyState(Store<AbsState> store) {
        return getStrategyState(store != null ? store.getState() : null);
    }

    private final AdStrategyState getStrategyState(AbsState state) {
        AdStrategyState adStrategyState;
        AbsState absState = state;
        if (absState != null && (adStrategyState = (AdStrategyState) absState.select(AdStrategyState.class)) != null) {
            return adStrategyState;
        }
        AdRedux adRedux = this;
        AdStrategyState strategyState = new AdStrategyState((MutableLiveData) null, (AdListState) null, (AdListState) null, (MutableLiveData) null, (MutableLiveData) null, AdListLabel.FLOW, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2015, (DefaultConstructorMarker) null);
        if (absState != null) {
            absState.put(strategyState);
        }
        return strategyState;
    }

    public final FlowStyle getFlowStyle(Store<AbsState> store) {
        return getFlowStyle(store != null ? store.getState() : null);
    }

    public final FlowStyle getFlowStyle(AbsState state) {
        FlowStyle flowStyle;
        FlowStyle value = getStrategyState(state).getFlowStyle().getValue();
        if (value != null) {
            return value;
        }
        AdRedux adRedux = this;
        if (IVideoScreenInfoUtils.Impl.get().isScreenLand()) {
            flowStyle = FlowStyle.LANDSCAPE;
        } else {
            flowStyle = FlowStyle.PORTRAIT;
        }
        return flowStyle;
    }

    public final AdListState getListState(Store<AbsState> store) {
        return getListState(store != null ? store.getState() : null);
    }

    public final AdListState getListState(AbsState state) {
        return getStrategyState(state).getListState();
    }

    public final AdListState getListStateLandscape(Store<AbsState> store) {
        return getListStateLandscape(store != null ? store.getState() : null);
    }

    public final AdListState getListStateLandscape(AbsState state) {
        return getStrategyState(state).getListStateLandscape();
    }

    public final boolean isLandscape(Store<AbsState> store) {
        return isLandscape(store != null ? store.getState() : null);
    }

    public final boolean isLandscape(AbsState state) {
        return getFlowStyle(state) == FlowStyle.LANDSCAPE;
    }

    public final boolean isPortrait(Store<AbsState> store) {
        return isPortrait(store != null ? store.getState() : null);
    }

    public final boolean isPortrait(AbsState state) {
        return getFlowStyle(state) == FlowStyle.PORTRAIT;
    }

    public final boolean isMiniVideo(AbsState state) {
        FlowDetailState flowDetailState;
        FlowDetailModel $this$isMiniVideo_u24lambda_u2d2;
        if (state == null || (flowDetailState = (FlowDetailState) state.select(FlowDetailState.class)) == null || ($this$isMiniVideo_u24lambda_u2d2 = flowDetailState.getData()) == null) {
            return false;
        }
        Integer height = StringsKt.toIntOrNull($this$isMiniVideo_u24lambda_u2d2.getVideoHeight());
        Integer width = StringsKt.toIntOrNull($this$isMiniVideo_u24lambda_u2d2.getVideoWidth());
        if (height == null || width == null || height.intValue() <= width.intValue()) {
            return false;
        }
        return true;
    }

    public final boolean isShortVideo(AbsState state) {
        FlowDetailState flowDetailState;
        FlowDetailModel $this$isShortVideo_u24lambda_u2d3;
        if (state == null || (flowDetailState = (FlowDetailState) state.select(FlowDetailState.class)) == null || ($this$isShortVideo_u24lambda_u2d3 = flowDetailState.getData()) == null) {
            return false;
        }
        Integer height = StringsKt.toIntOrNull($this$isShortVideo_u24lambda_u2d3.getVideoHeight());
        Integer width = StringsKt.toIntOrNull($this$isShortVideo_u24lambda_u2d3.getVideoWidth());
        if (height == null || width == null || height.intValue() > width.intValue()) {
            return false;
        }
        return true;
    }

    public final AdData getAdData(Store<AbsState> store) {
        MutableLiveData<AdData> data;
        if (store == null) {
            return null;
        }
        AbsState state = store.getState();
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        AdDataState adDataState = (AdDataState) (commonState != null ? commonState.select(AdDataState.class) : null);
        if (adDataState == null || (data = adDataState.getData()) == null) {
            return null;
        }
        return data.getValue();
    }

    public final AdData getAdData(AbsState state) {
        AdDataState adDataState;
        MutableLiveData<AdData> data;
        if (state == null || (adDataState = (AdDataState) state.select(AdDataState.class)) == null || (data = adDataState.getData()) == null) {
            return null;
        }
        return data.getValue();
    }

    public final boolean isSearchPlace(Store<AbsState> store) {
        return isSearchPlace(store != null ? store.getState() : null);
    }

    public final boolean isSearchPlace(AbsState state) {
        return getStrategyState(state).getListLabel() == AdListLabel.SEARCH_FLOW;
    }

    public final boolean isMainFeedPlace(Store<AbsState> store) {
        AbsState absState = null;
        String pd = getPd(store != null ? store.getState() : null);
        String entryTabId = getEntryTabId(store != null ? store.getState() : null);
        if (store != null) {
            absState = store.getState();
        }
        String page = getPage(absState);
        FlowStyle flowStyle = getFlowStyle(store);
        return AdReduxPlace.MAIN_FEED.check(page, pd, flowStyle, entryTabId) || AdReduxPlace.MAIN_FEED_LANDSCAPE.check(page, pd, flowStyle, entryTabId);
    }

    public final boolean isDiscoveryFeedPlace(Store<AbsState> store) {
        AbsState absState = null;
        String pd = getPd(store != null ? store.getState() : null);
        String entryTabId = getEntryTabId(store != null ? store.getState() : null);
        if (store != null) {
            absState = store.getState();
        }
        String page = getPage(absState);
        FlowStyle flowStyle = getFlowStyle(store);
        return AdReduxPlace.DISCOVERY.check(page, pd, flowStyle, entryTabId) || AdReduxPlace.DISCOVERY_LANDSCAPE.check(page, pd, flowStyle, entryTabId);
    }

    public final boolean isChannelPlace(AbsState state) {
        return getStrategyState(state).getListLabel().isChannelFlow();
    }

    public final boolean isChannelPlace(Store<AbsState> store) {
        return isChannelPlace(store != null ? store.getState() : null);
    }

    public final void removeComponentsWhenGoodsBannerValid(AdItemModel ad) {
        if (ad != null) {
            ad.setSlidingTag((NadSlidingTagModel) null);
        }
        if (ad != null) {
            ad.setNormandy((AdNormandyModel) null);
        }
        if (ad != null) {
            ad.setSicilyPop((NadSicilyModel) null);
        }
        if (ad != null) {
            ad.setPopover((AdLpParams.PopoverModel) null);
        }
    }

    public final String getPlaceId(Store<AbsState> store) {
        return getPlaceId(store != null ? store.getState() : null);
    }

    public final String getPlaceId(AbsState state) {
        AdPolicyState adPolicyState;
        AdPolicyState adPolicyState2;
        if (isPortrait(state)) {
            if (state == null || (adPolicyState2 = (AdPolicyState) state.select(AdPolicyState.class)) == null) {
                return null;
            }
            return adPolicyState2.getPlaceIdPortrait();
        } else if (state == null || (adPolicyState = (AdPolicyState) state.select(AdPolicyState.class)) == null) {
            return null;
        } else {
            return adPolicyState.getPlaceIdLandscape();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isFirstJumpAd(com.baidu.searchbox.feed.detail.arch.ext.CommonState r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0012
            r1 = r6
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r3 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r1 = r1.select(r3)
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = r1.nid
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            if (r6 == 0) goto L_0x0025
            r2 = r6
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r4 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r2 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r2
            if (r2 == 0) goto L_0x0025
            java.lang.String r0 = r2.getNid()
        L_0x0025:
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0035
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            r4 = r4 ^ r3
            if (r4 != r3) goto L_0x0035
            r4 = r3
            goto L_0x0036
        L_0x0035:
            r4 = r2
        L_0x0036:
            if (r4 == 0) goto L_0x0050
            if (r0 == 0) goto L_0x0046
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            r4 = r4 ^ r3
            if (r4 != r3) goto L_0x0046
            r4 = r3
            goto L_0x0047
        L_0x0046:
            r4 = r2
        L_0x0047:
            if (r4 == 0) goto L_0x0050
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x0050
            r2 = r3
        L_0x0050:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.isFirstJumpAd(com.baidu.searchbox.feed.detail.arch.ext.CommonState):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isFirstJumpAd(com.baidu.searchbox.feed.detail.arch.ext.CommonState r5, java.lang.String r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0011
            r0 = r5
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r2 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.nid
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0022
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ r2
            if (r3 != r2) goto L_0x0022
            r3 = r2
            goto L_0x0023
        L_0x0022:
            r3 = r1
        L_0x0023:
            if (r3 == 0) goto L_0x003d
            if (r6 == 0) goto L_0x0033
            r3 = r6
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ r2
            if (r3 != r2) goto L_0x0033
            r3 = r2
            goto L_0x0034
        L_0x0033:
            r3 = r1
        L_0x0034:
            if (r3 == 0) goto L_0x003d
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x003d
            r1 = r2
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.isFirstJumpAd(com.baidu.searchbox.feed.detail.arch.ext.CommonState, java.lang.String):boolean");
    }

    public final boolean ifPosBannedByFloorPolicy(List<ItemModel<?>> list, int pos) {
        CommonItemData commonItemData;
        FloorPolicyModel floorPolicy;
        CommonItemData commonItemData2;
        FloorPolicyModel floorPolicy2;
        Intrinsics.checkNotNullParameter(list, "list");
        ItemModel itemModel = (ItemModel) CollectionsKt.getOrNull(list, pos);
        boolean isTargetPosItemAd = itemModel != null ? ItemTypeManifestKt.isAdsItem((ItemModel<?>) itemModel) : false;
        ItemModel itemModel2 = (ItemModel) CollectionsKt.getOrNull(list, pos - 1);
        boolean prevUgcBanAdBehind = (itemModel2 == null || (commonItemData2 = itemModel2.getCommonItemData()) == null || (floorPolicy2 = commonItemData2.getFloorPolicy()) == null || !floorPolicy2.getBanAdBehind()) ? false : true;
        ItemModel itemModel3 = (ItemModel) CollectionsKt.getOrNull(list, isTargetPosItemAd ? pos + 1 : pos);
        boolean nextUgcBanAdAhead = (itemModel3 == null || (commonItemData = itemModel3.getCommonItemData()) == null || (floorPolicy = commonItemData.getFloorPolicy()) == null || !floorPolicy.getBanAdAhead()) ? false : true;
        if (prevUgcBanAdBehind || nextUgcBanAdAhead) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r4.getOperate();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isDownload(com.baidu.searchbox.video.feedflow.ad.detail.AdData r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0011
            com.baidu.searchbox.ad.model.FeedAdOperate r2 = r4.getOperate()
            if (r2 == 0) goto L_0x0011
            boolean r2 = r2.isDownload()
            if (r2 != r0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.isDownload(com.baidu.searchbox.video.feedflow.ad.detail.AdData):boolean");
    }

    public final boolean isDownload(Store<AbsState> store) {
        MutableLiveData<AdData> data;
        AdData adData = null;
        if (store != null) {
            AbsState state = store.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            AdDataState adDataState = (AdDataState) (commonState != null ? commonState.select(AdDataState.class) : null);
            if (!(adDataState == null || (data = adDataState.getData()) == null)) {
                adData = data.getValue();
            }
        }
        return isDownload(adData);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        r0 = (r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5.select(com.baidu.searchbox.video.detail.core.model.IntentData.class)).extRequest;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isPaidInvoke(com.baidu.searchbox.feed.detail.frame.AbsState r5) {
        /*
            r4 = this;
            boolean r0 = com.baidu.searchbox.feed.ad.AdUtil.externalInvokeNewApiSwitch()
            java.lang.String r1 = "is_paid_invoke"
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0039
            com.baidu.searchbox.ad.IExternalInvoke r0 = com.baidu.searchbox.feed.ad.AdRuntimeHolder.getExternalInvoke()
            org.json.JSONObject r0 = r0.getExternalInvokeInfo()
            if (r0 != 0) goto L_0x0038
            boolean r0 = com.baidu.searchbox.unitedscheme.SchemeChannelCheckInterceptor.isRecentSchemeInDppageIn8Days()
            if (r0 != 0) goto L_0x0038
            if (r5 == 0) goto L_0x0032
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r0 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r5.select(r0)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x0032
            org.json.JSONObject r0 = r0.extRequest
            if (r0 == 0) goto L_0x0032
            int r0 = r0.optInt(r1, r3)
            if (r0 != r2) goto L_0x0032
            r0 = r2
            goto L_0x0033
        L_0x0032:
            r0 = r3
        L_0x0033:
            if (r0 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r2 = r3
            goto L_0x005e
        L_0x0038:
            goto L_0x005e
        L_0x0039:
            boolean r0 = com.baidu.searchbox.unitedscheme.SchemeChannelCheckInterceptor.isRecentSchemeInDppageIn8Days()
            if (r0 != 0) goto L_0x005d
            if (r5 == 0) goto L_0x0057
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r0 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r5.select(r0)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x0057
            org.json.JSONObject r0 = r0.extRequest
            if (r0 == 0) goto L_0x0057
            int r0 = r0.optInt(r1, r3)
            if (r0 != r2) goto L_0x0057
            r0 = r2
            goto L_0x0058
        L_0x0057:
            r0 = r3
        L_0x0058:
            if (r0 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r2 = r3
            goto L_0x005e
        L_0x005d:
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.isPaidInvoke(com.baidu.searchbox.feed.detail.frame.AbsState):boolean");
    }

    public final boolean isEcommerceCallbackNotNull(ComponentArchManager manager) {
        INadFirstPosServiceForEcommerce service;
        INadFirstPosForEcommerceListener listener = null;
        if (manager != null) {
            service = (INadFirstPosServiceForEcommerce) manager.getService(INadFirstPosServiceForEcommerce.class);
        } else {
            service = null;
        }
        if (service != null) {
            listener = service.getNadFirstPosListener();
        }
        return AdReduxExpManager.INSTANCE.getFlowAdFirstPvPosWithEcommerceCallBack() >= 0 && listener != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a0, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) (r5 == null || (r0 = r5.getData()) == null || (r0 = r0.getValue()) == null) ? null : r0.getEtrade(), (java.lang.Object) "4") != false) goto L_0x00a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isLeftSlideToAuthorProfile(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = r9
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r2 = r0.getState()
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r4 = 0
            if (r3 == 0) goto L_0x0014
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x0015
        L_0x0014:
            r2 = r4
        L_0x0015:
            if (r2 == 0) goto L_0x001e
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r3 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r2 = r2.select(r3)
            goto L_0x001f
        L_0x001e:
            r2 = r4
        L_0x001f:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r2 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r2
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0031
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r1 = r2.getData()
            if (r1 == 0) goto L_0x0031
            java.lang.String r1 = r1.getLayout()
            if (r1 != 0) goto L_0x0032
        L_0x0031:
            r1 = r0
        L_0x0032:
            boolean r1 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isAdLiveItem((java.lang.String) r1)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x00a2
            r1 = r9
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r1.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0047
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0048
        L_0x0047:
            r6 = r4
        L_0x0048:
            if (r6 == 0) goto L_0x0051
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r7 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0052
        L_0x0051:
            r6 = r4
        L_0x0052:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r6 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r6
            if (r6 == 0) goto L_0x0064
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r1 = r6.getData()
            if (r1 == 0) goto L_0x0064
            java.lang.String r1 = r1.getLayout()
            if (r1 != 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r0 = r1
        L_0x0064:
            boolean r0 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isSoftAdLiveItem((java.lang.String) r0)
            if (r0 != 0) goto L_0x00a2
            r0 = r9
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0077
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0078
        L_0x0077:
            r5 = r4
        L_0x0078:
            if (r5 == 0) goto L_0x0081
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r6 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0082
        L_0x0081:
            r5 = r4
        L_0x0082:
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r5 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r5
            if (r5 == 0) goto L_0x0099
            androidx.lifecycle.MutableLiveData r0 = r5.getData()
            if (r0 == 0) goto L_0x0099
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r0
            if (r0 == 0) goto L_0x0099
            java.lang.String r0 = r0.getEtrade()
            goto L_0x009a
        L_0x0099:
            r0 = r4
        L_0x009a:
            java.lang.String r1 = "4"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00d6
        L_0x00a2:
            r0 = r9
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x00af
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00b0
        L_0x00af:
            r5 = r4
        L_0x00b0:
            if (r5 == 0) goto L_0x00b8
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r4 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r4 = r5.select(r4)
        L_0x00b8:
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r4 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r4
            if (r4 == 0) goto L_0x00d2
            androidx.lifecycle.MutableLiveData r0 = r4.getData()
            if (r0 == 0) goto L_0x00d2
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r0
            if (r0 == 0) goto L_0x00d2
            int r0 = r0.getAdVTag()
            if (r0 != r2) goto L_0x00d2
            r0 = r2
            goto L_0x00d3
        L_0x00d2:
            r0 = r3
        L_0x00d3:
            if (r0 == 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r2 = r3
        L_0x00d7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.isLeftSlideToAuthorProfile(com.baidu.searchbox.feed.detail.frame.Store):boolean");
    }

    public final String getPlayMode(Store<?> store) {
        switch (WhenMappings.$EnumSwitchMapping$1[PlayModePluginKt.getCurPlayMode(store).ordinal()]) {
            case 1:
                return "0";
            case 2:
                return "1";
            case 3:
                return "2";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void beforeSwitchComponentManager(Store<CommonState> store, AbsStore<CommonState> itemStore) {
        Intrinsics.checkNotNullParameter(itemStore, "itemStore");
        State state = itemStore.getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        AdStrategyState adStrategyState = (AdStrategyState) (commonState != null ? commonState.select(AdStrategyState.class) : null);
        if (adStrategyState != null) {
            AdStrategyState itemStrategyState = adStrategyState;
            if (store != null) {
                CommonState state2 = store.getState();
                CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
                if (commonState2 != null) {
                    obj = commonState2.select(AdStrategyState.class);
                }
                AdStrategyState adStrategyState2 = (AdStrategyState) obj;
                if (adStrategyState2 != null) {
                    AdStrategyState listStrategyState = adStrategyState2;
                    listStrategyState.getListState().setVideoPlayInfoMap(itemStrategyState.getListState().getVideoPlayInfoMap());
                    listStrategyState.getListStateLandscape().setVideoPlayInfoMap(itemStrategyState.getListState().getVideoPlayInfoMap());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel getCurAdItemModel(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x002a
            r1 = r6
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0010
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0011
        L_0x0010:
            r3 = r0
        L_0x0011:
            if (r3 == 0) goto L_0x001a
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r4 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x002a
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = r3.getCurItemModel()
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r1.getData()
            goto L_0x002b
        L_0x002a:
            r1 = r0
        L_0x002b:
            boolean r2 = r1 instanceof com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel
            if (r2 == 0) goto L_0x0032
            r0 = r1
            com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r0 = (com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel) r0
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdRedux.getCurAdItemModel(com.baidu.searchbox.feed.detail.frame.Store):com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel");
    }
}
