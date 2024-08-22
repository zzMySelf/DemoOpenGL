package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.o.qw;

public final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
    public static final long serialVersionUID = -2434867452883857743L;
    public volatile boolean cancelled;
    public final Object[] current;
    public final boolean delayErrors;
    public final Subscriber<? super R> downstream;
    public final AtomicThrowable errors;
    public final AtomicLong requested;
    public final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    public final Function<? super Object[], ? extends R> zipper;

    public FlowableZip$ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
        this.downstream = subscriber;
        this.zipper = function;
        this.delayErrors = z;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = new FlowableZip$ZipSubscriber[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            flowableZip$ZipSubscriberArr[i4] = new FlowableZip$ZipSubscriber<>(this, i3);
        }
        this.current = new Object[i2];
        this.subscribers = flowableZip$ZipSubscriberArr;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
        }
    }

    public void cancelAll() {
        for (FlowableZip$ZipSubscriber<T, R> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void drain() {
        int i2;
        if (getAndIncrement() == 0) {
            Subscriber<? super R> subscriber = this.downstream;
            FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
            int length = flowableZip$ZipSubscriberArr.length;
            Object[] objArr = this.current;
            int i3 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (!this.cancelled) {
                        if (this.delayErrors || this.errors.get() == null) {
                            boolean z = false;
                            for (int i4 = 0; i4 < length; i4++) {
                                FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber = flowableZip$ZipSubscriberArr[i4];
                                if (objArr[i4] == null) {
                                    try {
                                        boolean z2 = flowableZip$ZipSubscriber.done;
                                        SimpleQueue<T> simpleQueue = flowableZip$ZipSubscriber.queue;
                                        T poll = simpleQueue != null ? simpleQueue.poll() : null;
                                        boolean z3 = poll == null;
                                        if (!z2 || !z3) {
                                            if (!z3) {
                                                objArr[i4] = poll;
                                            }
                                            z = true;
                                        } else {
                                            cancelAll();
                                            if (((Throwable) this.errors.get()) != null) {
                                                subscriber.onError(this.errors.terminate());
                                                return;
                                            } else {
                                                subscriber.onComplete();
                                                return;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        qw.ad(th2);
                                        this.errors.addThrowable(th2);
                                        if (!this.delayErrors) {
                                            cancelAll();
                                            subscriber.onError(this.errors.terminate());
                                            return;
                                        }
                                    }
                                }
                            }
                            if (z) {
                                break;
                            }
                            try {
                                Object apply = this.zipper.apply(objArr.clone());
                                th.de.p039if.ad.qw.rg(apply, "The zipper returned a null value");
                                subscriber.onNext(apply);
                                j2++;
                                Arrays.fill(objArr, (Object) null);
                            } catch (Throwable th3) {
                                qw.ad(th3);
                                cancelAll();
                                this.errors.addThrowable(th3);
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                        } else {
                            cancelAll();
                            subscriber.onError(this.errors.terminate());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    if (!this.cancelled) {
                        if (this.delayErrors || this.errors.get() == null) {
                            for (int i5 = 0; i5 < length; i5++) {
                                FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber2 = flowableZip$ZipSubscriberArr[i5];
                                if (objArr[i5] == null) {
                                    try {
                                        boolean z4 = flowableZip$ZipSubscriber2.done;
                                        SimpleQueue<T> simpleQueue2 = flowableZip$ZipSubscriber2.queue;
                                        T poll2 = simpleQueue2 != null ? simpleQueue2.poll() : null;
                                        boolean z5 = poll2 == null;
                                        if (z4 && z5) {
                                            cancelAll();
                                            if (((Throwable) this.errors.get()) != null) {
                                                subscriber.onError(this.errors.terminate());
                                                return;
                                            } else {
                                                subscriber.onComplete();
                                                return;
                                            }
                                        } else if (!z5) {
                                            objArr[i5] = poll2;
                                        }
                                    } catch (Throwable th4) {
                                        qw.ad(th4);
                                        this.errors.addThrowable(th4);
                                        if (!this.delayErrors) {
                                            cancelAll();
                                            subscriber.onError(this.errors.terminate());
                                            return;
                                        }
                                    }
                                }
                            }
                        } else {
                            cancelAll();
                            subscriber.onError(this.errors.terminate());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j2 != 0) {
                    for (FlowableZip$ZipSubscriber<T, R> request : flowableZip$ZipSubscriberArr) {
                        request.request(j2);
                    }
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    public void error(FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber, Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            flowableZip$ZipSubscriber.done = true;
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }

    public void subscribe(Publisher<? extends T>[] publisherArr, int i2) {
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        int i3 = 0;
        while (i3 < i2 && !this.cancelled) {
            if (this.delayErrors || this.errors.get() == null) {
                publisherArr[i3].subscribe(flowableZip$ZipSubscriberArr[i3]);
                i3++;
            } else {
                return;
            }
        }
    }
}
