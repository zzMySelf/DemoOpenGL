package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableConcatWithCompletable<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final CompletableSource f10076th;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
        public static final long serialVersionUID = -1953724749712440952L;
        public final Observer<? super T> downstream;
        public boolean inCompletable;
        public CompletableSource other;

        public ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.downstream = observer;
            this.other = completableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            DisposableHelper.replace(this, (Disposable) null);
            CompletableSource completableSource = this.other;
            this.other = null;
            completableSource.qw(this);
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.inCompletable) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatWithCompletable(rg<T> rgVar, CompletableSource completableSource) {
        super(rgVar);
        this.f10076th = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new ConcatWithObserver(observer, this.f10076th));
    }
}
