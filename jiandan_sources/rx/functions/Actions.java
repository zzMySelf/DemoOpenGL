package rx.functions;

import rx.exceptions.OnErrorNotImplementedException;

public final class Actions {
    public static final qw qw = new qw();

    public enum NotImplemented implements Action1<Throwable> {
        INSTANCE;

        public void call(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }
    }

    public static final class qw<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements Action0, Action1<T0>, Action2<T0, T1>, Action3<T0, T1, T2>, Action4<T0, T1, T2, T3>, Action5<T0, T1, T2, T3, T4>, Action6<T0, T1, T2, T3, T4, T5>, Action7<T0, T1, T2, T3, T4, T5, T6>, Action8<T0, T1, T2, T3, T4, T5, T6, T7>, Action9<T0, T1, T2, T3, T4, T5, T6, T7, T8>, ActionN {
        public void call() {
        }

        public void call(T0 t0) {
        }

        public void qw(T0 t0, T1 t1) {
        }
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> qw<T0, T1, T2, T3, T4, T5, T6, T7, T8> qw() {
        return qw;
    }
}
