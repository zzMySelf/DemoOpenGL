package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class i extends qw implements OneParameterFilter {

    /* renamed from: o  reason: collision with root package name */
    public float f9002o = 2.0f;

    /* renamed from: pf  reason: collision with root package name */
    public int f9003pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform1f(this.f9003pf, this.f9002o);
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float gamma;\nvoid main() {\n  vec4 textureColor = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n}\n";
    }

    public void i(float f) {
        mmm(f * 2.0f);
    }

    public void mmm(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        this.f9002o = f;
    }

    public float nn() {
        return this.f9002o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9003pf = -1;
    }

    public float rg() {
        return nn() / 2.0f;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "gamma");
        this.f9003pf = glGetUniformLocation;
        fe.de(glGetUniformLocation, "gamma");
    }
}
