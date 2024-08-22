package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import th.de.yj;

public final class SingleCache<T> extends yj<T> implements SingleObserver<T> {

    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        public static final long serialVersionUID = 7514387411091976596L;
        public final SingleObserver<? super T> downstream;
        public final SingleCache<T> parent;

        public CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.downstream = singleObserver;
            this.parent = singleCache;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.yj(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    public abstract void yj(CacheDisposable<T> cacheDisposable);
}
