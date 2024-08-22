package i.qw;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class n0 extends p0 {

    /* renamed from: o  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6150o = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_invoked");
    @NotNull
    public volatile /* synthetic */ int _invoked = 0;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Function1<Throwable, Unit> f6151i;

    public n0(@NotNull Function1<? super Throwable, Unit> function1) {
        this.f6151i = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void s(@Nullable Throwable th2) {
        if (f6150o.compareAndSet(this, 0, 1)) {
            this.f6151i.invoke(th2);
        }
    }
}
