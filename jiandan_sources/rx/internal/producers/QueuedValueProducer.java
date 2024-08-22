package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.fe.qw;
import p041if.rg.fe.i.e;
import p041if.rg.fe.i.eee;
import p041if.rg.fe.uk.rg;
import rx.Producer;

public final class QueuedValueProducer<T> extends AtomicLong implements Producer {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final de<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QueuedValueProducer(de<? super T> deVar) {
        this(deVar, e.ad() ? new eee() : new rg());
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            de<? super T> deVar = this.child;
            Queue<Object> queue2 = this.queue;
            while (!deVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue2.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            deVar.onNext(null);
                        } else {
                            deVar.onNext(poll);
                        }
                        if (!deVar.isUnsubscribed()) {
                            j--;
                            j2++;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        qw.yj(th2, deVar, poll);
                        return;
                    }
                }
                if (!(j2 == 0 || get() == Long.MAX_VALUE)) {
                    addAndGet(-j2);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t) {
        if (t == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i2 > 0) {
            p041if.rg.qw.qw.ad(this, j);
            drain();
        }
    }

    public QueuedValueProducer(de<? super T> deVar, Queue<Object> queue2) {
        this.child = deVar;
        this.queue = queue2;
        this.wip = new AtomicInteger();
    }
}
