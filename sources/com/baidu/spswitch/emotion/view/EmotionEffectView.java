package com.baidu.spswitch.emotion.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.proxy.MediaPlayerProxy;
import com.baidu.searchbox.boxshare.BoxShareManager;
import com.baidu.searchbox.boxshare.bean.ShareContent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.bean.EmotionEffectConfig;
import com.baidu.spswitch.emotion.bean.SurpriseLoopConfig;
import com.baidu.spswitch.utils.EmotionEffectUtils;
import com.baidu.spswitch.utils.SPConfig;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001]B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010?\u001a\u00020@2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010BH\u0002J\b\u0010C\u001a\u00020@H\u0002J\b\u0010D\u001a\u00020@H\u0002J\b\u0010E\u001a\u00020@H\u0002J\b\u0010F\u001a\u00020@H\u0002J\u0012\u0010G\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010H\u001a\u00020@2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010I\u001a\u00020@H\u0002J\b\u0010J\u001a\u00020@H\u0002J\b\u0010K\u001a\u00020@H\u0002J\b\u0010L\u001a\u00020@H\u0002J\b\u0010M\u001a\u00020@H\u0002J\b\u0010N\u001a\u00020@H\u0002J\u0006\u0010O\u001a\u00020PJ\b\u0010Q\u001a\u00020@H\u0002J\b\u0010R\u001a\u00020@H\u0014J\u0012\u0010S\u001a\u00020P2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010V\u001a\u00020@H\u0002J\u0006\u0010W\u001a\u00020@J\b\u0010X\u001a\u00020@H\u0002J\u0006\u0010Y\u001a\u00020@J\u0010\u0010Z\u001a\u00020@2\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010[\u001a\u00020@H\u0002J\b\u0010\\\u001a\u00020@H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b+\u0010\u000eR\u001b\u0010-\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b2\u0010/R\u001b\u00104\u001a\u0002058BX\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b;\u0010<R\u0010\u0010>\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/baidu/spswitch/emotion/view/EmotionEffectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "effectConfig", "Lcom/baidu/spswitch/emotion/bean/EmotionEffectConfig;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/baidu/spswitch/emotion/bean/EmotionEffectConfig;)V", "alphaVideo", "Lcom/baidu/searchbox/afx/AlphaVideo;", "getAlphaVideo", "()Lcom/baidu/searchbox/afx/AlphaVideo;", "alphaVideo$delegate", "Lkotlin/Lazy;", "buttonArea", "Landroid/widget/LinearLayout;", "getButtonArea", "()Landroid/widget/LinearLayout;", "buttonArea$delegate", "closeArea", "Landroid/widget/ImageView;", "getCloseArea", "()Landroid/widget/ImageView;", "closeArea$delegate", "effectHeight", "effectResourceType", "", "getEffectResourceType$annotations", "()V", "effectView", "Landroid/widget/RelativeLayout;", "getEffectView", "()Landroid/widget/RelativeLayout;", "effectView$delegate", "entranceButton", "Landroid/view/View;", "listener", "Lcom/baidu/spswitch/emotion/view/EmotionEffectView$OnEmotionEffectListener;", "loopTimes", "loopVideo", "getLoopVideo", "loopVideo$delegate", "maskViewFirst", "getMaskViewFirst", "()Landroid/view/View;", "maskViewFirst$delegate", "maskViewSecond", "getMaskViewSecond", "maskViewSecond$delegate", "pagVideo", "Lorg/libpag/PAGView;", "getPagVideo", "()Lorg/libpag/PAGView;", "pagVideo$delegate", "retriever", "Landroid/media/MediaMetadataRetriever;", "getRetriever", "()Landroid/media/MediaMetadataRetriever;", "retriever$delegate", "shareButton", "addAlphaVideos", "", "path", "", "addBusinessButton", "addButtonAreaListener", "addCloseBtnListener", "addNormalButton", "addPagVideo", "addSingleAlphaVideo", "executeButtonAreaAnim", "executePosterShare", "initButtonArea", "initCloseArea", "initEffectView", "initMaskView", "isPlaying", "", "joinActivity", "onDetachedFromWindow", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "playAFX", "playEffect", "playPAG", "releaseRetriever", "setEffectListener", "updateButtonAreaLocation", "updateEffectContinueCloseTimes", "OnEmotionEffectListener", "emotion-keyboard_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmotionEffectView.kt */
public final class EmotionEffectView extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private final Lazy alphaVideo$delegate;
    private final Lazy buttonArea$delegate;
    private final Lazy closeArea$delegate;
    private final EmotionEffectConfig effectConfig;
    private int effectHeight;
    private String effectResourceType;
    private final Lazy effectView$delegate;
    private View entranceButton;
    /* access modifiers changed from: private */
    public OnEmotionEffectListener listener;
    /* access modifiers changed from: private */
    public int loopTimes;
    private final Lazy loopVideo$delegate;
    private final Lazy maskViewFirst$delegate;
    private final Lazy maskViewSecond$delegate;
    private final Lazy pagVideo$delegate;
    private final Lazy retriever$delegate;
    private View shareButton;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/baidu/spswitch/emotion/view/EmotionEffectView$OnEmotionEffectListener;", "", "closeClick", "", "entranceClick", "jumpWay", "", "onEnd", "isErr", "", "onStart", "shareClick", "emotion-keyboard_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EmotionEffectView.kt */
    public interface OnEmotionEffectListener {
        void closeClick();

        void entranceClick(String str);

        void onEnd(boolean z);

        void onStart();

        void shareClick();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmotionEffectView(Context context) {
        this(context, (AttributeSet) null, 0, (EmotionEffectConfig) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmotionEffectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, (EmotionEffectConfig) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmotionEffectView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (EmotionEffectConfig) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private static /* synthetic */ void getEffectResourceType$annotations() {
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
    public EmotionEffectView(Context context, AttributeSet attrs, int defStyleAttr, EmotionEffectConfig effectConfig2) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.effectConfig = effectConfig2;
        this.alphaVideo$delegate = LazyKt.lazy(new EmotionEffectView$alphaVideo$2(context));
        this.loopVideo$delegate = LazyKt.lazy(new EmotionEffectView$loopVideo$2(context));
        this.pagVideo$delegate = LazyKt.lazy(new EmotionEffectView$pagVideo$2(context));
        this.retriever$delegate = LazyKt.lazy(EmotionEffectView$retriever$2.INSTANCE);
        this.maskViewFirst$delegate = LazyKt.lazy(new EmotionEffectView$maskViewFirst$2(this));
        this.maskViewSecond$delegate = LazyKt.lazy(new EmotionEffectView$maskViewSecond$2(this));
        this.effectView$delegate = LazyKt.lazy(new EmotionEffectView$effectView$2(this));
        this.buttonArea$delegate = LazyKt.lazy(new EmotionEffectView$buttonArea$2(this));
        this.closeArea$delegate = LazyKt.lazy(new EmotionEffectView$closeArea$2(this));
        this.effectResourceType = ".pag";
        LayoutInflater.from(context).inflate(R.layout.emotion_effect_layout, this, true);
        initMaskView();
        initEffectView();
        initButtonArea();
        initCloseArea();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmotionEffectView(Context context, AttributeSet attributeSet, int i2, EmotionEffectConfig emotionEffectConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : emotionEffectConfig);
    }

    private final AlphaVideo getAlphaVideo() {
        return (AlphaVideo) this.alphaVideo$delegate.getValue();
    }

    private final AlphaVideo getLoopVideo() {
        return (AlphaVideo) this.loopVideo$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PAGView getPagVideo() {
        return (PAGView) this.pagVideo$delegate.getValue();
    }

    private final MediaMetadataRetriever getRetriever() {
        return (MediaMetadataRetriever) this.retriever$delegate.getValue();
    }

    private final View getMaskViewFirst() {
        Object value = this.maskViewFirst$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-maskViewFirst>(...)");
        return (View) value;
    }

    private final View getMaskViewSecond() {
        Object value = this.maskViewSecond$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-maskViewSecond>(...)");
        return (View) value;
    }

    private final RelativeLayout getEffectView() {
        Object value = this.effectView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-effectView>(...)");
        return (RelativeLayout) value;
    }

    private final LinearLayout getButtonArea() {
        Object value = this.buttonArea$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-buttonArea>(...)");
        return (LinearLayout) value;
    }

    private final ImageView getCloseArea() {
        Object value = this.closeArea$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-closeArea>(...)");
        return (ImageView) value;
    }

    private final void initMaskView() {
        String it;
        if (EmotionEffectUtils.INSTANCE.getEffectLoopTimes(this.effectConfig) > 1) {
            View $this$initMaskView_u24lambda_u2d0 = getMaskViewFirst();
            $this$initMaskView_u24lambda_u2d0.setVisibility(0);
            $this$initMaskView_u24lambda_u2d0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            $this$initMaskView_u24lambda_u2d0.setBackgroundColor(ContextCompat.getColor(AppRuntime.getAppContext(), R.color.emotion_Effect_background));
            EmotionEffectConfig emotionEffectConfig = this.effectConfig;
            if (emotionEffectConfig != null && (it = emotionEffectConfig.backgroundPicPath) != null) {
                View $this$initMaskView_u24lambda_u2d2_u24lambda_u2d1 = getMaskViewSecond();
                $this$initMaskView_u24lambda_u2d2_u24lambda_u2d1.setVisibility(0);
                $this$initMaskView_u24lambda_u2d2_u24lambda_u2d1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                $this$initMaskView_u24lambda_u2d2_u24lambda_u2d1.setBackground(Drawable.createFromPath(it));
            }
        }
    }

    private final void initButtonArea() {
        if (EmotionEffectUtils.INSTANCE.isBusinessEffect(this.effectConfig)) {
            addBusinessButton();
        } else if (EmotionEffectUtils.INSTANCE.isNormalShareEffect(this.effectConfig)) {
            addNormalButton();
        } else {
            setFocusable(false);
            setClickable(false);
        }
    }

    private final void addNormalButton() {
        updateButtonAreaLocation();
        View view2 = new View(getContext());
        View $this$addNormalButton_u24lambda_u2d3 = view2;
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        $this$addNormalButton_u24lambda_u2d3.setBackground(Drawable.createFromPath(emotionEffectConfig != null ? emotionEffectConfig.normalShareBtnPath : null));
        this.shareButton = view2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (ViewExtensionsKt.getDimension(this, R.dimen.effect_normal_button_width) * 0.87f), (int) (ViewExtensionsKt.getDimension(this, R.dimen.effect_button_height) * 0.87f));
        View view3 = this.shareButton;
        if (view3 != null) {
            view3.setLayoutParams(layoutParams);
        }
        LinearLayout $this$addNormalButton_u24lambda_u2d4 = getButtonArea();
        $this$addNormalButton_u24lambda_u2d4.bringToFront();
        $this$addNormalButton_u24lambda_u2d4.addView(this.shareButton);
    }

    private final void executePosterShare() {
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        String shareTalosLiteData = emotionEffectConfig != null ? emotionEffectConfig.shareTalosLiteData : null;
        CharSequence charSequence = shareTalosLiteData;
        if (!(charSequence == null || charSequence.length() == 0)) {
            ShareContent.Builder posterTalosData = new ShareContent.Builder().setShareType(3).setPosterTalosData(shareTalosLiteData);
            EmotionEffectConfig emotionEffectConfig2 = this.effectConfig;
            ShareContent shareContent = posterTalosData.setStrategyInfo(emotionEffectConfig2 != null ? emotionEffectConfig2.strategyInfo : null).setSource("share_caidan").setPanelStyle("3").create();
            BoxShareManager manager = (BoxShareManager) ServiceManager.getService(BoxShareManager.SERVICE_REFERENCE);
            if (manager != null && (getContext() instanceof Activity)) {
                Context context = getContext();
                if (context != null) {
                    manager.share((Activity) context, (View) null, shareContent);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    private final void addBusinessButton() {
        updateButtonAreaLocation();
        View view2 = new View(getContext());
        View $this$addBusinessButton_u24lambda_u2d5 = view2;
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        String str = null;
        $this$addBusinessButton_u24lambda_u2d5.setBackground(Drawable.createFromPath(emotionEffectConfig != null ? emotionEffectConfig.entranceBtnPath : null));
        this.entranceButton = view2;
        FrameLayout.LayoutParams entranceBtnLayoutParams = new FrameLayout.LayoutParams((int) (ViewExtensionsKt.getDimension(this, R.dimen.effect_business_button_width) * 0.87f), (int) (ViewExtensionsKt.getDimension(this, R.dimen.effect_button_height) * 0.87f));
        entranceBtnLayoutParams.setMargins(0, 0, ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.effect_business_button_margin), 0);
        View view3 = this.entranceButton;
        if (view3 != null) {
            view3.setLayoutParams(entranceBtnLayoutParams);
        }
        getButtonArea().addView(this.entranceButton);
        View view4 = new View(getContext());
        View $this$addBusinessButton_u24lambda_u2d6 = view4;
        EmotionEffectConfig emotionEffectConfig2 = this.effectConfig;
        if (emotionEffectConfig2 != null) {
            str = emotionEffectConfig2.businessShareBtnPath;
        }
        $this$addBusinessButton_u24lambda_u2d6.setBackground(Drawable.createFromPath(str));
        this.shareButton = view4;
        FrameLayout.LayoutParams shareBtnLayoutParams = new FrameLayout.LayoutParams((int) (ViewExtensionsKt.getDimension(this, R.dimen.effect_business_button_width) * 0.87f), (int) (ViewExtensionsKt.getDimension(this, R.dimen.effect_button_height) * 0.87f));
        shareBtnLayoutParams.setMargins(ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.effect_business_button_margin), 0, 0, 0);
        View view5 = this.shareButton;
        if (view5 != null) {
            view5.setLayoutParams(shareBtnLayoutParams);
        }
        LinearLayout $this$addBusinessButton_u24lambda_u2d7 = getButtonArea();
        $this$addBusinessButton_u24lambda_u2d7.bringToFront();
        $this$addBusinessButton_u24lambda_u2d7.addView(this.shareButton);
    }

    private final void joinActivity() {
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        String schemaIn = null;
        String schemaOut = emotionEffectConfig != null ? emotionEffectConfig.schemaOut : null;
        EmotionEffectConfig emotionEffectConfig2 = this.effectConfig;
        if (emotionEffectConfig2 != null) {
            schemaIn = emotionEffectConfig2.schemaIn;
        }
        CharSequence charSequence = schemaOut;
        if (charSequence == null || charSequence.length() == 0) {
            BaseRouter.invoke(getContext(), schemaIn);
            OnEmotionEffectListener onEmotionEffectListener = this.listener;
            if (onEmotionEffectListener != null) {
                onEmotionEffectListener.entranceClick("in_app");
            }
        } else if (OpenAppUtils.openApp(getContext(), schemaOut)) {
            OnEmotionEffectListener onEmotionEffectListener2 = this.listener;
            if (onEmotionEffectListener2 != null) {
                onEmotionEffectListener2.entranceClick("out_app");
            }
        } else {
            BaseRouter.invoke(getContext(), schemaIn);
            OnEmotionEffectListener onEmotionEffectListener3 = this.listener;
            if (onEmotionEffectListener3 != null) {
                onEmotionEffectListener3.entranceClick("down_grade");
            }
        }
    }

    private final void updateButtonAreaLocation() {
        LinearLayout $this$updateButtonAreaLocation_u24lambda_u2d8 = getButtonArea();
        $this$updateButtonAreaLocation_u24lambda_u2d8.setVisibility(0);
        $this$updateButtonAreaLocation_u24lambda_u2d8.setY((((float) this.effectHeight) * 0.75f) + ((float) ViewExtensionsKt.getDimensionPixelSize($this$updateButtonAreaLocation_u24lambda_u2d8, R.dimen.effect_button_move_distance)));
        $this$updateButtonAreaLocation_u24lambda_u2d8.getLayoutParams().height = (int) (((float) this.effectHeight) * 0.18f);
    }

    private final void initCloseArea() {
        if (EmotionEffectUtils.INSTANCE.getEffectLoopTimes(this.effectConfig) > 1) {
            ImageView $this$initCloseArea_u24lambda_u2d10 = getCloseArea();
            $this$initCloseArea_u24lambda_u2d10.setVisibility(0);
            $this$initCloseArea_u24lambda_u2d10.setImageDrawable(ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.emotion_effect_close_btn));
            ViewGroup.LayoutParams layoutParams = $this$initCloseArea_u24lambda_u2d10.getLayoutParams();
            $this$initCloseArea_u24lambda_u2d10.setY((((float) this.effectHeight) * 0.75f) + ((float) ((int) (((float) ViewExtensionsKt.getDimensionPixelSize($this$initCloseArea_u24lambda_u2d10, R.dimen.effect_button_height)) * 0.87f))) + ((float) ViewExtensionsKt.getDimensionPixelSize($this$initCloseArea_u24lambda_u2d10, R.dimen.effect_close_button_top_margin)));
            $this$initCloseArea_u24lambda_u2d10.bringToFront();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.resourcePathList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initEffectView() {
        /*
            r7 = this;
            com.baidu.spswitch.emotion.bean.EmotionEffectConfig r0 = r7.effectConfig
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0011
            java.util.List<java.lang.String> r0 = r0.resourcePathList
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            com.baidu.spswitch.utils.EmotionEffectUtils r3 = com.baidu.spswitch.utils.EmotionEffectUtils.INSTANCE
            com.baidu.spswitch.emotion.bean.EmotionEffectConfig r4 = r7.effectConfig
            int r3 = r3.getEffectLoopTimes(r4)
            r7.loopTimes = r3
            android.widget.RelativeLayout r3 = r7.getEffectView()
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof android.widget.FrameLayout.LayoutParams
            if (r4 == 0) goto L_0x002b
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            com.baidu.spswitch.emotion.bean.EmotionEffectConfig r4 = r7.effectConfig
            if (r4 == 0) goto L_0x0033
            int r4 = r4.alignment
            goto L_0x0034
        L_0x0033:
            r4 = r1
        L_0x0034:
            if (r3 != 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r3.gravity = r4
        L_0x0039:
            r5 = 48
            if (r4 != r5) goto L_0x0048
            if (r3 != 0) goto L_0x0040
            goto L_0x0048
        L_0x0040:
            com.baidu.spswitch.emotion.bean.EmotionEffectConfig r5 = r7.effectConfig
            if (r5 == 0) goto L_0x0046
            int r1 = r5.topMargin
        L_0x0046:
            r3.topMargin = r1
        L_0x0048:
            android.widget.RelativeLayout r1 = r7.getEffectView()
            r5 = 0
            r6 = r3
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            r1.setLayoutParams(r6)
            r1.bringToFront()
            com.baidu.spswitch.utils.EmotionEffectUtils r1 = com.baidu.spswitch.utils.EmotionEffectUtils.INSTANCE
            java.lang.String r1 = r1.getFileSuffix(r0)
            java.lang.String r5 = ".mp4"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0070
            com.baidu.spswitch.emotion.bean.EmotionEffectConfig r1 = r7.effectConfig
            if (r1 == 0) goto L_0x006c
            java.util.List<java.lang.String> r2 = r1.resourcePathList
        L_0x006c:
            r7.addAlphaVideos(r2)
            goto L_0x007b
        L_0x0070:
            java.lang.String r2 = ".pag"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x007b
            r7.addPagVideo(r0)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.spswitch.emotion.view.EmotionEffectView.initEffectView():void");
    }

    private final void addPagVideo(String path) {
        Float f2;
        CharSequence charSequence = path;
        if (!(charSequence == null || charSequence.length() == 0)) {
            this.effectResourceType = ".pag";
            PAGFile resource = PAGFile.Load(path);
            try {
                Result.Companion companion = Result.Companion;
                EmotionEffectView emotionEffectView = this;
                f2 = Result.m8971constructorimpl(Float.valueOf(((float) resource.height()) / ((float) resource.width())));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                f2 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Float valueOf = Float.valueOf(2.4f);
            if (Result.m8977isFailureimpl(f2)) {
                f2 = valueOf;
            }
            float radio = ((Number) f2).floatValue();
            int viewWidth = DeviceUtils.ScreenInfo.getDisplayWidth(getContext());
            this.effectHeight = (int) (((float) viewWidth) * radio);
            getPagVideo().setLayoutParams(new FrameLayout.LayoutParams(viewWidth, this.effectHeight));
            getEffectView().addView(getPagVideo());
        }
    }

    private final void addAlphaVideos(List<String> path) {
        Collection collection = path;
        if (!(collection == null || collection.isEmpty())) {
            this.effectResourceType = ".mp4";
            if (path.size() > 1) {
                addSingleAlphaVideo(path.get(0), getAlphaVideo());
                addSingleAlphaVideo(path.get(1), getLoopVideo());
                return;
            }
            addSingleAlphaVideo(path.get(0), getAlphaVideo());
        }
    }

    private final void addSingleAlphaVideo(String path, AlphaVideo alphaVideo) {
        float height;
        if (!(path.length() == 0)) {
            try {
                getRetriever().setDataSource(path);
                String extractMetadata = getRetriever().extractMetadata(18);
                Intrinsics.checkNotNull(extractMetadata);
                float width = Float.parseFloat(extractMetadata) / ((float) 2);
                String extractMetadata2 = getRetriever().extractMetadata(19);
                Intrinsics.checkNotNull(extractMetadata2);
                height = Float.parseFloat(extractMetadata2) / width;
            } catch (Exception e2) {
                height = 2.4f;
            }
            float radio = height;
            int viewWidth = DeviceUtils.ScreenInfo.getDisplayWidth(getContext());
            this.effectHeight = (int) (((float) viewWidth) * radio);
            if (SPConfig.isDebug()) {
                Log.d("EmotionEffectView", "emotion effect AlphaVideo: width-" + viewWidth + " height-" + this.effectHeight);
            }
            alphaVideo.setLayoutParams(new FrameLayout.LayoutParams(viewWidth, this.effectHeight));
            AlphaVideo $this$addSingleAlphaVideo_u24lambda_u2d13 = alphaVideo;
            $this$addSingleAlphaVideo_u24lambda_u2d13.setPlayer(new MediaPlayerProxy());
            $this$addSingleAlphaVideo_u24lambda_u2d13.setDarkFilter(NightModeHelper.isNightMode() ? 0.5f : 0.0f);
            $this$addSingleAlphaVideo_u24lambda_u2d13.setLooping(false);
            $this$addSingleAlphaVideo_u24lambda_u2d13.setClickable(false);
            $this$addSingleAlphaVideo_u24lambda_u2d13.setFocusable(false);
            getEffectView().addView(alphaVideo);
        }
    }

    public final boolean isPlaying() {
        return getAlphaVideo().isPlaying() || getLoopVideo().isPlaying() || getPagVideo().isPlaying();
    }

    public final void playEffect() {
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        Collection collection = emotionEffectConfig != null ? emotionEffectConfig.resourcePathList : null;
        if (!(collection == null || collection.isEmpty())) {
            setVisibility(0);
            executeButtonAreaAnim();
            addButtonAreaListener();
            addCloseBtnListener();
            String str = this.effectResourceType;
            if (Intrinsics.areEqual((Object) str, (Object) ".mp4")) {
                playAFX();
            } else if (Intrinsics.areEqual((Object) str, (Object) ".pag")) {
                playPAG();
            }
        }
    }

    private final void addButtonAreaListener() {
        View view2 = this.shareButton;
        if (view2 != null) {
            view2.setOnClickListener(new EmotionEffectView$$ExternalSyntheticLambda9(this));
        }
        View view3 = this.entranceButton;
        if (view3 != null) {
            view3.setOnClickListener(new EmotionEffectView$$ExternalSyntheticLambda10(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonAreaListener$lambda-15  reason: not valid java name */
    public static final void m7847addButtonAreaListener$lambda15(EmotionEffectView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.executePosterShare();
        OnEmotionEffectListener $this$addButtonAreaListener_u24lambda_u2d15_u24lambda_u2d14 = this$0.listener;
        if ($this$addButtonAreaListener_u24lambda_u2d15_u24lambda_u2d14 != null) {
            $this$addButtonAreaListener_u24lambda_u2d15_u24lambda_u2d14.shareClick();
            $this$addButtonAreaListener_u24lambda_u2d15_u24lambda_u2d14.onEnd(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonAreaListener$lambda-16  reason: not valid java name */
    public static final void m7848addButtonAreaListener$lambda16(EmotionEffectView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.joinActivity();
        OnEmotionEffectListener onEmotionEffectListener = this$0.listener;
        if (onEmotionEffectListener != null) {
            onEmotionEffectListener.onEnd(false);
        }
    }

    private final void addCloseBtnListener() {
        if (getCloseArea().getVisibility() != 8) {
            getCloseArea().setOnClickListener(new EmotionEffectView$$ExternalSyntheticLambda5(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addCloseBtnListener$lambda-18  reason: not valid java name */
    public static final void m7849addCloseBtnListener$lambda18(EmotionEffectView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateEffectContinueCloseTimes();
        OnEmotionEffectListener $this$addCloseBtnListener_u24lambda_u2d18_u24lambda_u2d17 = this$0.listener;
        if ($this$addCloseBtnListener_u24lambda_u2d18_u24lambda_u2d17 != null) {
            $this$addCloseBtnListener_u24lambda_u2d18_u24lambda_u2d17.closeClick();
            $this$addCloseBtnListener_u24lambda_u2d18_u24lambda_u2d17.onEnd(false);
        }
    }

    private final void playPAG() {
        Double d2;
        double d3;
        SurpriseLoopConfig surpriseLoopConfig;
        List<String> list;
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        String str = null;
        Collection collection = emotionEffectConfig != null ? emotionEffectConfig.resourcePathList : null;
        boolean z = true;
        if (!(collection == null || collection.isEmpty())) {
            EmotionEffectConfig emotionEffectConfig2 = this.effectConfig;
            if (!(emotionEffectConfig2 == null || (list = emotionEffectConfig2.resourcePathList) == null)) {
                str = list.get(0);
            }
            String path = str;
            CharSequence charSequence = path;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (!z) {
                getPagVideo().setPath(path);
                EmotionEffectConfig emotionEffectConfig3 = this.effectConfig;
                float startTime = (emotionEffectConfig3 == null || (surpriseLoopConfig = emotionEffectConfig3.surpriseLoopConfig) == null) ? 0.0f : surpriseLoopConfig.startTime;
                long playTime = getPagVideo().duration() / ((long) 1000000);
                try {
                    Result.Companion companion = Result.Companion;
                    EmotionEffectView emotionEffectView = this;
                    if (startTime > ((float) playTime)) {
                        d3 = 0.0d;
                    } else {
                        d3 = ((double) startTime) / ((double) playTime);
                    }
                    d2 = Result.m8971constructorimpl(Double.valueOf(d3));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    d2 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
                Double valueOf = Double.valueOf(0.0d);
                if (Result.m8977isFailureimpl(d2)) {
                    d2 = valueOf;
                }
                getPagVideo().addListener(new EmotionEffectView$playPAG$1(this, ((Number) d2).doubleValue()));
                getPagVideo().play();
            }
        }
    }

    private final void playAFX() {
        List resourcePathList;
        Ref.ObjectRef path = new Ref.ObjectRef();
        Ref.ObjectRef loopPath = new Ref.ObjectRef();
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        boolean z = false;
        if (!(emotionEffectConfig == null || (resourcePathList = emotionEffectConfig.resourcePathList) == null || !(!resourcePathList.isEmpty()))) {
            path.element = resourcePathList.get(0);
            if (resourcePathList.size() > 1) {
                loopPath.element = resourcePathList.get(1);
            }
        }
        CharSequence charSequence = (CharSequence) path.element;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (!z) {
            post(new EmotionEffectView$$ExternalSyntheticLambda12(this, loopPath, path));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35  reason: not valid java name */
    public static final void m7850playAFX$lambda35(EmotionEffectView this$0, Ref.ObjectRef $loopPath, Ref.ObjectRef $path) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($loopPath, "$loopPath");
        Intrinsics.checkNotNullParameter($path, "$path");
        if (this$0.loopTimes > 0) {
            CharSequence charSequence = (CharSequence) $loopPath.element;
            if (!(charSequence == null || charSequence.length() == 0)) {
                AlphaVideo $this$playAFX_u24lambda_u2d35_u24lambda_u2d27 = this$0.getLoopVideo();
                $this$playAFX_u24lambda_u2d35_u24lambda_u2d27.setSourcePath((String) $loopPath.element);
                $this$playAFX_u24lambda_u2d35_u24lambda_u2d27.setOnVideoStartedListener(new EmotionEffectView$$ExternalSyntheticLambda14(this$0));
                $this$playAFX_u24lambda_u2d35_u24lambda_u2d27.setOnVideoEndedListener(new EmotionEffectView$$ExternalSyntheticLambda15(this$0));
                $this$playAFX_u24lambda_u2d35_u24lambda_u2d27.setOnVideoErrorListener(new EmotionEffectView$$ExternalSyntheticLambda1(this$0));
                this$0.getAlphaVideo().setKeepLastFrame(true);
            }
        }
        AlphaVideo $this$playAFX_u24lambda_u2d35_u24lambda_u2d34 = this$0.getAlphaVideo();
        $this$playAFX_u24lambda_u2d35_u24lambda_u2d34.setSourcePath((String) $path.element);
        $this$playAFX_u24lambda_u2d35_u24lambda_u2d34.setOnVideoStartedListener(new EmotionEffectView$$ExternalSyntheticLambda2(this$0));
        $this$playAFX_u24lambda_u2d35_u24lambda_u2d34.setOnVideoEndedListener(new EmotionEffectView$$ExternalSyntheticLambda3(this$0, $this$playAFX_u24lambda_u2d35_u24lambda_u2d34));
        $this$playAFX_u24lambda_u2d35_u24lambda_u2d34.setOnVideoErrorListener(new EmotionEffectView$$ExternalSyntheticLambda4(this$0));
        $this$playAFX_u24lambda_u2d35_u24lambda_u2d34.play();
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-27$lambda-22  reason: not valid java name */
    public static final void m7851playAFX$lambda35$lambda27$lambda22(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtils.runOnUiThread(new EmotionEffectView$$ExternalSyntheticLambda6(this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-27$lambda-22$lambda-21  reason: not valid java name */
    public static final void m7852playAFX$lambda35$lambda27$lambda22$lambda21(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAlphaVideo().setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-27$lambda-24  reason: not valid java name */
    public static final void m7853playAFX$lambda35$lambda27$lambda24(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtils.runOnUiThread(new EmotionEffectView$$ExternalSyntheticLambda13(this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-27$lambda-24$lambda-23  reason: not valid java name */
    public static final void m7854playAFX$lambda35$lambda27$lambda24$lambda23(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = this$0.loopTimes - 1;
        this$0.loopTimes = i2;
        if (i2 > 0) {
            this$0.getLoopVideo().play();
            return;
        }
        OnEmotionEffectListener onEmotionEffectListener = this$0.listener;
        if (onEmotionEffectListener != null) {
            onEmotionEffectListener.onEnd(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-27$lambda-26  reason: not valid java name */
    public static final boolean m7855playAFX$lambda35$lambda27$lambda26(EmotionEffectView this$0, ErrorInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtils.runOnUiThread(new EmotionEffectView$$ExternalSyntheticLambda0(this$0));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-27$lambda-26$lambda-25  reason: not valid java name */
    public static final void m7856playAFX$lambda35$lambda27$lambda26$lambda25(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnEmotionEffectListener onEmotionEffectListener = this$0.listener;
        if (onEmotionEffectListener != null) {
            onEmotionEffectListener.onEnd(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-34$lambda-29  reason: not valid java name */
    public static final void m7857playAFX$lambda35$lambda34$lambda29(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtils.runOnUiThread(new EmotionEffectView$$ExternalSyntheticLambda8(this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-34$lambda-29$lambda-28  reason: not valid java name */
    public static final void m7858playAFX$lambda35$lambda34$lambda29$lambda28(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnEmotionEffectListener onEmotionEffectListener = this$0.listener;
        if (onEmotionEffectListener != null) {
            onEmotionEffectListener.onStart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-34$lambda-31  reason: not valid java name */
    public static final void m7859playAFX$lambda35$lambda34$lambda31(EmotionEffectView this$0, AlphaVideo $this_run) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        UiThreadUtils.runOnUiThread(new EmotionEffectView$$ExternalSyntheticLambda7(this$0, $this_run));
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-34$lambda-31$lambda-30  reason: not valid java name */
    public static final void m7860playAFX$lambda35$lambda34$lambda31$lambda30(EmotionEffectView this$0, AlphaVideo $this_run) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        if (this$0.loopTimes > 0) {
            this$0.getLoopVideo().setVisibility(0);
            this$0.getLoopVideo().play();
            return;
        }
        $this_run.setVisibility(8);
        OnEmotionEffectListener onEmotionEffectListener = this$0.listener;
        if (onEmotionEffectListener != null) {
            onEmotionEffectListener.onEnd(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-34$lambda-33  reason: not valid java name */
    public static final boolean m7861playAFX$lambda35$lambda34$lambda33(EmotionEffectView this$0, ErrorInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtils.runOnUiThread(new EmotionEffectView$$ExternalSyntheticLambda11(this$0));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: playAFX$lambda-35$lambda-34$lambda-33$lambda-32  reason: not valid java name */
    public static final void m7862playAFX$lambda35$lambda34$lambda33$lambda32(EmotionEffectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnEmotionEffectListener onEmotionEffectListener = this$0.listener;
        if (onEmotionEffectListener != null) {
            onEmotionEffectListener.onEnd(true);
        }
    }

    private final void updateEffectContinueCloseTimes() {
        DefaultSharedPrefsWrapper instance = DefaultSharedPrefsWrapper.getInstance();
        EmotionEffectConfig emotionEffectConfig = this.effectConfig;
        String str = null;
        int times = instance.getInt(emotionEffectConfig != null ? emotionEffectConfig.actID : null, 0);
        DefaultSharedPrefsWrapper instance2 = DefaultSharedPrefsWrapper.getInstance();
        EmotionEffectConfig emotionEffectConfig2 = this.effectConfig;
        if (emotionEffectConfig2 != null) {
            str = emotionEffectConfig2.actID;
        }
        instance2.putInt(str, times + 1);
    }

    private final void executeButtonAreaAnim() {
        if (getButtonArea().getVisibility() != 8) {
            ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(getButtonArea(), View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(320);
            Intrinsics.checkNotNullExpressionValue(alphaAnimation, "ofFloat(buttonArea, View…ion(BUTTON_ANIM_DURATION)");
            ObjectAnimator duration = ObjectAnimator.ofFloat(getButtonArea(), View.TRANSLATION_Y, new float[]{getButtonArea().getY(), getButtonArea().getY() - ViewExtensionsKt.getDimension(this, R.dimen.effect_button_move_distance)}).setDuration(320);
            Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(buttonArea, View…ion(BUTTON_ANIM_DURATION)");
            ObjectAnimator transAnimation = duration;
            AnimatorSet animSet = new AnimatorSet();
            animSet.playTogether(new Animator[]{alphaAnimation, transAnimation});
            animSet.start();
        }
    }

    public final void releaseRetriever() {
        getRetriever().release();
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibility(8);
        if (SPConfig.isDebug()) {
            Log.d("EmotionEffectView", "emotion effect view: onDetachedFromWindow");
        }
        getAlphaVideo().destroy();
        getLoopVideo().destroy();
        if (getPagVideo().isPlaying()) {
            getPagVideo().stop();
        }
        this.listener = null;
    }

    public final void setEffectListener(OnEmotionEffectListener listener2) {
        this.listener = listener2;
    }
}
