package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import java.util.Iterator;
import th.de.o.qw;

public final class FlowableFromIterable$IteratorConditionalSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    public static final long serialVersionUID = -6022804456014692607L;
    public final ConditionalSubscriber<? super T> downstream;

    public FlowableFromIterable$IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
        super(it);
        this.downstream = conditionalSubscriber;
    }

    public void fastPath() {
        Iterator<? extends T> it = this.it;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
        while (!this.cancelled) {
            try {
                Object next = it.next();
                if (!this.cancelled) {
                    if (next == null) {
                        conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    conditionalSubscriber.tryOnNext(next);
                    if (!this.cancelled) {
                        try {
                            if (!it.hasNext()) {
                                if (!this.cancelled) {
                                    conditionalSubscriber.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            qw.ad(th2);
                            conditionalSubscriber.onError(th2);
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
                conditionalSubscriber.onError(th3);
                return;
            }
        }
    }

    public void slowPath(long j) {
        Iterator<? extends T> it = this.it;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
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
                                conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            boolean tryOnNext = conditionalSubscriber.tryOnNext(next);
                            if (!this.cancelled) {
                                try {
                                    if (!it.hasNext()) {
                                        if (!this.cancelled) {
                                            conditionalSubscriber.onComplete();
                                            return;
                                        }
                                        return;
                                    } else if (tryOnNext) {
                                        j2++;
                                    }
                                } catch (Throwable th2) {
                                    qw.ad(th2);
                                    conditionalSubscriber.onError(th2);
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
                        conditionalSubscriber.onError(th3);
                        return;
                    }
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
