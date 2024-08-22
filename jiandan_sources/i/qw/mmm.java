package i.qw;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class mmm extends p0 implements ChildHandle {
    @NotNull
    @JvmField

    /* renamed from: i  reason: collision with root package name */
    public final ChildJob f6149i;

    public mmm(@NotNull ChildJob childJob) {
        this.f6149i = childJob;
    }

    public boolean fe(@NotNull Throwable th2) {
        return t().w(th2);
    }

    @NotNull
    public Job getParent() {
        return t();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void s(@Nullable Throwable th2) {
        this.f6149i.yj(t());
    }
}
