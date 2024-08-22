package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.ad.qw;

public final class FlowableConcatMapSingle$ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_INACTIVE = 0;
    public static final int STATE_RESULT_VALUE = 2;
    public static final long serialVersionUID = -9140123220065488293L;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public long emitted;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
    public R item;
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    public final int prefetch;
    public final SimplePlainQueue<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public volatile int state;
    public Subscription upstream;

    public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
        public static final long serialVersionUID = -3051469169682093892L;
        public final FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> parent;

        public ConcatMapSingleObserver(FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> flowableConcatMapSingle$ConcatMapSingleSubscriber) {
            this.parent = flowableConcatMapSingle$ConcatMapSingleSubscriber;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
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

    public FlowableConcatMapSingle$ConcatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, int i2, ErrorMode errorMode2) {
        this.downstream = subscriber;
        this.mapper = function;
        this.prefetch = i2;
        this.errorMode = errorMode2;
        this.queue = new SpscArrayQueue(i2);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
            this.item = null;
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            Subscriber<? super R> subscriber = this.downstream;
            ErrorMode errorMode2 = this.errorMode;
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicLong atomicLong = this.requested;
            int i2 = this.prefetch;
            int i3 = i2 - (i2 >> 1);
            int i4 = 1;
            while (true) {
                if (this.cancelled) {
                    simplePlainQueue.clear();
                    this.item = null;
                } else {
                    int i5 = this.state;
                    if (atomicThrowable.get() == null || !(errorMode2 == ErrorMode.IMMEDIATE || (errorMode2 == ErrorMode.BOUNDARY && i5 == 0))) {
                        if (i5 == 0) {
                            boolean z = this.done;
                            T poll = simplePlainQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(terminate);
                                    return;
                                }
                            } else if (!z2) {
                                int i6 = this.consumed + 1;
                                if (i6 == i3) {
                                    this.consumed = 0;
                                    this.upstream.request((long) i3);
                                } else {
                                    this.consumed = i6;
                                }
                                try {
                                    Object apply = this.mapper.apply(poll);
                                    qw.rg(apply, "The mapper returned a null SingleSource");
                                    SingleSource singleSource = (SingleSource) apply;
                                    this.state = 1;
                                    singleSource.qw(this.inner);
                                } catch (Throwable th2) {
                                    th.de.o.qw.ad(th2);
                                    this.upstream.cancel();
                                    simplePlainQueue.clear();
                                    atomicThrowable.addThrowable(th2);
                                    subscriber.onError(atomicThrowable.terminate());
                                    return;
                                }
                            }
                        } else if (i5 == 2) {
                            long j = this.emitted;
                            if (j != atomicLong.get()) {
                                R r = this.item;
                                this.item = null;
                                subscriber.onNext(r);
                                this.emitted = j + 1;
                                this.state = 0;
                            }
                        }
                    }
                }
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            }
            simplePlainQueue.clear();
            this.item = null;
            subscriber.onError(atomicThrowable.terminate());
        }
    }

    public void innerError(Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
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
        if (!this.queue.offer(t)) {
            this.upstream.cancel();
            onError(new MissingBackpressureException("queue full?!"));
            return;
        }
        drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request((long) this.prefetch);
        }
    }

    public void request(long j) {
        th.de.p039if.yj.qw.qw(this.requested, j);
        drain();
    }
}
