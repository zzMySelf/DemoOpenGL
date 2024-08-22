package th.de.p039if.fe.ad;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* renamed from: th.de.if.fe.ad.when  reason: invalid package */
public final class when<T> implements FlowableSubscriber<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Subscriber<? super T> f10506ad;

    /* renamed from: th  reason: collision with root package name */
    public final SubscriptionArbiter f10507th;

    public when(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
        this.f10506ad = subscriber;
        this.f10507th = subscriptionArbiter;
    }

    public void onComplete() {
        this.f10506ad.onComplete();
    }

    public void onError(Throwable th2) {
        this.f10506ad.onError(th2);
    }

    public void onNext(T t) {
        this.f10506ad.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        this.f10507th.setSubscription(subscription);
    }
}
