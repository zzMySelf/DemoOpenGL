package fe.mmm.qw.tt.rg.qw;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tera.scan.scanner.ui.camera.ICameraControl;
import com.tera.scan.scanner.ui.camera.PermissionCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class qw implements ICameraControl {

    /* renamed from: ad  reason: collision with root package name */
    public int f8491ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public int f8492de;

    /* renamed from: fe  reason: collision with root package name */
    public AtomicBoolean f8493fe = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public Rect f8494i = new Rect();

    /* renamed from: if  reason: not valid java name */
    public TextureView.SurfaceTextureListener f348if = new ad();

    /* renamed from: o  reason: collision with root package name */
    public fe f8495o;

    /* renamed from: pf  reason: collision with root package name */
    public View f8496pf;
    public int qw = 0;

    /* renamed from: rg  reason: collision with root package name */
    public Context f8497rg;

    /* renamed from: switch  reason: not valid java name */
    public Comparator<Camera.Size> f349switch = new de(this);

    /* renamed from: th  reason: collision with root package name */
    public Camera f8498th;

    /* renamed from: uk  reason: collision with root package name */
    public PermissionCallback f8499uk;

    /* renamed from: yj  reason: collision with root package name */
    public Camera.Parameters f8500yj;

    public class ad implements TextureView.SurfaceTextureListener {
        public ad() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            try {
                if (qw.this.f8498th == null) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    for (int i4 = 0; i4 < Camera.getNumberOfCameras(); i4++) {
                        Camera.getCameraInfo(i4, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            int unused = qw.this.f8491ad = i4;
                        }
                    }
                    Camera unused2 = qw.this.f8498th = Camera.open(qw.this.f8491ad);
                }
                if (qw.this.f8500yj == null) {
                    Camera.Parameters unused3 = qw.this.f8500yj = qw.this.f8498th.getParameters();
                    qw.this.f8500yj.setFocusMode("continuous-picture");
                }
                qw.this.qqq(qw.this.f8495o.getWidth(), qw.this.f8495o.getHeight());
                qw.this.f8498th.setPreviewTexture(surfaceTexture);
                qw.this.tt(false);
            } catch (IOException e) {
                fe.mmm.qw.i.qw.th("Camera1Control", e.getMessage(), e);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            qw qwVar = qw.this;
            qwVar.qqq(qwVar.f8495o.getWidth(), qw.this.f8495o.getHeight());
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class de implements Comparator<Camera.Size> {
        public de(qw qwVar) {
        }

        /* renamed from: qw */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((((long) size.width) * ((long) size.height)) - (((long) size2.width) * ((long) size2.height)));
        }
    }

    public class fe extends FrameLayout {

        /* renamed from: ad  reason: collision with root package name */
        public TextureView f8502ad;

        /* renamed from: th  reason: collision with root package name */
        public float f8503th = 0.75f;

        public fe(Context context) {
            super(context);
        }

        public final void de(int i2, int i3) {
            if (i2 < i3) {
                i3 = (int) (((float) i2) * this.f8503th);
            } else {
                i2 = (int) (((float) i3) * this.f8503th);
            }
            int width = (getWidth() - i2) / 2;
            int height = (getHeight() - i3) / 2;
            qw.this.f8494i.left = width;
            qw.this.f8494i.top = height;
            qw.this.f8494i.right = width + i2;
            qw.this.f8494i.bottom = height + i3;
        }

        public void fe(float f) {
            this.f8503th = f;
            requestLayout();
            de(getWidth(), getHeight());
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            this.f8502ad.layout(qw.this.f8494i.left, qw.this.f8494i.top, qw.this.f8494i.right, qw.this.f8494i.bottom);
        }

        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            de(i2, i3);
        }

        public void rg(TextureView textureView) {
            this.f8502ad = textureView;
            removeAllViews();
            addView(textureView);
        }
    }

    /* renamed from: fe.mmm.qw.tt.rg.qw.qw$qw  reason: collision with other inner class name */
    public class C0296qw implements Camera.AutoFocusCallback {
        public final /* synthetic */ ICameraControl.OnTakePictureCallback qw;

        /* renamed from: fe.mmm.qw.tt.rg.qw.qw$qw$qw  reason: collision with other inner class name */
        public class C0297qw implements Camera.PictureCallback {
            public C0297qw() {
            }

            public void onPictureTaken(byte[] bArr, Camera camera) {
                camera.startPreview();
                qw.this.f8493fe.set(false);
                ICameraControl.OnTakePictureCallback onTakePictureCallback = C0296qw.this.qw;
                if (onTakePictureCallback != null) {
                    onTakePictureCallback.qw(bArr);
                }
            }
        }

        public C0296qw(ICameraControl.OnTakePictureCallback onTakePictureCallback) {
            this.qw = onTakePictureCallback;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            camera.cancelAutoFocus();
            try {
                camera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, new C0297qw());
            } catch (RuntimeException e) {
                fe.mmm.qw.i.qw.th("Camera1Control", e.getMessage(), e);
                camera.startPreview();
                qw.this.f8493fe.set(false);
            }
        }
    }

    public qw(Context context) {
        this.f8497rg = context;
        this.f8495o = new fe(context);
        eee();
    }

    public final void a(int i2) {
        if (i2 == 0) {
            this.f8500yj.setFlashMode("off");
        } else if (i2 == 1) {
            this.f8500yj.setFlashMode("torch");
        } else if (i2 != 2) {
            this.f8500yj.setFlashMode("auto");
        } else {
            this.f8500yj.setFlashMode("auto");
        }
        this.f8498th.setParameters(this.f8500yj);
    }

    public final int aaa() {
        int i2 = this.qw;
        if (i2 != 90) {
            return i2 != 270 ? 90 : 180;
        }
        return 0;
    }

    public void ad(int i2) {
        if (this.f8492de != i2) {
            this.f8492de = i2;
            a(i2);
        }
    }

    public void de(PermissionCallback permissionCallback) {
        this.f8499uk = permissionCallback;
    }

    public final void eee() {
        rrr();
    }

    public View fe() {
        return this.f8496pf;
    }

    public Rect i() {
        return this.f8494i;
    }

    public final Camera.Size mmm(List<Camera.Size> list) {
        int i2;
        int i3;
        int width = this.f8495o.f8502ad.getWidth();
        int height = this.f8495o.f8502ad.getHeight();
        Camera.Size size = list.get(0);
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : list) {
            int i4 = next.width;
            if (i4 < width || (i3 = next.height) < height || i4 * height != i3 * width) {
                int i5 = next.height;
                if (i5 >= width && (i2 = next.width) >= height && i2 * width == i5 * height) {
                    arrayList.add(next);
                }
            } else {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return (Camera.Size) Collections.min(arrayList, this.f349switch);
        }
        float f = ((float) height) / ((float) width);
        float f2 = Float.MAX_VALUE;
        for (Camera.Size next2 : list) {
            float f3 = ((float) next2.width) / ((float) next2.height);
            float f4 = f3 - f;
            if (Math.abs(f4) < f2) {
                fe.mmm.qw.i.qw.ad("Camera1Control", "接近的尺寸 " + next2.width + " * " + next2.height + " = " + f3);
                f2 = Math.abs(f4);
            } else if (Math.abs(f4) == f2) {
                if (next2.height * next2.width <= size.width * size.height) {
                }
            }
            size = next2;
        }
        return size;
    }

    public void pause() {
        Camera camera = this.f8498th;
        if (camera != null) {
            camera.stopPreview();
        }
        ad(0);
    }

    public final void qqq(int i2, int i3) {
        Camera camera;
        if (this.f8500yj != null && (camera = this.f8498th) != null && i2 > 0) {
            Camera.Size mmm = mmm(camera.getParameters().getSupportedPreviewSizes());
            this.f8500yj.setPreviewSize(mmm.width, mmm.height);
            this.f8495o.fe((((float) mmm.width) * 1.0f) / ((float) mmm.height));
            this.f8498th.setDisplayOrientation(aaa());
            this.f8498th.stopPreview();
            try {
                this.f8498th.setParameters(this.f8500yj);
            } catch (RuntimeException e) {
                fe.mmm.qw.i.qw.th("Camera1Control", e.getMessage(), e);
            }
            this.f8498th.startPreview();
        }
    }

    public void qw() {
        tt(true);
    }

    public void rg(int i2) {
        this.qw = i2;
        this.f8495o.requestLayout();
    }

    public final void rrr() {
        TextureView textureView = new TextureView(this.f8497rg);
        TextureView unused = this.f8495o.f8502ad = textureView;
        this.f8495o.rg(textureView);
        this.f8496pf = this.f8495o;
        textureView.setSurfaceTextureListener(this.f348if);
    }

    public void start() {
    }

    public void stop() {
        Camera camera = this.f8498th;
        if (camera != null) {
            camera.stopPreview();
            this.f8498th.release();
            this.f8498th = null;
        }
    }

    public void th() {
        this.f8493fe.set(false);
        if (this.f8498th == null) {
            eee();
            return;
        }
        this.f8495o.f8502ad.setSurfaceTextureListener(this.f348if);
        if (this.f8495o.f8502ad.isAvailable()) {
            this.f8498th.startPreview();
        }
    }

    public final void tt(boolean z) {
        PermissionCallback permissionCallback;
        if (ContextCompat.checkSelfPermission(this.f8497rg, "android.permission.CAMERA") == 0) {
            this.f8498th.startPreview();
        } else if (z && (permissionCallback = this.f8499uk) != null) {
            permissionCallback.qw();
        }
    }

    public int uk() {
        return this.f8492de;
    }

    public void yj(ICameraControl.OnTakePictureCallback onTakePictureCallback) {
        if (!this.f8493fe.get()) {
            int i2 = this.qw;
            if (i2 == 0) {
                this.f8500yj.setRotation(90);
            } else if (i2 == 90) {
                this.f8500yj.setRotation(0);
            } else if (i2 == 270) {
                this.f8500yj.setRotation(180);
            }
            Camera.Size mmm = mmm(this.f8498th.getParameters().getSupportedPictureSizes());
            this.f8500yj.setPictureSize(mmm.width, mmm.height);
            this.f8498th.setParameters(this.f8500yj);
            this.f8493fe.set(true);
            this.f8498th.autoFocus(new C0296qw(onTakePictureCallback));
        }
    }
}
