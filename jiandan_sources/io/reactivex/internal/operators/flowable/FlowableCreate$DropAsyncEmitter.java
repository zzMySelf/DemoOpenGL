package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

public final class FlowableCreate$DropAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    public FlowableCreate$DropAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void onOverflow() {
    }
}
