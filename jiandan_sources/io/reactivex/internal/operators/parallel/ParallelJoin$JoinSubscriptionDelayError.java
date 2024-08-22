package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import org.reactivestreams.Subscriber;

public final class ParallelJoin$JoinSubscriptionDelayError<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    public static final long serialVersionUID = -5737965195918321883L;

    public ParallelJoin$JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i2, int i3) {
        super(subscriber, i2, i3);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r13 == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (r15 == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (((java.lang.Throwable) r0.errors.get()) == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
        r3.onError(r0.errors.terminate());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        r3.onComplete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        if (r15 == false) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return;
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
            if (r13 == 0) goto L_0x0069
            boolean r13 = r0.cancelled
            if (r13 == 0) goto L_0x001d
            r18.cleanup()
            return
        L_0x001d:
            java.util.concurrent.atomic.AtomicInteger r13 = r0.done
            int r13 = r13.get()
            if (r13 != 0) goto L_0x0027
            r13 = 1
            goto L_0x0028
        L_0x0027:
            r13 = 0
        L_0x0028:
            r14 = 0
            r15 = 1
        L_0x002a:
            if (r14 >= r2) goto L_0x004b
            r4 = r1[r14]
            io.reactivex.internal.fuseable.SimplePlainQueue<T> r12 = r4.queue
            if (r12 == 0) goto L_0x0048
            java.lang.Object r12 = r12.poll()
            if (r12 == 0) goto L_0x0048
            r3.onNext(r12)
            r4.requestOne()
            r16 = 1
            long r10 = r10 + r16
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0047
            goto L_0x0069
        L_0x0047:
            r15 = 0
        L_0x0048:
            int r14 = r14 + 1
            goto L_0x002a
        L_0x004b:
            if (r13 == 0) goto L_0x0067
            if (r15 == 0) goto L_0x0067
            io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
            java.lang.Object r1 = r1.get()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0063
            io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
            java.lang.Throwable r1 = r1.terminate()
            r3.onError(r1)
            goto L_0x0066
        L_0x0063:
            r3.onComplete()
        L_0x0066:
            return
        L_0x0067:
            if (r15 == 0) goto L_0x0011
        L_0x0069:
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x00b1
            boolean r4 = r0.cancelled
            if (r4 == 0) goto L_0x0075
            r18.cleanup()
            return
        L_0x0075:
            java.util.concurrent.atomic.AtomicInteger r4 = r0.done
            int r4 = r4.get()
            if (r4 != 0) goto L_0x007f
            r4 = 1
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            r12 = 0
        L_0x0081:
            if (r12 >= r2) goto L_0x0094
            r13 = r1[r12]
            io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.queue
            if (r13 == 0) goto L_0x0091
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x0091
            r12 = 0
            goto L_0x0095
        L_0x0091:
            int r12 = r12 + 1
            goto L_0x0081
        L_0x0094:
            r12 = 1
        L_0x0095:
            if (r4 == 0) goto L_0x00b1
            if (r12 == 0) goto L_0x00b1
            io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
            java.lang.Object r1 = r1.get()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x00ad
            io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
            java.lang.Throwable r1 = r1.terminate()
            r3.onError(r1)
            goto L_0x00b0
        L_0x00ad:
            r3.onComplete()
        L_0x00b0:
            return
        L_0x00b1:
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x00c4
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x00c4
            java.util.concurrent.atomic.AtomicLong r4 = r0.requested
            long r6 = -r10
            r4.addAndGet(r6)
        L_0x00c4:
            int r4 = r18.get()
            if (r4 != r5) goto L_0x00d2
            int r4 = -r5
            int r4 = r0.addAndGet(r4)
            if (r4 != 0) goto L_0x00d2
            return
        L_0x00d2:
            r5 = r4
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionDelayError.drainLoop():void");
    }

    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    public void onError(Throwable th2) {
        this.errors.addThrowable(th2);
        this.done.decrementAndGet();
        drain();
    }

    public void onNext(ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber, T t) {
        if (get() != 0 || !compareAndSet(0, 1)) {
            if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t) && parallelJoin$JoinInnerSubscriber.cancel()) {
                this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
            }
            if (getAndIncrement() != 0) {
                return;
            }
        } else {
            if (this.requested.get() != 0) {
                this.downstream.onNext(t);
                if (this.requested.get() != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                parallelJoin$JoinInnerSubscriber.request(1);
            } else if (!parallelJoin$JoinInnerSubscriber.getQueue().offer(t)) {
                parallelJoin$JoinInnerSubscriber.cancel();
                this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
                drainLoop();
                return;
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        drainLoop();
    }
}
