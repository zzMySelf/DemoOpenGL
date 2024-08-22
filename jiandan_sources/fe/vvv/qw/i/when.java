package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;
import java.util.Random;

public class when extends qw {
    public static final Random ggg = new Random();
    public static final String vvv = ("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float stepsizeX;\nuniform float stepsizeY;\nuniform vec2 scale;\nuniform float inv_max_dist;\nvec2 seed;\nfloat stepsize;\nvarying vec2 vTextureCoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  seed[0] = " + ggg.nextFloat() + ";\n  seed[1] = " + ggg.nextFloat() + ";\n  stepsize = " + 0.003921569f + ";\n  vec3 nbr_color = vec3(0.0, 0.0, 0.0);\n  vec2 coord;\n  vec4 color = texture2D(sTexture, " + "vTextureCoord" + ");\n  coord.x = " + "vTextureCoord" + ".x - 0.5 * stepsizeX;\n  coord.y = " + "vTextureCoord" + ".y - stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = " + "vTextureCoord" + ".x - stepsizeX;\n  coord.y = " + "vTextureCoord" + ".y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = " + "vTextureCoord" + ".x + stepsizeX;\n  coord.y = " + "vTextureCoord" + ".y - 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = " + "vTextureCoord" + ".x + stepsizeX;\n  coord.y = " + "vTextureCoord" + ".y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  vec3 s_color = vec3(color.rgb + 0.3 * nbr_color);\n  vec3 c_color = vec3(0.0, 0.0, 0.0);\n  float value;\n  if (s_color.r < 0.5) {\n    value = s_color.r;\n  } else {\n    value = 1.0 - s_color.r;\n  }\n  float red = 4.0 * value * value * value;\n  if (s_color.r < 0.5) {\n    c_color.r = red;\n  } else {\n    c_color.r = 1.0 - red;\n  }\n  if (s_color.g < 0.5) {\n    value = s_color.g;\n  } else {\n    value = 1.0 - s_color.g;\n  }\n  float green = 2.0 * value * value;\n  if (s_color.g < 0.5) {\n    c_color.g = green;\n  } else {\n    c_color.g = 1.0 - green;\n  }\n  c_color.b = s_color.b * 0.5 + 0.25;\n  float dither = rand(" + "vTextureCoord" + " + seed);\n  vec3 xform = clamp((c_color.rgb - 0.15) * 1.53846, 0.0, 1.0);\n  vec3 temp = clamp((color.rgb + stepsize - 0.15) * 1.53846, 0.0, 1.0);\n  vec3 bw_color = clamp(xform + (temp - xform) * (dither - 0.5), 0.0, 1.0);\n  coord = " + "vTextureCoord" + " - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = 0.85 / (1.0 + exp((dist * inv_max_dist - 0.73) * 20.0)) + 0.15;\n  gl_FragColor = vec4(bw_color * lumen, color.a);\n}\n");

    /* renamed from: if  reason: not valid java name */
    public int f384if = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f9018o = 1;

    /* renamed from: pf  reason: collision with root package name */
    public int f9019pf = 1;
    public int ppp = -1;

    /* renamed from: switch  reason: not valid java name */
    public int f385switch = -1;
    public int when = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        float[] fArr2 = new float[2];
        int i2 = this.f9018o;
        int i3 = this.f9019pf;
        if (i2 > i3) {
            fArr2[0] = 1.0f;
            fArr2[1] = ((float) i3) / ((float) i2);
        } else {
            fArr2[0] = ((float) i2) / ((float) i3);
            fArr2[1] = 1.0f;
        }
        GLES20.glUniform2fv(this.f384if, 1, fArr2, 0);
        fe.ad("glUniform2fv");
        GLES20.glUniform1f(this.f385switch, 1.0f / (((float) Math.sqrt((double) ((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1])))) * 0.5f));
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.when, 1.0f / ((float) this.f9018o));
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.ppp, 1.0f / ((float) this.f9019pf));
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return vvv;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f384if = -1;
        this.f385switch = -1;
        this.when = -1;
        this.ppp = -1;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.f384if = glGetUniformLocation;
        fe.de(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "inv_max_dist");
        this.f385switch = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, "inv_max_dist");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i2, "stepsizeX");
        this.when = glGetUniformLocation3;
        fe.de(glGetUniformLocation3, "stepsizeX");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i2, "stepsizeY");
        this.ppp = glGetUniformLocation4;
        fe.de(glGetUniformLocation4, "stepsizeY");
    }

    public void yj(int i2, int i3) {
        super.yj(i2, i3);
        this.f9018o = i2;
        this.f9019pf = i3;
    }
}
