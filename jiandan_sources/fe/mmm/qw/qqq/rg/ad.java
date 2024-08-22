package fe.mmm.qw.qqq.rg;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public String f8222ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f8223de;
    public final int qw;

    public ad(int i2, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "pageImagePath");
        this.qw = i2;
        this.f8222ad = str;
        this.f8223de = z;
    }

    public final int ad() {
        return this.qw;
    }

    public final boolean de() {
        return this.f8223de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.qw == adVar.qw && Intrinsics.areEqual((Object) this.f8222ad, (Object) adVar.f8222ad) && this.f8223de == adVar.f8223de;
    }

    public final void fe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f8222ad = str;
    }

    public int hashCode() {
        int hashCode = ((this.qw * 31) + this.f8222ad.hashCode()) * 31;
        boolean z = this.f8223de;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public final String qw() {
        return this.f8222ad;
    }

    public final void rg(boolean z) {
        this.f8223de = z;
    }

    @NotNull
    public String toString() {
        return "SplitPdfItemData(pageIndex=" + this.qw + ", pageImagePath=" + this.f8222ad + ", isSelected=" + this.f8223de + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(int i2, String str, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, (i3 & 4) != 0 ? false : z);
    }
}
