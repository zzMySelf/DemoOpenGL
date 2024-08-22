package p041if.yj;

import rx.Observer;
import rx.exceptions.OnErrorNotImplementedException;

/* renamed from: if.yj.qw  reason: invalid package */
public final class qw {
    public static final Observer<Object> qw = new C0361qw();

    /* renamed from: if.yj.qw$qw  reason: collision with other inner class name */
    public static class C0361qw implements Observer<Object> {
        public final void onCompleted() {
        }

        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        public final void onNext(Object obj) {
        }
    }

    public static <T> Observer<T> qw() {
        return qw;
    }
}
