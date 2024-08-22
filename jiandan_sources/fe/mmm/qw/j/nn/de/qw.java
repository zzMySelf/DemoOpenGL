package fe.mmm.qw.j.nn.de;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw extends de {

    /* renamed from: ad  reason: collision with root package name */
    public final int f7977ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final Object f7978de;
    public final int qw;

    public qw(int i2, int i3, @Nullable Object obj) {
        super((DefaultConstructorMarker) null);
        this.qw = i2;
        this.f7977ad = i3;
        this.f7978de = obj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return this.qw == qwVar.qw && this.f7977ad == qwVar.f7977ad && Intrinsics.areEqual(this.f7978de, qwVar.f7978de);
    }

    public int hashCode() {
        int i2 = ((this.qw * 31) + this.f7977ad) * 31;
        Object obj = this.f7978de;
        return i2 + (obj == null ? 0 : obj.hashCode());
    }

    @NotNull
    public String toString() {
        return "Change(position=" + this.qw + ", count=" + this.f7977ad + ", payload=" + this.f7978de + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qw(int i2, int i3, Object obj, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, (i4 & 4) != 0 ? null : obj);
    }
}
