package com.tera.scan.scanner.ui.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import fe.mmm.qw.j.ddd.de;
import java.io.IOException;

public class CropView extends View {
    public static final String TAG = "CropView";
    public Bitmap bitmap;
    public GestureDetector gestureDetector;
    public Matrix matrix = new Matrix();
    public float[] matrixArray = new float[9];
    public float maximumScale = 4.0f;
    public ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener = new qw();
    public Rect restrictBound;
    public int rotation = 0;
    public ScaleGestureDetector scaleGestureDetector;
    public float setMinimumScale = 0.2f;

    public class ad implements GestureDetector.OnGestureListener {
        public ad() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public class qw implements ScaleGestureDetector.OnScaleGestureListener {
        public qw() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            CropView.this.matrix.postScale(scaleFactor, scaleFactor);
            CropView.this.invalidate();
        }
    }

    public CropView(Context context) {
        super(context);
        init();
    }

    private void centerImage(int i2, int i3) {
        Bitmap bitmap2;
        if (i2 > 0 && i3 > 0 && (bitmap2 = this.bitmap) != null) {
            float min = Math.min((((float) i3) * 1.0f) / ((float) bitmap2.getHeight()), (((float) i2) * 1.0f) / ((float) this.bitmap.getWidth()));
            this.matrix.setTranslate(0.0f, 0.0f);
            this.matrix.setScale(min, min, ((float) this.bitmap.getWidth()) / 2.0f, ((float) this.bitmap.getHeight()) / 2.0f);
            this.matrix.postTranslate(((float) (i2 - this.bitmap.getWidth())) / 2.0f, ((float) (i3 - this.bitmap.getHeight())) / 2.0f);
            invalidate();
        }
    }

    private Rect getRestrictedBound() {
        return this.restrictBound;
    }

    private float getScale() {
        this.matrix.getValues(this.matrixArray);
        float f = this.matrixArray[0];
        if (((double) Math.abs(f)) <= 0.1d) {
            f = this.matrixArray[1];
        }
        return Math.abs(f);
    }

    private void init() {
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), this.onScaleGestureListener);
        this.gestureDetector = new GestureDetector(getContext(), new ad());
    }

    private void scale(ScaleGestureDetector scaleGestureDetector2) {
        float scaleFactor = scaleGestureDetector2.getScaleFactor();
        float scale = getScale();
        float f = this.setMinimumScale;
        if (scale * scaleFactor < f) {
            scaleFactor = f / scale;
        }
        float f2 = this.maximumScale;
        if (scale * scaleFactor > f2) {
            scaleFactor = f2 / scale;
        }
        this.matrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector2.getFocusX(), scaleGestureDetector2.getFocusY());
        invalidate();
    }

    private void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
        this.matrix.reset();
        centerImage(getWidth(), getHeight());
        this.rotation = 0;
        invalidate();
    }

    private void translate(float f, float f2) {
        this.matrix.getValues(this.matrixArray);
        float[] fArr = this.matrixArray;
        float f3 = fArr[2];
        float f4 = fArr[5];
        Rect restrictedBound = getRestrictedBound();
        if (restrictedBound != null) {
            float scale = getScale();
            float width = ((float) ((int) (((float) this.bitmap.getWidth()) / scale))) + f3;
            float height = ((float) ((int) (((float) this.bitmap.getHeight()) / scale))) + f4;
            int i2 = restrictedBound.left;
            if (f3 - f > ((float) i2)) {
                f = f3 - ((float) i2);
            }
            int i3 = restrictedBound.top;
            if (f4 - f2 > ((float) i3)) {
                f2 = f4 - ((float) i3);
            }
            if (f > 0.0f) {
                int i4 = restrictedBound.right;
                if (width - f < ((float) i4)) {
                    f = width - ((float) i4);
                }
            }
            if (f2 > 0.0f) {
                int i5 = restrictedBound.bottom;
                if (height - f2 < ((float) i5)) {
                    f2 = height - ((float) i5);
                }
            }
        }
        this.matrix.postTranslate(-f, -f2);
        invalidate();
    }

    public Bitmap crop(Rect rect) {
        float scale = getScale();
        float[] fArr = {(float) rect.left, (float) rect.top};
        float[] fArr2 = {0.0f, 0.0f};
        Matrix matrix2 = new Matrix();
        this.matrix.invert(matrix2);
        matrix2.mapPoints(fArr2, fArr);
        Matrix matrix3 = new Matrix();
        Bitmap createBitmap = Bitmap.createBitmap((int) (((float) rect.width()) / scale), (int) (((float) rect.height()) / scale), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap bitmap2 = this.bitmap;
        matrix3.postTranslate(-fArr2[0], -fArr2[1]);
        canvas.drawBitmap(bitmap2, matrix3, (Paint) null);
        return createBitmap;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, this.matrix, (Paint) null);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        centerImage(i2, i3);
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((this.gestureDetector.onTouchEvent(motionEvent) || this.scaleGestureDetector.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void rotate(int i2) {
        Matrix matrix2 = new Matrix();
        int width = this.bitmap.getWidth() / 2;
        int height = this.bitmap.getHeight() / 2;
        matrix2.postTranslate((float) (-width), (float) (-height));
        matrix2.postRotate((float) i2);
        matrix2.postTranslate((float) height, (float) width);
        Bitmap bitmap2 = this.bitmap;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2.getHeight(), bitmap2.getWidth(), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(this.bitmap, matrix2, (Paint) null);
        this.bitmap.recycle();
        this.bitmap = createBitmap;
        centerImage(getWidth(), getHeight());
        invalidate();
    }

    public void setFilePath(String str) {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.bitmap.recycle();
        }
        if (str != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                Matrix matrix2 = new Matrix();
                int ad2 = de.ad(attributeInt);
                if (((float) attributeInt) != 0.0f) {
                    matrix2.preRotate((float) ad2);
                }
                int min = Math.min(Math.min(options.outWidth, options.outHeight), 2560);
                Point point = new Point();
                ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
                int min2 = Math.min(min, (point.x * 2) / 3);
                int qw2 = de.qw(options, min2, min2);
                options.inSampleSize = qw2;
                options.inScaled = true;
                options.inDensity = options.outWidth;
                options.inTargetDensity = min2 * qw2;
                options.inJustDecodeBounds = false;
                this.bitmap = BitmapFactory.decodeFile(str, options);
            } catch (IOException e) {
                fe.mmm.qw.i.qw.th(TAG, e.getMessage(), e);
                this.bitmap = decodeFile;
            } catch (Exception e2) {
                fe.mmm.qw.i.qw.th(TAG, e2.getMessage(), e2);
            }
            setBitmap(this.bitmap);
        }
    }

    public void setMaximumScale(float f) {
        this.maximumScale = f;
    }

    public void setMinimumScale(float f) {
        this.setMinimumScale = f;
    }

    public void setRestrictBound(Rect rect) {
        this.restrictBound = rect;
    }

    public CropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CropView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
