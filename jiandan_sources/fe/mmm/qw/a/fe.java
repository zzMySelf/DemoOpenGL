package fe.mmm.qw.a;

import com.baidu.sapi2.SapiAccount;
import com.baidu.ubc.UBCManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class fe {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f7608ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f7609de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final String f7610fe;
    @NotNull
    public final String qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final String f7611rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final String f7612th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final JSONObject f7613yj;

    public fe(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "from");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, UBCManager.CONTENT_KEY_PAGE);
        Intrinsics.checkNotNullParameter(str5, "value");
        Intrinsics.checkNotNullParameter(str6, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(jSONObject, SapiAccount.SAPI_ACCOUNT_EXTRA);
        this.qw = str;
        this.f7608ad = str2;
        this.f7609de = str3;
        this.f7610fe = str4;
        this.f7611rg = str5;
        this.f7612th = str6;
        this.f7613yj = jSONObject;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) feVar.qw) && Intrinsics.areEqual((Object) this.f7608ad, (Object) feVar.f7608ad) && Intrinsics.areEqual((Object) this.f7609de, (Object) feVar.f7609de) && Intrinsics.areEqual((Object) this.f7610fe, (Object) feVar.f7610fe) && Intrinsics.areEqual((Object) this.f7611rg, (Object) feVar.f7611rg) && Intrinsics.areEqual((Object) this.f7612th, (Object) feVar.f7612th) && Intrinsics.areEqual((Object) this.f7613yj, (Object) feVar.f7613yj);
    }

    public int hashCode() {
        return (((((((((((this.qw.hashCode() * 31) + this.f7608ad.hashCode()) * 31) + this.f7609de.hashCode()) * 31) + this.f7610fe.hashCode()) * 31) + this.f7611rg.hashCode()) * 31) + this.f7612th.hashCode()) * 31) + this.f7613yj.hashCode();
    }

    @NotNull
    public String toString() {
        return "StatisticCostData(eventId=" + this.qw + ", from=" + this.f7608ad + ", type=" + this.f7609de + ", page=" + this.f7610fe + ", value=" + this.f7611rg + ", source=" + this.f7612th + ", extra=" + this.f7613yj + ')';
    }
}
