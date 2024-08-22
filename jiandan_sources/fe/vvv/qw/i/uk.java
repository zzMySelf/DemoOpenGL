package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class uk extends qw implements OneParameterFilter {

    /* renamed from: if  reason: not valid java name */
    public int f383if = -1;

    /* renamed from: o  reason: collision with root package name */
    public float f9016o = 0.5f;

    /* renamed from: pf  reason: collision with root package name */
    public int f9017pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        float f = 1.0f / (((1.0f - this.f9016o) * 0.7f) + 0.3f);
        GLES20.glUniform1f(this.f9017pf, f);
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.f383if, 1.0f / ((0.7f * f) + 0.3f));
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float mult;\nuniform float igamma;\nvarying vec2 vTextureCoord;\nvoid main() {\n  const vec3 color_weights = vec3(0.25, 0.5, 0.25);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float lightmask = dot(color.rgb, color_weights);\n  float backmask = (1.0 - lightmask);\n  vec3 ones = vec3(1.0, 1.0, 1.0);\n  vec3 diff = pow(mult * color.rgb, igamma * ones) - color.rgb;\n  diff = min(diff, 1.0);\n  vec3 new_color = min(color.rgb + diff * backmask, 1.0);\n  gl_FragColor = vec4(new_color, color.a);\n}\n";
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
        this.f9016o = f;
    }

    public float nn() {
        return this.f9016o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9017pf = -1;
        this.f383if = -1;
    }

    public float rg() {
        return nn();
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "mult");
        this.f9017pf = glGetUniformLocation;
        fe.de(glGetUniformLocation, "mult");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "igamma");
        this.f383if = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, "igamma");
    }
}
