package com.baidu.wallet.paysdk.ui.widget.compliance.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.d;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.e;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.f;
import com.tera.scan.app.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WheelView extends View implements Runnable {
    @Deprecated
    public static final int SCROLL_STATE_DRAGGING = 1;
    @Deprecated
    public static final int SCROLL_STATE_IDLE = 0;
    @Deprecated
    public static final int SCROLL_STATE_SCROLLING = 2;
    public final int A;
    public final int B;
    public final int C;
    public boolean D;
    public boolean E;
    public final Handler a;
    public boolean atmosphericEnabled;
    public final Paint b;
    public final Scroller c;
    public int currentPosition;
    public int curtainColor;
    public int curtainCorner;
    public boolean curtainEnabled;
    public float curtainRadius;
    public int curvedMaxAngle;
    public boolean cyclicEnabled;
    public VelocityTracker d;
    public List<?> data;
    public Object defaultItem;
    public int defaultItemPosition;
    public d e;
    public final Rect f;
    public f formatter;
    public final Rect g;
    public final Rect h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f3638i;
    public int indicatorColor;
    public boolean indicatorEnabled;
    public float indicatorSize;
    public int itemSpace;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* renamed from: o  reason: collision with root package name */
    public int f3639o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean selectedTextBold;
    public int selectedTextColor;
    public float selectedTextSize;
    public int t;
    public int textAlign;
    public int textColor;
    public float textSize;
    public int u;
    public int v;
    public int visibleItemCount;
    public int w;
    public int x;
    public int y;
    public int z;

    public WheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean a(int i2, int i3) {
        return i2 >= 0 && i2 < i3;
    }

    private void c() {
        this.n = 0;
        this.m = 0;
        this.m = (int) this.b.measureText(formatItem(0));
        Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
        this.n = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    private void d() {
        int i2 = this.textAlign;
        if (i2 == 1) {
            this.b.setTextAlign(Paint.Align.LEFT);
        } else if (i2 != 2) {
            this.b.setTextAlign(Paint.Align.CENTER);
        } else {
            this.b.setTextAlign(Paint.Align.RIGHT);
        }
    }

    private void e() {
        int i2 = this.textAlign;
        if (i2 == 1) {
            this.v = this.f.left;
        } else if (i2 != 2) {
            this.v = this.t;
        } else {
            this.v = this.f.right;
        }
        this.w = (int) (((float) this.u) - ((this.b.ascent() + this.b.descent()) / 2.0f));
    }

    private void f() {
        int i2;
        int i3 = this.defaultItemPosition;
        int i4 = this.f3639o;
        int i5 = i3 * i4;
        if (this.cyclicEnabled) {
            i2 = Integer.MIN_VALUE;
        } else {
            i2 = ((-i4) * (getItemCount() - 1)) + i5;
        }
        this.r = i2;
        if (this.cyclicEnabled) {
            i5 = Integer.MAX_VALUE;
        }
        this.s = i5;
    }

    private void g() {
        if (this.indicatorEnabled) {
            int i2 = (int) (this.indicatorSize / 2.0f);
            int i3 = this.u;
            int i4 = this.p;
            int i5 = i3 + i4;
            int i6 = i3 - i4;
            Rect rect = this.g;
            Rect rect2 = this.f;
            rect.set(rect2.left, i5 - i2, rect2.right, i5 + i2);
            Rect rect3 = this.h;
            Rect rect4 = this.f;
            rect3.set(rect4.left, i6 - i2, rect4.right, i6 + i2);
        }
    }

    private void h() {
        if (this.curtainEnabled || this.selectedTextColor != 0) {
            Rect rect = this.f3638i;
            Rect rect2 = this.f;
            int i2 = rect2.left;
            int i3 = this.u;
            int i4 = this.p;
            rect.set(i2, i3 - i4, rect2.right, i3 + i4);
        }
    }

    private void i() {
        VelocityTracker velocityTracker = this.d;
        if (velocityTracker == null) {
            this.d = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void j() {
        VelocityTracker velocityTracker = this.d;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.d = null;
        }
    }

    public String formatItem(int i2) {
        return formatItem(getItem(i2));
    }

    public List<?> generatePreviewData() {
        return null;
    }

    public <T> T getCurrentItem() {
        return getItem(this.currentPosition);
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    @ColorInt
    public int getCurtainColor() {
        return this.curtainColor;
    }

    public int getCurtainCorner() {
        return this.curtainCorner;
    }

    @Px
    public float getCurtainRadius() {
        return this.curtainRadius;
    }

    public int getCurvedMaxAngle() {
        return this.curvedMaxAngle;
    }

    public List<?> getData() {
        return this.data;
    }

    @ColorInt
    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    @Px
    public float getIndicatorSize() {
        return this.indicatorSize;
    }

    public <T> T getItem(int i2) {
        int i3;
        int size = this.data.size();
        if (size != 0 && (i3 = (i2 + size) % size) >= 0 && i3 <= size - 1) {
            return this.data.get(i3);
        }
        return null;
    }

    public int getItemCount() {
        return this.data.size();
    }

    public int getPosition(Object obj) {
        if (obj == null) {
            return 0;
        }
        return this.data.indexOf(obj);
    }

    public boolean getSelectedTextBold() {
        return this.selectedTextBold;
    }

    @ColorInt
    public int getSelectedTextColor() {
        return this.selectedTextColor;
    }

    @Px
    public float getSelectedTextSize() {
        return this.selectedTextSize;
    }

    public int getTextAlign() {
        return this.textAlign;
    }

    @ColorInt
    public int getTextColor() {
        return this.textColor;
    }

    @Px
    public float getTextSize() {
        return this.textSize;
    }

    public Typeface getTypeface() {
        return this.b.getTypeface();
    }

    public int getVisibleItemCount() {
        return this.visibleItemCount;
    }

    public boolean isAtmosphericEnabled() {
        return this.atmosphericEnabled;
    }

    public boolean isCurtainEnabled() {
        return this.curtainEnabled;
    }

    public boolean isCyclicEnabled() {
        return this.cyclicEnabled;
    }

    public boolean isIndicatorEnabled() {
        return this.indicatorEnabled;
    }

    public void onDraw(Canvas canvas) {
        d dVar = this.e;
        if (dVar != null) {
            dVar.onWheelScrolled(this, this.x);
        }
        if (this.f3639o - this.l > 0) {
            b(canvas);
            c(canvas);
            a(canvas);
        }
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = this.m;
        int i5 = this.n;
        int i6 = this.visibleItemCount;
        int i7 = (i5 * i6) + (this.itemSpace * (i6 - 1));
        setMeasuredDimension(a(mode, size, i4 + getPaddingLeft() + getPaddingRight()), a(mode2, size2, i7 + getPaddingTop() + getPaddingBottom()));
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.t = this.f.centerX();
        this.u = this.f.centerY();
        e();
        this.q = this.f.height() / 2;
        int height = this.f.height() / this.visibleItemCount;
        this.f3639o = height;
        this.p = height / 2;
        f();
        g();
        h();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a(motionEvent);
            } else if (action == 1) {
                c(motionEvent);
            } else if (action == 2) {
                b(motionEvent);
            } else if (action == 3) {
                d(motionEvent);
            }
        }
        if (this.D) {
            performClick();
        }
        return true;
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void run() {
        d dVar;
        if (this.f3639o != 0) {
            int itemCount = getItemCount();
            if (itemCount == 0) {
                d dVar2 = this.e;
                if (dVar2 != null) {
                    dVar2.onWheelScrollStateChanged(this, 0);
                }
            } else if (this.c.isFinished() && !this.E) {
                int e2 = e(itemCount);
                if (e2 < 0) {
                    e2 += itemCount;
                }
                this.currentPosition = e2;
                d dVar3 = this.e;
                if (dVar3 != null) {
                    dVar3.onWheelSelected(this, e2);
                    this.e.onWheelScrollStateChanged(this, 0);
                }
                postInvalidate();
            } else if (this.c.computeScrollOffset()) {
                d dVar4 = this.e;
                if (dVar4 != null) {
                    dVar4.onWheelScrollStateChanged(this, 2);
                }
                this.x = this.c.getCurrY();
                int e3 = e(itemCount);
                int i2 = this.j;
                if (i2 != e3) {
                    if (e3 == 0 && i2 == itemCount - 1 && (dVar = this.e) != null) {
                        dVar.onWheelLoopFinished(this);
                    }
                    this.j = e3;
                }
                postInvalidate();
                this.a.postDelayed(this, 20);
            }
        }
    }

    public void scrollTo(final int i2) {
        post(new Runnable() {
            public void run() {
                WheelView.this.a(i2);
            }
        });
    }

    public void setAtmosphericEnabled(boolean z2) {
        this.atmosphericEnabled = z2;
        invalidate();
    }

    public void setCurtainColor(@ColorInt int i2) {
        this.curtainColor = i2;
        invalidate();
    }

    public void setCurtainCorner(int i2) {
        this.curtainCorner = i2;
        invalidate();
    }

    public void setCurtainEnabled(boolean z2) {
        this.curtainEnabled = z2;
        if (z2) {
            this.indicatorEnabled = false;
        }
        h();
        invalidate();
    }

    public void setCurtainRadius(@Px float f2) {
        this.curtainRadius = f2;
        invalidate();
    }

    public void setCurvedMaxAngle(int i2) {
        this.curvedMaxAngle = i2;
        requestLayout();
        invalidate();
    }

    public void setCyclicEnabled(boolean z2) {
        this.cyclicEnabled = z2;
        f();
        invalidate();
    }

    public void setData(List<?> list) {
        setData(list, 0);
    }

    public void setDefaultPosition(int i2) {
        a(i2);
    }

    public void setDefaultValue(Object obj) {
        setDefaultPosition(a(obj));
    }

    public void setFormatter(f fVar) {
        this.formatter = fVar;
    }

    public void setIndicatorColor(@ColorInt int i2) {
        this.indicatorColor = i2;
        invalidate();
    }

    public void setIndicatorEnabled(boolean z2) {
        this.indicatorEnabled = z2;
        g();
        invalidate();
    }

    public void setIndicatorSize(@Px float f2) {
        this.indicatorSize = f2;
        g();
        invalidate();
    }

    public void setMaxWidthText(String str) {
        if (str != null) {
            c();
            requestLayout();
            invalidate();
            return;
        }
        throw new NullPointerException("Maximum width text can not be null!");
    }

    public void setOnWheelChangedListener(d dVar) {
        this.e = dVar;
    }

    public void setSelectedTextBold(boolean z2) {
        this.selectedTextBold = z2;
        c();
        requestLayout();
        invalidate();
    }

    public void setSelectedTextColor(@ColorInt int i2) {
        this.selectedTextColor = i2;
        h();
        invalidate();
    }

    public void setSelectedTextSize(@Px float f2) {
        this.selectedTextSize = f2;
        c();
        requestLayout();
        invalidate();
    }

    public void setStyle(@StyleRes int i2) {
        a(getContext(), (AttributeSet) null, (int) R.attr.DxmWheelStyle, i2);
        a();
        d();
        c();
        f();
        g();
        h();
        requestLayout();
        invalidate();
    }

    public void setTextAlign(int i2) {
        this.textAlign = i2;
        d();
        e();
        invalidate();
    }

    public void setTextColor(@ColorInt int i2) {
        this.textColor = i2;
        invalidate();
    }

    public void setTextSize(@Px float f2) {
        this.textSize = f2;
        c();
        requestLayout();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != null) {
            this.b.setTypeface(typeface);
            c();
            requestLayout();
            invalidate();
        }
    }

    public void setVisibleItemCount(@IntRange(from = 2) int i2) {
        this.visibleItemCount = i2;
        b();
        requestLayout();
    }

    public final void smoothScrollTo(final int i2) {
        if (isInEditMode()) {
            scrollTo(i2);
            return;
        }
        int i3 = this.x;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i3, ((this.currentPosition - i2) * this.f3639o) + i3});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = WheelView.this.x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                WheelView.this.invalidate();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                WheelView.this.scrollTo(i2);
            }
        });
        ofInt.start();
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.DxmWheelStyle);
    }

    private void a() {
        this.b.setColor(this.textColor);
        this.b.setTextSize(this.textSize);
        this.b.setFakeBoldText(false);
        this.b.setStyle(Paint.Style.FILL);
    }

    private void b() {
        int i2 = this.visibleItemCount;
        if (i2 >= 1) {
            if (i2 % 2 == 0) {
                this.visibleItemCount = i2 + 1;
            }
            int i3 = this.visibleItemCount + 2;
            this.k = i3;
            this.l = i3 / 2;
            return;
        }
        throw new ArithmeticException("Visible item count can not be less than 1");
    }

    public String formatItem(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof e) {
            return ((e) obj).c();
        }
        f fVar = this.formatter;
        if (fVar != null) {
            return fVar.a(obj);
        }
        return obj.toString();
    }

    public void setData(List<?> list, Object obj) {
        setData(list, a(obj));
    }

    public WheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.data = new ArrayList();
        this.itemSpace = 100;
        this.curvedMaxAngle = 90;
        this.a = new Handler();
        this.b = new Paint(69);
        this.f = new Rect();
        this.g = new Rect();
        this.h = new Rect();
        this.f3638i = new Rect();
        a(context, attributeSet, i2, (int) R.style.DxmWheelDefault);
        a();
        b();
        this.c = new Scroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A = viewConfiguration.getScaledMinimumFlingVelocity();
        this.B = viewConfiguration.getScaledMaximumFlingVelocity();
        this.C = viewConfiguration.getScaledTouchSlop();
    }

    public void setData(List<?> list, int i2) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data = list;
        a(i2);
    }

    private void c(int i2) {
        if (this.atmosphericEnabled) {
            int i3 = this.w;
            this.b.setAlpha(Math.max((int) (((((float) (i3 - i2)) * 1.0f) / ((float) i3)) * 255.0f), 0));
        }
    }

    private void d(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        j();
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = context.getResources().getDisplayMetrics().scaledDensity;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DxmWheelView, i2, i3);
        this.visibleItemCount = obtainStyledAttributes.getInt(17, 5);
        this.textColor = obtainStyledAttributes.getColor(13, -7829368);
        this.selectedTextColor = obtainStyledAttributes.getColor(14, -16777216);
        float dimension = obtainStyledAttributes.getDimension(15, f3 * 15.0f);
        this.textSize = dimension;
        this.selectedTextSize = obtainStyledAttributes.getDimension(16, dimension);
        this.selectedTextBold = obtainStyledAttributes.getBoolean(12, false);
        this.textAlign = obtainStyledAttributes.getInt(11, 0);
        this.itemSpace = obtainStyledAttributes.getDimensionPixelSize(10, (int) (20.0f * f2));
        this.cyclicEnabled = obtainStyledAttributes.getBoolean(6, false);
        this.indicatorEnabled = obtainStyledAttributes.getBoolean(8, true);
        this.indicatorColor = obtainStyledAttributes.getColor(7, -3552823);
        this.indicatorSize = obtainStyledAttributes.getDimension(9, f2 * 1.0f);
        this.curtainEnabled = obtainStyledAttributes.getBoolean(3, false);
        this.curtainColor = obtainStyledAttributes.getColor(1, -1);
        this.curtainCorner = obtainStyledAttributes.getInt(2, 0);
        this.curtainRadius = obtainStyledAttributes.getDimension(4, 0.0f);
        this.atmosphericEnabled = obtainStyledAttributes.getBoolean(0, false);
        this.curvedMaxAngle = obtainStyledAttributes.getInteger(5, 90);
        obtainStyledAttributes.recycle();
    }

    private int e(int i2) {
        return (((this.x * -1) / this.f3639o) + this.defaultItemPosition) % i2;
    }

    private String b(int i2) {
        int itemCount = getItemCount();
        if (this.cyclicEnabled) {
            if (itemCount != 0) {
                int i3 = i2 % itemCount;
                if (i3 < 0) {
                    i3 += itemCount;
                }
                return formatItem(i3);
            }
        } else if (a(i2, itemCount)) {
            return formatItem(i2);
        }
        return "";
    }

    private int d(int i2) {
        int i3;
        if (Math.abs(i2) <= this.p) {
            return i2 * -1;
        }
        if (this.x < 0) {
            i3 = -this.f3639o;
        } else {
            i3 = this.f3639o;
        }
        return i3 - i2;
    }

    private void c(Canvas canvas) {
        if (this.indicatorEnabled) {
            this.b.setColor(this.indicatorColor);
            this.b.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.g, this.b);
            canvas.drawRect(this.h, this.b);
        }
    }

    private void b(Canvas canvas) {
        float[] fArr;
        float[] fArr2;
        if (this.curtainEnabled) {
            this.b.setColor(this.curtainColor);
            this.b.setStyle(Paint.Style.FILL);
            if (this.curtainRadius > 0.0f) {
                Path path = new Path();
                int i2 = this.curtainCorner;
                if (i2 != 1) {
                    if (i2 == 2) {
                        float f2 = this.curtainRadius;
                        fArr2 = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
                    } else if (i2 == 3) {
                        float f3 = this.curtainRadius;
                        fArr2 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f3, f3, f3, f3};
                    } else if (i2 == 4) {
                        float f4 = this.curtainRadius;
                        fArr2 = new float[]{f4, f4, 0.0f, 0.0f, 0.0f, 0.0f, f4, f4};
                    } else if (i2 != 5) {
                        fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    } else {
                        float f5 = this.curtainRadius;
                        fArr2 = new float[]{0.0f, 0.0f, f5, f5, f5, f5, 0.0f, 0.0f};
                    }
                    fArr = fArr2;
                } else {
                    float f6 = this.curtainRadius;
                    fArr = new float[]{f6, f6, f6, f6, f6, f6, f6, f6};
                }
                path.addRoundRect(new RectF(this.f3638i), fArr, Path.Direction.CCW);
                canvas.drawPath(path, this.b);
                return;
            }
            canvas.drawRect(this.f3638i, this.b);
        }
    }

    private void c(MotionEvent motionEvent) {
        int i2;
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (!this.D) {
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.d.computeCurrentVelocity(1000, (float) this.B);
                i2 = (int) this.d.getYVelocity();
            } else {
                i2 = 0;
            }
            this.E = false;
            if (Math.abs(i2) > this.A) {
                this.c.fling(0, this.x, 0, i2, 0, 0, this.r, this.s);
                int d2 = d(this.c.getFinalY() % this.f3639o);
                Scroller scroller = this.c;
                scroller.setFinalY(scroller.getFinalY() + d2);
            } else {
                this.c.startScroll(0, this.x, 0, d(this.x % this.f3639o));
            }
            if (!this.cyclicEnabled) {
                int finalY = this.c.getFinalY();
                int i3 = this.s;
                if (finalY > i3) {
                    this.c.setFinalY(i3);
                } else {
                    int finalY2 = this.c.getFinalY();
                    int i4 = this.r;
                    if (finalY2 < i4) {
                        this.c.setFinalY(i4);
                    }
                }
            }
            this.a.post(this);
            j();
        }
    }

    private int a(Object obj) {
        boolean z2;
        f fVar;
        if (obj == null) {
            return 0;
        }
        Iterator<?> it = this.data.iterator();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Object next = it.next();
            if (next != null) {
                if (next.equals(obj) || (((fVar = this.formatter) != null && fVar.a(next).equals(this.formatter.a(obj))) || (((next instanceof e) && ((e) next).c().equals(obj.toString())) || next.toString().equals(obj.toString())))) {
                    break;
                }
                i2++;
            }
        }
        if (!z2) {
            return 0;
        }
        return i2;
    }

    private void b(MotionEvent motionEvent) {
        int d2 = d(this.c.getFinalY() % this.f3639o);
        if (Math.abs(((float) this.z) - motionEvent.getY()) >= ((float) this.C) || d2 <= 0) {
            this.D = false;
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            d dVar = this.e;
            if (dVar != null) {
                dVar.onWheelScrollStateChanged(this, 1);
            }
            float y2 = motionEvent.getY() - ((float) this.y);
            if (Math.abs(y2) >= 1.0f) {
                this.x = (int) (((float) this.x) + y2);
                this.y = (int) motionEvent.getY();
                invalidate();
                return;
            }
            return;
        }
        this.D = true;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        int max = Math.max(Math.min(i2, getItemCount() - 1), 0);
        this.x = 0;
        this.defaultItem = getItem(max);
        this.defaultItemPosition = max;
        this.currentPosition = max;
        d();
        f();
        g();
        h();
        requestLayout();
        invalidate();
    }

    private int a(int i2, int i3, int i4) {
        if (i2 == 1073741824) {
            return i3;
        }
        return i2 == Integer.MIN_VALUE ? Math.min(i4, i3) : i4;
    }

    private void a(Canvas canvas) {
        int i2 = (this.x * -1) / this.f3639o;
        int i3 = this.l;
        int i4 = i2 - i3;
        int i5 = this.defaultItemPosition + i4;
        int i6 = i3 * -1;
        while (i5 < this.defaultItemPosition + i4 + this.k) {
            a();
            boolean z2 = i5 == (this.defaultItemPosition + i4) + (this.k / 2);
            int i7 = this.w;
            int i8 = this.f3639o;
            int i9 = (i6 * i8) + i7 + (this.x % i8);
            int abs = Math.abs(i7 - i9);
            int i10 = this.w;
            int i11 = this.f.top;
            a(i9, (((float) ((i10 - abs) - i11)) * 1.0f) / ((float) (i10 - i11)));
            c(abs);
            a(canvas, i5, z2, (float) i9);
            i5++;
            i6++;
        }
    }

    private void a(Canvas canvas, int i2, boolean z2, float f2) {
        if (this.selectedTextColor == 0) {
            canvas.save();
            canvas.clipRect(this.f);
            a(canvas, i2, f2);
            canvas.restore();
        } else if (this.textSize == this.selectedTextSize && !this.selectedTextBold) {
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.f3638i);
            } else {
                canvas.clipRect(this.f3638i, Region.Op.DIFFERENCE);
            }
            a(canvas, i2, f2);
            canvas.restore();
            this.b.setColor(this.selectedTextColor);
            canvas.save();
            canvas.clipRect(this.f3638i);
            a(canvas, i2, f2);
            canvas.restore();
        } else if (!z2) {
            this.b.setColor(this.textColor);
            this.b.setAlpha(100);
            canvas.save();
            a(canvas, i2, f2);
            canvas.restore();
        } else {
            this.b.setColor(this.selectedTextColor);
            this.b.setTextSize(this.selectedTextSize);
            this.b.setFakeBoldText(this.selectedTextBold);
            canvas.save();
            a(canvas, i2, f2);
            canvas.restore();
        }
    }

    private void a(Canvas canvas, int i2, float f2) {
        int measuredWidth = getMeasuredWidth();
        float measureText = this.b.measureText("...");
        String b2 = b(i2);
        boolean z2 = false;
        while ((this.b.measureText(b2) + measureText) - ((float) measuredWidth) > 0.0f) {
            int length = b2.length();
            if (length > 1) {
                b2 = b2.substring(0, length - 1);
                z2 = true;
            }
        }
        if (z2) {
            b2 = b2 + "...";
        }
        canvas.drawText(b2, (float) this.v, f2, this.b);
    }

    private float a(int i2, float f2) {
        int i3 = this.w;
        int i4 = i2 > i3 ? 1 : i2 < i3 ? -1 : 0;
        float f3 = -(1.0f - f2);
        int i5 = this.curvedMaxAngle;
        return a(f3 * ((float) i5) * ((float) i4), (float) (-i5), (float) i5);
    }

    private float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : Math.min(f2, f4);
    }

    private void a(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        i();
        this.d.addMovement(motionEvent);
        if (!this.c.isFinished()) {
            this.c.abortAnimation();
            this.E = true;
        }
        int y2 = (int) motionEvent.getY();
        this.y = y2;
        this.z = y2;
    }
}
