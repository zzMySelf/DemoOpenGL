package kotlinx.coroutines.debug.internal;

import i.qw.v1.qw.rg;
import i.qw.v1.qw.th;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*:\u0003&'(B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u000eR(\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a0\u00198V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", "V", "", "weakRefQueue", "<init>", "(Z)V", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "w", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "clear", "()V", "decrementSize", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "", "", "getEntries", "()Ljava/util/Set;", "entries", "getKeys", "keys", "", "getSize", "()I", "size", "Ljava/lang/ref/ReferenceQueue;", "Ljava/lang/ref/ReferenceQueue;", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core", "Lkotlin/collections/AbstractMutableMap;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* renamed from: th  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6352th = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    @NotNull
    public volatile /* synthetic */ int _size;
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final ReferenceQueue<K> f6353ad;
    @NotNull
    public volatile /* synthetic */ Object core;

    public static final class ad<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* renamed from: ad  reason: collision with root package name */
        public final K f6354ad;

        /* renamed from: th  reason: collision with root package name */
        public final V f6355th;

        public ad(K k, V v) {
            this.f6354ad = k;
            this.f6355th = v;
        }

        public K getKey() {
            return this.f6354ad;
        }

        public V getValue() {
            return this.f6355th;
        }

        public V setValue(V v) {
            i.qw.v1.qw.qw.de();
            throw null;
        }
    }

    public final class de<E> extends AbstractMutableSet<E> {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final Function2<K, V, E> f6356ad;

        public de(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.f6356ad = function2;
        }

        public boolean add(E e) {
            i.qw.v1.qw.qw.de();
            throw null;
        }

        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @NotNull
        public Iterator<E> iterator() {
            return ((qw) ConcurrentWeakMap.this.core).rg(this.f6356ad);
        }
    }

    public final class qw {

        /* renamed from: yj  reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f6358yj = AtomicIntegerFieldUpdater.newUpdater(qw.class, "load");

        /* renamed from: ad  reason: collision with root package name */
        public final int f6359ad;

        /* renamed from: de  reason: collision with root package name */
        public final int f6360de = ((this.qw * 2) / 3);
        @NotNull

        /* renamed from: fe  reason: collision with root package name */
        public /* synthetic */ AtomicReferenceArray f6361fe = new AtomicReferenceArray(this.qw);
        @NotNull
        public volatile /* synthetic */ int load = 0;
        public final int qw;
        @NotNull

        /* renamed from: rg  reason: collision with root package name */
        public /* synthetic */ AtomicReferenceArray f6362rg = new AtomicReferenceArray(this.qw);

        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$qw$qw  reason: collision with other inner class name */
        public final class C0253qw<E> implements Iterator<E>, KMutableIterator {
            @NotNull

            /* renamed from: ad  reason: collision with root package name */
            public final Function2<K, V, E> f6364ad;

            /* renamed from: th  reason: collision with root package name */
            public int f6366th = -1;

            /* renamed from: uk  reason: collision with root package name */
            public V f6367uk;

            /* renamed from: yj  reason: collision with root package name */
            public K f6368yj;

            public C0253qw(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.f6364ad = function2;
                qw();
            }

            @NotNull
            public Void ad() {
                i.qw.v1.qw.qw.de();
                throw null;
            }

            public boolean hasNext() {
                return this.f6366th < qw.this.qw;
            }

            public E next() {
                if (this.f6366th < qw.this.qw) {
                    Function2<K, V, E> function2 = this.f6364ad;
                    K k = this.f6368yj;
                    if (k != null) {
                        V v = this.f6367uk;
                        if (v != null) {
                            E invoke = function2.invoke(k, v);
                            qw();
                            return invoke;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("value");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("key");
                    throw null;
                }
                throw new NoSuchElementException();
            }

            public final void qw() {
                while (true) {
                    int i2 = this.f6366th + 1;
                    this.f6366th = i2;
                    if (i2 < qw.this.qw) {
                        rg rgVar = (rg) qw.this.f6361fe.get(this.f6366th);
                        K k = rgVar == null ? null : rgVar.get();
                        if (k != null) {
                            this.f6368yj = k;
                            V v = qw.this.f6362rg.get(this.f6366th);
                            if (v instanceof th) {
                                v = ((th) v).qw;
                            }
                            if (v != null) {
                                this.f6367uk = v;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            public /* bridge */ /* synthetic */ void remove() {
                ad();
                throw null;
            }
        }

        public qw(int i2) {
            this.qw = i2;
            this.f6359ad = Integer.numberOfLeadingZeros(i2) + 1;
        }

        public static /* synthetic */ Object yj(qw qwVar, Object obj, Object obj2, rg rgVar, int i2, Object obj3) {
            if ((i2 & 4) != 0) {
                rgVar = null;
            }
            return qwVar.th(obj, obj2, rgVar);
        }

        public final void ad(@NotNull rg<?> rgVar) {
            int fe2 = fe(rgVar.qw);
            while (true) {
                rg<?> rgVar2 = (rg) this.f6361fe.get(fe2);
                if (rgVar2 != null) {
                    if (rgVar2 == rgVar) {
                        i(fe2);
                        return;
                    }
                    if (fe2 == 0) {
                        fe2 = this.qw;
                    }
                    fe2--;
                } else {
                    return;
                }
            }
        }

        @Nullable
        public final V de(@NotNull K k) {
            int fe2 = fe(k.hashCode());
            while (true) {
                rg rgVar = (rg) this.f6361fe.get(fe2);
                if (rgVar == null) {
                    return null;
                }
                Object obj = rgVar.get();
                if (Intrinsics.areEqual((Object) k, obj)) {
                    V v = this.f6362rg.get(fe2);
                    return v instanceof th ? ((th) v).qw : v;
                }
                if (obj == null) {
                    i(fe2);
                }
                if (fe2 == 0) {
                    fe2 = this.qw;
                }
                fe2--;
            }
        }

        public final int fe(int i2) {
            return (i2 * MapBuilder.MAGIC) >>> this.f6359ad;
        }

        public final void i(int i2) {
            Object obj;
            do {
                obj = this.f6362rg.get(i2);
                if (obj == null || (obj instanceof th)) {
                    return;
                }
            } while (!this.f6362rg.compareAndSet(i2, obj, (Object) null));
            ConcurrentWeakMap.this.fe();
        }

        @NotNull
        public final <E> Iterator<E> rg(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            return new C0253qw(function2);
        }

        @Nullable
        public final Object th(@NotNull K k, @Nullable V v, @Nullable rg<K> rgVar) {
            Object obj;
            int i2;
            int fe2 = fe(k.hashCode());
            boolean z = false;
            while (true) {
                rg rgVar2 = (rg) this.f6361fe.get(fe2);
                if (rgVar2 != null) {
                    Object obj2 = rgVar2.get();
                    if (!Intrinsics.areEqual((Object) k, obj2)) {
                        if (obj2 == null) {
                            i(fe2);
                        }
                        if (fe2 == 0) {
                            fe2 = this.qw;
                        }
                        fe2--;
                    } else if (z) {
                        f6358yj.decrementAndGet(this);
                    }
                } else if (v == null) {
                    return null;
                } else {
                    if (!z) {
                        do {
                            i2 = this.load;
                            if (i2 >= this.f6360de) {
                                return i.qw.v1.qw.qw.qw;
                            }
                        } while (!f6358yj.compareAndSet(this, i2, i2 + 1));
                        z = true;
                    }
                    if (rgVar == null) {
                        rgVar = new rg<>(k, ConcurrentWeakMap.this.f6353ad);
                    }
                    if (this.f6361fe.compareAndSet(fe2, (Object) null, rgVar)) {
                        break;
                    }
                }
            }
            do {
                obj = this.f6362rg.get(fe2);
                if (obj instanceof th) {
                    return i.qw.v1.qw.qw.qw;
                }
            } while (!this.f6362rg.compareAndSet(fe2, obj, v));
            return obj;
        }

        @NotNull
        public final ConcurrentWeakMap<K, V>.defpackage.qw uk() {
            ConcurrentWeakMap<K, V>.defpackage.qw qwVar;
            Object obj;
            Object obj2;
            loop0:
            while (true) {
                qwVar = new qw(Integer.highestOneBit(RangesKt___RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i2 = this.qw;
                if (i2 <= 0) {
                    break;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    rg rgVar = (rg) this.f6361fe.get(i3);
                    if (rgVar == null) {
                        obj = null;
                    } else {
                        obj = rgVar.get();
                    }
                    if (rgVar != null && obj == null) {
                        i(i3);
                    }
                    while (true) {
                        obj2 = this.f6362rg.get(i3);
                        if (!(obj2 instanceof th)) {
                            if (this.f6362rg.compareAndSet(i3, obj2, i.qw.v1.qw.qw.fe(obj2))) {
                                break;
                            }
                        } else {
                            obj2 = ((th) obj2).qw;
                            break;
                        }
                    }
                    if (!(obj == null || obj2 == null)) {
                        Object th2 = qwVar.th(obj, obj2, rgVar);
                        if (th2 != i.qw.v1.qw.qw.qw) {
                            boolean z = th2 == null;
                            if (_Assertions.ENABLED && !z) {
                                throw new AssertionError("Assertion failed");
                            }
                        }
                    }
                    if (i4 >= i2) {
                        break loop0;
                    }
                    i3 = i4;
                }
            }
            return qwVar;
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentWeakMap(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public void clear() {
        for (Object remove : keySet()) {
            remove(remove);
        }
    }

    public final void de(rg<?> rgVar) {
        ((qw) this.core).ad(rgVar);
    }

    public final void fe() {
        f6352th.decrementAndGet(this);
    }

    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return ((qw) this.core).de(obj);
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new de(ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @NotNull
    public Set<K> getKeys() {
        return new de(ConcurrentWeakMap$keys$1.INSTANCE);
    }

    public int getSize() {
        return this._size;
    }

    @Nullable
    public V put(@NotNull K k, @NotNull V v) {
        V yj2 = qw.yj((qw) this.core, k, v, (rg) null, 4, (Object) null);
        if (yj2 == i.qw.v1.qw.qw.qw) {
            yj2 = rg(k, v);
        }
        if (yj2 == null) {
            f6352th.incrementAndGet(this);
        }
        return yj2;
    }

    @Nullable
    public V remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        V yj2 = qw.yj((qw) this.core, obj, (Object) null, (rg) null, 4, (Object) null);
        if (yj2 == i.qw.v1.qw.qw.qw) {
            yj2 = rg(obj, (Object) null);
        }
        if (yj2 != null) {
            f6352th.decrementAndGet(this);
        }
        return yj2;
    }

    public final synchronized V rg(K k, V v) {
        V yj2;
        ConcurrentWeakMap<K, V>.defpackage.qw qwVar = (qw) this.core;
        while (true) {
            yj2 = qw.yj(qwVar, k, v, (rg) null, 4, (Object) null);
            if (yj2 == i.qw.v1.qw.qw.qw) {
                qwVar = qwVar.uk();
                this.core = qwVar;
            }
        }
        return yj2;
    }

    public final void th() {
        if (this.f6353ad != null) {
            while (true) {
                try {
                    Reference<? extends K> remove = this.f6353ad.remove();
                    if (remove != null) {
                        de((rg) remove);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new qw(16);
        this.f6353ad = z ? new ReferenceQueue<>() : null;
    }
}
