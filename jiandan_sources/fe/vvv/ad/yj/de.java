package fe.vvv.ad.yj;

import android.opengl.GLES20;
import com.baidu.ubc.UBCManager;
import fe.vvv.ad.ad.fe;
import fe.vvv.ad.th.th;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static final qw f8854ad = new qw((DefaultConstructorMarker) null);
    public final int qw;

    public static final class qw {
        public qw() {
        }

        public final int ad(int i2, String str) {
            int r0 = UInt.m1249constructorimpl(GLES20.glCreateShader(UInt.m1249constructorimpl(i2)));
            fe.ad("glCreateShader type=" + i2);
            GLES20.glShaderSource(r0, str);
            GLES20.glCompileShader(r0);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(r0, th.ad(), iArr, 0);
            if (iArr[0] != 0) {
                return r0;
            }
            String str2 = "Could not compile shader " + i2 + ": '" + GLES20.glGetShaderInfoLog(r0) + "' source: " + str;
            GLES20.glDeleteShader(r0);
            throw new RuntimeException(str2);
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public de(int i2, int i3) {
        this.qw = i3;
    }

    public final void ad() {
        GLES20.glDeleteShader(UInt.m1249constructorimpl(this.qw));
    }

    public final int qw() {
        return this.qw;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public de(int i2, @NotNull String str) {
        this(i2, f8854ad.ad(i2, str));
        Intrinsics.checkNotNullParameter(str, UBCManager.CONTENT_KEY_SOURCE);
    }
}
