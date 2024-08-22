package fe.vvv.ad.th;

import android.opengl.EGLSurface;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg {
    @Nullable
    public final EGLSurface qw;

    public rg(@Nullable EGLSurface eGLSurface) {
        this.qw = eGLSurface;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof rg) && Intrinsics.areEqual((Object) this.qw, (Object) ((rg) obj).qw);
        }
        return true;
    }

    public int hashCode() {
        EGLSurface eGLSurface = this.qw;
        if (eGLSurface != null) {
            return eGLSurface.hashCode();
        }
        return 0;
    }

    @Nullable
    public final EGLSurface qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "EglSurface(native=" + this.qw + ")";
    }
}
