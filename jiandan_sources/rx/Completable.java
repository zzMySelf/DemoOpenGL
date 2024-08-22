package rx;

import p041if.pf.fe;
import p041if.uk.de;
import rx.functions.Action1;
import rx.functions.Func1;

public class Completable {
    public final OnSubscribe qw;

    public interface OnSubscribe extends Action1<CompletableSubscriber> {
    }

    public interface Operator extends Func1<CompletableSubscriber, CompletableSubscriber> {
    }

    public interface Transformer extends Func1<Completable, Completable> {
    }

    public static class ad implements OnSubscribe {
        /* renamed from: ad */
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.onSubscribe(fe.ad());
        }
    }

    public static class qw implements OnSubscribe {
        /* renamed from: ad */
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.onSubscribe(fe.ad());
            completableSubscriber.onCompleted();
        }
    }

    static {
        new Completable(new qw(), false);
        new Completable(new ad(), false);
    }

    public Completable(OnSubscribe onSubscribe, boolean z) {
        this.qw = z ? de.yj(onSubscribe) : onSubscribe;
    }

    public static NullPointerException ad(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    public static <T> T qw(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public final void de(CompletableSubscriber completableSubscriber) {
        qw(completableSubscriber);
        try {
            de.rg(this, this.qw).call(completableSubscriber);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            p041if.fe.qw.rg(th2);
            Throwable fe2 = de.fe(th2);
            de.i(fe2);
            throw ad(fe2);
        }
    }
}
