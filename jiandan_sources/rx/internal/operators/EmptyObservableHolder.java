package rx.internal.operators;

import p041if.de;
import rx.Observable;

public enum EmptyObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    public static final Observable<Object> EMPTY = null;

    /* access modifiers changed from: public */
    static {
        EmptyObservableHolder emptyObservableHolder;
        EMPTY = Observable.ad(emptyObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return EMPTY;
    }

    public void call(de<? super Object> deVar) {
        deVar.onCompleted();
    }
}
