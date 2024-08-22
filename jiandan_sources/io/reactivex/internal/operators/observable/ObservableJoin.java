package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends qw<TLeft, R> {

    /* renamed from: i  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> f10149i;

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<? extends TRight> f10150th;

    /* renamed from: uk  reason: collision with root package name */
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f10151uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f10152yj;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.qw {
        public static final Integer LEFT_CLOSE = 3;
        public static final Integer LEFT_VALUE = 1;
        public static final Integer RIGHT_CLOSE = 4;
        public static final Integer RIGHT_VALUE = 2;
        public static final long serialVersionUID = -6071216598687999801L;
        public final AtomicInteger active;
        public volatile boolean cancelled;
        public final th.de.i.qw disposables = new th.de.i.qw();
        public final Observer<? super R> downstream;
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final Map<Integer, TLeft> lefts = new LinkedHashMap();
        public final th.de.p039if.rg.qw<Object> queue = new th.de.p039if.rg.qw<>(rg.bufferSize());
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        public int rightIndex;
        public final Map<Integer, TRight> rights = new LinkedHashMap();

        public JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.downstream = observer;
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
            this.active = new AtomicInteger(2);
        }

        public void cancelAll() {
            this.disposables.dispose();
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                th.de.p039if.rg.qw<Object> qwVar = this.queue;
                Observer<? super R> observer = this.downstream;
                int i2 = 1;
                while (!this.cancelled) {
                    if (this.error.get() != null) {
                        qwVar.clear();
                        cancelAll();
                        errorAll(observer);
                        return;
                    }
                    boolean z = this.active.get() == 0;
                    Integer num = (Integer) qwVar.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        observer.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = qwVar.poll();
                        if (num == LEFT_VALUE) {
                            int i3 = this.leftIndex;
                            this.leftIndex = i3 + 1;
                            this.lefts.put(Integer.valueOf(i3), poll);
                            try {
                                Object apply = this.leftEnd.apply(poll);
                                th.de.p039if.ad.qw.rg(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i3);
                                this.disposables.ad(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.error.get() != null) {
                                    qwVar.clear();
                                    cancelAll();
                                    errorAll(observer);
                                    return;
                                }
                                for (TRight apply2 : this.rights.values()) {
                                    try {
                                        Object apply3 = this.resultSelector.apply(poll, apply2);
                                        th.de.p039if.ad.qw.rg(apply3, "The resultSelector returned a null value");
                                        observer.onNext(apply3);
                                    } catch (Throwable th2) {
                                        fail(th2, observer, qwVar);
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                fail(th3, observer, qwVar);
                                return;
                            }
                        } else if (num == RIGHT_VALUE) {
                            int i4 = this.rightIndex;
                            this.rightIndex = i4 + 1;
                            this.rights.put(Integer.valueOf(i4), poll);
                            try {
                                Object apply4 = this.rightEnd.apply(poll);
                                th.de.p039if.ad.qw.rg(apply4, "The rightEnd returned a null ObservableSource");
                                ObservableSource observableSource2 = (ObservableSource) apply4;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i4);
                                this.disposables.ad(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.error.get() != null) {
                                    qwVar.clear();
                                    cancelAll();
                                    errorAll(observer);
                                    return;
                                }
                                for (TLeft apply5 : this.lefts.values()) {
                                    try {
                                        Object apply6 = this.resultSelector.apply(apply5, poll);
                                        th.de.p039if.ad.qw.rg(apply6, "The resultSelector returned a null value");
                                        observer.onNext(apply6);
                                    } catch (Throwable th4) {
                                        fail(th4, observer, qwVar);
                                        return;
                                    }
                                }
                            } catch (Throwable th5) {
                                fail(th5, observer, qwVar);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                            this.disposables.qw(leftRightEndObserver3);
                        } else {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                            this.disposables.qw(leftRightEndObserver4);
                        }
                    }
                }
                qwVar.clear();
            }
        }

        public void errorAll(Observer<?> observer) {
            Throwable ad2 = ExceptionHelper.ad(this.error);
            this.lefts.clear();
            this.rights.clear();
            observer.onError(ad2);
        }

        public void fail(Throwable th2, Observer<?> observer, th.de.p039if.rg.qw<?> qwVar) {
            th.de.o.qw.ad(th2);
            ExceptionHelper.qw(this.error, th2);
            qwVar.clear();
            cancelAll();
            errorAll(observer);
        }

        public void innerClose(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.m2355if(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndObserver);
            }
            drain();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.qw(this.error, th2)) {
                drain();
            } else {
                th.de.ppp.qw.ddd(th2);
            }
        }

        public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.disposables.de(leftRightObserver);
            this.active.decrementAndGet();
            drain();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.qw(this.error, th2)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.m2355if(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.f10150th = observableSource2;
        this.f10152yj = function;
        this.f10151uk = function2;
        this.f10149i = biFunction;
    }

    public void subscribeActual(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.f10152yj, this.f10151uk, this.f10149i);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.disposables.ad(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.disposables.ad(leftRightObserver2);
        this.f10756ad.subscribe(leftRightObserver);
        this.f10150th.subscribe(leftRightObserver2);
    }
}
