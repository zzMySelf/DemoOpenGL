package fe.mmm.qw.tt.rg.qw;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.display.DisplayManager;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.content.ContextCompat;
import com.tera.scan.scanner.ui.camera.ICameraControl;
import com.tera.scan.scanner.ui.camera.PermissionCallback;
import com.tera.scan.ui.widget.RotateProgress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
public class ad implements ICameraControl {
    public static final SparseIntArray rrr;
    public final ImageReader.OnImageAvailableListener aaa = new fe();

    /* renamed from: ad  reason: collision with root package name */
    public int f8479ad = 0;
    public int ddd;

    /* renamed from: de  reason: collision with root package name */
    public int f8480de = 0;
    public Comparator<Size> eee = new th(this);

    /* renamed from: fe  reason: collision with root package name */
    public Context f8481fe;
    public CaptureRequest.Builder ggg;

    /* renamed from: i  reason: collision with root package name */
    public Size f8482i;

    /* renamed from: if  reason: not valid java name */
    public Handler f346if;
    public final CameraDevice.StateCallback mmm = new C0295ad();
    public final TextureView.SurfaceTextureListener nn = new qw();

    /* renamed from: o  reason: collision with root package name */
    public Rect f8483o = new Rect();

    /* renamed from: pf  reason: collision with root package name */
    public HandlerThread f8484pf;
    public CameraDevice ppp;
    public CameraCaptureSession.CaptureCallback qqq = new rg();
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public ICameraControl.OnTakePictureCallback f8485rg;

    /* renamed from: switch  reason: not valid java name */
    public ImageReader f347switch;

    /* renamed from: th  reason: collision with root package name */
    public PermissionCallback f8486th;

    /* renamed from: uk  reason: collision with root package name */
    public TextureView f8487uk;
    public CaptureRequest vvv;
    public CameraCaptureSession when;
    public Semaphore xxx = new Semaphore(1);

    /* renamed from: yj  reason: collision with root package name */
    public String f8488yj;

    /* renamed from: fe.mmm.qw.tt.rg.qw.ad$ad  reason: collision with other inner class name */
    public class C0295ad extends CameraDevice.StateCallback {
        public C0295ad() {
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            ad.this.xxx.release();
            cameraDevice.close();
            CameraDevice unused = ad.this.ppp = null;
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            ad.this.xxx.release();
            cameraDevice.close();
            CameraDevice unused = ad.this.ppp = null;
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            ad.this.xxx.release();
            CameraDevice unused = ad.this.ppp = cameraDevice;
            ad.this.g();
        }
    }

    public class de extends CameraCaptureSession.StateCallback {
        public de() {
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            if (ad.this.ppp != null) {
                CameraCaptureSession unused = ad.this.when = cameraCaptureSession;
                try {
                    ad.this.ggg.set(CaptureRequest.CONTROL_AF_MODE, 4);
                    CaptureRequest unused2 = ad.this.vvv = ad.this.ggg.build();
                    ad.this.when.setRepeatingRequest(ad.this.vvv, ad.this.qqq, ad.this.f346if);
                } catch (CameraAccessException e) {
                    fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
                } catch (IllegalStateException e2) {
                    fe.mmm.qw.i.qw.th("Camera2Control", e2.getMessage(), e2);
                } catch (IllegalArgumentException e3) {
                    fe.mmm.qw.i.qw.th("Camera2Control", e3.getMessage(), e3);
                }
            }
        }
    }

