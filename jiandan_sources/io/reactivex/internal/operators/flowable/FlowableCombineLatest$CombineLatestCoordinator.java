package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import th.de.p039if.rg.qw;

public final class FlowableCombineLatest$CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
    public static final long serialVersionUID = -5082275438355852221L;
    public volatile boolean cancelled;
    public final Function<? super Object[], ? extends R> combiner;
    public int completedSources;
    public final boolean delayErrors;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public int nonEmptySources;
    public boolean outputFused;
    public final qw<Object> queue;
    public final AtomicLong requested;
    public final FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] subscribers;

    public FlowableCombineLatest$CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
        this.downstream = subscriber;
        this.combiner = function;
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = new FlowableCombineLatest$CombineLatestInnerSubscriber[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            flowableCombineLatest$CombineLatestInnerSubscriberArr[i4] = new FlowableCombineLatest$CombineLatestInnerSubscriber<>(this, i4, i3);
        }
        this.subscribers = flowableCombineLatest$CombineLatestInnerSubscriberArr;
        this.latest = new Object[i2];
        this.queue = new qw<>(i3);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
        this.delayErrors = z;
    }

    public void cancel() {
        this.cancelled = true;
        cancelAll();
    }

    public void cancelAll() {
        for (FlowableCombineLatest$CombineLatestInnerSubscriber<T> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, qw<?> qwVar) {
        if (this.cancelled) {
            cancelAll();
            qwVar.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!this.delayErrors) {
                Throwable ad2 = ExceptionHelper.ad(this.error);
                if (ad2 != null && ad2 != ExceptionHelper.qw) {
                    cancelAll();
                    qwVar.clear();
                    subscriber.onError(ad2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    cancelAll();
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                cancelAll();
                Throwable ad3 = ExceptionHelper.ad(this.error);
                if (ad3 == null || ad3 == ExceptionHelper.qw) {
                    subscriber.onComplete();
                } else {
                    subscriber.onError(ad3);
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
                drainOutput();
            } else {
                drainAsync();
            }
        }
    }

    public void drainAsync() {
        int i2;
        Subscriber<? super R> subscriber = this.downstream;
        qw<Object> qwVar = this.queue;
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
                Object poll = qwVar.poll();
                boolean z2 = poll == null;
                if (!checkTerminated(z, z2, subscriber, qwVar)) {
                    if (z2) {
                        break;
                    }
                    try {
                        Object apply = this.combiner.apply((Object[]) qwVar.poll());
                        th.de.p039if.ad.qw.rg(apply, "The combiner returned a null value");
                        subscriber.onNext(apply);
                        ((FlowableCombineLatest$CombineLatestInnerSubscriber) poll).requestOne();
                        j2++;
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        cancelAll();
                        ExceptionHelper.qw(this.error, th2);
                        subscriber.onError(ExceptionHelper.ad(this.error));
                        return;
                    }
                } else {
                    return;
                }
            }
            if (i2 != 0 || !checkTerminated(this.done, qwVar.isEmpty(), subscriber, qwVar)) {
                if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                    this.requested.addAndGet(-j2);
                }
                i3 = addAndGet(-i3);
            } else {
                return;
            }
        } while (i3 != 0);
    }

    public void drainOutput() {
        Subscriber<? super R> subscriber = this.downstream;
        qw<Object> qwVar = this.queue;
        int i2 = 1;
        while (!this.cancelled) {
            Throwable th2 = this.error.get();
            if (th2 != null) {
                qwVar.clear();
                subscriber.onError(th2);
                return;
            }
            boolean z = this.done;
            boolean isEmpty = qwVar.isEmpty();
            if (!isEmpty) {
                subscriber.onNext(null);
            }
            if (!z || !isEmpty) {
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                subscriber.onComplete();
                return;
            }
        }
        qwVar.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void innerComplete(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Object[] r0 = r2.latest     // Catch:{ all -> 0x001c }
            r3 = r0[r3]     // Catch:{ all -> 0x001c }
            r1 = 1
            if (r3 == 0) goto L_0x0015
            int r3 = r2.completedSources     // Catch:{ all -> 0x001c }
            int r3 = r3 + r1
            int r0 = r0.length     // Catch:{ all -> 0x001c }
            if (r3 != r0) goto L_0x0011
            r2.done = r1     // Catch:{ all -> 0x001c }
            goto L_0x0017
        L_0x0011:
            r2.completedSources = r3     // Catch:{ all -> 0x001c }
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            return
        L_0x0015:
            r2.done = r1     // Catch:{ all -> 0x001c }
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            r2.drain()
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCombineLatest$CombineLatestCoordinator.innerComplete(int):void");
    }

    public void innerError(int i2, Throwable th2) {
        if (!ExceptionHelper.qw(this.error, th2)) {
            th.de.ppp.qw.ddd(th2);
        } else if (!this.delayErrors) {
            cancelAll();
            this.done = true;
            drain();
        } else {
            innerComplete(i2);
        }
    }

    public void innerValue(int i2, T t) {
        boolean z;
        synchronized (this) {
            Object[] objArr = this.latest;
            int i3 = this.nonEmptySources;
            if (objArr[i2] == null) {
                i3++;
                this.nonEmptySources = i3;
            }
            objArr[i2] = t;
            if (objArr.length == i3) {
                this.queue.m2355if(this.subscribers[i2], objArr.clone());
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            this.subscribers[i2].requestOne();
        } else {
            drain();
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public R poll() throws Exception {
        Object poll = this.queue.poll();
        if (poll == null) {
            return null;
        }
        R apply = this.combiner.apply((Object[]) this.queue.poll());
        th.de.p039if.ad.qw.rg(apply, "The combiner returned a null value");
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) poll).requestOne();
        return apply;
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }

    public int requestFusion(int i2) {
        boolean z = false;
        if ((i2 & 4) != 0) {
            return 0;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            z = true;
        }
        this.outputFused = z;
        return i3;
    }

    public void subscribe(Publisher<? extends T>[] publisherArr, int i2) {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = this.subscribers;
        for (int i3 = 0; i3 < i2 && !this.done && !this.cancelled; i3++) {
            publisherArr[i3].subscribe(flowableCombineLatest$CombineLatestInnerSubscriberArr[i3]);
        }
    }
}
