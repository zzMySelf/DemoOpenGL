package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import th.de.p039if.fe.rg.y;
import th.de.p039if.yj.rg;

public final class ObservableWithLatestFromMany<T, R> extends th.de.p039if.fe.rg.qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<?>[] f10292th;

    /* renamed from: uk  reason: collision with root package name */
    public final Function<? super Object[], R> f10293uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<?>> f10294yj;

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = 1577321883966341961L;
        public final Function<? super Object[], R> combiner;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final AtomicThrowable error;
        public final WithLatestInnerObserver[] observers;
        public final AtomicReference<Disposable> upstream;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i2) {
            this.downstream = observer;
            this.combiner = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                withLatestInnerObserverArr[i3] = new WithLatestInnerObserver(this, i3);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.upstream = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        public void cancelAllBut(int i2) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i3 = 0; i3 < withLatestInnerObserverArr.length; i3++) {
                if (i3 != i2) {
                    withLatestInnerObserverArr[i3].dispose();
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            for (WithLatestInnerObserver dispose : this.observers) {
                dispose.dispose();
            }
        }

        public void innerComplete(int i2, boolean z) {
            if (!z) {
                this.done = true;
                cancelAllBut(i2);
                rg.qw(this.downstream, this, this.error);
            }
        }

        public void innerError(int i2, Throwable th2) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            cancelAllBut(i2);
            rg.de(this.downstream, th2, this, this.error);
        }

        public void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                rg.qw(this.downstream, this, this.error);
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            rg.de(this.downstream, th2, this, this.error);
        }

        public void onNext(T t) {
            if (!this.done) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.values;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[(length + 1)];
                int i2 = 0;
                objArr[0] = t;
                while (i2 < length) {
                    Object obj = atomicReferenceArray.get(i2);
                    if (obj != null) {
                        i2++;
                        objArr[i2] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    R apply = this.combiner.apply(objArr);
                    th.de.p039if.ad.qw.rg(apply, "combiner returned a null value");
                    rg.rg(this.downstream, apply, this, this.error);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void subscribe(ObservableSource<?>[] observableSourceArr, int i2) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<Disposable> atomicReference = this.upstream;
            for (int i3 = 0; i3 < i2 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i3++) {
                observableSourceArr[i3].subscribe(withLatestInnerObserverArr[i3]);
            }
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        public static final long serialVersionUID = 3256684027868224024L;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromObserver<?, ?> parent;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i2) {
            this.parent = withLatestFromObserver;
            this.index = i2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(this.index, th2);
        }

        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public final class qw implements Function<T, R> {
        public qw() {
        }

        public R apply(T t) throws Exception {
            R apply = ObservableWithLatestFromMany.this.f10293uk.apply(new Object[]{t});
            th.de.p039if.ad.qw.rg(apply, "The combiner returned a null value");
            return apply;
        }
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        super(observableSource);
        this.f10292th = observableSourceArr;
        this.f10294yj = null;
        this.f10293uk = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i2;
        ObservableSource<?>[] observableSourceArr = this.f10292th;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i2 = 0;
                for (ObservableSource<?> observableSource : this.f10294yj) {
                    if (i2 == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (i2 >> 1) + i2);
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
            new y(this.f10756ad, new qw()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.f10293uk, i2);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.subscribe(observableSourceArr, i2);
        this.f10756ad.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        super(observableSource);
        this.f10292th = null;
        this.f10294yj = iterable;
        this.f10293uk = function;
    }
}
