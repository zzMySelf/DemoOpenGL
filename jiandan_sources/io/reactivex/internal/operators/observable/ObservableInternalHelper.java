package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import th.de.p039if.fe.rg.m;
import th.de.p039if.fe.rg.q0;
import th.de.p039if.fe.rg.y;

public final class ObservableInternalHelper {

    public enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    public static final class ad<T> implements Callable<th.de.p040switch.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final th.de.rg<T> f10113ad;

        /* renamed from: i  reason: collision with root package name */
        public final th.de.th f10114i;

        /* renamed from: th  reason: collision with root package name */
        public final int f10115th;

        /* renamed from: uk  reason: collision with root package name */
        public final TimeUnit f10116uk;

        /* renamed from: yj  reason: collision with root package name */
        public final long f10117yj;

        public ad(th.de.rg<T> rgVar, int i2, long j, TimeUnit timeUnit, th.de.th thVar) {
            this.f10113ad = rgVar;
            this.f10115th = i2;
            this.f10117yj = j;
            this.f10116uk = timeUnit;
            this.f10114i = thVar;
        }

        /* renamed from: qw */
        public th.de.p040switch.qw<T> call() {
            return this.f10113ad.replay(this.f10115th, this.f10117yj, this.f10116uk, this.f10114i);
        }
    }

    public static final class de<T, U> implements Function<T, ObservableSource<U>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends U>> f10118ad;

        public de(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.f10118ad = function;
        }

        /* renamed from: qw */
        public ObservableSource<U> apply(T t) throws Exception {
            Object apply = this.f10118ad.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null Iterable");
            return new m((Iterable) apply);
        }
    }

    public static final class fe<U, R, T> implements Function<U, R> {

        /* renamed from: ad  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends R> f10119ad;

        /* renamed from: th  reason: collision with root package name */
        public final T f10120th;

        public fe(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.f10119ad = biFunction;
            this.f10120th = t;
        }

        public R apply(U u) throws Exception {
            return this.f10119ad.apply(this.f10120th, u);
        }
    }

    public static final class i<T> implements Consumer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<T> f10121ad;

        public i(Observer<T> observer) {
            this.f10121ad = observer;
        }

        public void accept(T t) throws Exception {
            this.f10121ad.onNext(t);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableInternalHelper$if  reason: invalid class name */
    public static final class Cif<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: ad  reason: collision with root package name */
        public final BiConsumer<S, Emitter<T>> f10122ad;

        public Cif(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f10122ad = biConsumer;
        }

        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            qw(obj, (Emitter) obj2);
            return obj;
        }

        public S qw(S s, Emitter<T> emitter) throws Exception {
            this.f10122ad.accept(s, emitter);
            return s;
        }
    }

    public static final class o<T> implements Callable<th.de.p040switch.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final th.de.rg<T> f10123ad;

        public o(th.de.rg<T> rgVar) {
            this.f10123ad = rgVar;
        }

        /* renamed from: qw */
        public th.de.p040switch.qw<T> call() {
            return this.f10123ad.replay();
        }
    }

    public static final class pf<T, R> implements Function<th.de.rg<T>, ObservableSource<R>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function<? super th.de.rg<T>, ? extends ObservableSource<R>> f10124ad;

        /* renamed from: th  reason: collision with root package name */
        public final th.de.th f10125th;

        public pf(Function<? super th.de.rg<T>, ? extends ObservableSource<R>> function, th.de.th thVar) {
            this.f10124ad = function;
            this.f10125th = thVar;
        }

        /* renamed from: qw */
        public ObservableSource<R> apply(th.de.rg<T> rgVar) throws Exception {
            Object apply = this.f10124ad.apply(rgVar);
            th.de.p039if.ad.qw.rg(apply, "The selector returned a null ObservableSource");
            return th.de.rg.wrap((ObservableSource) apply).observeOn(this.f10125th);
        }
    }

    public static final class ppp<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f10126ad;

        public ppp(Function<? super Object[], ? extends R> function) {
            this.f10126ad = function;
        }

        /* renamed from: qw */
        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return th.de.rg.zipIterable(list, this.f10126ad, false, th.de.rg.bufferSize());
        }
    }

    public static final class qw<T> implements Callable<th.de.p040switch.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final th.de.rg<T> f10127ad;

        /* renamed from: th  reason: collision with root package name */
        public final int f10128th;

        public qw(th.de.rg<T> rgVar, int i2) {
            this.f10127ad = rgVar;
            this.f10128th = i2;
        }

        /* renamed from: qw */
        public th.de.p040switch.qw<T> call() {
            return this.f10127ad.replay(this.f10128th);
        }
    }

    public static final class rg<T, R, U> implements Function<T, ObservableSource<R>> {

        /* renamed from: ad  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends R> f10129ad;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f10130th;

        public rg(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.f10129ad = biFunction;
            this.f10130th = function;
        }

        /* renamed from: qw */
        public ObservableSource<R> apply(T t) throws Exception {
            Object apply = this.f10130th.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null ObservableSource");
            return new y((ObservableSource) apply, new fe(this.f10129ad, t));
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableInternalHelper$switch  reason: invalid class name */
    public static final class Cswitch<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: ad  reason: collision with root package name */
        public final Consumer<Emitter<T>> f10131ad;

        public Cswitch(Consumer<Emitter<T>> consumer) {
            this.f10131ad = consumer;
        }

        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            qw(obj, (Emitter) obj2);
            return obj;
        }

        public S qw(S s, Emitter<T> emitter) throws Exception {
            this.f10131ad.accept(emitter);
            return s;
        }
    }

    public static final class th<T, U> implements Function<T, ObservableSource<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<U>> f10132ad;

        public th(Function<? super T, ? extends ObservableSource<U>> function) {
            this.f10132ad = function;
        }

        /* renamed from: qw */
        public ObservableSource<T> apply(T t) throws Exception {
            Object apply = this.f10132ad.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The itemDelay returned a null ObservableSource");
            return new q0((ObservableSource) apply, 1).map(Functions.m1138if(t)).defaultIfEmpty(t);
        }
    }

    public static final class uk<T> implements Consumer<Throwable> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<T> f10133ad;

        public uk(Observer<T> observer) {
            this.f10133ad = observer;
        }

        /* renamed from: qw */
        public void accept(Throwable th2) throws Exception {
            this.f10133ad.onError(th2);
        }
    }

    public static final class when<T> implements Callable<th.de.p040switch.qw<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final th.de.rg<T> f10134ad;

        /* renamed from: th  reason: collision with root package name */
        public final long f10135th;

        /* renamed from: uk  reason: collision with root package name */
        public final th.de.th f10136uk;

        /* renamed from: yj  reason: collision with root package name */
        public final TimeUnit f10137yj;

        public when(th.de.rg<T> rgVar, long j, TimeUnit timeUnit, th.de.th thVar) {
            this.f10134ad = rgVar;
            this.f10135th = j;
            this.f10137yj = timeUnit;
            this.f10136uk = thVar;
        }

        /* renamed from: qw */
        public th.de.p040switch.qw<T> call() {
            return this.f10134ad.replay(this.f10135th, this.f10137yj, this.f10136uk);
        }
    }

    public static final class yj<T> implements Action {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<T> f10138ad;

        public yj(Observer<T> observer) {
            this.f10138ad = observer;
        }

        public void run() throws Exception {
            this.f10138ad.onComplete();
        }
    }

    public static <T, U, R> Function<T, ObservableSource<R>> ad(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new rg(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> de(Function<? super T, ? extends ObservableSource<U>> function) {
        return new th(function);
    }

    public static <T> Action fe(Observer<T> observer) {
        return new yj(observer);
    }

    public static <T> Callable<th.de.p040switch.qw<T>> i(th.de.rg<T> rgVar, int i2, long j, TimeUnit timeUnit, th.de.th thVar) {
        return new ad(rgVar, i2, j, timeUnit, thVar);
    }

    /* renamed from: if  reason: not valid java name */
    public static <T, S> BiFunction<S, Emitter<T>, S> m1140if(BiConsumer<S, Emitter<T>> biConsumer) {
        return new Cif(biConsumer);
    }

    public static <T> Callable<th.de.p040switch.qw<T>> o(th.de.rg<T> rgVar, long j, TimeUnit timeUnit, th.de.th thVar) {
        return new when(rgVar, j, timeUnit, thVar);
    }

    public static <T, R> Function<th.de.rg<T>, ObservableSource<R>> pf(Function<? super th.de.rg<T>, ? extends ObservableSource<R>> function, th.de.th thVar) {
        return new pf(function, thVar);
    }

    public static <T, U> Function<T, ObservableSource<U>> qw(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new de(function);
    }

    public static <T> Consumer<Throwable> rg(Observer<T> observer) {
        return new uk(observer);
    }

    /* renamed from: switch  reason: not valid java name */
    public static <T, S> BiFunction<S, Emitter<T>, S> m1141switch(Consumer<Emitter<T>> consumer) {
        return new Cswitch(consumer);
    }

    public static <T> Consumer<T> th(Observer<T> observer) {
        return new i(observer);
    }

    public static <T> Callable<th.de.p040switch.qw<T>> uk(th.de.rg<T> rgVar, int i2) {
        return new qw(rgVar, i2);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> when(Function<? super Object[], ? extends R> function) {
        return new ppp(function);
    }

    public static <T> Callable<th.de.p040switch.qw<T>> yj(th.de.rg<T> rgVar) {
        return new o(rgVar);
    }
}
