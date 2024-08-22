package th.de.p039if.fe.ad;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber;
import org.reactivestreams.Subscription;

/* renamed from: th.de.if.fe.ad.pf  reason: invalid package */
public final class pf<T> implements FlowableSubscriber<Object> {

    /* renamed from: ad  reason: collision with root package name */
    public final FlowableSamplePublisher$SamplePublisherSubscriber<T> f10498ad;

    public pf(FlowableSamplePublisher$SamplePublisherSubscriber<T> flowableSamplePublisher$SamplePublisherSubscriber) {
        this.f10498ad = flowableSamplePublisher$SamplePublisherSubscriber;
    }

    public void onComplete() {
        this.f10498ad.complete();
    }

    public void onError(Throwable th2) {
        this.f10498ad.error(th2);
    }

    public void onNext(Object obj) {
        this.f10498ad.run();
    }

    public void onSubscribe(Subscription subscription) {
        this.f10498ad.setOther(subscription);
    }
}
