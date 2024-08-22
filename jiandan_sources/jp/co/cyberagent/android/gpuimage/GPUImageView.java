package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tera.scan.app.R$styleable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Semaphore;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.util.Rotation;

public class GPUImageView extends FrameLayout {
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public yj.qw.qw.qw.qw.de.qw filter;
    public pf forceSize = null;
    public GPUImage gpuImage;
    public boolean isShowLoading = true;
    public float ratio = 0.0f;
    public int surfaceType = 0;
    public View surfaceView;

    public interface OnPictureSavedListener {
        void qw(Uri uri);
    }

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            if (GPUImageView.this.isShowLoading) {
                GPUImageView gPUImageView = GPUImageView.this;
                GPUImageView gPUImageView2 = GPUImageView.this;
                gPUImageView.addView(new i(gPUImageView2.getContext()));
            }
            GPUImageView.this.surfaceView.requestLayout();
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Semaphore f10413ad;

        public de(Semaphore semaphore) {
            this.f10413ad = semaphore;
        }

        public void run() {
            this.f10413ad.release();
        }
    }

    public class fe implements Runnable {
        public fe() {
        }

        public void run() {
            GPUImageView.this.surfaceView.requestLayout();
        }
    }

    public class i extends FrameLayout {
        public i(Context context) {
            super(context);
            qw();
        }

        public final void qw() {
            ProgressBar progressBar = new ProgressBar(getContext());
            progressBar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            addView(progressBar);
            setBackgroundColor(-16777216);
        }
    }

    public class o extends AsyncTask<Void, Void, Void> {

        /* renamed from: ad  reason: collision with root package name */
        public final String f10417ad;

        /* renamed from: de  reason: collision with root package name */
        public final int f10418de;

        /* renamed from: fe  reason: collision with root package name */
        public final int f10419fe;
        public final String qw;

        /* renamed from: rg  reason: collision with root package name */
        public final OnPictureSavedListener f10420rg;

        /* renamed from: th  reason: collision with root package name */
        public final Handler f10421th;

        public class qw implements MediaScannerConnection.OnScanCompletedListener {

            /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageView$o$qw$qw  reason: collision with other inner class name */
            public class C0332qw implements Runnable {

                /* renamed from: ad  reason: collision with root package name */
                public final /* synthetic */ Uri f10423ad;

                public C0332qw(Uri uri) {
                    this.f10423ad = uri;
                }

                public void run() {
                    o.this.f10420rg.qw(this.f10423ad);
                }
            }

            public qw() {
            }

            public void onScanCompleted(String str, Uri uri) {
                if (o.this.f10420rg != null) {
                    o.this.f10421th.post(new C0332qw(uri));
                }
            }
        }

        public o(GPUImageView gPUImageView, String str, String str2, OnPictureSavedListener onPictureSavedListener) {
            this(str, str2, 0, 0, onPictureSavedListener);
        }

        /* renamed from: de */
        public Void doInBackground(Void... voidArr) {
            try {
                fe(this.qw, this.f10417ad, this.f10418de != 0 ? GPUImageView.this.capture(this.f10418de, this.f10419fe) : GPUImageView.this.capture());
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        public final void fe(String str, String str2, Bitmap bitmap) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(externalStoragePublicDirectory, str + "/" + str2);
            try {
                file.getParentFile().mkdirs();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
                MediaScannerConnection.scanFile(GPUImageView.this.getContext(), new String[]{file.toString()}, (String[]) null, new qw());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public o(String str, String str2, int i2, int i3, OnPictureSavedListener onPictureSavedListener) {
            this.qw = str;
            this.f10417ad = str2;
            this.f10418de = i2;
            this.f10419fe = i3;
            this.f10420rg = onPictureSavedListener;
            this.f10421th = new Handler();
        }
    }

    public static class pf {

        /* renamed from: ad  reason: collision with root package name */
        public int f10425ad;
        public int qw;

        public pf(int i2, int i3) {
            this.qw = i2;
            this.f10425ad = i3;
        }
    }

    public class qw implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Semaphore f10426ad;

        public qw(Semaphore semaphore) {
            this.f10426ad = semaphore;
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 16) {
                GPUImageView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                GPUImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            this.f10426ad.release();
        }
    }

    public class rg implements Runnable {
        public rg() {
        }

        public void run() {
            GPUImageView.this.removeViewAt(1);
        }
    }

    public class th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Bitmap f10429ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Semaphore f10430th;

        public th(Bitmap bitmap, Semaphore semaphore) {
            this.f10429ad = bitmap;
            this.f10430th = semaphore;
        }

        public void run() {
            GPUImageNativeLibrary.adjustBitmap(this.f10429ad);
            this.f10430th.release();
        }
    }

    public class uk extends GLTextureView {
        public uk(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onMeasure(int i2, int i3) {
            pf pfVar = GPUImageView.this.forceSize;
            if (pfVar != null) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(pfVar.qw, 1073741824), View.MeasureSpec.makeMeasureSpec(GPUImageView.this.forceSize.f10425ad, 1073741824));
            } else {
                super.onMeasure(i2, i3);
            }
        }
    }

    public class yj extends GLSurfaceView {
        public yj(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onMeasure(int i2, int i3) {
            pf pfVar = GPUImageView.this.forceSize;
            if (pfVar != null) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(pfVar.qw, 1073741824), View.MeasureSpec.makeMeasureSpec(GPUImageView.this.forceSize.f10425ad, 1073741824));
            } else {
                super.onMeasure(i2, i3);
            }
        }
    }

    public GPUImageView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.GPUImageView, 0, 0);
            try {
                this.surfaceType = obtainStyledAttributes.getInt(1, this.surfaceType);
                this.isShowLoading = obtainStyledAttributes.getBoolean(0, this.isShowLoading);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.gpuImage = new GPUImage(context);
        if (this.surfaceType == 1) {
            uk ukVar = new uk(context, attributeSet);
            this.surfaceView = ukVar;
            this.gpuImage.nn(ukVar);
        } else {
            yj yjVar = new yj(context, attributeSet);
            this.surfaceView = yjVar;
            this.gpuImage.ddd(yjVar);
        }
        addView(this.surfaceView);
    }

    public Bitmap capture(int i2, int i3) throws InterruptedException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.forceSize = new pf(i2, i3);
            Semaphore semaphore = new Semaphore(0);
            getViewTreeObserver().addOnGlobalLayoutListener(new qw(semaphore));
            post(new ad());
            semaphore.acquire();
            this.gpuImage.ggg(new de(semaphore));
            requestRender();
            semaphore.acquire();
            Bitmap capture = capture();
            this.forceSize = null;
            post(new fe());
            requestRender();
            if (this.isShowLoading) {
                postDelayed(new rg(), 300);
            }
            return capture;
        }
        throw new IllegalStateException("Do not call this method from the UI thread!");
    }

    public yj.qw.qw.qw.qw.de.qw getFilter() {
        return this.filter;
    }

    public GPUImage getGPUImage() {
        return this.gpuImage;
    }

    public void onMeasure(int i2, int i3) {
        if (this.ratio != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            float f = (float) size;
            float f2 = this.ratio;
            float f3 = (float) size2;
            if (f / f2 < f3) {
                size2 = Math.round(f / f2);
            } else {
                size = Math.round(f3 * f2);
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void onPause() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).onResume();
        }
    }

    public void requestRender() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).requestRender();
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).requestRender();
        }
    }

    public void saveToPictures(String str, String str2, OnPictureSavedListener onPictureSavedListener) {
        new o(this, str, str2, onPictureSavedListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void setBackgroundColor(float f, float f2, float f3) {
        this.gpuImage.vvv(f, f2, f3);
    }

    public void setFilter(yj.qw.qw.qw.qw.de.qw qwVar) {
        this.filter = qwVar;
        this.gpuImage.xxx(qwVar);
        requestRender();
    }

    public void setImage(Bitmap bitmap) {
        this.gpuImage.mmm(bitmap);
    }

    public void setRatio(float f) {
        this.ratio = f;
        this.surfaceView.requestLayout();
        this.gpuImage.i();
    }

    public void setRenderMode(int i2) {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).setRenderMode(i2);
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).setRenderMode(i2);
        }
    }

    public void setRotation(Rotation rotation) {
        this.gpuImage.eee(rotation);
        requestRender();
    }

    public void setScaleType(GPUImage.ScaleType scaleType) {
        this.gpuImage.rrr(scaleType);
    }

    @Deprecated
    public void setUpCamera(Camera camera) {
        this.gpuImage.tt(camera);
    }

    public void updatePreviewFrame(byte[] bArr, int i2, int i3) {
        this.gpuImage.c(bArr, i2, i3);
    }

    public void saveToPictures(String str, String str2, int i2, int i3, OnPictureSavedListener onPictureSavedListener) {
        new o(str, str2, i2, i3, onPictureSavedListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void setImage(Uri uri) {
        this.gpuImage.aaa(uri);
    }

    @Deprecated
    public void setUpCamera(Camera camera, int i2, boolean z, boolean z2) {
        this.gpuImage.a(camera, i2, z, z2);
    }

    public void setImage(File file) {
        this.gpuImage.qqq(file);
    }

    public GPUImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public Bitmap capture() throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        Bitmap createBitmap = Bitmap.createBitmap(this.surfaceView.getMeasuredWidth(), this.surfaceView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.gpuImage.ggg(new th(createBitmap, semaphore));
        requestRender();
        semaphore.acquire();
        return createBitmap;
    }
}
