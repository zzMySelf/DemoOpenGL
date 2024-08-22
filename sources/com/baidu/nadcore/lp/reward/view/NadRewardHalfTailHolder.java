package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.nadcore.business.R;
import com.baidu.nadcore.eventbus.EventBusWrapper;
import com.baidu.nadcore.lp.reward.inerface.INadRewardTailFrame;
import com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime;
import com.baidu.nadcore.lp.reward.util.NadRewardRouteUtil;
import com.baidu.nadcore.model.AdModelCommon;
import com.baidu.nadcore.model.AdRewardVideoLpModel;
import com.baidu.nadcore.model.AdVideoInfo;
import com.baidu.nadcore.model.AdVideoTailFrame;
import com.baidu.nadcore.model.CmdPolicy;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.nadcore.webpanel.PanelPopupWindow;
import com.baidu.nadcore.webpanel.event.PanelPopupWindowEvent;
import com.baidu.nadcore.webpanel.model.NadWebPanelModel;
import com.baidu.nadcore.widget.AdImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ2\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\bH\u0002J\b\u00101\u001a\u00020'H\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020)H\u0002J\b\u00105\u001a\u00020)H\u0002J\b\u00106\u001a\u00020)H\u0002J\b\u00107\u001a\u00020)H\u0003J,\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020'2\b\b\u0002\u0010=\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020)H\u0014J\u0010\u0010?\u001a\u00020)2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010@\u001a\u00020)2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020)0BH\u0016J\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u0018H\u0016J\u0010\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020\u0018H\u0002J\b\u0010G\u001a\u00020)H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailHolder;", "Landroid/widget/FrameLayout;", "Lcom/baidu/nadcore/lp/reward/inerface/INadRewardTailFrame;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adModel", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "arrowView", "Lcom/baidu/nadcore/widget/AdImageView;", "getArrowView", "()Lcom/baidu/nadcore/widget/AdImageView;", "arrowView$delegate", "Lkotlin/Lazy;", "halfTailView", "Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "getHalfTailView", "()Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "halfTailView$delegate", "hasShowGuide", "", "lottieGuideView", "Lcom/airbnb/lottie/LottieAnimationView;", "getLottieGuideView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieGuideView$delegate", "lottieRunnable", "Ljava/lang/Runnable;", "mLoadStartTime", "", "panelPop", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "shouldCharge", "shouldChargeTask", "tailNineChargeModify", "", "doViewAlphaAnimation", "", "target", "Landroid/view/View;", "from", "", "to", "ms", "vis", "getLogTime", "getView", "Landroid/view/ViewGroup;", "initArrowView", "initGuideView", "initPanelPop", "initTailInfoView", "logAndCharge", "area", "logType", "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "ext1", "ext2", "onDetachedFromWindow", "setData", "setOnReplayClickListener", "callback", "Lkotlin/Function0;", "setVisibility", "isVisible", "showPanelPop", "autoPopup", "tryShowGuideLottie", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardHalfTailHolder.kt */
public final class NadRewardHalfTailHolder extends FrameLayout implements INadRewardTailFrame {
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    public AdRewardVideoLpModel adModel;
    private final Lazy arrowView$delegate;
    private final Lazy halfTailView$delegate;
    /* access modifiers changed from: private */
    public boolean hasShowGuide;
    private final Lazy lottieGuideView$delegate;
    private final Runnable lottieRunnable;
    private long mLoadStartTime;
    private PanelPopupWindow panelPop;
    /* access modifiers changed from: private */
    public boolean shouldCharge;
    private Runnable shouldChargeTask;
    /* access modifiers changed from: private */
    public String tailNineChargeModify;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NadRewardHalfTailHolder(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NadRewardHalfTailHolder(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NadRewardHalfTailHolder(Context context, AttributeSet attributeSet, int style) {
        super(context, attributeSet, style);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.lottieGuideView$delegate = LazyKt.lazy(new NadRewardHalfTailHolder$lottieGuideView$2(this));
        this.halfTailView$delegate = LazyKt.lazy(new NadRewardHalfTailHolder$halfTailView$2(this));
        this.arrowView$delegate = LazyKt.lazy(new NadRewardHalfTailHolder$arrowView$2(this));
        this.tailNineChargeModify = "0";
        this.lottieRunnable = new NadRewardHalfTailHolder$$ExternalSyntheticLambda4(this);
        this.shouldChargeTask = new NadRewardHalfTailHolder$$ExternalSyntheticLambda5(this);
        LayoutInflater.from(context).inflate(R.layout.nad_reward_half_tail_holder, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NadRewardHalfTailHolder(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* access modifiers changed from: private */
    public final LottieAnimationView getLottieGuideView() {
        Object value = this.lottieGuideView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lottieGuideView>(...)");
        return (LottieAnimationView) value;
    }

    private final NadRewardHalfTailView getHalfTailView() {
        Object value = this.halfTailView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-halfTailView>(...)");
        return (NadRewardHalfTailView) value;
    }

    /* access modifiers changed from: private */
    public final AdImageView getArrowView() {
        Object value = this.arrowView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-arrowView>(...)");
        return (AdImageView) value;
    }

    /* access modifiers changed from: private */
    /* renamed from: lottieRunnable$lambda-0  reason: not valid java name */
    public static final void m14112lottieRunnable$lambda0(NadRewardHalfTailHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLottieGuideView().cancelAnimation();
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldChargeTask$lambda-1  reason: not valid java name */
    public static final void m14114shouldChargeTask$lambda1(NadRewardHalfTailHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shouldCharge = true;
    }

    public void setData(AdRewardVideoLpModel adModel2) {
        Intrinsics.checkNotNullParameter(adModel2, "adModel");
        this.adModel = adModel2;
        initTailInfoView();
        initArrowView();
        initGuideView();
        initPanelPop();
        setOnClickListener(new NadRewardHalfTailHolder$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-2  reason: not valid java name */
    public static final void m14113setData$lambda2(NadRewardHalfTailHolder this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = ClogBuilder.Area.AD_BLANK.type;
        Intrinsics.checkNotNullExpressionValue(str, "AD_BLANK.type");
        logAndCharge$default(this$0, str, ClogBuilder.LogType.FREE_CLICK, (String) null, (String) null, 12, (Object) null);
    }

    private final void initArrowView() {
        getArrowView().setOnClickListener(new NadRewardHalfTailHolder$$ExternalSyntheticLambda0(this));
        getArrowView().setImageResource(R.drawable.nad_reward_up_arrow);
        getArrowView().bringToFront();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r0 = (r0 = r0.videoInfo).tailFrame;
     */
    /* renamed from: initArrowView$lambda-3  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m14111initArrowView$lambda3(com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder r8, android.view.View r9) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.baidu.nadcore.lp.reward.util.NadRewardRouteUtil r0 = com.baidu.nadcore.lp.reward.util.NadRewardRouteUtil.INSTANCE
            boolean r0 = r0.hitFormSwitch()
            if (r0 == 0) goto L_0x0028
            com.baidu.nadcore.model.AdRewardVideoLpModel r0 = r8.adModel
            if (r0 == 0) goto L_0x001f
            com.baidu.nadcore.model.AdVideoInfo r0 = r0.videoInfo
            if (r0 == 0) goto L_0x001f
            com.baidu.nadcore.model.AdVideoTailFrame r0 = r0.tailFrame
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = r0.getPanelScheme()
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            android.content.Context r1 = r8.getContext()
            com.baidu.nadcore.cmd.SchemeRouter.invoke(r0, r1)
            goto L_0x002c
        L_0x0028:
            r0 = 0
            r8.showPanelPop(r0)
        L_0x002c:
            com.baidu.nadcore.stats.request.ClogBuilder$Area r0 = com.baidu.nadcore.stats.request.ClogBuilder.Area.ARROW
            java.lang.String r2 = r0.type
            java.lang.String r0 = "ARROW.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            com.baidu.nadcore.stats.request.ClogBuilder$LogType r3 = com.baidu.nadcore.stats.request.ClogBuilder.LogType.CLICK
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r8
            logAndCharge$default(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder.m14111initArrowView$lambda3(com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder, android.view.View):void");
    }

    private final void initGuideView() {
        ViewGroup.LayoutParams layoutParams = getLottieGuideView().getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
            params.topMargin = (((DeviceUtils.ScreenInfo.getRealScreenHeight(getContext()) - DeviceUtils.ScreenInfo.getStatusBarHeight()) - DeviceUtils.ScreenInfo.dp2px(getContext(), 47.0f)) - DeviceUtils.ScreenInfo.dp2px(getContext(), 472.0f)) - DeviceUtils.ScreenInfo.dp2px(getContext(), 135.0f);
            getLottieGuideView().setLayoutParams(params);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    private final void initTailInfoView() {
        getHalfTailView().setVisibility(8);
        getHalfTailView().setData(this.adModel);
        getHalfTailView().setBackgroundResource(R.drawable.nad_reward_half_tail_bg);
        getHalfTailView().registerClickInterceptor(new NadRewardHalfTailHolder$initTailInfoView$1(this));
        getHalfTailView().setClickable(true);
        getHalfTailView().setOnTouchListener(new NadRewardHalfTailHolder$initTailInfoView$2(this));
    }

    private final void initPanelPop() {
        if (NadRewardRouteUtil.INSTANCE.hitFormSwitch()) {
            EventBusWrapper.getDefault().register(this, new NadRewardHalfTailHolder$initPanelPop$1(this, PanelPopupWindowEvent.class));
        }
    }

    /* access modifiers changed from: private */
    public final void showPanelPop(boolean autoPopup) {
        AdModelCommon adModelCommon;
        AdModelCommon adModelCommon2;
        AdModelCommon adModelCommon3;
        AdVideoInfo adVideoInfo;
        AdVideoTailFrame adVideoTailFrame;
        Handler handler;
        CmdPolicy cmdPolicy;
        boolean z = autoPopup;
        AdRewardVideoLpModel adRewardVideoLpModel = this.adModel;
        String str = null;
        CharSequence lpRealUrl = adRewardVideoLpModel != null ? adRewardVideoLpModel.getLpRealUrl() : null;
        if (lpRealUrl == null || lpRealUrl.length() == 0) {
            this.panelPop = null;
            return;
        }
        if (z && (handler = getHandler()) != null) {
            Runnable runnable = this.shouldChargeTask;
            AdRewardVideoLpModel adRewardVideoLpModel2 = this.adModel;
            handler.postDelayed(runnable, (adRewardVideoLpModel2 == null || (cmdPolicy = adRewardVideoLpModel2.getCmdPolicy()) == null) ? 0 : cmdPolicy.getNineSplitChargeDuration());
        }
        PanelPopupWindow panelPopupWindow = new PanelPopupWindow(getContext());
        PanelPopupWindow $this$showPanelPop_u24lambda_u2d5 = panelPopupWindow;
        AdRewardVideoLpModel adRewardVideoLpModel3 = this.adModel;
        String str2 = (adRewardVideoLpModel3 == null || (adVideoInfo = adRewardVideoLpModel3.videoInfo) == null || (adVideoTailFrame = adVideoInfo.tailFrame) == null) ? null : adVideoTailFrame.tailNineChargeModify;
        if (str2 == null) {
            str2 = "0";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "adModel?.videoInfo?.tail…ilNineChargeModify ?: \"0\"");
        }
        this.tailNineChargeModify = str2;
        $this$showPanelPop_u24lambda_u2d5.setPopUpWindowListener(new NadRewardHalfTailHolder$showPanelPop$1$1(this, z));
        double heightRadio = ((double) 1) - (((double) getResources().getDimension(NadRewardVideoLpRuntime.getUIProvider().getPanelPopTopMargin())) / ((double) DeviceUtils.ScreenInfo.getDisplayHeight(getContext())));
        AdRewardVideoLpModel adRewardVideoLpModel4 = this.adModel;
        String lpRealUrl2 = adRewardVideoLpModel4 != null ? adRewardVideoLpModel4.getLpRealUrl() : null;
        AdRewardVideoLpModel adRewardVideoLpModel5 = this.adModel;
        NadWebPanelModel nadWebPanelModel = new NadWebPanelModel(lpRealUrl2, heightRadio, 0, (adRewardVideoLpModel5 == null || (adModelCommon3 = adRewardVideoLpModel5.common) == null) ? null : adModelCommon3.extraParam);
        NadWebPanelModel $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4 = nadWebPanelModel;
        $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setRewardVideo(true);
        $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setPanelDismissControlByH5(false);
        $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setShowTopRightIcon(true);
        $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setShowDownArrow(!z);
        $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setForbidClosePanel(z);
        $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setForbidMoveFollowHand(z);
        $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setForbidMoveUpFollowHand(true);
        AdRewardVideoLpModel adRewardVideoLpModel6 = this.adModel;
        if (!TextUtils.isEmpty((adRewardVideoLpModel6 == null || (adModelCommon2 = adRewardVideoLpModel6.common) == null) ? null : adModelCommon2.preRenderScheme)) {
            AdRewardVideoLpModel adRewardVideoLpModel7 = this.adModel;
            if (!(adRewardVideoLpModel7 == null || (adModelCommon = adRewardVideoLpModel7.common) == null)) {
                str = adModelCommon.preRenderRefer;
            }
            $this$showPanelPop_u24lambda_u2d5_u24lambda_u2d4.setChargeUrl(str);
        }
        $this$showPanelPop_u24lambda_u2d5.setPanelData(nadWebPanelModel);
        $this$showPanelPop_u24lambda_u2d5.showPanelPopWindow();
        this.mLoadStartTime = System.currentTimeMillis();
        this.panelPop = panelPopupWindow;
        if (getLottieGuideView().isAnimating()) {
            getLottieGuideView().cancelAnimation();
        }
    }

    /* access modifiers changed from: private */
    public final String getLogTime() {
        return String.valueOf((System.currentTimeMillis() - this.mLoadStartTime) / 1000);
    }

    public void setVisibility(boolean isVisible) {
        setVisibility(isVisible ? 0 : 8);
        getArrowView().setVisibility(8);
        if (isVisible) {
            AdRewardVideoLpModel it = this.adModel;
            if (it != null) {
                getHalfTailView().setMoreButton(it);
            }
            getHalfTailView().setVisibility(0);
            Animation animation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            animation.setDuration(320);
            animation.setAnimationListener(new NadRewardHalfTailHolder$setVisibility$2(this));
            getHalfTailView().startAnimation(animation);
            return;
        }
        PanelPopupWindow panelPopupWindow = this.panelPop;
        if (panelPopupWindow != null) {
            panelPopupWindow.closePanelForReset();
        }
        getHalfTailView().setVisibility(8);
    }

    public ViewGroup getView() {
        return getHalfTailView();
    }

    public void setOnReplayClickListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getHalfTailView().setOnReplayClickListener(callback);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.lottieRunnable);
        getHalfTailView().release();
        EventBusWrapper.getDefault().unregister(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r0 = (r0 = r0.videoInfo).tailFrame;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tryShowGuideLottie() {
        /*
            r4 = this;
            boolean r0 = r4.hasShowGuide
            if (r0 != 0) goto L_0x0083
            com.baidu.nadcore.model.AdRewardVideoLpModel r0 = r4.adModel
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.baidu.nadcore.model.AdVideoInfo r0 = r0.videoInfo
            if (r0 == 0) goto L_0x0014
            com.baidu.nadcore.model.AdVideoTailFrame r0 = r0.tailFrame
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = r0.swipeUpLottie
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0024
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = r3
            goto L_0x0025
        L_0x0024:
            r0 = r2
        L_0x0025:
            if (r0 != 0) goto L_0x0083
            com.baidu.nadcore.model.AdRewardVideoLpModel r0 = r4.adModel
            if (r0 == 0) goto L_0x003e
            com.baidu.nadcore.model.AdVideoInfo r0 = r0.videoInfo
            if (r0 == 0) goto L_0x003e
            com.baidu.nadcore.model.AdVideoTailFrame r0 = r0.tailFrame
            if (r0 == 0) goto L_0x003e
            java.lang.Boolean r0 = r0.tailNineSplitScreen
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            goto L_0x003f
        L_0x003e:
            r0 = r3
        L_0x003f:
            if (r0 == 0) goto L_0x0042
            goto L_0x0083
        L_0x0042:
            com.baidu.nadcore.model.AdRewardVideoLpModel r0 = r4.adModel
            if (r0 == 0) goto L_0x0050
            com.baidu.nadcore.model.AdVideoInfo r0 = r0.videoInfo
            if (r0 == 0) goto L_0x0050
            com.baidu.nadcore.model.AdVideoTailFrame r0 = r0.tailFrame
            if (r0 == 0) goto L_0x0050
            java.lang.String r1 = r0.swipeUpLottie
        L_0x0050:
            r0 = r1
            android.content.Context r1 = r4.getContext()
            if (r0 == 0) goto L_0x005b
            int r3 = r0.hashCode()
        L_0x005b:
            java.lang.String r2 = java.lang.String.valueOf(r3)
            com.airbnb.lottie.LottieTask r1 = com.airbnb.lottie.LottieCompositionFactory.fromUrl(r1, r0, r2)
            com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$$ExternalSyntheticLambda2 r2 = new com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$$ExternalSyntheticLambda2
            r2.<init>(r4)
            com.airbnb.lottie.LottieTask r1 = r1.addListener(r2)
            com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$$ExternalSyntheticLambda3 r2 = new com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder$$ExternalSyntheticLambda3
            r2.<init>(r4)
            r1.addFailureListener(r2)
            com.airbnb.lottie.LottieAnimationView r1 = r4.getLottieGuideView()
            r1.playAnimation()
            java.lang.Runnable r1 = r4.lottieRunnable
            r2 = 4500(0x1194, double:2.2233E-320)
            r4.postDelayed(r1, r2)
            return
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder.tryShowGuideLottie():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: tryShowGuideLottie$lambda-7  reason: not valid java name */
    public static final void m14115tryShowGuideLottie$lambda7(NadRewardHalfTailHolder this$0, LottieComposition result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hasShowGuide = true;
        this$0.getLottieGuideView().bringToFront();
        this$0.getLottieGuideView().setComposition(result);
        this$0.doViewAlphaAnimation(this$0.getLottieGuideView(), 0.0f, 1.0f, 320, 0);
        this$0.getLottieGuideView().setRepeatCount(1);
        this$0.getLottieGuideView().addAnimatorListener(new NadRewardHalfTailHolder$tryShowGuideLottie$1$1(this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: tryShowGuideLottie$lambda-8  reason: not valid java name */
    public static final void m14116tryShowGuideLottie$lambda8(NadRewardHalfTailHolder this$0, Throwable it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLottieGuideView().setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void doViewAlphaAnimation(View target, float from, float to, long ms, int vis) {
        if (target != null) {
            View $this$doViewAlphaAnimation_u24lambda_u2d9 = target;
            $this$doViewAlphaAnimation_u24lambda_u2d9.setAlpha(from);
            $this$doViewAlphaAnimation_u24lambda_u2d9.setVisibility(0);
            Animation animation = new AlphaAnimation(from, to);
            animation.setDuration(ms);
            $this$doViewAlphaAnimation_u24lambda_u2d9.startAnimation(animation);
            animation.setAnimationListener(new NadRewardHalfTailHolder$doViewAlphaAnimation$1$1($this$doViewAlphaAnimation_u24lambda_u2d9, vis));
        }
    }

    static /* synthetic */ void logAndCharge$default(NadRewardHalfTailHolder nadRewardHalfTailHolder, String str, ClogBuilder.LogType logType, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        nadRewardHalfTailHolder.logAndCharge(str, logType, str2, str3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0021, code lost:
        r6 = r6.common;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void logAndCharge(java.lang.String r18, com.baidu.nadcore.stats.request.ClogBuilder.LogType r19, java.lang.String r20, java.lang.String r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            r3 = r21
            com.baidu.nadcore.stats.request.ClogBuilder r4 = new com.baidu.nadcore.stats.request.ClogBuilder
            r4.<init>()
            r5 = r18
            com.baidu.nadcore.stats.request.ClogBuilder r4 = r4.setArea((java.lang.String) r5)
            com.baidu.nadcore.stats.request.ClogBuilder r4 = r4.setType((com.baidu.nadcore.stats.request.ClogBuilder.LogType) r1)
            com.baidu.nadcore.stats.request.ClogBuilder$Page r6 = com.baidu.nadcore.stats.request.ClogBuilder.Page.WELFARETAIL
            com.baidu.nadcore.stats.request.ClogBuilder r4 = r4.setPage((com.baidu.nadcore.stats.request.ClogBuilder.Page) r6)
            com.baidu.nadcore.model.AdRewardVideoLpModel r6 = r0.adModel
            if (r6 == 0) goto L_0x0028
            com.baidu.nadcore.model.AdModelCommon r6 = r6.common
            if (r6 == 0) goto L_0x0028
            java.lang.String r6 = r6.extraParam
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            com.baidu.nadcore.stats.request.ClogBuilder r4 = r4.setExtraParam(r6)
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            r8 = 1
            if (r6 <= 0) goto L_0x003a
            r6 = r8
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            if (r6 == 0) goto L_0x0040
            r4.setExt1(r2)
        L_0x0040:
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x004b
            r6 = r8
            goto L_0x004c
        L_0x004b:
            r6 = 0
        L_0x004c:
            if (r6 == 0) goto L_0x0051
            r4.setExt2(r3)
        L_0x0051:
            r6 = r4
            com.baidu.nadcore.stats.request.IReqBody r6 = (com.baidu.nadcore.stats.request.IReqBody) r6
            com.baidu.nadcore.stats.Als.send(r6)
            com.baidu.nadcore.stats.request.ClogBuilder$LogType r6 = com.baidu.nadcore.stats.request.ClogBuilder.LogType.CLICK
            if (r1 != r6) goto L_0x00be
            com.baidu.nadcore.model.AdRewardVideoLpModel r6 = r0.adModel
            if (r6 == 0) goto L_0x00be
            java.util.List r6 = r6.monitorUrls
            if (r6 == 0) goto L_0x00be
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r9 = 0
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            r11 = r6
            r12 = 0
            java.util.Iterator r13 = r11.iterator()
        L_0x0073:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0099
            java.lang.Object r14 = r13.next()
            r15 = r14
            com.baidu.nadcore.model.MonitorUrl r15 = (com.baidu.nadcore.model.MonitorUrl) r15
            r16 = 0
            java.lang.String r7 = r15.clickUrl
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0091
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r7 = 0
            goto L_0x0092
        L_0x0091:
            r7 = r8
        L_0x0092:
            r7 = r7 ^ r8
            if (r7 == 0) goto L_0x0073
            r10.add(r14)
            goto L_0x0073
        L_0x0099:
            r7 = r10
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            r6 = r7
            r7 = 0
            java.util.Iterator r8 = r6.iterator()
        L_0x00a8:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00bd
            java.lang.Object r9 = r8.next()
            r10 = r9
            com.baidu.nadcore.model.MonitorUrl r10 = (com.baidu.nadcore.model.MonitorUrl) r10
            r11 = 0
            java.lang.String r12 = r10.clickUrl
            com.baidu.nadcore.stats.charge.ParallelCharge.charge((java.lang.String) r12)
            goto L_0x00a8
        L_0x00bd:
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder.logAndCharge(java.lang.String, com.baidu.nadcore.stats.request.ClogBuilder$LogType, java.lang.String, java.lang.String):void");
    }
}
