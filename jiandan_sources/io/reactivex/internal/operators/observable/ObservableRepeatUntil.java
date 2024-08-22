package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableRepeatUntil<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final BooleanSupplier f10183th;

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        public static final long serialVersionUID = -7098360935104053232L;
        public final Observer<? super T> downstream;
        public final ObservableSource<? extends T> source;
        public final BooleanSupplier stop;
        public final SequentialDisposable upstream;

        public RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.upstream = sequentialDisposable;
            this.source = observableSource;
            this.stop = booleanSupplier;
        }

        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.downstream.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.downstream.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
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
                do {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    public ObservableRepeatUntil(rg<T> rgVar, BooleanSupplier booleanSupplier) {
        super(rgVar);
        this.f10183th = booleanSupplier;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(observer, this.f10183th, sequentialDisposable, this.f10756ad).subscribeNext();
    }
}
