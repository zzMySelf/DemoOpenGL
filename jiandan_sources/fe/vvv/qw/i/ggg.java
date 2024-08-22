package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class ggg extends qw implements OneParameterFilter {

    /* renamed from: if  reason: not valid java name */
    public int f376if = -1;

    /* renamed from: o  reason: collision with root package name */
    public float f9000o = 1.0f;

    /* renamed from: pf  reason: collision with root package name */
    public int f9001pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        float f = this.f9000o;
        if (f > 0.0f) {
            GLES20.glUniform1f(this.f9001pf, 0.0f);
            fe.ad("glUniform1f");
            int i2 = this.f376if;
            float f2 = this.f9000o;
            GLES20.glUniform3f(i2, (0.9f * f2) + 1.0f, (2.1f * f2) + 1.0f, (f2 * 2.7f) + 1.0f);
            fe.ad("glUniform3f");
            return;
        }
        GLES20.glUniform1f(this.f9001pf, f + 1.0f);
        fe.ad("glUniform1f");
        GLES20.glUniform3f(this.f376if, 0.0f, 0.0f, 0.0f);
        fe.ad("glUniform3f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform vec3 exponents;\nfloat shift;\nvec3 weights;\nvarying vec2 vTextureCoord;\nvoid main() {\n  weights[0] = 0.25;\n  weights[1] = 0.625;\n  weights[2] = 0.125;\n  shift = 0.003921569;\n  vec4 oldcolor = texture2D(sTexture, vTextureCoord);\n  float kv = dot(oldcolor.rgb, weights) + shift;\n  vec3 new_color = scale * oldcolor.rgb + (1.0 - scale) * kv;\n  gl_FragColor = vec4(new_color, oldcolor.a);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float de = dot(color.rgb, weights);\n  float inv_de = 1.0 / de;\n  vec3 verynew_color = de * pow(color.rgb * inv_de, exponents);\n  float max_color = max(max(max(verynew_color.r, verynew_color.g), verynew_color.b), 1.0);\n  gl_FragColor = gl_FragColor+vec4(verynew_color / max_color, color.a);\n}\n";
    }

    public void i(float f) {
        mmm((f * 2.0f) - 1.0f);
    }

    public void mmm(float f) {
        if (f < -1.0f) {
            f = -1.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f9000o = f;
    }

    public float nn() {
        return this.f9000o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9001pf = -1;
        this.f376if = -1;
    }

    public float rg() {
        return (nn() + 1.0f) / 2.0f;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.f9001pf = glGetUniformLocation;
        fe.de(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "exponents");
        this.f376if = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, "exponents");
    }
}
