package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    public final float[] tempEndValues = new float[9];
    public final Matrix tempMatrix = new Matrix();
    public final float[] tempStartValues = new float[9];

    @NonNull
    public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.tempEndValues;
            float f2 = fArr[i2];
            float[] fArr2 = this.tempStartValues;
            fArr[i2] = fArr2[i2] + ((f2 - fArr2[i2]) * f);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
