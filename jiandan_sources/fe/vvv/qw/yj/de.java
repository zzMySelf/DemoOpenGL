package fe.vvv.qw.yj;

import android.location.Location;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidubce.services.vod.VodClient;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.size.SizeSelectors;
import com.otaliastudios.cameraview.video.VideoRecorder;
import fe.vvv.qw.fe;
import fe.vvv.qw.rg;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class de extends CameraEngine {
    public int A;
    public int B;
    public int C;
    public int D;
    public Overlay E;
    public AudioCodec aaa;
    public Flash ddd;
    public float e;
    public PictureFormat eee;
    public boolean f;
    public boolean g;
    public fe.vvv.qw.xxx.ad ggg;
    public boolean h;

    /* renamed from: if  reason: not valid java name */
    public PictureRecorder f397if;
    public float j;
    public boolean k;
    public fe.vvv.qw.o.ad l;
    public final fe.vvv.qw.yj.i.qw m = new fe.vvv.qw.yj.i.qw();
    public VideoCodec mmm;
    @Nullable
    public SizeSelector n;
    public WhiteBalance nn;

    /* renamed from: o  reason: collision with root package name */
    public CameraPreview f9179o;
    public SizeSelector p;

    /* renamed from: pf  reason: collision with root package name */
    public fe.vvv.qw.ad f9180pf;
    public fe.vvv.qw.xxx.ad ppp;
    public SizeSelector q;
    public Hdr qqq;
    public Facing r;
    public Location rrr;
    public Mode s;

    /* renamed from: switch  reason: not valid java name */
    public VideoRecorder f398switch;
    public Audio t;
    public float tt;
    public long u;
    public int v;
    public int vvv;
    public int w;
    public fe.vvv.qw.xxx.ad when;
    public int x;
    public boolean xxx;
    public long y;
    public int z;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            de.this.X();
        }
    }

    /* renamed from: fe.vvv.qw.yj.de$de  reason: collision with other inner class name */
    public class C0319de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.qw f9182ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f9183th;

        public C0319de(fe.qw qwVar, boolean z) {
            this.f9182ad = qwVar;
            this.f9183th = z;
        }

        public void run() {
            CameraEngine.f6715i.de("takePicture:", "running. isTakingPicture:", Boolean.valueOf(de.this.O()));
            if (!de.this.O()) {
                if (de.this.s != Mode.VIDEO) {
                    fe.qw qwVar = this.f9182ad;
                    qwVar.qw = false;
                    de deVar = de.this;
                    qwVar.f8961ad = deVar.rrr;
                    qwVar.f8964rg = deVar.r;
                    fe.qw qwVar2 = this.f9182ad;
                    de deVar2 = de.this;
                    qwVar2.f8966yj = deVar2.eee;
                    deVar2.s1(qwVar2, this.f9183th);
                    return;
                }
                throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.qw f9185ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f9186th;

        public fe(fe.qw qwVar, boolean z) {
            this.f9185ad = qwVar;
            this.f9186th = z;
        }

        public void run() {
            CameraEngine.f6715i.de("takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(de.this.O()));
            if (!de.this.O()) {
                fe.qw qwVar = this.f9185ad;
                de deVar = de.this;
                qwVar.f8961ad = deVar.rrr;
                qwVar.qw = true;
                qwVar.f8964rg = deVar.r;
                this.f9185ad.f8966yj = PictureFormat.JPEG;
                de.this.t1(this.f9185ad, fe.vvv.qw.xxx.qw.uk(de.this.n1(Reference.OUTPUT)), this.f9186th);
            }
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Facing f9188ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Facing f9189th;

        public qw(Facing facing, Facing facing2) {
            this.f9188ad = facing;
            this.f9189th = facing2;
        }

        public void run() {
            if (de.this.nn(this.f9188ad)) {
                de.this.X();
            } else {
                Facing unused = de.this.r = this.f9189th;
            }
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ File f9191ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ rg.qw f9192th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ FileDescriptor f9194yj;

        public rg(File file, rg.qw qwVar, FileDescriptor fileDescriptor) {
            this.f9191ad = file;
            this.f9192th = qwVar;
            this.f9194yj = fileDescriptor;
        }

        public void run() {
            CameraEngine.f6715i.de("takeVideo:", "running. isTakingVideo:", Boolean.valueOf(de.this.P()));
            if (!de.this.P()) {
                if (de.this.s != Mode.PICTURE) {
                    File file = this.f9191ad;
                    if (file != null) {
                        this.f9192th.f9083rg = file;
                    } else {
                        FileDescriptor fileDescriptor = this.f9194yj;
                        if (fileDescriptor != null) {
                            this.f9192th.f9084th = fileDescriptor;
                        } else {
                            throw new IllegalStateException("file and fileDescriptor are both null.");
                        }
                    }
                    rg.qw qwVar = this.f9192th;
                    qwVar.qw = false;
                    de deVar = de.this;
                    qwVar.f9085uk = deVar.mmm;
                    qwVar.f9080i = deVar.aaa;
                    qwVar.f9077ad = deVar.rrr;
                    qwVar.f9086yj = deVar.r;
                    this.f9192th.f9081o = de.this.t;
                    this.f9192th.f9082pf = de.this.u;
                    this.f9192th.f390if = de.this.v;
                    this.f9192th.when = de.this.w;
                    this.f9192th.ggg = de.this.x;
                    de.this.u1(this.f9192th);
                    return;
                }
                throw new IllegalStateException("Can't record video while in PICTURE mode");
            }
        }
    }

    public class th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ rg.qw f9195ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ File f9196th;

        public th(rg.qw qwVar, File file) {
            this.f9195ad = qwVar;
            this.f9196th = file;
        }

        public void run() {
            CameraEngine.f6715i.de("takeVideoSnapshot:", "running. isTakingVideo:", Boolean.valueOf(de.this.P()));
            rg.qw qwVar = this.f9195ad;
            qwVar.f9083rg = this.f9196th;
            qwVar.qw = true;
            de deVar = de.this;
            qwVar.f9085uk = deVar.mmm;
            qwVar.f9080i = deVar.aaa;
            qwVar.f9077ad = deVar.rrr;
            qwVar.f9086yj = deVar.r;
            this.f9195ad.when = de.this.w;
            this.f9195ad.ggg = de.this.x;
            this.f9195ad.f9081o = de.this.t;
            this.f9195ad.f9082pf = de.this.u;
            this.f9195ad.f390if = de.this.v;
            de.this.v1(this.f9195ad, fe.vvv.qw.xxx.qw.uk(de.this.n1(Reference.OUTPUT)));
        }
    }

    public class uk implements Runnable {
        public uk() {
        }

        public void run() {
            fe.vvv.qw.xxx.ad i1 = de.this.i1();
            if (i1.equals(de.this.ppp)) {
                CameraEngine.f6715i.de("onSurfaceChanged:", "The computed preview size is identical. No op.");
                return;
            }
            CameraEngine.f6715i.de("onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
            de deVar = de.this;
            deVar.ppp = i1;
            deVar.q1();
        }
    }

    public class yj implements Runnable {
        public yj() {
        }

        public void run() {
            CameraEngine.f6715i.de("stopVideo", "running. isTakingVideo?", Boolean.valueOf(de.this.P()));
            de.this.r1();
        }
    }

    public de(@NonNull CameraEngine.Callback callback) {
        super(callback);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
    }

    public final int A() {
        return this.z;
    }

    public final void A0(int i2) {
        this.z = i2;
    }

    public final void B0(int i2) {
        this.w = i2;
    }

    public final void C0(@NonNull VideoCodec videoCodec) {
        this.mmm = videoCodec;
    }

    @Nullable
    public final fe.vvv.qw.xxx.ad D(@NonNull Reference reference) {
        fe.vvv.qw.xxx.ad y2 = y(reference);
        if (y2 == null) {
            return null;
        }
        boolean ad2 = qqq().ad(reference, Reference.VIEW);
        int i2 = ad2 ? this.A : this.z;
        int i3 = ad2 ? this.z : this.A;
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        if (i3 <= 0) {
            i3 = Integer.MAX_VALUE;
        }
        float o2 = fe.vvv.qw.xxx.qw.uk(y2).o();
        if (fe.vvv.qw.xxx.qw.th(i2, i3).o() >= o2) {
            int min = Math.min(y2.fe(), i3);
            return new fe.vvv.qw.xxx.ad((int) Math.floor((double) (((float) min) * o2)), min);
        }
        int min2 = Math.min(y2.rg(), i2);
        return new fe.vvv.qw.xxx.ad(min2, (int) Math.floor((double) (((float) min2) / o2)));
    }

    public final void D0(int i2) {
        this.v = i2;
    }

    public final int E() {
        return this.w;
    }

    public final void E0(long j2) {
        this.u = j2;
    }

    @NonNull
    public final VideoCodec F() {
        return this.mmm;
    }

    public final void F0(@NonNull SizeSelector sizeSelector) {
        this.q = sizeSelector;
    }

    public final int G() {
        return this.v;
    }

    public final long H() {
        return this.u;
    }

    @Nullable
    public final fe.vvv.qw.xxx.ad I(@NonNull Reference reference) {
        fe.vvv.qw.xxx.ad adVar = this.when;
        if (adVar == null || this.s == Mode.PICTURE) {
            return null;
        }
        return qqq().ad(Reference.SENSOR, reference) ? adVar.ad() : adVar;
    }

    @NonNull
    public final SizeSelector J() {
        return this.q;
    }

    @NonNull
    public final WhiteBalance K() {
        return this.nn;
    }

    public final float L() {
        return this.tt;
    }

    public final boolean O() {
        return this.f397if != null;
    }

    public final boolean P() {
        VideoRecorder videoRecorder = this.f398switch;
        return videoRecorder != null && videoRecorder.o();
    }

    public final void R0() {
        p().uk("stop video", true, new yj());
    }

    public void S0(@NonNull fe.qw qwVar) {
        p().ddd("take picture", CameraState.BIND, new C0319de(qwVar, this.g));
    }

    public void T0(@NonNull fe.qw qwVar) {
        p().ddd("take picture snapshot", CameraState.BIND, new fe(qwVar, this.h));
    }

    public final void U0(@NonNull rg.qw qwVar, @Nullable File file, @Nullable FileDescriptor fileDescriptor) {
        p().ddd("take video", CameraState.BIND, new rg(file, qwVar, fileDescriptor));
    }

    public final void V0(@NonNull rg.qw qwVar, @NonNull File file) {
        p().ddd("take video snapshot", CameraState.BIND, new th(qwVar, file));
    }

    public final long a() {
        return this.y;
    }

    public final void a0(@NonNull Audio audio) {
        if (this.t != audio) {
            if (P()) {
                CameraEngine.f6715i.i("Audio setting was changed while recording. Changes will take place starting from next video");
            }
            this.t = audio;
        }
    }

    public final void b0(int i2) {
        this.x = i2;
    }

    @Nullable
    public final fe.vvv.qw.ad c() {
        return this.f9180pf;
    }

    public final void c0(@NonNull AudioCodec audioCodec) {
        this.aaa = audioCodec;
    }

    public final float d() {
        return this.e;
    }

    public final void d0(long j2) {
        this.y = j2;
    }

    public void de() {
        b().th();
    }

    @NonNull
    public final Facing e() {
        return this.r;
    }

    @NonNull
    public final Audio eee() {
        return this.t;
    }

    @NonNull
    public final Flash f() {
        return this.ddd;
    }

    public final void f0(@NonNull Facing facing) {
        Facing facing2 = this.r;
        if (facing != facing2) {
            this.r = facing;
            p().ddd("facing", CameraState.ENGINE, new qw(facing, facing2));
        }
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad f1() {
        return g1(this.s);
    }

    public final int g() {
        return this.vvv;
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad g1(@NonNull Mode mode) {
        Collection<fe.vvv.qw.xxx.ad> collection;
        SizeSelector sizeSelector;
        boolean ad2 = qqq().ad(Reference.SENSOR, Reference.VIEW);
        if (mode == Mode.PICTURE) {
            sizeSelector = this.p;
            collection = this.f9180pf.o();
        } else {
            sizeSelector = this.q;
            collection = this.f9180pf.pf();
        }
        SizeSelector o2 = SizeSelectors.o(sizeSelector, SizeSelectors.de());
        ArrayList arrayList = new ArrayList(collection);
        fe.vvv.qw.xxx.ad adVar = o2.qw(arrayList).get(0);
        if (arrayList.contains(adVar)) {
            CameraEngine.f6715i.de("computeCaptureSize:", "result:", adVar, "flip:", Boolean.valueOf(ad2), "mode:", mode);
            return ad2 ? adVar.ad() : adVar;
        }
        throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
    }

    public final int h() {
        return this.C;
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad h1() {
        List<fe.vvv.qw.xxx.ad> k1 = k1();
        boolean ad2 = qqq().ad(Reference.SENSOR, Reference.VIEW);
        ArrayList arrayList = new ArrayList(k1.size());
        for (fe.vvv.qw.xxx.ad next : k1) {
            if (ad2) {
                next = next.ad();
            }
            arrayList.add(next);
        }
        fe.vvv.qw.xxx.qw th2 = fe.vvv.qw.xxx.qw.th(this.ppp.rg(), this.ppp.fe());
        if (ad2) {
            th2 = th2.ad();
        }
        int i2 = this.B;
        int i3 = this.C;
        if (i2 <= 0 || i2 == Integer.MAX_VALUE) {
            i2 = 640;
        }
        if (i3 <= 0 || i3 == Integer.MAX_VALUE) {
            i3 = 640;
        }
        fe.vvv.qw.xxx.ad adVar = new fe.vvv.qw.xxx.ad(i2, i3);
        CameraEngine.f6715i.de("computeFrameProcessingSize:", "targetRatio:", th2, "targetMaxSize:", adVar);
        SizeSelector ad3 = SizeSelectors.ad(th2, 0.0f);
        SizeSelector qw2 = SizeSelectors.qw(SizeSelectors.rg(adVar.fe()), SizeSelectors.th(adVar.rg()), SizeSelectors.de());
        fe.vvv.qw.xxx.ad adVar2 = SizeSelectors.o(SizeSelectors.qw(ad3, qw2), qw2, SizeSelectors.pf()).qw(arrayList).get(0);
        if (arrayList.contains(adVar2)) {
            if (ad2) {
                adVar2 = adVar2.ad();
            }
            CameraEngine.f6715i.de("computeFrameProcessingSize:", "result:", adVar2, "flip:", Boolean.valueOf(ad2));
            return adVar2;
        }
        throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
    }

    public final void i0(int i2) {
        this.C = i2;
    }

    @NonNull
    public final fe.vvv.qw.xxx.ad i1() {
        List<fe.vvv.qw.xxx.ad> m1 = m1();
        boolean ad2 = qqq().ad(Reference.SENSOR, Reference.VIEW);
        ArrayList arrayList = new ArrayList(m1.size());
        for (fe.vvv.qw.xxx.ad next : m1) {
            if (ad2) {
                next = next.ad();
            }
            arrayList.add(next);
        }
        fe.vvv.qw.xxx.ad n1 = n1(Reference.VIEW);
        if (n1 != null) {
            fe.vvv.qw.xxx.qw th2 = fe.vvv.qw.xxx.qw.th(this.when.rg(), this.when.fe());
            if (ad2) {
                th2 = th2.ad();
            }
            CameraEngine.f6715i.de("computePreviewStreamSize:", "targetRatio:", th2, "targetMinSize:", n1);
            SizeSelector qw2 = SizeSelectors.qw(SizeSelectors.ad(th2, 0.0f), SizeSelectors.de());
            SizeSelector qw3 = SizeSelectors.qw(SizeSelectors.uk(n1.fe()), SizeSelectors.i(n1.rg()), SizeSelectors.pf());
            SizeSelector o2 = SizeSelectors.o(SizeSelectors.qw(qw2, qw3), qw3, qw2, SizeSelectors.de());
            SizeSelector sizeSelector = this.n;
            if (sizeSelector != null) {
                o2 = SizeSelectors.o(sizeSelector, o2);
            }
            fe.vvv.qw.xxx.ad adVar = o2.qw(arrayList).get(0);
            if (arrayList.contains(adVar)) {
                if (ad2) {
                    adVar = adVar.ad();
                }
                CameraEngine.f6715i.de("computePreviewStreamSize:", "result:", adVar, "flip:", Boolean.valueOf(ad2));
                return adVar;
            }
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        throw new IllegalStateException("targetMinSize should not be null here.");
    }

    public final int j() {
        return this.B;
    }

    public final void j0(int i2) {
        this.B = i2;
    }

    @NonNull
    public fe.vvv.qw.o.ad j1() {
        if (this.l == null) {
            this.l = p1(this.D);
        }
        return this.l;
    }

    public final int k() {
        return this.D;
    }

    public final void k0(int i2) {
        this.D = i2;
    }

    @NonNull
    public abstract List<fe.vvv.qw.xxx.ad> k1();

    @NonNull
    public final Hdr l() {
        return this.qqq;
    }

    @Nullable
    public final Overlay l1() {
        return this.E;
    }

    @Nullable
    public final Location m() {
        return this.rrr;
    }

    @NonNull
    public abstract List<fe.vvv.qw.xxx.ad> m1();

    @NonNull
    public final Mode n() {
        return this.s;
    }

    @Nullable
    public final fe.vvv.qw.xxx.ad n1(@NonNull Reference reference) {
        CameraPreview cameraPreview = this.f9179o;
        if (cameraPreview == null) {
            return null;
        }
        if (qqq().ad(Reference.VIEW, reference)) {
            return cameraPreview.m716if().ad();
        }
        return cameraPreview.m716if();
    }

    public final void o0(@NonNull Mode mode) {
        if (mode != this.s) {
            this.s = mode;
            p().ddd(VodClient.PARA_MODE, CameraState.ENGINE, new ad());
        }
    }

    public final boolean o1() {
        return this.xxx;
    }

    public final void p0(@Nullable Overlay overlay) {
        this.E = overlay;
    }

    @NonNull
    public abstract fe.vvv.qw.o.ad p1(int i2);

    @CallSuper
    public void ppp(@Nullable rg.qw qwVar, @Nullable Exception exc) {
        this.f398switch = null;
        if (qwVar != null) {
            b().qw(qwVar);
            return;
        }
        CameraEngine.f6715i.ad("onVideoResult", "result is null: something went wrong.", exc);
        b().m713switch(new CameraException(exc, 5));
    }

    @NonNull
    public final PictureFormat q() {
        return this.eee;
    }

    public abstract void q1();

    @NonNull
    public final fe.vvv.qw.yj.i.qw qqq() {
        return this.m;
    }

    public void qw() {
        b().i();
    }

    public final boolean r() {
        return this.g;
    }

    public final void r0(boolean z2) {
        this.g = z2;
    }

    public void r1() {
        VideoRecorder videoRecorder = this.f398switch;
        if (videoRecorder != null) {
            videoRecorder.ppp(false);
        }
    }

    public final int rrr() {
        return this.x;
    }

    @Nullable
    public final fe.vvv.qw.xxx.ad s(@NonNull Reference reference) {
        fe.vvv.qw.xxx.ad adVar = this.when;
        if (adVar == null || this.s == Mode.VIDEO) {
            return null;
        }
        return qqq().ad(Reference.SENSOR, reference) ? adVar.ad() : adVar;
    }

    public final void s0(@NonNull SizeSelector sizeSelector) {
        this.p = sizeSelector;
    }

    public abstract void s1(@NonNull fe.qw qwVar, boolean z2);

    /* renamed from: switch  reason: not valid java name */
    public void m1045switch(boolean z2) {
        b().fe(!z2);
    }

    @NonNull
    public final SizeSelector t() {
        return this.p;
    }

    public final void t0(boolean z2) {
        this.h = z2;
    }

    public abstract void t1(@NonNull fe.qw qwVar, @NonNull fe.vvv.qw.xxx.qw qwVar2, boolean z2);

    @NonNull
    public final AudioCodec tt() {
        return this.aaa;
    }

    public final boolean u() {
        return this.h;
    }

    public abstract void u1(@NonNull rg.qw qwVar);

    @NonNull
    public final CameraPreview v() {
        return this.f9179o;
    }

    public final void v0(@NonNull CameraPreview cameraPreview) {
        CameraPreview cameraPreview2 = this.f9179o;
        if (cameraPreview2 != null) {
            cameraPreview2.qqq((CameraPreview.SurfaceCallback) null);
        }
        this.f9179o = cameraPreview;
        cameraPreview.qqq(this);
    }

    public abstract void v1(@NonNull rg.qw qwVar, @NonNull fe.vvv.qw.xxx.qw qwVar2);

    public final float w() {
        return this.j;
    }

    public final boolean w1() {
        long j2 = this.y;
        return j2 > 0 && j2 != Long.MAX_VALUE;
    }

    public final void when() {
        CameraEngine.f6715i.de("onSurfaceChanged:", "Size is", n1(Reference.VIEW));
        p().ddd("surface changed", CameraState.BIND, new uk());
    }

    public final boolean x() {
        return this.k;
    }

    public final void x0(boolean z2) {
        this.k = z2;
    }

    @Nullable
    public final fe.vvv.qw.xxx.ad y(@NonNull Reference reference) {
        fe.vvv.qw.xxx.ad adVar = this.ppp;
        if (adVar == null) {
            return null;
        }
        return qqq().ad(Reference.SENSOR, reference) ? adVar.ad() : adVar;
    }

    public final void y0(@Nullable SizeSelector sizeSelector) {
        this.n = sizeSelector;
    }

    public void yj(@Nullable fe.qw qwVar, @Nullable Exception exc) {
        this.f397if = null;
        if (qwVar != null) {
            b().o(qwVar);
            return;
        }
        CameraEngine.f6715i.ad("onPictureResult", "result is null: something went wrong.", exc);
        b().m713switch(new CameraException(exc, 4));
    }

    public final int z() {
        return this.A;
    }

    public final void z0(int i2) {
        this.A = i2;
    }
}
