package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMapCompletable$SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {

    public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
        public static final long serialVersionUID = -8003404460084760287L;
        public final FlowableSwitchMapCompletable$SwitchMapCompletableObserver<?> parent;

        public SwitchMapInnerObserver(FlowableSwitchMapCompletable$SwitchMapCompletableObserver<?> flowableSwitchMapCompletable$SwitchMapCompletableObserver) {
            this.parent = flowableSwitchMapCompletable$SwitchMapCompletableObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.parent.qw(this);
        }

        public void onError(Throwable th2) {
            this.parent.ad(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public abstract void ad(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2);

    public abstract void qw(SwitchMapInnerObserver switchMapInnerObserver);
}
