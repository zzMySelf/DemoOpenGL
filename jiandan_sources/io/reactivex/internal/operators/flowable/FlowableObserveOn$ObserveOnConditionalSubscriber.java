package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;
import th.de.o.qw;
import th.de.th;

public final class FlowableObserveOn$ObserveOnConditionalSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    public static final long serialVersionUID = 644624475404284533L;
    public long consumed;
    public final ConditionalSubscriber<? super T> downstream;

    public FlowableObserveOn$ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, th.de deVar, boolean z, int i2) {
        super(deVar, z, i2);
        this.downstream = conditionalSubscriber;
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
            long j = this.consumed + 1;
            if (j == ((long) this.limit)) {
                this.consumed = 0;
                this.upstream.request(j);
            } else {
                this.consumed = j;
            }
        }
        return poll;
    }

    public void runAsync() {
        int i2;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
        SimpleQueue<T> simpleQueue = this.queue;
        long j = this.produced;
        long j2 = this.consumed;
        int i3 = 1;
        while (true) {
            long j3 = this.requested.get();
            while (true) {
                i2 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
                if (i2 == 0) {
                    break;
                }
                boolean z = this.done;
                try {
                    T poll = simpleQueue.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, conditionalSubscriber)) {
                        if (z2) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j++;
                        }
                        j2++;
                        if (j2 == ((long) this.limit)) {
                            this.upstream.request(j2);
                            j2 = 0;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    qw.ad(th2);
                    this.cancelled = true;
                    this.upstream.cancel();
                    simpleQueue.clear();
                    conditionalSubscriber.onError(th2);
                    this.worker.dispose();
                    return;
                }
            }
            if (i2 != 0 || !checkTerminated(this.done, simpleQueue.isEmpty(), conditionalSubscriber)) {
                int i4 = get();
                if (i3 == i4) {
                    this.produced = j;
                    this.consumed = j2;
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
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
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
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (conditionalSubscriber.tryOnNext(poll)) {
                            j++;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    qw.ad(th2);
                    this.cancelled = true;
                    this.upstream.cancel();
                    conditionalSubscriber.onError(th2);
                    this.worker.dispose();
                    return;
                }
            }
            if (!this.cancelled) {
                if (simpleQueue.isEmpty()) {
                    this.cancelled = true;
                    conditionalSubscriber.onComplete();
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
