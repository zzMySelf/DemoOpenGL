package com.google.android.material.shape;

public class RoundedCornerTreatment extends CornerTreatment {
    private final float radius;

    public RoundedCornerTreatment(float radius2) {
        this.radius = radius2;
    }

    public void getCornerPath(float angle, float interpolation, ShapePath shapePath) {
        shapePath.reset(0.0f, this.radius * interpolation);
        float f2 = this.radius;
        shapePath.addArc(0.0f, 0.0f, f2 * 2.0f * interpolation, f2 * 2.0f * interpolation, angle + 180.0f, 90.0f);
    }
}
