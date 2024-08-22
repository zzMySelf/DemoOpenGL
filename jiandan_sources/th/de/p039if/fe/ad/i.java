package th.de.p039if.fe.ad;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription;
import th.de.ad;

/* renamed from: th.de.if.fe.ad.i  reason: invalid package */
public final class i<T> extends ad<T> implements FlowableSubscriber<T>, Disposable {
    public abstract void i(FlowablePublishMulticast$MulticastSubscription<T> flowablePublishMulticast$MulticastSubscription);

    public abstract void uk();
}
