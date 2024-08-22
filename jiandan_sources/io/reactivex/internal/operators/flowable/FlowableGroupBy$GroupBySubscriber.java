package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.th;
import th.de.p039if.rg.qw;
import th.de.pf.ad;

public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<ad<K, V>> implements FlowableSubscriber<T> {
    public static final Object NULL_KEY = new Object();
    public static final long serialVersionUID = -3688291656102519502L;
    public final int bufferSize;
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final boolean delayError;
    public boolean done;
    public final Subscriber<? super ad<K, V>> downstream;
    public Throwable error;
    public final Queue<th<K, V>> evictedGroups;
    public volatile boolean finished;
    public final AtomicInteger groupCount = new AtomicInteger(1);
    public final Map<Object, th<K, V>> groups;
    public final Function<? super T, ? extends K> keySelector;
    public boolean outputFused;
    public final qw<ad<K, V>> queue;
    public final AtomicLong requested = new AtomicLong();
    public Subscription upstream;
    public final Function<? super T, ? extends V> valueSelector;

    public FlowableGroupBy$GroupBySubscriber(Subscriber<? super ad<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z, Map<Object, th<K, V>> map, Queue<th<K, V>> queue2) {
        this.downstream = subscriber;
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i2;
        this.delayError = z;
        this.groups = map;
        this.evictedGroups = queue2;
        this.queue = new qw<>(i2);
    }

    private void completeEvictions() {
        if (this.evictedGroups != null) {
            int i2 = 0;
            while (true) {
                th poll = this.evictedGroups.poll();
                if (poll == null) {
                    break;
                }
                poll.onComplete();
                i2++;
            }
            if (i2 != 0) {
                this.groupCount.addAndGet(-i2);
            }
        }
    }

    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            completeEvictions();
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, qw<?> qwVar) {
        if (this.cancelled.get()) {
            qwVar.clear();
            return true;
        } else if (this.delayError) {
            if (!z || !z2) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                subscriber.onError(th2);
            } else {
                subscriber.onComplete();
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable th3 = this.error;
            if (th3 != null) {
                qwVar.clear();
                subscriber.onError(th3);
                return true;
            } else if (!z2) {
                return false;
            } else {
                subscriber.onComplete();
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
        qw<ad<K, V>> qwVar = this.queue;
        Subscriber<? super ad<K, V>> subscriber = this.downstream;
        int i2 = 1;
        while (!this.cancelled.get()) {
            boolean z = this.finished;
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
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            } else {
                qwVar.clear();
                subscriber.onError(th2);
                return;
            }
        }
        qwVar.clear();
    }

    public void drainNormal() {
        int i2;
        qw<ad<K, V>> qwVar = this.queue;
        Subscriber<? super ad<K, V>> subscriber = this.downstream;
        int i3 = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                }
                boolean z = this.finished;
                ad poll = qwVar.poll();
                boolean z2 = poll == null;
                if (!checkTerminated(z, z2, subscriber, qwVar)) {
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                } else {
                    return;
                }
            }
            if (i2 != 0 || !checkTerminated(this.finished, qwVar.isEmpty(), subscriber, qwVar)) {
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.upstream.request(j2);
                }
                i3 = addAndGet(-i3);
            } else {
                return;
            }
        } while (i3 != 0);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        if (!this.done) {
            for (th<K, V> onComplete : this.groups.values()) {
                onComplete.onComplete();
            }
            this.groups.clear();
            Queue<th<K, V>> queue2 = this.evictedGroups;
            if (queue2 != null) {
                queue2.clear();
            }
            this.done = true;
            this.finished = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.done = true;
        for (th<K, V> onError : this.groups.values()) {
            onError.onError(th2);
        }
        this.groups.clear();
        Queue<th<K, V>> queue2 = this.evictedGroups;
        if (queue2 != null) {
            queue2.clear();
        }
        this.error = th2;
        this.finished = true;
        drain();
    }

    public void onNext(T t) {
        Object obj;
        if (!this.done) {
            qw<ad<K, V>> qwVar = this.queue;
            try {
                Object apply = this.keySelector.apply(t);
                boolean z = false;
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                th thVar = this.groups.get(obj);
                if (thVar == null) {
                    if (!this.cancelled.get()) {
                        thVar = th.uk(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, thVar);
                        this.groupCount.getAndIncrement();
                        z = true;
                    } else {
                        return;
                    }
                }
                try {
                    Object apply2 = this.valueSelector.apply(t);
                    th.de.p039if.ad.qw.rg(apply2, "The valueSelector returned null");
                    thVar.onNext(apply2);
                    completeEvictions();
                    if (z) {
                        qwVar.offer(thVar);
                        drain();
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                this.upstream.cancel();
                onError(th3);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request((long) this.bufferSize);
        }
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

    public ad<K, V> poll() {
        return this.queue.poll();
    }

    public void cancel(K k) {
        if (k == null) {
            k = NULL_KEY;
        }
        this.groups.remove(k);
        if (this.groupCount.decrementAndGet() == 0) {
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }
}
