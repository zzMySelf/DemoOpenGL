package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.fe.rg.qw;

public final class ObservableConcatMapEager<T, R> extends qw<T, R> {

    /* renamed from: i  reason: collision with root package name */
    public final int f10072i;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f10073th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10074uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ErrorMode f10075yj;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        public static final long serialVersionUID = 8080567949447303262L;
        public int activeCount;
        public volatile boolean cancelled;
        public InnerQueuedObserver<R> current;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final ErrorMode errorMode;
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public final int maxConcurrency;
        public final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();
        public final int prefetch;
        public SimpleQueue<T> queue;
        public int sourceMode;
        public Disposable upstream;

        public ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3, ErrorMode errorMode2) {
            this.downstream = observer;
            this.mapper = function;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = errorMode2;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                drainAndDispose();
            }
        }

        public void disposeAll() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver poll = this.observers.poll();
                if (poll != null) {
                    poll.dispose();
                } else {
                    return;
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.queue;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
                Observer<? super R> observer = this.downstream;
                ErrorMode errorMode2 = this.errorMode;
                int i2 = 1;
                while (true) {
                    int i3 = this.activeCount;
                    while (true) {
                        if (i3 == this.maxConcurrency) {
                            break;
                        } else if (this.cancelled) {
                            simpleQueue.clear();
                            disposeAll();
                            return;
                        } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.error.get()) == null) {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                Object apply = this.mapper.apply(poll);
                                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.prefetch);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i3++;
                            } catch (Throwable th2) {
                                th.de.o.qw.ad(th2);
                                this.upstream.dispose();
                                simpleQueue.clear();
                                disposeAll();
                                this.error.addThrowable(th2);
                                observer.onError(this.error.terminate());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            disposeAll();
                            observer.onError(this.error.terminate());
                            return;
                        }
                    }
                    this.activeCount = i3;
                    if (this.cancelled) {
                        simpleQueue.clear();
                        disposeAll();
                        return;
                    } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.error.get()) == null) {
                        InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode2 != ErrorMode.BOUNDARY || ((Throwable) this.error.get()) == null) {
                                boolean z = this.done;
                                InnerQueuedObserver<R> poll2 = arrayDeque.poll();
                                boolean z2 = poll2 == null;
                                if (!z || !z2) {
                                    if (!z2) {
                                        this.current = poll2;
                                    }
                                    innerQueuedObserver2 = poll2;
                                } else if (((Throwable) this.error.get()) != null) {
                                    simpleQueue.clear();
                                    disposeAll();
                                    observer.onError(this.error.terminate());
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                simpleQueue.clear();
                                disposeAll();
                                observer.onError(this.error.terminate());
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue<R> queue2 = innerQueuedObserver2.queue();
                            while (!this.cancelled) {
                                boolean isDone = innerQueuedObserver2.isDone();
                                if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.error.get()) == null) {
                                    try {
                                        R poll3 = queue2.poll();
                                        boolean z3 = poll3 == null;
                                        if (isDone && z3) {
                                            this.current = null;
                                            this.activeCount--;
                                        } else if (!z3) {
                                            observer.onNext(poll3);
                                        }
                                    } catch (Throwable th3) {
                                        th.de.o.qw.ad(th3);
                                        this.error.addThrowable(th3);
                                        this.current = null;
                                        this.activeCount--;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    disposeAll();
                                    observer.onError(this.error.terminate());
                                    return;
                                }
                            }
                            simpleQueue.clear();
                            disposeAll();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        disposeAll();
                        observer.onError(this.error.terminate());
                        return;
                    }
                }
            }
        }

        public void drainAndDispose() {
            if (getAndIncrement() == 0) {
                do {
                    this.queue.clear();
                    disposeAll();
                } while (decrementAndGet() != 0);
            }
        }

        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th2) {
            if (this.error.addThrowable(th2)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.upstream.dispose();
                }
                innerQueuedObserver.setDone();
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.queue().offer(r);
            drain();
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (this.error.addThrowable(th2)) {
                this.done = true;
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new th.de.p039if.rg.qw(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i2, int i3) {
        super(observableSource);
        this.f10073th = function;
        this.f10075yj = errorMode;
        this.f10074uk = i2;
        this.f10072i = i3;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f10756ad.subscribe(new ConcatMapEagerMainObserver(observer, this.f10073th, this.f10074uk, this.f10072i, this.f10075yj));
    }
}
