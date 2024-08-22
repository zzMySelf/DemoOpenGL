package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;

public final class ObservableZip<T, R> extends rg<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f10296ad;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10297i;

    /* renamed from: th  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f10298th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10299uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f10300yj;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = 2983708048395377667L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public final Observer<? super R> downstream;
        public final qw<T, R>[] observers;
        public final T[] row;
        public final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i2, boolean z) {
            this.downstream = observer;
            this.zipper = function;
            this.observers = new qw[i2];
            this.row = new Object[i2];
            this.delayError = z;
        }

        public void cancel() {
            clear();
            cancelSources();
        }

        public void cancelSources() {
            for (qw<T, R> qw : this.observers) {
                qw.qw();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Observer<? super R> observer, boolean z3, qw<?, ?> qwVar) {
            if (this.cancelled) {
                cancel();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th2 = qwVar.f10304uk;
                    if (th2 != null) {
                        cancel();
                        observer.onError(th2);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        cancel();
                        observer.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th3 = qwVar.f10304uk;
                    cancel();
                    if (th3 != null) {
                        observer.onError(th3);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        public void clear() {
            for (qw<T, R> qwVar : this.observers) {
                qwVar.f10303th.clear();
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear();
                }
            }
        }

        public void drain() {
            Throwable th2;
            if (getAndIncrement() == 0) {
                qw<T, R>[] qwVarArr = this.observers;
                Observer<? super R> observer = this.downstream;
                T[] tArr = this.row;
                boolean z = this.delayError;
                int i2 = 1;
                while (true) {
                    int i3 = 0;
                    int i4 = 0;
                    for (qw<T, R> qwVar : qwVarArr) {
                        if (tArr[i4] == null) {
                            boolean z2 = qwVar.f10305yj;
                            T poll = qwVar.f10303th.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, observer, z, qwVar)) {
                                if (!z3) {
                                    tArr[i4] = poll;
                                } else {
                                    i3++;
                                }
                            } else {
                                return;
                            }
                        } else if (qwVar.f10305yj && !z && (th2 = qwVar.f10304uk) != null) {
                            cancel();
                            observer.onError(th2);
                            return;
                        }
                        i4++;
                    }
                    if (i3 != 0) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        try {
                            Object apply = this.zipper.apply(tArr.clone());
                            th.de.p039if.ad.qw.rg(apply, "The zipper returned a null value");
                            observer.onNext(apply);
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th3) {
                            th.de.o.qw.ad(th3);
                            cancel();
                            observer.onError(th3);
                            return;
                        }
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i2) {
            qw<T, R>[] qwVarArr = this.observers;
            int length = qwVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                qwVarArr[i3] = new qw<>(this, i2);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i4 = 0; i4 < length && !this.cancelled; i4++) {
                observableSourceArr[i4].subscribe(qwVarArr[i4]);
            }
        }
    }

    public static final class qw<T, R> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final ZipCoordinator<T, R> f10301ad;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicReference<Disposable> f10302i = new AtomicReference<>();

        /* renamed from: th  reason: collision with root package name */
        public final th.de.p039if.rg.qw<T> f10303th;

        /* renamed from: uk  reason: collision with root package name */
        public Throwable f10304uk;

        /* renamed from: yj  reason: collision with root package name */
        public volatile boolean f10305yj;

        public qw(ZipCoordinator<T, R> zipCoordinator, int i2) {
            this.f10301ad = zipCoordinator;
            this.f10303th = new th.de.p039if.rg.qw<>(i2);
        }

        public void onComplete() {
            this.f10305yj = true;
            this.f10301ad.drain();
        }

        public void onError(Throwable th2) {
            this.f10304uk = th2;
            this.f10305yj = true;
            this.f10301ad.drain();
        }

        public void onNext(T t) {
            this.f10303th.offer(t);
            this.f10301ad.drain();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f10302i, disposable);
        }

        public void qw() {
            DisposableHelper.dispose(this.f10302i);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z) {
        this.f10296ad = observableSourceArr;
        this.f10298th = iterable;
        this.f10300yj = function;
        this.f10299uk = i2;
        this.f10297i = z;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i2;
        ObservableSource<? extends T>[] observableSourceArr = this.f10296ad;
        if (observableSourceArr == null) {
            observableSourceArr = new rg[8];
            i2 = 0;
            for (ObservableSource<? extends T> observableSource : this.f10298th) {
                if (i2 == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i2 >> 2) + i2)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i2);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i2] = observableSource;
                i2++;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
        } else {
            new ZipCoordinator(observer, this.f10300yj, i2, this.f10297i).subscribe(observableSourceArr, this.f10299uk);
        }
    }
}
