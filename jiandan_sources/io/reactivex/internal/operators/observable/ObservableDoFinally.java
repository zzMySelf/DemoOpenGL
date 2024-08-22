package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import th.de.p039if.fe.rg.qw;

public final class ObservableDoFinally<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Action f10090th;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        public static final long serialVersionUID = 4109457741734051389L;
        public final Observer<? super T> downstream;
        public final Action onFinally;
        public QueueDisposable<T> qd;
        public boolean syncFused;
        public Disposable upstream;

        public DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.downstream = observer;
            this.onFinally = action;
        }

        public void clear() {
            this.qd.clear();
        }

        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            runFinally();
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.qd = (QueueDisposable) disposable;
                }
                this.downstream.onSubscribe(this);
            }
        }

        public T poll() throws Exception {
            T poll = this.qd.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        public int requestFusion(int i2) {
            QueueDisposable<T> queueDisposable = this.qd;
            boolean z = false;
            if (queueDisposable == null || (i2 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(i2);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.syncFused = z;
            }
            return requestFusion;
        }

        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    th.de.ppp.qw.ddd(th2);
                }
            }
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.f10090th = action;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new DoFinallyObserver(observer, this.f10090th));
    }
}
