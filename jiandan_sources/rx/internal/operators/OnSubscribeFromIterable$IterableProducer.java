package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.fe.qw;
import rx.Producer;

public final class OnSubscribeFromIterable$IterableProducer<T> extends AtomicLong implements Producer {
    public static final long serialVersionUID = -8730475647105475802L;
    public final Iterator<? extends T> it;

    /* renamed from: o  reason: collision with root package name */
    public final de<? super T> f11382o;

    public OnSubscribeFromIterable$IterableProducer(de<? super T> deVar, Iterator<? extends T> it2) {
        this.f11382o = deVar;
        this.it = it2;
    }

    public void fastPath() {
        de<? super T> deVar = this.f11382o;
        Iterator<? extends T> it2 = this.it;
        while (!deVar.isUnsubscribed()) {
            try {
                deVar.onNext(it2.next());
                if (!deVar.isUnsubscribed()) {
                    try {
                        if (!it2.hasNext()) {
                            if (!deVar.isUnsubscribed()) {
                                deVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th2) {
                        qw.th(th2, deVar);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                qw.th(th3, deVar);
                return;
            }
        }
    }

    public void request(long j) {
        if (get() != Long.MAX_VALUE) {
            if (j == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && p041if.rg.qw.qw.ad(this, j) == 0) {
                slowPath(j);
            }
        }
    }

    public void slowPath(long j) {
        de<? super T> deVar = this.f11382o;
        Iterator<? extends T> it2 = this.it;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j) {
                    j = get();
                    if (j2 == j) {
                        j = p041if.rg.qw.qw.yj(this, j2);
                    }
                } else if (!deVar.isUnsubscribed()) {
                    try {
                        deVar.onNext(it2.next());
                        if (!deVar.isUnsubscribed()) {
                            try {
                                if (it2.hasNext()) {
                                    j2++;
                                } else if (!deVar.isUnsubscribed()) {
                                    deVar.onCompleted();
                                    return;
                                } else {
                                    return;
                                }
                            } catch (Throwable th2) {
                                qw.th(th2, deVar);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        qw.th(th3, deVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