    public class fe implements ImageReader.OnImageAvailableListener {
        public fe() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            if (ad.this.f8485rg != null) {
                Image acquireNextImage = imageReader.acquireNextImage();
                ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                byte[] bArr = new byte[buffer.remaining()];
                buffer.get(bArr);
                acquireNextImage.close();
                ad.this.f8485rg.qw(bArr);
            }
        }
    }

    public class qw implements TextureView.SurfaceTextureListener {
        public qw() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ad.this.l(i2, i3);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ad.this.stop();
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            ad.this.f(i2, i3);
            ad.this.f8483o.left = 0;
            ad.this.f8483o.top = 0;
            ad.this.f8483o.right = i2;
            ad.this.f8483o.bottom = i3;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class rg extends CameraCaptureSession.CaptureCallback {
        public rg() {
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            qw(totalCaptureResult);
        }

        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            qw(captureResult);
        }

        public final void qw(CaptureResult captureResult) {
            int when = ad.this.f8480de;
            if (when == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    ad.this.d();
                    return;
                }
                int intValue = num.intValue();
                if (intValue == 2 || intValue == 4 || intValue == 5) {
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num2 == null || num2.intValue() == 2) {
                        ad.this.d();
                    } else {
                        ad.this.n();
                    }
                } else {
                    ad.this.d();
                }
            } else if (when == 2) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4) {
                    int unused = ad.this.f8480de = 3;
                } else if (num3.intValue() == 2) {
                    ad.this.d();
                }
            } else if (when == 3) {
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 == null || num4.intValue() != 5) {
                    ad.this.d();
                }
            }
        }
    }

    public class th implements Comparator<Size> {
        public th(ad adVar) {
        }

        /* renamed from: qw */
        public int compare(Size size, Size size2) {
            return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        }
    }

    public class yj extends CameraCaptureSession.CaptureCallback {
        public yj() {
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            ad.this.s();
        }

        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        rrr = sparseIntArray;
        sparseIntArray.append(0, 90);
        rrr.append(1, 0);
        rrr.append(2, 270);
        rrr.append(3, 180);
    }

    public ad(Context context) {
        this.f8481fe = context;
        this.f8487uk = new TextureView(context);
    }

    public void ad(int i2) {
        if (this.qw != i2) {
            this.qw = i2;
            try {
                this.ggg.set(CaptureRequest.CONTROL_AF_MODE, 4);
                t(i2, this.ggg);
                CaptureRequest build = this.ggg.build();
                this.vvv = build;
                this.when.setRepeatingRequest(build, this.qqq, this.f346if);
            } catch (Exception e) {
                fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
            }
        }
    }

    public final void d() {
        try {
            if (this.f8481fe == null) {
                return;
            }
            if (this.ppp != null) {
                CaptureRequest.Builder createCaptureRequest = this.ppp.createCaptureRequest(2);
                createCaptureRequest.addTarget(this.f347switch.getSurface());
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
                createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(j(this.f8479ad)));
                t(this.qw, createCaptureRequest);
                yj yjVar = new yj();
                this.when.stopRepeating();
                this.when.capture(createCaptureRequest.build(), yjVar, this.f346if);
                this.f8480de = 4;
            }
        } catch (CameraAccessException e) {
            fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
        }
    }

    public void de(PermissionCallback permissionCallback) {
        this.f8486th = permissionCallback;
    }

    public final void e() {
        try {
            this.xxx.acquire();
            if (this.when != null) {
                this.when.close();
                this.when = null;
            }
            if (this.ppp != null) {
                this.ppp.close();
                this.ppp = null;
            }
            if (this.f347switch != null) {
                this.f347switch.close();
                this.f347switch = null;
            }
            this.xxx.release();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
        } catch (Throwable th2) {
            this.xxx.release();
            throw th2;
        }
    }

    public final void f(int i2, int i3) {
        if (this.f8487uk != null && this.f8482i != null && this.f8481fe != null) {
            int i4 = this.f8479ad;
            Matrix matrix = new Matrix();
            float f = (float) i2;
            float f2 = (float) i3;
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            RectF rectF2 = new RectF(0.0f, 0.0f, (float) this.f8482i.getHeight(), (float) this.f8482i.getWidth());
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            fe.mmm.qw.i.qw.ad("Camera2Control", "rotation = " + i4);
            if (1 == i4 || 3 == i4) {
                rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                float max = Math.max(f2 / ((float) this.f8482i.getHeight()), f / ((float) this.f8482i.getWidth()));
                matrix.postScale(max, max, centerX, centerY);
                matrix.postRotate((float) ((i4 - 2) * 90), centerX, centerY);
                fe.mmm.qw.i.qw.ad("Camera2Control", "scale = " + max + ", viewheight" + i3 + ", viewwidth = " + i2 + ", previewwidth = " + this.f8482i.getWidth() + "previewheight = " + this.f8482i.getHeight());
            } else if (2 == i4) {
                matrix.postRotate(180.0f, centerX, centerY);
                fe.mmm.qw.i.qw.ad("Camera2Control", "centerx = " + centerX + ", centery = " + centerY);
            }
            this.f8487uk.setTransform(matrix);
        }
    }

    public View fe() {
        return this.f8487uk;
    }

    public final void g() {
        try {
            SurfaceTexture surfaceTexture = this.f8487uk.getSurfaceTexture();
            if (((DisplayManager) this.f8481fe.getSystemService("display")).getDisplays().length == 2) {
                surfaceTexture.setDefaultBufferSize(1920, 1440);
            } else {
                surfaceTexture.setDefaultBufferSize(this.f8482i.getWidth(), this.f8482i.getHeight());
            }
            Surface surface = new Surface(surfaceTexture);
            CaptureRequest.Builder createCaptureRequest = this.ppp.createCaptureRequest(1);
            this.ggg = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            t(this.qw, this.ggg);
            this.ppp.createCaptureSession(Arrays.asList(new Surface[]{surface, this.f347switch.getSurface()}), new de(), (Handler) null);
        } catch (CameraAccessException e) {
            fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
        }
    }

    public final Size h(Size[] sizeArr, int i2, int i3, int i4, int i5, Size size) {
        if (sizeArr != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int width = size.getWidth();
            int height = size.getHeight();
            for (Size size2 : sizeArr) {
                if (size2.getWidth() <= i4 && size2.getHeight() <= i5 && size2.getHeight() == (size2.getWidth() * height) / width) {
                    if (size2.getWidth() < i2 || size2.getHeight() < i3) {
                        arrayList2.add(size2);
                    } else {
                        arrayList.add(size2);
                    }
                }
            }
            if (arrayList.size() > 0) {
                return (Size) Collections.min(arrayList, this.eee);
            }
            if (arrayList2.size() > 0) {
                return (Size) Collections.max(arrayList2, this.eee);
            }
            float f = ((float) height) / ((float) width);
            float f2 = Float.MAX_VALUE;
            Size size3 = new Size(0, 0);
            for (Size size4 : sizeArr) {
                float width2 = ((float) size4.getWidth()) / ((float) size4.getHeight());
                float f3 = width2 - f;
                if (Math.abs(f3) < f2) {
                    fe.mmm.qw.i.qw.ad("Camera2Control", "接近的尺寸 " + size4.getWidth() + " * " + size4.getHeight() + " = " + width2);
                    f2 = Math.abs(f3);
                } else {
                    if (Math.abs(f3) == f2) {
                        if (size4.getHeight() * size4.getWidth() <= size3.getWidth() * size3.getHeight()) {
                        }
                    }
                }
                size3 = size4;
            }
            if (size3.getHeight() * size3.getWidth() != 0) {
                return size3;
            }
            return sizeArr[0];
        }
        throw new NullPointerException("getOptimalSize choices is null");
    }

    public Rect i() {
        return this.f8483o;
    }

    public final int j(int i2) {
        return ((rrr.get(i2) + this.ddd) + 270) % RotateProgress.FULL_DEGREE;
    }

    public final void k() {
        if (this.when != null && this.f8480de == 0) {
            try {
                this.ggg.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                this.f8480de = 1;
                this.when.capture(this.ggg.build(), this.qqq, this.f346if);
            } catch (CameraAccessException e) {
                fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
            }
        }
    }

    public final void l(int i2, int i3) {
        if (ContextCompat.checkSelfPermission(this.f8481fe, "android.permission.CAMERA") != 0) {
            m();
        } else if (p(i2, i3)) {
            fe.mmm.qw.i.qw.ad("Camera2Control", "width = " + this.f8482i.getWidth() + ", height = " + this.f8482i.getHeight());
            f(i2, i3);
            CameraManager cameraManager = (CameraManager) this.f8481fe.getSystemService("camera");
            try {
                if (this.xxx.tryAcquire(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    cameraManager.openCamera(this.f8488yj, this.mmm, this.f346if);
                    return;
                }
                throw new RuntimeException("Time out waiting to lock camera opening.");
            } catch (CameraAccessException e) {
                fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
            } catch (InterruptedException e2) {
                throw new RuntimeException("Interrupted while trying to lock camera opening.", e2);
            }
        }
    }

    public final void m() {
        PermissionCallback permissionCallback = this.f8486th;
        if (permissionCallback != null) {
            permissionCallback.qw();
        }
    }

    public final void n() {
        try {
            this.ggg.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            this.f8480de = 2;
            this.when.capture(this.ggg.build(), this.qqq, this.f346if);
        } catch (CameraAccessException e) {
            fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da A[Catch:{ CameraAccessException | NullPointerException -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e4 A[Catch:{ CameraAccessException | NullPointerException -> 0x0152 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p(int r17, int r18) {
        /*
            r16 = this;
            r8 = r16
            java.lang.String r9 = "Camera2Control"
            android.content.Context r0 = r8.f8481fe
            java.lang.String r1 = "camera"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.hardware.camera2.CameraManager r0 = (android.hardware.camera2.CameraManager) r0
            java.lang.String[] r1 = r0.getCameraIdList()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r2 = r1.length     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r3 = 0
        L_0x0014:
            if (r3 >= r2) goto L_0x015c
            r11 = r1[r3]     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.hardware.camera2.CameraCharacteristics r12 = r0.getCameraCharacteristics(r11)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.Object r4 = r12.get(r4)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            if (r4 == 0) goto L_0x002d
            int r4 = r4.intValue()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            if (r4 != 0) goto L_0x002d
            goto L_0x0038
        L_0x002d:
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.Object r4 = r12.get(r4)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r13 = r4
            android.hardware.camera2.params.StreamConfigurationMap r13 = (android.hardware.camera2.params.StreamConfigurationMap) r13     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            if (r13 != 0) goto L_0x003b
        L_0x0038:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x003b:
            android.content.Context r0 = r8.f8481fe     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.view.WindowManager r0 = (android.view.WindowManager) r0     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.graphics.Point r14 = new android.graphics.Point     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r14.<init>()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.view.Display r0 = r0.getDefaultDisplay()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0.getSize(r14)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0 = 2048(0x800, float:2.87E-42)
            int r1 = r14.y     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r15 = 3
            int r1 = r1 * 3
            r7 = 2
            int r1 = r1 / r7
            int r6 = java.lang.Math.min(r0, r1)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0 = 256(0x100, float:3.59E-43)
            android.util.Size[] r2 = r13.getOutputSizes(r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.view.TextureView r1 = r8.f8487uk     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r3 = r1.getWidth()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.view.TextureView r1 = r8.f8487uk     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r4 = r1.getHeight()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.util.Size r5 = new android.util.Size     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.view.TextureView r1 = r8.f8487uk     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r1 = r1.getWidth()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.view.TextureView r7 = r8.f8487uk     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r7 = r7.getHeight()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r5.<init>(r1, r7)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r1 = r16
            r7 = r5
            r5 = r6
            r10 = 2
            android.util.Size r7 = r1.h(r2, r3, r4, r5, r6, r7)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r1 = r7.getWidth()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r2 = r7.getHeight()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r6 = 1
            android.media.ImageReader r0 = android.media.ImageReader.newInstance(r1, r2, r0, r6)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r8.f347switch = r0     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.media.ImageReader$OnImageAvailableListener r1 = r8.aaa     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.os.Handler r2 = r8.f346if     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0.setOnImageAvailableListener(r1, r2)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r0 = r8.f8479ad     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.Object r1 = r12.get(r1)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r1 = r1.intValue()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r8.ddd = r1     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            if (r0 == 0) goto L_0x00c4
            if (r0 == r6) goto L_0x00b9
            if (r0 == r10) goto L_0x00c4
            if (r0 == r15) goto L_0x00b9
            goto L_0x00d1
        L_0x00b9:
            int r1 = r8.ddd     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            if (r1 == 0) goto L_0x00d3
            int r1 = r8.ddd     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r2 = 180(0xb4, float:2.52E-43)
            if (r1 != r2) goto L_0x00d1
            goto L_0x00d3
        L_0x00c4:
            int r1 = r8.ddd     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r2 = 90
            if (r1 == r2) goto L_0x00d3
            int r1 = r8.ddd     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r2 = 270(0x10e, float:3.78E-43)
            if (r1 != r2) goto L_0x00d1
            goto L_0x00d3
        L_0x00d1:
            r1 = 0
            goto L_0x00d4
        L_0x00d3:
            r1 = 1
        L_0x00d4:
            int r2 = r14.x     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r3 = r14.y     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            if (r1 == 0) goto L_0x00e4
            int r2 = r14.y     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r3 = r14.x     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r4 = r17
            r1 = r3
            r3 = r18
            goto L_0x00e9
        L_0x00e4:
            r4 = r18
            r1 = r3
            r3 = r17
        L_0x00e9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r5.<init>()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r10 = "displayorientation = "
            r5.append(r10)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r5.append(r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r0 = ", sensororientation = "
            r5.append(r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            int r0 = r8.ddd     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r5.append(r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r0 = r5.toString()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            fe.mmm.qw.i.qw.ad(r9, r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0.<init>()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r5 = "rotatedPreviewWidth = "
            r0.append(r5)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0.append(r3)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r5 = ", rotatedPreviewHeight = "
            r0.append(r5)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0.append(r4)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r5 = "maxPreviewWidth = "
            r0.append(r5)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0.append(r2)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r5 = ", maxPreviewHeight = "
            r0.append(r5)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0.append(r1)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.String r0 = r0.toString()     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            fe.mmm.qw.i.qw.ad(r9, r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0 = 1920(0x780, float:2.69E-42)
            int r5 = java.lang.Math.min(r2, r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r0 = 1080(0x438, float:1.513E-42)
            int r0 = java.lang.Math.min(r1, r0)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            java.lang.Class<android.graphics.SurfaceTexture> r1 = android.graphics.SurfaceTexture.class
            android.util.Size[] r2 = r13.getOutputSizes(r1)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r1 = r16
            r10 = 1
            r6 = r0
            android.util.Size r0 = r1.h(r2, r3, r4, r5, r6, r7)     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r8.f8482i = r0     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            r8.f8488yj = r11     // Catch:{ CameraAccessException -> 0x0154, NullPointerException -> 0x0152 }
            return r10
        L_0x0152:
            r0 = move-exception
            goto L_0x0155
        L_0x0154:
            r0 = move-exception
        L_0x0155:
            java.lang.String r1 = r0.getMessage()
            fe.mmm.qw.i.qw.th(r9, r1, r0)
        L_0x015c:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.tt.rg.qw.ad.p(int, int):boolean");
    }

    public void pause() {
        ad(0);
    }

    public final void q() {
        HandlerThread handlerThread = new HandlerThread("ocr_camera");
        this.f8484pf = handlerThread;
        handlerThread.start();
        this.f346if = new Handler(this.f8484pf.getLooper());
    }

    public void qw() {
        l(this.f8487uk.getWidth(), this.f8487uk.getHeight());
    }

    public final void r() {
        HandlerThread handlerThread = this.f8484pf;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f8484pf = null;
            this.f346if = null;
        }
    }

    public void rg(int i2) {
        this.f8479ad = i2 / 90;
    }

    public final void s() {
        try {
            this.ggg.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            this.when.capture(this.ggg.build(), this.qqq, this.f346if);
            this.f8480de = 0;
            this.when.setRepeatingRequest(this.vvv, this.qqq, this.f346if);
            this.f8487uk.setSurfaceTextureListener(this.nn);
        } catch (CameraAccessException e) {
            fe.mmm.qw.i.qw.th("Camera2Control", e.getMessage(), e);
        }
    }

    public void start() {
        q();
        if (this.f8487uk.isAvailable()) {
            fe.mmm.qw.i.qw.ad("Camera2Control", "width = " + this.f8487uk.getWidth() + ", height = " + this.f8487uk.getHeight());
            l(this.f8487uk.getWidth(), this.f8487uk.getHeight());
            this.f8487uk.setSurfaceTextureListener(this.nn);
            return;
        }
        this.f8487uk.setSurfaceTextureListener(this.nn);
    }

    public void stop() {
        this.f8487uk.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
        e();
        r();
    }

    public final void t(int i2, CaptureRequest.Builder builder) {
        if (i2 == 0) {
            builder.set(CaptureRequest.FLASH_MODE, 0);
        } else if (i2 != 1) {
            builder.set(CaptureRequest.FLASH_MODE, 1);
        } else {
            builder.set(CaptureRequest.FLASH_MODE, 2);
        }
    }

    public void th() {
        this.f8480de = 0;
    }

    public int uk() {
        return this.qw;
    }

    public void yj(ICameraControl.OnTakePictureCallback onTakePictureCallback) {
        this.f8485rg = onTakePictureCallback;
        k();
    }
}
