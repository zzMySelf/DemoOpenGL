package com.baidu.searchbox.video.feedflow.ad.position.collnext;

import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.nadcore.utils.FixedCapacityFifoQueue;
import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import com.baidu.searchbox.ad.exp.adconfig.ADConfigUtil;
import com.baidu.searchbox.ad.model.FeedAdOperate;
import com.baidu.searchbox.ad.position.list.AdListState;
import com.baidu.searchbox.ad.position.list.VideoPlayInfo;
import com.baidu.searchbox.ad.util.CollectionUtils;
import com.baidu.searchbox.ad.util.NadConsoleLog;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.IAdDeviceInfo;
import com.baidu.searchbox.feed.ad.model.AppInfoModel;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.flowvideo.ad.repos.AdListParam;
import com.baidu.searchbox.flowvideo.ad.repos.AdListParamKt;
import com.baidu.searchbox.flowvideo.ad.repos.AdListRepositoryImpl;
import com.baidu.searchbox.player.preboot.PrebootEngine;
import com.baidu.searchbox.player.preboot.env.PolicyScene;
import com.baidu.searchbox.player.preboot.env.PrebootRuntimeKt;
import com.baidu.searchbox.player.preboot.env.PrebootType;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.ad.AdRedux;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.ad.ExtraInfo;
import com.baidu.searchbox.video.feedflow.ad.FlowStyle;
import com.baidu.searchbox.video.feedflow.ad.IAdCollectionNextService;
import com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel;
import com.baidu.searchbox.video.feedflow.ad.flow.DuplicateAdRemoved;
import com.baidu.searchbox.video.feedflow.ad.flow.MaterialError;
import com.baidu.searchbox.video.feedflow.ad.policy.AdPolicyState;
import com.baidu.searchbox.video.feedflow.ad.position.AdStrategyState;
import com.baidu.searchbox.video.feedflow.ad.position.PositionSelectedData;
import com.baidu.searchbox.video.feedflow.ad.position.colladapt.IntervalCollAdaptGlobal;
import com.baidu.searchbox.video.feedflow.ad.util.DupStrategy;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.StrategyVideoModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J@\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010)2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-J\n\u0010.\u001a\u0004\u0018\u00010$H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u000203H\u0002J&\u00104\u001a\u0002052\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\b\u00107\u001a\u00020\u0016H\u0016J\b\u00108\u001a\u00020\u000eH\u0002J\u0014\u00109\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020\u0016H\u0016J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u000205H\u0002J \u0010>\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006?"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/position/collnext/AdCollectionNextPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "adSessionRefresh", "", "collId", "", "collPlayHistory", "", "getCollPlayHistory", "()Ljava/util/List;", "collPlayHistory$delegate", "Lkotlin/Lazy;", "isRequestFromLandscape", "", "isRequestProcessing", "repo", "Lcom/baidu/searchbox/flowvideo/ad/repos/AdListRepositoryImpl;", "getRepo", "()Lcom/baidu/searchbox/flowvideo/ad/repos/AdListRepositoryImpl;", "repo$delegate", "addCollectionNextAd", "", "ad", "Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;", "checkAdAppInfoValid", "adItemData", "checkAdDynamicValid", "checkAdValid", "checkAdVideoInfoValid", "checkRequestCondition", "isSwitchNext", "nextNid", "discardFlowListAd", "expandUserBehaviorToPvContext", "json", "Lorg/json/JSONObject;", "info", "Lcom/baidu/searchbox/ad/position/list/VideoPlayInfo;", "filterValidAd", "getCollectionNextAd", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "collItemModel", "currNid", "extraInfo", "Lcom/baidu/searchbox/video/feedflow/ad/ExtraInfo;", "getDa", "getDspReqInterval", "getLastAd", "getParamStr", "getPvContext", "Lorg/json/JSONArray;", "getRequestParams", "Lcom/baidu/searchbox/flowvideo/ad/repos/AdListParam;", "collPlayRecord", "injectService", "isSameCollection", "makeAdElement", "onAttachToManager", "preRenderAd", "requestAd", "param", "tryRequest", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdCollectionNextPlugin.kt */
public final class AdCollectionNextPlugin extends LiveDataPlugin {
    private int adSessionRefresh = 1;
    /* access modifiers changed from: private */
    public String collId = "";
    private final Lazy collPlayHistory$delegate = LazyKt.lazy(AdCollectionNextPlugin$collPlayHistory$2.INSTANCE);
    /* access modifiers changed from: private */
    public boolean isRequestFromLandscape;
    /* access modifiers changed from: private */
    public boolean isRequestProcessing;
    private final Lazy repo$delegate = LazyKt.lazy(AdCollectionNextPlugin$repo$2.INSTANCE);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdCollectionNextPlugin.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlowStyle.values().length];
            iArr[FlowStyle.PORTRAIT.ordinal()] = 1;
            iArr[FlowStyle.LANDSCAPE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final List<String> getCollPlayHistory() {
        return (List) this.collPlayHistory$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AdListRepositoryImpl getRepo() {
        return (AdListRepositoryImpl) this.repo$delegate.getValue();
    }

    public void onAttachToManager() {
        AdStrategyState $this$onAttachToManager_u24lambda_u2d5;
        AdCollListState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d2 = (AdCollListState) store.subscribe((Class<T>) AdCollListState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d2.getCollAdShow().observe(this, new AdCollectionNextPlugin$$ExternalSyntheticLambda0(this, $this$onAttachToManager_u24lambda_u2d2));
        }
        Store<AbsState> store2 = getStore();
        if (store2 != null && ($this$onAttachToManager_u24lambda_u2d5 = (AdStrategyState) store2.subscribe((Class<T>) AdStrategyState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d5.getFlowStyle().observe(this, new AdCollectionNextPlugin$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d5.getPositionSelected().observe(this, new AdCollectionNextPlugin$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2  */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5647onAttachToManager$lambda2$lambda1(com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin r9, com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState r10, com.baidu.searchbox.video.feedflow.flow.list.ItemModel r11) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "$this_run"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.Object r0 = r11.getData()
            boolean r1 = r0 instanceof com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel
            r2 = 0
            if (r1 == 0) goto L_0x0017
            com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r0 = (com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel) r0
            goto L_0x0018
        L_0x0017:
            r0 = r2
        L_0x0018:
            if (r0 == 0) goto L_0x0025
            com.baidu.searchbox.video.feedflow.ad.flow.AdRunTime r0 = r0.getRunTime()
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r0.getCollAdCollId()
            goto L_0x0026
        L_0x0025:
            r0 = r2
        L_0x0026:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0035
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r0 = r1
            goto L_0x0036
        L_0x0035:
            r0 = r3
        L_0x0036:
            if (r0 == 0) goto L_0x0039
            return
        L_0x0039:
            java.lang.Object r0 = r11.getData()
            boolean r4 = r0 instanceof com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel
            if (r4 == 0) goto L_0x0044
            com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r0 = (com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel) r0
            goto L_0x0045
        L_0x0044:
            r0 = r2
        L_0x0045:
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            java.util.List r4 = r9.getCollPlayHistory()
            java.util.List r5 = r9.getCollPlayHistory()
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast((int) r5, (int) r1)
            java.lang.String r5 = r11.getNid()
            r4.add(r1, r5)
            java.util.List r1 = r9.getCollPlayHistory()
            int r4 = r10.getLastAdPos()
            int r4 = r4 + r3
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r1, r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0094
            r3 = 0
            com.baidu.searchbox.video.feedflow.ad.AdRedux r4 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r5 = r9.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r4 = r4.getListState((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r5)
            java.util.Map r4 = r4.getVideoPlayInfoMap()
            java.lang.Object r4 = r4.get(r1)
            com.baidu.searchbox.ad.position.list.VideoPlayInfo r4 = (com.baidu.searchbox.ad.position.list.VideoPlayInfo) r4
            if (r4 == 0) goto L_0x008c
            java.lang.Long r4 = r4.getShowTs()
            goto L_0x008d
        L_0x008c:
            r4 = r2
        L_0x008d:
            if (r4 == 0) goto L_0x0094
            long r3 = r4.longValue()
            goto L_0x0098
        L_0x0094:
            long r3 = r10.getSessionStartTime()
        L_0x0098:
            java.util.List r1 = r9.getCollPlayHistory()
            java.lang.String r5 = r11.getNid()
            int r1 = r1.indexOf(r5)
            com.baidu.searchbox.feed.detail.frame.Store r5 = r9.getStore()
            if (r5 == 0) goto L_0x00ba
            com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextAction$CollAdShow r6 = new com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextAction$CollAdShow
            java.lang.String r7 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)
            r6.<init>(r11, r1, r3)
            com.baidu.searchbox.feed.detail.frame.Action r6 = (com.baidu.searchbox.feed.detail.frame.Action) r6
            r5.dispatch(r6)
        L_0x00ba:
            int r5 = r10.getLastAdPos()
            r6 = -1
            if (r5 != r6) goto L_0x00c4
            r10.setFirstAdPos(r1)
        L_0x00c4:
            r10.setLastAd(r0)
            r10.setLastAdPos(r1)
            long r5 = java.lang.System.currentTimeMillis()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            r10.setLastAdEShowTs(r5)
            com.baidu.searchbox.video.feedflow.ad.flow.AdRunTime r5 = r0.getRunTime()
            boolean r5 = r5.isRequestFromLandscape()
            if (r5 == 0) goto L_0x00e2
            r10.setAdLandscapeCache(r2)
            goto L_0x00e5
        L_0x00e2:
            r10.setAdPortraitCache(r2)
        L_0x00e5:
            r9.discardFlowListAd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.m5647onAttachToManager$lambda2$lambda1(com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin, com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-3  reason: not valid java name */
    public static final void m5648onAttachToManager$lambda5$lambda3(AdCollectionNextPlugin this$0, FlowStyle style) {
        ItemModel curItemModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IFlowComponentService iFlowComponentService = (IFlowComponentService) this$0.getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService != null && (curItemModel = iFlowComponentService.getCurItemModel()) != null) {
            Object data = curItemModel.getData();
            VideoItemModel data2 = data instanceof VideoItemModel ? (VideoItemModel) data : null;
            if (data2 != null) {
                if (data2.getCollId().length() > 0) {
                    this$0.tryRequest(true, data2.getCollId(), curItemModel.getNid());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-4  reason: not valid java name */
    public static final void m5649onAttachToManager$lambda5$lambda4(AdCollectionNextPlugin this$0, PositionSelectedData position) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isSameCollection()) {
            Store $this$select$iv = this$0.getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                Object obj = null;
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(AdCollListState.class);
                }
                AdCollListState adCollListState = (AdCollListState) obj;
                if (adCollListState != null) {
                    adCollListState.reset();
                }
            }
            this$0.getCollPlayHistory().clear();
            this$0.adSessionRefresh = 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isSameCollection() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r7.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r2 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r2)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r0 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r0
            r1 = 0
            if (r0 == 0) goto L_0x0015
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r0.getCurItemModel()
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x001d
            java.lang.Object r2 = r0.getData()
            goto L_0x001e
        L_0x001d:
            r2 = r1
        L_0x001e:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r3 == 0) goto L_0x0025
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r2 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r2
            goto L_0x0026
        L_0x0025:
            r2 = r1
        L_0x0026:
            if (r2 == 0) goto L_0x002d
            java.lang.String r2 = r2.getCollId()
            goto L_0x002e
        L_0x002d:
            r2 = r1
        L_0x002e:
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x003a
            boolean r5 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isAdsItem((com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r0)
            if (r5 != r3) goto L_0x003a
            r5 = r3
            goto L_0x003b
        L_0x003a:
            r5 = r4
        L_0x003b:
            if (r5 == 0) goto L_0x0064
            java.lang.Object r5 = r0.getData()
            boolean r6 = r5 instanceof com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel
            if (r6 == 0) goto L_0x0048
            r1 = r5
            com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r1 = (com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel) r1
        L_0x0048:
            if (r1 == 0) goto L_0x0060
            com.baidu.searchbox.video.feedflow.ad.flow.AdRunTime r1 = r1.getRunTime()
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = r1.getCollAdCollId()
            if (r1 == 0) goto L_0x0060
            java.lang.String r5 = r7.collId
            boolean r1 = r1.equals(r5)
            if (r1 != r3) goto L_0x0060
            r1 = r3
            goto L_0x0061
        L_0x0060:
            r1 = r4
        L_0x0061:
            if (r1 == 0) goto L_0x0064
            return r3
        L_0x0064:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0071
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r3 = r4
        L_0x0071:
            if (r3 == 0) goto L_0x0074
            return r4
        L_0x0074:
            java.lang.String r1 = r7.collId
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.isSameCollection():boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0078: MOVE  (r6v4 'idx' int) = (r1v5 'nextPos' int)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    private final void discardFlowListAd() {
        /*
            r18 = this;
            com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager r0 = com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager.INSTANCE
            boolean r0 = r0.getFlowCollAdDiscardSwitch()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.baidu.searchbox.video.feedflow.ad.AdRedux r0 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r1 = r18.getStore()
            boolean r0 = r0.isLandscape((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r1)
            if (r0 == 0) goto L_0x0020
            com.baidu.searchbox.video.feedflow.ad.AdRedux r0 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r1 = r18.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r0 = r0.getListStateLandscape((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r1)
            goto L_0x002a
        L_0x0020:
            com.baidu.searchbox.video.feedflow.ad.AdRedux r0 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r1 = r18.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r0 = r0.getListState((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r1)
        L_0x002a:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1 = r18.getManager()
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r3 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r1 = r1.getService(r3)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r1 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r1
            if (r1 == 0) goto L_0x003f
            int r1 = r1.getCurItemPosition()
            goto L_0x0043
        L_0x003f:
            int r1 = r0.getUserPos()
        L_0x0043:
            r2 = 1
            int r1 = r1 + r2
            int r3 = r0.getUserPos()
            com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager r4 = com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager.INSTANCE
            int r4 = r4.getCheckStickRange()
            int r3 = r3 + r4
            com.baidu.searchbox.feed.detail.frame.Store r4 = r18.getStore()
            if (r4 == 0) goto L_0x00de
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0062
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0063
        L_0x0062:
            r6 = 0
        L_0x0063:
            if (r6 == 0) goto L_0x006c
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r7 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x006d
        L_0x006c:
            r6 = 0
        L_0x006d:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r6 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r6
            if (r6 == 0) goto L_0x00de
            java.util.List r4 = r6.getFlowList()
            if (r4 == 0) goto L_0x00de
            r5 = 0
            r6 = r1
            if (r6 > r3) goto L_0x00dd
        L_0x007b:
            java.lang.Object r7 = kotlin.collections.CollectionsKt.getOrNull(r4, r6)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r7
            r9 = 0
            if (r7 == 0) goto L_0x008b
            boolean r10 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isAdsItem((com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r7)
            if (r10 != r2) goto L_0x008b
            r9 = r2
        L_0x008b:
            if (r9 != 0) goto L_0x008e
            goto L_0x00d8
        L_0x008e:
            java.lang.Object r9 = r7.getData()
            boolean r10 = r9 instanceof com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel
            if (r10 == 0) goto L_0x0099
            com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r9 = (com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel) r9
            goto L_0x009a
        L_0x0099:
            r9 = 0
        L_0x009a:
            if (r9 != 0) goto L_0x009d
            goto L_0x00d8
        L_0x009d:
            r15 = r9
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r9 = r18.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r10 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r9 = r9.getService(r10)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r9 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r9
            if (r9 == 0) goto L_0x00c0
            r14 = r9
            r16 = 0
            r11 = 1
            r12 = 0
            r13 = 4
            r17 = 0
            r10 = r6
            r8 = r14
            r14 = r17
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.DefaultImpls.removeListData$default(r9, r10, r11, r12, r13, r14)
            r8.notifyItemRangeRemoved(r6, r2)
        L_0x00c0:
            com.baidu.searchbox.feed.detail.frame.Store r8 = r18.getStore()
            if (r8 == 0) goto L_0x00d8
            com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextAction$DiscardFlowListAd r9 = new com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextAction$DiscardFlowListAd
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r10 = r7.getRunTimeStatus()
            boolean r10 = r10.isReportShow()
            r9.<init>(r15, r10)
            com.baidu.searchbox.feed.detail.frame.Action r9 = (com.baidu.searchbox.feed.detail.frame.Action) r9
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r8, r9)
        L_0x00d8:
            if (r6 == r3) goto L_0x00dd
            int r6 = r6 + 1
            goto L_0x007b
        L_0x00dd:
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.discardFlowListAd():void");
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(IAdCollectionNextService.class, new AdCollectionNextServiceImpl(this));
    }

    public final ItemModel<?> getCollectionNextAd(ItemModel<?> collItemModel, String collId2, String currNid, String nextNid, boolean isSwitchNext, ExtraInfo extraInfo) {
        String collId3;
        Intrinsics.checkNotNullParameter(collItemModel, "collItemModel");
        Intrinsics.checkNotNullParameter(collId2, "collId");
        Intrinsics.checkNotNullParameter(currNid, "currNid");
        Intrinsics.checkNotNullParameter(nextNid, "nextNid");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        boolean z = false;
        if (!(currNid.length() == 0)) {
            if (nextNid.length() == 0) {
                z = true;
            }
            if (!z) {
                if (isSwitchNext) {
                    if (!getCollPlayHistory().contains(currNid)) {
                        getCollPlayHistory().add(currNid);
                    }
                    if (getCollPlayHistory().contains(nextNid)) {
                        getCollPlayHistory().remove(nextNid);
                    }
                    getCollPlayHistory().add(nextNid);
                }
                Object data = collItemModel.getData();
                VideoItemModel videoItemModel = data instanceof VideoItemModel ? (VideoItemModel) data : null;
                if (videoItemModel == null || (collId3 = videoItemModel.getCollId()) == null) {
                    return null;
                }
                this.collId = collId3;
                switch (WhenMappings.$EnumSwitchMapping$0[AdRedux.INSTANCE.getFlowStyle(getStore()).ordinal()]) {
                    case 1:
                        Store $this$select$iv = getStore();
                        if ($this$select$iv != null) {
                            AbsState state = $this$select$iv.getState();
                            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                            AdCollListState adCollListState = (AdCollListState) (commonState != null ? commonState.select(AdCollListState.class) : null);
                            if (adCollListState != null) {
                                AdCollListState adCollListState2 = adCollListState;
                                if (adCollListState2.getAdPortraitCache() == null) {
                                    tryRequest(isSwitchNext, collId2, nextNid);
                                    NadConsoleLog.INSTANCE.collNextAd("竖屏广告缓存为空，返回null，发送异步306请求");
                                    return null;
                                } else if ((getCollPlayHistory().indexOf(nextNid) - adCollListState2.getLastAdPos()) - 1 < AdReduxExpManager.INSTANCE.getFlowCollAdInterval()) {
                                    NadConsoleLog.INSTANCE.collNextAd("不满足间隔要求，返回null");
                                    return null;
                                } else {
                                    NadConsoleLog.INSTANCE.collNextAd("返回竖屏缓存广告");
                                    Store $this$select$iv2 = getStore();
                                    if ($this$select$iv2 == null) {
                                        return null;
                                    }
                                    AbsState state2 = $this$select$iv2.getState();
                                    CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
                                    AdCollListState adCollListState3 = (AdCollListState) (commonState2 != null ? commonState2.select(AdCollListState.class) : null);
                                    if (adCollListState3 != null) {
                                        return adCollListState3.getAdPortraitCache();
                                    }
                                    return null;
                                }
                            }
                        }
                        return null;
                    case 2:
                        Store $this$select$iv3 = getStore();
                        if ($this$select$iv3 != null) {
                            AbsState state3 = $this$select$iv3.getState();
                            CommonState commonState3 = state3 instanceof CommonState ? (CommonState) state3 : null;
                            AdCollListState adCollListState4 = (AdCollListState) (commonState3 != null ? commonState3.select(AdCollListState.class) : null);
                            if (adCollListState4 != null) {
                                AdCollListState adCollListState5 = adCollListState4;
                                if (adCollListState5.getAdLandscapeCache() == null) {
                                    NadConsoleLog.INSTANCE.collNextAd("横屏广告缓存为空，返回null，发送异步306请求");
                                    tryRequest(isSwitchNext, collId2, nextNid);
                                    return null;
                                } else if ((getCollPlayHistory().indexOf(nextNid) - adCollListState5.getLastAdPos()) - 1 < AdReduxExpManager.INSTANCE.getFlowCollAdInterval()) {
                                    NadConsoleLog.INSTANCE.collNextAd("不满足间隔要求，返回null");
                                    return null;
                                } else {
                                    NadConsoleLog.INSTANCE.collNextAd("返回横屏缓存广告");
                                    Store $this$select$iv4 = getStore();
                                    if ($this$select$iv4 == null) {
                                        return null;
                                    }
                                    AbsState state4 = $this$select$iv4.getState();
                                    CommonState commonState4 = state4 instanceof CommonState ? (CommonState) state4 : null;
                                    AdCollListState adCollListState6 = (AdCollListState) (commonState4 != null ? commonState4.select(AdCollListState.class) : null);
                                    if (adCollListState6 != null) {
                                        return adCollListState6.getAdLandscapeCache();
                                    }
                                    return null;
                                }
                            }
                        }
                        return null;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }
        NadConsoleLog.INSTANCE.collNextAd("调用广告接口入参nid为空，返回null");
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addCollectionNextAd(com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r6) {
        /*
            r5 = this;
            com.baidu.searchbox.video.feedflow.ad.flow.AdRunTime r0 = r6.getRunTime()
            boolean r0 = r0.isRequestFromLandscape()
            r1 = 0
            if (r0 == 0) goto L_0x0033
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            if (r0 == 0) goto L_0x0028
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x001d
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            if (r3 == 0) goto L_0x0026
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState> r1 = com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x0026:
            com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState r1 = (com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState) r1
        L_0x0028:
            if (r1 != 0) goto L_0x002b
            goto L_0x005a
        L_0x002b:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r5.makeAdElement(r6)
            r1.setAdLandscapeCache(r0)
            goto L_0x005a
        L_0x0033:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            if (r0 == 0) goto L_0x0050
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0045
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0046
        L_0x0045:
            r3 = r1
        L_0x0046:
            if (r3 == 0) goto L_0x004e
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState> r1 = com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x004e:
            com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState r1 = (com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState) r1
        L_0x0050:
            if (r1 != 0) goto L_0x0053
            goto L_0x005a
        L_0x0053:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r5.makeAdElement(r6)
            r1.setAdPortraitCache(r0)
        L_0x005a:
            r5.preRenderAd(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.addCollectionNextAd(com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel):void");
    }

    private final void preRenderAd(AdItemModel ad) {
        BdVideoSeries vSeries = ad.getAdVideoSeries();
        if (vSeries != null && vSeries.isValid()) {
            PrebootEngine.Companion.getInstance().preboot(PrebootRuntimeKt.toPrebootInfo(vSeries, PrebootType.PREPARE, PolicyScene.LIST));
            ad.getRunTime().setPreBoot(true);
        }
    }

    private final void tryRequest(boolean isSwitchNext, String collId2, String nextNid) {
        if (this.isRequestProcessing) {
            NadConsoleLog.INSTANCE.collNextAd("有306请求正在处理中，驳回306请求");
        } else if (checkRequestCondition(isSwitchNext, nextNid)) {
            requestAd(getRequestParams(nextNid, collId2, getCollPlayHistory()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        r1 = (com.baidu.searchbox.video.detail.business.VideoBusiness) (r1 = r1.getState()).select(com.baidu.searchbox.video.detail.business.VideoBusiness.class);
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.flowvideo.ad.repos.AdListParam getRequestParams(java.lang.String r46, java.lang.String r47, java.util.List<java.lang.String> r48) {
        /*
            r45 = this;
            r0 = r45
            org.json.JSONObject r2 = r45.getDa()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r45.getStore()
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x0027
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x0027
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r1 = r1.select(r4)
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            if (r1 == 0) goto L_0x0027
            java.lang.String r1 = r1.pd
            if (r1 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r4 = r1
            goto L_0x0047
        L_0x0027:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r45.getStore()
            if (r1 == 0) goto L_0x0045
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x0045
            java.lang.Class<com.baidu.searchbox.video.detail.business.VideoBusiness> r4 = com.baidu.searchbox.video.detail.business.VideoBusiness.class
            java.lang.Object r1 = r1.select(r4)
            com.baidu.searchbox.video.detail.business.VideoBusiness r1 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r1
            if (r1 == 0) goto L_0x0045
            java.lang.String r1 = r1.pd()
            r4 = r1
            goto L_0x0047
        L_0x0045:
            r4 = r3
        L_0x0047:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r45.getStore()
            if (r1 == 0) goto L_0x0067
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x0067
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r1 = r1.select(r5)
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = r1.page
            if (r1 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r6 = r1
            goto L_0x0087
        L_0x0067:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r45.getStore()
            if (r1 == 0) goto L_0x0085
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x0085
            java.lang.Class<com.baidu.searchbox.video.detail.business.VideoBusiness> r5 = com.baidu.searchbox.video.detail.business.VideoBusiness.class
            java.lang.Object r1 = r1.select(r5)
            com.baidu.searchbox.video.detail.business.VideoBusiness r1 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r1
            if (r1 == 0) goto L_0x0085
            java.lang.String r1 = r1.page()
            r6 = r1
            goto L_0x0087
        L_0x0085:
            r6 = r3
        L_0x0087:
            r1 = 0
            com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils r3 = com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils.Impl.get()
            boolean r3 = r3.isScreenLand()
            r0.isRequestFromLandscape = r3
            java.lang.String r5 = "1"
            if (r3 == 0) goto L_0x0099
            r9 = r5
            goto L_0x009c
        L_0x0099:
            java.lang.String r3 = "0"
            r9 = r3
        L_0x009c:
            com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager r1 = com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager.INSTANCE
            int r1 = r1.getFlowCollAdPvControl()
            java.lang.String r11 = java.lang.String.valueOf(r1)
            org.json.JSONArray r1 = r45.getPvContext()
            java.lang.String r12 = r1.toString()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r45.getStore()
            r3 = 0
            if (r1 == 0) goto L_0x00dd
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r1.getState()
            boolean r10 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x00c2
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x00c3
        L_0x00c2:
            r8 = r3
        L_0x00c3:
            if (r8 == 0) goto L_0x00cc
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r8 = r8.select(r10)
            goto L_0x00cd
        L_0x00cc:
            r8 = r3
        L_0x00cd:
            com.baidu.searchbox.video.detail.core.model.IntentData r8 = (com.baidu.searchbox.video.detail.core.model.IntentData) r8
            if (r8 == 0) goto L_0x00dd
            org.json.JSONObject r1 = r8.extRequest
            if (r1 == 0) goto L_0x00dd
            java.lang.String r7 = "tab_id"
            java.lang.String r1 = r1.optString(r7, r5)
            goto L_0x00de
        L_0x00dd:
            r1 = r3
        L_0x00de:
            if (r1 != 0) goto L_0x00e2
            r14 = r5
            goto L_0x00e3
        L_0x00e2:
            r14 = r1
        L_0x00e3:
            com.baidu.searchbox.video.feedflow.ad.AdRedux r1 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r7 = r45.getStore()
            if (r7 == 0) goto L_0x00f2
            com.baidu.searchbox.feed.detail.frame.State r7 = r7.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            goto L_0x00f3
        L_0x00f2:
            r7 = r3
        L_0x00f3:
            java.lang.String r21 = r1.getFlowTabId(r7)
            com.baidu.searchbox.video.feedflow.ad.AdRedux r1 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r7 = r45.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r1 = r1.getListState((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r7)
            int r1 = r1.getAdSession()
            java.lang.String r22 = java.lang.String.valueOf(r1)
            com.baidu.searchbox.video.feedflow.ad.AdRedux r1 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r7 = r45.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r1 = r1.getListState((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r7)
            int r1 = r1.getPageCount()
            java.lang.String r23 = java.lang.String.valueOf(r1)
            com.baidu.searchbox.video.feedflow.ad.AdRedux r1 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r7 = r45.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r1 = r1.getListState((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r7)
            int r1 = r1.getSessionRefresh()
            java.lang.String r24 = java.lang.String.valueOf(r1)
            com.baidu.searchbox.video.feedflow.ad.AdRedux r1 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r7 = r45.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r1 = r1.getListState((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r7)
            long r7 = r1.getLastPageTimestamp()
            java.lang.String r25 = java.lang.String.valueOf(r7)
            com.baidu.searchbox.feed.detail.frame.Store r1 = r45.getStore()
            if (r1 == 0) goto L_0x016a
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r1.getState()
            boolean r10 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0151
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x0152
        L_0x0151:
            r8 = r3
        L_0x0152:
            if (r8 == 0) goto L_0x015b
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r8 = r8.select(r10)
            goto L_0x015c
        L_0x015b:
            r8 = r3
        L_0x015c:
            com.baidu.searchbox.video.detail.core.model.IntentData r8 = (com.baidu.searchbox.video.detail.core.model.IntentData) r8
            if (r8 == 0) goto L_0x016a
            java.lang.String r1 = r8.getResourceType()
            if (r1 != 0) goto L_0x0167
            goto L_0x016a
        L_0x0167:
            r26 = r1
            goto L_0x016c
        L_0x016a:
            r26 = r5
        L_0x016c:
            int r1 = com.baidu.searchbox.feed.util.RefreshCountUtils.getRefreshCount(r5)
            java.lang.String r29 = java.lang.String.valueOf(r1)
            com.baidu.searchbox.video.feedflow.ad.util.NadColl r1 = com.baidu.searchbox.video.feedflow.ad.util.NadColl.INSTANCE
            int r1 = r1.getCollConsumeFlag()
            java.lang.String r30 = java.lang.String.valueOf(r1)
            int r1 = r0.adSessionRefresh
            int r5 = r1 + 1
            r0.adSessionRefresh = r5
            java.lang.String r38 = java.lang.String.valueOf(r1)
            org.json.JSONObject r43 = r45.getParamStr()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r45.getStore()
            if (r1 == 0) goto L_0x01b5
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r1.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x019e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x019f
        L_0x019e:
            r7 = r3
        L_0x019f:
            if (r7 == 0) goto L_0x01a8
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState> r8 = com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x01a9
        L_0x01a8:
            r7 = r3
        L_0x01a9:
            com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState r7 = (com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState) r7
            if (r7 == 0) goto L_0x01b5
            int r1 = r7.getFirstAdPos()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
        L_0x01b5:
            java.lang.String r31 = java.lang.String.valueOf(r3)
            java.lang.String r32 = r45.getDspReqInterval()
            r5 = r46
            r3 = r48
            int r1 = r3.indexOf(r5)
            java.lang.String r33 = java.lang.String.valueOf(r1)
            java.lang.String r34 = r45.getLastAd()
            com.baidu.searchbox.video.feedflow.ad.AdRedux r1 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r7 = r45.getStore()
            com.baidu.searchbox.ad.position.list.AdListState r1 = r1.getListState((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r7)
            int r1 = r1.getGlobalSession()
            java.lang.String r36 = java.lang.String.valueOf(r1)
            com.baidu.searchbox.flowvideo.ad.repos.AdListParam r44 = new com.baidu.searchbox.flowvideo.ad.repos.AdListParam
            r1 = r44
            r7 = 0
            r8 = 0
            java.lang.String r10 = "toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r10)
            r10 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r27 = 0
            r28 = 0
            r37 = 0
            r40 = 101181792(0x607e960, float:2.5562135E-35)
            r41 = 8
            r42 = 0
            java.lang.String r35 = "1"
            java.lang.String r39 = "1"
            r3 = r4
            r4 = r9
            r5 = r11
            r9 = r12
            r11 = r14
            r12 = r21
            r14 = r22
            r21 = r23
            r22 = r43
            r23 = r24
            r24 = r25
            r25 = r26
            r26 = r29
            r29 = r30
            r30 = r38
            r38 = r47
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return r44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.getRequestParams(java.lang.String, java.lang.String, java.util.List):com.baidu.searchbox.flowvideo.ad.repos.AdListParam");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getLastAd() {
        /*
            r10 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = r0
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.Store r3 = r10.getStore()
            r4 = 0
            if (r3 == 0) goto L_0x0025
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x001a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x001b
        L_0x001a:
            r6 = r4
        L_0x001b:
            if (r6 == 0) goto L_0x0023
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState> r4 = com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState.class
            java.lang.Object r4 = r6.select(r4)
        L_0x0023:
            com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState r4 = (com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState) r4
        L_0x0025:
            r3 = r4
            java.lang.String r4 = ""
            java.lang.String r5 = "context_ext"
            java.lang.String r6 = "eshow_ts"
            java.lang.String r7 = "pos"
            if (r3 == 0) goto L_0x005f
            int r8 = r3.getLastAdPos()
            r9 = -1
            if (r8 == r9) goto L_0x005f
            int r8 = r3.getLastAdPos()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            com.baidu.searchbox.ad.util.JsonHelperKt.safelyPut((org.json.JSONObject) r1, (java.lang.String) r7, (java.lang.Object) r8)
            long r7 = r3.getLastAdEShowTs()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            com.baidu.searchbox.ad.util.JsonHelperKt.safelyPut((org.json.JSONObject) r1, (java.lang.String) r6, (java.lang.Object) r7)
            com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r6 = r3.getLastAd()
            if (r6 == 0) goto L_0x005b
            java.lang.String r6 = r6.getContextExt()
            if (r6 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r4 = r6
        L_0x005b:
            com.baidu.searchbox.ad.util.JsonHelperKt.safelyPut((org.json.JSONObject) r1, (java.lang.String) r5, (java.lang.Object) r4)
            goto L_0x006a
        L_0x005f:
            java.lang.String r8 = "-1"
            com.baidu.searchbox.ad.util.JsonHelperKt.safelyPut((org.json.JSONObject) r1, (java.lang.String) r7, (java.lang.Object) r8)
            com.baidu.searchbox.ad.util.JsonHelperKt.safelyPut((org.json.JSONObject) r1, (java.lang.String) r6, (java.lang.Object) r8)
            com.baidu.searchbox.ad.util.JsonHelperKt.safelyPut((org.json.JSONObject) r1, (java.lang.String) r5, (java.lang.Object) r4)
        L_0x006a:
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "JSONObject().apply {\n   …   }\n        }.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.getLastAd():java.lang.String");
    }

    private final String getDspReqInterval() {
        String str;
        AbsState state;
        AdPolicyState adPolicyState;
        Store<AbsState> store = getStore();
        if (store == null || (state = store.getState()) == null || (adPolicyState = (AdPolicyState) state.select(AdPolicyState.class)) == null || (str = adPolicyState.getPlaceIdPortrait()) == null) {
            str = "";
        }
        return String.valueOf(ADConfigUtil.getPlaceOrGlobalConfInt(str, "ad_control_dsp_req_interval", 4));
    }

    private final void requestAd(AdListParam param) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new AdCollectionNextPlugin$requestAd$1(this, param, (Continuation<? super AdCollectionNextPlugin$requestAd$1>) null), 2, (Object) null);
    }

    private final void expandUserBehaviorToPvContext(JSONObject json, VideoPlayInfo info) {
        if (info.getHasFinished()) {
            json.put("finished", "1");
        }
        if (info.getShow()) {
            json.put("show", "1");
            Long showTs = info.getShowTs();
            if (showTs != null) {
                json.put("show_ts", String.valueOf(showTs.longValue()));
            }
        }
        if (info.getLike() != 0) {
            json.put(AdListParamKt.AD_PARAMS_CONTEXT_LIKED, "1");
            Long likeTs = info.getLikeTs();
            if (likeTs != null) {
                json.put(AdListParamKt.AD_PARAMS_CONTEXT_LIKED_TS, String.valueOf(likeTs.longValue()));
            }
        }
        if (info.getCollect() != 0) {
            json.put("collect", "1");
            Long collectTs = info.getCollectTs();
            if (collectTs != null) {
                json.put(AdListParamKt.AD_PARAMS_CONTEXT_COLLECT_TS, String.valueOf(collectTs.longValue()));
            }
        }
        if (info.getFollow() != 0) {
            json.put("follow", "1");
            Long followTs = info.getFollowTs();
            if (followTs != null) {
                json.put(AdListParamKt.AD_PARAMS_CONTEXT_FOLLOW_TS, String.valueOf(followTs.longValue()));
            }
        }
        if (info.getShare() != 0) {
            json.put("share", "1");
            Long shareTs = info.getShareTs();
            if (shareTs != null) {
                json.put(AdListParamKt.AD_PARAMS_CONTEXT_SHARE_TS, String.valueOf(shareTs.longValue()));
            }
        }
        if (info.getComment() != 0) {
            json.put("comment", "1");
            Long commentTs = info.getCommentTs();
            if (commentTs != null) {
                json.put(AdListParamKt.AD_PARAMS_CONTEXT_COMMENT_TS, String.valueOf(commentTs.longValue()));
            }
        }
        if (info.getEnterUserPage() != 0) {
            json.put(AdListParamKt.AD_PARAMS_CONTEXT_ENTER_USER_PAGE, "1");
            Long enterUserPageTs = info.getEnterUserPageTs();
            if (enterUserPageTs != null) {
                json.put(AdListParamKt.AD_PARAMS_CONTEXT_ENTER_USER_PAGE_TS, String.valueOf(enterUserPageTs.longValue()));
            }
        }
    }

    private final JSONObject getParamStr() {
        try {
            String firstVideoNid = (String) CollectionUtils.get(getCollPlayHistory(), 0);
            JSONObject extStr = new JSONObject();
            extStr.put("vid", firstVideoNid == null ? "" : firstVideoNid);
            JSONObject $this$getParamStr_u24lambda_u2d19 = new JSONObject();
            $this$getParamStr_u24lambda_u2d19.put(AdListParamKt.AD_PARAMS_PARAMEXT_EXT, extStr.toString());
            return $this$getParamStr_u24lambda_u2d19;
        } catch (JSONException e2) {
            return new JSONObject();
        }
    }

    private final JSONArray getPvContext() {
        AdListState listState;
        try {
            AdRedux adRedux = AdRedux.INSTANCE;
            Store<AbsState> store = getStore();
            if (adRedux.isPortrait(store != null ? store.getState() : null)) {
                listState = AdRedux.INSTANCE.getListState(getStore());
            } else {
                listState = AdRedux.INSTANCE.getListStateLandscape(getStore());
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray $this$getPvContext_u24lambda_u2d22 = jSONArray;
            int lastIndex = CollectionsKt.getLastIndex(getCollPlayHistory());
            for (int idx = RangesKt.coerceAtLeast(getCollPlayHistory().size() - ADConfigManager.instance().getGlobalConfInt("flow_ad_context_window_ahead", 10), 0); idx < lastIndex; idx++) {
                String nid = (String) CollectionsKt.getOrNull(getCollPlayHistory(), idx);
                if (nid != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21 = jSONObject;
                    VideoPlayInfo it = listState.getVideoPlayInfoMap().get(nid);
                    if (it != null) {
                        $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("nid", nid);
                        $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("duration", it.getDuration());
                        if (getCollPlayHistory().indexOf(nid) < getCollPlayHistory().size() - 1) {
                            $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("progress", it.getProgressTime());
                            $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("replay", it.getReplayCount());
                        }
                        $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("pos", getCollPlayHistory().indexOf(nid) + 1);
                        $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("width", it.getWidth());
                        $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("height", it.getHeight());
                        $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("resource_type", it.getResourceType());
                        $this$getPvContext_u24lambda_u2d22_u24lambda_u2d21.put("layout", it.getLayout());
                        expandUserBehaviorToPvContext($this$getPvContext_u24lambda_u2d22_u24lambda_u2d21, it);
                    }
                    $this$getPvContext_u24lambda_u2d22.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (JSONException e2) {
            return new JSONArray();
        }
    }

    /* access modifiers changed from: private */
    public final AdItemModel filterValidAd(AdItemModel ad) {
        AdListState listState;
        AdRedux adRedux = AdRedux.INSTANCE;
        Store<AbsState> store = getStore();
        if (adRedux.isPortrait(store != null ? store.getState() : null)) {
            listState = AdRedux.INSTANCE.getListState(getStore());
        } else {
            listState = AdRedux.INSTANCE.getListStateLandscape(getStore());
        }
        HashSet nidSetOfSession = listState.getNidSet();
        FixedCapacityFifoQueue recentNidQueueOfSession = listState.getRecentNidQueue();
        if (Intrinsics.areEqual((Object) ad.getAdType(), (Object) "3")) {
            return null;
        }
        int validationCode = checkAdValid(ad);
        if (validationCode != 0) {
            Store<AbsState> store2 = getStore();
            if (store2 != null) {
                StoreExtKt.post(store2, new MaterialError(ad, String.valueOf(validationCode)));
            }
            return null;
        } else if (!DupStrategy.INSTANCE.judgeDupOnResponse(ad, nidSetOfSession, recentNidQueueOfSession)) {
            return ad;
        } else {
            Store<AbsState> store3 = getStore();
            if (store3 != null) {
                StoreExtKt.post(store3, new DuplicateAdRemoved(ad));
            }
            return null;
        }
    }

    private final int checkAdValid(AdItemModel ad) {
        AdRedux adRedux = AdRedux.INSTANCE;
        Store<AbsState> store = getStore();
        if (adRedux.isLandscape(store != null ? store.getState() : null)) {
            if (StringsKt.toIntOrNull(ad.getVideoWidth()) == null || StringsKt.toIntOrNull(ad.getVideoHeight()) == null || Integer.parseInt(ad.getVideoHeight()) > Integer.parseInt(ad.getVideoWidth())) {
                return 24;
            }
            if (ad.getNormandy() == null && StringsKt.isBlank(ad.getBanner()) && !Intrinsics.areEqual((Object) ad.getEtrade(), (Object) "4")) {
                return 76;
            }
        }
        if (!ItemTypeManifestKt.isAdsItem(ad.getLayout()) || !Intrinsics.areEqual((Object) "1", (Object) ad.getStatus())) {
            return 24;
        }
        if (ItemTypeManifestKt.isAdVideoItem(ad.getLayout()) && !checkAdVideoInfoValid(ad)) {
            return 4;
        }
        if (ItemTypeManifestKt.isAdDynamicItem(ad.getLayout()) && !checkAdDynamicValid(ad)) {
            return 3;
        }
        if (!checkAdAppInfoValid(ad)) {
            return SwanAppMessengerService.ServerToClient.MSG_FAVORITE_RESULT;
        }
        return 0;
    }

    private final boolean checkAdVideoInfoValid(AdItemModel adItemData) {
        AdItemModel $this$checkAdVideoInfoValid_u24lambda_u2d23 = adItemData;
        return (StringsKt.isBlank($this$checkAdVideoInfoValid_u24lambda_u2d23.getVideoHeight()) ^ true) && (StringsKt.isBlank($this$checkAdVideoInfoValid_u24lambda_u2d23.getVideoWidth()) ^ true) && (StringsKt.isBlank($this$checkAdVideoInfoValid_u24lambda_u2d23.getVideoInfo()) ^ true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean checkAdDynamicValid(com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r14) {
        /*
            r13 = this;
            r0 = r14
            r1 = 0
            com.baidu.searchbox.video.feedflow.ad.dynamic.NadDynamicModel r2 = r0.getAdDynamic()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0025
            com.baidu.searchbox.video.feedflow.ad.dynamic.BackMusic r2 = r2.getBackMusic()
            if (r2 == 0) goto L_0x0025
            java.lang.String r2 = r2.getUrl()
            if (r2 == 0) goto L_0x0025
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0020
            r2 = r3
            goto L_0x0021
        L_0x0020:
            r2 = r4
        L_0x0021:
            if (r2 != r3) goto L_0x0025
            r2 = r3
            goto L_0x0026
        L_0x0025:
            r2 = r4
        L_0x0026:
            r5 = 0
            r5 = 1
            com.baidu.searchbox.video.feedflow.ad.dynamic.NadDynamicModel r6 = r0.getAdDynamic()
            if (r6 == 0) goto L_0x0063
            java.util.List r6 = r6.getCarousels()
            if (r6 == 0) goto L_0x0063
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 0
            java.util.Iterator r8 = r6.iterator()
        L_0x003b:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0062
            java.lang.Object r9 = r8.next()
            r10 = r9
            com.baidu.searchbox.video.feedflow.ad.dynamic.CarouselPicModel r10 = (com.baidu.searchbox.video.feedflow.ad.dynamic.CarouselPicModel) r10
            r11 = 0
            java.lang.String r12 = r10.getImageUrl()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            int r12 = r12.length()
            if (r12 <= 0) goto L_0x0057
            r12 = r3
            goto L_0x0058
        L_0x0057:
            r12 = r4
        L_0x0058:
            if (r12 == 0) goto L_0x005e
            if (r5 == 0) goto L_0x005e
            r12 = r3
            goto L_0x005f
        L_0x005e:
            r12 = r4
        L_0x005f:
            r5 = r12
            goto L_0x003b
        L_0x0062:
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            if (r5 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r3 = r4
        L_0x0069:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.checkAdDynamicValid(com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel):boolean");
    }

    private final boolean checkAdAppInfoValid(AdItemModel adItemData) {
        AppInfoModel it;
        FeedAdOperate operate = adItemData.getOperate();
        if (operate == null || (it = operate.appInfo) == null) {
            return true;
        }
        return AdUtil.isAppDataValid(it);
    }

    private final ItemModel<?> makeAdElement(AdItemModel ad) {
        return new ItemModel(ad.getId(), ad.getNid(), ad.getLayout(), ad, (StrategyVideoModel) null, (CommonItemData) null, 48, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean checkRequestCondition(boolean r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x000c
            com.baidu.searchbox.ad.util.NadConsoleLog r1 = com.baidu.searchbox.ad.util.NadConsoleLog.INSTANCE
            java.lang.String r2 = "非点击下一集，驳回306请求"
            r1.collNextAd(r2)
            return r0
        L_0x000c:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r7.getStore()
            r2 = 1
            if (r1 == 0) goto L_0x0036
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0020
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0021
        L_0x0020:
            r4 = r6
        L_0x0021:
            if (r4 == 0) goto L_0x0029
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState> r5 = com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x0029:
            com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState r6 = (com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState) r6
            if (r6 == 0) goto L_0x0036
            int r1 = r6.getLastAdPos()
            r3 = -1
            if (r1 != r3) goto L_0x0036
            r1 = r2
            goto L_0x0037
        L_0x0036:
            r1 = r0
        L_0x0037:
            if (r1 == 0) goto L_0x0057
            java.util.List r1 = r7.getCollPlayHistory()
            int r1 = r1.indexOf(r9)
            com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager r3 = com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager.INSTANCE
            int r3 = r3.getFlowCollAdPvControl()
            if (r1 < r3) goto L_0x004a
            r0 = r2
        L_0x004a:
            r2 = r0
            if (r2 != 0) goto L_0x0055
            com.baidu.searchbox.ad.util.NadConsoleLog r0 = com.baidu.searchbox.ad.util.NadConsoleLog.INSTANCE
            java.lang.String r1 = "不满足首次pv楼层，驳回306请求"
            r0.collNextAd(r1)
        L_0x0055:
            goto L_0x0058
        L_0x0057:
        L_0x0058:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollectionNextPlugin.checkRequestCondition(boolean, java.lang.String):boolean");
    }

    private final JSONObject getDa() {
        String str;
        JSONObject extJson;
        AbsState state;
        IntentData intentData;
        String it;
        JSONObject buildCommonParams = IAdDeviceInfo.Impl.get().buildCommonParams();
        Long l = null;
        if (buildCommonParams == null) {
            return null;
        }
        JSONObject $this$getDa_u24lambda_u2d28 = buildCommonParams;
        AdRedux adRedux = AdRedux.INSTANCE;
        Store<AbsState> store = getStore();
        boolean z = true;
        if (adRedux.isPaidInvoke(store != null ? store.getState() : null)) {
            JSONUtils.put($this$getDa_u24lambda_u2d28, "is_external_invoke", 1);
        } else {
            JSONUtils.put($this$getDa_u24lambda_u2d28, "is_external_invoke", 0);
        }
        Store<AbsState> store2 = getStore();
        if (store2 == null || (state = store2.getState()) == null || (intentData = (IntentData) state.select(IntentData.class)) == null || (it = intentData.extendBusiness) == null) {
            str = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(it, "extendBusiness");
            try {
                str = new JSONObject(it).optString("adRequestExt", "");
            } catch (JSONException e2) {
                String str2 = null;
                str = null;
            }
        }
        String requestExt = str;
        String ext = $this$getDa_u24lambda_u2d28.optString("ext", "");
        CharSequence charSequence = ext;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            extJson = new JSONObject();
        } else {
            extJson = JSONUtils.newJSONObject(ext);
            Intrinsics.checkNotNullExpressionValue(extJson, "newJSONObject(ext)");
        }
        CharSequence charSequence2 = requestExt;
        if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
            z = false;
        }
        if (!z) {
            JSONUtils.put(extJson, "request_ext", requestExt);
        }
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state2 = $this$select$iv.getState();
            CommonState commonState = state2 instanceof CommonState ? (CommonState) state2 : null;
            AdCollListState adCollListState = (AdCollListState) (commonState != null ? commonState.select(AdCollListState.class) : null);
            if (adCollListState != null) {
                l = Long.valueOf(adCollListState.getSessionStartTime());
            }
        }
        JSONUtils.put(extJson, "session_start_time", String.valueOf(l));
        if (AdReduxExpManager.INSTANCE.getIntervalCollAdaptSwitch() && IntervalCollAdaptGlobal.INSTANCE.getCount() > 0 && AdReduxExpManager.INSTANCE.getFlowCollAdIntervalCollAdaptSwitch()) {
            JSONUtils.put(extJson, "interval_coll_adapt", IntervalCollAdaptGlobal.INSTANCE.getCount());
        }
        JSONUtils.put($this$getDa_u24lambda_u2d28, "ext", extJson.toString());
        return buildCommonParams;
    }
}
