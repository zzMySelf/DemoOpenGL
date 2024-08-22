package fe.mmm.qw.j.nn.de;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad extends de {

    /* renamed from: ad  reason: collision with root package name */
    public final int f7974ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f7975de;
    public final int qw;

    public ad(int i2, int i3, int i4) {
        super((DefaultConstructorMarker) null);
        this.qw = i2;
        this.f7974ad = i3;
        this.f7975de = i4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.qw == adVar.qw && this.f7974ad == adVar.f7974ad && this.f7975de == adVar.f7975de;
    }

    public int hashCode() {
        return (((this.qw * 31) + this.f7974ad) * 31) + this.f7975de;
    }

    @NotNull
    public String toString() {
        return "Insert(oldPosition=" + this.qw + ", newPosition=" + this.f7974ad + ", count=" + this.f7975de + ')';
    }
}
