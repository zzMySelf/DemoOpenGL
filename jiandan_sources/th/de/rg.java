package th.de;

import com.google.android.material.timepicker.RadialViewGroup;
import io.reactivex.BackpressureStrategy;
import io.reactivex.CompletableSource;
import io.reactivex.Emitter;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableConverter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import th.de.p039if.de.fe;
import th.de.p039if.fe.rg.Cif;
import th.de.p039if.fe.rg.a;
import th.de.p039if.fe.rg.a0;
import th.de.p039if.fe.rg.aaa;
import th.de.p039if.fe.rg.ad;
import th.de.p039if.fe.rg.b0;
import th.de.p039if.fe.rg.c;
import th.de.p039if.fe.rg.c0;
import th.de.p039if.fe.rg.d;
import th.de.p039if.fe.rg.d0;
import th.de.p039if.fe.rg.ddd;
import th.de.p039if.fe.rg.de;
import th.de.p039if.fe.rg.e;
import th.de.p039if.fe.rg.e0;
import th.de.p039if.fe.rg.eee;
import th.de.p039if.fe.rg.f;
import th.de.p039if.fe.rg.f0;
import th.de.p039if.fe.rg.g;
import th.de.p039if.fe.rg.g0;
import th.de.p039if.fe.rg.ggg;
import th.de.p039if.fe.rg.h;
import th.de.p039if.fe.rg.h0;
import th.de.p039if.fe.rg.i;
import th.de.p039if.fe.rg.i0;
import th.de.p039if.fe.rg.j;
import th.de.p039if.fe.rg.j0;
import th.de.p039if.fe.rg.k;
import th.de.p039if.fe.rg.k0;
import th.de.p039if.fe.rg.l;
import th.de.p039if.fe.rg.l0;
import th.de.p039if.fe.rg.m;
import th.de.p039if.fe.rg.m0;
import th.de.p039if.fe.rg.mmm;
import th.de.p039if.fe.rg.n;
import th.de.p039if.fe.rg.n0;
import th.de.p039if.fe.rg.nn;
import th.de.p039if.fe.rg.o;
import th.de.p039if.fe.rg.o0;
import th.de.p039if.fe.rg.p;
import th.de.p039if.fe.rg.p0;
import th.de.p039if.fe.rg.pf;
import th.de.p039if.fe.rg.q;
import th.de.p039if.fe.rg.q0;
import th.de.p039if.fe.rg.qqq;
import th.de.p039if.fe.rg.r;
import th.de.p039if.fe.rg.r0;
import th.de.p039if.fe.rg.rrr;
import th.de.p039if.fe.rg.s;
import th.de.p039if.fe.rg.s0;
import th.de.p039if.fe.rg.t;
import th.de.p039if.fe.rg.t0;
import th.de.p039if.fe.rg.th;
import th.de.p039if.fe.rg.tt;
import th.de.p039if.fe.rg.u;
import th.de.p039if.fe.rg.u0;
import th.de.p039if.fe.rg.uk;
import th.de.p039if.fe.rg.v;
import th.de.p039if.fe.rg.v0;
import th.de.p039if.fe.rg.vvv;
import th.de.p039if.fe.rg.w;
import th.de.p039if.fe.rg.w0;
import th.de.p039if.fe.rg.when;
import th.de.p039if.fe.rg.x;
import th.de.p039if.fe.rg.x0;
import th.de.p039if.fe.rg.xxx;
import th.de.p039if.fe.rg.y;
import th.de.p039if.fe.rg.y0;
import th.de.p039if.fe.rg.z;
import th.de.p039if.fe.rg.z0;

