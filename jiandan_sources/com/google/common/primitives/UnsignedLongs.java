package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@Beta
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                if (jArr[i2] != jArr2[i2]) {
                    return UnsignedLongs.compare(jArr[i2], jArr2[i2]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    public static final class ParseOverflowDetection {
        public static final int[] maxSafeDigits = new int[37];
        public static final long[] maxValueDivs = new long[37];
        public static final int[] maxValueMods = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i2 = 2; i2 <= 36; i2++) {
                long j = (long) i2;
                maxValueDivs[i2] = UnsignedLongs.divide(-1, j);
                maxValueMods[i2] = (int) UnsignedLongs.remainder(-1, j);
                maxSafeDigits[i2] = bigInteger.toString(i2).length() - 1;
            }
        }

        public static boolean overflowInParse(long j, int i2, int i3) {
            if (j < 0) {
                return true;
            }
            long[] jArr = maxValueDivs;
            if (j < jArr[i3]) {
                return false;
            }
            if (j <= jArr[i3] && i2 <= maxValueMods[i3]) {
                return false;
            }
            return true;
        }
    }

    public static int compare(long j, long j2) {
        return Longs.compare(flip(j), flip(j2));
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static long divide(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? 0 : 1;
        }
        if (j >= 0) {
            return j / j2;
        }
        int i2 = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (compare(j - (j3 * j2), j2) < 0) {
            i2 = 0;
        }
        return j3 + ((long) i2);
    }

    public static long flip(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i2 = 1; i2 < jArr.length; i2++) {
            sb.append(str);
            sb.append(toString(jArr[i2]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long flip2 = flip(jArr[i2]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long flip2 = flip(jArr[i2]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (compare(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j) {
        return toString(j, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i2) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i2 < 2 || i2 > 36) {
            throw new NumberFormatException("illegal radix: " + i2);
        } else {
            int i3 = ParseOverflowDetection.maxSafeDigits[i2] - 1;
            long j = 0;
            int i4 = 0;
            while (i4 < str.length()) {
                int digit = Character.digit(str.charAt(i4), i2);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i4 <= i3 || !ParseOverflowDetection.overflowInParse(j, digit, i2)) {
                    j = (j * ((long) i2)) + ((long) digit);
                    i4++;
                } else {
                    throw new NumberFormatException("Too large for unsigned long: " + str);
                }
            }
            return j;
        }
    }

    public static String toString(long j, int i2) {
        long j2;
        Preconditions.checkArgument(i2 >= 2 && i2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i2);
        int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i3 == 0) {
            return "0";
        }
        if (i3 > 0) {
            return Long.toString(j, i2);
        }
        int i4 = 64;
        char[] cArr = new char[64];
        int i5 = i2 - 1;
        if ((i2 & i5) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i2);
            do {
                i4--;
                cArr[i4] = Character.forDigit(((int) j) & i5, i2);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i2 & 1) == 0) {
                j2 = (j >>> 1) / ((long) (i2 >>> 1));
            } else {
                j2 = divide(j, (long) i2);
            }
            long j3 = (long) i2;
            cArr[63] = Character.forDigit((int) (j - (j2 * j3)), i2);
            i4 = 63;
            while (j2 > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (j2 % j3), i2);
                j2 /= j3;
            }
        }
        return new String(cArr, i4, 64 - i4);
    }

    public static void sort(long[] jArr, int i2, int i3) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i2, i3, jArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            jArr[i4] = flip(jArr[i4]);
        }
        Arrays.sort(jArr, i2, i3);
        while (i2 < i3) {
            jArr[i2] = flip(jArr[i2]);
            i2++;
        }
    }

    public static void sortDescending(long[] jArr, int i2, int i3) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i2, i3, jArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            jArr[i4] = Long.MAX_VALUE ^ jArr[i4];
        }
        Arrays.sort(jArr, i2, i3);
        while (i2 < i3) {
            jArr[i2] = jArr[i2] ^ Long.MAX_VALUE;
            i2++;
        }
    }
}
