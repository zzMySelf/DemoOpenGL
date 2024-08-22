package fe.mmm.qw.p030switch.rg;

import com.baidu.sapi2.SapiAccount;
import com.baidu.ubc.UBCManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* renamed from: fe.mmm.qw.switch.rg.rg  reason: invalid package */
public final class rg {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f8315ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f8316de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final String f8317fe;
    @NotNull
    public final String qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final String f8318rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final String f8319th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final JSONObject f8320yj;

    public rg(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "from");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, UBCManager.CONTENT_KEY_PAGE);
        Intrinsics.checkNotNullParameter(str5, "value");
        Intrinsics.checkNotNullParameter(str6, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(jSONObject, SapiAccount.SAPI_ACCOUNT_EXTRA);
        this.qw = str;
        this.f8315ad = str2;
        this.f8316de = str3;
        this.f8317fe = str4;
        this.f8318rg = str5;
        this.f8319th = str6;
        this.f8320yj = jSONObject;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rg)) {
            return false;
        }
        rg rgVar = (rg) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) rgVar.qw) && Intrinsics.areEqual((Object) this.f8315ad, (Object) rgVar.f8315ad) && Intrinsics.areEqual((Object) this.f8316de, (Object) rgVar.f8316de) && Intrinsics.areEqual((Object) this.f8317fe, (Object) rgVar.f8317fe) && Intrinsics.areEqual((Object) this.f8318rg, (Object) rgVar.f8318rg) && Intrinsics.areEqual((Object) this.f8319th, (Object) rgVar.f8319th) && Intrinsics.areEqual((Object) this.f8320yj, (Object) rgVar.f8320yj);
    }

    public int hashCode() {
        return (((((((((((this.qw.hashCode() * 31) + this.f8315ad.hashCode()) * 31) + this.f8316de.hashCode()) * 31) + this.f8317fe.hashCode()) * 31) + this.f8318rg.hashCode()) * 31) + this.f8319th.hashCode()) * 31) + this.f8320yj.hashCode();
    }

    @NotNull
    public String toString() {
        return "StatisticData(eventId=" + this.qw + ", from=" + this.f8315ad + ", type=" + this.f8316de + ", page=" + this.f8317fe + ", value=" + this.f8318rg + ", source=" + this.f8319th + ", extra=" + this.f8320yj + ')';
    }
}
