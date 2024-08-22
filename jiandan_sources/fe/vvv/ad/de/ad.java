package fe.vvv.ad.de;

import fe.vvv.ad.ad.fe;
import fe.vvv.ad.ad.th;
import fe.vvv.ad.th.yj;
import java.nio.FloatBuffer;
import org.jetbrains.annotations.NotNull;

public abstract class ad extends th {

    /* renamed from: ad  reason: collision with root package name */
    public int f8825ad;
    @NotNull
    public final float[] qw = yj.de(fe.qw);

    public abstract int ad();

    @NotNull
    public final float[] de() {
        return this.qw;
    }

    @NotNull
    public abstract FloatBuffer fe();

    public abstract void qw();

    public final int rg() {
        return this.f8825ad;
    }

    public int th() {
        return fe().limit() / ad();
    }

    public int yj() {
        return ad() * 4;
    }
}
