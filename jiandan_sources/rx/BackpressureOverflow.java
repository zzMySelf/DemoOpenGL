package rx;

import rx.exceptions.MissingBackpressureException;

public final class BackpressureOverflow {

    /* renamed from: ad  reason: collision with root package name */
    public static final Strategy f11375ad;
    public static final Strategy qw;

    public interface Strategy {
        boolean qw() throws MissingBackpressureException;
    }

    public static final class ad implements Strategy {
        public static final ad qw = new ad();

        public boolean qw() {
            return true;
        }
    }

    public static final class de implements Strategy {
        public static final de qw = new de();

        public boolean qw() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    public static final class qw implements Strategy {
        public static final qw qw = new qw();

        public boolean qw() {
            return false;
        }
    }

    static {
        de deVar = de.qw;
        qw = deVar;
        f11375ad = deVar;
        ad adVar = ad.qw;
        qw qwVar = qw.qw;
    }
}
