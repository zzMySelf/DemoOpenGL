package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import org.reactivestreams.Subscriber;

public final class FlowableCreate$ErrorAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    public static final long serialVersionUID = 338953216916120960L;

    public FlowableCreate$ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
