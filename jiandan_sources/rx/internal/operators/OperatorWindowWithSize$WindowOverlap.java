package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Producer;
import rx.functions.Action0;

public final class OperatorWindowWithSize$WindowOverlap<T> extends de<T> implements Action0 {

    /* renamed from: ad  reason: collision with root package name */
    public final int f11439ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f11440th;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicLong f11441yj;

    public final class WindowOverlapProducer extends AtomicBoolean implements Producer {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowOverlapProducer() {
        }

        public void request(long j) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i2 != 0) {
                OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = OperatorWindowWithSize$WindowOverlap.this;
                if (get() || !compareAndSet(false, true)) {
                    OperatorWindowWithSize$WindowOverlap.this.request(qw.de((long) operatorWindowWithSize$WindowOverlap.f11440th, j));
                } else {
                    operatorWindowWithSize$WindowOverlap.request(qw.qw(qw.de((long) operatorWindowWithSize$WindowOverlap.f11440th, j - 1), (long) operatorWindowWithSize$WindowOverlap.f11439ad));
                }
                qw.ad(operatorWindowWithSize$WindowOverlap.f11441yj, j);
                operatorWindowWithSize$WindowOverlap.rg();
            }
        }
    }

    public abstract void rg();
}
