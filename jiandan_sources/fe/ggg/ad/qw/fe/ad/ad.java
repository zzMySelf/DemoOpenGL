package fe.ggg.ad.qw.fe.ad;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull
    public static final Pair<Integer, Float> ad(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 0;
        Pair<Integer, Float> pair = TuplesKt.to(0, Float.valueOf(ArraysKt___ArraysKt.getLastIndex(fArr) >= 0 ? fArr[0] : 0.0f));
        int length = fArr.length;
        Pair<Integer, Float> pair2 = pair;
        int i3 = 0;
        while (i2 < length) {
            float f = fArr[i2];
            int i4 = i3 + 1;
            if (i3 != 0) {
                if (((i3 < 0 || i3 > ArraysKt___ArraysKt.getLastIndex(fArr)) ? 0.0f : fArr[i3]) > pair2.getSecond().floatValue()) {
                    pair2 = TuplesKt.to(Integer.valueOf(i3), Float.valueOf(f));
                }
            }
            i2++;
            i3 = i4;
        }
        return pair2;
    }

    @NotNull
    public static final Pair<Integer, Float> de(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 0;
        Pair<Integer, Float> pair = TuplesKt.to(0, Float.valueOf(ArraysKt___ArraysKt.getLastIndex(fArr) >= 0 ? fArr[0] : 0.0f));
        int length = fArr.length;
        Pair<Integer, Float> pair2 = pair;
        int i3 = 0;
        while (i2 < length) {
            float f = fArr[i2];
            int i4 = i3 + 1;
            if (i3 != 0) {
                if (((i3 < 0 || i3 > ArraysKt___ArraysKt.getLastIndex(fArr)) ? 0.0f : fArr[i3]) < pair2.getSecond().floatValue()) {
                    pair2 = TuplesKt.to(Integer.valueOf(i3), Float.valueOf(f));
                }
            }
            i2++;
            i3 = i4;
        }
        return pair2;
    }

    @NotNull
    public static final float[] fe(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                fArr[i2] = f;
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return fArr;
    }

    public static final float qw(@NotNull float[] fArr) {
        float f;
        int i2;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        int i3 = 0;
        if (length > 0) {
            int i4 = 0;
            i2 = 0;
            f = 0.0f;
            while (true) {
                int i5 = i3 + 1;
                if (fArr[i3] > 0.0f) {
                    i4++;
                } else if (fArr[i3] < 0.0f) {
                    i2++;
                }
                f += fArr[i3];
                if (i5 >= length) {
                    break;
                }
                i3 = i5;
            }
            i3 = i4;
        } else {
            i2 = 0;
            f = 0.0f;
        }
        if (i3 <= 0 || i2 <= 0) {
            return f / ((float) fArr.length);
        }
        return 0.0f;
    }

    @NotNull
    public static final int[] rg(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                iArr[i3] = i2;
                if (i4 >= length) {
                    break;
                }
                i3 = i4;
            }
        }
        return iArr;
    }

    public static /* synthetic */ float[] th(float[] fArr, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = 0.0f;
        }
        fe(fArr, f);
        return fArr;
    }

    @NotNull
    public static final float[] uk(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length - 1;
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                fArr[i2] = fArr[i3];
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        fArr[fArr.length - 1] = f;
        return fArr;
    }

    public static /* synthetic */ int[] yj(int[] iArr, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        rg(iArr, i2);
        return iArr;
    }
}
