package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

/* renamed from: fe.vvv.qw.i.if  reason: invalid class name */
public class Cif extends qw implements OneParameterFilter {

    /* renamed from: o  reason: collision with root package name */
    public float f9004o = 0.0f;

    /* renamed from: pf  reason: collision with root package name */
    public int f9005pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform1f(this.f9005pf, (((this.f9004o - 45.0f) / 45.0f) + 0.5f) * -1.0f);
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float hue;\nvoid main() {\n  vec4 kRGBToYPrime = vec4 (0.299, 0.587, 0.114, 0.0);\n  vec4 kRGBToI = vec4 (0.595716, -0.274453, -0.321263, 0.0);\n  vec4 kRGBToQ = vec4 (0.211456, -0.522591, 0.31135, 0.0);\n  vec4 kYIQToR = vec4 (1.0, 0.9563, 0.6210, 0.0);\n  vec4 kYIQToG = vec4 (1.0, -0.2721, -0.6474, 0.0);\n  vec4 kYIQToB = vec4 (1.0, -1.1070, 1.7046, 0.0);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float YPrime = dot(color, kRGBToYPrime);\n  float I = dot(color, kRGBToI);\n  float Q = dot(color, kRGBToQ);\n  float chroma = sqrt (I * I + Q * Q);\n  Q = chroma * sin (hue);\n  I = chroma * cos (hue);\n  vec4 yIQ = vec4 (YPrime, I, Q, 0.0);\n  color.r = dot (yIQ, kYIQToR);\n  color.g = dot (yIQ, kYIQToG);\n  color.b = dot (yIQ, kYIQToB);\n  gl_FragColor = color;\n}\n";
    }

    public void i(float f) {
        mmm(f * 360.0f);
    }

    public void mmm(float f) {
        this.f9004o = f % 360.0f;
    }

    public float nn() {
        return this.f9004o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9005pf = -1;
    }

    public float rg() {
        return nn() / 360.0f;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "hue");
        this.f9005pf = glGetUniformLocation;
        fe.de(glGetUniformLocation, "hue");
    }
}
