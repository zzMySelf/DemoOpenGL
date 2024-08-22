package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

public final class FlowableCreate$MissingEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 3776720187248809713L;

    public FlowableCreate$MissingEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void onNext(T t) {
        long j;
        if (!isCancelled()) {
            if (t != null) {
                this.downstream.onNext(t);
                do {
                    j = get();
                    if (j == 0 || compareAndSet(j, j - 1)) {
                        return;
                    }
                    j = get();
                    return;
                } while (compareAndSet(j, j - 1));
                return;
            }
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
    }
}
