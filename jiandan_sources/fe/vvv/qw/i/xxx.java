package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class xxx extends qw implements OneParameterFilter {

    /* renamed from: if  reason: not valid java name */
    public int f386if = 1;

    /* renamed from: o  reason: collision with root package name */
    public float f9020o = 0.5f;

    /* renamed from: pf  reason: collision with root package name */
    public int f9021pf = 1;
    public int ppp = -1;

    /* renamed from: switch  reason: not valid java name */
    public int f387switch = -1;
    public int when = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform1f(this.f387switch, this.f9020o);
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.when, 1.0f / ((float) this.f9021pf));
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.ppp, 1.0f / ((float) this.f386if));
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform float stepsizeX;\nuniform float stepsizeY;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 nbr_color = vec3(0.0, 0.0, 0.0);\n  vec2 coord;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  coord.x = vTextureCoord.x - 0.5 * stepsizeX;\n  coord.y = vTextureCoord.y - stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x - stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y - 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  gl_FragColor = vec4(color.rgb - 2.0 * scale * nbr_color, color.a);\n}\n";
    }

    public void i(float f) {
        mmm(f);
    }

    public void mmm(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f9020o = f;
    }

    public float nn() {
        return this.f9020o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f387switch = -1;
        this.when = -1;
        this.ppp = -1;
    }

    public float rg() {
        return nn();
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.f387switch = glGetUniformLocation;
        fe.de(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "stepsizeX");
        this.when = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, "stepsizeX");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i2, "stepsizeY");
        this.ppp = glGetUniformLocation3;
        fe.de(glGetUniformLocation3, "stepsizeY");
    }

    public void yj(int i2, int i3) {
        super.yj(i2, i3);
        this.f9021pf = i2;
        this.f386if = i3;
    }
}
