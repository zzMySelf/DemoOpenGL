package jp.co.cyberagent.android.gpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserModel;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import jp.co.cyberagent.android.gpuimage.util.Rotation;

public class GPUImage {

    /* renamed from: ad  reason: collision with root package name */
    public final yj.qw.qw.qw.qw.qw f10396ad;

    /* renamed from: de  reason: collision with root package name */
    public int f10397de = 0;

    /* renamed from: fe  reason: collision with root package name */
    public GLSurfaceView f10398fe;

    /* renamed from: i  reason: collision with root package name */
    public int f10399i;

    /* renamed from: o  reason: collision with root package name */
    public int f10400o;
    public final Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public GLTextureView f10401rg;

    /* renamed from: th  reason: collision with root package name */
    public yj.qw.qw.qw.qw.de.qw f10402th;

    /* renamed from: uk  reason: collision with root package name */
    public ScaleType f10403uk = ScaleType.CENTER_CROP;

    /* renamed from: yj  reason: collision with root package name */
    public Bitmap f10404yj;

    public interface OnPictureSavedListener {
    }

    public interface ResponseListener<T> {
    }

    public enum ScaleType {
        CENTER_INSIDE,
        CENTER_CROP
    }

    public class ad extends de {

        /* renamed from: rg  reason: collision with root package name */
        public final File f10405rg;

        public ad(GPUImage gPUImage, GPUImage gPUImage2, File file) {
            super(gPUImage2);
            this.f10405rg = file;
        }

        public Bitmap ad(BitmapFactory.Options options) {
            return BitmapFactory.decodeFile(this.f10405rg.getAbsolutePath(), options);
        }

        public int fe() throws IOException {
            int attributeInt = new ExifInterface(this.f10405rg.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        }
    }

    public abstract class de extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: ad  reason: collision with root package name */
        public int f10406ad;

        /* renamed from: de  reason: collision with root package name */
        public int f10407de;
        public final GPUImage qw;

        public de(GPUImage gPUImage) {
            this.qw = gPUImage;
        }

        public abstract Bitmap ad(BitmapFactory.Options options);

