package fe.mmm.qw.xxx.p032if.fe;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.fe.qw  reason: invalid package */
public final class qw {
    @SerializedName("toolTabUbcExt")
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f8603ad;
    @SerializedName("toolGroupList")
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public List<fe.ggg.qw.qw.qw> f8604de;
    @SerializedName("toolGroupName")
    @Nullable
    public final String qw;

    @Nullable
    public final String ad() {
        return this.qw;
    }

    @NotNull
    public final String de() {
        return this.f8603ad;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && Intrinsics.areEqual((Object) this.f8603ad, (Object) qwVar.f8603ad) && Intrinsics.areEqual((Object) this.f8604de, (Object) qwVar.f8604de);
    }

    public int hashCode() {
        String str = this.qw;
        int i2 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.f8603ad.hashCode()) * 31;
        List<fe.ggg.qw.qw.qw> list = this.f8604de;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    @Nullable
    public final List<fe.ggg.qw.qw.qw> qw() {
        return this.f8604de;
    }

    @NotNull
    public String toString() {
        return "AllScanToolRes(toolGroupName=" + this.qw + ", toolTabUbcExt=" + this.f8603ad + ", toolGroupList=" + this.f8604de + ')';
    }
}
