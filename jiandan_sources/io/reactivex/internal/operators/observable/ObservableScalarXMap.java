package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.rg;

public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        public static final int FUSED = 1;
        public static final int ON_COMPLETE = 3;
        public static final int ON_NEXT = 2;
        public static final int START = 0;
        public static final long serialVersionUID = 3880992722410194083L;
        public final Observer<? super T> observer;
        public final T value;

        public ScalarDisposable(Observer<? super T> observer2, T t) {
            this.observer = observer2;
            this.value = t;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        public boolean isDisposed() {
            return get() == 3;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public static final class qw<T, R> extends rg<R> {

        /* renamed from: ad  reason: collision with root package name */
        public final T f10211ad;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f10212th;

        public qw(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f10211ad = t;
            this.f10212th = function;
        }

        public void subscribeActual(Observer<? super R> observer) {
            try {
                Object apply = this.f10212th.apply(this.f10211ad);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.complete((Observer<?>) observer);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        EmptyDisposable.error(th2, (Observer<?>) observer);
                    }
                } else {
                    observableSource.subscribe(observer);
                }
            } catch (Throwable th3) {
                EmptyDisposable.error(th3, (Observer<?>) observer);
            }
        }
    }

    public static <T, R> boolean ad(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (!(observableSource instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) observableSource).call();
            if (call == null) {
                EmptyDisposable.complete((Observer<?>) observer);
                return true;
            }
            try {
                Object apply = function.apply(call);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null ObservableSource");
                ObservableSource observableSource2 = (ObservableSource) apply;
                if (observableSource2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) observableSource2).call();
                        if (call2 == null) {
                            EmptyDisposable.complete((Observer<?>) observer);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call2);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        EmptyDisposable.error(th2, (Observer<?>) observer);
                        return true;
                    }
                } else {
                    observableSource2.subscribe(observer);
                }
                return true;
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                EmptyDisposable.error(th3, (Observer<?>) observer);
                return true;
            }
        } catch (Throwable th4) {
            th.de.o.qw.ad(th4);
            EmptyDisposable.error(th4, (Observer<?>) observer);
            return true;
        }
    }

    public static <T, U> rg<U> qw(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return th.de.ppp.qw.when(new qw(t, function));
    }
}
