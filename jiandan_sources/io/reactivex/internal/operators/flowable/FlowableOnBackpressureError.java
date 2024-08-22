package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.p039if.fe.ad.qw;

public final class FlowableOnBackpressureError<T> extends qw<T, T> {

    public static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -3176480756392482682L;
        public boolean done;
        public final Subscriber<? super T> downstream;
        public Subscription upstream;

        public BackpressureErrorSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            if (!this.done) {
                if (get() != 0) {
                    this.downstream.onNext(t);
                    th.de.p039if.yj.qw.rg(this, 1);
                    return;
                }
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                th.de.p039if.yj.qw.qw(this, j);
            }
        }
    }

    public FlowableOnBackpressureError(ad<T> adVar) {
        super(adVar);
    }

    public void yj(Subscriber<? super T> subscriber) {
        this.f10499th.th(new BackpressureErrorSubscriber(subscriber));
    }
}
