package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import java.util.concurrent.atomic.AtomicReference;
import th.de.o.qw;

public final class CancellableDisposable extends AtomicReference<Cancellable> implements Disposable {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(Cancellable cancellable) {
        super(cancellable);
    }

    public void dispose() {
        Cancellable cancellable;
        if (get() != null && (cancellable = (Cancellable) getAndSet((Object) null)) != null) {
            try {
                cancellable.cancel();
            } catch (Exception e) {
                qw.ad(e);
                th.de.ppp.qw.ddd(e);
            }
        }
    }

    public boolean isDisposed() {
        return get() == null;
    }
}
