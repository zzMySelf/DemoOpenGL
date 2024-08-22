package com.baidu.searchbox.screenshot.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.searchbox.socialshare.utils.SocialShareLogUtils;
import java.util.ArrayList;
import java.util.List;

public class Doodle extends View {
    public static final int COLOR_BLACK = Color.parseColor("#FF333333");
    public static final int COLOR_BLUE = Color.parseColor("#FF3C78FF");
    public static final int COLOR_RED = Color.parseColor("#FFE63838");
    public static final int ERASE_STYLE = 2;
    public static final int PAINT_STYLE = 1;
    private static final String TAG = "Doodle";
    private boolean isDoodleEnable;
    private boolean mActionMove;
    private Bitmap mBackGround;
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private int mBtmHeight;
    private int mBtmWidth;
    private List<DrawPath> mCachedPath;
    private Canvas mCanvas;
    private int mCurrentStyle;
    private OnDoodleEvent mDoodleEvent;
    private DrawPath mDrawPath;
    int mHeight;
    private int mLastX;
    private int mLastY;
    private Paint mPaint;
    private int mPaintColor;
    private int mPaintSize;
    private Path mPath;
    private List<DrawPath> mSavedPath;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;
    private int mVerticalRegion;
    int mWidth;

    public interface OnDoodleEvent {
        void onDoodleEnd();

        void onDoodleStart();

        void onDoodling();
    }

    public Doodle(Context context) {
        this(context, (AttributeSet) null);
    }

