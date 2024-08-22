package th.de.p039if.yj;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.rg.qw;

/* renamed from: th.de.if.yj.uk  reason: invalid package */
public final class uk {
    public static <T> SimpleQueue<T> ad(int i2) {
        if (i2 < 0) {
            return new qw(-i2);
        }
        return new SpscArrayQueue(i2);
    }

    public static <T, U> void de(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        int i2 = 1;
        while (!qw(observableQueueDrain.fe(), simplePlainQueue.isEmpty(), observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean fe2 = observableQueueDrain.fe();
                T poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (!qw(fe2, z2, observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                    if (z2) {
                        i2 = observableQueueDrain.de(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observableQueueDrain.qw(observer, poll);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static boolean fe(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            return true;
        }
    }

    public static <T, U> boolean qw(boolean z, boolean z2, Observer<?> observer, boolean z3, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.rg()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable ad2 = observableQueueDrain.ad();
                if (ad2 != null) {
                    simpleQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onError(ad2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                if (disposable != null) {
                    disposable.dispose();
                }
                Throwable ad3 = observableQueueDrain.ad();
                if (ad3 != null) {
                    observer.onError(ad3);
                } else {
                    observer.onComplete();
                }
                return true;
            }
        }
    }

    public static <T> void rg(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            subscriber.onComplete();
        } else if (!th(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            do {
                j = atomicLong.get();
                if ((j & Long.MIN_VALUE) == 0) {
                    j2 = j | Long.MIN_VALUE;
                } else {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j2));
            if (j != 0) {
                th(j2, subscriber, queue, atomicLong, booleanSupplier);
            }
        }
    }

    public static <T> boolean th(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (fe(booleanSupplier)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j2++;
            } else if (fe(booleanSupplier)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static void uk(Subscription subscription, int i2) {
        subscription.request(i2 < 0 ? Long.MAX_VALUE : (long) i2);
    }

    public static <T> boolean yj(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2;
        long j3 = j;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, qw.de(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 != Long.MIN_VALUE) {
            return false;
        }
        th(j3 | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
        return true;
    }
}
