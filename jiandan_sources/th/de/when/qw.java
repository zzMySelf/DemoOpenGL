package th.de.when;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import th.de.p039if.yj.fe;

public abstract class qw<T> implements Observer<T> {

    /* renamed from: ad  reason: collision with root package name */
    public Disposable f11044ad;

    public final void onSubscribe(Disposable disposable) {
        if (fe.rg(this.f11044ad, disposable, getClass())) {
            this.f11044ad = disposable;
            qw();
        }
    }

    public void qw() {
    }
}
