package th.de.ddd;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.fe;

public abstract class qw<T> implements FlowableSubscriber<T>, Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Subscription> f10461ad = new AtomicReference<>();

    public void ad() {
        this.f10461ad.get().request(Long.MAX_VALUE);
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.f10461ad);
    }

    public final boolean isDisposed() {
        return this.f10461ad.get() == SubscriptionHelper.CANCELLED;
    }

    public final void onSubscribe(Subscription subscription) {
        if (fe.fe(this.f10461ad, subscription, getClass())) {
            ad();
        }
    }

    public final void qw() {
        dispose();
    }
}
