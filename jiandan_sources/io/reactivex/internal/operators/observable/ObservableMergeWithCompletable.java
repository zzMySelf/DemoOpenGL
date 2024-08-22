package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.rg.qw;
import th.de.p039if.yj.rg;

public final class ObservableMergeWithCompletable<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final CompletableSource f10153th;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = -4592979584110982903L;
        public final Observer<? super T> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final AtomicReference<Disposable> mainDisposable = new AtomicReference<>();
        public volatile boolean mainDone;
        public volatile boolean otherDone;
        public final OtherObserver otherObserver = new OtherObserver(this);

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            public static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<?> parent;

            public OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            public void onComplete() {
                this.parent.otherComplete();
            }

            public void onError(Throwable th2) {
                this.parent.otherError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                rg.qw(this.downstream, this, this.error);
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.mainDisposable);
            rg.de(this.downstream, th2, this, this.error);
        }

        public void onNext(T t) {
            rg.rg(this.downstream, t, this, this.error);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.mainDisposable, disposable);
        }

        public void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                rg.qw(this.downstream, this, this.error);
            }
        }

        public void otherError(Throwable th2) {
            DisposableHelper.dispose(this.mainDisposable);
            rg.de(this.downstream, th2, this, this.error);
        }
    }

    public ObservableMergeWithCompletable(th.de.rg<T> rgVar, CompletableSource completableSource) {
        super(rgVar);
        this.f10153th = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f10756ad.subscribe(mergeWithObserver);
        this.f10153th.qw(mergeWithObserver.otherObserver);
    }
}
