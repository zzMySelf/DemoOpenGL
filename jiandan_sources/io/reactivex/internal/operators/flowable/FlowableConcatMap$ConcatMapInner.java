package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.de;

public final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
    public static final long serialVersionUID = 897683679971470653L;
    public final de<R> parent;
    public long produced;

    public FlowableConcatMap$ConcatMapInner(de<R> deVar) {
        super(false);
        this.parent = deVar;
    }

    public void onComplete() {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0;
            produced(j);
        }
        this.parent.innerComplete();
    }

    public void onError(Throwable th2) {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0;
            produced(j);
        }
        this.parent.innerError(th2);
    }

    public void onNext(R r) {
        this.produced++;
        this.parent.innerNext(r);
    }

    public void onSubscribe(Subscription subscription) {
        setSubscription(subscription);
    }
}
