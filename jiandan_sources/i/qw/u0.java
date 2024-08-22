package i.qw;

import com.dxmpay.wallet.paysdk.PayUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class u0 extends b implements DisposableHandle, Incomplete {

    /* renamed from: uk  reason: collision with root package name */
    public v0 f6175uk;

    public void dispose() {
        t().d0(this);
    }

    public boolean isActive() {
        return true;
    }

    @Nullable
    public a1 qw() {
        return null;
    }

    @NotNull
    public final v0 t() {
        v0 v0Var = this.f6175uk;
        if (v0Var != null) {
            return v0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException(PayUtils.KEY_JOB);
        throw null;
    }

    @NotNull
    public String toString() {
        return l.qw(this) + '@' + l.ad(this) + "[job@" + l.ad(t()) + ']';
    }

    public final void u(@NotNull v0 v0Var) {
        this.f6175uk = v0Var;
    }
}
