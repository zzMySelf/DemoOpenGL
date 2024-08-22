package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.fe.i.e;
import p041if.rg.fe.i.vvv;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    public static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    public static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    public static final long serialVersionUID = -3741892510772238743L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final qw<T> parent;
    public final int prefetch;
    public volatile Producer producer;
    public final Queue<T> queue;
    public volatile PublishProducer<T>[] subscribers;

    public static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        public static final long serialVersionUID = 960704844171597367L;
        public final de<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(de<? super T> deVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = deVar;
            this.parent = onSubscribePublishMulticast;
        }

        public boolean isUnsubscribed() {
            return this.once.get();
        }

        public void request(long j) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i2 != 0) {
                p041if.rg.qw.qw.ad(this, j);
                this.parent.drain();
            }
        }

        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    public static final class qw<T> extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final OnSubscribePublishMulticast<T> f11413ad;

        public qw(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f11413ad = onSubscribePublishMulticast;
        }

        public void onCompleted() {
            this.f11413ad.onCompleted();
        }

        public void onError(Throwable th2) {
            this.f11413ad.onError(th2);
        }

        public void onNext(T t) {
            this.f11413ad.onNext(t);
        }

        public void setProducer(Producer producer) {
            this.f11413ad.setProducer(producer);
        }
    }

    public OnSubscribePublishMulticast(int i2, boolean z) {
        if (i2 > 0) {
            this.prefetch = i2;
            this.delayError = z;
            if (e.ad()) {
                this.queue = new vvv(i2);
            } else {
                this.queue = new p041if.rg.fe.uk.de(i2);
            }
            this.subscribers = EMPTY;
            this.parent = new qw<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i2);
    }

    public boolean add(PublishProducer<T> publishProducer) {
        if (this.subscribers == TERMINATED) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            if (publishProducerArr == TERMINATED) {
                return false;
            }
            int length = publishProducerArr.length;
            PublishProducer<T>[] publishProducerArr2 = new PublishProducer[(length + 1)];
            System.arraycopy(publishProducerArr, 0, publishProducerArr2, 0, length);
            publishProducerArr2[length] = publishProducer;
            this.subscribers = publishProducerArr2;
            return true;
        }
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        int i2 = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    PublishProducer[] terminate = terminate();
                    int length = terminate.length;
                    while (i2 < length) {
                        terminate[i2].actual.onError(th2);
                        i2++;
                    }
                    return true;
                } else if (z2) {
                    PublishProducer[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i2 < length2) {
                        terminate2[i2].actual.onCompleted();
                        i2++;
                    }
                    return true;
                }
            } else if (z2) {
                PublishProducer[] terminate3 = terminate();
                Throwable th3 = this.error;
                if (th3 != null) {
                    int length3 = terminate3.length;
                    while (i2 < length3) {
                        terminate3[i2].actual.onError(th3);
                        i2++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i2 < length4) {
                        terminate3[i2].actual.onCompleted();
                        i2++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void drain() {
        int i2;
        if (getAndIncrement() == 0) {
            Queue<T> queue2 = this.queue;
            int i3 = 0;
            do {
                long j = Long.MAX_VALUE;
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j = Math.min(j, publishProducer.get());
                }
                if (length != 0) {
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.done;
                        T poll = queue2.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2)) {
                            if (z2) {
                                break;
                            }
                            for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                                publishProducer2.actual.onNext(poll);
                            }
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i2 == 0 && checkTerminated(this.done, queue2.isEmpty())) {
                        return;
                    }
                    if (j2 != 0) {
                        Producer producer2 = this.producer;
                        if (producer2 != null) {
                            producer2.request(j2);
                        }
                        for (PublishProducer<T> yj2 : publishProducerArr) {
                            p041if.rg.qw.qw.yj(yj2, j2);
                        }
                    }
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    public void onCompleted() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.internal.operators.OnSubscribePublishMulticast.PublishProducer<T> r7) {
        /*
            r6 = this;
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r6.subscribers
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = TERMINATED
            if (r0 == r1) goto L_0x0048
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = EMPTY
            if (r0 != r1) goto L_0x000b
            goto L_0x0048
        L_0x000b:
            monitor-enter(r6)
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r6.subscribers     // Catch:{ all -> 0x0045 }
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = TERMINATED     // Catch:{ all -> 0x0045 }
            if (r0 == r1) goto L_0x0043
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = EMPTY     // Catch:{ all -> 0x0045 }
            if (r0 != r1) goto L_0x0017
            goto L_0x0043
        L_0x0017:
            r1 = -1
            int r2 = r0.length     // Catch:{ all -> 0x0045 }
            r3 = 0
            r4 = 0
        L_0x001b:
            if (r4 >= r2) goto L_0x0026
            r5 = r0[r4]     // Catch:{ all -> 0x0045 }
            if (r5 != r7) goto L_0x0023
            r1 = r4
            goto L_0x0026
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0026:
            if (r1 >= 0) goto L_0x002a
            monitor-exit(r6)     // Catch:{ all -> 0x0045 }
            return
        L_0x002a:
            r7 = 1
            if (r2 != r7) goto L_0x0030
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r7 = EMPTY     // Catch:{ all -> 0x0045 }
            goto L_0x003f
        L_0x0030:
            int r4 = r2 + -1
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer[] r4 = new rx.internal.operators.OnSubscribePublishMulticast.PublishProducer[r4]     // Catch:{ all -> 0x0045 }
            java.lang.System.arraycopy(r0, r3, r4, r3, r1)     // Catch:{ all -> 0x0045 }
            int r3 = r1 + 1
            int r2 = r2 - r1
            int r2 = r2 - r7
            java.lang.System.arraycopy(r0, r3, r4, r1, r2)     // Catch:{ all -> 0x0045 }
            r7 = r4
        L_0x003f:
            r6.subscribers = r7     // Catch:{ all -> 0x0045 }
            monitor-exit(r6)     // Catch:{ all -> 0x0045 }
            return
        L_0x0043:
            monitor-exit(r6)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0045 }
            throw r7
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribePublishMulticast.remove(rx.internal.operators.OnSubscribePublishMulticast$PublishProducer):void");
    }

    public void setProducer(Producer producer2) {
        this.producer = producer2;
        producer2.request((long) this.prefetch);
    }

    public de<T> subscriber() {
        return this.parent;
    }

    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        if (publishProducerArr != TERMINATED) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != TERMINATED) {
                    this.subscribers = TERMINATED;
                }
            }
        }
        return publishProducerArr;
    }

    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public void call(de<? super T> deVar) {
        PublishProducer publishProducer = new PublishProducer(deVar, this);
        deVar.add(publishProducer);
        deVar.setProducer(publishProducer);
        if (!add(publishProducer)) {
            Throwable th2 = this.error;
            if (th2 != null) {
                deVar.onError(th2);
            } else {
                deVar.onCompleted();
            }
        } else if (publishProducer.isUnsubscribed()) {
            remove(publishProducer);
        } else {
            drain();
        }
    }
}
