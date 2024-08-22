package p041if.uk;

import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import rx.Completable;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;

/* renamed from: if.uk.de  reason: invalid package */
public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile Func1<Observable.OnSubscribe, Observable.OnSubscribe> f11344ad;

    /* renamed from: de  reason: collision with root package name */
    public static volatile Func1<Completable.OnSubscribe, Completable.OnSubscribe> f11345de;

    /* renamed from: fe  reason: collision with root package name */
    public static volatile Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe> f11346fe;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Func0<? extends ScheduledExecutorService> f11347i;

    /* renamed from: if  reason: not valid java name */
    public static volatile Func1<Observable.Operator, Observable.Operator> f539if;

    /* renamed from: o  reason: collision with root package name */
    public static volatile Func1<Throwable, Throwable> f11348o;

    /* renamed from: pf  reason: collision with root package name */
    public static volatile Func1<Throwable, Throwable> f11349pf;
    public static volatile Action1<Throwable> qw;

    /* renamed from: rg  reason: collision with root package name */
    public static volatile Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> f11350rg;

    /* renamed from: th  reason: collision with root package name */
    public static volatile Func1<p041if.qw, p041if.qw> f11351th;

    /* renamed from: uk  reason: collision with root package name */
    public static volatile Func1<Subscription, Subscription> f11352uk;

    /* renamed from: yj  reason: collision with root package name */
    public static volatile Func1<Action0, Action0> f11353yj;

    /* renamed from: if.uk.de$ad */
    public static class ad implements Func1<Observable.OnSubscribe, Observable.OnSubscribe> {
        public Observable.OnSubscribe ad(Observable.OnSubscribe onSubscribe) {
            th.de().fe().qw(onSubscribe);
            return onSubscribe;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            Observable.OnSubscribe onSubscribe = (Observable.OnSubscribe) obj;
            ad(onSubscribe);
            return onSubscribe;
        }
    }

    /* renamed from: if.uk.de$de  reason: collision with other inner class name */
    public static class C0360de implements Func1<Completable.OnSubscribe, Completable.OnSubscribe> {
        public Completable.OnSubscribe ad(Completable.OnSubscribe onSubscribe) {
            th.de().qw().qw(onSubscribe);
            return onSubscribe;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            Completable.OnSubscribe onSubscribe = (Completable.OnSubscribe) obj;
            ad(onSubscribe);
            return onSubscribe;
        }
    }

    /* renamed from: if.uk.de$fe */
    public static class fe implements Action1<Throwable> {
        /* renamed from: ad */
        public void call(Throwable th2) {
            th.de().ad().qw(th2);
        }
    }

    /* renamed from: if.uk.de$i */
    public static class i implements Func1<Throwable, Throwable> {
        public Throwable ad(Throwable th2) {
            th.de().fe().de(th2);
            return th2;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            Throwable th2 = (Throwable) obj;
            ad(th2);
            return th2;
        }
    }

    /* renamed from: if.uk.de$o */
    public static class o implements Func1<Observable.Operator, Observable.Operator> {
        public Observable.Operator ad(Observable.Operator operator) {
            th.de().fe().ad(operator);
            return operator;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            Observable.Operator operator = (Observable.Operator) obj;
            ad(operator);
            return operator;
        }
    }

    /* renamed from: if.uk.de$qw */
    public static class qw implements Func1<Throwable, Throwable> {
        public Throwable ad(Throwable th2) {
            th.de().qw().ad(th2);
            return th2;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            Throwable th2 = (Throwable) obj;
            ad(th2);
            return th2;
        }
    }

    /* renamed from: if.uk.de$rg */
    public static class rg implements Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe> {
        public Observable.OnSubscribe ad(Observable observable, Observable.OnSubscribe onSubscribe) {
            th.de().fe().rg(observable, onSubscribe);
            return onSubscribe;
        }

        public /* bridge */ /* synthetic */ Object qw(Object obj, Object obj2) {
            Observable.OnSubscribe onSubscribe = (Observable.OnSubscribe) obj2;
            ad((Observable) obj, onSubscribe);
            return onSubscribe;
        }
    }

    /* renamed from: if.uk.de$th */
    public static class th implements Func1<Subscription, Subscription> {
        public Subscription ad(Subscription subscription) {
            th.de().fe().fe(subscription);
            return subscription;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            Subscription subscription = (Subscription) obj;
            ad(subscription);
            return subscription;
        }
    }

    /* renamed from: if.uk.de$uk */
    public static class uk implements Func1<Action0, Action0> {
        public Action0 ad(Action0 action0) {
            th.de().th().pf(action0);
            return action0;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            Action0 action0 = (Action0) obj;
            ad(action0);
            return action0;
        }
    }

    /* renamed from: if.uk.de$yj */
    public static class yj implements Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> {
        public Completable.OnSubscribe ad(Completable completable, Completable.OnSubscribe onSubscribe) {
            th.de().qw().de(completable, onSubscribe);
            return onSubscribe;
        }

        public /* bridge */ /* synthetic */ Object qw(Object obj, Object obj2) {
            Completable.OnSubscribe onSubscribe = (Completable.OnSubscribe) obj2;
            ad((Completable) obj, onSubscribe);
            return onSubscribe;
        }
    }

    static {
        ad();
    }

    public static void ad() {
        qw = new fe();
        f11346fe = new rg();
        f11352uk = new th();
        f11350rg = new yj();
        f11353yj = new uk();
        f11348o = new i();
        f539if = new o();
        f11349pf = new qw();
        de();
    }

    public static void de() {
        f11344ad = new ad();
        f11345de = new C0360de();
    }

    public static Throwable fe(Throwable th2) {
        Func1<Throwable, Throwable> func1 = f11349pf;
        return func1 != null ? func1.call(th2) : th2;
    }

    public static void i(Throwable th2) {
        Action1<Throwable> action1 = qw;
        if (action1 != null) {
            try {
                action1.call(th2);
                return;
            } catch (Throwable th3) {
                PrintStream printStream = System.err;
                printStream.println("The onError handler threw an Exception. It shouldn't. => " + th3.getMessage());
                th3.printStackTrace();
                ppp(th3);
            }
        }
        ppp(th2);
    }

    /* renamed from: if  reason: not valid java name */
    public static Subscription m2373if(Subscription subscription) {
        Func1<Subscription, Subscription> func1 = f11352uk;
        return func1 != null ? func1.call(subscription) : subscription;
    }

    public static Throwable o(Throwable th2) {
        Func1<Throwable, Throwable> func1 = f11348o;
        return func1 != null ? func1.call(th2) : th2;
    }

    public static <T, R> Observable.Operator<R, T> pf(Observable.Operator<R, T> operator) {
        Func1 func1 = f539if;
        return func1 != null ? (Observable.Operator) func1.call(operator) : operator;
    }

    public static void ppp(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    public static Func0<? extends ScheduledExecutorService> qw() {
        return f11347i;
    }

    public static <T> Completable.OnSubscribe rg(Completable completable, Completable.OnSubscribe onSubscribe) {
        Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> func2 = f11350rg;
        return func2 != null ? func2.qw(completable, onSubscribe) : onSubscribe;
    }

    /* renamed from: switch  reason: not valid java name */
    public static <T> Observable.OnSubscribe<T> m2374switch(Observable<T> observable, Observable.OnSubscribe<T> onSubscribe) {
        Func2<Observable, Observable.OnSubscribe, Observable.OnSubscribe> func2 = f11346fe;
        return func2 != null ? func2.qw(observable, onSubscribe) : onSubscribe;
    }

    public static p041if.qw th(p041if.qw qwVar) {
        Func1<p041if.qw, p041if.qw> func1 = f11351th;
        return func1 != null ? func1.call(qwVar) : qwVar;
    }

    public static <T> Observable.OnSubscribe<T> uk(Observable.OnSubscribe<T> onSubscribe) {
        Func1<Observable.OnSubscribe, Observable.OnSubscribe> func1 = f11344ad;
        return func1 != null ? func1.call(onSubscribe) : onSubscribe;
    }

    public static Action0 when(Action0 action0) {
        Func1<Action0, Action0> func1 = f11353yj;
        return func1 != null ? func1.call(action0) : action0;
    }

    public static Completable.OnSubscribe yj(Completable.OnSubscribe onSubscribe) {
        Func1<Completable.OnSubscribe, Completable.OnSubscribe> func1 = f11345de;
        return func1 != null ? func1.call(onSubscribe) : onSubscribe;
    }
}
