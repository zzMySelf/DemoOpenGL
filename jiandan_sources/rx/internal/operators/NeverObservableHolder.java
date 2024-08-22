package rx.internal.operators;

import p041if.de;
import rx.Observable;

public enum NeverObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    public static final Observable<Object> NEVER = null;

    /* access modifiers changed from: public */
    static {
        NeverObservableHolder neverObservableHolder;
        NEVER = Observable.ad(neverObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return NEVER;
    }

    public void call(de<? super Object> deVar) {
    }
}
