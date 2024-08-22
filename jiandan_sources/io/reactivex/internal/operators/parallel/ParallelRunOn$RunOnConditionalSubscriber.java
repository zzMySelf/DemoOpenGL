package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;
import th.de.th;

public final class ParallelRunOn$RunOnConditionalSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    public static final long serialVersionUID = 1075119423897941642L;
    public final ConditionalSubscriber<? super T> downstream;

    public ParallelRunOn$RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i2, SpscArrayQueue<T> spscArrayQueue, th.de deVar) {
        super(i2, spscArrayQueue, deVar);
        this.downstream = conditionalSubscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request((long) this.prefetch);
        }
    }

    public void run() {
        int i2;
        Throwable th2;
        int i3 = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
        int i4 = this.limit;
        int i5 = 1;
        while (true) {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                } else {
                    boolean z = this.done;
                    if (!z || (th2 = this.error) == null) {
                        T poll = spscArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            if (conditionalSubscriber.tryOnNext(poll)) {
                                j2++;
                            }
                            i3++;
                            if (i3 == i4) {
                                this.upstream.request((long) i3);
                                i3 = 0;
                            }
                        }
                    } else {
                        spscArrayQueue.clear();
                        conditionalSubscriber.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (i2 == 0) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                } else if (this.done) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        spscArrayQueue.clear();
                        conditionalSubscriber.onError(th3);
                        this.worker.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        conditionalSubscriber.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                this.requested.addAndGet(-j2);
            }
            int i6 = get();
            if (i6 == i5) {
                this.consumed = i3;
                i5 = addAndGet(-i5);
                if (i5 == 0) {
                    return;
                }
            } else {
                i5 = i6;
            }
        }
    }
}
