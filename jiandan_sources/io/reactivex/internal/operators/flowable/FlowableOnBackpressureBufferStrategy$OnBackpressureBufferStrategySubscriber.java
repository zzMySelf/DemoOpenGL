package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.uk;
import th.de.p039if.yj.qw;

public final class FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 3240706908776709697L;
    public final long bufferSize;
    public volatile boolean cancelled;
    public final Deque<T> deque = new ArrayDeque();
    public volatile boolean done;
    public final Subscriber<? super T> downstream;
    public Throwable error;
    public final Action onOverflow;
    public final AtomicLong requested = new AtomicLong();
    public final BackpressureOverflowStrategy strategy;
    public Subscription upstream;

    public FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
        this.downstream = subscriber;
        this.onOverflow = action;
        this.strategy = backpressureOverflowStrategy;
        this.bufferSize = j;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() == 0) {
            clear(this.deque);
        }
    }

    public void clear(Deque<T> deque2) {
        synchronized (deque2) {
            deque2.clear();
        }
    }

    public void drain() {
        int i2;
        boolean isEmpty;
        T poll;
        if (getAndIncrement() == 0) {
            Deque<T> deque2 = this.deque;
            Subscriber<? super T> subscriber = this.downstream;
            int i3 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.cancelled) {
                        clear(deque2);
                        return;
                    } else {
                        boolean z = this.done;
                        synchronized (deque2) {
                            poll = deque2.poll();
                        }
                        boolean z2 = poll == null;
                        if (z) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                clear(deque2);
                                subscriber.onError(th2);
                                return;
                            } else if (z2) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                    }
                }
                if (i2 == 0) {
                    if (this.cancelled) {
                        clear(deque2);
                        return;
                    }
                    boolean z3 = this.done;
                    synchronized (deque2) {
                        isEmpty = deque2.isEmpty();
                    }
                    if (z3) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            clear(deque2);
                            subscriber.onError(th3);
                            return;
                        } else if (isEmpty) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    qw.rg(this.requested, j2);
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.done) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        boolean z;
        boolean z2;
        if (!this.done) {
            Deque<T> deque2 = this.deque;
            synchronized (deque2) {
                z = false;
                z2 = true;
                if (((long) deque2.size()) == this.bufferSize) {
                    int i2 = uk.qw[this.strategy.ordinal()];
                    if (i2 == 1) {
                        deque2.pollLast();
                        deque2.offer(t);
                    } else if (i2 == 2) {
                        deque2.poll();
                        deque2.offer(t);
                    }
                    z = true;
                } else {
                    deque2.offer(t);
                }
                z2 = false;
            }
            if (z) {
                Action action = this.onOverflow;
                if (action != null) {
                    try {
                        action.run();
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        this.upstream.cancel();
                        onError(th2);
                    }
                }
            } else if (z2) {
                this.upstream.cancel();
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this.requested, j);
            drain();
        }
    }
}
