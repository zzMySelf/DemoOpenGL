package fe.ggg.qw.qw;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @SerializedName("node_key")
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f7598ad;
    @SerializedName("node_name")
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f7599de;
    @SerializedName("scan_tool_event_id")
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final String f7600fe;
    @SerializedName("scan_tool_title")
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f7601i;
    @SerializedName("cfg_version")
    public final long qw;
    @SerializedName("scan_tool_icon_dark_url")
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final String f7602rg;
    @SerializedName("scan_tool_icon_url")
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final String f7603th;
    @SerializedName("scan_tool_scheme_iOS_url")
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public final String f7604uk;
    @SerializedName("scan_tool_jump_url")
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final String f7605yj;

    @Nullable
    public final String ad() {
        return this.f7603th;
    }

    @Nullable
    public final String de() {
        return this.f7605yj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return this.qw == qwVar.qw && Intrinsics.areEqual((Object) this.f7598ad, (Object) qwVar.f7598ad) && Intrinsics.areEqual((Object) this.f7599de, (Object) qwVar.f7599de) && Intrinsics.areEqual((Object) this.f7600fe, (Object) qwVar.f7600fe) && Intrinsics.areEqual((Object) this.f7602rg, (Object) qwVar.f7602rg) && Intrinsics.areEqual((Object) this.f7603th, (Object) qwVar.f7603th) && Intrinsics.areEqual((Object) this.f7605yj, (Object) qwVar.f7605yj) && Intrinsics.areEqual((Object) this.f7604uk, (Object) qwVar.f7604uk) && Intrinsics.areEqual((Object) this.f7601i, (Object) qwVar.f7601i);
    }

    @Nullable
    public final String fe() {
        return this.f7601i;
    }

    public int hashCode() {
        int qw2 = ((((defpackage.qw.qw(this.qw) * 31) + this.f7598ad.hashCode()) * 31) + this.f7599de.hashCode()) * 31;
        String str = this.f7600fe;
        int i2 = 0;
        int hashCode = (qw2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f7602rg;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f7603th;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f7605yj;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f7604uk;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f7601i;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    @Nullable
    public final String qw() {
        return this.f7600fe;
    }

    @NotNull
    public String toString() {
        return "ScanServiceToolSubItem(amisCfgVersion=" + this.qw + ", amisNodeKey=" + this.f7598ad + ", amisNodeName=" + this.f7599de + ", amisScanToolEventId=" + this.f7600fe + ", amisScanToolIconDarkUrl=" + this.f7602rg + ", amisScanToolIconUrl=" + this.f7603th + ", amisScanToolJumpUrl=" + this.f7605yj + ", amisScanToolSchemeIOSUrl=" + this.f7604uk + ", amisScanToolTitle=" + this.f7601i + ')';
    }
}
