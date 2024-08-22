package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.when.fe;

public final class ObservableConcatMap<T, U> extends qw<T, U> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f10069th;

    /* renamed from: uk  reason: collision with root package name */
    public final ErrorMode f10070uk;

    /* renamed from: yj  reason: collision with root package name */
    public final int f10071yj;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = -6951100001833242599L;
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public final DelayErrorInnerObserver<R> observer;
        public SimpleQueue<T> queue;
        public int sourceMode;
        public final boolean tillTheEnd;
        public Disposable upstream;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            public static final long serialVersionUID = 2620149119579502636L;
            public final Observer<? super R> downstream;
            public final ConcatMapDelayErrorObserver<?, R> parent;

            public DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.downstream = observer;
                this.parent = concatMapDelayErrorObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            public void onError(Throwable th2) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (concatMapDelayErrorObserver.error.addThrowable(th2)) {
                    if (!concatMapDelayErrorObserver.tillTheEnd) {
                        concatMapDelayErrorObserver.upstream.dispose();
                    }
                    concatMapDelayErrorObserver.active = false;
                    concatMapDelayErrorObserver.drain();
                    return;
                }
                th.de.ppp.qw.ddd(th2);
            }

            public void onNext(R r) {
                this.downstream.onNext(r);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapDelayErrorObserver(Observer<? super R> observer2, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
            this.downstream = observer2;
            this.mapper = function;
            this.bufferSize = i2;
            this.tillTheEnd = z;
            this.observer = new DelayErrorInnerObserver<>(observer2, this);
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer2 = this.downstream;
                SimpleQueue<T> simpleQueue = this.queue;
                AtomicThrowable atomicThrowable = this.error;
                while (true) {
                    if (!this.active) {
                        if (this.cancelled) {
                            simpleQueue.clear();
                            return;
                        } else if (this.tillTheEnd || ((Throwable) atomicThrowable.get()) == null) {
                            boolean z = this.done;
                            try {
                                T poll = simpleQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    this.cancelled = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        observer2.onError(terminate);
                                        return;
                                    } else {
                                        observer2.onComplete();
                                        return;
                                    }
                                } else if (!z2) {
                                    try {
                                        Object apply = this.mapper.apply(poll);
                                        th.de.p039if.ad.qw.rg(apply, "The mapper returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        if (observableSource instanceof Callable) {
                                            try {
                                                Object call = ((Callable) observableSource).call();
                                                if (call != null && !this.cancelled) {
                                                    observer2.onNext(call);
                                                }
                                            } catch (Throwable th2) {
                                                th.de.o.qw.ad(th2);
                                                atomicThrowable.addThrowable(th2);
                                            }
                                        } else {
                                            this.active = true;
                                            observableSource.subscribe(this.observer);
                                        }
                                    } catch (Throwable th3) {
                                        th.de.o.qw.ad(th3);
                                        this.cancelled = true;
                                        this.upstream.dispose();
                                        simpleQueue.clear();
                                        atomicThrowable.addThrowable(th3);
                                        observer2.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                th.de.o.qw.ad(th4);
                                this.cancelled = true;
                                this.upstream.dispose();
                                atomicThrowable.addThrowable(th4);
                                observer2.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            this.cancelled = true;
                            observer2.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
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
                this.queue = new th.de.p039if.rg.qw(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = 8828587559905699186L;
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean disposed;
        public volatile boolean done;
        public final Observer<? super U> downstream;
        public int fusionMode;
        public final InnerObserver<U> inner;
        public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        public SimpleQueue<T> queue;
        public Disposable upstream;

        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            public static final long serialVersionUID = -7449079488798789337L;
            public final Observer<? super U> downstream;
            public final SourceObserver<?, ?> parent;

            public InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.downstream = observer;
                this.parent = sourceObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.parent.innerComplete();
            }

            public void onError(Throwable th2) {
                this.parent.dispose();
                this.downstream.onError(th2);
            }

            public void onNext(U u) {
                this.downstream.onNext(u);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2) {
            this.downstream = observer;
            this.mapper = function;
            this.bufferSize = i2;
            this.inner = new InnerObserver<>(observer, this);
        }

        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.disposed = true;
                                this.downstream.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.mapper.apply(poll);
                                    th.de.p039if.ad.qw.rg(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) apply;
                                    this.active = true;
                                    observableSource.subscribe(this.inner);
                                } catch (Throwable th2) {
                                    th.de.o.qw.ad(th2);
                                    dispose();
                                    this.queue.clear();
                                    this.downstream.onError(th2);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            th.de.o.qw.ad(th3);
                            dispose();
                            this.queue.clear();
                            this.downstream.onError(th3);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode == 0) {
                    this.queue.offer(t);
                }
                drain();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new th.de.p039if.rg.qw(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2, ErrorMode errorMode) {
        super(observableSource);
        this.f10069th = function;
        this.f10070uk = errorMode;
        this.f10071yj = Math.max(8, i2);
    }

    public void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.ad(this.f10756ad, observer, this.f10069th)) {
            if (this.f10070uk == ErrorMode.IMMEDIATE) {
                this.f10756ad.subscribe(new SourceObserver(new fe(observer), this.f10069th, this.f10071yj));
            } else {
                this.f10756ad.subscribe(new ConcatMapDelayErrorObserver(observer, this.f10069th, this.f10071yj, this.f10070uk == ErrorMode.END));
            }
        }
    }
}
