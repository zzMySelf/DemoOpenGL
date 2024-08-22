package com.baidu.searchbox.video.feedflow.detail.autoplay;

import android.text.SpannableStringBuilder;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.player.model.TipsConfig;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayTipPlugin$playerListener$2;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.detail.toast.ShowTipAction;
import com.baidu.searchbox.video.feedflow.detail.toast.TipLocation;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.guidemanager.ProgressGuideShow;
import com.baidu.searchbox.video.feedflow.flow.list.FlowScrollMiddlewareKt;
import com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import com.baidu.searchbox.video.service.guidepriority.GuideType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0014J\b\u0010\u001d\u001a\u00020\nH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u001aH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/autoplay/AutoplayTipPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "diff", "", "getDiff", "()I", "setDiff", "(I)V", "intercept", "", "isLand", "isShow", "max", "playerListener", "com/baidu/searchbox/video/feedflow/detail/autoplay/AutoplayTipPlugin$playerListener$2$1", "getPlayerListener", "()Lcom/baidu/searchbox/video/feedflow/detail/autoplay/AutoplayTipPlugin$playerListener$2$1;", "playerListener$delegate", "Lkotlin/Lazy;", "getAutoplayNewTip", "getAutoplaySwitch", "getAutoplaySwitchShow", "getGuideText", "", "handleData", "", "isCanShow", "isHasShown", "needShowTip", "onAttachToManager", "onCreate", "onDestroy", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "onUpdateProgress", "progress", "registerGuide", "sendGuideTip", "sendTip", "showTip", "setAutoplaySwitch", "showGuideTip", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoPlayTipPlugin.kt */
public class AutoplayTipPlugin extends LiveDataPlugin {
    private int diff = Integer.MAX_VALUE;
    private boolean intercept;
    private boolean isLand;
    private boolean isShow;
    private int max = -1;
    private final Lazy playerListener$delegate = LazyKt.lazy(new AutoplayTipPlugin$playerListener$2(this));

    /* access modifiers changed from: protected */
    public final int getDiff() {
        return this.diff;
    }

    /* access modifiers changed from: protected */
    public final void setDiff(int i2) {
        this.diff = i2;
    }

    private final AutoplayTipPlugin$playerListener$2.AnonymousClass1 getPlayerListener() {
        return (AutoplayTipPlugin$playerListener$2.AnonymousClass1) this.playerListener$delegate.getValue();
    }

