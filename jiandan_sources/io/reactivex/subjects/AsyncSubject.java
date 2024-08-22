package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import th.de.ppp.qw;
import th.de.xxx.ad;

public final class AsyncSubject<T> extends ad<T> {

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        public static final long serialVersionUID = 5629876084736248016L;
        public final AsyncSubject<T> parent;

        public AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.parent = asyncSubject;
        }

        public void dispose() {
            if (super.tryDispose()) {
                this.parent.fe(this);
            }
        }

        public void onComplete() {
            if (!isDisposed()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isDisposed()) {
                qw.ddd(th2);
            } else {
                this.downstream.onError(th2);
            }
        }
    }

    public abstract void fe(AsyncDisposable<T> asyncDisposable);
}
