package fe.mmm.qw.h.fe;

import android.graphics.BitmapFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapFactory.Options f7845ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f7846de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f7847fe;
    @NotNull
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f7848rg;

    /* renamed from: th  reason: collision with root package name */
    public int f7849th;

    public ad(@NotNull String str, @NotNull BitmapFactory.Options options, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(options, "options");
        this.qw = str;
        this.f7845ad = options;
        this.f7846de = i2;
        this.f7847fe = i3;
        this.f7848rg = i4;
        this.f7849th = i5;
    }

    public final int ad() {
        return this.f7849th;
    }

    public final int de() {
        return this.f7848rg;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) adVar.qw) && Intrinsics.areEqual((Object) this.f7845ad, (Object) adVar.f7845ad) && this.f7846de == adVar.f7846de && this.f7847fe == adVar.f7847fe && this.f7848rg == adVar.f7848rg && this.f7849th == adVar.f7849th;
    }

    public final int fe() {
        return this.f7846de;
    }

    public int hashCode() {
        return (((((((((this.qw.hashCode() * 31) + this.f7845ad.hashCode()) * 31) + this.f7846de) * 31) + this.f7847fe) * 31) + this.f7848rg) * 31) + this.f7849th;
    }

    @NotNull
    public final String qw() {
        return this.qw;
    }

    public final int rg() {
        return this.f7847fe;
    }

    public final void th(int i2) {
        this.f7849th = i2;
    }

    @NotNull
    public String toString() {
        return "ImageInfo(path=" + this.qw + ", options=" + this.f7845ad + ", sourceHeight=" + this.f7846de + ", sourceWidth=" + this.f7847fe + ", scaleWidth=" + this.f7848rg + ", scaleHeight=" + this.f7849th + ')';
    }

    public final void yj(int i2) {
        this.f7848rg = i2;
    }
}
