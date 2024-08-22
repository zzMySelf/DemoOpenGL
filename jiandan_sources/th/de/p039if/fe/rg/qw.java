package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.qw  reason: invalid package */
public abstract class qw<T, U> extends rg<U> implements HasUpstreamObservableSource<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10756ad;

    public qw(ObservableSource<T> observableSource) {
        this.f10756ad = observableSource;
    }
}
