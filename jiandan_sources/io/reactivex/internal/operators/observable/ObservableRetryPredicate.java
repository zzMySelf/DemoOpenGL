package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableRetryPredicate<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super Throwable> f10201th;

    /* renamed from: yj  reason: collision with root package name */
    public final long f10202yj;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        public static final long serialVersionUID = -7098360935104053232L;
        public final Observer<? super T> downstream;
        public final Predicate<? super Throwable> predicate;
        public long remaining;
        public final ObservableSource<? extends T> source;
        public final SequentialDisposable upstream;

        public RepeatObserver(Observer<? super T> observer, long j, Predicate<? super Throwable> predicate2, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.upstream = sequentialDisposable;
            this.source = observableSource;
            this.predicate = predicate2;
            this.remaining = j;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.downstream.onError(th2);
                return;
            }
            try {
                if (!this.predicate.test(th2)) {
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

    public ObservableRetryPredicate(rg<T> rgVar, long j, Predicate<? super Throwable> predicate) {
        super(rgVar);
        this.f10201th = predicate;
        this.f10202yj = j;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.f10202yj, this.f10201th, sequentialDisposable, this.f10756ad).subscribeNext();
    }
}
