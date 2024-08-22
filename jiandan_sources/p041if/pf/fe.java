package p041if.pf;

import rx.Subscription;
import rx.functions.Action0;

/* renamed from: if.pf.fe  reason: invalid package */
public final class fe {
    public static final qw qw = new qw();

    /* renamed from: if.pf.fe$qw */
    public static final class qw implements Subscription {
        public boolean isUnsubscribed() {
            return true;
        }

        public void unsubscribe() {
        }
    }

    public static Subscription ad() {
        return qw;
    }

    public static Subscription qw(Action0 action0) {
        return qw.qw(action0);
    }
}
