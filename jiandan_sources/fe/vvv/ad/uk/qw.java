package fe.vvv.ad.uk;

import fe.vvv.ad.th.fe;
import fe.vvv.ad.th.rg;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f8851ad = -1;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public fe.vvv.ad.ad.qw f8852de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public rg f8853fe;
    public int qw = -1;

    public qw(@NotNull fe.vvv.ad.ad.qw qwVar, @NotNull rg rgVar) {
        Intrinsics.checkNotNullParameter(qwVar, "eglCore");
        Intrinsics.checkNotNullParameter(rgVar, "eglSurface");
        this.f8852de = qwVar;
        this.f8853fe = rgVar;
    }

    @NotNull
    public final rg ad() {
        return this.f8853fe;
    }

    public final int de() {
        int i2 = this.f8851ad;
        return i2 < 0 ? this.f8852de.fe(this.f8853fe, fe.th()) : i2;
    }

    public final int fe() {
        int i2 = this.qw;
        return i2 < 0 ? this.f8852de.fe(this.f8853fe, fe.xxx()) : i2;
    }

    @NotNull
    public final fe.vvv.ad.ad.qw qw() {
        return this.f8852de;
    }

    public final boolean rg() {
        return this.f8852de.ad(this.f8853fe);
    }

    public final void th() {
        this.f8852de.de(this.f8853fe);
    }

    public final void uk(long j) {
        this.f8852de.yj(this.f8853fe, j);
    }

    public void yj() {
        this.f8852de.th(this.f8853fe);
        this.f8853fe = fe.o();
        this.f8851ad = -1;
        this.qw = -1;
    }
}
