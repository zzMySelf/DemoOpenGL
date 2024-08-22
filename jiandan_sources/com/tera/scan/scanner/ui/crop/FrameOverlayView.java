package com.tera.scan.scanner.ui.crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.aiscan.R;

public class FrameOverlayView extends View {
    public static final int CORNER_LEFT_BOTTOM = 4;
    public static final int CORNER_LEFT_TOP = 1;
    public static final int CORNER_RIGHT_BOTTOM = 3;
    public static final int CORNER_RIGHT_TOP = 2;
    public static final String TAG = "FrameOverlayView";
    public int cornerLength = 100;
    public int cornerLineWidth = 6;
    public int currentCorner = -1;
    public Paint eraser = new Paint(1);
    public int frameHeight;
    public RectF frameRect = new RectF();
    public int frameWidth;
    public GestureDetector gestureDetector;
    public boolean mIsMove = false;
    public Paint mNinePaint = new Paint(1);
    public int mRatioType = 0;
    public int margin = 20;
    public int maskColor = Color.argb(180, 0, 0, 0);
    public ad onFrameChangeListener;
    public GestureDetector.SimpleOnGestureListener onGestureListener = new qw();
    public Paint paint = new Paint(1);
    public RectF touchRect = new RectF();

    public interface ad {
        void qw(RectF rectF);
    }

