package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;

@GwtIncompatible
@Beta
public final class Interners {

    public static class InternerBuilder {
        public final MapMaker mapMaker;
        public boolean strong;

        public <E> Interner<E> build() {
            if (!this.strong) {
                this.mapMaker.weakKeys();
            }
            return new InternerImpl(this.mapMaker);
        }

        public InternerBuilder concurrencyLevel(int i2) {
            this.mapMaker.concurrencyLevel(i2);
            return this;
        }

        public InternerBuilder strong() {
            this.strong = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public InternerBuilder weak() {
            this.strong = false;
            return this;
        }

        public InternerBuilder() {
            this.mapMaker = new MapMaker();
            this.strong = true;
        }
    }

    public static class InternerFunction<E> implements Function<E, E> {
        public final Interner<E> interner;

        public InternerFunction(Interner<E> interner2) {
            this.interner = interner2;
        }

        public E apply(E e) {
            return this.interner.intern(e);
        }

        public boolean equals(Object obj) {
            if (obj instanceof InternerFunction) {
                return this.interner.equals(((InternerFunction) obj).interner);
            }
            return false;
        }

        public int hashCode() {
            return this.interner.hashCode();
        }
    }

    @VisibleForTesting
    public static final class InternerImpl<E> implements Interner<E> {
        @VisibleForTesting
        public final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> map;

        public E intern(E e) {
            E key;
            do {
                MapMakerInternalMap.InternalEntry entry = this.map.getEntry(e);
                if (entry != null && (key = entry.getKey()) != null) {
                    return key;
                }
            } while (this.map.putIfAbsent(e, MapMaker.Dummy.VALUE) != null);
            return e;
        }

        public InternerImpl(MapMaker mapMaker) {
            this.map = MapMakerInternalMap.createWithDummyValues(mapMaker.keyEquivalence(Equivalence.equals()));
        }
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new InternerFunction((Interner) Preconditions.checkNotNull(interner));
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder();
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }
}
