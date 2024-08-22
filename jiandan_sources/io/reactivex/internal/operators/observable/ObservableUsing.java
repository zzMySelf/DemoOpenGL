package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import th.de.o.qw;
import th.de.rg;

public final class ObservableUsing<T, D> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Callable<? extends D> f10274ad;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super D, ? extends ObservableSource<? extends T>> f10275th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f10276uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Consumer<? super D> f10277yj;

    public static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        public static final long serialVersionUID = 5904473792286235046L;
        public final Consumer<? super D> disposer;
        public final Observer<? super T> downstream;
        public final boolean eager;
        public final D resource;
        public Disposable upstream;

        public UsingObserver(Observer<? super T> observer, D d, Consumer<? super D> consumer, boolean z) {
            this.downstream = observer;
            this.resource = d;
            this.disposer = consumer;
            this.eager = z;
        }

        public void dispose() {
            disposeAfter();
            this.upstream.dispose();
        }

        public void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    qw.ad(th2);
                    th.de.ppp.qw.ddd(th2);
                }
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th2) {
                        qw.ad(th2);
                        this.downstream.onError(th2);
                        return;
                    }
                }
                this.upstream.dispose();
                this.downstream.onComplete();
                return;
            }
            this.downstream.onComplete();
            this.upstream.dispose();
            disposeAfter();
        }

        public void onError(Throwable th2) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th3) {
                        qw.ad(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                }
                this.upstream.dispose();
                this.downstream.onError(th2);
                return;
            }
            this.downstream.onError(th2);
            this.upstream.dispose();
            disposeAfter();
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f10274ad = callable;
        this.f10275th = function;
        this.f10277yj = consumer;
        this.f10276uk = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f10274ad.call();
            try {
                Object apply = this.f10275th.apply(call);
                th.de.p039if.ad.qw.rg(apply, "The sourceSupplier returned a null ObservableSource");
                ((ObservableSource) apply).subscribe(new UsingObserver(observer, call, this.f10277yj, this.f10276uk));
            } catch (Throwable th2) {
                qw.ad(th2);
                EmptyDisposable.error((Throwable) new CompositeException(th, th2), (Observer<?>) observer);
            }
        } catch (Throwable th3) {
            qw.ad(th3);
            EmptyDisposable.error(th3, (Observer<?>) observer);
        }
    }
}
