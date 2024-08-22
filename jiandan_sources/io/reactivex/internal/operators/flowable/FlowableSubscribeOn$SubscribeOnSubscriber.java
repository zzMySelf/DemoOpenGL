package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.th;

public final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final long serialVersionUID = 8094547886072529208L;
    public final Subscriber<? super T> downstream;
    public final boolean nonScheduledRequests;
    public final AtomicLong requested = new AtomicLong();
    public Publisher<T> source;
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();
    public final th.de worker;

    public static final class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final Subscription f9992ad;

        /* renamed from: th  reason: collision with root package name */
        public final long f9993th;

        public qw(Subscription subscription, long j) {
            this.f9992ad = subscription;
            this.f9993th = j;
        }

        public void run() {
            this.f9992ad.request(this.f9993th);
        }
    }

    public FlowableSubscribeOn$SubscribeOnSubscriber(Subscriber<? super T> subscriber, th.de deVar, Publisher<T> publisher, boolean z) {
        this.downstream = subscriber;
        this.worker = deVar;
        this.source = publisher;
        this.nonScheduledRequests = !z;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            long andSet = this.requested.getAndSet(0);
            if (andSet != 0) {
                requestUpstream(andSet, subscription);
            }
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            Subscription subscription = this.upstream.get();
            if (subscription != null) {
                requestUpstream(j, subscription);
                return;
            }
            th.de.p039if.yj.qw.qw(this.requested, j);
            Subscription subscription2 = this.upstream.get();
            if (subscription2 != null) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    requestUpstream(andSet, subscription2);
                }
            }
        }
    }

    public void requestUpstream(long j, Subscription subscription) {
        if (this.nonScheduledRequests || Thread.currentThread() == get()) {
            subscription.request(j);
        } else {
            this.worker.ad(new qw(subscription, j));
        }
    }

    public void run() {
        lazySet(Thread.currentThread());
        Publisher<T> publisher = this.source;
        this.source = null;
        publisher.subscribe(this);
    }
}
