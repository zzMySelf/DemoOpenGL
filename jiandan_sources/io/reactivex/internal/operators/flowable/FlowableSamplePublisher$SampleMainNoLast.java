package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableSamplePublisher$SampleMainNoLast<T> extends FlowableSamplePublisher$SamplePublisherSubscriber<T> {
    public static final long serialVersionUID = -3029755663834015785L;

    public FlowableSamplePublisher$SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
        super(subscriber, publisher);
    }

    public void completeMain() {
        this.downstream.onComplete();
    }

    public void completeOther() {
        this.downstream.onComplete();
    }

    public void run() {
        emit();
    }
}
