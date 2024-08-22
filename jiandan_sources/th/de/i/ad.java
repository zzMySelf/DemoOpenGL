package th.de.i;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import th.de.p039if.ad.qw;

public final class ad {
    public static Disposable ad(Runnable runnable) {
        qw.rg(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static Disposable qw() {
        return EmptyDisposable.INSTANCE;
    }
}
