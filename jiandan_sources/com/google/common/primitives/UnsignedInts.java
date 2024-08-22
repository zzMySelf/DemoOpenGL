package com.google.common.primitives;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@Beta
public final class UnsignedInts {
    public static final long INT_MASK = 4294967295L;

    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                if (iArr[i2] != iArr2[i2]) {
                    return UnsignedInts.compare(iArr[i2], iArr2[i2]);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int checkedCast(long j) {
        Preconditions.checkArgument((j >> 32) == 0, "out of range: %s", j);
        return (int) j;
    }

    public static int compare(int i2, int i3) {
        return Ints.compare(flip(i2), flip(i3));
    }

    @CanIgnoreReturnValue
    public static int decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedInt(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static int divide(int i2, int i3) {
        return (int) (toLong(i2) / toLong(i3));
    }

    public static int flip(int i2) {
        return i2 ^ Integer.MIN_VALUE;
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(toString(iArr[0]));
        for (int i2 = 1; i2 < iArr.length; i2++) {
            sb.append(str);
            sb.append(toString(iArr[i2]));
        }
        return sb.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int flip2 = flip(iArr[i2]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int flip2 = flip(iArr[i2]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static int remainder(int i2, int i3) {
        return (int) (toLong(i2) % toLong(i3));
    }

    public static int saturatedCast(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSED_BIT) {
            return -1;
        }
        return (int) j;
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static long toLong(int i2) {
        return ((long) i2) & 4294967295L;
    }

    public static String toString(int i2) {
        return toString(i2, 10);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str, int i2) {
        Preconditions.checkNotNull(str);
        long parseLong = Long.parseLong(str, i2);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i2 + " is not in the range of an unsigned integer");
    }

    public static String toString(int i2, int i3) {
        return Long.toString(((long) i2) & 4294967295L, i3);
    }

    public static void sort(int[] iArr, int i2, int i3) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i2, i3, iArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            iArr[i4] = flip(iArr[i4]);
        }
        Arrays.sort(iArr, i2, i3);
        while (i2 < i3) {
            iArr[i2] = flip(iArr[i2]);
            i2++;
        }
    }

    public static void sortDescending(int[] iArr, int i2, int i3) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i2, i3, iArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            iArr[i4] = Integer.MAX_VALUE ^ iArr[i4];
        }
        Arrays.sort(iArr, i2, i3);
        while (i2 < i3) {
            iArr[i2] = iArr[i2] ^ Integer.MAX_VALUE;
            i2++;
        }
    }
}
