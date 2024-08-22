package th.de.p039if.fe.ad;

import io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$State;
import org.reactivestreams.Subscriber;
import th.de.pf.ad;

/* renamed from: th.de.if.fe.ad.th  reason: invalid package */
public final class th<K, T> extends ad<K, T> {

    /* renamed from: yj  reason: collision with root package name */
    public final FlowableGroupBy$State<T, K> f10503yj;

    public th(K k, FlowableGroupBy$State<T, K> flowableGroupBy$State) {
        super(k);
        this.f10503yj = flowableGroupBy$State;
    }

    public static <T, K> th<K, T> uk(K k, int i2, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z) {
        return new th<>(k, new FlowableGroupBy$State(i2, flowableGroupBy$GroupBySubscriber, k, z));
    }

    public void onComplete() {
        this.f10503yj.onComplete();
    }

    public void onError(Throwable th2) {
        this.f10503yj.onError(th2);
    }

    public void onNext(T t) {
        this.f10503yj.onNext(t);
    }

    public void yj(Subscriber<? super T> subscriber) {
        this.f10503yj.subscribe(subscriber);
    }
}
