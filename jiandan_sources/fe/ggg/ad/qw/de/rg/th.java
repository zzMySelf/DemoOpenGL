package fe.ggg.ad.qw.de.rg;

import android.database.Cursor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class th<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final int f7582ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final T f7583de;
    @NotNull
    public final Cursor qw;

    @Nullable
    public final T ad() {
        return this.f7583de;
    }

    public final int de() {
        return this.f7582ad;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof th)) {
            return false;
        }
        th thVar = (th) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) thVar.qw) && this.f7582ad == thVar.f7582ad && Intrinsics.areEqual((Object) this.f7583de, (Object) thVar.f7583de);
    }

    public int hashCode() {
        int hashCode = ((this.qw.hashCode() * 31) + this.f7582ad) * 31;
        T t = this.f7583de;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    @NotNull
    public final Cursor qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "LoadResult(cursor=" + this.qw + ", parseResultState=" + this.f7582ad + ", parseResult=" + this.f7583de + ')';
    }
}
