package fe.mmm.qw.xxx.p032if.fe;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.fe.ad  reason: invalid package */
public final class ad {
    @SerializedName("node_key")
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f8594ad;
    @SerializedName("node_name")
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f8595de;
    @SerializedName("scan_kingkong_show_type")
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final Long f8596fe;
    @SerializedName("scan_tool_scheme_iOS_url")
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f8597i;
    @SerializedName("scan_tool_title")
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public final String f8598o;
    @SerializedName("cfg_version")
    public final long qw;
    @SerializedName("scan_tool_event_id")
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final String f8599rg;
    @SerializedName("scan_tool_icon_dark_url")
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final String f8600th;
    @SerializedName("scan_tool_jump_url")
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public final String f8601uk;
    @SerializedName("scan_tool_icon_url")
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final String f8602yj;

    @Nullable
    public final String ad() {
        return this.f8600th;
    }

    @Nullable
    public final String de() {
        return this.f8602yj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.qw == adVar.qw && Intrinsics.areEqual((Object) this.f8594ad, (Object) adVar.f8594ad) && Intrinsics.areEqual((Object) this.f8595de, (Object) adVar.f8595de) && Intrinsics.areEqual((Object) this.f8596fe, (Object) adVar.f8596fe) && Intrinsics.areEqual((Object) this.f8599rg, (Object) adVar.f8599rg) && Intrinsics.areEqual((Object) this.f8600th, (Object) adVar.f8600th) && Intrinsics.areEqual((Object) this.f8602yj, (Object) adVar.f8602yj) && Intrinsics.areEqual((Object) this.f8601uk, (Object) adVar.f8601uk) && Intrinsics.areEqual((Object) this.f8597i, (Object) adVar.f8597i) && Intrinsics.areEqual((Object) this.f8598o, (Object) adVar.f8598o);
    }

    @Nullable
    public final String fe() {
        return this.f8601uk;
    }

    public int hashCode() {
        int qw2 = ((((qw.qw(this.qw) * 31) + this.f8594ad.hashCode()) * 31) + this.f8595de.hashCode()) * 31;
        Long l = this.f8596fe;
        int i2 = 0;
        int hashCode = (qw2 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.f8599rg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8600th;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f8602yj;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f8601uk;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f8597i;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f8598o;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode6 + i2;
    }

    @Nullable
    public final String qw() {
        return this.f8599rg;
    }

    @Nullable
    public final String rg() {
        return this.f8598o;
    }

    @NotNull
    public String toString() {
        return "ScanServiceAreaItem(amisCfgVersion=" + this.qw + ", amisNodeKey=" + this.f8594ad + ", amisNodeName=" + this.f8595de + ", amisScanKingkongShowType=" + this.f8596fe + ", amisScanToolEventId=" + this.f8599rg + ", amisScanToolIconDarkUrl=" + this.f8600th + ", amisScanToolIconUrl=" + this.f8602yj + ", amisScanToolJumpUrl=" + this.f8601uk + ", amisScanToolSchemeIOSUrl=" + this.f8597i + ", amisScanToolTitle=" + this.f8598o + ')';
    }
}
