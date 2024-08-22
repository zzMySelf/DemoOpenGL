package fe.mmm.qw.l.fe.ad;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @SerializedName("redDot")

    /* renamed from: ad  reason: collision with root package name */
    public final int f8010ad;
    @SerializedName("text")
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final String f8011de;
    @SerializedName("url")
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final String f8012fe;
    @SerializedName("show")
    public final int qw;
    @SerializedName("color")
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final String f8013rg;

    public final int ad() {
        return this.f8010ad;
    }

    public final int de() {
        return this.qw;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.qw == adVar.qw && this.f8010ad == adVar.f8010ad && Intrinsics.areEqual((Object) this.f8011de, (Object) adVar.f8011de) && Intrinsics.areEqual((Object) this.f8012fe, (Object) adVar.f8012fe) && Intrinsics.areEqual((Object) this.f8013rg, (Object) adVar.f8013rg);
    }

    @Nullable
    public final String fe() {
        return this.f8011de;
    }

    public int hashCode() {
        int i2 = ((this.qw * 31) + this.f8010ad) * 31;
        String str = this.f8011de;
        int i3 = 0;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8012fe;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f8013rg;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return hashCode2 + i3;
    }

    @Nullable
    public final String qw() {
        return this.f8013rg;
    }

    @Nullable
    public final String rg() {
        return this.f8012fe;
    }

    @NotNull
    public String toString() {
        return "TitleBarTheme(show=" + this.qw + ", redDot=" + this.f8010ad + ", text=" + this.f8011de + ", url=" + this.f8012fe + ", color=" + this.f8013rg + ')';
    }
}