    public Doodle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Doodle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCurrentStyle = 1;
        this.isDoodleEnable = false;
        this.mVerticalRegion = 0;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float scale = context.getResources().getDisplayMetrics().density;
        this.mPaintSize = (int) ((5.0f * scale) + 0.5f);
        this.mWidth = (int) ((300.0f * scale) + 0.5f);
        this.mHeight = (int) ((400.0f * scale) + 0.5f);
        this.mPaintColor = COLOR_BLUE;
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
        init();
    }

    private void init() {
        this.mSavedPath = new ArrayList();
        this.mCurrentStyle = 1;
        setLayerType(1, (Paint) null);
        setPaintStyle();
        Paint paint = new Paint(4);
        this.mBitmapPaint = paint;
        paint.setAlpha(200);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mBitmap = Bitmap.createScaledBitmap(bitmap, w, h2, true);
            this.mCanvas = new Canvas(this.mBitmap);
            return;
        }
        try {
            this.mBitmap = Bitmap.createBitmap(w, h2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e2) {
            try {
                this.mBitmap = Bitmap.createBitmap(w, h2, Bitmap.Config.RGB_565);
            } catch (OutOfMemoryError e3) {
                SocialShareLogUtils.d(TAG, "doodle oom e = " + e2.getMessage());
            }
        }
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 != null) {
            bitmap2.eraseColor(Color.argb(0, 0, 0, 0));
            Canvas canvas = new Canvas(this.mBitmap);
            this.mCanvas = canvas;
            canvas.drawColor(0);
        }
    }

    private void setPaintStyle() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        if (this.mCurrentStyle == 1) {
            this.mPaint.setXfermode((Xfermode) null);
            this.mPaint.setStrokeWidth((float) this.mPaintSize);
            this.mPaint.setColor(this.mPaintColor);
            this.mPaint.setAlpha(200);
            return;
        }
        this.mPaint.setAlpha(0);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mPaint.setColor(0);
        this.mPaint.setStrokeWidth((float) (this.mPaintSize * 4));
    }

    public boolean onTouchEvent(MotionEvent event) {
        int i2;
        if (!this.isDoodleEnable) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case 0:
                if (y < this.mVerticalRegion - 3) {
                    this.mPath = new Path();
                    DrawPath drawPath = new DrawPath();
                    this.mDrawPath = drawPath;
                    drawPath.path = this.mPath;
                    this.mDrawPath.paint = this.mPaint;
                    this.mPath.moveTo((float) x, (float) y);
                    this.mLastX = x;
                    this.mLastY = y;
                    invalidate();
                    OnDoodleEvent onDoodleEvent = this.mDoodleEvent;
                    if (onDoodleEvent != null) {
                        onDoodleEvent.onDoodleStart();
                        break;
                    }
                } else {
                    return false;
                }
                break;
            case 1:
                this.mActionMove = false;
                int i3 = this.mVerticalRegion;
                if (i3 != 0 && y >= i3 - 3) {
                    y = Math.min(y, i3 - 3);
                }
                this.mPath.lineTo((float) x, (float) y);
                this.mCanvas.drawPath(this.mPath, this.mPaint);
                this.mSavedPath.add(this.mDrawPath);
                invalidate();
                OnDoodleEvent onDoodleEvent2 = this.mDoodleEvent;
                if (onDoodleEvent2 != null) {
                    onDoodleEvent2.onDoodleEnd();
                    break;
                }
                break;
            case 2:
                int i4 = this.mVerticalRegion;
                if (i4 != 0) {
                    y = Math.min(y, i4 - 3);
                }
                int dx = Math.abs(x - this.mLastX);
                int dy = Math.abs(y - this.mLastY);
                if (!this.mActionMove && (dx > (i2 = this.mTouchSlop) || dy > i2)) {
                    this.mActionMove = true;
                    this.mLastX = x;
                    this.mLastY = y;
                }
                if (this.mActionMove) {
                    this.mPath.lineTo((float) x, (float) y);
                    this.mLastX = x;
                    this.mLastY = y;
                    this.mCanvas.drawPath(this.mPath, this.mPaint);
                    invalidate();
                    OnDoodleEvent onDoodleEvent3 = this.mDoodleEvent;
                    if (onDoodleEvent3 != null) {
                        onDoodleEvent3.onDoodling();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mBitmapPaint);
    }

    public void setPaintSize(int size) {
        this.mPaintSize = size;
    }

    public void setVerticalRegion(int verticalRegion) {
        this.mVerticalRegion = verticalRegion;
    }

    public void selectPaintColor(int color) {
        if (color == COLOR_BLUE || color == COLOR_RED || color == COLOR_BLACK) {
            this.mPaintColor = color;
            this.mCurrentStyle = 1;
            setPaintStyle();
        }
    }

    public void selectPaintStyle(int style) {
        if (style == 1 || style == 2) {
            this.mCurrentStyle = style;
            setPaintStyle();
        }
    }

    public int getPaintStyle() {
        return this.mCurrentStyle;
    }

    public void setBackGroundBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.mBackGround = Bitmap.createScaledBitmap(bitmap, this.mWidth, this.mHeight, true);
            invalidate();
        }
    }

    public void setDoodleEnable(boolean enable) {
        this.isDoodleEnable = enable;
    }

    public void clear() {
        List<DrawPath> list = this.mSavedPath;
        if (list != null) {
            list.clear();
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.eraseColor(Color.argb(0, 0, 0, 0));
        }
        Canvas canvas = this.mCanvas;
        if (canvas != null) {
            canvas.drawColor(0);
        }
        invalidate();
    }

    public void cacheCurSession() {
        List<DrawPath> list = this.mSavedPath;
        if (list != null && list.size() != 0) {
            if (this.mCachedPath == null) {
                this.mCachedPath = new ArrayList();
            }
            for (DrawPath drawPath : this.mSavedPath) {
                this.mCachedPath.add(drawPath);
            }
        }
    }

    public void flush(boolean isUndo) {
        List<DrawPath> list = this.mCachedPath;
        if (list == null || list.size() == 0) {
            if (isUndo) {
                clear();
            }
        } else if (isUndo) {
            clear();
            for (DrawPath drawPath : this.mCachedPath) {
                this.mSavedPath.add(drawPath);
            }
            this.mCachedPath.clear();
            restore();
            restore();
        } else {
            this.mCachedPath.clear();
            this.mCachedPath = null;
        }
    }

    private void restore() {
        for (DrawPath drawPath : this.mSavedPath) {
            this.mCanvas.drawPath(drawPath.path, drawPath.paint);
        }
        invalidate();
    }

    public boolean isDoodled() {
        return this.mSavedPath.size() > 0;
    }

    public Bitmap getDoodleBitmap() {
        return this.mBitmap;
    }

    public void setOnDoodleEvent(OnDoodleEvent event) {
        this.mDoodleEvent = event;
    }

    private class DrawPath {
        public Paint paint;
        public Path path;

        private DrawPath() {
        }
    }
}
