package i.qw;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @NotNull
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final Function1<Throwable, Unit> f6077ad;
    @Nullable
    @JvmField
    public final Object qw;

    public a(@Nullable Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        this.qw = obj;
        this.f6077ad = function1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.qw, aVar.qw) && Intrinsics.areEqual((Object) this.f6077ad, (Object) aVar.f6077ad);
    }

    public int hashCode() {
        Object obj = this.qw;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f6077ad.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.qw + ", onCancellation=" + this.f6077ad + ')';
    }
}
