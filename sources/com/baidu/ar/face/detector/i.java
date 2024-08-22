package com.baidu.ar.face.detector;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.p.b;
import com.baidu.ar.p.c;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.talos.core.render.views.lineargradient.LinearGradientManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private g f9466a = new g();

    /* renamed from: b  reason: collision with root package name */
    private long f9467b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f9468c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f9469d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9470e = true;

    /* renamed from: f  reason: collision with root package name */
    private long f9471f;

    /* renamed from: g  reason: collision with root package name */
    private long f9472g;

    /* renamed from: h  reason: collision with root package name */
    private k f9473h = new k();

    /* renamed from: i  reason: collision with root package name */
    private FaceAlgoConfig f9474i = new FaceAlgoConfig(180, 5, 0.03f, 1.0f);

    /* renamed from: j  reason: collision with root package name */
    private boolean f9475j = true;
    private AlgoHandleController k;
    private boolean l = false;
    private String m;
    private String n;
    private String o;
    private String[] p;
    private String q;
    private String r;
    private String s;
    private String t;

    private String a(String str) {
        return str.startsWith("file:///android_asset/") ? str.replace("file:///android_asset/", "") : str;
    }

    private void b() {
        try {
            long j2 = this.f9467b;
            if (j2 > 0) {
                FaceJniClient.releaseDetectCore(j2);
            }
            long j3 = this.f9468c;
            if (j3 > 0) {
                FaceJniClient.releaseTrackCore(j3);
            }
            long j4 = this.f9469d;
            if (j4 > 0) {
                FaceJniClient.releaseAnimateCore(j4);
            }
            this.f9467b = 0;
            this.f9468c = 0;
            this.f9469d = 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(boolean z) {
        FaceAlgoConfig faceAlgoConfig = this.f9474i;
        if (faceAlgoConfig != null) {
            faceAlgoConfig.setAutoCalibrate(z);
        }
    }

    private void m() {
        try {
            b.b("algo", "environment version= " + c.a() + ", face = " + FaceJniClient.getFaceAlgoVersion());
        } catch (Exception e2) {
        }
    }

    public i a(j jVar) {
        m();
        this.m = jVar.k();
        this.n = jVar.a();
        this.o = jVar.b();
        this.p = new String[]{jVar.c(), jVar.e(), jVar.d()};
        this.q = jVar.f();
        this.r = jVar.g();
        this.s = jVar.h();
        this.t = jVar.l();
        return this;
    }

    public void a(float f2) {
        if (this.f9474i != null) {
            b.a("bdar-face", "mTrackingMouthThreshold:" + f2);
            this.f9474i.setTrackingMouthThreshold(f2);
        }
    }

    public void a(float f2, float f3) {
        if (this.f9474i != null) {
            b.a("bdar-face", "mTrackingSmoothAlpha:" + f2 + " mTrackingSmoothThreshold:" + f3);
            this.f9474i.setTrackingSmoothAlpha(f2);
            this.f9474i.setTrackingSmoothThreshold(f3);
        }
    }

    public void a(int i2) {
        this.f9466a.b(i2);
        if (this.f9474i != null) {
            b.a("bdar-face", "setMaxTrackingFace:" + i2);
            this.f9474i.setMaxTrackingFace(i2);
        }
    }

    public void a(long j2) {
        AlgoHandleController algoHandleController = this.k;
        if (algoHandleController != null) {
            algoHandleController.destroyHandle(j2);
        }
    }

    public void a(Context context) {
        Context context2 = (Context) new WeakReference(context).get();
        if (context2 != null) {
            FaceJniClient.setAssetManager(context2.getApplicationContext().getAssets());
        }
    }

    public void a(AlgoHandleController algoHandleController) {
        this.k = algoHandleController;
    }

    public void a(boolean z) {
        if (this.f9474i == null) {
            return;
        }
        if (!z || ARAuth.checkFeatureAuth(FeatureCodes.FACE_DUMOJI)) {
            b.a("bdar-face", "setAnimojiMode:" + z);
            this.f9474i.setIsAnimojiMode(z);
            return;
        }
        b.a("bdar-face", "setAnimojiMode(true) hasn't auth");
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (this.f9474i != null) {
            b.a("bdar-face", "setAnimateMode needHeadPose:" + z + " needSkeleton:" + z2 + " needTriggers:" + z3);
            this.f9474i.setAnimateRunningMode(z, z2, z3);
        }
    }

    public void a(int[] iArr) {
        g gVar = this.f9466a;
        if (gVar != null) {
            gVar.a(iArr);
        } else {
            b.b("bdar-face", "mDetectSkiper is null when being configured");
        }
    }

    public boolean a() {
        return j();
    }

    public boolean a(boolean z, int i2) {
        if (!this.l) {
            b.c("bdar-face", "detect_frame track task executing modelLoad failed");
            return true;
        }
        if ((!this.f9470e) == z) {
            this.f9474i.setForceLost(true);
            this.f9470e = z;
        } else {
            this.f9474i.setForceLost(false);
        }
        this.f9474i.setMirror(false);
        this.f9474i.setTrackingRT(com.baidu.ar.face.c.a(i2));
        return false;
    }

    public void b(int i2) {
        if (this.f9474i != null) {
            b.a("bdar-face", "trackMode:" + i2);
            this.f9474i.setRunningMode(i2);
        }
    }

    public void b(long j2) {
        b.d("bdar-face", "[FaceHandlerThread] destroy handle:" + j2);
        FaceJniClient.destoryFrame(j2);
    }

    public g c() {
        return this.f9466a;
    }

    public void c(boolean z) {
        if (this.f9474i != null) {
            b.a("bdar-face", "setNeedExpression:" + z);
            this.f9474i.setNeedExpression(z);
        }
    }

    public AlgoHandleController d() {
        return this.k;
    }

    public void d(boolean z) {
        if (this.f9474i != null) {
            b.a("bdar-face", "setNeedRefineEyes:" + z);
            this.f9474i.setNeedRefineEyes(z);
        }
    }

    public long e() {
        return this.f9469d;
    }

    public void e(boolean z) {
        if (this.f9474i != null) {
            b.a("bdar-face", "setNeedRefineMouth:" + z);
            this.f9474i.setNeedRefineMouth(z);
        }
    }

    public long f() {
        return this.f9467b;
    }

    public void f(boolean z) {
        if (this.f9474i != null) {
            b.a("bdar-face", "setNeedHeadPose:" + z);
            this.f9474i.setNeedHeadPose(z);
        }
    }

    public FaceAlgoConfig g() {
        return this.f9474i;
    }

    public void g(boolean z) {
        if (this.f9474i != null) {
            b.a("bdar-face", "setNeedSkeleton:" + z);
            this.f9474i.setNeedSkeleton(z);
        }
    }

    public k h() {
        return this.f9473h;
    }

    public void h(boolean z) {
        if (this.f9474i != null) {
            b.a("bdar-face", "setNeedTriggers:" + z);
            this.f9474i.setNeedTriggers(z);
        }
    }

    public long i() {
        return this.f9468c;
    }

    public boolean j() {
        return this.l;
    }

    public boolean k() {
        return this.f9475j;
    }

    public i l() {
        if (com.baidu.ar.face.c.a(this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t)) {
            b.b("bdar-face", "init error! check face model!");
            return null;
        }
        b.a("bdar-face", "detect_frame load facemodel");
        boolean z = true;
        b(true);
        b.a("bdar-face", "imbin:" + this.m + "\nDetect:" + this.n + "\nTrack0:" + this.o + "\nTrack1:" + Arrays.toString(this.p) + "\nTrack2:" + this.q + "\nTrack3:" + this.r + "\nexpression:" + this.s + "\nmouth:" + this.t);
        String[] strArr = {ConstPath.KEY_DETECT, a(this.n)};
        String[] strArr2 = {LinearGradientManager.PROP_ANGLE, a(this.o), "heavy", a(this.p[0]), "medium", a(this.p[1]), "lite", a(this.p[2]), "mouth", a(this.t), ConstPath.KEY_EYES, a(this.q), "iris", a(this.r)};
        String[] strArr3 = {"animate", a(this.m), "expression", a(this.s)};
        this.f9467b = this.n.startsWith("file:///android_asset/") ? FaceJniClient.createDetectCoreFromAssetDir(strArr) : FaceJniClient.createDetectCore(strArr);
        this.f9468c = this.o.startsWith("file:///android_asset/") ? FaceJniClient.createTrackCoreFromAssetDir(strArr2) : FaceJniClient.createTrackCore(strArr2);
        this.f9469d = this.m.startsWith("file:///android_asset/") ? FaceJniClient.createAnimateCoreFromAssetDir(strArr3) : FaceJniClient.createAnimateCore(strArr3);
        b.a("bdar-face", "face init mDetectHandle:" + this.f9467b + " mTrackHandle:" + this.f9468c + " mAnimateHandle:" + this.f9469d);
        b.a("bdar-face", "anakinDetectModelPath " + this.n + " " + new File(this.n).exists());
        b.a("bdar-face", "anakinTrackCorePath0 " + this.o + " " + new File(this.o).exists());
        b.a("bdar-face", "imbinModelPath " + this.m + " " + new File(this.m).exists());
        if (((this.f9467b <= 0 || this.f9468c <= 0 || this.f9469d <= 0) ? 'h' : 'd') != 'd') {
            z = false;
        }
        this.l = z;
        return this;
    }

    public boolean n() {
        b();
        k kVar = this.f9473h;
        if (kVar == null) {
            return true;
        }
        kVar.a();
        this.f9473h = null;
        return true;
    }

    public i o() {
        k kVar;
        if (this.f9472g > 0 && (kVar = this.f9473h) != null) {
            kVar.e((double) (System.currentTimeMillis() - this.f9472g));
        }
        this.f9472g = System.currentTimeMillis();
        return this;
    }

    public i p() {
        k kVar;
        if (this.f9471f > 0 && (kVar = this.f9473h) != null) {
            kVar.b((double) (System.currentTimeMillis() - this.f9471f));
        }
        this.f9471f = System.currentTimeMillis();
        return this;
    }
}
