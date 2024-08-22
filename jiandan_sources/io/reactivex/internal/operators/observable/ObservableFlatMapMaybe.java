package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableFlatMapMaybe<T, R> extends qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f10100th;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f10101yj;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = 8600231336733376951L;
        public final AtomicInteger active = new AtomicInteger(1);
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final Observer<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public final AtomicReference<th.de.p039if.rg.qw<R>> queue = new AtomicReference<>();
        public final th.de.i.qw set = new th.de.i.qw();
        public Disposable upstream;

        public final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            public static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.innerComplete(this);
            }

            public void onError(Throwable th2) {
                FlatMapMaybeObserver.this.innerError(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r) {
                FlatMapMaybeObserver.this.innerSuccess(this, r);
            }
        }

        public FlatMapMaybeObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
        }

        public void clear() {
            th.de.p039if.rg.qw qwVar = this.queue.get();
            if (qwVar != null) {
                qwVar.clear();
            }
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            Observer<? super R> observer = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<th.de.p039if.rg.qw<R>> atomicReference = this.queue;
            int i2 = 1;
            while (!this.cancelled) {
                if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                    boolean z = false;
                    boolean z2 = atomicInteger.get() == 0;
                    th.de.p039if.rg.qw qwVar = atomicReference.get();
                    Object poll = qwVar != null ? qwVar.poll() : null;
                    if (poll == null) {
                        z = true;
                    }
                    if (z2 && z) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            observer.onError(terminate);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    } else if (z) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(poll);
                    }
                } else {
                    Throwable terminate2 = this.errors.terminate();
                    clear();
                    observer.onError(terminate2);
                    return;
                }
            }
            clear();
        }

        public th.de.p039if.rg.qw<R> getOrCreateQueue() {
            th.de.p039if.rg.qw<R> qwVar;
            do {
                th.de.p039if.rg.qw<R> qwVar2 = this.queue.get();
                if (qwVar2 != null) {
                    return qwVar2;
                }
                qwVar = new th.de.p039if.rg.qw<>(rg.bufferSize());
            } while (!this.queue.compareAndSet((Object) null, qwVar));
            return qwVar;
        }

        public void innerComplete(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            this.set.de(innerObserver);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() == 0) {
                        z = true;
                    }
                    th.de.p039if.rg.qw qwVar = this.queue.get();
                    if (z && (qwVar == null || qwVar.isEmpty())) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.downstream.onError(terminate);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    } else if (decrementAndGet() != 0) {
                        drainLoop();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.active.decrementAndGet();
            drain();
        }

        public void innerError(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.set.de(innerObserver);
            if (this.errors.addThrowable(th2)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void innerSuccess(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r) {
            this.set.de(innerObserver);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    this.downstream.onNext(r);
                    if (this.active.decrementAndGet() == 0) {
                        z = true;
                    }
                    th.de.p039if.rg.qw qwVar = this.queue.get();
                    if (!z || (qwVar != null && !qwVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                    }
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.downstream.onError(terminate);
                        return;
                    } else {
                        this.downstream.onComplete();
                        return;
                    }
                }
            }
            th.de.p039if.rg.qw orCreateQueue = getOrCreateQueue();
            synchronized (orCreateQueue) {
                orCreateQueue.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        public void onError(Throwable th2) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(th2)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            try {
                Object apply = this.mapper.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.cancelled && this.set.ad(innerObserver)) {
                    maybeSource.qw(innerObserver);
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.f10100th = function;
        this.f10101yj = z;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f10756ad.subscribe(new FlatMapMaybeObserver(observer, this.f10100th, this.f10101yj));
    }
}
