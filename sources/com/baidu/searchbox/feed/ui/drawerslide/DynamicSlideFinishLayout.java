package com.baidu.searchbox.feed.ui.drawerslide;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\u0018\u0000 \u00012\u00020\u0001:\n\u0001\u0001\u0001\u0001\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010@\u001a\u00020A2\b\u00107\u001a\u0004\u0018\u000106J\u0010\u0010B\u001a\u00020A2\b\u00108\u001a\u0004\u0018\u000106J\u0010\u0010C\u001a\u00020A2\b\u0010D\u001a\u0004\u0018\u000106J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\tH\u0002J\u0010\u0010G\u001a\u00020.2\u0006\u0010F\u001a\u00020\tH\u0002J\b\u0010H\u001a\u00020AH\u0002J\u0012\u0010I\u001a\u00020A2\b\u0010J\u001a\u0004\u0018\u00010\u001fH\u0002J \u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020.H\u0002J\u0010\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020\tH\u0002J\b\u0010Q\u001a\u00020AH\u0016J\u0006\u0010R\u001a\u00020AJ\u0018\u0010S\u001a\u00020A2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020.H\u0002J\u0010\u0010V\u001a\u00020A2\u0006\u0010J\u001a\u00020\u001fH\u0002J\u0010\u0010W\u001a\u00020A2\u0006\u0010J\u001a\u00020\u001fH\u0002J\u0018\u0010X\u001a\u00020A2\u0006\u0010Y\u001a\u00020.2\u0006\u0010Z\u001a\u00020.H\u0002J(\u0010[\u001a\u00020A2\u0006\u0010F\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0002J(\u0010_\u001a\u00020A2\u0006\u0010F\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0002J \u0010`\u001a\u00020A2\u0006\u0010F\u001a\u00020\t2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0002J\u0010\u0010a\u001a\u00020A2\u0006\u0010P\u001a\u00020\tH\u0002J\u000e\u0010b\u001a\u00020A2\u0006\u0010c\u001a\u00020\tJ\b\u0010d\u001a\u00020AH\u0002J\u0014\u0010d\u001a\u0004\u0018\u00010?2\b\u0010D\u001a\u0004\u0018\u000106H\u0002J\u0018\u0010e\u001a\u00020A2\u0006\u0010J\u001a\u00020\u001f2\u0006\u0010c\u001a\u00020\tH\u0002J\u001a\u0010f\u001a\u00020A2\b\u0010J\u001a\u0004\u0018\u00010\u001f2\u0006\u0010c\u001a\u00020\tH\u0002J\u0006\u0010g\u001a\u000206J\b\u0010h\u001a\u00020\rH\u0002J\u0006\u0010i\u001a\u00020\rJ\u0010\u0010j\u001a\u00020\r2\u0006\u0010P\u001a\u00020\tH\u0002J\b\u0010k\u001a\u00020\rH\u0002J\u0010\u0010l\u001a\u00020\r2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020\r2\u0006\u0010P\u001a\u00020\tH\u0002J\u0010\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u000206H\u0002J\b\u0010s\u001a\u00020AH\u0014J\u0012\u0010t\u001a\u00020\r2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J0\u0010u\u001a\u00020A2\u0006\u0010v\u001a\u00020\r2\u0006\u0010F\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020\tH\u0014J\u0018\u0010y\u001a\u00020A2\u0006\u0010z\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0014J\u0006\u0010|\u001a\u00020AJ\u0012\u0010}\u001a\u00020\r2\b\u0010~\u001a\u0004\u0018\u00010nH\u0016J\u0018\u0010\u001a\u00020A2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020.H\u0002J\u0019\u0010\u0001\u001a\u00020A2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020.H\u0002J\t\u0010\u0001\u001a\u00020AH\u0002J\u0007\u0010\u0001\u001a\u00020AJ#\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020.2\u0006\u0010P\u001a\u00020\tH\u0002J\u0011\u0010\u0001\u001a\u00020A2\u0006\u0010m\u001a\u00020nH\u0002J\u0012\u0010\u0001\u001a\u00020A2\t\u0010\u0001\u001a\u0004\u0018\u000106J\u000f\u0010\u0001\u001a\u00020A2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020\tH\u0002J\u000f\u0010\u0001\u001a\u00020A2\u0006\u0010J\u001a\u00020\u001fJ\u0010\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020\rJ\u000f\u0010\u0001\u001a\u00020A2\u0006\u0010J\u001a\u000201J\u0012\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020.H\u0002J\u0011\u0010\u0001\u001a\u00020A2\b\u0010D\u001a\u0004\u0018\u00010?J\u0012\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020\tH\u0002J\u001b\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0002J\t\u0010\u0001\u001a\u00020AH\u0002J\t\u0010\u0001\u001a\u00020AH\u0002J\u0007\u0010\u0001\u001a\u00020AR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000206X.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activePointerId", "canSlide", "", "colorEvaluator", "Landroid/animation/TypeEvaluator;", "disableDragWhenFirstItem", "Lcom/baidu/searchbox/feed/ui/drawerslide/IDisableDragWhenFirstItem;", "getDisableDragWhenFirstItem", "()Lcom/baidu/searchbox/feed/ui/drawerslide/IDisableDragWhenFirstItem;", "setDisableDragWhenFirstItem", "(Lcom/baidu/searchbox/feed/ui/drawerslide/IDisableDragWhenFirstItem;)V", "dragScaleTransitionManager", "Lcom/baidu/searchbox/feed/ui/drawerslide/DragScaleTransitionManager;", "getDragScaleTransitionManager", "()Lcom/baidu/searchbox/feed/ui/drawerslide/DragScaleTransitionManager;", "dragScaleTransitionManager$delegate", "Lkotlin/Lazy;", "dragState", "finishColor", "finishListener", "Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout$FinishListener;", "finishView", "Lcom/baidu/searchbox/feed/ui/drawerslide/ImageViewWithMask;", "finishViewEndHeight", "finishViewEndLeft", "finishViewEndTop", "finishViewEndWidth", "initialMotionX", "", "initialMotionY", "isSlideFinish", "isSmoothnessSlide", "lastMotionX", "lastMotionY", "maxVelocity", "", "minVelocity", "nestedScrollListener", "Lcom/baidu/searchbox/feed/ui/drawerslide/ISlideNestedScrollListener;", "pointersDown", "scroller", "Landroid/widget/OverScroller;", "sharedElement", "Landroid/view/View;", "sharedRegion", "target", "targetPosArray", "", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "addSharedRegion", "", "addTarget", "applySharedElement", "view", "calcPositionFraction", "left", "calcScaleRatio", "cancel", "cancelFinishPageWithScaleAnimation", "listener", "clampMag", "value", "absMin", "absMax", "clearMotionHistory", "pointerId", "computeScroll", "disableDragOffset", "dispatchTargetReleased", "xvel", "yvel", "doFinishTransition", "doFinishTransitionWithCurrentView", "dragScale", "offsetX", "offsetY", "dragTo", "top", "dx", "dy", "dragWithFinish", "dragWithoutFinish", "ensureMotionHistorySizeForId", "exit", "exitType", "findViewPager", "finish", "finishPageWithScaleAnimation", "getTarget", "isDraggingState", "isExecutingFinishAnim", "isPointerDown", "isSharedElementPosInvalid", "isTouchInViewPager", "ev", "Landroid/view/MotionEvent;", "isValidPointerForActionMove", "loadBitmapFromView", "Landroid/graphics/Bitmap;", "v", "onDetachedFromWindow", "onInterceptTouchEvent", "onLayout", "changed", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNightModeChanged", "onTouchEvent", "event", "processFinishReleased", "processTranslateReleased", "releaseTargetForPointerUp", "resetFinishView", "saveInitialMotion", "x", "y", "saveLastMotion", "setAnchorView", "anchor", "setCanSlide", "setDragState", "state", "setFinishListener", "setIsSmoothnessSlide", "isUse", "setNestedSlideListener", "setSharedElementAlpha", "alpha", "setViewPager", "settleTargetAt", "finalLeft", "finalTop", "settlingTarget", "settlingTargetTranslationScene", "updateFinishViewEndPos", "Companion", "FinishEvent", "FinishListener", "SimpleFinishListener", "UpdateEvent", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicSlideFinishLayout.kt */
public final class DynamicSlideFinishLayout extends FrameLayout {
    public static final int ALPHA_END_COLOR = 2130706432;
    public static final int ALPHA_START_COLOR = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float DELTA_SCALE = 0.5f;
    public static final float EXIT_ANIM_SCALE_WIDTH_FACTOR = 0.25f;
    public static final int EXIT_TYPE_CURRENT_ELEMENT = 3;
    public static final int EXIT_TYPE_SHARED_ELEMENT = 1;
    public static final int EXIT_TYPE_TRANSLATION = 2;
    public static final long FINISH_TRANSITION_DURATION = 160;
    public static final int INVALID_POINTER = -1;
    public static final int SETTLING_DURATION = 160;
    public static final long SETTLING_TRANSLATION_DURATION = 200;
    public static final float SLIDE_WIDTH_SCALE_FACTOR = 0.45f;
    public static final int STATE_IDLE = 1;
    public static final int STATE_SHARED_DRAGGING = 2;
    public static final int STATE_SHARED_FINISHING = 4;
    public static final int STATE_SHARED_SETTING = 3;
    public static final int STATE_TRANSLATE_DRAGGING = 32;
    public static final int STATE_TRANSLATE_FINISHING = 34;
    public static final int STATE_TRANSLATE_SETTING = 33;
    public static final String TAG = "SlideFinishLayout";
    private int activePointerId;
    private boolean canSlide;
    private TypeEvaluator<Integer> colorEvaluator;
    private IDisableDragWhenFirstItem disableDragWhenFirstItem;
    private final Lazy dragScaleTransitionManager$delegate;
    private int dragState;
    private int finishColor;
    private FinishListener finishListener;
    private ImageViewWithMask finishView;
    private int finishViewEndHeight;
    private int finishViewEndLeft;
    private int finishViewEndTop;
    private int finishViewEndWidth;
    private float[] initialMotionX;
    private float[] initialMotionY;
    /* access modifiers changed from: private */
    public boolean isSlideFinish;
    private boolean isSmoothnessSlide;
    private float[] lastMotionX;
    private float[] lastMotionY;
    private float maxVelocity;
    private float minVelocity;
    private ISlideNestedScrollListener nestedScrollListener;
    private int pointersDown;
    private OverScroller scroller;
    private View sharedElement;
    private View sharedRegion;
    /* access modifiers changed from: private */
    public View target;
    private final int[] targetPosArray;
    private int touchSlop;
    private VelocityTracker velocityTracker;
    private ViewPager viewPager;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout$FinishListener;", "", "onDragBegin", "", "onDragging", "dx", "", "dy", "onFinish", "isSlideFinish", "", "onFinishBegin", "onReset", "onSettling", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicSlideFinishLayout.kt */
    public interface FinishListener {
        void onDragBegin();

        void onDragging(int i2, int i3);

        void onFinish(boolean z);

        void onFinishBegin();

        void onReset();

        void onSettling();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicSlideFinishLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.activePointerId = -1;
        this.dragState = 1;
        this.canSlide = true;
        this.finishColor = 2130706432;
        this.dragScaleTransitionManager$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, DynamicSlideFinishLayout$dragScaleTransitionManager$2.INSTANCE);
        this.targetPosArray = new int[2];
        setBackgroundColor(0);
        this.scroller = new OverScroller(context);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.maxVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.minVelocity = (float) ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.colorEvaluator = new DynamicSlideFinishLayout$$ExternalSyntheticLambda1();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout$Companion;", "", "()V", "ALPHA_END_COLOR", "", "ALPHA_START_COLOR", "DELTA_SCALE", "", "EXIT_ANIM_SCALE_WIDTH_FACTOR", "EXIT_TYPE_CURRENT_ELEMENT", "EXIT_TYPE_SHARED_ELEMENT", "EXIT_TYPE_TRANSLATION", "FINISH_TRANSITION_DURATION", "", "INVALID_POINTER", "SETTLING_DURATION", "SETTLING_TRANSLATION_DURATION", "SLIDE_WIDTH_SCALE_FACTOR", "STATE_IDLE", "STATE_SHARED_DRAGGING", "STATE_SHARED_FINISHING", "STATE_SHARED_SETTING", "STATE_TRANSLATE_DRAGGING", "STATE_TRANSLATE_FINISHING", "STATE_TRANSLATE_SETTING", "TAG", "", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicSlideFinishLayout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final IDisableDragWhenFirstItem getDisableDragWhenFirstItem() {
        return this.disableDragWhenFirstItem;
    }

    public final void setDisableDragWhenFirstItem(IDisableDragWhenFirstItem iDisableDragWhenFirstItem) {
        this.disableDragWhenFirstItem = iDisableDragWhenFirstItem;
    }

    public final DragScaleTransitionManager getDragScaleTransitionManager() {
        return (DragScaleTransitionManager) this.dragScaleTransitionManager$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DynamicSlideFinishLayout(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DynamicSlideFinishLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final Integer m19689_init_$lambda0(float fraction, Integer startValue, Integer endValue) {
        Integer startColor = startValue;
        Integer endColor = endValue;
        Intrinsics.checkNotNullExpressionValue(startColor, "startColor");
        Intrinsics.checkNotNullExpressionValue(endColor, "endColor");
        return Integer.valueOf(Color.argb((int) (((float) Color.alpha(startColor.intValue())) + (((float) (Color.alpha(endColor.intValue()) - Color.alpha(startColor.intValue()))) * fraction)), Color.red(startColor.intValue()), Color.green(startColor.intValue()), Color.blue(startColor.intValue())));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ImageViewWithMask it = this.finishView;
        if (it != null) {
            measureChild(it, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() * this.finishViewEndHeight) / this.finishViewEndWidth, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View view2 = this.target;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        int targetL = view2.getLeft();
        View view4 = this.target;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view4 = null;
        }
        int targetT = view4.getTop();
        ImageViewWithMask imageViewWithMask = this.finishView;
        Integer finishL = imageViewWithMask != null ? Integer.valueOf(imageViewWithMask.getLeft()) : null;
        ImageViewWithMask imageViewWithMask2 = this.finishView;
        Integer finishT = imageViewWithMask2 != null ? Integer.valueOf(imageViewWithMask2.getTop()) : null;
        super.onLayout(changed, left, top, right, bottom);
        int i2 = this.dragState;
        if (i2 == 2 || i2 == 4 || i2 == 32 || i2 == 33) {
            View view5 = this.target;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
            } else {
                view3 = view5;
            }
            View it = view3;
            it.layout(targetL, targetT, it.getMeasuredWidth() + targetL, it.getMeasuredHeight() + targetT);
            ImageViewWithMask it2 = this.finishView;
            if (it2 != null && finishL != null && finishT != null) {
                it2.layout(finishL.intValue(), finishT.intValue(), finishL.intValue() + it2.getMeasuredWidth(), finishT.intValue() + it2.getMeasuredHeight());
            }
        }
    }

    public final void addTarget(View target2) {
        if (this.target == null && target2 != null) {
            addView(target2, new FrameLayout.LayoutParams(-1, -1));
            this.target = target2;
            findViewPager();
        }
    }

    public final void applySharedElement(View view2) {
        if (view2 != null && this.finishView == null) {
            this.sharedElement = view2;
            Bitmap bitmap = loadBitmapFromView(view2);
            Bitmap bitmap2 = bitmap;
            this.finishViewEndWidth = view2.getWidth();
            this.finishViewEndHeight = view2.getHeight();
            updateFinishViewEndPos();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ImageViewWithMask imageViewWithMask = new ImageViewWithMask(context);
            this.finishView = imageViewWithMask;
            Intrinsics.checkNotNull(imageViewWithMask);
            imageViewWithMask.setClickable(false);
            ImageViewWithMask imageViewWithMask2 = this.finishView;
            Intrinsics.checkNotNull(imageViewWithMask2);
            imageViewWithMask2.setVisibility(4);
            ImageViewWithMask imageViewWithMask3 = this.finishView;
            Intrinsics.checkNotNull(imageViewWithMask3);
            imageViewWithMask3.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageViewWithMask imageViewWithMask4 = this.finishView;
            Intrinsics.checkNotNull(imageViewWithMask4);
            imageViewWithMask4.setImageBitmap(bitmap);
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -1);
            lp.gravity = 17;
            addView(this.finishView, lp);
            Rect rect = new Rect();
            view2.getLocalVisibleRect(rect);
            ImageViewWithMask imageViewWithMask5 = this.finishView;
            Intrinsics.checkNotNull(imageViewWithMask5);
            imageViewWithMask5.updateSharedViewInfo(this.finishViewEndHeight, rect);
        }
    }

    public final void setIsSmoothnessSlide(boolean isUse) {
        this.isSmoothnessSlide = isUse;
    }

    public final void onNightModeChanged() {
        View view2;
        if (this.finishView != null && (view2 = this.sharedElement) != null) {
            Intrinsics.checkNotNull(view2);
            Bitmap bitmap = loadBitmapFromView(view2);
            ImageViewWithMask imageViewWithMask = this.finishView;
            Intrinsics.checkNotNull(imageViewWithMask);
            imageViewWithMask.setImageBitmap(bitmap);
        }
    }

    public final void addSharedRegion(View sharedRegion2) {
        this.sharedRegion = sharedRegion2;
        if (sharedRegion2 != null) {
            sharedRegion2.getLocationOnScreen(this.targetPosArray);
        }
    }

    private final Bitmap loadBitmapFromView(View v) {
        Bitmap screenshot = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(screenshot, "createBitmap(v.width, v.… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(screenshot);
        canvas.translate((float) (-v.getScrollX()), (float) (-v.getScrollY()));
        v.draw(canvas);
        return screenshot;
    }

    private final boolean isTouchInViewPager(MotionEvent ev) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            return false;
        }
        ViewPager viewPager3 = viewPager2;
        int[] pos = new int[2];
        Intrinsics.checkNotNull(viewPager2);
        viewPager2.getLocationOnScreen(pos);
        int i2 = pos[0];
        int i3 = pos[1];
        int i4 = pos[0];
        ViewPager viewPager4 = this.viewPager;
        Intrinsics.checkNotNull(viewPager4);
        int width = i4 + viewPager4.getWidth();
        int i5 = pos[1];
        ViewPager viewPager5 = this.viewPager;
        Intrinsics.checkNotNull(viewPager5);
        return new Rect(i2, i3, width, i5 + viewPager5.getHeight()).contains((int) ev.getRawX(), (int) ev.getRawY());
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            if (r1 == 0) goto L_0x000f
            int r3 = r23.getActionMasked()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0010
        L_0x000f:
            r3 = 0
        L_0x0010:
            if (r1 == 0) goto L_0x001b
            int r4 = r23.getActionIndex()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x001c
        L_0x001b:
            r4 = 0
        L_0x001c:
            if (r3 != 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            int r5 = r3.intValue()
            if (r5 != 0) goto L_0x0028
            r22.cancel()
        L_0x0028:
            com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideDrawerLayout$Companion r5 = com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideDrawerLayout.Companion
            boolean r5 = r5.getDrawerInterceptAbSwitch()
            r7 = 0
            if (r5 != 0) goto L_0x0048
            boolean r5 = r0.canSlide
            if (r5 != 0) goto L_0x0036
            return r7
        L_0x0036:
            if (r1 == 0) goto L_0x0048
            com.baidu.searchbox.feed.ui.drawerslide.ISlideNestedScrollListener r5 = r0.nestedScrollListener
            if (r5 == 0) goto L_0x0044
            boolean r5 = r5.canSlideFinish(r1)
            if (r5 != 0) goto L_0x0044
            r5 = 1
            goto L_0x0045
        L_0x0044:
            r5 = r7
        L_0x0045:
            if (r5 == 0) goto L_0x0048
            return r7
        L_0x0048:
            android.view.VelocityTracker r5 = r0.velocityTracker
            if (r5 != 0) goto L_0x0052
            android.view.VelocityTracker r5 = android.view.VelocityTracker.obtain()
            r0.velocityTracker = r5
        L_0x0052:
            android.view.VelocityTracker r5 = r0.velocityTracker
            if (r5 == 0) goto L_0x0059
            r5.addMovement(r1)
        L_0x0059:
            if (r3 != 0) goto L_0x005d
            goto L_0x0074
        L_0x005d:
            int r5 = r3.intValue()
            if (r5 != 0) goto L_0x0074
            float r2 = r23.getX()
            float r5 = r23.getY()
            int r6 = r1.getPointerId(r7)
            r0.saveInitialMotion(r2, r5, r6)
            goto L_0x0213
        L_0x0074:
            r5 = 5
            if (r3 != 0) goto L_0x0078
            goto L_0x009e
        L_0x0078:
            int r8 = r3.intValue()
            if (r8 != r5) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r2 = r4.intValue()
            int r2 = r1.getPointerId(r2)
            int r5 = r4.intValue()
            float r5 = r1.getX(r5)
            int r6 = r4.intValue()
            float r6 = r1.getY(r6)
            r0.saveInitialMotion(r5, r6, r2)
            goto L_0x0213
        L_0x009e:
            if (r3 != 0) goto L_0x00a2
            goto L_0x01df
        L_0x00a2:
            int r5 = r3.intValue()
            r8 = 2
            if (r5 != r8) goto L_0x01df
            r5 = r0
            com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout r5 = (com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout) r5
            r9 = 0
            com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideDrawerLayout$Companion r10 = com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideDrawerLayout.Companion
            boolean r10 = r10.getDrawerInterceptAbSwitch()
            if (r10 == 0) goto L_0x00cc
            boolean r10 = r5.canSlide
            if (r10 != 0) goto L_0x00ba
            return r7
        L_0x00ba:
            if (r1 == 0) goto L_0x00cc
            com.baidu.searchbox.feed.ui.drawerslide.ISlideNestedScrollListener r10 = r5.nestedScrollListener
            if (r10 == 0) goto L_0x00c8
            boolean r10 = r10.canSlideFinish(r1)
            if (r10 != 0) goto L_0x00c8
            r10 = 1
            goto L_0x00c9
        L_0x00c8:
            r10 = r7
        L_0x00c9:
            if (r10 == 0) goto L_0x00cc
            return r7
        L_0x00cc:
            float[] r10 = r5.initialMotionX
            if (r10 == 0) goto L_0x01dd
            float[] r10 = r5.initialMotionY
            if (r10 != 0) goto L_0x00d6
            goto L_0x01dd
        L_0x00d6:
            int r10 = r23.getPointerCount()
            r11 = 0
        L_0x00db:
            if (r11 >= r10) goto L_0x01d9
            int r12 = r1.getPointerId(r11)
            boolean r13 = r5.isValidPointerForActionMove(r12)
            if (r13 != 0) goto L_0x00ea
            r2 = r8
            goto L_0x01d3
        L_0x00ea:
            float r13 = r1.getX(r11)
            float r14 = r1.getY(r11)
            float[] r15 = r5.initialMotionX
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            r15 = r15[r12]
            float r15 = r13 - r15
            float[] r2 = r5.initialMotionY
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2 = r2[r12]
            float r2 = r14 - r2
            float r16 = r15 * r15
            float r17 = r2 * r2
            float r16 = r16 + r17
            int r7 = r5.touchSlop
            int r7 = r7 * r7
            float r7 = (float) r7
            int r7 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0114
            r7 = 1
            goto L_0x0115
        L_0x0114:
            r7 = 0
        L_0x0115:
            if (r7 == 0) goto L_0x01c7
            float r16 = java.lang.Math.abs(r15)
            float r18 = java.lang.Math.abs(r2)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 <= 0) goto L_0x01c7
            r16 = 0
            int r16 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
            if (r16 <= 0) goto L_0x01c3
            boolean r16 = r5.isTouchInViewPager(r1)
            java.lang.String r18 = "target"
            r19 = 18
            if (r16 == 0) goto L_0x0193
            androidx.viewpager.widget.ViewPager r8 = r5.viewPager
            if (r8 == 0) goto L_0x0149
            r20 = r8
            r21 = 0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCurrentItem()
            if (r8 > 0) goto L_0x0147
            r8 = 1
            goto L_0x0148
        L_0x0147:
            r8 = 0
        L_0x0148:
            goto L_0x014a
        L_0x0149:
            r8 = 0
        L_0x014a:
            if (r8 == 0) goto L_0x018f
            com.baidu.searchbox.feed.ui.drawerslide.IDisableDragWhenFirstItem r6 = r5.disableDragWhenFirstItem
            if (r6 == 0) goto L_0x015c
            boolean r6 = r6.disableDragWhenFirstItem()
            r21 = r2
            r2 = 1
            if (r6 != r2) goto L_0x015e
            r2 = 1
            goto L_0x015f
        L_0x015c:
            r21 = r2
        L_0x015e:
            r2 = 0
        L_0x015f:
            if (r2 != 0) goto L_0x0191
            com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout$FinishListener r2 = r5.finishListener
            if (r2 == 0) goto L_0x0168
            r2.onDragBegin()
        L_0x0168:
            boolean r2 = r5.isSharedElementPosInvalid()
            if (r2 != 0) goto L_0x0188
            boolean r2 = r5.isSmoothnessSlide
            if (r2 == 0) goto L_0x0173
            goto L_0x0188
        L_0x0173:
            r2 = 2
            r5.setDragState(r2)
            android.view.View r2 = r5.target
            if (r2 != 0) goto L_0x017f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r2 = 0
        L_0x017f:
            float r6 = com.baidu.searchbox.feed.ui.drawerslide.DynamicUtilsKt.dp2px(r19)
            com.baidu.searchbox.feed.ui.drawerslide.DynamicUtilsKt.setCorner(r2, r6)
            r2 = 2
            goto L_0x01ca
        L_0x0188:
            r2 = 32
            r5.setDragState(r2)
            r2 = 2
            goto L_0x01ca
        L_0x018f:
            r21 = r2
        L_0x0191:
            r2 = 2
            goto L_0x01ca
        L_0x0193:
            r21 = r2
            com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout$FinishListener r2 = r5.finishListener
            if (r2 == 0) goto L_0x019c
            r2.onDragBegin()
        L_0x019c:
            boolean r2 = r5.isSharedElementPosInvalid()
            if (r2 != 0) goto L_0x01bc
            boolean r2 = r5.isSmoothnessSlide
            if (r2 == 0) goto L_0x01a8
            r2 = 2
            goto L_0x01bd
        L_0x01a8:
            r2 = 2
            r5.setDragState(r2)
            android.view.View r6 = r5.target
            if (r6 != 0) goto L_0x01b4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r6 = 0
        L_0x01b4:
            float r8 = com.baidu.searchbox.feed.ui.drawerslide.DynamicUtilsKt.dp2px(r19)
            com.baidu.searchbox.feed.ui.drawerslide.DynamicUtilsKt.setCorner(r6, r8)
            goto L_0x01ca
        L_0x01bc:
            r2 = 2
        L_0x01bd:
            r6 = 32
            r5.setDragState(r6)
            goto L_0x01ca
        L_0x01c3:
            r21 = r2
            r2 = r8
            goto L_0x01ca
        L_0x01c7:
            r21 = r2
            r2 = r8
        L_0x01ca:
            boolean r6 = r5.isDraggingState()
            if (r6 == 0) goto L_0x01d3
            r5.activePointerId = r12
            goto L_0x01d9
        L_0x01d3:
            int r11 = r11 + 1
            r8 = r2
            r7 = 0
            goto L_0x00db
        L_0x01d9:
            r5.saveLastMotion(r1)
            goto L_0x01de
        L_0x01dd:
        L_0x01de:
            goto L_0x0213
        L_0x01df:
            r2 = 6
            if (r3 != 0) goto L_0x01e3
            goto L_0x01f8
        L_0x01e3:
            int r5 = r3.intValue()
            if (r5 != r2) goto L_0x01f8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r2 = r4.intValue()
            int r2 = r1.getPointerId(r2)
            r0.clearMotionHistory(r2)
            goto L_0x0213
        L_0x01f8:
            if (r3 != 0) goto L_0x01fb
            goto L_0x0206
        L_0x01fb:
            int r2 = r3.intValue()
            r5 = 1
            if (r2 != r5) goto L_0x0206
            r22.cancel()
            goto L_0x0213
        L_0x0206:
            r2 = 3
            if (r3 != 0) goto L_0x020a
            goto L_0x0213
        L_0x020a:
            int r5 = r3.intValue()
            if (r5 != r2) goto L_0x0213
            r22.cancel()
        L_0x0213:
            boolean r2 = r22.isDraggingState()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent event) {
        View view2 = null;
        Integer action = event != null ? Integer.valueOf(event.getActionMasked()) : null;
        Integer actionIndex = event != null ? Integer.valueOf(event.getActionIndex()) : null;
        if (action != null && action.intValue() == 0) {
            cancel();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(event);
        }
        if (action != null && action.intValue() == 5) {
            Intrinsics.checkNotNull(actionIndex);
            int pointerId = event.getPointerId(actionIndex.intValue());
            saveInitialMotion(event.getX(actionIndex.intValue()), event.getY(actionIndex.intValue()), pointerId);
            if (isDraggingState()) {
                this.activePointerId = pointerId;
            }
        } else {
            boolean z = true;
            if (action != null && action.intValue() == 1) {
                if (isDraggingState()) {
                    releaseTargetForPointerUp();
                }
                cancel();
            } else if (action != null && action.intValue() == 3) {
                if (isDraggingState()) {
                    dispatchTargetReleased(0.0f, 0.0f);
                }
                cancel();
            } else if (action != null && action.intValue() == 2) {
                DynamicSlideFinishLayout $this$onTouchEvent_u24lambda_u2d8 = this;
                if (!($this$onTouchEvent_u24lambda_u2d8.lastMotionX == null || $this$onTouchEvent_u24lambda_u2d8.lastMotionY == null || !$this$onTouchEvent_u24lambda_u2d8.isValidPointerForActionMove($this$onTouchEvent_u24lambda_u2d8.activePointerId))) {
                    if (!DynamicSlideDrawerLayout.Companion.getDrawerInterceptAbSwitch()) {
                        ISlideNestedScrollListener iSlideNestedScrollListener = $this$onTouchEvent_u24lambda_u2d8.nestedScrollListener;
                        if (iSlideNestedScrollListener == null || iSlideNestedScrollListener.canSlideFinish(event)) {
                            z = false;
                        }
                        if (z) {
                            $this$onTouchEvent_u24lambda_u2d8.saveLastMotion(event);
                            return super.onTouchEvent(event);
                        }
                    }
                    int index = event.findPointerIndex($this$onTouchEvent_u24lambda_u2d8.activePointerId);
                    float x = event.getX(index);
                    float y = event.getY(index);
                    float[] fArr = $this$onTouchEvent_u24lambda_u2d8.lastMotionX;
                    Intrinsics.checkNotNull(fArr);
                    int dx = (int) (x - fArr[$this$onTouchEvent_u24lambda_u2d8.activePointerId]);
                    float[] fArr2 = $this$onTouchEvent_u24lambda_u2d8.lastMotionY;
                    Intrinsics.checkNotNull(fArr2);
                    int dy = (int) (y - fArr2[$this$onTouchEvent_u24lambda_u2d8.activePointerId]);
                    if ($this$onTouchEvent_u24lambda_u2d8.getDragScaleTransitionManager().getDisableDragOffset()) {
                        $this$onTouchEvent_u24lambda_u2d8.dragScale(x - $this$onTouchEvent_u24lambda_u2d8.getDragScaleTransitionManager().getLastAssociatedMotionX(), y - $this$onTouchEvent_u24lambda_u2d8.getDragScaleTransitionManager().getLastAssociatedMotionY());
                    } else {
                        View view3 = $this$onTouchEvent_u24lambda_u2d8.target;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("target");
                            view3 = null;
                        }
                        int left = view3.getLeft() + dx;
                        View view4 = $this$onTouchEvent_u24lambda_u2d8.target;
                        if (view4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("target");
                        } else {
                            view2 = view4;
                        }
                        $this$onTouchEvent_u24lambda_u2d8.dragTo(left, view2.getTop() + dy, dx, dy);
                    }
                    $this$onTouchEvent_u24lambda_u2d8.saveLastMotion(event);
                }
            } else if (action != null && action.intValue() == 6) {
                Intrinsics.checkNotNull(actionIndex);
                int pointerId2 = event.getPointerId(actionIndex.intValue());
                if (isDraggingState() && pointerId2 == this.activePointerId) {
                    int pointerCount = event.getPointerCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 < pointerCount) {
                            int id = event.getPointerId(i2);
                            if (id != this.activePointerId) {
                                this.activePointerId = id;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
                clearMotionHistory(pointerId2);
            }
        }
        return super.onTouchEvent(event);
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.dragState == 3) {
            settlingTarget();
        }
        if (this.dragState == 33) {
            settlingTargetTranslationScene();
        }
    }

    private final void settlingTargetTranslationScene() {
        FinishListener finishListener2;
        boolean keepGoing = this.scroller.computeScrollOffset();
        int x = this.scroller.getCurrX();
        View view2 = this.target;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        int dx = x - view2.getLeft();
        if (dx != 0) {
            View view4 = this.target;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view4 = null;
            }
            float clampX = view4.getX() + ((float) dx);
            View view5 = this.target;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
            } else {
                view3 = view5;
            }
            ViewCompat.offsetLeftAndRight(view3, dx);
            Integer evaluate = this.colorEvaluator.evaluate(calcPositionFraction((int) clampX), 0, 2130706432);
            Intrinsics.checkNotNullExpressionValue(evaluate, "colorEvaluator.evaluate(…LOR\n                    )");
            setBackgroundColor(evaluate.intValue());
        }
        FinishListener finishListener3 = this.finishListener;
        if (finishListener3 != null) {
            finishListener3.onSettling();
        }
        if (keepGoing && x == this.scroller.getFinalX()) {
            this.scroller.abortAnimation();
            keepGoing = false;
        }
        if (!keepGoing) {
            setDragState(1);
            if (this.scroller.getFinalX() == 0) {
                FinishListener finishListener4 = this.finishListener;
                if (finishListener4 != null) {
                    finishListener4.onReset();
                }
            } else if (this.scroller.getFinalX() == getRight() && (finishListener2 = this.finishListener) != null) {
                finishListener2.onFinish(this.isSlideFinish);
            }
        } else {
            invalidate();
        }
    }

    private final void settlingTarget() {
        boolean keepGoing = this.scroller.computeScrollOffset();
        int x = this.scroller.getCurrX();
        int y = this.scroller.getCurrY();
        View view2 = this.target;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        int dx = x - view2.getLeft();
        View view4 = this.target;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view4 = null;
        }
        int dy = y - view4.getTop();
        if (dx != 0) {
            View view5 = this.target;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view5 = null;
            }
            float clampX = view5.getX() + ((float) dx);
            View view6 = this.target;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view6 = null;
            }
            ViewCompat.offsetLeftAndRight(view6, dx);
            ImageViewWithMask it = this.finishView;
            if (it != null) {
                ViewCompat.offsetLeftAndRight(it, dx);
            }
            float scaleValue = calcScaleRatio((int) clampX);
            View view7 = this.target;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view7 = null;
            }
            view7.setScaleY(scaleValue);
            View view8 = this.target;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view8 = null;
            }
            view8.setScaleX(scaleValue);
            ImageViewWithMask it2 = this.finishView;
            if (it2 != null) {
                it2.setScaleY(scaleValue);
                it2.setScaleX(scaleValue);
            }
            Integer evaluate = this.colorEvaluator.evaluate(calcPositionFraction((int) clampX), 0, 2130706432);
            Intrinsics.checkNotNullExpressionValue(evaluate, "colorEvaluator.evaluate(…LOR\n                    )");
            setBackgroundColor(evaluate.intValue());
        }
        if (dy != 0) {
            View view9 = this.target;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view9 = null;
            }
            ViewCompat.offsetTopAndBottom(view9, dy);
            ImageViewWithMask it3 = this.finishView;
            if (it3 != null) {
                ViewCompat.offsetTopAndBottom(it3, dy);
            }
        }
        FinishListener finishListener2 = this.finishListener;
        if (finishListener2 != null) {
            finishListener2.onSettling();
        }
        if (keepGoing && x == this.scroller.getFinalX() && y == this.scroller.getFinalY()) {
            this.scroller.abortAnimation();
            keepGoing = false;
        }
        if (!keepGoing) {
            setDragState(1);
            View view10 = this.target;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
            } else {
                view3 = view10;
            }
            view3.setScaleY(1.0f);
            FinishListener finishListener3 = this.finishListener;
            if (finishListener3 != null) {
                finishListener3.onReset();
                return;
            }
            return;
        }
        invalidate();
    }

    private final boolean isDraggingState() {
        int i2 = this.dragState;
        return i2 == 2 || i2 == 32;
    }

    private final void findViewPager() {
        if (this.viewPager == null) {
            this.viewPager = findViewPager(this);
        }
    }

    private final ViewPager findViewPager(View view2) {
        if (view2 instanceof ViewPager) {
            return (ViewPager) view2;
        }
        if (!(view2 instanceof ViewGroup)) {
            return null;
        }
        int i2 = 0;
        int childCount = ((ViewGroup) view2).getChildCount();
        if (0 > childCount) {
            return null;
        }
        while (true) {
            ViewPager result = findViewPager(((ViewGroup) view2).getChildAt(i2));
            if (result != null) {
                return result;
            }
            if (i2 == childCount) {
                return null;
            }
            i2++;
        }
    }

    public final View getTarget() {
        View view2 = this.target;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("target");
        return null;
    }

    private final void cancel() {
        this.activePointerId = -1;
        float[] fArr = this.initialMotionX;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.initialMotionY, 0.0f);
            Arrays.fill(this.lastMotionX, 0.0f);
            Arrays.fill(this.lastMotionY, 0.0f);
            this.pointersDown = 0;
            VelocityTracker it = this.velocityTracker;
            if (it != null) {
                it.recycle();
                this.velocityTracker = null;
            }
            getDragScaleTransitionManager().reset();
        }
    }

    private final void clearMotionHistory(int pointerId) {
        if (this.initialMotionX != null && isPointerDown(pointerId)) {
            float[] fArr = this.initialMotionX;
            Intrinsics.checkNotNull(fArr);
            fArr[pointerId] = 0.0f;
            float[] fArr2 = this.initialMotionY;
            Intrinsics.checkNotNull(fArr2);
            fArr2[pointerId] = 0.0f;
            float[] fArr3 = this.lastMotionX;
            Intrinsics.checkNotNull(fArr3);
            fArr3[pointerId] = 0.0f;
            float[] fArr4 = this.lastMotionY;
            Intrinsics.checkNotNull(fArr4);
            fArr4[pointerId] = 0.0f;
            this.pointersDown &= ~(1 << pointerId);
        }
    }

    /* access modifiers changed from: private */
    public final void setDragState(int state) {
        if (this.dragState != state) {
            this.dragState = state;
        }
    }

    private final void saveLastMotion(MotionEvent ev) {
        int pointerCount = ev.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = ev.getPointerId(i2);
            if (isValidPointerForActionMove(pointerId)) {
                float x = ev.getX(i2);
                float y = ev.getY(i2);
                float[] fArr = this.lastMotionX;
                Intrinsics.checkNotNull(fArr);
                fArr[pointerId] = x;
                float[] fArr2 = this.lastMotionY;
                Intrinsics.checkNotNull(fArr2);
                fArr2[pointerId] = y;
            }
        }
    }

    private final boolean isValidPointerForActionMove(int pointerId) {
        if (!isPointerDown(pointerId)) {
            return false;
        }
        return true;
    }

    private final boolean isPointerDown(int pointerId) {
        return (this.pointersDown & (1 << pointerId)) != 0;
    }

    public final void resetFinishView() {
        ImageViewWithMask imageViewWithMask = this.finishView;
        if (imageViewWithMask != null) {
            removeView(imageViewWithMask);
            this.finishView = null;
        }
    }

    private final void saveInitialMotion(float x, float y, int pointerId) {
        ensureMotionHistorySizeForId(pointerId);
        float[] fArr = this.initialMotionX;
        Intrinsics.checkNotNull(fArr);
        fArr[pointerId] = x;
        float[] fArr2 = this.lastMotionX;
        Intrinsics.checkNotNull(fArr2);
        fArr2[pointerId] = x;
        float[] fArr3 = this.initialMotionY;
        Intrinsics.checkNotNull(fArr3);
        fArr3[pointerId] = y;
        float[] fArr4 = this.lastMotionY;
        Intrinsics.checkNotNull(fArr4);
        fArr4[pointerId] = y;
        this.pointersDown |= 1 << pointerId;
        getDragScaleTransitionManager().setLastAssociatedMotionX(x);
        getDragScaleTransitionManager().setLastAssociatedMotionY(y);
    }

    private final void ensureMotionHistorySizeForId(int pointerId) {
        float[] fArr = this.initialMotionX;
        if (fArr != null) {
            Intrinsics.checkNotNull(fArr);
            if (fArr.length > pointerId) {
                return;
            }
        }
        float[] imx = new float[(pointerId + 1)];
        float[] imy = new float[(pointerId + 1)];
        float[] lmx = new float[(pointerId + 1)];
        float[] lmy = new float[(pointerId + 1)];
        float[] fArr2 = this.initialMotionX;
        if (fArr2 != null) {
            Intrinsics.checkNotNull(fArr2);
            float[] fArr3 = this.initialMotionX;
            Intrinsics.checkNotNull(fArr3);
            System.arraycopy(fArr2, 0, imx, 0, fArr3.length);
            float[] fArr4 = this.initialMotionY;
            Intrinsics.checkNotNull(fArr4);
            float[] fArr5 = this.initialMotionY;
            Intrinsics.checkNotNull(fArr5);
            System.arraycopy(fArr4, 0, imy, 0, fArr5.length);
            float[] fArr6 = this.lastMotionX;
            Intrinsics.checkNotNull(fArr6);
            float[] fArr7 = this.lastMotionX;
            Intrinsics.checkNotNull(fArr7);
            System.arraycopy(fArr6, 0, lmx, 0, fArr7.length);
            float[] fArr8 = this.lastMotionY;
            Intrinsics.checkNotNull(fArr8);
            float[] fArr9 = this.lastMotionY;
            Intrinsics.checkNotNull(fArr9);
            System.arraycopy(fArr8, 0, lmy, 0, fArr9.length);
        }
        this.initialMotionX = imx;
        this.initialMotionY = imy;
        this.lastMotionX = lmx;
        this.lastMotionY = lmy;
    }

    private final void dispatchTargetReleased(float xvel, float yvel) {
        if (this.dragState == 2) {
            processFinishReleased(xvel, yvel);
        }
        if (this.dragState == 32) {
            processTranslateReleased(xvel, yvel);
        }
        if (isDraggingState()) {
            setDragState(1);
        }
    }

    private final void processTranslateReleased(float xvel, float yvel) {
        float abs = Math.abs(xvel);
        float f2 = this.minVelocity;
        if (abs <= f2) {
            View view2 = this.target;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view2 = null;
            }
            if (view2.getLeft() < getRight() / 5) {
                settleTargetAt(0);
            } else {
                settleTargetAt(getRight());
            }
        } else if (xvel > f2) {
            settleTargetAt(getRight());
        } else {
            settleTargetAt(0);
        }
    }

    private final void processFinishReleased(float xvel, float yvel) {
        FinishListener it = this.finishListener;
        if (it != null) {
            View view2 = this.target;
            View view3 = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view2 = null;
            }
            if (view2.getScaleY() < 1.0f) {
                if (getDragScaleTransitionManager().getDisableDragOffset()) {
                    finish(it, 3);
                    return;
                } else if (xvel > this.minVelocity) {
                    this.isSlideFinish = true;
                    finish(it, 1);
                    return;
                }
            }
            int[] targetGlobalPos = new int[2];
            View view4 = this.target;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view4 = null;
            }
            view4.getLocationOnScreen(targetGlobalPos);
            View view5 = this.target;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
            } else {
                view3 = view5;
            }
            if (view3.getScaleY() < 1.0f && ((float) targetGlobalPos[0]) > ((float) getWidth()) * 0.25f) {
                this.isSlideFinish = true;
                finish(it, 1);
                return;
            }
        }
        settleTargetAt(0, 0);
    }

    private final void finish(FinishListener listener, int exitType) {
        if (!getDragScaleTransitionManager().interceptFinish(exitType, new DynamicSlideFinishLayout$finish$1(this, listener, exitType))) {
            if (exitType != 1 || isSharedElementPosInvalid() || this.isSmoothnessSlide) {
                setSharedElementAlpha(1.0f);
                settleTargetAt(getRight());
            } else if (this.finishView == null) {
                listener.onFinish(this.isSlideFinish);
            } else {
                doFinishTransition(listener);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void finishPageWithScaleAnimation(FinishListener listener, int exitType) {
        DragScaleTransitionManager dragScaleTransitionManager = getDragScaleTransitionManager();
        View view2 = this.target;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        if (!dragScaleTransitionManager.matchExitCondition(view2)) {
            cancelFinishPageWithScaleAnimation(listener);
        } else if (listener != null) {
            doFinishTransitionWithCurrentView(listener);
        }
    }

    /* access modifiers changed from: private */
    public final void cancelFinishPageWithScaleAnimation(FinishListener listener) {
        View view2 = this.target;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        ObjectAnimator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(view2, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f})});
        Intrinsics.checkNotNullExpressionValue(scaleAnimator, "ofPropertyValuesHolder(\n…t(\"scaleY\", 1f)\n        )");
        ObjectAnimator $this$cancelFinishPageWithScaleAnimation_u24lambda_u2d15 = scaleAnimator;
        $this$cancelFinishPageWithScaleAnimation_u24lambda_u2d15.setDuration(160);
        $this$cancelFinishPageWithScaleAnimation_u24lambda_u2d15.addListener(new DynamicSlideFinishLayout$cancelFinishPageWithScaleAnimation$scaleAnimator$1$1(this));
        scaleAnimator.start();
        if (listener != null) {
            listener.onReset();
        }
    }

    private final boolean isSharedElementPosInvalid() {
        int[] posArray = new int[2];
        View view2 = this.sharedElement;
        if (view2 != null) {
            view2.getLocationOnScreen(posArray);
        }
        int endLeft = posArray[0];
        int endTop = posArray[1];
        if (Math.abs(endLeft - this.finishViewEndLeft) > 1 || Math.abs(endTop - this.finishViewEndTop) > 1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
        if (r12[1] <= 0) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void doFinishTransition(com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout.FinishListener r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            com.baidu.searchbox.feed.ui.drawerslide.ImageViewWithMask r2 = r0.finishView
            if (r2 == 0) goto L_0x0149
            r3 = 0
            r4 = 4
            r0.setDragState(r4)
            r26.onFinishBegin()
            boolean r4 = r25.isSharedElementPosInvalid()
            r5 = 1
            if (r4 == 0) goto L_0x0020
            r0.setDragState(r5)
            boolean r4 = r0.isSlideFinish
            r1.onFinish(r4)
            return
        L_0x0020:
            int r4 = r2.getWidth()
            if (r4 == 0) goto L_0x0146
            int r4 = r2.getHeight()
            if (r4 != 0) goto L_0x0030
            r19 = r3
            goto L_0x0148
        L_0x0030:
            int r4 = r0.finishViewEndWidth
            float r4 = (float) r4
            int r6 = r2.getWidth()
            float r6 = (float) r6
            float r4 = r4 / r6
            r6 = 2
            float[] r7 = new float[r6]
            float r8 = r2.getScaleX()
            r9 = 0
            r7[r9] = r8
            r7[r5] = r4
            java.lang.String r8 = "scaleX"
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r2, r8, r7)
            int r8 = r0.finishViewEndHeight
            float r8 = (float) r8
            int r10 = r2.getHeight()
            float r10 = (float) r10
            float r8 = r8 / r10
            float[] r10 = new float[r6]
            float r11 = r2.getScaleY()
            r10[r9] = r11
            r10[r5] = r8
            java.lang.String r11 = "scaleY"
            android.animation.ObjectAnimator r10 = android.animation.ObjectAnimator.ofFloat(r2, r11, r10)
            int[] r11 = new int[r6]
            r2.getLocationOnScreen(r11)
            android.view.View r12 = r0.sharedRegion
            if (r12 == 0) goto L_0x0079
            int[] r12 = r0.targetPosArray
            r13 = r12[r9]
            if (r13 > 0) goto L_0x0083
            r12 = r12[r5]
            if (r12 > 0) goto L_0x0083
        L_0x0079:
            int[] r12 = r0.targetPosArray
            r13 = r11[r9]
            r12[r9] = r13
            r13 = r11[r5]
            r12[r5] = r13
        L_0x0083:
            r12 = r11[r9]
            float r13 = r2.getScaleX()
            float r13 = r13 - r4
            int r14 = r2.getWidth()
            float r14 = (float) r14
            float r13 = r13 * r14
            int r14 = r0.finishViewEndLeft
            int r14 = r14 - r12
            float r14 = (float) r14
            float r15 = (float) r6
            float r16 = r13 / r15
            float r14 = r14 - r16
            float[] r5 = new float[r6]
            float r17 = r2.getTranslationX()
            r5[r9] = r17
            float r17 = r2.getTranslationX()
            float r17 = r17 + r14
            r16 = 1
            r5[r16] = r17
            java.lang.String r9 = "translationX"
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofFloat(r2, r9, r5)
            int[] r9 = r0.targetPosArray
            r18 = r9[r16]
            r19 = r11[r16]
            int r6 = r18 - r19
            r9 = r9[r16]
            float r18 = r2.getScaleY()
            float r18 = r18 - r8
            r19 = r3
            int r3 = r2.getHeight()
            float r3 = (float) r3
            float r18 = r18 * r3
            int r3 = r0.finishViewEndTop
            int r3 = r3 - r9
            float r3 = (float) r3
            float r15 = r18 / r15
            float r3 = r3 - r15
            float r15 = r2.getTranslationY()
            r21 = r4
            float r4 = (float) r6
            float r15 = r15 + r4
            float r4 = r15 + r3
            r22 = r3
            r3 = 2
            float[] r3 = new float[r3]
            r17 = 0
            r3[r17] = r15
            r16 = 1
            r3[r16] = r4
            r16 = r4
            java.lang.String r4 = "translationY"
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r2, r4, r3)
            android.animation.AnimatorSet r4 = new android.animation.AnimatorSet
            r4.<init>()
            r17 = r6
            r6 = r7
            android.animation.Animator r6 = (android.animation.Animator) r6
            android.animation.AnimatorSet$Builder r6 = r4.play(r6)
            r20 = r8
            r8 = r10
            android.animation.Animator r8 = (android.animation.Animator) r8
            android.animation.AnimatorSet$Builder r6 = r6.with(r8)
            r8 = r5
            android.animation.Animator r8 = (android.animation.Animator) r8
            android.animation.AnimatorSet$Builder r6 = r6.with(r8)
            r8 = r3
            android.animation.Animator r8 = (android.animation.Animator) r8
            r6.with(r8)
            com.baidu.searchbox.feed.ui.drawerslide.CubicBezierInterpolator r6 = new com.baidu.searchbox.feed.ui.drawerslide.CubicBezierInterpolator
            r8 = 0
            r23 = r3
            r3 = 1065353216(0x3f800000, float:1.0)
            r24 = r5
            r5 = 1045220557(0x3e4ccccd, float:0.2)
            r6.<init>(r5, r8, r5, r3)
            android.animation.TimeInterpolator r6 = (android.animation.TimeInterpolator) r6
            r4.setInterpolator(r6)
            r5 = 160(0xa0, double:7.9E-322)
            r4.setDuration(r5)
            com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout$doFinishTransition$1$1 r3 = new com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout$doFinishTransition$1$1
            r3.<init>(r0, r1, r2)
            android.animation.Animator$AnimatorListener r3 = (android.animation.Animator.AnimatorListener) r3
            r4.addListener(r3)
            com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout$$ExternalSyntheticLambda0 r3 = new com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout$$ExternalSyntheticLambda0
            r3.<init>(r2, r0)
            r7.addUpdateListener(r3)
            r4.start()
            goto L_0x0149
        L_0x0146:
            r19 = r3
        L_0x0148:
            return
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout.doFinishTransition(com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideFinishLayout$FinishListener):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: doFinishTransition$lambda-17$lambda-16  reason: not valid java name */
    public static final void m19690doFinishTransition$lambda17$lambda16(ImageViewWithMask $it, DynamicSlideFinishLayout this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter($it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        float currentFraction = animation.getAnimatedFraction();
        $it.updateFraction(Float.valueOf(currentFraction));
        Integer evaluate = this$0.colorEvaluator.evaluate(currentFraction, Integer.valueOf(this$0.finishColor), 0);
        Intrinsics.checkNotNullExpressionValue(evaluate, "colorEvaluator.evaluate(…                        )");
        this$0.setBackgroundColor(evaluate.intValue());
    }

    public final boolean isExecutingFinishAnim() {
        int i2 = this.dragState;
        return i2 == 4 || i2 == 33;
    }

    public final void updateFinishViewEndPos() {
        View it = this.sharedElement;
        if (it != null) {
            int[] posArray = new int[2];
            it.getLocationOnScreen(posArray);
            this.finishViewEndLeft = posArray[0];
            this.finishViewEndTop = posArray[1];
        }
    }

    private final void releaseTargetForPointerUp() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(1000, this.maxVelocity);
        }
        float xvel = 0.0f;
        float yvel = 0.0f;
        VelocityTracker it = this.velocityTracker;
        if (it != null) {
            xvel = clampMag(it.getXVelocity(), this.minVelocity, this.maxVelocity);
            yvel = clampMag(it.getYVelocity(), this.minVelocity, this.maxVelocity);
        }
        dispatchTargetReleased(xvel, yvel);
    }

    private final float calcScaleRatio(int left) {
        float f2 = 0.5f;
        float dRatio = (((float) Math.abs(left)) / (((float) getWidth()) * 0.45f)) * 0.5f;
        if (dRatio <= 0.5f) {
            f2 = dRatio;
        }
        float dRatio2 = f2;
        if (left > 0) {
            return ((float) 1) - dRatio2;
        }
        return ((float) 1) + dRatio2;
    }

    private final float clampMag(float value, float absMin, float absMax) {
        float absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0.0f;
        }
        if (absValue <= absMax) {
            return value;
        }
        if (value > 0.0f) {
            return absMax;
        }
        return -absMax;
    }

    private final float calcPositionFraction(int left) {
        return ((float) Math.abs(left - getWidth())) / ((float) getWidth());
    }

    private final void dragScale(float offsetX, float offsetY) {
        float scaleValue = calcScaleRatio((int) offsetX);
        View view2 = null;
        if (scaleValue > 1.0f) {
            scaleValue = 1.0f;
            View view3 = this.target;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view3 = null;
            }
            DynamicUtilsKt.setCorner(view3, 0.0f);
        }
        getDragScaleTransitionManager().onDragScale(offsetX, offsetY, scaleValue);
        View view4 = this.target;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view4 = null;
        }
        view4.setScaleY(scaleValue);
        View view5 = this.target;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
        } else {
            view2 = view5;
        }
        view2.setScaleX(scaleValue);
        ImageViewWithMask $this$dragScale_u24lambda_u2d20 = this.finishView;
        if ($this$dragScale_u24lambda_u2d20 != null) {
            $this$dragScale_u24lambda_u2d20.setScaleY(scaleValue);
            $this$dragScale_u24lambda_u2d20.setScaleX(scaleValue);
        }
        Integer evaluate = this.colorEvaluator.evaluate(calcPositionFraction((int) offsetX), 0, 2130706432);
        Intrinsics.checkNotNullExpressionValue(evaluate, "colorEvaluator.evaluate(…ALPHA_END_COLOR\n        )");
        int intValue = evaluate.intValue();
        this.finishColor = intValue;
        setBackgroundColor(intValue);
    }

    private final void dragTo(int left, int top, int dx, int dy) {
        if (this.dragState == 2) {
            setSharedElementAlpha(0.0f);
            dragWithFinish(left, top, dx, dy);
        }
        if (this.dragState == 32) {
            setSharedElementAlpha(1.0f);
            dragWithoutFinish(left, dx, dy);
        }
    }

    /* access modifiers changed from: private */
    public final void setSharedElementAlpha(float alpha) {
        View view2;
        View view3 = this.sharedElement;
        if (!Intrinsics.areEqual(view3 != null ? Float.valueOf(view3.getAlpha()) : null, alpha) && (view2 = this.sharedElement) != null) {
            view2.setAlpha(alpha);
        }
    }

    private final void dragWithoutFinish(int left, int dx, int dy) {
        int clampX = left;
        View view2 = this.target;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        int oldLeft = view2.getLeft();
        int clampX2 = clampX < 0 ? 0 : clampX;
        int clampX3 = clampX2 > getRight() ? getRight() : clampX2;
        if (dx != 0) {
            FinishListener finishListener2 = this.finishListener;
            if (finishListener2 != null) {
                finishListener2.onDragging(dx, dy);
            }
            View view4 = this.target;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
            } else {
                view3 = view4;
            }
            ViewCompat.offsetLeftAndRight(view3, clampX3 - oldLeft);
            ImageViewWithMask it = this.finishView;
            if (it != null) {
                ViewCompat.offsetLeftAndRight(it, clampX3 - oldLeft);
            }
            Integer evaluate = this.colorEvaluator.evaluate(calcPositionFraction(clampX3), 0, 2130706432);
            Intrinsics.checkNotNullExpressionValue(evaluate, "colorEvaluator.evaluate(…LOR\n                    )");
            setBackgroundColor(evaluate.intValue());
        }
    }

    private final void dragWithFinish(int left, int top, int dx, int dy) {
        int clampX = left;
        int clampY = top;
        View view2 = this.target;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        int oldLeft = view2.getLeft();
        View view4 = this.target;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view4 = null;
        }
        int oldTop = view4.getTop();
        if (dx != 0) {
            FinishListener finishListener2 = this.finishListener;
            if (finishListener2 != null) {
                finishListener2.onDragging(dx, dy);
            }
            View view5 = this.target;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view5 = null;
            }
            ViewCompat.offsetLeftAndRight(view5, clampX - oldLeft);
            ImageViewWithMask it = this.finishView;
            if (it != null) {
                ViewCompat.offsetLeftAndRight(it, clampX - oldLeft);
            }
            float scaleValue = calcScaleRatio(clampX);
            View view6 = this.target;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view6 = null;
            }
            view6.setScaleY(scaleValue);
            View view7 = this.target;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
                view7 = null;
            }
            view7.setScaleX(scaleValue);
            ImageViewWithMask it2 = this.finishView;
            if (it2 != null) {
                it2.setScaleY(scaleValue);
                it2.setScaleX(scaleValue);
            }
            Integer evaluate = this.colorEvaluator.evaluate(calcPositionFraction(clampX), 0, 2130706432);
            Intrinsics.checkNotNullExpressionValue(evaluate, "colorEvaluator.evaluate(…A_END_COLOR\n            )");
            int intValue = evaluate.intValue();
            this.finishColor = intValue;
            setBackgroundColor(intValue);
        }
        if (dy != 0) {
            FinishListener finishListener3 = this.finishListener;
            if (finishListener3 != null) {
                finishListener3.onDragging(dx, dy);
            }
            View view8 = this.target;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("target");
            } else {
                view3 = view8;
            }
            ViewCompat.offsetTopAndBottom(view3, clampY - oldTop);
            ImageViewWithMask it3 = this.finishView;
            if (it3 != null) {
                ViewCompat.offsetTopAndBottom(it3, clampY - oldTop);
            }
        }
    }

    private final void settleTargetAt(int finalLeft) {
        View view2 = this.target;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        int startLeft = view2.getLeft();
        int dx = finalLeft - startLeft;
        if (dx == 0) {
            this.scroller.abortAnimation();
            setDragState(1);
            if (finalLeft == getRight()) {
                FinishListener finishListener2 = this.finishListener;
                if (finishListener2 != null) {
                    finishListener2.onFinish(this.isSlideFinish);
                    return;
                }
                return;
            }
            FinishListener finishListener3 = this.finishListener;
            if (finishListener3 != null) {
                finishListener3.onReset();
                return;
            }
            return;
        }
        this.scroller.startScroll(startLeft, 0, dx, 0, (int) 200);
        setDragState(33);
        invalidate();
    }

    private final void settleTargetAt(int finalLeft, int finalTop) {
        View view2 = this.target;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view2 = null;
        }
        DynamicUtilsKt.setCorner(view2, 0.0f);
        View view4 = this.target;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            view4 = null;
        }
        int startLeft = view4.getLeft();
        View view5 = this.target;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
        } else {
            view3 = view5;
        }
        int startTop = view3.getTop();
        int dx = finalLeft - startLeft;
        int dy = finalTop - startTop;
        if (dx == 0 && dy == 0) {
            this.scroller.abortAnimation();
            setDragState(1);
            FinishListener finishListener2 = this.finishListener;
            if (finishListener2 != null) {
                finishListener2.onReset();
                return;
            }
            return;
        }
        this.scroller.startScroll(startLeft, startTop, dx, dy, 160);
        setDragState(3);
        invalidate();
    }

    public final void setCanSlide(boolean canSlide2) {
        this.canSlide = canSlide2;
    }

    public final void exit(int exitType) {
        FinishListener it = this.finishListener;
        if (it != null) {
            this.isSlideFinish = false;
            finish(it, exitType);
        }
    }

    public final void setFinishListener(FinishListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.finishListener = listener;
    }

    public final void setNestedSlideListener(ISlideNestedScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.nestedScrollListener = listener;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.sharedElement = null;
    }

    public final void setViewPager(ViewPager view2) {
        this.viewPager = view2;
    }

    public final void setAnchorView(View anchor) {
        getDragScaleTransitionManager().setAnchorView(anchor);
    }

    private final void doFinishTransitionWithCurrentView(FinishListener listener) {
        setDragState(4);
        listener.onFinishBegin();
        View targetView = this.target;
        if (targetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("target");
            targetView = null;
        }
        getDragScaleTransitionManager().doFinishTransitionWithCurrentView(targetView, new DynamicSlideFinishLayout$doFinishTransitionWithCurrentView$1$1(this, listener));
    }

    public final void disableDragOffset() {
        getDragScaleTransitionManager().setDisableDragOffset(true);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout$FinishEvent;", "", "()V", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicSlideFinishLayout.kt */
    public static final class FinishEvent {
        public static final FinishEvent INSTANCE = new FinishEvent();

        private FinishEvent() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout$UpdateEvent;", "", "()V", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicSlideFinishLayout.kt */
    public static final class UpdateEvent {
        public static final UpdateEvent INSTANCE = new UpdateEvent();

        private UpdateEvent() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout$SimpleFinishListener;", "Lcom/baidu/searchbox/feed/ui/drawerslide/DynamicSlideFinishLayout$FinishListener;", "()V", "onDragBegin", "", "onDragging", "dx", "", "dy", "onFinish", "isSlideFinish", "", "onFinishBegin", "onReset", "onSettling", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicSlideFinishLayout.kt */
    public static abstract class SimpleFinishListener implements FinishListener {
        public void onFinishBegin() {
        }

        public void onFinish(boolean isSlideFinish) {
        }

        public void onReset() {
        }

        public void onDragBegin() {
        }

        public void onDragging(int dx, int dy) {
        }

        public void onSettling() {
        }
    }
}
