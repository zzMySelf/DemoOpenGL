package fe.vvv.ad.ad;

import android.opengl.EGL14;
import android.opengl.EGLExt;
import fe.vvv.ad.th.ad;
import fe.vvv.ad.th.fe;
import fe.vvv.ad.th.qw;
import fe.vvv.ad.th.rg;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public ad f8823ad = fe.uk();

    /* renamed from: de  reason: collision with root package name */
    public qw f8824de;
    public fe.vvv.ad.th.de qw = fe.i();

    public de(@NotNull ad adVar, int i2) {
        qw qw2;
        Intrinsics.checkNotNullParameter(adVar, "sharedContext");
        fe.vvv.ad.th.de deVar = new fe.vvv.ad.th.de(EGL14.eglGetDisplay(0));
        this.qw = deVar;
        if (deVar != fe.i()) {
            if (EGL14.eglInitialize(this.qw.qw(), new int[1], 0, new int[1], 0)) {
                ad adVar2 = new ad();
                boolean z = (i2 & 1) != 0;
                if (((i2 & 2) != 0) && (qw2 = adVar2.qw(this.qw, 3, z)) != null) {
                    ad adVar3 = new ad(EGL14.eglCreateContext(this.qw.qw(), qw2.qw(), adVar.qw(), new int[]{fe.de(), 3, fe.yj()}, 0));
                    try {
                        fe.qw("eglCreateContext (3)");
                        this.f8824de = qw2;
                        this.f8823ad = adVar3;
                    } catch (Exception unused) {
                    }
                }
                if (this.f8823ad == fe.uk()) {
                    qw qw3 = adVar2.qw(this.qw, 2, z);
                    if (qw3 != null) {
                        ad adVar4 = new ad(EGL14.eglCreateContext(this.qw.qw(), qw3.qw(), adVar.qw(), new int[]{fe.de(), 2, fe.yj()}, 0));
                        fe.qw("eglCreateContext (2)");
                        this.f8824de = qw3;
                        this.f8823ad = adVar4;
                        return;
                    }
                    throw new RuntimeException("Unable to find a suitable EGLConfig");
                }
                return;
            }
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public final boolean ad(@NotNull rg rgVar) {
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
        return Intrinsics.areEqual((Object) this.f8823ad, (Object) new ad(EGL14.eglGetCurrentContext())) && Intrinsics.areEqual((Object) rgVar, (Object) new rg(EGL14.eglGetCurrentSurface(fe.fe())));
    }

    public final void de(@NotNull rg rgVar) {
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
        fe.vvv.ad.th.de deVar = this.qw;
        fe.vvv.ad.th.de i2 = fe.i();
        if (!EGL14.eglMakeCurrent(this.qw.qw(), rgVar.qw(), rgVar.qw(), this.f8823ad.qw())) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final int fe(@NotNull rg rgVar, int i2) {
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.qw.qw(), rgVar.qw(), i2, iArr, 0);
        return iArr[0];
    }

    @NotNull
    public final rg qw(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "surface");
        int[] iArr = {fe.yj()};
        fe.vvv.ad.th.de deVar = this.qw;
        qw qwVar = this.f8824de;
        Intrinsics.checkNotNull(qwVar);
        rg rgVar = new rg(EGL14.eglCreateWindowSurface(deVar.qw(), qwVar.qw(), obj, iArr, 0));
        fe.qw("eglCreateWindowSurface");
        if (rgVar != fe.o()) {
            return rgVar;
        }
        throw new RuntimeException("surface was null");
    }

    public void rg() {
        if (this.qw != fe.i()) {
            EGL14.eglMakeCurrent(this.qw.qw(), fe.o().qw(), fe.o().qw(), fe.uk().qw());
            EGL14.eglDestroyContext(this.qw.qw(), this.f8823ad.qw());
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.qw.qw());
        }
        this.qw = fe.i();
        this.f8823ad = fe.uk();
        this.f8824de = null;
    }

    public final void th(@NotNull rg rgVar) {
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
        EGL14.eglDestroySurface(this.qw.qw(), rgVar.qw());
    }

    public final boolean uk(@NotNull rg rgVar) {
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
        return EGL14.eglSwapBuffers(this.qw.qw(), rgVar.qw());
    }

    public final void yj(@NotNull rg rgVar, long j) {
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
        EGLExt.eglPresentationTimeANDROID(this.qw.qw(), rgVar.qw(), j);
    }
}
