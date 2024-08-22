package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.p039if.rg.qw;

public final class FlowableWindow$WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final long serialVersionUID = 2428527070996323976L;
    public final int bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final Subscriber<? super ad<T>> downstream;
    public Throwable error;
    public final AtomicBoolean firstRequest = new AtomicBoolean();
    public long index;
    public final AtomicBoolean once = new AtomicBoolean();
    public long produced;
    public final qw<UnicastProcessor<T>> queue;
    public final AtomicLong requested = new AtomicLong();
    public final long size;
    public final long skip;
    public Subscription upstream;
    public final ArrayDeque<UnicastProcessor<T>> windows = new ArrayDeque<>();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableWindow$WindowOverlapSubscriber(Subscriber<? super ad<T>> subscriber, long j, long j2, int i2) {
        super(1);
        this.downstream = subscriber;
        this.size = j;
        this.skip = j2;
        this.queue = new qw<>(i2);
        this.bufferSize = i2;
    }

    public void cancel() {
        this.cancelled = true;
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, qw<?> qwVar) {
        if (this.cancelled) {
            qwVar.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable th2 = this.error;
            if (th2 != null) {
                qwVar.clear();
                subscriber.onError(th2);
                return true;
            } else if (!z2) {
                return false;
            } else {
                subscriber.onComplete();
                return true;
            }
        }
    }

    public void drain() {
        int i2;
        if (this.wip.getAndIncrement() == 0) {
            Subscriber<? super ad<T>> subscriber = this.downstream;
            qw<UnicastProcessor<T>> qwVar = this.queue;
            int i3 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.done;
                    UnicastProcessor poll = qwVar.poll();
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
                if (i2 != 0 || !checkTerminated(this.done, qwVar.isEmpty(), subscriber, qwVar)) {
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        this.requested.addAndGet(-j2);
                    }
                    i3 = this.wip.addAndGet(-i3);
                } else {
                    return;
                }
            } while (i3 != 0);
        }
    }

    public void onComplete() {
        if (!this.done) {
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        Iterator<UnicastProcessor<T>> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onError(th2);
        }
        this.windows.clear();
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (!this.done) {
            long j = this.index;
            if (j == 0 && !this.cancelled) {
                getAndIncrement();
                UnicastProcessor o2 = UnicastProcessor.o(this.bufferSize, this);
                this.windows.offer(o2);
                this.queue.offer(o2);
                drain();
            }
            long j2 = j + 1;
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j3 = this.produced + 1;
            if (j3 == this.size) {
                this.produced = j3 - this.skip;
                Processor poll = this.windows.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.produced = j3;
            }
            if (j2 == this.skip) {
                this.index = 0;
            } else {
                this.index = j2;
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                this.upstream.request(th.de.p039if.yj.qw.fe(this.skip, j));
            } else {
                this.upstream.request(th.de.p039if.yj.qw.de(this.size, th.de.p039if.yj.qw.fe(this.skip, j - 1)));
            }
            drain();
        }
    }

    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
