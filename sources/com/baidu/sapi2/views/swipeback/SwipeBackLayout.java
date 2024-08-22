package com.baidu.sapi2.views.swipeback;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.passport.sapi2.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SwipeBackLayout extends ViewGroup {
    private static final String t = "SwipeBackLayout";
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 4;
    public static final int x = 8;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f18596a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewDragHelper f18597b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View f18598c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f18599d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f18600e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f18601f;

    /* renamed from: g  reason: collision with root package name */
    private int f18602g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public float f18603h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f18604i;

    /* renamed from: j  reason: collision with root package name */
    private int f18605j;
    private boolean k;
    /* access modifiers changed from: private */
    public float l;
    /* access modifiers changed from: private */
    public float m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    private float p;
    /* access modifiers changed from: private */
    public int q;
    /* access modifiers changed from: private */
    public d r;
    private d s;

    class a implements d {
        a() {
        }

        public void a(View view2, float f2, float f3) {
            SwipeBackLayout.this.invalidate();
        }

        public void a(View view2, boolean z) {
            if (z) {
                SwipeBackLayout.this.a();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    private class c extends ViewDragHelper.Callback {
        private c() {
        }

        public int clampViewPositionHorizontal(View view2, int i2, int i3) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int unused = swipeBackLayout.n = swipeBackLayout.getPaddingLeft();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.f18596a == 1 && !com.baidu.sapi2.views.swipeback.a.a.c(SwipeBackLayout.this.f18599d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    int unused2 = swipeBackLayout2.n = Math.min(Math.max(i2, swipeBackLayout2.getPaddingLeft()), SwipeBackLayout.this.f18600e);
                } else if (SwipeBackLayout.this.f18596a == 2 && !com.baidu.sapi2.views.swipeback.a.a.b(SwipeBackLayout.this.f18599d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    int unused3 = swipeBackLayout3.n = Math.min(Math.max(i2, -swipeBackLayout3.f18600e), SwipeBackLayout.this.getPaddingRight());
                }
            }
            return SwipeBackLayout.this.n;
        }

        public int clampViewPositionVertical(View view2, int i2, int i3) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int unused = swipeBackLayout.o = swipeBackLayout.getPaddingTop();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.f18596a == 4 && !com.baidu.sapi2.views.swipeback.a.a.d(SwipeBackLayout.this.f18599d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    int unused2 = swipeBackLayout2.o = Math.min(Math.max(i2, swipeBackLayout2.getPaddingTop()), SwipeBackLayout.this.f18601f);
                } else if (SwipeBackLayout.this.f18596a == 8 && !com.baidu.sapi2.views.swipeback.a.a.a(SwipeBackLayout.this.f18599d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    int unused3 = swipeBackLayout3.o = Math.min(Math.max(i2, -swipeBackLayout3.f18601f), SwipeBackLayout.this.getPaddingBottom());
                }
            }
            return SwipeBackLayout.this.o;
        }

        public int getViewHorizontalDragRange(View view2) {
            return SwipeBackLayout.this.f18600e;
        }

        public int getViewVerticalDragRange(View view2) {
            return SwipeBackLayout.this.f18601f;
        }

        public void onEdgeTouched(int i2, int i3) {
            super.onEdgeTouched(i2, i3);
            int unused = SwipeBackLayout.this.q = i2;
        }

        public void onViewDragStateChanged(int i2) {
            super.onViewDragStateChanged(i2);
            if (i2 == 0 && SwipeBackLayout.this.r != null) {
                if (SwipeBackLayout.this.f18604i == 0.0f) {
                    SwipeBackLayout.this.r.a(SwipeBackLayout.this.f18598c, false);
                } else if (SwipeBackLayout.this.f18604i == 1.0f) {
                    SwipeBackLayout.this.r.a(SwipeBackLayout.this.f18598c, true);
                }
            }
        }

        public void onViewPositionChanged(View view2, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view2, i2, i3, i4, i5);
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            int h2 = SwipeBackLayout.this.f18596a;
            if (h2 == 1 || h2 == 2) {
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                float unused = swipeBackLayout.f18604i = (((float) abs) * 1.0f) / ((float) swipeBackLayout.f18600e);
            } else if (h2 == 4 || h2 == 8) {
                SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                float unused2 = swipeBackLayout2.f18604i = (((float) abs2) * 1.0f) / ((float) swipeBackLayout2.f18601f);
            }
            if (SwipeBackLayout.this.r != null) {
                SwipeBackLayout.this.r.a(SwipeBackLayout.this.f18598c, SwipeBackLayout.this.f18604i, SwipeBackLayout.this.f18603h);
            }
        }

        public void onViewReleased(View view2, float f2, float f3) {
            super.onViewReleased(view2, f2, f3);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            boolean z = false;
            int unused = swipeBackLayout.n = swipeBackLayout.o = 0;
            if (!SwipeBackLayout.this.c()) {
                int unused2 = SwipeBackLayout.this.q = -1;
                return;
            }
            int unused3 = SwipeBackLayout.this.q = -1;
            if (SwipeBackLayout.this.a(f2, f3) || SwipeBackLayout.this.f18604i >= SwipeBackLayout.this.f18603h) {
                z = true;
            }
            if (z) {
                int h2 = SwipeBackLayout.this.f18596a;
                if (h2 == 1) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    swipeBackLayout2.a(swipeBackLayout2.f18600e);
                } else if (h2 == 2) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    swipeBackLayout3.a(-swipeBackLayout3.f18600e);
                } else if (h2 == 4) {
                    SwipeBackLayout swipeBackLayout4 = SwipeBackLayout.this;
                    swipeBackLayout4.b(swipeBackLayout4.f18601f);
                } else if (h2 == 8) {
                    SwipeBackLayout swipeBackLayout5 = SwipeBackLayout.this;
                    swipeBackLayout5.b(-swipeBackLayout5.f18601f);
                }
            } else {
                int h3 = SwipeBackLayout.this.f18596a;
                if (h3 == 1 || h3 == 2) {
                    SwipeBackLayout swipeBackLayout6 = SwipeBackLayout.this;
                    swipeBackLayout6.a(swipeBackLayout6.getPaddingLeft());
                } else if (h3 == 4 || h3 == 8) {
                    SwipeBackLayout swipeBackLayout7 = SwipeBackLayout.this;
                    swipeBackLayout7.b(swipeBackLayout7.getPaddingTop());
                }
            }
        }

        public boolean tryCaptureView(View view2, int i2) {
            return view2 == SwipeBackLayout.this.f18598c;
        }

        /* synthetic */ c(SwipeBackLayout swipeBackLayout, a aVar) {
            this();
        }
    }

    public interface d {
        void a(View view2, float f2, float f3);

        void a(View view2, boolean z);
    }

    public SwipeBackLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void computeScroll() {
        if (this.f18597b.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public float getAutoFinishedVelocityLimit() {
        return this.p;
    }

    public int getDirectionMode() {
        return this.f18596a;
    }

    public int getMaskAlpha() {
        return this.f18605j;
    }

    public float getSwipeBackFactor() {
        return this.f18603h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.l = motionEvent.getRawX();
            this.m = motionEvent.getRawY();
        } else if (actionMasked == 2 && (view2 = this.f18599d) != null && com.baidu.sapi2.views.swipeback.a.a.a(view2, this.l, this.m)) {
            float abs = Math.abs(motionEvent.getRawX() - this.l);
            float abs2 = Math.abs(motionEvent.getRawY() - this.m);
            int i2 = this.f18596a;
            if (i2 == 1 || i2 == 2) {
                if (abs2 > ((float) this.f18602g) && abs2 > abs) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
            } else if ((i2 == 4 || i2 == 8) && abs > ((float) this.f18602g) && abs > abs2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
        }
        boolean shouldInterceptTouchEvent = this.f18597b.shouldInterceptTouchEvent(motionEvent);
        return shouldInterceptTouchEvent ? shouldInterceptTouchEvent : super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft() + this.n;
            int paddingTop = getPaddingTop() + this.o;
            this.f18598c.layout(paddingLeft, paddingTop, this.f18598c.getMeasuredWidth() + paddingLeft, this.f18598c.getMeasuredHeight() + paddingTop);
            if (z) {
                this.f18600e = getWidth();
                this.f18601f = getHeight();
            }
            this.f18599d = com.baidu.sapi2.views.swipeback.a.a.a((ViewGroup) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        if (childCount <= 1) {
            int i5 = 0;
            if (childCount > 0) {
                measureChildren(i2, i3);
                View childAt = getChildAt(0);
                this.f18598c = childAt;
                i5 = childAt.getMeasuredWidth();
                i4 = this.f18598c.getMeasuredHeight();
            } else {
                i4 = 0;
            }
            setMeasuredDimension(View.resolveSize(i5, i2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(i4, i3) + getPaddingTop() + getPaddingBottom());
            return;
        }
        throw new IllegalStateException("SwipeBackLayout must contains only one direct child.");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f18597b.processTouchEvent(motionEvent);
        return true;
    }

    public void setAutoFinishedVelocityLimit(float f2) {
        this.p = f2;
    }

    public void setDirectionMode(int i2) {
        this.f18596a = i2;
        this.f18597b.setEdgeTrackingEnabled(i2);
    }

    public void setMaskAlpha(int i2) {
        if (i2 > 255) {
            i2 = 255;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.f18605j = i2;
    }

    public void setSwipeBackFactor(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f18603h = f2;
    }

    public void setSwipeBackListener(d dVar) {
        this.r = dVar;
    }

    public void setSwipeFromEdge(boolean z) {
        this.k = z;
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18596a = 1;
        this.f18603h = 0.5f;
        this.f18605j = 125;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 2000.0f;
        this.q = -1;
        this.s = new a();
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new c(this, (a) null));
        this.f18597b = create;
        create.setEdgeTrackingEnabled(this.f18596a);
        this.f18602g = create.getTouchSlop();
        setSwipeBackListener(this.s);
        a(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public boolean c() {
        if (!this.k) {
            return true;
        }
        int i2 = this.f18596a;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 == 8 && this.q != 8) {
                        return false;
                    }
                    return true;
                } else if (this.q == 4) {
                    return true;
                } else {
                    return false;
                }
            } else if (this.q == 2) {
                return true;
            } else {
                return false;
            }
        } else if (this.q == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void b(int i2) {
        if (this.f18597b.settleCapturedViewAt(getPaddingLeft(), i2)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sapi_sdk_SwipeBackLayout);
        setDirectionMode(obtainStyledAttributes.getInt(R.styleable.sapi_sdk_SwipeBackLayout_sapi_sdk_directionMode, this.f18596a));
        setSwipeBackFactor(obtainStyledAttributes.getFloat(R.styleable.sapi_sdk_SwipeBackLayout_sapi_sdk_swipeBackFactor, this.f18603h));
        setMaskAlpha(obtainStyledAttributes.getInteger(R.styleable.sapi_sdk_SwipeBackLayout_sapi_sdk_maskAlpha, this.f18605j));
        this.k = obtainStyledAttributes.getBoolean(R.styleable.sapi_sdk_SwipeBackLayout_sapi_sdk_isSwipeFromEdge, this.k);
        obtainStyledAttributes.recycle();
    }

    public boolean b() {
        return this.k;
    }

    public void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundColor(0);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        viewGroup.addView(this);
    }

    public void a(int i2) {
        if (this.f18597b.settleCapturedViewAt(i2, getPaddingTop())) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a() {
        ((Activity) getContext()).finish();
    }

    /* access modifiers changed from: private */
    public boolean a(float f2, float f3) {
        int i2 = this.f18596a;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 == 8 && f3 < (-this.p)) {
                        return true;
                    }
                    return false;
                } else if (f3 > this.p) {
                    return true;
                } else {
                    return false;
                }
            } else if (f2 < (-this.p)) {
                return true;
            } else {
                return false;
            }
        } else if (f2 > this.p) {
            return true;
        } else {
            return false;
        }
    }
}
