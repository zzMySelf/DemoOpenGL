package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.rg.qw;
import th.de.rg;

public final class ObservableConcatMapMaybe<T, R> extends rg<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final rg<T> f10014ad;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f10015th;

    /* renamed from: uk  reason: collision with root package name */
    public final int f10016uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ErrorMode f10017yj;

    public static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final int STATE_ACTIVE = 1;
        public static final int STATE_INACTIVE = 0;
        public static final int STATE_RESULT_VALUE = 2;
        public static final long serialVersionUID = -9140123220065488293L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapMaybeObserver<R> inner = new ConcatMapMaybeObserver<>(this);
        public R item;
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public final SimplePlainQueue<T> queue;
        public volatile int state;
        public Disposable upstream;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            public static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapMaybeMainObserver<?, R> parent;

            public ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.parent = concatMapMaybeMainObserver;
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

            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }
        }

        public ConcatMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, int i2, ErrorMode errorMode2) {
            this.downstream = observer;
            this.mapper = function;
            this.errorMode = errorMode2;
            this.queue = new qw(i2);
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.downstream;
                ErrorMode errorMode2 = this.errorMode;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i2 = 1;
                while (true) {
                    if (this.cancelled) {
                        simplePlainQueue.clear();
                        this.item = null;
                    } else {
                        int i3 = this.state;
                        if (atomicThrowable.get() == null || !(errorMode2 == ErrorMode.IMMEDIATE || (errorMode2 == ErrorMode.BOUNDARY && i3 == 0))) {
                            boolean z = false;
                            if (i3 == 0) {
                                boolean z2 = this.done;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z = true;
                                }
                                if (z2 && z) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        observer.onComplete();
                                        return;
                                    } else {
                                        observer.onError(terminate);
                                        return;
                                    }
                                } else if (!z) {
                                    try {
                                        Object apply = this.mapper.apply(poll);
                                        th.de.p039if.ad.qw.rg(apply, "The mapper returned a null MaybeSource");
                                        MaybeSource maybeSource = (MaybeSource) apply;
                                        this.state = 1;
                                        maybeSource.qw(this.inner);
                                    } catch (Throwable th2) {
                                        th.de.o.qw.ad(th2);
                                        this.upstream.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th2);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                R r = this.item;
                                this.item = null;
                                observer.onNext(r);
                                this.state = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.item = null;
                observer.onError(atomicThrowable.terminate());
            }
        }

        public void innerComplete() {
            this.state = 0;
            drain();
        }

        public void innerError(Throwable th2) {
            if (this.errors.addThrowable(th2)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.dispose();
                }
                this.state = 0;
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
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
            if (this.errors.addThrowable(th2)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
                }
                this.done = true;
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapMaybe(rg<T> rgVar, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.f10014ad = rgVar;
        this.f10015th = function;
        this.f10017yj = errorMode;
        this.f10016uk = i2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!th.de.p039if.fe.fe.qw.ad(this.f10014ad, this.f10015th, observer)) {
            this.f10014ad.subscribe(new ConcatMapMaybeMainObserver(observer, this.f10015th, this.f10016uk, this.f10017yj));
        }
    }
}
