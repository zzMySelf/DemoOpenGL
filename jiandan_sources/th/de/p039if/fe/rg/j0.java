package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import th.de.rg;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.j0  reason: invalid package */
public final class j0<T> extends qw<T, T> {
    public j0(rg<T> rgVar) {
        super(rgVar);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new fe(observer));
    }
}
