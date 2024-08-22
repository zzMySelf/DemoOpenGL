package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.rg.qw;

public final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
    public static final long serialVersionUID = -4255299542215038287L;
    public volatile boolean cancelled;
    public volatile InnerQueuedSubscriber<R> current;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;
    public final AtomicLong requested = new AtomicLong();
    public final qw<InnerQueuedSubscriber<R>> subscribers;
    public Subscription upstream;

    public FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode2) {
        this.downstream = subscriber;
        this.mapper = function;
        this.maxConcurrency = i2;
        this.prefetch = i3;
        this.errorMode = errorMode2;
        this.subscribers = new qw<>(Math.min(i3, i2));
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            drainAndCancel();
        }
    }

    public void cancelAll() {
        InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
        this.current = null;
        if (innerQueuedSubscriber != null) {
            innerQueuedSubscriber.cancel();
        }
        while (true) {
            InnerQueuedSubscriber poll = this.subscribers.poll();
            if (poll != null) {
                poll.cancel();
            } else {
                return;
            }
        }
    }

    public void drain() {
        InnerQueuedSubscriber<R> innerQueuedSubscriber;
        int i2;
        long j;
        boolean z;
        SimpleQueue<R> queue;
        int i3;
        if (getAndIncrement() == 0) {
            InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
            Subscriber<? super R> subscriber = this.downstream;
            ErrorMode errorMode2 = this.errorMode;
            int i4 = 1;
            while (true) {
                long j2 = this.requested.get();
                if (innerQueuedSubscriber2 != null) {
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                } else if (errorMode2 == ErrorMode.END || ((Throwable) this.errors.get()) == null) {
                    boolean z2 = this.done;
                    innerQueuedSubscriber = this.subscribers.poll();
                    if (z2 && innerQueuedSubscriber == null) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else if (innerQueuedSubscriber != null) {
                        this.current = innerQueuedSubscriber;
                    }
                } else {
                    cancelAll();
                    subscriber.onError(this.errors.terminate());
                    return;
                }
                if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                    i2 = i4;
                    j = 0;
                    z = false;
                } else {
                    i2 = i4;
                    j = 0;
                    while (true) {
                        i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        } else if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                            boolean isDone = innerQueuedSubscriber.isDone();
                            try {
                                R poll = queue.poll();
                                boolean z3 = poll == null;
                                if (isDone && z3) {
                                    this.current = null;
                                    this.upstream.request(1);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                    break;
                                } else if (z3) {
                                    break;
                                } else {
                                    subscriber.onNext(poll);
                                    j++;
                                    innerQueuedSubscriber.requestOne();
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                th.de.o.qw.ad(th3);
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                subscriber.onError(th3);
                                return;
                            }
                        } else {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            subscriber.onError(this.errors.terminate());
                            return;
                        }
                    }
                    z = false;
                    if (i3 == 0) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                            boolean isDone2 = innerQueuedSubscriber.isDone();
                            boolean isEmpty = queue.isEmpty();
                            if (isDone2 && isEmpty) {
                                this.current = null;
                                this.upstream.request(1);
                                innerQueuedSubscriber = null;
                                z = true;
                            }
                        } else {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            subscriber.onError(this.errors.terminate());
                            return;
                        }
                    }
                }
                if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                    this.requested.addAndGet(-j);
                }
                if (z) {
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                    i4 = i2;
                } else {
                    i4 = addAndGet(-i2);
                    if (i4 != 0) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void drainAndCancel() {
        if (getAndIncrement() == 0) {
            do {
                cancelAll();
            } while (decrementAndGet() != 0);
        }
    }

    public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        drain();
    }

    public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            innerQueuedSubscriber.setDone();
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
        if (innerQueuedSubscriber.queue().offer(r)) {
            drain();
            return;
        }
        innerQueuedSubscriber.cancel();
        innerError(innerQueuedSubscriber, new MissingBackpressureException());
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            this.done = true;
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onNext(T t) {
        try {
            Object apply = this.mapper.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.prefetch);
            if (!this.cancelled) {
                this.subscribers.offer(innerQueuedSubscriber);
                publisher.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    drainAndCancel();
                }
            }
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.upstream.cancel();
            onError(th2);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            int i2 = this.maxConcurrency;
            subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }
}
