package com.tera.scan.ui.ocr.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.appcompat.widget.AppCompatImageView;
import com.tera.scan.app.R$styleable;

public class CropImageView extends AppCompatImageView {
    public static final int DEFAULT_GUIDE_LINE_COLOR = -1;
    public static final float DEFAULT_GUIDE_LINE_WIDTH = 0.3f;
    public static final int DEFAULT_LINE_COLOR = -16711681;
    public static final float DEFAULT_LINE_WIDTH = 1.0f;
    public static final int DEFAULT_MAGNIFIER_CROSS_COLOR = -49023;
    public static final int DEFAULT_MASK_ALPHA = 86;
    public static final int DEFAULT_POINT_FILL_ALPHA = 175;
    public static final int DEFAULT_POINT_FILL_COLOR = -1;
    public static final float MAGNIFIER_BORDER_WIDTH = 1.0f;
    public static final float MAGNIFIER_CROSS_LINE_LENGTH = 3.0f;
    public static final float MAGNIFIER_CROSS_LINE_WIDTH = 0.8f;
    public static final float POINT_RADIUS = 5.0f;
    public static final int P_LB = 3;
    public static final int P_LT = 0;
    public static final int P_RB = 2;
    public static final int P_RT = 1;
    public static final String TAG = "CropImageView";
    public static final float TOUCH_POINT_CATCH_DISTANCE = 15.0f;
    public int mActHeight;
    public int mActLeft;
    public int mActTop;
    public int mActWidth;
    public Point[] mCropPoints;
    public float mDensity;
    public boolean mDragHandle;
    public boolean mDragLimit;
    public Point mDraggingPoint;
    public int mDrawableHeight;
    public int mDrawableWidth;
    public Point[] mEdgeMidPoints;
    public int mGuideLineColor;
    public Paint mGuideLinePaint;
    public float mGuideLineWidth;
    public int mLineColor;
    public int mLineInvalidColor;
    public Paint mLinePaint;
    public float mLineWidth;
    public OnPointChangedListener mListener;
    public int mMagnifierCrossColor;
    public Paint mMagnifierCrossPaint;
    public ShapeDrawable mMagnifierDrawable;
    public Matrix mMagnifierMatrix;
    public Paint mMagnifierPaint;
    public int mMaskAlpha;
    public Paint mMaskPaint;
    public Xfermode mMaskXfermode;
    public float[] mMatrixValue;
    public int mPointColor;
    public int mPointFillAlpha;
    public int mPointFillColor;
    public Paint mPointFillPaint;
    public int mPointInvalidColor;
    public Path mPointLinePath;
    public Paint mPointPaint;
    public float mPointWidth;
    public float mScaleX;
    public float mScaleY;
    public boolean mShowAnchorPoint;
    public boolean mShowEdgeMidPoint;
    public boolean mShowGuideLine;
    public boolean mShowMagnifier;

    public enum DragPointType {
        LEFT_TOP,
        RIGHT_TOP,
        RIGHT_BOTTOM,
        LEFT_BOTTOM,
        TOP,
        RIGHT,
        BOTTOM,
        LEFT;

        public static boolean isEdgePoint(DragPointType dragPointType) {
            return dragPointType == TOP || dragPointType == RIGHT || dragPointType == BOTTOM || dragPointType == LEFT;
        }
    }

