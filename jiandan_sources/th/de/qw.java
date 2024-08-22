package th.de;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;

public abstract class qw implements CompletableSource {
    public static NullPointerException fe(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    public abstract void de(CompletableObserver completableObserver);

    public final void qw(CompletableObserver completableObserver) {
        th.de.p039if.ad.qw.rg(completableObserver, "observer is null");
        try {
            CompletableObserver qqq = th.de.ppp.qw.qqq(this, completableObserver);
            th.de.p039if.ad.qw.rg(qqq, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            de(qqq);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            th.de.ppp.qw.ddd(th2);
            throw fe(th2);
        }
    }
}
