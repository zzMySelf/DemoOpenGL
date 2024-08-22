package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import th.de.p039if.ad.qw;

public final class MaybeFlatMapIterableFlowable$FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
    public static final long serialVersionUID = -8938804753851907758L;
    public volatile boolean cancelled;
    public final Subscriber<? super R> downstream;
    public volatile Iterator<? extends R> it;
    public final Function<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;
    public final AtomicLong requested = new AtomicLong();
    public Disposable upstream;

    public MaybeFlatMapIterableFlowable$FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.downstream = subscriber;
        this.mapper = function;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public void clear() {
        this.it = null;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            Subscriber<? super R> subscriber = this.downstream;
            Iterator<? extends R> it2 = this.it;
            if (!this.outputFused || it2 == null) {
                int i2 = 1;
                while (true) {
                    if (it2 != null) {
                        long j = this.requested.get();
                        if (j == Long.MAX_VALUE) {
                            fastPath(subscriber, it2);
                            return;
                        }
                        long j2 = 0;
                        while (j2 != j) {
                            if (!this.cancelled) {
                                try {
                                    Object next = it2.next();
                                    qw.rg(next, "The iterator returned a null value");
                                    subscriber.onNext(next);
                                    if (!this.cancelled) {
                                        j2++;
                                        try {
                                            if (!it2.hasNext()) {
                                                subscriber.onComplete();
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            th.de.o.qw.ad(th2);
                                            subscriber.onError(th2);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    th.de.o.qw.ad(th3);
                                    subscriber.onError(th3);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j2 != 0) {
                            th.de.p039if.yj.qw.rg(this.requested, j2);
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 != 0) {
                        if (it2 == null) {
                            it2 = this.it;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                subscriber.onNext(null);
                subscriber.onComplete();
            }
        }
    }

    public void fastPath(Subscriber<? super R> subscriber, Iterator<? extends R> it2) {
        while (!this.cancelled) {
            try {
                subscriber.onNext(it2.next());
                if (!this.cancelled) {
                    try {
                        if (!it2.hasNext()) {
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        subscriber.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                subscriber.onError(th3);
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.it == null;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        try {
            Iterator<? extends R> it2 = ((Iterable) this.mapper.apply(t)).iterator();
            if (!it2.hasNext()) {
                this.downstream.onComplete();
                return;
            }
            this.it = it2;
            drain();
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.downstream.onError(th2);
        }
    }

    public R poll() throws Exception {
        Iterator<? extends R> it2 = this.it;
        if (it2 == null) {
            return null;
        }
        R next = it2.next();
        qw.rg(next, "The iterator returned a null value");
        if (!it2.hasNext()) {
            this.it = null;
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
        if ((i2 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
