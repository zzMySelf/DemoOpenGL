package fe.vvv.ad.th;

import android.opengl.GLU;
import android.opengl.Matrix;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class yj {
    @NotNull
    public static final String ad(int i2) {
        String hexString = Integer.toHexString(i2);
        Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(value)");
        return hexString;
    }

    @NotNull
    public static final float[] de(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        return (float[]) fArr.clone();
    }

    public static final void fe(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Matrix.setIdentityM(fArr, 0);
    }

    @NotNull
    public static final String qw(int i2) {
        String gluErrorString = GLU.gluErrorString(i2);
        Intrinsics.checkNotNullExpressionValue(gluErrorString, "GLU.gluErrorString(value)");
        return gluErrorString;
    }
}