    public void onAttachToManager() {
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        AutoPlayTipState $this$onAttachToManager_u24lambda_u2d6;
        CoreState coreState2;
        MutableLiveData<NestedAction> nestedAction2;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (!(store == null || (coreState2 = (CoreState) store.subscribe((Class<T>) CoreState.class)) == null || (nestedAction2 = coreState2.getNestedAction()) == null)) {
            nestedAction2.observe(this, new AutoplayTipPlugin$$ExternalSyntheticLambda0(this));
        }
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || ($this$onAttachToManager_u24lambda_u2d6 = (AutoPlayTipState) store2.subscribe((Class<T>) AutoPlayTipState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d6.isLandscapeFlow().observe(this, new AutoplayTipPlugin$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d6.getIntercept().observe(this, new AutoplayTipPlugin$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d6.getRequestSuccess().observe(this, new AutoplayTipPlugin$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d6.getAutoGuideClick().observe(this, new AutoplayTipPlugin$$ExternalSyntheticLambda4(this));
        }
        Store<AbsState> store3 = getStore();
        if (store3 != null && (coreState = (CoreState) store3.subscribe((Class<T>) CoreState.class)) != null && (nestedAction = coreState.getNestedAction()) != null) {
            nestedAction.observe(this, new AutoplayTipPlugin$$ExternalSyntheticLambda5(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1  reason: not valid java name */
    public static final void m10658onAttachToManager$lambda1(AutoplayTipPlugin this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nestedAction != null) {
            this$0.onNestedAction(nestedAction);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-2  reason: not valid java name */
    public static final void m10659onAttachToManager$lambda6$lambda2(AutoplayTipPlugin this$0, Boolean style) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(style, "style");
        this$0.isLand = style.booleanValue();
        this$0.handleData();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-3  reason: not valid java name */
    public static final void m10660onAttachToManager$lambda6$lambda3(AutoplayTipPlugin this$0, Boolean intercept2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(intercept2, "intercept");
        this$0.intercept = intercept2.booleanValue();
        this$0.handleData();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-4  reason: not valid java name */
    public static final void m10661onAttachToManager$lambda6$lambda4(AutoplayTipPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleData();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-5  reason: not valid java name */
    public static final void m10662onAttachToManager$lambda6$lambda5(AutoplayTipPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store<AbsState> store = this$0.getStore();
        CommonState commonState = null;
        State state = store != null ? (AbsState) store.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        boolean z = true;
        if (commonState == null || !commonState.isActive()) {
            z = false;
        }
        if (z) {
            this$0.setAutoplaySwitch();
            Store<AbsState> store2 = this$0.getStore();
            if (store2 != null) {
                StoreExtKt.post(store2, OnAutoplaySwitchStateChanged.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8  reason: not valid java name */
    public static final void m10663onAttachToManager$lambda8(AutoplayTipPlugin this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nestedAction != null) {
            NestedAction nestedAction2 = nestedAction;
            if (nestedAction instanceof NestedAction.OnPageSelected) {
                this$0.registerGuide();
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.addPlayerComponentListener(getPlayerListener());
        }
    }

    /* access modifiers changed from: private */
    public final void onUpdateProgress(int progress, int max2) {
        this.max = max2;
        this.diff = max2 - progress;
        handleData();
    }

    private final void handleData() {
        int i2 = this.diff;
        if (i2 >= 0 && i2 < 11) {
            sendGuideTip();
        }
        int i3 = this.diff;
        if (!(i3 >= 0 && i3 < 6) || this.intercept) {
            sendTip(false);
        } else {
            sendTip(true);
        }
    }

    private final void sendTip(boolean showTip) {
        String title;
        boolean z = showTip;
        if ((!z || needShowTip()) && this.isLand && z != this.isShow && getAutoplaySwitch()) {
            boolean z2 = false;
            if (z) {
                IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
                if (iFlowComponentService == null || (title = iFlowComponentService.getNextTitle()) == null) {
                    title = "";
                }
                String next = getContext().getResources().getString(R.string.video_flow_autoplay_next);
                Intrinsics.checkNotNullExpressionValue(next, "context.resources.getStr…video_flow_autoplay_next)");
                if (title.length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    this.isShow = true;
                    TipsConfig tipsConfig = TipsConfig.Companion.obtainCommonTipConfig$default(TipsConfig.Companion, "autoplay", new SpannableStringBuilder(next + title), -1, 0, 0, false, 56, (Object) null);
                    Store<AbsState> store = getStore();
                    if (store != null) {
                        StoreExtKt.post(store, new OnShowAutoPlayTip(true, tipsConfig));
                        return;
                    }
                    return;
                }
                return;
            }
            this.isShow = false;
            TipsConfig tipsConfig2 = TipsConfig.Companion.obtainCommonTipConfig$default(TipsConfig.Companion, "autoplay", (SpannableStringBuilder) null, 0, 0, 0, false, 56, (Object) null);
            Store<AbsState> store2 = getStore();
            if (store2 != null) {
                StoreExtKt.post(store2, new OnShowAutoPlayTip(false, tipsConfig2));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean needShowTip() {
        /*
            r8 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0028
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0014
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0015
        L_0x0014:
            r4 = r1
        L_0x0015:
            if (r4 == 0) goto L_0x001e
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r5 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x001f
        L_0x001e:
            r4 = r1
        L_0x001f:
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r4 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r4
            if (r4 == 0) goto L_0x0028
            boolean r0 = r4.isInterceptContinuePlayNext()
            goto L_0x0029
        L_0x0028:
            r0 = r2
        L_0x0029:
            r3 = 1
            if (r0 != 0) goto L_0x007b
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r8.getManager()
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.ICollectionContinuePlayService> r6 = com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.ICollectionContinuePlayService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r4 = r4.getService(r6)
            com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.ICollectionContinuePlayService r4 = (com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.ICollectionContinuePlayService) r4
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = r4.getCollNextVid()
            if (r4 != 0) goto L_0x0043
        L_0x0041:
            java.lang.String r4 = ""
        L_0x0043:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x007b
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            if (r4 == 0) goto L_0x0076
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x005d
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x005e
        L_0x005d:
            r6 = r1
        L_0x005e:
            if (r6 == 0) goto L_0x0066
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessPlayState> r1 = com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessPlayState.class
            java.lang.Object r1 = r6.select(r1)
        L_0x0066:
            com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessPlayState r1 = (com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessPlayState) r1
            if (r1 == 0) goto L_0x0076
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            boolean r1 = r1.hasNext(r4)
            if (r1 != r3) goto L_0x0076
            r1 = r3
            goto L_0x0077
        L_0x0076:
            r1 = r2
        L_0x0077:
            if (r1 != 0) goto L_0x007b
            r2 = r3
            goto L_0x007c
        L_0x007b:
        L_0x007c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayTipPlugin.needShowTip():boolean");
    }

    private final void sendGuideTip() {
        Store<AbsState> store;
        if (isCanShow() && this.max >= 10 && needShowTip() && getAutoplayNewTip() && !getAutoplaySwitch() && getAutoplaySwitchShow() && !this.intercept && !DIFactory.INSTANCE.getConfig().getAutoplayGuideShow() && (store = getStore()) != null) {
            store.dispatch(new ProgressGuideShow(18));
        }
    }

    /* access modifiers changed from: private */
    public final void showGuideTip() {
        String guideText = getGuideText();
        String btn = DIFactory.INSTANCE.getAppContext().getResources().getString(R.string.video_flow_autoplay_guide_btn);
        Intrinsics.checkNotNullExpressionValue(btn, "DIFactory.getAppContext(…_flow_autoplay_guide_btn)");
        Store $this$select$iv = getStore();
        boolean z = false;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(PlayerOrientationState.class);
            }
            PlayerOrientationState playerOrientationState = (PlayerOrientationState) obj;
            if (playerOrientationState != null && playerOrientationState.isFullScreen()) {
                z = true;
            }
        }
        if (!z) {
            DIFactory.INSTANCE.getConfig().saveAutoplayGuideShow();
            Store<AbsState> store = getStore();
            if (store != null) {
                StoreExtKt.post(store, new ShowTipAction(guideText, btn, "autoplay", 5, 5000, (TipLocation) null, false, 96, (DefaultConstructorMarker) null));
            }
        } else if (!FlowScrollMiddlewareKt.isDisableLandscapeScrollScene(getStore())) {
            DIFactory.INSTANCE.getConfig().saveAutoplayGuideShow();
            TipsConfig config = TipsConfig.Companion.obtainTextBtnTipConfig("autoplay", new SpannableStringBuilder(guideText), btn, 5000);
            Store<AbsState> store2 = getStore();
            if (store2 != null) {
                StoreExtKt.post(store2, new OnShowAutoPlayTip(true, config));
            }
        }
        Store<AbsState> store3 = getStore();
        if (store3 != null) {
            StoreExtKt.post(store3, OnAutoPlayTipGuideShownAction.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isHasShown() {
        return true;
    }

    private final void registerGuide() {
        GuidePriorityService guidePriorityService = (GuidePriorityService) getManager().getService(GuidePriorityService.class);
        if (guidePriorityService != null) {
            GuidePriorityService.DefaultImpls.registerGuide$default(guidePriorityService, new AutoplayTipPlugin$registerGuide$1(this), new AutoplayTipPlugin$registerGuide$2(this), new AutoplayTipPlugin$registerGuide$3(this), 18, true, GuideType.NORMAL_FUNCTION, false, 64, (Object) null);
        }
    }

    private final boolean isCanShow() {
        GuidePriorityService guidePriorityService = (GuidePriorityService) getManager().getService(GuidePriorityService.class);
        if (guidePriorityService != null) {
            return GuidePriorityService.DefaultImpls.isCanShow$default(guidePriorityService, 18, (Function1) null, 2, (Object) null);
        }
        return false;
    }

    public boolean getAutoplaySwitch() {
        return AutoplayConfigKt.findAutoplaySwitch((Store<?>) getStore());
    }

    public boolean getAutoplaySwitchShow() {
        return true;
    }

    public void setAutoplaySwitch() {
        Store<AbsState> store = getStore();
        if (store != null) {
            AutoplayConfigKt.updateAutoplaySwitchValue((Store<?>) store, true);
        }
    }

    public boolean getAutoplayNewTip() {
        return DIFactory.INSTANCE.getConfig().getAutoplayNewTip();
    }

    public void onDestroy() {
        super.onDestroy();
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.removePlayerComponentListener(getPlayerListener());
        }
    }

    private final void onNestedAction(NestedAction nestedAction) {
        if (nestedAction instanceof NestedAction.OnDetachFromScreen) {
            sendTip(false);
            this.diff = Integer.MAX_VALUE;
        }
    }

    public String getGuideText() {
        if (!StringsKt.isBlank(DIFactory.INSTANCE.getConfig().getAutoplayGuideText())) {
            return DIFactory.INSTANCE.getConfig().getAutoplayGuideText();
        }
        String string = DIFactory.INSTANCE.getAppContext().getResources().getString(R.string.video_flow_autoplay_guide);
        Intrinsics.checkNotNullExpressionValue(string, "{\n            DIFactory.…autoplay_guide)\n        }");
        return string;
    }
}
