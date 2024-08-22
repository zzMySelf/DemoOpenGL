package fe.vvv.ad.th;

import android.opengl.EGLDisplay;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    @Nullable
    public final EGLDisplay qw;

    public de(@Nullable EGLDisplay eGLDisplay) {
        this.qw = eGLDisplay;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof de) && Intrinsics.areEqual((Object) this.qw, (Object) ((de) obj).qw);
        }
        return true;
    }

    public int hashCode() {
        EGLDisplay eGLDisplay = this.qw;
        if (eGLDisplay != null) {
            return eGLDisplay.hashCode();
        }
        return 0;
    }

    @Nullable
    public final EGLDisplay qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "EglDisplay(native=" + this.qw + ")";
    }
}
