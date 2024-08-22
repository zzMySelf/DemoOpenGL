package com.baidu.searchbox.push.set.switchbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.set.switchbutton.AnimationController;
import com.baidu.searchbox.push.set.switchbutton.Configuration;

public class SwitchButton extends CompoundButton {
    private static boolean SHOW_RECT = false;
    /* access modifiers changed from: private */
    public boolean isAnimating;
    private AnimationController mAnimationController;
    private Rect mBackZone;
    private Rect mBounds;
    private float mCenterPos;
    private int mClickTimeout;
    private Configuration mConf;
    private boolean mIsChecked;
    private float mLastX;
    private SBAnimationListener mOnAnimateListener;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private Paint mRectPaint;
    /* access modifiers changed from: private */
    public Rect mSafeZone;
    private RectF mSaveLayerZone;
    private float mStartX;
    private float mStartY;
    /* access modifiers changed from: private */
    public Rect mThumbZone;
    private int mTouchSlop;

    public SwitchButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mIsChecked = false;
        this.mOnAnimateListener = new SBAnimationListener();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SwitchButton);
        this.mConf.setThumbMarginInPixel(ta.getDimensionPixelSize(R.styleable.SwitchButton_kswThumb_margin, this.mConf.getDefaultThumbMarginInPixel()));
        this.mConf.setThumbMarginInPixel(ta.getDimensionPixelSize(R.styleable.SwitchButton_kswThumb_marginTop, this.mConf.getThumbMarginTop()), ta.getDimensionPixelSize(R.styleable.SwitchButton_kswThumb_marginBottom, this.mConf.getThumbMarginBottom()), ta.getDimensionPixelSize(R.styleable.SwitchButton_kswThumb_marginLeft, this.mConf.getThumbMarginLeft()), ta.getDimensionPixelSize(R.styleable.SwitchButton_kswThumb_marginRight, this.mConf.getThumbMarginRight()));
        this.mConf.setRadius((float) ta.getInt(R.styleable.SwitchButton_kswRadius, Configuration.Default.DEFAULT_RADIUS));
        this.mConf.setThumbWidthAndHeightInPixel(ta.getDimensionPixelSize(R.styleable.SwitchButton_kswThumb_width, -1), ta.getDimensionPixelSize(R.styleable.SwitchButton_kswThumb_height, -1));
        this.mConf.setMeasureFactor(ta.getFloat(R.styleable.SwitchButton_kswMeasureFactor, -1.0f));
        this.mConf.setInsetBounds(ta.getDimensionPixelSize(R.styleable.SwitchButton_kswInsetLeft, 0), ta.getDimensionPixelSize(R.styleable.SwitchButton_kswInsetTop, 0), ta.getDimensionPixelSize(R.styleable.SwitchButton_kswInsetRight, 0), ta.getDimensionPixelSize(R.styleable.SwitchButton_kswInsetBottom, 0));
        int velocity = ta.getInteger(R.styleable.SwitchButton_kswAnimationVelocity, -1);
        AnimationController animationController = this.mAnimationController;
        if (animationController != null) {
            animationController.setVelocity(velocity);
        }
        fetchDrawableFromAttr(ta);
        ta.recycle();
        setLayerType(1, (Paint) null);
    }

    public SwitchButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initView() {
        this.mConf = Configuration.getDefault(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mAnimationController = AnimationController.getDefault().init(this.mOnAnimateListener);
        this.mBounds = new Rect();
        if (SHOW_RECT) {
            Paint paint = new Paint();
            this.mRectPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    private void fetchDrawableFromAttr(TypedArray ta) {
        Configuration configuration = this.mConf;
        if (configuration != null) {
            configuration.setOffDrawable(fetchDrawable(ta, R.styleable.SwitchButton_kswOffDrawable, R.styleable.SwitchButton_kswOffColor, Configuration.Default.DEFAULT_OFF_COLOR));
            this.mConf.setOnDrawable(fetchDrawable(ta, R.styleable.SwitchButton_kswOnDrawable, R.styleable.SwitchButton_kswOnColor, Configuration.Default.DEFAULT_ON_COLOR));
            this.mConf.setThumbDrawable(fetchThumbDrawable(ta));
        }
    }

    private Drawable fetchDrawable(TypedArray ta, int attrId, int alterColorId, int defaultColor) {
        Drawable tempDrawable = ta.getDrawable(attrId);
        if (tempDrawable != null) {
            return tempDrawable;
        }
        int tempColor = ta.getColor(alterColorId, defaultColor);
        Drawable tempDrawable2 = new GradientDrawable();
        ((GradientDrawable) tempDrawable2).setCornerRadius(this.mConf.getRadius());
        ((GradientDrawable) tempDrawable2).setColor(tempColor);
        return tempDrawable2;
    }

    private Drawable fetchThumbDrawable(TypedArray ta) {
        Drawable tempDrawable = ta.getDrawable(R.styleable.SwitchButton_kswThumbDrawable);
        if (tempDrawable != null) {
            return tempDrawable;
        }
        int normalColor = ta.getColor(R.styleable.SwitchButton_kswThumbColor, Configuration.Default.DEFAULT_THUMB_COLOR);
        int pressedColor = ta.getColor(R.styleable.SwitchButton_kswThumbPressedColor, Configuration.Default.DEFAULT_THUMB_PRESSED_COLOR);
        StateListDrawable drawable = new StateListDrawable();
        GradientDrawable normalDrawable = new GradientDrawable();
        normalDrawable.setCornerRadius(this.mConf.getRadius());
        normalDrawable.setColor(normalColor);
        GradientDrawable pressedDrawable = new GradientDrawable();
        pressedDrawable.setCornerRadius(this.mConf.getRadius());
        pressedDrawable.setColor(pressedColor);
        drawable.addState(View.PRESSED_ENABLED_STATE_SET, pressedDrawable);
        drawable.addState(new int[0], normalDrawable);
        return drawable;
    }

    public Configuration getConfiguration() {
        return this.mConf;
    }

    public void setConfiguration(Configuration conf) {
        if (this.mConf == null) {
            this.mConf = Configuration.getDefault(conf.getDensity());
        }
        this.mConf.setOffDrawable(conf.getOffDrawableWithFix());
        this.mConf.setOnDrawable(conf.getOnDrawableWithFix());
        this.mConf.setThumbDrawable(conf.getThumbDrawableWithFix());
        this.mConf.setThumbMarginInPixel(conf.getThumbMarginTop(), conf.getThumbMarginBottom(), conf.getThumbMarginLeft(), conf.getThumbMarginRight());
        this.mConf.setThumbWidthAndHeightInPixel(conf.getThumbWidth(), conf.getThumbHeight());
        this.mConf.setVelocity(conf.getVelocity());
        this.mConf.setMeasureFactor(conf.getMeasureFactor());
        AnimationController animationController = this.mAnimationController;
        if (animationController != null) {
            animationController.setVelocity(this.mConf.getVelocity());
        }
        requestLayout();
        setup();
        setChecked(this.mIsChecked);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        setup();
    }

    private void setup() {
        setupBackZone();
        setupSafeZone();
        setupThumbZone();
        setupDrawableBounds();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.mSaveLayerZone = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
        ViewGroup parent = (ViewGroup) getParent();
        if (parent != null) {
            parent.setClipChildren(false);
        }
    }

    private void setupSafeZone() {
        int w = getMeasuredWidth();
        int h2 = getMeasuredHeight();
        if (w <= 0 || h2 <= 0) {
            this.mSafeZone = null;
            return;
        }
        if (this.mSafeZone == null) {
            this.mSafeZone = new Rect();
        }
        int i2 = 0;
        int left = getPaddingLeft() + (this.mConf.getThumbMarginLeft() > 0 ? this.mConf.getThumbMarginLeft() : 0);
        int right = ((w - getPaddingRight()) - (this.mConf.getThumbMarginRight() > 0 ? this.mConf.getThumbMarginRight() : 0)) + (-this.mConf.getShrinkX());
        int top = getPaddingTop() + (this.mConf.getThumbMarginTop() > 0 ? this.mConf.getThumbMarginTop() : 0);
        int paddingBottom = h2 - getPaddingBottom();
        if (this.mConf.getThumbMarginBottom() > 0) {
            i2 = this.mConf.getThumbMarginBottom();
        }
        this.mSafeZone.set(left, top, right, (paddingBottom - i2) + (-this.mConf.getShrinkY()));
        this.mCenterPos = (float) (this.mSafeZone.left + (((this.mSafeZone.right - this.mSafeZone.left) - this.mConf.getThumbWidth()) / 2));
    }

    private void setupBackZone() {
        int w = getMeasuredWidth();
        int h2 = getMeasuredHeight();
        if (w <= 0 || h2 <= 0) {
            this.mBackZone = null;
            return;
        }
        if (this.mBackZone == null) {
            this.mBackZone = new Rect();
        }
        int i2 = 0;
        int left = getPaddingLeft() + (this.mConf.getThumbMarginLeft() > 0 ? 0 : -this.mConf.getThumbMarginLeft());
        int right = ((w - getPaddingRight()) - (this.mConf.getThumbMarginRight() > 0 ? 0 : -this.mConf.getThumbMarginRight())) + (-this.mConf.getShrinkX());
        int top = getPaddingTop() + (this.mConf.getThumbMarginTop() > 0 ? 0 : -this.mConf.getThumbMarginTop());
        int paddingBottom = h2 - getPaddingBottom();
        if (this.mConf.getThumbMarginBottom() <= 0) {
            i2 = -this.mConf.getThumbMarginBottom();
        }
        this.mBackZone.set(left, top, right, (paddingBottom - i2) + (-this.mConf.getShrinkY()));
    }

    private void setupThumbZone() {
        int w = getMeasuredWidth();
        int h2 = getMeasuredHeight();
        if (w <= 0 || h2 <= 0) {
            this.mThumbZone = null;
            return;
        }
        if (this.mThumbZone == null) {
            this.mThumbZone = new Rect();
        }
        int left = this.mIsChecked ? this.mSafeZone.right - this.mConf.getThumbWidth() : this.mSafeZone.left;
        int top = this.mSafeZone.top;
        this.mThumbZone.set(left, top, this.mConf.getThumbWidth() + left, this.mConf.getThumbHeight() + top);
    }

    private void setupDrawableBounds() {
        if (this.mBackZone != null) {
            this.mConf.getOnDrawable().setBounds(this.mBackZone);
            this.mConf.getOffDrawable().setBounds(this.mBackZone);
        }
        if (this.mThumbZone != null) {
            this.mConf.getThumbDrawable().setBounds(this.mThumbZone);
        }
    }

    private int measureWidth(int measureSpec) {
        int measuredWidth;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        int minWidth = (int) ((((float) this.mConf.getThumbWidth()) * this.mConf.getMeasureFactor()) + ((float) getPaddingLeft()) + ((float) getPaddingRight()));
        int innerMarginWidth = this.mConf.getThumbMarginLeft() + this.mConf.getThumbMarginRight();
        if (innerMarginWidth > 0) {
            minWidth += innerMarginWidth;
        }
        if (specMode == 1073741824) {
            measuredWidth = Math.max(specSize, minWidth);
        } else {
            measuredWidth = minWidth;
            if (specMode == Integer.MIN_VALUE) {
                measuredWidth = Math.min(specSize, minWidth);
            }
        }
        return measuredWidth + this.mConf.getInsetBounds().left + this.mConf.getInsetBounds().right;
    }

    private int measureHeight(int measureSpec) {
        int measuredHeight;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        int minHeight = this.mConf.getThumbHeight() + getPaddingTop() + getPaddingBottom();
        int innerMarginHeight = this.mConf.getThumbMarginTop() + this.mConf.getThumbMarginBottom();
        if (innerMarginHeight > 0) {
            minHeight += innerMarginHeight;
        }
        if (specMode == 1073741824) {
            measuredHeight = Math.max(specSize, minHeight);
        } else {
            measuredHeight = minHeight;
            if (specMode == Integer.MIN_VALUE) {
                measuredHeight = Math.min(specSize, minHeight);
            }
        }
        return measuredHeight + this.mConf.getInsetBounds().top + this.mConf.getInsetBounds().bottom;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.mConf.needShrink()) {
            this.mBounds.inset(this.mConf.getInsetX(), this.mConf.getInsetY());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate((float) this.mConf.getInsetBounds().left, (float) this.mConf.getInsetBounds().top);
        }
        boolean useGeneralDisableEffect = !isEnabled() && notStatableDrawable();
        if (useGeneralDisableEffect) {
            canvas.saveLayerAlpha(this.mSaveLayerZone, 127, 31);
        }
        this.mConf.getOffDrawable().draw(canvas);
        this.mConf.getOnDrawable().setAlpha(calcAlpha());
        this.mConf.getOnDrawable().draw(canvas);
        this.mConf.getThumbDrawable().draw(canvas);
        if (useGeneralDisableEffect) {
            canvas.restore();
        }
        if (SHOW_RECT) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.mBackZone, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.mSafeZone, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.mThumbZone, this.mRectPaint);
        }
    }

    private boolean notStatableDrawable() {
        return !(this.mConf.getThumbDrawable() instanceof StateListDrawable) || !(this.mConf.getOnDrawable() instanceof StateListDrawable) || !(this.mConf.getOffDrawable() instanceof StateListDrawable);
    }

    private int calcAlpha() {
        int backWidth;
        Rect rect = this.mSafeZone;
        if (rect == null || rect.right == this.mSafeZone.left || (backWidth = (this.mSafeZone.right - this.mConf.getThumbWidth()) - this.mSafeZone.left) <= 0) {
            return 255;
        }
        return ((this.mThumbZone.left - this.mSafeZone.left) * 255) / backWidth;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = event.getAction();
        float deltaX = event.getX() - this.mStartX;
        float deltaY = event.getY() - this.mStartY;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                catchView();
                this.mStartX = event.getX();
                this.mStartY = event.getY();
                this.mLastX = this.mStartX;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean nextStatus = getStatusBasedOnPos();
                float time = (float) (event.getEventTime() - event.getDownTime());
                int i2 = this.mTouchSlop;
                if (deltaX < ((float) i2) && deltaY < ((float) i2) && time < ((float) this.mClickTimeout)) {
                    performClick();
                    break;
                } else {
                    slideToChecked(nextStatus);
                    break;
                }
                break;
            case 2:
                float x = event.getX();
                moveThumb((int) (x - this.mLastX));
                this.mLastX = x;
                break;
        }
        invalidate();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.mThumbZone.left) > this.mCenterPos;
    }

    public void invalidate() {
        if (this.mBounds == null || !this.mConf.needShrink()) {
            super.invalidate();
        } else {
            invalidate(this.mBounds);
        }
    }

    public boolean performClick() {
        return super.performClick();
    }

    private void catchView() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean checked, boolean trigger) {
        if (this.mThumbZone != null) {
            int measuredWidth = getMeasuredWidth();
            if (!checked) {
                measuredWidth = -measuredWidth;
            }
            moveThumb(measuredWidth);
        }
        setCheckedInClass(checked, trigger);
    }

    public void setChecked(boolean checked) {
        setChecked(checked, true);
    }

    public void toggle(boolean animated) {
        if (animated) {
            slideToChecked(!this.mIsChecked);
        } else {
            setChecked(!this.mIsChecked);
        }
    }

    public void toggle() {
        toggle(true);
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Configuration configuration = this.mConf;
        if (configuration != null) {
            setDrawableState(configuration.getThumbDrawable());
            setDrawableState(this.mConf.getOnDrawable());
            setDrawableState(this.mConf.getOffDrawable());
        }
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener != null || !AppConfig.isDebug()) {
            this.mOnCheckedChangeListener = onCheckedChangeListener;
            return;
        }
        throw new IllegalArgumentException("onCheckedChangeListener can not be null");
    }

    /* access modifiers changed from: private */
    public void setCheckedInClass(boolean checked) {
        setCheckedInClass(checked, true);
    }

    private void setCheckedInClass(boolean checked, boolean trigger) {
        if (this.mIsChecked != checked) {
            this.mIsChecked = checked;
            refreshDrawableState();
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
            if (onCheckedChangeListener != null && trigger) {
                onCheckedChangeListener.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void slideToChecked(boolean checked) {
        if (!this.isAnimating) {
            int from = this.mThumbZone.left;
            Rect rect = this.mSafeZone;
            int to = checked ? rect.right - this.mConf.getThumbWidth() : rect.left;
            AnimationController animationController = this.mAnimationController;
            if (animationController != null) {
                animationController.startAnimation(from, to);
            }
        }
    }

    /* access modifiers changed from: private */
    public void moveThumb(int delta) {
        int newLeft = this.mThumbZone.left + delta;
        int newRight = this.mThumbZone.right + delta;
        if (newLeft < this.mSafeZone.left) {
            newLeft = this.mSafeZone.left;
            newRight = newLeft + this.mConf.getThumbWidth();
        }
        if (newRight > this.mSafeZone.right) {
            newRight = this.mSafeZone.right;
            newLeft = newRight - this.mConf.getThumbWidth();
        }
        moveThumbTo(newLeft, newRight);
    }

    private void moveThumbTo(int newLeft, int newRight) {
        Rect rect = this.mThumbZone;
        rect.set(newLeft, rect.top, newRight, this.mThumbZone.bottom);
        this.mConf.getThumbDrawable().setBounds(this.mThumbZone);
    }

    class SBAnimationListener implements AnimationController.OnAnimateListener {
        SBAnimationListener() {
        }

        public void onAnimationStart() {
            boolean unused = SwitchButton.this.isAnimating = true;
        }

        public boolean continueAnimating() {
            return SwitchButton.this.mThumbZone.right < SwitchButton.this.mSafeZone.right && SwitchButton.this.mThumbZone.left > SwitchButton.this.mSafeZone.left;
        }

        public void onFrameUpdate(int frame) {
            SwitchButton.this.moveThumb(frame);
            SwitchButton.this.postInvalidate();
        }

        public void onAnimateComplete() {
            SwitchButton switchButton = SwitchButton.this;
            switchButton.setCheckedInClass(switchButton.getStatusBasedOnPos());
            boolean unused = SwitchButton.this.isAnimating = false;
        }
    }
}
