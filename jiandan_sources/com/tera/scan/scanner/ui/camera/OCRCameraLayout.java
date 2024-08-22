package com.tera.scan.scanner.ui.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.i.qw;

public class OCRCameraLayout extends FrameLayout {
    public static final int ORIENTATION_HORIZONTAL = 1;
    public static final int ORIENTATION_PORTRAIT = 0;
    public static final String TAG = "OCRCameraLayout";
    public Rect backgroundRect;
    public View centerView;
    public int centerViewId;
    public View contentView;
    public int contentViewId;
    public boolean isNeedCameraFull = false;
    public View leftDownView;
    public int leftDownViewId;
    public int mRatioType = 0;
    public int orientation = 0;
    public Paint paint;
    public View rightUpView;
    public int rightUpViewId;

    public OCRCameraLayout(Context context) {
        super(context);
        setWillNotDraw(false);
        this.backgroundRect = new Rect();
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    private int getContentHeight(int i2) {
        if (this.mRatioType == 1) {
            return (i2 * 16) / 9;
        }
        return (i2 * 4) / 3;
    }

    private void parseAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.OCRCameraLayout, 0, 0);
        try {
            this.contentViewId = obtainStyledAttributes.getResourceId(1, -1);
            this.centerViewId = obtainStyledAttributes.getResourceId(0, -1);
            this.leftDownViewId = obtainStyledAttributes.getResourceId(2, -1);
            this.rightUpViewId = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.contentViewId);
        int i2 = this.centerViewId;
        if (i2 != -1) {
            this.centerView = findViewById(i2);
        }
        this.leftDownView = findViewById(this.leftDownViewId);
        this.rightUpView = findViewById(this.rightUpViewId);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.isNeedCameraFull) {
            canvas.drawRect(this.backgroundRect, this.paint);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        qw.ad(TAG, "Camera2Control layout l = " + i2 + ", r = " + i4 + ", b = " + i5);
        int width = getWidth();
        int height = getHeight();
        qw.ad(TAG, "Camera2Control layout width = " + width + ", height = " + height);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.leftDownView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.rightUpView.getLayoutParams();
        if (i4 < i5) {
            int min = Math.min(Math.min(getContentHeight(width), height), getHeight() - fe.mmm.qw.h.qw.qw(70));
            int i6 = height - min;
            if (this.isNeedCameraFull) {
                this.contentView.layout(i2, i3, i4, i5);
            } else {
                this.contentView.layout(i2, i3, i4, min);
            }
            Rect rect = this.backgroundRect;
            rect.left = 0;
            rect.top = min;
            rect.right = width;
            rect.bottom = height;
            View view = this.centerView;
            if (view != null) {
                int measuredWidth = (width - view.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.centerView.getMeasuredHeight()) / 2) + min;
                if (this.centerView.getMeasuredHeight() + measuredHeight > height) {
                    measuredHeight = height - this.centerView.getMeasuredHeight();
                }
                View view2 = this.centerView;
                view2.layout(measuredWidth, measuredHeight, view2.getMeasuredWidth() + measuredWidth, this.centerView.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.leftDownView.getMeasuredHeight()) / 2) + min;
            if (this.leftDownView.getMeasuredHeight() + measuredHeight2 > height) {
                measuredHeight2 = height - this.leftDownView.getMeasuredHeight();
            }
            View view3 = this.leftDownView;
            view3.layout(i7, measuredHeight2, view3.getMeasuredWidth() + i7, this.leftDownView.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.rightUpView.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = min + ((i6 - this.rightUpView.getMeasuredHeight()) / 2);
            if (this.rightUpView.getMeasuredHeight() + measuredHeight3 > height) {
                measuredHeight3 = height - this.rightUpView.getMeasuredHeight();
            }
            View view4 = this.rightUpView;
            view4.layout(measuredWidth2, measuredHeight3, view4.getMeasuredWidth() + measuredWidth2, this.rightUpView.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int contentHeight = getContentHeight(height);
        int i8 = width - contentHeight;
        if (this.isNeedCameraFull) {
            this.contentView.layout(i2, i3, i4, i5);
        } else {
            this.contentView.layout(i2, i3, contentHeight, height);
        }
        Rect rect2 = this.backgroundRect;
        rect2.left = contentHeight;
        rect2.top = 0;
        rect2.right = width;
        rect2.bottom = height;
        View view5 = this.centerView;
        if (view5 != null) {
            int measuredWidth3 = ((i8 - view5.getMeasuredWidth()) / 2) + contentHeight;
            int measuredHeight4 = (height - this.centerView.getMeasuredHeight()) / 2;
            View view6 = this.centerView;
            view6.layout(measuredWidth3, measuredHeight4, view6.getMeasuredWidth() + measuredWidth3, this.centerView.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i8 - this.leftDownView.getMeasuredWidth()) / 2) + contentHeight;
        int measuredHeight5 = (height - this.leftDownView.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        View view7 = this.leftDownView;
        view7.layout(measuredWidth4, measuredHeight5, view7.getMeasuredWidth() + measuredWidth4, this.leftDownView.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = contentHeight + ((i8 - this.rightUpView.getMeasuredWidth()) / 2);
        int i9 = marginLayoutParams2.topMargin;
        View view8 = this.rightUpView;
        view8.layout(measuredWidth5, i9, view8.getMeasuredWidth() + measuredWidth5, this.rightUpView.getMeasuredHeight() + i9);
    }

    public void setIsNeedCameraFull(boolean z) {
        this.isNeedCameraFull = z;
    }

    public void setOrientation(int i2) {
        if (this.orientation != i2) {
            this.orientation = i2;
            requestLayout();
        }
    }

    public void setRatioType(int i2) {
        this.mRatioType = i2;
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.backgroundRect = new Rect();
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        parseAttrs(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setWillNotDraw(false);
        this.backgroundRect = new Rect();
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        parseAttrs(attributeSet);
    }
}
