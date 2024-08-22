package fe.ggg.ad.ad.qw;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f7574ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f7575de;
    @NotNull
    public final String qw;

    @NotNull
    public final String ad() {
        return this.f7575de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) feVar.qw) && this.f7574ad == feVar.f7574ad;
    }

    public int hashCode() {
        int hashCode = this.qw.hashCode() * 31;
        boolean z = this.f7574ad;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public final String qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "ProductParam(productId=" + this.qw + ", isSubs=" + this.f7574ad + ')';
    }
}
