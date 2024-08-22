package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import th.de.i.qw;
import th.de.p039if.fe.de.fe;

public final class MaybeMergeArray$MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
    public static final long serialVersionUID = -660395290758764731L;
    public volatile boolean cancelled;
    public long consumed;
    public final Subscriber<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public boolean outputFused;
    public final fe<Object> queue;
    public final AtomicLong requested = new AtomicLong();
    public final qw set = new qw();
    public final int sourceCount;

    public MaybeMergeArray$MergeMaybeObserver(Subscriber<? super T> subscriber, int i2, fe<Object> feVar) {
        this.downstream = subscriber;
        this.sourceCount = i2;
        this.queue = feVar;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }
    }

    public void drainFused() {
        Subscriber<? super T> subscriber = this.downstream;
        fe<Object> feVar = this.queue;
        int i2 = 1;
        while (!this.cancelled) {
            Throwable th2 = (Throwable) this.error.get();
            if (th2 != null) {
                feVar.clear();
                subscriber.onError(th2);
                return;
            }
            boolean z = feVar.producerIndex() == this.sourceCount;
            if (!feVar.isEmpty()) {
                subscriber.onNext(null);
            }
            if (z) {
                subscriber.onComplete();
                return;
            }
            i2 = addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
        feVar.clear();
    }

    public void drainNormal() {
        int i2;
        Subscriber<? super T> subscriber = this.downstream;
        fe<Object> feVar = this.queue;
        long j = this.consumed;
        int i3 = 1;
        do {
            long j2 = this.requested.get();
            while (true) {
                i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    feVar.clear();
                    return;
                } else if (((Throwable) this.error.get()) != null) {
                    feVar.clear();
                    subscriber.onError(this.error.terminate());
                    return;
                } else if (feVar.consumerIndex() == this.sourceCount) {
                    subscriber.onComplete();
                    return;
                } else {
                    Object poll = feVar.poll();
                    if (poll == null) {
                        break;
                    } else if (poll != NotificationLite.COMPLETE) {
                        subscriber.onNext(poll);
                        j++;
                    }
                }
            }
            if (i2 == 0) {
                if (((Throwable) this.error.get()) != null) {
                    feVar.clear();
                    subscriber.onError(this.error.terminate());
                    return;
                }
                while (feVar.peek() == NotificationLite.COMPLETE) {
                    feVar.drop();
                }
                if (feVar.consumerIndex() == this.sourceCount) {
                    subscriber.onComplete();
                    return;
                }
            }
            this.consumed = j;
            i3 = addAndGet(-i3);
        } while (i3 != 0);
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    public void onError(Throwable th2) {
        if (this.error.addThrowable(th2)) {
            this.set.dispose();
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onSubscribe(Disposable disposable) {
        this.set.ad(disposable);
    }

    public void onSuccess(T t) {
        this.queue.offer(t);
        drain();
    }

    public T poll() throws Exception {
        T poll;
        do {
            poll = this.queue.poll();
        } while (poll == NotificationLite.COMPLETE);
        return poll;
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }

    public int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
