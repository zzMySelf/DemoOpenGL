package com.tera.scan.doc.preview.document.ui.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import fe.mmm.qw.i.qw;
import java.io.IOException;
import java.io.InputStream;

public class BigImageView extends View implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public static final String TAG = "BigView";
    public Bitmap bitmap;
    public BitmapRegionDecoder mDecoder;
    public GestureDetector mGestureDetector;
    public int mImageHeight;
    public int mImageWidth;
    public BitmapFactory.Options mOptions;
    public Rect mRect;
    public float mScale;
    public Scroller mScroller;
    public int mViewHeight;
    public int mViewWidth;

    public BigImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            this.mRect.top = this.mScroller.getCurrY();
            Rect rect = this.mRect;
            rect.bottom = rect.top + ((int) (((float) this.mViewHeight) / this.mScale));
            invalidate();
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        return true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDecoder != null) {
            qw.rg(TAG, "复用上一张bitmap=" + this.bitmap);
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 == null || bitmap2.getHeight() < this.mRect.bottom) {
                this.mOptions.inBitmap = null;
            } else {
                qw.ad(TAG, "上一张bitmap尺寸：" + this.bitmap.getWidth() + " " + this.bitmap.getHeight());
                this.mOptions.inBitmap = this.bitmap;
            }
            this.bitmap = this.mDecoder.decodeRegion(this.mRect, this.mOptions);
            Matrix matrix = new Matrix();
            float f = this.mScale;
            matrix.setScale(f, f);
            try {
                if (this.bitmap != null) {
                    canvas.drawBitmap(this.bitmap, matrix, (Paint) null);
                }
            } catch (Exception e) {
                qw.th(TAG, e.getMessage(), e);
            }
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mScroller.fling(0, this.mRect.top, 0, (int) (-f2), 0, 0, 0, this.mImageHeight - ((int) (((float) this.mViewHeight) / this.mScale)));
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.mViewWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mViewHeight = measuredHeight;
        if (this.mDecoder != null) {
            Rect rect = this.mRect;
            rect.left = 0;
            rect.top = 0;
            int i4 = this.mImageWidth;
            rect.right = i4;
            float f = ((float) this.mViewWidth) / ((float) i4);
            this.mScale = f;
            rect.bottom = (int) (((float) measuredHeight) / f);
            qw.rg(TAG, "l=" + this.mRect.left);
            qw.rg(TAG, "t=" + this.mRect.top);
            qw.rg(TAG, "r=" + this.mRect.right);
            qw.rg(TAG, "b=" + this.mRect.bottom);
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mRect.offset(0, (int) f2);
        Rect rect = this.mRect;
        int i2 = rect.bottom;
        int i3 = this.mImageHeight;
        if (i2 > i3) {
            rect.bottom = i3;
            rect.top = i3 - ((int) (((float) this.mViewHeight) / this.mScale));
        }
        Rect rect2 = this.mRect;
        if (rect2.top < 0) {
            rect2.top = 0;
            rect2.bottom = (int) (((float) this.mViewHeight) / this.mScale);
        }
        invalidate();
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void setImage(InputStream inputStream, String str) {
        BitmapFactory.Options options = this.mOptions;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        BitmapFactory.Options options2 = this.mOptions;
        this.mImageWidth = options2.outWidth;
        this.mImageHeight = options2.outHeight;
        options2.inMutable = true;
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        options2.inJustDecodeBounds = false;
        try {
            this.mDecoder = BitmapRegionDecoder.newInstance(str, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestLayout();
    }

    public BigImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BigImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mRect = new Rect();
        this.mOptions = new BitmapFactory.Options();
        this.mGestureDetector = new GestureDetector(context, this);
        setOnTouchListener(this);
        this.mScroller = new Scroller(context);
    }
}
