package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.bdpfont.utils.BDPFont;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.clearcache.res.AccelerateResManagerKt;
import com.baidu.searchbox.download.center.clearcache.view.funison.views.IViewTransitionAbility;
import com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0003012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020!H\u0016J\u0006\u0010.\u001a\u00020!J\u0006\u0010/\u001a\u00020!R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u001b¨\u00063"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/IViewTransitionAbility;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListener", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView$ICleaningViewEventCallback;", "getEventListener", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView$ICleaningViewEventCallback;", "setEventListener", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView$ICleaningViewEventCallback;)V", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "mRootView$delegate", "Lkotlin/Lazy;", "mTransitionEntryAnimation", "Landroid/animation/ValueAnimator;", "getMTransitionEntryAnimation", "()Landroid/animation/ValueAnimator;", "mTransitionEntryAnimation$delegate", "mTransitionExitAnimation", "getMTransitionExitAnimation", "mTransitionExitAnimation$delegate", "dismiss", "", "onDestroy", "onPause", "onResume", "onTransitionEntryAnimatorUpdate", "animator", "onTransitionExitAnimatorUpdate", "setPendingCleanCacheText", "pendingCleanCacheText", "", "show", "transitionEntry", "transitionExit", "updateWhenFontSizeChanged", "updateWhenNightModeChanged", "ICleaningViewEventCallback", "TransitionEntryAnimatorListener", "TransitionExitAnimatorListener", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CleaningView.kt */
public final class CleaningView extends FrameLayout implements IViewTransitionAbility {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ICleaningViewEventCallback eventListener;
    private final Lazy mRootView$delegate;
    private final Lazy mTransitionEntryAnimation$delegate;
    private final Lazy mTransitionExitAnimation$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView$ICleaningViewEventCallback;", "", "onCleaningViewDismissActual", "", "onCleaningViewShowed", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CleaningView.kt */
    public interface ICleaningViewEventCallback {
        void onCleaningViewDismissActual();

        void onCleaningViewShowed();
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

    public void startAnimationDelay(View $this$startAnimationDelay, Animation anim, long delayMillis, Function0<Unit> isAnimationCanStart) {
        IViewTransitionAbility.DefaultImpls.startAnimationDelay(this, $this$startAnimationDelay, anim, delayMillis, isAnimationCanStart);
    }

    /* access modifiers changed from: private */
    public final View getMRootView() {
        return (View) this.mRootView$delegate.getValue();
    }

    public final ICleaningViewEventCallback getEventListener() {
        return this.eventListener;
    }

    public final void setEventListener(ICleaningViewEventCallback iCleaningViewEventCallback) {
        this.eventListener = iCleaningViewEventCallback;
    }

    private final ValueAnimator getMTransitionEntryAnimation() {
        Object value = this.mTransitionEntryAnimation$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mTransitionEntryAnimation>(...)");
        return (ValueAnimator) value;
    }

