package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableRetryBiPredicate<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final BiPredicate<? super Integer, ? super Throwable> f10200th;

    public static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        public static final long serialVersionUID = -7098360935104053232L;
        public final Observer<? super T> downstream;
        public final BiPredicate<? super Integer, ? super Throwable> predicate;
        public int retries;
        public final ObservableSource<? extends T> source;
        public final SequentialDisposable upstream;

        public RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.upstream = sequentialDisposable;
            this.source = observableSource;
            this.predicate = biPredicate;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.predicate;
                int i2 = this.retries + 1;
                this.retries = i2;
                if (!biPredicate.qw(Integer.valueOf(i2), th2)) {
                    this.downstream.onError(th2);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.upstream.replace(disposable);
        }

        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryBiPredicate(rg<T> rgVar, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(rgVar);
        this.f10200th = biPredicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RetryBiObserver(observer, this.f10200th, sequentialDisposable, this.f10756ad).subscribeNext();
    }
}
