package th.de.p039if.fe.rg;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import th.de.p039if.ad.qw;

/* renamed from: th.de.if.fe.rg.x  reason: invalid package */
public final class x<R, T> extends qw<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableOperator<? extends R, ? super T> f10861th;

    public x(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.f10861th = observableOperator;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            Observer<? super Object> qw = this.f10861th.qw(observer);
            qw.rg(qw, "Operator " + this.f10861th + " returned a null Observer");
            this.f10756ad.subscribe(qw);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            th.de.ppp.qw.ddd(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
