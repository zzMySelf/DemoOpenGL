package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import th.de.o.qw;

public final class SingleFlatMapIterableObservable$FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
    public static final long serialVersionUID = -8938804753851907758L;
    public volatile boolean cancelled;
    public final Observer<? super R> downstream;
    public volatile Iterator<? extends R> it;
    public final Function<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;
    public Disposable upstream;

    public SingleFlatMapIterableObservable$FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.downstream = observer;
        this.mapper = function;
    }

    public void clear() {
        this.it = null;
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean isEmpty() {
        return this.it == null;
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
        Observer<? super R> observer = this.downstream;
        try {
            Iterator<? extends R> it2 = ((Iterable) this.mapper.apply(t)).iterator();
            if (!it2.hasNext()) {
                observer.onComplete();
            } else if (this.outputFused) {
                this.it = it2;
                observer.onNext(null);
                observer.onComplete();
            } else {
                while (!this.cancelled) {
                    try {
                        observer.onNext(it2.next());
                        if (!this.cancelled) {
                            try {
                                if (!it2.hasNext()) {
                                    observer.onComplete();
                                    return;
                                }
                            } catch (Throwable th2) {
                                qw.ad(th2);
                                observer.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        qw.ad(th3);
                        observer.onError(th3);
                        return;
                    }
                }
            }
        } catch (Throwable th4) {
            qw.ad(th4);
            this.downstream.onError(th4);
        }
    }

    public R poll() throws Exception {
        Iterator<? extends R> it2 = this.it;
        if (it2 == null) {
            return null;
        }
        R next = it2.next();
        th.de.p039if.ad.qw.rg(next, "The iterator returned a null value");
        if (!it2.hasNext()) {
            this.it = null;
        }
        return next;
    }

    public int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
