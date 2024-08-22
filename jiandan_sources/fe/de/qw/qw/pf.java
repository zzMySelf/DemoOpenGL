package fe.de.qw.qw;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class pf {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final List f1275ad;
    @NotNull
    public final yj qw;

    public pf(@RecentlyNonNull yj yjVar, @RecentlyNonNull @Nullable List<o> list) {
        Intrinsics.checkNotNullParameter(yjVar, "billingResult");
        this.qw = yjVar;
        this.f1275ad = list;
    }

    @RecentlyNonNull
    @Nullable
    public final List<o> ad() {
        return this.f1275ad;
    }

    public boolean equals(@RecentlyNonNull @Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pf)) {
            return false;
        }
        pf pfVar = (pf) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) pfVar.qw) && Intrinsics.areEqual((Object) this.f1275ad, (Object) pfVar.f1275ad);
    }

    public int hashCode() {
        int hashCode = this.qw.hashCode() * 31;
        List list = this.f1275ad;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public final yj qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "ProductDetailsResult(billingResult=" + this.qw + ", productDetailsList=" + this.f1275ad + ')';
    }
}
