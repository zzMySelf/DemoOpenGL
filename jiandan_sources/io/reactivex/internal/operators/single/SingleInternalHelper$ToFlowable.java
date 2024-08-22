package io.reactivex.internal.operators.single;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

public enum SingleInternalHelper$ToFlowable implements Function<SingleSource, Publisher> {
    INSTANCE;

    public Publisher apply(SingleSource singleSource) {
        return new SingleToFlowable(singleSource);
    }
}
