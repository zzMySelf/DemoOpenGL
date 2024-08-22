package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher$OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
    public static final long serialVersionUID = -1215060610805418006L;
    public final MaybeObserver<? super T> downstream;
    public Throwable error;
    public T value;

    public MaybeDelayOtherPublisher$OtherSubscriber(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void onComplete() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.downstream.onError(th2);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        Throwable th3 = this.error;
        if (th3 == null) {
            this.downstream.onError(th2);
            return;
        }
        this.downstream.onError(new CompositeException(th3, th2));
    }

    public void onNext(Object obj) {
        Subscription subscription = (Subscription) get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            subscription.cancel();
            onComplete();
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
