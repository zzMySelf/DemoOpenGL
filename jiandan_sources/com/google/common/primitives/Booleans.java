package com.google.common.primitives;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public final class Booleans {

    @GwtCompatible
    public static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final boolean[] array;
        public final int end;
        public final int start;

        public BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.array[this.start + i2] != booleanArrayAsList.array[booleanArrayAsList.start + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                i2 = (i2 * 31) + Booleans.hashCode(this.array[i3]);
            }
            return i2;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Boolean) || (access$000 = Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Boolean) || (access$100 = Booleans.lastIndexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Boolean> subList(int i2, int i3) {
            Preconditions.checkPositionIndexes(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i4 = this.start;
            return new BooleanArrayAsList(zArr, i2 + i4, i4 + i3);
        }

        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.array[this.start] ? "[true" : "[false");
            int i2 = this.start;
            while (true) {
                i2++;
                if (i2 < this.end) {
                    sb.append(this.array[i2] ? ", true" : ", false");
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public BooleanArrayAsList(boolean[] zArr, int i2, int i3) {
            this.array = zArr;
            this.start = i2;
            this.end = i3;
        }

        public Boolean get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            return Boolean.valueOf(this.array[this.start + i2]);
        }

        public Boolean set(int i2, Boolean bool) {
            Preconditions.checkElementIndex(i2, size());
            boolean[] zArr = this.array;
            int i3 = this.start;
            boolean z = zArr[i3 + i2];
            zArr[i3 + i2] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z);
        }
    }

    public enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        public final String toString;
        public final int trueValue;

        /* access modifiers changed from: public */
        BooleanComparator(int i2, String str) {
            this.trueValue = i2;
            this.toString = str;
        }

        public String toString() {
            return this.toString;
        }

        public int compare(Boolean bool, Boolean bool2) {
            int i2 = 0;
            int i3 = bool.booleanValue() ? this.trueValue : 0;
            if (bool2.booleanValue()) {
                i2 = this.trueValue;
            }
            return i2 - i3;
        }
    }

    public enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int compare = Booleans.compare(zArr[i2], zArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr.length - zArr2.length;
        }
    }

    public static List<Boolean> asList(boolean... zArr) {
        if (zArr.length == 0) {
            return Collections.emptyList();
        }
        return new BooleanArrayAsList(zArr);
    }

    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i2 = 0;
        for (boolean[] length : zArr) {
            i2 += length.length;
        }
        boolean[] zArr2 = new boolean[i2];
        int i3 = 0;
        for (boolean[] zArr3 : zArr) {
            System.arraycopy(zArr3, 0, zArr2, i3, zArr3.length);
            i3 += zArr3.length;
        }
        return zArr2;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public static int countTrue(boolean... zArr) {
        int i2 = 0;
        for (boolean z : zArr) {
            if (z) {
                i2++;
            }
        }
        return i2;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i2, int i3) {
        boolean z = true;
        Preconditions.checkArgument(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i3);
        return zArr.length < i2 ? Arrays.copyOf(zArr, i2 + i3) : zArr;
    }

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0, zArr.length);
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i2 = 1; i2 < zArr.length; i2++) {
            sb.append(str);
            sb.append(zArr[i2]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, 0, zArr.length);
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = ((Boolean) Preconditions.checkNotNull(array[i2])).booleanValue();
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    public static int indexOf(boolean[] zArr, boolean z, int i2, int i3) {
        while (i2 < i3) {
            if (zArr[i2] == z) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (zArr[i4] == z) {
                return i4;
            }
        }
        return -1;
    }

    public static int indexOf(boolean[] zArr, boolean[] zArr2) {
        Preconditions.checkNotNull(zArr, "array");
        Preconditions.checkNotNull(zArr2, AnimatedVectorDrawableCompat.TARGET);
        if (zArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (zArr.length - zArr2.length) + 1) {
            int i3 = 0;
            while (i3 < zArr2.length) {
                if (zArr[i2 + i3] != zArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static void reverse(boolean[] zArr, int i2, int i3) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i2, i3, zArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            boolean z = zArr[i2];
            zArr[i2] = zArr[i4];
            zArr[i4] = z;
            i2++;
        }
    }
}
