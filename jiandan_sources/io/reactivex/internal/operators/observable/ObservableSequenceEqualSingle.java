package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.rg;
import th.de.yj;

public final class ObservableSequenceEqualSingle<T> extends yj<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<? extends T> f10222ad;

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<? extends T> f10223th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10224uk;

    /* renamed from: yj  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f10225yj;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = -6178010334400373240L;
        public volatile boolean cancelled;
        public final BiPredicate<? super T, ? super T> comparer;
        public final SingleObserver<? super Boolean> downstream;
        public final ObservableSource<? extends T> first;
        public final qw<T>[] observers;
        public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        public final ObservableSource<? extends T> second;
        public T v1;
        public T v2;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i2, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.downstream = singleObserver;
            this.first = observableSource;
            this.second = observableSource2;
            this.comparer = biPredicate;
            qw<T>[] qwVarArr = new qw[2];
            this.observers = qwVarArr;
            qwVarArr[0] = new qw<>(this, 0, i2);
            qwVarArr[1] = new qw<>(this, 1, i2);
        }

        public void cancel(th.de.p039if.rg.qw<T> qwVar, th.de.p039if.rg.qw<T> qwVar2) {
            this.cancelled = true;
            qwVar.clear();
            qwVar2.clear();
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.resources.dispose();
                if (getAndIncrement() == 0) {
                    qw<T>[] qwVarArr = this.observers;
                    qwVarArr[0].f10228th.clear();
                    qwVarArr[1].f10228th.clear();
                }
            }
        }

        public void drain() {
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() == 0) {
                qw<T>[] qwVarArr = this.observers;
                qw<T> qwVar = qwVarArr[0];
                th.de.p039if.rg.qw<T> qwVar2 = qwVar.f10228th;
                qw<T> qwVar3 = qwVarArr[1];
                th.de.p039if.rg.qw<T> qwVar4 = qwVar3.f10228th;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z = qwVar.f10229uk;
                    if (!z || (th3 = qwVar.f10227i) == null) {
                        boolean z2 = qwVar3.f10229uk;
                        if (!z2 || (th2 = qwVar3.f10227i) == null) {
                            if (this.v1 == null) {
                                this.v1 = qwVar2.poll();
                            }
                            boolean z3 = this.v1 == null;
                            if (this.v2 == null) {
                                this.v2 = qwVar4.poll();
                            }
                            boolean z4 = this.v2 == null;
                            if (z && z2 && z3 && z4) {
                                this.downstream.onSuccess(Boolean.TRUE);
                                return;
                            } else if (!z || !z2 || z3 == z4) {
                                if (!z3 && !z4) {
                                    try {
                                        if (!this.comparer.qw(this.v1, this.v2)) {
                                            cancel(qwVar2, qwVar4);
                                            this.downstream.onSuccess(Boolean.FALSE);
                                            return;
                                        }
                                        this.v1 = null;
                                        this.v2 = null;
                                    } catch (Throwable th4) {
                                        th.de.o.qw.ad(th4);
                                        cancel(qwVar2, qwVar4);
                                        this.downstream.onError(th4);
                                        return;
                                    }
                                }
                                if ((z3 || z4) && (i2 = addAndGet(-i2)) == 0) {
                                    return;
                                }
                            } else {
                                cancel(qwVar2, qwVar4);
                                this.downstream.onSuccess(Boolean.FALSE);
                                return;
                            }
                        } else {
                            cancel(qwVar2, qwVar4);
                            this.downstream.onError(th2);
                            return;
                        }
                    } else {
                        cancel(qwVar2, qwVar4);
                        this.downstream.onError(th3);
                        return;
                    }
                }
                qwVar2.clear();
                qwVar4.clear();
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public boolean setDisposable(Disposable disposable, int i2) {
            return this.resources.setResource(i2, disposable);
        }

        public void subscribe() {
            qw<T>[] qwVarArr = this.observers;
            this.first.subscribe(qwVarArr[0]);
            this.second.subscribe(qwVarArr[1]);
        }
    }

    public static final class qw<T> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final EqualCoordinator<T> f10226ad;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f10227i;

        /* renamed from: th  reason: collision with root package name */
        public final th.de.p039if.rg.qw<T> f10228th;

        /* renamed from: uk  reason: collision with root package name */
        public volatile boolean f10229uk;

        /* renamed from: yj  reason: collision with root package name */
        public final int f10230yj;

        public qw(EqualCoordinator<T> equalCoordinator, int i2, int i3) {
            this.f10226ad = equalCoordinator;
            this.f10230yj = i2;
            this.f10228th = new th.de.p039if.rg.qw<>(i3);
        }

        public void onComplete() {
            this.f10229uk = true;
            this.f10226ad.drain();
        }

        public void onError(Throwable th2) {
            this.f10227i = th2;
            this.f10229uk = true;
            this.f10226ad.drain();
        }

        public void onNext(T t) {
            this.f10228th.offer(t);
            this.f10226ad.drain();
        }

        public void onSubscribe(Disposable disposable) {
            this.f10226ad.setDisposable(disposable, this.f10230yj);
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.f10222ad = observableSource;
        this.f10223th = observableSource2;
        this.f10225yj = biPredicate;
        this.f10224uk = i2;
    }

    public rg<Boolean> ad() {
        return th.de.ppp.qw.when(new ObservableSequenceEqual(this.f10222ad, this.f10223th, this.f10225yj, this.f10224uk));
    }

    public void rg(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f10224uk, this.f10222ad, this.f10223th, this.f10225yj);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }
}
