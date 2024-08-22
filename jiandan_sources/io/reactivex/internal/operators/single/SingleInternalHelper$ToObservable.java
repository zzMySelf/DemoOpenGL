package io.reactivex.internal.operators.single;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import th.de.rg;

public enum SingleInternalHelper$ToObservable implements Function<SingleSource, rg> {
    INSTANCE;

    public rg apply(SingleSource singleSource) {
        return new SingleToObservable(singleSource);
    }
}
