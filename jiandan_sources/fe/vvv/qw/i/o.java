package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;
import java.util.Random;

public class o extends qw implements OneParameterFilter {
    public static final Random ggg = new Random();
    public static final String vvv = ("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvec2 seed;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES tex_sampler_0;\nuniform samplerExternalOES tex_sampler_1;\nuniform float scale;\nuniform float stepX;\nuniform float stepY;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  float sum = (part1 + part2 + part3);\n  return fract(sum)*scale;\n}\nvoid main() {\n  seed[0] = " + ggg.nextFloat() + ";\n  seed[1] = " + ggg.nextFloat() + ";\n  float noise = texture2D(tex_sampler_1, " + "vTextureCoord" + " + vec2(-stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, " + "vTextureCoord" + " + vec2(-stepX, stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, " + "vTextureCoord" + " + vec2(stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, " + "vTextureCoord" + " + vec2(stepX, stepY)).r * 0.224;\n  noise += 0.4448;\n  noise *= scale;\n  vec4 color = texture2D(tex_sampler_0, " + "vTextureCoord" + ");\n  float energy = 0.33333 * color.r + 0.33333 * color.g + 0.33333 * color.b;\n  float mask = (1.0 - sqrt(energy));\n  float weight = 1.0 - 1.333 * mask * noise;\n  gl_FragColor = vec4(color.rgb * weight, color.a);\n  gl_FragColor = gl_FragColor+vec4(rand(" + "vTextureCoord" + " + seed), rand(" + "vTextureCoord" + " + seed),rand(" + "vTextureCoord" + " + seed),1);\n}\n");

    /* renamed from: if  reason: not valid java name */
    public int f379if = 1;

    /* renamed from: o  reason: collision with root package name */
    public float f9010o = 0.5f;

    /* renamed from: pf  reason: collision with root package name */
    public int f9011pf = 1;
    public int ppp = -1;

    /* renamed from: switch  reason: not valid java name */
    public int f380switch = -1;
    public int when = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform1f(this.f380switch, this.f9010o);
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.when, 0.5f / ((float) this.f9011pf));
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.ppp, 0.5f / ((float) this.f379if));
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return vvv;
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
        this.f9010o = f;
    }

    public float nn() {
        return this.f9010o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f380switch = -1;
        this.when = -1;
        this.ppp = -1;
    }

    public float rg() {
        return nn();
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.f380switch = glGetUniformLocation;
        fe.de(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "stepX");
        this.when = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, "stepX");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i2, "stepY");
        this.ppp = glGetUniformLocation3;
        fe.de(glGetUniformLocation3, "stepY");
    }

    public void yj(int i2, int i3) {
        super.yj(i2, i3);
        this.f9011pf = i2;
        this.f379if = i3;
    }
}
