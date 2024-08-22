package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import th.de.p039if.de.yj;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.a  reason: invalid package */
public final class a<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Consumer<? super Disposable> f10518th;

    /* renamed from: yj  reason: collision with root package name */
    public final Action f10519yj;

    public a(rg<T> rgVar, Consumer<? super Disposable> consumer, Action action) {
        super(rgVar);
        this.f10518th = consumer;
        this.f10519yj = action;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new yj(observer, this.f10518th, this.f10519yj));
    }
}
