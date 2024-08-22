package fe.mmm.qw.k.yj;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f8007ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f8008de;
    public final int qw;

    public qw(int i2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, "serverOrderId");
        this.qw = i2;
        this.f8007ad = str;
        this.f8008de = str2;
    }

    @NotNull
    public final String ad() {
        return this.f8008de;
    }

    public final boolean de() {
        return this.qw == 100005;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return this.qw == qwVar.qw && Intrinsics.areEqual((Object) this.f8007ad, (Object) qwVar.f8007ad) && Intrinsics.areEqual((Object) this.f8008de, (Object) qwVar.f8008de);
    }

    public final boolean fe() {
        return this.qw == 801;
    }

    public int hashCode() {
        return (((this.qw * 31) + this.f8007ad.hashCode()) * 31) + this.f8008de.hashCode();
    }

    @NotNull
    public final String qw() {
        return this.f8007ad;
    }

    @NotNull
    public String toString() {
        return "VipBuyResult(code=" + this.qw + ", msg=" + this.f8007ad + ", serverOrderId=" + this.f8008de + ')';
    }
}
