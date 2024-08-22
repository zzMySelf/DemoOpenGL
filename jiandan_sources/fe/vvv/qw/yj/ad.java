package fe.vvv.qw.yj;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.baidu.apollon.restnet.http.b;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.video.Full2VideoRecorder;
import com.otaliastudios.cameraview.video.VideoRecorder;
import fe.vvv.qw.fe;
import fe.vvv.qw.rg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

@RequiresApi(21)
public class ad extends de implements ImageReader.OnImageAvailableListener, ActionHolder {
    public final CameraManager F = ((CameraManager) b().getContext().getSystemService("camera"));
    public String G;
    public CameraDevice H;
    public CameraCharacteristics I;
    public CameraCaptureSession J;
    public CaptureRequest.Builder K;
    public TotalCaptureResult L;
    public final fe.vvv.qw.yj.th.ad M = fe.vvv.qw.yj.th.ad.qw();
    public ImageReader N;
    public Surface O;
    public Surface P;
    public rg.qw Q;
    public ImageReader R;
    public final List<Action> S = new CopyOnWriteArrayList();
    public fe.vvv.qw.yj.yj.yj T;
    public final CameraCaptureSession.CaptureCallback U = new pf();

    public class aaa extends fe.vvv.qw.yj.fe.de {

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f9134rg;

        public aaa(ad adVar, TaskCompletionSource taskCompletionSource) {
            this.f9134rg = taskCompletionSource;
        }

