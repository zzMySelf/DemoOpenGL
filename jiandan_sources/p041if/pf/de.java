package p041if.pf;

import rx.Subscription;
import rx.internal.subscriptions.SequentialSubscription;

/* renamed from: if.pf.de  reason: invalid package */
public final class de implements Subscription {

    /* renamed from: ad  reason: collision with root package name */
    public final SequentialSubscription f11138ad = new SequentialSubscription();

    public boolean isUnsubscribed() {
        return this.f11138ad.isUnsubscribed();
    }

    public void qw(Subscription subscription) {
        if (subscription != null) {
            this.f11138ad.update(subscription);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    public void unsubscribe() {
        this.f11138ad.unsubscribe();
    }
}
