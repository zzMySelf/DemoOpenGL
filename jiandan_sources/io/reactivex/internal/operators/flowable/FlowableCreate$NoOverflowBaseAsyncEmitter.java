package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import th.de.p039if.yj.qw;

public abstract class FlowableCreate$NoOverflowBaseAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public FlowableCreate$NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public final void onNext(T t) {
        if (!isCancelled()) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() != 0) {
                this.downstream.onNext(t);
                qw.rg(this, 1);
            } else {
                onOverflow();
            }
        }
    }

    public abstract void onOverflow();
}
