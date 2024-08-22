package fe.vvv.qw.i;

import android.graphics.Color;
import android.opengl.GLES20;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.google.gson.internal.bind.TypeAdapters;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import fe.vvv.ad.ad.fe;
import fe.vvv.qw.uk.qw;

public class yj extends qw implements TwoParameterFilter {

    /* renamed from: if  reason: not valid java name */
    public int f388if = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f9022o = -65281;

    /* renamed from: pf  reason: collision with root package name */
    public int f9023pf = InputDeviceCompat.SOURCE_ANY;

    /* renamed from: switch  reason: not valid java name */
    public int f389switch = -1;

    public void aaa(@ColorInt int i2) {
        this.f9022o = Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public void ddd(long j, @NonNull float[] fArr) {
        super.ddd(j, fArr);
        float[] fArr2 = {((float) Color.red(this.f9022o)) / 255.0f, ((float) Color.green(this.f9022o)) / 255.0f, ((float) Color.blue(this.f9022o)) / 255.0f};
        float[] fArr3 = {((float) Color.red(this.f9023pf)) / 255.0f, ((float) Color.green(this.f9023pf)) / 255.0f, ((float) Color.blue(this.f9023pf)) / 255.0f};
        GLES20.glUniform3fv(this.f388if, 1, fArr2, 0);
        fe.ad("glUniform3fv");
        GLES20.glUniform3fv(this.f389switch, 1, fArr3, 0);
        fe.ad("glUniform3fv");
    }

    public float de() {
        int mmm = mmm();
        return ((float) Color.argb(0, Color.red(mmm), Color.green(mmm), Color.blue(mmm))) / 1.6777215E7f;
    }

    @NonNull
    public String fe() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform vec3 first;\nuniform vec3 second;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float energy = (color.r + color.g + color.b) * 0.3333;\n  vec3 new_color = (1.0 - energy) * first + energy * second;\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    public void i(float f) {
        aaa((int) (f * 1.6777215E7f));
    }

    @ColorInt
    public int mmm() {
        return this.f9023pf;
    }

    @ColorInt
    public int nn() {
        return this.f9022o;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f388if = -1;
        this.f389switch = -1;
    }

    public void qqq(@ColorInt int i2) {
        this.f9023pf = Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public float rg() {
        int nn = nn();
        return ((float) Color.argb(0, Color.red(nn), Color.green(nn), Color.blue(nn))) / 1.6777215E7f;
    }

    public void th(int i2) {
        super.th(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "first");
        this.f388if = glGetUniformLocation;
        fe.de(glGetUniformLocation, "first");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, TypeAdapters.AnonymousClass27.SECOND);
        this.f389switch = glGetUniformLocation2;
        fe.de(glGetUniformLocation2, TypeAdapters.AnonymousClass27.SECOND);
    }

    public void uk(float f) {
        qqq((int) (f * 1.6777215E7f));
    }
}
