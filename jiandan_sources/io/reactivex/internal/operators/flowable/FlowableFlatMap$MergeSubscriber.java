package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableFlatMap$MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] CANCELLED = new FlowableFlatMap$InnerSubscriber[0];
    public static final FlowableFlatMap$InnerSubscriber<?, ?>[] EMPTY = new FlowableFlatMap$InnerSubscriber[0];
    public static final long serialVersionUID = -2117620485640801370L;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final Subscriber<? super U> downstream;
    public final AtomicThrowable errs = new AtomicThrowable();
    public long lastId;
    public int lastIndex;
    public final Function<? super T, ? extends Publisher<? extends U>> mapper;
    public final int maxConcurrency;
    public volatile SimplePlainQueue<U> queue;
    public final AtomicLong requested = new AtomicLong();
    public int scalarEmitted;
    public final int scalarLimit;
    public final AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> subscribers = new AtomicReference<>();
    public long uniqueId;
    public Subscription upstream;

    public FlowableFlatMap$MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i2, int i3) {
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i2;
        this.bufferSize = i3;
        this.scalarLimit = Math.max(1, i2 >> 1);
        this.subscribers.lazySet(EMPTY);
    }

    public boolean addInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.get();
            if (flowableFlatMap$InnerSubscriberArr == CANCELLED) {
                flowableFlatMap$InnerSubscriber.dispose();
                return false;
            }
            int length = flowableFlatMap$InnerSubscriberArr.length;
            flowableFlatMap$InnerSubscriberArr2 = new FlowableFlatMap$InnerSubscriber[(length + 1)];
            System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr2, 0, length);
            flowableFlatMap$InnerSubscriberArr2[length] = flowableFlatMap$InnerSubscriber;
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
        return true;
    }

    public void cancel() {
        SimplePlainQueue<U> simplePlainQueue;
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() == 0 && (simplePlainQueue = this.queue) != null) {
                simplePlainQueue.clear();
            }
        }
    }

    public boolean checkTerminate() {
        if (this.cancelled) {
            clearScalarQueue();
            return true;
        } else if (this.delayErrors || this.errs.get() == null) {
            return false;
        } else {
            clearScalarQueue();
            Throwable terminate = this.errs.terminate();
            if (terminate != ExceptionHelper.qw) {
                this.downstream.onError(terminate);
            }
            return true;
        }
    }

    public void clearScalarQueue() {
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (simplePlainQueue != null) {
            simplePlainQueue.clear();
        }
    }

    public void disposeAll() {
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2 = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.get();
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr3 = CANCELLED;
        if (flowableFlatMap$InnerSubscriberArr2 != flowableFlatMap$InnerSubscriberArr3 && (flowableFlatMap$InnerSubscriberArr = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.getAndSet(flowableFlatMap$InnerSubscriberArr3)) != CANCELLED) {
            for (FlowableFlatMap$InnerSubscriber<?, ?> dispose : flowableFlatMap$InnerSubscriberArr) {
                dispose.dispose();
            }
            Throwable terminate = this.errs.terminate();
            if (terminate != null && terminate != ExceptionHelper.qw) {
                qw.ddd(terminate);
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        long j;
        boolean z;
        long j2;
        long j3;
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArr;
        int i2;
        long j4;
        Subscriber<? super U> subscriber = this.downstream;
        int i3 = 1;
        while (!checkTerminate()) {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            long j5 = this.requested.get();
            boolean z2 = j5 == Long.MAX_VALUE;
            long j6 = 0;
            long j7 = 0;
            if (simplePlainQueue != null) {
                while (true) {
                    long j8 = 0;
                    U u = null;
                    while (true) {
                        if (j5 == 0) {
                            break;
                        }
                        U poll = simplePlainQueue.poll();
                        if (!checkTerminate()) {
                            if (poll == null) {
                                u = poll;
                                break;
                            }
                            subscriber.onNext(poll);
                            j7++;
                            j8++;
                            j5--;
                            u = poll;
                        } else {
                            return;
                        }
                    }
                    if (j8 != 0) {
                        if (z2) {
                            j5 = Long.MAX_VALUE;
                        } else {
                            j5 = this.requested.addAndGet(-j8);
                        }
                    }
                    if (j5 == 0 || u == null) {
                        break;
                    }
                }
            }
            boolean z3 = this.done;
            SimplePlainQueue<U> simplePlainQueue2 = this.queue;
            FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArr2 = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.get();
            int length = flowableFlatMap$InnerSubscriberArr2.length;
            if (!z3 || ((simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) || length != 0)) {
                int i4 = i3;
                if (length != 0) {
                    long j9 = this.lastId;
                    int i5 = this.lastIndex;
                    if (length <= i5 || flowableFlatMap$InnerSubscriberArr2[i5].id != j9) {
                        if (length <= i5) {
                            i5 = 0;
                        }
                        for (int i6 = 0; i6 < length && flowableFlatMap$InnerSubscriberArr2[i5].id != j9; i6++) {
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                        }
                        this.lastIndex = i5;
                        this.lastId = flowableFlatMap$InnerSubscriberArr2[i5].id;
                    }
                    int i7 = i5;
                    boolean z4 = false;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                            z = z4;
                            break;
                        } else if (!checkTerminate()) {
                            FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber = flowableFlatMap$InnerSubscriberArr2[i7];
                            U u2 = null;
                            while (!checkTerminate()) {
                                SimpleQueue<U> simpleQueue = flowableFlatMap$InnerSubscriber.queue;
                                if (simpleQueue == null) {
                                    flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                                    i2 = length;
                                } else {
                                    flowableFlatMap$InnerSubscriberArr = flowableFlatMap$InnerSubscriberArr2;
                                    i2 = length;
                                    long j10 = j6;
                                    while (j != j6) {
                                        try {
                                            u2 = simpleQueue.poll();
                                            if (u2 == null) {
                                                break;
                                            }
                                            subscriber.onNext(u2);
                                            if (!checkTerminate()) {
                                                j--;
                                                j10++;
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            Throwable th3 = th2;
                                            th.de.o.qw.ad(th3);
                                            flowableFlatMap$InnerSubscriber.dispose();
                                            this.errs.addThrowable(th3);
                                            if (!this.delayErrors) {
                                                this.upstream.cancel();
                                            }
                                            if (!checkTerminate()) {
                                                removeInner(flowableFlatMap$InnerSubscriber);
                                                i8++;
                                                length = i2;
                                                z4 = true;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    if (j10 != j6) {
                                        j = !z2 ? this.requested.addAndGet(-j10) : Long.MAX_VALUE;
                                        flowableFlatMap$InnerSubscriber.requestMore(j10);
                                        j4 = 0;
                                    } else {
                                        j4 = j6;
                                    }
                                    if (!(j == j4 || u2 == null)) {
                                        flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr;
                                        length = i2;
                                        j6 = 0;
                                    }
                                }
                                boolean z5 = flowableFlatMap$InnerSubscriber.done;
                                SimpleQueue<U> simpleQueue2 = flowableFlatMap$InnerSubscriber.queue;
                                if (z5 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    removeInner(flowableFlatMap$InnerSubscriber);
                                    if (!checkTerminate()) {
                                        j7++;
                                        z4 = true;
                                    } else {
                                        return;
                                    }
                                }
                                if (j == 0) {
                                    z = z4;
                                    break;
                                }
                                i7++;
                                length = i2;
                                if (i7 == length) {
                                    i7 = 0;
                                }
                                i8++;
                                flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr;
                                j6 = 0;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.lastIndex = i7;
                    this.lastId = flowableFlatMap$InnerSubscriberArr[i7].id;
                    j3 = j7;
                    j2 = 0;
                } else {
                    j2 = 0;
                    j3 = j7;
                    z = false;
                }
                if (j3 != j2 && !this.cancelled) {
                    this.upstream.request(j3);
                }
                if (z) {
                    i3 = i4;
                } else {
                    i3 = addAndGet(-i4);
                    if (i3 == 0) {
                        return;
                    }
                }
            } else {
                Throwable terminate = this.errs.terminate();
                if (terminate == ExceptionHelper.qw) {
                    return;
                }
                if (terminate == null) {
                    subscriber.onComplete();
                    return;
                } else {
                    subscriber.onError(terminate);
                    return;
                }
            }
        }
    }

    public SimpleQueue<U> getInnerQueue(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        SimpleQueue<U> simpleQueue = flowableFlatMap$InnerSubscriber.queue;
        if (simpleQueue != null) {
            return simpleQueue;
        }
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
        flowableFlatMap$InnerSubscriber.queue = spscArrayQueue;
        return spscArrayQueue;
    }

    public SimpleQueue<U> getMainQueue() {
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (simplePlainQueue == null) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                simplePlainQueue = new th.de.p039if.rg.qw<>(this.bufferSize);
            } else {
                simplePlainQueue = new SpscArrayQueue<>(this.maxConcurrency);
            }
            this.queue = simplePlainQueue;
        }
        return simplePlainQueue;
    }

    public void innerError(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber, Throwable th2) {
        if (this.errs.addThrowable(th2)) {
            flowableFlatMap$InnerSubscriber.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                for (FlowableFlatMap$InnerSubscriber dispose : (FlowableFlatMap$InnerSubscriber[]) this.subscribers.getAndSet(CANCELLED)) {
                    dispose.dispose();
                }
            }
            drain();
            return;
        }
        qw.ddd(th2);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
        } else if (this.errs.addThrowable(th2)) {
            this.done = true;
            drain();
        } else {
            qw.ddd(th2);
        }
    }

    public void onNext(T t) {
        if (!this.done) {
            try {
                Object apply = this.mapper.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call != null) {
                            tryEmitScalar(call);
                        } else if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                            int i2 = this.scalarEmitted + 1;
                            this.scalarEmitted = i2;
                            int i3 = this.scalarLimit;
                            if (i2 == i3) {
                                this.scalarEmitted = 0;
                                this.upstream.request((long) i3);
                            }
                        }
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        this.errs.addThrowable(th2);
                        drain();
                    }
                } else {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber = new FlowableFlatMap$InnerSubscriber(this, j);
                    if (addInner(flowableFlatMap$InnerSubscriber)) {
                        publisher.subscribe(flowableFlatMap$InnerSubscriber);
                    }
                }
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                this.upstream.cancel();
                onError(th3);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            if (!this.cancelled) {
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i2);
                }
            }
        }
    }

    public void removeInner(FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber<T, U>[] flowableFlatMap$InnerSubscriberArr;
        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr2;
        do {
            flowableFlatMap$InnerSubscriberArr = (FlowableFlatMap$InnerSubscriber[]) this.subscribers.get();
            int length = flowableFlatMap$InnerSubscriberArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (flowableFlatMap$InnerSubscriberArr[i3] == flowableFlatMap$InnerSubscriber) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        flowableFlatMap$InnerSubscriberArr2 = EMPTY;
                    } else {
                        FlowableFlatMap$InnerSubscriber<?, ?>[] flowableFlatMap$InnerSubscriberArr3 = new FlowableFlatMap$InnerSubscriber[(length - 1)];
                        System.arraycopy(flowableFlatMap$InnerSubscriberArr, 0, flowableFlatMap$InnerSubscriberArr3, 0, i2);
                        System.arraycopy(flowableFlatMap$InnerSubscriberArr, i2 + 1, flowableFlatMap$InnerSubscriberArr3, i2, (length - i2) - 1);
                        flowableFlatMap$InnerSubscriberArr2 = flowableFlatMap$InnerSubscriberArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(flowableFlatMap$InnerSubscriberArr, flowableFlatMap$InnerSubscriberArr2));
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }

    public void tryEmit(U u, FlowableFlatMap$InnerSubscriber<T, U> flowableFlatMap$InnerSubscriber) {
        if (get() != 0 || !compareAndSet(0, 1)) {
            SimpleQueue simpleQueue = flowableFlatMap$InnerSubscriber.queue;
            if (simpleQueue == null) {
                simpleQueue = new SpscArrayQueue(this.bufferSize);
                flowableFlatMap$InnerSubscriber.queue = simpleQueue;
            }
            if (!simpleQueue.offer(u)) {
                onError(new MissingBackpressureException("Inner queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
        } else {
            long j = this.requested.get();
            SimpleQueue<U> simpleQueue2 = flowableFlatMap$InnerSubscriber.queue;
            if (j == 0 || (simpleQueue2 != null && !simpleQueue2.isEmpty())) {
                if (simpleQueue2 == null) {
                    simpleQueue2 = getInnerQueue(flowableFlatMap$InnerSubscriber);
                }
                if (!simpleQueue2.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                }
            } else {
                this.downstream.onNext(u);
                if (j != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                flowableFlatMap$InnerSubscriber.requestMore(1);
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        drainLoop();
    }

    public void tryEmitScalar(U u) {
        if (get() == 0 && compareAndSet(0, 1)) {
            long j = this.requested.get();
            SimpleQueue simpleQueue = this.queue;
            if (j == 0 || (simpleQueue != null && !simpleQueue.isEmpty())) {
                if (simpleQueue == null) {
                    simpleQueue = getMainQueue();
                }
                if (!simpleQueue.offer(u)) {
                    onError(new IllegalStateException("Scalar queue full?!"));
                    return;
                }
            } else {
                this.downstream.onNext(u);
                if (j != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                    int i2 = this.scalarEmitted + 1;
                    this.scalarEmitted = i2;
                    int i3 = this.scalarLimit;
                    if (i2 == i3) {
                        this.scalarEmitted = 0;
                        this.upstream.request((long) i3);
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else if (!getMainQueue().offer(u)) {
            onError(new IllegalStateException("Scalar queue full?!"));
            return;
        } else if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }
}
