package com.baidu.searchbox.video.feedflow.detail.combopraise;

import android.app.Activity;
import android.view.MotionEvent;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig;
import com.baidu.searchbox.praise.runtime.IPraiseEffectInterface;
import com.baidu.searchbox.video.feedflow.detail.combopraise.service.ComboPraiseService;
import com.baidu.searchbox.video.feedflow.detail.combopraise.service.IComboPraiseService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/combopraise/ComboPraisePlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "config", "Lcom/baidu/searchbox/praise/praiseeffect/PraiseEffectConfig;", "isEnable", "", "isTouchStatus", "lastClickTime", "", "lastClickX", "", "lastClickY", "praiseEffectController", "Lcom/baidu/searchbox/praise/runtime/IPraiseEffectInterface;", "praiseHeight", "", "praiseWidth", "disableAnimation", "initPraise", "", "injectService", "isComboPraiseAnimationRunning", "isFastClick", "isFullScreen", "activity", "Landroid/app/Activity;", "onAttachToManager", "onCreate", "onPause", "performDoubleClickPraise", "event", "Landroid/view/MotionEvent;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComboPraisePlugin.kt */
public final class ComboPraisePlugin extends LiveDataPlugin {
    private PraiseEffectConfig config;
    private boolean isEnable = true;
    /* access modifiers changed from: private */
    public boolean isTouchStatus;
    private long lastClickTime;
    /* access modifiers changed from: private */
    public float lastClickX;
    /* access modifiers changed from: private */
    public float lastClickY;
    private IPraiseEffectInterface praiseEffectController;
    /* access modifiers changed from: private */
    public int praiseHeight;
    /* access modifiers changed from: private */
    public int praiseWidth;

