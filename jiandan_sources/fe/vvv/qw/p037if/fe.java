package fe.vvv.qw.p037if;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.opengl.texture.GlTexture;
import fe.vvv.ad.yj.qw;
import fe.vvv.qw.uk.de;

/* renamed from: fe.vvv.qw.if.fe  reason: invalid package */
public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public float[] f9024ad;
    @NonNull

    /* renamed from: de  reason: collision with root package name */
    public Filter f9025de;

    /* renamed from: fe  reason: collision with root package name */
    public Filter f9026fe;
    public final GlTexture qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9027rg;

    static {
        CameraLogger.qw(fe.class.getSimpleName());
    }

    public fe() {
        this(new GlTexture(33984, 36197));
    }

    @NonNull
    public GlTexture ad() {
        return this.qw;
    }

    @NonNull
    public float[] de() {
        return this.f9024ad;
    }

    public void fe() {
        if (this.f9027rg != -1) {
            this.f9025de.onDestroy();
            GLES20.glDeleteProgram(this.f9027rg);
            this.f9027rg = -1;
        }
    }

    public void qw(long j) {
        if (this.f9026fe != null) {
            fe();
            this.f9025de = this.f9026fe;
            this.f9026fe = null;
        }
        if (this.f9027rg == -1) {
            int de2 = qw.de(this.f9025de.ad(), this.f9025de.fe());
            this.f9027rg = de2;
            this.f9025de.th(de2);
            fe.vvv.ad.ad.fe.ad("program creation");
        }
        GLES20.glUseProgram(this.f9027rg);
        fe.vvv.ad.ad.fe.ad("glUseProgram(handle)");
        this.qw.ad();
        this.f9025de.o(j, this.f9024ad);
        this.qw.qw();
        GLES20.glUseProgram(0);
        fe.vvv.ad.ad.fe.ad("glUseProgram(0)");
    }

    public void rg(@NonNull Filter filter) {
        this.f9026fe = filter;
    }

    public void th(@NonNull float[] fArr) {
        this.f9024ad = fArr;
    }

    public fe(int i2) {
        this(new GlTexture(33984, 36197, Integer.valueOf(i2)));
    }

    public fe(@NonNull GlTexture glTexture) {
        this.f9024ad = (float[]) fe.vvv.ad.ad.fe.qw.clone();
        this.f9025de = new de();
        this.f9026fe = null;
        this.f9027rg = -1;
        this.qw = glTexture;
    }
}
