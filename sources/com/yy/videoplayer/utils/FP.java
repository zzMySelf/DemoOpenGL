package com.yy.videoplayer.utils;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class FP {

    public interface BinaryFunc<R, A, B> {
        R apply(A a2, B b2);
    }

    public interface UnaryFunc<R, A> {
        R apply(A a2);
    }

    public static abstract class Pred<A> implements UnaryFunc<Boolean, A> {
        public abstract boolean pred(A a2);

        public Boolean apply(A x) {
            return Boolean.valueOf(pred(x));
        }
    }

    public static abstract class Eq<A> implements BinaryFunc<Boolean, A, A> {
        public abstract boolean eq(A a2, A a3);

        public Boolean apply(A x, A y) {
            return Boolean.valueOf(eq(x, y));
        }
    }

    public static class Tuple<A, B, C> {

        /* renamed from: a  reason: collision with root package name */
        public A f7725a;

        /* renamed from: b  reason: collision with root package name */
        public B f7726b;

        /* renamed from: c  reason: collision with root package name */
        public C f7727c;

        public Tuple(A x, B y, C z) {
            this.f7725a = x;
            this.f7726b = y;
            this.f7727c = z;
        }
    }

    public static <A, B, C> Tuple<A, B, C> makeTuple(A a2, B b2, C c2) {
        return new Tuple<>(a2, b2, c2);
    }

    public static <E> Pred<E> negate(final Pred<E> p) {
        return new Pred<E>() {
            public boolean pred(E x) {
                return !p.pred(x);
            }
        };
    }

    public static int limit(int x, int low, int high) {
        return Math.min(Math.max(low, x), high);
    }

    public static int maximum(int... xs) {
        int m = Integer.MIN_VALUE;
        for (int x : xs) {
            m = Math.max(m, x);
        }
        return m;
    }

    public static <E> E find(Pred<E> p, List<E> xs) {
        if (empty((Collection<?>) xs)) {
            return null;
        }
        for (E x : xs) {
            if (p.pred(x)) {
                return x;
            }
        }
        return null;
    }

    public static <E> E find(final E x, List<E> xs) {
        return find(new Pred<E>() {
            public boolean pred(E y) {
                return y.equals(x);
            }
        }, xs);
    }

    public static <E> int findIndex(Pred<E> p, List<E> xs) {
        int n = length((Collection<?>) xs);
        int i2 = 0;
        while (i2 < n && !p.pred(xs.get(i2))) {
            i2++;
        }
        if (i2 == n) {
            return -1;
        }
        return i2;
    }

    public static <K, V> V lookup(K k, List<Pair<K, V>> xs) {
        if (empty((Collection<?>) xs)) {
            return null;
        }
        for (Pair<K, V> x : xs) {
            if (k == x.first) {
                return x.second;
            }
        }
        return null;
    }

    public static <E> E lookup(int k, SparseArray<E> xs) {
        if (empty((SparseArray<?>) xs)) {
            return null;
        }
        return xs.get(k);
    }

    public static <E> List<E> nubBy(final Eq<E> cmp, List<E> xs) {
        List<E> ys = new ArrayList<>();
        if (!empty((Collection<?>) xs)) {
            for (final E x : xs) {
                if (find(new Pred<E>() {
                    public boolean pred(E y) {
                        return cmp.eq(x, y);
                    }
                }, ys) == null) {
                    ys.add(x);
                }
            }
        }
        return ys;
    }

    public static <E> List<E> nub(List<E> xs) {
        return nubBy(new Eq<E>() {
            public boolean eq(E x, E y) {
                return y.equals(x);
            }
        }, xs);
    }

    public static boolean empty(Collection<?> xs) {
        return xs == null || xs.isEmpty();
    }

    public static <T> boolean empty(T[] xs) {
        return xs == null || xs.length == 0;
    }

    public static boolean empty(SparseArray<?> xs) {
        return xs == null || xs.size() == 0;
    }

    public static boolean empty(SparseIntArray xs) {
        return xs == null || xs.size() == 0;
    }

    public static boolean empty(int[] xs) {
        return xs == null || xs.length == 0;
    }

    public static boolean empty(long[] xs) {
        return xs == null || xs.length == 0;
    }

    public static boolean empty(CharSequence s) {
        return s == null || s.length() == 0;
    }

    public static boolean empty(Map<?, ?> m) {
        return m == null || m.isEmpty();
    }

    public static int size(Collection<?> xs) {
        if (xs == null) {
            return 0;
        }
        return xs.size();
    }

    public static int size(CharSequence s) {
        if (s == null) {
            return 0;
        }
        return s.length();
    }

    public static <T> int size(T[] xs) {
        if (xs == null) {
            return 0;
        }
        return xs.length;
    }

    public static int size(int[] xs) {
        if (xs == null) {
            return 0;
        }
        return xs.length;
    }

    public static int size(Map<?, ?> m) {
        if (m == null) {
            return 0;
        }
        return m.size();
    }

    public static int size(SparseArray<?> xs) {
        if (xs == null) {
            return 0;
        }
        return xs.size();
    }

    public static int size(SparseIntArray xs) {
        if (xs == null) {
            return 0;
        }
        return xs.size();
    }

    public static int length(Collection<?> xs) {
        return size(xs);
    }

    public static int length(CharSequence s) {
        return size(s);
    }

    public static <T> int length(T[] xs) {
        return size(xs);
    }

    public static int length(int[] xs) {
        return size(xs);
    }

    public static int length(Map<?, ?> m) {
        return size(m);
    }

    public static int length(SparseArray<?> xs) {
        return size(xs);
    }

    public static int length(SparseIntArray xs) {
        return size(xs);
    }

    public static <T> boolean elem(T x, T[] xs) {
        return !empty(xs) && Arrays.asList(xs).contains(x);
    }

    public static <T> boolean elem(T x, Collection<T> xs) {
        return !empty((Collection<?>) xs) && xs.contains(x);
    }

    public static <T> void swap(List<T> xs, int i2, int j2) {
        T tmp = xs.get(i2);
        xs.set(i2, xs.get(j2));
        xs.set(j2, tmp);
    }

    public static <T> void swap(T[] xs, int i2, int j2) {
        T tmp = xs[i2];
        xs[i2] = xs[j2];
        xs[j2] = tmp;
    }

    public static <T> void shift(List<T> xs, int from, int to) {
        T tmp = xs.get(from);
        int d2 = from < to ? 1 : -1;
        while (from != to) {
            xs.set(from, xs.get(from + d2));
            from += d2;
        }
        xs.set(to, tmp);
    }

    public static <T> void shift(T[] xs, int from, int to) {
        T tmp = xs[from];
        int d2 = from < to ? 1 : -1;
        while (from != to) {
            xs[from] = xs[from + d2];
            from += d2;
        }
        xs[to] = tmp;
    }

    public static <E> List<E> add(List<E> xs, E x) {
        if (xs == null) {
            xs = new ArrayList<>();
        }
        xs.add(x);
        return xs;
    }

    public static <E> List<E> delBy(Eq<E> cmp, List<E> xs, E x) {
        int n = length((Collection<?>) xs);
        int i2 = 0;
        while (i2 < n && !cmp.eq(xs.get(i2), x)) {
            i2++;
        }
        if (i2 < n) {
            xs.remove(i2);
        }
        return xs;
    }

    public static <E> List<E> del(List<E> xs, E x) {
        return delBy(new Eq<E>() {
            public boolean eq(E x, E y) {
                return FP.eq(x, y);
            }
        }, xs, x);
    }

    public static <E> Pair<List<E>, List<E>> span(Pred<E> p, List<E> xs) {
        return Pair.create(takeWhile(p, xs), dropWhile(p, xs));
    }

    public static <E> List<E> take(int n, List<E> xs) {
        List<E> ys = new ArrayList<>();
        if (empty((Collection<?>) xs) || n <= 0) {
            return ys;
        }
        ys.addAll(xs.subList(0, Math.min(n, length((Collection<?>) xs))));
        return ys;
    }

    public static String take(int n, String s) {
        return s.substring(0, limit(n, 0, length((CharSequence) s)));
    }

    public static <K, V> Map<K, V> take(int n, Map<K, V> xs) {
        Map<K, V> ys = new HashMap<>();
        for (K k : xs.keySet()) {
            int n2 = n - 1;
            if (n > 0) {
                ys.put(k, xs.get(k));
            }
            n = n2;
        }
        return ys;
    }

    public static <E> List<E> takeWhile(Pred<E> p, List<E> xs) {
        int n = length((Collection<?>) xs);
        int i2 = 0;
        while (i2 < n && p.pred(xs.get(i2))) {
            i2++;
        }
        return take(i2, xs);
    }

    public static <E> List<E> drop(int n, List<E> xs) {
        List<E> ys = new ArrayList<>();
        if (xs == null || n > length((Collection<?>) xs)) {
            return ys;
        }
        ys.addAll(xs.subList(Math.max(0, n), length((Collection<?>) xs)));
        return ys;
    }

    public static String drop(int n, String s) {
        if (s == null || n > length((CharSequence) s)) {
            return "";
        }
        return s.substring(Math.max(0, n));
    }

    public static <E> List<E> dropWhile(Pred<E> p, List<E> xs) {
        int n = length((Collection<?>) xs);
        int i2 = 0;
        while (i2 < n && p.pred(xs.get(i2))) {
            i2++;
        }
        return drop(n, xs);
    }

    public static <E> E head(LinkedList<E> xs) {
        if (empty((Collection<?>) xs)) {
            return null;
        }
        return xs.element();
    }

    public static <E> LinkedList<E> tail(LinkedList<E> xs) {
        if (empty((Collection<?>) xs)) {
            return xs;
        }
        LinkedList<E> ys = new LinkedList<>(xs);
        ys.remove();
        return ys;
    }

    public static <E> LinkedList<E> cons(E x, LinkedList<E> xs) {
        LinkedList<E> xs2 = empty((Collection<?>) xs) ? new LinkedList<>() : xs;
        xs2.addFirst(x);
        return xs2;
    }

    public static <E> E first(List<E> xs) {
        if (empty((Collection<?>) xs)) {
            return null;
        }
        return xs.get(0);
    }

    public static <E> E second(List<E> xs) {
        if (size((Collection<?>) xs) < 2) {
            return null;
        }
        return xs.get(1);
    }

    public static <E> E last(List<E> xs) {
        if (empty((Collection<?>) xs)) {
            return null;
        }
        return xs.get(lastIndex(xs));
    }

    public static int lastIndex(List<?> xs) {
        if (empty((Collection<?>) xs)) {
            return -1;
        }
        return xs.size() - 1;
    }

    public static <E> E first(Collection<E> xs) {
        if (empty((Collection<?>) xs)) {
            return null;
        }
        return xs.iterator().next();
    }

    public static <E> List<E> toList(Collection<? extends E> xs) {
        return empty((Collection<?>) xs) ? new ArrayList() : new ArrayList(xs);
    }

    public static <T> List<T> toList(T x) {
        return Collections.singletonList(x);
    }

    public static <T> List<T> toList(T[] xs) {
        List<T> ys = new ArrayList<>();
        if (!empty(xs)) {
            for (T x : xs) {
                ys.add(x);
            }
        }
        return ys;
    }

    public static List<Integer> toList(int[] xs) {
        List<Integer> ys = new ArrayList<>();
        if (!empty(xs)) {
            for (int x : xs) {
                ys.add(Integer.valueOf(x));
            }
        }
        return ys;
    }

    public static List<Long> toList(long[] xs) {
        List<Long> ys = new ArrayList<>();
        if (!empty(xs)) {
            for (long x : xs) {
                ys.add(Long.valueOf(x));
            }
        }
        return ys;
    }

    public static <E> List<Pair<Integer, E>> toList(SparseArray<E> xs) {
        List<Pair<Integer, E>> ys = new ArrayList<>();
        if (!empty((SparseArray<?>) xs)) {
            for (int i2 = 0; i2 < xs.size(); i2++) {
                ys.add(Pair.create(Integer.valueOf(xs.keyAt(i2)), xs.valueAt(i2)));
            }
        }
        return ys;
    }

    public static List<Pair<Integer, Integer>> toList(SparseIntArray xs) {
        List<Pair<Integer, Integer>> ys = new ArrayList<>();
        if (!empty(xs)) {
            for (int i2 = 0; i2 < xs.size(); i2++) {
                ys.add(Pair.create(Integer.valueOf(xs.keyAt(i2)), Integer.valueOf(xs.valueAt(i2))));
            }
        }
        return ys;
    }

    public static int[] toArray(List<Integer> xs) {
        int n = length((Collection<?>) xs);
        int[] ys = new int[n];
        for (int i2 = 0; i2 < n; i2++) {
            ys[i2] = xs.get(i2).intValue();
        }
        return ys;
    }

    public static <E> List<E> ref(List<E> xs) {
        return xs == null ? new ArrayList() : xs;
    }

    public static <E> E[] ref(E[] xs) {
        return xs == null ? (Object[]) new Object[0] : xs;
    }

    public static int[] ref(int[] xs) {
        return xs == null ? new int[0] : xs;
    }

    public static String ref(String s) {
        return s == null ? "" : s;
    }

    public static <A, B> List<Pair<A, B>> zip(List<A> as, List<B> bs) {
        List<Pair<A, B>> xs = new ArrayList<>();
        if (!empty((Collection<?>) as) && !empty((Collection<?>) bs)) {
            Iterator<A> a2 = as.iterator();
            Iterator<B> b2 = bs.iterator();
            while (a2.hasNext() && b2.hasNext()) {
                xs.add(Pair.create(a2.next(), b2.next()));
            }
        }
        return xs;
    }

    public static boolean eq(Object a2, Object b2) {
        if (a2 == null && b2 == null) {
            return true;
        }
        if (a2 == null || !a2.equals(b2)) {
            return false;
        }
        return true;
    }

    public static boolean isPrefixOf(String prefix, String s) {
        if (empty((CharSequence) prefix)) {
            return true;
        }
        if (empty((CharSequence) s) || !s.startsWith(prefix)) {
            return false;
        }
        return true;
    }

    public static <E> boolean isPrefixOf(List<E> prefix, List<E> xs) {
        if (empty((Collection<?>) prefix)) {
            return true;
        }
        if (empty((Collection<?>) xs) || !eq(prefix, take(length((Collection<?>) prefix), xs))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [T[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void convert(T[] r2, java.lang.Object[] r3) {
        /*
            r0 = 0
        L_0x0001:
            int r1 = r3.length
            if (r0 >= r1) goto L_0x0009
            r2[r0] = r3
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0009:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.videoplayer.utils.FP.convert(java.lang.Object[], java.lang.Object[]):void");
    }

    public static <T> List<T> concat(List<T> xs, List<T> ys) {
        List<T> zs = ref(xs);
        zs.addAll(ref(ys));
        return zs;
    }

    public static <T> T[] concat(T[] xs, T[] ys) {
        T[] zs = (Object[]) new Object[(length(xs) + length(ys))];
        int i2 = 0;
        int length = xs.length;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            zs[i2] = xs[i4];
            i4++;
            i2++;
        }
        int length2 = ys.length;
        while (i3 < length2) {
            zs[i2] = ys[i3];
            i3++;
            i2++;
        }
        return zs;
    }

    public static int[] concat(int[] xs, int[] ys) {
        int[] zs = new int[(length(xs) + length(ys))];
        int i2 = 0;
        int length = xs.length;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            zs[i2] = xs[i4];
            i4++;
            i2++;
        }
        int length2 = ys.length;
        while (i3 < length2) {
            zs[i2] = ys[i3];
            i3++;
            i2++;
        }
        return zs;
    }

    public static <T> List<T> unionBy(Eq<T> cmp, List<T> xs, List<T> ys) {
        List<T> ys2 = ref(ys);
        if (empty((Collection<?>) xs)) {
            return ys2;
        }
        for (T y : ys2) {
            boolean e2 = false;
            Iterator<T> it = xs.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (cmp.eq(it.next(), y)) {
                        e2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!e2) {
                xs.add(y);
            }
        }
        return xs;
    }

    public static <T> List<T> union(List<T> xs, List<T> ys) {
        return unionBy(new Eq<T>() {
            public boolean eq(T x, T y) {
                return FP.eq(x, y);
            }
        }, xs, ys);
    }

    public static <T> List<T> diffBy(Eq<T> eq, List<T> xs, List<T> ys) {
        List<T> zs = toList(xs);
        for (T y : ys) {
            zs = delBy(eq, zs, y);
        }
        return zs;
    }

    public static <T> List<T> diff(List<T> xs, List<T> ys) {
        return diffBy(new Eq<T>() {
            public boolean eq(T x, T y) {
                return FP.eq(x, y);
            }
        }, xs, ys);
    }

    public static <A, B> List<B> map(UnaryFunc<B, A> f2, List<A> xs) {
        List<B> ys = new ArrayList<>();
        for (A x : ref(xs)) {
            ys.add(f2.apply(x));
        }
        return ys;
    }

    public static <E> List<E> filter(Pred<E> p, List<E> xs) {
        List<E> ys = new ArrayList<>();
        for (E x : xs) {
            if (p.pred(x)) {
                ys.add(x);
            }
        }
        return ys;
    }

    public static <S, E> S fold(BinaryFunc<S, S, E> f2, S s, Collection<E> xs) {
        if (!empty((Collection<?>) xs)) {
            for (E x : xs) {
                s = f2.apply(s, x);
            }
        }
        return s;
    }

    public static <E> List<E> insert(Comparator<E> cmp, E x, List<E> xs) {
        int pos = Collections.binarySearch(xs, x, cmp);
        xs.add((-(pos < 0 ? (-pos) - 1 : pos)) - 1, x);
        return xs;
    }

    public static <E> List<E> sort(Comparator<E> cmp, List<E> xs) {
        List<E> xs2 = ref(xs);
        try {
            Collections.sort(xs2, cmp);
        } catch (Exception e2) {
            YMFLog.error((Object) null, "[Util    ]", "Failed to sort %s, exception:%s", xs2, e2.toString());
        }
        return xs2;
    }

    public static int sum(Integer[] xs) {
        int n = 0;
        for (Integer intValue : xs) {
            n += intValue.intValue();
        }
        return n;
    }

    public static long sum(Long[] xs) {
        long n = 0;
        for (Long longValue : xs) {
            n += longValue.longValue();
        }
        return n;
    }

    public static int sum(List<Integer> xs) {
        int n = 0;
        for (Integer intValue : xs) {
            n += intValue.intValue();
        }
        return n;
    }

    public static int ord(boolean x) {
        return x;
    }

    public static int ord(Integer x) {
        if (x == null) {
            return 0;
        }
        return x.intValue();
    }

    public static <E> List<E> replicate(int n, E x) {
        List<E> xs = new ArrayList<>();
        while (true) {
            int n2 = n - 1;
            if (n <= 0) {
                return xs;
            }
            xs.add(x);
            n = n2;
        }
    }

    public static <E> List<E> replicate(int n, Callable<E> gen) {
        List<E> xs = new ArrayList<>();
        while (true) {
            int n2 = n - 1;
            if (n <= 0) {
                break;
            }
            try {
                xs.add(gen.call());
                n = n2;
            } catch (Exception e2) {
                YMFLog.error((Object) null, "[Util    ]", "replicate failed, exception:", e2);
            }
        }
        return xs;
    }

    public static class M {
        public static <K, V> List<Pair<K, V>> toList(Map<K, V> m) {
            List<Pair<K, V>> xs = new ArrayList<>();
            if (!FP.empty((Map<?, ?>) m)) {
                for (Map.Entry<K, V> e2 : m.entrySet()) {
                    xs.add(Pair.create(e2.getKey(), e2.getValue()));
                }
            }
            return xs;
        }

        public static <K extends Comparable<K>, V> Map<K, V> fromList(List<Pair<K, V>> xs) {
            Map<K, V> m = new TreeMap<>();
            if (!FP.empty((Collection<?>) xs)) {
                for (Pair<K, V> p : xs) {
                    m.put(p.first, p.second);
                }
            }
            return m;
        }

        public static <V> Map<Integer, V> fromList(SparseArray<V> xs) {
            Map<Integer, V> m = new TreeMap<>();
            if (!FP.empty((SparseArray<?>) xs)) {
                for (int i2 = 0; i2 < xs.size(); i2++) {
                    m.put(Integer.valueOf(xs.keyAt(i2)), xs.valueAt(i2));
                }
            }
            return m;
        }

        public static <V> List<V> values(SparseArray<V> m) {
            List<V> xs = new ArrayList<>();
            int n = FP.size((SparseArray<?>) m);
            for (int i2 = 0; i2 < n; i2++) {
                xs.add(m.valueAt(i2));
            }
            return xs;
        }
    }
}
