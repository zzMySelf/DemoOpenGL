package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true, serializable = true)
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    public static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(ObjectCountHashMap.create());
    public final transient ObjectCountHashMap<E> contents;
    @LazyInit
    public transient ImmutableSet<E> elementSet;
    public final transient int size;

    public final class ElementSet extends IndexedImmutableSet<E> {
        public ElementSet() {
        }

        public boolean contains(@NullableDecl Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        public E get(int i2) {
            return RegularImmutableMultiset.this.contents.getKey(i2);
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return RegularImmutableMultiset.this.contents.size();
        }
    }

    @GwtIncompatible
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final int[] counts;
        public final Object[] elements;

        public SerializedForm(Multiset<?> multiset) {
            int size = multiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i2 = 0;
            for (Multiset.Entry next : multiset.entrySet()) {
                this.elements[i2] = next.getElement();
                this.counts[i2] = next.getCount();
                i2++;
            }
        }

        public Object readResolve() {
            ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(this.elements.length);
            int i2 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i2 >= objArr.length) {
                    return builder.build();
                }
                builder.addCopies(objArr[i2], this.counts[i2]);
                i2++;
            }
        }
    }

    public RegularImmutableMultiset(ObjectCountHashMap<E> objectCountHashMap) {
        this.contents = objectCountHashMap;
        long j = 0;
        for (int i2 = 0; i2 < objectCountHashMap.size(); i2++) {
            j += (long) objectCountHashMap.getValue(i2);
        }
        this.size = Ints.saturatedCast(j);
    }

    public int count(@NullableDecl Object obj) {
        return this.contents.get(obj);
    }

    public Multiset.Entry<E> getEntry(int i2) {
        return this.contents.getEntry(i2);
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }

    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet2 = new ElementSet();
        this.elementSet = elementSet2;
        return elementSet2;
    }
}