        public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.ad(actionHolder, captureRequest, totalCaptureResult);
            ppp(Integer.MAX_VALUE);
            this.f9134rg.trySetResult(null);
        }
    }

    /* renamed from: fe.vvv.qw.yj.ad$ad  reason: collision with other inner class name */
    public class C0317ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Flash f9135ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Flash f9136th;

        public C0317ad(Flash flash, Flash flash2) {
            this.f9135ad = flash;
            this.f9136th = flash2;
        }

        public void run() {
            ad adVar = ad.this;
            boolean R1 = adVar.R1(adVar.K, this.f9135ad);
            if (ad.this.B() == CameraState.PREVIEW) {
                ad adVar2 = ad.this;
                adVar2.ddd = Flash.OFF;
                adVar2.R1(adVar2.K, this.f9135ad);
                try {
                    ad.this.J.capture(ad.this.K.build(), (CameraCaptureSession.CaptureCallback) null, (Handler) null);
                    ad adVar3 = ad.this;
                    adVar3.ddd = this.f9136th;
                    adVar3.R1(adVar3.K, this.f9135ad);
                    ad.this.W1();
                } catch (CameraAccessException e) {
                    throw ad.this.b2(e);
                }
            } else if (R1) {
                ad.this.W1();
            }
        }
    }

    public class ddd implements Callable<Void> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Object f9138ad;

        public ddd(Object obj) {
            this.f9138ad = obj;
        }

        /* renamed from: qw */
        public Void call() {
            ((SurfaceHolder) this.f9138ad).setFixedSize(ad.this.ppp.rg(), ad.this.ppp.fe());
            return null;
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Location f9140ad;

        public de(Location location) {
            this.f9140ad = location;
        }

        public void run() {
            ad adVar = ad.this;
            if (adVar.U1(adVar.K, this.f9140ad)) {
                ad.this.W1();
            }
        }
    }

    public class eee extends fe.vvv.qw.yj.fe.fe {
        public final /* synthetic */ fe.qw qw;

        public eee(fe.qw qwVar) {
            this.qw = qwVar;
        }

        public void ad(@NonNull Action action) {
            ad.this.r0(false);
            ad.this.S0(this.qw);
            ad.this.r0(true);
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ WhiteBalance f9143ad;

        public fe(WhiteBalance whiteBalance) {
            this.f9143ad = whiteBalance;
        }

        public void run() {
            ad adVar = ad.this;
            if (adVar.Y1(adVar.K, this.f9143ad)) {
                ad.this.W1();
            }
        }
    }

    public class ggg extends fe.vvv.qw.yj.fe.de {
        public ggg() {
        }

        /* renamed from: switch  reason: not valid java name */
        public void m1044switch(@NonNull ActionHolder actionHolder) {
            super.m1047switch(actionHolder);
            ad.this.P1(actionHolder.rg(this));
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            actionHolder.rg(this).set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.FALSE);
            actionHolder.pf(this);
            ppp(Integer.MAX_VALUE);
        }
    }

    public class i implements Comparator<Range<Integer>> {
        public i(ad adVar) {
        }

        /* renamed from: qw */
        public int compare(Range<Integer> range, Range<Integer> range2) {
            return (range.getUpper().intValue() - range.getLower().intValue()) - (range2.getUpper().intValue() - range2.getLower().intValue());
        }
    }

    /* renamed from: fe.vvv.qw.yj.ad$if  reason: invalid class name */
    public class Cif implements Runnable {
        public Cif() {
        }

        public void run() {
            ad.this.X();
        }
    }

    public class mmm implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ rg.qw f9147ad;

        public mmm(rg.qw qwVar) {
            this.f9147ad = qwVar;
        }

        public void run() {
            ad.this.e2(this.f9147ad);
        }
    }

    public class nn extends CameraCaptureSession.StateCallback {
        public final /* synthetic */ TaskCompletionSource qw;

        public nn(TaskCompletionSource taskCompletionSource) {
            this.qw = taskCompletionSource;
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            throw new RuntimeException(CameraEngine.f6715i.ad("onConfigureFailed! Session", cameraCaptureSession));
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            CameraCaptureSession unused = ad.this.J = cameraCaptureSession;
            CameraEngine.f6715i.de("onStartBind:", "Completed");
            this.qw.trySetResult(null);
        }

        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            CameraEngine.f6715i.de("CameraCaptureSession.StateCallback reported onReady.");
        }
    }

    public class o implements Comparator<Range<Integer>> {
        public o(ad adVar) {
        }

        /* renamed from: qw */
        public int compare(Range<Integer> range, Range<Integer> range2) {
            return (range2.getUpper().intValue() - range2.getLower().intValue()) - (range.getUpper().intValue() - range.getLower().intValue());
        }
    }

    public class pf extends CameraCaptureSession.CaptureCallback {
        public pf() {
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            TotalCaptureResult unused = ad.this.L = totalCaptureResult;
            for (Action ad2 : ad.this.S) {
                ad2.ad(ad.this, captureRequest, totalCaptureResult);
            }
        }

        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            for (Action th2 : ad.this.S) {
                th2.th(ad.this, captureRequest, captureResult);
            }
        }

        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            for (Action de2 : ad.this.S) {
                de2.de(ad.this, captureRequest);
            }
        }
    }

    public class ppp implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Gesture f9150ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ PointF f9151th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ fe.vvv.qw.when.ad f9153yj;

        public class qw extends fe.vvv.qw.yj.fe.fe {
            public final /* synthetic */ fe.vvv.qw.yj.yj.yj qw;

            /* renamed from: fe.vvv.qw.yj.ad$ppp$qw$qw  reason: collision with other inner class name */
            public class C0318qw implements Runnable {
                public C0318qw() {
                }

                public void run() {
                    ad.this.l2();
                }
            }

            public qw(fe.vvv.qw.yj.yj.yj yjVar) {
                this.qw = yjVar;
            }

            public void ad(@NonNull Action action) {
                ad.this.b().uk(ppp.this.f9150ad, this.qw.xxx(), ppp.this.f9151th);
                ad.this.p().th("reset metering");
                if (ad.this.w1()) {
                    ad.this.p().nn("reset metering", CameraState.PREVIEW, ad.this.a(), new C0318qw());
                }
            }
        }

        public ppp(Gesture gesture, PointF pointF, fe.vvv.qw.when.ad adVar) {
            this.f9150ad = gesture;
            this.f9151th = pointF;
            this.f9153yj = adVar;
        }

        public void run() {
            if (ad.this.f9180pf.m1025switch()) {
                ad.this.b().pf(this.f9150ad, this.f9151th);
                fe.vvv.qw.yj.yj.yj D1 = ad.this.c2(this.f9153yj);
                fe.vvv.qw.yj.fe.de ad2 = fe.vvv.qw.yj.fe.ad.ad(CoroutineLiveDataKt.DEFAULT_TIMEOUT, D1);
                ad2.yj(ad.this);
                ad2.fe(new qw(D1));
            }
        }
    }

    public class qqq extends fe.vvv.qw.yj.fe.fe {
        public final /* synthetic */ fe.qw qw;

        public qqq(fe.qw qwVar) {
            this.qw = qwVar;
        }

        public void ad(@NonNull Action action) {
            ad.this.t0(false);
            ad.this.T0(this.qw);
            ad.this.t0(true);
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            ad.this.g2();
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Hdr f9158ad;

        public rg(Hdr hdr) {
            this.f9158ad = hdr;
        }

        public void run() {
            ad adVar = ad.this;
            if (adVar.T1(adVar.K, this.f9158ad)) {
                ad.this.W1();
            }
        }
    }

    public class rrr implements Runnable {
        public rrr() {
        }

        public void run() {
            ad.this.l2();
        }
    }

    /* renamed from: fe.vvv.qw.yj.ad$switch  reason: invalid class name */
    public class Cswitch implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f9161ad;

        public Cswitch(boolean z) {
            this.f9161ad = z;
        }

        public void run() {
            if (!ad.this.B().isAtLeast(CameraState.BIND) || !ad.this.N()) {
                ad adVar = ad.this;
                adVar.xxx = this.f9161ad;
                if (adVar.B().isAtLeast(CameraState.BIND)) {
                    ad.this.Y();
                    return;
                }
                return;
            }
            ad.this.l0(this.f9161ad);
        }
    }

    public class th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f9163ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f9165th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ PointF[] f9166uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ float f9167yj;

        public th(float f, boolean z, float f2, PointF[] pointFArr) {
            this.f9163ad = f;
            this.f9165th = z;
            this.f9167yj = f2;
            this.f9166uk = pointFArr;
        }

        public void run() {
            ad adVar = ad.this;
            if (adVar.Z1(adVar.K, this.f9163ad)) {
                ad.this.W1();
                if (this.f9165th) {
                    ad.this.b().ggg(this.f9167yj, this.f9166uk);
                }
            }
        }
    }

    public class uk implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f9168ad;

        public uk(float f) {
            this.f9168ad = f;
        }

        public void run() {
            ad adVar = ad.this;
            if (adVar.V1(adVar.K, this.f9168ad)) {
                ad.this.W1();
            }
        }
    }

    public static /* synthetic */ class vvv {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.otaliastudios.cameraview.controls.PictureFormat[] r0 = com.otaliastudios.cameraview.controls.PictureFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.otaliastudios.cameraview.controls.PictureFormat r1 = com.otaliastudios.cameraview.controls.PictureFormat.JPEG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.controls.PictureFormat r1 = com.otaliastudios.cameraview.controls.PictureFormat.DNG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.yj.ad.vvv.<clinit>():void");
        }
    }

    public class when implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f9170ad;

        public when(int i2) {
            this.f9170ad = i2;
        }

        public void run() {
            if (!ad.this.B().isAtLeast(CameraState.BIND) || !ad.this.N()) {
                ad adVar = ad.this;
                int i2 = this.f9170ad;
                if (i2 <= 0) {
                    i2 = 35;
                }
                adVar.vvv = i2;
                if (ad.this.B().isAtLeast(CameraState.BIND)) {
                    ad.this.Y();
                    return;
                }
                return;
            }
            ad.this.h0(this.f9170ad);
        }
    }

    public class xxx extends CameraDevice.StateCallback {
        public final /* synthetic */ TaskCompletionSource qw;

        public xxx(TaskCompletionSource taskCompletionSource) {
            this.qw = taskCompletionSource;
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            CameraException cameraException = new CameraException(3);
            if (!this.qw.getTask().isComplete()) {
                this.qw.trySetException(cameraException);
                return;
            }
            CameraEngine.f6715i.de("CameraDevice.StateCallback reported disconnection.");
            throw cameraException;
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            if (!this.qw.getTask().isComplete()) {
                this.qw.trySetException(ad.this.a2(i2));
                return;
            }
            CameraEngine.f6715i.ad("CameraDevice.StateCallback reported an error:", Integer.valueOf(i2));
            throw new CameraException(3);
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            int i2;
            CameraDevice unused = ad.this.H = cameraDevice;
            try {
                CameraEngine.f6715i.de("onStartEngine:", "Opened camera device.");
                CameraCharacteristics unused2 = ad.this.I = ad.this.F.getCameraCharacteristics(ad.this.G);
                boolean ad2 = ad.this.qqq().ad(Reference.SENSOR, Reference.VIEW);
                int i3 = vvv.qw[ad.this.eee.ordinal()];
                if (i3 == 1) {
                    i2 = 256;
                } else if (i3 == 2) {
                    i2 = 32;
                } else {
                    throw new IllegalArgumentException("Unknown format:" + ad.this.eee);
                }
                ad.this.f9180pf = new fe.vvv.qw.yj.o.ad(ad.this.F, ad.this.G, ad2, i2);
                CaptureRequest.Builder unused3 = ad.this.d2(1);
                this.qw.trySetResult(ad.this.f9180pf);
            } catch (CameraAccessException e) {
                this.qw.trySetException(ad.this.b2(e));
            }
        }
    }

    public class yj implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f9173ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PointF[] f9174i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f9176th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ float[] f9177uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ float f9178yj;

        public yj(float f, boolean z, float f2, float[] fArr, PointF[] pointFArr) {
            this.f9173ad = f;
            this.f9176th = z;
            this.f9178yj = f2;
            this.f9177uk = fArr;
            this.f9174i = pointFArr;
        }

        public void run() {
            ad adVar = ad.this;
            if (adVar.Q1(adVar.K, this.f9173ad)) {
                ad.this.W1();
                if (this.f9176th) {
                    ad.this.b().m712if(this.f9178yj, this.f9177uk, this.f9174i);
                }
            }
        }
    }

    public ad(CameraEngine.Callback callback) {
        super(callback);
        new fe.vvv.qw.yj.fe.rg().yj(this);
    }

    public void G0(@NonNull WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.nn;
        this.nn = whiteBalance;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("white balance (" + whiteBalance + ")", CameraState.ENGINE, new fe(whiteBalance2));
    }

    public void H0(float f, @Nullable PointF[] pointFArr, boolean z) {
        float f2 = this.tt;
        this.tt = f;
        p().th("zoom");
        p().ddd("zoom", CameraState.ENGINE, new th(f2, z, f, pointFArr));
    }

    public void J0(@Nullable Gesture gesture, @NonNull fe.vvv.qw.when.ad adVar, @NonNull PointF pointF) {
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("autofocus (" + gesture + ")", CameraState.PREVIEW, new ppp(gesture, pointF, adVar));
    }

    public final void N1(@NonNull Surface... surfaceArr) {
        this.K.addTarget(this.P);
        Surface surface = this.O;
        if (surface != null) {
            this.K.addTarget(surface);
        }
        int length = surfaceArr.length;
        int i2 = 0;
        while (i2 < length) {
            Surface surface2 = surfaceArr[i2];
            if (surface2 != null) {
                this.K.addTarget(surface2);
                i2++;
            } else {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
        }
    }

    public final void O1(@NonNull CaptureRequest.Builder builder, @Nullable CaptureRequest.Builder builder2) {
        CameraEngine.f6715i.de("applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        P1(builder);
        R1(builder, Flash.OFF);
        U1(builder, (Location) null);
        Y1(builder, WhiteBalance.AUTO);
        T1(builder, Hdr.OFF);
        Z1(builder, 0.0f);
        Q1(builder, 0.0f);
        V1(builder, 0.0f);
        if (builder2 != null) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            builder.set(key, (MeteringRectangle[]) builder2.get(key));
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_REGIONS;
            builder.set(key2, (MeteringRectangle[]) builder2.get(key2));
            CaptureRequest.Key key3 = CaptureRequest.CONTROL_AWB_REGIONS;
            builder.set(key3, (MeteringRectangle[]) builder2.get(key3));
            CaptureRequest.Key key4 = CaptureRequest.CONTROL_AF_MODE;
            builder.set(key4, (Integer) builder2.get(key4));
        }
    }

    public void P1(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) h2(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        if (n() == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        } else if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
    }

    public Task<Void> Q() {
        int i2;
        CameraEngine.f6715i.de("onStartBind:", "Started");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.when = f1();
        this.ppp = i1();
        ArrayList arrayList = new ArrayList();
        Class<SurfaceTexture> o2 = this.f9179o.o();
        Object i3 = this.f9179o.i();
        if (o2 == SurfaceHolder.class) {
            try {
                Tasks.await(Tasks.call(new ddd(i3)));
                this.P = ((SurfaceHolder) i3).getSurface();
            } catch (InterruptedException | ExecutionException e) {
                throw new CameraException(e, 1);
            }
        } else if (o2 == SurfaceTexture.class) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) i3;
            surfaceTexture.setDefaultBufferSize(this.ppp.rg(), this.ppp.fe());
            this.P = new Surface(surfaceTexture);
        } else {
            throw new RuntimeException("Unknown CameraPreview output class.");
        }
        arrayList.add(this.P);
        if (n() == Mode.VIDEO && this.Q != null) {
            Full2VideoRecorder full2VideoRecorder = new Full2VideoRecorder(this, this.G);
            try {
                arrayList.add(full2VideoRecorder.mmm(this.Q));
                this.f398switch = full2VideoRecorder;
            } catch (Full2VideoRecorder.PrepareException e2) {
                throw new CameraException(e2, 1);
            }
        }
        if (n() == Mode.PICTURE) {
            int i4 = vvv.qw[this.eee.ordinal()];
            if (i4 == 1) {
                i2 = 256;
            } else if (i4 == 2) {
                i2 = 32;
            } else {
                throw new IllegalArgumentException("Unknown format:" + this.eee);
            }
            ImageReader newInstance = ImageReader.newInstance(this.when.rg(), this.when.fe(), i2, 2);
            this.R = newInstance;
            arrayList.add(newInstance.getSurface());
        }
        if (o1()) {
            fe.vvv.qw.xxx.ad h1 = h1();
            this.ggg = h1;
            ImageReader newInstance2 = ImageReader.newInstance(h1.rg(), this.ggg.fe(), this.vvv, k() + 1);
            this.N = newInstance2;
            newInstance2.setOnImageAvailableListener(this, (Handler) null);
            Surface surface = this.N.getSurface();
            this.O = surface;
            arrayList.add(surface);
        } else {
            this.N = null;
            this.ggg = null;
            this.O = null;
        }
        try {
            this.H.createCaptureSession(arrayList, new nn(taskCompletionSource), (Handler) null);
            return taskCompletionSource.getTask();
        } catch (CameraAccessException e3) {
            throw b2(e3);
        }
    }

    public boolean Q1(@NonNull CaptureRequest.Builder builder, float f) {
        if (this.f9180pf.when()) {
            builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(this.e * ((Rational) h2(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1))).floatValue())));
            return true;
        }
        this.e = f;
        return false;
    }

    @SuppressLint({"MissingPermission"})
    @NonNull
    public Task<fe.vvv.qw.ad> R() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.F.openCamera(this.G, new xxx(taskCompletionSource), (Handler) null);
            return taskCompletionSource.getTask();
        } catch (CameraAccessException e) {
            throw b2(e);
        }
    }

    public boolean R1(@NonNull CaptureRequest.Builder builder, @NonNull Flash flash) {
        if (this.f9180pf.ggg(this.ddd)) {
            int[] iArr = (int[]) h2(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int valueOf : iArr) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            for (Pair next : this.M.de(this.ddd)) {
                if (arrayList.contains(next.first)) {
                    CameraEngine.f6715i.de("applyFlash: setting CONTROL_AE_MODE to", next.first);
                    CameraEngine.f6715i.de("applyFlash: setting FLASH_MODE to", next.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, (Integer) next.first);
                    builder.set(CaptureRequest.FLASH_MODE, (Integer) next.second);
                    return true;
                }
            }
        }
        this.ddd = flash;
        return false;
    }

    @NonNull
    public Task<Void> S() {
        CameraEngine.f6715i.de("onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        b().ppp();
        fe.vvv.qw.xxx.ad y = y(Reference.VIEW);
        if (y != null) {
            this.f9179o.aaa(y.rg(), y.fe());
            this.f9179o.mmm(qqq().de(Reference.BASE, Reference.VIEW, Axis.ABSOLUTE));
            if (o1()) {
                j1().i(this.vvv, this.ggg, qqq());
            }
            CameraEngine.f6715i.de("onStartPreview:", "Starting preview.");
            N1(new Surface[0]);
            X1(false, 2);
            CameraEngine.f6715i.de("onStartPreview:", "Started preview.");
            rg.qw qwVar = this.Q;
            if (qwVar != null) {
                this.Q = null;
                p().ddd("do take video", CameraState.PREVIEW, new mmm(qwVar));
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            new aaa(this, taskCompletionSource).yj(this);
            return taskCompletionSource.getTask();
        }
        throw new IllegalStateException("previewStreamSize should not be null at this point.");
    }

    public void S1(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) h2(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (n() == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
    }

    @NonNull
    public Task<Void> T() {
        CameraEngine.f6715i.de("onStopBind:", "About to clean up.");
        this.O = null;
        this.P = null;
        this.ppp = null;
        this.when = null;
        this.ggg = null;
        ImageReader imageReader = this.N;
        if (imageReader != null) {
            imageReader.close();
            this.N = null;
        }
        ImageReader imageReader2 = this.R;
        if (imageReader2 != null) {
            imageReader2.close();
            this.R = null;
        }
        this.J.close();
        this.J = null;
        CameraEngine.f6715i.de("onStopBind:", "Returning.");
        return Tasks.forResult(null);
    }

    public boolean T1(@NonNull CaptureRequest.Builder builder, @NonNull Hdr hdr) {
        if (this.f9180pf.ggg(this.qqq)) {
            builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(this.M.fe(this.qqq)));
            return true;
        }
        this.qqq = hdr;
        return false;
    }

    @NonNull
    public Task<Void> U() {
        try {
            CameraEngine.f6715i.de("onStopEngine:", "Clean up.", "Releasing camera.");
            this.H.close();
            CameraEngine.f6715i.de("onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e) {
            CameraEngine.f6715i.i("onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
        }
        this.H = null;
        CameraEngine.f6715i.de("onStopEngine:", "Aborting actions.");
        for (Action qw2 : this.S) {
            qw2.qw(this);
        }
        this.I = null;
        this.f9180pf = null;
        this.f398switch = null;
        this.K = null;
        CameraEngine.f6715i.i("onStopEngine:", "Returning.");
        return Tasks.forResult(null);
    }

    public boolean U1(@NonNull CaptureRequest.Builder builder, @Nullable Location location) {
        Location location2 = this.rrr;
        if (location2 == null) {
            return true;
        }
        builder.set(CaptureRequest.JPEG_GPS_LOCATION, location2);
        return true;
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
        if (o1()) {
            j1().uk();
        }
        j2();
        this.L = null;
        CameraEngine.f6715i.de("onStopPreview:", "Returning.");
        return Tasks.forResult(null);
    }

    public boolean V1(@NonNull CaptureRequest.Builder builder, float f) {
        Range[] rangeArr = (Range[]) h2(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new Range[0]);
        k2(rangeArr);
        float f2 = this.j;
        if (f2 == 0.0f) {
            for (Range range : rangeArr) {
                if (range.contains(30) || range.contains(24)) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float min = Math.min(f2, this.f9180pf.de());
            this.j = min;
            this.j = Math.max(min, this.f9180pf.fe());
            for (Range range2 : rangeArr) {
                if (range2.contains(Integer.valueOf(Math.round(this.j)))) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.j = f;
        return false;
    }

    public void W1() {
        X1(true, 3);
    }

    public final void X1(boolean z, int i2) {
        if ((B() == CameraState.PREVIEW && !N()) || !z) {
            try {
                this.J.setRepeatingRequest(this.K.build(), this.U, (Handler) null);
            } catch (CameraAccessException e) {
                throw new CameraException(e, i2);
            } catch (IllegalStateException e2) {
                CameraEngine.f6715i.ad("applyRepeatingRequestBuilder: session is invalid!", e2, "checkStarted:", Boolean.valueOf(z), "currentThread:", Thread.currentThread().getName(), "state:", B(), "targetState:", C());
                throw new CameraException(3);
            }
        }
    }

    public boolean Y1(@NonNull CaptureRequest.Builder builder, @NonNull WhiteBalance whiteBalance) {
        if (this.f9180pf.ggg(this.nn)) {
            builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(this.M.rg(this.nn)));
            return true;
        }
        this.nn = whiteBalance;
        return false;
    }

    public boolean Z1(@NonNull CaptureRequest.Builder builder, float f) {
        if (this.f9180pf.ppp()) {
            float floatValue = ((Float) h2(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
            builder.set(CaptureRequest.SCALER_CROP_REGION, f2((this.tt * (floatValue - 1.0f)) + 1.0f, floatValue));
            return true;
        }
        this.tt = f;
        return false;
    }

    @NonNull
    public final CameraException a2(int i2) {
        int i3 = 1;
        if (!(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5)) {
            i3 = 0;
        }
        return new CameraException(i3);
    }

    @NonNull
    public final CameraException b2(@NonNull CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i2 = 3;
        if (reason != 1) {
            if (!(reason == 2 || reason == 3)) {
                if (!(reason == 4 || reason == 5)) {
                    i2 = 0;
                }
            }
            return new CameraException(cameraAccessException, i2);
        }
        i2 = 1;
        return new CameraException(cameraAccessException, i2);
    }

    @NonNull
    public final fe.vvv.qw.yj.yj.yj c2(@Nullable fe.vvv.qw.when.ad adVar) {
        fe.vvv.qw.yj.yj.yj yjVar = this.T;
        if (yjVar != null) {
            yjVar.qw(this);
        }
        S1(this.K);
        fe.vvv.qw.yj.yj.yj yjVar2 = new fe.vvv.qw.yj.yj.yj(this, adVar, adVar == null);
        this.T = yjVar2;
        return yjVar2;
    }

    @NonNull
    public final CaptureRequest.Builder d2(int i2) throws CameraAccessException {
        CaptureRequest.Builder builder = this.K;
        CaptureRequest.Builder createCaptureRequest = this.H.createCaptureRequest(i2);
        this.K = createCaptureRequest;
        createCaptureRequest.setTag(Integer.valueOf(i2));
        O1(this.K, builder);
        return this.K;
    }

    public void de() {
        super.de();
        if ((this.f398switch instanceof Full2VideoRecorder) && ((Integer) h2(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2) {
            CameraEngine.f6715i.i("Applying the Issue549 workaround.", Thread.currentThread());
            g2();
            CameraEngine.f6715i.i("Applied the Issue549 workaround. Sleeping...");
            try {
                Thread.sleep(600);
            } catch (InterruptedException unused) {
            }
            CameraEngine.f6715i.i("Applied the Issue549 workaround. Slept!");
        }
    }

    public void e0(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z) {
        float f2 = this.e;
        this.e = f;
        p().th("exposure correction");
        p().ddd("exposure correction", CameraState.ENGINE, new yj(f2, z, f, fArr, pointFArr));
    }

    public final void e2(@NonNull rg.qw qwVar) {
        VideoRecorder videoRecorder = this.f398switch;
        if (videoRecorder instanceof Full2VideoRecorder) {
            Full2VideoRecorder full2VideoRecorder = (Full2VideoRecorder) videoRecorder;
            try {
                d2(3);
                N1(full2VideoRecorder.aaa());
                X1(true, 3);
                this.f398switch.when(qwVar);
            } catch (CameraAccessException e) {
                ppp((rg.qw) null, e);
                throw b2(e);
            } catch (CameraException e2) {
                ppp((rg.qw) null, e2);
                throw e2;
            }
        } else {
            throw new IllegalStateException("doTakeVideo called, but video recorder is not a Full2VideoRecorder! " + this.f398switch);
        }
    }

    @NonNull
    public final Rect f2(float f, float f2) {
        Rect rect = (Rect) h2(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
        int width = rect.width() - ((int) (((float) rect.width()) / f2));
        int height = rect.height() - ((int) (((float) rect.height()) / f2));
        float f3 = f - 1.0f;
        float f4 = f2 - 1.0f;
        int i2 = (int) (((((float) width) * f3) / f4) / 2.0f);
        int i3 = (int) (((((float) height) * f3) / f4) / 2.0f);
        return new Rect(i2, i3, rect.width() - i2, rect.height() - i3);
    }

    public void g0(@NonNull Flash flash) {
        Flash flash2 = this.ddd;
        this.ddd = flash;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("flash (" + flash + ")", CameraState.ENGINE, new C0317ad(flash2, flash));
    }

    public final void g2() {
        if (((Integer) this.K.build().getTag()).intValue() != 1) {
            try {
                d2(1);
                N1(new Surface[0]);
                W1();
            } catch (CameraAccessException e) {
                throw b2(e);
            }
        }
    }

    public void ggg(@NonNull Action action) {
        this.S.remove(action);
    }

    public void h0(int i2) {
        if (this.vvv == 0) {
            this.vvv = 35;
        }
        fe.vvv.qw.yj.pf.qw p = p();
        p.uk("frame processing format (" + i2 + ")", true, new when(i2));
    }

    @VisibleForTesting
    @NonNull
    public <T> T h2(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        return i2(this.I, key, t);
    }

    public void i(@NonNull Action action) {
        if (!this.S.contains(action)) {
            this.S.add(action);
        }
    }

    @NonNull
    public final <T> T i2(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = cameraCharacteristics.get(key);
        return t2 == null ? t : t2;
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public TotalCaptureResult m1043if(@NonNull Action action) {
        return this.L;
    }

    public final void j2() {
        this.K.removeTarget(this.P);
        Surface surface = this.O;
        if (surface != null) {
            this.K.removeTarget(surface);
        }
    }

    @NonNull
    public List<fe.vvv.qw.xxx.ad> k1() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.F.getCameraCharacteristics(this.G).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap != null) {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.vvv);
                ArrayList arrayList = new ArrayList(outputSizes.length);
                for (Size size : outputSizes) {
                    fe.vvv.qw.xxx.ad adVar = new fe.vvv.qw.xxx.ad(size.getWidth(), size.getHeight());
                    if (!arrayList.contains(adVar)) {
                        arrayList.add(adVar);
                    }
                }
                return arrayList;
            }
            throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
        } catch (CameraAccessException e) {
            throw b2(e);
        }
    }

    public final void k2(Range<Integer>[] rangeArr) {
        if (!x() || this.j == 0.0f) {
            Arrays.sort(rangeArr, new o(this));
        } else {
            Arrays.sort(rangeArr, new i(this));
        }
    }

    public void l0(boolean z) {
        fe.vvv.qw.yj.pf.qw p = p();
        p.uk("has frame processors (" + z + ")", true, new Cswitch(z));
    }

    public final void l2() {
        fe.vvv.qw.yj.fe.ad.qw(new ggg(), new fe.vvv.qw.yj.yj.uk()).yj(this);
    }

    public void m0(@NonNull Hdr hdr) {
        Hdr hdr2 = this.qqq;
        this.qqq = hdr;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("hdr (" + hdr + ")", CameraState.ENGINE, new rg(hdr2));
    }

    @NonNull
    public List<fe.vvv.qw.xxx.ad> m1() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.F.getCameraCharacteristics(this.G).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap != null) {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.f9179o.o());
                ArrayList arrayList = new ArrayList(outputSizes.length);
                for (Size size : outputSizes) {
                    fe.vvv.qw.xxx.ad adVar = new fe.vvv.qw.xxx.ad(size.getWidth(), size.getHeight());
                    if (!arrayList.contains(adVar)) {
                        arrayList.add(adVar);
                    }
                }
                return arrayList;
            }
            throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
        } catch (CameraAccessException e) {
            throw b2(e);
        }
    }

    public void n0(@Nullable Location location) {
        Location location2 = this.rrr;
        this.rrr = location;
        p().ddd(b.c.j, CameraState.ENGINE, new de(location2));
    }

    public final boolean nn(@NonNull Facing facing) {
        int ad2 = this.M.ad(facing);
        try {
            String[] cameraIdList = this.F.getCameraIdList();
            CameraEngine.f6715i.de("collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(ad2), "Cameras:", Integer.valueOf(cameraIdList.length));
            int length = cameraIdList.length;
            int i2 = 0;
            while (i2 < length) {
                String str = cameraIdList[i2];
                try {
                    CameraCharacteristics cameraCharacteristics = this.F.getCameraCharacteristics(str);
                    if (ad2 == ((Integer) i2(cameraCharacteristics, CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                        this.G = str;
                        qqq().i(facing, ((Integer) i2(cameraCharacteristics, CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                        return true;
                    }
                    i2++;
                } catch (CameraAccessException unused) {
                }
            }
            return false;
        } catch (CameraAccessException e) {
            throw b2(e);
        }
    }

    public void o(@NonNull Action action, @NonNull CaptureRequest.Builder builder) throws CameraAccessException {
        if (B() == CameraState.PREVIEW && !N()) {
            this.J.capture(builder.build(), this.U, (Handler) null);
        }
    }

    public void onImageAvailable(ImageReader imageReader) {
        Image image;
        CameraEngine.f6715i.uk("onImageAvailable:", "trying to acquire Image.");
        try {
            image = imageReader.acquireLatestImage();
        } catch (Exception unused) {
            image = null;
        }
        if (image == null) {
            CameraEngine.f6715i.i("onImageAvailable:", "failed to acquire Image!");
        } else if (B() != CameraState.PREVIEW || N()) {
            CameraEngine.f6715i.de("onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            image.close();
        } else {
            fe.vvv.qw.o.qw qw2 = j1().qw(image, System.currentTimeMillis());
            if (qw2 != null) {
                CameraEngine.f6715i.uk("onImageAvailable:", "Image acquired, dispatching.");
                b().ad(qw2);
                return;
            }
            CameraEngine.f6715i.de("onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        }
    }

    @NonNull
    public fe.vvv.qw.o.ad p1(int i2) {
        return new fe.vvv.qw.o.de(i2);
    }

    public void pf(@NonNull Action action) {
        W1();
    }

    public void ppp(@Nullable rg.qw qwVar, @Nullable Exception exc) {
        super.ppp(qwVar, exc);
        p().ddd("restore preview template", CameraState.BIND, new qw());
    }

    public void q0(@NonNull PictureFormat pictureFormat) {
        if (pictureFormat != this.eee) {
            this.eee = pictureFormat;
            fe.vvv.qw.yj.pf.qw p = p();
            p.ddd("picture format (" + pictureFormat + ")", CameraState.ENGINE, new Cif());
        }
    }

    public void q1() {
        CameraEngine.f6715i.de("onPreviewStreamSizeChanged:", "Calling restartBind().");
        Y();
    }

    @NonNull
    public CaptureRequest.Builder rg(@NonNull Action action) {
        return this.K;
    }

    public void s1(@NonNull fe.qw qwVar, boolean z) {
        if (z) {
            CameraEngine.f6715i.de("onTakePicture:", "doMetering is true. Delaying.");
            fe.vvv.qw.yj.fe.de ad2 = fe.vvv.qw.yj.fe.ad.ad(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, c2((fe.vvv.qw.when.ad) null));
            ad2.fe(new eee(qwVar));
            ad2.yj(this);
            return;
        }
        CameraEngine.f6715i.de("onTakePicture:", "doMetering is false. Performing.");
        qwVar.f8962de = qqq().de(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        qwVar.f8963fe = s(Reference.OUTPUT);
        try {
            CaptureRequest.Builder createCaptureRequest = this.H.createCaptureRequest(2);
            O1(createCaptureRequest, this.K);
            fe.vvv.qw.ggg.ad adVar = new fe.vvv.qw.ggg.ad(qwVar, this, createCaptureRequest, this.R);
            this.f397if = adVar;
            adVar.de();
        } catch (CameraAccessException e) {
            throw b2(e);
        }
    }

    public void t1(@NonNull fe.qw qwVar, @NonNull fe.vvv.qw.xxx.qw qwVar2, boolean z) {
        if (z) {
            CameraEngine.f6715i.de("onTakePictureSnapshot:", "doMetering is true. Delaying.");
            fe.vvv.qw.yj.fe.de ad2 = fe.vvv.qw.yj.fe.ad.ad(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, c2((fe.vvv.qw.when.ad) null));
            ad2.fe(new qqq(qwVar));
            ad2.yj(this);
            return;
        }
        CameraEngine.f6715i.de("onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (this.f9179o instanceof RendererCameraPreview) {
            qwVar.f8963fe = D(Reference.OUTPUT);
            qwVar.f8962de = qqq().de(Reference.VIEW, Reference.OUTPUT, Axis.ABSOLUTE);
            fe.vvv.qw.ggg.rg rgVar = new fe.vvv.qw.ggg.rg(qwVar, this, (RendererCameraPreview) this.f9179o, qwVar2);
            this.f397if = rgVar;
            rgVar.de();
            return;
        }
        throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
    }

    public void u0(boolean z) {
        this.f = z;
        Tasks.forResult(null);
    }

    public void u1(@NonNull rg.qw qwVar) {
        CameraEngine.f6715i.de("onTakeVideo", "called.");
        qwVar.f9078de = qqq().de(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        qwVar.f9079fe = qqq().ad(Reference.SENSOR, Reference.OUTPUT) ? this.when.ad() : this.when;
        CameraEngine.f6715i.i("onTakeVideo", "calling restartBind.");
        this.Q = qwVar;
        Y();
    }

    @NonNull
    public CameraCharacteristics uk(@NonNull Action action) {
        return this.I;
    }

    public void v1(@NonNull rg.qw qwVar, @NonNull fe.vvv.qw.xxx.qw qwVar2) {
        CameraPreview cameraPreview = this.f9179o;
        if (cameraPreview instanceof RendererCameraPreview) {
            RendererCameraPreview rendererCameraPreview = (RendererCameraPreview) cameraPreview;
            fe.vvv.qw.xxx.ad D = D(Reference.OUTPUT);
            if (D != null) {
                Rect qw2 = fe.vvv.qw.p037if.ad.qw(D, qwVar2);
                qwVar.f9079fe = new fe.vvv.qw.xxx.ad(qw2.width(), qw2.height());
                qwVar.f9078de = qqq().de(Reference.VIEW, Reference.OUTPUT, Axis.ABSOLUTE);
                qwVar.ppp = Math.round(this.j);
                CameraEngine.f6715i.de("onTakeVideoSnapshot", "rotation:", Integer.valueOf(qwVar.f9078de), "size:", qwVar.f9079fe);
                fe.vvv.qw.ddd.de deVar = new fe.vvv.qw.ddd.de(this, rendererCameraPreview, l1());
                this.f398switch = deVar;
                deVar.when(qwVar);
                return;
            }
            throw new IllegalStateException("outputSize should not be null.");
        }
        throw new IllegalStateException("Video snapshots are only supported with GL_SURFACE.");
    }

    public void w0(float f) {
        float f2 = this.j;
        this.j = f;
        fe.vvv.qw.yj.pf.qw p = p();
        p.ddd("preview fps (" + f + ")", CameraState.ENGINE, new uk(f2));
    }

    public void yj(@Nullable fe.qw qwVar, @Nullable Exception exc) {
        boolean z = this.f397if instanceof fe.vvv.qw.ggg.ad;
        super.yj(qwVar, exc);
        if ((z && r()) || (!z && u())) {
            p().ddd("reset metering after picture", CameraState.PREVIEW, new rrr());
        }
    }
}
