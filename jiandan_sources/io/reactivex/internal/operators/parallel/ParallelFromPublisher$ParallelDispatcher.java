package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher$ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -4470634016609963609L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final long[] emissions;
    public Throwable error;
    public int index;
    public final int limit;
    public final int prefetch;
    public int produced;
    public SimpleQueue<T> queue;
    public final AtomicLongArray requests;
    public int sourceMode;
    public final AtomicInteger subscriberCount = new AtomicInteger();
    public final Subscriber<? super T>[] subscribers;
    public Subscription upstream;

    public final class qw implements Subscription {

        /* renamed from: ad  reason: collision with root package name */
        public final int f10306ad;

        /* renamed from: th  reason: collision with root package name */
        public final int f10307th;

        public qw(int i2, int i3) {
            this.f10306ad = i2;
            this.f10307th = i3;
        }

        public void cancel() {
            if (ParallelFromPublisher$ParallelDispatcher.this.requests.compareAndSet(this.f10306ad + this.f10307th, 0, 1)) {
                ParallelFromPublisher$ParallelDispatcher parallelFromPublisher$ParallelDispatcher = ParallelFromPublisher$ParallelDispatcher.this;
                int i2 = this.f10307th;
                parallelFromPublisher$ParallelDispatcher.cancel(i2 + i2);
            }
        }

        public void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                AtomicLongArray atomicLongArray = ParallelFromPublisher$ParallelDispatcher.this.requests;
                do {
                    j2 = atomicLongArray.get(this.f10306ad);
                    if (j2 != Long.MAX_VALUE) {
                    } else {
                        return;
                    }
                } while (!atomicLongArray.compareAndSet(this.f10306ad, j2, th.de.p039if.yj.qw.de(j2, j)));
                if (ParallelFromPublisher$ParallelDispatcher.this.subscriberCount.get() == this.f10307th) {
                    ParallelFromPublisher$ParallelDispatcher.this.drain();
                }
            }
        }
    }

    public ParallelFromPublisher$ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i2) {
        this.subscribers = subscriberArr;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
        int length = subscriberArr.length;
        int i3 = length + length;
        AtomicLongArray atomicLongArray = new AtomicLongArray(i3 + 1);
        this.requests = atomicLongArray;
        atomicLongArray.lazySet(i3, (long) length);
        this.emissions = new long[length];
    }

    public void cancel(int i2) {
        if (this.requests.decrementAndGet(i2) == 0) {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }
    }

    public void drainAsync() {
        Throwable th2;
        SimpleQueue<T> simpleQueue = this.queue;
        Subscriber<? super T>[] subscriberArr = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] jArr = this.emissions;
        int length = jArr.length;
        int i2 = this.index;
        int i3 = this.produced;
        int i4 = 1;
        while (true) {
            int i5 = 0;
            int i6 = 0;
            while (!this.cancelled) {
                boolean z = this.done;
                if (!z || (th2 = this.error) == null) {
                    boolean isEmpty = simpleQueue.isEmpty();
                    if (!z || !isEmpty) {
                        if (!isEmpty) {
                            long j = atomicLongArray.get(i2);
                            long j2 = jArr[i2];
                            if (j == j2 || atomicLongArray.get(length + i2) != 0) {
                                i6++;
                            } else {
                                try {
                                    T poll = simpleQueue.poll();
                                    if (poll != null) {
                                        subscriberArr[i2].onNext(poll);
                                        jArr[i2] = j2 + 1;
                                        i3++;
                                        if (i3 == this.limit) {
                                            this.upstream.request((long) i3);
                                            i3 = 0;
                                        }
                                        i6 = 0;
                                    }
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    th.de.o.qw.ad(th4);
                                    this.upstream.cancel();
                                    int length2 = subscriberArr.length;
                                    while (i5 < length2) {
                                        subscriberArr[i5].onError(th4);
                                        i5++;
                                    }
                                    return;
                                }
                            }
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                                continue;
                            }
                            if (i6 == length) {
                            }
                        }
                        int i7 = get();
                        if (i7 == i4) {
                            this.index = i2;
                            this.produced = i3;
                            i4 = addAndGet(-i4);
                            if (i4 == 0) {
                                return;
                            }
                        } else {
                            i4 = i7;
                        }
                    } else {
                        int length3 = subscriberArr.length;
                        while (i5 < length3) {
                            subscriberArr[i5].onComplete();
                            i5++;
                        }
                        return;
                    }
                } else {
                    simpleQueue.clear();
                    int length4 = subscriberArr.length;
                    while (i5 < length4) {
                        subscriberArr[i5].onError(th2);
                        i5++;
                    }
                    return;
                }
            }
            simpleQueue.clear();
            return;
        }
    }

    public void drainSync() {
        SimpleQueue<T> simpleQueue = this.queue;
        Subscriber<? super T>[] subscriberArr = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] jArr = this.emissions;
        int length = jArr.length;
        int i2 = this.index;
        int i3 = 1;
        while (true) {
            int i4 = 0;
            int i5 = 0;
            while (!this.cancelled) {
                if (simpleQueue.isEmpty()) {
                    int length2 = subscriberArr.length;
                    while (i4 < length2) {
                        subscriberArr[i4].onComplete();
                        i4++;
                    }
                    return;
                }
                long j = atomicLongArray.get(i2);
                long j2 = jArr[i2];
                if (j == j2 || atomicLongArray.get(length + i2) != 0) {
                    i5++;
                } else {
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            int length3 = subscriberArr.length;
                            while (i4 < length3) {
                                subscriberArr[i4].onComplete();
                                i4++;
                            }
                            return;
                        }
                        subscriberArr[i2].onNext(poll);
                        jArr[i2] = j2 + 1;
                        i5 = 0;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        th.de.o.qw.ad(th3);
                        this.upstream.cancel();
                        int length4 = subscriberArr.length;
                        while (i4 < length4) {
                            subscriberArr[i4].onError(th3);
                            i4++;
                        }
                        return;
                    }
                }
                i2++;
                if (i2 == length) {
                    i2 = 0;
                    continue;
                }
                if (i5 == length) {
                    int i6 = get();
                    if (i6 == i3) {
                        this.index = i2;
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        i3 = i6;
                    }
                }
            }
            simpleQueue.clear();
            return;
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (this.sourceMode != 0 || this.queue.offer(t)) {
            drain();
            return;
        }
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?"));
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    setupSubscribers();
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    setupSubscribers();
                    subscription.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            setupSubscribers();
            subscription.request((long) this.prefetch);
        }
    }

    public void setupSubscribers() {
        Subscriber<? super T>[] subscriberArr = this.subscribers;
        int length = subscriberArr.length;
        int i2 = 0;
        while (i2 < length && !this.cancelled) {
            int i3 = i2 + 1;
            this.subscriberCount.lazySet(i3);
            subscriberArr[i2].onSubscribe(new qw(i2, length));
            i2 = i3;
        }
    }
}
