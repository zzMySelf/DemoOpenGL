package rx.subjects;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Producer;
import rx.Subscription;

public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
    public static final long serialVersionUID = -5006209596735204567L;
    public final de<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(de<? super T> deVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = deVar;
        this.state = replaySubject$ReplayState;
    }

    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 > 0) {
            qw.ad(this.requested, j);
            this.state.buffer.qw(this);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }

    public void unsubscribe() {
        this.state.remove(this);
    }
}
