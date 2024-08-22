package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import th.de.qw;

public final class CompletableCache extends qw implements CompletableObserver {

    public final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        public static final long serialVersionUID = 8943152917179642732L;
        public final CompletableObserver downstream;

        public InnerCompletableCache(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.rg(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    public abstract void rg(InnerCompletableCache innerCompletableCache);
}
