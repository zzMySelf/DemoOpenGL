package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import th.de.p039if.yj.qw;

public final class FlowableCreate$LatestAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<T> queue = new AtomicReference<>();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableCreate$LatestAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void drain() {
        boolean z;
        int i2;
        if (this.wip.getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.downstream;
            AtomicReference<T> atomicReference = this.queue;
            int i3 = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    z = false;
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (isCancelled()) {
                        atomicReference.lazySet((Object) null);
                        return;
                    } else {
                        boolean z2 = this.done;
                        T andSet = atomicReference.getAndSet((Object) null);
                        boolean z3 = andSet == null;
                        if (z2 && z3) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                error(th2);
                                return;
                            } else {
                                complete();
                                return;
                            }
                        } else if (z3) {
                            break;
                        } else {
                            subscriber.onNext(andSet);
                            j2++;
                        }
                    }
                }
                if (i2 == 0) {
                    if (isCancelled()) {
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
                            error(th3);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    qw.rg(this, j2);
                }
                i3 = this.wip.addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (!this.done && !isCancelled()) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.queue.set(t);
            drain();
        }
    }

    public void onRequested() {
        drain();
    }

    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.lazySet((Object) null);
        }
    }

    public boolean tryOnError(Throwable th2) {
        if (this.done || isCancelled()) {
            return false;
        }
        if (th2 == null) {
            onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
        this.error = th2;
        this.done = true;
        drain();
        return true;
    }
}
