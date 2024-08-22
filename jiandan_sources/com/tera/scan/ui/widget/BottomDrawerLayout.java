package com.tera.scan.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.tera.scan.app.R$styleable;

public class BottomDrawerLayout extends RelativeLayout {
    public static final int DEFAULT_DURATION = 200;
    public static final float MAX_CLICK_DISTANCE = 5.0f;
    public static final float SCALE_AUTO_OPEN_CLOSE = 0.3f;
    public static final String TAG = "BottomDrawerLayout";
    public static final int VEL = 800;
    public ViewGroup.MarginLayoutParams drawerLayoutParams;
    public int initialState = 1;
    public boolean isDragging;
    public boolean isFirstInit = false;
    public boolean isShowing = false;
    public boolean isTouchingDrawer = false;
    public DrawAlphaView mBackground;
    public View mDrawer;
    public int mDrawerBackgroundId;
    public View mDrawerLayoutContent;
    public int mDrawerLayoutContentId;
    public View mDrawerLayoutHandler;
    public int mDrawerLayoutHandlerId;
    public int mDrawerLayoutId = -1;
    public DrawerListener mDrawerListener;
    public boolean mIsOpenable = true;
    public long mPressStartTime;
    public VelocityTracker mVelocityTracker;
    public int touchSlop;
    public float xDown;
    public float yDown;
    public float yMove;

    public interface DrawerListener {
        void ad();

        void de();

        boolean qw();
    }

    public interface OnAnimationCallback {
        void qw();
    }

    public interface State {
    }

