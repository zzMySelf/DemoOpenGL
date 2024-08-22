package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscription;

public enum TestSubscriber$EmptySubscriber implements FlowableSubscriber<Object> {
    INSTANCE;

    public void onComplete() {
    }

    public void onError(Throwable th2) {
    }

    public void onNext(Object obj) {
    }

    public void onSubscribe(Subscription subscription) {
    }
}
