package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;

public final class ObservableFlatMapCompletable<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f10095th;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f10096yj;

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        public static final long serialVersionUID = 8443155186132538303L;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final Observer<? super T> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final Function<? super T, ? extends CompletableSource> mapper;
        public final th.de.i.qw set = new th.de.i.qw();
        public Disposable upstream;

        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            public static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onComplete() {
                FlatMapCompletableMainObserver.this.innerComplete(this);
            }

            public void onError(Throwable th2) {
                FlatMapCompletableMainObserver.this.innerError(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public FlatMapCompletableMainObserver(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
            lazySet(1);
        }

        public void clear() {
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        public void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.de(innerObserver);
            onComplete();
        }

        public void innerError(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
            this.set.de(innerObserver);
            onError(th2);
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.downstream.onError(terminate);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.errors.addThrowable(th2)) {
                th.de.ppp.qw.ddd(th2);
            } else if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.downstream.onError(this.errors.terminate());
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.mapper.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.disposed && this.set.ad(innerObserver)) {
                    completableSource.qw(innerObserver);
                }
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public T poll() throws Exception {
            return null;
        }

        public int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        super(observableSource);
        this.f10095th = function;
        this.f10096yj = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new FlatMapCompletableMainObserver(observer, this.f10095th, this.f10096yj));
    }
}