    public interface OnPointChangedListener {
        void qw(Point[] pointArr, boolean z, int i2, int i3);
    }

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType[] r0 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.TOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.RIGHT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.tera.scan.ui.ocr.crop.CropImageView$DragPointType r1 = com.tera.scan.ui.ocr.crop.CropImageView.DragPointType.LEFT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.ocr.crop.CropImageView.qw.<clinit>():void");
        }
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean canMoveLeftBottom(int i2, int i3) {
        Point[] pointArr = this.mCropPoints;
        long pointSideLine = pointSideLine(pointArr[0], pointArr[2], i2, i3);
        Point[] pointArr2 = this.mCropPoints;
        if (pointSideLine * pointSideLine(pointArr2[0], pointArr2[2], pointArr2[1]) > 0) {
            return false;
        }
        Point[] pointArr3 = this.mCropPoints;
        long pointSideLine2 = pointSideLine(pointArr3[0], pointArr3[1], i2, i3);
        Point[] pointArr4 = this.mCropPoints;
        if (pointSideLine2 * pointSideLine(pointArr4[0], pointArr4[1], pointArr4[2]) < 0) {
            return false;
        }
        Point[] pointArr5 = this.mCropPoints;
        long pointSideLine3 = pointSideLine(pointArr5[1], pointArr5[2], i2, i3);
        Point[] pointArr6 = this.mCropPoints;
        return pointSideLine3 * pointSideLine(pointArr6[1], pointArr6[2], pointArr6[0]) >= 0;
    }

    private boolean canMoveLeftTop(int i2, int i3) {
        Point[] pointArr = this.mCropPoints;
        long pointSideLine = pointSideLine(pointArr[1], pointArr[3], i2, i3);
        Point[] pointArr2 = this.mCropPoints;
        if (pointSideLine * pointSideLine(pointArr2[1], pointArr2[3], pointArr2[2]) > 0) {
            return false;
        }
        Point[] pointArr3 = this.mCropPoints;
        long pointSideLine2 = pointSideLine(pointArr3[1], pointArr3[2], i2, i3);
        Point[] pointArr4 = this.mCropPoints;
        if (pointSideLine2 * pointSideLine(pointArr4[1], pointArr4[2], pointArr4[3]) < 0) {
            return false;
        }
        Point[] pointArr5 = this.mCropPoints;
        long pointSideLine3 = pointSideLine(pointArr5[3], pointArr5[2], i2, i3);
        Point[] pointArr6 = this.mCropPoints;
        if (pointSideLine3 * pointSideLine(pointArr6[3], pointArr6[2], pointArr6[1]) < 0) {
            return false;
        }
        return true;
    }

    private boolean canMoveRightBottom(int i2, int i3) {
        Point[] pointArr = this.mCropPoints;
        long pointSideLine = pointSideLine(pointArr[1], pointArr[3], i2, i3);
        Point[] pointArr2 = this.mCropPoints;
        if (pointSideLine * pointSideLine(pointArr2[1], pointArr2[3], pointArr2[0]) > 0) {
            return false;
        }
        Point[] pointArr3 = this.mCropPoints;
        long pointSideLine2 = pointSideLine(pointArr3[0], pointArr3[1], i2, i3);
        Point[] pointArr4 = this.mCropPoints;
        if (pointSideLine2 * pointSideLine(pointArr4[0], pointArr4[1], pointArr4[3]) < 0) {
            return false;
        }
        Point[] pointArr5 = this.mCropPoints;
        long pointSideLine3 = pointSideLine(pointArr5[0], pointArr5[3], i2, i3);
        Point[] pointArr6 = this.mCropPoints;
        return pointSideLine3 * pointSideLine(pointArr6[0], pointArr6[3], pointArr6[1]) >= 0;
    }

    private boolean canMoveRightTop(int i2, int i3) {
        Point[] pointArr = this.mCropPoints;
        long pointSideLine = pointSideLine(pointArr[0], pointArr[2], i2, i3);
        Point[] pointArr2 = this.mCropPoints;
        if (pointSideLine * pointSideLine(pointArr2[0], pointArr2[2], pointArr2[3]) > 0) {
            return false;
        }
        Point[] pointArr3 = this.mCropPoints;
        long pointSideLine2 = pointSideLine(pointArr3[0], pointArr3[3], i2, i3);
        Point[] pointArr4 = this.mCropPoints;
        if (pointSideLine2 * pointSideLine(pointArr4[0], pointArr4[3], pointArr4[2]) < 0) {
            return false;
        }
        Point[] pointArr5 = this.mCropPoints;
        long pointSideLine3 = pointSideLine(pointArr5[3], pointArr5[2], i2, i3);
        Point[] pointArr6 = this.mCropPoints;
        if (pointSideLine3 * pointSideLine(pointArr6[3], pointArr6[2], pointArr6[0]) < 0) {
            return false;
        }
        return true;
    }

    private float dp2px(float f) {
        return f * this.mDensity;
    }

    private void getDrawablePosition() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            getImageMatrix().getValues(this.mMatrixValue);
            float[] fArr = this.mMatrixValue;
            this.mScaleX = fArr[0];
            this.mScaleY = fArr[4];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.mActWidth = Math.round(((float) intrinsicWidth) * this.mScaleX);
            this.mActHeight = Math.round(((float) intrinsicHeight) * this.mScaleY);
            this.mActLeft = (getWidth() - this.mActWidth) / 2;
            this.mActTop = (getHeight() - this.mActHeight) / 2;
        }
    }

    private Point[] getFullImgCropPoints() {
        Point[] pointArr = new Point[4];
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            pointArr[0] = new Point(0, 0);
            pointArr[1] = new Point(intrinsicWidth, 0);
            pointArr[2] = new Point(intrinsicWidth, intrinsicHeight);
            pointArr[3] = new Point(0, intrinsicHeight);
        }
        return pointArr;
    }

    private Point getNearbyPoint(MotionEvent motionEvent) {
        if (this.mShowAnchorPoint && checkPoints(this.mCropPoints)) {
            for (Point point : this.mCropPoints) {
                if (isTouchPoint(point, motionEvent)) {
                    return point;
                }
            }
        }
        if (!this.mShowEdgeMidPoint || !checkPoints(this.mEdgeMidPoints)) {
            return null;
        }
        for (Point point2 : this.mEdgeMidPoints) {
            if (isTouchPoint(point2, motionEvent)) {
                return point2;
            }
        }
        return null;
    }

    private DragPointType getPointType(Point point) {
        if (point == null) {
            return null;
        }
        int i2 = 0;
        if (this.mShowAnchorPoint && checkPoints(this.mCropPoints)) {
            int i3 = 0;
            while (true) {
                Point[] pointArr = this.mCropPoints;
                if (i3 >= pointArr.length) {
                    break;
                } else if (point.equals(pointArr[i3])) {
                    return DragPointType.values()[i3];
                } else {
                    i3++;
                }
            }
        }
        if (this.mShowEdgeMidPoint && checkPoints(this.mEdgeMidPoints)) {
            while (true) {
                Point[] pointArr2 = this.mEdgeMidPoints;
                if (i2 >= pointArr2.length) {
                    break;
                } else if (point.equals(pointArr2[i2])) {
                    return DragPointType.values()[i2 + 4];
                } else {
                    i2++;
                }
            }
        }
        return null;
    }

    public static double getPointsDistance(Point point, Point point2) {
        return getPointsDistance((float) point.x, (float) point.y, (float) point2.x, (float) point2.y);
    }

    private float getViewPointX(Point point) {
        return getViewPointX((float) point.x);
    }

    private float getViewPointY(Point point) {
        return getViewPointY((float) point.y);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CropImageView);
        this.mMaskAlpha = Math.min(Math.max(0, obtainStyledAttributes.getInt(6, 86)), 255);
        this.mShowGuideLine = obtainStyledAttributes.getBoolean(14, true);
        this.mLineColor = obtainStyledAttributes.getColor(2, DEFAULT_LINE_COLOR);
        this.mLineInvalidColor = obtainStyledAttributes.getColor(3, DEFAULT_LINE_COLOR);
        this.mLineWidth = obtainStyledAttributes.getDimension(4, dp2px(1.0f));
        this.mPointColor = obtainStyledAttributes.getColor(7, DEFAULT_LINE_COLOR);
        this.mPointInvalidColor = obtainStyledAttributes.getColor(10, DEFAULT_LINE_COLOR);
        this.mPointWidth = obtainStyledAttributes.getDimension(11, dp2px(1.0f));
        this.mMagnifierCrossColor = obtainStyledAttributes.getColor(5, DEFAULT_MAGNIFIER_CROSS_COLOR);
        this.mShowMagnifier = obtainStyledAttributes.getBoolean(15, true);
        this.mGuideLineWidth = obtainStyledAttributes.getDimension(1, dp2px(0.3f));
        this.mGuideLineColor = obtainStyledAttributes.getColor(0, -1);
        this.mPointFillColor = obtainStyledAttributes.getColor(9, -1);
        this.mShowEdgeMidPoint = obtainStyledAttributes.getBoolean(13, true);
        this.mPointFillAlpha = Math.min(Math.max(0, obtainStyledAttributes.getInt(8, 175)), 255);
        this.mShowAnchorPoint = obtainStyledAttributes.getBoolean(12, true);
        obtainStyledAttributes.recycle();
    }

    private void initMagnifier() {
        Bitmap bitmap = getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-16777216);
            int i2 = this.mActLeft;
            int i3 = this.mActTop;
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(i2, i3, this.mActWidth + i2, this.mActHeight + i3), (Paint) null);
            canvas.save();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            this.mMagnifierDrawable = shapeDrawable;
            shapeDrawable.getPaint().setShader(bitmapShader);
        }
    }

    private void initPaints() {
        Paint paint = new Paint(1);
        this.mPointPaint = paint;
        paint.setColor(this.mPointColor);
        this.mPointPaint.setStrokeWidth(this.mPointWidth);
        this.mPointPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.mPointFillPaint = paint2;
        paint2.setColor(this.mPointFillColor);
        this.mPointFillPaint.setStyle(Paint.Style.FILL);
        this.mPointFillPaint.setAlpha(this.mPointFillAlpha);
        Paint paint3 = new Paint(1);
        this.mLinePaint = paint3;
        paint3.setColor(this.mLineColor);
        this.mLinePaint.setStrokeWidth(this.mLineWidth);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.mMaskPaint = paint4;
        paint4.setColor(-16777216);
        this.mMaskPaint.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint(1);
        this.mGuideLinePaint = paint5;
        paint5.setColor(this.mGuideLineColor);
        this.mGuideLinePaint.setStyle(Paint.Style.FILL);
        this.mGuideLinePaint.setStrokeWidth(this.mGuideLineWidth);
        Paint paint6 = new Paint(1);
        this.mMagnifierPaint = paint6;
        paint6.setColor(-16777216);
        this.mMagnifierPaint.setStyle(Paint.Style.FILL);
        Paint paint7 = new Paint(1);
        this.mMagnifierCrossPaint = paint7;
        paint7.setColor(this.mMagnifierCrossColor);
        this.mMagnifierCrossPaint.setStyle(Paint.Style.FILL);
        this.mMagnifierCrossPaint.setStrokeWidth(dp2px(0.8f));
    }

    private boolean isTouchPoint(Point point, MotionEvent motionEvent) {
        return Math.sqrt(Math.pow((double) (motionEvent.getX() - getViewPointX(point)), 2.0d) + Math.pow((double) (motionEvent.getY() - getViewPointY(point)), 2.0d)) < ((double) dp2px(15.0f));
    }

    private void moveEdge(DragPointType dragPointType, int i2, int i3) {
        int i4 = qw.qw[dragPointType.ordinal()];
        if (i4 == 5) {
            movePoint(this.mCropPoints[0], 0, i3);
            movePoint(this.mCropPoints[1], 0, i3);
        } else if (i4 == 6) {
            movePoint(this.mCropPoints[1], i2, 0);
            movePoint(this.mCropPoints[2], i2, 0);
        } else if (i4 == 7) {
            movePoint(this.mCropPoints[3], 0, i3);
            movePoint(this.mCropPoints[2], 0, i3);
        } else if (i4 == 8) {
            movePoint(this.mCropPoints[0], i2, 0);
            movePoint(this.mCropPoints[3], i2, 0);
        }
    }

    private void movePoint(Point point, int i2, int i3) {
        if (point != null) {
            int i4 = point.x + i2;
            int i5 = point.y + i3;
            if (i4 >= 0 && i4 <= getDrawable().getIntrinsicWidth() && i5 >= 0 && i5 <= getDrawable().getIntrinsicHeight()) {
                point.x = i4;
                point.y = i5;
            }
        }
    }

    private long pointSideLine(Point point, Point point2, Point point3) {
        return pointSideLine(point, point2, point3.x, point3.y);
    }

    private Path resetPointPath() {
        if (!checkPoints(this.mCropPoints)) {
            return null;
        }
        this.mPointLinePath.reset();
        Point[] pointArr = this.mCropPoints;
        Point point = pointArr[0];
        Point point2 = pointArr[1];
        Point point3 = pointArr[2];
        Point point4 = pointArr[3];
        this.mPointLinePath.moveTo(getViewPointX(point), getViewPointY(point));
        this.mPointLinePath.lineTo(getViewPointX(point2), getViewPointY(point2));
        this.mPointLinePath.lineTo(getViewPointX(point3), getViewPointY(point3));
        this.mPointLinePath.lineTo(getViewPointX(point4), getViewPointY(point4));
        this.mPointLinePath.close();
        return this.mPointLinePath;
    }

    private void toImagePointSize(Point point, MotionEvent motionEvent) {
        if (point != null) {
            DragPointType pointType = getPointType(point);
            int min = (int) ((Math.min(Math.max(motionEvent.getX(), (float) this.mActLeft), (float) (this.mActLeft + this.mActWidth)) - ((float) this.mActLeft)) / this.mScaleX);
            int min2 = (int) ((Math.min(Math.max(motionEvent.getY(), (float) this.mActTop), (float) (this.mActTop + this.mActHeight)) - ((float) this.mActTop)) / this.mScaleY);
            if (this.mDragLimit && pointType != null) {
                switch (qw.qw[pointType.ordinal()]) {
                    case 1:
                        if (!canMoveLeftTop(min, min2)) {
                            return;
                        }
                        break;
                    case 2:
                        if (!canMoveRightTop(min, min2)) {
                            return;
                        }
                        break;
                    case 3:
                        if (!canMoveRightBottom(min, min2)) {
                            return;
                        }
                        break;
                    case 4:
                        if (!canMoveLeftBottom(min, min2)) {
                            return;
                        }
                        break;
                    case 5:
                        if (!canMoveLeftTop(min, min2) || !canMoveRightTop(min, min2)) {
                            return;
                        }
                    case 6:
                        if (!canMoveRightTop(min, min2) || !canMoveRightBottom(min, min2)) {
                            return;
                        }
                    case 7:
                        if (!canMoveLeftBottom(min, min2) || !canMoveRightBottom(min, min2)) {
                            return;
                        }
                    case 8:
                        if (!canMoveLeftBottom(min, min2) || !canMoveLeftTop(min, min2)) {
                            return;
                        }
                }
            }
            if (DragPointType.isEdgePoint(pointType)) {
                moveEdge(pointType, min - point.x, min2 - point.y);
                return;
            }
            point.y = min2;
            point.x = min;
        }
    }

    public boolean canRightCrop() {
        if (!checkPoints(this.mCropPoints)) {
            return false;
        }
        Point[] pointArr = this.mCropPoints;
        Point point = pointArr[0];
        Point point2 = pointArr[1];
        Point point3 = pointArr[2];
        Point point4 = pointArr[3];
        if (pointSideLine(point, point3, point4) * pointSideLine(point, point3, point2) >= 0 || pointSideLine(point4, point2, point) * pointSideLine(point4, point2, point3) >= 0) {
            return false;
        }
        return true;
    }

    public boolean checkPoints(Point[] pointArr) {
        return (pointArr == null || pointArr.length != 4 || pointArr[0] == null || pointArr[1] == null || pointArr[2] == null || pointArr[3] == null) ? false : true;
    }

    @SuppressLint({"RestrictedApi"})
    public Bitmap getBitmap() {
        Drawable drawable = getDrawable();
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof DrawableWrapper) {
            return ((BitmapDrawable) ((DrawableWrapper) drawable).getWrappedDrawable()).getBitmap();
        }
        return null;
    }

    public Point[] getCropPoints() {
        return this.mCropPoints;
    }

    public OnPointChangedListener getListener() {
        return this.mListener;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getDrawablePosition();
        onDrawCropPoint(canvas);
    }

    public void onDrawCropPoint(Canvas canvas) {
        onDrawMask(canvas);
        onDrawGuideLine(canvas);
        onDrawLines(canvas);
        onDrawPoints(canvas);
        onDrawMagnifier(canvas);
    }

    public void onDrawCusMagnifier(Canvas canvas) {
        float f;
        DragPointType pointType = getPointType(this.mDraggingPoint);
        if (pointType != null && !DragPointType.isEdgePoint(pointType) && this.mShowMagnifier && this.mDraggingPoint != null) {
            if (this.mMagnifierDrawable == null) {
                initMagnifier();
            }
            if (this.mMagnifierDrawable != null) {
                float viewPointX = getViewPointX(this.mDraggingPoint);
                float viewPointY = getViewPointY(this.mDraggingPoint);
                float width = (float) (getWidth() / 8);
                int dp2px = (int) dp2px(1.0f);
                int i2 = this.mDraggingPoint.x;
                if (i2 < 0 || i2 >= getDrawable().getIntrinsicWidth() / 2) {
                    int i3 = (((int) width) * 2) - dp2px;
                    this.mMagnifierDrawable.setBounds(dp2px, dp2px, i3, i3);
                    f = width;
                } else {
                    int i4 = ((int) width) * 2;
                    this.mMagnifierDrawable.setBounds((getWidth() - i4) + dp2px, dp2px, getWidth() - dp2px, i4 - dp2px);
                    f = ((float) getWidth()) - width;
                }
                canvas.drawCircle(f, width, width, this.mMagnifierPaint);
                this.mMagnifierMatrix.setTranslate(width - viewPointX, width - viewPointY);
                this.mMagnifierDrawable.getPaint().getShader().setLocalMatrix(this.mMagnifierMatrix);
                this.mMagnifierDrawable.draw(canvas);
                canvas.drawCircle(f, width, dp2px(5.0f), this.mPointFillPaint);
                canvas.drawCircle(f, width, dp2px(5.0f), this.mPointPaint);
            }
        }
    }

    public void onDrawGuideLine(Canvas canvas) {
        if (this.mShowGuideLine) {
            int i2 = this.mActWidth / 3;
            int i3 = this.mActHeight;
            int i4 = i3 / 3;
            int i5 = this.mActLeft;
            int i6 = this.mActTop;
            Canvas canvas2 = canvas;
            canvas2.drawLine((float) (i5 + i2), (float) i6, (float) (i5 + i2), (float) (i6 + i3), this.mGuideLinePaint);
            int i7 = this.mActLeft;
            int i8 = i2 * 2;
            int i9 = this.mActTop;
            Canvas canvas3 = canvas;
            canvas3.drawLine((float) (i7 + i8), (float) i9, (float) (i7 + i8), (float) (i9 + this.mActHeight), this.mGuideLinePaint);
            int i10 = this.mActLeft;
            int i11 = this.mActTop;
            canvas.drawLine((float) i10, (float) (i11 + i4), (float) (i10 + this.mActWidth), (float) (i11 + i4), this.mGuideLinePaint);
            int i12 = this.mActLeft;
            int i13 = this.mActTop;
            int i14 = i4 * 2;
            canvas.drawLine((float) i12, (float) (i13 + i14), (float) (i12 + this.mActWidth), (float) (i13 + i14), this.mGuideLinePaint);
        }
    }

    public void onDrawLines(Canvas canvas) {
        Path resetPointPath = resetPointPath();
        if (resetPointPath != null) {
            if (canRightCrop()) {
                this.mLinePaint.setColor(this.mLineColor);
            } else {
                this.mLinePaint.setColor(this.mLineInvalidColor);
            }
            canvas.drawPath(resetPointPath, this.mLinePaint);
        }
    }

    public void onDrawMagnifier(Canvas canvas) {
        float f;
        if (this.mShowMagnifier && this.mDraggingPoint != null) {
            if (this.mMagnifierDrawable == null) {
                initMagnifier();
            }
            if (this.mMagnifierDrawable != null) {
                float viewPointX = getViewPointX(this.mDraggingPoint);
                float viewPointY = getViewPointY(this.mDraggingPoint);
                float width = (float) (getWidth() / 8);
                int dp2px = (int) dp2px(1.0f);
                int i2 = ((int) width) * 2;
                int i3 = i2 - dp2px;
                this.mMagnifierDrawable.setBounds(dp2px, dp2px, i3, i3);
                if (getPointsDistance(viewPointX, viewPointY, 0.0f, 0.0f) < ((double) width) * 2.5d) {
                    this.mMagnifierDrawable.setBounds((getWidth() - i2) + dp2px, dp2px, getWidth() - dp2px, i3);
                    f = ((float) getWidth()) - width;
                } else {
                    f = width;
                }
                canvas.drawCircle(f, width, width, this.mMagnifierPaint);
                this.mMagnifierMatrix.setTranslate(width - viewPointX, width - viewPointY);
                this.mMagnifierDrawable.getPaint().getShader().setLocalMatrix(this.mMagnifierMatrix);
                this.mMagnifierDrawable.draw(canvas);
                float dp2px2 = dp2px(3.0f);
                canvas.drawLine(f, width - dp2px2, f, width + dp2px2, this.mMagnifierCrossPaint);
                canvas.drawLine(f - dp2px2, width, f + dp2px2, width, this.mMagnifierCrossPaint);
            }
        }
    }

    public void onDrawMask(Canvas canvas) {
        Path resetPointPath;
        if (this.mMaskAlpha > 0 && (resetPointPath = resetPointPath()) != null) {
            int i2 = this.mActLeft;
            int i3 = this.mActTop;
            int saveLayer = canvas.saveLayer((float) i2, (float) i3, (float) (i2 + this.mActWidth), (float) (i3 + this.mActHeight), this.mMaskPaint, 31);
            this.mMaskPaint.setAlpha(this.mMaskAlpha);
            int i4 = this.mActLeft;
            int i5 = this.mActTop;
            canvas.drawRect((float) i4, (float) i5, (float) (i4 + this.mActWidth), (float) (i5 + this.mActHeight), this.mMaskPaint);
            this.mMaskPaint.setXfermode(this.mMaskXfermode);
            this.mMaskPaint.setAlpha(255);
            canvas.drawPath(resetPointPath, this.mMaskPaint);
            this.mMaskPaint.setXfermode((Xfermode) null);
            canvas.restoreToCount(saveLayer);
        }
    }

    public void onDrawPoints(Canvas canvas) {
        if (checkPoints(this.mCropPoints)) {
            if (canRightCrop()) {
                this.mPointPaint.setColor(this.mPointColor);
            } else {
                this.mPointPaint.setColor(this.mPointInvalidColor);
            }
            if (this.mShowAnchorPoint) {
                for (Point point : this.mCropPoints) {
                    canvas.drawCircle(getViewPointX(point), getViewPointY(point), dp2px(5.0f), this.mPointFillPaint);
                    canvas.drawCircle(getViewPointX(point), getViewPointY(point), dp2px(5.0f), this.mPointPaint);
                }
            }
            if (this.mShowEdgeMidPoint) {
                setEdgeMidPoints();
                for (Point point2 : this.mEdgeMidPoints) {
                    canvas.drawCircle(getViewPointX(point2), getViewPointY(point2), dp2px(5.0f), this.mPointFillPaint);
                    canvas.drawCircle(getViewPointX(point2), getViewPointY(point2), dp2px(5.0f), this.mPointPaint);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            Point nearbyPoint = getNearbyPoint(motionEvent);
            this.mDraggingPoint = nearbyPoint;
            if (nearbyPoint != null) {
                this.mDragHandle = true;
            }
        } else if (action != 2) {
            OnPointChangedListener onPointChangedListener = this.mListener;
            if (onPointChangedListener != null) {
                onPointChangedListener.qw(this.mCropPoints, canRightCrop(), this.mDrawableWidth, this.mDrawableHeight);
            }
            this.mDraggingPoint = null;
            this.mDragHandle = false;
        } else {
            toImagePointSize(this.mDraggingPoint, motionEvent);
        }
        postInvalidate();
        if (this.mDragHandle) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (this.mDragHandle || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setCropPoints(Point[] pointArr) {
        if (getDrawable() == null) {
            this.mCropPoints = pointArr;
        } else if (!checkPoints(pointArr)) {
            setFullImgCrop();
        } else {
            this.mCropPoints = pointArr;
            postInvalidate();
        }
    }

    public void setDragLimit(boolean z) {
        this.mDragLimit = z;
    }

    public void setEdgeMidPoints() {
        int i2 = 0;
        if (this.mEdgeMidPoints == null) {
            this.mEdgeMidPoints = new Point[4];
            int i3 = 0;
            while (true) {
                Point[] pointArr = this.mEdgeMidPoints;
                if (i3 >= pointArr.length) {
                    break;
                }
                pointArr[i3] = new Point();
                i3++;
            }
        }
        int length = this.mCropPoints.length;
        while (i2 < length) {
            Point point = this.mEdgeMidPoints[i2];
            Point[] pointArr2 = this.mCropPoints;
            int i4 = i2 + 1;
            int i5 = i4 % length;
            point.set(pointArr2[i2].x + ((pointArr2[i5].x - pointArr2[i2].x) / 2), pointArr2[i2].y + ((pointArr2[i5].y - pointArr2[i2].y) / 2));
            i2 = i4;
        }
    }

    public void setFullImgCrop() {
        if (getDrawable() != null) {
            this.mCropPoints = getFullImgCropPoints();
            postInvalidate();
        }
    }

    public void setGuideLineColor(int i2) {
        this.mGuideLineColor = i2;
    }

    public void setGuideLineWidth(float f) {
        this.mGuideLineWidth = f;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mMagnifierDrawable = null;
        if (!checkPoints(this.mCropPoints)) {
            setFullImgCrop();
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mMagnifierDrawable = null;
        if (!checkPoints(this.mCropPoints)) {
            setFullImgCrop();
        }
        if (drawable != null) {
            this.mDrawableWidth = drawable.getIntrinsicWidth();
            this.mDrawableHeight = drawable.getIntrinsicHeight();
            OnPointChangedListener onPointChangedListener = this.mListener;
            if (onPointChangedListener != null) {
                onPointChangedListener.qw(this.mCropPoints, canRightCrop(), this.mDrawableWidth, this.mDrawableHeight);
                return;
            }
            return;
        }
        this.mDrawableWidth = 0;
        this.mDrawableHeight = 0;
    }

    public void setImageToCrop(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public void setLineColor(int i2) {
        this.mLineColor = i2;
        postInvalidate();
    }

    public void setLineWidth(int i2) {
        this.mLineWidth = (float) i2;
        postInvalidate();
    }

    public void setListener(OnPointChangedListener onPointChangedListener) {
        this.mListener = onPointChangedListener;
    }

    public void setMagnifierCrossColor(int i2) {
        this.mMagnifierCrossColor = i2;
    }

    public void setMaskAlpha(int i2) {
        this.mMaskAlpha = Math.min(Math.max(0, i2), 255);
        postInvalidate();
    }

    public void setPointColor(int i2) {
        this.mPointColor = i2;
        postInvalidate();
    }

    public void setPointFillAlpha(int i2) {
        this.mPointFillAlpha = i2;
    }

    public void setPointFillColor(int i2) {
        this.mPointFillColor = i2;
    }

    public void setPointWidth(float f) {
        this.mPointWidth = f;
        postInvalidate();
    }

    public void setShowGuideLine(boolean z) {
        this.mShowGuideLine = z;
        postInvalidate();
    }

    public void setShowMagnifier(boolean z) {
        this.mShowMagnifier = z;
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static double getPointsDistance(float f, float f2, float f3, float f4) {
        return Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d));
    }

    private float getViewPointX(float f) {
        return (f * this.mScaleX) + ((float) this.mActLeft);
    }

    private float getViewPointY(float f) {
        return (f * this.mScaleY) + ((float) this.mActTop);
    }

    private long pointSideLine(Point point, Point point2, int i2, int i3) {
        long j = (long) point.x;
        long j2 = (long) point.y;
        return ((((long) i2) - j) * (((long) point2.y) - j2)) - ((((long) i3) - j2) * (((long) point2.x) - j));
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDraggingPoint = null;
        this.mMatrixValue = new float[9];
        this.mMaskXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.mPointLinePath = new Path();
        this.mMagnifierMatrix = new Matrix();
        this.mPointFillColor = -1;
        this.mPointFillAlpha = 175;
        this.mLineColor = DEFAULT_LINE_COLOR;
        this.mLineInvalidColor = DEFAULT_LINE_COLOR;
        this.mMagnifierCrossColor = DEFAULT_MAGNIFIER_CROSS_COLOR;
        this.mGuideLineColor = -1;
        this.mMaskAlpha = 86;
        this.mShowGuideLine = true;
        this.mShowMagnifier = true;
        this.mShowEdgeMidPoint = true;
        this.mShowAnchorPoint = true;
        this.mDragLimit = true;
        this.mDragHandle = false;
        ImageView.ScaleType scaleType = getScaleType();
        if (scaleType == ImageView.ScaleType.FIT_END || scaleType == ImageView.ScaleType.FIT_START || scaleType == ImageView.ScaleType.MATRIX) {
            throw new RuntimeException("Image in CropImageView must be in center");
        }
        this.mDensity = getResources().getDisplayMetrics().density;
        initAttrs(context, attributeSet);
        initPaints();
    }
}
