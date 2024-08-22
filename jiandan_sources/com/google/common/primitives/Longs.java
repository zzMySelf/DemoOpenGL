package com.google.common.primitives;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    public static final class AsciiDigits {
        public static final byte[] asciiDigits;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i2 = 0; i2 <= 9; i2++) {
                bArr[i2 + 48] = (byte) i2;
            }
            for (int i3 = 0; i3 <= 26; i3++) {
                byte b = (byte) (i3 + 10);
                bArr[i3 + 65] = b;
                bArr[i3 + 97] = b;
            }
            asciiDigits = bArr;
        }

        public static int digit(char c) {
            if (c < 128) {
                return asciiDigits[c];
            }
            return -1;
        }
    }

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public String toString() {
            return "Longs.lexicographicalComparator()";
        }

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int compare = Longs.compare(jArr[i2], jArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    @GwtCompatible
    public static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final long[] array;
        public final int end;
        public final int start;

        public LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.array[this.start + i2] != longArrayAsList.array[longArrayAsList.start + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                i2 = (i2 * 31) + Longs.hashCode(this.array[i3]);
            }
            return i2;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Long) || (access$000 = Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Long) || (access$100 = Longs.lastIndexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Long> subList(int i2, int i3) {
            Preconditions.checkPositionIndexes(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i4 = this.start;
            return new LongArrayAsList(jArr, i2 + i4, i4 + i3);
        }

        public long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
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

        public LongArrayAsList(long[] jArr, int i2, int i3) {
            this.array = jArr;
            this.start = i2;
            this.end = i3;
        }

        public Long get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            return Long.valueOf(this.array[this.start + i2]);
        }

        public Long set(int i2, Long l) {
            Preconditions.checkElementIndex(i2, size());
            long[] jArr = this.array;
            int i3 = this.start;
            long j = jArr[i3 + i2];
            jArr[i3 + i2] = ((Long) Preconditions.checkNotNull(l)).longValue();
            return Long.valueOf(j);
        }
    }

    public static final class LongConverter extends Converter<String, Long> implements Serializable {
        public static final LongConverter INSTANCE = new LongConverter();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Longs.stringConverter()";
        }

        public String doBackward(Long l) {
            return l.toString();
        }

        public Long doForward(String str) {
            return Long.decode(str);
        }
    }

    public static List<Long> asList(long... jArr) {
        if (jArr.length == 0) {
            return Collections.emptyList();
        }
        return new LongArrayAsList(jArr);
    }

    public static int compare(long j, long j2) {
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static long[] concat(long[]... jArr) {
        int i2 = 0;
        for (long[] length : jArr) {
            i2 += length.length;
        }
        long[] jArr2 = new long[i2];
        int i3 = 0;
        for (long[] jArr3 : jArr) {
            System.arraycopy(jArr3, 0, jArr2, i3, jArr3.length);
            i3 += jArr3.length;
        }
        return jArr2;
    }

    @Beta
    public static long constrainToRange(long j, long j2, long j3) {
        Preconditions.checkArgument(j2 <= j3, "min (%s) must be less than or equal to max (%s)", j2, j3);
        return Math.min(Math.max(j, j2), j3);
    }

    public static boolean contains(long[] jArr, long j) {
        for (long j2 : jArr) {
            if (j2 == j) {
                return true;
            }
        }
        return false;
    }

    public static long[] ensureCapacity(long[] jArr, int i2, int i3) {
        boolean z = true;
        Preconditions.checkArgument(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i3);
        return jArr.length < i2 ? Arrays.copyOf(jArr, i2 + i3) : jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
    }

    public static int hashCode(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0, jArr.length);
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i2 = 1; i2 < jArr.length; i2++) {
            sb.append(str);
            sb.append(jArr[i2]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, 0, jArr.length);
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            if (jArr[i2] > j) {
                j = jArr[i2];
            }
        }
        return j;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            if (jArr[i2] < j) {
                j = jArr[i2];
            }
        }
        return j;
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    @Beta
    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = ((Number) Preconditions.checkNotNull(array[i2])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j) {
        byte[] bArr = new byte[8];
        for (int i2 = 7; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        return bArr;
    }

    @NullableDecl
    @Beta
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    public static int indexOf(long[] jArr, long j, int i2, int i3) {
        while (i2 < i3) {
            if (jArr[i2] == j) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (jArr[i4] == j) {
                return i4;
            }
        }
        return -1;
    }

    @NullableDecl
    @Beta
    public static Long tryParse(String str, int i2) {
        String str2 = str;
        int i3 = i2;
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i3 < 2 || i3 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i3);
        }
        int i4 = 0;
        if (str2.charAt(0) == '-') {
            i4 = 1;
        }
        if (i4 == str.length()) {
            return null;
        }
        int i5 = i4 + 1;
        int digit = AsciiDigits.digit(str2.charAt(i4));
        if (digit < 0 || digit >= i3) {
            return null;
        }
        long j = (long) (-digit);
        long j2 = (long) i3;
        long j3 = Long.MIN_VALUE / j2;
        while (i5 < str.length()) {
            int i6 = i5 + 1;
            int digit2 = AsciiDigits.digit(str2.charAt(i5));
            if (digit2 < 0 || digit2 >= i3 || j < j3) {
                return null;
            }
            long j4 = j * j2;
            long j5 = (long) digit2;
            if (j4 < j5 - Long.MIN_VALUE) {
                return null;
            }
            j = j4 - j5;
            i5 = i6;
        }
        if (i4 != 0) {
            return Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j);
    }

    public static int indexOf(long[] jArr, long[] jArr2) {
        Preconditions.checkNotNull(jArr, "array");
        Preconditions.checkNotNull(jArr2, AnimatedVectorDrawableCompat.TARGET);
        if (jArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (jArr.length - jArr2.length) + 1) {
            int i3 = 0;
            while (i3 < jArr2.length) {
                if (jArr[i2 + i3] != jArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static void reverse(long[] jArr, int i2, int i3) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i2, i3, jArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            long j = jArr[i2];
            jArr[i2] = jArr[i4];
            jArr[i4] = j;
            i2++;
        }
    }

    public static void sortDescending(long[] jArr, int i2, int i3) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i2, i3, jArr.length);
        Arrays.sort(jArr, i2, i3);
        reverse(jArr, i2, i3);
    }
}
