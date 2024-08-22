package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.android.common.others.UIUtils;
import com.baidu.android.common.others.java.Pair;
import com.baidu.android.util.devices.DeviceUtil;

public class DrawableCenterTextView extends TextView {
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 2;
    public static final int POSITION_TOP = 1;
    public static final int POSITION_UNKNOWN = -1;
    private static final float STANDARD_CORNER_RADIUS = 4.0f;
    private boolean isDrawBg;
    private boolean isDrawBorder;
    private boolean isDrawSingleBorder;
    private boolean isPressEnable;
    private boolean isPressed;
    private float mAnimationPercent;
    private Pair<Object, Object> mBgColor;
    private Object mBorderColor;
    private float mCornerRadius;
    private boolean mIsAnimationActive;
    private Paint mOutShadowPaint;
    private GradientDrawable mRoundDrawable;
    private Path mRoundPath;
    private Object mSingleBorderColor;
    private int mSingleBorderDirect;

    public DrawableCenterTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRoundDrawable = new GradientDrawable();
        this.mOutShadowPaint = null;
        this.mRoundPath = new Path();
        this.mBgColor = null;
        this.isPressed = false;
        this.mCornerRadius = -1.0f;
        this.mAnimationPercent = 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        onDrawBackground(canvas);
        onDrawableAndTextRelocated(canvas);
        super.onDraw(canvas);
    }

    private void onDrawableAndTextRelocated(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        Drawable drawable = null;
        int flag = -1;
        if (drawables != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= drawables.length) {
                    break;
                } else if (drawables[i2] != null) {
                    drawable = drawables[i2];
                    flag = i2;
                    break;
                } else {
                    i2++;
                }
            }
        }
        int textWidth = UIUtils.getTextViewWidth(this);
        int textHeight = UIUtils.getTextViewHeight(this);
        int drawablePadding = getCompoundDrawablePadding();
        int drawableWidth = 0;
        int drawableHeight = 0;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            drawableWidth = bounds.right - bounds.left;
            drawableHeight = bounds.bottom - bounds.top;
        }
        int newWidth = 0;
        int newHeight = 0;
        if (flag == 0 || flag == 2) {
            newWidth = textWidth + drawableWidth + drawablePadding;
        } else if (flag == 1 || flag == 3) {
            newHeight = textHeight + drawableHeight + drawablePadding;
        }
        int dx = 0;
        int dy = 0;
        int withoutPaddingWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int withoutPaddingHeight = (getHeight() - getPaddingTop()) - getPaddingBottom();
        switch (flag) {
            case 0:
                setGravity(19);
                dx = withoutPaddingWidth - newWidth;
                break;
            case 1:
                setGravity(49);
                dy = withoutPaddingHeight - newHeight;
                break;
            case 2:
                setGravity(21);
                dx = newWidth - withoutPaddingWidth;
                break;
            case 3:
                setGravity(81);
                dy = newHeight - withoutPaddingHeight;
                break;
            default:
                setGravity(19);
                dx = withoutPaddingWidth - textWidth;
                break;
        }
        Drawable[] drawableArr = drawables;
        canvas.translate((float) (dx / 2), (float) (dy / 2));
    }

    private void onDrawBackground(Canvas canvas) {
        if (isEnableHandlePress()) {
            float f2 = this.mCornerRadius;
            if (f2 >= 0.0f) {
                this.mRoundDrawable.setCornerRadius(f2);
            } else {
                this.mRoundDrawable.setCornerRadius(4.0f);
            }
            if (this.isDrawBorder) {
                int strokeWidth = DeviceUtil.ScreenInfo.dp2px(getContext(), 0.5f);
                Object obj = this.mBorderColor;
                if (obj instanceof String) {
                    this.mRoundDrawable.setStroke(strokeWidth, Color.parseColor(obj.toString()));
                } else if (obj instanceof Integer) {
                    this.mRoundDrawable.setStroke(strokeWidth, getResources().getColor(Integer.valueOf(this.mBorderColor.toString()).intValue()));
                }
            }
            if (this.isPressed != 0) {
                if (this.mBgColor.mSecond instanceof String) {
                    this.mRoundDrawable.setColor(Color.parseColor(this.mBgColor.mSecond.toString()));
                } else if (this.mBgColor.mSecond instanceof Integer) {
                    this.mRoundDrawable.setColor(getResources().getColor(Integer.valueOf(this.mBgColor.mSecond.toString()).intValue()));
                }
            } else if (this.mBgColor.mFirst instanceof String) {
                this.mRoundDrawable.setColor(Color.parseColor(this.mBgColor.mFirst.toString()));
            } else if (this.mBgColor.mFirst instanceof Integer) {
                this.mRoundDrawable.setColor(getResources().getColor(Integer.valueOf(this.mBgColor.mFirst.toString()).intValue()));
            }
            canvas.save();
            if (this.mIsAnimationActive) {
                generateNextAnimationFrame();
            } else {
                this.mRoundDrawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.mRoundDrawable.draw(canvas);
            if (this.isDrawSingleBorder) {
                onDrawSingleBorder(canvas);
            }
            canvas.restore();
        }
    }

    private void onDrawSingleBorder(Canvas canvas) {
        float startX = 0.0f;
        float startY = 0.0f;
        float endX = (float) getWidth();
        float endY = (float) getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth((float) DeviceUtil.ScreenInfo.dp2px(getContext(), 0.5f));
        Object obj = this.mSingleBorderColor;
        if (obj instanceof String) {
            paint.setColor(Color.parseColor(obj.toString()));
        } else if (obj instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.mSingleBorderColor.toString()).intValue()));
        }
        switch (this.mSingleBorderDirect) {
            case 0:
                endX = 0.0f;
                break;
            case 1:
                endY = 0.0f;
                break;
            case 2:
                startX = (float) getWidth();
                break;
            case 3:
                startY = (float) getHeight();
                break;
        }
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    public void setAnimationPercent(float percent) {
        if (this.mAnimationPercent != percent) {
            this.mAnimationPercent = percent;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean isActive) {
        this.mIsAnimationActive = isActive;
    }

    private void generateNextAnimationFrame() {
        if (this.mRoundDrawable != null) {
            int[] size = {getWidth(), getHeight()};
            if (this.mIsAnimationActive) {
                size[0] = (int) (((float) getWidth()) * this.mAnimationPercent);
                size[1] = getHeight();
            }
            int archerPosition = getWidth() / 2;
            this.mRoundDrawable.setBounds(archerPosition - (size[0] / 2), 0, (size[0] / 2) + archerPosition, getHeight());
        }
    }

    public void setShadowLayer(float radius, float dx, float dy, int color) {
        initShadowPaint();
        RectF rect = new RectF(radius, radius, radius, radius);
        rect.offset(dx, dy);
        int bottom = 0;
        int left = rect.left < 0.0f ? 0 : (int) (rect.left + 0.5f);
        int right = rect.right < 0.0f ? 0 : (int) (rect.right + 0.5f);
        int top = rect.top < 0.0f ? 0 : (int) (rect.top + 0.5f);
        if (rect.bottom >= 0.0f) {
            bottom = (int) (rect.bottom + 0.5f);
        }
        setPadding(left, top, right, bottom);
        this.mOutShadowPaint.setShadowLayer(radius, dx, dy, color);
    }

    private void initShadowPaint() {
        if (this.mOutShadowPaint == null) {
            Paint paint = new Paint();
            this.mOutShadowPaint = paint;
            paint.setColor(0);
            this.mOutShadowPaint.setStyle(Paint.Style.STROKE);
            this.mOutShadowPaint.setAntiAlias(true);
            this.mOutShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public void initDrawable(Drawable drawable, int position, int drawableWidth, int drawableHeight) {
        if (drawable != null && position > -1 && position <= 3) {
            if (drawableWidth <= 0 || drawableHeight <= 0) {
                drawableWidth = drawable.getIntrinsicWidth();
                drawableHeight = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, drawableWidth, drawableHeight);
            switch (position) {
                case 0:
                    setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    return;
                case 1:
                    setCompoundDrawables((Drawable) null, drawable, (Drawable) null, (Drawable) null);
                    return;
                case 2:
                    setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                    return;
                case 3:
                    setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, drawable);
                    return;
                default:
                    return;
            }
        }
    }

    public void initBgColor(Object normalColor, Object pressedColor) {
        if (!UIUtils.isColorValid(normalColor) || !UIUtils.isColorValid(pressedColor)) {
            this.isPressEnable = false;
            return;
        }
        this.mBgColor = new Pair<>(normalColor, pressedColor);
        this.isPressEnable = true;
    }

    public void initBorderColor(Object borderColor) {
        if (!UIUtils.isColorValid(borderColor)) {
            this.isDrawBorder = false;
            return;
        }
        this.isDrawBorder = true;
        this.mBorderColor = borderColor;
    }

    public void initSingleBorder(Object singleBorderColor, int borderDirect) {
        if (!UIUtils.isColorValid(singleBorderColor)) {
            this.isDrawSingleBorder = false;
        } else if (borderDirect < 0 || borderDirect > 3) {
            this.isDrawSingleBorder = false;
        } else {
            this.isDrawSingleBorder = true;
            this.mSingleBorderColor = singleBorderColor;
            this.mSingleBorderDirect = borderDirect;
        }
    }

    public void initCornerRadius(int radius) {
        this.mCornerRadius = (float) radius;
    }

    private boolean isEnableHandlePress() {
        return this.isPressEnable && this.mBgColor != null;
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                if (isEnableHandlePress()) {
                    this.isPressed = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (isEnableHandlePress()) {
                    this.isPressed = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (isEnableHandlePress()) {
                    this.isPressed = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
