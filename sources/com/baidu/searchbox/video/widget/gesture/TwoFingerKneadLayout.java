package com.baidu.searchbox.video.widget.gesture;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.searchbox.player.view.PinchGestureInterceptProxy;
import com.baidu.searchbox.video.detail.utils.ViewUtilsKt;
import com.baidu.searchbox.video.widget.interpolator.CubicBezierInterpolator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0016\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u0014H\u0002J\b\u0010F\u001a\u00020(H\u0002J\b\u0010G\u001a\u00020(H\u0002J\u0006\u0010H\u001a\u00020(J\u0010\u0010I\u001a\u00020(2\u0006\u0010J\u001a\u000208H\u0002J\b\u0010K\u001a\u00020\nH\u0002J\b\u0010L\u001a\u00020\u0001H\u0002J\u0012\u0010M\u001a\u00020 2\b\u0010N\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010O\u001a\u00020 2\b\u0010J\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010P\u001a\u00020 2\u0006\u0010N\u001a\u000208H\u0002J\b\u0010Q\u001a\u00020(H\u0016J\u0006\u0010R\u001a\u00020(J\u0010\u0010S\u001a\u00020(2\b\u0010T\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010U\u001a\u00020(2\u0006\u0010N\u001a\u000208H\u0002J\u0010\u0010V\u001a\u00020(2\u0006\u0010E\u001a\u00020\u0014H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\"\u00100\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\"\u00103\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R(\u00106\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020(\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/baidu/searchbox/video/widget/gesture/TwoFingerKneadLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "coverParentView", "getCoverParentView", "()Landroid/widget/FrameLayout;", "coverParentView$delegate", "coverViewX", "", "coverViewY", "curScale", "eventModel", "finalScale", "gestureProxy", "Lcom/baidu/searchbox/player/view/PinchGestureInterceptProxy;", "getGestureProxy", "()Lcom/baidu/searchbox/player/view/PinchGestureInterceptProxy;", "setGestureProxy", "(Lcom/baidu/searchbox/player/view/PinchGestureInterceptProxy;)V", "isEnlarge", "", "()Z", "setEnlarge", "(Z)V", "kneadTarget", "Landroid/view/View;", "onKneadStart", "Lkotlin/Function0;", "", "getOnKneadStart", "()Lkotlin/jvm/functions/Function0;", "setOnKneadStart", "(Lkotlin/jvm/functions/Function0;)V", "onKneadTarget", "getOnKneadTarget", "setOnKneadTarget", "onTargetEnd", "getOnTargetEnd", "setOnTargetEnd", "onTargetReset", "getOnTargetReset", "setOnTargetReset", "onTwoFingerKneadMove", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getOnTwoFingerKneadMove", "()Lkotlin/jvm/functions/Function1;", "setOnTwoFingerKneadMove", "(Lkotlin/jvm/functions/Function1;)V", "pointerOne", "Landroid/graphics/PointF;", "pointerTwo", "xy", "", "handleDoubleFingerEvent", "dx", "dy", "scale", "handleDoubleFingerTouchEnd", "handleDoubleFingerTouchStart", "handleKneadTargetTouchEvent", "handleMovementEvent", "event", "initAnimator", "initCoverParentView", "onInterceptTouchEvent", "ev", "onTouchEvent", "pointersInImg", "release", "resetTargetState", "setPinchGestureProxy", "pinchGestureProxy", "setPivotCenterForCover", "updateScale", "lib-video-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TwoFingerKneadLayout.kt */
public class TwoFingerKneadLayout extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private final Lazy animator$delegate;
    private final Lazy coverParentView$delegate;
    private float coverViewX;
    private float coverViewY;
    private float curScale;
    private int eventModel;
    /* access modifiers changed from: private */
    public float finalScale;
    private PinchGestureInterceptProxy gestureProxy;
    private boolean isEnlarge;
    private View kneadTarget;
    private Function0<Unit> onKneadStart;
    private Function0<? extends View> onKneadTarget;
    private Function0<Unit> onTargetEnd;
    private Function0<Unit> onTargetReset;
    private Function1<? super MotionEvent, Unit> onTwoFingerKneadMove;
    private PointF pointerOne;
    private PointF pointerTwo;
    private final int[] xy;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TwoFingerKneadLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TwoFingerKneadLayout(Context context, AttributeSet attributeSet) {
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
    public TwoFingerKneadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.finalScale = 1.0f;
        this.animator$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TwoFingerKneadLayout$animator$2(this));
        this.coverParentView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TwoFingerKneadLayout$coverParentView$2(this));
        this.xy = new int[2];
        this.curScale = 1.0f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TwoFingerKneadLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final ValueAnimator getAnimator() {
        return (ValueAnimator) this.animator$delegate.getValue();
    }

    private final FrameLayout getCoverParentView() {
        return (FrameLayout) this.coverParentView$delegate.getValue();
    }

    public final Function0<View> getOnKneadTarget() {
        return this.onKneadTarget;
    }

    public final void setOnKneadTarget(Function0<? extends View> function0) {
        this.onKneadTarget = function0;
    }

    public final Function0<Unit> getOnKneadStart() {
        return this.onKneadStart;
    }

    public final void setOnKneadStart(Function0<Unit> function0) {
        this.onKneadStart = function0;
    }

    public final Function0<Unit> getOnTargetReset() {
        return this.onTargetReset;
    }

    public final void setOnTargetReset(Function0<Unit> function0) {
        this.onTargetReset = function0;
    }

    public final Function0<Unit> getOnTargetEnd() {
        return this.onTargetEnd;
    }

    public final void setOnTargetEnd(Function0<Unit> function0) {
        this.onTargetEnd = function0;
    }

    public final Function1<MotionEvent, Unit> getOnTwoFingerKneadMove() {
        return this.onTwoFingerKneadMove;
    }

    public final void setOnTwoFingerKneadMove(Function1<? super MotionEvent, Unit> function1) {
        this.onTwoFingerKneadMove = function1;
    }

    public final boolean isEnlarge() {
        return this.isEnlarge;
    }

    public final void setEnlarge(boolean z) {
        this.isEnlarge = z;
    }

    /* access modifiers changed from: protected */
    public final PinchGestureInterceptProxy getGestureProxy() {
        return this.gestureProxy;
    }

    /* access modifiers changed from: protected */
    public final void setGestureProxy(PinchGestureInterceptProxy pinchGestureInterceptProxy) {
        this.gestureProxy = pinchGestureInterceptProxy;
    }

    /* access modifiers changed from: private */
    public final FrameLayout initCoverParentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout $this$initCoverParentView_u24lambda_u2d0 = frameLayout;
        $this$initCoverParentView_u24lambda_u2d0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$initCoverParentView_u24lambda_u2d0.setClickable(true);
        return frameLayout;
    }

    public final void setPinchGestureProxy(PinchGestureInterceptProxy pinchGestureProxy) {
        this.gestureProxy = pinchGestureProxy;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.eventModel == 0) {
            if ((ev != null && ev.getPointerCount() == 2) && pointersInImg(ev)) {
                Function0<? extends View> function0 = this.onKneadTarget;
                View view2 = function0 != null ? (View) function0.invoke() : null;
                this.kneadTarget = view2;
                if (view2 == null) {
                    return false;
                }
                this.eventModel = 1;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                switch (ev.getActionMasked()) {
                    case 3:
                        this.eventModel = 0;
                        break;
                    case 5:
                        PinchGestureInterceptProxy pinchGestureInterceptProxy = this.gestureProxy;
                        if (!(pinchGestureInterceptProxy != null && pinchGestureInterceptProxy.shouldInterceptGesture())) {
                            handleDoubleFingerTouchStart();
                            break;
                        } else {
                            PinchGestureInterceptProxy pinchGestureInterceptProxy2 = this.gestureProxy;
                            if (pinchGestureInterceptProxy2 != null) {
                                pinchGestureInterceptProxy2.setShouldPreventGesture(true);
                                break;
                            }
                        }
                        break;
                }
                setPivotCenterForCover(ev);
            }
        }
        if (this.eventModel == 1) {
            return true;
        }
        return false;
    }

    private final boolean pointersInImg(MotionEvent ev) {
        float pointerOneX = ev.getX(0);
        float pointerOneY = ev.getY(0);
        float pointerTwoX = ev.getX(1);
        float pointerTwoY = ev.getY(1);
        int layoutWidth = getWidth();
        int layoutHeight = getHeight();
        if (pointerOneX < 0.0f || pointerOneX > ((float) layoutWidth) || pointerOneY < 0.0f || pointerOneY > ((float) layoutHeight) || pointerTwoX < 0.0f || pointerTwoX > ((float) layoutWidth) || pointerTwoY < 0.0f || pointerTwoY > ((float) layoutHeight)) {
            return false;
        }
        return true;
    }

    private final void setPivotCenterForCover(MotionEvent ev) {
        float curX1 = ev.getX(0);
        float curY1 = ev.getY(0);
        float middlePointX = (float) (((double) (curX1 + ev.getX(1))) / 2.0d);
        float middlePointY = (float) (((double) (curY1 + ev.getY(1))) / 2.0d);
        View view2 = this.kneadTarget;
        if (view2 != null) {
            view2.setPivotX(middlePointX);
        }
        View view3 = this.kneadTarget;
        if (view3 != null) {
            view3.setPivotY(middlePointY);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getActionMasked()) : null;
        if (valueOf != null && valueOf.intValue() == 6) {
            this.eventModel = 2;
            this.pointerOne = null;
        } else if (valueOf != null && valueOf.intValue() == 5) {
            if (this.eventModel == 2) {
                this.pointerOne = null;
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            handleMovementEvent(event);
            Function1<? super MotionEvent, Unit> function1 = this.onTwoFingerKneadMove;
            if (function1 != null) {
                function1.invoke(event);
            }
        } else {
            boolean z = true;
            if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
                this.pointerOne = null;
                this.pointerTwo = null;
                this.eventModel = 0;
                PinchGestureInterceptProxy pinchGestureInterceptProxy = this.gestureProxy;
                if (pinchGestureInterceptProxy == null || !pinchGestureInterceptProxy.isInProgress()) {
                    z = false;
                }
                if (z) {
                    PinchGestureInterceptProxy pinchGestureInterceptProxy2 = this.gestureProxy;
                    if (pinchGestureInterceptProxy2 != null) {
                        pinchGestureInterceptProxy2.onExternalTouchEvent(event, this.curScale);
                    }
                    Function0<Unit> function0 = this.onTargetEnd;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    handleDoubleFingerTouchEnd();
                }
                this.curScale = 1.0f;
                PinchGestureInterceptProxy pinchGestureInterceptProxy3 = this.gestureProxy;
                if (pinchGestureInterceptProxy3 != null) {
                    pinchGestureInterceptProxy3.setInProgress(false);
                }
                PinchGestureInterceptProxy pinchGestureInterceptProxy4 = this.gestureProxy;
                if (pinchGestureInterceptProxy4 != null) {
                    pinchGestureInterceptProxy4.setShouldPreventGesture(false);
                }
            }
        }
        return super.onTouchEvent(event);
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleDoubleFingerTouchStart() {
        /*
            r5 = this;
            android.view.View r0 = r5.kneadTarget
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r5.onKneadStart
            if (r0 == 0) goto L_0x000c
            r0.invoke()
        L_0x000c:
            android.animation.ValueAnimator r0 = r5.getAnimator()
            r0.end()
            android.view.View r0 = r5.kneadTarget
            r1 = 0
            if (r0 == 0) goto L_0x001d
            int r0 = r0.getWidth()
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            android.view.View r2 = r5.kneadTarget
            if (r2 == 0) goto L_0x0026
            int r1 = r2.getHeight()
        L_0x0026:
            android.view.View r2 = r5.kneadTarget
            if (r2 == 0) goto L_0x003e
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            if (r2 == 0) goto L_0x003e
            r3 = 0
            r2.width = r0
            r2.height = r1
            android.view.View r4 = r5.kneadTarget
            if (r4 != 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            r4.setLayoutParams(r2)
        L_0x003d:
        L_0x003e:
            android.view.View r2 = r5.kneadTarget
            r3 = 0
            if (r2 == 0) goto L_0x0049
            android.view.ViewParent r2 = r2.getParent()
            goto L_0x004a
        L_0x0049:
            r2 = r3
        L_0x004a:
            boolean r4 = r2 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x0051
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            goto L_0x0052
        L_0x0051:
            r2 = r3
        L_0x0052:
            if (r2 == 0) goto L_0x0059
            android.view.View r4 = r5.kneadTarget
            r2.removeView(r4)
        L_0x0059:
            android.widget.FrameLayout r2 = r5.getCoverParentView()
            r2.removeAllViews()
            android.widget.FrameLayout r2 = r5.getCoverParentView()
            android.view.View r4 = r5.kneadTarget
            r2.addView(r4)
            android.widget.FrameLayout r2 = r5.getCoverParentView()
            android.view.View r2 = (android.view.View) r2
            r4 = 1065353216(0x3f800000, float:1.0)
            com.baidu.searchbox.video.detail.utils.ViewUtilsKt.setViewTranslationZ(r2, r4)
            android.content.Context r2 = r5.getContext()
            if (r2 == 0) goto L_0x0097
            android.app.Activity r2 = (android.app.Activity) r2
            android.view.Window r2 = r2.getWindow()
            android.view.View r2 = r2.getDecorView()
            boolean r4 = r2 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x008b
            r3 = r2
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
        L_0x008b:
            if (r3 == 0) goto L_0x0096
            android.widget.FrameLayout r2 = r5.getCoverParentView()
            android.view.View r2 = (android.view.View) r2
            r3.addView(r2)
        L_0x0096:
            return
        L_0x0097:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "null cannot be cast to non-null type android.app.Activity"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.widget.gesture.TwoFingerKneadLayout.handleDoubleFingerTouchStart():void");
    }

    public final void handleKneadTargetTouchEvent() {
        Function0<? extends View> function0 = this.onKneadTarget;
        this.kneadTarget = function0 != null ? (View) function0.invoke() : null;
        handleDoubleFingerTouchStart();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleMovementEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = r13.eventModel
            r1 = 2
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            r4 = 0
            if (r0 != r3) goto L_0x014e
            int r0 = r14.getPointerCount()
            if (r0 >= r1) goto L_0x0010
            return
        L_0x0010:
            android.graphics.PointF r0 = r13.pointerOne
            if (r0 != 0) goto L_0x0023
            android.graphics.PointF r0 = new android.graphics.PointF
            float r1 = r14.getX(r4)
            float r5 = r14.getY(r4)
            r0.<init>(r1, r5)
            r13.pointerOne = r0
        L_0x0023:
            android.graphics.PointF r0 = r13.pointerTwo
            if (r0 != 0) goto L_0x0036
            android.graphics.PointF r0 = new android.graphics.PointF
            float r1 = r14.getX(r3)
            float r5 = r14.getY(r3)
            r0.<init>(r1, r5)
            r13.pointerTwo = r0
        L_0x0036:
            float r0 = r14.getX(r4)
            float r1 = r14.getY(r4)
            float r5 = r14.getX(r3)
            float r6 = r14.getY(r3)
            android.graphics.PointF r7 = r13.pointerTwo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            float r7 = r7.x
            android.graphics.PointF r8 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            float r8 = r8.x
            float r7 = r7 - r8
            android.graphics.PointF r8 = r13.pointerTwo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            float r8 = r8.x
            android.graphics.PointF r9 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            float r9 = r9.x
            float r8 = r8 - r9
            float r7 = r7 * r8
            android.graphics.PointF r8 = r13.pointerTwo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            float r8 = r8.y
            android.graphics.PointF r9 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            float r9 = r9.y
            float r8 = r8 - r9
            android.graphics.PointF r9 = r13.pointerTwo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            float r9 = r9.y
            android.graphics.PointF r10 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.y
            float r9 = r9 - r10
            float r8 = r8 * r9
            float r7 = r7 + r8
            double r7 = (double) r7
            double r7 = java.lang.Math.sqrt(r7)
            float r7 = (float) r7
            float r8 = r5 - r0
            float r9 = r5 - r0
            float r8 = r8 * r9
            float r9 = r6 - r1
            float r10 = r6 - r1
            float r9 = r9 * r10
            float r8 = r8 + r9
            double r8 = (double) r8
            double r8 = java.lang.Math.sqrt(r8)
            float r8 = (float) r8
            float r9 = r8 / r7
            android.graphics.PointF r10 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.x
            float r10 = r0 - r10
            android.graphics.PointF r11 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            float r11 = r11.y
            float r11 = r1 - r11
            int r12 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00e6
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r12 = r13.gestureProxy
            if (r12 == 0) goto L_0x00c4
            boolean r12 = r12.getShouldPreventGesture()
            if (r12 != r3) goto L_0x00c4
            r12 = r3
            goto L_0x00c5
        L_0x00c4:
            r12 = r4
        L_0x00c5:
            if (r12 == 0) goto L_0x00e6
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r12 = r13.gestureProxy
            if (r12 != 0) goto L_0x00cc
            goto L_0x00cf
        L_0x00cc:
            r12.setShouldPreventGesture(r4)
        L_0x00cf:
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r12 = r13.gestureProxy
            if (r12 != 0) goto L_0x00d4
            goto L_0x00d7
        L_0x00d4:
            r12.setInProgress(r3)
        L_0x00d7:
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r12 = r13.gestureProxy
            if (r12 == 0) goto L_0x00de
            r12.onExternalPinchTouchEvent()
        L_0x00de:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r13.onKneadStart
            if (r12 == 0) goto L_0x0104
            r12.invoke()
            goto L_0x0104
        L_0x00e6:
            int r12 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r12 <= 0) goto L_0x0104
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r12 = r13.gestureProxy
            if (r12 == 0) goto L_0x00f6
            boolean r12 = r12.getShouldPreventGesture()
            if (r12 != r3) goto L_0x00f6
            r12 = r3
            goto L_0x00f7
        L_0x00f6:
            r12 = r4
        L_0x00f7:
            if (r12 == 0) goto L_0x0104
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r12 = r13.gestureProxy
            if (r12 != 0) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r12.setShouldPreventGesture(r4)
        L_0x0101:
            r13.handleDoubleFingerTouchStart()
        L_0x0104:
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r12 = r13.gestureProxy
            if (r12 == 0) goto L_0x0110
            boolean r12 = r12.isInProgress()
            if (r12 != r3) goto L_0x0110
            r12 = r3
            goto L_0x0111
        L_0x0110:
            r12 = r4
        L_0x0111:
            if (r12 == 0) goto L_0x0121
            r13.updateScale(r9)
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r2 = r13.gestureProxy
            if (r2 == 0) goto L_0x01a7
            float r3 = r13.curScale
            r2.onExternalTouchEvent(r14, r3)
            goto L_0x01a7
        L_0x0121:
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0127
            r2 = r3
            goto L_0x0128
        L_0x0127:
            r2 = r4
        L_0x0128:
            if (r2 != 0) goto L_0x01a7
            r13.handleDoubleFingerEvent(r10, r11, r9)
            android.graphics.PointF r2 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            float r12 = r14.getX(r4)
            float r4 = r14.getY(r4)
            r2.set(r12, r4)
            android.graphics.PointF r2 = r13.pointerTwo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            float r4 = r14.getX(r3)
            float r3 = r14.getY(r3)
            r2.set(r4, r3)
            goto L_0x01a7
        L_0x014e:
            if (r0 != r1) goto L_0x01a7
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r0 = r13.gestureProxy
            if (r0 == 0) goto L_0x015b
            boolean r0 = r0.getShouldPreventGesture()
            if (r0 != r3) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r3 = r4
        L_0x015c:
            if (r3 == 0) goto L_0x0169
            com.baidu.searchbox.player.view.PinchGestureInterceptProxy r0 = r13.gestureProxy
            if (r0 != 0) goto L_0x0163
            goto L_0x0166
        L_0x0163:
            r0.setShouldPreventGesture(r4)
        L_0x0166:
            r13.handleDoubleFingerTouchStart()
        L_0x0169:
            android.graphics.PointF r0 = r13.pointerOne
            if (r0 != 0) goto L_0x017c
            android.graphics.PointF r0 = new android.graphics.PointF
            float r1 = r14.getX(r4)
            float r3 = r14.getY(r4)
            r0.<init>(r1, r3)
            r13.pointerOne = r0
        L_0x017c:
            float r0 = r14.getX(r4)
            android.graphics.PointF r1 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            float r1 = r1.x
            float r0 = r0 - r1
            float r1 = r14.getY(r4)
            android.graphics.PointF r3 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            float r3 = r3.y
            float r1 = r1 - r3
            r13.handleDoubleFingerEvent(r0, r1, r2)
            android.graphics.PointF r2 = r13.pointerOne
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            float r3 = r14.getX(r4)
            float r4 = r14.getY(r4)
            r2.set(r3, r4)
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.widget.gesture.TwoFingerKneadLayout.handleMovementEvent(android.view.MotionEvent):void");
    }

    private final void handleDoubleFingerEvent(float dx, float dy, float scale) {
        View view2 = this.kneadTarget;
        if (view2 != null) {
            Intrinsics.checkNotNull(view2);
            view2.setX(view2.getX() + dx);
        }
        View view3 = this.kneadTarget;
        if (view3 != null) {
            Intrinsics.checkNotNull(view3);
            view3.setY(view3.getY() + dy);
        }
        View view4 = this.kneadTarget;
        float scaleX = view4 != null ? view4.getScaleX() : 1.0f;
        this.finalScale = scaleX;
        if (scale < 1.0f && scaleX > 0.3f) {
            float f2 = scaleX * scale;
            this.finalScale = f2;
            if (f2 < 0.3f) {
                this.finalScale = 0.3f;
            }
        } else if (scale > 1.0f && scaleX < 3.5f) {
            float f3 = scaleX * scale;
            this.finalScale = f3;
            if (f3 > 3.5f) {
                this.finalScale = 3.5f;
            }
        }
        View view5 = this.kneadTarget;
        if (view5 != null) {
            view5.setScaleX(this.finalScale);
        }
        View view6 = this.kneadTarget;
        if (view6 != null) {
            view6.setScaleY(this.finalScale);
        }
    }

    private final void updateScale(float scale) {
        this.curScale = scale;
    }

    private final void handleDoubleFingerTouchEnd() {
        View view2 = this.kneadTarget;
        if (view2 != null) {
            float f2 = 0.0f;
            this.isEnlarge = (view2 != null ? view2.getScaleX() : 0.0f) > 1.0f;
            if (getAnimator().isRunning()) {
                getAnimator().end();
            }
            getLocationInWindow(this.xy);
            View view3 = this.kneadTarget;
            this.coverViewX = view3 != null ? view3.getX() : 0.0f;
            View view4 = this.kneadTarget;
            if (view4 != null) {
                f2 = view4.getY();
            }
            this.coverViewY = f2;
            getAnimator().start();
        }
    }

    public final void resetTargetState() {
        Window window;
        if (getCoverParentView().getChildCount() > 0) {
            ViewUtilsKt.setViewTranslationZ(getCoverParentView(), 0.0f);
            getCoverParentView().removeAllViews();
            View view2 = this.kneadTarget;
            ViewGroup viewGroup = null;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            ViewGroup $this$resetTargetState_u24lambda_u2d2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if ($this$resetTargetState_u24lambda_u2d2 != null) {
                $this$resetTargetState_u24lambda_u2d2.removeView(this.kneadTarget);
            }
            Context context = getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            KeyEvent.Callback decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            if (decorView instanceof ViewGroup) {
                viewGroup = (ViewGroup) decorView;
            }
            if (viewGroup != null) {
                viewGroup.removeView(getCoverParentView());
            }
            Function0<Unit> function0 = this.onTargetReset;
            if (function0 != null) {
                function0.invoke();
            }
            Function0<Unit> function02 = this.onTargetEnd;
            if (function02 != null) {
                function02.invoke();
            }
        }
    }

    /* access modifiers changed from: private */
    public final ValueAnimator initAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ValueAnimator $this$initAnimator_u24lambda_u2d4 = ofFloat;
        $this$initAnimator_u24lambda_u2d4.setDuration(160);
        $this$initAnimator_u24lambda_u2d4.setInterpolator(new CubicBezierInterpolator(0.41f, 0.05f, 0.1f, 1.0f));
        $this$initAnimator_u24lambda_u2d4.addUpdateListener(new TwoFingerKneadLayout$$ExternalSyntheticLambda0(this));
        $this$initAnimator_u24lambda_u2d4.addListener(new TwoFingerKneadLayout$initAnimator$1$2(this));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(1f, 0f).apply {\n…\n            })\n        }");
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: initAnimator$lambda-4$lambda-3  reason: not valid java name */
    public static final void m7217initAnimator$lambda4$lambda3(TwoFingerKneadLayout this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            float value = ((Float) animatedValue).floatValue();
            float f2 = (float) 1;
            float curOffsetScale = ((this$0.finalScale - f2) * value) + f2;
            View view2 = this$0.kneadTarget;
            if (view2 != null) {
                view2.setScaleX(curOffsetScale);
            }
            View view3 = this$0.kneadTarget;
            if (view3 != null) {
                view3.setScaleY(curOffsetScale);
            }
            View view4 = this$0.kneadTarget;
            if (view4 != null) {
                float f3 = this$0.coverViewX;
                int i2 = this$0.xy[0];
                view4.setX(((f3 - ((float) i2)) * value) + ((float) i2));
            }
            View view5 = this$0.kneadTarget;
            if (view5 != null) {
                float f4 = this$0.coverViewY;
                int i3 = this$0.xy[1];
                view5.setY(((f4 - ((float) i3)) * value) + ((float) i3));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public void release() {
        this.onKneadTarget = null;
        this.onKneadStart = null;
        this.onTargetEnd = null;
        this.onTargetReset = null;
        this.onTwoFingerKneadMove = null;
        getAnimator().end();
        this.gestureProxy = null;
    }
}
