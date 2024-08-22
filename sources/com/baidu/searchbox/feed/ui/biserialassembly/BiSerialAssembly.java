package com.baidu.searchbox.feed.ui.biserialassembly;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.ui.biserialassembly.BiserialAssemblyConfig;
import com.baidu.searchbox.feed.ui.biserialassembly.event.BiSerialAssemblyVisibleEvent;
import com.baidu.searchbox.feed.ui.biserialassembly.interfase.IBiSerialItemClickListener;
import com.baidu.searchbox.feed.ui.biserialassembly.interfase.IBiSerialRefreshListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\rJ\u0006\u0010\u001d\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020!J\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssembly;", "", "builder", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssembly$BiSerialBuilder;", "(Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssembly$BiSerialBuilder;)V", "biSerialLayout", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyPageView;", "configBuilder", "dataManager", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialDataManager;", "statisticsHelper", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialStatisticsHelper;", "initBiSerialLayout", "", "showSpecialPage", "", "(Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialDataManager;Ljava/lang/Boolean;)V", "initComponent", "isCanBiSerialScrollUp", "loadBiSerialData", "notifyBiSerialVisible", "notifyDataSetChanged", "notifyNightChanged", "isNightMode", "notifyPullRefresh", "refreshSource", "", "notifySizeChanged", "onBiSerialInvisible", "onConfigurationChanged", "onDestroy", "onLinkageScroll", "dy", "", "onLinkageScrollFlow", "onPause", "onResume", "BiSerialBuilder", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialAssembly.kt */
public final class BiSerialAssembly {
    /* access modifiers changed from: private */
    public BiSerialAssemblyPageView biSerialLayout;
    private BiSerialBuilder configBuilder;
    private BiSerialDataManager dataManager;
    private BiSerialStatisticsHelper statisticsHelper = new BiSerialStatisticsHelper();

    public BiSerialAssembly(BiSerialBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.configBuilder = builder;
        initComponent();
    }

    private final void initComponent() {
        BiSerialDataManager biSerialDataManager = new BiSerialDataManager();
        this.dataManager = biSerialDataManager;
        loadBiSerialData(biSerialDataManager);
    }

