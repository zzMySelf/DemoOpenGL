package fe.de.qw.qw;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class when {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final List f1302ad;
    @NotNull
    public final yj qw;

    public when(@RecentlyNonNull yj yjVar, @RecentlyNonNull List<? extends Cif> list) {
        Intrinsics.checkNotNullParameter(yjVar, "billingResult");
        Intrinsics.checkNotNullParameter(list, "purchasesList");
        this.qw = yjVar;
        this.f1302ad = list;
    }

    public boolean equals(@RecentlyNonNull @Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof when)) {
            return false;
        }
        when when = (when) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) when.qw) && Intrinsics.areEqual((Object) this.f1302ad, (Object) when.f1302ad);
    }

    public int hashCode() {
        return (this.qw.hashCode() * 31) + this.f1302ad.hashCode();
    }

    @NotNull
    public final List<Cif> qw() {
        return this.f1302ad;
    }

    @NotNull
    public String toString() {
        return "PurchasesResult(billingResult=" + this.qw + ", purchasesList=" + this.f1302ad + ')';
    }
}
