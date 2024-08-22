package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;
import th.de.rg;

public final class ObservableSwitchMapMaybe<T, R> extends rg<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final rg<T> f10032ad;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f10033th;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f10034yj;

    public static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>((SwitchMapMaybeMainObserver) null);
        public static final long serialVersionUID = -5402190102429853762L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public Disposable upstream;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            public static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapMaybeMainObserver<?, R> parent;

            public SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.parent = switchMapMaybeMainObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.parent.innerComplete(this);
            }

            public void onError(Throwable th2) {
                this.parent.innerError(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }
        }

        public SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        public void disposeInner() {
            SwitchMapMaybeObserver<Object> andSet = this.inner.getAndSet(INNER_DISPOSED);
            if (andSet != null && andSet != INNER_DISPOSED) {
                andSet.dispose();
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
                int i2 = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() == null || this.delayErrors) {
                        boolean z = this.done;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        boolean z2 = switchMapMaybeObserver == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                observer.onError(terminate);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else if (z2 || switchMapMaybeObserver.item == null) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            atomicReference.compareAndSet(switchMapMaybeObserver, (Object) null);
                            observer.onNext(switchMapMaybeObserver.item);
                        }
                    } else {
                        observer.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
        }

        public void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, (Object) null)) {
                drain();
            }
        }

        public void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
            if (!this.inner.compareAndSet(switchMapMaybeObserver, (Object) null) || !this.errors.addThrowable(th2)) {
                qw.ddd(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                disposeInner();
            }
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
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            qw.ddd(th2);
        }

        public void onNext(T t) {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.dispose();
            }
            try {
                Object apply = this.mapper.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.qw(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.upstream.dispose();
                this.inner.getAndSet(INNER_DISPOSED);
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

    public ObservableSwitchMapMaybe(rg<T> rgVar, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.f10032ad = rgVar;
        this.f10033th = function;
        this.f10034yj = z;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!th.de.p039if.fe.fe.qw.ad(this.f10032ad, this.f10033th, observer)) {
            this.f10032ad.subscribe(new SwitchMapMaybeMainObserver(observer, this.f10033th, this.f10034yj));
        }
    }
}
