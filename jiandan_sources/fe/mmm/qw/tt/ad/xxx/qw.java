package fe.mmm.qw.tt.ad.xxx;

import com.google.zxing.Result;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f8467ad;
    @Nullable
    public final Result qw;

    public qw(@Nullable Result result, boolean z) {
        this.qw = result;
        this.f8467ad = z;
    }

    @Nullable
    public final Result ad() {
        return this.qw;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && this.f8467ad == qwVar.f8467ad;
    }

    public int hashCode() {
        Result result = this.qw;
        int hashCode = (result == null ? 0 : result.hashCode()) * 31;
        boolean z = this.f8467ad;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final boolean qw() {
        return this.f8467ad;
    }

    @NotNull
    public String toString() {
        return "DecodeResult(result=" + this.qw + ", fromLocal=" + this.f8467ad + ')';
    }
}
