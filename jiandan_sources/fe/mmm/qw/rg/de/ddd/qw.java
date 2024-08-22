package fe.mmm.qw.rg.de.ddd;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final String f8268ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f8269de;
    @NotNull
    public final String qw;

    public qw(@NotNull String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "imagePath");
        Intrinsics.checkNotNullParameter(str3, "ocrText");
        this.qw = str;
        this.f8268ad = str2;
        this.f8269de = str3;
    }

    @NotNull
    public final String ad() {
        return this.f8269de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && Intrinsics.areEqual((Object) this.f8268ad, (Object) qwVar.f8268ad) && Intrinsics.areEqual((Object) this.f8269de, (Object) qwVar.f8269de);
    }

    public int hashCode() {
        int hashCode = this.qw.hashCode() * 31;
        String str = this.f8268ad;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f8269de.hashCode();
    }

    @NotNull
    public final String qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "OcrTextData(imagePath=" + this.qw + ", cropPath=" + this.f8268ad + ", ocrText=" + this.f8269de + ')';
    }
}
