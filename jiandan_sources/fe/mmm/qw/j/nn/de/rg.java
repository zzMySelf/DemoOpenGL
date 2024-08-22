package fe.mmm.qw.j.nn.de;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg extends de {

    /* renamed from: ad  reason: collision with root package name */
    public final int f7979ad;
    public final int qw;

    public rg(int i2, int i3) {
        super((DefaultConstructorMarker) null);
        this.qw = i2;
        this.f7979ad = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rg)) {
            return false;
        }
        rg rgVar = (rg) obj;
        return this.qw == rgVar.qw && this.f7979ad == rgVar.f7979ad;
    }

    public int hashCode() {
        return (this.qw * 31) + this.f7979ad;
    }

    @NotNull
    public String toString() {
        return "Remove(position=" + this.qw + ", count=" + this.f7979ad + ')';
    }
}
