package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;

public class qw extends fe.vvv.qw.uk.qw implements OneParameterFilter {

    /* renamed from: o  reason: collision with root package name */
    public float f9012o = 1.0f;

    /* renamed from: pf  reason: collision with root package name */
    public int f9013pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform1f(this.f9013pf, this.f9012o);
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES tex_sampler_0;\nuniform samplerExternalOES tex_sampler_1;\nuniform samplerExternalOES tex_sampler_2;\nuniform float scale;\nfloat shift_scale;\nfloat hist_offset;\nfloat hist_scale;\nfloat density_offset;\nfloat density_scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n  shift_scale = 0.00390625;\n  hist_offset = 6.527415E-4;\n  hist_scale = 0.99869454;\n  density_offset = 4.8828125E-4;\n  density_scale = 0.99902344;\n  const vec3 weights = vec3(0.33333, 0.33333, 0.33333);\n  vec4 color = texture2D(tex_sampler_0, vTextureCoord);\n  float energy = dot(color.rgb, weights);\n  float mask_value = energy - 0.5;\n  float alpha;\n  if (mask_value > 0.0) {\n    alpha = (pow(2.0 * mask_value, 1.5) - 1.0) * scale + 1.0;\n  } else { \n    alpha = (pow(2.0 * mask_value, 2.0) - 1.0) * scale + 1.0;\n  }\n  float index = energy * hist_scale + hist_offset;\n  vec4 temp = texture2D(tex_sampler_1, vec2(index, 0.5));\n  float value = temp.g + temp.r * shift_scale;\n  index = value * density_scale + density_offset;\n  temp = texture2D(tex_sampler_2, vec2(index, 0.5));\n  value = temp.g + temp.r * shift_scale;\n  float dst_energy = energy * alpha + value * (1.0 - alpha);\n  float max_energy = energy / max(color.r, max(color.g, color.b));\n  if (dst_energy > max_energy) {\n    dst_energy = max_energy;\n  }\n  if (energy == 0.0) {\n    gl_FragColor = color;\n  } else {\n    gl_FragColor = vec4(color.rgb * dst_energy / energy, color.a);\n  }\n}\n";
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
        this.f9012o = f;
    }

    public float nn() {
        return this.f9012o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9013pf = -1;
    }

    public float rg() {
        return nn();
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.f9013pf = glGetUniformLocation;
        fe.de(glGetUniformLocation, "scale");
    }
}
