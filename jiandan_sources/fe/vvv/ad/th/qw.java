package fe.vvv.ad.th;

import android.opengl.EGLConfig;
import com.baidu.sapi2.SapiAccountService;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public final EGLConfig qw;

    public qw(@NotNull EGLConfig eGLConfig) {
        Intrinsics.checkNotNullParameter(eGLConfig, SapiAccountService.DISPLAY_TYPE_NATIVE);
        this.qw = eGLConfig;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof qw) && Intrinsics.areEqual((Object) this.qw, (Object) ((qw) obj).qw);
        }
        return true;
    }

    public int hashCode() {
        EGLConfig eGLConfig = this.qw;
        if (eGLConfig != null) {
            return eGLConfig.hashCode();
        }
        return 0;
    }

    @NotNull
    public final EGLConfig qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "EglConfig(native=" + this.qw + ")";
    }
}
