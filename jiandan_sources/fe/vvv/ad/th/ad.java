package fe.vvv.ad.th;

import android.opengl.EGLContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @Nullable
    public final EGLContext qw;

    public ad(@Nullable EGLContext eGLContext) {
        this.qw = eGLContext;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ad) && Intrinsics.areEqual((Object) this.qw, (Object) ((ad) obj).qw);
        }
        return true;
    }

    public int hashCode() {
        EGLContext eGLContext = this.qw;
        if (eGLContext != null) {
            return eGLContext.hashCode();
        }
        return 0;
    }

    @Nullable
    public final EGLContext qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "EglContext(native=" + this.qw + ")";
    }
}
