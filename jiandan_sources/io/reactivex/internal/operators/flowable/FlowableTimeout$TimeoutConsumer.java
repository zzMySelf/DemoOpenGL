package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.Cswitch;
import th.de.ppp.qw;

public final class FlowableTimeout$TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
    public static final long serialVersionUID = 8708641127342403073L;
    public final long idx;
    public final Cswitch parent;

    public FlowableTimeout$TimeoutConsumer(long j, Cswitch switchR) {
        this.idx = j;
        this.parent = switchR;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    public void onError(Throwable th2) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.onTimeoutError(this.idx, th2);
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(Object obj) {
        Subscription subscription = (Subscription) get();
        if (subscription != SubscriptionHelper.CANCELLED) {
            subscription.cancel();
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.onTimeout(this.idx);
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