    private final ValueAnimator getMTransitionExitAnimation() {
        Object value = this.mTransitionExitAnimation$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mTransitionExitAnimation>(...)");
        return (ValueAnimator) value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CleaningView(Context context) {
        super(context);
        ClearRiseNumberTextView clearRiseNumberTextView;
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRootView$delegate = LazyKt.lazy(new CleaningView$mRootView$2(this));
        this.mTransitionEntryAnimation$delegate = LazyKt.lazy(new CleaningView$mTransitionEntryAnimation$2(this));
        this.mTransitionExitAnimation$delegate = LazyKt.lazy(new CleaningView$mTransitionExitAnimation$2(this));
        View mRootView = getMRootView();
        if (!(mRootView == null || (alphaVideoWithPlaceHolderView2 = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) == null)) {
            alphaVideoWithPlaceHolderView2.setPlaceholderPadding(DeviceUtils.ScreenInfo.dp2px(getContext(), 17.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 27.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 40.0f), 0);
        }
        View mRootView2 = getMRootView();
        if (!(mRootView2 == null || (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView2.findViewById(R.id.cleaningAfxAnimation)) == null)) {
            alphaVideoWithPlaceHolderView.setupView(AccelerateResManagerKt.CLEAR_CACHE_AFX_CLEANING, ContextCompat.getDrawable(getContext(), R.drawable.afx_placeholder_clear_cache_scan));
        }
        View mRootView3 = getMRootView();
        if (!(mRootView3 == null || (clearRiseNumberTextView = (ClearRiseNumberTextView) mRootView3.findViewById(R.id.cleaningTotalSizeNumberTextView)) == null)) {
            clearRiseNumberTextView.setDuration(2000);
        }
        View mRootView4 = getMRootView();
        ClearRiseNumberTextView clearRiseNumberTextView2 = mRootView4 != null ? (ClearRiseNumberTextView) mRootView4.findViewById(R.id.cleaningTotalSizeNumberTextView) : null;
        if (clearRiseNumberTextView2 != null) {
            clearRiseNumberTextView2.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CleaningView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ClearRiseNumberTextView clearRiseNumberTextView;
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mRootView$delegate = LazyKt.lazy(new CleaningView$mRootView$2(this));
        this.mTransitionEntryAnimation$delegate = LazyKt.lazy(new CleaningView$mTransitionEntryAnimation$2(this));
        this.mTransitionExitAnimation$delegate = LazyKt.lazy(new CleaningView$mTransitionExitAnimation$2(this));
        View mRootView = getMRootView();
        if (!(mRootView == null || (alphaVideoWithPlaceHolderView2 = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) == null)) {
            alphaVideoWithPlaceHolderView2.setPlaceholderPadding(DeviceUtils.ScreenInfo.dp2px(getContext(), 17.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 27.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 40.0f), 0);
        }
        View mRootView2 = getMRootView();
        if (!(mRootView2 == null || (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView2.findViewById(R.id.cleaningAfxAnimation)) == null)) {
            alphaVideoWithPlaceHolderView.setupView(AccelerateResManagerKt.CLEAR_CACHE_AFX_CLEANING, ContextCompat.getDrawable(getContext(), R.drawable.afx_placeholder_clear_cache_scan));
        }
        View mRootView3 = getMRootView();
        if (!(mRootView3 == null || (clearRiseNumberTextView = (ClearRiseNumberTextView) mRootView3.findViewById(R.id.cleaningTotalSizeNumberTextView)) == null)) {
            clearRiseNumberTextView.setDuration(2000);
        }
        View mRootView4 = getMRootView();
        ClearRiseNumberTextView clearRiseNumberTextView2 = mRootView4 != null ? (ClearRiseNumberTextView) mRootView4.findViewById(R.id.cleaningTotalSizeNumberTextView) : null;
        if (clearRiseNumberTextView2 != null) {
            clearRiseNumberTextView2.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CleaningView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ClearRiseNumberTextView clearRiseNumberTextView;
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mRootView$delegate = LazyKt.lazy(new CleaningView$mRootView$2(this));
        this.mTransitionEntryAnimation$delegate = LazyKt.lazy(new CleaningView$mTransitionEntryAnimation$2(this));
        this.mTransitionExitAnimation$delegate = LazyKt.lazy(new CleaningView$mTransitionExitAnimation$2(this));
        View mRootView = getMRootView();
        if (!(mRootView == null || (alphaVideoWithPlaceHolderView2 = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) == null)) {
            alphaVideoWithPlaceHolderView2.setPlaceholderPadding(DeviceUtils.ScreenInfo.dp2px(getContext(), 17.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 27.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 40.0f), 0);
        }
        View mRootView2 = getMRootView();
        if (!(mRootView2 == null || (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView2.findViewById(R.id.cleaningAfxAnimation)) == null)) {
            alphaVideoWithPlaceHolderView.setupView(AccelerateResManagerKt.CLEAR_CACHE_AFX_CLEANING, ContextCompat.getDrawable(getContext(), R.drawable.afx_placeholder_clear_cache_scan));
        }
        View mRootView3 = getMRootView();
        if (!(mRootView3 == null || (clearRiseNumberTextView = (ClearRiseNumberTextView) mRootView3.findViewById(R.id.cleaningTotalSizeNumberTextView)) == null)) {
            clearRiseNumberTextView.setDuration(2000);
        }
        View mRootView4 = getMRootView();
        ClearRiseNumberTextView clearRiseNumberTextView2 = mRootView4 != null ? (ClearRiseNumberTextView) mRootView4.findViewById(R.id.cleaningTotalSizeNumberTextView) : null;
        if (clearRiseNumberTextView2 != null) {
            clearRiseNumberTextView2.setTypeface(BDPFont.INSTANCE.getBDPFontTypeFace(BDPFont.NUMBER_FONT_NAME));
        }
    }

    /* JADX WARNING: type inference failed for: r2v8, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v15, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v24, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPendingCleanCacheText(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "pendingCleanCacheText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "KB"
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r4 = kotlin.text.StringsKt.endsWith$default(r11, r0, r1, r2, r3)
            java.lang.String r5 = "MB"
            boolean r5 = kotlin.text.StringsKt.endsWith$default(r11, r5, r1, r2, r3)
            java.lang.String r6 = "GB"
            boolean r6 = kotlin.text.StringsKt.endsWith$default(r11, r6, r1, r2, r3)
            java.lang.String r7 = "项"
            boolean r7 = kotlin.text.StringsKt.endsWith$default(r11, r7, r1, r2, r3)
            java.lang.String r8 = ""
            if (r4 != 0) goto L_0x00d2
            if (r5 != 0) goto L_0x00d2
            if (r6 == 0) goto L_0x002c
            goto L_0x00d2
        L_0x002c:
            if (r7 == 0) goto L_0x008d
            android.view.View r0 = r10.getMRootView()
            if (r0 == 0) goto L_0x003d
            int r2 = com.baidu.searchbox.clearcache.business.R.id.cleaningUnitTextView
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x003e
        L_0x003d:
            r0 = r3
        L_0x003e:
            r2 = 1
            if (r0 != 0) goto L_0x0042
            goto L_0x004b
        L_0x0042:
            java.lang.String r9 = kotlin.text.StringsKt.takeLast((java.lang.String) r11, (int) r2)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
        L_0x004b:
            java.lang.String r0 = kotlin.text.StringsKt.dropLast((java.lang.String) r11, (int) r2)
            if (r0 != 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r8 = r0
        L_0x0053:
            r0 = r8
            android.view.View r2 = r10.getMRootView()
            if (r2 == 0) goto L_0x0063
            int r3 = com.baidu.searchbox.clearcache.business.R.id.cleaningTotalSizeNumberTextView
            android.view.View r2 = r2.findViewById(r3)
            r3 = r2
            com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView r3 = (com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView) r3
        L_0x0063:
            if (r3 != 0) goto L_0x0066
            goto L_0x006c
        L_0x0066:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x006c:
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r2 == 0) goto L_0x0077
            int r2 = r2.intValue()
            goto L_0x0078
        L_0x0077:
            r2 = r1
        L_0x0078:
            android.view.View r3 = r10.getMRootView()
            if (r3 == 0) goto L_0x012e
            int r8 = com.baidu.searchbox.clearcache.business.R.id.cleaningTotalSizeNumberTextView
            android.view.View r3 = r3.findViewById(r8)
            com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView r3 = (com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView) r3
            if (r3 == 0) goto L_0x012e
            r3.withNumber((int) r2, (boolean) r1)
            goto L_0x012e
        L_0x008d:
            android.view.View r2 = r10.getMRootView()
            if (r2 == 0) goto L_0x009c
            int r8 = com.baidu.searchbox.clearcache.business.R.id.cleaningUnitTextView
            android.view.View r2 = r2.findViewById(r8)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x009d
        L_0x009c:
            r2 = r3
        L_0x009d:
            if (r2 != 0) goto L_0x00a0
            goto L_0x00a5
        L_0x00a0:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
        L_0x00a5:
            android.view.View r0 = r10.getMRootView()
            if (r0 == 0) goto L_0x00b4
            int r2 = com.baidu.searchbox.clearcache.business.R.id.cleaningTotalSizeNumberTextView
            android.view.View r0 = r0.findViewById(r2)
            r3 = r0
            com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView r3 = (com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView) r3
        L_0x00b4:
            if (r3 != 0) goto L_0x00b7
            goto L_0x00be
        L_0x00b7:
            java.lang.String r0 = "0"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
        L_0x00be:
            android.view.View r0 = r10.getMRootView()
            if (r0 == 0) goto L_0x012e
            int r2 = com.baidu.searchbox.clearcache.business.R.id.cleaningTotalSizeNumberTextView
            android.view.View r0 = r0.findViewById(r2)
            com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView r0 = (com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView) r0
            if (r0 == 0) goto L_0x012e
            r0.withNumber((int) r1, (boolean) r1)
            goto L_0x012e
        L_0x00d2:
            android.view.View r0 = r10.getMRootView()
            if (r0 == 0) goto L_0x00e1
            int r9 = com.baidu.searchbox.clearcache.business.R.id.cleaningUnitTextView
            android.view.View r0 = r0.findViewById(r9)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x00e2
        L_0x00e1:
            r0 = r3
        L_0x00e2:
            if (r0 != 0) goto L_0x00e5
            goto L_0x00ee
        L_0x00e5:
            java.lang.String r9 = kotlin.text.StringsKt.takeLast((java.lang.String) r11, (int) r2)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
        L_0x00ee:
            java.lang.String r0 = kotlin.text.StringsKt.dropLast((java.lang.String) r11, (int) r2)
            if (r0 != 0) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r8 = r0
        L_0x00f6:
            r0 = r8
            android.view.View r2 = r10.getMRootView()
            if (r2 == 0) goto L_0x0106
            int r3 = com.baidu.searchbox.clearcache.business.R.id.cleaningTotalSizeNumberTextView
            android.view.View r2 = r2.findViewById(r3)
            r3 = r2
            com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView r3 = (com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView) r3
        L_0x0106:
            if (r3 != 0) goto L_0x0109
            goto L_0x010f
        L_0x0109:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x010f:
            java.lang.Float r2 = kotlin.text.StringsKt.toFloatOrNull(r0)
            if (r2 == 0) goto L_0x011a
            float r2 = r2.floatValue()
            goto L_0x011b
        L_0x011a:
            r2 = 0
        L_0x011b:
            android.view.View r3 = r10.getMRootView()
            if (r3 == 0) goto L_0x012e
            int r8 = com.baidu.searchbox.clearcache.business.R.id.cleaningTotalSizeNumberTextView
            android.view.View r3 = r3.findViewById(r8)
            com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView r3 = (com.baidu.searchbox.download.center.clearcache.view.old.ClearRiseNumberTextView) r3
            if (r3 == 0) goto L_0x012e
            r3.withNumber((float) r2, (boolean) r1)
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.clearcache.view.funison.views.CleaningView.setPendingCleanCacheText(java.lang.String):void");
    }

    public final void onResume() {
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        View mRootView = getMRootView();
        if (mRootView != null && (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) != null) {
            alphaVideoWithPlaceHolderView.onResume();
        }
    }

    public final void onPause() {
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        View mRootView = getMRootView();
        if (mRootView != null && (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) != null) {
            alphaVideoWithPlaceHolderView.onPause();
        }
    }

    public final void onDestroy() {
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        View mRootView = getMRootView();
        if (mRootView != null && (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) != null) {
            alphaVideoWithPlaceHolderView.onDestroy();
        }
    }

    public void transitionEntry() {
        if (getVisibility() != 0) {
            getMTransitionEntryAnimation().start();
        }
    }

    public void transitionExit() {
        if (getVisibility() == 0) {
            getMTransitionExitAnimation().start();
        }
    }

    /* access modifiers changed from: private */
    public final void show() {
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        if (getVisibility() != 0) {
            setVisibility(0);
            View mRootView = getMRootView();
            if (mRootView != null && (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) != null) {
                AlphaVideoWithPlaceHolderView.play$default(alphaVideoWithPlaceHolderView, true, (Boolean) null, 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void dismiss() {
        AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView;
        View mRootView = getMRootView();
        if (!(mRootView == null || (alphaVideoWithPlaceHolderView = (AlphaVideoWithPlaceHolderView) mRootView.findViewById(R.id.cleaningAfxAnimation)) == null)) {
            alphaVideoWithPlaceHolderView.stop();
        }
        setVisibility(8);
        ICleaningViewEventCallback iCleaningViewEventCallback = this.eventListener;
        if (iCleaningViewEventCallback != null) {
            iCleaningViewEventCallback.onCleaningViewDismissActual();
        }
    }

    public final void updateWhenNightModeChanged() {
        TextView textView;
        TextView textView2;
        ClearRiseNumberTextView clearRiseNumberTextView;
        int totalSizeTextColor = ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC1);
        int unitTextColor = ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC4);
        View mRootView = getMRootView();
        if (!(mRootView == null || (clearRiseNumberTextView = (ClearRiseNumberTextView) mRootView.findViewById(R.id.cleaningTotalSizeNumberTextView)) == null)) {
            clearRiseNumberTextView.setTextColor(totalSizeTextColor);
        }
        View mRootView2 = getMRootView();
        if (!(mRootView2 == null || (textView2 = (TextView) mRootView2.findViewById(R.id.cleaningUnitTextView)) == null)) {
            textView2.setTextColor(unitTextColor);
        }
        View mRootView3 = getMRootView();
        if (mRootView3 != null && (textView = (TextView) mRootView3.findViewById(R.id.cleaningDescTextView)) != null) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.clear_cache_size_desc));
        }
    }

    public final void updateWhenFontSizeChanged() {
        TextView textView;
        TextView textView2;
        ClearRiseNumberTextView clearRiseNumberTextView;
        View mRootView = getMRootView();
        if (!(mRootView == null || (clearRiseNumberTextView = (ClearRiseNumberTextView) mRootView.findViewById(R.id.cleaningTotalSizeNumberTextView)) == null)) {
            clearRiseNumberTextView.setTextSize(1, 61.0f);
        }
        View mRootView2 = getMRootView();
        if (!(mRootView2 == null || (textView2 = (TextView) mRootView2.findViewById(R.id.cleaningUnitTextView)) == null)) {
            textView2.setTextSize(1, 35.0f);
        }
        View mRootView3 = getMRootView();
        if (mRootView3 != null && (textView = (TextView) mRootView3.findViewById(R.id.cleaningDescTextView)) != null) {
            textView.setTextSize(1, 16.0f);
        }
    }

    /* access modifiers changed from: private */
    public final void onTransitionEntryAnimatorUpdate(ValueAnimator animator) {
        setAlpha(animator.getAnimatedFraction());
    }

    /* access modifiers changed from: private */
    public final void onTransitionExitAnimatorUpdate(ValueAnimator animator) {
        setAlpha(1.0f - animator.getAnimatedFraction());
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView$TransitionEntryAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CleaningView.kt */
    private final class TransitionEntryAnimatorListener implements Animator.AnimatorListener {
        public TransitionEntryAnimatorListener() {
        }

        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            CleaningView.this.show();
        }

        public void onAnimationEnd(Animator animation) {
            ClearRiseNumberTextView clearRiseNumberTextView;
            Intrinsics.checkNotNullParameter(animation, "animation");
            ICleaningViewEventCallback eventListener = CleaningView.this.getEventListener();
            if (eventListener != null) {
                eventListener.onCleaningViewShowed();
            }
            View access$getMRootView = CleaningView.this.getMRootView();
            if (access$getMRootView != null && (clearRiseNumberTextView = (ClearRiseNumberTextView) access$getMRootView.findViewById(R.id.cleaningTotalSizeNumberTextView)) != null) {
                clearRiseNumberTextView.start();
            }
        }

        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView$TransitionExitAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/CleaningView;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CleaningView.kt */
    private final class TransitionExitAnimatorListener implements Animator.AnimatorListener {
        public TransitionExitAnimatorListener() {
        }

        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            CleaningView.this.dismiss();
        }

        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }
}
