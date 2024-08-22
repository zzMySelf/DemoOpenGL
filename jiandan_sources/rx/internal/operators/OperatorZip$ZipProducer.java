package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.rg.qw.qw;
import rx.Producer;

public final class OperatorZip$ZipProducer<R> extends AtomicLong implements Producer {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    public void request(long j) {
        qw.ad(this, j);
        this.zipper.tick();
    }
}
