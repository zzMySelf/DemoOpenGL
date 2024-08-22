package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint {
    public final int count;
    public final float estimatedModuleSize;

    public FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.estimatedModuleSize);
        if (abs <= 1.0f || abs <= this.estimatedModuleSize) {
            return true;
        }
        return false;
    }

    public FinderPattern combineEstimate(float f, float f2, float f3) {
        int i2 = this.count;
        int i3 = i2 + 1;
        float x = (((float) i2) * getX()) + f2;
        float f4 = (float) i3;
        return new FinderPattern(x / f4, ((((float) this.count) * getY()) + f) / f4, ((((float) this.count) * this.estimatedModuleSize) + f3) / f4, i3);
    }

    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    public FinderPattern(float f, float f2, float f3, int i2) {
        super(f, f2);
        this.estimatedModuleSize = f3;
        this.count = i2;
    }
}
