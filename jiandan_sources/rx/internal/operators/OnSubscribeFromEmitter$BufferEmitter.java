package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import p041if.de;
import p041if.rg.fe.i.e;
import p041if.rg.fe.i.rrr;
import p041if.rg.fe.uk.th;
import p041if.rg.qw.qw;

public final class OnSubscribeFromEmitter$BufferEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    public OnSubscribeFromEmitter$BufferEmitter(de<? super T> deVar, int i2) {
        super(deVar);
        this.queue = e.ad() ? new rrr<>(i2) : new th<>(i2);
        this.wip = new AtomicInteger();
    }

    public void drain() {
        int i2;
        if (this.wip.getAndIncrement() == 0) {
            de<? super T> deVar = this.actual;
            Queue<Object> queue2 = this.queue;
            int i3 = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (deVar.isUnsubscribed()) {
                        queue2.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        Object poll = queue2.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            deVar.onNext(NotificationLite.rg(poll));
                            j2++;
                        }
                    }
                }
                if (i2 == 0) {
                    if (deVar.isUnsubscribed()) {
                        queue2.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean isEmpty = queue2.isEmpty();
                    if (z3 && isEmpty) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            super.onError(th3);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    qw.yj(this, j2);
                }
                i3 = this.wip.addAndGet(-i3);
            } while (i3 != 0);
        }
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
        this.queue.offer(NotificationLite.uk(t));
        drain();
    }

    public void onRequested() {
        drain();
    }

    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.clear();
        }
    }
}
