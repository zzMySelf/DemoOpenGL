package fe.mmm.qw.p030switch.yj;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.switch.yj.ad  reason: invalid package */
public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final float f8325ad;

    /* renamed from: de  reason: collision with root package name */
    public final float f8326de;
    @NotNull
    public final ViewGroup qw;

    public ad(@NotNull ViewGroup viewGroup, float f, float f2) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        this.qw = viewGroup;
        this.f8325ad = f;
        this.f8326de = f2;
    }

    public final float ad() {
        return this.f8325ad;
    }

    public final float de() {
        return this.f8326de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) adVar.qw) && Intrinsics.areEqual((Object) Float.valueOf(this.f8325ad), (Object) Float.valueOf(adVar.f8325ad)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8326de), (Object) Float.valueOf(adVar.f8326de));
    }

    public int hashCode() {
        return (((this.qw.hashCode() * 31) + Float.floatToIntBits(this.f8325ad)) * 31) + Float.floatToIntBits(this.f8326de);
    }

    @NotNull
    public final ViewGroup qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "PointViewInfo(view=" + this.qw + ", x=" + this.f8325ad + ", y=" + this.f8326de + ')';
    }
}
