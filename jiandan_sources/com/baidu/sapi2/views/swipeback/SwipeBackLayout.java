package com.baidu.sapi2.views.swipeback;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.tera.scan.app.R$styleable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SwipeBackLayout extends ViewGroup {
    public static final String t = "SwipeBackLayout";
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 4;
    public static final int x = 8;
    public int a;
    public final ViewDragHelper b;
    public View c;
    public View d;
    public int e;
    public int f;
    public int g;
    public float h;

    /* renamed from: i  reason: collision with root package name */
    public float f990i;
    public int j;
    public boolean k;
    public float l;
    public float m;
    public int n;

    /* renamed from: o  reason: collision with root package name */
    public int f991o;
    public float p;
    public int q;
    public d r;
    public d s;

    public class a implements d {
        public a() {
        }

        public void a(View view, float f, float f2) {
            SwipeBackLayout.this.invalidate();
        }

        public void a(View view, boolean z) {
            if (z) {
                SwipeBackLayout.this.a();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public class c extends ViewDragHelper.Callback {
        public c() {
        }

        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int unused = swipeBackLayout.n = swipeBackLayout.getPaddingLeft();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.a == 1 && !com.baidu.sapi2.views.swipeback.a.a.c(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    int unused2 = swipeBackLayout2.n = Math.min(Math.max(i2, swipeBackLayout2.getPaddingLeft()), SwipeBackLayout.this.e);
                } else if (SwipeBackLayout.this.a == 2 && !com.baidu.sapi2.views.swipeback.a.a.b(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    int unused3 = swipeBackLayout3.n = Math.min(Math.max(i2, -swipeBackLayout3.e), SwipeBackLayout.this.getPaddingRight());
                }
            }
            return SwipeBackLayout.this.n;
        }

        public int clampViewPositionVertical(View view, int i2, int i3) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int unused = swipeBackLayout.f991o = swipeBackLayout.getPaddingTop();
            if (SwipeBackLayout.this.c()) {
                if (SwipeBackLayout.this.a == 4 && !com.baidu.sapi2.views.swipeback.a.a.d(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    int unused2 = swipeBackLayout2.f991o = Math.min(Math.max(i2, swipeBackLayout2.getPaddingTop()), SwipeBackLayout.this.f);
                } else if (SwipeBackLayout.this.a == 8 && !com.baidu.sapi2.views.swipeback.a.a.a(SwipeBackLayout.this.d, SwipeBackLayout.this.l, SwipeBackLayout.this.m, false)) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    int unused3 = swipeBackLayout3.f991o = Math.min(Math.max(i2, -swipeBackLayout3.f), SwipeBackLayout.this.getPaddingBottom());
                }
            }
            return SwipeBackLayout.this.f991o;
        }

        public int getViewHorizontalDragRange(View view) {
            return SwipeBackLayout.this.e;
        }

        public int getViewVerticalDragRange(View view) {
            return SwipeBackLayout.this.f;
        }

        public void onEdgeTouched(int i2, int i3) {
            super.onEdgeTouched(i2, i3);
            int unused = SwipeBackLayout.this.q = i2;
        }

        public void onViewDragStateChanged(int i2) {
            super.onViewDragStateChanged(i2);
            if (i2 == 0 && SwipeBackLayout.this.r != null) {
                if (SwipeBackLayout.this.f990i == 0.0f) {
                    SwipeBackLayout.this.r.a(SwipeBackLayout.this.c, false);
                } else if (SwipeBackLayout.this.f990i == 1.0f) {
                    SwipeBackLayout.this.r.a(SwipeBackLayout.this.c, true);
                }
            }
        }

        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            int h = SwipeBackLayout.this.a;
            if (h == 1 || h == 2) {
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                float unused = swipeBackLayout.f990i = (((float) abs) * 1.0f) / ((float) swipeBackLayout.e);
            } else if (h == 4 || h == 8) {
                SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                float unused2 = swipeBackLayout2.f990i = (((float) abs2) * 1.0f) / ((float) swipeBackLayout2.f);
            }
            if (SwipeBackLayout.this.r != null) {
                SwipeBackLayout.this.r.a(SwipeBackLayout.this.c, SwipeBackLayout.this.f990i, SwipeBackLayout.this.h);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            super.onViewReleased(view, f, f2);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            boolean z = false;
            int unused = swipeBackLayout.n = swipeBackLayout.f991o = 0;
            if (!SwipeBackLayout.this.c()) {
                int unused2 = SwipeBackLayout.this.q = -1;
                return;
            }
            int unused3 = SwipeBackLayout.this.q = -1;
            if (SwipeBackLayout.this.a(f, f2) || SwipeBackLayout.this.f990i >= SwipeBackLayout.this.h) {
                z = true;
            }
            if (z) {
                int h = SwipeBackLayout.this.a;
                if (h == 1) {
                    SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
                    swipeBackLayout2.a(swipeBackLayout2.e);
                } else if (h == 2) {
                    SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
                    swipeBackLayout3.a(-swipeBackLayout3.e);
                } else if (h == 4) {
                    SwipeBackLayout swipeBackLayout4 = SwipeBackLayout.this;
                    swipeBackLayout4.b(swipeBackLayout4.f);
                } else if (h == 8) {
                    SwipeBackLayout swipeBackLayout5 = SwipeBackLayout.this;
                    swipeBackLayout5.b(-swipeBackLayout5.f);
                }
            } else {
                int h2 = SwipeBackLayout.this.a;
                if (h2 == 1 || h2 == 2) {
                    SwipeBackLayout swipeBackLayout6 = SwipeBackLayout.this;
                    swipeBackLayout6.a(swipeBackLayout6.getPaddingLeft());
                } else if (h2 == 4 || h2 == 8) {
                    SwipeBackLayout swipeBackLayout7 = SwipeBackLayout.this;
                    swipeBackLayout7.b(swipeBackLayout7.getPaddingTop());
                }
            }
        }

        public boolean tryCaptureView(View view, int i2) {
            return view == SwipeBackLayout.this.c;
        }

        public /* synthetic */ c(SwipeBackLayout swipeBackLayout, a aVar) {
            this();
        }
    }

    public interface d {
        void a(View view, float f, float f2);

        void a(View view, boolean z);
    }

    public SwipeBackLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void computeScroll() {
        if (this.b.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public float getAutoFinishedVelocityLimit() {
        return this.p;
    }

    public int getDirectionMode() {
        return this.a;
    }

    public int getMaskAlpha() {
        return this.j;
    }

    public float getSwipeBackFactor() {
        return this.h;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.l = motionEvent.getRawX();
            this.m = motionEvent.getRawY();
        } else if (actionMasked == 2 && (view = this.d) != null && com.baidu.sapi2.views.swipeback.a.a.a(view, this.l, this.m)) {
            float abs = Math.abs(motionEvent.getRawX() - this.l);
            float abs2 = Math.abs(motionEvent.getRawY() - this.m);
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                if (abs2 > ((float) this.g) && abs2 > abs) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
            } else if ((i2 == 4 || i2 == 8) && abs > ((float) this.g) && abs > abs2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
        }
        boolean shouldInterceptTouchEvent = this.b.shouldInterceptTouchEvent(motionEvent);
        return shouldInterceptTouchEvent ? shouldInterceptTouchEvent : super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft() + this.n;
            int paddingTop = getPaddingTop() + this.f991o;
            this.c.layout(paddingLeft, paddingTop, this.c.getMeasuredWidth() + paddingLeft, this.c.getMeasuredHeight() + paddingTop);
            if (z) {
                this.e = getWidth();
                this.f = getHeight();
            }
            this.d = com.baidu.sapi2.views.swipeback.a.a.a((ViewGroup) this);
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        if (childCount <= 1) {
            int i5 = 0;
            if (childCount > 0) {
                measureChildren(i2, i3);
                View childAt = getChildAt(0);
                this.c = childAt;
                i5 = childAt.getMeasuredWidth();
                i4 = this.c.getMeasuredHeight();
            } else {
                i4 = 0;
            }
            setMeasuredDimension(View.resolveSize(i5, i2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(i4, i3) + getPaddingTop() + getPaddingBottom());
            return;
        }
        throw new IllegalStateException("SwipeBackLayout must contains only one direct child.");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.processTouchEvent(motionEvent);
        return true;
    }

    public void setAutoFinishedVelocityLimit(float f2) {
        this.p = f2;
    }

    public void setDirectionMode(int i2) {
        this.a = i2;
        this.b.setEdgeTrackingEnabled(i2);
    }

    public void setMaskAlpha(@IntRange(from = 0, to = 255) int i2) {
        if (i2 > 255) {
            i2 = 255;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.j = i2;
    }

    public void setSwipeBackFactor(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.h = f2;
    }

    public void setSwipeBackListener(d dVar) {
        this.r = dVar;
    }

    public void setSwipeFromEdge(boolean z) {
        this.k = z;
    }

    public SwipeBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 1;
        this.h = 0.5f;
        this.j = 125;
        this.k = false;
        this.n = 0;
        this.f991o = 0;
        this.p = 2000.0f;
        this.q = -1;
        this.s = new a();
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new c(this, (a) null));
        this.b = create;
        create.setEdgeTrackingEnabled(this.a);
        this.g = this.b.getTouchSlop();
        setSwipeBackListener(this.s);
        a(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public boolean c() {
        if (!this.k) {
            return true;
        }
        int i2 = this.a;
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
        if (this.b.settleCapturedViewAt(getPaddingLeft(), i2)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.sapi_sdk_SwipeBackLayout);
        setDirectionMode(obtainStyledAttributes.getInt(0, this.a));
        setSwipeBackFactor(obtainStyledAttributes.getFloat(3, this.h));
        setMaskAlpha(obtainStyledAttributes.getInteger(2, this.j));
        this.k = obtainStyledAttributes.getBoolean(1, this.k);
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
        if (this.b.settleCapturedViewAt(i2, getPaddingTop())) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a() {
        ((Activity) getContext()).finish();
    }

    /* access modifiers changed from: private */
    public boolean a(float f2, float f3) {
        int i2 = this.a;
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
