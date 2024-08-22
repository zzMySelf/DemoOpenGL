package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p041if.de;
import p041if.rg.qw.Cswitch;
import p041if.rg.qw.qw;
import rx.Observable;
import rx.Producer;
import rx.Subscription;

public final class OperatorGroupBy$State<T, K> extends AtomicInteger implements Producer, Subscription, Observable.OnSubscribe<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final AtomicReference<de<? super T>> actual;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final AtomicBoolean once;
    public final Cswitch<?, K, T> parent;
    public final Queue<Object> queue = new ConcurrentLinkedQueue();
    public final AtomicLong requested;

    public OperatorGroupBy$State(int i2, Cswitch<?, K, T> switchR, K k, boolean z) {
        this.parent = switchR;
        this.key = k;
        this.delayError = z;
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    public boolean checkTerminated(boolean z, boolean z2, de<? super T> deVar, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.de(this.key);
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    deVar.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    deVar.onCompleted();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                Throwable th3 = this.error;
                if (th3 != null) {
                    deVar.onError(th3);
                } else {
                    deVar.onCompleted();
                }
                return true;
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            Queue<Object> queue2 = this.queue;
            boolean z = this.delayError;
            de deVar = this.actual.get();
            int i2 = 1;
            while (true) {
                if (deVar != null) {
                    if (!checkTerminated(this.done, queue2.isEmpty(), deVar, z)) {
                        long j = this.requested.get();
                        long j2 = 0;
                        while (j2 != j) {
                            boolean z2 = this.done;
                            Object poll = queue2.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, deVar, z)) {
                                if (z3) {
                                    break;
                                }
                                deVar.onNext(NotificationLite.rg(poll));
                                j2++;
                            } else {
                                return;
                            }
                        }
                        if (j2 != 0) {
                            if (j != Long.MAX_VALUE) {
                                qw.yj(this.requested, j2);
                            }
                            this.parent.f11331ad.request(j2);
                        }
                    } else {
                        return;
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 != 0) {
                    if (deVar == null) {
                        deVar = this.actual.get();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean isUnsubscribed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (t == null) {
            this.error = new NullPointerException();
            this.done = true;
        } else {
            this.queue.offer(NotificationLite.uk(t));
        }
        drain();
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= required but it was " + j);
        } else if (i2 != 0) {
            qw.ad(this.requested, j);
            drain();
        }
    }

    public void unsubscribe() {
        if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.parent.de(this.key);
        }
    }

    public void call(de<? super T> deVar) {
        if (this.once.compareAndSet(false, true)) {
            deVar.add(this);
            deVar.setProducer(this);
            this.actual.lazySet(deVar);
            drain();
            return;
        }
        deVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
    }
}
