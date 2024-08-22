package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.p039if.yj.qw;

public final class FlowableWindow$WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final long serialVersionUID = -8792836352386833856L;
    public final int bufferSize;
    public final Subscriber<? super ad<T>> downstream;
    public final AtomicBoolean firstRequest = new AtomicBoolean();
    public long index;
    public final AtomicBoolean once = new AtomicBoolean();
    public final long size;
    public final long skip;
    public Subscription upstream;
    public UnicastProcessor<T> window;

    public FlowableWindow$WindowSkipSubscriber(Subscriber<? super ad<T>> subscriber, long j, long j2, int i2) {
        super(1);
        this.downstream = subscriber;
        this.size = j;
        this.skip = j2;
        this.bufferSize = i2;
    }

    public void cancel() {
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    public void onComplete() {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onError(th2);
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        long j = this.index;
        UnicastProcessor<T> unicastProcessor = this.window;
        if (j == 0) {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.o(this.bufferSize, this);
            this.window = unicastProcessor;
            this.downstream.onNext(unicastProcessor);
        }
        long j2 = j + 1;
        if (unicastProcessor != null) {
            unicastProcessor.onNext(t);
        }
        if (j2 == this.size) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        if (j2 == this.skip) {
            this.index = 0;
        } else {
            this.index = j2;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
            this.upstream.request(qw.fe(this.skip, j));
            return;
        }
        this.upstream.request(qw.de(qw.fe(this.size, j), qw.fe(this.skip - this.size, j - 1)));
    }

    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
