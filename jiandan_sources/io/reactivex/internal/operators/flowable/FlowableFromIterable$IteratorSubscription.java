package io.reactivex.internal.operators.flowable;

import java.util.Iterator;
import org.reactivestreams.Subscriber;
import th.de.o.qw;

public final class FlowableFromIterable$IteratorSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    public static final long serialVersionUID = -6022804456014692607L;
    public final Subscriber<? super T> downstream;

    public FlowableFromIterable$IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        super(it);
        this.downstream = subscriber;
    }

    public void fastPath() {
        Iterator<? extends T> it = this.it;
        Subscriber<? super T> subscriber = this.downstream;
        while (!this.cancelled) {
            try {
                Object next = it.next();
                if (!this.cancelled) {
                    if (next == null) {
                        subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    subscriber.onNext(next);
                    if (!this.cancelled) {
                        try {
                            if (!it.hasNext()) {
                                if (!this.cancelled) {
                                    subscriber.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            qw.ad(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                qw.ad(th3);
                subscriber.onError(th3);
                return;
            }
        }
    }

    public void slowPath(long j) {
        Iterator<? extends T> it = this.it;
        Subscriber<? super T> subscriber = this.downstream;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j) {
                    j = get();
                    if (j2 == j) {
                        j = addAndGet(-j2);
                    }
                } else if (!this.cancelled) {
                    try {
                        Object next = it.next();
                        if (!this.cancelled) {
                            if (next == null) {
                                subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            subscriber.onNext(next);
                            if (!this.cancelled) {
                                try {
                                    if (it.hasNext()) {
                                        j2++;
                                    } else if (!this.cancelled) {
                                        subscriber.onComplete();
                                        return;
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    qw.ad(th2);
                                    subscriber.onError(th2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        qw.ad(th3);
                        subscriber.onError(th3);
                        return;
                    }
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
