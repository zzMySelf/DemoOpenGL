package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.ppp.qw;

public final class FlowableMergeWithMaybe$MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    public static final int OTHER_STATE_HAS_VALUE = 1;
    public static final long serialVersionUID = -4592979584110982903L;
    public volatile boolean cancelled;
    public int consumed;
    public final Subscriber<? super T> downstream;
    public long emitted;
    public final AtomicThrowable error = new AtomicThrowable();
    public final int limit;
    public volatile boolean mainDone;
    public final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
    public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
    public volatile int otherState;
    public final int prefetch;
    public volatile SimplePlainQueue<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public T singleItem;

    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        public static final long serialVersionUID = -2935427570954647017L;
        public final FlowableMergeWithMaybe$MergeWithObserver<T> parent;

        public OtherObserver(FlowableMergeWithMaybe$MergeWithObserver<T> flowableMergeWithMaybe$MergeWithObserver) {
            this.parent = flowableMergeWithMaybe$MergeWithObserver;
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

    public FlowableMergeWithMaybe$MergeWithObserver(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
        int qw = ad.qw();
        this.prefetch = qw;
        this.limit = qw - (qw >> 2);
    }

    public void cancel() {
        this.cancelled = true;
        SubscriptionHelper.cancel(this.mainSubscription);
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
        int i2;
        Subscriber<? super T> subscriber = this.downstream;
        long j = this.emitted;
        int i3 = this.consumed;
        int i4 = this.limit;
        int i5 = 1;
        int i6 = 1;
        while (true) {
            long j2 = this.requested.get();
            while (true) {
                i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    this.singleItem = null;
                    this.queue = null;
                    return;
                } else if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    subscriber.onError(this.error.terminate());
                    return;
                } else {
                    int i7 = this.otherState;
                    if (i7 == i5) {
                        T t = this.singleItem;
                        this.singleItem = null;
                        this.otherState = 2;
                        subscriber.onNext(t);
                        j++;
                    } else {
                        boolean z = this.mainDone;
                        SimplePlainQueue<T> simplePlainQueue = this.queue;
                        T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                        boolean z2 = poll == null;
                        if (z && z2 && i7 == 2) {
                            this.queue = null;
                            subscriber.onComplete();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext(poll);
                            j++;
                            i3++;
                            if (i3 == i4) {
                                this.mainSubscription.get().request((long) i4);
                                i3 = 0;
                            }
                            i5 = 1;
                        }
                    }
                }
            }
            if (i2 == 0) {
                if (this.cancelled) {
                    this.singleItem = null;
                    this.queue = null;
                    return;
                } else if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    subscriber.onError(this.error.terminate());
                    return;
                } else {
                    boolean z3 = this.mainDone;
                    SimplePlainQueue<T> simplePlainQueue2 = this.queue;
                    boolean z4 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                    if (z3 && z4 && this.otherState == 2) {
                        this.queue = null;
                        subscriber.onComplete();
                        return;
                    }
                }
            }
            this.emitted = j;
            this.consumed = i3;
            i6 = addAndGet(-i6);
            if (i6 != 0) {
                i5 = 1;
            } else {
                return;
            }
        }
    }

    public SimplePlainQueue<T> getOrCreateQueue() {
        SimplePlainQueue<T> simplePlainQueue = this.queue;
        if (simplePlainQueue != null) {
            return simplePlainQueue;
        }
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(ad.qw());
        this.queue = spscArrayQueue;
        return spscArrayQueue;
    }

    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.error.addThrowable(th2)) {
            SubscriptionHelper.cancel(this.mainSubscription);
            drain();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        if (compareAndSet(0, 1)) {
            long j = this.emitted;
            if (this.requested.get() != j) {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                    this.emitted = j + 1;
                    this.downstream.onNext(t);
                    int i2 = this.consumed + 1;
                    if (i2 == this.limit) {
                        this.consumed = 0;
                        this.mainSubscription.get().request((long) i2);
                    } else {
                        this.consumed = i2;
                    }
                } else {
                    simplePlainQueue.offer(t);
                }
            } else {
                getOrCreateQueue().offer(t);
            }
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

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.mainSubscription, subscription, (long) this.prefetch);
    }

    public void otherComplete() {
        this.otherState = 2;
        drain();
    }

    public void otherError(Throwable th2) {
        if (this.error.addThrowable(th2)) {
            SubscriptionHelper.cancel(this.mainSubscription);
            drain();
            return;
        }
        qw.ddd(th2);
    }

    public void otherSuccess(T t) {
        if (compareAndSet(0, 1)) {
            long j = this.emitted;
            if (this.requested.get() != j) {
                this.emitted = j + 1;
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        } else {
            this.singleItem = t;
            this.otherState = 1;
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public void request(long j) {
        th.de.p039if.yj.qw.qw(this.requested, j);
        drain();
    }
}
