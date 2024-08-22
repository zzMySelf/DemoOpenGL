package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class Functions {

    /* renamed from: ad  reason: collision with root package name */
    public static final Runnable f9948ad = new ggg();

    /* renamed from: de  reason: collision with root package name */
    public static final Action f9949de = new when();

    /* renamed from: fe  reason: collision with root package name */
    public static final Consumer<Object> f9950fe = new ppp();

    /* renamed from: i  reason: collision with root package name */
    public static final Comparator<Object> f9951i = new aaa();
    public static final Function<Object, Object> qw = new ddd();

    /* renamed from: rg  reason: collision with root package name */
    public static final Consumer<Throwable> f9952rg = new a();

    /* renamed from: th  reason: collision with root package name */
    public static final Predicate<Object> f9953th = new f();

    /* renamed from: uk  reason: collision with root package name */
    public static final Callable<Object> f9954uk = new tt();

    /* renamed from: yj  reason: collision with root package name */
    public static final Predicate<Object> f9955yj = new xxx();

    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class a implements Consumer<Throwable> {
        /* renamed from: qw */
        public void accept(Throwable th2) {
            th.de.ppp.qw.ddd(new OnErrorNotImplementedException(th2));
        }
    }

    public static final class aaa implements Comparator<Object> {
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class ad<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final BiFunction<? super T1, ? super T2, ? extends R> f9956ad;

        public ad(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f9956ad = biFunction;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f9956ad.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class b<T> implements Function<T, th.de.vvv.ad<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final TimeUnit f9957ad;

        /* renamed from: th  reason: collision with root package name */
        public final th.de.th f9958th;

        public b(TimeUnit timeUnit, th.de.th thVar) {
            this.f9957ad = timeUnit;
            this.f9958th = thVar;
        }

        /* renamed from: qw */
        public th.de.vvv.ad<T> apply(T t) throws Exception {
            return new th.de.vvv.ad<>(t, this.f9958th.ad(this.f9957ad), this.f9957ad);
        }
    }

    public static final class c<K, T> implements BiConsumer<Map<K, T>, T> {
        public final Function<? super T, ? extends K> qw;

        public c(Function<? super T, ? extends K> function) {
            this.qw = function;
        }

        /* renamed from: qw */
        public void accept(Map<K, T> map, T t) throws Exception {
            map.put(this.qw.apply(t), t);
        }
    }

    public static final class d<K, V, T> implements BiConsumer<Map<K, V>, T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function<? super T, ? extends K> f9959ad;
        public final Function<? super T, ? extends V> qw;

        public d(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.qw = function;
            this.f9959ad = function2;
        }

        /* renamed from: qw */
        public void accept(Map<K, V> map, T t) throws Exception {
            map.put(this.f9959ad.apply(t), this.qw.apply(t));
        }
    }

    public static final class ddd implements Function<Object, Object> {
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    public static final class de<T1, T2, T3, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function3<T1, T2, T3, R> f9960ad;

        public de(Function3<T1, T2, T3, R> function3) {
            this.f9960ad = function3;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return this.f9960ad.qw(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    public static final class e<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function<? super T, ? extends V> f9961ad;

        /* renamed from: de  reason: collision with root package name */
        public final Function<? super T, ? extends K> f9962de;
        public final Function<? super K, ? extends Collection<? super V>> qw;

        public e(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.qw = function;
            this.f9961ad = function2;
            this.f9962de = function3;
        }

        /* renamed from: qw */
        public void accept(Map<K, Collection<V>> map, T t) throws Exception {
            Object apply = this.f9962de.apply(t);
            Collection collection = map.get(apply);
            if (collection == null) {
                collection = (Collection) this.qw.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f9961ad.apply(t));
        }
    }

    public static final class eee<T> implements Consumer<Throwable> {

        /* renamed from: ad  reason: collision with root package name */
        public final Consumer<? super th.de.fe<T>> f9963ad;

        public eee(Consumer<? super th.de.fe<T>> consumer) {
            this.f9963ad = consumer;
        }

        /* renamed from: qw */
        public void accept(Throwable th2) throws Exception {
            this.f9963ad.accept(th.de.fe.ad(th2));
        }
    }

    public static final class f implements Predicate<Object> {
        public boolean test(Object obj) {
            return true;
        }
    }

    public static final class fe<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function4<T1, T2, T3, T4, R> f9964ad;

        public fe(Function4<T1, T2, T3, T4, R> function4) {
            this.f9964ad = function4;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return this.f9964ad.qw(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    public static final class ggg implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f9965ad;

        public i(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.f9965ad = function9;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return this.f9965ad.qw(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$if  reason: invalid class name */
    public static final class Cif<T, U> implements Function<T, U> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<U> f9966ad;

        public Cif(Class<U> cls) {
            this.f9966ad = cls;
        }

        public U apply(T t) throws Exception {
            return this.f9966ad.cast(t);
        }
    }

    public static final class mmm<T> implements Function<List<T>, List<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final Comparator<? super T> f9967ad;

        public mmm(Comparator<? super T> comparator) {
            this.f9967ad = comparator;
        }

        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            List list = (List) obj;
            qw(list);
            return list;
        }

        public List<T> qw(List<T> list) {
            Collections.sort(list, this.f9967ad);
            return list;
        }
    }

    public static final class nn<T, U> implements Callable<U>, Function<T, U> {

        /* renamed from: ad  reason: collision with root package name */
        public final U f9968ad;

        public nn(U u) {
            this.f9968ad = u;
        }

        public U apply(T t) throws Exception {
            return this.f9968ad;
        }

        public U call() throws Exception {
            return this.f9968ad;
        }
    }

    public static final class o<T> implements Callable<List<T>> {

        /* renamed from: ad  reason: collision with root package name */
        public final int f9969ad;

        public o(int i2) {
            this.f9969ad = i2;
        }

        /* renamed from: qw */
        public List<T> call() throws Exception {
            return new ArrayList(this.f9969ad);
        }
    }

    public static final class pf<T> implements Predicate<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final BooleanSupplier f9970ad;

        public pf(BooleanSupplier booleanSupplier) {
            this.f9970ad = booleanSupplier;
        }

        public boolean test(T t) throws Exception {
            return !this.f9970ad.getAsBoolean();
        }
    }

    public static final class ppp implements Consumer<Object> {
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class qqq<T> implements Action {

        /* renamed from: ad  reason: collision with root package name */
        public final Consumer<? super th.de.fe<T>> f9971ad;

        public qqq(Consumer<? super th.de.fe<T>> consumer) {
            this.f9971ad = consumer;
        }

        public void run() throws Exception {
            this.f9971ad.accept(th.de.fe.qw());
        }
    }

    public static final class qw<T> implements Consumer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Action f9972ad;

        public qw(Action action) {
            this.f9972ad = action;
        }

        public void accept(T t) throws Exception {
            this.f9972ad.run();
        }
    }

    public static final class rg<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function5<T1, T2, T3, T4, T5, R> f9973ad;

        public rg(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.f9973ad = function5;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return this.f9973ad.qw(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    public static final class rrr<T> implements Consumer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Consumer<? super th.de.fe<T>> f9974ad;

        public rrr(Consumer<? super th.de.fe<T>> consumer) {
            this.f9974ad = consumer;
        }

        public void accept(T t) throws Exception {
            this.f9974ad.accept(th.de.fe.de(t));
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$switch  reason: invalid class name */
    public static final class Cswitch<T, U> implements Predicate<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<U> f9975ad;

        public Cswitch(Class<U> cls) {
            this.f9975ad = cls;
        }

        public boolean test(T t) throws Exception {
            return this.f9975ad.isInstance(t);
        }
    }

    public static final class th<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function6<T1, T2, T3, T4, T5, T6, R> f9976ad;

        public th(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.f9976ad = function6;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return this.f9976ad.qw(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    public static final class tt implements Callable<Object> {
        public Object call() {
            return null;
        }
    }

    public static final class uk<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f9977ad;

        public uk(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.f9977ad = function8;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return this.f9977ad.qw(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    public static final class vvv<T> implements Predicate<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final T f9978ad;

        public vvv(T t) {
            this.f9978ad = t;
        }

        public boolean test(T t) throws Exception {
            return th.de.p039if.ad.qw.de(t, this.f9978ad);
        }
    }

    public static final class when implements Action {
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    public static final class xxx implements Predicate<Object> {
        public boolean test(Object obj) {
            return false;
        }
    }

    public static final class yj<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Function7<T1, T2, T3, T4, T5, T6, T7, R> f9979ad;

        public yj(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.f9979ad = function7;
        }

        /* renamed from: qw */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return this.f9979ad.qw(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> a(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        th.de.p039if.ad.qw.rg(function7, "f is null");
        return new yj(function7);
    }

    public static <T1, T2, R> Function<Object[], R> aaa(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        th.de.p039if.ad.qw.rg(biFunction, "f is null");
        return new ad(biFunction);
    }

    public static <T> Predicate<T> ad() {
        return f9955yj;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> b(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        th.de.p039if.ad.qw.rg(function8, "f is null");
        return new uk(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> c(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        th.de.p039if.ad.qw.rg(function9, "f is null");
        return new i(function9);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> d(Function<? super T, ? extends K> function) {
        return new c(function);
    }

    public static <T> Callable<T> ddd() {
        return f9954uk;
    }

    public static <T> Predicate<T> de() {
        return f9953th;
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> e(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new d(function2, function);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> eee(Function4<T1, T2, T3, T4, R> function4) {
        th.de.p039if.ad.qw.rg(function4, "f is null");
        return new fe(function4);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> f(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new e(function3, function2, function);
    }

    public static <T, U> Function<T, U> fe(Class<U> cls) {
        return new Cif(cls);
    }

    public static <T> Action ggg(Consumer<? super th.de.fe<T>> consumer) {
        return new qqq(consumer);
    }

    public static <T> Function<T, T> i() {
        return qw;
    }

    /* renamed from: if  reason: not valid java name */
    public static <T, U> Function<T, U> m1138if(U u) {
        return new nn(u);
    }

    public static <T> Function<T, th.de.vvv.ad<T>> mmm(TimeUnit timeUnit, th.de.th thVar) {
        return new b(timeUnit, thVar);
    }

    public static <T> Predicate<T> nn(BooleanSupplier booleanSupplier) {
        return new pf(booleanSupplier);
    }

    public static <T, U> Predicate<T> o(Class<U> cls) {
        return new Cswitch(cls);
    }

    public static <T> Callable<T> pf(T t) {
        return new nn(t);
    }

    public static <T> Comparator<T> ppp() {
        return f9951i;
    }

    public static <T1, T2, T3, R> Function<Object[], R> qqq(Function3<T1, T2, T3, R> function3) {
        th.de.p039if.ad.qw.rg(function3, "f is null");
        return new de(function3);
    }

    public static <T> Consumer<T> qw(Action action) {
        return new qw(action);
    }

    public static <T> Callable<List<T>> rg(int i2) {
        return new o(i2);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> rrr(Function5<T1, T2, T3, T4, T5, R> function5) {
        th.de.p039if.ad.qw.rg(function5, "f is null");
        return new rg(function5);
    }

    /* renamed from: switch  reason: not valid java name */
    public static <T> Function<List<T>, List<T>> m1139switch(Comparator<? super T> comparator) {
        return new mmm(comparator);
    }

    public static <T> Callable<Set<T>> th() {
        return HashSetCallable.INSTANCE;
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> tt(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        th.de.p039if.ad.qw.rg(function6, "f is null");
        return new th(function6);
    }

    public static <T> Predicate<T> uk(T t) {
        return new vvv(t);
    }

    public static <T> Consumer<Throwable> vvv(Consumer<? super th.de.fe<T>> consumer) {
        return new eee(consumer);
    }

    public static <T> Comparator<T> when() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Consumer<T> xxx(Consumer<? super th.de.fe<T>> consumer) {
        return new rrr(consumer);
    }

    public static <T> Consumer<T> yj() {
        return f9950fe;
    }
}
