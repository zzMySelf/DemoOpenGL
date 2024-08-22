package com.baidu.searchbox.account.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.baidu.searchbox.account.R;

public class ShadowLayout extends FrameLayout {
    public static final int SHADOW_MODEL_AUTO = 0;
    public static final int SHADOW_MODEL_PATH = 2;
    public static final int SHADOW_MODEL_SHAP = 1;
    private ShadowDelegate mShadowDeltegate;

    public interface Shadow {
        boolean onClipChildCanvas(Canvas canvas, View view2);

        void onDraw(Canvas canvas);

        void onDrawOver(Canvas canvas);

        void onLayout(View view2, int i2, int i3, int i4, int i5);

        void setParameter(int i2, int i3, float f2, float f3, float f4, float f5, Rect rect);
    }

    public interface ShadowDelegate {
        void invalidateShadow();

        void onAttachToWindow();

        boolean onClipCanvas(Canvas canvas, View view2);

        void onDetachedFromWindow();

        void onDraw(Canvas canvas);

        void onDrawOver(Canvas canvas);

        void onLayout(boolean z, int i2, int i3, int i4, int i5);

        void setShadowColor(int i2);
    }

    public ShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShadowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShadowLayout);
        int model = typedArray.getInt(R.styleable.ShadowLayout_sl_shadow_model, 0);
        if (model == 0) {
            this.mShadowDeltegate = new AutoModel(this, typedArray);
        } else if (model == 1) {
            this.mShadowDeltegate = new ExactlyModel(this, typedArray);
        } else if (model == 2) {
            this.mShadowDeltegate = new PathModel(this, typedArray);
        }
        typedArray.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mShadowDeltegate.onLayout(changed, left, top, right, bottom);
        this.mShadowDeltegate.invalidateShadow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mShadowDeltegate.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mShadowDeltegate.onAttachToWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        this.mShadowDeltegate.onDraw(canvas);
        this.mShadowDeltegate.onDrawOver(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        try {
            canvas.save();
            return this.mShadowDeltegate.onClipCanvas(canvas, child) & super.drawChild(canvas, child, drawingTime);
        } finally {
            canvas.restore();
        }
    }

    public void setShadowColor(int color) {
        this.mShadowDeltegate.setShadowColor(color);
    }

    public void superDispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public ShadowDelegate getShadowDeltegate() {
        return this.mShadowDeltegate;
    }

    public static int adjustAlpha(int shadowAlpha, int shadowColor) {
        return Color.argb(shadowAlpha, Color.red(shadowColor), Color.green(shadowColor), Color.blue(shadowColor));
    }

    public static int convertDpToPx(Context context, float dp) {
        return (int) ((dp * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static class AutoModel implements ShadowDelegate {
        private static final float DEFAULT_SHADOW_ANGLE = 45.0f;
        private static final int DEFAULT_SHADOW_COLOR = -12303292;
        private static final float DEFAULT_SHADOW_DISTANCE = 15.0f;
        private static final float DEFAULT_SHADOW_RADIUS = 30.0f;
        private static final int MAX_ALPHA = 255;
        private static final float MAX_ANGLE = 360.0f;
        private static final float MIN_ANGLE = 0.0f;
        private static final float MIN_RADIUS = 0.1f;
        private Bitmap mBitmap;
        private final Rect mBounds = new Rect();
        private final Canvas mCanvas = new Canvas();
        Path mClipPath;
        private boolean mDrawCenter = true;
        private boolean mInvalidateShadow = true;
        private boolean mIsShadowed;
        private float mOffsetDx;
        private float mOffsetDy;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private final Paint mPaint;
        ShadowLayout mParent;
        private int mShadowAlpha;
        private float mShadowAngle;
        private int mShadowColor;
        private float mShadowDistance;
        private float mShadowRadius;
        private float mZoomDy;

        public AutoModel(ShadowLayout parent, TypedArray typedArray) {
            AnonymousClass1 r0 = new Paint(1) {
                {
                    setDither(true);
                    setFilterBitmap(true);
                }
            };
            this.mPaint = r0;
            this.mParent = parent;
            parent.setWillNotDraw(false);
            this.mParent.setLayerType(2, r0);
            setIsShadowed(typedArray.getBoolean(R.styleable.ShadowLayout_sl_shadowed, true));
            setShadowRadius(typedArray.getDimension(R.styleable.ShadowLayout_sl_shadow_radius, 30.0f));
            this.mOffsetDx = (float) typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_shadow_offsetdx, Integer.MAX_VALUE);
            this.mOffsetDy = (float) typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_shadow_offsetdy, Integer.MAX_VALUE);
            this.mShadowDistance = typedArray.getDimension(R.styleable.ShadowLayout_sl_shadow_distance, 0.0f);
            setShadowAngle((float) typedArray.getInteger(R.styleable.ShadowLayout_sl_shadow_angle, 45));
            setShadowColor(typedArray.getColor(R.styleable.ShadowLayout_sl_shadow_color, -12303292));
            this.mZoomDy = (float) typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_shadow_zoomdy, 0);
            this.mPaddingLeft = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_paddingLeft, 0);
            this.mPaddingRight = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_paddingRight, 0);
            this.mPaddingTop = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_paddingTop, 0);
            this.mPaddingBottom = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_paddingBottom, 0);
            int shadowPadding = (int) (this.mShadowRadius + Math.max(this.mOffsetDx, this.mOffsetDy));
            if (this.mOffsetDx != 0.0f) {
                this.mPaddingLeft = shadowPadding;
                this.mPaddingRight = shadowPadding;
            }
            if (this.mOffsetDy != 0.0f) {
                this.mPaddingTop = shadowPadding;
                this.mPaddingBottom = shadowPadding;
            }
            this.mParent.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        }

        public void onDetachedFromWindow() {
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
        }

        public boolean isShadowed() {
            return this.mIsShadowed;
        }

        public void setIsShadowed(boolean isShadowed) {
            this.mIsShadowed = isShadowed;
            if (this.mParent.isLayoutRequested() && this.mParent.getParent() != null) {
                this.mParent.postInvalidate();
            }
        }

        public float getShadowDistance() {
            return this.mShadowDistance;
        }

        public void setShadowDistance(float shadowDistance) {
            this.mShadowDistance = shadowDistance;
            resetShadow();
        }

        public float getShadowAngle() {
            return this.mShadowAngle;
        }

        public void setShadowAngle(float shadowAngle) {
            this.mShadowAngle = Math.max(0.0f, Math.min(shadowAngle, 360.0f));
            resetShadow();
        }

        public float getShadowRadius() {
            return this.mShadowRadius;
        }

        public void setShadowRadius(float shadowRadius) {
            this.mShadowRadius = Math.max(0.1f, shadowRadius);
            if (!this.mParent.isInEditMode()) {
                this.mPaint.setMaskFilter(new BlurMaskFilter(this.mShadowRadius, BlurMaskFilter.Blur.NORMAL));
                invalidateShadow();
            }
        }

        public void setRadius(float shadowRadius) {
            this.mShadowRadius = Math.max(0.1f, shadowRadius);
            if (!this.mParent.isInEditMode()) {
                this.mPaint.setMaskFilter(new BlurMaskFilter(this.mShadowRadius, BlurMaskFilter.Blur.NORMAL));
                this.mInvalidateShadow = true;
                this.mParent.postInvalidate();
            }
        }

        public int getShadowColor() {
            return this.mShadowColor;
        }

        public void setShadowColor(int shadowColor) {
            this.mShadowColor = shadowColor;
            this.mShadowAlpha = Color.alpha(shadowColor);
            invalidateShadow();
        }

        public void invalidateShadow() {
            this.mInvalidateShadow = true;
            this.mParent.postInvalidate();
        }

        public float getOffsetDx() {
            return this.mOffsetDx;
        }

        public float getOffsetDy() {
            return this.mOffsetDy;
        }

        private void resetShadow() {
            float f2 = this.mShadowDistance;
            if (f2 > 0.0f) {
                this.mOffsetDx = (float) (((double) f2) * Math.cos(((double) (this.mShadowAngle / 180.0f)) * 3.141592653589793d));
                this.mOffsetDy = (float) (((double) this.mShadowDistance) * Math.sin(((double) (this.mShadowAngle / 180.0f)) * 3.141592653589793d));
            }
            this.mInvalidateShadow = true;
            this.mParent.postInvalidate();
        }

        private int adjustShadowAlpha(boolean adjust) {
            return Color.argb(adjust ? 255 : this.mShadowAlpha, Color.red(this.mShadowColor), Color.green(this.mShadowColor), Color.blue(this.mShadowColor));
        }

        public void onLayout(boolean changed, int left, int top, int right, int bottom) {
            this.mBounds.set(0, 0, this.mParent.getMeasuredWidth(), this.mParent.getMeasuredHeight());
        }

        public void onAttachToWindow() {
        }

        public void onDraw(Canvas canvas) {
            Bitmap bitmap;
            if (this.mIsShadowed) {
                if (this.mInvalidateShadow) {
                    if (this.mBounds.width() == 0 || this.mBounds.height() == 0) {
                        this.mBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
                    } else {
                        Bitmap createBitmap = Bitmap.createBitmap(this.mBounds.width(), this.mBounds.height(), Bitmap.Config.ARGB_8888);
                        this.mBitmap = createBitmap;
                        this.mCanvas.setBitmap(createBitmap);
                        this.mInvalidateShadow = false;
                        this.mParent.superDispatchDraw(this.mCanvas);
                        Bitmap extractedAlpha = this.mBitmap.extractAlpha();
                        this.mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        this.mPaint.setColor(adjustShadowAlpha(false));
                        float f2 = this.mZoomDy;
                        if (!(f2 == 0.0f || f2 == 2.14748365E9f)) {
                            extractedAlpha = getScaleBitmap(extractedAlpha, f2);
                        }
                        if (this.mDrawCenter) {
                            int w = extractedAlpha.getWidth();
                            int h2 = extractedAlpha.getHeight();
                            float width = ((float) (this.mCanvas.getWidth() - w)) / 2.0f;
                            float f3 = this.mOffsetDx;
                            if (f3 == 2.14748365E9f) {
                                f3 = 0.0f;
                            }
                            float l = width + f3;
                            float height = ((float) (this.mCanvas.getHeight() - h2)) / 2.0f;
                            float f4 = this.mOffsetDy;
                            if (f4 == 2.14748365E9f) {
                                f4 = 0.0f;
                            }
                            this.mCanvas.drawBitmap(extractedAlpha, l, height + f4, this.mPaint);
                        } else {
                            Canvas canvas2 = this.mCanvas;
                            float f5 = this.mOffsetDx;
                            if (f5 == 2.14748365E9f) {
                                f5 = 0.0f;
                            }
                            float f6 = this.mOffsetDy;
                            if (f6 == 2.14748365E9f) {
                                f6 = 0.0f;
                            }
                            canvas2.drawBitmap(extractedAlpha, f5, f6, this.mPaint);
                        }
                        extractedAlpha.recycle();
                    }
                }
                this.mPaint.setColor(adjustShadowAlpha(true));
                if (!(this.mCanvas == null || (bitmap = this.mBitmap) == null || bitmap.isRecycled())) {
                    canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
                }
            }
            this.mParent.superDispatchDraw(this.mCanvas);
        }

        public void onDrawOver(Canvas canvas) {
        }

        public boolean onClipCanvas(Canvas canvas, View child) {
            Path path = this.mClipPath;
            if (path == null || path.isEmpty()) {
                return false;
            }
            canvas.clipPath(this.mClipPath);
            return false;
        }

        public void setClipPath(Path clipPath) {
            this.mClipPath = clipPath;
            invalidateShadow();
        }

        public void setZoomDy(float dy) {
            this.mInvalidateShadow = true;
            this.mZoomDy = dy;
            this.mParent.postInvalidate();
        }

        public void setOffsetDx(float dx) {
            this.mInvalidateShadow = true;
            this.mOffsetDx = dx;
            this.mParent.postInvalidate();
        }

        public void setOffsetDy(float dy) {
            this.mInvalidateShadow = true;
            this.mOffsetDy = dy;
            this.mParent.postInvalidate();
        }

        public Bitmap getScaleBitmap(Bitmap mBitmap2, float dy) {
            float h2;
            int width = mBitmap2.getWidth();
            int height = mBitmap2.getHeight();
            float h3 = ((float) height) + dy;
            if (h3 <= 1.0f) {
                h2 = 1.0f;
            } else {
                h2 = h3;
            }
            float scale = h2 / ((float) height);
            Matrix matrix = new Matrix();
            matrix.postScale(scale, scale);
            return Bitmap.createBitmap(mBitmap2, 0, 0, width, height, matrix, true);
        }

        public void setDrawCenter(boolean drawCenter) {
            this.mDrawCenter = drawCenter;
            this.mInvalidateShadow = true;
            this.mParent.postInvalidate();
        }
    }

    public static class PathModel implements ShadowDelegate {
        private static final float MIN_RADIUS = 0.1f;
        Rect mBoundsRect = new Rect();
        Path mClipPath;
        private Point mControlPoint1;
        private Point mControlPoint2;
        private float mCoordinatex1;
        private float mCoordinatex2;
        private float mCoordinatey1;
        private float mCoordinatey2;
        private int mEndRightY;
        private float mOffsetDx;
        private float mOffsetDy;
        Paint mPaint;
        ShadowLayout mParent;
        Path mPath;
        private float mRateEndRightY;
        private float mRatgStartLeftY;
        float mShadowRadius;
        Path mShadowpath;
        private int mStartLeftY;
        private boolean useCustom;

        public PathModel(ShadowLayout parent, TypedArray typedArray) {
            this.mParent = parent;
            this.mParent.setWillNotDraw(false);
            this.mParent.setClipToPadding(false);
            this.mParent.setLayerType(1, (Paint) null);
            this.mPath = new Path();
            this.mClipPath = new Path();
            this.mShadowpath = new Path();
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setDither(true);
            this.mPaint.setStyle(Paint.Style.FILL);
            setShadowColor(typedArray.getColor(R.styleable.ShadowLayout_sl_shadow_color, -16777216));
            setShadowRadius(typedArray.getDimension(R.styleable.ShadowLayout_sl_shadow_radius, 25.0f));
            this.mOffsetDx = (float) typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_shadow_offsetdx, 0);
            this.mOffsetDy = (float) typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_sl_shadow_offsetdy, 0);
            this.mCoordinatex1 = typedArray.getFloat(R.styleable.ShadowLayout_shadow_path_coordinatex1, 0.0f);
            this.mCoordinatey1 = typedArray.getFloat(R.styleable.ShadowLayout_shadow_path_coordinatey1, 1.0f);
            this.mCoordinatex2 = typedArray.getFloat(R.styleable.ShadowLayout_shadow_path_coordinatex2, 1.0f);
            this.mCoordinatey2 = typedArray.getFloat(R.styleable.ShadowLayout_shadow_path_coordinatey2, 1.0f);
            this.mRatgStartLeftY = typedArray.getFloat(R.styleable.ShadowLayout_shadow_path_startleft_y_rate, 0.6f);
            this.mRateEndRightY = typedArray.getFloat(R.styleable.ShadowLayout_shadow_path_endright_y_rate, 0.6f);
        }

        public void setShadowRadius(float shadowRadius) {
            this.mShadowRadius = Math.max(0.1f, shadowRadius);
            if (!this.mParent.isInEditMode()) {
                this.mPaint.setMaskFilter(new BlurMaskFilter(this.mShadowRadius, BlurMaskFilter.Blur.NORMAL));
                invalidateShadow();
            }
        }

        public void setPath(Path path) {
            this.useCustom = true;
            this.mClipPath = path;
            invalidateShadow();
        }

        public void setControlPoint1(float xRate, float yRate) {
            this.mCoordinatex1 = xRate;
            this.mCoordinatey1 = yRate;
        }

        public void setControlPoint2(float xRate, float yRate) {
            this.mCoordinatex2 = xRate;
            this.mCoordinatey2 = yRate;
        }

        public void setRatgStartLeftY(int ratgStartLeftY) {
            this.mRatgStartLeftY = (float) ratgStartLeftY;
        }

        public void setRateEndRightY(int rateEndRightY) {
            this.mRateEndRightY = (float) rateEndRightY;
        }

        public void onDraw(Canvas canvas) {
            this.mParent.superDispatchDraw(canvas);
        }

        public void onDrawOver(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.mPath, Region.Op.REPLACE);
            canvas.clipPath(this.mClipPath, Region.Op.DIFFERENCE);
            this.mPaint.setColor(-16777216);
            this.mShadowpath.set(this.mClipPath);
            this.mShadowpath.offset(this.mOffsetDx, this.mOffsetDy);
            canvas.drawPath(this.mShadowpath, this.mPaint);
            canvas.restore();
        }

        public boolean onClipCanvas(Canvas canvas, View child) {
            canvas.clipPath(this.mClipPath);
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            child.invalidateOutline();
            return false;
        }

        public void invalidateShadow() {
            this.mParent.postInvalidate();
        }

        public void setShadowColor(int color) {
            this.mPaint.setColor(color);
            this.mParent.postInvalidate();
        }

        public void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int i2 = left;
            int i3 = top;
            int i4 = right;
            int i5 = bottom;
            this.mBoundsRect.set(i2, i3, i4, i5);
            this.mPath.reset();
            this.mShadowpath.reset();
            this.mPath.lineTo((float) i2, (float) i3);
            this.mPath.lineTo((float) i4, (float) i3);
            this.mPath.lineTo((float) i4, (float) i5);
            this.mPath.lineTo((float) i2, (float) i5);
            this.mPath.lineTo((float) i2, (float) i3);
            if (!this.useCustom) {
                this.mClipPath.reset();
                int width = i4 - i2;
                int height = i5 - i3;
                if (this.mControlPoint1 == null) {
                    this.mControlPoint1 = new Point();
                }
                if (this.mControlPoint2 == null) {
                    this.mControlPoint2 = new Point();
                }
                this.mControlPoint1.set((int) ((this.mCoordinatex1 * ((float) width)) + ((float) i2)), (int) ((this.mCoordinatey1 * ((float) height)) + ((float) i3)));
                this.mControlPoint2.set((int) ((this.mCoordinatex2 * ((float) width)) + ((float) i2)), (int) ((this.mCoordinatey2 * ((float) height)) + ((float) i3)));
                this.mStartLeftY = (int) ((this.mRatgStartLeftY * ((float) height)) + ((float) i3));
                this.mEndRightY = (int) ((this.mRateEndRightY * ((float) height)) + ((float) i3));
                this.mClipPath.moveTo((float) i2, (float) i3);
                this.mClipPath.lineTo((float) i2, (float) this.mStartLeftY);
                this.mClipPath.cubicTo((float) this.mControlPoint1.x, (float) this.mControlPoint1.y, (float) this.mControlPoint2.x, (float) this.mControlPoint2.y, (float) i4, (float) this.mEndRightY);
                this.mClipPath.lineTo((float) i4, (float) i3);
                this.mClipPath.lineTo((float) i2, (float) i3);
            }
        }

        public void changeClipPath() {
            this.mClipPath.reset();
            if (!this.mBoundsRect.isEmpty()) {
                if (this.mControlPoint1 == null) {
                    this.mControlPoint1 = new Point();
                }
                if (this.mControlPoint2 == null) {
                    this.mControlPoint2 = new Point();
                }
                this.mControlPoint1.set((int) ((this.mCoordinatex1 * ((float) this.mBoundsRect.width())) + ((float) this.mBoundsRect.left)), (int) ((this.mCoordinatey1 * ((float) this.mBoundsRect.height())) + ((float) this.mBoundsRect.top)));
                this.mControlPoint2.set((int) ((this.mCoordinatex2 * ((float) this.mBoundsRect.width())) + ((float) this.mBoundsRect.left)), (int) ((this.mCoordinatey2 * ((float) this.mBoundsRect.height())) + ((float) this.mBoundsRect.top)));
                this.mStartLeftY = (int) ((this.mRatgStartLeftY * ((float) this.mBoundsRect.height())) + ((float) this.mBoundsRect.top));
                this.mEndRightY = (int) ((this.mRateEndRightY * ((float) this.mBoundsRect.height())) + ((float) this.mBoundsRect.top));
                this.mClipPath.moveTo((float) this.mBoundsRect.left, (float) this.mBoundsRect.top);
                this.mClipPath.lineTo((float) this.mBoundsRect.left, (float) this.mStartLeftY);
                this.mClipPath.cubicTo((float) this.mControlPoint1.x, (float) this.mControlPoint1.y, (float) this.mControlPoint2.x, (float) this.mControlPoint2.y, (float) this.mBoundsRect.right, (float) this.mEndRightY);
                this.mClipPath.lineTo((float) this.mBoundsRect.right, (float) this.mBoundsRect.top);
                this.mClipPath.lineTo((float) this.mBoundsRect.left, (float) this.mBoundsRect.top);
                invalidateShadow();
            }
        }

        public void onAttachToWindow() {
        }

        public void onDetachedFromWindow() {
        }
    }

    public class ExactlyModel implements ShadowDelegate {
        protected static final String ANIM_PROPERTY_ALPHA_BOTTOM_SHADOW = "alphaBottomShadow";
        protected static final String ANIM_PROPERTY_ALPHA_TOP_SHADOW = "alphaTopShadow";
        protected static final String ANIM_PROPERTY_BLUR_BOTTOM_SHADOW = "blurBottomShadow";
        protected static final String ANIM_PROPERTY_BLUR_TOP_SHADOW = "blurTopShadow";
        protected static final String ANIM_PROPERTY_OFFSET_BOTTOM_SHADOW = "offsetBottomShadow";
        protected static final String ANIM_PROPERTY_OFFSET_TOP_SHADOW = "offsetTopShadow";
        protected static final int DEFAULT_ATTR_SHAPE = 0;
        protected static final int DEFAULT_ATTR_ZDEPTH = 1;
        protected static final int DEFAULT_ATTR_ZDEPTH_ANIM_DURATION = 150;
        protected static final boolean DEFAULT_ATTR_ZDEPTH_DO_ANIMATION = true;
        protected static final int DEFAULT_ATTR_ZDEPTH_PADDING = 5;
        private static final int DEFAULT_SHADOW_COLOR = -14540254;
        protected static final int SHAPE_OVAL = 1;
        protected static final int SHAPE_RECT = 0;
        boolean mClipCanvas;
        /* access modifiers changed from: private */
        public ShadowLayout mParent;
        protected Shadow mShadow;
        /* access modifiers changed from: private */
        public int mShadowColor = -14540254;
        Rect mShadowDrawingRect = new Rect();
        protected long mZDepthAnimDuration;
        protected boolean mZDepthDoAnimation;
        protected int mZDepthPaddingBottom;
        protected int mZDepthPaddingLeft;
        protected int mZDepthPaddingRight;
        protected int mZDepthPaddingTop;
        protected ZDepth mZDepthParam;

        public ExactlyModel(ShadowLayout parent, TypedArray typedArray) {
            this.mParent = parent;
            parent.setClipToPadding(false);
            this.mParent.setLayerType(1, (Paint) null);
            init(typedArray);
        }

        /* access modifiers changed from: protected */
        public void init(TypedArray typedArray) {
            int attrZDepthPaddingRight;
            int attrZDepthPaddingTop;
            int attrZDepthPaddingLeft;
            int attrZDepthPaddingLeft2;
            int attrShape = typedArray.getInt(R.styleable.ShadowLayout_z_depth_shape, 0);
            int attrZDepth = typedArray.getInt(R.styleable.ShadowLayout_z_depth, 1);
            int attrZDepthAnimDuration = typedArray.getInt(R.styleable.ShadowLayout_z_depth_animDuration, 150);
            boolean attrZDepthDoAnimation = typedArray.getBoolean(R.styleable.ShadowLayout_z_depth_doAnim, true);
            int attrZDepthPadding = typedArray.getInt(R.styleable.ShadowLayout_z_depth_padding, -1);
            int attrZDepthPaddingLeft3 = typedArray.getInt(R.styleable.ShadowLayout_z_depth_paddingLeft, -1);
            int attrZDepthPaddingTop2 = typedArray.getInt(R.styleable.ShadowLayout_z_depth_paddingTop, -1);
            int attrZDepthPaddingRight2 = typedArray.getInt(R.styleable.ShadowLayout_z_depth_paddingRight, -1);
            int attrZDepthPaddingBottom = typedArray.getInt(R.styleable.ShadowLayout_z_depth_paddingBottom, -1);
            this.mClipCanvas = typedArray.getBoolean(R.styleable.ShadowLayout_z_depth_clipcanvas, false);
            this.mShadowColor = typedArray.getColor(R.styleable.ShadowLayout_sl_shadow_color, -14540254);
            if (attrZDepthPadding > -1) {
                attrZDepthPaddingLeft2 = attrZDepthPadding;
                attrZDepthPaddingLeft = attrZDepthPadding;
                attrZDepthPaddingTop = attrZDepthPadding;
                attrZDepthPaddingRight = attrZDepthPadding;
            } else {
                int i2 = 5;
                int attrZDepthPaddingLeft4 = attrZDepthPaddingLeft3 > -1 ? attrZDepthPaddingLeft3 : 5;
                int attrZDepthPaddingTop3 = attrZDepthPaddingTop2 > -1 ? attrZDepthPaddingTop2 : 5;
                int attrZDepthPaddingRight3 = attrZDepthPaddingRight2 > -1 ? attrZDepthPaddingRight2 : 5;
                if (attrZDepthPaddingBottom > -1) {
                    i2 = attrZDepthPaddingBottom;
                }
                int i3 = attrZDepthPaddingRight3;
                attrZDepthPaddingRight = i2;
                attrZDepthPaddingLeft2 = attrZDepthPaddingLeft4;
                attrZDepthPaddingLeft = attrZDepthPaddingTop3;
                attrZDepthPaddingTop = i3;
            }
            int roundRectRadius = typedArray.getDimensionPixelOffset(R.styleable.ShadowLayout_sl_shadow_rectroundradius, 0);
            setShape(attrShape);
            if (attrShape == 0) {
                ((ShadowRect) this.mShadow).setRoundRectRadius(roundRectRadius);
            }
            setZDepth(attrZDepth);
            setZDepthPaddingLeft(attrZDepthPaddingLeft2);
            setZDepthPaddingTop(attrZDepthPaddingLeft);
            setZDepthPaddingRight(attrZDepthPaddingTop);
            setZDepthPaddingBottom(attrZDepthPaddingRight);
            setZDepthAnimDuration((long) attrZDepthAnimDuration);
            setZDepthDoAnimation(attrZDepthDoAnimation);
        }

        public Context getContext() {
            return this.mParent.getContext();
        }

        /* access modifiers changed from: protected */
        public void setZDepthDoAnimation(boolean doAnimation) {
            this.mZDepthDoAnimation = doAnimation;
        }

        /* access modifiers changed from: protected */
        public void setZDepthAnimDuration(long duration) {
            this.mZDepthAnimDuration = duration;
        }

        /* access modifiers changed from: protected */
        public void setZDepthPaddingLeft(int zDepthPaddingLeftValue) {
            ZDepth zDepth = getZDepthWithAttributeValue(zDepthPaddingLeftValue);
            zDepth.initZDepth(getContext());
            this.mZDepthPaddingLeft = measureZDepthPadding(zDepth);
        }

        /* access modifiers changed from: protected */
        public void setZDepthPaddingTop(int zDepthPaddingTopValue) {
            ZDepth zDepth = getZDepthWithAttributeValue(zDepthPaddingTopValue);
            zDepth.initZDepth(getContext());
            this.mZDepthPaddingTop = measureZDepthPadding(zDepth);
        }

        /* access modifiers changed from: protected */
        public void setZDepthPaddingRight(int zDepthPaddingRightValue) {
            ZDepth zDepth = getZDepthWithAttributeValue(zDepthPaddingRightValue);
            zDepth.initZDepth(getContext());
            this.mZDepthPaddingRight = measureZDepthPadding(zDepth);
        }

        /* access modifiers changed from: protected */
        public void setZDepthPaddingBottom(int zDepthPaddingBottomValue) {
            ZDepth zDepth = getZDepthWithAttributeValue(zDepthPaddingBottomValue);
            zDepth.initZDepth(getContext());
            this.mZDepthPaddingBottom = measureZDepthPadding(zDepth);
        }

        /* access modifiers changed from: protected */
        public int measureZDepthPadding(ZDepth zDepth) {
            return (int) Math.max(zDepth.mBlurTopShadowPx + zDepth.mOffsetYTopShadowPx, zDepth.mBlurBottomShadowPx + zDepth.mOffsetYBottomShadowPx);
        }

        /* access modifiers changed from: protected */
        public int getZDepthPaddingLeft() {
            return this.mZDepthPaddingLeft;
        }

        /* access modifiers changed from: protected */
        public int getZDepthPaddingTop() {
            return this.mZDepthPaddingTop;
        }

        /* access modifiers changed from: protected */
        public int getZDepthPaddingRight() {
            return this.mZDepthPaddingRight;
        }

        /* access modifiers changed from: protected */
        public int getZDepthPaddingBottom() {
            return this.mZDepthPaddingBottom;
        }

        /* access modifiers changed from: protected */
        public void setShape(int shape) {
            switch (shape) {
                case 0:
                    this.mShadow = new ShadowRect();
                    return;
                case 1:
                    this.mShadow = new ShadowOval();
                    return;
                default:
                    this.mShadow = new ShadowRect();
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public void setZDepth(int zDepthValue) {
            setZDepth(getZDepthWithAttributeValue(zDepthValue));
        }

        /* access modifiers changed from: protected */
        public void setZDepth(ZDepth zDepth) {
            this.mZDepthParam = zDepth;
            zDepth.initZDepth(getContext());
        }

        private ZDepth getZDepthWithAttributeValue(int zDepthValue) {
            switch (zDepthValue) {
                case 0:
                    return ZDepth.Depth0;
                case 1:
                    return ZDepth.Depth1;
                case 2:
                    return ZDepth.Depth2;
                case 3:
                    return ZDepth.Depth3;
                case 4:
                    return ZDepth.Depth4;
                case 5:
                    return ZDepth.Depth5;
                default:
                    return ZDepth.Depth0;
            }
        }

        public void onLayout(boolean changed, int left, int top, int right, int bottom) {
            this.mShadowDrawingRect.setEmpty();
            if (this.mParent.getChildCount() > 0) {
                int childCount = this.mParent.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View child = this.mParent.getChildAt(i2);
                    if (i2 == 0) {
                        this.mShadowDrawingRect.set(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
                    } else {
                        this.mShadowDrawingRect.union(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
                    }
                }
            }
            setParameterToShadow();
            this.mShadow.onLayout(this.mParent, left, top, right, bottom);
        }

        public void onAttachToWindow() {
            this.mParent.setPadding(getZDepthPaddingLeft(), getZDepthPaddingTop(), getZDepthPaddingRight(), getZDepthPaddingBottom());
        }

        public void onDetachedFromWindow() {
        }

        public void onDraw(Canvas canvas) {
            this.mShadow.onDraw(canvas);
            this.mParent.superDispatchDraw(canvas);
        }

        public void onDrawOver(Canvas canvas) {
            this.mShadow.onDrawOver(canvas);
        }

        public boolean onClipCanvas(Canvas canvas, View child) {
            if (!this.mClipCanvas) {
                return false;
            }
            boolean result = this.mShadow.onClipChildCanvas(canvas, child);
            if (Build.VERSION.SDK_INT >= 21) {
                child.invalidateOutline();
            }
            return result;
        }

        public void invalidateShadow() {
            this.mParent.postInvalidate();
        }

        public void setShadowColor(int color) {
            this.mShadowColor = color;
            setParameterToShadow();
            invalidateShadow();
        }

        private int getWidth() {
            return this.mParent.getMeasuredWidth();
        }

        private int getHeight() {
            return this.mParent.getMeasuredHeight();
        }

        public int getWidthExceptShadow() {
            return (getWidth() - this.mParent.getPaddingLeft()) - this.mParent.getPaddingRight();
        }

        public int getHeightExceptShadow() {
            return (getHeight() - this.mParent.getPaddingTop()) - this.mParent.getPaddingBottom();
        }

        private void setParameterToShadow() {
            int colorTop = ShadowLayout.adjustAlpha(this.mZDepthParam.mAlphaTopShadow, this.mShadowColor);
            this.mShadow.setParameter(colorTop, ShadowLayout.adjustAlpha(this.mZDepthParam.mAlphaBottomShadow, this.mShadowColor), this.mZDepthParam.mOffsetYTopShadowPx, this.mZDepthParam.mOffsetYBottomShadowPx, this.mZDepthParam.mBlurTopShadowPx, this.mZDepthParam.mBlurBottomShadowPx, this.mShadowDrawingRect);
        }

        public void changeZDepth(ZDepth zDepth) {
            zDepth.initZDepth(getContext());
            if (!this.mZDepthDoAnimation) {
                this.mZDepthParam = zDepth;
                setParameterToShadow();
                this.mParent.invalidate();
                return;
            }
            PropertyValuesHolder alphaTopShadowHolder = PropertyValuesHolder.ofInt(ANIM_PROPERTY_ALPHA_TOP_SHADOW, new int[]{this.mZDepthParam.mAlphaTopShadow, zDepth.mAlphaTopShadow});
            PropertyValuesHolder alphaBottomShadowHolder = PropertyValuesHolder.ofInt(ANIM_PROPERTY_ALPHA_BOTTOM_SHADOW, new int[]{this.mZDepthParam.mAlphaBottomShadow, zDepth.mAlphaBottomShadow});
            PropertyValuesHolder offsetTopShadowHolder = PropertyValuesHolder.ofFloat(ANIM_PROPERTY_OFFSET_TOP_SHADOW, new float[]{this.mZDepthParam.mOffsetYTopShadow, zDepth.mOffsetYTopShadow});
            PropertyValuesHolder offsetBottomShadowHolder = PropertyValuesHolder.ofFloat(ANIM_PROPERTY_OFFSET_BOTTOM_SHADOW, new float[]{this.mZDepthParam.mOffsetYBottomShadow, zDepth.mOffsetYBottomShadow});
            PropertyValuesHolder blurTopShadowHolder = PropertyValuesHolder.ofFloat(ANIM_PROPERTY_BLUR_TOP_SHADOW, new float[]{this.mZDepthParam.mBlurTopShadow, zDepth.mBlurTopShadow});
            PropertyValuesHolder blurBottomShadowHolder = PropertyValuesHolder.ofFloat(ANIM_PROPERTY_BLUR_BOTTOM_SHADOW, new float[]{this.mZDepthParam.mBlurBottomShadow, zDepth.mBlurBottomShadow});
            this.mZDepthParam = zDepth;
            ValueAnimator anim = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{alphaTopShadowHolder, alphaBottomShadowHolder, offsetTopShadowHolder, offsetBottomShadowHolder, blurTopShadowHolder, blurBottomShadowHolder});
            anim.setDuration(this.mZDepthAnimDuration);
            anim.setInterpolator(new LinearInterpolator());
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    ValueAnimator valueAnimator = animation;
                    int alphaTopShadow = ((Integer) valueAnimator.getAnimatedValue(ExactlyModel.ANIM_PROPERTY_ALPHA_TOP_SHADOW)).intValue();
                    int alphaBottomShadow = ((Integer) valueAnimator.getAnimatedValue(ExactlyModel.ANIM_PROPERTY_ALPHA_BOTTOM_SHADOW)).intValue();
                    float offsetTopShadow = ((Float) valueAnimator.getAnimatedValue(ExactlyModel.ANIM_PROPERTY_OFFSET_TOP_SHADOW)).floatValue();
                    float offsetBottomShadow = ((Float) valueAnimator.getAnimatedValue(ExactlyModel.ANIM_PROPERTY_OFFSET_BOTTOM_SHADOW)).floatValue();
                    float blurTopShadow = ((Float) valueAnimator.getAnimatedValue(ExactlyModel.ANIM_PROPERTY_BLUR_TOP_SHADOW)).floatValue();
                    float blurBottomShadow = ((Float) valueAnimator.getAnimatedValue(ExactlyModel.ANIM_PROPERTY_BLUR_BOTTOM_SHADOW)).floatValue();
                    int colorTop = ShadowLayout.adjustAlpha(alphaTopShadow, ExactlyModel.this.mShadowColor);
                    int colorBottom = ShadowLayout.adjustAlpha(alphaBottomShadow, ExactlyModel.this.mShadowColor);
                    ExactlyModel.this.mShadow.setParameter(colorTop, colorBottom, offsetTopShadow, offsetBottomShadow, blurTopShadow, blurBottomShadow, ExactlyModel.this.mShadowDrawingRect);
                    ExactlyModel.this.mParent.invalidate();
                }
            });
            anim.start();
        }
    }

    public enum ZDepth {
        Depth0(0, 0, 0.0f, 0.0f, 0.0f, 0.0f),
        Depth1(30, 61, 1.0f, 1.0f, 1.5f, 1.0f),
        Depth2(40, 58, 3.0f, 3.0f, 3.0f, 3.0f),
        Depth3(48, 58, 10.0f, 6.0f, 10.0f, 3.0f),
        Depth4(64, 56, 14.0f, 10.0f, 14.0f, 5.0f),
        Depth5(76, 56, 19.0f, 15.0f, 19.0f, 6.0f);
        
        public int mAlphaBottomShadow;
        public int mAlphaTopShadow;
        public final float mBlurBottomShadow;
        public float mBlurBottomShadowPx;
        public final float mBlurTopShadow;
        public float mBlurTopShadowPx;
        public final float mOffsetYBottomShadow;
        public float mOffsetYBottomShadowPx;
        public final float mOffsetYTopShadow;
        public float mOffsetYTopShadowPx;

        private ZDepth(int alphaTopShadow, int alphaBottomShadow, float offsetYTopShadow, float offsetYBottomShadow, float blurTopShadow, float blurBottomShadow) {
            this.mAlphaTopShadow = alphaTopShadow;
            this.mAlphaBottomShadow = alphaBottomShadow;
            this.mOffsetYTopShadow = offsetYTopShadow;
            this.mOffsetYBottomShadow = offsetYBottomShadow;
            this.mBlurTopShadow = blurTopShadow;
            this.mBlurBottomShadow = blurBottomShadow;
        }

        public void initZDepth(Context context) {
            this.mOffsetYTopShadowPx = getOffsetYTopShadowPx(context);
            this.mOffsetYBottomShadowPx = getOffsetYBottomShadowPx(context);
            this.mBlurTopShadowPx = getBlurTopShadowPx(context);
            this.mBlurBottomShadowPx = getBlurBottomShadowPx(context);
        }

        public int getAlphaTopShadow() {
            return this.mAlphaTopShadow;
        }

        public int getAlphaBottomShadow() {
            return this.mAlphaBottomShadow;
        }

        public float getOffsetYTopShadowPx(Context context) {
            return (float) ShadowLayout.convertDpToPx(context, this.mOffsetYTopShadow);
        }

        public float getOffsetYBottomShadowPx(Context context) {
            return (float) ShadowLayout.convertDpToPx(context, this.mOffsetYBottomShadow);
        }

        public float getBlurTopShadowPx(Context context) {
            return (float) ShadowLayout.convertDpToPx(context, this.mBlurTopShadow);
        }

        public float getBlurBottomShadowPx(Context context) {
            return (float) ShadowLayout.convertDpToPx(context, this.mBlurBottomShadow);
        }

        public int getColorTopShadow() {
            return Color.argb(this.mAlphaTopShadow, 0, 0, 0);
        }

        public int getColorBottomShadow() {
            return Color.argb(this.mAlphaBottomShadow, 0, 0, 0);
        }
    }

    public static class ShadowOval implements Shadow {
        private ShapeDrawable mBottomShadow = new ShapeDrawable(new OvalShape());
        RectF mClipRect = new RectF();
        Path mPath = new Path();
        private RectF mRectBottomShadow = new RectF();
        private RectF mRectTopShadow = new RectF();
        private ShapeDrawable mTopShadow = new ShapeDrawable(new OvalShape());

        public void setParameter(int colorTopShadow, int colorBottomShadow, float offsetTopShadow, float offsetBottomShadow, float blurTopShadow, float blurBottomShadow, Rect rect) {
            this.mRectTopShadow.left = (float) rect.left;
            this.mRectTopShadow.top = ((float) rect.top) + offsetTopShadow;
            this.mRectTopShadow.right = (float) rect.right;
            this.mRectTopShadow.bottom = ((float) rect.bottom) + offsetTopShadow;
            this.mRectBottomShadow.left = (float) rect.left;
            this.mRectBottomShadow.top = ((float) rect.top) + offsetBottomShadow;
            this.mRectBottomShadow.right = (float) rect.right;
            this.mRectBottomShadow.bottom = ((float) rect.bottom) + offsetBottomShadow;
            this.mTopShadow.getPaint().setColor(colorTopShadow);
            if (0.0f < blurTopShadow) {
                this.mTopShadow.getPaint().setMaskFilter(new BlurMaskFilter(blurTopShadow, BlurMaskFilter.Blur.NORMAL));
            } else {
                this.mTopShadow.getPaint().setMaskFilter((MaskFilter) null);
            }
            this.mBottomShadow.getPaint().setColor(colorBottomShadow);
            if (0.0f < blurBottomShadow) {
                this.mBottomShadow.getPaint().setMaskFilter(new BlurMaskFilter(blurBottomShadow, BlurMaskFilter.Blur.NORMAL));
            } else {
                this.mBottomShadow.getPaint().setMaskFilter((MaskFilter) null);
            }
        }

        public void onDraw(Canvas canvas) {
            canvas.drawOval(this.mRectBottomShadow, this.mBottomShadow.getPaint());
            canvas.drawOval(this.mRectTopShadow, this.mTopShadow.getPaint());
        }

        public void onDrawOver(Canvas canvas) {
        }

        public boolean onClipChildCanvas(Canvas canvas, View child) {
            this.mPath.reset();
            int width = Math.min(child.getHeight(), child.getWidth());
            this.mPath.addCircle((float) (child.getLeft() + (child.getWidth() / 2)), (float) (child.getTop() + (child.getHeight() / 2)), (float) (width / 2), Path.Direction.CW);
            canvas.clipPath(this.mPath, Region.Op.INTERSECT);
            return false;
        }

        public void onLayout(View parent, int left, int top, int right, int bottom) {
            ViewGroup viewGroup = (ViewGroup) parent;
            Path path = this.mPath;
            RectF rectF = this.mClipRect;
            path.addRoundRect(rectF, rectF.width(), this.mClipRect.width(), Path.Direction.CW);
        }
    }

    public static class ShadowRect implements Shadow {
        float blurTopShadow;
        private ShapeDrawable mBottomShadow = new ShapeDrawable(new RectShape());
        RectF mClipRect = new RectF();
        Path mPath = new Path();
        private Rect mRectBottomShadow = new Rect();
        private Rect mRectTopShadow = new Rect();
        int mRoundRectRadius;
        private ShapeDrawable mTopShadow = new ShapeDrawable(new RectShape());

        public void setRoundRectRadius(int roundRectRadius) {
            this.mRoundRectRadius = roundRectRadius;
        }

        public void setParameter(int colorTopShadow, int colorBottomShadow, float offsetTopShadow, float offsetBottomShadow, float blurTopShadow2, float blurBottomShadow, Rect rect) {
            this.mRectTopShadow.left = rect.left;
            this.mRectTopShadow.top = (int) (((float) rect.top) + offsetTopShadow);
            this.mRectTopShadow.right = rect.right;
            this.mRectTopShadow.bottom = (int) (((float) rect.bottom) + (offsetTopShadow / 2.0f));
            this.mRectBottomShadow.left = rect.left;
            this.mRectBottomShadow.top = (int) (((float) rect.top) + offsetBottomShadow);
            this.mRectBottomShadow.right = rect.right;
            this.mRectBottomShadow.bottom = (int) (((float) rect.bottom) + (offsetBottomShadow / 2.0f));
            this.mTopShadow.getPaint().setColor(colorTopShadow);
            if (0.0f < blurTopShadow2) {
                this.mTopShadow.getPaint().setMaskFilter(new BlurMaskFilter(blurTopShadow2, BlurMaskFilter.Blur.NORMAL));
            } else {
                this.mTopShadow.getPaint().setMaskFilter((MaskFilter) null);
            }
            this.mBottomShadow.getPaint().setColor(colorBottomShadow);
            if (0.0f < blurBottomShadow) {
                this.mBottomShadow.getPaint().setMaskFilter(new BlurMaskFilter(blurBottomShadow, BlurMaskFilter.Blur.NORMAL));
            } else {
                this.mBottomShadow.getPaint().setMaskFilter((MaskFilter) null);
            }
            this.blurTopShadow = blurTopShadow2;
        }

        public void onDraw(Canvas canvas) {
            if (this.mRoundRectRadius <= 0) {
                canvas.drawRect(this.mRectBottomShadow, this.mBottomShadow.getPaint());
                canvas.drawRect(this.mRectTopShadow, this.mTopShadow.getPaint());
                return;
            }
            RectF rectF = new RectF((float) this.mRectBottomShadow.left, (float) this.mRectBottomShadow.top, (float) this.mRectBottomShadow.right, (float) this.mRectBottomShadow.bottom);
            int i2 = this.mRoundRectRadius;
            canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.mBottomShadow.getPaint());
            RectF rectF2 = new RectF((float) this.mRectTopShadow.left, (float) this.mRectTopShadow.top, (float) this.mRectTopShadow.right, (float) this.mRectTopShadow.bottom);
            int i3 = this.mRoundRectRadius;
            canvas.drawRoundRect(rectF2, (float) i3, (float) i3, this.mTopShadow.getPaint());
        }

        public void onDrawOver(Canvas canvas) {
        }

        public boolean onClipChildCanvas(Canvas canvas, View child) {
            if (this.mRoundRectRadius <= 0) {
                return false;
            }
            this.mClipRect.set((float) child.getLeft(), (float) child.getTop(), (float) child.getRight(), (float) child.getBottom());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mClipRect;
            int i2 = this.mRoundRectRadius;
            path.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
            canvas.clipPath(this.mPath, Region.Op.INTERSECT);
            return false;
        }

        public void onLayout(View parent, int left, int top, int right, int bottom) {
        }
    }
}
