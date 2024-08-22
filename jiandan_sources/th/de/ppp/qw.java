package th.de.ppp;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import th.de.ad;
import th.de.de;
import th.de.rg;
import th.de.th;
import th.de.yj;

public final class qw {
    public static volatile boolean aaa;

    /* renamed from: ad  reason: collision with root package name */
    public static volatile Function<? super Runnable, ? extends Runnable> f10995ad;
    public static volatile BiFunction<? super yj, ? super SingleObserver, ? extends SingleObserver> ddd;

    /* renamed from: de  reason: collision with root package name */
    public static volatile Function<? super Callable<th>, ? extends th> f10996de;

    /* renamed from: fe  reason: collision with root package name */
    public static volatile Function<? super Callable<th>, ? extends th> f10997fe;
    public static volatile BiFunction<? super ad, ? super Subscriber, ? extends Subscriber> ggg;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Function<? super th, ? extends th> f10998i;

    /* renamed from: if  reason: not valid java name */
    public static volatile Function<? super th.de.p040switch.qw, ? extends th.de.p040switch.qw> f520if;
    public static volatile BooleanSupplier mmm;
    public static volatile BiFunction<? super th.de.qw, ? super CompletableObserver, ? extends CompletableObserver> nn;

    /* renamed from: o  reason: collision with root package name */
    public static volatile Function<? super ad, ? extends ad> f10999o;

    /* renamed from: pf  reason: collision with root package name */
    public static volatile Function<? super rg, ? extends rg> f11000pf;
    public static volatile Function<? super th.de.qw, ? extends th.de.qw> ppp;
    public static volatile Consumer<? super Throwable> qw;

    /* renamed from: rg  reason: collision with root package name */
    public static volatile Function<? super Callable<th>, ? extends th> f11001rg;

    /* renamed from: switch  reason: not valid java name */
    public static volatile Function<? super de, ? extends de> f521switch;

    /* renamed from: th  reason: collision with root package name */
    public static volatile Function<? super Callable<th>, ? extends th> f11002th;

    /* renamed from: uk  reason: collision with root package name */
    public static volatile Function<? super th, ? extends th> f11003uk;
    public static volatile BiFunction<? super de, ? super MaybeObserver, ? extends MaybeObserver> vvv;
    public static volatile Function<? super yj, ? extends yj> when;
    public static volatile BiFunction<? super rg, ? super Observer, ? extends Observer> xxx;

    /* renamed from: yj  reason: collision with root package name */
    public static volatile Function<? super th, ? extends th> f11004yj;

    public static <T> Subscriber<? super T> a(ad<T> adVar, Subscriber<? super T> subscriber) {
        BiFunction<? super ad, ? super Subscriber, ? extends Subscriber> biFunction = ggg;
        return biFunction != null ? (Subscriber) qw(biFunction, adVar, subscriber) : subscriber;
    }

    public static th aaa(th thVar) {
        Function<? super th, ? extends th> function = f11003uk;
        if (function == null) {
            return thVar;
        }
        return (th) ad(function, thVar);
    }

