package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.e  reason: invalid package */
public final class e extends rg<Object> implements ScalarCallable<Object> {

    /* renamed from: ad  reason: collision with root package name */
    public static final rg<Object> f10587ad = new e();

    public Object call() {
        return null;
    }

    public void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.complete((Observer<?>) observer);
    }
}
