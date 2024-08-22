package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;
import th.de.th;

public abstract class FlowableObserveOn$BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
    public static final long serialVersionUID = -8241002408341274697L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public boolean outputFused;
    public final int prefetch;
    public long produced;
    public SimpleQueue<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public int sourceMode;
    public Subscription upstream;
    public final th.de worker;

    public FlowableObserveOn$BaseObserveOnSubscriber(th.de deVar, boolean z, int i2) {
        this.worker = deVar;
        this.delayError = z;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public final boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber) {
        if (this.cancelled) {
            clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!this.delayError) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.cancelled = true;
                    clear();
                    subscriber.onError(th2);
                    this.worker.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.cancelled = true;
                    subscriber.onComplete();
                    this.worker.dispose();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                this.cancelled = true;
                Throwable th3 = this.error;
                if (th3 != null) {
                    subscriber.onError(th3);
                } else {
                    subscriber.onComplete();
                }
                this.worker.dispose();
                return true;
            }
        }
    }

    public final void clear() {
        this.queue.clear();
    }

    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public final void onComplete() {
        if (!this.done) {
            this.done = true;
            trySchedule();
        }
    }

    public final void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        trySchedule();
    }

    public final void onNext(T t) {
        if (!this.done) {
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }
    }

    public abstract /* synthetic */ void onSubscribe(Subscription subscription);

    public abstract /* synthetic */ T poll() throws Exception;

    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            trySchedule();
        }
    }

    public final int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }

    public final void run() {
        if (this.outputFused) {
            runBackfused();
        } else if (this.sourceMode == 1) {
            runSync();
        } else {
            runAsync();
        }
    }

    public abstract void runAsync();

    public abstract void runBackfused();

    public abstract void runSync();

    public final void trySchedule() {
        if (getAndIncrement() == 0) {
            this.worker.ad(this);
        }
    }
}