    public void onAttachToManager() {
        ComboPraiseState $this$onAttachToManager_u24lambda_u2d5;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d5 = (ComboPraiseState) store.subscribe((Class<T>) ComboPraiseState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d5.getDoubleClickPraise().observe(this, new ComboPraisePlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d5.isEnable().observe(this, new ComboPraisePlugin$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d5.getCancelEffect().observe(this, new ComboPraisePlugin$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d5.getUpdatePraiseUBCParam().observe(this, new ComboPraisePlugin$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-0  reason: not valid java name */
    public static final void m11050onAttachToManager$lambda5$lambda0(ComboPraisePlugin this$0, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(event, "event");
        this$0.performDoubleClickPraise(event);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-1  reason: not valid java name */
    public static final void m11051onAttachToManager$lambda5$lambda1(ComboPraisePlugin this$0, Boolean isEnable2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isEnable2, "isEnable");
        this$0.isEnable = isEnable2.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-2  reason: not valid java name */
    public static final void m11052onAttachToManager$lambda5$lambda2(ComboPraisePlugin this$0, Unit it) {
        IPraiseEffectInterface iPraiseEffectInterface;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPraiseEffectInterface iPraiseEffectInterface2 = this$0.praiseEffectController;
        boolean z = true;
        if (iPraiseEffectInterface2 == null || !iPraiseEffectInterface2.isAnimPlaying()) {
            z = false;
        }
        if (z && (iPraiseEffectInterface = this$0.praiseEffectController) != null) {
            iPraiseEffectInterface.cancelPraiseEffect();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* renamed from: onAttachToManager$lambda-5$lambda-4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m11053onAttachToManager$lambda5$lambda4(com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraisePlugin r11, kotlin.Unit r12) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 0
            com.baidu.searchbox.feed.detail.frame.Store r1 = r11.getStore()
            r2 = 0
            if (r1 == 0) goto L_0x002e
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x001a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001b
        L_0x001a:
            r4 = r2
        L_0x001b:
            if (r4 == 0) goto L_0x0024
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState> r5 = com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0025
        L_0x0024:
            r4 = r2
        L_0x0025:
            com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState r4 = (com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState) r4
            if (r4 == 0) goto L_0x002e
            java.lang.String r1 = r4.getSource()
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            r0 = r1
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x003e
            int r1 = r1.length()
            if (r1 != 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r1 = 0
            goto L_0x003f
        L_0x003e:
            r1 = 1
        L_0x003f:
            if (r1 == 0) goto L_0x0046
            java.lang.String r1 = "merge_video_landing_double_click"
            r0 = r1
        L_0x0046:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r1 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r3 = r11.getStore()
            if (r3 == 0) goto L_0x006e
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x005a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x005b
        L_0x005a:
            r5 = r2
        L_0x005b:
            if (r5 == 0) goto L_0x0064
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r6 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0065
        L_0x0064:
            r5 = r2
        L_0x0065:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x006e
            java.lang.Object r3 = r5.getData()
            goto L_0x006f
        L_0x006e:
            r3 = r2
        L_0x006f:
            boolean r4 = r3 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r4 == 0) goto L_0x0076
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r3
            goto L_0x0077
        L_0x0076:
            r3 = r2
        L_0x0077:
            if (r3 == 0) goto L_0x007e
            java.lang.String r3 = r3.getVideoInfo()
            goto L_0x007f
        L_0x007e:
            r3 = r2
        L_0x007f:
            org.json.JSONObject r1 = r1.getVideoInfoExtLog(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "VideoFlowUBCHelper.getVi…              .toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig r3 = r11.config
            if (r3 != 0) goto L_0x0092
            goto L_0x00f6
        L_0x0092:
            com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC r4 = new com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC
            r4.<init>()
            r5 = r4
            r6 = 0
            r5.setUBCSource(r0)
            java.lang.String r7 = "double_press"
            r5.setType(r7)
            java.lang.String r7 = "resource_content"
            r5.setValue(r7)
            com.baidu.searchbox.feed.detail.frame.Store r7 = r11.getStore()
            if (r7 == 0) goto L_0x00c4
            com.baidu.searchbox.feed.detail.frame.State r7 = r7.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            if (r7 == 0) goto L_0x00c4
            java.lang.Class<com.baidu.searchbox.feed.detail.ext.common.UbcBean> r8 = com.baidu.searchbox.feed.detail.ext.common.UbcBean.class
            java.lang.Object r7 = r7.select(r8)
            com.baidu.searchbox.feed.detail.ext.common.UbcBean r7 = (com.baidu.searchbox.feed.detail.ext.common.UbcBean) r7
            if (r7 == 0) goto L_0x00c4
            java.lang.String r7 = r7.getPage()
            goto L_0x00c5
        L_0x00c4:
            r7 = r2
        L_0x00c5:
            r5.setPage(r7)
            com.baidu.searchbox.feed.detail.frame.Store r7 = r11.getStore()
            if (r7 == 0) goto L_0x00ed
            r8 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r7.getState()
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x00da
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9
            goto L_0x00db
        L_0x00da:
            r9 = r2
        L_0x00db:
            if (r9 == 0) goto L_0x00e4
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r10 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r9 = r9.select(r10)
            goto L_0x00e5
        L_0x00e4:
            r9 = r2
        L_0x00e5:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r9 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r9
            if (r9 == 0) goto L_0x00ed
            java.lang.String r2 = r9.getNid()
        L_0x00ed:
            r5.setNid(r2)
            r5.setStrategyInfo(r1)
            r3.ubc = r4
        L_0x00f6:
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r2 = r11.praiseEffectController
            if (r2 == 0) goto L_0x00ff
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig r3 = r11.config
            r2.updateConfig(r3)
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraisePlugin.m11053onAttachToManager$lambda5$lambda4(com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraisePlugin, kotlin.Unit):void");
    }

    public void onCreate() {
        super.onCreate();
        initPraise();
    }

    public void injectService() {
        getManager().registerServices(IComboPraiseService.class, new ComboPraiseService(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002c, code lost:
        r0 = (com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState) (r0 = r0.getState()).select(com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState.class);
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initPraise() {
        /*
            r8 = this;
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            r1 = 1103101952(0x41c00000, float:24.0)
            int r0 = r0.dp2px(r1)
            r8.praiseWidth = r0
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            int r0 = r0.dp2px(r1)
            r8.praiseHeight = r0
            com.baidu.searchbox.praise.praiseeffect.interfaces.PraiseEffectRuntime r0 = new com.baidu.searchbox.praise.praiseeffect.interfaces.PraiseEffectRuntime
            r0.<init>()
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r0 = r0.getPraiseEffect()
            r8.praiseEffectController = r0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x003b
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x003b
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState> r2 = com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState r0 = (com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseState) r0
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r0.getSource()
            goto L_0x003c
        L_0x003b:
            r0 = r1
        L_0x003c:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            if (r2 == 0) goto L_0x004b
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r2 = r3
            goto L_0x004c
        L_0x004b:
            r2 = 1
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            java.lang.String r0 = "merge_video_landing_double_click"
        L_0x0051:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r2 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            if (r4 == 0) goto L_0x0079
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0065
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0066
        L_0x0065:
            r6 = r1
        L_0x0066:
            if (r6 == 0) goto L_0x006f
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0070
        L_0x006f:
            r6 = r1
        L_0x0070:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r6 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r6
            if (r6 == 0) goto L_0x0079
            java.lang.Object r4 = r6.getData()
            goto L_0x007a
        L_0x0079:
            r4 = r1
        L_0x007a:
            boolean r5 = r4 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r5 == 0) goto L_0x0081
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r4
            goto L_0x0082
        L_0x0081:
            r4 = r1
        L_0x0082:
            if (r4 == 0) goto L_0x0089
            java.lang.String r4 = r4.getVideoInfo()
            goto L_0x008a
        L_0x0089:
            r4 = r1
        L_0x008a:
            org.json.JSONObject r2 = r2.getVideoInfoExtLog(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "VideoFlowUBCHelper\n     …l)?.videoInfo).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfigBuilder r4 = new com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfigBuilder
            r4.<init>()
            com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC r5 = new com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC
            java.lang.String r6 = ""
            r5.<init>(r0, r6, r2)
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfigBuilder r4 = r4.setUbc(r5)
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfigBuilder r3 = r4.setEnableFirstPraise(r3)
            java.lang.String r4 = "strong"
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfigBuilder r3 = r3.setEffectType(r4)
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            if (r4 == 0) goto L_0x00d8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x00c5
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x00c6
        L_0x00c5:
            r6 = r1
        L_0x00c6:
            if (r6 == 0) goto L_0x00cf
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x00d0
        L_0x00cf:
            r6 = r1
        L_0x00d0:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r6 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r6
            if (r6 == 0) goto L_0x00d8
            java.lang.String r1 = r6.getNid()
        L_0x00d8:
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfigBuilder r1 = r3.setPraiseId(r1)
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig r1 = r1.build()
            r8.config = r1
            if (r1 != 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            r3 = 10
            r1.vibrateTime = r3
        L_0x00e9:
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig r1 = r8.config
            if (r1 != 0) goto L_0x00ee
            goto L_0x00f1
        L_0x00ee:
            r3 = -1
            r1.vibrateAmplitude = r3
        L_0x00f1:
            android.content.Context r1 = r8.getContext()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0108
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r1 = r8.praiseEffectController
            if (r1 == 0) goto L_0x0108
            android.content.Context r3 = r8.getContext()
            android.app.Activity r3 = (android.app.Activity) r3
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig r4 = r8.config
            r1.initPraiseEffectController(r3, r4)
        L_0x0108:
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r1 = r8.praiseEffectController
            if (r1 == 0) goto L_0x0116
            com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraisePlugin$initPraise$1 r3 = new com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraisePlugin$initPraise$1
            r3.<init>(r8)
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectAnimCallback r3 = (com.baidu.searchbox.praise.praiseeffect.PraiseEffectAnimCallback) r3
            r1.setPraiseEffectAnimCallback(r3)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraisePlugin.initPraise():void");
    }

    private final boolean isFullScreen(Activity activity) {
        if (activity == null || (activity.getWindow().getAttributes().flags & 1024) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void performDoubleClickPraise(android.view.MotionEvent r11) {
        /*
            r10 = this;
            boolean r0 = r10.isEnable
            if (r0 == 0) goto L_0x01af
            com.baidu.searchbox.feed.detail.frame.Store r0 = r10.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0035
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0017
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0018
        L_0x0017:
            r3 = r1
        L_0x0018:
            if (r3 == 0) goto L_0x0021
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r4 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0022
        L_0x0021:
            r3 = r1
        L_0x0022:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r3 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r3
            if (r3 == 0) goto L_0x0035
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = r3.getData()
            if (r0 == 0) goto L_0x0035
            boolean r0 = r0.isAuditFailed()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0036
        L_0x0035:
            r0 = r1
        L_0x0036:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            if (r0 == 0) goto L_0x003e
            goto L_0x01af
        L_0x003e:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r10.getStore()
            if (r0 == 0) goto L_0x0069
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0069
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState> r2 = com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState r0 = (com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState) r0
            if (r0 == 0) goto L_0x0069
            androidx.lifecycle.MutableLiveData r0 = r0.getData()
            if (r0 == 0) goto L_0x0069
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel r0 = (com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel) r0
            if (r0 == 0) goto L_0x0069
            com.baidu.searchbox.video.feedflow.detail.praise.PraiseStyle r0 = r0.getPraiseStyle()
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            com.baidu.searchbox.feed.detail.frame.Store r2 = r10.getStore()
            if (r2 == 0) goto L_0x0095
            com.baidu.searchbox.feed.detail.frame.State r2 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r2 = (com.baidu.searchbox.feed.detail.frame.AbsState) r2
            if (r2 == 0) goto L_0x0095
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState> r3 = com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState.class
            java.lang.Object r2 = r2.select(r3)
            com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState r2 = (com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState) r2
            if (r2 == 0) goto L_0x0095
            androidx.lifecycle.MutableLiveData r2 = r2.getData()
            if (r2 == 0) goto L_0x0095
            java.lang.Object r2 = r2.getValue()
            com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel r2 = (com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel) r2
            if (r2 == 0) goto L_0x0095
            com.baidu.searchbox.video.feedflow.detail.praise.PraiseAnimationStyle r2 = r2.getPraiseAnimationStyle()
            goto L_0x0096
        L_0x0095:
            r2 = r1
        L_0x0096:
            com.baidu.searchbox.feed.detail.frame.Store r3 = r10.getStore()
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x00c0
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r3.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x00aa
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x00ab
        L_0x00aa:
            r7 = r1
        L_0x00ab:
            if (r7 == 0) goto L_0x00b4
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState> r8 = com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x00b5
        L_0x00b4:
            r7 = r1
        L_0x00b5:
            com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState r7 = (com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState) r7
            if (r7 == 0) goto L_0x00c0
            boolean r3 = r7.isFullScreen()
            if (r3 != r5) goto L_0x00c0
            r4 = r5
        L_0x00c0:
            r3 = r4
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig r4 = r10.config
            if (r4 == 0) goto L_0x011e
            r6 = 0
            if (r0 == 0) goto L_0x00cd
            java.lang.String r7 = r0.getAnimationType()
            goto L_0x00ce
        L_0x00cd:
            r7 = r1
        L_0x00ce:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r8 = "default"
            java.lang.String r9 = "strong"
            if (r7 != 0) goto L_0x00ec
            if (r0 == 0) goto L_0x00e2
            java.lang.String r7 = r0.getAnimationType()
            goto L_0x00e3
        L_0x00e2:
            r7 = r1
        L_0x00e3:
            r4.effectName = r7
            if (r3 == 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r8 = r9
        L_0x00e9:
            r4.effectType = r8
            goto L_0x011c
        L_0x00ec:
            if (r2 == 0) goto L_0x00f3
            java.lang.String r7 = r2.getContentAnimation()
            goto L_0x00f4
        L_0x00f3:
            r7 = r1
        L_0x00f4:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x010c
            if (r2 == 0) goto L_0x0103
            java.lang.String r7 = r2.getContentAnimation()
            goto L_0x0104
        L_0x0103:
            r7 = r1
        L_0x0104:
            r4.effectName = r7
            java.lang.String r7 = "strong_heart"
            r4.effectType = r7
            goto L_0x011c
        L_0x010c:
            if (r0 == 0) goto L_0x0113
            java.lang.String r7 = r0.getAnimationType()
            goto L_0x0114
        L_0x0113:
            r7 = r1
        L_0x0114:
            r4.effectName = r7
            if (r3 == 0) goto L_0x0119
            goto L_0x011a
        L_0x0119:
            r8 = r9
        L_0x011a:
            r4.effectType = r8
        L_0x011c:
        L_0x011e:
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r4 = r10.praiseEffectController
            if (r4 == 0) goto L_0x0127
            com.baidu.searchbox.praise.praiseeffect.PraiseEffectConfig r6 = r10.config
            r4.updateConfig(r6)
        L_0x0127:
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r4 = r10.praiseEffectController
            if (r4 == 0) goto L_0x012e
            r4.clearComboClickCounts()
        L_0x012e:
            java.lang.String r4 = "na_feed_video"
            boolean r4 = com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.isPraiseEnabled(r4)
            if (r4 == 0) goto L_0x01ae
            boolean r4 = r10.disableAnimation()
            if (r4 != 0) goto L_0x0173
            r6 = 0
            com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.vibrateStart$default(r6, r5, r1)
            float r4 = r11.getRawX()
            r10.lastClickX = r4
            float r4 = r11.getRawY()
            r10.lastClickY = r4
            if (r2 == 0) goto L_0x0155
            java.lang.String r4 = r2.getIconAnimation()
            goto L_0x0156
        L_0x0155:
            r4 = r1
        L_0x0156:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x016c
            boolean r4 = r10.isFastClick()
            if (r4 == 0) goto L_0x016c
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r4 = r10.praiseEffectController
            if (r4 == 0) goto L_0x0173
            r4.startAnimForComboClick()
            goto L_0x0173
        L_0x016c:
            com.baidu.searchbox.praise.runtime.IPraiseEffectInterface r4 = r10.praiseEffectController
            if (r4 == 0) goto L_0x0173
            r4.startAnim(r5)
        L_0x0173:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r10.getManager()
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r6 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r4 = r4.getService(r6)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r4 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r4
            if (r4 == 0) goto L_0x018b
            int r5 = r4.getDurationMs()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x018c
        L_0x018b:
            r5 = r1
        L_0x018c:
            int r5 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r5)
            if (r4 == 0) goto L_0x019a
            int r1 = r4.getCurProgressMs()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x019a:
            int r1 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r1)
            com.baidu.searchbox.feed.detail.frame.Store r6 = r10.getStore()
            if (r6 == 0) goto L_0x01ae
            com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseAction r7 = new com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseAction
            r7.<init>(r1, r5)
            com.baidu.searchbox.feed.detail.frame.Action r7 = (com.baidu.searchbox.feed.detail.frame.Action) r7
            r6.dispatch(r7)
        L_0x01ae:
            return
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraisePlugin.performDoubleClickPraise(android.view.MotionEvent):void");
    }

    public final boolean isFastClick() {
        long currentTime = System.currentTimeMillis();
        boolean isFastClick = Math.abs(currentTime - this.lastClickTime) < 500;
        this.lastClickTime = currentTime;
        return isFastClick;
    }

    /* access modifiers changed from: private */
    public final boolean disableAnimation() {
        AbsState state;
        ComboPraiseState comboPraiseState;
        Store<AbsState> store = getStore();
        if (store == null || (state = store.getState()) == null || (comboPraiseState = (ComboPraiseState) state.select(ComboPraiseState.class)) == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) comboPraiseState.getDisableAnimation(), (Object) true);
    }

    public final boolean isComboPraiseAnimationRunning() {
        IPraiseEffectInterface iPraiseEffectInterface = this.praiseEffectController;
        if (iPraiseEffectInterface != null) {
            return iPraiseEffectInterface.isAnimPlaying();
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(new HeartEffectCancelAction());
        }
    }
}
