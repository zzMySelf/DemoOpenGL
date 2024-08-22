package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.rg;

public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends th.de.p039if.fe.rg.qw<TLeft, R> {

    /* renamed from: i  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super rg<TRight>, ? extends R> f10109i;

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<? extends TRight> f10110th;

    /* renamed from: uk  reason: collision with root package name */
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f10111uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f10112yj;

    public static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, qw {
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
        public final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
        public final th.de.p039if.rg.qw<Object> queue = new th.de.p039if.rg.qw<>(rg.bufferSize());
        public final BiFunction<? super TLeft, ? super rg<TRight>, ? extends R> resultSelector;
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        public int rightIndex;
        public final Map<Integer, TRight> rights = new LinkedHashMap();

        public GroupJoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super rg<TRight>, ? extends R> biFunction) {
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
                        for (UnicastSubject<TRight> onComplete : this.lefts.values()) {
                            onComplete.onComplete();
                        }
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
                            UnicastSubject fe2 = UnicastSubject.fe();
                            int i3 = this.leftIndex;
                            this.leftIndex = i3 + 1;
                            this.lefts.put(Integer.valueOf(i3), fe2);
                            try {
                                Object apply = this.leftEnd.apply(poll);
                                th.de.p039if.ad.qw.rg(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i3);
                                this.disposables.ad(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.error.get() != null) {
                                    qwVar.clear();
                                    cancelAll();
                                    errorAll(observer);
                                    return;
                                }
                                try {
                                    Object apply2 = this.resultSelector.apply(poll, fe2);
                                    th.de.p039if.ad.qw.rg(apply2, "The resultSelector returned a null value");
                                    observer.onNext(apply2);
                                    for (TRight onNext : this.rights.values()) {
                                        fe2.onNext(onNext);
                                    }
                                } catch (Throwable th2) {
                                    fail(th2, observer, qwVar);
                                    return;
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
                                Object apply3 = this.rightEnd.apply(poll);
                                th.de.p039if.ad.qw.rg(apply3, "The rightEnd returned a null ObservableSource");
                                ObservableSource observableSource2 = (ObservableSource) apply3;
                                LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i4);
                                this.disposables.ad(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.error.get() != null) {
                                    qwVar.clear();
                                    cancelAll();
                                    errorAll(observer);
                                    return;
                                }
                                for (UnicastSubject<TRight> onNext2 : this.lefts.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th4) {
                                fail(th4, observer, qwVar);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) poll;
                            UnicastSubject remove = this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                            this.disposables.qw(leftRightEndObserver3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else if (num == RIGHT_CLOSE) {
                            LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) poll;
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
            for (UnicastSubject<TRight> onError : this.lefts.values()) {
                onError.onError(ad2);
            }
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

        public void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver) {
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

        public void innerComplete(LeftRightObserver leftRightObserver) {
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

    public static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        public static final long serialVersionUID = 1883890389173668373L;
        public final int index;
        public final boolean isLeft;
        public final qw parent;

        public LeftRightEndObserver(qw qwVar, boolean z, int i2) {
            this.parent = qwVar;
            this.isLeft = z;
            this.index = i2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        public void onError(Throwable th2) {
            this.parent.innerCloseError(th2);
        }

        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        public static final long serialVersionUID = 1883890389173668373L;
        public final boolean isLeft;
        public final qw parent;

        public LeftRightObserver(qw qwVar, boolean z) {
            this.parent = qwVar;
            this.isLeft = z;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.parent.innerComplete(this);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2);
        }

        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public interface qw {
        void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th2);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th2);

        void innerValue(boolean z, Object obj);
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super rg<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.f10110th = observableSource2;
        this.f10112yj = function;
        this.f10111uk = function2;
        this.f10109i = biFunction;
    }

    public void subscribeActual(Observer<? super R> observer) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(observer, this.f10112yj, this.f10111uk, this.f10109i);
        observer.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.disposables.ad(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.disposables.ad(leftRightObserver2);
        this.f10756ad.subscribe(leftRightObserver);
        this.f10110th.subscribe(leftRightObserver2);
    }
}
