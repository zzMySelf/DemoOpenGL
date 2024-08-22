package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;
import java.util.Random;

public class th extends qw {
    public static final String ppp = ("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvec2 seed;\nfloat stepsize;\nuniform float inv_max_dist;\nuniform vec2 scale;\nvarying vec2 vTextureCoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  seed[0] = " + when.nextFloat() + ";\n  seed[1] = " + when.nextFloat() + ";\n  stepsize = " + 0.003921569f + ";\n  vec4 color = texture2D(sTexture, " + "vTextureCoord" + ");\n  float dither = rand(" + "vTextureCoord" + " + seed);\n  vec3 xform = clamp(2.0 * color.rgb, 0.0, 1.0);\n  vec3 temp = clamp(2.0 * (color.rgb + stepsize), 0.0, 1.0);\n  vec3 new_color = clamp(xform + (temp - xform) * (dither - 0.5), 0.0, 1.0);\n  float gray = dot(new_color, vec3(0.299, 0.587, 0.114));\n  new_color = vec3(gray, gray, gray);\n  vec2 coord = " + "vTextureCoord" + " - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = 0.85 / (1.0 + exp((dist * inv_max_dist - 0.83) * 20.0)) + 0.15;\n  gl_FragColor = vec4(new_color * lumen, color.a);\n}\n");
    public static final Random when = new Random();

    /* renamed from: if  reason: not valid java name */
    public int f381if = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f9014o = 1;

    /* renamed from: pf  reason: collision with root package name */
    public int f9015pf = 1;

    /* renamed from: switch  reason: not valid java name */
    public int f382switch = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        float[] fArr2 = new float[2];
        int i2 = this.f9014o;
        int i3 = this.f9015pf;
        if (i2 > i3) {
            fArr2[0] = 1.0f;
            fArr2[1] = ((float) i3) / ((float) i2);
        } else {
            fArr2[0] = ((float) i2) / ((float) i3);
            fArr2[1] = 1.0f;
        }
        GLES20.glUniform2fv(this.f381if, 1, fArr2, 0);
        fe.ad("glUniform2fv");
        GLES20.glUniform1f(this.f382switch, 1.0f / (((float) Math.sqrt((double) ((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1])))) * 0.5f));
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return ppp;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f381if = -1;
        this.f382switch = -1;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.f381if = glGetUniformLocation;
        fe.de(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "inv_max_dist");
        this.f382switch = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, "inv_max_dist");
    }

    public void yj(int i2, int i3) {
        super.yj(i2, i3);
        this.f9014o = i2;
        this.f9015pf = i3;
    }
}