        /* renamed from: de */
        public Bitmap doInBackground(Void... voidArr) {
            if (GPUImage.this.f10396ad != null && GPUImage.this.f10396ad.ddd() == 0) {
                try {
                    synchronized (GPUImage.this.f10396ad.f11112th) {
                        GPUImage.this.f10396ad.f11112th.wait(3000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.f10406ad = GPUImage.this.when();
            this.f10407de = GPUImage.this.m1150switch();
            return th();
        }

        public abstract int fe() throws IOException;

        public final Bitmap i(Bitmap bitmap) {
            int[] rg2 = rg(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, rg2[0], rg2[1], true);
            if (createScaledBitmap != bitmap) {
                bitmap.recycle();
                System.gc();
                bitmap = createScaledBitmap;
            }
            if (GPUImage.this.f10403uk != ScaleType.CENTER_CROP) {
                return bitmap;
            }
            int i2 = rg2[0] - this.f10406ad;
            int i3 = rg2[1] - this.f10407de;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2 / 2, i3 / 2, rg2[0] - i2, rg2[1] - i3);
            if (createBitmap == bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }

        public final boolean qw(boolean z, boolean z2) {
            return GPUImage.this.f10403uk == ScaleType.CENTER_CROP ? z && z2 : z || z2;
        }

        public final int[] rg(int i2, int i3) {
            float f;
            float f2;
            float f3 = (float) i2;
            float f4 = f3 / ((float) this.f10406ad);
            float f5 = (float) i3;
            float f6 = f5 / ((float) this.f10407de);
            if (GPUImage.this.f10403uk != ScaleType.CENTER_CROP ? f4 < f6 : f4 > f6) {
                f2 = (float) this.f10407de;
                f = (f2 / f5) * f3;
            } else {
                float f7 = (float) this.f10406ad;
                float f8 = (f7 / f3) * f5;
                f = f7;
                f2 = f8;
            }
            int unused = GPUImage.this.f10399i = Math.round(f);
            int unused2 = GPUImage.this.f10400o = Math.round(f2);
            return new int[]{Math.round(f), Math.round(f2)};
        }

        public final Bitmap th() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            ad(options);
            int i2 = 1;
            while (true) {
                boolean z = false;
                boolean z2 = options.outWidth / i2 > this.f10406ad;
                if (options.outHeight / i2 > this.f10407de) {
                    z = true;
                }
                if (!qw(z2, z)) {
                    break;
                }
                i2++;
            }
            int i3 = i2 - 1;
            if (i3 < 1) {
                i3 = 1;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i3;
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            options2.inPurgeable = true;
            options2.inTempStorage = new byte[32768];
            Bitmap ad2 = ad(options2);
            if (ad2 == null) {
                return null;
            }
            return i(uk(ad2));
        }

        public final Bitmap uk(Bitmap bitmap) {
            Bitmap bitmap2;
            IOException e;
            if (bitmap == null) {
                return null;
            }
            try {
                int fe2 = fe();
                if (fe2 == 0) {
                    return bitmap;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate((float) fe2);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                try {
                    bitmap.recycle();
                } catch (IOException e2) {
                    e = e2;
                }
                return bitmap2;
            } catch (IOException e3) {
                IOException iOException = e3;
                bitmap2 = bitmap;
                e = iOException;
                e.printStackTrace();
                return bitmap2;
            }
        }

        /* renamed from: yj */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            this.qw.i();
            this.qw.mmm(bitmap);
        }
    }

    public class fe extends de {

        /* renamed from: rg  reason: collision with root package name */
        public final Uri f10409rg;

        public fe(GPUImage gPUImage, Uri uri) {
            super(gPUImage);
            this.f10409rg = uri;
        }

        public Bitmap ad(BitmapFactory.Options options) {
            InputStream inputStream;
            try {
                if (!this.f10409rg.getScheme().startsWith("http")) {
                    if (!this.f10409rg.getScheme().startsWith("https")) {
                        if (this.f10409rg.getPath().startsWith("/android_asset/")) {
                            inputStream = GPUImage.this.qw.getAssets().open(this.f10409rg.getPath().substring(15));
                        } else {
                            inputStream = GPUImage.this.qw.getContentResolver().openInputStream(this.f10409rg);
                        }
                        return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    }
                }
                inputStream = new URL(this.f10409rg.toString()).openStream();
                return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int fe() throws IOException {
            Cursor query = GPUImage.this.qw.getContentResolver().query(this.f10409rg, new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
            if (query == null || query.getCount() != 1) {
                return 0;
            }
            query.moveToFirst();
            int i2 = query.getInt(0);
            query.close();
            return i2;
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            synchronized (GPUImage.this.f10402th) {
                GPUImage.this.f10402th.qw();
                GPUImage.this.f10402th.notify();
            }
        }
    }

    public GPUImage(Context context) {
        if (b(context)) {
            this.qw = context;
            this.f10402th = new yj.qw.qw.qw.qw.de.qw();
            this.f10396ad = new yj.qw.qw.qw.qw.qw(this.f10402th);
            return;
        }
        throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
    }

    @Deprecated
    public void a(Camera camera, int i2, boolean z, boolean z2) {
        int i3 = this.f10397de;
        if (i3 == 0) {
            this.f10398fe.setRenderMode(1);
        } else if (i3 == 1) {
            this.f10401rg.setRenderMode(1);
        }
        this.f10396ad.g(camera);
        Rotation rotation = Rotation.NORMAL;
        if (i2 == 90) {
            rotation = Rotation.ROTATION_90;
        } else if (i2 == 180) {
            rotation = Rotation.ROTATION_180;
        } else if (i2 == 270) {
            rotation = Rotation.ROTATION_270;
        }
        this.f10396ad.e(rotation, z, z2);
    }

    public void aaa(Uri uri) {
        new fe(this, uri).execute(new Void[0]);
    }

    public final boolean b(Context context) {
        return ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void c(byte[] bArr, int i2, int i3) {
        this.f10396ad.aaa(bArr, i2, i3);
    }

    public void ddd(GLSurfaceView gLSurfaceView) {
        this.f10397de = 0;
        this.f10398fe = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.f10398fe.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.f10398fe.getHolder().setFormat(1);
        this.f10398fe.setRenderer(this.f10396ad);
        this.f10398fe.setRenderMode(0);
        this.f10398fe.requestRender();
    }

    public void eee(Rotation rotation) {
        this.f10396ad.c(rotation);
    }

    public void ggg(Runnable runnable) {
        this.f10396ad.rrr(runnable);
    }

    public void i() {
        this.f10396ad.vvv();
        this.f10404yj = null;
        ppp();
    }

    /* renamed from: if  reason: not valid java name */
    public Bitmap m1149if(Bitmap bitmap, boolean z) {
        if (!(this.f10398fe == null && this.f10401rg == null)) {
            this.f10396ad.vvv();
            this.f10396ad.eee(new qw());
            synchronized (this.f10402th) {
                ppp();
                try {
                    this.f10402th.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        yj.qw.qw.qw.qw.qw qwVar = new yj.qw.qw.qw.qw.qw(this.f10402th);
        qwVar.d(Rotation.NORMAL, this.f10396ad.nn(), this.f10396ad.mmm());
        qwVar.f(this.f10403uk);
        yj.qw.qw.qw.qw.ad adVar = new yj.qw.qw.qw.qw.ad(bitmap.getWidth(), bitmap.getHeight());
        adVar.rg(qwVar);
        qwVar.b(bitmap, z);
        Bitmap fe2 = adVar.fe();
        this.f10402th.qw();
        qwVar.vvv();
        adVar.de();
        this.f10396ad.a(this.f10402th);
        Bitmap bitmap2 = this.f10404yj;
        if (bitmap2 != null) {
            this.f10396ad.b(bitmap2, false);
        }
        ppp();
        return fe2;
    }

    public void mmm(Bitmap bitmap) {
        this.f10404yj = bitmap;
        this.f10396ad.b(bitmap, false);
        ppp();
    }

    public void nn(GLTextureView gLTextureView) {
        this.f10397de = 1;
        this.f10401rg = gLTextureView;
        gLTextureView.setEGLContextClientVersion(2);
        this.f10401rg.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.f10401rg.setOpaque(false);
        this.f10401rg.setRenderer(this.f10396ad);
        this.f10401rg.setRenderMode(0);
        this.f10401rg.requestRender();
    }

    public Bitmap o() {
        return pf(this.f10404yj);
    }

    public Bitmap pf(Bitmap bitmap) {
        return m1149if(bitmap, false);
    }

    public void ppp() {
        GLTextureView gLTextureView;
        int i2 = this.f10397de;
        if (i2 == 0) {
            GLSurfaceView gLSurfaceView = this.f10398fe;
            if (gLSurfaceView != null) {
                gLSurfaceView.requestRender();
            }
        } else if (i2 == 1 && (gLTextureView = this.f10401rg) != null) {
            gLTextureView.requestRender();
        }
    }

    public void qqq(File file) {
        new ad(this, this, file).execute(new Void[0]);
    }

    public void rrr(ScaleType scaleType) {
        this.f10403uk = scaleType;
        this.f10396ad.f(scaleType);
        this.f10396ad.vvv();
        this.f10404yj = null;
        ppp();
    }

    /* renamed from: switch  reason: not valid java name */
    public final int m1150switch() {
        yj.qw.qw.qw.qw.qw qwVar = this.f10396ad;
        if (qwVar != null && qwVar.xxx() != 0) {
            return this.f10396ad.xxx();
        }
        Bitmap bitmap = this.f10404yj;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return ((WindowManager) this.qw.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    @Deprecated
    public void tt(Camera camera) {
        a(camera, 0, false, false);
    }

    public void vvv(float f, float f2, float f3) {
        this.f10396ad.tt(f, f2, f3);
    }

    public final int when() {
        yj.qw.qw.qw.qw.qw qwVar = this.f10396ad;
        if (qwVar != null && qwVar.ddd() != 0) {
            return this.f10396ad.ddd();
        }
        Bitmap bitmap = this.f10404yj;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return ((WindowManager) this.qw.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public void xxx(yj.qw.qw.qw.qw.de.qw qwVar) {
        this.f10402th = qwVar;
        this.f10396ad.a(qwVar);
        ppp();
    }
}
