package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int compare = SignedBytes.compare(bArr[i2], bArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static byte checkedCast(long j) {
        byte b = (byte) ((int) j);
        Preconditions.checkArgument(((long) b) == j, "Out of range: %s", j);
        return b;
    }

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            sb.append(str);
            sb.append(bArr[i2]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i2 = 1; i2 < bArr.length; i2++) {
            if (bArr[i2] > b) {
                b = bArr[i2];
            }
        }
        return b;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i2 = 1; i2 < bArr.length; i2++) {
            if (bArr[i2] < b) {
                b = bArr[i2];
            }
        }
        return b;
    }

    public static byte saturatedCast(long j) {
        if (j > 127) {
            return Byte.MAX_VALUE;
        }
        if (j < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) ((int) j);
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i2, int i3) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i2, i3, bArr.length);
        Arrays.sort(bArr, i2, i3);
        Bytes.reverse(bArr, i2, i3);
    }
}
