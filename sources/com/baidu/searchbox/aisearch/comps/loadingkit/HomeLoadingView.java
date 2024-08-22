package com.baidu.searchbox.aisearch.comps.loadingkit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.proxy.MediaPlayerProxy;
import com.baidu.searchbox.aisearch.R;
import com.baidu.searchbox.aisearch.utils.AnyScene;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u000fH\u0003J\b\u0010\u001b\u001a\u00020\u000fH\u0007J\b\u0010\u001c\u001a\u00020\u000fH\u0003J\b\u0010\u001d\u001a\u00020\u000fH\u0014J\b\u0010\u001e\u001a\u00020\u000fH\u0003J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0007H\u0007J\b\u0010$\u001a\u00020\u000fH\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/loadingkit/HomeLoadingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avLoading", "Lcom/baidu/searchbox/afx/AlphaVideo;", "containerView", "Landroid/view/View;", "exitLoadingCallback", "Lkotlin/Function0;", "", "getExitLoadingCallback$lib_aisearch_impl_release", "()Lkotlin/jvm/functions/Function0;", "setExitLoadingCallback$lib_aisearch_impl_release", "(Lkotlin/jvm/functions/Function0;)V", "firstAnimRunnable", "Ljava/lang/Runnable;", "loadingAnim", "Lcom/baidu/searchbox/aisearch/comps/loadingkit/HomeLoadingTransition;", "loadingWithTransition", "", "destroyPlayer", "exitLoading", "initAfxPlayer", "onDetachedFromWindow", "removeFirstRunnable", "setLoadingUISettings", "settings", "Lcom/baidu/searchbox/aisearch/comps/loadingkit/UISettings;", "setType", "type", "showLoading", "Companion", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@AnyScene
/* compiled from: HomeLoadingView.kt */
public final class HomeLoadingView extends FrameLayout {
    public static final int BLACK_LOADING = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FIRST_ENTER_DELAY = 350;
    public static final int WHITE_LOADING = 1;
    public Map<Integer, View> _$_findViewCache;
    private AlphaVideo avLoading;
    private final View containerView;
    private Function0<Unit> exitLoadingCallback;
    private Runnable firstAnimRunnable;
    private final HomeLoadingTransition loadingAnim;
    private boolean loadingWithTransition;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeLoadingView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeLoadingView(Context context, AttributeSet attributeSet) {
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
    public HomeLoadingView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        HomeLoadingTransition $this$loadingAnim_u24lambda_u2d0 = new HomeLoadingTransition(this);
        $this$loadingAnim_u24lambda_u2d0.setExitEndCallback(new HomeLoadingView$loadingAnim$1$1(this));
        this.loadingAnim = $this$loadingAnim_u24lambda_u2d0;
        this.loadingWithTransition = true;
        this.firstAnimRunnable = new HomeLoadingView$$ExternalSyntheticLambda1(this);
        LayoutInflater.from(context).inflate(R.layout.aisearch_home_loading_comp, this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View findViewById = getRootView().findViewById(R.id.rl_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rl_container)");
        this.containerView = findViewById;
        setAlpha(0.0f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeLoadingView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/loadingkit/HomeLoadingView$Companion;", "", "()V", "BLACK_LOADING", "", "FIRST_ENTER_DELAY", "", "WHITE_LOADING", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HomeLoadingView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Function0<Unit> getExitLoadingCallback$lib_aisearch_impl_release() {
        return this.exitLoadingCallback;
    }

    public final void setExitLoadingCallback$lib_aisearch_impl_release(Function0<Unit> function0) {
        this.exitLoadingCallback = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: firstAnimRunnable$lambda-1  reason: not valid java name */
    public static final void m15795firstAnimRunnable$lambda1(HomeLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadingAnim.enter();
    }

    private final void initAfxPlayer() {
        if (this.avLoading == null) {
            try {
                AlphaVideo alphaVideo = new AlphaVideo(getContext());
                AlphaVideo $this$initAfxPlayer_u24lambda_u2d3 = alphaVideo;
                $this$initAfxPlayer_u24lambda_u2d3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                $this$initAfxPlayer_u24lambda_u2d3.setOnVideoErrorListener(new HomeLoadingView$$ExternalSyntheticLambda0());
                $this$initAfxPlayer_u24lambda_u2d3.setPlayer(new MediaPlayerProxy());
                $this$initAfxPlayer_u24lambda_u2d3.setLooping(true);
                $this$initAfxPlayer_u24lambda_u2d3.setSourceAssets("afx/aisearch_home_loading.mp4");
                View view2 = this.containerView;
                ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
                if (viewGroup != null) {
                    viewGroup.addView($this$initAfxPlayer_u24lambda_u2d3, 0);
                }
                this.avLoading = alphaVideo;
            } catch (OutOfMemoryError e2) {
                destroyPlayer();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initAfxPlayer$lambda-3$lambda-2  reason: not valid java name */
    public static final boolean m15796initAfxPlayer$lambda3$lambda2(ErrorInfo it) {
        return true;
    }

    public final void setLoadingUISettings(UISettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        ResWrapper.setTextColor((TextView) _$_findCachedViewById(R.id.tv_loading), settings.getLoadingTextColor());
        this.loadingWithTransition = settings.getLoadingWithTransition();
        if (!settings.getShowLoadingText()) {
            ((TextView) _$_findCachedViewById(R.id.tv_loading)).setVisibility(8);
        }
    }

    public final void setType(int type) {
    }

    /* access modifiers changed from: private */
    public final void destroyPlayer() {
        AlphaVideo alphaVideo = this.avLoading;
        if (alphaVideo != null) {
            alphaVideo.destroy();
        }
        AlphaVideo $this$destroyPlayer_u24lambda_u2d5 = this.avLoading;
        if ($this$destroyPlayer_u24lambda_u2d5 != null) {
            View view2 = this.containerView;
            ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
            if (viewGroup != null) {
                viewGroup.removeView($this$destroyPlayer_u24lambda_u2d5);
            }
        }
        this.avLoading = null;
    }

    public final void exitLoading() {
        if (this.loadingWithTransition) {
            this.loadingAnim.exit();
        } else {
            Function0<Unit> exitEndCallback = this.loadingAnim.getExitEndCallback();
            if (exitEndCallback != null) {
                exitEndCallback.invoke();
            }
        }
        removeFirstRunnable();
    }

    public final void showLoading() {
        initAfxPlayer();
        AlphaVideo alphaVideo = this.avLoading;
        if (alphaVideo != null) {
            alphaVideo.play();
        }
        if (this.loadingWithTransition) {
            Runnable $this$showLoading_u24lambda_u2d6 = this.firstAnimRunnable;
            if ($this$showLoading_u24lambda_u2d6 == null) {
                this.loadingAnim.enter();
            } else if ($this$showLoading_u24lambda_u2d6 != null) {
                UiThreadUtils.getMainHandler().postDelayed($this$showLoading_u24lambda_u2d6, 350);
            }
        } else {
            setAlpha(1.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroyPlayer();
        removeFirstRunnable();
    }

    private final void removeFirstRunnable() {
        Runnable $this$removeFirstRunnable_u24lambda_u2d7 = this.firstAnimRunnable;
        if ($this$removeFirstRunnable_u24lambda_u2d7 != null) {
            UiThreadUtils.getMainHandler().removeCallbacks($this$removeFirstRunnable_u24lambda_u2d7);
        }
        this.firstAnimRunnable = null;
    }
}
