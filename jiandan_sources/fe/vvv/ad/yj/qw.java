package fe.vvv.ad.yj;

import android.opengl.GLES20;
import com.baidu.apollon.utils.ResUtils;
import com.otaliastudios.opengl.core.GlBindable;
import com.otaliastudios.opengl.program.GlProgramLocation;
import fe.vvv.ad.ad.fe;
import fe.vvv.ad.de.ad;
import fe.vvv.ad.th.th;
import kotlin.Deprecated;
import kotlin.UInt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class qw implements GlBindable {

    /* renamed from: rg  reason: collision with root package name */
    public static final C0305qw f8861rg = new C0305qw((DefaultConstructorMarker) null);

    /* renamed from: ad  reason: collision with root package name */
    public final int f8862ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f8863de;

    /* renamed from: fe  reason: collision with root package name */
    public final de[] f8864fe;
    public boolean qw;

    /* renamed from: fe.vvv.ad.yj.qw$qw  reason: collision with other inner class name */
    public static final class C0305qw {
        public C0305qw() {
        }

        @JvmStatic
        public final int ad(@NotNull de... deVarArr) {
            Intrinsics.checkNotNullParameter(deVarArr, "shaders");
            int r0 = UInt.m1249constructorimpl(GLES20.glCreateProgram());
            fe.ad("glCreateProgram");
            if (r0 != 0) {
                for (de qw : deVarArr) {
                    GLES20.glAttachShader(r0, UInt.m1249constructorimpl(qw.qw()));
                    fe.ad("glAttachShader");
                }
                GLES20.glLinkProgram(r0);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(r0, th.uk(), iArr, 0);
                if (iArr[0] == th.xxx()) {
                    return r0;
                }
                String str = "Could not link program: " + GLES20.glGetProgramInfoLog(r0);
                GLES20.glDeleteProgram(r0);
                throw new RuntimeException(str);
            }
            throw new RuntimeException("Could not create program");
        }

        @JvmStatic
        @Deprecated(message = "Use create(GlShader) signature.")
        public final int qw(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "vertexShaderSource");
            Intrinsics.checkNotNullParameter(str2, "fragmentShaderSource");
            return ad(new de(th.ddd(), str), new de(th.fe(), str2));
        }

        public /* synthetic */ C0305qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public qw(int i2, boolean z, @NotNull de... deVarArr) {
        Intrinsics.checkNotNullParameter(deVarArr, "shaders");
        this.f8862ad = i2;
        this.f8863de = z;
        this.f8864fe = deVarArr;
    }

    @JvmStatic
    @Deprecated(message = "Use create(GlShader) signature.")
    public static final int de(@NotNull String str, @NotNull String str2) {
        return f8861rg.qw(str, str2);
    }

    public void ad() {
        GLES20.glUseProgram(UInt.m1249constructorimpl(this.f8862ad));
        fe.ad("glUseProgram");
    }

    @NotNull
    public final GlProgramLocation fe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return GlProgramLocation.f6802fe.qw(this.f8862ad, str);
    }

    public void i() {
        if (!this.qw) {
            if (this.f8863de) {
                GLES20.glDeleteProgram(UInt.m1249constructorimpl(this.f8862ad));
            }
            for (de ad2 : this.f8864fe) {
                ad2.ad();
            }
            this.qw = true;
        }
    }

    public void qw() {
        GLES20.glUseProgram(0);
    }

    @NotNull
    public final GlProgramLocation rg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return GlProgramLocation.f6802fe.ad(this.f8862ad, str);
    }

    public void th(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, ResUtils.e);
        adVar.qw();
    }

    public void uk(@NotNull ad adVar, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(adVar, ResUtils.e);
        Intrinsics.checkNotNullParameter(fArr, "modelViewProjectionMatrix");
    }

    public void yj(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, ResUtils.e);
    }
}
