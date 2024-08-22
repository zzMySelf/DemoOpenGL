package p041if.o;

import rx.Observable;
import rx.Observer;

/* renamed from: if.o.fe  reason: invalid package */
public abstract class fe<T, R> extends Observable<R> implements Observer<T> {
    public fe(Observable.OnSubscribe<R> onSubscribe) {
        super(onSubscribe);
    }

    public final de<T, R> qqq() {
        if (getClass() == de.class) {
            return (de) this;
        }
        return new de<>(this);
    }
}
