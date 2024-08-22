package rx;

import java.util.concurrent.TimeUnit;
import p041if.de;
import p041if.fe.qw;
import p041if.rg.fe.th;
import p041if.rg.qw.ggg;
import p041if.rg.qw.i;
import p041if.rg.qw.pf;
import p041if.rg.qw.ppp;
import p041if.rg.qw.rg;
import p041if.rg.qw.uk;
import p041if.rg.qw.yj;
import p041if.yj.ad;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;

public class Observable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final OnSubscribe<T> f11379ad;

    public interface OnSubscribe<T> extends Action1<de<? super T>> {
    }

    public interface Operator<R, T> extends Func1<de<? super R>, de<? super T>> {
    }

    public interface Transformer<T, R> extends Func1<Observable<T>, Observable<R>> {
    }

    public Observable(OnSubscribe<T> onSubscribe) {
        this.f11379ad = onSubscribe;
    }

    public static <T> Observable<T> ad(OnSubscribe<T> onSubscribe) {
        return new Observable<>(p041if.uk.de.uk(onSubscribe));
    }

    public static <T> Subscription mmm(de<? super T> deVar, Observable<T> observable) {
        if (deVar == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        } else if (observable.f11379ad != null) {
            deVar.onStart();
            if (!(deVar instanceof ad)) {
                deVar = new ad<>(deVar);
            }
            try {
                p041if.uk.de.m2374switch(observable, observable.f11379ad).call(deVar);
                return p041if.uk.de.m2373if(deVar);
            } catch (Throwable th2) {
                qw.rg(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                p041if.uk.de.o(onErrorFailedException);
                throw onErrorFailedException;
            }
        } else {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
    }

    public static <T> Observable<T> uk() {
        return NeverObservableHolder.instance();
    }

    public final Subscription aaa(de<? super T> deVar) {
        try {
            deVar.onStart();
            p041if.uk.de.m2374switch(this, this.f11379ad).call(deVar);
            return p041if.uk.de.m2373if(deVar);
        } catch (Throwable th2) {
            qw.rg(th2);
            OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
            p041if.uk.de.o(onErrorFailedException);
            throw onErrorFailedException;
        }
    }

    public final Subscription ddd() {
        return nn(new p041if.rg.fe.ad(Actions.qw(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.qw()));
    }

    public final Observable<T> de(Action1<? super Throwable> action1) {
        return ad(new rg(this, new p041if.rg.fe.qw(Actions.qw(), action1, Actions.qw())));
    }

    public final Observable<T> fe(Action1<? super T> action1) {
        return ad(new rg(this, new p041if.rg.fe.qw(action1, Actions.qw(), Actions.qw())));
    }

    public final p041if.th.qw<T> ggg(int i2, long j, TimeUnit timeUnit, p041if.qw qwVar) {
        if (i2 >= 0) {
            return OperatorReplay.a(this, j, timeUnit, qwVar, i2);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final Observable<T> i(p041if.qw qwVar) {
        return o(qwVar, th.f11231yj);
    }

    /* renamed from: if  reason: not valid java name */
    public final <R> Observable<R> m2375if(Class<R> cls) {
        return rg(InternalObservableUtils.isInstanceOf(cls)).qw(cls);
    }

    public final Subscription nn(de<? super T> deVar) {
        return mmm(deVar, this);
    }

    public final Observable<T> o(p041if.qw qwVar, int i2) {
        return pf(qwVar, false, i2);
    }

    public final Observable<T> pf(p041if.qw qwVar, boolean z, int i2) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).qqq(qwVar);
        }
        return th(new ppp(qwVar, z, i2));
    }

    public final p041if.th.qw<T> ppp(int i2) {
        return OperatorReplay.rrr(this, i2);
    }

    public final <R> Observable<R> qw(Class<R> cls) {
        return th(new pf(cls));
    }

    public final Observable<T> rg(Func1<? super T, Boolean> func1) {
        return ad(new p041if.rg.qw.th(this, func1));
    }

    /* renamed from: switch  reason: not valid java name */
    public final Observable<T> m2376switch() {
        return th(ggg.de());
    }

    public final <R> Observable<R> th(Operator<? extends R, ? super T> operator) {
        return ad(new yj(this.f11379ad, operator));
    }

    public final p041if.th.qw<T> vvv(long j, TimeUnit timeUnit, p041if.qw qwVar) {
        return OperatorReplay.tt(this, j, timeUnit, qwVar);
    }

    public final p041if.th.qw<T> when() {
        return OperatorReplay.eee(this);
    }

    public final Observable<T> xxx() {
        return i.de(this);
    }

    public final <R> Observable<R> yj(Func1<? super T, ? extends R> func1) {
        return ad(new uk(this, func1));
    }
}
