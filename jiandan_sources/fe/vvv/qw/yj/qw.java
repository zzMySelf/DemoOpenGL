package fe.vvv.qw.yj;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.os.Build;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.apollon.restnet.http.b;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.frame.ByteBufferFrameManager;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.video.VideoRecorder;
import fe.vvv.qw.fe;
import fe.vvv.qw.rg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class qw extends de implements Camera.PreviewCallback, Camera.ErrorCallback, ByteBufferFrameManager.BufferCallback {
    public final fe.vvv.qw.yj.th.qw F = fe.vvv.qw.yj.th.qw.qw();
    public Camera G;
    @VisibleForTesting
    public int H;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.vvv.qw.when.ad f9232ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Gesture f9233th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ PointF f9235yj;

        /* renamed from: fe.vvv.qw.yj.qw$ad$ad  reason: collision with other inner class name */
        public class C0324ad implements Camera.AutoFocusCallback {

            /* renamed from: fe.vvv.qw.yj.qw$ad$ad$qw  reason: collision with other inner class name */
            public class C0325qw implements Runnable {
                public C0325qw() {
                }

                public void run() {
                    qw.this.G.cancelAutoFocus();
                    Camera.Parameters parameters = qw.this.G.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas((List) null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas((List) null);
                    }
                    qw.this.I1(parameters);
                    qw.this.G.setParameters(parameters);
                }
            }

            public C0324ad() {
            }

            public void onAutoFocus(boolean z, Camera camera) {
                qw.this.p().th("focus end");
                qw.this.p().th("focus reset");
                CameraEngine.Callback b = qw.this.b();
                ad adVar = ad.this;
                b.uk(adVar.f9233th, z, adVar.f9235yj);
                if (qw.this.w1()) {
                    qw.this.p().nn("focus reset", CameraState.ENGINE, qw.this.a(), new C0325qw());
                }
            }
        }

        /* renamed from: fe.vvv.qw.yj.qw$ad$qw  reason: collision with other inner class name */
        public class C0326qw implements Runnable {
            public C0326qw() {
            }

            public void run() {
                CameraEngine.Callback b = qw.this.b();
                ad adVar = ad.this;
                b.uk(adVar.f9233th, false, adVar.f9235yj);
            }
        }

        public ad(fe.vvv.qw.when.ad adVar, Gesture gesture, PointF pointF) {
            this.f9232ad = adVar;
            this.f9233th = gesture;
            this.f9235yj = pointF;
        }

        public void run() {
            if (qw.this.f9180pf.m1025switch()) {
                fe.vvv.qw.yj.uk.qw qwVar = new fe.vvv.qw.yj.uk.qw(qw.this.qqq(), qw.this.v().m716if());
                fe.vvv.qw.when.ad uk2 = this.f9232ad.uk(qwVar);
                Camera.Parameters parameters = qw.this.G.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(uk2.yj(maxNumFocusAreas, qwVar));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(uk2.yj(maxNumMeteringAreas, qwVar));
                }
                parameters.setFocusMode("auto");
                qw.this.G.setParameters(parameters);
                qw.this.b().pf(this.f9233th, this.f9235yj);
                qw.this.p().th("focus end");
                qw.this.p().o("focus end", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, new C0326qw());
                try {
                    qw.this.G.autoFocus(new C0324ad());
                } catch (RuntimeException e) {
                    CameraEngine.f6715i.ad("startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Flash f9238ad;

        public de(Flash flash) {
            this.f9238ad = flash;
        }

        public void run() {
            Camera.Parameters parameters = qw.this.G.getParameters();
            if (qw.this.K1(parameters, this.f9238ad)) {
                qw.this.G.setParameters(parameters);
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Location f9240ad;

        public fe(Location location) {
            this.f9240ad = location;
        }

        public void run() {
            Camera.Parameters parameters = qw.this.G.getParameters();
            if (qw.this.M1(parameters, this.f9240ad)) {
                qw.this.G.setParameters(parameters);
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f9242ad;

        public i(boolean z) {
            this.f9242ad = z;
        }

        public void run() {
            boolean unused = qw.this.N1(this.f9242ad);
        }
    }

    public class o implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f9244ad;

        public o(float f) {
            this.f9244ad = f;
        }

        public void run() {
            Camera.Parameters parameters = qw.this.G.getParameters();
            if (qw.this.O1(parameters, this.f9244ad)) {
                qw.this.G.setParameters(parameters);
            }
        }
    }

    public class pf implements Comparator<int[]> {
        public pf(qw qwVar) {
        }

        /* renamed from: qw */
        public int compare(int[] iArr, int[] iArr2) {
            return (iArr[1] - iArr[0]) - (iArr2[1] - iArr2[0]);
        }
    }

    /* renamed from: fe.vvv.qw.yj.qw$qw  reason: collision with other inner class name */
    public class C0327qw implements Comparator<int[]> {
        public C0327qw(qw qwVar) {
        }

        /* renamed from: qw */
        public int compare(int[] iArr, int[] iArr2) {
            return (iArr2[1] - iArr2[0]) - (iArr[1] - iArr[0]);
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ WhiteBalance f9246ad;

        public rg(WhiteBalance whiteBalance) {
            this.f9246ad = whiteBalance;
        }

        public void run() {
            Camera.Parameters parameters = qw.this.G.getParameters();
            if (qw.this.P1(parameters, this.f9246ad)) {
                qw.this.G.setParameters(parameters);
            }
        }
    }

    public class th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Hdr f9248ad;

        public th(Hdr hdr) {
            this.f9248ad = hdr;
        }

        public void run() {
            Camera.Parameters parameters = qw.this.G.getParameters();
            if (qw.this.L1(parameters, this.f9248ad)) {
                qw.this.G.setParameters(parameters);
            }
        }
    }

    public class uk implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f9250ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f9252th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ PointF[] f9253uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ float[] f9254yj;

        public uk(float f, boolean z, float[] fArr, PointF[] pointFArr) {
            this.f9250ad = f;
            this.f9252th = z;
            this.f9254yj = fArr;
            this.f9253uk = pointFArr;
        }

        public void run() {
            Camera.Parameters parameters = qw.this.G.getParameters();
            if (qw.this.J1(parameters, this.f9250ad)) {
                qw.this.G.setParameters(parameters);
                if (this.f9252th) {
                    qw.this.b().m712if(qw.this.e, this.f9254yj, this.f9253uk);
                }
            }
        }
    }

    public class yj implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f9255ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f9256th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ PointF[] f9258yj;

        public yj(float f, boolean z, PointF[] pointFArr) {
            this.f9255ad = f;
            this.f9256th = z;
            this.f9258yj = pointFArr;
        }

        public void run() {
            Camera.Parameters parameters = qw.this.G.getParameters();
            if (qw.this.Q1(parameters, this.f9255ad)) {
                qw.this.G.setParameters(parameters);
                if (this.f9256th) {
                    qw.this.b().ggg(qw.this.tt, this.f9258yj);
                }
            }
        }
    }

    public qw(@NonNull CameraEngine.Callback callback) {
        super(callback);
    }

    public void G0(@NonNull WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.nn;
        this.nn = whiteBalance;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("white balance (" + whiteBalance + ")", CameraState.ENGINE, new rg(whiteBalance2));
    }

    public void H0(float f, @Nullable PointF[] pointFArr, boolean z) {
        float f2 = this.tt;
        this.tt = f;
        p().th("zoom");
        p().ddd("zoom", CameraState.ENGINE, new yj(f2, z, pointFArr));
    }

    public final void H1(@NonNull Camera.Parameters parameters) {
        parameters.setRecordingHint(n() == Mode.VIDEO);
        I1(parameters);
        K1(parameters, Flash.OFF);
        M1(parameters, (Location) null);
        P1(parameters, WhiteBalance.AUTO);
        L1(parameters, Hdr.OFF);
        Q1(parameters, 0.0f);
        J1(parameters, 0.0f);
        N1(this.f);
        O1(parameters, 0.0f);
    }

    public final void I1(@NonNull Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (n() == Mode.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    public void J0(@Nullable Gesture gesture, @NonNull fe.vvv.qw.when.ad adVar, @NonNull PointF pointF) {
        p().ddd("auto focus", CameraState.BIND, new ad(adVar, gesture, pointF));
    }

    public final boolean J1(@NonNull Camera.Parameters parameters, float f) {
        if (this.f9180pf.when()) {
            float qw = this.f9180pf.qw();
            float ad2 = this.f9180pf.ad();
            float f2 = this.e;
            if (f2 < ad2) {
                qw = ad2;
            } else if (f2 <= qw) {
                qw = f2;
            }
            this.e = qw;
            parameters.setExposureCompensation((int) (qw / parameters.getExposureCompensationStep()));
            return true;
        }
        this.e = f;
        return false;
    }

    public final boolean K1(@NonNull Camera.Parameters parameters, @NonNull Flash flash) {
        if (this.f9180pf.ggg(this.ddd)) {
            parameters.setFlashMode(this.F.de(this.ddd));
            return true;
        }
        this.ddd = flash;
        return false;
    }

    public final boolean L1(@NonNull Camera.Parameters parameters, @NonNull Hdr hdr) {
        if (this.f9180pf.ggg(this.qqq)) {
            parameters.setSceneMode(this.F.fe(this.qqq));
            return true;
        }
        this.qqq = hdr;
        return false;
    }

    public final boolean M1(@NonNull Camera.Parameters parameters, @Nullable Location location) {
        Location location2 = this.rrr;
        if (location2 == null) {
            return true;
        }
        parameters.setGpsLatitude(location2.getLatitude());
        parameters.setGpsLongitude(this.rrr.getLongitude());
        parameters.setGpsAltitude(this.rrr.getAltitude());
        parameters.setGpsTimestamp(this.rrr.getTime());
        parameters.setGpsProcessingMethod(this.rrr.getProvider());
        return true;
    }

    @TargetApi(17)
    public final boolean N1(boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.H, cameraInfo);
            if (cameraInfo.canDisableShutterSound) {
                try {
                    return this.G.enableShutterSound(this.f);
                } catch (RuntimeException unused) {
                    return false;
                }
            }
        }
        if (this.f) {
            return true;
        }
        this.f = z;
        return false;
    }

    public final boolean O1(@NonNull Camera.Parameters parameters, float f) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        S1(supportedPreviewFpsRange);
        float f2 = this.j;
        if (f2 == 0.0f) {
            for (int[] next : supportedPreviewFpsRange) {
                float f3 = ((float) next[0]) / 1000.0f;
                float f4 = ((float) next[1]) / 1000.0f;
                if ((f3 <= 30.0f && 30.0f <= f4) || (f3 <= 24.0f && 24.0f <= f4)) {
                    parameters.setPreviewFpsRange(next[0], next[1]);
                    return true;
                }
            }
        } else {
            float min = Math.min(f2, this.f9180pf.de());
            this.j = min;
            this.j = Math.max(min, this.f9180pf.fe());
            for (int[] next2 : supportedPreviewFpsRange) {
                float f5 = ((float) next2[1]) / 1000.0f;
                float round = (float) Math.round(this.j);
                if (((float) next2[0]) / 1000.0f <= round && round <= f5) {
                    parameters.setPreviewFpsRange(next2[0], next2[1]);
                    return true;
                }
            }
        }
        this.j = f;
        return false;
    }

    public final boolean P1(@NonNull Camera.Parameters parameters, @NonNull WhiteBalance whiteBalance) {
        if (this.f9180pf.ggg(this.nn)) {
            parameters.setWhiteBalance(this.F.rg(this.nn));
            parameters.remove("auto-whitebalance-lock");
            return true;
        }
        this.nn = whiteBalance;
        return false;
    }

    @NonNull
    public Task<Void> Q() {
        CameraEngine.f6715i.de("onStartBind:", "Started");
        try {
            if (this.f9179o.o() == SurfaceHolder.class) {
                this.G.setPreviewDisplay((SurfaceHolder) this.f9179o.i());
            } else if (this.f9179o.o() == SurfaceTexture.class) {
                this.G.setPreviewTexture((SurfaceTexture) this.f9179o.i());
            } else {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            this.when = f1();
            this.ppp = i1();
            return Tasks.forResult(null);
        } catch (IOException e) {
            CameraEngine.f6715i.ad("onStartBind:", "Failed to bind.", e);
            throw new CameraException(e, 2);
        }
    }

    public final boolean Q1(@NonNull Camera.Parameters parameters, float f) {
        if (this.f9180pf.ppp()) {
            parameters.setZoom((int) (this.tt * ((float) parameters.getMaxZoom())));
            this.G.setParameters(parameters);
            return true;
        }
        this.tt = f;
        return false;
    }

    @NonNull
    public Task<fe.vvv.qw.ad> R() {
        try {
            Camera open = Camera.open(this.H);
            this.G = open;
            if (open != null) {
                open.setErrorCallback(this);
                CameraEngine.f6715i.de("onStartEngine:", "Applying default parameters.");
                try {
                    Camera.Parameters parameters = this.G.getParameters();
                    this.f9180pf = new fe.vvv.qw.yj.o.qw(parameters, this.H, qqq().ad(Reference.SENSOR, Reference.VIEW));
                    H1(parameters);
                    this.G.setParameters(parameters);
                    try {
                        this.G.setDisplayOrientation(qqq().de(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE));
                        CameraEngine.f6715i.de("onStartEngine:", "Ended");
                        return Tasks.forResult(this.f9180pf);
                    } catch (Exception unused) {
                        CameraEngine.f6715i.ad("onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                        throw new CameraException(1);
                    }
                } catch (Exception e) {
                    CameraEngine.f6715i.ad("onStartEngine:", "Failed to connect. Problem with camera params");
                    throw new CameraException(e, 1);
                }
            } else {
                CameraEngine.f6715i.ad("onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
        } catch (Exception e2) {
            CameraEngine.f6715i.ad("onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e2, 1);
        }
    }

    @NonNull
    /* renamed from: R1 */
    public ByteBufferFrameManager j1() {
        return (ByteBufferFrameManager) super.j1();
    }

    @NonNull
    public Task<Void> S() {
        CameraEngine.f6715i.de("onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        b().ppp();
        fe.vvv.qw.xxx.ad y = y(Reference.VIEW);
        if (y != null) {
            this.f9179o.aaa(y.rg(), y.fe());
            this.f9179o.mmm(0);
            try {
                Camera.Parameters parameters = this.G.getParameters();
                parameters.setPreviewFormat(17);
                parameters.setPreviewSize(this.ppp.rg(), this.ppp.fe());
                Mode n = n();
                Mode mode = Mode.PICTURE;
                if (n == mode) {
                    parameters.setPictureSize(this.when.rg(), this.when.fe());
                } else {
                    fe.vvv.qw.xxx.ad g1 = g1(mode);
                    parameters.setPictureSize(g1.rg(), g1.fe());
                }
                try {
                    this.G.setParameters(parameters);
                    this.G.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                    this.G.setPreviewCallbackWithBuffer(this);
                    j1().i(17, this.ppp, qqq());
                    CameraEngine.f6715i.de("onStartPreview", "Starting preview with startPreview().");
                    try {
                        this.G.startPreview();
                        CameraEngine.f6715i.de("onStartPreview", "Started preview.");
                        return Tasks.forResult(null);
                    } catch (Exception e) {
                        CameraEngine.f6715i.ad("onStartPreview", "Failed to start preview.", e);
                        throw new CameraException(e, 2);
                    }
                } catch (Exception e2) {
                    CameraEngine.f6715i.ad("onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                    throw new CameraException(e2, 2);
                }
            } catch (Exception e3) {
                CameraEngine.f6715i.ad("onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
                throw new CameraException(e3, 2);
            }
        } else {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
    }

    public final void S1(List<int[]> list) {
        if (!x() || this.j == 0.0f) {
            Collections.sort(list, new C0327qw(this));
        } else {
            Collections.sort(list, new pf(this));
        }
    }

    @NonNull
    public Task<Void> T() {
        this.ppp = null;
        this.when = null;
        try {
            if (this.f9179o.o() == SurfaceHolder.class) {
                this.G.setPreviewDisplay((SurfaceHolder) null);
            } else if (this.f9179o.o() == SurfaceTexture.class) {
                this.G.setPreviewTexture((SurfaceTexture) null);
            } else {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
        } catch (IOException e) {
            CameraEngine.f6715i.ad("onStopBind", "Could not release surface", e);
        }
        return Tasks.forResult(null);
    }

    @NonNull
    public Task<Void> U() {
        CameraEngine.f6715i.de("onStopEngine:", "About to clean up.");
        p().th("focus reset");
        p().th("focus end");
        if (this.G != null) {
            try {
                CameraEngine.f6715i.de("onStopEngine:", "Clean up.", "Releasing camera.");
                this.G.release();
                CameraEngine.f6715i.de("onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e) {
                CameraEngine.f6715i.i("onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
            }
            this.G = null;
            this.f9180pf = null;
        }
        this.f398switch = null;
        this.f9180pf = null;
        this.G = null;
        CameraEngine.f6715i.i("onStopEngine:", "Clean up.", "Returning.");
        return Tasks.forResult(null);
    }

    @NonNull
    public Task<Void> V() {
        CameraEngine.f6715i.de("onStopPreview:", "Started.");
        VideoRecorder videoRecorder = this.f398switch;
        if (videoRecorder != null) {
            videoRecorder.ppp(true);
            this.f398switch = null;
        }
        this.f397if = null;
        j1().uk();
        CameraEngine.f6715i.de("onStopPreview:", "Releasing preview buffers.");
        this.G.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
        try {
            CameraEngine.f6715i.de("onStopPreview:", "Stopping preview.");
            this.G.stopPreview();
            CameraEngine.f6715i.de("onStopPreview:", "Stopped preview.");
        } catch (Exception e) {
            CameraEngine.f6715i.ad("stopPreview", "Could not stop preview", e);
        }
        return Tasks.forResult(null);
    }

    public void ad(@NonNull byte[] bArr) {
        if (B().isAtLeast(CameraState.ENGINE) && C().isAtLeast(CameraState.ENGINE)) {
            this.G.addCallbackBuffer(bArr);
        }
    }

    public void e0(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z) {
        float f2 = this.e;
        this.e = f;
        p().th("exposure correction");
        p().ddd("exposure correction", CameraState.ENGINE, new uk(f2, z, fArr, pointFArr));
    }

    public void g0(@NonNull Flash flash) {
        Flash flash2 = this.ddd;
        this.ddd = flash;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("flash (" + flash + ")", CameraState.ENGINE, new de(flash2));
    }

    public void h0(int i2) {
        this.vvv = 17;
    }

    @NonNull
    public List<fe.vvv.qw.xxx.ad> k1() {
        return Collections.singletonList(this.ppp);
    }

    public void l0(boolean z) {
        this.xxx = z;
    }

    public void m0(@NonNull Hdr hdr) {
        Hdr hdr2 = this.qqq;
        this.qqq = hdr;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("hdr (" + hdr + ")", CameraState.ENGINE, new th(hdr2));
    }

    @NonNull
    public List<fe.vvv.qw.xxx.ad> m1() {
        try {
            List<Camera.Size> supportedPreviewSizes = this.G.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera.Size next : supportedPreviewSizes) {
                fe.vvv.qw.xxx.ad adVar = new fe.vvv.qw.xxx.ad(next.width, next.height);
                if (!arrayList.contains(adVar)) {
                    arrayList.add(adVar);
                }
            }
            CameraEngine.f6715i.de("getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e) {
            CameraEngine.f6715i.ad("getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e, 2);
        }
    }

    public void n0(@Nullable Location location) {
        Location location2 = this.rrr;
        this.rrr = location;
        p().ddd(b.c.j, CameraState.ENGINE, new fe(location2));
    }

    public boolean nn(@NonNull Facing facing) {
        int ad2 = this.F.ad(facing);
        CameraEngine.f6715i.de("collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(ad2), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == ad2) {
                qqq().i(facing, cameraInfo.orientation);
                this.H = i2;
                return true;
            }
        }
        return false;
    }

    public void onError(int i2, Camera camera) {
        int i3 = 0;
        RuntimeException runtimeException = new RuntimeException(CameraEngine.f6715i.ad("Internal Camera1 error.", Integer.valueOf(i2)));
        if (i2 == 1 || i2 == 2 || i2 == 100) {
            i3 = 3;
        }
        throw new CameraException(runtimeException, i3);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        fe.vvv.qw.o.qw qw;
        if (bArr != null && (qw = j1().qw(bArr, System.currentTimeMillis())) != null) {
            b().ad(qw);
        }
    }

    @NonNull
    public fe.vvv.qw.o.ad p1(int i2) {
        return new ByteBufferFrameManager(i2, this);
    }

    public void ppp(@Nullable rg.qw qwVar, @Nullable Exception exc) {
        super.ppp(qwVar, exc);
        if (qwVar == null) {
            this.G.lock();
        }
    }

    public void q0(@NonNull PictureFormat pictureFormat) {
        if (pictureFormat == PictureFormat.JPEG) {
            this.eee = pictureFormat;
            return;
        }
        throw new UnsupportedOperationException("Unsupported picture format: " + pictureFormat);
    }

    public void q1() {
        Z();
    }

    public void s1(@NonNull fe.qw qwVar, boolean z) {
        CameraEngine.f6715i.de("onTakePicture:", "executing.");
        qwVar.f8962de = qqq().de(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        qwVar.f8963fe = s(Reference.OUTPUT);
        fe.vvv.qw.ggg.qw qwVar2 = new fe.vvv.qw.ggg.qw(qwVar, this, this.G);
        this.f397if = qwVar2;
        qwVar2.de();
        CameraEngine.f6715i.de("onTakePicture:", "executed.");
    }

    public void t1(@NonNull fe.qw qwVar, @NonNull fe.vvv.qw.xxx.qw qwVar2, boolean z) {
        CameraEngine.f6715i.de("onTakePictureSnapshot:", "executing.");
        qwVar.f8963fe = D(Reference.OUTPUT);
        if (!(this.f9179o instanceof RendererCameraPreview) || Build.VERSION.SDK_INT < 19) {
            qwVar.f8962de = qqq().de(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
            this.f397if = new fe.vvv.qw.ggg.fe(qwVar, this, this.G, qwVar2);
        } else {
            qwVar.f8962de = qqq().de(Reference.VIEW, Reference.OUTPUT, Axis.ABSOLUTE);
            this.f397if = new fe.vvv.qw.ggg.th(qwVar, this, (RendererCameraPreview) this.f9179o, qwVar2, l1());
        }
        this.f397if.de();
        CameraEngine.f6715i.de("onTakePictureSnapshot:", "executed.");
    }

    public void u0(boolean z) {
        boolean z2 = this.f;
        this.f = z;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("play sounds (" + z + ")", CameraState.ENGINE, new i(z2));
    }

    public void u1(@NonNull rg.qw qwVar) {
        fe.vvv.qw.xxx.ad adVar;
        qwVar.f9078de = qqq().de(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        if (qqq().ad(Reference.SENSOR, Reference.OUTPUT)) {
            adVar = this.when.ad();
        } else {
            adVar = this.when;
        }
        qwVar.f9079fe = adVar;
        try {
            this.G.unlock();
            fe.vvv.qw.ddd.qw qwVar2 = new fe.vvv.qw.ddd.qw(this, this.G, this.H);
            this.f398switch = qwVar2;
            qwVar2.when(qwVar);
        } catch (Exception e) {
            ppp((rg.qw) null, e);
        }
    }

    @SuppressLint({"NewApi"})
    public void v1(@NonNull rg.qw qwVar, @NonNull fe.vvv.qw.xxx.qw qwVar2) {
        CameraPreview cameraPreview = this.f9179o;
        if (!(cameraPreview instanceof RendererCameraPreview)) {
            throw new IllegalStateException("Video snapshots are only supported with GL_SURFACE.");
        } else if (Build.VERSION.SDK_INT >= 18) {
            RendererCameraPreview rendererCameraPreview = (RendererCameraPreview) cameraPreview;
            fe.vvv.qw.xxx.ad D = D(Reference.OUTPUT);
            if (D != null) {
                Rect qw = fe.vvv.qw.p037if.ad.qw(D, qwVar2);
                qwVar.f9079fe = new fe.vvv.qw.xxx.ad(qw.width(), qw.height());
                qwVar.f9078de = qqq().de(Reference.VIEW, Reference.OUTPUT, Axis.ABSOLUTE);
                qwVar.ppp = Math.round(this.j);
                CameraEngine.f6715i.de("onTakeVideoSnapshot", "rotation:", Integer.valueOf(qwVar.f9078de), "size:", qwVar.f9079fe);
                fe.vvv.qw.ddd.de deVar = new fe.vvv.qw.ddd.de(this, rendererCameraPreview, l1());
                this.f398switch = deVar;
                deVar.when(qwVar);
                return;
            }
            throw new IllegalStateException("outputSize should not be null.");
        } else {
            throw new IllegalStateException("Video snapshots are only supported on API 18+.");
        }
    }

    public void w0(float f) {
        this.j = f;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("preview fps (" + f + ")", CameraState.ENGINE, new o(f));
    }
}
