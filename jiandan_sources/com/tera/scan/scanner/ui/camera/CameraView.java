package com.tera.scan.scanner.ui.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.aiscan.R;
import com.tera.scan.scanner.ui.camera.ICameraControl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraView extends FrameLayout {
    public static final int ORIENTATION_HORIZONTAL = 90;
    public static final int ORIENTATION_INVERT = 270;
    public static final int ORIENTATION_PORTRAIT = 0;
    public static final String TAG = "CameraView";
    public ICameraControl cameraControl;
    public ad cameraViewTakePictureCallback = new ad();
    public View displayView;
    public ImageView hintView;
    public boolean isNeedEnterLottie = false;
    public boolean isNeedNineLine = false;
    public LottieAnimationView mEnterLottie;
    public ImageView mNineLine;
    public fe.mmm.qw.tt.rg.de.qw mSensorUtil;
    public MaskView maskView;

    public class ad implements ICameraControl.OnTakePictureCallback {

        /* renamed from: ad  reason: collision with root package name */
        public de f7320ad;

        /* renamed from: de  reason: collision with root package name */
        public HandlerThread f7321de;

        /* renamed from: fe  reason: collision with root package name */
        public Handler f7322fe;
        public File qw;

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ byte[] f7324ad;

            /* renamed from: com.tera.scan.scanner.ui.camera.CameraView$ad$qw$qw  reason: collision with other inner class name */
            public class C0268qw implements Runnable {

                /* renamed from: ad  reason: collision with root package name */
                public final /* synthetic */ File f7326ad;

                /* renamed from: th  reason: collision with root package name */
                public final /* synthetic */ int f7327th;

                public C0268qw(File file, int i2) {
                    this.f7326ad = file;
                    this.f7327th = i2;
                }

                public void run() {
                    ad adVar = ad.this;
                    ad.this.f7320ad.qw(CameraView.this.crop(adVar.qw, this.f7326ad, this.f7327th));
                    if (!this.f7326ad.delete()) {
                        this.f7326ad.deleteOnExit();
                    }
                }
            }

            public qw(byte[] bArr) {
                this.f7324ad = bArr;
            }

            public void run() {
                int i2;
                try {
                    if (fe.mmm.qw.j.ddd.de.th(CameraView.this.getContext())) {
                        fe.mmm.qw.i.qw.ad(CameraView.TAG, "Camera2Control  orientation = " + CameraView.this.mSensorUtil.de());
                        i2 = CameraView.this.mSensorUtil.de() != 0 ? 90 : 270;
                    } else {
                        i2 = fe.mmm.qw.j.ddd.de.rg(this.f7324ad);
                    }
                    File createTempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), "jpg");
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    fileOutputStream.write(this.f7324ad);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    ad.this.f7322fe.post(new C0268qw(createTempFile, i2));
                } catch (IOException e) {
                    fe.mmm.qw.i.qw.th(CameraView.TAG, e.getMessage(), e);
                }
            }
        }

        public ad() {
            HandlerThread handlerThread = new HandlerThread("cropThread");
            this.f7321de = handlerThread;
            handlerThread.start();
            this.f7322fe = new Handler(this.f7321de.getLooper());
        }

        public void qw(byte[] bArr) {
            this.f7322fe.post(new qw(bArr));
        }
    }

    public interface de {
        void qw(Bitmap bitmap);
    }

    public CameraView(Context context) {
        super(context);
        init();
    }

    /* access modifiers changed from: private */
    public Bitmap crop(File file, File file2, int i2) {
        int i3 = i2;
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(file2.getAbsolutePath(), true);
            Rect i4 = this.cameraControl.i();
            int width = i3 % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
            int height = i3 % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
            Rect frameRect = this.maskView.getFrameRect();
            int width2 = (frameRect.left * width) / this.maskView.getWidth();
            int height2 = (frameRect.top * height) / this.maskView.getHeight();
            int width3 = (frameRect.right * width) / this.maskView.getWidth();
            int height3 = (frameRect.bottom * height) / this.maskView.getHeight();
            if (i4.top < 0) {
                int height4 = (i4.height() * getWidth()) / i4.width();
                int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / i4.width();
                height2 = (((((height4 - frameRect.height()) / 2) * getWidth()) / i4.width()) * height) / i4.height();
                height3 = (height5 * height) / i4.height();
            } else if (i4.left < 0) {
                int width4 = (i4.width() * getHeight()) / i4.height();
                int width5 = (((width4 - this.maskView.getFrameRect().width()) / 2) * getHeight()) / i4.height();
                int width6 = (((width4 + this.maskView.getFrameRect().width()) / 2) * getHeight()) / i4.height();
                width2 = (width5 * width) / i4.width();
                width3 = (width6 * width) / i4.width();
            }
            Rect rect = new Rect();
            rect.left = width2;
            rect.top = height2;
            rect.right = width3;
            rect.bottom = height3;
            if (i3 % 180 == 90) {
                int width7 = newInstance.getWidth() / 2;
                int height6 = newInstance.getHeight() / 2;
                int height7 = rect.height();
                int width8 = rect.width();
                rect.left = width7 - (height7 / 2);
                rect.top = height6 - (width8 / 2);
                rect.right = width7 + (height7 / 2);
                rect.bottom = height6 + (width8 / 2);
                rect.sort();
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            int min = Math.min(Math.min(newInstance.getWidth(), newInstance.getHeight()), 2560);
            options.inSampleSize = fe.mmm.qw.j.ddd.de.qw(options, min, min);
            options.inScaled = true;
            options.inDensity = Math.max(options.outWidth, options.outHeight);
            options.inTargetDensity = min;
            Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
            if (i3 != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate((float) i3);
                Bitmap createBitmap = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, false);
                if (decodeRegion != createBitmap) {
                    decodeRegion.recycle();
                }
                decodeRegion = createBitmap;
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                decodeRegion.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return decodeRegion;
            } catch (IOException e) {
                fe.mmm.qw.i.qw.th(TAG, e.getMessage(), e);
                return null;
            }
        } catch (Exception e2) {
            fe.mmm.qw.i.qw.th(TAG, e2.getMessage(), e2);
            return null;
        }
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.cameraControl = new fe.mmm.qw.tt.rg.qw.ad(getContext());
        } else {
            this.cameraControl = new fe.mmm.qw.tt.rg.qw.qw(getContext());
        }
        View fe2 = this.cameraControl.fe();
        this.displayView = fe2;
        addView(fe2);
        ImageView imageView = new ImageView(getContext());
        this.mNineLine = imageView;
        imageView.setBackground(getResources().getDrawable(R.drawable.bd_ocr_nine_line));
        addView(this.mNineLine);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
        this.mEnterLottie = lottieAnimationView;
        addView(lottieAnimationView);
        MaskView maskView2 = new MaskView(getContext());
        this.maskView = maskView2;
        addView(maskView2);
        ImageView imageView2 = new ImageView(getContext());
        this.hintView = imageView2;
        addView(imageView2);
        this.mSensorUtil = new fe.mmm.qw.tt.rg.de.qw(getContext());
    }

    public ICameraControl getCameraControl() {
        return this.cameraControl;
    }

    public void hideNineLine() {
        ImageView imageView = this.mNineLine;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void isNeedEnterLottie(boolean z) {
        this.isNeedEnterLottie = z;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        HandlerThread handlerThread = this.cameraViewTakePictureCallback.f7321de;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i5 - i3;
        this.displayView.layout(i2, 0, i4, i6);
        this.mNineLine.layout(i2, 0, i4, i6);
        this.maskView.layout(i2, 0, i4, i6);
        this.mEnterLottie.layout(i2, 0, i4, i6);
        int qw2 = fe.mmm.qw.h.qw.qw(150);
        int qw3 = fe.mmm.qw.h.qw.qw(25);
        int width = (getWidth() - qw2) / 2;
        int qw4 = this.maskView.getFrameRect().bottom + fe.mmm.qw.h.qw.qw(16);
        if (this.maskView.getMaskType() == 12) {
            qw4 = getHeight() - fe.mmm.qw.h.qw.qw(210);
        }
        this.hintView.layout(width, qw4, qw2 + width, qw3 + qw4);
    }

    public void setIShowNineLine(boolean z) {
        this.isNeedNineLine = z;
    }

    public void setMaskType(int i2) {
        this.maskView.setMaskType(i2);
        this.maskView.setVisibility(0);
        this.hintView.setVisibility(0);
        if (this.isNeedNineLine) {
            this.mNineLine.setVisibility(0);
        } else {
            this.mNineLine.setVisibility(4);
        }
        if (this.isNeedEnterLottie) {
            this.mEnterLottie.setVisibility(0);
        } else {
            this.mEnterLottie.setVisibility(4);
        }
    }

    public void setOrientation(int i2) {
        this.cameraControl.rg(i2);
    }

    public void showNineLine() {
        ImageView imageView = this.mNineLine;
        if (imageView != null && this.isNeedNineLine) {
            imageView.setVisibility(0);
        }
    }

    public void start() {
        this.cameraControl.start();
        setKeepScreenOn(true);
    }

    public void startEnterLottie() {
        if (this.isNeedEnterLottie) {
            if (this.mEnterLottie.isAnimating()) {
                this.mEnterLottie.cancelAnimation();
            }
            this.mEnterLottie.setAnimation("ocr_enter.json");
            this.mEnterLottie.loop(true);
            this.mEnterLottie.playAnimation();
        }
    }

    public void stop() {
        this.cameraControl.stop();
        setKeepScreenOn(false);
    }

    public void takePicture(File file, de deVar) {
        File unused = this.cameraViewTakePictureCallback.qw = file;
        de unused2 = this.cameraViewTakePictureCallback.f7320ad = deVar;
        this.cameraControl.yj(this.cameraViewTakePictureCallback);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
