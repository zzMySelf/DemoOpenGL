package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.yj;

public final class FlowableGroupJoin$LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
    public static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final yj parent;

    public FlowableGroupJoin$LeftRightEndSubscriber(yj yjVar, boolean z, int i2) {
        this.parent = yjVar;
        this.isLeft = z;
        this.index = i2;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.parent.innerClose(this.isLeft, this);
    }

    public void onError(Throwable th2) {
        this.parent.innerCloseError(th2);
    }

    public void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            this.parent.innerClose(this.isLeft, this);
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
