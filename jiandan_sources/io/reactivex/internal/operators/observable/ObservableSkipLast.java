package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import th.de.p039if.fe.rg.qw;

public final class ObservableSkipLast<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final int f10231th;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        public static final long serialVersionUID = -3807491841935125653L;
        public final Observer<? super T> downstream;
        public final int skip;
        public Disposable upstream;

        public SkipLastObserver(Observer<? super T> observer, int i2) {
            super(i2);
            this.downstream = observer;
            this.skip = i2;
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            }
            offer(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.f10231th = i2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new SkipLastObserver(observer, this.f10231th));
    }
}
