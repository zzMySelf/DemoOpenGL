package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@KeepForSdk
@VisibleForTesting
public final class ArrayUtils {
    @KeepForSdk
    public static <T> T[] appendToArray(T[] tArr, T t) {
        T[] tArr2;
        if (tArr == null && t == null) {
            throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
        }
        if (tArr == null) {
            tArr2 = (Object[]) Array.newInstance(t.getClass(), 1);
        } else {
            tArr2 = Arrays.copyOf(tArr, tArr.length + 1);
        }
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    @KeepForSdk
    public static <T> T[] concat(T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i2 = 0;
        for (T[] length : tArr) {
            i2 += length.length;
        }
        T[] copyOf = Arrays.copyOf(tArr[0], i2);
        int length2 = tArr[0].length;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T[] tArr2 = tArr[i3];
            System.arraycopy(tArr2, 0, copyOf, length2, tArr2.length);
            length2 += tArr2.length;
        }
        return copyOf;
    }

    @KeepForSdk
    public static byte[] concatByteArrays(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i2 = 0;
        for (byte[] length : bArr) {
            i2 += length.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i2);
        int length2 = bArr[0].length;
        for (int i3 = 1; i3 < bArr.length; i3++) {
            byte[] bArr2 = bArr[i3];
            System.arraycopy(bArr2, 0, copyOf, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return copyOf;
    }

    @KeepForSdk
    public static <T> boolean contains(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (Objects.equal(tArr[i2], t)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @KeepForSdk
    public static <T> T[] removeAll(T[] tArr, T... tArr2) {
        int i2;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || tArr2.length == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
        if (tArr2.length == 1) {
            i2 = 0;
            for (T t : tArr) {
                if (!Objects.equal(tArr2[0], t)) {
                    tArr3[i2] = t;
                    i2++;
                }
            }
        } else {
            int i3 = 0;
            for (T t2 : tArr) {
                if (!contains(tArr2, t2)) {
                    tArr3[i3] = t2;
                    i3++;
                }
            }
            i2 = i3;
        }
        if (tArr3 == null) {
            return null;
        }
        return i2 != tArr3.length ? Arrays.copyOf(tArr3, i2) : tArr3;
    }

    @KeepForSdk
    public static <T> ArrayList<T> toArrayList(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(r0);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    @KeepForSdk
    public static int[] toPrimitiveArray(Collection<Integer> collection) {
        int i2 = 0;
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        for (Integer intValue : collection) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        return iArr;
    }

    @KeepForSdk
    public static Integer[] toWrapperArray(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    @KeepForSdk
    public static <T> void writeArray(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i2].toString());
        }
    }

    @KeepForSdk
    public static void writeStringArray(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i2]);
            sb.append("\"");
        }
    }

    @KeepForSdk
    public static boolean contains(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i2]));
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i2]));
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i2]));
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i2]));
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i2]));
        }
    }
}
