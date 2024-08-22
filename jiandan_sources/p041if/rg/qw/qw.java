package p041if.rg.qw;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

/* renamed from: if.rg.qw.qw  reason: invalid package */
public final class qw {
    public static long ad(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, qw(j2, j)));
        return j2;
    }

    public static long de(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) == 0 || j2 == 0 || j3 / j2 == j) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    public static <T, R> void fe(AtomicLong atomicLong, Queue<T> queue, de<? super R> deVar, Func1<? super T, ? extends R> func1) {
        long j = atomicLong.get();
        if (j == Long.MAX_VALUE) {
            while (!deVar.isUnsubscribed()) {
                T poll = queue.poll();
                if (poll == null) {
                    deVar.onCompleted();
                    return;
                }
                deVar.onNext(func1.call(poll));
            }
            return;
        }
        do {
            long j2 = Long.MIN_VALUE;
            while (true) {
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    if (i2 == 0) {
                        if (!deVar.isUnsubscribed()) {
                            if (queue.isEmpty()) {
                                deVar.onCompleted();
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    j = atomicLong.get();
                    if (j == j2) {
                        j = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    }
                } else if (!deVar.isUnsubscribed()) {
                    T poll2 = queue.poll();
                    if (poll2 == null) {
                        deVar.onCompleted();
                        return;
                    } else {
                        deVar.onNext(func1.call(poll2));
                        j2++;
                    }
                } else {
                    return;
                }
            }
        } while (j != Long.MIN_VALUE);
    }

    public static long qw(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public static <T> boolean rg(AtomicLong atomicLong, long j, Queue<T> queue, de<? super T> deVar) {
        return th(atomicLong, j, queue, deVar, UtilityFunctions.ad());
    }

    public static <T, R> boolean th(AtomicLong atomicLong, long j, Queue<T> queue, de<? super R> deVar, Func1<? super T, ? extends R> func1) {
        long j2;
        long j3;
        AtomicLong atomicLong2 = atomicLong;
        long j4 = j;
        int i2 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j4);
        } else if (i2 == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        } else {
            while (true) {
                j2 = atomicLong.get();
                j3 = j2 & Long.MIN_VALUE;
                if (atomicLong2.compareAndSet(j2, qw(Long.MAX_VALUE & j2, j4) | j3)) {
                    break;
                }
                Queue<T> queue2 = queue;
                de<? super R> deVar2 = deVar;
                Func1<? super T, ? extends R> func12 = func1;
            }
            if (j2 == Long.MIN_VALUE) {
                fe(atomicLong2, queue, deVar, func1);
                return false;
            } else if (j3 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean uk(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public static long yj(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                throw new IllegalStateException("More produced than requested: " + j3);
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }
}
