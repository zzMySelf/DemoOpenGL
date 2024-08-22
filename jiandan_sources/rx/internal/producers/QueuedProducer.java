package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.fe.qw;
import p041if.rg.fe.i.e;
import p041if.rg.fe.i.eee;
import p041if.rg.fe.uk.rg;
import rx.Observer;
import rx.Producer;
import rx.exceptions.MissingBackpressureException;

public final class QueuedProducer<T> extends AtomicLong implements Producer, Observer<T> {
    public static final Object NULL_SENTINEL = new Object();
    public static final long serialVersionUID = 7277121710709137047L;
    public final de<? super T> child;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QueuedProducer(de<? super T> deVar) {
        this(deVar, e.ad() ? new eee() : new rg());
    }

    private boolean checkTerminated(boolean z, boolean z2) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (!z) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            this.queue.clear();
            this.child.onError(th2);
            return true;
        } else if (!z2) {
            return false;
        } else {
            this.child.onCompleted();
            return true;
        }
    }

    private void drain() {
        if (this.wip.getAndIncrement() == 0) {
            de<? super T> deVar = this.child;
            Queue<Object> queue2 = this.queue;
            while (!checkTerminated(this.done, queue2.isEmpty())) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0) {
                    boolean z = this.done;
                    Object poll = queue2.poll();
                    if (!checkTerminated(z, poll == null)) {
                        if (poll == null) {
                            break;
                        }
                        try {
                            if (poll == NULL_SENTINEL) {
                                deVar.onNext(null);
                            } else {
                                deVar.onNext(poll);
                            }
                            j--;
                            j2++;
                        } catch (Throwable th2) {
                            if (poll == NULL_SENTINEL) {
                                poll = null;
                            }
                            qw.yj(th2, deVar, poll);
                            return;
                        }
                    } else {
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

    public void onCompleted() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (!offer(t)) {
            onError(new MissingBackpressureException());
        }
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

    public QueuedProducer(de<? super T> deVar, Queue<Object> queue2) {
        this.child = deVar;
        this.queue = queue2;
        this.wip = new AtomicInteger();
    }
}
