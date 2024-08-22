package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import okhttp3.HttpUrl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
@Immutable
@Beta
public final class ImmutableIntArray implements Serializable {
    public static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    public final int[] array;
    public final int end;
    public final transient int start;

    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        public final ImmutableIntArray parent;

        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int access$100 = this.parent.start;
            for (Object next : list) {
                if (next instanceof Integer) {
                    int i2 = access$100 + 1;
                    if (this.parent.array[access$100] == ((Integer) next).intValue()) {
                        access$100 = i2;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.parent.hashCode();
        }

        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public int size() {
            return this.parent.length();
        }

        public List<Integer> subList(int i2, int i3) {
            return this.parent.subArray(i2, i3).asList();
        }

        public String toString() {
            return this.parent.toString();
        }

        public AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        public Integer get(int i2) {
            return Integer.valueOf(this.parent.get(i2));
        }
    }

    public static Builder builder(int i2) {
        Preconditions.checkArgument(i2 >= 0, "Invalid initialCapacity: %s", i2);
        return new Builder(i2);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i2) {
        return indexOf(i2) >= 0;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length(); i2++) {
            if (get(i2) != immutableIntArray.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i2) {
        Preconditions.checkElementIndex(i2, length());
        return this.array[this.start + i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.start; i3 < this.end; i3++) {
            i2 = (i2 * 31) + Ints.hashCode(this.array[i3]);
        }
        return i2;
    }

    public int indexOf(int i2) {
        for (int i3 = this.start; i3 < this.end; i3++) {
            if (this.array[i3] == i2) {
                return i3 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i2) {
        int i3 = this.end;
        while (true) {
            i3--;
            int i4 = this.start;
            if (i3 < i4) {
                return -1;
            }
            if (this.array[i3] == i2) {
                return i3 - i4;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableIntArray subArray(int i2, int i3) {
        Preconditions.checkPositionIndexes(i2, i3, length());
        if (i2 == i3) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i4 = this.start;
        return new ImmutableIntArray(iArr, i2 + i4, i4 + i3);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i2 = this.start;
        while (true) {
            i2++;
            if (i2 < this.end) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.array[i2]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.toArray(collection));
    }

    public static ImmutableIntArray of(int i2) {
        return new ImmutableIntArray(new int[]{i2});
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        public int[] array;
        public int count = 0;

        public Builder(int i2) {
            this.array = new int[i2];
        }

        private void ensureRoomFor(int i2) {
            int i3 = this.count + i2;
            int[] iArr = this.array;
            if (i3 > iArr.length) {
                int[] iArr2 = new int[expandedCapacity(iArr.length, i3)];
                System.arraycopy(this.array, 0, iArr2, 0, this.count);
                this.array = iArr2;
            }
        }

        public static int expandedCapacity(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                if (i4 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i4;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public Builder add(int i2) {
            ensureRoomFor(1);
            int[] iArr = this.array;
            int i3 = this.count;
            iArr[i3] = i2;
            this.count = i3 + 1;
            return this;
        }

        public Builder addAll(int[] iArr) {
            ensureRoomFor(iArr.length);
            System.arraycopy(iArr, 0, this.array, this.count, iArr.length);
            this.count += iArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray build() {
            return this.count == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.array, 0, this.count);
        }

        public Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Integer>) (Collection) iterable);
            }
            for (Integer intValue : iterable) {
                add(intValue.intValue());
            }
            return this;
        }

        public Builder addAll(Collection<Integer> collection) {
            ensureRoomFor(collection.size());
            for (Integer intValue : collection) {
                int[] iArr = this.array;
                int i2 = this.count;
                this.count = i2 + 1;
                iArr[i2] = intValue.intValue();
            }
            return this;
        }

        public Builder addAll(ImmutableIntArray immutableIntArray) {
            ensureRoomFor(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.array, this.count, immutableIntArray.length());
            this.count += immutableIntArray.length();
            return this;
        }
    }

    public ImmutableIntArray(int[] iArr, int i2, int i3) {
        this.array = iArr;
        this.start = i2;
        this.end = i3;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) (Collection) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableIntArray of(int i2, int i3) {
        return new ImmutableIntArray(new int[]{i2, i3});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i2, i3, i4});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5, int i6, int i7) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6, i7});
    }

    public static ImmutableIntArray of(int i2, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[(iArr.length + 1)];
        iArr2[0] = i2;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
