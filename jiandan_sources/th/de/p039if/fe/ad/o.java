package th.de.p039if.fe.ad;

import io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription;

/* renamed from: th.de.if.fe.ad.o  reason: invalid package */
public interface o<T> {
    void complete();

    void error(Throwable th2);

    void next(T t);

    void replay(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription);
}
