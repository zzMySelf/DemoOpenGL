package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import th.de.p039if.fe.rg.qw;

public final class ObservableTakeLast<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final int f10243th;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        public static final long serialVersionUID = 7240042530241604978L;
        public volatile boolean cancelled;
        public final int count;
        public final Observer<? super T> downstream;
        public Disposable upstream;

        public TakeLastObserver(Observer<? super T> observer, int i2) {
            this.downstream = observer;
            this.count = i2;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onComplete() {
            Observer<? super T> observer = this.downstream;
            while (!this.cancelled) {
                Object poll = poll();
                if (poll != null) {
                    observer.onNext(poll);
                } else if (!this.cancelled) {
                    observer.onComplete();
                    return;
                } else {
                    return;
                }
            }
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            if (this.count == size()) {
                poll();
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

    public ObservableTakeLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.f10243th = i2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new TakeLastObserver(observer, this.f10243th));
    }
}