public abstract class rg<T> implements ObservableSource<T> {

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: th.de.rg.qw.<clinit>():void");
        }
    }

    public static <T> rg<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        th.de.p039if.ad.qw.rg(iterable, "sources is null");
        return th.de.ppp.qw.when(new ObservableAmb((ObservableSource<? extends T>[]) null, iterable));
    }

    public static <T> rg<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        th.de.p039if.ad.qw.rg(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return th.de.ppp.qw.when(new ObservableAmb(observableSourceArr, (Iterable) null));
    }

    public static int bufferSize() {
        return ad.qw();
    }

    public static <T, R> rg<R> combineLatest(Function<? super Object[], ? extends R> function, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i2);
    }

    public static <T, R> rg<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    public static <T> rg<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        th.de.p039if.ad.qw.rg(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.i(), bufferSize(), false);
    }

    public static <T> rg<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return th.de.ppp.qw.when(new ObservableConcatMap(fromArray(observableSourceArr), Functions.i(), bufferSize(), ErrorMode.BOUNDARY));
    }

    public static <T> rg<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return concatDelayError(fromArray(observableSourceArr));
    }

    public static <T> rg<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    public static <T> rg<T> concatArrayEagerDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), observableSourceArr);
    }

    public static <T> rg<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        th.de.p039if.ad.qw.rg(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> rg<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    public static <T> rg<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        th.de.p039if.ad.qw.rg(observableOnSubscribe, "source is null");
        return th.de.ppp.qw.when(new ObservableCreate(observableOnSubscribe));
    }

    public static <T> rg<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        th.de.p039if.ad.qw.rg(callable, "supplier is null");
        return th.de.ppp.qw.when(new xxx(callable));
    }

    private rg<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        th.de.p039if.ad.qw.rg(consumer, "onNext is null");
        th.de.p039if.ad.qw.rg(consumer2, "onError is null");
        th.de.p039if.ad.qw.rg(action, "onComplete is null");
        th.de.p039if.ad.qw.rg(action2, "onAfterTerminate is null");
        return th.de.ppp.qw.when(new tt(this, consumer, consumer2, action, action2));
    }

    public static <T> rg<T> empty() {
        return th.de.ppp.qw.when(e.f10587ad);
    }

    public static <T> rg<T> error(Callable<? extends Throwable> callable) {
        th.de.p039if.ad.qw.rg(callable, "errorSupplier is null");
        return th.de.ppp.qw.when(new f(callable));
    }

    public static <T> rg<T> fromArray(T... tArr) {
        th.de.p039if.ad.qw.rg(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return th.de.ppp.qw.when(new j(tArr));
    }

    public static <T> rg<T> fromCallable(Callable<? extends T> callable) {
        th.de.p039if.ad.qw.rg(callable, "supplier is null");
        return th.de.ppp.qw.when(new k(callable));
    }

    public static <T> rg<T> fromFuture(Future<? extends T> future) {
        th.de.p039if.ad.qw.rg(future, "future is null");
        return th.de.ppp.qw.when(new l(future, 0, (TimeUnit) null));
    }

    public static <T> rg<T> fromIterable(Iterable<? extends T> iterable) {
        th.de.p039if.ad.qw.rg(iterable, "source is null");
        return th.de.ppp.qw.when(new m(iterable));
    }

    public static <T> rg<T> fromPublisher(Publisher<? extends T> publisher) {
        th.de.p039if.ad.qw.rg(publisher, "publisher is null");
        return th.de.ppp.qw.when(new n(publisher));
    }

    public static <T> rg<T> generate(Consumer<Emitter<T>> consumer) {
        th.de.p039if.ad.qw.rg(consumer, "generator is null");
        return generate(Functions.ddd(), ObservableInternalHelper.m1141switch(consumer), Functions.yj());
    }

    public static rg<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, th.de.vvv.qw.qw());
    }

    public static rg<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, th.de.vvv.qw.qw());
    }

    public static <T> rg<T> just(T t) {
        th.de.p039if.ad.qw.rg(t, "item is null");
        return th.de.ppp.qw.when(new u(t));
    }

    public static <T> rg<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).flatMap(Functions.i(), false, i2, i3);
    }

    public static <T> rg<T> mergeArray(int i2, int i3, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), false, i2, i3);
    }

    public static <T> rg<T> mergeArrayDelayError(int i2, int i3, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), true, i2, i3);
    }

    public static <T> rg<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.i(), true);
    }

    public static <T> rg<T> never() {
        return th.de.ppp.qw.when(b0.f10538ad);
    }

    public static rg<Integer> range(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        } else if (i3 == 0) {
            return empty();
        } else {
            if (i3 == 1) {
                return just(Integer.valueOf(i2));
            }
            if (((long) i2) + ((long) (i3 - 1)) <= 2147483647L) {
                return th.de.ppp.qw.when(new ObservableRange(i2, i3));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static rg<Long> rangeLong(long j, long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        } else if (i2 == 0) {
            return empty();
        } else {
            if (j2 == 1) {
                return just(Long.valueOf(j));
            }
            long j3 = (j2 - 1) + j;
            if (j <= 0 || j3 >= 0) {
                return th.de.ppp.qw.when(new ObservableRangeLong(j, j2));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> yj<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, th.de.p039if.ad.qw.fe(), bufferSize());
    }

    public static <T> rg<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableSwitchMap(observableSource, Functions.i(), i2, false));
    }

    public static <T> rg<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    private rg<T> timeout0(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "timeUnit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableTimeoutTimed(this, j, timeUnit, thVar, observableSource));
    }

    public static rg<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, th.de.vvv.qw.qw());
    }

    public static <T> rg<T> unsafeCreate(ObservableSource<T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "onSubscribe is null");
        if (!(observableSource instanceof rg)) {
            return th.de.ppp.qw.when(new p(observableSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> rg<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T> rg<T> wrap(ObservableSource<T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "source is null");
        if (observableSource instanceof rg) {
            return th.de.ppp.qw.when((rg) observableSource);
        }
        return th.de.ppp.qw.when(new p(observableSource));
    }

    public static <T, R> rg<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        th.de.p039if.ad.qw.rg(function, "zipper is null");
        th.de.p039if.ad.qw.rg(iterable, "sources is null");
        return th.de.ppp.qw.when(new ObservableZip((ObservableSource<? extends T>[]) null, iterable, function, bufferSize(), false));
    }

    public static <T, R> rg<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i2, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        th.de.p039if.ad.qw.rg(function, "zipper is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableZip(observableSourceArr, (Iterable) null, function, i2, z));
    }

    public static <T, R> rg<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(function, "zipper is null");
        th.de.p039if.ad.qw.rg(iterable, "sources is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableZip((ObservableSource<? extends T>[]) null, iterable, function, i2, z));
    }

    public final yj<Boolean> all(Predicate<? super T> predicate) {
        th.de.p039if.ad.qw.rg(predicate, "predicate is null");
        return th.de.ppp.qw.ppp(new th(this, predicate));
    }

    public final rg<T> ambWith(ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    public final yj<Boolean> any(Predicate<? super T> predicate) {
        th.de.p039if.ad.qw.rg(predicate, "predicate is null");
        return th.de.ppp.qw.ppp(new uk(this, predicate));
    }

    public final <R> R as(ObservableConverter<T, ? extends R> observableConverter) {
        th.de.p039if.ad.qw.rg(observableConverter, "converter is null");
        return observableConverter.qw(this);
    }

    public final T blockingFirst() {
        fe feVar = new fe();
        subscribe(feVar);
        T qw2 = feVar.qw();
        if (qw2 != null) {
            return qw2;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                ((Disposable) it).dispose();
                throw ExceptionHelper.fe(th2);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        th.de.p039if.de.rg rgVar = new th.de.p039if.de.rg();
        subscribe(rgVar);
        T qw2 = rgVar.qw();
        if (qw2 != null) {
            return qw2;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new ad(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new de(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new th.de.p039if.fe.rg.fe(this);
    }

    public final T blockingSingle() {
        T de2 = singleElement().de();
        if (de2 != null) {
            return de2;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        i.qw(this);
    }

    public final rg<List<T>> buffer(int i2) {
        return buffer(i2, i2);
    }

    public final rg<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final rg<T> cacheWithInitialCapacity(int i2) {
        th.de.p039if.ad.qw.th(i2, "initialCapacity");
        return th.de.ppp.qw.when(new ObservableCache(this, i2));
    }

    public final <U> rg<U> cast(Class<U> cls) {
        th.de.p039if.ad.qw.rg(cls, "clazz is null");
        return map(Functions.fe(cls));
    }

    public final <U> yj<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        th.de.p039if.ad.qw.rg(callable, "initialValueSupplier is null");
        th.de.p039if.ad.qw.rg(biConsumer, "collector is null");
        return th.de.ppp.qw.ppp(new when(this, callable, biConsumer));
    }

    public final <U> yj<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        th.de.p039if.ad.qw.rg(u, "initialValue is null");
        return collect(Functions.pf(u), biConsumer);
    }

    public final <R> rg<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        th.de.p039if.ad.qw.rg(observableTransformer, "composer is null");
        return wrap(observableTransformer.qw(this));
    }

    public final <R> rg<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    public final qw concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    public final qw concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    public final <R> rg<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    public final <R> rg<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> rg<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z);
    }

    public final <U> rg<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new h(this, function));
    }

    public final <R> rg<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    public final <R> rg<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    public final <R> rg<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    public final <R> rg<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    public final rg<T> concatWith(ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return concat(this, (rg) observableSource);
    }

    public final yj<Boolean> contains(Object obj) {
        th.de.p039if.ad.qw.rg(obj, "element is null");
        return any(Functions.uk(obj));
    }

    public final yj<Long> count() {
        return th.de.ppp.qw.ppp(new ggg(this));
    }

    public final <U> rg<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        th.de.p039if.ad.qw.rg(function, "debounceSelector is null");
        return th.de.ppp.qw.when(new vvv(this, function));
    }

    public final rg<T> defaultIfEmpty(T t) {
        th.de.p039if.ad.qw.rg(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final <U> rg<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        th.de.p039if.ad.qw.rg(function, "itemDelay is null");
        return flatMap(ObservableInternalHelper.de(function));
    }

    public final <U> rg<T> delaySubscription(ObservableSource<U> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return th.de.ppp.qw.when(new nn(this, observableSource));
    }

    @Deprecated
    public final <T2> rg<T2> dematerialize() {
        return th.de.ppp.qw.when(new mmm(this, Functions.i()));
    }

    public final rg<T> distinct() {
        return distinct(Functions.i(), Functions.th());
    }

    public final rg<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.i());
    }

    public final rg<T> doAfterNext(Consumer<? super T> consumer) {
        th.de.p039if.ad.qw.rg(consumer, "onAfterNext is null");
        return th.de.ppp.qw.when(new rrr(this, consumer));
    }

    public final rg<T> doAfterTerminate(Action action) {
        th.de.p039if.ad.qw.rg(action, "onFinally is null");
        return doOnEach(Functions.yj(), Functions.yj(), Functions.f9949de, action);
    }

    public final rg<T> doFinally(Action action) {
        th.de.p039if.ad.qw.rg(action, "onFinally is null");
        return th.de.ppp.qw.when(new ObservableDoFinally(this, action));
    }

    public final rg<T> doOnComplete(Action action) {
        return doOnEach(Functions.yj(), Functions.yj(), action, Functions.f9949de);
    }

    public final rg<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.yj(), action);
    }

    public final rg<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer yj2 = Functions.yj();
        Action action = Functions.f9949de;
        return doOnEach(yj2, consumer, action, action);
    }

    public final rg<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        th.de.p039if.ad.qw.rg(consumer, "onSubscribe is null");
        th.de.p039if.ad.qw.rg(action, "onDispose is null");
        return th.de.ppp.qw.when(new a(this, consumer, action));
    }

    public final rg<T> doOnNext(Consumer<? super T> consumer) {
        Consumer yj2 = Functions.yj();
        Action action = Functions.f9949de;
        return doOnEach(consumer, yj2, action, action);
    }

    public final rg<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.f9949de);
    }

    public final rg<T> doOnTerminate(Action action) {
        th.de.p039if.ad.qw.rg(action, "onTerminate is null");
        return doOnEach(Functions.yj(), Functions.qw(action), action, Functions.f9949de);
    }

    public final de<T> elementAt(long j) {
        if (j >= 0) {
            return th.de.ppp.qw.m2358switch(new c(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final yj<T> elementAtOrError(long j) {
        if (j >= 0) {
            return th.de.ppp.qw.ppp(new d(this, j, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final rg<T> filter(Predicate<? super T> predicate) {
        th.de.p039if.ad.qw.rg(predicate, "predicate is null");
        return th.de.ppp.qw.when(new g(this, predicate));
    }

    public final yj<T> first(T t) {
        return elementAt(0, t);
    }

    public final de<T> firstElement() {
        return elementAt(0);
    }

    public final yj<T> firstOrError() {
        return elementAtOrError(0);
    }

    public final <R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap(function, false);
    }

    public final qw flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    public final <U> rg<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new h(this, function));
    }

    public final <R> rg<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    public final <R> rg<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.f9952rg, Functions.f9949de);
    }

    public final <K> rg<th.de.p040switch.ad<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return groupBy(function, Functions.i(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> rg<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super rg<TRight>, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        th.de.p039if.ad.qw.rg(function, "leftEnd is null");
        th.de.p039if.ad.qw.rg(function2, "rightEnd is null");
        th.de.p039if.ad.qw.rg(biFunction, "resultSelector is null");
        return th.de.ppp.qw.when(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    public final rg<T> hide() {
        return th.de.ppp.qw.when(new r(this));
    }

    public final qw ignoreElements() {
        return th.de.ppp.qw.pf(new t(this));
    }

    public final yj<Boolean> isEmpty() {
        return all(Functions.ad());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> rg<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        th.de.p039if.ad.qw.rg(function, "leftEnd is null");
        th.de.p039if.ad.qw.rg(function2, "rightEnd is null");
        th.de.p039if.ad.qw.rg(biFunction, "resultSelector is null");
        return th.de.ppp.qw.when(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    public final yj<T> last(T t) {
        th.de.p039if.ad.qw.rg(t, "defaultItem is null");
        return th.de.ppp.qw.ppp(new w(this, t));
    }

    public final de<T> lastElement() {
        return th.de.ppp.qw.m2358switch(new v(this));
    }

    public final yj<T> lastOrError() {
        return th.de.ppp.qw.ppp(new w(this, null));
    }

    public final <R> rg<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        th.de.p039if.ad.qw.rg(observableOperator, "lifter is null");
        return th.de.ppp.qw.when(new x(this, observableOperator));
    }

    public final <R> rg<R> map(Function<? super T, ? extends R> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new y(this, function));
    }

    public final rg<fe<T>> materialize() {
        return th.de.ppp.qw.when(new a0(this));
    }

    public final rg<T> mergeWith(ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return merge(this, (rg) observableSource);
    }

    public final rg<T> observeOn(th thVar) {
        return observeOn(thVar, false, bufferSize());
    }

    public final <U> rg<U> ofType(Class<U> cls) {
        th.de.p039if.ad.qw.rg(cls, "clazz is null");
        return filter(Functions.o(cls)).cast(cls);
    }

    public final rg<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        th.de.p039if.ad.qw.rg(function, "resumeFunction is null");
        return th.de.ppp.qw.when(new c0(this, function, false));
    }

    public final rg<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        th.de.p039if.ad.qw.rg(function, "valueSupplier is null");
        return th.de.ppp.qw.when(new d0(this, function));
    }

    public final rg<T> onErrorReturnItem(T t) {
        th.de.p039if.ad.qw.rg(t, "item is null");
        return onErrorReturn(Functions.m1138if(t));
    }

    public final rg<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "next is null");
        return th.de.ppp.qw.when(new c0(this, Functions.m1138if(observableSource), true));
    }

    public final rg<T> onTerminateDetach() {
        return th.de.ppp.qw.when(new aaa(this));
    }

    public final th.de.p040switch.qw<T> publish() {
        return ObservablePublish.rg(this);
    }

    public final de<T> reduce(BiFunction<T, T, T> biFunction) {
        th.de.p039if.ad.qw.rg(biFunction, "reducer is null");
        return th.de.ppp.qw.m2358switch(new e0(this, biFunction));
    }

    public final <R> yj<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        th.de.p039if.ad.qw.rg(callable, "seedSupplier is null");
        th.de.p039if.ad.qw.rg(biFunction, "reducer is null");
        return th.de.ppp.qw.ppp(new g0(this, callable, biFunction));
    }

    public final rg<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final rg<T> repeatUntil(BooleanSupplier booleanSupplier) {
        th.de.p039if.ad.qw.rg(booleanSupplier, "stop is null");
        return th.de.ppp.qw.when(new ObservableRepeatUntil(this, booleanSupplier));
    }

    public final rg<T> repeatWhen(Function<? super rg<Object>, ? extends ObservableSource<?>> function) {
        th.de.p039if.ad.qw.rg(function, "handler is null");
        return th.de.ppp.qw.when(new ObservableRepeatWhen(this, function));
    }

    public final th.de.p040switch.qw<T> replay() {
        return ObservableReplay.o(this);
    }

    public final rg<T> retry() {
        return retry(Long.MAX_VALUE, Functions.de());
    }

    public final rg<T> retryUntil(BooleanSupplier booleanSupplier) {
        th.de.p039if.ad.qw.rg(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.nn(booleanSupplier));
    }

    public final rg<T> retryWhen(Function<? super rg<Throwable>, ? extends ObservableSource<?>> function) {
        th.de.p039if.ad.qw.rg(function, "handler is null");
        return th.de.ppp.qw.when(new ObservableRetryWhen(this, function));
    }

    public final void safeSubscribe(Observer<? super T> observer) {
        th.de.p039if.ad.qw.rg(observer, "observer is null");
        if (observer instanceof th.de.when.de) {
            subscribe(observer);
        } else {
            subscribe(new th.de.when.de(observer));
        }
    }

    public final rg<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, th.de.vvv.qw.qw());
    }

    public final rg<T> scan(BiFunction<T, T, T> biFunction) {
        th.de.p039if.ad.qw.rg(biFunction, "accumulator is null");
        return th.de.ppp.qw.when(new h0(this, biFunction));
    }

    public final <R> rg<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        th.de.p039if.ad.qw.rg(callable, "seedSupplier is null");
        th.de.p039if.ad.qw.rg(biFunction, "accumulator is null");
        return th.de.ppp.qw.when(new i0(this, callable, biFunction));
    }

    public final rg<T> serialize() {
        return th.de.ppp.qw.when(new j0(this));
    }

    public final rg<T> share() {
        return publish().fe();
    }

    public final yj<T> single(T t) {
        th.de.p039if.ad.qw.rg(t, "defaultItem is null");
        return th.de.ppp.qw.ppp(new l0(this, t));
    }

    public final de<T> singleElement() {
        return th.de.ppp.qw.m2358switch(new k0(this));
    }

    public final yj<T> singleOrError() {
        return th.de.ppp.qw.ppp(new l0(this, null));
    }

    public final rg<T> skip(long j) {
        if (j <= 0) {
            return th.de.ppp.qw.when(this);
        }
        return th.de.ppp.qw.when(new m0(this, j));
    }

    public final rg<T> skipLast(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        } else if (i2 == 0) {
            return th.de.ppp.qw.when(this);
        } else {
            return th.de.ppp.qw.when(new ObservableSkipLast(this, i2));
        }
    }

    public final <U> rg<T> skipUntil(ObservableSource<U> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return th.de.ppp.qw.when(new n0(this, observableSource));
    }

    public final rg<T> skipWhile(Predicate<? super T> predicate) {
        th.de.p039if.ad.qw.rg(predicate, "predicate is null");
        return th.de.ppp.qw.when(new o0(this, predicate));
    }

    public final rg<T> sorted() {
        return toList().th().map(Functions.m1139switch(Functions.when())).flatMapIterable(Functions.i());
    }

    public final rg<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final rg<T> startWithArray(T... tArr) {
        rg fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return th.de.ppp.qw.when(this);
        }
        return concatArray(fromArray, this);
    }

    public final Disposable subscribe() {
        return subscribe(Functions.yj(), Functions.f9952rg, Functions.f9949de, Functions.yj());
    }

    public abstract void subscribeActual(Observer<? super T> observer);

    public final rg<T> subscribeOn(th thVar) {
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableSubscribeOn(this, thVar));
    }

    public final <E extends Observer<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final rg<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return th.de.ppp.qw.when(new p0(this, observableSource));
    }

    public final <R> rg<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    public final qw switchMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.pf(new ObservableSwitchMapCompletable(this, function, false));
    }

    public final qw switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.pf(new ObservableSwitchMapCompletable(this, function, true));
    }

    public final <R> rg<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    public final <R> rg<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new ObservableSwitchMapMaybe(this, function, false));
    }

    public final <R> rg<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new ObservableSwitchMapMaybe(this, function, true));
    }

    public final <R> rg<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new ObservableSwitchMapSingle(this, function, false));
    }

    public final <R> rg<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new ObservableSwitchMapSingle(this, function, true));
    }

    public final rg<T> take(long j) {
        if (j >= 0) {
            return th.de.ppp.qw.when(new q0(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final rg<T> takeLast(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        } else if (i2 == 0) {
            return th.de.ppp.qw.when(new s(this));
        } else {
            if (i2 == 1) {
                return th.de.ppp.qw.when(new r0(this));
            }
            return th.de.ppp.qw.when(new ObservableTakeLast(this, i2));
        }
    }

    public final <U> rg<T> takeUntil(ObservableSource<U> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return th.de.ppp.qw.when(new ObservableTakeUntil(this, observableSource));
    }

    public final rg<T> takeWhile(Predicate<? super T> predicate) {
        th.de.p039if.ad.qw.rg(predicate, "predicate is null");
        return th.de.ppp.qw.when(new t0(this, predicate));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final rg<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, th.de.vvv.qw.qw());
    }

    public final rg<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final rg<T> throttleLatest(long j, TimeUnit timeUnit) {
        return throttleLatest(j, timeUnit, th.de.vvv.qw.qw(), false);
    }

    public final rg<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final rg<th.de.vvv.ad<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, th.de.vvv.qw.qw());
    }

    public final <V> rg<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return timeout0((ObservableSource) null, function, (ObservableSource) null);
    }

    public final rg<th.de.vvv.ad<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, th.de.vvv.qw.qw());
    }

    public final <R> R to(Function<? super rg<T>, R> function) {
        try {
            th.de.p039if.ad.qw.rg(function, "converter is null");
            return function.apply(this);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            throw ExceptionHelper.fe(th2);
        }
    }

    public final ad<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        th.de.p039if.fe.ad.rg rgVar = new th.de.p039if.fe.ad.rg(this);
        int i2 = qw.qw[backpressureStrategy.ordinal()];
        if (i2 == 1) {
            return rgVar.fe();
        }
        if (i2 == 2) {
            return rgVar.rg();
        }
        if (i2 == 3) {
            return rgVar;
        }
        if (i2 != 4) {
            return rgVar.ad();
        }
        return th.de.ppp.qw.m2357if(new FlowableOnBackpressureError(rgVar));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new th.de.p039if.de.uk());
    }

    public final yj<List<T>> toList() {
        return toList(16);
    }

    public final <K> yj<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        th.de.p039if.ad.qw.rg(function, "keySelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.d(function));
    }

    public final <K> yj<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return toMultimap(function, Functions.i(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final yj<List<T>> toSortedList() {
        return toSortedList(Functions.ppp());
    }

    public final rg<T> unsubscribeOn(th thVar) {
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableUnsubscribeOn(this, thVar));
    }

    public final rg<rg<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    public final <U, R> rg<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        th.de.p039if.ad.qw.rg(biFunction, "combiner is null");
        return th.de.ppp.qw.when(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    public final <U, R> rg<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(iterable, "other is null");
        th.de.p039if.ad.qw.rg(biFunction, "zipper is null");
        return th.de.ppp.qw.when(new z0(this, iterable, biFunction));
    }

    public static <T, R> rg<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    public static <T, R> rg<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i2);
    }

    public static <T> rg<T> concatArrayEager(int i2, int i3, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.i(), i2, i3, false);
    }

    public static <T> rg<T> concatArrayEagerDelayError(int i2, int i3, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.i(), i2, i3, true);
    }

    public static <T> rg<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2, int i3) {
        return wrap(observableSource).concatMapEager(Functions.i(), i2, i3);
    }

    public static rg<Long> interval(long j, long j2, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableInterval(Math.max(0, j), Math.max(0, j2), timeUnit, thVar));
    }

    public static rg<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, th thVar) {
        long j5 = j2;
        long j6 = j3;
        TimeUnit timeUnit2 = timeUnit;
        th thVar2 = thVar;
        int i2 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j5);
        } else if (i2 == 0) {
            return empty().delay(j6, timeUnit2, thVar2);
        } else {
            long j7 = j + (j5 - 1);
            if (j <= 0 || j7 >= 0) {
                th.de.p039if.ad.qw.rg(timeUnit2, "unit is null");
                th.de.p039if.ad.qw.rg(thVar2, "scheduler is null");
                return th.de.ppp.qw.when(new ObservableIntervalRange(j, j7, Math.max(0, j6), Math.max(0, j4), timeUnit, thVar));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> rg<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.i());
    }

    public static <T> rg<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), observableSourceArr.length);
    }

    public static <T> rg<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), true, observableSourceArr.length);
    }

    public static <T> rg<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).flatMap(Functions.i(), true, i2, i3);
    }

    public static <T> yj<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    public static <T> rg<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return th.de.ppp.qw.when(new ObservableSwitchMap(observableSource, Functions.i(), i2, true));
    }

    public static rg<Long> timer(long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableTimer(Math.max(j, 0), timeUnit, thVar));
    }

    public static <T, D> rg<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        th.de.p039if.ad.qw.rg(callable, "resourceSupplier is null");
        th.de.p039if.ad.qw.rg(function, "sourceSupplier is null");
        th.de.p039if.ad.qw.rg(consumer, "disposer is null");
        return th.de.ppp.qw.when(new ObservableUsing(callable, function, consumer, z));
    }

    public final Iterable<T> blockingIterable(int i2) {
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return new BlockingObservableIterable(this, i2);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer) {
        i.de(this, consumer, Functions.f9952rg, Functions.f9949de);
    }

    public final rg<List<T>> buffer(int i2, int i3) {
        return buffer(i2, i3, ArrayListSupplier.asCallable());
    }

    public final <R> rg<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return th.de.ppp.qw.when(new ObservableConcatMap(this, function, i2, ErrorMode.IMMEDIATE));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.qw(call, function);
    }

    public final qw concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "capacityHint");
        return th.de.ppp.qw.pf(new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i2));
    }

    public final qw concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z) {
        return concatMapCompletableDelayError(function, z, 2);
    }

    public final <R> rg<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.qw(call, function);
        }
        return th.de.ppp.qw.when(new ObservableConcatMap(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final <R> rg<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "maxConcurrency");
        th.de.p039if.ad.qw.th(i3, "prefetch");
        return th.de.ppp.qw.when(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i2, i3));
    }

    public final <R> rg<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3, boolean z) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "maxConcurrency");
        th.de.p039if.ad.qw.th(i3, "prefetch");
        return th.de.ppp.qw.when(new ObservableConcatMapEager(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2, i3));
    }

    public final <R> rg<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return th.de.ppp.qw.when(new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i2));
    }

    public final <R> rg<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        return concatMapMaybeDelayError(function, z, 2);
    }

    public final <R> rg<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return th.de.ppp.qw.when(new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i2));
    }

    public final <R> rg<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        return concatMapSingleDelayError(function, z, 2);
    }

    public final <R> rg<R> dematerialize(Function<? super T, fe<R>> function) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        return th.de.ppp.qw.when(new mmm(this, function));
    }

    public final <K> rg<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.th());
    }

    public final <K> rg<T> distinctUntilChanged(Function<? super T, K> function) {
        th.de.p039if.ad.qw.rg(function, "keySelector is null");
        return th.de.ppp.qw.when(new eee(this, function, th.de.p039if.ad.qw.fe()));
    }

    public final <R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return flatMap(function, z, Integer.MAX_VALUE);
    }

    public final qw flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.pf(new ObservableFlatMapCompletableCompletable(this, function, z));
    }

    public final <R> rg<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new ObservableFlatMapMaybe(this, function, z));
    }

    public final <R> rg<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        return th.de.ppp.qw.when(new ObservableFlatMapSingle(this, function, z));
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.f9949de);
    }

    public final <K> rg<th.de.p040switch.ad<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        return groupBy(function, Functions.i(), z, bufferSize());
    }

    public final rg<T> observeOn(th thVar, boolean z) {
        return observeOn(thVar, z, bufferSize());
    }

    public final <R> rg<R> publish(Function<? super rg<T>, ? extends ObservableSource<R>> function) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        return th.de.ppp.qw.when(new ObservablePublishSelector(this, function));
    }

    public final rg<T> repeat(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + j);
        } else if (i2 == 0) {
            return empty();
        } else {
            return th.de.ppp.qw.when(new ObservableRepeat(this, j));
        }
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        return ObservableReplay.pf(ObservableInternalHelper.yj(this), function);
    }

    public final rg<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        th.de.p039if.ad.qw.rg(biPredicate, "predicate is null");
        return th.de.ppp.qw.when(new ObservableRetryBiPredicate(this, biPredicate));
    }

    public final rg<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, th.de.vvv.qw.qw(), z);
    }

    public final rg<T> sorted(Comparator<? super T> comparator) {
        th.de.p039if.ad.qw.rg(comparator, "sortFunction is null");
        return toList().th().map(Functions.m1139switch(comparator)).flatMapIterable(Functions.i());
    }

    public final rg<T> startWith(ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.f9952rg, Functions.f9949de, Functions.yj());
    }

    public final <R> rg<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return th.de.ppp.qw.when(new ObservableSwitchMap(this, function, i2, false));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.qw(call, function);
    }

    public final <R> rg<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return th.de.ppp.qw.when(new ObservableSwitchMap(this, function, i2, true));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.qw(call, function);
    }

    public final rg<T> throttleFirst(long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableThrottleFirstTimed(this, j, timeUnit, thVar));
    }

    public final rg<T> throttleLast(long j, TimeUnit timeUnit, th thVar) {
        return sample(j, timeUnit, thVar);
    }

    public final rg<T> throttleLatest(long j, TimeUnit timeUnit, boolean z) {
        return throttleLatest(j, timeUnit, th.de.vvv.qw.qw(), z);
    }

    public final rg<T> throttleWithTimeout(long j, TimeUnit timeUnit, th thVar) {
        return debounce(j, timeUnit, thVar);
    }

    public final rg<th.de.vvv.ad<T>> timeInterval(th thVar) {
        return timeInterval(TimeUnit.MILLISECONDS, thVar);
    }

    public final <V> rg<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return timeout0((ObservableSource) null, function, observableSource);
    }

    public final rg<th.de.vvv.ad<T>> timestamp(th thVar) {
        return timestamp(TimeUnit.MILLISECONDS, thVar);
    }

    public final yj<List<T>> toList(int i2) {
        th.de.p039if.ad.qw.th(i2, "capacityHint");
        return th.de.ppp.qw.ppp(new w0(this, i2));
    }

    public final yj<List<T>> toSortedList(Comparator<? super T> comparator) {
        th.de.p039if.ad.qw.rg(comparator, "comparator is null");
        return toList().fe(Functions.m1139switch(comparator));
    }

    public final rg<rg<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    public static <T, R> rg<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2) {
        th.de.p039if.ad.qw.rg(iterable, "sources is null");
        th.de.p039if.ad.qw.rg(function, "combiner is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableCombineLatest((ObservableSource<? extends T>[]) null, iterable, function, i2 << 1, false));
    }

    public static <T, R> rg<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i2) {
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        th.de.p039if.ad.qw.rg(function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return th.de.ppp.qw.when(new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i2 << 1, true));
    }

    public static <T> rg<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    public static <T> rg<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    public static <T> rg<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> rg<T> error(Throwable th2) {
        th.de.p039if.ad.qw.rg(th2, "exception is null");
        return error((Callable<? extends Throwable>) Functions.pf(th2));
    }

    public static <T> rg<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        th.de.p039if.ad.qw.rg(future, "future is null");
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        return th.de.ppp.qw.when(new l(future, j, timeUnit));
    }

    public static <T> rg<T> just(T t, T t2) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        return fromArray(t, t2);
    }

    public static <T> rg<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i2) {
        return fromIterable(iterable).flatMap(Functions.i(), i2);
    }

    public static <T> rg<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i2) {
        return fromIterable(iterable).flatMap(Functions.i(), true, i2);
    }

    public static <T> yj<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(biPredicate, "isEqual is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.ppp(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i2));
    }

    public final T blockingSingle(T t) {
        return single(t).de();
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        i.de(this, consumer, consumer2, Functions.f9949de);
    }

    public final <U extends Collection<? super T>> rg<U> buffer(int i2, int i3, Callable<U> callable) {
        th.de.p039if.ad.qw.th(i2, "count");
        th.de.p039if.ad.qw.th(i3, RadialViewGroup.SKIP_TAG);
        th.de.p039if.ad.qw.rg(callable, "bufferSupplier is null");
        return th.de.ppp.qw.when(new ObservableBuffer(this, i2, i3, callable));
    }

    public final qw concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return th.de.ppp.qw.pf(new ObservableConcatMapCompletable(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    public final <U> rg<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return concatMap(ObservableInternalHelper.qw(function), i2);
    }

    public final <R> rg<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return th.de.ppp.qw.when(new ObservableConcatMapMaybe(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    public final <R> rg<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return th.de.ppp.qw.when(new ObservableConcatMapSingle(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    public final rg<T> concatWith(SingleSource<? extends T> singleSource) {
        th.de.p039if.ad.qw.rg(singleSource, "other is null");
        return th.de.ppp.qw.when(new ObservableConcatWithSingle(this, singleSource));
    }

    public final rg<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, th.de.vvv.qw.qw());
    }

    public final rg<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, th.de.vvv.qw.qw(), false);
    }

    public final rg<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, th.de.vvv.qw.qw());
    }

    public final <K> rg<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        th.de.p039if.ad.qw.rg(function, "keySelector is null");
        th.de.p039if.ad.qw.rg(callable, "collectionSupplier is null");
        return th.de.ppp.qw.when(new qqq(this, function, callable));
    }

    public final yj<T> elementAt(long j, T t) {
        if (j >= 0) {
            th.de.p039if.ad.qw.rg(t, "defaultItem is null");
            return th.de.ppp.qw.ppp(new d(this, j, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final <R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2) {
        return flatMap(function, z, i2, bufferSize());
    }

    public final <U, V> rg<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.rg(biFunction, "resultSelector is null");
        return flatMap(ObservableInternalHelper.qw(function), biFunction, false, bufferSize(), bufferSize());
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        th.de.p039if.ad.qw.rg(predicate, "onNext is null");
        th.de.p039if.ad.qw.rg(consumer, "onError is null");
        th.de.p039if.ad.qw.rg(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K, V> rg<th.de.p040switch.ad<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    public final rg<T> mergeWith(SingleSource<? extends T> singleSource) {
        th.de.p039if.ad.qw.rg(singleSource, "other is null");
        return th.de.ppp.qw.when(new ObservableMergeWithSingle(this, singleSource));
    }

    public final rg<T> observeOn(th thVar, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableObserveOn(this, thVar, z, i2));
    }

    public final rg<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "next is null");
        return onErrorResumeNext(Functions.m1138if(observableSource));
    }

    public final <R> yj<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        th.de.p039if.ad.qw.rg(r, "seed is null");
        th.de.p039if.ad.qw.rg(biFunction, "reducer is null");
        return th.de.ppp.qw.ppp(new f0(this, r, biFunction));
    }

    public final rg<T> sample(long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableSampleTimed(this, j, timeUnit, thVar, false));
    }

    public final <R> rg<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        th.de.p039if.ad.qw.rg(r, "initialValue is null");
        return scanWith(Functions.pf(r), biFunction);
    }

    public final rg<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.f9949de, Functions.yj());
    }

    public final rg<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    public final rg<T> takeUntil(Predicate<? super T> predicate) {
        th.de.p039if.ad.qw.rg(predicate, "stopPredicate is null");
        return th.de.ppp.qw.when(new s0(this, predicate));
    }

    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final rg<T> throttleLatest(long j, TimeUnit timeUnit, th thVar) {
        return throttleLatest(j, timeUnit, thVar, false);
    }

    public final rg<th.de.vvv.ad<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, th.de.vvv.qw.qw());
    }

    public final rg<th.de.vvv.ad<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, th.de.vvv.qw.qw());
    }

    public final <K, V> yj<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        th.de.p039if.ad.qw.rg(function, "keySelector is null");
        th.de.p039if.ad.qw.rg(function2, "valueSelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.e(function, function2));
    }

    public final rg<rg<T>> window(long j, long j2, int i2) {
        th.de.p039if.ad.qw.yj(j, "count");
        th.de.p039if.ad.qw.yj(j2, RadialViewGroup.SKIP_TAG);
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableWindow(this, j, j2, i2));
    }

    public static <T> rg<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        th.de.p039if.ad.qw.th(i2, "prefetch");
        return th.de.ppp.qw.when(new ObservableConcatMap(observableSource, Functions.i(), i2, ErrorMode.IMMEDIATE));
    }

    public static <T> rg<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2, boolean z) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        th.de.p039if.ad.qw.th(i2, "prefetch is null");
        return th.de.ppp.qw.when(new ObservableConcatMap(observableSource, Functions.i(), i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public static <T> rg<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.i(), i2, i3, false);
    }

    public static <T> rg<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        return th.de.ppp.qw.when(new ObservableFlatMap(observableSource, Functions.i(), false, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> rg<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        return th.de.ppp.qw.when(new ObservableFlatMap(observableSource, Functions.i(), true, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> rg<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    private <U, V> rg<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        th.de.p039if.ad.qw.rg(function, "itemTimeoutIndicator is null");
        return th.de.ppp.qw.when(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    public static <T, R> rg<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        th.de.p039if.ad.qw.rg(function, "zipper is null");
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        return th.de.ppp.qw.when(new v0(observableSource, 16).flatMap(ObservableInternalHelper.when(function)));
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        i.de(this, consumer, consumer2, action);
    }

    public final rg<T> debounce(long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableDebounceTimed(this, j, timeUnit, thVar));
    }

    public final rg<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, th.de.vvv.qw.qw(), z);
    }

    public final rg<T> delaySubscription(long j, TimeUnit timeUnit, th thVar) {
        return delaySubscription(timer(j, timeUnit, thVar));
    }

    public final rg<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        th.de.p039if.ad.qw.rg(biPredicate, "comparer is null");
        return th.de.ppp.qw.when(new eee(this, Functions.i(), biPredicate));
    }

    public final <R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2, int i3) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.th(i2, "maxConcurrency");
        th.de.p039if.ad.qw.th(i3, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return th.de.ppp.qw.when(new ObservableFlatMap(this, function, z, i2, i3));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.qw(call, function);
    }

    public final <K, V> rg<th.de.p040switch.ad<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function, int i2) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return ObservableReplay.pf(ObservableInternalHelper.uk(this, i2), function);
    }

    public final rg<T> retry(long j) {
        return retry(j, Functions.de());
    }

    public final rg<T> skip(long j, TimeUnit timeUnit, th thVar) {
        return skipUntil(timer(j, timeUnit, thVar));
    }

    public final rg<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, th.de.vvv.qw.fe(), false, bufferSize());
    }

    public final rg<T> startWith(T t) {
        th.de.p039if.ad.qw.rg(t, "item is null");
        return concatArray(just(t), this);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.yj());
    }

    public final rg<T> take(long j, TimeUnit timeUnit, th thVar) {
        return takeUntil(timer(j, timeUnit, thVar));
    }

    public final rg<T> throttleLatest(long j, TimeUnit timeUnit, th thVar, boolean z) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableThrottleLatest(this, j, timeUnit, thVar, z));
    }

    public final rg<th.de.vvv.ad<T>> timeInterval(TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new u0(this, timeUnit, thVar));
    }

    public final rg<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, (ObservableSource) null, th.de.vvv.qw.qw());
    }

    public final rg<th.de.vvv.ad<T>> timestamp(TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return map(Functions.mmm(timeUnit, thVar));
    }

    public final <U extends Collection<? super T>> yj<U> toList(Callable<U> callable) {
        th.de.p039if.ad.qw.rg(callable, "collectionSupplier is null");
        return th.de.ppp.qw.ppp(new w0(this, callable));
    }

    public final yj<List<T>> toSortedList(Comparator<? super T> comparator, int i2) {
        th.de.p039if.ad.qw.rg(comparator, "comparator is null");
        return toList(i2).fe(Functions.m1139switch(comparator));
    }

    public final <T1, T2, R> rg<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        th.de.p039if.ad.qw.rg(observableSource, "o1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "o2 is null");
        th.de.p039if.ad.qw.rg(function3, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2}, Functions.qqq(function3));
    }

    public final <U, R> rg<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    public static <T, S> rg<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        th.de.p039if.ad.qw.rg(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.m1140if(biConsumer), Functions.yj());
    }

    public static rg<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, th.de.vvv.qw.qw());
    }

    public final T blockingFirst(T t) {
        fe feVar = new fe();
        subscribe(feVar);
        T qw2 = feVar.qw();
        return qw2 != null ? qw2 : t;
    }

    public final T blockingLast(T t) {
        th.de.p039if.de.rg rgVar = new th.de.p039if.de.rg();
        subscribe(rgVar);
        T qw2 = rgVar.qw();
        return qw2 != null ? qw2 : t;
    }

    public final void blockingSubscribe(Observer<? super T> observer) {
        i.ad(this, observer);
    }

    public final rg<T> concatWith(MaybeSource<? extends T> maybeSource) {
        th.de.p039if.ad.qw.rg(maybeSource, "other is null");
        return th.de.ppp.qw.when(new ObservableConcatWithMaybe(this, maybeSource));
    }

    public final rg<T> delay(long j, TimeUnit timeUnit, th thVar) {
        return delay(j, timeUnit, thVar, false);
    }

    public final <K, V> rg<th.de.p040switch.ad<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(function, "keySelector is null");
        th.de.p039if.ad.qw.rg(function2, "valueSelector is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableGroupBy(this, function, function2, i2, z));
    }

    public final rg<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        th.de.p039if.ad.qw.rg(maybeSource, "other is null");
        return th.de.ppp.qw.when(new ObservableMergeWithMaybe(this, maybeSource));
    }

    public final rg<T> retry(long j, Predicate<? super Throwable> predicate) {
        if (j >= 0) {
            th.de.p039if.ad.qw.rg(predicate, "predicate is null");
            return th.de.ppp.qw.when(new ObservableRetryPredicate(this, j, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final rg<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, th.de.vvv.qw.fe(), z, bufferSize());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        th.de.p039if.ad.qw.rg(consumer, "onNext is null");
        th.de.p039if.ad.qw.rg(consumer2, "onError is null");
        th.de.p039if.ad.qw.rg(action, "onComplete is null");
        th.de.p039if.ad.qw.rg(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final rg<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, th.de.vvv.qw.fe(), false, bufferSize());
    }

    public final rg<T> timeout(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return timeout0(j, timeUnit, observableSource, th.de.vvv.qw.qw());
    }

    public final <K, V> yj<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public static <T> rg<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(thVar);
    }

    public static rg<Long> interval(long j, TimeUnit timeUnit, th thVar) {
        return interval(j, j, timeUnit, thVar);
    }

    public static <T> rg<T> just(T t, T t2, T t3) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    public static <T> rg<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        th.de.p039if.ad.qw.th(i2, "maxConcurrency");
        return th.de.ppp.qw.when(new ObservableFlatMap(observableSource, Functions.i(), false, i2, bufferSize()));
    }

    public static <T> rg<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "sources is null");
        th.de.p039if.ad.qw.th(i2, "maxConcurrency");
        return th.de.ppp.qw.when(new ObservableFlatMap(observableSource, Functions.i(), true, i2, bufferSize()));
    }

    public final rg<T> delay(long j, TimeUnit timeUnit, th thVar, boolean z) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ddd(this, j, timeUnit, thVar, z));
    }

    public final rg<T> doOnEach(Consumer<? super fe<T>> consumer) {
        th.de.p039if.ad.qw.rg(consumer, "onNotification is null");
        return doOnEach(Functions.xxx(consumer), Functions.vvv(consumer), Functions.ggg(consumer), Functions.f9949de);
    }

    public final rg<T> sample(long j, TimeUnit timeUnit, th thVar, boolean z) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return th.de.ppp.qw.when(new ObservableSampleTimed(this, j, timeUnit, thVar, z));
    }

    public final rg<T> skipLast(long j, TimeUnit timeUnit, th thVar) {
        return skipLast(j, timeUnit, thVar, false, bufferSize());
    }

    public final rg<T> takeLast(long j, long j2, TimeUnit timeUnit, th thVar) {
        return takeLast(j, j2, timeUnit, thVar, false, bufferSize());
    }

    public final <K, V> yj<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        th.de.p039if.ad.qw.rg(function, "keySelector is null");
        th.de.p039if.ad.qw.rg(function2, "valueSelector is null");
        th.de.p039if.ad.qw.rg(callable, "mapSupplier is null");
        return collect(callable, Functions.e(function, function2));
    }

    public final yj<List<T>> toSortedList(int i2) {
        return toSortedList(Functions.ppp(), i2);
    }

    public final <U, R> rg<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip(this, observableSource, biFunction, z);
    }

    public static <T, R> rg<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    public static <T> rg<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    public static <T, S> rg<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        th.de.p039if.ad.qw.rg(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.m1140if(biConsumer), consumer);
    }

    public final <U extends Collection<? super T>> rg<U> buffer(int i2, Callable<U> callable) {
        return buffer(i2, i2, callable);
    }

    public final rg<T> concatWith(CompletableSource completableSource) {
        th.de.p039if.ad.qw.rg(completableSource, "other is null");
        return th.de.ppp.qw.when(new ObservableConcatWithCompletable(this, completableSource));
    }

    public final rg<T> mergeWith(CompletableSource completableSource) {
        th.de.p039if.ad.qw.rg(completableSource, "other is null");
        return th.de.ppp.qw.when(new ObservableMergeWithCompletable(this, completableSource));
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function, int i2, long j, TimeUnit timeUnit) {
        return replay(function, i2, j, timeUnit, th.de.vvv.qw.qw());
    }

    public final rg<T> skipLast(long j, TimeUnit timeUnit, th thVar, boolean z) {
        return skipLast(j, timeUnit, thVar, z, bufferSize());
    }

    public final rg<T> takeLast(long j, long j2, TimeUnit timeUnit, th thVar, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        if (j >= 0) {
            return th.de.ppp.qw.when(new ObservableTakeLastTimed(this, j, j2, timeUnit, thVar, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j);
    }

    public final rg<T> timeout(long j, TimeUnit timeUnit, th thVar, ObservableSource<? extends T> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "other is null");
        return timeout0(j, timeUnit, observableSource, thVar);
    }

    public final rg<rg<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, th.de.vvv.qw.qw(), bufferSize());
    }

    public final <U, R> rg<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        return zip(this, observableSource, biFunction, z, i2);
    }

    public static <T, R> rg<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i2) {
        th.de.p039if.ad.qw.rg(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        th.de.p039if.ad.qw.rg(function, "combiner is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i2 << 1, false));
    }

    public static <T, R> rg<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    public static <T> yj<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i2) {
        return sequenceEqual(observableSource, observableSource2, th.de.p039if.ad.qw.fe(), i2);
    }

    public final rg<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return buffer(j, j2, timeUnit, th.de.vvv.qw.qw(), ArrayListSupplier.asCallable());
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function, int i2, long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return ObservableReplay.pf(ObservableInternalHelper.i(this, i2, j, timeUnit, thVar), function);
    }

    public final rg<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    public final rg<T> skipLast(long j, TimeUnit timeUnit, th thVar, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableSkipLastTimed(this, j, timeUnit, thVar, i2 << 1, z));
    }

    public final <K, V> yj<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        th.de.p039if.ad.qw.rg(function, "keySelector is null");
        th.de.p039if.ad.qw.rg(function2, "valueSelector is null");
        th.de.p039if.ad.qw.rg(callable, "mapSupplier is null");
        th.de.p039if.ad.qw.rg(function3, "collectionFactory is null");
        return collect(callable, Functions.f(function, function2, function3));
    }

    public final rg<rg<T>> window(long j, long j2, TimeUnit timeUnit, th thVar) {
        return window(j, j2, timeUnit, thVar, bufferSize());
    }

    public static <T, R> rg<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2) {
        th.de.p039if.ad.qw.rg(iterable, "sources is null");
        th.de.p039if.ad.qw.rg(function, "combiner is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableCombineLatest((ObservableSource<? extends T>[]) null, iterable, function, i2 << 1, true));
    }

    public static <T> rg<T> fromFuture(Future<? extends T> future, th thVar) {
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return fromFuture(future).subscribeOn(thVar);
    }

    public static <T, S> rg<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.yj());
    }

    public static <T> rg<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.i(), false, 2);
    }

    public static <T> rg<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.i(), true, 2);
    }

    public static <T1, T2, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        return zipArray(Functions.aaa(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    public final rg<List<T>> buffer(long j, long j2, TimeUnit timeUnit, th thVar) {
        return buffer(j, j2, timeUnit, thVar, ArrayListSupplier.asCallable());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <U, V> th.de.rg<T> delay(io.reactivex.ObservableSource<U> r1, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> r2) {
        /*
            r0 = this;
            th.de.rg r1 = r0.delaySubscription(r1)
            th.de.rg r1 = r1.delay(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: th.de.rg.delay(io.reactivex.ObservableSource, io.reactivex.functions.Function):th.de.rg");
    }

    public final <U> rg<T> sample(ObservableSource<U> observableSource) {
        th.de.p039if.ad.qw.rg(observableSource, "sampler is null");
        return th.de.ppp.qw.when(new ObservableSampleWithObservable(this, observableSource, false));
    }

    public final rg<T> timeout(long j, TimeUnit timeUnit, th thVar) {
        return timeout0(j, timeUnit, (ObservableSource) null, thVar);
    }

    public final rg<rg<T>> window(long j, long j2, TimeUnit timeUnit, th thVar, int i2) {
        th.de.p039if.ad.qw.yj(j, "timespan");
        long j3 = j2;
        th.de.p039if.ad.qw.yj(j3, "timeskip");
        int i3 = i2;
        th.de.p039if.ad.qw.th(i3, "bufferSize");
        th thVar2 = thVar;
        th.de.p039if.ad.qw.rg(thVar2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        th.de.p039if.ad.qw.rg(timeUnit2, "unit is null");
        return th.de.ppp.qw.when(new y0(this, j, j3, timeUnit2, thVar2, Long.MAX_VALUE, i3, false));
    }

    public final <T1, T2, T3, R> rg<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        th.de.p039if.ad.qw.rg(observableSource, "o1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "o2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "o3 is null");
        th.de.p039if.ad.qw.rg(function4, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.eee(function4));
    }

    public static <T> rg<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    public static <T, S> rg<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        th.de.p039if.ad.qw.rg(callable, "initialState is null");
        th.de.p039if.ad.qw.rg(biFunction, "generator is null");
        th.de.p039if.ad.qw.rg(consumer, "disposeState is null");
        return th.de.ppp.qw.when(new q(callable, biFunction, consumer));
    }

    public static <T> rg<T> just(T t, T t2, T t3, T t4) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        th.de.p039if.ad.qw.rg(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    public final <U extends Collection<? super T>> rg<U> buffer(long j, long j2, TimeUnit timeUnit, th thVar, Callable<U> callable) {
        TimeUnit timeUnit2 = timeUnit;
        th.de.p039if.ad.qw.rg(timeUnit2, "unit is null");
        th thVar2 = thVar;
        th.de.p039if.ad.qw.rg(thVar2, "scheduler is null");
        Callable<U> callable2 = callable;
        th.de.p039if.ad.qw.rg(callable2, "bufferSupplier is null");
        return th.de.ppp.qw.when(new Cif(this, j, j2, timeUnit2, thVar2, callable2, Integer.MAX_VALUE, false));
    }

    public final <U, V> rg<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        th.de.p039if.ad.qw.rg(observableSource, "firstTimeoutIndicator is null");
        return timeout0(observableSource, function, (ObservableSource) null);
    }

    public final rg<T> doOnEach(Observer<? super T> observer) {
        th.de.p039if.ad.qw.rg(observer, "observer is null");
        return doOnEach(ObservableInternalHelper.th(observer), ObservableInternalHelper.rg(observer), ObservableInternalHelper.fe(observer), Functions.f9949de);
    }

    public final <U> rg<T> sample(ObservableSource<U> observableSource, boolean z) {
        th.de.p039if.ad.qw.rg(observableSource, "sampler is null");
        return th.de.ppp.qw.when(new ObservableSampleWithObservable(this, observableSource, z));
    }

    public final void subscribe(Observer<? super T> observer) {
        th.de.p039if.ad.qw.rg(observer, "observer is null");
        try {
            Observer<? super Object> rrr = th.de.ppp.qw.rrr(this, observer);
            th.de.p039if.ad.qw.rg(rrr, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(rrr);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            th.de.ppp.qw.ddd(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public static <T> rg<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.i(), false, 3);
    }

    public static <T> rg<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.i(), true, 3);
    }

    public static <T1, T2, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        return zipArray(Functions.aaa(biFunction), z, bufferSize(), observableSource, observableSource2);
    }

    public final <R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        th.de.p039if.ad.qw.rg(function, "onNextMapper is null");
        th.de.p039if.ad.qw.rg(function2, "onErrorMapper is null");
        th.de.p039if.ad.qw.rg(callable, "onCompleteSupplier is null");
        return merge(new z(this, function, function2, callable));
    }

    public final rg<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, th.de.vvv.qw.fe(), false, bufferSize());
    }

    public final <U, V> rg<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        th.de.p039if.ad.qw.rg(observableSource, "firstTimeoutIndicator is null");
        th.de.p039if.ad.qw.rg(observableSource2, "other is null");
        return timeout0(observableSource, function, observableSource2);
    }

    public final rg<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, th.de.vvv.qw.fe(), z, bufferSize());
    }

    public final <K, V> yj<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    public static <T1, T2, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        return combineLatest(Functions.aaa(biFunction), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2});
    }

    public static <T> rg<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    public final rg<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, th.de.vvv.qw.qw(), Integer.MAX_VALUE);
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function, int i2, th thVar) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return ObservableReplay.pf(ObservableInternalHelper.uk(this, i2), ObservableInternalHelper.pf(function, thVar));
    }

    public final rg<T> takeLast(long j, TimeUnit timeUnit, th thVar) {
        return takeLast(j, timeUnit, thVar, false, bufferSize());
    }

    public static <T> rg<T> just(T t, T t2, T t3, T t4, T t5) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        th.de.p039if.ad.qw.rg(t4, "item4 is null");
        th.de.p039if.ad.qw.rg(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T1, T2, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        return zipArray(Functions.aaa(biFunction), z, i2, observableSource, observableSource2);
    }

    public final rg<List<T>> buffer(long j, TimeUnit timeUnit, int i2) {
        return buffer(j, timeUnit, th.de.vvv.qw.qw(), i2);
    }

    public final rg<T> takeLast(long j, TimeUnit timeUnit, th thVar, boolean z) {
        return takeLast(j, timeUnit, thVar, z, bufferSize());
    }

    public final rg<rg<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, th.de.vvv.qw.qw(), Long.MAX_VALUE, false);
    }

    public final <T1, T2, T3, T4, R> rg<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        th.de.p039if.ad.qw.rg(observableSource, "o1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "o2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "o3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "o4 is null");
        th.de.p039if.ad.qw.rg(function5, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.rrr(function5));
    }

    public static <T> rg<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.i(), false, 4);
    }

    public static <T> rg<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.i(), true, 4);
    }

    public final rg<List<T>> buffer(long j, TimeUnit timeUnit, th thVar, int i2) {
        return buffer(j, timeUnit, thVar, i2, ArrayListSupplier.asCallable(), false);
    }

    public final <R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i2) {
        th.de.p039if.ad.qw.rg(function, "onNextMapper is null");
        th.de.p039if.ad.qw.rg(function2, "onErrorMapper is null");
        th.de.p039if.ad.qw.rg(callable, "onCompleteSupplier is null");
        return merge(new z(this, function, function2, callable), i2);
    }

    public final rg<T> takeLast(long j, TimeUnit timeUnit, th thVar, boolean z, int i2) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, thVar, z, i2);
    }

    public final rg<rg<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, th.de.vvv.qw.qw(), j2, false);
    }

    public static <T1, T2, T3, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        return combineLatest(Functions.qqq(function3), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3});
    }

    public final <U extends Collection<? super T>> rg<U> buffer(long j, TimeUnit timeUnit, th thVar, int i2, Callable<U> callable, boolean z) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th thVar2 = thVar;
        th.de.p039if.ad.qw.rg(thVar2, "scheduler is null");
        Callable<U> callable2 = callable;
        th.de.p039if.ad.qw.rg(callable2, "bufferSupplier is null");
        int i3 = i2;
        th.de.p039if.ad.qw.th(i3, "count");
        return th.de.ppp.qw.when(new Cif(this, j, j, timeUnit, thVar2, callable2, i3, z));
    }

    public final rg<rg<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, th.de.vvv.qw.qw(), j2, z);
    }

    public static <T1, T2, T3, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        return zipArray(Functions.qqq(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    public final rg<rg<T>> window(long j, TimeUnit timeUnit, th thVar) {
        return window(j, timeUnit, thVar, Long.MAX_VALUE, false);
    }

    public final rg<rg<T>> window(long j, TimeUnit timeUnit, th thVar, long j2) {
        return window(j, timeUnit, thVar, j2, false);
    }

    public final <R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        return flatMap(function, false, i2, bufferSize());
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit) {
        return replay(function, j, timeUnit, th.de.vvv.qw.qw());
    }

    public final rg<rg<T>> window(long j, TimeUnit timeUnit, th thVar, long j2, boolean z) {
        return window(j, timeUnit, thVar, j2, z, bufferSize());
    }

    public static <T1, T2, T3, T4, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        return combineLatest(Functions.eee(function4), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4});
    }

    public static <T> rg<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        th.de.p039if.ad.qw.rg(t4, "item4 is null");
        th.de.p039if.ad.qw.rg(t5, "item5 is null");
        th.de.p039if.ad.qw.rg(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public final <U, R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return ObservableReplay.pf(ObservableInternalHelper.o(this, j, timeUnit, thVar), function);
    }

    public final rg<rg<T>> window(long j, TimeUnit timeUnit, th thVar, long j2, boolean z, int i2) {
        int i3 = i2;
        th.de.p039if.ad.qw.th(i3, "bufferSize");
        th thVar2 = thVar;
        th.de.p039if.ad.qw.rg(thVar2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        th.de.p039if.ad.qw.rg(timeUnit2, "unit is null");
        long j3 = j2;
        th.de.p039if.ad.qw.yj(j3, "count");
        return th.de.ppp.qw.when(new y0(this, j, j, timeUnit2, thVar2, j3, i3, z));
    }

    public static <T1, T2, T3, T4, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        return zipArray(Functions.eee(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    public final rg<List<T>> buffer(long j, TimeUnit timeUnit, th thVar) {
        return buffer(j, timeUnit, thVar, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final <U, R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    public final <R> rg<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        th.de.p039if.ad.qw.rg(observableSourceArr, "others is null");
        th.de.p039if.ad.qw.rg(function, "combiner is null");
        return th.de.ppp.qw.when(new ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    public final <TOpening, TClosing> rg<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return buffer(observableSource, function, ArrayListSupplier.asCallable());
    }

    public final <U, R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        return flatMap(function, biFunction, z, i2, bufferSize());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> rg<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        th.de.p039if.ad.qw.rg(observableSource, "openingIndicator is null");
        th.de.p039if.ad.qw.rg(function, "closingIndicator is null");
        th.de.p039if.ad.qw.rg(callable, "bufferSupplier is null");
        return th.de.ppp.qw.when(new ObservableBufferBoundary(this, observableSource, function, callable));
    }

    public final <U, R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2, int i3) {
        th.de.p039if.ad.qw.rg(function, "mapper is null");
        th.de.p039if.ad.qw.rg(biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.ad(function, biFunction), z, i2, i3);
    }

    public final <R> rg<R> replay(Function<? super rg<T>, ? extends ObservableSource<R>> function, th thVar) {
        th.de.p039if.ad.qw.rg(function, "selector is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return ObservableReplay.pf(ObservableInternalHelper.yj(this), ObservableInternalHelper.pf(function, thVar));
    }

    public final <R> rg<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        th.de.p039if.ad.qw.rg(iterable, "others is null");
        th.de.p039if.ad.qw.rg(function, "combiner is null");
        return th.de.ppp.qw.when(new ObservableWithLatestFromMany(this, iterable, function));
    }

    public static <T1, T2, T3, T4, T5, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        return combineLatest(Functions.rrr(function5), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5});
    }

    public final <B> rg<rg<T>> window(ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        return zipArray(Functions.rrr(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    public final <U, R> rg<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i2) {
        return flatMap(function, biFunction, false, i2, bufferSize());
    }

    public final <B> rg<rg<T>> window(ObservableSource<B> observableSource, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "boundary is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableWindowBoundary(this, observableSource, i2));
    }

    public static <T> rg<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        th.de.p039if.ad.qw.rg(t4, "item4 is null");
        th.de.p039if.ad.qw.rg(t5, "item5 is null");
        th.de.p039if.ad.qw.rg(t6, "item6 is null");
        th.de.p039if.ad.qw.rg(t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public final <B> rg<List<T>> buffer(ObservableSource<B> observableSource) {
        return buffer(observableSource, ArrayListSupplier.asCallable());
    }

    public final <B> rg<List<T>> buffer(ObservableSource<B> observableSource, int i2) {
        th.de.p039if.ad.qw.th(i2, "initialCapacity");
        return buffer(observableSource, Functions.rg(i2));
    }

    public final th.de.p040switch.qw<T> replay(int i2) {
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return ObservableReplay.rg(this, i2);
    }

    public final <U, V> rg<rg<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    public final <B, U extends Collection<? super T>> rg<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        th.de.p039if.ad.qw.rg(observableSource, "boundary is null");
        th.de.p039if.ad.qw.rg(callable, "bufferSupplier is null");
        return th.de.ppp.qw.when(new pf(this, observableSource, callable));
    }

    public final <U, V> rg<rg<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i2) {
        th.de.p039if.ad.qw.rg(observableSource, "openingIndicator is null");
        th.de.p039if.ad.qw.rg(function, "closingIndicator is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new x0(this, observableSource, function, i2));
    }

    public static <T1, T2, T3, T4, T5, T6, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        return combineLatest(Functions.tt(function6), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6});
    }

    public final th.de.p040switch.qw<T> replay(int i2, long j, TimeUnit timeUnit) {
        return replay(i2, j, timeUnit, th.de.vvv.qw.qw());
    }

    public static <T1, T2, T3, T4, T5, T6, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        return zipArray(Functions.tt(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    public final th.de.p040switch.qw<T> replay(int i2, long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return ObservableReplay.uk(this, j, timeUnit, thVar, i2);
    }

    public final <B> rg<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return buffer(callable, ArrayListSupplier.asCallable());
    }

    public final <B, U extends Collection<? super T>> rg<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        th.de.p039if.ad.qw.rg(callable, "boundarySupplier is null");
        th.de.p039if.ad.qw.rg(callable2, "bufferSupplier is null");
        return th.de.ppp.qw.when(new o(this, callable, callable2));
    }

    public final <B> rg<rg<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> rg<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        th.de.p039if.ad.qw.rg(t4, "item4 is null");
        th.de.p039if.ad.qw.rg(t5, "item5 is null");
        th.de.p039if.ad.qw.rg(t6, "item6 is null");
        th.de.p039if.ad.qw.rg(t7, "item7 is null");
        th.de.p039if.ad.qw.rg(t8, "item8 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    public final <B> rg<rg<T>> window(Callable<? extends ObservableSource<B>> callable, int i2) {
        th.de.p039if.ad.qw.rg(callable, "boundary is null");
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return th.de.ppp.qw.when(new ObservableWindowBoundarySupplier(this, callable, i2));
    }

    public final th.de.p040switch.qw<T> replay(int i2, th thVar) {
        th.de.p039if.ad.qw.th(i2, "bufferSize");
        return ObservableReplay.m1142if(replay(i2), thVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        th.de.p039if.ad.qw.rg(observableSource7, "source7 is null");
        return combineLatest(Functions.a(function7), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7});
    }

    public final th.de.p040switch.qw<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, th.de.vvv.qw.qw());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        th.de.p039if.ad.qw.rg(observableSource7, "source7 is null");
        return zipArray(Functions.a(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    public final th.de.p040switch.qw<T> replay(long j, TimeUnit timeUnit, th thVar) {
        th.de.p039if.ad.qw.rg(timeUnit, "unit is null");
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return ObservableReplay.th(this, j, timeUnit, thVar);
    }

    public final th.de.p040switch.qw<T> replay(th thVar) {
        th.de.p039if.ad.qw.rg(thVar, "scheduler is null");
        return ObservableReplay.m1142if(replay(), thVar);
    }

    public static <T> rg<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        th.de.p039if.ad.qw.rg(t4, "item4 is null");
        th.de.p039if.ad.qw.rg(t5, "item5 is null");
        th.de.p039if.ad.qw.rg(t6, "item6 is null");
        th.de.p039if.ad.qw.rg(t7, "item7 is null");
        th.de.p039if.ad.qw.rg(t8, "item8 is null");
        th.de.p039if.ad.qw.rg(t9, "item9 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        th.de.p039if.ad.qw.rg(observableSource7, "source7 is null");
        th.de.p039if.ad.qw.rg(observableSource8, "source8 is null");
        return combineLatest(Functions.b(function8), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        th.de.p039if.ad.qw.rg(observableSource7, "source7 is null");
        th.de.p039if.ad.qw.rg(observableSource8, "source8 is null");
        return zipArray(Functions.b(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    public static <T> rg<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        th.de.p039if.ad.qw.rg(t, "item1 is null");
        th.de.p039if.ad.qw.rg(t2, "item2 is null");
        th.de.p039if.ad.qw.rg(t3, "item3 is null");
        th.de.p039if.ad.qw.rg(t4, "item4 is null");
        th.de.p039if.ad.qw.rg(t5, "item5 is null");
        th.de.p039if.ad.qw.rg(t6, "item6 is null");
        th.de.p039if.ad.qw.rg(t7, "item7 is null");
        th.de.p039if.ad.qw.rg(t8, "item8 is null");
        th.de.p039if.ad.qw.rg(t9, "item9 is null");
        th.de.p039if.ad.qw.rg(t10, "item10 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> rg<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        th.de.p039if.ad.qw.rg(observableSource7, "source7 is null");
        th.de.p039if.ad.qw.rg(observableSource8, "source8 is null");
        th.de.p039if.ad.qw.rg(observableSource9, "source9 is null");
        return combineLatest(Functions.c(function9), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> rg<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        th.de.p039if.ad.qw.rg(observableSource, "source1 is null");
        th.de.p039if.ad.qw.rg(observableSource2, "source2 is null");
        th.de.p039if.ad.qw.rg(observableSource3, "source3 is null");
        th.de.p039if.ad.qw.rg(observableSource4, "source4 is null");
        th.de.p039if.ad.qw.rg(observableSource5, "source5 is null");
        th.de.p039if.ad.qw.rg(observableSource6, "source6 is null");
        th.de.p039if.ad.qw.rg(observableSource7, "source7 is null");
        th.de.p039if.ad.qw.rg(observableSource8, "source8 is null");
        th.de.p039if.ad.qw.rg(observableSource9, "source9 is null");
        return zipArray(Functions.c(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }
}
