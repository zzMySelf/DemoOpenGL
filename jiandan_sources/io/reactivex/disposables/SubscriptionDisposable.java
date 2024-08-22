package io.reactivex.disposables;

import org.reactivestreams.Subscription;

public final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    public static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(Subscription subscription) {
        super(subscription);
    }

    public void onDisposed(Subscription subscription) {
        subscription.cancel();
    }
}
