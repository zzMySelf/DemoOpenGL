package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {
    public static final float MAX_AVG_VARIANCE = 0.2f;
    public static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    public static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    public final int[] dataCharacterCounters;
    public final int[] decodeFinderCounters = new int[4];
    public final int[] evenCounts;
    public final float[] evenRoundingErrors;
    public final int[] oddCounts;
    public final float[] oddRoundingErrors;

    public AbstractRSSReader() {
        int[] iArr = new int[8];
        this.dataCharacterCounters = iArr;
        this.oddRoundingErrors = new float[4];
        this.evenRoundingErrors = new float[4];
        this.oddCounts = new int[(iArr.length / 2)];
        this.evenCounts = new int[(iArr.length / 2)];
    }

    @Deprecated
    public static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    public static void decrement(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f) {
                f = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    public static void increment(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f) {
                f = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    public static boolean isFinderPattern(int[] iArr) {
        int i2 = iArr[0] + iArr[1];
        float f = ((float) i2) / ((float) ((iArr[2] + i2) + iArr[3]));
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            for (int i5 : iArr) {
                if (i5 > i4) {
                    i4 = i5;
                }
                if (i5 < i3) {
                    i3 = i5;
                }
            }
            if (i4 < i3 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (OneDReader.patternMatchVariance(iArr, iArr2[i2], 0.45f) < 0.2f) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    public final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    public final int[] getEvenCounts() {
        return this.evenCounts;
    }

    public final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    public final int[] getOddCounts() {
        return this.oddCounts;
    }

    public final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }
}
