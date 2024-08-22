package com.tera.scan.framework.swipeback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsSeekBar;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tera.scan.ui.widget.AbsVerticalSeekBar;
import fe.mmm.qw.p030switch.yj.ad;
import fe.mmm.qw.p030switch.yj.de;
import fe.mmm.qw.p030switch.yj.fe;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u0012H\u0002J\b\u0010M\u001a\u000208H\u0016J\u0012\u0010N\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020\f2\u0006\u0010H\u001a\u00020IH\u0002J\u0012\u0010S\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J(\u0010T\u001a\u0002082\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\tH\u0014J\u0012\u0010Y\u001a\u00020\f2\b\u0010Z\u001a\u0004\u0018\u00010IH\u0016J0\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020QH\u0002J\u0018\u0010a\u001a\u0002082\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH\u0016J\u0010\u0010b\u001a\u0002082\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u0010c\u001a\u00020\f2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010d\u001a\u0002082\u0006\u0010e\u001a\u00020\u0012H\u0002J\u0010\u0010f\u001a\u0002082\u0006\u0010g\u001a\u00020\u0012H\u0002J\u0010\u0010h\u001a\u0002082\u0006\u0010i\u001a\u00020\tH\u0002J\u0010\u0010j\u001a\u0002082\u0006\u0010k\u001a\u00020\tH\u0002J\u0010\u0010l\u001a\u00020\f2\u0006\u0010P\u001a\u00020QH\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R=\u00103\u001a%\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u000208\u0018\u000104j\u0004\u0018\u0001`9X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\bA\u0010%\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020C8BX\u0002¢\u0006\f\n\u0004\bF\u0010%\u001a\u0004\bD\u0010E¨\u0006m"}, d2 = {"Lcom/tera/scan/framework/swipeback/SwipeBackLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canSwipe", "", "getCanSwipe", "()Z", "setCanSwipe", "(Z)V", "downX", "", "downY", "ignoreTouchEvent", "getIgnoreTouchEvent", "setIgnoreTouchEvent", "layoutHeight", "layoutWidth", "onStartSwipe", "Lkotlin/Function0;", "Lcom/tera/scan/framework/swipeback/OnStartSwipe;", "getOnStartSwipe", "()Lkotlin/jvm/functions/Function0;", "setOnStartSwipe", "(Lkotlin/jvm/functions/Function0;)V", "scroller", "Landroid/widget/Scroller;", "getScroller", "()Landroid/widget/Scroller;", "scroller$delegate", "Lkotlin/Lazy;", "shouldFinishActivity", "swipeArea", "Lcom/tera/scan/framework/swipeback/SwipeArea;", "getSwipeArea", "()Lcom/tera/scan/framework/swipeback/SwipeArea;", "setSwipeArea", "(Lcom/tera/scan/framework/swipeback/SwipeArea;)V", "swipeBackConfig", "Lcom/tera/scan/framework/swipeback/SwipeBackConfig;", "getSwipeBackConfig", "()Lcom/tera/scan/framework/swipeback/SwipeBackConfig;", "setSwipeBackConfig", "(Lcom/tera/scan/framework/swipeback/SwipeBackConfig;)V", "swipeProgressCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "progress", "", "Lcom/tera/scan/framework/swipeback/SwipeProgressChanged;", "getSwipeProgressCallback", "()Lkotlin/jvm/functions/Function1;", "setSwipeProgressCallback", "(Lkotlin/jvm/functions/Function1;)V", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "velocityTracker", "Landroid/view/VelocityTracker;", "getVelocityTracker", "()Landroid/view/VelocityTracker;", "velocityTracker$delegate", "canSwipeBack", "ev", "Landroid/view/MotionEvent;", "childCanScroll", "x", "y", "computeScroll", "dispatchTouchEvent", "ignoreSwipeView", "view", "Landroid/view/View;", "inEdgeArea", "onInterceptTouchEvent", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "pointOnView", "viewPointX", "viewPointY", "scrollX", "scrollY", "child", "scrollTo", "setShadow", "shouldIntercept", "smartSmoothScrollX", "xVelocity", "smartSmoothScrollY", "yVelocity", "startSmoothScrollX", "dx", "startSmoothScrollY", "dy", "viewCanScroll", "framework-android_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwipeBackLayout extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public boolean canSwipe;
    public float downX;
    public float downY;
    public boolean ignoreTouchEvent;
    public int layoutHeight;
    public int layoutWidth;
    @Nullable
    public Function0<Boolean> onStartSwipe;
    @NotNull
    public final Lazy scroller$delegate;
    public boolean shouldFinishActivity;
    @NotNull
    public SwipeArea swipeArea;
    @NotNull
    public de swipeBackConfig;
    @Nullable
    public Function1<? super Float, Unit> swipeProgressCallback;
    @NotNull
    public final Lazy touchSlop$delegate;
    @NotNull
    public final Lazy velocityTracker$delegate;

    public /* synthetic */ class qw {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SwipeArea.values().length];
            iArr[SwipeArea.FULL.ordinal()] = 1;
            iArr[SwipeArea.EDGE.ordinal()] = 2;
            iArr[SwipeArea.EDGE_AND_FULL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SwipeType.values().length];
            iArr2[SwipeType.LEFT_TO_RIGHT.ordinal()] = 1;
            iArr2[SwipeType.TOP_TO_DOWN.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.touchSlop$delegate = LazyKt__LazyJVMKt.lazy(new SwipeBackLayout$touchSlop$2(context));
        this.scroller$delegate = LazyKt__LazyJVMKt.lazy(new SwipeBackLayout$scroller$2(context));
        this.velocityTracker$delegate = LazyKt__LazyJVMKt.lazy(SwipeBackLayout$velocityTracker$2.INSTANCE);
        this.swipeBackConfig = new de(0.0f, 0, (SwipeType) null, (fe.mmm.qw.p030switch.yj.qw) null, 15, (DefaultConstructorMarker) null);
        this.swipeArea = SwipeArea.EDGE_AND_FULL;
        setClickable(true);
    }

    private final boolean canSwipeBack(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (childCanScroll(x, y)) {
            return false;
        }
        float f = x - this.downX;
        float f2 = y - this.downY;
        int i2 = qw.$EnumSwitchMapping$1[this.swipeBackConfig.fe().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else if (f2 <= Math.abs(f) || f2 <= ((float) getTouchSlop())) {
                return false;
            }
        } else if (f <= Math.abs(f2) || f <= ((float) getTouchSlop())) {
            return false;
        }
        return true;
    }

    private final boolean childCanScroll(float f, float f2) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(new ad(this, f, f2));
        while (!linkedList.isEmpty()) {
            ad adVar = (ad) linkedList.poll();
            if (adVar != null) {
                ViewGroup qw2 = adVar.qw();
                int scrollX = qw2.getScrollX();
                int scrollY = qw2.getScrollY();
                float ad2 = adVar.ad();
                float de2 = adVar.de();
                if (viewCanScroll(qw2) || ignoreSwipeView(qw2)) {
                    return true;
                }
                int childCount = qw2.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = qw2.getChildAt(i2);
                    Intrinsics.checkNotNullExpressionValue(childAt, "child");
                    View view = childAt;
                    if (pointOnView(ad2, de2, scrollX, scrollY, childAt)) {
                        View view2 = view;
                        if (view2 instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view2;
                            linkedList.push(new ad(viewGroup, (((float) scrollX) + ad2) - ((float) viewGroup.getLeft()), (((float) scrollY) + de2) - ((float) viewGroup.getTop())));
                        } else if (viewCanScroll(view2) || ignoreSwipeView(view2)) {
                            return true;
                        }
                    }
                }
                continue;
            }
        }
        return false;
    }

    private final Scroller getScroller() {
        return (Scroller) this.scroller$delegate.getValue();
    }

    private final int getTouchSlop() {
        return ((Number) this.touchSlop$delegate.getValue()).intValue();
    }

    private final VelocityTracker getVelocityTracker() {
        Object value = this.velocityTracker$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-velocityTracker>(...)");
        return (VelocityTracker) value;
    }

    private final boolean ignoreSwipeView(View view) {
        return (view instanceof AbsSeekBar) || (view instanceof AbsVerticalSeekBar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        if (r8 > ((float) getTouchSlop())) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        if (r0 > ((float) getTouchSlop())) goto L_0x0095;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean inEdgeArea(android.view.MotionEvent r8) {
        /*
            r7 = this;
            com.tera.scan.framework.swipeback.SwipeArea r0 = r7.swipeArea
            com.tera.scan.framework.swipeback.SwipeArea r1 = com.tera.scan.framework.swipeback.SwipeArea.EDGE_AND_FULL
            r2 = 0
            if (r0 == r1) goto L_0x000c
            com.tera.scan.framework.swipeback.SwipeArea r1 = com.tera.scan.framework.swipeback.SwipeArea.EDGE
            if (r0 == r1) goto L_0x000c
            return r2
        L_0x000c:
            float r0 = r8.getX()
            float r1 = r7.downX
            float r0 = r0 - r1
            float r8 = r8.getY()
            float r1 = r7.downY
            float r8 = r8 - r1
            fe.mmm.qw.switch.yj.de r1 = r7.swipeBackConfig
            com.tera.scan.framework.swipeback.SwipeType r1 = r1.fe()
            int[] r3 = com.tera.scan.framework.swipeback.SwipeBackLayout.qw.$EnumSwitchMapping$1
            int r1 = r1.ordinal()
            r1 = r3[r1]
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x0042
            if (r1 != r4) goto L_0x003c
            fe.mmm.qw.switch.yj.de r1 = r7.swipeBackConfig
            fe.mmm.qw.switch.yj.qw r1 = r1.qw()
            if (r1 == 0) goto L_0x004e
            android.graphics.RectF r3 = r1.ad()
            goto L_0x004e
        L_0x003c:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x0042:
            fe.mmm.qw.switch.yj.de r1 = r7.swipeBackConfig
            fe.mmm.qw.switch.yj.qw r1 = r1.qw()
            if (r1 == 0) goto L_0x004e
            android.graphics.RectF r3 = r1.qw()
        L_0x004e:
            if (r3 == 0) goto L_0x009b
            float r1 = r7.downX
            float r6 = r7.downY
            boolean r1 = r3.contains(r1, r6)
            if (r1 == 0) goto L_0x009b
            fe.mmm.qw.switch.yj.de r1 = r7.swipeBackConfig
            com.tera.scan.framework.swipeback.SwipeType r1 = r1.fe()
            int[] r3 = com.tera.scan.framework.swipeback.SwipeBackLayout.qw.$EnumSwitchMapping$1
            int r1 = r1.ordinal()
            r1 = r3[r1]
            if (r1 == r5) goto L_0x0084
            if (r1 != r4) goto L_0x007e
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0097
            int r0 = r7.getTouchSlop()
            float r0 = (float) r0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x0097
            goto L_0x0095
        L_0x007e:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x0084:
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0097
            int r8 = r7.getTouchSlop()
            float r8 = (float) r8
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0097
        L_0x0095:
            r8 = 1
            goto L_0x0098
        L_0x0097:
            r8 = 0
        L_0x0098:
            if (r8 == 0) goto L_0x009b
            r2 = 1
        L_0x009b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.framework.swipeback.SwipeBackLayout.inEdgeArea(android.view.MotionEvent):boolean");
    }

    private final boolean pointOnView(float f, float f2, int i2, int i3, View view) {
        float f3 = f + ((float) i2);
        if (f3 >= ((float) view.getLeft()) && f3 < ((float) view.getRight())) {
            float f4 = f2 + ((float) i3);
            return f4 >= ((float) view.getTop()) && f4 < ((float) view.getBottom());
        }
    }

    private final void setShadow(float f) {
        setBackgroundColor((((int) (((float) ((fe.ad() & 4278190080L) >>> 24)) * (1.0f - f))) << 24) | ((int) (fe.ad() & 16777215)));
    }

    private final boolean shouldIntercept(MotionEvent motionEvent) {
        int i2 = qw.$EnumSwitchMapping$0[this.swipeArea.ordinal()];
        if (i2 == 1) {
            return canSwipeBack(motionEvent);
        }
        if (i2 == 2) {
            return inEdgeArea(motionEvent);
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        } else if (inEdgeArea(motionEvent) || canSwipeBack(motionEvent)) {
            return true;
        } else {
            return false;
        }
    }

    private final void smartSmoothScrollX(float f) {
        if (((float) getScrollX()) <= ((float) (-this.layoutWidth)) * this.swipeBackConfig.de() || f > 1000.0f) {
            this.shouldFinishActivity = true;
            startSmoothScrollX(-(this.layoutWidth + getScrollX()));
            return;
        }
        this.shouldFinishActivity = false;
        startSmoothScrollX(-getScrollX());
    }

    private final void smartSmoothScrollY(float f) {
        if (((float) getScrollY()) <= ((float) (-this.layoutHeight)) * this.swipeBackConfig.de() || f > 1000.0f) {
            this.shouldFinishActivity = true;
            startSmoothScrollY(-(this.layoutHeight + getScrollY()));
            return;
        }
        this.shouldFinishActivity = false;
        startSmoothScrollY(-getScrollY());
    }

    private final void startSmoothScrollX(int i2) {
        float coerceIn = RangesKt___RangesKt.coerceIn(((float) Math.abs(i2)) / ((float) this.layoutWidth), 0.0f, 1.0f);
        getScroller().startScroll(getScrollX(), getScrollY(), i2, 0, (int) (((float) this.swipeBackConfig.ad()) * coerceIn));
        invalidate();
    }

    private final void startSmoothScrollY(int i2) {
        int i3 = i2;
        getScroller().startScroll(getScrollX(), getScrollY(), 0, i3, (int) (((float) this.swipeBackConfig.ad()) * RangesKt___RangesKt.coerceIn(((float) Math.abs(i2)) / ((float) this.layoutHeight), 0.0f, 1.0f)));
        invalidate();
    }

    private final boolean viewCanScroll(View view) {
        if (this.swipeBackConfig.fe() == SwipeType.LEFT_TO_RIGHT) {
            return view.canScrollHorizontally(-1);
        }
        return view.canScrollVertically(-1);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void computeScroll() {
        if (getScroller().computeScrollOffset()) {
            scrollTo(getScroller().getCurrX(), getScroller().getCurrY());
            postInvalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        if ((r3 != null && r3.invoke().booleanValue()) != false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x000c
            int r2 = r6.getActionMasked()
            if (r2 != 0) goto L_0x000c
            r2 = 1
            goto L_0x000d
        L_0x000c:
            r2 = 0
        L_0x000d:
            if (r2 == 0) goto L_0x0013
            r5.ignoreTouchEvent = r1
            r5.canSwipe = r1
        L_0x0013:
            boolean r2 = r5.canSwipe
            if (r2 != 0) goto L_0x007e
            boolean r2 = r5.ignoreTouchEvent
            if (r2 != 0) goto L_0x007e
            if (r6 != 0) goto L_0x001e
            goto L_0x007e
        L_0x001e:
            int r2 = r6.getActionMasked()
            if (r2 == 0) goto L_0x006d
            r3 = 2
            if (r2 == r3) goto L_0x0028
            goto L_0x0079
        L_0x0028:
            float r2 = r6.getX()
            float r3 = r5.downX
            float r2 = r2 - r3
            float r3 = r6.getY()
            float r4 = r5.downY
            float r3 = r3 - r4
            int r4 = r5.getTouchSlop()
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
            int r2 = r5.getTouchSlop()
            float r2 = (float) r2
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0079
        L_0x0048:
            boolean r2 = r5.shouldIntercept(r6)
            if (r2 == 0) goto L_0x0064
            kotlin.jvm.functions.Function0<java.lang.Boolean> r3 = r5.onStartSwipe
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r3.invoke()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != r0) goto L_0x0060
            r3 = 1
            goto L_0x0061
        L_0x0060:
            r3 = 0
        L_0x0061:
            if (r3 == 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r1 = r2
        L_0x0065:
            if (r1 == 0) goto L_0x006a
            r5.canSwipe = r0
            return r0
        L_0x006a:
            r5.ignoreTouchEvent = r0
            goto L_0x0079
        L_0x006d:
            float r0 = r6.getX()
            r5.downX = r0
            float r0 = r6.getY()
            r5.downY = r0
        L_0x0079:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        L_0x007e:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.framework.swipeback.SwipeBackLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean getCanSwipe() {
        return this.canSwipe;
    }

    public final boolean getIgnoreTouchEvent() {
        return this.ignoreTouchEvent;
    }

    @Nullable
    public final Function0<Boolean> getOnStartSwipe() {
        return this.onStartSwipe;
    }

    @NotNull
    public final SwipeArea getSwipeArea() {
        return this.swipeArea;
    }

    @NotNull
    public final de getSwipeBackConfig() {
        return this.swipeBackConfig;
    }

    @Nullable
    public final Function1<Float, Unit> getSwipeProgressCallback() {
        return this.swipeProgressCallback;
    }

    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        return this.canSwipe || super.onInterceptTouchEvent(motionEvent);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.layoutWidth = i2;
        this.layoutHeight = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r2 != 3) goto L_0x00d3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.shouldFinishActivity
            if (r0 != 0) goto L_0x00d8
            if (r8 != 0) goto L_0x0008
            goto L_0x00d8
        L_0x0008:
            float r0 = r8.getX()
            float r1 = r8.getY()
            int r2 = r8.getActionMasked()
            if (r2 == 0) goto L_0x00b4
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x006e
            if (r2 == r3) goto L_0x0021
            r0 = 3
            if (r2 == r0) goto L_0x006e
            goto L_0x00d3
        L_0x0021:
            boolean r2 = r7.canSwipe
            if (r2 == 0) goto L_0x00d3
            android.view.VelocityTracker r2 = r7.getVelocityTracker()
            r2.addMovement(r8)
            float r2 = r7.downX
            float r0 = r0 - r2
            float r2 = r7.downY
            float r1 = r1 - r2
            fe.mmm.qw.switch.yj.de r2 = r7.swipeBackConfig
            com.tera.scan.framework.swipeback.SwipeType r2 = r2.fe()
            int[] r5 = com.tera.scan.framework.swipeback.SwipeBackLayout.qw.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
            r5 = 0
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0047
            r0 = 0
            goto L_0x004f
        L_0x0047:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x004d:
            float r0 = -r0
            int r0 = (int) r0
        L_0x004f:
            fe.mmm.qw.switch.yj.de r2 = r7.swipeBackConfig
            com.tera.scan.framework.swipeback.SwipeType r2 = r2.fe()
            int[] r6 = com.tera.scan.framework.swipeback.SwipeBackLayout.qw.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r6[r2]
            if (r2 == r4) goto L_0x006a
            if (r2 != r3) goto L_0x0064
            float r1 = -r1
            int r5 = (int) r1
            goto L_0x006a
        L_0x0064:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x006a:
            r7.scrollTo(r0, r5)
            goto L_0x00d3
        L_0x006e:
            boolean r0 = r7.canSwipe
            if (r0 == 0) goto L_0x00ac
            android.view.VelocityTracker r0 = r7.getVelocityTracker()
            r0.addMovement(r8)
            android.view.VelocityTracker r0 = r7.getVelocityTracker()
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r1)
            fe.mmm.qw.switch.yj.de r0 = r7.swipeBackConfig
            com.tera.scan.framework.swipeback.SwipeType r0 = r0.fe()
            int[] r1 = com.tera.scan.framework.swipeback.SwipeBackLayout.qw.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r4) goto L_0x00a1
            if (r0 == r3) goto L_0x0095
            goto L_0x00ac
        L_0x0095:
            android.view.VelocityTracker r0 = r7.getVelocityTracker()
            float r0 = r0.getYVelocity()
            r7.smartSmoothScrollY(r0)
            goto L_0x00ac
        L_0x00a1:
            android.view.VelocityTracker r0 = r7.getVelocityTracker()
            float r0 = r0.getXVelocity()
            r7.smartSmoothScrollX(r0)
        L_0x00ac:
            android.view.VelocityTracker r0 = r7.getVelocityTracker()
            r0.clear()
            goto L_0x00d3
        L_0x00b4:
            android.widget.Scroller r0 = r7.getScroller()
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00c5
            android.widget.Scroller r0 = r7.getScroller()
            r0.abortAnimation()
        L_0x00c5:
            android.view.VelocityTracker r0 = r7.getVelocityTracker()
            r0.clear()
            android.view.VelocityTracker r0 = r7.getVelocityTracker()
            r0.addMovement(r8)
        L_0x00d3:
            boolean r8 = super.onTouchEvent(r8)
            return r8
        L_0x00d8:
            boolean r8 = super.onTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.framework.swipeback.SwipeBackLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void scrollTo(int i2, int i3) {
        int i4;
        float f;
        int min = Math.min(i2, 0);
        int min2 = Math.min(i3, 0);
        super.scrollTo(min, min2);
        int i5 = qw.$EnumSwitchMapping$1[this.swipeBackConfig.fe().ordinal()];
        if (i5 == 1) {
            f = (float) Math.abs(min);
            i4 = this.layoutWidth;
        } else if (i5 == 2) {
            f = (float) Math.abs(min2);
            i4 = this.layoutWidth;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        float f2 = f / ((float) i4);
        Function1<? super Float, Unit> function1 = this.swipeProgressCallback;
        if (function1 != null) {
            function1.invoke(Float.valueOf(f2));
        }
        setShadow(f2);
    }

    public final void setCanSwipe(boolean z) {
        this.canSwipe = z;
    }

    public final void setIgnoreTouchEvent(boolean z) {
        this.ignoreTouchEvent = z;
    }

    public final void setOnStartSwipe(@Nullable Function0<Boolean> function0) {
        this.onStartSwipe = function0;
    }

    public final void setSwipeArea(@NotNull SwipeArea swipeArea2) {
        Intrinsics.checkNotNullParameter(swipeArea2, "<set-?>");
        this.swipeArea = swipeArea2;
    }

    public final void setSwipeBackConfig(@NotNull de deVar) {
        Intrinsics.checkNotNullParameter(deVar, "<set-?>");
        this.swipeBackConfig = deVar;
    }

    public final void setSwipeProgressCallback(@Nullable Function1<? super Float, Unit> function1) {
        this.swipeProgressCallback = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
