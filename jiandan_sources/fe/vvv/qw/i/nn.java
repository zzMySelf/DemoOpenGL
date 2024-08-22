package fe.vvv.qw.i;

import android.graphics.Color;
import android.opengl.GLES20;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class nn extends qw implements OneParameterFilter {

    /* renamed from: o  reason: collision with root package name */
    public int f9008o = SupportMenu.CATEGORY_MASK;

    /* renamed from: pf  reason: collision with root package name */
    public int f9009pf = -1;

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        GLES20.glUniform3fv(this.f9009pf, 1, new float[]{((float) Color.red(this.f9008o)) / 255.0f, ((float) Color.green(this.f9008o)) / 255.0f, ((float) Color.blue(this.f9008o)) / 255.0f}, 0);
        fe.ad("glUniform3fv");
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform vec3 tint;\nvec3 color_ratio;\nvarying vec2 vTextureCoord;\nvoid main() {\n  color_ratio[0] = 0.21;\n  color_ratio[1] = 0.71;\n  color_ratio[2] = 0.07;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float avg_color = dot(color_ratio, color.rgb);\n  vec3 new_color = min(0.8 * avg_color + 0.2 * tint, 1.0);\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    public void i(float f) {
        mmm((int) (f * 1.6777215E7f));
    }

    public void mmm(@ColorInt int i2) {
        this.f9008o = Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    @ColorInt
    public int nn() {
        return this.f9008o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9009pf = -1;
    }

    public float rg() {
        int nn = nn();
        return ((float) Color.argb(0, Color.red(nn), Color.green(nn), Color.blue(nn))) / 1.6777215E7f;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "tint");
        this.f9009pf = glGetUniformLocation;
        fe.de(glGetUniformLocation, "tint");
    }
}
