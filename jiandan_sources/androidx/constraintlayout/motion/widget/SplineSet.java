package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {
    public static final String TAG = "SplineSet";
    public int count;
    public CurveFit mCurveFit;
    public int[] mTimePoints = new int[10];
    public String mType;
    public float[] mValues = new float[10];

    public static class AlphaSet extends SplineSet {
        public void setProperty(View view, float f) {
            view.setAlpha(get(f));
        }
    }

    public static class CustomSet extends SplineSet {
        public String mAttributeName;
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i2, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(View view, float f) {
            this.mCurveFit.getPos((double) f, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }

        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[noOfInterpValues];
            int[] iArr = new int[2];
            iArr[1] = noOfInterpValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i3 = 0; i3 < size; i3++) {
                dArr[i3] = ((double) this.mConstraintAttributeList.keyAt(i3)) * 0.01d;
                this.mConstraintAttributeList.valueAt(i3).getValuesToInterpolate(this.mTempValues);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i2, constraintAttribute);
        }
    }

    public static class ElevationSet extends SplineSet {
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f));
            }
        }
    }

    public static class PathRotate extends SplineSet {
        public void setPathRotate(View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        public void setProperty(View view, float f) {
        }
    }

    public static class PivotXset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setPivotX(get(f));
        }
    }

    public static class PivotYset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setPivotY(get(f));
        }
    }

    public static class ProgressSet extends SplineSet {
        public boolean mNoMethod = false;

        public void setProperty(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f));
            } else if (!this.mNoMethod) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
        }
    }

    public static class RotationSet extends SplineSet {
        public void setProperty(View view, float f) {
            view.setRotation(get(f));
        }
    }

    public static class RotationXset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setRotationX(get(f));
        }
    }

    public static class RotationYset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setRotationY(get(f));
        }
    }

    public static class ScaleXset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setScaleX(get(f));
        }
    }

    public static class ScaleYset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setScaleY(get(f));
        }
    }

    public static class Sort {
        public static void doubleQuickSort(int[] iArr, float[] fArr, int i2, int i3) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int partition = partition(iArr, fArr, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = partition - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = partition + 1;
                }
            }
        }

        public static int partition(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    swap(iArr, fArr, i5, i2);
                    i5++;
                }
                i2++;
            }
            swap(iArr, fArr, i5, i3);
            return i5;
        }

        public static void swap(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f;
        }
    }

    public static class TranslationXset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    public static class TranslationYset extends SplineSet {
        public void setProperty(View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    public static class TranslationZset extends SplineSet {
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f));
            }
        }
    }

    public static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.constraintlayout.motion.widget.SplineSet makeSpline(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x00ae;
                case -1249320805: goto L_0x00a4;
                case -1225497657: goto L_0x0099;
                case -1225497656: goto L_0x008e;
                case -1225497655: goto L_0x0083;
                case -1001078227: goto L_0x0078;
                case -908189618: goto L_0x006d;
                case -908189617: goto L_0x0062;
                case -797520672: goto L_0x0057;
                case -760884510: goto L_0x004c;
                case -760884509: goto L_0x0041;
                case -40300674: goto L_0x0036;
                case -4379043: goto L_0x002b;
                case 37232917: goto L_0x0020;
                case 92909918: goto L_0x0015;
                case 156108012: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00b8
        L_0x0009:
            java.lang.String r0 = "waveOffset"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 10
            goto L_0x00b9
        L_0x0015:
            java.lang.String r0 = "alpha"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 0
            goto L_0x00b9
        L_0x0020:
            java.lang.String r0 = "transitionPathRotate"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 7
            goto L_0x00b9
        L_0x002b:
            java.lang.String r0 = "elevation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 1
            goto L_0x00b9
        L_0x0036:
            java.lang.String r0 = "rotation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 2
            goto L_0x00b9
        L_0x0041:
            java.lang.String r0 = "transformPivotY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 6
            goto L_0x00b9
        L_0x004c:
            java.lang.String r0 = "transformPivotX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 5
            goto L_0x00b9
        L_0x0057:
            java.lang.String r0 = "waveVariesBy"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 11
            goto L_0x00b9
        L_0x0062:
            java.lang.String r0 = "scaleY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 9
            goto L_0x00b9
        L_0x006d:
            java.lang.String r0 = "scaleX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 8
            goto L_0x00b9
        L_0x0078:
            java.lang.String r0 = "progress"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 15
            goto L_0x00b9
        L_0x0083:
            java.lang.String r0 = "translationZ"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 14
            goto L_0x00b9
        L_0x008e:
            java.lang.String r0 = "translationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 13
            goto L_0x00b9
        L_0x0099:
            java.lang.String r0 = "translationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 12
            goto L_0x00b9
        L_0x00a4:
            java.lang.String r0 = "rotationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 4
            goto L_0x00b9
        L_0x00ae:
            java.lang.String r0 = "rotationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 3
            goto L_0x00b9
        L_0x00b8:
            r1 = -1
        L_0x00b9:
            switch(r1) {
                case 0: goto L_0x0118;
                case 1: goto L_0x0112;
                case 2: goto L_0x010c;
                case 3: goto L_0x0106;
                case 4: goto L_0x0100;
                case 5: goto L_0x00fa;
                case 6: goto L_0x00f4;
                case 7: goto L_0x00ee;
                case 8: goto L_0x00e8;
                case 9: goto L_0x00e2;
                case 10: goto L_0x00dc;
                case 11: goto L_0x00d6;
                case 12: goto L_0x00d0;
                case 13: goto L_0x00ca;
                case 14: goto L_0x00c4;
                case 15: goto L_0x00be;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            r1 = 0
            return r1
        L_0x00be:
            androidx.constraintlayout.motion.widget.SplineSet$ProgressSet r1 = new androidx.constraintlayout.motion.widget.SplineSet$ProgressSet
            r1.<init>()
            return r1
        L_0x00c4:
            androidx.constraintlayout.motion.widget.SplineSet$TranslationZset r1 = new androidx.constraintlayout.motion.widget.SplineSet$TranslationZset
            r1.<init>()
            return r1
        L_0x00ca:
            androidx.constraintlayout.motion.widget.SplineSet$TranslationYset r1 = new androidx.constraintlayout.motion.widget.SplineSet$TranslationYset
            r1.<init>()
            return r1
        L_0x00d0:
            androidx.constraintlayout.motion.widget.SplineSet$TranslationXset r1 = new androidx.constraintlayout.motion.widget.SplineSet$TranslationXset
            r1.<init>()
            return r1
        L_0x00d6:
            androidx.constraintlayout.motion.widget.SplineSet$AlphaSet r1 = new androidx.constraintlayout.motion.widget.SplineSet$AlphaSet
            r1.<init>()
            return r1
        L_0x00dc:
            androidx.constraintlayout.motion.widget.SplineSet$AlphaSet r1 = new androidx.constraintlayout.motion.widget.SplineSet$AlphaSet
            r1.<init>()
            return r1
        L_0x00e2:
            androidx.constraintlayout.motion.widget.SplineSet$ScaleYset r1 = new androidx.constraintlayout.motion.widget.SplineSet$ScaleYset
            r1.<init>()
            return r1
        L_0x00e8:
            androidx.constraintlayout.motion.widget.SplineSet$ScaleXset r1 = new androidx.constraintlayout.motion.widget.SplineSet$ScaleXset
            r1.<init>()
            return r1
        L_0x00ee:
            androidx.constraintlayout.motion.widget.SplineSet$PathRotate r1 = new androidx.constraintlayout.motion.widget.SplineSet$PathRotate
            r1.<init>()
            return r1
        L_0x00f4:
            androidx.constraintlayout.motion.widget.SplineSet$PivotYset r1 = new androidx.constraintlayout.motion.widget.SplineSet$PivotYset
            r1.<init>()
            return r1
        L_0x00fa:
            androidx.constraintlayout.motion.widget.SplineSet$PivotXset r1 = new androidx.constraintlayout.motion.widget.SplineSet$PivotXset
            r1.<init>()
            return r1
        L_0x0100:
            androidx.constraintlayout.motion.widget.SplineSet$RotationYset r1 = new androidx.constraintlayout.motion.widget.SplineSet$RotationYset
            r1.<init>()
            return r1
        L_0x0106:
            androidx.constraintlayout.motion.widget.SplineSet$RotationXset r1 = new androidx.constraintlayout.motion.widget.SplineSet$RotationXset
            r1.<init>()
            return r1
        L_0x010c:
            androidx.constraintlayout.motion.widget.SplineSet$RotationSet r1 = new androidx.constraintlayout.motion.widget.SplineSet$RotationSet
            r1.<init>()
            return r1
        L_0x0112:
            androidx.constraintlayout.motion.widget.SplineSet$ElevationSet r1 = new androidx.constraintlayout.motion.widget.SplineSet$ElevationSet
            r1.<init>()
            return r1
        L_0x0118:
            androidx.constraintlayout.motion.widget.SplineSet$AlphaSet r1 = new androidx.constraintlayout.motion.widget.SplineSet$AlphaSet
            r1.<init>()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.SplineSet.makeSpline(java.lang.String):androidx.constraintlayout.motion.widget.SplineSet");
    }

    public float get(float f) {
        return (float) this.mCurveFit.getPos((double) f, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCurveFit.getSlope((double) f, 0);
    }

    public void setPoint(int i2, float f) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i3 = this.count;
        iArr2[i3] = i2;
        this.mValues[i3] = f;
        this.count = i3 + 1;
    }

    public abstract void setProperty(View view, float f);

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i2) {
        int i3 = this.count;
        if (i3 != 0) {
            Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i3 - 1);
            int i4 = 1;
            for (int i5 = 1; i5 < this.count; i5++) {
                int[] iArr = this.mTimePoints;
                if (iArr[i5 - 1] != iArr[i5]) {
                    i4++;
                }
            }
            double[] dArr = new double[i4];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i4;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr2);
            int i6 = 0;
            for (int i7 = 0; i7 < this.count; i7++) {
                if (i7 > 0) {
                    int[] iArr3 = this.mTimePoints;
                    if (iArr3[i7] == iArr3[i7 - 1]) {
                    }
                }
                dArr[i6] = ((double) this.mTimePoints[i7]) * 0.01d;
                dArr2[i6][0] = (double) this.mValues[i7];
                i6++;
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.count; i2++) {
            str = str + "[" + this.mTimePoints[i2] + " , " + decimalFormat.format((double) this.mValues[i2]) + "] ";
        }
        return str;
    }
}
