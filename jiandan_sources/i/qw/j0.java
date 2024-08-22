package i.qw;

import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;

public final class j0 implements Incomplete {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final a1 f6137ad;

    public j0(@NotNull a1 a1Var) {
        this.f6137ad = a1Var;
    }

    public boolean isActive() {
        return false;
    }

    @NotNull
    public a1 qw() {
        return this.f6137ad;
    }

    @NotNull
    public String toString() {
        return k.de() ? qw().t("New") : super.toString();
    }
}
