package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern {
    public final ResultPoint[] resultPoints;
    public final int[] startEnd;
    public final int value;

    public FinderPattern(int i2, int[] iArr, int i3, int i4, int i5) {
        this.value = i2;
        this.startEnd = iArr;
        float f = (float) i5;
        this.resultPoints = new ResultPoint[]{new ResultPoint((float) i3, f), new ResultPoint((float) i4, f)};
    }

    public boolean equals(Object obj) {
        if ((obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value) {
            return true;
        }
        return false;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
