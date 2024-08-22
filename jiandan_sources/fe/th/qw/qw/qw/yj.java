package fe.th.qw.qw.qw;

import java.util.concurrent.atomic.AtomicLong;

public class yj {
    public static AtomicLong qw = new AtomicLong(999);

    public static void ad(long j) {
        if (0 == j) {
            j = 999;
        }
        qw.set(j);
    }

    public static long qw() {
        if (0 == qw.incrementAndGet()) {
            qw.set(999);
        }
        return qw.get();
    }
}
