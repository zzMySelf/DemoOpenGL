package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.p039if.fe.ad.qw;

public final class FlowableOnBackpressureDrop<T> extends qw<T, T> implements Consumer<T> {

    /* renamed from: yj  reason: collision with root package name */
    public final Consumer<? super T> f9990yj = this;

    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -6246093802440953054L;
        public boolean done;
        public final Subscriber<? super T> downstream;
        public final Consumer<? super T> onDrop;
        public Subscription upstream;

        public BackpressureDropSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.downstream = subscriber;
            this.onDrop = consumer;
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
                try {
                    this.onDrop.accept(t);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    cancel();
                    onError(th2);
                }
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

    public FlowableOnBackpressureDrop(ad<T> adVar) {
        super(adVar);
    }

    public void accept(T t) {
    }

    public void yj(Subscriber<? super T> subscriber) {
        this.f10499th.th(new BackpressureDropSubscriber(subscriber, this.f9990yj));
    }
}
