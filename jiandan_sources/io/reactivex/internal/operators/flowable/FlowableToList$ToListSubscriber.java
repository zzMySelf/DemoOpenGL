package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscription;

public final class FlowableToList$ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -8134157938864266736L;
    public Subscription upstream;

    /* JADX WARNING: type inference failed for: r2v0, types: [T, U] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowableToList$ToListSubscriber(org.reactivestreams.Subscriber<? super U> r1, U r2) {
        /*
            r0 = this;
            r0.<init>(r1)
            r0.value = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableToList$ToListSubscriber.<init>(org.reactivestreams.Subscriber, java.util.Collection):void");
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        complete(this.value);
    }

    public void onError(Throwable th2) {
        this.value = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        Collection collection = (Collection) this.value;
        if (collection != null) {
            collection.add(t);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
