package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ggg.qw;

public final class FlowableRepeatWhen$RepeatWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Object> {
    public static final long serialVersionUID = -2680129890138081029L;

    public FlowableRepeatWhen$RepeatWhenSubscriber(Subscriber<? super T> subscriber, qw<Object> qwVar, Subscription subscription) {
        super(subscriber, qwVar, subscription);
    }

    public void onComplete() {
        again(0);
    }

    public void onError(Throwable th2) {
        this.receiver.cancel();
        this.downstream.onError(th2);
    }
}
