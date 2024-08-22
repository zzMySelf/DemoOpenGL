package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;

public final class ObservableAmb<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f10040ad;

    /* renamed from: th  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f10041th;

    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        public static final long serialVersionUID = -1185974347409665484L;
        public final Observer<? super T> downstream;
        public final int index;
        public final qw<T> parent;
        public boolean won;

        public AmbInnerObserver(qw<T> qwVar, int i2, Observer<? super T> observer) {
            this.parent = qwVar;
            this.index = i2;
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.ad(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.won) {
                this.downstream.onError(th2);
            } else if (this.parent.ad(this.index)) {
                this.won = true;
                this.downstream.onError(th2);
            } else {
                th.de.ppp.qw.ddd(th2);
            }
        }

        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (this.parent.ad(this.index)) {
                this.won = true;
                this.downstream.onNext(t);
            } else {
                ((Disposable) get()).dispose();
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class qw<T> implements Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10042ad;

        /* renamed from: th  reason: collision with root package name */
        public final AmbInnerObserver<T>[] f10043th;

        /* renamed from: yj  reason: collision with root package name */
        public final AtomicInteger f10044yj = new AtomicInteger();

        public qw(Observer<? super T> observer, int i2) {
            this.f10042ad = observer;
            this.f10043th = new AmbInnerObserver[i2];
        }

        public boolean ad(int i2) {
            int i3 = this.f10044yj.get();
            int i4 = 0;
            if (i3 == 0) {
                if (!this.f10044yj.compareAndSet(0, i2)) {
                    return false;
                }
                AmbInnerObserver<T>[] ambInnerObserverArr = this.f10043th;
                int length = ambInnerObserverArr.length;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    if (i5 != i2) {
                        ambInnerObserverArr[i4].dispose();
                    }
                    i4 = i5;
                }
                return true;
            } else if (i3 == i2) {
                return true;
            } else {
                return false;
            }
        }

        public void dispose() {
            if (this.f10044yj.get() != -1) {
                this.f10044yj.lazySet(-1);
                for (AmbInnerObserver<T> dispose : this.f10043th) {
                    dispose.dispose();
                }
            }
        }

        public boolean isDisposed() {
            return this.f10044yj.get() == -1;
        }

        public void qw(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f10043th;
            int length = ambInnerObserverArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                ambInnerObserverArr[i2] = new AmbInnerObserver<>(this, i3, this.f10042ad);
                i2 = i3;
            }
            this.f10044yj.lazySet(0);
            this.f10042ad.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f10044yj.get() == 0; i4++) {
                observableSourceArr[i4].subscribe(ambInnerObserverArr[i4]);
            }
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.f10040ad = observableSourceArr;
        this.f10041th = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        int i2;
        ObservableSource<? extends T>[] observableSourceArr = this.f10040ad;
        if (observableSourceArr == null) {
            observableSourceArr = new rg[8];
            try {
                i2 = 0;
                for (ObservableSource<? extends T> observableSource : this.f10041th) {
                    if (observableSource == null) {
                        EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (Observer<?>) observer);
                        return;
                    }
                    if (i2 == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i2 >> 2) + i2)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i2);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i3 = i2 + 1;
                    observableSourceArr[i2] = observableSource;
                    i2 = i3;
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
                return;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
        } else if (i2 == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new qw(observer, i2).qw(observableSourceArr);
        }
    }
}
