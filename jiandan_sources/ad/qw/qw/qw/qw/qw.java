package ad.qw.qw.qw.qw;

import _._._._._.__;
import com.baidu.netdisk.trade.privilege.config.IRequest;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final long f547ad;
    @NotNull
    public final String qw;

    public qw(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "cluster");
        this.qw = str;
        this.f547ad = j;
    }

    public final long ad() {
        return this.f547ad;
    }

    public final boolean de() {
        long j;
        IRequest ad2 = __.f542ad.ad();
        if (ad2 != null) {
            j = ad2.rg();
        } else {
            j = System.currentTimeMillis();
        }
        long j2 = this.f547ad;
        return j > ((long) 1000) * j2 || j2 <= 0;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof qw) && Intrinsics.areEqual((Object) ((qw) obj).qw, (Object) this.qw);
    }

    public int hashCode() {
        String str = this.qw;
        return ((str != null ? str.hashCode() : 0) * 31) + defpackage.qw.qw(this.f547ad);
    }

    @NotNull
    public final String qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "PCombineProduct(cluster=" + this.qw + ", endTime=" + this.f547ad + ")";
    }
}
