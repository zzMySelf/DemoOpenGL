package th.de.p040switch;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import th.de.rg;

/* renamed from: th.de.switch.qw  reason: invalid package */
public abstract class qw<T> extends rg<T> {
    public abstract void ad(Consumer<? super Disposable> consumer);

    public rg<T> fe() {
        return th.de.ppp.qw.when(new ObservableRefCount(this));
    }
}
