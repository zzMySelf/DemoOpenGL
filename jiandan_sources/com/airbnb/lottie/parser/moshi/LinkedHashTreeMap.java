package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Comparator<Comparable> NATURAL_ORDER = new qw();
    public Comparator<? super K> comparator;
    public LinkedHashTreeMap<K, V>.fe entrySet;
    public final yj<K, V> header;
    public LinkedHashTreeMap<K, V>.rg keySet;
    public int modCount;
    public int size;
    public yj<K, V>[] table;
    public int threshold;

    public static final class ad<K, V> {

        /* renamed from: ad  reason: collision with root package name */
        public int f634ad;

        /* renamed from: de  reason: collision with root package name */
        public int f635de;

        /* renamed from: fe  reason: collision with root package name */
        public int f636fe;
        public yj<K, V> qw;

        public void ad(int i2) {
            this.f634ad = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.f636fe = 0;
            this.f635de = 0;
            this.qw = null;
        }

        public yj<K, V> de() {
            yj<K, V> yjVar = this.qw;
            if (yjVar.f643ad == null) {
                return yjVar;
            }
            throw new IllegalStateException();
        }

        public void qw(yj<K, V> yjVar) {
            yjVar.f649yj = null;
            yjVar.f643ad = null;
            yjVar.f647th = null;
            yjVar.f5switch = 1;
            int i2 = this.f634ad;
            if (i2 > 0) {
                int i3 = this.f636fe;
                if ((i3 & 1) == 0) {
                    this.f636fe = i3 + 1;
                    this.f634ad = i2 - 1;
                    this.f635de++;
                }
            }
            yjVar.f643ad = this.qw;
            this.qw = yjVar;
            int i4 = this.f636fe + 1;
            this.f636fe = i4;
            int i5 = this.f634ad;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.f636fe = i4 + 1;
                this.f634ad = i5 - 1;
                this.f635de++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f636fe & i7) == i7) {
                    int i8 = this.f635de;
                    if (i8 == 0) {
                        yj<K, V> yjVar2 = this.qw;
                        yj<K, V> yjVar3 = yjVar2.f643ad;
                        yj<K, V> yjVar4 = yjVar3.f643ad;
                        yjVar3.f643ad = yjVar4.f643ad;
                        this.qw = yjVar3;
                        yjVar3.f647th = yjVar4;
                        yjVar3.f649yj = yjVar2;
                        yjVar3.f5switch = yjVar2.f5switch + 1;
                        yjVar4.f643ad = yjVar3;
                        yjVar2.f643ad = yjVar3;
                    } else if (i8 == 1) {
                        yj<K, V> yjVar5 = this.qw;
                        yj<K, V> yjVar6 = yjVar5.f643ad;
                        this.qw = yjVar6;
                        yjVar6.f649yj = yjVar5;
                        yjVar6.f5switch = yjVar5.f5switch + 1;
                        yjVar5.f643ad = yjVar6;
                        this.f635de = 0;
                    } else if (i8 == 2) {
                        this.f635de = 0;
                    }
                    i6 *= 2;
                } else {
                    return;
                }
            }
        }
    }

    public static class de<K, V> {
        public yj<K, V> qw;

        public void ad(yj<K, V> yjVar) {
            yj<K, V> yjVar2 = null;
            while (yjVar != null) {
                yjVar.f643ad = yjVar2;
                yjVar2 = yjVar;
                yjVar = yjVar.f647th;
            }
            this.qw = yjVar2;
        }

        public yj<K, V> qw() {
            yj<K, V> yjVar = this.qw;
            if (yjVar == null) {
                return null;
            }
            yj<K, V> yjVar2 = yjVar.f643ad;
            yjVar.f643ad = null;
            yj<K, V> yjVar3 = yjVar.f649yj;
            while (true) {
                yj<K, V> yjVar4 = yjVar2;
                yjVar2 = yjVar3;
                yj<K, V> yjVar5 = yjVar4;
                if (yjVar2 != null) {
                    yjVar2.f643ad = yjVar5;
                    yjVar3 = yjVar2.f647th;
                } else {
                    this.qw = yjVar5;
                    return yjVar;
                }
            }
        }
    }

    public final class fe extends AbstractSet<Map.Entry<K, V>> {

        public class qw extends LinkedHashTreeMap<K, V>.th<Map.Entry<K, V>> {
            public qw(fe feVar) {
                super();
            }

            /* renamed from: ad */
            public Map.Entry<K, V> next() {
                return qw();
            }
        }

        public fe() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new qw(this);
        }

        public boolean remove(Object obj) {
            yj findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public class qw implements Comparator<Comparable> {
        /* renamed from: qw */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public final class rg extends AbstractSet<K> {

        public class qw extends LinkedHashTreeMap<K, V>.th<K> {
            public qw(rg rgVar) {
                super();
            }

            public K next() {
                return qw().f645o;
            }
        }

        public rg() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new qw(this);
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public abstract class th<T> implements Iterator<T> {

        /* renamed from: ad  reason: collision with root package name */
        public yj<K, V> f639ad;

        /* renamed from: th  reason: collision with root package name */
        public yj<K, V> f640th = null;

        /* renamed from: yj  reason: collision with root package name */
        public int f642yj;

        public th() {
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            this.f639ad = linkedHashTreeMap.header.f648uk;
            this.f642yj = linkedHashTreeMap.modCount;
        }

        public final boolean hasNext() {
            return this.f639ad != LinkedHashTreeMap.this.header;
        }

        public final yj<K, V> qw() {
            yj<K, V> yjVar = this.f639ad;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (yjVar == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.modCount == this.f642yj) {
                this.f639ad = yjVar.f648uk;
                this.f640th = yjVar;
                return yjVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            yj<K, V> yjVar = this.f640th;
            if (yjVar != null) {
                LinkedHashTreeMap.this.removeInternal(yjVar, true);
                this.f640th = null;
                this.f642yj = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static {
        Class<LinkedHashTreeMap> cls = LinkedHashTreeMap.class;
    }

    public LinkedHashTreeMap() {
        this((Comparator) null);
    }

    private void doubleCapacity() {
        yj<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(yj<K, V> yjVar, boolean z) {
        while (yjVar != null) {
            yj<K, V> yjVar2 = yjVar.f647th;
            yj<K, V> yjVar3 = yjVar.f649yj;
            int i2 = 0;
            int i3 = yjVar2 != null ? yjVar2.f5switch : 0;
            int i4 = yjVar3 != null ? yjVar3.f5switch : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                yj<K, V> yjVar4 = yjVar3.f647th;
                yj<K, V> yjVar5 = yjVar3.f649yj;
                int i6 = yjVar5 != null ? yjVar5.f5switch : 0;
                if (yjVar4 != null) {
                    i2 = yjVar4.f5switch;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    rotateLeft(yjVar);
                } else {
                    rotateRight(yjVar3);
                    rotateLeft(yjVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                yj<K, V> yjVar6 = yjVar2.f647th;
                yj<K, V> yjVar7 = yjVar2.f649yj;
                int i8 = yjVar7 != null ? yjVar7.f5switch : 0;
                if (yjVar6 != null) {
                    i2 = yjVar6.f5switch;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    rotateRight(yjVar);
                } else {
                    rotateLeft(yjVar2);
                    rotateRight(yjVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                yjVar.f5switch = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                yjVar.f5switch = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            yjVar = yjVar.f643ad;
        }
    }

    private void replaceInParent(yj<K, V> yjVar, yj<K, V> yjVar2) {
        yj<K, V> yjVar3 = yjVar.f643ad;
        yjVar.f643ad = null;
        if (yjVar2 != null) {
            yjVar2.f643ad = yjVar3;
        }
        if (yjVar3 == null) {
            int i2 = yjVar.f646pf;
            yj<K, V>[] yjVarArr = this.table;
            yjVarArr[i2 & (yjVarArr.length - 1)] = yjVar2;
        } else if (yjVar3.f647th == yjVar) {
            yjVar3.f647th = yjVar2;
        } else {
            yjVar3.f649yj = yjVar2;
        }
    }

    private void rotateLeft(yj<K, V> yjVar) {
        yj<K, V> yjVar2 = yjVar.f647th;
        yj<K, V> yjVar3 = yjVar.f649yj;
        yj<K, V> yjVar4 = yjVar3.f647th;
        yj<K, V> yjVar5 = yjVar3.f649yj;
        yjVar.f649yj = yjVar4;
        if (yjVar4 != null) {
            yjVar4.f643ad = yjVar;
        }
        replaceInParent(yjVar, yjVar3);
        yjVar3.f647th = yjVar;
        yjVar.f643ad = yjVar3;
        int i2 = 0;
        int max = Math.max(yjVar2 != null ? yjVar2.f5switch : 0, yjVar4 != null ? yjVar4.f5switch : 0) + 1;
        yjVar.f5switch = max;
        if (yjVar5 != null) {
            i2 = yjVar5.f5switch;
        }
        yjVar3.f5switch = Math.max(max, i2) + 1;
    }

    private void rotateRight(yj<K, V> yjVar) {
        yj<K, V> yjVar2 = yjVar.f647th;
        yj<K, V> yjVar3 = yjVar.f649yj;
        yj<K, V> yjVar4 = yjVar2.f647th;
        yj<K, V> yjVar5 = yjVar2.f649yj;
        yjVar.f647th = yjVar5;
        if (yjVar5 != null) {
            yjVar5.f643ad = yjVar;
        }
        replaceInParent(yjVar, yjVar2);
        yjVar2.f649yj = yjVar;
        yjVar.f643ad = yjVar2;
        int i2 = 0;
        int max = Math.max(yjVar3 != null ? yjVar3.f5switch : 0, yjVar5 != null ? yjVar5.f5switch : 0) + 1;
        yjVar.f5switch = max;
        if (yjVar4 != null) {
            i2 = yjVar4.f5switch;
        }
        yjVar2.f5switch = Math.max(max, i2) + 1;
    }

    public static int secondaryHash(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        yj<K, V> yjVar = this.header;
        yj<K, V> yjVar2 = yjVar.f648uk;
        while (yjVar2 != yjVar) {
            yj<K, V> yjVar3 = yjVar2.f648uk;
            yjVar2.f644i = null;
            yjVar2.f648uk = null;
            yjVar2 = yjVar3;
        }
        yjVar.f644i = yjVar;
        yjVar.f648uk = yjVar;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.fe feVar = this.entrySet;
        if (feVar != null) {
            return feVar;
        }
        LinkedHashTreeMap<K, V>.fe feVar2 = new fe();
        this.entrySet = feVar2;
        return feVar2;
    }

    public yj<K, V> find(K k, boolean z) {
        int i2;
        yj<K, V> yjVar;
        yj<K, V> yjVar2;
        int i3;
        Comparator<? super K> comparator2 = this.comparator;
        yj<K, V>[] yjVarArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (yjVarArr.length - 1) & secondaryHash;
        yj<K, V> yjVar3 = yjVarArr[length];
        if (yjVar3 != null) {
            Comparable comparable = comparator2 == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i3 = comparable.compareTo(yjVar3.f645o);
                } else {
                    i3 = comparator2.compare(k, yjVar3.f645o);
                }
                if (i3 == 0) {
                    return yjVar3;
                }
                yj<K, V> yjVar4 = i3 < 0 ? yjVar3.f647th : yjVar3.f649yj;
                if (yjVar4 == null) {
                    yjVar = yjVar3;
                    i2 = i3;
                    break;
                }
                yjVar3 = yjVar4;
            }
        } else {
            yjVar = yjVar3;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        yj<K, V> yjVar5 = this.header;
        if (yjVar != null) {
            yjVar2 = new yj<>(yjVar, k, secondaryHash, yjVar5, yjVar5.f644i);
            if (i2 < 0) {
                yjVar.f647th = yjVar2;
            } else {
                yjVar.f649yj = yjVar2;
            }
            rebalance(yjVar, true);
        } else if (comparator2 != NATURAL_ORDER || (k instanceof Comparable)) {
            yjVar2 = new yj<>(yjVar, k, secondaryHash, yjVar5, yjVar5.f644i);
            yjVarArr[length] = yjVar2;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i4 = this.size;
        this.size = i4 + 1;
        if (i4 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return yjVar2;
    }

    public yj<K, V> findByEntry(Map.Entry<?, ?> entry) {
        yj<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f4if, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    public yj<K, V> findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        yj findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f4if;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.rg rgVar = this.keySet;
        if (rgVar != null) {
            return rgVar;
        }
        LinkedHashTreeMap<K, V>.rg rgVar2 = new rg();
        this.keySet = rgVar2;
        return rgVar2;
    }

    public V put(K k, V v) {
        if (k != null) {
            yj find = find(k, true);
            V v2 = find.f4if;
            find.f4if = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        yj removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f4if;
        }
        return null;
    }

    public void removeInternal(yj<K, V> yjVar, boolean z) {
        int i2;
        if (z) {
            yj<K, V> yjVar2 = yjVar.f644i;
            yjVar2.f648uk = yjVar.f648uk;
            yjVar.f648uk.f644i = yjVar2;
            yjVar.f644i = null;
            yjVar.f648uk = null;
        }
        yj<K, V> yjVar3 = yjVar.f647th;
        yj<K, V> yjVar4 = yjVar.f649yj;
        yj<K, V> yjVar5 = yjVar.f643ad;
        int i3 = 0;
        if (yjVar3 == null || yjVar4 == null) {
            if (yjVar3 != null) {
                replaceInParent(yjVar, yjVar3);
                yjVar.f647th = null;
            } else if (yjVar4 != null) {
                replaceInParent(yjVar, yjVar4);
                yjVar.f649yj = null;
            } else {
                replaceInParent(yjVar, (yj<K, V>) null);
            }
            rebalance(yjVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        yj<K, V> ad2 = yjVar3.f5switch > yjVar4.f5switch ? yjVar3.ad() : yjVar4.qw();
        removeInternal(ad2, false);
        yj<K, V> yjVar6 = yjVar.f647th;
        if (yjVar6 != null) {
            i2 = yjVar6.f5switch;
            ad2.f647th = yjVar6;
            yjVar6.f643ad = ad2;
            yjVar.f647th = null;
        } else {
            i2 = 0;
        }
        yj<K, V> yjVar7 = yjVar.f649yj;
        if (yjVar7 != null) {
            i3 = yjVar7.f5switch;
            ad2.f649yj = yjVar7;
            yjVar7.f643ad = ad2;
            yjVar.f649yj = null;
        }
        ad2.f5switch = Math.max(i2, i3) + 1;
        replaceInParent(yjVar, ad2);
    }

    public yj<K, V> removeInternalByKey(Object obj) {
        yj<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
        this.header = new yj<>();
        yj<K, V>[] yjVarArr = new yj[16];
        this.table = yjVarArr;
        this.threshold = (yjVarArr.length / 2) + (yjVarArr.length / 4);
    }

    public static <K, V> yj<K, V>[] doubleCapacity(yj<K, V>[] yjVarArr) {
        int length = yjVarArr.length;
        yj<K, V>[] yjVarArr2 = new yj[(length * 2)];
        de deVar = new de();
        ad adVar = new ad();
        ad adVar2 = new ad();
        for (int i2 = 0; i2 < length; i2++) {
            yj<K, V> yjVar = yjVarArr[i2];
            if (yjVar != null) {
                deVar.ad(yjVar);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    yj qw2 = deVar.qw();
                    if (qw2 == null) {
                        break;
                    } else if ((qw2.f646pf & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                adVar.ad(i3);
                adVar2.ad(i4);
                deVar.ad(yjVar);
                while (true) {
                    yj qw3 = deVar.qw();
                    if (qw3 == null) {
                        break;
                    } else if ((qw3.f646pf & length) == 0) {
                        adVar.qw(qw3);
                    } else {
                        adVar2.qw(qw3);
                    }
                }
                yj<K, V> yjVar2 = null;
                yjVarArr2[i2] = i3 > 0 ? adVar.de() : null;
                int i5 = i2 + length;
                if (i4 > 0) {
                    yjVar2 = adVar2.de();
                }
                yjVarArr2[i5] = yjVar2;
            }
        }
        return yjVarArr2;
    }

    public static final class yj<K, V> implements Map.Entry<K, V> {

        /* renamed from: ad  reason: collision with root package name */
        public yj<K, V> f643ad;

        /* renamed from: i  reason: collision with root package name */
        public yj<K, V> f644i;

        /* renamed from: if  reason: not valid java name */
        public V f4if;

        /* renamed from: o  reason: collision with root package name */
        public final K f645o;

        /* renamed from: pf  reason: collision with root package name */
        public final int f646pf;

        /* renamed from: switch  reason: not valid java name */
        public int f5switch;

        /* renamed from: th  reason: collision with root package name */
        public yj<K, V> f647th;

        /* renamed from: uk  reason: collision with root package name */
        public yj<K, V> f648uk;

        /* renamed from: yj  reason: collision with root package name */
        public yj<K, V> f649yj;

        public yj() {
            this.f645o = null;
            this.f646pf = -1;
            this.f644i = this;
            this.f648uk = this;
        }

        public yj<K, V> ad() {
            yj<K, V> yjVar = this;
            for (yj<K, V> yjVar2 = this.f649yj; yjVar2 != null; yjVar2 = yjVar2.f649yj) {
                yjVar = yjVar2;
            }
            return yjVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.f645o
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f4if
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.yj.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.f645o;
        }

        public V getValue() {
            return this.f4if;
        }

        public int hashCode() {
            K k = this.f645o;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f4if;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public yj<K, V> qw() {
            yj<K, V> yjVar = this;
            for (yj<K, V> yjVar2 = this.f647th; yjVar2 != null; yjVar2 = yjVar2.f647th) {
                yjVar = yjVar2;
            }
            return yjVar;
        }

        public V setValue(V v) {
            V v2 = this.f4if;
            this.f4if = v;
            return v2;
        }

        public String toString() {
            return this.f645o + "=" + this.f4if;
        }

        public yj(yj<K, V> yjVar, K k, int i2, yj<K, V> yjVar2, yj<K, V> yjVar3) {
            this.f643ad = yjVar;
            this.f645o = k;
            this.f646pf = i2;
            this.f5switch = 1;
            this.f648uk = yjVar2;
            this.f644i = yjVar3;
            yjVar3.f648uk = this;
            yjVar2.f644i = this;
        }
    }
}
