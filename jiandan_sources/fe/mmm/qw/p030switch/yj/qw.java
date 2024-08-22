package fe.mmm.qw.p030switch.yj;

import android.graphics.RectF;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.switch.yj.qw  reason: invalid package */
public final class qw {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public RectF f8331ad;
    @Nullable
    public RectF qw;

    public qw() {
        this((RectF) null, (RectF) null, 3, (DefaultConstructorMarker) null);
    }

    public qw(@Nullable RectF rectF, @Nullable RectF rectF2) {
        this.qw = rectF;
        this.f8331ad = rectF2;
    }

    @Nullable
    public final RectF ad() {
        return this.f8331ad;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && Intrinsics.areEqual((Object) this.f8331ad, (Object) qwVar.f8331ad);
    }

    public int hashCode() {
        RectF rectF = this.qw;
        int i2 = 0;
        int hashCode = (rectF == null ? 0 : rectF.hashCode()) * 31;
        RectF rectF2 = this.f8331ad;
        if (rectF2 != null) {
            i2 = rectF2.hashCode();
        }
        return hashCode + i2;
    }

    @Nullable
    public final RectF qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "EdgeSwipeArea(horizontalSwipeArea=" + this.qw + ", verticalSwipeArea=" + this.f8331ad + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qw(RectF rectF, RectF rectF2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : rectF, (i2 & 2) != 0 ? null : rectF2);
    }
}
