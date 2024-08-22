package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    public static final long serialVersionUID = 0;
    public transient int[] counts;
    public transient int distinctElements;
    public transient E[] enumConstants;
    public transient long size;
    public transient Class<E> type;

    public abstract class Itr<T> implements Iterator<T> {
        public int index = 0;
        public int toRemove = -1;

        public Itr() {
        }

        public boolean hasNext() {
            while (this.index < EnumMultiset.this.enumConstants.length) {
                int[] access$100 = EnumMultiset.this.counts;
                int i2 = this.index;
                if (access$100[i2] > 0) {
                    return true;
                }
                this.index = i2 + 1;
            }
            return false;
        }

        public T next() {
            if (hasNext()) {
                T output = output(this.index);
                int i2 = this.index;
                this.toRemove = i2;
                this.index = i2 + 1;
                return output;
            }
            throw new NoSuchElementException();
        }

        public abstract T output(int i2);

        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove >= 0);
            if (EnumMultiset.this.counts[this.toRemove] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset enumMultiset = EnumMultiset.this;
                long unused = enumMultiset.size = enumMultiset.size - ((long) EnumMultiset.this.counts[this.toRemove]);
                EnumMultiset.this.counts[this.toRemove] = 0;
            }
            this.toRemove = -1;
        }
    }

    public EnumMultiset(Class<E> cls) {
        this.type = cls;
        Preconditions.checkArgument(cls.isEnum());
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.enumConstants = eArr;
        this.counts = new int[eArr.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i2 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i2 - 1;
        return i2;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    private boolean isActuallyE(@NullableDecl Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        E e = (Enum) obj;
        int ordinal = e.ordinal();
        E[] eArr = this.enumConstants;
        if (ordinal >= eArr.length || eArr[ordinal] != e) {
            return false;
        }
        return true;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.enumConstants = eArr;
        this.counts = new int[eArr.length];
        Serialization.populateMultiset(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    public void checkIsE(@NullableDecl Object obj) {
        Preconditions.checkNotNull(obj);
        if (!isActuallyE(obj)) {
            throw new ClassCastException("Expected an " + this.type + " but got " + obj);
        }
    }

    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    public int count(@NullableDecl Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    public int distinctElements() {
        return this.distinctElements;
    }

    public Iterator<E> elementIterator() {
        return new EnumMultiset<E>.Itr<E>() {
            public E output(int i2) {
                return EnumMultiset.this.enumConstants[i2];
            }
        };
    }

    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() {
            public Multiset.Entry<E> output(final int i2) {
                return new Multisets.AbstractEntry<E>() {
                    public int getCount() {
                        return EnumMultiset.this.counts[i2];
                    }

                    public E getElement() {
                        return EnumMultiset.this.enumConstants[i2];
                    }
                };
            }
        };
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i2) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum enumR = (Enum) obj;
        CollectPreconditions.checkNonnegative(i2, "occurrences");
        if (i2 == 0) {
            return count(obj);
        }
        int ordinal = enumR.ordinal();
        int[] iArr = this.counts;
        int i3 = iArr[ordinal];
        if (i3 == 0) {
            return 0;
        }
        if (i3 <= i2) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= (long) i3;
        } else {
            iArr[ordinal] = i3 - i2;
            this.size -= (long) i2;
        }
        return i3;
    }

    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(((Enum) it.next()).getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    @CanIgnoreReturnValue
    public int add(E e, int i2) {
        checkIsE(e);
        CollectPreconditions.checkNonnegative(i2, "occurrences");
        if (i2 == 0) {
            return count(e);
        }
        int ordinal = e.ordinal();
        int i3 = this.counts[ordinal];
        long j = (long) i2;
        long j2 = ((long) i3) + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.counts[ordinal] = (int) j2;
        if (i3 == 0) {
            this.distinctElements++;
        }
        this.size += j;
        return i3;
    }

    @CanIgnoreReturnValue
    public int setCount(E e, int i2) {
        checkIsE(e);
        CollectPreconditions.checkNonnegative(i2, "count");
        int ordinal = e.ordinal();
        int[] iArr = this.counts;
        int i3 = iArr[ordinal];
        iArr[ordinal] = i2;
        this.size += (long) (i2 - i3);
        if (i3 == 0 && i2 > 0) {
            this.distinctElements++;
        } else if (i3 > 0 && i2 == 0) {
            this.distinctElements--;
        }
        return i3;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }
}
