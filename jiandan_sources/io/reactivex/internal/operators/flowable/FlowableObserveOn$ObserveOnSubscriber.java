package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.o.qw;
import th.de.th;

public final class FlowableObserveOn$ObserveOnSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -4547113800637756442L;
    public final Subscriber<? super T> downstream;

    public FlowableObserveOn$ObserveOnSubscriber(Subscriber<? super T> subscriber, th.de deVar, boolean z, int i2) {
        super(deVar, z, i2);
        this.downstream = subscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = 1;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = 2;
                    this.queue = queueSubscription;
                    this.downstream.onSubscribe(this);
                    subscription.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            subscription.request((long) this.prefetch);
        }
    }

    public T poll() throws Exception {
        T poll = this.queue.poll();
        if (!(poll == null || this.sourceMode == 1)) {
            long j = this.produced + 1;
            if (j == ((long) this.limit)) {
                this.produced = 0;
                this.upstream.request(j);
            } else {
                this.produced = j;
            }
        }
        return poll;
    }

    public void runAsync() {
        int i2;
        Subscriber<? super T> subscriber = this.downstream;
        SimpleQueue<T> simpleQueue = this.queue;
        long j = this.produced;
        int i3 = 1;
        while (true) {
            long j2 = this.requested.get();
            while (true) {
                i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 == 0) {
                    break;
                }
                boolean z = this.done;
                try {
                    T poll = simpleQueue.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, subscriber)) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j++;
                        if (j == ((long) this.limit)) {
                            if (j2 != Long.MAX_VALUE) {
                                j2 = this.requested.addAndGet(-j);
                            }
                            this.upstream.request(j);
                            j = 0;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    qw.ad(th2);
                    this.cancelled = true;
                    this.upstream.cancel();
                    simpleQueue.clear();
                    subscriber.onError(th2);
                    this.worker.dispose();
                    return;
                }
            }
            if (i2 != 0 || !checkTerminated(this.done, simpleQueue.isEmpty(), subscriber)) {
                int i4 = get();
                if (i3 == i4) {
                    this.produced = j;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i4;
                }
            } else {
                return;
            }
        }
    }

    public void runBackfused() {
        int i2 = 1;
        while (!this.cancelled) {
            boolean z = this.done;
            this.downstream.onNext(null);
            if (z) {
                this.cancelled = true;
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.downstream.onError(th2);
                } else {
                    this.downstream.onComplete();
                }
                this.worker.dispose();
                return;
            }
            i2 = addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
    }

    public void runSync() {
        Subscriber<? super T> subscriber = this.downstream;
        SimpleQueue<T> simpleQueue = this.queue;
        long j = this.produced;
        int i2 = 1;
        while (true) {
            long j2 = this.requested.get();
            while (j != j2) {
                try {
                    T poll = simpleQueue.poll();
                    if (!this.cancelled) {
                        if (poll == null) {
                            this.cancelled = true;
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        subscriber.onNext(poll);
                        j++;
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    qw.ad(th2);
                    this.cancelled = true;
                    this.upstream.cancel();
                    subscriber.onError(th2);
                    this.worker.dispose();
                    return;
                }
            }
            if (!this.cancelled) {
                if (simpleQueue.isEmpty()) {
                    this.cancelled = true;
                    subscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            } else {
                return;
            }
        }
    }
}
