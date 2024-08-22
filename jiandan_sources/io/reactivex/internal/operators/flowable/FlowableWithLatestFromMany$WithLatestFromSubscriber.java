package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.rg;
import th.de.ppp.qw;

public final class FlowableWithLatestFromMany$WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
    public static final long serialVersionUID = 1577321883966341961L;
    public final Function<? super Object[], R> combiner;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public final AtomicThrowable error;
    public final AtomicLong requested;
    public final FlowableWithLatestFromMany$WithLatestInnerSubscriber[] subscribers;
    public final AtomicReference<Subscription> upstream;
    public final AtomicReferenceArray<Object> values;

    public FlowableWithLatestFromMany$WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i2) {
        this.downstream = subscriber;
        this.combiner = function;
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = new FlowableWithLatestFromMany$WithLatestInnerSubscriber[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i3] = new FlowableWithLatestFromMany$WithLatestInnerSubscriber(this, i3);
        }
        this.subscribers = flowableWithLatestFromMany$WithLatestInnerSubscriberArr;
        this.values = new AtomicReferenceArray<>(i2);
        this.upstream = new AtomicReference<>();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        for (FlowableWithLatestFromMany$WithLatestInnerSubscriber dispose : this.subscribers) {
            dispose.dispose();
        }
    }

    public void cancelAllBut(int i2) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        for (int i3 = 0; i3 < flowableWithLatestFromMany$WithLatestInnerSubscriberArr.length; i3++) {
            if (i3 != i2) {
                flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i3].dispose();
            }
        }
    }

    public void innerComplete(int i2, boolean z) {
        if (!z) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(i2);
            rg.ad(this.downstream, this, this.error);
        }
    }

    public void innerError(int i2, Throwable th2) {
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        cancelAllBut(i2);
        rg.fe(this.downstream, th2, this, this.error);
    }

    public void innerNext(int i2, Object obj) {
        this.values.set(i2, obj);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            cancelAllBut(-1);
            rg.ad(this.downstream, this, this.error);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        rg.fe(this.downstream, th2, this, this.error);
    }

    public void onNext(T t) {
        if (!tryOnNext(t) && !this.done) {
            this.upstream.get().request(1);
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }

    public void subscribe(Publisher<?>[] publisherArr, int i2) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        AtomicReference<Subscription> atomicReference = this.upstream;
        for (int i3 = 0; i3 < i2 && atomicReference.get() != SubscriptionHelper.CANCELLED; i3++) {
            publisherArr[i3].subscribe(flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i3]);
        }
    }

    public boolean tryOnNext(T t) {
        if (this.done) {
            return false;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[(length + 1)];
        objArr[0] = t;
        int i2 = 0;
        while (i2 < length) {
            Object obj = atomicReferenceArray.get(i2);
            if (obj == null) {
                return false;
            }
            i2++;
            objArr[i2] = obj;
        }
        try {
            R apply = this.combiner.apply(objArr);
            th.de.p039if.ad.qw.rg(apply, "The combiner returned a null value");
            rg.th(this.downstream, apply, this, this.error);
            return true;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            cancel();
            onError(th2);
            return false;
        }
    }
}
