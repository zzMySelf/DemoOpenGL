package com.baidu.searchbox.bigimage.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020 H\u0002J\u0017\u0010-\u001a\u00020\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0/H\bJ\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u001eH\u0016J\u000e\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u000fJ\b\u00104\u001a\u00020 H\u0002R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/baidu/searchbox/bigimage/widget/BigImageViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canScroll", "", "getCanScroll", "()Z", "setCanScroll", "(Z)V", "downX", "", "downY", "hasCancelSuperIntercept", "hasCancelSuperTouch", "isAnimating", "isBeingDrag", "isUnableDrag", "lastPageDragCallback", "Lcom/baidu/searchbox/bigimage/widget/BigImageViewPager$LastPageDragCallback;", "getLastPageDragCallback", "()Lcom/baidu/searchbox/bigimage/widget/BigImageViewPager$LastPageDragCallback;", "setLastPageDragCallback", "(Lcom/baidu/searchbox/bigimage/widget/BigImageViewPager$LastPageDragCallback;)V", "startDragX", "touchSlop", "", "cancelSuper", "", "ev", "Landroid/view/MotionEvent;", "type", "checkLastPage", "computeSpringX", "dx", "disableTouch", "onInterceptTouchEvent", "onTouchEvent", "performOverDrag", "x", "resetTouch", "safeRun", "block", "Lkotlin/Function0;", "setCurrentItem", "item", "setLastMotionX", "rawX", "springBack", "LastPageDragCallback", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageViewPager.kt */
public final class BigImageViewPager extends ViewPager {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean canScroll;
    private float downX;
    private float downY;
    private boolean hasCancelSuperIntercept;
    private boolean hasCancelSuperTouch;
    /* access modifiers changed from: private */
    public boolean isAnimating;
    private boolean isBeingDrag;
    private boolean isUnableDrag;
    private LastPageDragCallback lastPageDragCallback;
    private float startDragX;
    private final int touchSlop;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/bigimage/widget/BigImageViewPager$LastPageDragCallback;", "", "onDragStart", "", "onSpringBackEnd", "onSpringBackStart", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BigImageViewPager.kt */
    public interface LastPageDragCallback {
        void onDragStart();

        void onSpringBackEnd();

        void onSpringBackStart();
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

    public final LastPageDragCallback getLastPageDragCallback() {
        return this.lastPageDragCallback;
    }

    public final void setLastPageDragCallback(LastPageDragCallback lastPageDragCallback2) {
        this.lastPageDragCallback = lastPageDragCallback2;
    }

    public final boolean getCanScroll() {
        return this.canScroll;
    }

    public final void setCanScroll(boolean z) {
        this.canScroll = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BigImageViewPager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
        this.canScroll = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BigImageViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
        this.canScroll = true;
    }

    public final void setLastMotionX(float rawX) {
        Field $this$setLastMotionX_u24lambda_u2d1;
        Field $this$setLastMotionX_u24lambda_u2d0;
        try {
            int[] loc = new int[2];
            getLocationOnScreen(loc);
            float x = rawX - ((float) loc[0]);
            Class<? super Object> superclass = getClass().getSuperclass();
            if (!(superclass == null || ($this$setLastMotionX_u24lambda_u2d0 = superclass.getDeclaredField("mLastMotionX")) == null)) {
                $this$setLastMotionX_u24lambda_u2d0.setAccessible(true);
                $this$setLastMotionX_u24lambda_u2d0.set(this, Float.valueOf(x));
            }
            Class<? super Object> superclass2 = getClass().getSuperclass();
            if (!(superclass2 == null || ($this$setLastMotionX_u24lambda_u2d1 = superclass2.getDeclaredField("mInitialMotionX")) == null)) {
                $this$setLastMotionX_u24lambda_u2d1.setAccessible(true);
                $this$setLastMotionX_u24lambda_u2d1.set(this, Float.valueOf(x));
            }
            if (BigImageViewPagerKt.DEBUG) {
                Log.d("BigImageViewPager", "set viewpager last motion x: " + x + " and rawX: " + rawX);
            }
        } catch (Exception error) {
            if (BigImageViewPagerKt.DEBUG) {
                error.printStackTrace();
                Log.e("BigImageViewPager", "reflect to set viewpager last motion x err: " + error.getMessage());
            }
        }
    }

