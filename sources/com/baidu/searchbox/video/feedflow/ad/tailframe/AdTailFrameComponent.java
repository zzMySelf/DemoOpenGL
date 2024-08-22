package com.baidu.searchbox.video.feedflow.ad.tailframe;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.baidu.nadcore.tailframe.NadImageTailFrameModel;
import com.baidu.nadcore.tailframe.NadImageTailFrameView;
import com.baidu.searchbox.ad.util.MapUtils;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.model.TailFrame;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.video.component.autoplay.AutoPlayInterceptPriority;
import com.baidu.searchbox.video.component.autoplay.OnAutoPlayInterceptCallback;
import com.baidu.searchbox.video.component.autoplay.service.IAutoPlayInterceptorService;
import com.baidu.searchbox.video.component.autoplay.service.IAutoPlayService;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.ad.dazzle.NadDazzleVisibilityState;
import com.baidu.searchbox.video.feedflow.ad.detail.AdData;
import com.baidu.searchbox.video.feedflow.ad.detail.AdDataState;
import com.baidu.searchbox.video.feedflow.ad.ecommerce.AdECommercePopVisibilityState;
import com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState;
import com.baidu.searchbox.video.feedflow.ad.moveup.PanelType;
import com.baidu.searchbox.video.feedflow.ad.player.state.NadPlayerState;
import com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction;
import com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent$playerListener$2;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfigKt;
import com.baidu.searchbox.video.feedflow.detail.bottom.BottomBarReducerAdapterAction;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.service.ILongPressNewMenuPanelService;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.service.ILongPressMenuService;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u001fH\u0016J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0016J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0016J\b\u0010.\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0016J\b\u00100\u001a\u00020\u001fH\u0016J \u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0002J\u0018\u00105\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0002J:\u00106\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u0001092\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u00010;H\u0002J:\u0010<\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u0001092\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u00010;H\u0002J\b\u0010=\u001a\u00020\u001fH\u0002J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u00020\u001fH\u0002J\b\u0010F\u001a\u00020\u0016H\u0002J\b\u0010G\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020BH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/tailframe/AdTailFrameComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "Lcom/baidu/searchbox/video/component/autoplay/OnAutoPlayInterceptCallback;", "()V", "countDownRunnable", "Ljava/lang/Runnable;", "firstInit", "", "imageCountDownRunnable", "imageTailFrameView", "Lcom/baidu/nadcore/tailframe/NadImageTailFrameView;", "isDazzleVisibility", "isDislikeVisibility", "isECommerceVisibility", "isPanelVisibility", "playerListener", "com/baidu/searchbox/video/feedflow/ad/tailframe/AdTailFrameComponent$playerListener$2$1", "getPlayerListener", "()Lcom/baidu/searchbox/video/feedflow/ad/tailframe/AdTailFrameComponent$playerListener$2$1;", "playerListener$delegate", "Lkotlin/Lazy;", "repeatCount", "", "tailFrameContainer", "Lcom/baidu/searchbox/video/feedflow/ad/tailframe/NadTailFrameContainer;", "getTailFrameContainer", "()Lcom/baidu/searchbox/video/feedflow/ad/tailframe/NadTailFrameContainer;", "tailFrameContainer$delegate", "tailFrameView", "Lcom/baidu/searchbox/video/feedflow/ad/tailframe/FlowVideoAdTailFrameView;", "alphaShow", "", "consumeIntercept", "createView", "Landroid/view/View;", "fetchPriority", "Lcom/baidu/searchbox/video/component/autoplay/AutoPlayInterceptPriority;", "forbidAutoPlayNext", "initPlugin", "isAutoPlay", "isLandscapeWithCommentPanelShowing", "needIntercept", "needShowCountdownScrollUpText", "textShowTimeAutoPlay", "onAdClick", "onCreate", "onDestroy", "onPause", "onResume", "onUpdateProgress", "progress", "buffer", "max", "onUpdateProgressMs", "postCountDownRunnable", "countDownTime", "lottieUrl", "", "paramsMap", "", "postImageCountDownRunnable", "removeCountdown", "setSDKEnhance", "Lcom/baidu/nadcore/model/AdLpParams$EnhanceModel;", "enhance", "adDate", "Lcom/baidu/searchbox/video/feedflow/ad/detail/AdData;", "setTailVisible", "isLandscape", "showCountDown", "tailShowTime", "tryShowTailFrame", "updateImageTailFrame", "adData", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdTailFrameComponent.kt */
public final class AdTailFrameComponent extends LiveDataComponent implements OnAutoPlayInterceptCallback {
    private Runnable countDownRunnable;
    private boolean firstInit = true;
    private Runnable imageCountDownRunnable;
    /* access modifiers changed from: private */
    public NadImageTailFrameView imageTailFrameView;
    private boolean isDazzleVisibility;
    private boolean isDislikeVisibility;
    private boolean isECommerceVisibility;
    private boolean isPanelVisibility;
    private final Lazy playerListener$delegate = LazyKt.lazy(new AdTailFrameComponent$playerListener$2(this));
    /* access modifiers changed from: private */
    public int repeatCount;
    private final Lazy tailFrameContainer$delegate = LazyKt.lazy(new AdTailFrameComponent$tailFrameContainer$2(this));
    /* access modifiers changed from: private */
    public FlowVideoAdTailFrameView tailFrameView;

    private final NadTailFrameContainer getTailFrameContainer() {
        return (NadTailFrameContainer) this.tailFrameContainer$delegate.getValue();
    }

    private final AdTailFrameComponent$playerListener$2.AnonymousClass1 getPlayerListener() {
        return (AdTailFrameComponent$playerListener$2.AnonymousClass1) this.playerListener$delegate.getValue();
    }

