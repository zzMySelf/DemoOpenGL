package fe.vvv.ad.ad;

import android.opengl.EGL14;
import android.opengl.GLES20;
import androidx.core.app.NotificationCompatJellybean;
import fe.vvv.ad.fe.qw;
import fe.vvv.ad.th.th;
import fe.vvv.ad.th.yj;
import kotlin.UInt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class fe {
    @NotNull
    @JvmField
    public static final float[] qw;

    static {
        float[] fArr = new float[16];
        qw.ad(fArr);
        qw = fArr;
    }

    @JvmStatic
    public static final void ad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "opName");
        int r0 = UInt.m1249constructorimpl(GLES20.glGetError());
        if (r0 != th.o()) {
            throw new RuntimeException("Error during " + str + ": glError 0x" + yj.ad(r0) + ": " + yj.qw(r0));
        }
    }

    @JvmStatic
    public static final void de(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompatJellybean.KEY_LABEL);
        if (i2 < 0) {
            throw new RuntimeException("Unable to locate " + str + " in program");
        }
    }

    @JvmStatic
    public static final void qw(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "opName");
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != fe.vvv.ad.th.fe.ggg()) {
            throw new RuntimeException("Error during " + str + ": EGL error 0x" + yj.ad(eglGetError));
        }
    }
}
