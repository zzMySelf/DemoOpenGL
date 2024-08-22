package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import th.de.p039if.rg.qw;

public final class FlowableCreate$BufferAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final qw<T> queue;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableCreate$BufferAsyncEmitter(Subscriber<? super T> subscriber, int i2) {
        super(subscriber);
        this.queue = new qw<>(i2);
    }

    public void drain() {
        int i2;
        if (this.wip.getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.downstream;
            qw<T> qwVar = this.queue;
            int i3 = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (isCancelled()) {
                        qwVar.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        T poll = qwVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                error(th2);
                                return;
                            } else {
                                complete();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext(poll);
                            j2++;
                        }
                    }
                }
                if (i2 == 0) {
                    if (isCancelled()) {
                        qwVar.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean isEmpty = qwVar.isEmpty();
                    if (z3 && isEmpty) {
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
                    th.de.p039if.yj.qw.rg(this, j2);
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
            this.queue.offer(t);
            drain();
        }
    }

    public void onRequested() {
        drain();
    }

    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public boolean tryOnError(Throwable th2) {
        if (this.done || isCancelled()) {
            return false;
        }
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.error = th2;
        this.done = true;
        drain();
        return true;
    }
}
