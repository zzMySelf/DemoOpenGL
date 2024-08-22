package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.rg;

public final class ObservableConcatWithSingle<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final SingleSource<? extends T> f10078th;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
        public static final long serialVersionUID = -1953724749712440952L;
        public final Observer<? super T> downstream;
        public boolean inSingle;
        public SingleSource<? extends T> other;

        public ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
            this.downstream = observer;
            this.other = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.inSingle = true;
            DisposableHelper.replace(this, (Disposable) null);
            SingleSource<? extends T> singleSource = this.other;
            this.other = null;
            singleSource.qw(this);
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.inSingle) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithSingle(rg<T> rgVar, SingleSource<? extends T> singleSource) {
        super(rgVar);
        this.f10078th = singleSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new ConcatWithObserver(observer, this.f10078th));
    }
}
