package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p041if.de;
import p041if.rg.qw.qw;

public final class OnSubscribeFromEmitter$LatestEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<Object> queue = new AtomicReference<>();
    public final AtomicInteger wip = new AtomicInteger();

    public OnSubscribeFromEmitter$LatestEmitter(de<? super T> deVar) {
        super(deVar);
    }

    public void drain() {
        boolean z;
        int i2;
        if (this.wip.getAndIncrement() == 0) {
            de<? super T> deVar = this.actual;
            AtomicReference<Object> atomicReference = this.queue;
            int i3 = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    z = false;
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (deVar.isUnsubscribed()) {
                        atomicReference.lazySet((Object) null);
                        return;
                    } else {
                        boolean z2 = this.done;
                        Object andSet = atomicReference.getAndSet((Object) null);
                        boolean z3 = andSet == null;
                        if (z2 && z3) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z3) {
                            break;
                        } else {
                            deVar.onNext(NotificationLite.rg(andSet));
                            j2++;
                        }
                    }
                }
                if (i2 == 0) {
                    if (deVar.isUnsubscribed()) {
                        atomicReference.lazySet((Object) null);
                        return;
                    }
                    boolean z4 = this.done;
                    if (atomicReference.get() == null) {
                        z = true;
                    }
                    if (z4 && z) {
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
        this.queue.set(NotificationLite.uk(t));
        drain();
    }

    public void onRequested() {
        drain();
    }

    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.lazySet((Object) null);
        }
    }
}
