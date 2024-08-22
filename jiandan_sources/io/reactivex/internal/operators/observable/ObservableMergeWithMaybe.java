package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableMergeWithMaybe<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final MaybeSource<? extends T> f10154th;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        public static final int OTHER_STATE_HAS_VALUE = 1;
        public static final long serialVersionUID = -4592979584110982903L;
        public volatile boolean disposed;
        public final Observer<? super T> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final AtomicReference<Disposable> mainDisposable = new AtomicReference<>();
        public volatile boolean mainDone;
        public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        public volatile int otherState;
        public volatile SimplePlainQueue<T> queue;
        public T singleItem;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            public static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            public void onComplete() {
                this.parent.otherComplete();
            }

            public void onError(Throwable th2) {
                this.parent.otherError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            Observer<? super T> observer = this.downstream;
            int i2 = 1;
            while (!this.disposed) {
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    observer.onError(this.error.terminate());
                    return;
                }
                int i3 = this.otherState;
                if (i3 == 1) {
                    T t = this.singleItem;
                    this.singleItem = null;
                    this.otherState = 2;
                    observer.onNext(t);
                    i3 = 2;
                }
                boolean z = this.mainDone;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                boolean z2 = poll == null;
                if (z && z2 && i3 == 2) {
                    this.queue = null;
                    observer.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        public SimplePlainQueue<T> getOrCreateQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            th.de.p039if.rg.qw qwVar = new th.de.p039if.rg.qw(rg.bufferSize());
            this.queue = qwVar;
            return qwVar;
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (this.error.addThrowable(th2)) {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.mainDisposable, disposable);
        }

        public void otherComplete() {
            this.otherState = 2;
            drain();
        }

        public void otherError(Throwable th2) {
            if (this.error.addThrowable(th2)) {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
                return;
            }
            th.de.ppp.qw.ddd(th2);
        }

        public void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public ObservableMergeWithMaybe(rg<T> rgVar, MaybeSource<? extends T> maybeSource) {
        super(rgVar);
        this.f10154th = maybeSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f10756ad.subscribe(mergeWithObserver);
        this.f10154th.qw(mergeWithObserver.otherObserver);
    }
}
