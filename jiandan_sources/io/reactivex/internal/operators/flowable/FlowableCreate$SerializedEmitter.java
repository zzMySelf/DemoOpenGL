package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.p039if.rg.qw;

public final class FlowableCreate$SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
    public static final long serialVersionUID = 4883307006032401862L;
    public volatile boolean done;
    public final FlowableCreate$BaseEmitter<T> emitter;
    public final AtomicThrowable error = new AtomicThrowable();
    public final SimplePlainQueue<T> queue = new qw(16);

    public FlowableCreate$SerializedEmitter(FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter) {
        this.emitter = flowableCreate$BaseEmitter;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter = this.emitter;
        SimplePlainQueue<T> simplePlainQueue = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int i2 = 1;
        while (!flowableCreate$BaseEmitter.isCancelled()) {
            if (atomicThrowable.get() != null) {
                simplePlainQueue.clear();
                flowableCreate$BaseEmitter.onError(atomicThrowable.terminate());
                return;
            }
            boolean z = this.done;
            T poll = simplePlainQueue.poll();
            boolean z2 = poll == null;
            if (z && z2) {
                flowableCreate$BaseEmitter.onComplete();
                return;
            } else if (z2) {
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                flowableCreate$BaseEmitter.onNext(poll);
            }
        }
        simplePlainQueue.clear();
    }

    public boolean isCancelled() {
        return this.emitter.isCancelled();
    }

    public void onComplete() {
        if (!this.emitter.isCancelled() && !this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (!tryOnError(th2)) {
            th.de.ppp.qw.ddd(th2);
        }
    }

    public void onNext(T t) {
        if (!this.emitter.isCancelled() && !this.done) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                synchronized (simplePlainQueue) {
                    simplePlainQueue.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public long requested() {
        return this.emitter.requested();
    }

    public FlowableEmitter<T> serialize() {
        return this;
    }

    public void setCancellable(Cancellable cancellable) {
        this.emitter.setCancellable(cancellable);
    }

    public void setDisposable(Disposable disposable) {
        this.emitter.setDisposable(disposable);
    }

    public String toString() {
        return this.emitter.toString();
    }

    public boolean tryOnError(Throwable th2) {
        if (!this.emitter.isCancelled() && !this.done) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (this.error.addThrowable(th2)) {
                this.done = true;
                drain();
                return true;
            }
        }
        return false;
    }
}
