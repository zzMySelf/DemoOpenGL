package fe.vvv.qw.uk;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import fe.vvv.ad.de.ad;
import fe.vvv.ad.de.de;
import fe.vvv.ad.yj.fe;

public abstract class qw implements Filter {

    /* renamed from: i  reason: collision with root package name */
    public static final CameraLogger f9097i = CameraLogger.qw(qw.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public ad f9098ad = null;
    @VisibleForTesting

    /* renamed from: de  reason: collision with root package name */
    public fe.vvv.qw.xxx.ad f9099de;

    /* renamed from: fe  reason: collision with root package name */
    public String f9100fe = "aPosition";
    @VisibleForTesting
    public fe qw = null;

    /* renamed from: rg  reason: collision with root package name */
    public String f9101rg = "aTextureCoord";

    /* renamed from: th  reason: collision with root package name */
    public String f9102th = "uMVPMatrix";

    /* renamed from: uk  reason: collision with root package name */
    public String f9103uk = "vTextureCoord";

    /* renamed from: yj  reason: collision with root package name */
    public String f9104yj = "uTexMatrix";

    @NonNull
    public static String ppp(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
        return "uniform mat4 " + str3 + ";\nuniform mat4 " + str4 + ";\nattribute vec4 " + str + ";\nattribute vec4 " + str2 + ";\nvarying vec2 " + str5 + ";\nvoid main() {\n    gl_Position = " + str3 + " * " + str + ";\n    " + str5 + " = (" + str4 + " * " + str2 + ").xy;\n}\n";
    }

    @NonNull
    /* renamed from: switch  reason: not valid java name */
    public static String m1041switch(@NonNull String str) {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 " + str + ";\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, " + str + ");\n}\n";
    }

    @NonNull
    public String ad() {
        return when();
    }

    public void ddd(long j, @NonNull float[] fArr) {
        this.qw.pf(fArr);
        fe feVar = this.qw;
        ad adVar = this.f9098ad;
        feVar.uk(adVar, adVar.de());
    }

    @NonNull
    public qw ggg() {
        try {
            return (qw) getClass().newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public String m1042if() {
        return m1041switch(this.f9103uk);
    }

    public void o(long j, @NonNull float[] fArr) {
        if (this.qw == null) {
            f9097i.i("Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            return;
        }
        ddd(j, fArr);
        vvv(j);
        xxx(j);
    }

    public void onDestroy() {
        this.qw.i();
        this.qw = null;
        this.f9098ad = null;
    }

    @NonNull
    /* renamed from: pf */
    public final qw qw() {
        qw ggg = ggg();
        fe.vvv.qw.xxx.ad adVar = this.f9099de;
        if (adVar != null) {
            ggg.yj(adVar.rg(), this.f9099de.fe());
        }
        if (this instanceof OneParameterFilter) {
            ((OneParameterFilter) ggg).i(((OneParameterFilter) this).rg());
        }
        if (this instanceof TwoParameterFilter) {
            ((TwoParameterFilter) ggg).uk(((TwoParameterFilter) this).de());
        }
        return ggg;
    }

    public void th(int i2) {
        this.qw = new fe(i2, this.f9100fe, this.f9102th, this.f9101rg, this.f9104yj);
        this.f9098ad = new de();
    }

    public void vvv(long j) {
        this.qw.th(this.f9098ad);
    }

    @NonNull
    public String when() {
        return ppp(this.f9100fe, this.f9101rg, this.f9102th, this.f9104yj, this.f9103uk);
    }

    public void xxx(long j) {
        this.qw.yj(this.f9098ad);
    }

    public void yj(int i2, int i3) {
        this.f9099de = new fe.vvv.qw.xxx.ad(i2, i3);
    }
}
