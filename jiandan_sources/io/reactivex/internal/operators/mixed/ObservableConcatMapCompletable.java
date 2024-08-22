package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.qw;
import th.de.rg;

public final class ObservableConcatMapCompletable<T> extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public final rg<T> f10010ad;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f10011th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10012uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ErrorMode f10013yj;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = 3610901111000061034L;
        public volatile boolean active;
        public volatile boolean disposed;
        public volatile boolean done;
        public final CompletableObserver downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        public final Function<? super T, ? extends CompletableSource> mapper;
        public final int prefetch;
        public SimpleQueue<T> queue;
        public Disposable upstream;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            public static final long serialVersionUID = 5638352172918776687L;
            public final ConcatMapCompletableObserver<?> parent;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.parent.innerComplete();
            }

            public void onError(Throwable th2) {
                this.parent.innerError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode2, int i2) {
            this.downstream = completableObserver;
            this.mapper = function;
            this.errorMode = errorMode2;
            this.prefetch = i2;
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            boolean z;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.errors;
                ErrorMode errorMode2 = this.errorMode;
                while (!this.disposed) {
                    if (!this.active) {
                        if (errorMode2 != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z2 = this.done;
                            CompletableSource completableSource = null;
                            try {
                                T poll = this.queue.poll();
                                if (poll != null) {
                                    Object apply = this.mapper.apply(poll);
                                    th.de.p039if.ad.qw.rg(apply, "The mapper returned a null CompletableSource");
                                    completableSource = (CompletableSource) apply;
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z2 && z) {
                                    this.disposed = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        this.downstream.onError(terminate);
                                        return;
                                    } else {
                                        this.downstream.onComplete();
                                        return;
                                    }
                                } else if (!z) {
                                    this.active = true;
                                    completableSource.qw(this.inner);
                                }
                            } catch (Throwable th2) {
                                th.de.o.qw.ad(th2);
                                this.disposed = true;
                                this.queue.clear();
                                this.upstream.dispose();
                                atomicThrowable.addThrowable(th2);
                                this.downstream.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            this.disposed = true;
                            this.queue.clear();
                            this.downstream.onError(atomicThrowable.terminate());
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

        public void innerError(Throwable th2) {
            if (!this.errors.addThrowable(th2)) {
                th.de.ppp.qw.ddd(th2);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.upstream.dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.qw) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.active = false;
                drain();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (!this.errors.addThrowable(th2)) {
                th.de.ppp.qw.ddd(th2);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.inner.dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.qw) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.done = true;
                drain();
            }
        }

        public void onNext(T t) {
            if (t != null) {
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
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
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

    public ObservableConcatMapCompletable(rg<T> rgVar, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
        this.f10010ad = rgVar;
        this.f10011th = function;
        this.f10013yj = errorMode;
        this.f10012uk = i2;
    }

    public void de(CompletableObserver completableObserver) {
        if (!th.de.p039if.fe.fe.qw.qw(this.f10010ad, this.f10011th, completableObserver)) {
            this.f10010ad.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f10011th, this.f10013yj, this.f10012uk));
        }
    }
}
