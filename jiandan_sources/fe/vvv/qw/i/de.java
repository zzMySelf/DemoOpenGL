package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class de extends qw implements OneParameterFilter {

    /* renamed from: o  reason: collision with root package name */
    public float f8996o = 2.0f;

    /* renamed from: pf  reason: collision with root package name */
    public int f8997pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform1f(this.f8997pf, this.f8996o);
        fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float brightness;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = brightness * color;\n}\n";
    }

    public void i(float f) {
        mmm(f + 1.0f);
    }

    public void mmm(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        this.f8996o = f;
    }

    public float nn() {
        return this.f8996o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f8997pf = -1;
    }

    public float rg() {
        return nn() - 1.0f;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "brightness");
        this.f8997pf = glGetUniformLocation;
        fe.de(glGetUniformLocation, "brightness");
    }
}