    private final void loadBiSerialData(BiSerialDataManager dataManager2) {
        BiSerialBuilder biSerialBuilder = this.configBuilder;
        boolean z = true;
        if (biSerialBuilder == null || !biSerialBuilder.getShowSpecialPage()) {
            z = false;
        }
        if (z) {
            BiSerialBuilder biSerialBuilder2 = this.configBuilder;
            initBiSerialLayout(dataManager2, biSerialBuilder2 != null ? Boolean.valueOf(biSerialBuilder2.getShowSpecialPage()) : null);
        }
        BiSerialBuilder $this$loadBiSerialData_u24lambda_u2d1 = this.configBuilder;
        if ($this$loadBiSerialData_u24lambda_u2d1 != null) {
            JSONObject it = $this$loadBiSerialData_u24lambda_u2d1.getTalosLite();
            if (!(it == null || dataManager2 == null)) {
                dataManager2.setTalosLiteParams(it);
            }
            if (dataManager2 != null) {
                dataManager2.requestBiSerialData($this$loadBiSerialData_u24lambda_u2d1.getBiSerialNid(), $this$loadBiSerialData_u24lambda_u2d1.getBiSerialFrom(), true, new BiSerialAssembly$loadBiSerialData$1$2($this$loadBiSerialData_u24lambda_u2d1, this, dataManager2), $this$loadBiSerialData_u24lambda_u2d1.getRequestExtDataMap());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void initBiSerialLayout(BiSerialDataManager dataManager2, Boolean showSpecialPage) {
        IBiSerialInitCompleteListener initListener;
        BiSerialBuilder biSerialBuilder = this.configBuilder;
        if ((biSerialBuilder != null ? biSerialBuilder.getContextRef() : null) != null) {
            Bundle bundle = new Bundle();
            Bundle $this$initBiSerialLayout_u24lambda_u2d2 = bundle;
            $this$initBiSerialLayout_u24lambda_u2d2.putString("channelId", BiSerialAssemblyUtils.INSTANCE.getChannelId(dataManager2 != null ? Integer.valueOf(dataManager2.hashCode()) : null));
            BiSerialBuilder biSerialBuilder2 = this.configBuilder;
            Integer valueOf = biSerialBuilder2 != null ? Integer.valueOf(biSerialBuilder2.getBiSerialMargin()) : null;
            Intrinsics.checkNotNull(valueOf);
            $this$initBiSerialLayout_u24lambda_u2d2.putInt("biSerial_margin", valueOf.intValue());
            BiSerialBuilder $this$initBiSerialLayout_u24lambda_u2d5 = this.configBuilder;
            if ($this$initBiSerialLayout_u24lambda_u2d5 != null) {
                BiserialAssemblyConfig.Builder it = new BiserialAssemblyConfig.Builder();
                it.setHeaderView($this$initBiSerialLayout_u24lambda_u2d5.getHeaderView());
                it.setItemClickListener($this$initBiSerialLayout_u24lambda_u2d5.getItemClickListener());
                it.setNotifyCeilingScene($this$initBiSerialLayout_u24lambda_u2d5.isNotifyCeilingScene());
                it.setRefreshListener($this$initBiSerialLayout_u24lambda_u2d5.getRefreshListener());
                it.setForceNightModel($this$initBiSerialLayout_u24lambda_u2d5.isForceNightModel());
                it.setBiSerialChannelId($this$initBiSerialLayout_u24lambda_u2d5.getBiSerialChannelId());
                BiSerialAssemblyPageView biSerialAssemblyPageView = new BiSerialAssemblyPageView(it.build());
                BiSerialAssemblyPageView $this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4 = biSerialAssemblyPageView;
                Activity contextRef = $this$initBiSerialLayout_u24lambda_u2d5.getContextRef();
                Intrinsics.checkNotNull(contextRef);
                $this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.init(contextRef, (String) null, (String) null, bundle);
                $this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.onUserVisibleHint(true);
                $this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.onViewResume();
                $this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.setParams(this.statisticsHelper, $this$initBiSerialLayout_u24lambda_u2d5.getBiSerialFrom(), $this$initBiSerialLayout_u24lambda_u2d5.getRequestExtDataMap());
                BiSerialAssemblyMgrsKt.putInfoManager($this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.getFeedFlowContext(), dataManager2);
                if (!($this$initBiSerialLayout_u24lambda_u2d5.getInitListener() == null || (initListener = $this$initBiSerialLayout_u24lambda_u2d5.getInitListener()) == null)) {
                    initListener.biSerialInitComplete($this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.onCreateView($this$initBiSerialLayout_u24lambda_u2d5.getContextRef(), bundle));
                }
                if (Intrinsics.areEqual((Object) showSpecialPage, (Object) true)) {
                    $this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.showLoadingView();
                }
                if ($this$initBiSerialLayout_u24lambda_u2d5.isForceNightModel()) {
                    $this$initBiSerialLayout_u24lambda_u2d5_u24lambda_u2d4.notifyNightChanged(true);
                }
                this.biSerialLayout = biSerialAssemblyPageView;
            }
        }
    }

    public final void onResume() {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.onViewResume();
        }
    }

    public final void onPause() {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.onViewPause();
        }
    }

    public final void onDestroy() {
        BiSerialDataManager biSerialDataManager = this.dataManager;
        if (biSerialDataManager != null) {
            biSerialDataManager.clearDisplay();
        }
        BiSerialDataManager biSerialDataManager2 = this.dataManager;
        if (biSerialDataManager2 != null) {
            biSerialDataManager2.cancelAllRequest();
        }
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.onViewDestroy();
        }
    }

