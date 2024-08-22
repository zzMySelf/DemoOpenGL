package com.tera.scan.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tera.scan.widget.ZoomImageView;

public class CropImageView extends ZoomImageView {
    public ImageView mCropView;

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f7479ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PointF f7480i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ float f7481o;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f7483th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ float f7484uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ PointF f7485yj;

        public qw(float f, long j, PointF pointF, float f2, PointF pointF2, float f3) {
            this.f7479ad = f;
            this.f7483th = j;
            this.f7485yj = pointF;
            this.f7484uk = f2;
            this.f7480i = pointF2;
            this.f7481o = f3;
        }

        public void run() {
            float min = Math.min(this.f7479ad, (float) (System.currentTimeMillis() - this.f7483th));
            PointF pointF = this.f7485yj;
            float f = pointF.x + (this.f7484uk * min);
            PointF pointF2 = this.f7480i;
            float f2 = f - pointF2.x;
            float f3 = (pointF.y + (this.f7481o * min)) - pointF2.y;
            CropImageView.this.postTranslate(f2, f3);
            CropImageView cropImageView = CropImageView.this;
            cropImageView.setImageMatrix(cropImageView.getImageViewMatrix());
            PointF pointF3 = this.f7480i;
            pointF3.x += f2;
            pointF3.y += f3;
            if (min < this.f7479ad) {
                CropImageView.this.post(this);
            }
        }
    }

    public CropImageView(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int center(boolean r8, boolean r9) {
        /*
            r7 = this;
            com.tera.scan.widget.ZoomImageView$fe r0 = r7.mBitmapDisplayed
            android.graphics.Bitmap r0 = r0.qw()
            if (r0 != 0) goto L_0x000b
            r8 = 15
            return r8
        L_0x000b:
            android.graphics.RectF r0 = r7.getMapRect()
            float r1 = r0.height()
            float r2 = r0.width()
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            if (r9 == 0) goto L_0x0064
            int r9 = r7.getCropBottom()
            int r6 = r7.getCropTop()
            int r9 = r9 - r6
            float r9 = (float) r9
            int r6 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x0039
            float r9 = r9 - r1
            float r9 = r9 / r4
            float r1 = r0.top
            float r9 = r9 - r1
            int r1 = r7.getCropTop()
            float r1 = (float) r1
            float r9 = r9 + r1
            r3 = 12
            goto L_0x0065
        L_0x0039:
            float r9 = r0.top
            int r1 = r7.getCropTop()
            float r1 = (float) r1
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 <= 0) goto L_0x004e
            int r9 = r7.getCropTop()
            float r9 = (float) r9
            float r1 = r0.top
            float r9 = r9 - r1
            r3 = 4
            goto L_0x0065
        L_0x004e:
            float r9 = r0.bottom
            int r1 = r7.getCropBottom()
            float r1 = (float) r1
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 >= 0) goto L_0x0064
            int r9 = r7.getCropBottom()
            float r9 = (float) r9
            float r1 = r0.bottom
            float r9 = r9 - r1
            r3 = 8
            goto L_0x0065
        L_0x0064:
            r9 = 0
        L_0x0065:
            if (r8 == 0) goto L_0x00b3
            int r8 = r7.getCropRight()
            int r1 = r7.getCropLeft()
            int r8 = r8 - r1
            float r8 = (float) r8
            int r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0084
            float r8 = r8 - r2
            float r8 = r8 / r4
            float r0 = r0.left
            float r8 = r8 - r0
            int r0 = r7.getCropLeft()
            float r0 = (float) r0
            float r5 = r8 + r0
            r3 = r3 | 3
            goto L_0x00b3
        L_0x0084:
            float r8 = r0.left
            int r1 = r7.getCropLeft()
            float r1 = (float) r1
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x009c
            float r8 = r0.left
            float r8 = -r8
            int r0 = r7.getCropLeft()
            float r0 = (float) r0
            float r5 = r8 + r0
            r3 = r3 | 1
            goto L_0x00b3
        L_0x009c:
            float r8 = r0.right
            int r1 = r7.getCropRight()
            float r1 = (float) r1
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b3
            float r8 = r0.right
            float r8 = -r8
            int r0 = r7.getCropRight()
            float r0 = (float) r0
            float r5 = r8 + r0
            r3 = r3 | 2
        L_0x00b3:
            r7.postTranslate(r5, r9)
            android.graphics.Matrix r8 = r7.getImageViewMatrix()
            r7.setImageMatrix(r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.widget.CropImageView.center(boolean, boolean):int");
    }

    public int getCropBottom() {
        return ((View) this.mCropView.getParent()).getBottom();
    }

    public int getCropLeft() {
        return this.mCropView.getLeft();
    }

    public int getCropRight() {
        return this.mCropView.getRight();
    }

    public int getCropTop() {
        return ((View) this.mCropView.getParent()).getTop();
    }

    public Rect getMapCropRect() {
        Matrix imageViewMatrix = getImageViewMatrix();
        Matrix matrix = new Matrix();
        matrix.reset();
        imageViewMatrix.invert(matrix);
        RectF rectF = new RectF((float) getCropLeft(), (float) getCropTop(), (float) getCropRight(), (float) getCropBottom());
        matrix.mapRect(rectF);
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public void getProperBaseMatrix(ZoomImageView.fe feVar, Matrix matrix) {
        float height = (float) getHeight();
        float cropRight = (float) (getCropRight() - getCropLeft());
        float f = 0.0f;
        if (cropRight == 0.0f) {
            cropRight = (float) getWidth();
        }
        float rg2 = (float) feVar.rg();
        float ad2 = (float) feVar.ad();
        matrix.reset();
        float f2 = cropRight / (rg2 < ad2 ? rg2 : ad2);
        matrix.postConcat(feVar.de());
        matrix.postScale(f2, f2);
        float f3 = (cropRight - (rg2 * f2)) / 2.0f;
        float f4 = (height - (ad2 * f2)) / 2.0f;
        if (f4 >= 0.0f) {
            f = f4;
        }
        matrix.postTranslate(f3, f);
    }

    public float maxZoom() {
        if (this.mBitmapDisplayed.qw() == null) {
            return 1.0f;
        }
        return Math.max(Math.min(((float) this.mBitmapDisplayed.rg()) / 250.0f, ((float) this.mBitmapDisplayed.ad()) / 250.0f), 1.0f);
    }

    public void setCropView(ImageView imageView) {
        this.mCropView = imageView;
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void center(boolean r12, boolean r13, float r14) {
        /*
            r11 = this;
            com.tera.scan.widget.ZoomImageView$fe r0 = r11.mBitmapDisplayed
            android.graphics.Bitmap r0 = r0.qw()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.Matrix r0 = r11.getImageViewMatrix()
            android.graphics.RectF r1 = new android.graphics.RectF
            com.tera.scan.widget.ZoomImageView$fe r2 = r11.mBitmapDisplayed
            android.graphics.Bitmap r2 = r2.qw()
            int r2 = r2.getWidth()
            float r2 = (float) r2
            com.tera.scan.widget.ZoomImageView$fe r3 = r11.mBitmapDisplayed
            android.graphics.Bitmap r3 = r3.qw()
            int r3 = r3.getHeight()
            float r3 = (float) r3
            r4 = 0
            r1.<init>(r4, r4, r2, r3)
            r0.mapRect(r1)
            float r0 = r1.height()
            float r2 = r1.width()
            android.graphics.PointF r5 = new android.graphics.PointF
            r5.<init>()
            android.graphics.PointF r7 = new android.graphics.PointF
            r7.<init>()
            r3 = 1073741824(0x40000000, float:2.0)
            if (r13 == 0) goto L_0x008d
            int r6 = r11.getCropBottom()
            int r8 = r11.getCropTop()
            int r6 = r6 - r8
            float r6 = (float) r6
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0060
            float r6 = r6 - r0
            float r6 = r6 / r3
            float r0 = r1.top
            float r6 = r6 - r0
            int r0 = r11.getCropTop()
            float r0 = (float) r0
            float r6 = r6 + r0
            float r0 = r1.top
            r5.y = r0
            goto L_0x008e
        L_0x0060:
            float r0 = r1.top
            int r6 = r11.getCropTop()
            float r6 = (float) r6
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0077
            int r0 = r11.getCropTop()
            float r0 = (float) r0
            float r6 = r1.top
            float r0 = r0 - r6
            r5.y = r6
        L_0x0075:
            r6 = r0
            goto L_0x008e
        L_0x0077:
            float r0 = r1.bottom
            int r6 = r11.getCropBottom()
            float r6 = (float) r6
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x008d
            int r0 = r11.getCropBottom()
            float r0 = (float) r0
            float r6 = r1.bottom
            float r0 = r0 - r6
            r5.y = r6
            goto L_0x0075
        L_0x008d:
            r6 = 0
        L_0x008e:
            if (r12 == 0) goto L_0x00df
            int r0 = r11.getCropRight()
            int r8 = r11.getCropLeft()
            int r0 = r0 - r8
            float r0 = (float) r0
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x00af
            float r0 = r0 - r2
            float r0 = r0 / r3
            float r2 = r1.left
            float r0 = r0 - r2
            int r2 = r11.getCropLeft()
            float r2 = (float) r2
            float r4 = r0 + r2
            float r0 = r1.left
            r5.x = r0
            goto L_0x00df
        L_0x00af:
            float r0 = r1.left
            int r2 = r11.getCropLeft()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c9
            float r0 = r1.left
            float r0 = -r0
            int r2 = r11.getCropLeft()
            float r2 = (float) r2
            float r4 = r0 + r2
            float r0 = r1.left
            r5.x = r0
            goto L_0x00df
        L_0x00c9:
            float r0 = r1.right
            int r2 = r11.getCropRight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00df
            int r0 = r11.getCropRight()
            float r0 = (float) r0
            float r1 = r1.right
            float r4 = r0 - r1
            r5.x = r1
        L_0x00df:
            r7.set(r5)
            float r8 = r4 / r14
            float r9 = r6 / r14
            long r3 = java.lang.System.currentTimeMillis()
            com.tera.scan.widget.CropImageView$qw r10 = new com.tera.scan.widget.CropImageView$qw
            r0 = r10
            r1 = r11
            r2 = r14
            r6 = r8
            r8 = r9
            r0.<init>(r2, r3, r5, r6, r7, r8)
            r11.post(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.widget.CropImageView.center(boolean, boolean, float):void");
    }
}
