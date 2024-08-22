package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@GwtIncompatible
@Beta
public final class Quantiles {

    public static final class Scale {
        public final int scale;

        public ScaleAndIndex index(int i2) {
            return new ScaleAndIndex(this.scale, i2);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }

        public Scale(int i2) {
            Preconditions.checkArgument(i2 > 0, "Quantile scale must be positive");
            this.scale = i2;
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }
    }

    public static final class ScaleAndIndex {
        public final int index;
        public final int scale;

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.index) * ((long) (dArr.length - 1));
            int divide = (int) LongMath.divide(length, (long) this.scale, RoundingMode.DOWN);
            int i2 = (int) (length - (((long) divide) * ((long) this.scale)));
            Quantiles.selectInPlace(divide, dArr, 0, dArr.length - 1);
            if (i2 == 0) {
                return dArr[divide];
            }
            int i3 = divide + 1;
            Quantiles.selectInPlace(i3, dArr, i3, dArr.length - 1);
            return Quantiles.interpolate(dArr[divide], dArr[i3], (double) i2, (double) this.scale);
        }

        public ScaleAndIndex(int i2, int i3) {
            Quantiles.checkIndex(i3, i2);
            this.scale = i2;
            this.index = i3;
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    public static final class ScaleAndIndexes {
        public final int[] indexes;
        public final int scale;

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            double[] dArr2 = dArr;
            int i2 = 0;
            int i3 = 1;
            Preconditions.checkArgument(dArr2.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                HashMap hashMap = new HashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i2 < length) {
                    hashMap.put(Integer.valueOf(iArr[i2]), Double.valueOf(Double.NaN));
                    i2++;
                }
                return Collections.unmodifiableMap(hashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[(iArr2.length * 2)];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr6 = this.indexes;
                if (i4 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i4]) * ((long) (dArr2.length - i3));
                int divide = (int) LongMath.divide(length2, (long) this.scale, RoundingMode.DOWN);
                int i6 = i4;
                int i7 = (int) (length2 - (((long) divide) * ((long) this.scale)));
                iArr3[i6] = divide;
                iArr4[i6] = i7;
                iArr5[i5] = divide;
                i5++;
                if (i7 != 0) {
                    iArr5[i5] = divide + 1;
                    i5++;
                }
                i4 = i6 + 1;
                i3 = 1;
            }
            Arrays.sort(iArr5, 0, i5);
            Quantiles.selectAllInPlace(iArr5, 0, i5 - 1, dArr, 0, dArr2.length - 1);
            HashMap hashMap2 = new HashMap();
            while (true) {
                int[] iArr7 = this.indexes;
                if (i2 >= iArr7.length) {
                    return Collections.unmodifiableMap(hashMap2);
                }
                int i8 = iArr3[i2];
                int i9 = iArr4[i2];
                if (i9 == 0) {
                    hashMap2.put(Integer.valueOf(iArr7[i2]), Double.valueOf(dArr2[i8]));
                } else {
                    hashMap2.put(Integer.valueOf(iArr7[i2]), Double.valueOf(Quantiles.interpolate(dArr2[i8], dArr2[i8 + 1], (double) i9, (double) this.scale)));
                }
                i2++;
            }
        }

        public ScaleAndIndexes(int i2, int[] iArr) {
            for (int access$300 : iArr) {
                Quantiles.checkIndex(access$300, i2);
            }
            this.scale = i2;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    public static void checkIndex(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i3);
        }
    }

    public static int chooseNextSelection(int[] iArr, int i2, int i3, int i4, int i5) {
        if (i2 == i3) {
            return i2;
        }
        int i6 = i4 + i5;
        int i7 = i6 >>> 1;
        while (i3 > i2 + 1) {
            int i8 = (i2 + i3) >>> 1;
            if (iArr[i8] > i7) {
                i3 = i8;
            } else if (iArr[i8] >= i7) {
                return i8;
            } else {
                i2 = i8;
            }
        }
        return (i6 - iArr[i2]) - iArr[i3] > 0 ? i3 : i2;
    }

    public static boolean containsNaN(double... dArr) {
        for (double isNaN : dArr) {
            if (Double.isNaN(isNaN)) {
                return true;
            }
        }
        return false;
    }

    public static double interpolate(double d, double d2, double d3, double d4) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d2 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d + (((d2 - d) * d3) / d4);
    }

    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = (double) iArr[i2];
        }
        return dArr;
    }

    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = (double) jArr[i2];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    public static void movePivotToStartOfSlice(double[] dArr, int i2, int i3) {
        boolean z = true;
        int i4 = (i2 + i3) >>> 1;
        boolean z2 = dArr[i3] < dArr[i4];
        boolean z3 = dArr[i4] < dArr[i2];
        if (dArr[i3] >= dArr[i2]) {
            z = false;
        }
        if (z2 == z3) {
            swap(dArr, i4, i2);
        } else if (z2 != z) {
            swap(dArr, i2, i3);
        }
    }

    public static int partition(double[] dArr, int i2, int i3) {
        movePivotToStartOfSlice(dArr, i2, i3);
        double d = dArr[i2];
        int i4 = i3;
        while (i3 > i2) {
            if (dArr[i3] > d) {
                swap(dArr, i4, i3);
                i4--;
            }
            i3--;
        }
        swap(dArr, i2, i4);
        return i4;
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i2) {
        return new Scale(i2);
    }

    public static void selectAllInPlace(int[] iArr, int i2, int i3, double[] dArr, int i4, int i5) {
        int chooseNextSelection = chooseNextSelection(iArr, i2, i3, i4, i5);
        int i6 = iArr[chooseNextSelection];
        selectInPlace(i6, dArr, i4, i5);
        int i7 = chooseNextSelection - 1;
        while (i7 >= i2 && iArr[i7] == i6) {
            i7--;
        }
        if (i7 >= i2) {
            selectAllInPlace(iArr, i2, i7, dArr, i4, i6 - 1);
        }
        int i8 = chooseNextSelection + 1;
        while (i8 <= i3 && iArr[i8] == i6) {
            i8++;
        }
        if (i8 <= i3) {
            selectAllInPlace(iArr, i8, i3, dArr, i6 + 1, i5);
        }
    }

    public static void selectInPlace(int i2, double[] dArr, int i3, int i4) {
        if (i2 == i3) {
            int i5 = i3;
            for (int i6 = i3 + 1; i6 <= i4; i6++) {
                if (dArr[i5] > dArr[i6]) {
                    i5 = i6;
                }
            }
            if (i5 != i3) {
                swap(dArr, i5, i3);
                return;
            }
            return;
        }
        while (i4 > i3) {
            int partition = partition(dArr, i3, i4);
            if (partition >= i2) {
                i4 = partition - 1;
            }
            if (partition <= i2) {
                i3 = partition + 1;
            }
        }
    }

    public static void swap(double[] dArr, int i2, int i3) {
        double d = dArr[i2];
        dArr[i2] = dArr[i3];
        dArr[i3] = d;
    }
}
