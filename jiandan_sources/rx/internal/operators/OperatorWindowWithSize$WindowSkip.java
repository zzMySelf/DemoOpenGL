package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Producer;
import rx.functions.Action0;

public final class OperatorWindowWithSize$WindowSkip<T> extends de<T> implements Action0 {

    /* renamed from: ad  reason: collision with root package name */
    public final int f11442ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f11443th;

    public final class WindowSkipProducer extends AtomicBoolean implements Producer {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        public void request(long j) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i2 != 0) {
                OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                if (get() || !compareAndSet(false, true)) {
                    operatorWindowWithSize$WindowSkip.request(qw.de(j, (long) operatorWindowWithSize$WindowSkip.f11443th));
                } else {
                    operatorWindowWithSize$WindowSkip.request(qw.qw(qw.de(j, (long) operatorWindowWithSize$WindowSkip.f11442ad), qw.de((long) (operatorWindowWithSize$WindowSkip.f11443th - operatorWindowWithSize$WindowSkip.f11442ad), j - 1)));
                }
            }
        }
    }
}
