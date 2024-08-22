package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.rg;

public final class ObservableSequenceEqual<T> extends rg<Boolean> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<? extends T> f10213ad;

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<? extends T> f10214th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10215uk;

    /* renamed from: yj  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f10216yj;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = -6178010334400373240L;
        public volatile boolean cancelled;
        public final BiPredicate<? super T, ? super T> comparer;
        public final Observer<? super Boolean> downstream;
        public final ObservableSource<? extends T> first;
        public final qw<T>[] observers;
        public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        public final ObservableSource<? extends T> second;
        public T v1;
        public T v2;

        public EqualCoordinator(Observer<? super Boolean> observer, int i2, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.downstream = observer;
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
                    qwVarArr[0].f10219th.clear();
                    qwVarArr[1].f10219th.clear();
                }
            }
        }

        public void drain() {
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() == 0) {
                qw<T>[] qwVarArr = this.observers;
                qw<T> qwVar = qwVarArr[0];
                th.de.p039if.rg.qw<T> qwVar2 = qwVar.f10219th;
                qw<T> qwVar3 = qwVarArr[1];
                th.de.p039if.rg.qw<T> qwVar4 = qwVar3.f10219th;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z = qwVar.f10220uk;
                    if (!z || (th3 = qwVar.f10218i) == null) {
                        boolean z2 = qwVar3.f10220uk;
                        if (!z2 || (th2 = qwVar3.f10218i) == null) {
                            if (this.v1 == null) {
                                this.v1 = qwVar2.poll();
                            }
                            boolean z3 = this.v1 == null;
                            if (this.v2 == null) {
                                this.v2 = qwVar4.poll();
                            }
                            boolean z4 = this.v2 == null;
                            if (z && z2 && z3 && z4) {
                                this.downstream.onNext(Boolean.TRUE);
                                this.downstream.onComplete();
                                return;
                            } else if (!z || !z2 || z3 == z4) {
                                if (!z3 && !z4) {
                                    try {
                                        if (!this.comparer.qw(this.v1, this.v2)) {
                                            cancel(qwVar2, qwVar4);
                                            this.downstream.onNext(Boolean.FALSE);
                                            this.downstream.onComplete();
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
                                this.downstream.onNext(Boolean.FALSE);
                                this.downstream.onComplete();
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
        public final EqualCoordinator<T> f10217ad;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f10218i;

        /* renamed from: th  reason: collision with root package name */
        public final th.de.p039if.rg.qw<T> f10219th;

        /* renamed from: uk  reason: collision with root package name */
        public volatile boolean f10220uk;

        /* renamed from: yj  reason: collision with root package name */
        public final int f10221yj;

        public qw(EqualCoordinator<T> equalCoordinator, int i2, int i3) {
            this.f10217ad = equalCoordinator;
            this.f10221yj = i2;
            this.f10219th = new th.de.p039if.rg.qw<>(i3);
        }

        public void onComplete() {
            this.f10220uk = true;
            this.f10217ad.drain();
        }

        public void onError(Throwable th2) {
            this.f10218i = th2;
            this.f10220uk = true;
            this.f10217ad.drain();
        }

        public void onNext(T t) {
            this.f10219th.offer(t);
            this.f10217ad.drain();
        }

        public void onSubscribe(Disposable disposable) {
            this.f10217ad.setDisposable(disposable, this.f10221yj);
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.f10213ad = observableSource;
        this.f10214th = observableSource2;
        this.f10216yj = biPredicate;
        this.f10215uk = i2;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f10215uk, this.f10213ad, this.f10214th, this.f10216yj);
        observer.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }
}
