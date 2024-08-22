package com.otaliastudios.cameraview.engine;

import android.content.Context;
import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.video.VideoRecorder;
import fe.vvv.qw.fe;
import fe.vvv.qw.rg;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class CameraEngine implements CameraPreview.SurfaceCallback, PictureRecorder.PictureResultListener, VideoRecorder.VideoResultListener {

    /* renamed from: i  reason: collision with root package name */
    public static final CameraLogger f6715i = CameraLogger.qw(CameraEngine.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public fe.vvv.qw.p037if.yj f6716ad;
    @VisibleForTesting

    /* renamed from: th  reason: collision with root package name */
    public Handler f6717th;

    /* renamed from: uk  reason: collision with root package name */
    public final fe.vvv.qw.yj.pf.qw f6718uk = new fe.vvv.qw.yj.pf.qw(new de());

    /* renamed from: yj  reason: collision with root package name */
    public final Callback f6719yj;

    public interface Callback {
        void ad(@NonNull fe.vvv.qw.o.qw qwVar);

        void fe(boolean z);

        @NonNull
        Context getContext();

        void ggg(float f, @Nullable PointF[] pointFArr);

        void i();

        /* renamed from: if  reason: not valid java name */
        void m712if(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr);

        void o(@NonNull fe.qw qwVar);

        void pf(@Nullable Gesture gesture, @NonNull PointF pointF);

        void ppp();

        void qw(@NonNull rg.qw qwVar);

        void rg(@NonNull fe.vvv.qw.ad adVar);

        /* renamed from: switch  reason: not valid java name */
        void m713switch(CameraException cameraException);

        void th();

        void uk(@Nullable Gesture gesture, boolean z, @NonNull PointF pointF);

        void yj();
    }

    public class ad implements Callable<Task<Void>> {
        public ad() {
        }

        /* renamed from: qw */
        public Task<Void> call() {
            return CameraEngine.this.V();
        }
    }

    public class de implements CameraOrchestrator.Callback {
        public de() {
        }

        public void ad(@NonNull String str, @NonNull Exception exc) {
            CameraEngine.this.M(exc, false);
        }

        @NonNull
        public fe.vvv.qw.p037if.yj qw(@NonNull String str) {
            return CameraEngine.this.f6716ad;
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Throwable f6721ad;

        public fe(Throwable th2) {
            this.f6721ad = th2;
        }

        public void run() {
            Throwable th2 = this.f6721ad;
            if (th2 instanceof CameraException) {
                CameraException cameraException = (CameraException) th2;
                if (cameraException.isUnrecoverable()) {
                    CameraEngine.f6715i.ad("EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                    CameraEngine.this.mmm(false);
                }
                CameraEngine.f6715i.ad("EXCEPTION:", "Got CameraException. Dispatching to callback.");
                CameraEngine.this.f6719yj.m713switch(cameraException);
                return;
            }
            CameraEngine.f6715i.ad("EXCEPTION:", "Unexpected error! Executing destroy(true).");
            CameraEngine.this.mmm(true);
            CameraEngine.f6715i.ad("EXCEPTION:", "Unexpected error! Throwing.");
            Throwable th3 = this.f6721ad;
            if (th3 instanceof RuntimeException) {
                throw ((RuntimeException) th3);
            }
            throw new RuntimeException(this.f6721ad);
        }
    }

    public class i implements Callable<Task<Void>> {
        public i() {
        }

        /* renamed from: qw */
        public Task<Void> call() {
            return CameraEngine.this.U();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$if  reason: invalid class name */
    public class Cif implements Thread.UncaughtExceptionHandler {
        public Cif() {
        }

        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
            CameraEngine.this.M(th2, true);
        }

        public /* synthetic */ Cif(CameraEngine cameraEngine, de deVar) {
            this();
        }
    }

    public class o implements Callable<Task<Void>> {
        public o() {
        }

        /* renamed from: qw */
        public Task<Void> call() {
            if (CameraEngine.this.v() == null || !CameraEngine.this.v().when()) {
                return Tasks.forCanceled();
            }
            return CameraEngine.this.Q();
        }
    }

    public class pf implements Callable<Task<Void>> {
        public pf() {
        }

        /* renamed from: qw */
        public Task<Void> call() {
            return CameraEngine.this.T();
        }
    }

    public class qw implements Callable<Task<Void>> {
        public qw() {
        }

        /* renamed from: qw */
        public Task<Void> call() {
            return CameraEngine.this.S();
        }
    }

    public class rg implements OnCompleteListener<Void> {
        public final /* synthetic */ CountDownLatch qw;

        public rg(CameraEngine cameraEngine, CountDownLatch countDownLatch) {
            this.qw = countDownLatch;
        }

        public void onComplete(@NonNull Task<Void> task) {
            this.qw.countDown();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$switch  reason: invalid class name */
    public static class Cswitch implements Thread.UncaughtExceptionHandler {
        public Cswitch() {
        }

        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
            CameraEngine.f6715i.i("EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th2);
        }

        public /* synthetic */ Cswitch(de deVar) {
            this();
        }
    }

    public class th implements SuccessContinuation<fe.vvv.qw.ad, Void> {
        public th() {
        }

        @NonNull
        /* renamed from: qw */
        public Task<Void> then(@Nullable fe.vvv.qw.ad adVar) {
            if (adVar != null) {
                CameraEngine.this.f6719yj.rg(adVar);
                return Tasks.forResult(null);
            }
            throw new RuntimeException("Null options!");
        }
    }

    public class uk implements OnSuccessListener<Void> {
        public uk() {
        }

        /* renamed from: qw */
        public void onSuccess(Void voidR) {
            CameraEngine.this.f6719yj.yj();
        }
    }

    public class yj implements Callable<Task<fe.vvv.qw.ad>> {
        public yj() {
        }

        /* renamed from: qw */
        public Task<fe.vvv.qw.ad> call() {
            CameraEngine cameraEngine = CameraEngine.this;
            if (cameraEngine.nn(cameraEngine.e())) {
                return CameraEngine.this.R();
            }
            CameraEngine.f6715i.ad("onStartEngine:", "No camera available for facing", CameraEngine.this.e());
            throw new CameraException(6);
        }
    }

    public CameraEngine(@NonNull Callback callback) {
        this.f6719yj = callback;
        this.f6717th = new Handler(Looper.getMainLooper());
        W(false);
    }

    public abstract int A();

    public abstract void A0(int i2);

    @NonNull
    public final CameraState B() {
        return this.f6718uk.ppp();
    }

    public abstract void B0(int i2);

    @NonNull
    public final CameraState C() {
        return this.f6718uk.ggg();
    }

    public abstract void C0(@NonNull VideoCodec videoCodec);

    @Nullable
    public abstract fe.vvv.qw.xxx.ad D(@NonNull Reference reference);

    public abstract void D0(int i2);

    public abstract int E();

    public abstract void E0(long j);

    @NonNull
    public abstract VideoCodec F();

    public abstract void F0(@NonNull SizeSelector sizeSelector);

    public abstract int G();

    public abstract void G0(@NonNull WhiteBalance whiteBalance);

    public abstract long H();

    public abstract void H0(float f, @Nullable PointF[] pointFArr, boolean z);

    @Nullable
    public abstract fe.vvv.qw.xxx.ad I(@NonNull Reference reference);

    @NonNull
    public Task<Void> I0() {
        f6715i.de("START:", "scheduled. State:", B());
        Task<Void> L0 = L0();
        K0();
        M0();
        return L0;
    }

    @NonNull
    public abstract SizeSelector J();

    public abstract void J0(@Nullable Gesture gesture, @NonNull fe.vvv.qw.when.ad adVar, @NonNull PointF pointF);

    @NonNull
    public abstract WhiteBalance K();

    @NonNull
    public final Task<Void> K0() {
        return this.f6718uk.xxx(CameraState.ENGINE, CameraState.BIND, true, new o());
    }

    public abstract float L();

    @NonNull
    public final Task<Void> L0() {
        return this.f6718uk.xxx(CameraState.OFF, CameraState.ENGINE, true, new yj()).onSuccessTask(new th());
    }

    public final void M(@NonNull Throwable th2, boolean z) {
        if (z) {
            f6715i.ad("EXCEPTION:", "Handler thread is gone. Replacing.");
            W(false);
        }
        f6715i.ad("EXCEPTION:", "Scheduling on the crash handler...");
        this.f6717th.post(new fe(th2));
    }

    @NonNull
    public final Task<Void> M0() {
        return this.f6718uk.xxx(CameraState.BIND, CameraState.PREVIEW, true, new qw());
    }

    public final boolean N() {
        return this.f6718uk.vvv();
    }

    @NonNull
    public Task<Void> N0(boolean z) {
        f6715i.de("STOP:", "scheduled. State:", B());
        Q0(z);
        O0(z);
        return P0(z);
    }

    public abstract boolean O();

    @NonNull
    public final Task<Void> O0(boolean z) {
        return this.f6718uk.xxx(CameraState.BIND, CameraState.ENGINE, !z, new pf());
    }

    public abstract boolean P();

    @NonNull
    public final Task<Void> P0(boolean z) {
        return this.f6718uk.xxx(CameraState.ENGINE, CameraState.OFF, !z, new i()).addOnSuccessListener(new uk());
    }

    @NonNull
    public abstract Task<Void> Q();

    @NonNull
    public final Task<Void> Q0(boolean z) {
        return this.f6718uk.xxx(CameraState.PREVIEW, CameraState.BIND, !z, new ad());
    }

    @NonNull
    public abstract Task<fe.vvv.qw.ad> R();

    public abstract void R0();

    @NonNull
    public abstract Task<Void> S();

    public abstract void S0(@NonNull fe.qw qwVar);

    @NonNull
    public abstract Task<Void> T();

    public abstract void T0(@NonNull fe.qw qwVar);

    @NonNull
    public abstract Task<Void> U();

    public abstract void U0(@NonNull rg.qw qwVar, @Nullable File file, @Nullable FileDescriptor fileDescriptor);

    @NonNull
    public abstract Task<Void> V();

    public abstract void V0(@NonNull rg.qw qwVar, @NonNull File file);

    public final void W(boolean z) {
        fe.vvv.qw.p037if.yj yjVar = this.f6716ad;
        if (yjVar != null) {
            yjVar.qw();
        }
        fe.vvv.qw.p037if.yj fe2 = fe.vvv.qw.p037if.yj.fe("CameraViewEngine");
        this.f6716ad = fe2;
        fe2.yj().setUncaughtExceptionHandler(new Cif(this, (de) null));
        if (z) {
            this.f6718uk.yj();
        }
    }

    public void X() {
        f6715i.de("RESTART:", "scheduled. State:", B());
        N0(false);
        I0();
    }

    @NonNull
    public Task<Void> Y() {
        f6715i.de("RESTART BIND:", "scheduled. State:", B());
        Q0(false);
        O0(false);
        K0();
        return M0();
    }

    @NonNull
    public Task<Void> Z() {
        f6715i.de("RESTART PREVIEW:", "scheduled. State:", B());
        Q0(false);
        return M0();
    }

    public abstract long a();

    public abstract void a0(@NonNull Audio audio);

    public final void aaa(boolean z, int i2) {
        f6715i.de("DESTROY:", "state:", B(), "thread:", Thread.currentThread(), "depth:", Integer.valueOf(i2), "unrecoverably:", Boolean.valueOf(z));
        if (z) {
            this.f6716ad.yj().setUncaughtExceptionHandler(new Cswitch((de) null));
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        N0(true).addOnCompleteListener(this.f6716ad.rg(), new rg(this, countDownLatch));
        try {
            if (!countDownLatch.await(6, TimeUnit.SECONDS)) {
                f6715i.ad("DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", Thread.currentThread(), "Handler thread:", this.f6716ad.yj());
                int i3 = i2 + 1;
                if (i3 < 2) {
                    W(true);
                    f6715i.ad("DESTROY: Trying again on thread:", this.f6716ad.yj());
                    aaa(z, i3);
                    return;
                }
                f6715i.i("DESTROY: Giving up because DESTROY_RETRIES was reached.");
            }
        } catch (InterruptedException unused) {
        }
    }

    @NonNull
    public final Callback b() {
        return this.f6719yj;
    }

    public abstract void b0(int i2);

    @Nullable
    public abstract fe.vvv.qw.ad c();

    public abstract void c0(@NonNull AudioCodec audioCodec);

    public abstract float d();

    public abstract void d0(long j);

    @NonNull
    public abstract Facing e();

    public abstract void e0(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z);

    @NonNull
    public abstract Audio eee();

    @NonNull
    public abstract Flash f();

    public abstract void f0(@NonNull Facing facing);

    public final void fe() {
        f6715i.de("onSurfaceAvailable:", "Size is", v().m716if());
        K0();
        M0();
    }

    public abstract int g();

    public abstract void g0(@NonNull Flash flash);

    public abstract int h();

    public abstract void h0(int i2);

    public abstract void i0(int i2);

    public abstract int j();

    public abstract void j0(int i2);

    public abstract int k();

    public abstract void k0(int i2);

    @NonNull
    public abstract Hdr l();

    public abstract void l0(boolean z);

    @Nullable
    public abstract Location m();

    public abstract void m0(@NonNull Hdr hdr);

    public void mmm(boolean z) {
        aaa(z, 0);
    }

    @NonNull
    public abstract Mode n();

    public abstract void n0(@Nullable Location location);

    public abstract boolean nn(@NonNull Facing facing);

    public abstract void o0(@NonNull Mode mode);

    @NonNull
    public final fe.vvv.qw.yj.pf.qw p() {
        return this.f6718uk;
    }

    public abstract void p0(@Nullable Overlay overlay);

    @NonNull
    public abstract PictureFormat q();

    public abstract void q0(@NonNull PictureFormat pictureFormat);

    @NonNull
    public abstract fe.vvv.qw.yj.i.qw qqq();

    public abstract boolean r();

    public abstract void r0(boolean z);

    public abstract int rrr();

    @Nullable
    public abstract fe.vvv.qw.xxx.ad s(@NonNull Reference reference);

    public abstract void s0(@NonNull SizeSelector sizeSelector);

    @NonNull
    public abstract SizeSelector t();

    public abstract void t0(boolean z);

    public final void th() {
        f6715i.de("onSurfaceDestroyed");
        Q0(false);
        O0(false);
    }

    @NonNull
    public abstract AudioCodec tt();

    public abstract boolean u();

    public abstract void u0(boolean z);

    @Nullable
    public abstract CameraPreview v();

    public abstract void v0(@NonNull CameraPreview cameraPreview);

    public abstract float w();

    public abstract void w0(float f);

    public abstract boolean x();

    public abstract void x0(boolean z);

    @Nullable
    public abstract fe.vvv.qw.xxx.ad y(@NonNull Reference reference);

    public abstract void y0(@Nullable SizeSelector sizeSelector);

    public abstract int z();

    public abstract void z0(int i2);
}
