package fe.vvv.qw.i;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.qw.uk.qw;

public class fe extends qw implements OneParameterFilter {

    /* renamed from: o  reason: collision with root package name */
    public float f8998o = 2.0f;

    /* renamed from: pf  reason: collision with root package name */
    public int f8999pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform1f(this.f8999pf, this.f8998o);
        fe.vvv.ad.ad.fe.ad("glUniform1f");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float contrast;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  color -= 0.5;\n  color *= contrast;\n  color += 0.5;\n  gl_FragColor = color;\n}\n";
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
        this.f8998o = f;
    }

    public float nn() {
        return this.f8998o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f8999pf = -1;
    }

    public float rg() {
        return nn() - 1.0f;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "contrast");
        this.f8999pf = glGetUniformLocation;
        fe.vvv.ad.ad.fe.de(glGetUniformLocation, "contrast");
    }
}
