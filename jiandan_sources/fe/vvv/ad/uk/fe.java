package fe.vvv.ad.uk;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import fe.vvv.ad.ad.qw;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class fe extends ad {

    /* renamed from: rg  reason: collision with root package name */
    public Surface f8849rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f8850th;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public fe(@NotNull qw qwVar, @NotNull Surface surface, boolean z) {
        super(qwVar, qwVar.qw(surface));
        Intrinsics.checkNotNullParameter(qwVar, "eglCore");
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.f8849rg = surface;
        this.f8850th = z;
    }

    public void yj() {
        super.yj();
        if (this.f8850th) {
            Surface surface = this.f8849rg;
            if (surface != null) {
                surface.release();
            }
            this.f8849rg = null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fe(@NotNull qw qwVar, @NotNull SurfaceTexture surfaceTexture) {
        super(qwVar, qwVar.qw(surfaceTexture));
        Intrinsics.checkNotNullParameter(qwVar, "eglCore");
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
    }
}
