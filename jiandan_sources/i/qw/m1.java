package i.qw;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class m1 implements Function1<Throwable, Unit> {

    /* renamed from: uk  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6145uk = AtomicIntegerFieldUpdater.newUpdater(m1.class, "_state");
    @NotNull
    public volatile /* synthetic */ int _state = 0;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Job f6146ad;

    /* renamed from: th  reason: collision with root package name */
    public final Thread f6147th = Thread.currentThread();
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public DisposableHandle f6148yj;

    public m1(@NotNull Job job) {
        this.f6146ad = job;
    }

    public final Void ad(int i2) {
        throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", Integer.valueOf(i2)).toString());
    }

    public void de(@Nullable Throwable th2) {
        int i2;
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2 && i2 != 3) {
                    ad(i2);
                    throw null;
                }
                return;
            }
        } while (!f6145uk.compareAndSet(this, i2, 2));
        this.f6147th.interrupt();
        this._state = 3;
    }

    public final void fe() {
        int i2;
        this.f6148yj = this.f6146ad.fe(true, true, this);
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 != 2 && i2 != 3) {
                    ad(i2);
                    throw null;
                }
                return;
            }
        } while (!f6145uk.compareAndSet(this, i2, 0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        de((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void qw() {
        while (true) {
            int i2 = this._state;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        ad(i2);
                        throw null;
                    }
                }
            } else if (f6145uk.compareAndSet(this, i2, 1)) {
                DisposableHandle disposableHandle = this.f6148yj;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }
}
