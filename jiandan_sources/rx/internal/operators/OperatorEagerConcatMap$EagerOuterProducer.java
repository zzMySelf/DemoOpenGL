package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.rg.qw.Cif;
import p041if.rg.qw.qw;
import rx.Producer;

public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements Producer {
    public static final long serialVersionUID = -657299606803478389L;
    public final Cif<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(Cif<?, ?> ifVar) {
        this.parent = ifVar;
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalStateException("n >= 0 required but it was " + j);
        } else if (i2 > 0) {
            qw.ad(this, j);
            this.parent.de();
        }
    }
}
