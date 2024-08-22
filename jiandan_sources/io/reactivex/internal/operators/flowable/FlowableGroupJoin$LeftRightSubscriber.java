package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.yj;

public final class FlowableGroupJoin$LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
    public static final long serialVersionUID = 1883890389173668373L;
    public final boolean isLeft;
    public final yj parent;

    public FlowableGroupJoin$LeftRightSubscriber(yj yjVar, boolean z) {
        this.parent = yjVar;
        this.isLeft = z;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(th2);
    }

    public void onNext(Object obj) {
        this.parent.innerValue(this.isLeft, obj);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
