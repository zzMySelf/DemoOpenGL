package fe.mmm.qw.j.nn.ad;

import com.tera.scan.utils.listdiff.patch.delta.DeltaType;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final int f7970ad;
    @JvmField

    /* renamed from: de  reason: collision with root package name */
    public final int f7971de;
    @JvmField

    /* renamed from: fe  reason: collision with root package name */
    public final int f7972fe;
    @NotNull
    @JvmField
    public final DeltaType qw;
    @JvmField

    /* renamed from: rg  reason: collision with root package name */
    public final int f7973rg;

    public qw(@NotNull DeltaType deltaType, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(deltaType, "deltaType");
        this.qw = deltaType;
        this.f7970ad = i2;
        this.f7971de = i3;
        this.f7972fe = i4;
        this.f7973rg = i5;
    }

    public final int ad() {
        return this.f7970ad;
    }

    public final int de() {
        return this.f7971de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return this.qw == qwVar.qw && this.f7970ad == qwVar.f7970ad && this.f7971de == qwVar.f7971de && this.f7972fe == qwVar.f7972fe && this.f7973rg == qwVar.f7973rg;
    }

    public final int fe() {
        return this.f7972fe;
    }

    public int hashCode() {
        return (((((((this.qw.hashCode() * 31) + this.f7970ad) * 31) + this.f7971de) * 31) + this.f7972fe) * 31) + this.f7973rg;
    }

    @NotNull
    public final DeltaType qw() {
        return this.qw;
    }

    public final int rg() {
        return this.f7973rg;
    }

    @NotNull
    public final qw th(int i2) {
        return new qw(this.qw, this.f7970ad, i2, this.f7972fe, this.f7973rg);
    }

    @NotNull
    public String toString() {
        return "Change(deltaType=" + this.qw + ", startOriginal=" + this.f7970ad + ", endOriginal=" + this.f7971de + ", startRevised=" + this.f7972fe + ", endRevised=" + this.f7973rg + ')';
    }

    @NotNull
    public final qw yj(int i2) {
        return new qw(this.qw, this.f7970ad, this.f7971de, this.f7972fe, i2);
    }
}