    private final void postCountDownRunnable(boolean isAutoPlay, int countDownTime, String lottieUrl, Map<String, String> paramsMap) {
        String str;
        Integer intOrNull;
        int i2 = countDownTime;
        String str2 = lottieUrl;
        Map<String, String> map = paramsMap;
        FlowVideoAdTailFrameView flowVideoAdTailFrameView = this.tailFrameView;
        boolean z = true;
        int i3 = -1;
        if ((flowVideoAdTailFrameView != null && flowVideoAdTailFrameView.getVisibility() == 8) || i2 <= 0) {
            FlowVideoAdTailFrameView flowVideoAdTailFrameView2 = this.tailFrameView;
            if (flowVideoAdTailFrameView2 != null) {
                flowVideoAdTailFrameView2.setCountDownHint(-1);
            }
            FlowVideoAdTailFrameView flowVideoAdTailFrameView3 = this.tailFrameView;
            if (flowVideoAdTailFrameView3 != null) {
                flowVideoAdTailFrameView3.setScrollUpGuide("");
                return;
            }
            return;
        }
        Ref.IntRef showViewTime = new Ref.IntRef();
        showViewTime.element = i2;
        if (!(map == null || (str = map.get("countdownShowTimeAutoPlay")) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null)) {
            i3 = intOrNull.intValue();
        }
        int scrollTextShowTimeAutoPlay = i3;
        String scrollTextAutoPlay = map != null ? map.get("countdownShowTextAutoPlay") : null;
        Ref.BooleanRef needLoadLottie = new Ref.BooleanRef();
        if (str2 == null || !(!StringsKt.isBlank(str2))) {
            z = false;
        }
        needLoadLottie.element = z;
        if (!needLoadLottie.element) {
            boolean z2 = isAutoPlay;
        } else if (!needShowCountdownScrollUpText(isAutoPlay, scrollTextShowTimeAutoPlay)) {
            FlowVideoAdTailFrameView flowVideoAdTailFrameView4 = this.tailFrameView;
            if (flowVideoAdTailFrameView4 != null) {
                flowVideoAdTailFrameView4.loadCountDownLottieAnimation(str2);
            }
            needLoadLottie.element = false;
        }
        Ref.IntRef countDownTimer = new Ref.IntRef();
        countDownTimer.element = i2;
        Ref.IntRef textShowCountDownTimer = new Ref.IntRef();
        textShowCountDownTimer.element = scrollTextShowTimeAutoPlay;
        Ref.IntRef intRef = textShowCountDownTimer;
        Ref.IntRef intRef2 = countDownTimer;
        Ref.BooleanRef booleanRef = needLoadLottie;
        Runnable adTailFrameComponent$postCountDownRunnable$1 = new AdTailFrameComponent$postCountDownRunnable$1(this, isAutoPlay, scrollTextShowTimeAutoPlay, textShowCountDownTimer, lottieUrl, scrollTextAutoPlay, countDownTimer, showViewTime, needLoadLottie);
        this.countDownRunnable = adTailFrameComponent$postCountDownRunnable$1;
        FlowVideoAdTailFrameView flowVideoAdTailFrameView5 = this.tailFrameView;
        if (flowVideoAdTailFrameView5 != null) {
            flowVideoAdTailFrameView5.post(adTailFrameComponent$postCountDownRunnable$1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r0 = kotlin.text.StringsKt.toIntOrNull((r0 = r14.get("countdownShowTimeAutoPlay")));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void postImageCountDownRunnable(boolean r11, int r12, java.lang.String r13, java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
            r10 = this;
            com.baidu.nadcore.tailframe.NadImageTailFrameView r0 = r10.imageTailFrameView
            r1 = 0
            if (r0 == 0) goto L_0x000e
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 != r2) goto L_0x000e
            r1 = 1
        L_0x000e:
            if (r1 != 0) goto L_0x0052
            if (r12 > 0) goto L_0x0013
            goto L_0x0052
        L_0x0013:
            if (r14 == 0) goto L_0x002a
            java.lang.String r0 = "countdownShowTimeAutoPlay"
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x002a
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x002a
            int r0 = r0.intValue()
            goto L_0x002b
        L_0x002a:
            r0 = -1
        L_0x002b:
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            r7 = r1
            r7.element = r12
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            r8 = r1
            r8.element = r0
            com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent$postImageCountDownRunnable$1 r9 = new com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent$postImageCountDownRunnable$1
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r0
            r5 = r8
            r6 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.Runnable r9 = (java.lang.Runnable) r9
            r10.imageCountDownRunnable = r9
            com.baidu.nadcore.tailframe.NadImageTailFrameView r1 = r10.imageTailFrameView
            if (r1 == 0) goto L_0x0051
            r1.post(r9)
        L_0x0051:
            return
        L_0x0052:
            com.baidu.nadcore.tailframe.NadImageTailFrameView r0 = r10.imageTailFrameView
            if (r0 == 0) goto L_0x0059
            r0.hideScrollUpGuide()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.postImageCountDownRunnable(boolean, int, java.lang.String, java.util.Map):void");
    }

    /* access modifiers changed from: private */
    public final boolean needShowCountdownScrollUpText(boolean isAutoPlay, int textShowTimeAutoPlay) {
        return isAutoPlay && textShowTimeAutoPlay > -1;
    }

    public View createView() {
        Store $this$select$iv;
        MutableLiveData<AdData> data;
        AdData adData;
        FlowVideoAdTailFrameView tailFrame = this.tailFrameView;
        if (tailFrame == null) {
            tailFrame = new FlowVideoAdTailFrameView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        this.tailFrameView = tailFrame;
        FlowVideoAdTailFrameView $this$createView_u24lambda_u2d0 = tailFrame;
        $this$createView_u24lambda_u2d0.setVisibility(8);
        $this$createView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        tailFrame.registerActionListener(new AdTailFrameComponent$createView$2(this));
        tailFrame.setTagListActionListener(new AdTailFrameComponent$createView$3(this));
        if (AdRuntimeHolder.getViewOptimize().viewOptSwitch1() && ($this$select$iv = getStore()) != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(AdDataState.class);
            }
            AdDataState adDataState = (AdDataState) obj;
            if (!(adDataState == null || (data = adDataState.getData()) == null || (adData = data.getValue()) == null)) {
                tailFrame.update(adData, IVideoScreenInfoUtils.Impl.get().isScreenLand());
            }
        }
        NadImageTailFrameView imageTailFrame = this.imageTailFrameView;
        if (imageTailFrame == null) {
            imageTailFrame = new NadImageTailFrameView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        this.imageTailFrameView = imageTailFrame;
        NadImageTailFrameView $this$createView_u24lambda_u2d2 = imageTailFrame;
        $this$createView_u24lambda_u2d2.setVisibility(8);
        $this$createView_u24lambda_u2d2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageTailFrame.registerActionListener(new AdTailFrameComponent$createView$6(this));
        getTailFrameContainer().removeAllViews();
        getTailFrameContainer().addView(tailFrame);
        getTailFrameContainer().addView(imageTailFrame);
        getTailFrameContainer().setVisibility(8);
        return getTailFrameContainer();
    }

    public void initPlugin() {
        AdTailFrameState adTailFrameState;
        MutableLiveData<Boolean> dislikeHinder;
        AdTailFrameState adTailFrameState2;
        MutableLiveData<Unit> onAdClick;
        NadDazzleVisibilityState nadDazzleVisibilityState;
        MutableLiveData<Boolean> isVisible;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        FontSizeState fontSizeState;
        MutableLiveData<Unit> action;
        NadMoveUpState $this$initPlugin_u24lambda_u2d13;
        AdECommercePopVisibilityState adECommercePopVisibilityState;
        MutableLiveData<Boolean> isVisible2;
        AdTailFrameState $this$initPlugin_u24lambda_u2d10;
        AdDataState adDataState;
        MutableLiveData<AdData> data;
        super.initPlugin();
        Store<AbsState> store = getStore();
        if (!(store == null || (adDataState = (AdDataState) store.subscribe((Class<T>) AdDataState.class)) == null || (data = adDataState.getData()) == null)) {
            data.observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda0(this));
        }
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || ($this$initPlugin_u24lambda_u2d10 = (AdTailFrameState) store2.subscribe((Class<T>) AdTailFrameState.class)) == null)) {
            $this$initPlugin_u24lambda_u2d10.isVisible().observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda2(this));
            $this$initPlugin_u24lambda_u2d10.isLandscape().observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda3(this));
        }
        Store<AbsState> store3 = getStore();
        if (!(store3 == null || (adECommercePopVisibilityState = (AdECommercePopVisibilityState) store3.subscribe((Class<T>) AdECommercePopVisibilityState.class)) == null || (isVisible2 = adECommercePopVisibilityState.isVisible()) == null)) {
            isVisible2.observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda4(this));
        }
        Store<AbsState> store4 = getStore();
        if (!(store4 == null || ($this$initPlugin_u24lambda_u2d13 = (NadMoveUpState) store4.subscribe((Class<T>) NadMoveUpState.class)) == null)) {
            $this$initPlugin_u24lambda_u2d13.isStart().observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda5(this));
        }
        Store<AbsState> store5 = getStore();
        if (!(store5 == null || (fontSizeState = (FontSizeState) store5.subscribe((Class<T>) FontSizeState.class)) == null || (action = fontSizeState.getAction()) == null)) {
            action.observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda6(this));
        }
        Store<AbsState> store6 = getStore();
        if (!(store6 == null || (coreState = (CoreState) store6.subscribe((Class<T>) CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda7(this));
        }
        Store<AbsState> store7 = getStore();
        if (!(store7 == null || (nadDazzleVisibilityState = (NadDazzleVisibilityState) store7.subscribe((Class<T>) NadDazzleVisibilityState.class)) == null || (isVisible = nadDazzleVisibilityState.isVisible()) == null)) {
            isVisible.observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda8(this));
        }
        Store<AbsState> store8 = getStore();
        if (!(store8 == null || (adTailFrameState2 = (AdTailFrameState) store8.subscribe((Class<T>) AdTailFrameState.class)) == null || (onAdClick = adTailFrameState2.getOnAdClick()) == null)) {
            onAdClick.observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda9(this));
        }
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && (adTailFrameState = (AdTailFrameState) $this$subscribe$iv.subscribe(AdTailFrameState.class)) != null && (dislikeHinder = adTailFrameState.getDislikeHinder()) != null) {
            dislikeHinder.observe(this, new AdTailFrameComponent$$ExternalSyntheticLambda10(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-4  reason: not valid java name */
    public static final void m5729initPlugin$lambda4(AdTailFrameComponent this$0, AdData adData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isLandscape = IVideoScreenInfoUtils.Impl.get().isScreenLand();
        FlowVideoAdTailFrameView $this$initPlugin_u24lambda_u2d4_u24lambda_u2d3 = this$0.tailFrameView;
        if ($this$initPlugin_u24lambda_u2d4_u24lambda_u2d3 != null) {
            Intrinsics.checkNotNullExpressionValue(adData, "adData");
            $this$initPlugin_u24lambda_u2d4_u24lambda_u2d3.update(adData, isLandscape);
        }
        Intrinsics.checkNotNullExpressionValue(adData, "adData");
        this$0.updateImageTailFrame(adData);
        this$0.setTailVisible(isLandscape);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0099, code lost:
        r5 = r5.getCurItemModel();
     */
    /* renamed from: initPlugin$lambda-10$lambda-7  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5720initPlugin$lambda10$lambda7(com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent r9, java.lang.Boolean r10) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r9.getStore()
            if (r0 == 0) goto L_0x00f9
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x00f9
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r1 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r0
            if (r0 == 0) goto L_0x00f9
            androidx.lifecycle.MutableLiveData r0 = r0.getData()
            if (r0 == 0) goto L_0x00f9
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r0
            if (r0 == 0) goto L_0x00f9
            r1 = 0
            com.baidu.searchbox.video.feedflow.ad.tailframe.NadTailFrameContainer r2 = r9.getTailFrameContainer()
            r3 = 0
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r5)
            r6 = 0
            if (r5 == 0) goto L_0x0075
            r2.bringToFront()
            boolean r5 = r0.getForbidTailAnim()
            if (r5 == 0) goto L_0x004d
            r5 = 1065353216(0x3f800000, float:1.0)
            r2.setAlpha(r5)
            goto L_0x0073
        L_0x004d:
            com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils r5 = com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils.Impl.get()
            boolean r5 = r5.isScreenLand()
            com.baidu.searchbox.video.feedflow.ad.tailframe.FlowVideoAdTailFrameView r7 = r9.tailFrameView
            if (r7 == 0) goto L_0x005c
            r7.update(r0, r5)
        L_0x005c:
            r9.alphaShow()
            com.baidu.searchbox.video.feedflow.ad.tailframe.FlowVideoAdTailFrameView r7 = r9.tailFrameView
            if (r7 == 0) goto L_0x0066
            r7.beforeTailFrameVisible(r0)
        L_0x0066:
            r9.updateImageTailFrame(r0)
            com.baidu.nadcore.tailframe.NadImageTailFrameView r7 = r9.imageTailFrameView
            if (r7 == 0) goto L_0x0070
            r7.showClickBtnLottieDelay()
        L_0x0070:
            r9.setTailVisible(r5)
        L_0x0073:
            r5 = r6
            goto L_0x0085
        L_0x0075:
            com.baidu.searchbox.video.feedflow.ad.tailframe.FlowVideoAdTailFrameView r5 = r9.tailFrameView
            if (r5 == 0) goto L_0x007c
            r5.beforeTailFrameGone()
        L_0x007c:
            com.baidu.nadcore.tailframe.NadImageTailFrameView r5 = r9.imageTailFrameView
            if (r5 == 0) goto L_0x0083
            r5.hideClickBtnLottie()
        L_0x0083:
            r5 = 8
        L_0x0085:
            r2.setVisibility(r5)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r5 = r9.getManager()
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r8 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r5 = r5.getService(r8)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r5 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r5
            r7 = 0
            if (r5 == 0) goto L_0x00a4
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = r5.getCurItemModel()
            if (r5 == 0) goto L_0x00a4
            java.lang.Object r5 = r5.getData()
            goto L_0x00a5
        L_0x00a4:
            r5 = r7
        L_0x00a5:
            boolean r8 = r5 instanceof com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel
            if (r8 == 0) goto L_0x00ac
            com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r5 = (com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel) r5
            goto L_0x00ad
        L_0x00ac:
            r5 = r7
        L_0x00ad:
            if (r5 == 0) goto L_0x00b4
            com.baidu.searchbox.video.feedflow.ad.flow.AdRunTime r7 = r5.getRunTime()
        L_0x00b4:
            r5 = r7
            int r7 = r2.getVisibility()
            if (r7 != 0) goto L_0x00f6
            if (r5 == 0) goto L_0x00c5
            boolean r7 = r5.getHasExposedTailFrame()
            if (r7 != r4) goto L_0x00c5
            r7 = r4
            goto L_0x00c6
        L_0x00c5:
            r7 = r6
        L_0x00c6:
            if (r7 != 0) goto L_0x00f6
            com.baidu.nadcore.tailframe.NadImageTailFrameView r7 = r9.imageTailFrameView
            if (r7 == 0) goto L_0x00d3
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x00d3
            r6 = r4
        L_0x00d3:
            if (r6 == 0) goto L_0x00e3
            com.baidu.searchbox.feed.detail.frame.Store r6 = r9.getStore()
            if (r6 == 0) goto L_0x00f0
            com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction$ImageFirstShowAction r7 = com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction.ImageFirstShowAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r7 = (com.baidu.searchbox.feed.detail.frame.Action) r7
            r6.dispatch(r7)
            goto L_0x00f0
        L_0x00e3:
            com.baidu.searchbox.feed.detail.frame.Store r6 = r9.getStore()
            if (r6 == 0) goto L_0x00f0
            com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction$FirstShowAction r7 = com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction.FirstShowAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r7 = (com.baidu.searchbox.feed.detail.frame.Action) r7
            r6.dispatch(r7)
        L_0x00f0:
            if (r5 != 0) goto L_0x00f3
            goto L_0x00f6
        L_0x00f3:
            r5.setHasExposedTailFrame(r4)
        L_0x00f6:
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.m5720initPlugin$lambda10$lambda7(com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent, java.lang.Boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-10$lambda-9  reason: not valid java name */
    public static final void m5721initPlugin$lambda10$lambda9(AdTailFrameComponent this$0, Boolean isLandscape) {
        AbsState state;
        AdDataState adDataState;
        MutableLiveData<AdData> data;
        AdData adDate;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store<AbsState> store = this$0.getStore();
        if (store != null && (state = store.getState()) != null && (adDataState = (AdDataState) state.select(AdDataState.class)) != null && (data = adDataState.getData()) != null && (adDate = data.getValue()) != null) {
            FlowVideoAdTailFrameView flowVideoAdTailFrameView = this$0.tailFrameView;
            if (flowVideoAdTailFrameView != null) {
                Intrinsics.checkNotNullExpressionValue(isLandscape, "isLandscape");
                flowVideoAdTailFrameView.update(adDate, isLandscape.booleanValue());
            }
            this$0.repeatCount = 0;
            this$0.updateImageTailFrame(adDate);
            Intrinsics.checkNotNullExpressionValue(isLandscape, "isLandscape");
            this$0.setTailVisible(isLandscape.booleanValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-11  reason: not valid java name */
    public static final void m5722initPlugin$lambda11(AdTailFrameComponent this$0, Boolean visible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.firstInit) {
            this$0.isECommerceVisibility = false;
            this$0.firstInit = false;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        this$0.isECommerceVisibility = visible.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-13$lambda-12  reason: not valid java name */
    public static final void m5723initPlugin$lambda13$lambda12(AdTailFrameComponent this$0, PanelType isPanelShown) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isPanelVisibility = isPanelShown != PanelType.PANEL_HIDE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r1 = (r1 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) (r1 = r1.getState()).select(com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class)).getData();
     */
    /* renamed from: initPlugin$lambda-14  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5724initPlugin$lambda14(com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent r3, kotlin.Unit r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.baidu.searchbox.video.feedflow.ad.tailframe.FlowVideoAdTailFrameView r0 = r3.tailFrameView
            if (r0 == 0) goto L_0x0033
            com.baidu.searchbox.feed.detail.frame.Store r1 = r3.getStore()
            if (r1 == 0) goto L_0x002f
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x002f
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r2 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r1 = r1.select(r2)
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r1 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r1
            if (r1 == 0) goto L_0x002f
            androidx.lifecycle.MutableLiveData r1 = r1.getData()
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r1.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r1 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r1
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            r0.setFontSize(r1)
        L_0x0033:
            com.baidu.nadcore.tailframe.NadImageTailFrameView r0 = r3.imageTailFrameView
            if (r0 == 0) goto L_0x003f
            r1 = 0
            float r1 = com.baidu.searchbox.config.FontSizeHelper.getScaledRatio(r1)
            r0.setFontSize(r1)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.m5724initPlugin$lambda14(com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent, kotlin.Unit):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-15  reason: not valid java name */
    public static final void m5725initPlugin$lambda15(AdTailFrameComponent this$0, NestedAction it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it instanceof NestedAction.OnPageSelected) {
            this$0.repeatCount = 0;
            this$0.removeCountdown();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-16  reason: not valid java name */
    public static final void m5726initPlugin$lambda16(AdTailFrameComponent this$0, Boolean visible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        this$0.isDazzleVisibility = visible.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-17  reason: not valid java name */
    public static final void m5727initPlugin$lambda17(AdTailFrameComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onAdClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-18  reason: not valid java name */
    public static final void m5728initPlugin$lambda18(AdTailFrameComponent this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.isDislikeVisibility = it.booleanValue();
    }

    /* access modifiers changed from: private */
    public final void onUpdateProgressMs(int progress, int max) {
        if (progress > 0 && max > 0 && max >= progress && Math.abs(progress - max) <= 2000) {
            tryShowTailFrame();
        }
        if (Math.abs(progress - max) > 2000 && getTailFrameContainer().getVisibility() == 0) {
            getTailFrameContainer().setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r0 != null) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpdateProgress(int r7, int r8, int r9) {
        /*
            r6 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r6.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x003c
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0013
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 == 0) goto L_0x001d
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r4 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r3 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r3
            if (r3 == 0) goto L_0x003c
            androidx.lifecycle.MutableLiveData r0 = r3.getData()
            if (r0 == 0) goto L_0x003c
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r0
            if (r0 == 0) goto L_0x003c
            com.baidu.nadcore.tailframe.NadImageTailFrameModel r0 = r0.getImageTailFrame()
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r0.getImage()
            if (r0 != 0) goto L_0x003e
        L_0x003c:
            java.lang.String r0 = ""
        L_0x003e:
            com.baidu.searchbox.feed.detail.frame.Store r2 = r6.getStore()
            if (r2 == 0) goto L_0x0076
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r2.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0050
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0051
        L_0x0050:
            r4 = r1
        L_0x0051:
            if (r4 == 0) goto L_0x0059
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r1 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r1 = r4.select(r1)
        L_0x0059:
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r1 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r1
            if (r1 == 0) goto L_0x0076
            androidx.lifecycle.MutableLiveData r1 = r1.getData()
            if (r1 == 0) goto L_0x0076
            java.lang.Object r1 = r1.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r1 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r1
            if (r1 == 0) goto L_0x0076
            com.baidu.nadcore.tailframe.NadImageTailFrameModel r1 = r1.getImageTailFrame()
            if (r1 == 0) goto L_0x0076
            double r1 = r1.getImagePreloadTime()
            goto L_0x0078
        L_0x0076:
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x0078:
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x0095
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0095
            double r3 = (double) r7
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x0095
            com.baidu.nadcore.load.ILoadImage r3 = com.baidu.nadcore.load.AdLoadRuntime.image()
            r3.preloadImage(r0)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.onUpdateProgress(int, int, int):void");
    }

    /* access modifiers changed from: private */
    public final void tryShowTailFrame() {
        boolean needShowTail = true;
        this.repeatCount++;
        if (getTailFrameContainer().getVisibility() != 0 && !this.isECommerceVisibility && !this.isDazzleVisibility && !isLandscapeWithCommentPanelShowing() && !this.isPanelVisibility) {
            ILongPressMenuService iLongPressMenuService = (ILongPressMenuService) getManager().getService(ILongPressMenuService.class);
            if (!(iLongPressMenuService != null && iLongPressMenuService.isMenuShowing())) {
                ILongPressNewMenuPanelService iLongPressNewMenuPanelService = (ILongPressNewMenuPanelService) getManager().getService(ILongPressNewMenuPanelService.class);
                if (!(iLongPressNewMenuPanelService != null && iLongPressNewMenuPanelService.isMenuPanelShowing()) && !this.isDislikeVisibility) {
                    int tailShow = tailShowTime();
                    if (tailShow > 0) {
                        if (AdReduxExpManager.INSTANCE.useNewTailShowSwitch()) {
                            if (1 > tailShow || tailShow > this.repeatCount) {
                                needShowTail = false;
                            }
                        } else if (tailShow <= 0) {
                            needShowTail = false;
                        }
                        if (needShowTail) {
                            Store<AbsState> store = getStore();
                            if (store != null) {
                                StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateInputAlpha(0.0f));
                            }
                            Store<AbsState> store2 = getStore();
                            if (store2 != null) {
                                StoreExtKt.post(store2, new BottomBarReducerAdapterAction.UpdateBottomInteractAlpha(0.0f));
                            }
                            Store<AbsState> store3 = getStore();
                            if (store3 != null) {
                                store3.dispatch(AdTailFrameAction.ShowAction.INSTANCE);
                            }
                            showCountDown();
                        }
                    } else if (isAutoPlay() && !forbidAutoPlayNext()) {
                        Store<AbsState> store4 = getStore();
                        Object obj = null;
                        AbsState state = store4 != null ? store4.getState() : null;
                        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                        if (commonState == null || !commonState.isActive()) {
                            needShowTail = false;
                        }
                        if (needShowTail) {
                            Store $this$select$iv = getStore();
                            if ($this$select$iv != null) {
                                AbsState state2 = $this$select$iv.getState();
                                CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
                                if (commonState2 != null) {
                                    obj = commonState2.select(NadPlayerState.class);
                                }
                                NadPlayerState $this$tryShowTailFrame_u24lambda_u2d19 = (NadPlayerState) obj;
                                if ($this$tryShowTailFrame_u24lambda_u2d19 != null) {
                                    $this$tryShowTailFrame_u24lambda_u2d19.getStopAndClearProgress().setValue(Unit.INSTANCE);
                                }
                            }
                            IAutoPlayService iAutoPlayService = (IAutoPlayService) getManager().getService(IAutoPlayService.class);
                            if (iAutoPlayService != null) {
                                iAutoPlayService.playNext();
                            }
                        }
                    }
                }
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.addPlayerComponentListener(getPlayerListener());
        }
        IAutoPlayInterceptorService iAutoPlayInterceptorService = (IAutoPlayInterceptorService) getManager().getService(IAutoPlayInterceptorService.class);
        if (iAutoPlayInterceptorService != null) {
            iAutoPlayInterceptorService.addInterceptor(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.removePlayerComponentListener(getPlayerListener());
        }
        FlowVideoAdTailFrameView flowVideoAdTailFrameView = this.tailFrameView;
        if (flowVideoAdTailFrameView != null) {
            flowVideoAdTailFrameView.destroy();
        }
        NadImageTailFrameView nadImageTailFrameView = this.imageTailFrameView;
        if (nadImageTailFrameView != null) {
            nadImageTailFrameView.destroy();
        }
    }

    public AutoPlayInterceptPriority fetchPriority() {
        return AutoPlayInterceptPriority.Channel.Ad.INSTANCE;
    }

    public boolean needIntercept() {
        return false;
    }

    public boolean consumeIntercept() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = (r0 = (com.baidu.searchbox.video.component.comment.CommonCommentState) (r0 = r0.getState()).select(com.baidu.searchbox.video.component.comment.CommonCommentState.class)).getChangePanelVisible();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isLandscapeWithCommentPanelShowing() {
        /*
            r4 = this;
            com.baidu.searchbox.video.feedflow.ad.AdRedux r0 = com.baidu.searchbox.video.feedflow.ad.AdRedux.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Store r1 = r4.getStore()
            boolean r0 = r0.isLandscape((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState>) r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003d
            com.baidu.searchbox.feed.detail.frame.Store r0 = r4.getStore()
            if (r0 == 0) goto L_0x0039
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0039
            java.lang.Class<com.baidu.searchbox.video.component.comment.CommonCommentState> r3 = com.baidu.searchbox.video.component.comment.CommonCommentState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.component.comment.CommonCommentState r0 = (com.baidu.searchbox.video.component.comment.CommonCommentState) r0
            if (r0 == 0) goto L_0x0039
            androidx.lifecycle.MutableLiveData r0 = r0.getChangePanelVisible()
            if (r0 == 0) goto L_0x0039
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            goto L_0x003a
        L_0x0039:
            r0 = r2
        L_0x003a:
            if (r0 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = r2
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.isLandscapeWithCommentPanelShowing():boolean");
    }

    public void onResume() {
        super.onResume();
        if (getTailFrameContainer().getVisibility() == 0) {
            showCountDown();
        }
    }

    public void onPause() {
        super.onPause();
        removeCountdown();
    }

    private final void setTailVisible(boolean isLandscape) {
        MutableLiveData<AdData> data;
        AdData value;
        TailFrame tailFrame;
        if (isLandscape) {
            FlowVideoAdTailFrameView flowVideoAdTailFrameView = this.tailFrameView;
            if (flowVideoAdTailFrameView != null) {
                flowVideoAdTailFrameView.setVisibility(0);
            }
            NadImageTailFrameView nadImageTailFrameView = this.imageTailFrameView;
            if (nadImageTailFrameView != null) {
                nadImageTailFrameView.setVisibility(8);
                return;
            }
            return;
        }
        Store $this$select$iv = getStore();
        String str = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            AdDataState adDataState = (AdDataState) (commonState != null ? commonState.select(AdDataState.class) : null);
            if (!(adDataState == null || (data = adDataState.getData()) == null || (value = data.getValue()) == null || (tailFrame = value.getTailFrame()) == null)) {
                str = tailFrame.styleType;
            }
        }
        if (TextUtils.equals(str, "1")) {
            NadImageTailFrameView nadImageTailFrameView2 = this.imageTailFrameView;
            if (nadImageTailFrameView2 != null) {
                nadImageTailFrameView2.setVisibility(0);
            }
            FlowVideoAdTailFrameView flowVideoAdTailFrameView2 = this.tailFrameView;
            if (flowVideoAdTailFrameView2 != null) {
                flowVideoAdTailFrameView2.setVisibility(8);
                return;
            }
            return;
        }
        FlowVideoAdTailFrameView flowVideoAdTailFrameView3 = this.tailFrameView;
        if (flowVideoAdTailFrameView3 != null) {
            flowVideoAdTailFrameView3.setVisibility(0);
        }
        NadImageTailFrameView nadImageTailFrameView3 = this.imageTailFrameView;
        if (nadImageTailFrameView3 != null) {
            nadImageTailFrameView3.setVisibility(8);
        }
    }

    private final void showCountDown() {
        Store $this$select$iv;
        MutableLiveData<AdData> data;
        AdData value;
        TailFrame it;
        Store $this$select$iv2;
        MutableLiveData<AdData> data2;
        AdData value2;
        TailFrame it2;
        if (getTailFrameContainer().getVisibility() == 8) {
            FlowVideoAdTailFrameView flowVideoAdTailFrameView = this.tailFrameView;
            if (flowVideoAdTailFrameView != null) {
                flowVideoAdTailFrameView.setCountDownHint(-1);
            }
            FlowVideoAdTailFrameView flowVideoAdTailFrameView2 = this.tailFrameView;
            if (flowVideoAdTailFrameView2 != null) {
                flowVideoAdTailFrameView2.setScrollUpGuide("");
            }
            NadImageTailFrameView nadImageTailFrameView = this.imageTailFrameView;
            if (nadImageTailFrameView != null) {
                nadImageTailFrameView.hideScrollUpGuide();
                return;
            }
            return;
        }
        FlowVideoAdTailFrameView $this$showCountDown_u24lambda_u2d21 = this.tailFrameView;
        if (!($this$showCountDown_u24lambda_u2d21 == null || ($this$select$iv2 = getStore()) == null)) {
            AbsState state = $this$select$iv2.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            AdDataState adDataState = (AdDataState) (commonState != null ? commonState.select(AdDataState.class) : null);
            if (!(adDataState == null || (data2 = adDataState.getData()) == null || (value2 = data2.getValue()) == null || (it2 = value2.getTailFrame()) == null)) {
                Map paramsMap = new LinkedHashMap();
                MapUtils.put(paramsMap, "countdownShowTextAutoPlay", it2.countdownShowTextAutoPlay);
                MapUtils.put(paramsMap, "countdownShowTimeAutoPlay", String.valueOf(it2.countdownShowTimeAutoPlay));
                if (!isAutoPlay() || forbidAutoPlayNext()) {
                    if (it2.countdownTime >= 0) {
                        postCountDownRunnable(false, it2.countdownTime, (String) null, paramsMap);
                    } else {
                        $this$showCountDown_u24lambda_u2d21.setCountDownHint(-1);
                        $this$showCountDown_u24lambda_u2d21.setScrollUpGuide("");
                    }
                } else if (it2.countdownTimeAutoPlay >= 0) {
                    postCountDownRunnable(true, it2.countdownTimeAutoPlay, it2.countdownLottieUrl, paramsMap);
                } else {
                    $this$showCountDown_u24lambda_u2d21.setCountDownHint(-1);
                    $this$showCountDown_u24lambda_u2d21.setScrollUpGuide("");
                    IAutoPlayService iAutoPlayService = (IAutoPlayService) getManager().getService(IAutoPlayService.class);
                    if (iAutoPlayService != null) {
                        iAutoPlayService.playNext();
                    }
                }
            }
        }
        NadImageTailFrameView $this$showCountDown_u24lambda_u2d23 = this.imageTailFrameView;
        if ($this$showCountDown_u24lambda_u2d23 != null && ($this$select$iv = getStore()) != null) {
            AbsState state2 = $this$select$iv.getState();
            CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
            AdDataState adDataState2 = (AdDataState) (commonState2 != null ? commonState2.select(AdDataState.class) : null);
            if (adDataState2 != null && (data = adDataState2.getData()) != null && (value = data.getValue()) != null && (it = value.getTailFrame()) != null) {
                Map paramsMap2 = new LinkedHashMap();
                MapUtils.put(paramsMap2, "countdownShowTimeAutoPlay", String.valueOf(it.countdownShowTimeAutoPlay));
                if (!isAutoPlay() || forbidAutoPlayNext()) {
                    if (it.countdownTime >= 0) {
                        postImageCountDownRunnable(false, it.countdownTime, (String) null, paramsMap2);
                    } else {
                        $this$showCountDown_u24lambda_u2d23.hideScrollUpGuide();
                    }
                } else if (it.countdownTimeAutoPlay >= 0) {
                    postImageCountDownRunnable(true, it.countdownTimeAutoPlay, it.countdownLottieUrl, paramsMap2);
                } else {
                    $this$showCountDown_u24lambda_u2d23.hideScrollUpGuide();
                    IAutoPlayService iAutoPlayService2 = (IAutoPlayService) getManager().getService(IAutoPlayService.class);
                    if (iAutoPlayService2 != null) {
                        iAutoPlayService2.playNext();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void removeCountdown() {
        FlowVideoAdTailFrameView flowVideoAdTailFrameView = this.tailFrameView;
        if (flowVideoAdTailFrameView != null) {
            flowVideoAdTailFrameView.removeCallbacks(this.countDownRunnable);
        }
        FlowVideoAdTailFrameView flowVideoAdTailFrameView2 = this.tailFrameView;
        if (flowVideoAdTailFrameView2 != null) {
            flowVideoAdTailFrameView2.setCountDownHint(-1);
        }
        FlowVideoAdTailFrameView flowVideoAdTailFrameView3 = this.tailFrameView;
        if (flowVideoAdTailFrameView3 != null) {
            flowVideoAdTailFrameView3.setScrollUpGuide("");
        }
        NadImageTailFrameView nadImageTailFrameView = this.imageTailFrameView;
        if (nadImageTailFrameView != null) {
            nadImageTailFrameView.hideScrollUpGuide();
        }
        NadImageTailFrameView nadImageTailFrameView2 = this.imageTailFrameView;
        if (nadImageTailFrameView2 != null) {
            nadImageTailFrameView2.removeCallbacks(this.imageCountDownRunnable);
        }
    }

    private final void alphaShow() {
        ValueAnimator appearAnim = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(480);
        appearAnim.addUpdateListener(new AdTailFrameComponent$$ExternalSyntheticLambda1(this));
        getTailFrameContainer().setAlpha(0.0f);
        appearAnim.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: alphaShow$lambda-24  reason: not valid java name */
    public static final void m5719alphaShow$lambda24(AdTailFrameComponent this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            this$0.getTailFrameContainer().setAlpha(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean forbidAutoPlayNext() {
        /*
            r6 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r6.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0034
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r5 = 0
            if (r4 == 0) goto L_0x0014
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0015
        L_0x0014:
            r3 = r5
        L_0x0015:
            if (r3 == 0) goto L_0x001d
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r4 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r5 = r3.select(r4)
        L_0x001d:
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r5 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r5
            if (r5 == 0) goto L_0x0034
            androidx.lifecycle.MutableLiveData r0 = r5.getData()
            if (r0 == 0) goto L_0x0034
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r0
            if (r0 == 0) goto L_0x0034
            int r0 = r0.getForbidAutoPlayNext()
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            r2 = 1
            if (r0 != r2) goto L_0x0039
            r1 = r2
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.forbidAutoPlayNext():boolean");
    }

    private final boolean isAutoPlay() {
        return AutoplayConfigKt.findAutoplaySwitch((Store<?>) getStore());
    }

    private final int tailShowTime() {
        MutableLiveData<AdData> data;
        AdData value;
        MutableLiveData<AdData> data2;
        AdData value2;
        Object obj = null;
        if (!isAutoPlay() || forbidAutoPlayNext()) {
            Store $this$select$iv = getStore();
            if ($this$select$iv == null) {
                return 0;
            }
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(AdDataState.class);
            }
            AdDataState adDataState = (AdDataState) obj;
            if (adDataState == null || (data = adDataState.getData()) == null || (value = data.getValue()) == null) {
                return 0;
            }
            return value.getTailShow();
        }
        Store $this$select$iv2 = getStore();
        if ($this$select$iv2 == null) {
            return 0;
        }
        AbsState state2 = $this$select$iv2.getState();
        CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
        if (commonState2 != null) {
            obj = commonState2.select(AdDataState.class);
        }
        AdDataState adDataState2 = (AdDataState) obj;
        if (adDataState2 == null || (data2 = adDataState2.getData()) == null || (value2 = data2.getValue()) == null) {
            return 0;
        }
        return value2.getTailShowAutoPlay();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r0 = r0.getClickBtnLottieView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onAdClick() {
        /*
            r6 = this;
            com.baidu.searchbox.video.feedflow.ad.tailframe.FlowVideoAdTailFrameView r0 = r6.tailFrameView
            if (r0 == 0) goto L_0x0007
            r0.hideClickBtnLottie()
        L_0x0007:
            com.baidu.searchbox.video.feedflow.ad.tailframe.FlowVideoAdTailFrameView r0 = r6.tailFrameView
            r1 = 0
            if (r0 == 0) goto L_0x0017
            com.baidu.nadcore.guidelottie.view.NadGuideLottieView r0 = r0.getClickBtnLottieView()
            if (r0 == 0) goto L_0x0017
            java.lang.Object r0 = r0.getTag()
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            boolean r2 = r0 instanceof com.baidu.searchbox.feed.ad.model.NadClickBtnLottieModel
            if (r2 == 0) goto L_0x001f
            com.baidu.searchbox.feed.ad.model.NadClickBtnLottieModel r0 = (com.baidu.searchbox.feed.ad.model.NadClickBtnLottieModel) r0
            goto L_0x0020
        L_0x001f:
            r0 = r1
        L_0x0020:
            r2 = 0
            if (r0 != 0) goto L_0x0024
            goto L_0x0027
        L_0x0024:
            r0.setCanShow(r2)
        L_0x0027:
            com.baidu.nadcore.tailframe.NadImageTailFrameView r0 = r6.imageTailFrameView
            if (r0 == 0) goto L_0x002e
            r0.hideClickBtnLottie()
        L_0x002e:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r6.getStore()
            if (r0 == 0) goto L_0x006b
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0040
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0041
        L_0x0040:
            r4 = r1
        L_0x0041:
            if (r4 == 0) goto L_0x004a
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r5 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x004b
        L_0x004a:
            r4 = r1
        L_0x004b:
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r4 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r4
            if (r4 == 0) goto L_0x006b
            androidx.lifecycle.MutableLiveData r0 = r4.getData()
            if (r0 == 0) goto L_0x006b
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r0
            if (r0 == 0) goto L_0x006b
            com.baidu.nadcore.tailframe.NadImageTailFrameModel r0 = r0.getImageTailFrame()
            if (r0 == 0) goto L_0x006b
            com.baidu.nadcore.model.AdLpParams$EnhanceModel r0 = r0.getEnhance()
            if (r0 == 0) goto L_0x006b
            com.baidu.nadcore.model.AdLpParams$NadClickBtnLottieModel r1 = r0.buttonClickLottie
        L_0x006b:
            if (r1 != 0) goto L_0x006e
            goto L_0x0071
        L_0x006e:
            r1.setCanShow(r2)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.onAdClick():void");
    }

    private final void updateImageTailFrame(AdData adData) {
        NadImageTailFrameModel imageTailModel = adData.getImageTailFrame();
        if (imageTailModel != null) {
            setSDKEnhance(imageTailModel.getEnhance(), adData);
            NadImageTailFrameView nadImageTailFrameView = this.imageTailFrameView;
            if (nadImageTailFrameView != null) {
                nadImageTailFrameView.update(imageTailModel);
            }
            NadImageTailFrameView nadImageTailFrameView2 = this.imageTailFrameView;
            if (nadImageTailFrameView2 != null) {
                nadImageTailFrameView2.setFontSize(FontSizeHelper.getScaledRatio(0));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = r1.adDownload;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.nadcore.model.AdLpParams.EnhanceModel setSDKEnhance(com.baidu.nadcore.model.AdLpParams.EnhanceModel r10, com.baidu.searchbox.video.feedflow.ad.detail.AdData r11) {
        /*
            r9 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.baidu.searchbox.feed.ad.model.ExtData r1 = r11.getExtraData()
            r2 = 0
            if (r1 == 0) goto L_0x0013
            com.baidu.searchbox.ad.download.data.AdDownload r1 = r1.adDownload
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = r1.appName
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            java.lang.String r3 = "pkg_name"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r0, (java.lang.String) r3, r1)
            com.baidu.searchbox.feed.ad.model.ExtData r1 = r11.getExtraData()
            if (r1 == 0) goto L_0x0026
            com.baidu.searchbox.ad.download.data.AdDownload r1 = r1.adDownload
            if (r1 == 0) goto L_0x0026
            java.lang.String r1 = r1.key
            goto L_0x0027
        L_0x0026:
            r1 = r2
        L_0x0027:
            java.lang.String r3 = "key"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r0, (java.lang.String) r3, r1)
            com.baidu.searchbox.feed.ad.model.ExtData r1 = r11.getExtraData()
            if (r1 == 0) goto L_0x0039
            com.baidu.searchbox.ad.download.data.AdDownload r1 = r1.adDownload
            if (r1 == 0) goto L_0x0039
            java.lang.String r1 = r1.deferredCmd
            goto L_0x003a
        L_0x0039:
            r1 = r2
        L_0x003a:
            java.lang.String r3 = "deferred_cmd"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r0, (java.lang.String) r3, r1)
            com.baidu.searchbox.feed.ad.model.ExtData r1 = r11.getExtraData()
            if (r1 == 0) goto L_0x004c
            com.baidu.searchbox.ad.download.data.AdDownload r1 = r1.adDownload
            if (r1 == 0) goto L_0x004c
            java.lang.String r1 = r1.downloadUrl
            goto L_0x004d
        L_0x004c:
            r1 = r2
        L_0x004d:
            java.lang.String r3 = "download_url"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r0, (java.lang.String) r3, r1)
            com.baidu.searchbox.feed.ad.model.ExtData r1 = r11.getExtraData()
            if (r1 == 0) goto L_0x005f
            com.baidu.searchbox.ad.download.data.AdDownload r1 = r1.adDownload
            if (r1 == 0) goto L_0x005f
            java.lang.String r1 = r1.source
            goto L_0x0060
        L_0x005f:
            r1 = r2
        L_0x0060:
            java.lang.String r3 = "source"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r0, (java.lang.String) r3, r1)
            com.baidu.searchbox.feed.ad.model.ExtData r1 = r11.getExtraData()
            if (r1 == 0) goto L_0x0073
            com.baidu.searchbox.ad.download.data.AdDownload r1 = r1.adDownload
            if (r1 == 0) goto L_0x0073
            com.baidu.searchbox.ad.download.data.AdDownloadCopy r1 = r1.copy
            goto L_0x0074
        L_0x0073:
            r1 = r2
        L_0x0074:
            java.lang.String r3 = "copy"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r0, (java.lang.String) r3, r1)
            com.baidu.searchbox.feed.ad.model.ExtData r1 = r11.getExtraData()
            if (r1 == 0) goto L_0x0086
            com.baidu.searchbox.ad.download.data.AdDownload r1 = r1.adDownload
            if (r1 == 0) goto L_0x0086
            java.lang.String r1 = r1.startCmd
            goto L_0x0087
        L_0x0086:
            r1 = r2
        L_0x0087:
            java.lang.String r3 = "start_cmd"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r0, (java.lang.String) r3, r1)
            com.baidu.nadcore.model.AdDownloadInfo r1 = com.baidu.nadcore.model.AdDownloadInfo.createWithNewDataStruct(r0)
            r10.adDownload = r1
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r3 = "strict_mode"
            java.lang.String r4 = "0"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r3, r4)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x00ad
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x00ad
            java.lang.String r3 = r3.appIcon
            goto L_0x00ae
        L_0x00ad:
            r3 = r2
        L_0x00ae:
            java.lang.String r4 = "app_icon"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x00c0
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x00c0
            java.lang.String r3 = r3.appName
            goto L_0x00c1
        L_0x00c0:
            r3 = r2
        L_0x00c1:
            java.lang.String r4 = "app_name"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x00d3
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x00d3
            java.lang.String r3 = r3.developerName
            goto L_0x00d4
        L_0x00d3:
            r3 = r2
        L_0x00d4:
            java.lang.String r4 = "developer_name"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x00ea
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x00ea
            float r3 = r3.score
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00eb
        L_0x00ea:
            r3 = r2
        L_0x00eb:
            java.lang.String r4 = "score"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x00fd
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x00fd
            java.lang.String r3 = r3.version
            goto L_0x00fe
        L_0x00fd:
            r3 = r2
        L_0x00fe:
            java.lang.String r4 = "version"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x0111
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x0111
            java.lang.String r3 = r3.apkSize
            goto L_0x0112
        L_0x0111:
            r3 = r2
        L_0x0112:
            java.lang.String r4 = "apk_size"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x0124
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x0124
            java.lang.String r3 = r3.apkUrl
            goto L_0x0125
        L_0x0124:
            r3 = r2
        L_0x0125:
            java.lang.String r4 = "apk_url"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate r3 = r11.getOperate()
            if (r3 == 0) goto L_0x0137
            com.baidu.searchbox.feed.ad.model.AppInfoModel r3 = r3.appInfo
            if (r3 == 0) goto L_0x0137
            java.lang.String r3 = r3.desc
            goto L_0x0138
        L_0x0137:
            r3 = r2
        L_0x0138:
            java.lang.String r4 = "desc"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r3)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            com.baidu.searchbox.ad.model.FeedAdOperate r5 = r11.getOperate()
            if (r5 == 0) goto L_0x0153
            com.baidu.searchbox.feed.ad.model.AppInfoModel r5 = r5.appInfo
            if (r5 == 0) goto L_0x0153
            com.baidu.searchbox.feed.ad.model.AppInfoModel$Privacy r5 = r5.privacy
            if (r5 == 0) goto L_0x0153
            java.lang.String r5 = r5.desc
            goto L_0x0154
        L_0x0153:
            r5 = r2
        L_0x0154:
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r3, (java.lang.String) r4, r5)
            com.baidu.searchbox.ad.model.FeedAdOperate r5 = r11.getOperate()
            if (r5 == 0) goto L_0x0168
            com.baidu.searchbox.feed.ad.model.AppInfoModel r5 = r5.appInfo
            if (r5 == 0) goto L_0x0168
            com.baidu.searchbox.feed.ad.model.AppInfoModel$Privacy r5 = r5.privacy
            if (r5 == 0) goto L_0x0168
            java.lang.String r5 = r5.cmd
            goto L_0x0169
        L_0x0168:
            r5 = r2
        L_0x0169:
            java.lang.String r6 = "cmd"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r3, (java.lang.String) r6, r5)
            java.lang.String r5 = "privacy"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r5, r3)
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            com.baidu.searchbox.ad.model.FeedAdOperate r7 = r11.getOperate()
            if (r7 == 0) goto L_0x0189
            com.baidu.searchbox.feed.ad.model.AppInfoModel r7 = r7.appInfo
            if (r7 == 0) goto L_0x0189
            com.baidu.searchbox.feed.ad.model.AppInfoModel$Permission r7 = r7.permission
            if (r7 == 0) goto L_0x0189
            java.lang.String r7 = r7.desc
            goto L_0x018a
        L_0x0189:
            r7 = r2
        L_0x018a:
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r5, (java.lang.String) r4, r7)
            com.baidu.searchbox.ad.model.FeedAdOperate r7 = r11.getOperate()
            if (r7 == 0) goto L_0x019e
            com.baidu.searchbox.feed.ad.model.AppInfoModel r7 = r7.appInfo
            if (r7 == 0) goto L_0x019e
            com.baidu.searchbox.feed.ad.model.AppInfoModel$Permission r7 = r7.permission
            if (r7 == 0) goto L_0x019e
            java.lang.String r7 = r7.cmd
            goto L_0x019f
        L_0x019e:
            r7 = r2
        L_0x019f:
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r5, (java.lang.String) r6, r7)
            java.lang.String r7 = "permission"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r7, r5)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            com.baidu.searchbox.ad.model.FeedAdOperate r8 = r11.getOperate()
            if (r8 == 0) goto L_0x01bd
            com.baidu.searchbox.feed.ad.model.AppInfoModel r8 = r8.appInfo
            if (r8 == 0) goto L_0x01bd
            com.baidu.searchbox.feed.ad.model.AppInfoModel$Feature r8 = r8.feature
            if (r8 == 0) goto L_0x01bd
            java.lang.String r8 = r8.desc
            goto L_0x01be
        L_0x01bd:
            r8 = r2
        L_0x01be:
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r7, (java.lang.String) r4, r8)
            com.baidu.searchbox.ad.model.FeedAdOperate r4 = r11.getOperate()
            if (r4 == 0) goto L_0x01d2
            com.baidu.searchbox.feed.ad.model.AppInfoModel r4 = r4.appInfo
            if (r4 == 0) goto L_0x01d2
            com.baidu.searchbox.feed.ad.model.AppInfoModel$Feature r4 = r4.feature
            if (r4 == 0) goto L_0x01d2
            java.lang.String r4 = r4.cmd
            goto L_0x01d3
        L_0x01d2:
            r4 = r2
        L_0x01d3:
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r7, (java.lang.String) r6, r4)
            java.lang.String r4 = "feature"
            com.baidu.nadcore.safe.JSONUtils.put((org.json.JSONObject) r1, (java.lang.String) r4, r7)
            com.baidu.nadcore.model.AppInfoModel r4 = com.baidu.nadcore.model.AppInfoModel.create(r1)
            r10.appInfoModel = r4
            com.baidu.searchbox.feed.ad.model.AdLpParams$EnhanceModel r4 = r11.getEnhancement()
            if (r4 == 0) goto L_0x01ea
            int r4 = r4.type
            goto L_0x01eb
        L_0x01ea:
            r4 = 0
        L_0x01eb:
            r10.type = r4
            com.baidu.nadcore.model.AdLpParams$AlsModel r4 = r10.alsModel
            if (r4 == 0) goto L_0x0204
            r6 = 0
            com.baidu.searchbox.feed.ad.model.AdExt r8 = r11.getExtraInfo()
            if (r8 == 0) goto L_0x01fa
            java.lang.String r2 = r8.extraParams
        L_0x01fa:
            r4.extraParam = r2
            com.baidu.searchbox.feed.ad.Als$Page r2 = com.baidu.searchbox.feed.ad.Als.Page.IMMERSIVE_TAIL
            java.lang.String r2 = r2.value
            r4.daPage = r2
        L_0x0204:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameComponent.setSDKEnhance(com.baidu.nadcore.model.AdLpParams$EnhanceModel, com.baidu.searchbox.video.feedflow.ad.detail.AdData):com.baidu.nadcore.model.AdLpParams$EnhanceModel");
    }
}
