package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.o.qw;

public final class MaybeEqualSingle$EqualCoordinator<T> extends AtomicInteger implements Disposable {
    public final SingleObserver<? super Boolean> downstream;
    public final BiPredicate<? super T, ? super T> isEqual;
    public final MaybeEqualSingle$EqualObserver<T> observer1 = new MaybeEqualSingle$EqualObserver<>(this);
    public final MaybeEqualSingle$EqualObserver<T> observer2 = new MaybeEqualSingle$EqualObserver<>(this);

    public MaybeEqualSingle$EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
        super(2);
        this.downstream = singleObserver;
        this.isEqual = biPredicate;
    }

    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    public void done() {
        if (decrementAndGet() == 0) {
            Object obj = this.observer1.value;
            Object obj2 = this.observer2.value;
            if (obj == null || obj2 == null) {
                this.downstream.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                return;
            }
            try {
                this.downstream.onSuccess(Boolean.valueOf(this.isEqual.qw(obj, obj2)));
            } catch (Throwable th2) {
                qw.ad(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public void error(MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver, Throwable th2) {
        if (getAndSet(0) > 0) {
            MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver2 = this.observer1;
            if (maybeEqualSingle$EqualObserver == maybeEqualSingle$EqualObserver2) {
                this.observer2.dispose();
            } else {
                maybeEqualSingle$EqualObserver2.dispose();
            }
            this.downstream.onError(th2);
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.observer1.get());
    }

    public void subscribe(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        maybeSource.qw(this.observer1);
        maybeSource2.qw(this.observer2);
    }
}
