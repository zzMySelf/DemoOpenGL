package yj.qw.qw.qw.qw.de;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final String f11098ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f11099de;

    /* renamed from: fe  reason: collision with root package name */
    public int f11100fe;
    public final LinkedList<Runnable> qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f11101rg;

    /* renamed from: th  reason: collision with root package name */
    public int f11102th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f11103uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f11104yj;

    public qw() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public int ad() {
        return this.f11100fe;
    }

    public void de() {
        if (!this.f11103uk) {
            fe();
        }
    }

    public final void fe() {
        i();
        o();
    }

    public void i() {
        int qw2 = yj.qw.qw.qw.qw.fe.qw.qw(this.f11098ad, this.f11099de);
        this.f11100fe = qw2;
        this.f11101rg = GLES20.glGetAttribLocation(qw2, "position");
        this.f11102th = GLES20.glGetUniformLocation(this.f11100fe, "inputImageTexture");
        this.f11104yj = GLES20.glGetAttribLocation(this.f11100fe, "inputTextureCoordinate");
        this.f11103uk = true;
    }

    /* renamed from: if  reason: not valid java name */
    public void m2360if() {
        synchronized (this.qw) {
            while (!this.qw.isEmpty()) {
                this.qw.removeFirst().run();
            }
        }
    }

    public void o() {
    }

    public void pf(int i2, int i3) {
    }

    public final void qw() {
        this.f11103uk = false;
        GLES20.glDeleteProgram(this.f11100fe);
        th();
    }

    public boolean rg() {
        return this.f11103uk;
    }

    public void th() {
    }

    public void uk() {
    }

    public void yj(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f11100fe);
        m2360if();
        if (this.f11103uk) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.f11101rg, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f11101rg);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.f11104yj, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.f11104yj);
            if (i2 != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i2);
                GLES20.glUniform1i(this.f11102th, 0);
            }
            uk();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f11101rg);
            GLES20.glDisableVertexAttribArray(this.f11104yj);
            GLES20.glBindTexture(3553, 0);
        }
    }

    public qw(String str, String str2) {
        this.qw = new LinkedList<>();
        this.f11098ad = str;
        this.f11099de = str2;
    }
}
