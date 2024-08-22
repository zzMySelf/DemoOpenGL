package com.google.common.primitives;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.ShortCompanionObject;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    public enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int compare = Shorts.compare(sArr[i2], sArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    @GwtCompatible
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final short[] array;
        public final int end;
        public final int start;

        public ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        public boolean contains(@NullableDecl Object obj) {
            return (obj instanceof Short) && Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.array[this.start + i2] != shortArrayAsList.array[shortArrayAsList.start + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                i2 = (i2 * 31) + Shorts.hashCode(this.array[i3]);
            }
            return i2;
        }

        public int indexOf(@NullableDecl Object obj) {
            int access$000;
            if (!(obj instanceof Short) || (access$000 = Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@NullableDecl Object obj) {
            int access$100;
            if (!(obj instanceof Short) || (access$100 = Shorts.lastIndexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Short> subList(int i2, int i3) {
            Preconditions.checkPositionIndexes(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i4 = this.start;
            return new ShortArrayAsList(sArr, i2 + i4, i4 + i3);
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
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

        public ShortArrayAsList(short[] sArr, int i2, int i3) {
            this.array = sArr;
            this.start = i2;
            this.end = i3;
        }

        public Short get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            return Short.valueOf(this.array[this.start + i2]);
        }

        public Short set(int i2, Short sh) {
            Preconditions.checkElementIndex(i2, size());
            short[] sArr = this.array;
            int i3 = this.start;
            short s = sArr[i3 + i2];
            sArr[i3 + i2] = ((Short) Preconditions.checkNotNull(sh)).shortValue();
            return Short.valueOf(s);
        }
    }

    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        public static final ShortConverter INSTANCE = new ShortConverter();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        public String doBackward(Short sh) {
            return sh.toString();
        }

        public Short doForward(String str) {
            return Short.decode(str);
        }
    }

    public static List<Short> asList(short... sArr) {
        if (sArr.length == 0) {
            return Collections.emptyList();
        }
        return new ShortArrayAsList(sArr);
    }

    public static short checkedCast(long j) {
        short s = (short) ((int) j);
        Preconditions.checkArgument(((long) s) == j, "Out of range: %s", j);
        return s;
    }

    public static int compare(short s, short s2) {
        return s - s2;
    }

    public static short[] concat(short[]... sArr) {
        int i2 = 0;
        for (short[] length : sArr) {
            i2 += length.length;
        }
        short[] sArr2 = new short[i2];
        int i3 = 0;
        for (short[] sArr3 : sArr) {
            System.arraycopy(sArr3, 0, sArr2, i3, sArr3.length);
            i3 += sArr3.length;
        }
        return sArr2;
    }

    @Beta
    public static short constrainToRange(short s, short s2, short s3) {
        Preconditions.checkArgument(s2 <= s3, "min (%s) must be less than or equal to max (%s)", (int) s2, (int) s3);
        if (s < s2) {
            return s2;
        }
        return s < s3 ? s : s3;
    }

    public static boolean contains(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static short[] ensureCapacity(short[] sArr, int i2, int i3) {
        boolean z = true;
        Preconditions.checkArgument(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i3);
        return sArr.length < i2 ? Arrays.copyOf(sArr, i2 + i3) : sArr;
    }

    @GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static short fromBytes(byte b, byte b2) {
        return (short) ((b << 8) | (b2 & 255));
    }

    public static int hashCode(short s) {
        return s;
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0, sArr.length);
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append(sArr[0]);
        for (int i2 = 1; i2 < sArr.length; i2++) {
            sb.append(str);
            sb.append(sArr[i2]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, 0, sArr.length);
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static short max(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s = sArr[0];
        for (int i2 = 1; i2 < sArr.length; i2++) {
            if (sArr[i2] > s) {
                s = sArr[i2];
            }
        }
        return s;
    }

    public static short min(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s = sArr[0];
        for (int i2 = 1; i2 < sArr.length; i2++) {
            if (sArr[i2] < s) {
                s = sArr[i2];
            }
        }
        return s;
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static short saturatedCast(long j) {
        return j > 32767 ? ShortCompanionObject.MAX_VALUE : j < -32768 ? ShortCompanionObject.MIN_VALUE : (short) ((int) j);
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i2 = 0; i2 < length; i2++) {
            sArr[i2] = ((Number) Preconditions.checkNotNull(array[i2])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(short s) {
        return new byte[]{(byte) (s >> 8), (byte) s};
    }

    public static int indexOf(short[] sArr, short s, int i2, int i3) {
        while (i2 < i3) {
            if (sArr[i2] == s) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (sArr[i4] == s) {
                return i4;
            }
        }
        return -1;
    }

    public static int indexOf(short[] sArr, short[] sArr2) {
        Preconditions.checkNotNull(sArr, "array");
        Preconditions.checkNotNull(sArr2, AnimatedVectorDrawableCompat.TARGET);
        if (sArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (sArr.length - sArr2.length) + 1) {
            int i3 = 0;
            while (i3 < sArr2.length) {
                if (sArr[i2 + i3] != sArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static void reverse(short[] sArr, int i2, int i3) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i2, i3, sArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            short s = sArr[i2];
            sArr[i2] = sArr[i4];
            sArr[i4] = s;
            i2++;
        }
    }

    public static void sortDescending(short[] sArr, int i2, int i3) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i2, i3, sArr.length);
        Arrays.sort(sArr, i2, i3);
        reverse(sArr, i2, i3);
    }
}
