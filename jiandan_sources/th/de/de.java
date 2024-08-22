package th.de;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import th.de.p039if.ad.qw;
import th.de.p039if.de.th;

public abstract class de<T> implements MaybeSource<T> {
    public final T de() {
        th thVar = new th();
        qw(thVar);
        return thVar.qw();
    }

    public abstract void fe(MaybeObserver<? super T> maybeObserver);

    public final void qw(MaybeObserver<? super T> maybeObserver) {
        qw.rg(maybeObserver, "observer is null");
        MaybeObserver<? super Object> eee = th.de.ppp.qw.eee(this, maybeObserver);
        qw.rg(eee, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            fe(eee);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
