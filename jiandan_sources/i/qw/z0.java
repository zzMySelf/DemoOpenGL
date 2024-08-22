package i.qw;

import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class z0 extends CoroutineDispatcher {
    @Nullable
    public final String mmm() {
        z0 z0Var;
        u uVar = u.qw;
        z0 de2 = u.de();
        if (this == de2) {
            return "Dispatchers.Main";
        }
        try {
            z0Var = de2.xxx();
        } catch (UnsupportedOperationException unused) {
            z0Var = null;
        }
        if (this == z0Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @NotNull
    public String toString() {
        String mmm = mmm();
        if (mmm != null) {
            return mmm;
        }
        return l.qw(this) + '@' + l.ad(this);
    }

    @NotNull
    public abstract z0 xxx();
}
