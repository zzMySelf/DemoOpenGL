package fe.mmm.qw.xxx.rg;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f8643ad;
    public final boolean qw;

    public qw(boolean z, boolean z2) {
        this.qw = z;
        this.f8643ad = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return this.qw == qwVar.qw && this.f8643ad == qwVar.f8643ad;
    }

    public int hashCode() {
        boolean z = this.qw;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.f8643ad;
        if (!z3) {
            z2 = z3;
        }
        return i2 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "LogOutResult(logoutResult=" + this.qw + ", needFinishPage=" + this.f8643ad + ')';
    }
}
