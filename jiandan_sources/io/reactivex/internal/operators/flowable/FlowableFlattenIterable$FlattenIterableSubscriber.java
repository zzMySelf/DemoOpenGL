package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableFlattenIterable$FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -3096000382929934955L;
    public volatile boolean cancelled;
    public int consumed;
    public Iterator<? extends R> current;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public int fusionMode;
    public final int limit;
    public final Function<? super T, ? extends Iterable<? extends R>> mapper;
    public final int prefetch;
    public SimpleQueue<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public Subscription upstream;

    public FlowableFlattenIterable$FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
        this.downstream = subscriber;
        this.mapper = function;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
        if (this.cancelled) {
            this.current = null;
            simpleQueue.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (this.error.get() != null) {
                Throwable ad2 = ExceptionHelper.ad(this.error);
                this.current = null;
                simpleQueue.clear();
                subscriber.onError(ad2);
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
        this.current = null;
        this.queue.clear();
    }

    public void consumedOne(boolean z) {
        if (z) {
            int i2 = this.consumed + 1;
            if (i2 == this.limit) {
                this.consumed = 0;
                this.upstream.request((long) i2);
                return;
            }
            this.consumed = i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
        if (r6 == null) goto L_0x012b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r18 = this;
            r1 = r18
            int r0 = r18.getAndIncrement()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            org.reactivestreams.Subscriber<? super R> r2 = r1.downstream
            io.reactivex.internal.fuseable.SimpleQueue<T> r3 = r1.queue
            int r0 = r1.fusionMode
            r4 = 0
            r5 = 1
            if (r0 == r5) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            java.util.Iterator<? extends R> r6 = r1.current
            r7 = 0
            r8 = 1
        L_0x001a:
            if (r6 != 0) goto L_0x0080
            boolean r9 = r1.done
            java.lang.Object r10 = r3.poll()     // Catch:{ all -> 0x0062 }
            if (r10 != 0) goto L_0x0026
            r11 = 1
            goto L_0x0027
        L_0x0026:
            r11 = 0
        L_0x0027:
            boolean r9 = r1.checkTerminated(r9, r11, r2, r3)
            if (r9 == 0) goto L_0x002e
            return
        L_0x002e:
            if (r10 == 0) goto L_0x0080
            io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> r6 = r1.mapper     // Catch:{ all -> 0x004a }
            java.lang.Object r6 = r6.apply(r10)     // Catch:{ all -> 0x004a }
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x004a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004a }
            boolean r9 = r6.hasNext()     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x0047
            r1.consumedOne(r0)
            r6 = r7
            goto L_0x001a
        L_0x0047:
            r1.current = r6
            goto L_0x0080
        L_0x004a:
            r0 = move-exception
            th.de.o.qw.ad(r0)
            org.reactivestreams.Subscription r3 = r1.upstream
            r3.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.error
            io.reactivex.internal.util.ExceptionHelper.qw(r3, r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.ad(r0)
            r2.onError(r0)
            return
        L_0x0062:
            r0 = move-exception
            r4 = r0
            th.de.o.qw.ad(r4)
            org.reactivestreams.Subscription r0 = r1.upstream
            r0.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            io.reactivex.internal.util.ExceptionHelper.qw(r0, r4)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.ad(r0)
            r1.current = r7
            r3.clear()
            r2.onError(r0)
            return
        L_0x0080:
            if (r6 == 0) goto L_0x0123
            java.util.concurrent.atomic.AtomicLong r9 = r1.requested
            long r9 = r9.get()
            r11 = 0
            r13 = r11
        L_0x008b:
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 == 0) goto L_0x00f5
            boolean r15 = r1.done
            boolean r15 = r1.checkTerminated(r15, r4, r2, r3)
            if (r15 == 0) goto L_0x0098
            return
        L_0x0098:
            java.lang.Object r15 = r6.next()     // Catch:{ all -> 0x00db }
            java.lang.String r5 = "The iterator returned a null value"
            th.de.p039if.ad.qw.rg(r15, r5)     // Catch:{ all -> 0x00db }
            r2.onNext(r15)
            boolean r5 = r1.done
            boolean r5 = r1.checkTerminated(r5, r4, r2, r3)
            if (r5 == 0) goto L_0x00ad
            return
        L_0x00ad:
            r16 = 1
            long r13 = r13 + r16
            boolean r5 = r6.hasNext()     // Catch:{ all -> 0x00c0 }
            if (r5 != 0) goto L_0x00be
            r1.consumedOne(r0)
            r1.current = r7
            r6 = r7
            goto L_0x00f5
        L_0x00be:
            r5 = 1
            goto L_0x008b
        L_0x00c0:
            r0 = move-exception
            r3 = r0
            th.de.o.qw.ad(r3)
            r1.current = r7
            org.reactivestreams.Subscription r0 = r1.upstream
            r0.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            io.reactivex.internal.util.ExceptionHelper.qw(r0, r3)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.ad(r0)
            r2.onError(r0)
            return
        L_0x00db:
            r0 = move-exception
            th.de.o.qw.ad(r0)
            r1.current = r7
            org.reactivestreams.Subscription r3 = r1.upstream
            r3.cancel()
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.error
            io.reactivex.internal.util.ExceptionHelper.qw(r3, r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
            java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.ad(r0)
            r2.onError(r0)
            return
        L_0x00f5:
            int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x010d
            boolean r5 = r1.done
            boolean r15 = r3.isEmpty()
            if (r15 == 0) goto L_0x0105
            if (r6 != 0) goto L_0x0105
            r15 = 1
            goto L_0x0106
        L_0x0105:
            r15 = 0
        L_0x0106:
            boolean r5 = r1.checkTerminated(r5, r15, r2, r3)
            if (r5 == 0) goto L_0x010d
            return
        L_0x010d:
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0120
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0120
            java.util.concurrent.atomic.AtomicLong r5 = r1.requested
            long r9 = -r13
            r5.addAndGet(r9)
        L_0x0120:
            if (r6 != 0) goto L_0x0123
            goto L_0x012b
        L_0x0123:
            int r5 = -r8
            int r8 = r1.addAndGet(r5)
            if (r8 != 0) goto L_0x012b
            return
        L_0x012b:
            r5 = 1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable$FlattenIterableSubscriber.drain():void");
    }

    public boolean isEmpty() {
        return this.current == null && this.queue.isEmpty();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done || !ExceptionHelper.qw(this.error, th2)) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (!this.done) {
            if (this.fusionMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.downstream.onSubscribe(this);
                    subscription.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            subscription.request((long) this.prefetch);
        }
    }

    public R poll() throws Exception {
        Iterator<? extends R> it = this.current;
        while (true) {
            if (it == null) {
                T poll = this.queue.poll();
                if (poll != null) {
                    it = ((Iterable) this.mapper.apply(poll)).iterator();
                    if (it.hasNext()) {
                        this.current = it;
                        break;
                    }
                    it = null;
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        R next = it.next();
        th.de.p039if.ad.qw.rg(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.current = null;
        }
        return next;
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }

    public int requestFusion(int i2) {
        return ((i2 & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
    }
}