    public class ad implements ValueAnimator.AnimatorUpdateListener {
        public ad() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BottomDrawerLayout.this.drawerLayoutParams.bottomMargin = (int) floatValue;
            BottomDrawerLayout.this.mDrawer.setLayoutParams(BottomDrawerLayout.this.drawerLayoutParams);
            BottomDrawerLayout.this.updateBackground(floatValue);
        }
    }

    public class de extends AnimatorListenerAdapter {
        public de() {
        }

        public void onAnimationEnd(Animator animator) {
            boolean unused = BottomDrawerLayout.this.isShowing = true;
            fe.mmm.qw.i.qw.ad(BottomDrawerLayout.TAG, "open drawer end isShowing = false");
            if (BottomDrawerLayout.this.mDrawerListener != null) {
                BottomDrawerLayout.this.mDrawerListener.de();
            }
        }
    }

    public class fe implements ValueAnimator.AnimatorUpdateListener {
        public fe() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BottomDrawerLayout.this.drawerLayoutParams.bottomMargin = (int) floatValue;
            BottomDrawerLayout.this.mDrawer.setLayoutParams(BottomDrawerLayout.this.drawerLayoutParams);
            BottomDrawerLayout.this.updateBackground(floatValue);
        }
    }

    public class qw extends AnimatorListenerAdapter {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ OnAnimationCallback f7406ad;
        public final /* synthetic */ ValueAnimator.AnimatorUpdateListener qw;

        /* renamed from: com.tera.scan.ui.widget.BottomDrawerLayout$qw$qw  reason: collision with other inner class name */
        public class C0269qw extends AnimatorListenerAdapter {
            public C0269qw() {
            }

            public void onAnimationEnd(Animator animator) {
                qw.this.f7406ad.qw();
            }
        }

        public qw(ValueAnimator.AnimatorUpdateListener animatorUpdateListener, OnAnimationCallback onAnimationCallback) {
            this.qw = animatorUpdateListener;
            this.f7406ad = onAnimationCallback;
        }

        public void onAnimationEnd(Animator animator) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{(float) BottomDrawerLayout.this.drawerLayoutParams.bottomMargin, (float) (-BottomDrawerLayout.this.mDrawerLayoutContent.getMeasuredHeight())}).setDuration(400);
            duration.addUpdateListener(this.qw);
            duration.addListener(new C0269qw());
            duration.setTarget(BottomDrawerLayout.this.mDrawer);
            duration.setInterpolator(new DecelerateInterpolator());
            duration.start();
        }
    }

    public class rg extends AnimatorListenerAdapter {
        public rg() {
        }

        public void onAnimationEnd(Animator animator) {
            boolean unused = BottomDrawerLayout.this.isShowing = false;
            BottomDrawerLayout.this.drawerLayoutParams.bottomMargin = -BottomDrawerLayout.this.mDrawerLayoutContent.getMeasuredHeight();
            BottomDrawerLayout.this.mDrawer.setLayoutParams(BottomDrawerLayout.this.drawerLayoutParams);
            fe.mmm.qw.i.qw.ad(BottomDrawerLayout.TAG, "close drawer end isShowing = false");
            if (BottomDrawerLayout.this.mDrawerListener != null) {
                BottomDrawerLayout.this.mDrawerListener.ad();
            }
        }
    }

    public BottomDrawerLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private double distance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomDrawerLayout);
            this.mDrawerBackgroundId = obtainStyledAttributes.getResourceId(0, -1);
            this.mDrawerLayoutId = obtainStyledAttributes.getResourceId(3, -1);
            this.mDrawerLayoutHandlerId = obtainStyledAttributes.getResourceId(2, -1);
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            this.mDrawerLayoutContentId = resourceId;
            if (this.mDrawerBackgroundId == -1 || resourceId == -1 || this.mDrawerLayoutHandlerId == -1 || this.mDrawerLayoutId == -1) {
                throw new IllegalArgumentException("必须指定属性值");
            }
            obtainStyledAttributes.recycle();
        }
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private boolean isViewHit(View view, int i2, int i3) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i2;
        int i5 = iArr2[1] + i3;
        if (i4 < iArr[0] || i4 >= iArr[0] + view.getWidth() || i5 < iArr[1] || i5 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    private boolean processDown(MotionEvent motionEvent) {
        this.xDown = motionEvent.getX();
        float y = motionEvent.getY();
        this.yDown = y;
        if (this.isShowing || !isViewHit(this.mDrawer, (int) this.xDown, (int) y)) {
            if (this.isShowing) {
                if (!isViewHit(this.mDrawerLayoutContent, (int) this.xDown, (int) this.yDown)) {
                    closeDrawer();
                } else {
                    this.isTouchingDrawer = true;
                }
            }
            return false;
        }
        this.isTouchingDrawer = true;
        DrawerListener drawerListener = this.mDrawerListener;
        if (drawerListener == null || drawerListener.qw()) {
            return true;
        }
        return false;
    }

    private void processMove(MotionEvent motionEvent) {
        if (this.isTouchingDrawer) {
            this.mPressStartTime = System.currentTimeMillis();
            float y = motionEvent.getY();
            this.yMove = y;
            int i2 = (int) (y - this.yDown);
            if (!this.isDragging && Math.abs(i2) > this.touchSlop) {
                this.isDragging = true;
            }
            if (this.isDragging) {
                this.yDown = this.yMove;
                ViewGroup.MarginLayoutParams marginLayoutParams = this.drawerLayoutParams;
                int i3 = marginLayoutParams.bottomMargin - i2;
                marginLayoutParams.bottomMargin = i3;
                if (i3 >= 0) {
                    marginLayoutParams.bottomMargin = 0;
                    this.isShowing = true;
                    DrawerListener drawerListener = this.mDrawerListener;
                    if (drawerListener != null) {
                        drawerListener.de();
                    }
                }
                if (this.drawerLayoutParams.bottomMargin < (-this.mDrawerLayoutContent.getMeasuredHeight())) {
                    this.drawerLayoutParams.bottomMargin = -this.mDrawerLayoutContent.getMeasuredHeight();
                    this.isShowing = false;
                    DrawerListener drawerListener2 = this.mDrawerListener;
                    if (drawerListener2 != null) {
                        drawerListener2.ad();
                    }
                }
                this.mDrawer.setLayoutParams(this.drawerLayoutParams);
                updateBackground((float) this.drawerLayoutParams.bottomMargin);
            }
        }
    }

    private void processUp(MotionEvent motionEvent) {
        fe.mmm.qw.i.qw.ad(TAG, "process up isShowing = " + this.isShowing);
        if (this.isTouchingDrawer) {
            this.isTouchingDrawer = false;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000);
            int yVelocity = (int) velocityTracker.getYVelocity();
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            if (!this.isShowing || !isViewHit(this.mDrawerLayoutHandler, (int) motionEvent.getX(), (int) motionEvent.getY()) || distance(this.xDown, this.yDown, motionEvent.getX(), motionEvent.getY()) >= 5.0d) {
                if (yVelocity < -800 || (((float) (-this.drawerLayoutParams.bottomMargin)) < ((float) this.mDrawerLayoutContent.getMeasuredHeight()) * 0.7f && yVelocity < 800)) {
                    this.isShowing = false;
                    openDrawer();
                } else {
                    this.isShowing = true;
                    closeDrawer();
                }
                this.isDragging = false;
                return;
            }
            closeDrawer();
        }
    }

    private void trackVelocity(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
        this.mVelocityTracker.addMovement(obtain);
    }

    /* access modifiers changed from: private */
    public void updateBackground(float f) {
        fe.mmm.qw.i.qw.ad(TAG, "value = " + f);
        int measuredHeight = this.mDrawerLayoutContent.getMeasuredHeight();
        fe.mmm.qw.i.qw.ad(TAG, "height = " + measuredHeight);
        float f2 = (float) measuredHeight;
        if (Math.abs(f) <= f2) {
            this.mBackground.setAlpha(((f2 - Math.abs(f)) / f2) * 0.6f);
        }
    }

    public void closeDrawer() {
        fe.mmm.qw.i.qw.ad(TAG, "closeDrawer function");
        if (this.isShowing) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{(float) this.drawerLayoutParams.bottomMargin, (float) (-this.mDrawerLayoutContent.getMeasuredHeight())}).setDuration(200);
            duration.setTarget(this.mDrawer);
            duration.addUpdateListener(new fe());
            duration.addListener(new rg());
            duration.setInterpolator(new LinearInterpolator());
            duration.start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (r0 != 3) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "event.pointerCount = "
            r0.append(r1)
            int r1 = r5.getPointerCount()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "BottomDrawerLayout"
            fe.mmm.qw.i.qw.ad(r1, r0)
            boolean r0 = r4.mIsOpenable
            if (r0 != 0) goto L_0x0023
            boolean r5 = super.dispatchTouchEvent(r5)
            return r5
        L_0x0023:
            r4.trackVelocity(r5)
            int r0 = r5.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0040
            if (r0 == r1) goto L_0x003b
            r3 = 2
            if (r0 == r3) goto L_0x0037
            r3 = 3
            if (r0 == r3) goto L_0x003b
            goto L_0x003e
        L_0x0037:
            r4.processMove(r5)
            goto L_0x003e
        L_0x003b:
            r4.processUp(r5)
        L_0x003e:
            r0 = 0
            goto L_0x0044
        L_0x0040:
            boolean r0 = r4.processDown(r5)
        L_0x0044:
            if (r0 != 0) goto L_0x004e
            boolean r5 = super.dispatchTouchEvent(r5)
            if (r5 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.widget.BottomDrawerLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean isOpened() {
        return this.isShowing;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mBackground = (DrawAlphaView) findViewById(this.mDrawerBackgroundId);
        this.mDrawerLayoutHandler = findViewById(this.mDrawerLayoutHandlerId);
        this.mDrawerLayoutContent = findViewById(this.mDrawerLayoutContentId);
        this.mDrawer = findViewById(this.mDrawerLayoutId);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.isDragging;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.isFirstInit) {
            int i6 = 0;
            while (true) {
                if (i6 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i6);
                if (childAt.equals(this.mDrawer)) {
                    fe.mmm.qw.i.qw.ad(TAG, "onLayout");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    this.drawerLayoutParams = marginLayoutParams;
                    if (this.initialState == 1) {
                        marginLayoutParams.bottomMargin = -this.mDrawerLayoutContent.getMeasuredHeight();
                        this.isShowing = false;
                    } else {
                        marginLayoutParams.bottomMargin = 0;
                        this.isShowing = true;
                    }
                    childAt.setLayoutParams(this.drawerLayoutParams);
                } else {
                    i6++;
                }
            }
            this.isFirstInit = true;
        }
    }

    public void openDrawer() {
        fe.mmm.qw.i.qw.ad(TAG, "openDrawer");
        if (!this.isShowing && this.mIsOpenable) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{(float) this.drawerLayoutParams.bottomMargin, 0.0f}).setDuration(200);
            duration.setTarget(this.mDrawer);
            duration.addUpdateListener(new ad());
            duration.addListener(new de());
            duration.setInterpolator(new LinearInterpolator());
            duration.start();
        }
    }

    public /* synthetic */ void qw(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ViewGroup.MarginLayoutParams marginLayoutParams = this.drawerLayoutParams;
        marginLayoutParams.bottomMargin = (int) floatValue;
        this.mDrawer.setLayoutParams(marginLayoutParams);
        updateBackground(floatValue);
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.mDrawerListener = drawerListener;
    }

    public void setInitialState(int i2) {
        this.initialState = i2;
    }

    public void setOpenable(boolean z) {
        this.mIsOpenable = z;
    }

    public void showGuide(OnAnimationCallback onAnimationCallback) {
        if (!this.isShowing && this.mIsOpenable && this.drawerLayoutParams != null) {
            fe.mmm.qw.f.fe.qw qwVar = new fe.mmm.qw.f.fe.qw(this);
            int i2 = this.drawerLayoutParams.bottomMargin;
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{(float) i2, (float) (i2 + 500)}).setDuration(600);
            duration.addUpdateListener(qwVar);
            duration.setTarget(this.mDrawer);
            duration.setInterpolator(new LinearInterpolator());
            duration.addListener(new qw(qwVar, onAnimationCallback));
            duration.start();
        }
    }

    public BottomDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public BottomDrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }
}
