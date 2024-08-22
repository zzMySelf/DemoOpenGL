package th.de;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import th.de.p039if.ad.qw;
import th.de.p039if.de.th;
import th.de.p039if.fe.th.ad;

public abstract class yj<T> implements SingleSource<T> {
    public final T de() {
        th thVar = new th();
        qw(thVar);
        return thVar.qw();
    }

    public final <R> yj<R> fe(Function<? super T, ? extends R> function) {
        qw.rg(function, "mapper is null");
        return th.de.ppp.qw.ppp(new ad(this, function));
    }

    public final void qw(SingleObserver<? super T> singleObserver) {
        qw.rg(singleObserver, "observer is null");
        SingleObserver<? super Object> tt = th.de.ppp.qw.tt(this, singleObserver);
        qw.rg(tt, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            rg(tt);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void rg(SingleObserver<? super T> singleObserver);

    public final rg<T> th() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).ad();
        }
        return th.de.ppp.qw.when(new SingleToObservable(this));
    }
}
