package fe.vvv.qw.p037if;

import android.opengl.GLES20;

/* renamed from: fe.vvv.qw.if.rg  reason: invalid package */
public class rg {
    public final int qw;

    public rg(int i2) {
        this.qw = i2;
    }

    public final void ad(int i2) {
        GLES20.glBindTexture(36197, i2);
    }

    public void de() {
        ad(0);
    }

    public void qw() {
        ad(this.qw);
    }
}
