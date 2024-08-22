package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observable;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;

public enum InternalObservableUtils {
    ;
    
    public static final yj COUNTER = null;
    public static final rg ERROR_EXTRACTOR = null;
    public static final Action1<Throwable> ERROR_NOT_IMPLEMENTED = null;
    public static final Observable.Operator<Boolean, Object> IS_EMPTY = null;
    public static final uk LONG_COUNTER = null;
    public static final th OBJECT_EQUALS = null;
    public static final ppp RETURNS_VOID = null;
    public static final vvv TO_ARRAY = null;

    public static final class ad implements Func1<Object, Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final Object f11452ad;

        public ad(Object obj) {
            this.f11452ad = obj;
        }

        /* renamed from: ad */
        public Boolean call(Object obj) {
            Object obj2 = this.f11452ad;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    public static final class de implements Action1<Throwable> {
        public void ad(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        public /* bridge */ /* synthetic */ void call(Object obj) {
            ad((Throwable) obj);
            throw null;
        }
    }

    public static final class fe implements Func1<Object, Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<?> f11453ad;

        public fe(Class<?> cls) {
            this.f11453ad = cls;
        }

        /* renamed from: ad */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f11453ad.isInstance(obj));
        }
    }

    public static final class ggg<T, R> implements Func1<Observable<T>, Observable<R>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Func1<? super Observable<T>, ? extends Observable<R>> f11454ad;

        /* renamed from: th  reason: collision with root package name */
        public final p041if.qw f11455th;

        public ggg(Func1<? super Observable<T>, ? extends Observable<R>> func1, p041if.qw qwVar) {
            this.f11454ad = func1;
            this.f11455th = qwVar;
        }

        /* renamed from: ad */
        public Observable<R> call(Observable<T> observable) {
            return ((Observable) this.f11454ad.call(observable)).i(this.f11455th);
        }
    }

    public static final class i implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Func1<? super Observable<? extends Void>, ? extends Observable<?>> f11456ad;

        public i(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
            this.f11456ad = func1;
        }

        /* renamed from: ad */
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return (Observable) this.f11456ad.call(observable.yj(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* renamed from: rx.internal.util.InternalObservableUtils$if  reason: invalid class name */
    public static final class Cif<T> implements Func0<p041if.th.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observable<T> f11457ad;

        public Cif(Observable<T> observable) {
            this.f11457ad = observable;
        }

        /* renamed from: ad */
        public p041if.th.qw<T> call() {
            return this.f11457ad.when();
        }
    }

    public static final class o<T> implements Func0<p041if.th.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observable<T> f11458ad;

        /* renamed from: th  reason: collision with root package name */
        public final int f11459th;

        public o(Observable<T> observable, int i2) {
            this.f11458ad = observable;
            this.f11459th = i2;
        }

        /* renamed from: ad */
        public p041if.th.qw<T> call() {
            return this.f11458ad.ppp(this.f11459th);
        }
    }

    public static final class pf<T> implements Func0<p041if.th.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final TimeUnit f11460ad;

        /* renamed from: th  reason: collision with root package name */
        public final Observable<T> f11461th;

        /* renamed from: uk  reason: collision with root package name */
        public final p041if.qw f11462uk;

        /* renamed from: yj  reason: collision with root package name */
        public final long f11463yj;

        public pf(Observable<T> observable, long j, TimeUnit timeUnit, p041if.qw qwVar) {
            this.f11460ad = timeUnit;
            this.f11461th = observable;
            this.f11463yj = j;
            this.f11462uk = qwVar;
        }

        /* renamed from: ad */
        public p041if.th.qw<T> call() {
            return this.f11461th.vvv(this.f11463yj, this.f11460ad, this.f11462uk);
        }
    }

    public static final class ppp implements Func1<Object, Void> {
        /* renamed from: ad */
        public Void call(Object obj) {
            return null;
        }
    }

    public static final class qw<T, R> implements Func2<R, T, R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Action2<R, ? super T> f11464ad;

        public qw(Action2<R, ? super T> action2) {
            this.f11464ad = action2;
        }

        public R qw(R r, T t) {
            this.f11464ad.qw(r, t);
            return r;
        }
    }

    public static final class rg implements Func1<Notification<?>, Throwable> {
        /* renamed from: ad */
        public Throwable call(Notification<?> notification) {
            return notification.rg();
        }
    }

    /* renamed from: rx.internal.util.InternalObservableUtils$switch  reason: invalid class name */
    public static final class Cswitch<T> implements Func0<p041if.th.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final long f11465ad;

        /* renamed from: i  reason: collision with root package name */
        public final Observable<T> f11466i;

        /* renamed from: th  reason: collision with root package name */
        public final TimeUnit f11467th;

        /* renamed from: uk  reason: collision with root package name */
        public final int f11468uk;

        /* renamed from: yj  reason: collision with root package name */
        public final p041if.qw f11469yj;

        public Cswitch(Observable<T> observable, int i2, long j, TimeUnit timeUnit, p041if.qw qwVar) {
            this.f11465ad = j;
            this.f11467th = timeUnit;
            this.f11469yj = qwVar;
            this.f11468uk = i2;
            this.f11466i = observable;
        }

        /* renamed from: ad */
        public p041if.th.qw<T> call() {
            return this.f11466i.ggg(this.f11468uk, this.f11465ad, this.f11467th, this.f11469yj);
        }
    }

    public static final class th implements Func2<Object, Object, Boolean> {
        /* renamed from: ad */
        public Boolean qw(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    public static final class uk implements Func2<Long, Object, Long> {
        /* renamed from: ad */
        public Long qw(Long l, Object obj) {
            return Long.valueOf(l.longValue() + 1);
        }
    }

    public static final class vvv implements Func1<List<? extends Observable<?>>, Observable<?>[]> {
        /* renamed from: ad */
        public Observable<?>[] call(List<? extends Observable<?>> list) {
            return (Observable[]) list.toArray(new Observable[list.size()]);
        }
    }

    public static final class when implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> f11470ad;

        public when(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
            this.f11470ad = func1;
        }

        /* renamed from: ad */
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return (Observable) this.f11470ad.call(observable.yj(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    public static final class yj implements Func2<Integer, Object, Integer> {
        /* renamed from: ad */
        public Integer qw(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* access modifiers changed from: public */
    static {
        LONG_COUNTER = new uk();
        OBJECT_EQUALS = new th();
        TO_ARRAY = new vvv();
        RETURNS_VOID = new ppp();
        COUNTER = new yj();
        ERROR_EXTRACTOR = new rg();
        ERROR_NOT_IMPLEMENTED = new de();
        IS_EMPTY = new p041if.rg.qw.o(UtilityFunctions.qw(), true);
    }

    public static <T, R> Func2<R, T, R> createCollectorCaller(Action2<R, ? super T> action2) {
        return new qw(action2);
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRepeatDematerializer(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        return new i(func1);
    }

    public static <T, R> Func1<Observable<T>, Observable<R>> createReplaySelectorAndObserveOn(Func1<? super Observable<T>, ? extends Observable<R>> func1, p041if.qw qwVar) {
        return new ggg(func1, qwVar);
    }

    public static <T> Func0<p041if.th.qw<T>> createReplaySupplier(Observable<T> observable) {
        return new Cif(observable);
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRetryDematerializer(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return new when(func1);
    }

    public static Func1<Object, Boolean> equalsWith(Object obj) {
        return new ad(obj);
    }

    public static Func1<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new fe(cls);
    }

    public static <T> Func0<p041if.th.qw<T>> createReplaySupplier(Observable<T> observable, int i2) {
        return new o(observable, i2);
    }

    public static <T> Func0<p041if.th.qw<T>> createReplaySupplier(Observable<T> observable, long j, TimeUnit timeUnit, p041if.qw qwVar) {
        return new pf(observable, j, timeUnit, qwVar);
    }

    public static <T> Func0<p041if.th.qw<T>> createReplaySupplier(Observable<T> observable, int i2, long j, TimeUnit timeUnit, p041if.qw qwVar) {
        return new Cswitch(observable, i2, j, timeUnit, qwVar);
    }
}