    public class qw extends GestureDetector.SimpleOnGestureListener {
        public qw() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            FrameOverlayView.this.translate(f, f2);
            return true;
        }
    }

    public FrameOverlayView(Context context) {
        super(context);
        setLayerType(1, (Paint) null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.mNinePaint.setColor(-1);
        this.mNinePaint.setStrokeWidth(2.0f);
        this.eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }

    private void calculateFrame() {
        if (this.mRatioType == 1) {
            setAccordingWidth();
        } else {
            setAccordingHeight();
        }
    }

    private int calculateFrameWidth() {
        int qw2 = fe.mmm.qw.h.qw.qw(getContext().getResources().getInteger(R.integer.image_view_margin));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels - (qw2 * 2);
    }

    private void drawCorners(Canvas canvas) {
        this.paint.setStrokeWidth((float) this.cornerLineWidth);
        RectF rectF = this.frameRect;
        Canvas canvas2 = canvas;
        drawLine(canvas2, rectF.left - (((float) this.cornerLineWidth) / 2.0f), rectF.top, this.cornerLength, 0);
        RectF rectF2 = this.frameRect;
        drawLine(canvas2, rectF2.left, rectF2.top, 0, this.cornerLength);
        RectF rectF3 = this.frameRect;
        Canvas canvas3 = canvas;
        drawLine(canvas3, (((float) this.cornerLineWidth) / 2.0f) + rectF3.right, rectF3.top, -this.cornerLength, 0);
        RectF rectF4 = this.frameRect;
        drawLine(canvas3, rectF4.right, rectF4.top, 0, this.cornerLength);
        RectF rectF5 = this.frameRect;
        drawLine(canvas3, rectF5.right, rectF5.bottom, 0, -this.cornerLength);
        RectF rectF6 = this.frameRect;
        drawLine(canvas, (((float) this.cornerLineWidth) / 2.0f) + rectF6.right, rectF6.bottom, -this.cornerLength, 0);
        RectF rectF7 = this.frameRect;
        Canvas canvas4 = canvas;
        drawLine(canvas4, rectF7.left - (((float) this.cornerLineWidth) / 2.0f), rectF7.bottom, this.cornerLength, 0);
        RectF rectF8 = this.frameRect;
        drawLine(canvas4, rectF8.left, rectF8.bottom, 0, -this.cornerLength);
        float height = this.frameRect.height();
        float width = this.frameRect.width();
        RectF rectF9 = this.frameRect;
        int i2 = (int) width;
        drawNineLine(canvas, rectF9.left, rectF9.top + (height / 3.0f), i2, 0);
        RectF rectF10 = this.frameRect;
        drawNineLine(canvas, rectF10.left, rectF10.top + ((height * 2.0f) / 3.0f), i2, 0);
        RectF rectF11 = this.frameRect;
        int i3 = (int) height;
        drawNineLine(canvas, (width / 3.0f) + rectF11.left, rectF11.top, 0, i3);
        RectF rectF12 = this.frameRect;
        drawNineLine(canvas, rectF12.left + ((width * 2.0f) / 3.0f), rectF12.top, 0, i3);
    }

    private void drawLine(Canvas canvas, float f, float f2, int i2, int i3) {
        canvas.drawLine(f, f2, f + ((float) i2), f2 + ((float) i3), this.paint);
    }

    private void drawNineLine(Canvas canvas, float f, float f2, int i2, int i3) {
        canvas.drawLine(f, f2, f + ((float) i2), f2 + ((float) i3), this.mNinePaint);
    }

    private float getMinimumFrameHeight() {
        return ((float) this.cornerLength) * 2.4f;
    }

    private float getMinimumFrameWidth() {
        return ((float) this.cornerLength) * 2.4f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        if (r0 != 3) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleDown(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getAction()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r4) goto L_0x0016
            if (r0 == r3) goto L_0x0011
            if (r0 == r2) goto L_0x0016
            goto L_0x0019
        L_0x0011:
            boolean r10 = r9.handleScale(r10)
            return r10
        L_0x0016:
            r10 = -1
            r9.currentCorner = r10
        L_0x0019:
            return r1
        L_0x001a:
            int r0 = r9.cornerLength
            int r0 = r0 * 2
            float r0 = (float) r0
            android.graphics.RectF r5 = r9.touchRect
            float r6 = r10.getX()
            float r6 = r6 - r0
            float r7 = r10.getY()
            float r7 = r7 - r0
            float r8 = r10.getX()
            float r8 = r8 + r0
            float r10 = r10.getY()
            float r10 = r10 + r0
            r5.set(r6, r7, r8, r10)
            android.graphics.RectF r10 = r9.touchRect
            android.graphics.RectF r0 = r9.frameRect
            float r5 = r0.left
            float r0 = r0.top
            boolean r10 = r10.contains(r5, r0)
            if (r10 == 0) goto L_0x0049
            r9.currentCorner = r4
            return r4
        L_0x0049:
            android.graphics.RectF r10 = r9.touchRect
            android.graphics.RectF r0 = r9.frameRect
            float r5 = r0.right
            float r0 = r0.top
            boolean r10 = r10.contains(r5, r0)
            if (r10 == 0) goto L_0x005a
            r9.currentCorner = r3
            return r4
        L_0x005a:
            android.graphics.RectF r10 = r9.touchRect
            android.graphics.RectF r0 = r9.frameRect
            float r3 = r0.right
            float r0 = r0.bottom
            boolean r10 = r10.contains(r3, r0)
            if (r10 == 0) goto L_0x006b
            r9.currentCorner = r2
            return r4
        L_0x006b:
            android.graphics.RectF r10 = r9.touchRect
            android.graphics.RectF r0 = r9.frameRect
            float r2 = r0.left
            float r0 = r0.bottom
            boolean r10 = r10.contains(r2, r0)
            if (r10 == 0) goto L_0x007d
            r10 = 4
            r9.currentCorner = r10
            return r4
        L_0x007d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ui.crop.FrameOverlayView.handleDown(android.view.MotionEvent):boolean");
    }

    private boolean handleScale(MotionEvent motionEvent) {
        int i2 = this.currentCorner;
        if (i2 == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            RectF rectF = this.frameRect;
            scaleTo(x, y, rectF.right, rectF.bottom);
            return true;
        } else if (i2 == 2) {
            scaleTo(this.frameRect.left, motionEvent.getY(), motionEvent.getX(), this.frameRect.bottom);
            return true;
        } else if (i2 == 3) {
            RectF rectF2 = this.frameRect;
            scaleTo(rectF2.left, rectF2.top, motionEvent.getX(), motionEvent.getY());
            return true;
        } else if (i2 != 4) {
            return false;
        } else {
            float x2 = motionEvent.getX();
            RectF rectF3 = this.frameRect;
            scaleTo(x2, rectF3.top, rectF3.right, motionEvent.getY());
            return true;
        }
    }

    private void init() {
        this.gestureDetector = new GestureDetector(getContext(), this.onGestureListener);
        this.cornerLength = fe.mmm.qw.h.qw.qw(18);
        this.cornerLineWidth = fe.mmm.qw.h.qw.qw(3);
    }

    private void notifyFrameChange() {
        ad adVar = this.onFrameChangeListener;
        if (adVar != null) {
            adVar.qw(this.frameRect);
        }
    }

    private void resetFrameRect(int i2, int i3) {
        int i4;
        calculateFrame();
        int i5 = this.frameWidth;
        if (i2 <= i5 || i3 <= (i4 = this.frameHeight)) {
            RectF rectF = this.frameRect;
            float f = (float) i2;
            float f2 = (float) ((int) (f * 0.2f));
            rectF.left = f2;
            float f3 = (float) i3;
            float f4 = (float) ((int) (0.2f * f3));
            rectF.top = f4;
            rectF.right = f - f2;
            rectF.bottom = f3 - f4;
            return;
        }
        RectF rectF2 = this.frameRect;
        float f5 = ((float) (i2 - i5)) / 2.0f;
        rectF2.left = f5;
        float f6 = ((float) (i3 - i4)) / 2.0f;
        rectF2.top = f6;
        rectF2.right = f5 + ((float) i5);
        rectF2.bottom = f6 + ((float) i4);
    }

    private void scaleTo(float f, float f2, float f3, float f4) {
        if (f4 - f2 < getMinimumFrameHeight()) {
            RectF rectF = this.frameRect;
            float f5 = rectF.top;
            f4 = rectF.bottom;
            f2 = f5;
        }
        if (f3 - f < getMinimumFrameWidth()) {
            RectF rectF2 = this.frameRect;
            float f6 = rectF2.left;
            f3 = rectF2.right;
            f = f6;
        }
        this.frameRect.set(Math.max((float) this.margin, f), Math.max((float) this.margin, f2), Math.min((float) (getWidth() - this.margin), f3), Math.min((float) (getHeight() - this.margin), f4));
        invalidate();
        this.mIsMove = true;
    }

    private void setAccordingHeight() {
        this.frameHeight = getContext().getResources().getInteger(R.integer.crop_image_view_height);
        this.frameWidth = calculateFrameWidth();
    }

    private void setAccordingWidth() {
        int qw2 = fe.mmm.qw.h.qw.qw(getContext().getResources().getInteger(R.integer.image_view_margin));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels - (qw2 * 2);
        this.frameWidth = i2;
        this.frameHeight = (i2 * 16) / 9;
    }

    /* access modifiers changed from: private */
    public void translate(float f, float f2) {
        if (f > 0.0f) {
            float f3 = this.frameRect.left;
            int i2 = this.margin;
            if (f3 - f < ((float) i2)) {
                f = f3 - ((float) i2);
            }
        } else if (this.frameRect.right - f > ((float) (getWidth() - this.margin))) {
            f = (this.frameRect.right - ((float) getWidth())) + ((float) this.margin);
        }
        if (f2 > 0.0f) {
            float f4 = this.frameRect.top;
            int i3 = this.margin;
            if (f4 - f2 < ((float) i3)) {
                f2 = f4 - ((float) i3);
            }
        } else if (this.frameRect.bottom - f2 > ((float) (getHeight() - this.margin))) {
            f2 = (this.frameRect.bottom - ((float) getHeight())) + ((float) this.margin);
        }
        this.frameRect.offset(-f, -f2);
        invalidate();
    }

    public Rect getFrameRect() {
        Rect rect = new Rect();
        RectF rectF = this.frameRect;
        rect.left = (int) rectF.left;
        rect.top = (int) rectF.top;
        rect.right = (int) rectF.right;
        rect.bottom = (int) rectF.bottom;
        return rect;
    }

    public boolean getIsMove() {
        return this.mIsMove;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.maskColor);
        this.paint.setStrokeWidth((float) fe.mmm.qw.h.qw.qw(1));
        canvas.drawRect(this.frameRect, this.paint);
        canvas.drawRect(this.frameRect, this.eraser);
        drawCorners(canvas);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        resetFrameRect(i2, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean handleDown = handleDown(motionEvent);
        if (handleDown || !this.frameRect.contains(motionEvent.getX(), motionEvent.getY())) {
            return handleDown;
        }
        this.gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public void setOnFrameChangeListener(ad adVar) {
        this.onFrameChangeListener = adVar;
    }

    public void setRatioType(int i2) {
        this.mRatioType = i2;
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, (Paint) null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.mNinePaint.setColor(-1);
        this.mNinePaint.setStrokeWidth(2.0f);
        this.eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }

    public FrameOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayerType(1, (Paint) null);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(6.0f);
        this.mNinePaint.setColor(-1);
        this.mNinePaint.setStrokeWidth(2.0f);
        this.eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }
}
