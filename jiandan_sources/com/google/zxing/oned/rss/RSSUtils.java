package com.google.zxing.oned.rss;

public final class RSSUtils {
    public static int combins(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > i3) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        int i6 = 1;
        int i7 = 1;
        while (i2 > i3) {
            i6 *= i2;
            if (i7 <= i4) {
                i6 /= i7;
                i7++;
            }
            i2--;
        }
        while (i7 <= i4) {
            i6 /= i7;
            i7++;
        }
        return i6;
    }

    public static int getRSSvalue(int[] iArr, int i2, boolean z) {
        int[] iArr2 = iArr;
        int i3 = i2;
        int i4 = 0;
        for (int i5 : iArr2) {
            i4 += i5;
        }
        int length = iArr2.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = length - 1;
            if (i6 >= i9) {
                return i7;
            }
            int i10 = 1 << i6;
            i8 |= i10;
            int i11 = 1;
            while (i11 < iArr2[i6]) {
                int i12 = i4 - i11;
                int i13 = length - i6;
                int i14 = i13 - 2;
                int combins = combins(i12 - 1, i14);
                if (z && i8 == 0) {
                    int i15 = i13 - 1;
                    if (i12 - i15 >= i15) {
                        combins -= combins(i12 - i13, i14);
                    }
                }
                if (i13 - 1 > 1) {
                    int i16 = i12 - i14;
                    int i17 = 0;
                    while (i16 > i3) {
                        i17 += combins((i12 - i16) - 1, i13 - 3);
                        i16--;
                        int[] iArr3 = iArr;
                    }
                    combins -= i17 * (i9 - i6);
                } else if (i12 > i3) {
                    combins--;
                }
                i7 += combins;
                i11++;
                i8 &= ~i10;
                iArr2 = iArr;
            }
            i4 -= i11;
            i6++;
            iArr2 = iArr;
        }
    }
}
