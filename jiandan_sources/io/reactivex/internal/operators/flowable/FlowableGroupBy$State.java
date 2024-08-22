package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import th.de.p039if.rg.qw;

public final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public final AtomicBoolean once = new AtomicBoolean();
    public boolean outputFused;
    public final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    public int produced;
    public final qw<T> queue;
    public final AtomicLong requested = new AtomicLong();

    public FlowableGroupBy$State(int i2, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k, boolean z) {
        this.queue = new qw<>(i2);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = k;
        this.delayError = z;
    }

    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            this.parent.cancel(this.key);
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    subscriber.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                Throwable th3 = this.error;
                if (th3 != null) {
                    subscriber.onError(th3);
                } else {
                    subscriber.onComplete();
                }
                return true;
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
        Throwable th2;
        qw<T> qwVar = this.queue;
        Subscriber subscriber = this.actual.get();
        int i2 = 1;
        while (true) {
            if (subscriber != null) {
                if (this.cancelled.get()) {
                    qwVar.clear();
                    return;
                }
                boolean z = this.done;
                if (!z || this.delayError || (th2 = this.error) == null) {
                    subscriber.onNext(null);
                    if (z) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            subscriber.onError(th3);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                } else {
                    qwVar.clear();
                    subscriber.onError(th2);
                    return;
                }
            }
            i2 = addAndGet(-i2);
            if (i2 != 0) {
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            } else {
                return;
            }
        }
    }

    public void drainNormal() {
        int i2;
        qw<T> qwVar = this.queue;
        boolean z = this.delayError;
        Subscriber subscriber = this.actual.get();
        int i3 = 1;
        while (true) {
            if (subscriber != null) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z2 = this.done;
                    T poll = qwVar.poll();
                    boolean z3 = poll == null;
                    if (!checkTerminated(z2, z3, subscriber, z)) {
                        if (z3) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                    } else {
                        return;
                    }
                }
                if (i2 == 0 && checkTerminated(this.done, qwVar.isEmpty(), subscriber, z)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.parent.upstream.request(j2);
                }
            }
            i3 = addAndGet(-i3);
            if (i3 != 0) {
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            } else {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
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
        this.queue.offer(t);
        drain();
    }

    public T poll() {
        T poll = this.queue.poll();
        if (poll != null) {
            this.produced++;
            return poll;
        }
        int i2 = this.produced;
        if (i2 == 0) {
            return null;
        }
        this.produced = 0;
        this.parent.upstream.request((long) i2);
        return null;
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

    public void subscribe(Subscriber<? super T> subscriber) {
        if (this.once.compareAndSet(false, true)) {
            subscriber.onSubscribe(this);
            this.actual.lazySet(subscriber);
            drain();
            return;
        }
        EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
    }
}
