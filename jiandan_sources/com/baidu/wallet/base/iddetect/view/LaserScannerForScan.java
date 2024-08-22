package com.baidu.wallet.base.iddetect.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.iddetect.CameraSizeInfo;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import com.baidu.wallet.core.utils.LogUtil;

public class LaserScannerForScan extends ImageView {
    public Bitmap laser;
    public IdCardActivity mAttachedActivity;
    public int mHeight;
    public int mScanDrawableHeight;
    public CameraSizeInfo mSortSize;
    public Matrix mat;
    public float posX;
    public int posY;
    public float scale;
    public boolean scan;
    public Drawable scanDrawable;

    public LaserScannerForScan(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        IdCardActivity idCardActivity;
        try {
            CameraSizeInfo sortSizeInstance = CameraUtilsForScan.getSortSizeInstance(context, 1, false);
            this.mSortSize = sortSizeInstance;
            if (sortSizeInstance != null || (idCardActivity = this.mAttachedActivity) == null) {
                if (this.scanDrawable == null) {
                    this.scanDrawable = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
                }
                this.laser = ((BitmapDrawable) this.scanDrawable).getBitmap();
                this.mat = new Matrix();
                this.scan = true;
                this.posY = 0;
                return;
            }
            idCardActivity.dialogPermission();
        } catch (Exception e) {
            String simpleName = LaserScannerForScan.class.getSimpleName();
            LogUtil.errord(simpleName, "init failed exception = " + e.getMessage());
            throw e;
        }
    }

    public IdCardActivity getAttachedActivity() {
        return this.mAttachedActivity;
    }

    public int getBankHeight() {
        return this.mHeight;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.scan) {
            this.mat.reset();
            Matrix matrix = this.mat;
            float f = this.scale;
            matrix.setScale(f, f);
            this.mat.setTranslate(this.posX, (float) (this.posY + this.mScanDrawableHeight));
            canvas.drawBitmap(this.laser, this.mat, (Paint) null);
            int height = canvas.getHeight() - this.mScanDrawableHeight;
            this.posY = (this.posY + (height / 100)) % height;
            postInvalidateDelayed(10, 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        CameraSizeInfo cameraSizeInfo = this.mSortSize;
        if (cameraSizeInfo == null) {
            i4 = (int) (((float) size) * 1.0f * 0.6306f);
        } else {
            i4 = (int) (((float) size) * 1.0f * cameraSizeInfo.mHeightRatio);
        }
        this.mHeight = i4;
        setMeasuredDimension(size, i4);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.scale = (float) (i2 / this.laser.getWidth());
        Bitmap bitmap = this.laser;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, bitmap.getHeight(), true);
        this.laser = createScaledBitmap;
        this.posX = 0.0f;
        this.mScanDrawableHeight = -createScaledBitmap.getHeight();
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.mAttachedActivity = idCardActivity;
    }

    public void startScan() {
        this.scan = true;
        postInvalidate();
    }

    public void stopScan() {
        this.scan = false;
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.scanDrawable = null;
        this.mHeight = -1;
        this.mScanDrawableHeight = -1;
        init(context, attributeSet, i2);
    }
}
