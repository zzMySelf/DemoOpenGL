package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.o.qw;

public final class CompletableConcat$CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
    public static final long serialVersionUID = 9032184911934499404L;
    public volatile boolean active;
    public int consumed;
    public volatile boolean done;
    public final CompletableObserver downstream;
    public final ConcatInnerObserver inner = new ConcatInnerObserver(this);
    public final int limit;
    public final AtomicBoolean once = new AtomicBoolean();
    public final int prefetch;
    public SimpleQueue<CompletableSource> queue;
    public int sourceFused;
    public Subscription upstream;

    public static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
        public static final long serialVersionUID = -5454794857847146511L;
        public final CompletableConcat$CompletableConcatSubscriber parent;

        public ConcatInnerObserver(CompletableConcat$CompletableConcatSubscriber completableConcat$CompletableConcatSubscriber) {
            this.parent = completableConcat$CompletableConcatSubscriber;
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

    public CompletableConcat$CompletableConcatSubscriber(CompletableObserver completableObserver, int i2) {
        this.downstream = completableObserver;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.inner);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            while (!isDisposed()) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        CompletableSource poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (!z || !z2) {
                            if (!z2) {
                                this.active = true;
                                poll.qw(this.inner);
                                request();
                            }
                        } else if (this.once.compareAndSet(false, true)) {
                            this.downstream.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        qw.ad(th2);
                        innerError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            this.upstream.cancel();
            this.downstream.onError(th2);
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.inner.get());
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose(this.inner);
            this.downstream.onError(th2);
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            int i2 = this.prefetch;
            long j = i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceFused = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceFused = requestFusion;
                    this.queue = queueSubscription;
                    this.downstream.onSubscribe(this);
                    subscription.request(j);
                    return;
                }
            }
            if (this.prefetch == Integer.MAX_VALUE) {
                this.queue = new th.de.p039if.rg.qw(ad.qw());
            } else {
                this.queue = new SpscArrayQueue(this.prefetch);
            }
            this.downstream.onSubscribe(this);
            subscription.request(j);
        }
    }

    public void request() {
        if (this.sourceFused != 1) {
            int i2 = this.consumed + 1;
            if (i2 == this.limit) {
                this.consumed = 0;
                this.upstream.request((long) i2);
                return;
            }
            this.consumed = i2;
        }
    }

    public void onNext(CompletableSource completableSource) {
        if (this.sourceFused != 0 || this.queue.offer(completableSource)) {
            drain();
        } else {
            onError(new MissingBackpressureException());
        }
    }
}
