package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.th;

public final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 1015244841293359600L;
    public final Subscriber<? super T> downstream;
    public final th scheduler;
    public Subscription upstream;

    public final class qw implements Runnable {
        public qw() {
        }

        public void run() {
            FlowableUnsubscribeOn$UnsubscribeSubscriber.this.upstream.cancel();
        }
    }

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(Subscriber<? super T> subscriber, th thVar) {
        this.downstream = subscriber;
        this.scheduler = thVar;
    }

    public void cancel() {
        if (compareAndSet(false, true)) {
            this.scheduler.de(new qw());
        }
    }

    public void onComplete() {
        if (!get()) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (get()) {
            th.de.ppp.qw.ddd(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    public void onNext(T t) {
        if (!get()) {
            this.downstream.onNext(t);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        this.upstream.request(j);
    }
}
