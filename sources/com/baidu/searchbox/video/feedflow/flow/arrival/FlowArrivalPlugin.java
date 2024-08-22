package com.baidu.searchbox.video.feedflow.flow.arrival;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.core.exception.IntentDataException;
import com.baidu.searchbox.video.feedflow.common.IDetailItemCoreEventService;
import com.baidu.searchbox.video.feedflow.flow.arrival.service.FlowArrivalService;
import com.baidu.searchbox.video.feedflow.flow.arrival.service.IFlowArrivalService;
import com.baidu.searchbox.video.feedflow.flow.exc.ExcStatusManager;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.tab.ITabComponentService;
import com.baidu.searchbox.video.feedflow.tab.TabItemCreatorServiceKt;
import com.baidu.swan.apps.impl.inlinewidget.video.widget.SwanInlineBaseVideoWidget;
import com.baidu.swan.apps.page.SwanAppPageInfoHelper;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0002JD\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0014J\b\u0010\u001d\u001a\u00020\u0010H\u0014J\n\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010 \u001a\u00020\u0010H\u0016J\u0016\u0010!\u001a\u00020\"2\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0006\u0010$\u001a\u00020\u0010J\b\u0010%\u001a\u00020\u0010H\u0016J\u0014\u0010&\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016J\u0010\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\nJ\b\u0010)\u001a\u00020\u0010H\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J \u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\nJ\b\u0010.\u001a\u00020\u0010H\u0016J\b\u0010/\u001a\u00020\u0010H\u0016J\b\u00100\u001a\u00020\u0010H\u0014J\u0006\u00101\u001a\u00020\u0010J\u0014\u00102\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016J0\u00103\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u00104\u001a\u00020\u0006H\u0014J\b\u00105\u001a\u00020\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u00066"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/arrival/FlowArrivalPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "enterTime", "", "index", "", "relativeIntentVideoPosition", "sequence", "uniqueKey", "", "getUniqueKey", "()Ljava/lang/String;", "uniqueKey$delegate", "Lkotlin/Lazy;", "addExtPageInfo", "", "pageInfo", "Lorg/json/JSONObject;", "buildFlowItemArrivalModel", "Lcom/baidu/searchbox/video/feedflow/flow/arrival/FlowItemArrivalModel;", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "buildSpecialFlowItemArrivalModel", "nid", "layout", "tabId", "position", "statusType", "createFirstPart", "getCurrentTabId", "getFirstFlowItemArrivalModel", "injectService", "isOnReUsePlayerType", "", "isPageArrivalByDefault", "isPlayFromLocal", "onAttachToManager", "onCallPlayer", "onCarlton", "info", "onCreate", "onDestroy", "onError", "what", "extra", "onPause", "onResume", "pageSelected", "picLoadSuccess", "playSuccess", "updateArrivalStatusAndBehave", "behaveType", "uploadArrivalStatistic", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowArrivalPlugin.kt */
public class FlowArrivalPlugin extends LiveDataPlugin {
    private long enterTime;
    private int index;
    private int relativeIntentVideoPosition;
    private int sequence;
    private final Lazy uniqueKey$delegate = BdPlayerUtils.lazyNone(FlowArrivalPlugin$uniqueKey$2.INSTANCE);

    private final String getUniqueKey() {
        return (String) this.uniqueKey$delegate.getValue();
    }

    public void onCreate() {
        super.onCreate();
        IDetailItemCoreEventService iDetailItemCoreEventService = (IDetailItemCoreEventService) getManager().getService(IDetailItemCoreEventService.class);
        if (iDetailItemCoreEventService != null) {
            iDetailItemCoreEventService.addItemSelectedListener(new FlowArrivalPlugin$onCreate$1(this));
        }
        IDetailItemCoreEventService iDetailItemCoreEventService2 = (IDetailItemCoreEventService) getManager().getService(IDetailItemCoreEventService.class);
        if (iDetailItemCoreEventService2 != null) {
            iDetailItemCoreEventService2.addItemDetachFromScreenListener(new FlowArrivalPlugin$onCreate$2(this));
        }
    }

