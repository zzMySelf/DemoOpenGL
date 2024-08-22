package com.tera.scan.scanner.zxing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.aiscan.R;
import com.google.zxing.ResultPoint;
import fe.mmm.qw.tt.th.uk.fe;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {
    public static final long ANIMATION_DELAY = 80;
    public static final int CURRENT_POINT_OPACITY = 160;
    public static final int MAX_RESULT_POINTS = 20;
    public static final int POINT_SIZE = 6;
    public static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    public fe cameraManager;
    public final int laserColor;
    public List<ResultPoint> lastPossibleResultPoints;
    public final int maskColor;
    public final Paint paint = new Paint(1);
    public List<ResultPoint> possibleResultPoints;
    public Bitmap resultBitmap;
    public final int resultColor;
    public final int resultPointColor;
    public int scannerAlpha;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.maskColor = resources.getColor(R.color.viewfinder_mask);
        this.resultColor = resources.getColor(R.color.result_view);
        this.laserColor = resources.getColor(R.color.viewfinder_laser);
        this.resultPointColor = resources.getColor(R.color.possible_result_points);
        this.scannerAlpha = 0;
        this.possibleResultPoints = new ArrayList(5);
        this.lastPossibleResultPoints = null;
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        List<ResultPoint> list = this.possibleResultPoints;
        synchronized (list) {
            list.add(resultPoint);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.resultBitmap = bitmap;
        invalidate();
    }

    public void drawViewfinder() {
        Bitmap bitmap = this.resultBitmap;
        this.resultBitmap = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        fe feVar = this.cameraManager;
        if (feVar != null) {
            Rect fe2 = feVar.fe();
            Rect rg2 = this.cameraManager.rg();
            if (fe2 != null && rg2 != null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                this.paint.setColor(this.resultBitmap != null ? this.resultColor : this.maskColor);
                float f = (float) width;
                canvas.drawRect(0.0f, 0.0f, f, (float) fe2.top, this.paint);
                canvas.drawRect(0.0f, (float) fe2.top, (float) fe2.left, (float) (fe2.bottom + 1), this.paint);
                float f2 = f;
                canvas.drawRect((float) (fe2.right + 1), (float) fe2.top, f2, (float) (fe2.bottom + 1), this.paint);
                canvas.drawRect(0.0f, (float) (fe2.bottom + 1), f2, (float) height, this.paint);
                if (this.resultBitmap != null) {
                    this.paint.setAlpha(160);
                    canvas.drawBitmap(this.resultBitmap, (Rect) null, fe2, this.paint);
                    return;
                }
                this.paint.setColor(this.laserColor);
                this.paint.setAlpha(SCANNER_ALPHA[this.scannerAlpha]);
                this.scannerAlpha = (this.scannerAlpha + 1) % SCANNER_ALPHA.length;
                int height2 = (fe2.height() / 2) + fe2.top;
                canvas.drawRect((float) (fe2.left + 2), (float) (height2 - 1), (float) (fe2.right - 1), (float) (height2 + 2), this.paint);
                float width2 = ((float) fe2.width()) / ((float) rg2.width());
                float height3 = ((float) fe2.height()) / ((float) rg2.height());
                List<ResultPoint> list = this.possibleResultPoints;
                List<ResultPoint> list2 = this.lastPossibleResultPoints;
                int i2 = fe2.left;
                int i3 = fe2.top;
                if (list.isEmpty()) {
                    this.lastPossibleResultPoints = null;
                } else {
                    this.possibleResultPoints = new ArrayList(5);
                    this.lastPossibleResultPoints = list;
                    this.paint.setAlpha(160);
                    this.paint.setColor(this.resultPointColor);
                    synchronized (list) {
                        for (ResultPoint next : list) {
                            canvas.drawCircle((float) (((int) (next.getX() * width2)) + i2), (float) (((int) (next.getY() * height3)) + i3), 6.0f, this.paint);
                        }
                    }
                }
                if (list2 != null) {
                    this.paint.setAlpha(80);
                    this.paint.setColor(this.resultPointColor);
                    synchronized (list2) {
                        for (ResultPoint next2 : list2) {
                            canvas.drawCircle((float) (((int) (next2.getX() * width2)) + i2), (float) (((int) (next2.getY() * height3)) + i3), 3.0f, this.paint);
                        }
                    }
                }
                postInvalidateDelayed(80, fe2.left - 6, fe2.top - 6, fe2.right + 6, fe2.bottom + 6);
            }
        }
    }

    public void setCameraManager(fe feVar) {
        this.cameraManager = feVar;
    }
}
