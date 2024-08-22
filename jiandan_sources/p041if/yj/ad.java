package p041if.yj;

import java.util.Arrays;
import java.util.Collection;
import p041if.de;
import p041if.fe.qw;
import p041if.uk.th;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;

/* renamed from: if.yj.ad  reason: invalid package */
public class ad<T> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final de<? super T> f11360ad;

    /* renamed from: th  reason: collision with root package name */
    public boolean f11361th;

    public ad(de<? super T> deVar) {
        super(deVar);
        this.f11360ad = deVar;
    }

    public void de(Throwable th2) {
        th.de().ad().qw(th2);
        try {
            this.f11360ad.onError(th2);
            try {
                unsubscribe();
            } catch (Throwable th3) {
                p041if.uk.de.i(th3);
                throw new OnErrorFailedException(th3);
            }
        } catch (OnErrorNotImplementedException e) {
            unsubscribe();
            throw e;
        } catch (Throwable th4) {
            p041if.uk.de.i(th4);
            throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th2, th4})));
        }
    }

    public void onCompleted() {
        if (!this.f11361th) {
            this.f11361th = true;
            try {
                this.f11360ad.onCompleted();
                try {
                    unsubscribe();
                } catch (Throwable th2) {
                    p041if.uk.de.i(th2);
                    throw new UnsubscribeFailedException(th2.getMessage(), th2);
                }
            } catch (Throwable th3) {
                try {
                    unsubscribe();
                    throw th3;
                } catch (Throwable th4) {
                    p041if.uk.de.i(th4);
                    throw new UnsubscribeFailedException(th4.getMessage(), th4);
                }
            }
        }
    }

    public void onError(Throwable th2) {
        qw.rg(th2);
        if (!this.f11361th) {
            this.f11361th = true;
            de(th2);
        }
    }

    public void onNext(T t) {
        try {
            if (!this.f11361th) {
                this.f11360ad.onNext(t);
            }
        } catch (Throwable th2) {
            qw.th(th2, this);
        }
    }
}
