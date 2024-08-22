package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.ad.qw;

public final class FlowableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    public static final long serialVersionUID = 3610901111000061034L;
    public volatile boolean active;
    public int consumed;
    public volatile boolean disposed;
    public volatile boolean done;
    public final CompletableObserver downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
    public final Function<? super T, ? extends CompletableSource> mapper;
    public final int prefetch;
    public final SimplePlainQueue<T> queue;
    public Subscription upstream;

    public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
        public static final long serialVersionUID = 5638352172918776687L;
        public final FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> flowableConcatMapCompletable$ConcatMapCompletableObserver) {
            this.parent = flowableConcatMapCompletable$ConcatMapCompletableObserver;
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

    public FlowableConcatMapCompletable$ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode2, int i2) {
        this.downstream = completableObserver;
        this.mapper = function;
        this.errorMode = errorMode2;
        this.prefetch = i2;
        this.queue = new SpscArrayQueue(i2);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            while (!this.disposed) {
                if (!this.active) {
                    if (this.errorMode != ErrorMode.BOUNDARY || this.errors.get() == null) {
                        boolean z = this.done;
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.downstream.onError(terminate);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        } else if (!z2) {
                            int i2 = this.prefetch;
                            int i3 = i2 - (i2 >> 1);
                            int i4 = this.consumed + 1;
                            if (i4 == i3) {
                                this.consumed = 0;
                                this.upstream.request((long) i3);
                            } else {
                                this.consumed = i4;
                            }
                            try {
                                Object apply = this.mapper.apply(poll);
                                qw.rg(apply, "The mapper returned a null CompletableSource");
                                CompletableSource completableSource = (CompletableSource) apply;
                                this.active = true;
                                completableSource.qw(this.inner);
                            } catch (Throwable th2) {
                                th.de.o.qw.ad(th2);
                                this.queue.clear();
                                this.upstream.cancel();
                                this.errors.addThrowable(th2);
                                this.downstream.onError(this.errors.terminate());
                                return;
                            }
                        }
                    } else {
                        this.queue.clear();
                        this.downstream.onError(this.errors.terminate());
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
            this.upstream.cancel();
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
        if (this.queue.offer(t)) {
            drain();
            return;
        }
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue full?!"));
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request((long) this.prefetch);
        }
    }
}