    public void onAttachToManager() {
        FlowArrivalState $this$onAttachToManager_u24lambda_u2d7;
        FlowArrivalState $this$onAttachToManager_u24lambda_u2d1;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d1 = (FlowArrivalState) $this$subscribe$iv.subscribe(FlowArrivalState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d1.getTabSelectedAction().observe(this, new FlowArrivalPlugin$$ExternalSyntheticLambda0(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && ($this$onAttachToManager_u24lambda_u2d7 = (FlowArrivalState) $this$subscribe$iv2.subscribe(FlowArrivalState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d7.getData().observe(this, new FlowArrivalPlugin$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d7.getStartPlayError().observe(this, new FlowArrivalPlugin$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d7.getVideoOffLine().observe(this, new FlowArrivalPlugin$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d7.isPageCovered().observe(this, new FlowArrivalPlugin$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015f  */
    /* renamed from: onAttachToManager$lambda-1$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5977onAttachToManager$lambda1$lambda0(com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin r12, com.baidu.searchbox.video.feedflow.tab.TabInfoModel r13) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0033
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0019
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x001a
        L_0x0019:
            r3 = r1
        L_0x001a:
            if (r3 == 0) goto L_0x0023
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r4 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0024
        L_0x0023:
            r3 = r1
        L_0x0024:
            com.baidu.searchbox.video.feedflow.tab.TabState r3 = (com.baidu.searchbox.video.feedflow.tab.TabState) r3
            if (r3 == 0) goto L_0x0033
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r3.getPreTabInfo()
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getPageType()
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isLeaveTalosTab(r0)
            if (r0 == 0) goto L_0x0048
            r4 = 0
            r5 = 0
            r6 = 4002(0xfa2, float:5.608E-42)
            r7 = 6
            r8 = 0
            java.lang.String r3 = "layout_tab_talos"
            r2 = r12
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00c7
        L_0x0048:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x0074
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x005a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x005b
        L_0x005a:
            r3 = r1
        L_0x005b:
            if (r3 == 0) goto L_0x0064
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r4 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0065
        L_0x0064:
            r3 = r1
        L_0x0065:
            com.baidu.searchbox.video.feedflow.tab.TabState r3 = (com.baidu.searchbox.video.feedflow.tab.TabState) r3
            if (r3 == 0) goto L_0x0074
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r3.getPreTabInfo()
            if (r0 == 0) goto L_0x0074
            java.lang.String r0 = r0.getId()
            goto L_0x0075
        L_0x0074:
            r0 = r1
        L_0x0075:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isLeaveLiveTab(r0)
            if (r0 == 0) goto L_0x0088
            r4 = 0
            r5 = 0
            r6 = 4002(0xfa2, float:5.608E-42)
            r7 = 6
            r8 = 0
            java.lang.String r3 = "layout_tab_live"
            r2 = r12
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00c7
        L_0x0088:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x00b4
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x009a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x009b
        L_0x009a:
            r3 = r1
        L_0x009b:
            if (r3 == 0) goto L_0x00a4
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r4 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x00a5
        L_0x00a4:
            r3 = r1
        L_0x00a5:
            com.baidu.searchbox.video.feedflow.tab.TabState r3 = (com.baidu.searchbox.video.feedflow.tab.TabState) r3
            if (r3 == 0) goto L_0x00b4
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r3.getPreTabInfo()
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = r0.getPageType()
            goto L_0x00b5
        L_0x00b4:
            r0 = r1
        L_0x00b5:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isLeaveH5Tab(r0)
            if (r0 == 0) goto L_0x00c7
            r4 = 0
            r5 = 0
            r6 = 4002(0xfa2, float:5.608E-42)
            r7 = 6
            r8 = 0
            java.lang.String r3 = "layout_tab_h5"
            r2 = r12
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
        L_0x00c7:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x00f3
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x00d9
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x00da
        L_0x00d9:
            r3 = r1
        L_0x00da:
            if (r3 == 0) goto L_0x00e3
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r4 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x00e4
        L_0x00e3:
            r3 = r1
        L_0x00e4:
            com.baidu.searchbox.video.feedflow.tab.TabState r3 = (com.baidu.searchbox.video.feedflow.tab.TabState) r3
            if (r3 == 0) goto L_0x00f3
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r3.getCurrentTabInfo()
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = r0.getPageType()
            goto L_0x00f4
        L_0x00f3:
            r0 = r1
        L_0x00f4:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isSelectedTalosTab(r0)
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x015f
            int r4 = r12.index
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x0126
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0110
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0111
        L_0x0110:
            r5 = r1
        L_0x0111:
            if (r5 == 0) goto L_0x0119
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r5.select(r1)
        L_0x0119:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x0126
            java.lang.String r0 = r1.getCurrentTabId()
            if (r0 != 0) goto L_0x0124
            goto L_0x0126
        L_0x0124:
            r7 = r0
            goto L_0x0127
        L_0x0126:
            r7 = r2
        L_0x0127:
            r8 = 0
            r9 = 0
            r10 = 48
            r11 = 0
            java.lang.String r5 = "layout_tab_talos"
            java.lang.String r6 = "layout_tab_talos"
            r3 = r12
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r0 = buildSpecialFlowItemArrivalModel$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.addItemArrivalModel(r0)
            int r1 = r12.index
            int r1 = r1 + 1
            r12.index = r1
            java.lang.String r1 = "layout_tab_talos"
            boolean r1 = r12.isPageArrivalByDefault(r1)
            if (r1 == 0) goto L_0x0289
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 10
            r8 = 0
            java.lang.String r3 = "layout_tab_talos"
            r2 = r12
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0289
        L_0x015f:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x018b
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0171
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0172
        L_0x0171:
            r4 = r1
        L_0x0172:
            if (r4 == 0) goto L_0x017b
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r5 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x017c
        L_0x017b:
            r4 = r1
        L_0x017c:
            com.baidu.searchbox.video.feedflow.tab.TabState r4 = (com.baidu.searchbox.video.feedflow.tab.TabState) r4
            if (r4 == 0) goto L_0x018b
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r4.getCurrentTabInfo()
            if (r0 == 0) goto L_0x018b
            java.lang.String r0 = r0.getId()
            goto L_0x018c
        L_0x018b:
            r0 = r1
        L_0x018c:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isSelectedLiveTab(r0)
            if (r0 == 0) goto L_0x01f5
            int r4 = r12.index
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x01bc
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x01a6
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x01a7
        L_0x01a6:
            r5 = r1
        L_0x01a7:
            if (r5 == 0) goto L_0x01af
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r5.select(r1)
        L_0x01af:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x01bc
            java.lang.String r0 = r1.getCurrentTabId()
            if (r0 != 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r7 = r0
            goto L_0x01bd
        L_0x01bc:
            r7 = r2
        L_0x01bd:
            r8 = 0
            r9 = 0
            r10 = 48
            r11 = 0
            java.lang.String r5 = "layout_tab_live"
            java.lang.String r6 = "layout_tab_live"
            r3 = r12
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r0 = buildSpecialFlowItemArrivalModel$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.addItemArrivalModel(r0)
            int r1 = r12.index
            int r1 = r1 + 1
            r12.index = r1
            java.lang.String r1 = "layout_tab_live"
            boolean r1 = r12.isPageArrivalByDefault(r1)
            if (r1 == 0) goto L_0x0289
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 10
            r8 = 0
            java.lang.String r3 = "layout_tab_live"
            r2 = r12
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0289
        L_0x01f5:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x0221
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0207
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0208
        L_0x0207:
            r4 = r1
        L_0x0208:
            if (r4 == 0) goto L_0x0211
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r5 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0212
        L_0x0211:
            r4 = r1
        L_0x0212:
            com.baidu.searchbox.video.feedflow.tab.TabState r4 = (com.baidu.searchbox.video.feedflow.tab.TabState) r4
            if (r4 == 0) goto L_0x0221
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r4.getCurrentTabInfo()
            if (r0 == 0) goto L_0x0221
            java.lang.String r0 = r0.getPageType()
            goto L_0x0222
        L_0x0221:
            r0 = r1
        L_0x0222:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isSelectedH5Tab(r0)
            if (r0 == 0) goto L_0x0289
            int r4 = r12.index
            com.baidu.searchbox.feed.detail.frame.Store r0 = r12.getStore()
            if (r0 == 0) goto L_0x0252
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x023c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x023d
        L_0x023c:
            r5 = r1
        L_0x023d:
            if (r5 == 0) goto L_0x0245
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r5.select(r1)
        L_0x0245:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x0252
            java.lang.String r0 = r1.getCurrentTabId()
            if (r0 != 0) goto L_0x0250
            goto L_0x0252
        L_0x0250:
            r7 = r0
            goto L_0x0253
        L_0x0252:
            r7 = r2
        L_0x0253:
            r8 = 0
            r9 = 0
            r10 = 48
            r11 = 0
            java.lang.String r5 = "layout_tab_h5"
            java.lang.String r6 = "layout_tab_h5"
            r3 = r12
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r0 = buildSpecialFlowItemArrivalModel$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.addItemArrivalModel(r0)
            int r1 = r12.index
            int r1 = r1 + 1
            r12.index = r1
            java.lang.String r1 = "layout_tab_h5"
            boolean r1 = r12.isPageArrivalByDefault(r1)
            if (r1 == 0) goto L_0x0289
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 10
            r8 = 0
            java.lang.String r3 = "layout_tab_h5"
            r2 = r12
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
        L_0x0289:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.m5977onAttachToManager$lambda1$lambda0(com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin, com.baidu.searchbox.video.feedflow.tab.TabInfoModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-3  reason: not valid java name */
    public static final void m5978onAttachToManager$lambda7$lambda3(FlowArrivalPlugin this$0, FlowIntentDataExcModel model) {
        Throwable exc;
        int exceptionType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (model != null && (exc = model.getExc()) != null && (exc instanceof IntentDataException)) {
            switch (((IntentDataException) exc).mExceptionType) {
                case 1001:
                    exceptionType = 3004;
                    break;
                case 1011:
                    exceptionType = 3001;
                    break;
                case 1031:
                    exceptionType = 3002;
                    break;
                case 1041:
                    exceptionType = 3003;
                    break;
                default:
                    exceptionType = -1;
                    break;
            }
            if (exceptionType > 0) {
                this$0.enterTime = System.currentTimeMillis();
                FlowArrivalStatusCollector.Companion.getInstance().addItemArrivalModel(buildSpecialFlowItemArrivalModel$default(this$0, 0, (String) null, (String) null, (String) null, 0, exceptionType, 31, (Object) null));
                this$0.uploadArrivalStatistic();
                this$0.sequence++;
                FlowArrivalStatusCollector.Companion.getInstance().clear();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-4  reason: not valid java name */
    public static final void m5979onAttachToManager$lambda7$lambda4(FlowArrivalPlugin this$0, Unit it) {
        String str;
        ItemModel<?> curItemModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IFlowComponentService iFlowComponentService = (IFlowComponentService) this$0.getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService == null || (curItemModel = iFlowComponentService.getCurItemModel()) == null || (str = curItemModel.getNid()) == null) {
            str = "";
        }
        updateArrivalStatusAndBehave$default(this$0, str, (String) null, 3101, 0, 10, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-5  reason: not valid java name */
    public static final void m5980onAttachToManager$lambda7$lambda5(FlowArrivalPlugin this$0, Unit it) {
        String str;
        ItemModel<?> curItemModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IFlowComponentService iFlowComponentService = (IFlowComponentService) this$0.getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService == null || (curItemModel = iFlowComponentService.getCurItemModel()) == null || (str = curItemModel.getNid()) == null) {
            str = "";
        }
        updateArrivalStatusAndBehave$default(this$0, str, (String) null, 3102, 0, 10, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x023e, code lost:
        if (r3 != false) goto L_0x0240;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f2  */
    /* renamed from: onAttachToManager$lambda-7$lambda-6  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5981onAttachToManager$lambda7$lambda6(com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin r14, java.lang.Boolean r15) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r14.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r1 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r1)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r0 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r0
            r1 = 0
            if (r0 == 0) goto L_0x001a
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r0.getCurItemModel()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            java.lang.String r2 = "isCovered"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r2)
            boolean r2 = r15.booleanValue()
            java.lang.String r3 = ""
            r4 = 1
            if (r2 == 0) goto L_0x0066
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1 = r14.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r2 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r1 = r1.getService(r2)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r1 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r1
            if (r1 == 0) goto L_0x0047
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = r1.getCurItemModel()
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r1.getNid()
            if (r1 != 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r6 = r1
            goto L_0x0048
        L_0x0047:
            r6 = r3
        L_0x0048:
            r7 = 0
            r8 = 3103(0xc1f, float:4.348E-42)
            r9 = 4203(0x106b, float:5.89E-42)
            r10 = 2
            r11 = 0
            r5 = r14
            updateArrivalStatusAndBehave$default(r5, r6, r7, r8, r9, r10, r11)
            r14.uploadArrivalStatistic()
            int r1 = r14.sequence
            int r1 = r1 + r4
            r14.sequence = r1
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.clear()
            goto L_0x026c
        L_0x0066:
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r2 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r2 = r2.getInstance()
            r2.clear()
            long r5 = java.lang.System.currentTimeMillis()
            r14.enterTime = r5
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r14.getManager()
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r6 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r6)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r2 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r2
            if (r2 == 0) goto L_0x0090
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r2 = r2.getCurrentTabInfo()
            if (r2 == 0) goto L_0x0090
            java.lang.String r2 = r2.getPageType()
            goto L_0x0091
        L_0x0090:
            r2 = r1
        L_0x0091:
            java.lang.String r5 = "talos"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x00fc
            int r6 = r14.index
            com.baidu.searchbox.feed.detail.frame.Store r2 = r14.getStore()
            if (r2 == 0) goto L_0x00c4
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r2.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x00ae
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x00af
        L_0x00ae:
            r7 = r1
        L_0x00af:
            if (r7 == 0) goto L_0x00b7
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r7.select(r1)
        L_0x00b7:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x00c4
            java.lang.String r1 = r1.getCurrentTabId()
            if (r1 != 0) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r9 = r1
            goto L_0x00c5
        L_0x00c4:
            r9 = r3
        L_0x00c5:
            r10 = 0
            r11 = 0
            r12 = 48
            r13 = 0
            java.lang.String r7 = "layout_tab_talos"
            java.lang.String r8 = "layout_tab_talos"
            r5 = r14
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r1 = buildSpecialFlowItemArrivalModel$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r2 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r2 = r2.getInstance()
            r2.addItemArrivalModel(r1)
            int r2 = r14.index
            int r2 = r2 + r4
            r14.index = r2
            java.lang.String r2 = "layout_tab_talos"
            boolean r2 = r14.isPageArrivalByDefault(r2)
            if (r2 == 0) goto L_0x026c
            r5 = 0
            r6 = 1
            r7 = 0
            r8 = 10
            r9 = 0
            java.lang.String r4 = "layout_tab_talos"
            r3 = r14
            updateArrivalStatusAndBehave$default(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x026c
        L_0x00fc:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r14.getManager()
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r6 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r6)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r2 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r2
            if (r2 == 0) goto L_0x0116
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r2 = r2.getCurrentTabInfo()
            if (r2 == 0) goto L_0x0116
            java.lang.String r2 = r2.getPageType()
            goto L_0x0117
        L_0x0116:
            r2 = r1
        L_0x0117:
            java.lang.String r5 = "H5"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0181
            int r6 = r14.index
            com.baidu.searchbox.feed.detail.frame.Store r2 = r14.getStore()
            if (r2 == 0) goto L_0x0149
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r2.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0133
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0134
        L_0x0133:
            r7 = r1
        L_0x0134:
            if (r7 == 0) goto L_0x013c
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r7.select(r1)
        L_0x013c:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x0149
            java.lang.String r1 = r1.getCurrentTabId()
            if (r1 != 0) goto L_0x0147
            goto L_0x0149
        L_0x0147:
            r9 = r1
            goto L_0x014a
        L_0x0149:
            r9 = r3
        L_0x014a:
            r10 = 0
            r11 = 0
            r12 = 48
            r13 = 0
            java.lang.String r7 = "layout_tab_h5"
            java.lang.String r8 = "layout_tab_h5"
            r5 = r14
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r1 = buildSpecialFlowItemArrivalModel$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r2 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r2 = r2.getInstance()
            r2.addItemArrivalModel(r1)
            int r2 = r14.index
            int r2 = r2 + r4
            r14.index = r2
            java.lang.String r2 = "layout_tab_h5"
            boolean r2 = r14.isPageArrivalByDefault(r2)
            if (r2 == 0) goto L_0x026c
            r5 = 0
            r6 = 1
            r7 = 0
            r8 = 10
            r9 = 0
            java.lang.String r4 = "layout_tab_h5"
            r3 = r14
            updateArrivalStatusAndBehave$default(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x026c
        L_0x0181:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r14.getManager()
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r6 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r6)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r2 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r2
            if (r2 == 0) goto L_0x0195
            java.lang.String r2 = r2.getCurrentTabId()
            goto L_0x0196
        L_0x0195:
            r2 = r1
        L_0x0196:
            java.lang.String r5 = "4"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0200
            int r6 = r14.index
            com.baidu.searchbox.feed.detail.frame.Store r2 = r14.getStore()
            if (r2 == 0) goto L_0x01c8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r2.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x01b2
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x01b3
        L_0x01b2:
            r7 = r1
        L_0x01b3:
            if (r7 == 0) goto L_0x01bb
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r7.select(r1)
        L_0x01bb:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x01c8
            java.lang.String r1 = r1.getCurrentTabId()
            if (r1 != 0) goto L_0x01c6
            goto L_0x01c8
        L_0x01c6:
            r9 = r1
            goto L_0x01c9
        L_0x01c8:
            r9 = r3
        L_0x01c9:
            r10 = 0
            r11 = 0
            r12 = 48
            r13 = 0
            java.lang.String r7 = "layout_tab_live"
            java.lang.String r8 = "layout_tab_live"
            r5 = r14
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r1 = buildSpecialFlowItemArrivalModel$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r2 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r2 = r2.getInstance()
            r2.addItemArrivalModel(r1)
            int r2 = r14.index
            int r2 = r2 + r4
            r14.index = r2
            java.lang.String r2 = "layout_tab_live"
            boolean r2 = r14.isPageArrivalByDefault(r2)
            if (r2 == 0) goto L_0x026c
            r5 = 0
            r6 = 1
            r7 = 0
            r8 = 10
            r9 = 0
            java.lang.String r4 = "layout_tab_live"
            r3 = r14
            updateArrivalStatusAndBehave$default(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x026c
        L_0x0200:
            if (r0 == 0) goto L_0x026c
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r1 = r14.buildFlowItemArrivalModel(r0)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r2 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r2 = r2.getInstance()
            r2.addItemArrivalModel(r1)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r14.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r3 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r3)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r2 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r2
            r3 = 0
            if (r2 == 0) goto L_0x0226
            boolean r2 = r2.isPlayerPlaying()
            if (r2 != r4) goto L_0x0226
            r2 = r4
            goto L_0x0227
        L_0x0226:
            r2 = r3
        L_0x0227:
            if (r2 != 0) goto L_0x0240
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r14.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r5 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r5)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r2 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r2
            if (r2 == 0) goto L_0x023e
            boolean r2 = r2.isPlayerPause()
            if (r2 != r4) goto L_0x023e
            r3 = r4
        L_0x023e:
            if (r3 == 0) goto L_0x024f
        L_0x0240:
            java.lang.String r6 = r0.getNid()
            r7 = 0
            r8 = 1
            r9 = 0
            r10 = 10
            r11 = 0
            r5 = r14
            updateArrivalStatusAndBehave$default(r5, r6, r7, r8, r9, r10, r11)
        L_0x024f:
            java.lang.String r2 = r0.getLayout()
            boolean r2 = r14.isPageArrivalByDefault(r2)
            if (r2 == 0) goto L_0x0267
            java.lang.String r6 = r0.getNid()
            r7 = 0
            r8 = 1
            r9 = 0
            r10 = 10
            r11 = 0
            r5 = r14
            updateArrivalStatusAndBehave$default(r5, r6, r7, r8, r9, r10, r11)
        L_0x0267:
            int r2 = r14.index
            int r2 = r2 + r4
            r14.index = r2
        L_0x026c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.m5981onAttachToManager$lambda7$lambda6(com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin, java.lang.Boolean):void");
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(IFlowArrivalService.class, new FlowArrivalService(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.tab.TabState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.baidu.searchbox.video.feedflow.tab.TabState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: com.baidu.searchbox.video.feedflow.tab.TabState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: com.baidu.searchbox.video.feedflow.tab.TabState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: com.baidu.searchbox.video.feedflow.tab.TabState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: com.baidu.searchbox.video.feedflow.tab.TabState} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0023, code lost:
        r0 = r0.getCurrentTabInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01f2, code lost:
        if (r4 != false) goto L_0x01f4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r13 = this;
            super.onResume()
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r0 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r0 = r0.getInstance()
            r0.clear()
            long r0 = java.lang.System.currentTimeMillis()
            r13.enterTime = r0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r13.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r2 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r2)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r0 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r0
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getCurrentTabInfo()
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = r0.getPageType()
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            java.lang.String r2 = "talos"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            java.lang.String r2 = ""
            r3 = 1
            if (r0 == 0) goto L_0x009d
            int r5 = r13.index
            com.baidu.searchbox.feed.detail.frame.Store r0 = r13.getStore()
            if (r0 == 0) goto L_0x0065
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x004f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0050
        L_0x004f:
            r6 = r1
        L_0x0050:
            if (r6 == 0) goto L_0x0058
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r6.select(r1)
        L_0x0058:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x0065
            java.lang.String r0 = r1.getCurrentTabId()
            if (r0 != 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r8 = r0
            goto L_0x0066
        L_0x0065:
            r8 = r2
        L_0x0066:
            r9 = 0
            r10 = 0
            r11 = 48
            r12 = 0
            java.lang.String r6 = "layout_tab_talos"
            java.lang.String r7 = "layout_tab_talos"
            r4 = r13
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r0 = buildSpecialFlowItemArrivalModel$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.addItemArrivalModel(r0)
            int r1 = r13.index
            int r1 = r1 + r3
            r13.index = r1
            java.lang.String r1 = "layout_tab_talos"
            boolean r1 = r13.isPageArrivalByDefault(r1)
            if (r1 == 0) goto L_0x0224
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 10
            r8 = 0
            java.lang.String r3 = "layout_tab_talos"
            r2 = r13
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0224
        L_0x009d:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r13.getManager()
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r5 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r5)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r0 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r0
            if (r0 == 0) goto L_0x00b7
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getCurrentTabInfo()
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r0.getPageType()
            goto L_0x00b8
        L_0x00b7:
            r0 = r1
        L_0x00b8:
            java.lang.String r4 = "H5"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0122
            int r5 = r13.index
            com.baidu.searchbox.feed.detail.frame.Store r0 = r13.getStore()
            if (r0 == 0) goto L_0x00ea
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x00d4
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x00d5
        L_0x00d4:
            r6 = r1
        L_0x00d5:
            if (r6 == 0) goto L_0x00dd
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r6.select(r1)
        L_0x00dd:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x00ea
            java.lang.String r0 = r1.getCurrentTabId()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00ea
        L_0x00e8:
            r8 = r0
            goto L_0x00eb
        L_0x00ea:
            r8 = r2
        L_0x00eb:
            r9 = 0
            r10 = 0
            r11 = 48
            r12 = 0
            java.lang.String r6 = "layout_tab_h5"
            java.lang.String r7 = "layout_tab_h5"
            r4 = r13
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r0 = buildSpecialFlowItemArrivalModel$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.addItemArrivalModel(r0)
            int r1 = r13.index
            int r1 = r1 + r3
            r13.index = r1
            java.lang.String r1 = "layout_tab_h5"
            boolean r1 = r13.isPageArrivalByDefault(r1)
            if (r1 == 0) goto L_0x0224
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 10
            r8 = 0
            java.lang.String r3 = "layout_tab_h5"
            r2 = r13
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0224
        L_0x0122:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r13.getManager()
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r5 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r5)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r0 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r0
            if (r0 == 0) goto L_0x0136
            java.lang.String r0 = r0.getCurrentTabId()
            goto L_0x0137
        L_0x0136:
            r0 = r1
        L_0x0137:
            java.lang.String r4 = "4"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x01a1
            int r5 = r13.index
            com.baidu.searchbox.feed.detail.frame.Store r0 = r13.getStore()
            if (r0 == 0) goto L_0x0169
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0153
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0154
        L_0x0153:
            r6 = r1
        L_0x0154:
            if (r6 == 0) goto L_0x015c
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r1 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r1 = r6.select(r1)
        L_0x015c:
            com.baidu.searchbox.video.feedflow.tab.TabState r1 = (com.baidu.searchbox.video.feedflow.tab.TabState) r1
            if (r1 == 0) goto L_0x0169
            java.lang.String r0 = r1.getCurrentTabId()
            if (r0 != 0) goto L_0x0167
            goto L_0x0169
        L_0x0167:
            r8 = r0
            goto L_0x016a
        L_0x0169:
            r8 = r2
        L_0x016a:
            r9 = 0
            r10 = 0
            r11 = 48
            r12 = 0
            java.lang.String r6 = "layout_tab_live"
            java.lang.String r7 = "layout_tab_live"
            r4 = r13
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r0 = buildSpecialFlowItemArrivalModel$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.addItemArrivalModel(r0)
            int r1 = r13.index
            int r1 = r1 + r3
            r13.index = r1
            java.lang.String r1 = "layout_tab_live"
            boolean r1 = r13.isPageArrivalByDefault(r1)
            if (r1 == 0) goto L_0x0224
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 10
            r8 = 0
            java.lang.String r3 = "layout_tab_live"
            r2 = r13
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0224
        L_0x01a1:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r13.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r2 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r2)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r0 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r0
            if (r0 == 0) goto L_0x01b3
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = r0.getCurItemModel()
        L_0x01b3:
            r0 = r1
            if (r0 == 0) goto L_0x0221
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r1 = r13.buildFlowItemArrivalModel(r0)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r2 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r2 = r2.getInstance()
            r2.addItemArrivalModel(r1)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r13.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r4 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r4)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r2 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r2
            r4 = 0
            if (r2 == 0) goto L_0x01da
            boolean r2 = r2.isPlayerPlaying()
            if (r2 != r3) goto L_0x01da
            r2 = r3
            goto L_0x01db
        L_0x01da:
            r2 = r4
        L_0x01db:
            if (r2 != 0) goto L_0x01f4
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r13.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r5 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r5)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r2 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r2
            if (r2 == 0) goto L_0x01f2
            boolean r2 = r2.isPlayerPause()
            if (r2 != r3) goto L_0x01f2
            r4 = r3
        L_0x01f2:
            if (r4 == 0) goto L_0x0203
        L_0x01f4:
            java.lang.String r6 = r0.getNid()
            r7 = 0
            r8 = 1
            r9 = 0
            r10 = 10
            r11 = 0
            r5 = r13
            updateArrivalStatusAndBehave$default(r5, r6, r7, r8, r9, r10, r11)
        L_0x0203:
            java.lang.String r2 = r0.getLayout()
            boolean r2 = r13.isPageArrivalByDefault(r2)
            if (r2 == 0) goto L_0x021b
            java.lang.String r5 = r0.getNid()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 10
            r10 = 0
            r4 = r13
            updateArrivalStatusAndBehave$default(r4, r5, r6, r7, r8, r9, r10)
        L_0x021b:
            int r2 = r13.index
            int r2 = r2 + r3
            r13.index = r2
            goto L_0x0224
        L_0x0221:
            r13.createFirstPart()
        L_0x0224:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.onResume():void");
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPause() {
        /*
            r10 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r10.getStore()
            r2 = 0
            r9 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r0)
            if (r0 != r9) goto L_0x0010
            r0 = r9
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            super.onPause()
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r10.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r3 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r3)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r0 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r0
            r3 = 0
            if (r0 == 0) goto L_0x0033
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getCurrentTabInfo()
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getPageType()
            goto L_0x0034
        L_0x0033:
            r0 = r3
        L_0x0034:
            java.lang.String r1 = "talos"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0042
            java.lang.String r0 = "layout_tab_talos"
            r1 = r0
            goto L_0x00a7
        L_0x0042:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r10.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r4 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r4)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r0 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r0
            if (r0 == 0) goto L_0x005c
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r0.getCurrentTabInfo()
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r0.getPageType()
            goto L_0x005d
        L_0x005c:
            r0 = r3
        L_0x005d:
            java.lang.String r1 = "H5"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = "layout_tab_h5"
            r1 = r0
            goto L_0x00a7
        L_0x0069:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r10.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r4 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r4)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r0 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r0
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = r0.getCurrentTabId()
            goto L_0x007e
        L_0x007d:
            r0 = r3
        L_0x007e:
            java.lang.String r1 = "4"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = "layout_tab_live"
            r1 = r0
            goto L_0x00a7
        L_0x008a:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r10.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r1 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r1)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r0 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r0
            if (r0 == 0) goto L_0x00a4
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r0.getCurItemModel()
            if (r0 == 0) goto L_0x00a4
            java.lang.String r0 = r0.getNid()
            if (r0 != 0) goto L_0x00a6
        L_0x00a4:
            java.lang.String r0 = ""
        L_0x00a6:
            r1 = r0
        L_0x00a7:
            android.content.Context r0 = r10.getContext()
            boolean r4 = r0 instanceof android.app.Activity
            if (r4 == 0) goto L_0x00b3
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
        L_0x00b3:
            if (r3 == 0) goto L_0x00bc
            boolean r0 = r3.isFinishing()
            if (r0 != r9) goto L_0x00bc
            r2 = r9
        L_0x00bc:
            if (r2 == 0) goto L_0x00cc
            r2 = 0
            r3 = 3103(0xc1f, float:4.348E-42)
            r4 = 4201(0x1069, float:5.887E-42)
            r5 = 2
            r6 = 0
            r0 = r10
            updateArrivalStatusAndBehave$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x00da
        L_0x00cc:
            r4 = 0
            r5 = 3103(0xc1f, float:4.348E-42)
            r6 = 4202(0x106a, float:5.888E-42)
            r7 = 2
            r8 = 0
            r2 = r10
            r3 = r1
            updateArrivalStatusAndBehave$default(r2, r3, r4, r5, r6, r7, r8)
        L_0x00da:
            r10.uploadArrivalStatistic()
            int r0 = r10.sequence
            int r0 = r0 + r9
            r10.sequence = r0
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r0 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r0 = r0.getInstance()
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.onPause():void");
    }

    /* access modifiers changed from: protected */
    public void pageSelected() {
        String str;
        String str2;
        String nid;
        String str3;
        String str4;
        String layout;
        String nid2;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        String str5 = null;
        ItemModel itemModel = iFlowComponentService != null ? iFlowComponentService.getCurItemModel() : null;
        FlowItemArrivalModel lastItemArrivalModel = FlowArrivalStatusCollector.Companion.getInstance().getLastItemArrivalModel();
        String nid3 = lastItemArrivalModel != null ? lastItemArrivalModel.getNid() : null;
        if (itemModel != null) {
            str5 = itemModel.getNid();
        }
        if (Intrinsics.areEqual((Object) nid3, (Object) str5)) {
            if (itemModel == null || (nid2 = itemModel.getNid()) == null) {
                str3 = "";
            } else {
                str3 = nid2;
            }
            if (itemModel == null || (layout = itemModel.getLayout()) == null) {
                str4 = "";
            } else {
                str4 = layout;
            }
            updateArrivalStatusAndBehave$default(this, str3, str4, 0, 0, 12, (Object) null);
        } else {
            FlowArrivalStatusCollector.Companion.getInstance().addItemArrivalModel(buildFlowItemArrivalModel(itemModel));
            this.index++;
        }
        if (itemModel == null || (str = itemModel.getLayout()) == null) {
            str = "";
        }
        if (isPageArrivalByDefault(str) || isOnReUsePlayerType(itemModel)) {
            if (itemModel == null || (nid = itemModel.getNid()) == null) {
                str2 = "";
            } else {
                str2 = nid;
            }
            updateArrivalStatusAndBehave$default(this, str2, (String) null, 1, 0, 10, (Object) null);
        }
        IFlowComponentService iFlowComponentService2 = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        this.relativeIntentVideoPosition = iFlowComponentService2 != null ? iFlowComponentService2.getRelativeIntentVideoPosition() : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if ((r0 != null && r0.isPlayerPause()) != false) goto L_0x0029;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isOnReUsePlayerType(com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r7) {
        /*
            r6 = this;
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r6.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r2 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r2)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r0 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0019
            boolean r3 = r0.isPlayerPlaying()
            if (r3 != r1) goto L_0x0019
            r3 = r1
            goto L_0x001a
        L_0x0019:
            r3 = r2
        L_0x001a:
            if (r3 != 0) goto L_0x0029
            if (r0 == 0) goto L_0x0026
            boolean r3 = r0.isPlayerPause()
            if (r3 != r1) goto L_0x0026
            r3 = r1
            goto L_0x0027
        L_0x0026:
            r3 = r2
        L_0x0027:
            if (r3 == 0) goto L_0x0038
        L_0x0029:
            if (r0 == 0) goto L_0x0033
            boolean r3 = r0.isUseCache()
            if (r3 != r1) goto L_0x0033
            r3 = r1
            goto L_0x0034
        L_0x0033:
            r3 = r2
        L_0x0034:
            if (r3 == 0) goto L_0x0038
            r3 = r1
            goto L_0x0039
        L_0x0038:
            r3 = r2
        L_0x0039:
            if (r3 == 0) goto L_0x0058
            r4 = 0
            if (r0 == 0) goto L_0x004a
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r5 = r0.getVideoSeries()
            if (r5 == 0) goto L_0x004a
            java.lang.String r5 = r5.getVid()
            goto L_0x004b
        L_0x004a:
            r5 = r4
        L_0x004b:
            if (r7 == 0) goto L_0x0051
            java.lang.String r4 = r7.getId()
        L_0x0051:
            boolean r4 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.equalsVid(r5, r4)
            if (r4 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r1 = r2
        L_0x0059:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.isOnReUsePlayerType(com.baidu.searchbox.video.feedflow.flow.list.ItemModel):boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createFirstPart() {
        /*
            r11 = this;
            int r1 = r11.index
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            r2 = 0
            if (r0 == 0) goto L_0x0028
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0016
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0017
        L_0x0016:
            r4 = r2
        L_0x0017:
            if (r4 == 0) goto L_0x0020
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0021
        L_0x0020:
            r4 = r2
        L_0x0021:
            com.baidu.searchbox.video.detail.core.model.IntentData r4 = (com.baidu.searchbox.video.detail.core.model.IntentData) r4
            if (r4 == 0) goto L_0x0028
            java.lang.String r0 = r4.nid
            goto L_0x0029
        L_0x0028:
            r0 = r2
        L_0x0029:
            java.lang.String r3 = ""
            if (r0 != 0) goto L_0x002f
            r4 = r3
            goto L_0x0030
        L_0x002f:
            r4 = r0
        L_0x0030:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            if (r0 == 0) goto L_0x0058
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0042
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0043
        L_0x0042:
            r6 = r2
        L_0x0043:
            if (r6 == 0) goto L_0x004c
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x004d
        L_0x004c:
            r6 = r2
        L_0x004d:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x0058
            java.lang.String r0 = r6.layout
            if (r0 != 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r5 = r0
            goto L_0x0059
        L_0x0058:
            r5 = r3
        L_0x0059:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            if (r0 == 0) goto L_0x0081
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r0.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x006b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x006c
        L_0x006b:
            r7 = r2
        L_0x006c:
            if (r7 == 0) goto L_0x0074
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r2 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r2 = r7.select(r2)
        L_0x0074:
            com.baidu.searchbox.video.feedflow.tab.TabState r2 = (com.baidu.searchbox.video.feedflow.tab.TabState) r2
            if (r2 == 0) goto L_0x0081
            java.lang.String r0 = r2.getCurrentTabId()
            if (r0 != 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r6 = r0
            goto L_0x0082
        L_0x0081:
            r6 = r3
        L_0x0082:
            r7 = 0
            r8 = 0
            r9 = 32
            r10 = 0
            r0 = r11
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r10
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r0 = buildSpecialFlowItemArrivalModel$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r1 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r1 = r1.getInstance()
            r1.addItemArrivalModel(r0)
            int r1 = r11.index
            int r1 = r1 + 1
            r11.index = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.createFirstPart():void");
    }

    public static /* synthetic */ FlowItemArrivalModel buildSpecialFlowItemArrivalModel$default(FlowArrivalPlugin flowArrivalPlugin, int i2, String str, String str2, String str3, int i3, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                i2 = -1;
            }
            if ((i5 & 2) != 0) {
                str = "";
            }
            if ((i5 & 4) != 0) {
                str2 = "";
            }
            if ((i5 & 8) != 0) {
                str3 = "";
            }
            if ((i5 & 16) != 0) {
                i3 = -1;
            }
            if ((i5 & 32) != 0) {
                i4 = -1;
            }
            return flowArrivalPlugin.buildSpecialFlowItemArrivalModel(i2, str, str2, str3, i3, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildSpecialFlowItemArrivalModel");
    }

    /* access modifiers changed from: protected */
    public FlowItemArrivalModel buildSpecialFlowItemArrivalModel(int index2, String nid, String layout, String tabId, int position, int statusType) {
        String str = layout;
        int i2 = position;
        Intrinsics.checkNotNullParameter(nid, "nid");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        return new FlowItemArrivalModel(index2, i2, str, nid, tabId, (String) null, System.currentTimeMillis(), 0, 0, (String) null, false, false, statusType, 0, (String) null, (String) null, 0, false, (JSONObject) null, 520096, (DefaultConstructorMarker) null);
    }

    static /* synthetic */ FlowItemArrivalModel buildFlowItemArrivalModel$default(FlowArrivalPlugin flowArrivalPlugin, ItemModel itemModel, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                itemModel = null;
            }
            return flowArrivalPlugin.buildFlowItemArrivalModel(itemModel);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildFlowItemArrivalModel");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        if (r5 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r30.getRunTimeStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel buildFlowItemArrivalModel(com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r30) {
        /*
            r29 = this;
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r26 = new com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel
            r15 = r29
            int r1 = r15.index
            if (r30 == 0) goto L_0x0013
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r30.getRunTimeStatus()
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getPosition()
            goto L_0x0014
        L_0x0013:
            r0 = -1
        L_0x0014:
            r2 = r0
            java.lang.String r0 = ""
            if (r30 == 0) goto L_0x001f
            java.lang.String r3 = r30.getLayout()
            if (r3 != 0) goto L_0x0020
        L_0x001f:
            r3 = r0
        L_0x0020:
            if (r30 == 0) goto L_0x0028
            java.lang.String r4 = r30.getNid()
            if (r4 != 0) goto L_0x0029
        L_0x0028:
            r4 = r0
        L_0x0029:
            com.baidu.searchbox.feed.detail.frame.Store r5 = r29.getStore()
            r6 = 0
            if (r5 == 0) goto L_0x0051
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r5.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x003c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x003d
        L_0x003c:
            r8 = r6
        L_0x003d:
            if (r8 == 0) goto L_0x0046
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r9 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x0047
        L_0x0046:
            r8 = r6
        L_0x0047:
            com.baidu.searchbox.video.feedflow.tab.TabState r8 = (com.baidu.searchbox.video.feedflow.tab.TabState) r8
            if (r8 == 0) goto L_0x0051
            java.lang.String r5 = r8.getCurrentTabId()
            if (r5 != 0) goto L_0x0052
        L_0x0051:
            r5 = r0
        L_0x0052:
            if (r30 == 0) goto L_0x0060
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r7 = r30.getRunTimeStatus()
            if (r7 == 0) goto L_0x0060
            java.lang.String r7 = r7.getCacheSource()
            if (r7 != 0) goto L_0x0061
        L_0x0060:
            r7 = r0
        L_0x0061:
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            java.lang.String r20 = r0.getNetType()
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            java.lang.String r21 = r0.getNetQualityScore()
            r27 = 0
            if (r30 == 0) goto L_0x008c
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r30.getRunTimeStatus()
            if (r0 == 0) goto L_0x008c
            java.lang.Boolean r6 = r0.isOfflineCache()
        L_0x008c:
            boolean r22 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r6)
            r23 = 0
            r24 = 343936(0x53f80, float:4.81957E-40)
            r25 = 0
            r0 = r26
            r6 = r7
            r7 = r8
            r9 = r10
            r11 = r12
            r13 = r14
            r14 = r16
            r15 = r17
            r16 = r18
            r17 = r19
            r18 = r20
            r19 = r21
            r20 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25)
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.buildFlowItemArrivalModel(com.baidu.searchbox.video.feedflow.flow.list.ItemModel):com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel");
    }

    public final void playSuccess(ItemModel<?> itemModel) {
        ItemModel model;
        String nid;
        RunTimeStatus runTimeStatus;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService == null || (model = iFlowComponentService.getCurItemModel()) == null) {
            model = itemModel;
        }
        if (model == null || (nid = model.getNid()) == null) {
            nid = "";
        }
        updateArrivalStatusAndBehave$default(this, nid, (String) null, 1, 0, 10, (Object) null);
        FlowItemArrivalModel itemArrivalModelByNid = FlowArrivalStatusCollector.Companion.getInstance().getItemArrivalModelByNid(nid);
        if (itemArrivalModelByNid != null) {
            boolean z = true;
            if (model == null || (runTimeStatus = model.getRunTimeStatus()) == null || !runTimeStatus.isPlayFromLocal()) {
                z = false;
            }
            itemArrivalModelByNid.setPlayFromLocal(z ? "1" : "0");
        }
    }

    public final void onCallPlayer(ItemModel<?> itemModel) {
        ItemModel model;
        String nid;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService == null || (model = iFlowComponentService.getCurItemModel()) == null) {
            model = itemModel;
        }
        if (model == null || (nid = model.getNid()) == null) {
            nid = "";
        }
        FlowItemArrivalModel itemArrivalModelByNid = FlowArrivalStatusCollector.Companion.getInstance().getItemArrivalModelByNid(nid);
        if (itemArrivalModelByNid != null) {
            itemArrivalModelByNid.setCallPlayerTime(System.currentTimeMillis());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r0.getCurItemModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void isPlayFromLocal() {
        /*
            r3 = this;
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r3.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r2 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r2)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r0 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r0
            if (r0 == 0) goto L_0x001a
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r0.getCurItemModel()
            if (r0 == 0) goto L_0x001a
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r0.getRunTimeStatus()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            r1 = 1
            r0.setPlayFromLocal(r1)
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.isPlayFromLocal():void");
    }

    public final void onError(int what, int extra, String info) {
        String nid;
        JSONObject $this$onError_u24lambda_u2d10;
        ItemModel<?> curItemModel;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService == null || (curItemModel = iFlowComponentService.getCurItemModel()) == null || (nid = curItemModel.getNid()) == null) {
            nid = "";
        }
        JSONObject childErrorInfo = new JSONObject();
        childErrorInfo.put(SwanInlineBaseVideoWidget.UbcConstants.EXT_KEY_ERROR_NO, what);
        childErrorInfo.put("subErrorNo", extra);
        childErrorInfo.put("info", info);
        FlowItemArrivalModel itemArrivalModelByNid = FlowArrivalStatusCollector.Companion.getInstance().getItemArrivalModelByNid(nid);
        if (itemArrivalModelByNid != null && ($this$onError_u24lambda_u2d10 = itemArrivalModelByNid.getExt()) != null) {
            JSONArray $this$onError_u24lambda_u2d10_u24lambda_u2d8 = $this$onError_u24lambda_u2d10.optJSONArray("errorInfo");
            if ($this$onError_u24lambda_u2d10_u24lambda_u2d8 != null) {
                Intrinsics.checkNotNullExpressionValue($this$onError_u24lambda_u2d10_u24lambda_u2d8, "optJSONArray(\"errorInfo\")");
                if ($this$onError_u24lambda_u2d10_u24lambda_u2d8.put(childErrorInfo) != null) {
                    return;
                }
            }
            JSONArray childErrorArray = new JSONArray();
            childErrorArray.put(childErrorInfo);
            $this$onError_u24lambda_u2d10.put("errorInfo", childErrorArray);
        }
    }

    public final void onCarlton(String info) {
        String nid;
        JSONObject $this$onCarlton_u24lambda_u2d13;
        ItemModel<?> curItemModel;
        CharSequence charSequence = info;
        if (!(charSequence == null || charSequence.length() == 0)) {
            try {
                JSONObject carlton = new JSONObject(info);
                IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
                if (iFlowComponentService == null || (curItemModel = iFlowComponentService.getCurItemModel()) == null || (nid = curItemModel.getNid()) == null) {
                    nid = "";
                }
                JSONObject childCarltonInfo = new JSONObject();
                childCarltonInfo.put("carltonType", carlton.optString("carlton_type"));
                childCarltonInfo.put("currentTime", carlton.optString("current_time"));
                childCarltonInfo.put("carltonLength", carlton.optString("carltonLength"));
                childCarltonInfo.put("carltonBuffer", carlton.optString("buffer"));
                FlowItemArrivalModel itemArrivalModelByNid = FlowArrivalStatusCollector.Companion.getInstance().getItemArrivalModelByNid(nid);
                if (itemArrivalModelByNid != null && ($this$onCarlton_u24lambda_u2d13 = itemArrivalModelByNid.getExt()) != null) {
                    JSONArray $this$onCarlton_u24lambda_u2d13_u24lambda_u2d11 = $this$onCarlton_u24lambda_u2d13.optJSONArray("cartonInfo");
                    if ($this$onCarlton_u24lambda_u2d13_u24lambda_u2d11 != null) {
                        Intrinsics.checkNotNullExpressionValue($this$onCarlton_u24lambda_u2d13_u24lambda_u2d11, "optJSONArray(\"cartonInfo\")");
                        if ($this$onCarlton_u24lambda_u2d13_u24lambda_u2d11.put(childCarltonInfo) != null) {
                            return;
                        }
                    }
                    JSONArray childCarltonArray = new JSONArray();
                    childCarltonArray.put(childCarltonInfo);
                    $this$onCarlton_u24lambda_u2d13.put("cartonInfo", childCarltonArray);
                }
            } catch (JSONException e2) {
            }
        }
    }

    public final void picLoadSuccess() {
        String str;
        ItemModel<?> curItemModel;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService == null || (curItemModel = iFlowComponentService.getCurItemModel()) == null || (str = curItemModel.getNid()) == null) {
            str = "";
        }
        updateArrivalStatusAndBehave$default(this, str, (String) null, 1, 0, 10, (Object) null);
    }

    private final boolean isPageArrivalByDefault(String layout) {
        return ItemTypeManifestKt.isAssessmentItem(layout) || ItemTypeManifestKt.isInterestItem(layout) || ItemTypeManifestKt.isFollowGuideItem(layout) || ItemTypeManifestKt.isFollowBatchItem(layout) || Intrinsics.areEqual((Object) layout, (Object) FlowArrivalCodeConstantKt.LAYOUT_TAB_TALOS) || Intrinsics.areEqual((Object) layout, (Object) FlowArrivalCodeConstantKt.LAYOUT_TAB_LIVE) || Intrinsics.areEqual((Object) layout, (Object) FlowArrivalCodeConstantKt.LAYOUT_TAB_H5);
    }

    public static /* synthetic */ void updateArrivalStatusAndBehave$default(FlowArrivalPlugin flowArrivalPlugin, String str, String str2, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                str = "";
            }
            if ((i4 & 2) != 0) {
                str2 = "";
            }
            if ((i4 & 4) != 0) {
                i2 = -1;
            }
            if ((i4 & 8) != 0) {
                i3 = -1;
            }
            flowArrivalPlugin.updateArrivalStatusAndBehave(str, str2, i2, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateArrivalStatusAndBehave");
    }

    /* access modifiers changed from: protected */
    public void updateArrivalStatusAndBehave(String nid, String layout, int statusType, int behaveType) {
        int i2;
        Intrinsics.checkNotNullParameter(nid, "nid");
        Intrinsics.checkNotNullParameter(layout, "layout");
        int pageStatusType = -1;
        FlowItemArrivalModel arrivalModel = FlowArrivalStatusCollector.Companion.getInstance().getItemArrivalModelByNid(nid);
        boolean z = true;
        if (statusType > 0) {
            if (!(arrivalModel != null && arrivalModel.isFirstUploadStatusType())) {
                switch (statusType) {
                    case 3102:
                    case 3106:
                        pageStatusType = statusType;
                        if (arrivalModel != null) {
                            arrivalModel.setWaitingDuration(System.currentTimeMillis() - arrivalModel.getStartTime());
                            break;
                        }
                        break;
                }
            } else {
                if (statusType == 1 || ExcStatusManager.Companion.getInstance().isFastFirstFrame()) {
                    i2 = 1;
                } else if (statusType == 3101 || statusType == 3102 || statusType == 3106) {
                    i2 = statusType;
                } else {
                    i2 = 3103;
                }
                pageStatusType = i2;
                arrivalModel.setWaitingDuration(System.currentTimeMillis() - arrivalModel.getStartTime());
            }
            if (arrivalModel != null) {
                arrivalModel.setFirstUploadStatusType(false);
            }
            if (pageStatusType == 1 && arrivalModel != null) {
                arrivalModel.setArrivalTime(System.currentTimeMillis());
            }
        }
        int pageBehaveType = -1;
        if (behaveType > 0) {
            if (arrivalModel == null || !arrivalModel.isFirstUploadBehaveType()) {
                z = false;
            }
            if (z) {
                int pageBehaveType2 = behaveType;
                if (arrivalModel.getWaitingDuration() < 0) {
                    arrivalModel.setWaitingDuration(System.currentTimeMillis() - arrivalModel.getStartTime());
                }
                pageBehaveType = pageBehaveType2;
            }
            if (arrivalModel != null) {
                arrivalModel.setFirstUploadBehaveType(false);
            }
        }
        FlowArrivalStatusCollector.Companion.getInstance().updateItemArrivalModel(nid, layout, pageStatusType, pageBehaveType);
        ExcStatusManager.Companion.getInstance().clearFastFirstFrame();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01fd A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x020c A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x023c A[SYNTHETIC, Splitter:B:108:0x023c] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0306 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008a A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ef A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f7 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fc A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010e A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0117 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0129 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0132 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0138 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013d A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0145 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014a A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x015a A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015f A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0168 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0171 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x017d A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x018f A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0198 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a0 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a9 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b1 A[Catch:{ JSONException -> 0x0344 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01b6 A[Catch:{ JSONException -> 0x0344 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadArrivalStatistic() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "callPlayerTime"
            java.lang.String r2 = "cacheType"
            java.lang.String r3 = "netType"
            com.baidu.searchbox.feed.detail.frame.Store r4 = r17.getStore()
            if (r4 == 0) goto L_0x0346
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x001a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            if (r6 == 0) goto L_0x0024
            java.lang.Class<com.baidu.searchbox.feed.detail.ext.common.UbcBean> r7 = com.baidu.searchbox.feed.detail.ext.common.UbcBean.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0025
        L_0x0024:
            r6 = 0
        L_0x0025:
            com.baidu.searchbox.feed.detail.ext.common.UbcBean r6 = (com.baidu.searchbox.feed.detail.ext.common.UbcBean) r6
            if (r6 != 0) goto L_0x002b
            goto L_0x0346
        L_0x002b:
            r4 = r6
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0344 }
            r5.<init>()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r6 = "pd"
            com.baidu.searchbox.feed.detail.frame.Store r7 = r17.getStore()     // Catch:{ JSONException -> 0x0344 }
            if (r7 == 0) goto L_0x0058
            r9 = 0
            com.baidu.searchbox.feed.detail.frame.State r10 = r7.getState()     // Catch:{ JSONException -> 0x0344 }
            boolean r11 = r10 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x0344 }
            if (r11 == 0) goto L_0x0046
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r10 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0047
        L_0x0046:
            r10 = 0
        L_0x0047:
            if (r10 == 0) goto L_0x0050
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r11 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r10 = r10.select(r11)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0051
        L_0x0050:
            r10 = 0
        L_0x0051:
            com.baidu.searchbox.video.detail.core.model.IntentData r10 = (com.baidu.searchbox.video.detail.core.model.IntentData) r10     // Catch:{ JSONException -> 0x0344 }
            if (r10 == 0) goto L_0x0058
            java.lang.String r7 = r10.pd     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0059
        L_0x0058:
            r7 = 0
        L_0x0059:
            java.lang.String r9 = ""
            if (r7 != 0) goto L_0x005e
            r7 = r9
        L_0x005e:
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r6 = "channelId"
            com.baidu.searchbox.feed.detail.frame.Store r7 = r17.getStore()     // Catch:{ JSONException -> 0x0344 }
            if (r7 == 0) goto L_0x0087
            r10 = 0
            com.baidu.searchbox.feed.detail.frame.State r11 = r7.getState()     // Catch:{ JSONException -> 0x0344 }
            boolean r12 = r11 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x0344 }
            if (r12 == 0) goto L_0x0075
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0076
        L_0x0075:
            r11 = 0
        L_0x0076:
            if (r11 == 0) goto L_0x007f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r12 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r11 = r11.select(r12)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0080
        L_0x007f:
            r11 = 0
        L_0x0080:
            com.baidu.searchbox.video.detail.core.model.IntentData r11 = (com.baidu.searchbox.video.detail.core.model.IntentData) r11     // Catch:{ JSONException -> 0x0344 }
            if (r11 == 0) goto L_0x0087
            java.lang.String r7 = r11.entranceId     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0088
        L_0x0087:
            r7 = 0
        L_0x0088:
            if (r7 != 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r9 = r7
        L_0x008c:
            r5.put(r6, r9)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r6 = "sequence"
            int r7 = r1.sequence     // Catch:{ JSONException -> 0x0344 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.di.DIFactory r6 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r6 = r6.getNetType()     // Catch:{ JSONException -> 0x0344 }
            r5.put(r3, r6)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r6 = "staticScore"
            com.baidu.searchbox.export.IPlayerSpeedScoreManager r7 = com.baidu.searchbox.export.IPlayerSpeedScoreManager.Impl.getInstance()     // Catch:{ JSONException -> 0x0344 }
            float r7 = r7.getStaticDeviceScore()     // Catch:{ JSONException -> 0x0344 }
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ JSONException -> 0x0344 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0344 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0344 }
            r6.<init>()     // Catch:{ JSONException -> 0x0344 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0344 }
            r7.<init>()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r9 = "pageId"
            java.lang.String r10 = r17.getUniqueKey()     // Catch:{ JSONException -> 0x0344 }
            r7.put(r9, r10)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r9 = "enterTime"
            long r10 = r1.enterTime     // Catch:{ JSONException -> 0x0344 }
            r7.put(r9, r10)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r9 = "leaveTime"
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0344 }
            r7.put(r9, r10)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r9 = "duration"
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0344 }
            long r12 = r1.enterTime     // Catch:{ JSONException -> 0x0344 }
            long r10 = r10 - r12
            r7.put(r9, r10)     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r9 = r17.getFirstFlowItemArrivalModel()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "firstStatus"
            r11 = -1
            if (r9 == 0) goto L_0x00ef
            int r12 = r9.getStatusType()     // Catch:{ JSONException -> 0x0344 }
            goto L_0x00f0
        L_0x00ef:
            r12 = r11
        L_0x00f0:
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "firstBehaveType"
            if (r9 == 0) goto L_0x00fc
            int r12 = r9.getBehaveType()     // Catch:{ JSONException -> 0x0344 }
            goto L_0x00fd
        L_0x00fc:
            r12 = r11
        L_0x00fd:
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "lastStatus"
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r12 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r12 = r12.getInstance()     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r12 = r12.getLastItemArrivalModel()     // Catch:{ JSONException -> 0x0344 }
            if (r12 == 0) goto L_0x0117
            int r12 = r12.getStatusType()     // Catch:{ JSONException -> 0x0344 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0118
        L_0x0117:
            r12 = 0
        L_0x0118:
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "lastBehaveType"
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r12 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r12 = r12.getInstance()     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r12 = r12.getLastItemArrivalModel()     // Catch:{ JSONException -> 0x0344 }
            if (r12 == 0) goto L_0x0132
            int r12 = r12.getBehaveType()     // Catch:{ JSONException -> 0x0344 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0133
        L_0x0132:
            r12 = 0
        L_0x0133:
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
            if (r9 == 0) goto L_0x013d
            java.lang.String r10 = r9.getNetType()     // Catch:{ JSONException -> 0x0344 }
            goto L_0x013e
        L_0x013d:
            r10 = 0
        L_0x013e:
            r7.put(r3, r10)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "netQuality"
            if (r9 == 0) goto L_0x014a
            java.lang.String r12 = r9.getNetQualityScore()     // Catch:{ JSONException -> 0x0344 }
            goto L_0x014b
        L_0x014a:
            r12 = 0
        L_0x014b:
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "userTag"
            java.lang.String r12 = com.baidu.searchbox.player.preboot.utils.PlayerPolicyCfgUtil.getUserTagString()     // Catch:{ JSONException -> 0x0344 }
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
            if (r9 == 0) goto L_0x015f
            java.lang.String r10 = r9.getCacheType()     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0160
        L_0x015f:
            r10 = 0
        L_0x0160:
            r7.put(r2, r10)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "waitingDuration"
            if (r9 == 0) goto L_0x0171
            long r12 = r9.getWaitingDuration()     // Catch:{ JSONException -> 0x0344 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0172
        L_0x0171:
            r12 = 0
        L_0x0172:
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.di.DIFactory r10 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE     // Catch:{ JSONException -> 0x0344 }
            boolean r10 = r10.isAppColdLaunch()     // Catch:{ JSONException -> 0x0344 }
            if (r10 == 0) goto L_0x0188
            java.lang.String r10 = "coldLaunchTime"
            com.baidu.searchbox.video.feedflow.di.DIFactory r12 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE     // Catch:{ JSONException -> 0x0344 }
            long r12 = r12.getAppCreateTime()     // Catch:{ JSONException -> 0x0344 }
            r7.put(r10, r12)     // Catch:{ JSONException -> 0x0344 }
        L_0x0188:
            java.lang.String r10 = "hotLaunchTime"
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
            if (r9 == 0) goto L_0x0198
            long r10 = r9.getCallPlayerTime()     // Catch:{ JSONException -> 0x0344 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0199
        L_0x0198:
            r10 = 0
        L_0x0199:
            r7.put(r0, r10)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "firstFrameTime"
            if (r9 == 0) goto L_0x01a9
            long r11 = r9.getArrivalTime()     // Catch:{ JSONException -> 0x0344 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x01aa
        L_0x01a9:
            r11 = 0
        L_0x01aa:
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "firstVideoIsPlayFromLocal"
            if (r9 == 0) goto L_0x01b6
            java.lang.String r11 = r9.isPlayFromLocal()     // Catch:{ JSONException -> 0x0344 }
            goto L_0x01b7
        L_0x01b6:
            r11 = 0
        L_0x01b7:
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "currentRelativePosition"
            int r11 = r1.relativeIntentVideoPosition     // Catch:{ JSONException -> 0x0344 }
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r10 = r17.getManager()     // Catch:{ JSONException -> 0x0344 }
            r11 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.secondjumparrival.ISecondJumpArrivalService> r12 = com.baidu.searchbox.video.feedflow.tab.secondjumparrival.ISecondJumpArrivalService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r12 = r10.getService(r12)     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.tab.secondjumparrival.ISecondJumpArrivalService r12 = (com.baidu.searchbox.video.feedflow.tab.secondjumparrival.ISecondJumpArrivalService) r12     // Catch:{ JSONException -> 0x0344 }
            if (r12 == 0) goto L_0x01dd
            org.json.JSONObject r10 = r12.getUbcInfoAndReset()     // Catch:{ JSONException -> 0x0344 }
            if (r10 == 0) goto L_0x01dd
            r11 = 0
            java.lang.String r12 = "cantSlideInfo"
            r7.putOpt(r12, r10)     // Catch:{ JSONException -> 0x0344 }
        L_0x01dd:
            java.lang.String r10 = "page_id"
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r11 = r17.getManager()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r11 = com.baidu.searchbox.video.feedflow.trace.PageIdManagerPluginKt.getPageId(r11)     // Catch:{ JSONException -> 0x0344 }
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "page_seq"
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r11 = r17.getManager()     // Catch:{ JSONException -> 0x0344 }
            int r11 = com.baidu.searchbox.video.feedflow.trace.PageIdManagerPluginKt.getPageSequence(r11)     // Catch:{ JSONException -> 0x0344 }
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0344 }
            r11 = 26
            if (r10 < r11) goto L_0x0206
            java.lang.String r10 = "areAnimatorsEnabled"
            boolean r11 = android.animation.ValueAnimator.areAnimatorsEnabled()     // Catch:{ JSONException -> 0x0344 }
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
        L_0x0206:
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0344 }
            r11 = 33
            if (r10 < r11) goto L_0x0219
            java.lang.String r10 = "sDurationScale"
            float r11 = android.animation.ValueAnimator.getDurationScale()     // Catch:{ JSONException -> 0x0344 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ JSONException -> 0x0344 }
            r7.put(r10, r11)     // Catch:{ JSONException -> 0x0344 }
        L_0x0219:
            r1.addExtPageInfo(r7)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r10 = "pageInfo"
            r6.put(r10, r7)     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector$Companion r10 = com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector.Companion     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalStatusCollector r10 = r10.getInstance()     // Catch:{ JSONException -> 0x0344 }
            java.util.List r10 = r10.getItemArrivalModelList()     // Catch:{ JSONException -> 0x0344 }
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0344 }
            r11.<init>()     // Catch:{ JSONException -> 0x0344 }
            java.util.Iterator r12 = r10.iterator()     // Catch:{ JSONException -> 0x0344 }
        L_0x0234:
            boolean r13 = r12.hasNext()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r14 = "nid"
            if (r13 == 0) goto L_0x02f6
            java.lang.Object r13 = r12.next()     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel r13 = (com.baidu.searchbox.video.feedflow.flow.arrival.FlowItemArrivalModel) r13     // Catch:{ JSONException -> 0x0344 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0344 }
            r15.<init>()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r8 = "index"
            int r1 = r13.getIndex()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r8, r1)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "position"
            int r8 = r13.getPosition()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r8)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "layout"
            java.lang.String r8 = r13.getLayout()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r8)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = r13.getNid()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r14, r1)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "tabId"
            java.lang.String r8 = r13.getTabId()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r8)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = r13.getCacheType()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r2, r1)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "statusType"
            int r8 = r13.getStatusType()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r8)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "behaveType"
            int r8 = r13.getBehaveType()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r8)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = r13.getNetType()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r3, r1)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "netQualityScore"
            java.lang.String r8 = r13.getNetQualityScore()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r8)     // Catch:{ JSONException -> 0x0344 }
            r8 = r2
            long r1 = r13.getCallPlayerTime()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r0, r1)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "startRecordTime"
            r16 = r3
            long r2 = r13.getStartTime()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r2)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "arrivalTime"
            long r2 = r13.getArrivalTime()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r2)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "arriveDuration"
            long r2 = r13.getWaitingDuration()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r2)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "isPlayFromLocal"
            java.lang.String r2 = r13.isPlayFromLocal()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r2)     // Catch:{ JSONException -> 0x0344 }
            boolean r1 = r13.isOfflineCache()     // Catch:{ JSONException -> 0x0344 }
            if (r1 == 0) goto L_0x02e3
            java.lang.String r1 = "offlineCacheTag"
            com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfig r2 = com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfigKt.getFlowVideoCacheConfig()     // Catch:{ JSONException -> 0x0344 }
            int r2 = com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfigKt.getCacheMaxSize(r2)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r2)     // Catch:{ JSONException -> 0x0344 }
        L_0x02e3:
            java.lang.String r1 = "ext"
            org.json.JSONObject r2 = r13.getExt()     // Catch:{ JSONException -> 0x0344 }
            r15.put(r1, r2)     // Catch:{ JSONException -> 0x0344 }
            r11.put(r15)     // Catch:{ JSONException -> 0x0344 }
            r1 = r17
            r2 = r8
            r3 = r16
            goto L_0x0234
        L_0x02f6:
            java.lang.String r0 = "part"
            r6.put(r0, r11)     // Catch:{ JSONException -> 0x0344 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0344 }
            r0.<init>()     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.feed.detail.frame.Store r1 = r17.getStore()     // Catch:{ JSONException -> 0x0344 }
            if (r1 == 0) goto L_0x0324
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()     // Catch:{ JSONException -> 0x0344 }
            boolean r8 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x0344 }
            if (r8 == 0) goto L_0x0312
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0313
        L_0x0312:
            r3 = 0
        L_0x0313:
            if (r3 == 0) goto L_0x031c
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r3 = r3.select(r8)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x031d
        L_0x031c:
            r3 = 0
        L_0x031d:
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = (com.baidu.searchbox.video.detail.core.model.IntentData) r3     // Catch:{ JSONException -> 0x0344 }
            if (r3 == 0) goto L_0x0324
            java.lang.String r8 = r3.nid     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0325
        L_0x0324:
            r8 = 0
        L_0x0325:
            r0.put(r14, r8)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "schemeInfo"
            r6.put(r1, r0)     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r1 = "5800Info"
            r5.put(r1, r6)     // Catch:{ JSONException -> 0x0344 }
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r1 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r2 = r4.getFrom()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r3 = r4.getPage()     // Catch:{ JSONException -> 0x0344 }
            java.lang.String r8 = r4.getSource()     // Catch:{ JSONException -> 0x0344 }
            r1.upload5800Ubc(r2, r3, r8, r5)     // Catch:{ JSONException -> 0x0344 }
            goto L_0x0345
        L_0x0344:
            r0 = move-exception
        L_0x0345:
            return
        L_0x0346:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.arrival.FlowArrivalPlugin.uploadArrivalStatistic():void");
    }

    /* access modifiers changed from: protected */
    public void addExtPageInfo(JSONObject pageInfo) {
        Intrinsics.checkNotNullParameter(pageInfo, SwanAppPageInfoHelper.PAGE_INFO_KEY);
    }

    /* access modifiers changed from: protected */
    public FlowItemArrivalModel getFirstFlowItemArrivalModel() {
        List list = FlowArrivalStatusCollector.Companion.getInstance().getItemArrivalModelList();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    private final String getCurrentTabId() {
        ITabComponentService iTabComponentService = (ITabComponentService) getManager().getService(ITabComponentService.class);
        return TabItemCreatorServiceKt.tabIdOrDefault(iTabComponentService != null ? iTabComponentService.getCurrentTabId() : null, getStore());
    }

    public void onDestroy() {
        super.onDestroy();
        ExcStatusManager.Companion.getInstance().clearFastFirstFrame();
    }
}