    public final void notifySizeChanged() {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.notifySizeChanged(0);
        }
    }

    public final void notifyNightChanged(boolean isNightMode) {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.notifyNightChanged(Boolean.valueOf(isNightMode));
        }
    }

    public final void onConfigurationChanged() {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.onConfigurationChanged();
        }
    }

    public final void notifyDataSetChanged() {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.notifyDataSetChanged();
        }
    }

    public final void notifyPullRefresh(String refreshSource) {
        Intrinsics.checkNotNullParameter(refreshSource, "refreshSource");
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.notifyPullRefresh(refreshSource);
        }
    }

    public final boolean isCanBiSerialScrollUp() {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            return biSerialAssemblyPageView.isCanBiSerialScrollUp();
        }
        return false;
    }

    public final void onLinkageScroll(int dy) {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.onScroll(dy);
        }
    }

    public final void onLinkageScrollFlow(int dy) {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.onScrollFlow(dy);
        }
    }

    public final void onBiSerialInvisible() {
        BiSerialAssemblyPageView biSerialAssemblyPageView = this.biSerialLayout;
        if (biSerialAssemblyPageView != null) {
            biSerialAssemblyPageView.inVisibleEvent();
        }
    }

    public final void notifyBiSerialVisible() {
        BdEventBus.Companion.getDefault().post(new BiSerialAssemblyVisibleEvent());
    }

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u0010K\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u000105J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0004J\u0010\u0010N\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010\u0016J\u000e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rJ\u0010\u0010R\u001a\u00020\u00002\b\u0010S\u001a\u0004\u0018\u00010\u0004J\u0010\u0010T\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010U\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010\"J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010,\u001a\u00020(J\u0010\u0010Y\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u001c\u0010[\u001a\u00020\u00002\u0014\b\u0002\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040;J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010?\u001a\u00020(J\u0010\u0010^\u001a\u00020\u00002\b\u0010_\u001a\u0004\u0018\u00010CR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R6\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040;2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040;@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u0010+R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006`"}, d2 = {"Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssembly$BiSerialBuilder;", "", "()V", "biSerialChannelId", "", "getBiSerialChannelId", "()Ljava/lang/String;", "setBiSerialChannelId", "(Ljava/lang/String;)V", "biSerialFrom", "getBiSerialFrom", "setBiSerialFrom", "biSerialMargin", "", "getBiSerialMargin", "()I", "setBiSerialMargin", "(I)V", "biSerialNid", "getBiSerialNid", "setBiSerialNid", "contextRef", "Landroid/app/Activity;", "getContextRef", "()Landroid/app/Activity;", "setContextRef", "(Landroid/app/Activity;)V", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "initListener", "Lcom/baidu/searchbox/feed/ui/biserialassembly/IBiSerialInitCompleteListener;", "getInitListener", "()Lcom/baidu/searchbox/feed/ui/biserialassembly/IBiSerialInitCompleteListener;", "setInitListener", "(Lcom/baidu/searchbox/feed/ui/biserialassembly/IBiSerialInitCompleteListener;)V", "isForceNightModel", "", "()Z", "setForceNightModel", "(Z)V", "isNotifyCeilingScene", "setNotifyCeilingScene", "itemClickListener", "Lcom/baidu/searchbox/feed/ui/biserialassembly/interfase/IBiSerialItemClickListener;", "getItemClickListener", "()Lcom/baidu/searchbox/feed/ui/biserialassembly/interfase/IBiSerialItemClickListener;", "setItemClickListener", "(Lcom/baidu/searchbox/feed/ui/biserialassembly/interfase/IBiSerialItemClickListener;)V", "refreshListener", "Lcom/baidu/searchbox/feed/ui/biserialassembly/interfase/IBiSerialRefreshListener;", "getRefreshListener", "()Lcom/baidu/searchbox/feed/ui/biserialassembly/interfase/IBiSerialRefreshListener;", "setRefreshListener", "(Lcom/baidu/searchbox/feed/ui/biserialassembly/interfase/IBiSerialRefreshListener;)V", "<set-?>", "", "requestExtDataMap", "getRequestExtDataMap", "()Ljava/util/Map;", "showSpecialPage", "getShowSpecialPage", "setShowSpecialPage", "talosLite", "Lorg/json/JSONObject;", "getTalosLite", "()Lorg/json/JSONObject;", "setTalosLite", "(Lorg/json/JSONObject;)V", "build", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssembly;", "setBiSerialAssemblyListener", "setBiSerialRefreshListener", "setChannelId", "channelId", "setContext", "activity", "setEdgeDistance", "edgeDistance", "setFrom", "from", "setHeadView", "setInitCompletedListener", "listener", "setIsForceNightModel", "setIsNotifyCeilingScene", "setNid", "nid", "setRequestExtData", "requestExtData", "setSpecialPage", "setTalosParams", "talos", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialAssembly.kt */
    public static final class BiSerialBuilder {
        private String biSerialChannelId = "";
        private String biSerialFrom = "";
        private int biSerialMargin;
        private String biSerialNid = "";
        private Activity contextRef;
        private View headerView;
        private IBiSerialInitCompleteListener initListener;
        private boolean isForceNightModel;
        private boolean isNotifyCeilingScene;
        private IBiSerialItemClickListener itemClickListener;
        private IBiSerialRefreshListener refreshListener;
        private Map<String, String> requestExtDataMap = MapsKt.emptyMap();
        private boolean showSpecialPage;
        private JSONObject talosLite;

        public final String getBiSerialChannelId() {
            return this.biSerialChannelId;
        }

        public final void setBiSerialChannelId(String str) {
            this.biSerialChannelId = str;
        }

        public final Activity getContextRef() {
            return this.contextRef;
        }

        public final void setContextRef(Activity activity) {
            this.contextRef = activity;
        }

        public final String getBiSerialFrom() {
            return this.biSerialFrom;
        }

        public final void setBiSerialFrom(String str) {
            this.biSerialFrom = str;
        }

        public final Map<String, String> getRequestExtDataMap() {
            return this.requestExtDataMap;
        }

        public final int getBiSerialMargin() {
            return this.biSerialMargin;
        }

        public final void setBiSerialMargin(int i2) {
            this.biSerialMargin = i2;
        }

        public final String getBiSerialNid() {
            return this.biSerialNid;
        }

        public final void setBiSerialNid(String str) {
            this.biSerialNid = str;
        }

        public final boolean getShowSpecialPage() {
            return this.showSpecialPage;
        }

        public final void setShowSpecialPage(boolean z) {
            this.showSpecialPage = z;
        }

        public final IBiSerialInitCompleteListener getInitListener() {
            return this.initListener;
        }

        public final void setInitListener(IBiSerialInitCompleteListener iBiSerialInitCompleteListener) {
            this.initListener = iBiSerialInitCompleteListener;
        }

        public final View getHeaderView() {
            return this.headerView;
        }

        public final void setHeaderView(View view2) {
            this.headerView = view2;
        }

        public final IBiSerialItemClickListener getItemClickListener() {
            return this.itemClickListener;
        }

        public final void setItemClickListener(IBiSerialItemClickListener iBiSerialItemClickListener) {
            this.itemClickListener = iBiSerialItemClickListener;
        }

        public final boolean isNotifyCeilingScene() {
            return this.isNotifyCeilingScene;
        }

        public final void setNotifyCeilingScene(boolean z) {
            this.isNotifyCeilingScene = z;
        }

        public final IBiSerialRefreshListener getRefreshListener() {
            return this.refreshListener;
        }

        public final void setRefreshListener(IBiSerialRefreshListener iBiSerialRefreshListener) {
            this.refreshListener = iBiSerialRefreshListener;
        }

        public final boolean isForceNightModel() {
            return this.isForceNightModel;
        }

        public final void setForceNightModel(boolean z) {
            this.isForceNightModel = z;
        }

        public final JSONObject getTalosLite() {
            return this.talosLite;
        }

        public final void setTalosLite(JSONObject jSONObject) {
            this.talosLite = jSONObject;
        }

        public final BiSerialBuilder setChannelId(String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.biSerialChannelId = channelId;
            return this;
        }

        public final BiSerialBuilder setContext(Activity activity) {
            this.contextRef = activity;
            return this;
        }

        public final BiSerialBuilder setFrom(String from) {
            this.biSerialFrom = from;
            return this;
        }

        public static /* synthetic */ BiSerialBuilder setRequestExtData$default(BiSerialBuilder biSerialBuilder, Map map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                map = MapsKt.emptyMap();
            }
            return biSerialBuilder.setRequestExtData(map);
        }

        public final BiSerialBuilder setRequestExtData(Map<String, String> requestExtData) {
            Intrinsics.checkNotNullParameter(requestExtData, "requestExtData");
            this.requestExtDataMap = requestExtData;
            return this;
        }

        public final BiSerialBuilder setEdgeDistance(int edgeDistance) {
            this.biSerialMargin = edgeDistance;
            return this;
        }

        public final BiSerialBuilder setNid(String nid) {
            this.biSerialNid = nid;
            return this;
        }

        public final BiSerialBuilder setSpecialPage(boolean showSpecialPage2) {
            this.showSpecialPage = showSpecialPage2;
            return this;
        }

        public final BiSerialBuilder setInitCompletedListener(IBiSerialInitCompleteListener listener) {
            this.initListener = listener;
            return this;
        }

        public final BiSerialBuilder setHeadView(View headerView2) {
            this.headerView = headerView2;
            return this;
        }

        public final BiSerialBuilder setBiSerialAssemblyListener(IBiSerialItemClickListener itemClickListener2) {
            this.itemClickListener = itemClickListener2;
            return this;
        }

        public final BiSerialBuilder setIsNotifyCeilingScene(boolean isNotifyCeilingScene2) {
            this.isNotifyCeilingScene = isNotifyCeilingScene2;
            return this;
        }

        public final BiSerialBuilder setBiSerialRefreshListener(IBiSerialRefreshListener refreshListener2) {
            this.refreshListener = refreshListener2;
            return this;
        }

        public final BiSerialBuilder setIsForceNightModel(boolean isForceNightModel2) {
            this.isForceNightModel = isForceNightModel2;
            return this;
        }

        public final BiSerialBuilder setTalosParams(JSONObject talos) {
            this.talosLite = talos;
            return this;
        }

        public final BiSerialAssembly build() {
            return new BiSerialAssembly(this);
        }
    }
}