    private final boolean safeRun(Function0<Boolean> block) {
        try {
            return block.invoke().booleanValue();
        } catch (IllegalArgumentException error) {
            if (BigImageViewPagerKt.DEBUG) {
                Log.e("BigImageViewPager", "run with IllegalArgumentException", error);
            }
            return false;
        }
    }

    private final boolean disableTouch() {
        return !this.canScroll || this.isAnimating;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        boolean z = false;
        if (disableTouch()) {
            return false;
        }
        int actionMasked = ev.getActionMasked();
        switch (actionMasked) {
            case 1:
            case 3:
                resetTouch();
                try {
                    return super.onInterceptTouchEvent(ev);
                } catch (IllegalArgumentException error$iv) {
                    if (!BigImageViewPagerKt.DEBUG) {
                        return false;
                    }
                    Log.e("BigImageViewPager", "run with IllegalArgumentException", error$iv);
                    return false;
                }
            default:
                if (actionMasked != 0) {
                    if (this.isUnableDrag) {
                        if (BigImageViewPagerKt.DEBUG) {
                            Log.d("BigImageViewPager", "onInterceptTouchEvent: unable to drag, return super");
                        }
                        this.hasCancelSuperIntercept = false;
                        try {
                            return super.onInterceptTouchEvent(ev);
                        } catch (IllegalArgumentException error$iv2) {
                            if (!BigImageViewPagerKt.DEBUG) {
                                return false;
                            }
                            Log.e("BigImageViewPager", "run with IllegalArgumentException", error$iv2);
                            return false;
                        }
                    } else if (this.isBeingDrag) {
                        if (BigImageViewPagerKt.DEBUG) {
                            Log.d("BigImageViewPager", "onInterceptTouchEvent: is being drag, return true");
                        }
                        cancelSuper(ev, 0);
                        return true;
                    }
                }
                float curX = ev.getRawX();
                float curY = ev.getRawY();
                switch (actionMasked) {
                    case 0:
                        this.downX = curX;
                        this.downY = curY;
                        this.isBeingDrag = false;
                        this.isUnableDrag = !checkLastPage();
                        break;
                    case 2:
                        float absDx = Math.abs(curX - this.downX);
                        float absDy = Math.abs(curY - this.downY);
                        int i2 = this.touchSlop;
                        if (absDx <= ((float) i2) || 0.5f * absDx <= absDy) {
                            if (absDy > ((float) i2)) {
                                this.isUnableDrag = true;
                            }
                        } else if (curX < this.downX) {
                            this.isBeingDrag = true;
                            this.startDragX = curX;
                            LastPageDragCallback lastPageDragCallback2 = this.lastPageDragCallback;
                            if (lastPageDragCallback2 != null) {
                                lastPageDragCallback2.onDragStart();
                            }
                            if (BigImageViewPagerKt.DEBUG) {
                                Log.d("BigImageViewPager", "start over drag!");
                            }
                        } else {
                            this.isUnableDrag = true;
                            if (BigImageViewPagerKt.DEBUG) {
                                Log.d("BigImageViewPager", "has drag right, unable to drag last");
                            }
                        }
                        if (this.isBeingDrag) {
                            performOverDrag(curX);
                            break;
                        }
                        break;
                    case 5:
                        if (BigImageViewPagerKt.DEBUG) {
                            Log.d("BigImageViewPager", "onInterceptTouchEvent: pointer down");
                        }
                        this.isUnableDrag = true;
                        break;
                }
                if (this.isBeingDrag) {
                    cancelSuper(ev, 0);
                    return true;
                }
                this.hasCancelSuperIntercept = false;
                try {
                    z = super.onInterceptTouchEvent(ev);
                } catch (IllegalArgumentException error$iv3) {
                    if (BigImageViewPagerKt.DEBUG) {
                        Log.e("BigImageViewPager", "run with IllegalArgumentException", error$iv3);
                    }
                }
                return z;
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        boolean z = false;
        if (ev == null || disableTouch()) {
            return false;
        }
        switch (ev.getAction()) {
            case 1:
            case 3:
                if (this.isBeingDrag) {
                    springBack();
                }
                resetTouch();
                break;
            case 2:
                if (this.isBeingDrag) {
                    performOverDrag(ev.getRawX());
                    break;
                }
                break;
        }
        if (this.isBeingDrag) {
            cancelSuper(ev, 1);
            return true;
        }
        this.hasCancelSuperTouch = false;
        try {
            z = super.onTouchEvent(ev);
        } catch (IllegalArgumentException error$iv) {
            if (BigImageViewPagerKt.DEBUG) {
                Log.e("BigImageViewPager", "run with IllegalArgumentException", error$iv);
            }
        }
        return z;
    }

    private final void cancelSuper(MotionEvent ev, int type) {
        MotionEvent cancelEvent = MotionEvent.obtain(ev.getDownTime(), ev.getEventTime(), 3, ev.getX(), ev.getY(), ev.getMetaState());
        switch (type) {
            case 0:
                if (!this.hasCancelSuperIntercept) {
                    try {
                        super.onInterceptTouchEvent(cancelEvent);
                    } catch (IllegalArgumentException error$iv) {
                        if (BigImageViewPagerKt.DEBUG) {
                            Log.e("BigImageViewPager", "run with IllegalArgumentException", error$iv);
                        }
                    }
                    this.hasCancelSuperIntercept = true;
                    if (BigImageViewPagerKt.DEBUG) {
                        Log.d("BigImageViewPager", "cancel super onInterceptTouchEvent!");
                        break;
                    }
                }
                break;
            case 1:
                if (!this.hasCancelSuperTouch) {
                    try {
                        super.onTouchEvent(cancelEvent);
                    } catch (IllegalArgumentException error$iv2) {
                        if (BigImageViewPagerKt.DEBUG) {
                            Log.e("BigImageViewPager", "run with IllegalArgumentException", error$iv2);
                        }
                    }
                    this.hasCancelSuperTouch = true;
                    if (BigImageViewPagerKt.DEBUG) {
                        Log.d("BigImageViewPager", "cancel super onTouchEvent!");
                        break;
                    }
                }
                break;
        }
        cancelEvent.recycle();
    }

    private final void resetTouch() {
        this.isBeingDrag = false;
        this.isUnableDrag = false;
        this.hasCancelSuperIntercept = false;
        this.hasCancelSuperTouch = false;
    }

    private final boolean checkLastPage() {
        PagerAdapter adapter = getAdapter();
        int count = adapter != null ? adapter.getCount() : 0;
        if (count <= 0 || getCurrentItem() != count - 1) {
            return false;
        }
        return true;
    }

    private final void performOverDrag(float x) {
        float dx = Math.min(0.0f, x - this.startDragX);
        if (BigImageViewPagerKt.DEBUG) {
            Log.d("BigImageViewPager", "perform drag: dx: " + dx);
        }
        setTranslationX(-computeSpringX(dx));
    }

    private final float computeSpringX(float dx) {
        return (float) Math.sqrt((double) ((((float) 2) * Math.abs(dx)) / 0.02f));
    }

    private final void springBack() {
        animate().translationX(0.0f).setDuration(150).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new BigImageViewPager$springBack$1(this)).start();
    }

    public void setCurrentItem(int item) {
        super.setCurrentItem(item, false);
    }
}
