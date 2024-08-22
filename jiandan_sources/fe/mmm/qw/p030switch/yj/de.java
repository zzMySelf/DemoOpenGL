package fe.mmm.qw.p030switch.yj;

import com.tera.scan.framework.swipeback.SwipeType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.switch.yj.de  reason: invalid package */
public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public int f8327ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public SwipeType f8328de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public qw f8329fe;
    public float qw;

    public de() {
        this(0.0f, 0, (SwipeType) null, (qw) null, 15, (DefaultConstructorMarker) null);
    }

    public de(float f, int i2, @NotNull SwipeType swipeType, @Nullable qw qwVar) {
        Intrinsics.checkNotNullParameter(swipeType, "swipeType");
        this.qw = f;
        this.f8327ad = i2;
        this.f8328de = swipeType;
        this.f8329fe = qwVar;
    }

    public final int ad() {
        return this.f8327ad;
    }

    public final float de() {
        return this.qw;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof de)) {
            return false;
        }
        de deVar = (de) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.qw), (Object) Float.valueOf(deVar.qw)) && this.f8327ad == deVar.f8327ad && this.f8328de == deVar.f8328de && Intrinsics.areEqual((Object) this.f8329fe, (Object) deVar.f8329fe);
    }

    @NotNull
    public final SwipeType fe() {
        return this.f8328de;
    }

    public int hashCode() {
        int floatToIntBits = ((((Float.floatToIntBits(this.qw) * 31) + this.f8327ad) * 31) + this.f8328de.hashCode()) * 31;
        qw qwVar = this.f8329fe;
        return floatToIntBits + (qwVar == null ? 0 : qwVar.hashCode());
    }

    @Nullable
    public final qw qw() {
        return this.f8329fe;
    }

    public final void rg(@Nullable qw qwVar) {
        this.f8329fe = qwVar;
    }

    @NotNull
    public String toString() {
        return "SwipeBackConfig(swipeSensitivity=" + this.qw + ", swipeDuration=" + this.f8327ad + ", swipeType=" + this.f8328de + ", edgeSwipeArea=" + this.f8329fe + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ de(float f, int i2, SwipeType swipeType, qw qwVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.55f : f, (i3 & 2) != 0 ? 400 : i2, (i3 & 4) != 0 ? SwipeType.LEFT_TO_RIGHT : swipeType, (i3 & 8) != 0 ? null : qwVar);
    }
}
