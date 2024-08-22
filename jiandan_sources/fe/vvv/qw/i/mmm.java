package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class mmm extends qw implements TwoParameterFilter {
    public int ggg = -1;

    /* renamed from: if  reason: not valid java name */
    public int f377if = 1;

    /* renamed from: o  reason: collision with root package name */
    public float f9006o = 0.85f;

    /* renamed from: pf  reason: collision with root package name */
    public float f9007pf = 0.5f;
    public int ppp = -1;

    /* renamed from: switch  reason: not valid java name */
    public int f378switch = 1;
    public int vvv = -1;
    public int when = -1;

    public void aaa(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f9006o = f;
    }

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        float[] fArr2 = new float[2];
        int i2 = this.f377if;
        int i3 = this.f378switch;
        if (i2 > i3) {
            fArr2[0] = 1.0f;
            fArr2[1] = ((float) i3) / ((float) i2);
        } else {
            fArr2[0] = ((float) i2) / ((float) i3);
            fArr2[1] = 1.0f;
        }
        GLES20.glUniform2fv(this.vvv, 1, fArr2, 0);
        fe.ad("glUniform2fv");
        GLES20.glUniform1f(this.ppp, 1.0f / (((float) Math.sqrt((double) ((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1])))) * 0.5f));
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.ggg, this.f9007pf);
        fe.ad("glUniform1f");
        GLES20.glUniform1f(this.when, 1.3f - (((float) Math.sqrt((double) this.f9006o)) * 0.7f));
        fe.ad("glUniform1f");
    }

    public float de() {
        return mmm();
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float range;\nuniform float inv_max_dist;\nuniform float shade;\nuniform vec2 scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n  const float slope = 20.0;\n  vec2 coord = vTextureCoord - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = shade / (1.0 + exp((dist * inv_max_dist - range) * slope)) + (1.0 - shade);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = vec4(color.rgb * lumen, color.a);\n}\n";
    }

    public void i(float f) {
        aaa(f);
    }

    public float mmm() {
        return this.f9007pf;
    }

    public float nn() {
        return this.f9006o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.when = -1;
        this.ppp = -1;
        this.ggg = -1;
        this.vvv = -1;
    }

    public void qqq(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f9007pf = f;
    }

    public float rg() {
        return nn();
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "range");
        this.when = glGetUniformLocation;
        fe.de(glGetUniformLocation, "range");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "inv_max_dist");
        this.ppp = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, "inv_max_dist");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i2, "shade");
        this.ggg = glGetUniformLocation3;
        fe.de(glGetUniformLocation3, "shade");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i2, "scale");
        this.vvv = glGetUniformLocation4;
        fe.de(glGetUniformLocation4, "scale");
    }

    public void uk(float f) {
        qqq(f);
    }

    public void yj(int i2, int i3) {
        super.yj(i2, i3);
        this.f377if = i2;
        this.f378switch = i3;
    }
}
