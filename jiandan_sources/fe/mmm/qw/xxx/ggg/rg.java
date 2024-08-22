package fe.mmm.qw.xxx.ggg;

import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final String f8579ad;
    @NotNull
    public final String qw;

    public rg(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        this.qw = str;
        this.f8579ad = str2;
    }

    @NotNull
    public final String ad() {
        return this.qw;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rg)) {
            return false;
        }
        rg rgVar = (rg) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) rgVar.qw) && Intrinsics.areEqual((Object) this.f8579ad, (Object) rgVar.f8579ad);
    }

    public int hashCode() {
        int hashCode = this.qw.hashCode() * 31;
        String str = this.f8579ad;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @Nullable
    public final String qw() {
        return this.f8579ad;
    }

    @NotNull
    public String toString() {
        return "TabSelectedData(tag=" + this.qw + ", action=" + this.f8579ad + ')';
    }
}
