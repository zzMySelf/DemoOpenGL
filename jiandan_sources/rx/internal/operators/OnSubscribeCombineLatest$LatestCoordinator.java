package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p041if.de;
import p041if.rg.fe.uk.fe;
import p041if.rg.qw.qw;
import rx.Observable;
import rx.Producer;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;

public final class OnSubscribeCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
    public static final Object MISSING = new Object();
    public static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public final de<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final FuncN<? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final Object[] latest;
    public final fe<Object> queue;
    public final AtomicLong requested = new AtomicLong();
    public final p041if.rg.qw.fe<T, R>[] subscribers;

    public OnSubscribeCombineLatest$LatestCoordinator(de<? super R> deVar, FuncN<? extends R> funcN, int i2, int i3, boolean z) {
        this.actual = deVar;
        this.combiner = funcN;
        this.bufferSize = i3;
        this.delayError = z;
        Object[] objArr = new Object[i2];
        this.latest = objArr;
        Arrays.fill(objArr, MISSING);
        this.subscribers = new p041if.rg.qw.fe[i2];
        this.queue = new fe<>(i3);
    }

    public void cancel(Queue<?> queue2) {
        queue2.clear();
        for (p041if.rg.qw.fe<T, R> unsubscribe : this.subscribers) {
            unsubscribe.unsubscribe();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, de<?> deVar, Queue<?> queue2, boolean z3) {
        if (this.cancelled) {
            cancel(queue2);
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue2);
                    deVar.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    deVar.onCompleted();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                Throwable th3 = this.error.get();
                if (th3 != null) {
                    deVar.onError(th3);
                } else {
                    deVar.onCompleted();
                }
                return true;
            }
        }
    }

    public void combine(Object obj, int i2) {
        boolean z;
        p041if.rg.qw.fe<T, R> feVar = this.subscribers[i2];
        synchronized (this) {
            int length = this.latest.length;
            Object obj2 = this.latest[i2];
            int i3 = this.active;
            if (obj2 == MISSING) {
                i3++;
                this.active = i3;
            }
            int i4 = this.complete;
            if (obj == null) {
                i4++;
                this.complete = i4;
            } else {
                this.latest[i2] = NotificationLite.rg(obj);
            }
            boolean z2 = false;
            z = i3 == length;
            if (i4 == length || (obj == null && obj2 == MISSING)) {
                z2 = true;
            }
            if (z2) {
                this.done = true;
            } else if (obj != null && z) {
                this.queue.m2369if(feVar, this.latest.clone());
            } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                this.done = true;
            }
        }
        if (z || obj == null) {
            drain();
        } else {
            feVar.de(1);
        }
    }

    public void drain() {
        long j;
        if (getAndIncrement() == 0) {
            fe<Object> feVar = this.queue;
            de<? super R> deVar = this.actual;
            boolean z = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i2 = 1;
            do {
                if (!checkTerminated(this.done, feVar.isEmpty(), deVar, feVar, z)) {
                    long j2 = atomicLong.get();
                    long j3 = 0;
                    while (true) {
                        if (j3 == j2) {
                            j = j3;
                            break;
                        }
                        boolean z2 = this.done;
                        p041if.rg.qw.fe feVar2 = (p041if.rg.qw.fe) feVar.peek();
                        boolean z3 = feVar2 == null;
                        p041if.rg.qw.fe feVar3 = feVar2;
                        long j4 = j3;
                        if (!checkTerminated(z2, z3, deVar, feVar, z)) {
                            if (z3) {
                                j = j4;
                                break;
                            }
                            feVar.poll();
                            Object[] objArr = (Object[]) feVar.poll();
                            if (objArr == null) {
                                this.cancelled = true;
                                cancel(feVar);
                                deVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                                return;
                            }
                            try {
                                deVar.onNext(this.combiner.call(objArr));
                                feVar3.de(1);
                                j3 = j4 + 1;
                            } catch (Throwable th2) {
                                this.cancelled = true;
                                cancel(feVar);
                                deVar.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                        qw.yj(atomicLong, j);
                    }
                    i2 = addAndGet(-i2);
                } else {
                    return;
                }
            } while (i2 != 0);
        }
    }

    public boolean isUnsubscribed() {
        return this.cancelled;
    }

    public void onError(Throwable th2) {
        Throwable th3;
        Throwable th4;
        AtomicReference<Throwable> atomicReference = this.error;
        do {
            th3 = atomicReference.get();
            if (th3 == null) {
                th4 = th2;
            } else if (th3 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th3).getExceptions());
                arrayList.add(th2);
                th4 = new CompositeException((Collection<? extends Throwable>) arrayList);
            } else {
                th4 = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th3, th2}));
            }
        } while (!atomicReference.compareAndSet(th3, th4));
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= required but it was " + j);
        } else if (i2 != 0) {
            qw.ad(this.requested, j);
            drain();
        }
    }

    public void subscribe(Observable<? extends T>[] observableArr) {
        p041if.rg.qw.fe<T, R>[] feVarArr = this.subscribers;
        int length = feVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            feVarArr[i2] = new p041if.rg.qw.fe<>(this, i2);
        }
        lazySet(0);
        this.actual.add(this);
        this.actual.setProducer(this);
        for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
            observableArr[i3].nn(feVarArr[i3]);
        }
    }

    public void unsubscribe() {
        if (!this.cancelled) {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                cancel(this.queue);
            }
        }
    }
}
