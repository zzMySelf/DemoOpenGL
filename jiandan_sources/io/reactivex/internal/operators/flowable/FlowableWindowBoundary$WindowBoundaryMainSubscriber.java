package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.p039if.fe.ad.vvv;
import th.de.ppp.qw;

public final class FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final Object NEXT_WINDOW = new Object();
    public static final long serialVersionUID = 2233020065421370272L;
    public final vvv<T, B> boundarySubscriber = new vvv<>(this);
    public final int capacityHint;
    public volatile boolean done;
    public final Subscriber<? super ad<T>> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicBoolean stopWindows = new AtomicBoolean();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();
    public UnicastProcessor<T> window;
    public final AtomicInteger windows = new AtomicInteger(1);

    public FlowableWindowBoundary$WindowBoundaryMainSubscriber(Subscriber<? super ad<T>> subscriber, int i2) {
        this.downstream = subscriber;
        this.capacityHint = i2;
    }

    public void cancel() {
        if (this.stopWindows.compareAndSet(false, true)) {
            this.boundarySubscriber.dispose();
            if (this.windows.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.upstream);
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            Subscriber<? super ad<T>> subscriber = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            long j = this.emitted;
            int i2 = 1;
            while (this.windows.get() != 0) {
                UnicastProcessor<T> unicastProcessor = this.window;
                boolean z = this.done;
                if (!z || atomicThrowable.get() == null) {
                    Object poll = mpscLinkedQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate == null) {
                            if (unicastProcessor != null) {
                                this.window = null;
                                unicastProcessor.onComplete();
                            }
                            subscriber.onComplete();
                            return;
                        }
                        if (unicastProcessor != null) {
                            this.window = null;
                            unicastProcessor.onError(terminate);
                        }
                        subscriber.onError(terminate);
                        return;
                    } else if (z2) {
                        this.emitted = j;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (poll != NEXT_WINDOW) {
                        unicastProcessor.onNext(poll);
                    } else {
                        if (unicastProcessor != null) {
                            this.window = null;
                            unicastProcessor.onComplete();
                        }
                        if (!this.stopWindows.get()) {
                            UnicastProcessor<T> o2 = UnicastProcessor.o(this.capacityHint, this);
                            this.window = o2;
                            this.windows.getAndIncrement();
                            if (j != this.requested.get()) {
                                j++;
                                subscriber.onNext(o2);
                            } else {
                                SubscriptionHelper.cancel(this.upstream);
                                this.boundarySubscriber.dispose();
                                atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                this.done = true;
                            }
                        }
                    }
                } else {
                    mpscLinkedQueue.clear();
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onError(terminate2);
                    }
                    subscriber.onError(terminate2);
                    return;
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }
    }

    public void innerComplete() {
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
    }

    public void innerError(Throwable th2) {
        SubscriptionHelper.cancel(this.upstream);
        if (this.errors.addThrowable(th2)) {
            this.done = true;
            drain();
            return;
        }
        qw.ddd(th2);
    }

    public void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    public void onComplete() {
        this.boundarySubscriber.dispose();
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.boundarySubscriber.dispose();
        if (this.errors.addThrowable(th2)) {
            this.done = true;
            drain();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        this.queue.offer(t);
        drain();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.upstream, subscription, Long.MAX_VALUE);
    }

    public void request(long j) {
        th.de.p039if.yj.qw.qw(this.requested, j);
    }

    public void run() {
        if (this.windows.decrementAndGet() == 0) {
            SubscriptionHelper.cancel(this.upstream);
        }
    }
}
