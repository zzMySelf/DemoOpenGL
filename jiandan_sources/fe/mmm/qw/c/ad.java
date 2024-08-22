package fe.mmm.qw.c;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    public boolean qw;

    public ad() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public ad(boolean z) {
        this.qw = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ad) && this.qw == ((ad) obj).qw;
    }

    public int hashCode() {
        boolean z = this.qw;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "Config(isStrictMode=" + this.qw + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z);
    }
}
