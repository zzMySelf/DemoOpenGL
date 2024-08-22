package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.u  reason: invalid package */
public final class u<T> extends rg<T> implements ScalarCallable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final T f10808ad;

    public u(T t) {
        this.f10808ad = t;
    }

    public T call() {
        return this.f10808ad;
    }

    public void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.f10808ad);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
