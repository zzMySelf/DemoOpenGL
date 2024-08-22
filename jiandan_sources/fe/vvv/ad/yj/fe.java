package fe.vvv.ad.yj;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.baidu.apollon.utils.ResUtils;
import com.otaliastudios.opengl.program.GlProgramLocation;
import com.otaliastudios.opengl.texture.GlTexture;
import fe.vvv.ad.de.qw;
import fe.vvv.ad.i.ad;
import fe.vvv.ad.th.th;
import fe.vvv.ad.th.yj;
import java.nio.FloatBuffer;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fe extends qw {

    /* renamed from: i  reason: collision with root package name */
    public final GlProgramLocation f8855i;

    /* renamed from: if  reason: not valid java name */
    public final RectF f359if;

    /* renamed from: o  reason: collision with root package name */
    public final GlProgramLocation f8856o;

    /* renamed from: pf  reason: collision with root package name */
    public final GlProgramLocation f8857pf;
    @Nullable
    public GlTexture ppp;

    /* renamed from: switch  reason: not valid java name */
    public int f360switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public float[] f8858th;

    /* renamed from: uk  reason: collision with root package name */
    public FloatBuffer f8859uk;
    public qw when;

    /* renamed from: yj  reason: collision with root package name */
    public final GlProgramLocation f8860yj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fe(int i2, boolean z, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        super(i2, z, new de[0]);
        Intrinsics.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics.checkNotNullParameter(str2, "vertexMvpMatrixName");
        this.f8858th = yj.de(fe.vvv.ad.ad.fe.qw);
        GlProgramLocation glProgramLocation = null;
        this.f8860yj = str4 != null ? rg(str4) : null;
        this.f8859uk = fe.vvv.ad.i.qw.ad(8);
        this.f8855i = str3 != null ? fe(str3) : glProgramLocation;
        this.f8856o = fe(str);
        this.f8857pf = rg(str2);
        this.f359if = new RectF();
        this.f360switch = -1;
    }

    public void i() {
        super.i();
        ad.qw(this.f8859uk);
        GlTexture glTexture = this.ppp;
        if (glTexture != null) {
            glTexture.i();
        }
        this.ppp = null;
    }

    public float o(int i2, @NotNull qw qwVar, float f, float f2, float f3, boolean z) {
        Intrinsics.checkNotNullParameter(qwVar, ResUtils.e);
        return (((f - f2) / (f3 - f2)) * 1.0f) + 0.0f;
    }

    public final void pf(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.f8858th = fArr;
    }

    public void uk(@NotNull fe.vvv.ad.de.ad adVar, @NotNull float[] fArr) {
        fe.vvv.ad.de.ad adVar2 = adVar;
        float[] fArr2 = fArr;
        Intrinsics.checkNotNullParameter(adVar2, ResUtils.e);
        Intrinsics.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        super.uk(adVar, fArr);
        if (adVar2 instanceof qw) {
            GlTexture glTexture = this.ppp;
            if (glTexture != null) {
                glTexture.ad();
            }
            GLES20.glUniformMatrix4fv(this.f8857pf.ad(), 1, false, fArr2, 0);
            fe.vvv.ad.ad.fe.ad("glUniformMatrix4fv");
            GlProgramLocation glProgramLocation = this.f8860yj;
            if (glProgramLocation != null) {
                GLES20.glUniformMatrix4fv(glProgramLocation.ad(), 1, false, this.f8858th, 0);
                fe.vvv.ad.ad.fe.ad("glUniformMatrix4fv");
            }
            GlProgramLocation glProgramLocation2 = this.f8856o;
            GLES20.glEnableVertexAttribArray(glProgramLocation2.qw());
            fe.vvv.ad.ad.fe.ad("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(glProgramLocation2.qw(), 2, th.de(), false, adVar.yj(), adVar.fe());
            fe.vvv.ad.ad.fe.ad("glVertexAttribPointer");
            GlProgramLocation glProgramLocation3 = this.f8855i;
            if (glProgramLocation3 != null) {
                if ((!Intrinsics.areEqual((Object) adVar2, (Object) this.when)) || adVar.rg() != this.f360switch) {
                    qw qwVar = (qw) adVar2;
                    this.when = qwVar;
                    this.f360switch = adVar.rg();
                    qwVar.uk(this.f359if);
                    int th2 = adVar.th() * 2;
                    if (this.f8859uk.capacity() < th2) {
                        ad.qw(this.f8859uk);
                        this.f8859uk = fe.vvv.ad.i.qw.ad(th2);
                    }
                    this.f8859uk.clear();
                    this.f8859uk.limit(th2);
                    for (int i2 = 0; i2 < th2; i2++) {
                        boolean z = i2 % 2 == 0;
                        float f = adVar.fe().get(i2);
                        RectF rectF = this.f359if;
                        float f2 = z ? rectF.left : rectF.bottom;
                        RectF rectF2 = this.f359if;
                        this.f8859uk.put(o(i2 / 2, qwVar, f, f2, z ? rectF2.right : rectF2.top, z));
                    }
                }
                this.f8859uk.rewind();
                GLES20.glEnableVertexAttribArray(glProgramLocation3.qw());
                fe.vvv.ad.ad.fe.ad("glEnableVertexAttribArray");
                GLES20.glVertexAttribPointer(glProgramLocation3.qw(), 2, th.de(), false, adVar.yj(), this.f8859uk);
                fe.vvv.ad.ad.fe.ad("glVertexAttribPointer");
                return;
            }
            return;
        }
        throw new RuntimeException("GlTextureProgram only supports 2D drawables.");
    }

    public void yj(@NotNull fe.vvv.ad.de.ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, ResUtils.e);
        super.yj(adVar);
        GLES20.glDisableVertexAttribArray(this.f8856o.qw());
        GlProgramLocation glProgramLocation = this.f8855i;
        if (glProgramLocation != null) {
            GLES20.glDisableVertexAttribArray(glProgramLocation.qw());
        }
        GlTexture glTexture = this.ppp;
        if (glTexture != null) {
            glTexture.qw();
        }
        fe.vvv.ad.ad.fe.ad("onPostDraw end");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public fe(int i2, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        this(i2, false, str, str2, str3, str4);
        Intrinsics.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics.checkNotNullParameter(str2, "vertexMvpMatrixName");
    }
}
