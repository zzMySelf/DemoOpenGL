package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.p  reason: invalid package */
public final class p<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10724ad;

    public p(ObservableSource<T> observableSource) {
        this.f10724ad = observableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10724ad.subscribe(observer);
    }
}
