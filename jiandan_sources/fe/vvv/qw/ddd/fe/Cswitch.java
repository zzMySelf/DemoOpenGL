package fe.vvv.qw.ddd.fe;

import android.opengl.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.internal.Pool;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import fe.vvv.ad.uk.fe;

@RequiresApi(api = 18)
/* renamed from: fe.vvv.qw.ddd.fe.switch  reason: invalid class name */
public class Cswitch extends ppp<Cif> {
    public static final CameraLogger c = CameraLogger.qw(Cswitch.class.getSimpleName());
    public Pool<ad> a = new Pool<>(Integer.MAX_VALUE, new qw(this));
    public long b = Long.MIN_VALUE;
    public fe.vvv.ad.ad.qw eee;
    public int qqq;
    public fe rrr;
    public fe.vvv.qw.p037if.fe tt;

    /* renamed from: fe.vvv.qw.ddd.fe.switch$ad */
    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public long f8926ad;

        /* renamed from: de  reason: collision with root package name */
        public float[] f8927de;
        public long qw;

        public /* synthetic */ ad(qw qwVar) {
            this();
        }

        public final long ad() {
            return this.qw / 1000;
        }

        public ad() {
            this.f8927de = new float[16];
        }
    }

    /* renamed from: fe.vvv.qw.ddd.fe.switch$qw */
    public class qw implements Pool.Factory<ad> {
        public qw(Cswitch switchR) {
        }

        /* renamed from: ad */
        public ad qw() {
            return new ad((qw) null);
        }
    }

    public Cswitch(@NonNull Cif ifVar) {
        super(ifVar.ad());
    }

    public boolean a(long j) {
        if (!super.a(j)) {
            c.de("shouldRenderFrame - Dropping frame because of super()");
            return false;
        } else if (this.nn <= 10 || o("frame") <= 2) {
            return true;
        } else {
            c.de("shouldRenderFrame - Dropping, we already have too many pending events:", Integer.valueOf(o("frame")));
            return false;
        }
    }

    @NonNull
    public ad b() {
        if (!this.a.rg()) {
            return this.a.fe();
        }
        throw new RuntimeException("Need more frames than this! Please increase the pool size.");
    }

    public final void c(@NonNull Filter filter) {
        this.tt.rg(filter);
    }

    public final void d(@NonNull ad adVar) {
        ad adVar2 = adVar;
        if (!a(adVar.ad())) {
            this.a.th(adVar2);
            return;
        }
        if (this.nn == 1) {
            m1031switch(adVar2.f8926ad);
        }
        if (this.b == Long.MIN_VALUE) {
            this.b = adVar.ad();
        }
        if (!pf()) {
            if (adVar.ad() - this.b > i()) {
                c.i("onEvent -", "frameNumber:", Integer.valueOf(this.nn), "timestampUs:", Long.valueOf(adVar.ad()), "firstTimeUs:", Long.valueOf(this.b), "- reached max length! deltaUs:", Long.valueOf(adVar.ad() - this.b));
                when();
            }
        }
        c.de("onEvent -", "frameNumber:", Integer.valueOf(this.nn), "timestampUs:", Long.valueOf(adVar.ad()), "hasReachedMaxLength:", Boolean.valueOf(pf()), "thread:", Thread.currentThread(), "- draining.");
        th(false);
        c.de("onEvent -", "frameNumber:", Integer.valueOf(this.nn), "timestampUs:", Long.valueOf(adVar.ad()), "hasReachedMaxLength:", Boolean.valueOf(pf()), "thread:", Thread.currentThread(), "- drawing.");
        float[] fArr = adVar2.f8927de;
        C c2 = this.xxx;
        float f = ((Cif) c2).f367if;
        float f2 = ((Cif) c2).f368switch;
        Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, (float) this.qqq, 0.0f, 0.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (((Cif) this.xxx).de()) {
            C c3 = this.xxx;
            ((Cif) c3).f8916o.qw(((Cif) c3).f8915i);
            Matrix.translateM(((Cif) this.xxx).f8916o.ad(), 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(((Cif) this.xxx).f8916o.ad(), 0, (float) ((Cif) this.xxx).f8917pf, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(((Cif) this.xxx).f8916o.ad(), 0, -0.5f, -0.5f, 0.0f);
        }
        c.de("onEvent -", "frameNumber:", Integer.valueOf(this.nn), "timestampUs:", Long.valueOf(adVar.ad()), "hasReachedMaxLength:", Boolean.valueOf(pf()), "thread:", Thread.currentThread(), "- gl rendering.");
        this.tt.th(fArr);
        this.tt.qw(adVar.ad());
        if (((Cif) this.xxx).de()) {
            ((Cif) this.xxx).f8916o.fe(adVar.ad());
        }
        this.rrr.uk(adVar2.qw);
        this.rrr.pf();
        this.a.th(adVar2);
        c.de("onEvent -", "frameNumber:", Integer.valueOf(this.nn), "timestampUs:", Long.valueOf(adVar.ad()), "hasReachedMaxLength:", Boolean.valueOf(pf()), "thread:", Thread.currentThread(), "- gl rendered.");
    }

    public void nn() {
        super.nn();
        this.a.ad();
        fe feVar = this.rrr;
        if (feVar != null) {
            feVar.yj();
            this.rrr = null;
        }
        fe.vvv.qw.p037if.fe feVar2 = this.tt;
        if (feVar2 != null) {
            feVar2.fe();
            this.tt = null;
        }
        fe.vvv.ad.ad.qw qwVar = this.eee;
        if (qwVar != null) {
            qwVar.i();
            this.eee = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ppp(@androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.Nullable java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -1274492040(0xffffffffb408cb78, float:-1.2740009E-7)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 97692013(0x5d2a96d, float:1.9810542E-35)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "frame"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "filter"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            if (r4 == 0) goto L_0x0030
            if (r4 == r2) goto L_0x002a
            goto L_0x0035
        L_0x002a:
            fe.vvv.qw.ddd.fe.switch$ad r5 = (fe.vvv.qw.ddd.fe.Cswitch.ad) r5
            r3.d(r5)
            goto L_0x0035
        L_0x0030:
            com.otaliastudios.cameraview.filter.Filter r5 = (com.otaliastudios.cameraview.filter.Filter) r5
            r3.c(r5)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.ddd.fe.Cswitch.ppp(java.lang.String, java.lang.Object):void");
    }

    public void vvv(@NonNull MediaEncoderEngine.qw qwVar, long j) {
        C c2 = this.xxx;
        this.qqq = ((Cif) c2).f8938rg;
        ((Cif) c2).f8938rg = 0;
        super.vvv(qwVar, j);
        fe.vvv.ad.ad.qw qwVar2 = new fe.vvv.ad.ad.qw(((Cif) this.xxx).when, 1);
        this.eee = qwVar2;
        fe feVar = new fe(qwVar2, this.ddd, true);
        this.rrr = feVar;
        feVar.th();
        this.tt = new fe.vvv.qw.p037if.fe(((Cif) this.xxx).f8918uk);
    }
}