    public static <T, R> R ad(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th2) {
            throw ExceptionHelper.fe(th2);
        }
    }

    public static void b(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    public static void ddd(Throwable th2) {
        Consumer<? super Throwable> consumer = qw;
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (consumer != null) {
            try {
                consumer.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                b(th3);
            }
        }
        th2.printStackTrace();
        b(th2);
    }

    public static th de(Function<? super Callable<th>, ? extends th> function, Callable<th> callable) {
        Object ad2 = ad(function, callable);
        th.de.p039if.ad.qw.rg(ad2, "Scheduler Callable result can't be null");
        return (th) ad2;
    }

    public static <T> MaybeObserver<? super T> eee(de<T> deVar, MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super de, ? super MaybeObserver, ? extends MaybeObserver> biFunction = vvv;
        return biFunction != null ? (MaybeObserver) qw(biFunction, deVar, maybeObserver) : maybeObserver;
    }

    public static th fe(Callable<th> callable) {
        try {
            th call = callable.call();
            th.de.p039if.ad.qw.rg(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th2) {
            throw ExceptionHelper.fe(th2);
        }
    }

    public static <T> th.de.p040switch.qw<T> ggg(th.de.p040switch.qw<T> qwVar) {
        Function<? super th.de.p040switch.qw, ? extends th.de.p040switch.qw> function = f520if;
        return function != null ? (th.de.p040switch.qw) ad(function, qwVar) : qwVar;
    }

    public static boolean i(Throwable th2) {
        if (!(th2 instanceof OnErrorNotImplementedException) && !(th2 instanceof MissingBackpressureException) && !(th2 instanceof IllegalStateException) && !(th2 instanceof NullPointerException) && !(th2 instanceof IllegalArgumentException) && !(th2 instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public static <T> ad<T> m2357if(ad<T> adVar) {
        Function<? super ad, ? extends ad> function = f10999o;
        return function != null ? (ad) ad(function, adVar) : adVar;
    }

    public static Runnable mmm(Runnable runnable) {
        th.de.p039if.ad.qw.rg(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f10995ad;
        if (function == null) {
            return runnable;
        }
        return (Runnable) ad(function, runnable);
    }

    public static th nn(th thVar) {
        Function<? super th, ? extends th> function = f10998i;
        if (function == null) {
            return thVar;
        }
        return (th) ad(function, thVar);
    }

    public static boolean o() {
        return aaa;
    }

    public static th.de.qw pf(th.de.qw qwVar) {
        Function<? super th.de.qw, ? extends th.de.qw> function = ppp;
        return function != null ? (th.de.qw) ad(function, qwVar) : qwVar;
    }

    public static <T> yj<T> ppp(yj<T> yjVar) {
        Function<? super yj, ? extends yj> function = when;
        return function != null ? (yj) ad(function, yjVar) : yjVar;
    }

    public static CompletableObserver qqq(th.de.qw qwVar, CompletableObserver completableObserver) {
        BiFunction<? super th.de.qw, ? super CompletableObserver, ? extends CompletableObserver> biFunction = nn;
        return biFunction != null ? (CompletableObserver) qw(biFunction, qwVar, completableObserver) : completableObserver;
    }

    public static <T, U, R> R qw(BiFunction<T, U, R> biFunction, T t, U u) {
        try {
            return biFunction.apply(t, u);
        } catch (Throwable th2) {
            throw ExceptionHelper.fe(th2);
        }
    }

    public static th rg(Callable<th> callable) {
        th.de.p039if.ad.qw.rg(callable, "Scheduler Callable can't be null");
        Function<? super Callable<th>, ? extends th> function = f10996de;
        if (function == null) {
            return fe(callable);
        }
        return de(function, callable);
    }

    public static <T> Observer<? super T> rrr(rg<T> rgVar, Observer<? super T> observer) {
        BiFunction<? super rg, ? super Observer, ? extends Observer> biFunction = xxx;
        return biFunction != null ? (Observer) qw(biFunction, rgVar, observer) : observer;
    }

    /* renamed from: switch  reason: not valid java name */
    public static <T> de<T> m2358switch(de<T> deVar) {
        Function<? super de, ? extends de> function = f521switch;
        return function != null ? (de) ad(function, deVar) : deVar;
    }

    public static th th(Callable<th> callable) {
        th.de.p039if.ad.qw.rg(callable, "Scheduler Callable can't be null");
        Function<? super Callable<th>, ? extends th> function = f11001rg;
        if (function == null) {
            return fe(callable);
        }
        return de(function, callable);
    }

    public static <T> SingleObserver<? super T> tt(yj<T> yjVar, SingleObserver<? super T> singleObserver) {
        BiFunction<? super yj, ? super SingleObserver, ? extends SingleObserver> biFunction = ddd;
        return biFunction != null ? (SingleObserver) qw(biFunction, yjVar, singleObserver) : singleObserver;
    }

    public static th uk(Callable<th> callable) {
        th.de.p039if.ad.qw.rg(callable, "Scheduler Callable can't be null");
        Function<? super Callable<th>, ? extends th> function = f10997fe;
        if (function == null) {
            return fe(callable);
        }
        return de(function, callable);
    }

    public static boolean vvv() {
        BooleanSupplier booleanSupplier = mmm;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th2) {
            throw ExceptionHelper.fe(th2);
        }
    }

    public static <T> rg<T> when(rg<T> rgVar) {
        Function<? super rg, ? extends rg> function = f11000pf;
        return function != null ? (rg) ad(function, rgVar) : rgVar;
    }

    public static th xxx(th thVar) {
        Function<? super th, ? extends th> function = f11004yj;
        if (function == null) {
            return thVar;
        }
        return (th) ad(function, thVar);
    }

    public static th yj(Callable<th> callable) {
        th.de.p039if.ad.qw.rg(callable, "Scheduler Callable can't be null");
        Function<? super Callable<th>, ? extends th> function = f11002th;
        if (function == null) {
            return fe(callable);
        }
        return de(function, callable);
    }
}
