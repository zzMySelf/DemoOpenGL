package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import org.reactivestreams.Subscriber;
import th.de.ppp.qw;

public final class ParallelJoin$JoinSubscription<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    public static final long serialVersionUID = 6312374661811000451L;

    public ParallelJoin$JoinSubscription(Subscriber<? super T> subscriber, int i2, int i3) {
        super(subscriber, i2, i3);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r13 == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r15 == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r3.onComplete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        if (r15 == false) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drainLoop() {
        /*
            r18 = this;
            r0 = r18
            io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber<T>[] r1 = r0.subscribers
            int r2 = r1.length
            org.reactivestreams.Subscriber<? super T> r3 = r0.downstream
            r5 = 1
        L_0x0008:
            java.util.concurrent.atomic.AtomicLong r6 = r0.requested
            long r6 = r6.get()
            r8 = 0
            r10 = r8
        L_0x0011:
            int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r13 == 0) goto L_0x0067
            boolean r13 = r0.cancelled
            if (r13 == 0) goto L_0x001d
            r18.cleanup()
            return
        L_0x001d:
            io.reactivex.internal.util.AtomicThrowable r13 = r0.errors
            java.lang.Object r13 = r13.get()
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            if (r13 == 0) goto L_0x002e
            r18.cleanup()
            r3.onError(r13)
            return
        L_0x002e:
            java.util.concurrent.atomic.AtomicInteger r13 = r0.done
            int r13 = r13.get()
            if (r13 != 0) goto L_0x0038
            r13 = 1
            goto L_0x0039
        L_0x0038:
            r13 = 0
        L_0x0039:
            r14 = 0
            r15 = 1
        L_0x003b:
            int r4 = r1.length
            if (r14 >= r4) goto L_0x005d
            r4 = r1[r14]
            io.reactivex.internal.fuseable.SimplePlainQueue<T> r12 = r4.queue
            if (r12 == 0) goto L_0x005a
            java.lang.Object r12 = r12.poll()
            if (r12 == 0) goto L_0x005a
            r3.onNext(r12)
            r4.requestOne()
            r16 = 1
            long r10 = r10 + r16
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0059
            goto L_0x0067
        L_0x0059:
            r15 = 0
        L_0x005a:
            int r14 = r14 + 1
            goto L_0x003b
        L_0x005d:
            if (r13 == 0) goto L_0x0065
            if (r15 == 0) goto L_0x0065
            r3.onComplete()
            return
        L_0x0065:
            if (r15 == 0) goto L_0x0011
        L_0x0067:
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x00ac
            boolean r4 = r0.cancelled
            if (r4 == 0) goto L_0x0073
            r18.cleanup()
            return
        L_0x0073:
            io.reactivex.internal.util.AtomicThrowable r4 = r0.errors
            java.lang.Object r4 = r4.get()
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L_0x0084
            r18.cleanup()
            r3.onError(r4)
            return
        L_0x0084:
            java.util.concurrent.atomic.AtomicInteger r4 = r0.done
            int r4 = r4.get()
            if (r4 != 0) goto L_0x008e
            r4 = 1
            goto L_0x008f
        L_0x008e:
            r4 = 0
        L_0x008f:
            r12 = 0
        L_0x0090:
            if (r12 >= r2) goto L_0x00a3
            r13 = r1[r12]
            io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.queue
            if (r13 == 0) goto L_0x00a0
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x00a0
            r12 = 0
            goto L_0x00a4
        L_0x00a0:
            int r12 = r12 + 1
            goto L_0x0090
        L_0x00a3:
            r12 = 1
        L_0x00a4:
            if (r4 == 0) goto L_0x00ac
            if (r12 == 0) goto L_0x00ac
            r3.onComplete()
            return
        L_0x00ac:
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x00bf
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x00bf
            java.util.concurrent.atomic.AtomicLong r4 = r0.requested
            long r6 = -r10
            r4.addAndGet(r6)
        L_0x00bf:
            int r4 = r18.get()
            if (r4 != r5) goto L_0x00cd
            int r4 = -r5
            int r4 = r0.addAndGet(r4)
            if (r4 != 0) goto L_0x00cd
            return
        L_0x00cd:
            r5 = r4
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscription.drainLoop():void");
    }

    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.compareAndSet((Object) null, th2)) {
            cancelAll();
            drain();
        } else if (th2 != this.errors.get()) {
            qw.ddd(th2);
        }
    }

    public void onNext(ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber, T t) {
        if (get() == 0 && compareAndSet(0, 1)) {
            if (this.requested.get() != 0) {
                this.downstream.onNext(t);
                if (this.requested.get() != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                parallelJoin$JoinInnerSubscriber.request(1);
            } else if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                if (this.errors.compareAndSet((Object) null, missingBackpressureException)) {
                    this.downstream.onError(missingBackpressureException);
                    return;
                } else {
                    qw.ddd(missingBackpressureException);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t)) {
            cancelAll();
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        } else if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }
}
