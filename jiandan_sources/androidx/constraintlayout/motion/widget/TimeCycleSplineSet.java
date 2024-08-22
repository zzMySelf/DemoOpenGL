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

public abstract class TimeCycleSplineSet {
    public static final int CURVE_OFFSET = 2;
    public static final int CURVE_PERIOD = 1;
    public static final int CURVE_VALUE = 0;
    public static final String TAG = "SplineSet";
    public static float VAL_2PI = 6.2831855f;
    public int count;
    public float last_cycle = Float.NaN;
    public long last_time;
    public float[] mCache = new float[3];
    public boolean mContinue = false;
    public CurveFit mCurveFit;
    public int[] mTimePoints = new int[10];
    public String mType;
    public float[][] mValues = ((float[][]) Array.newInstance(float.class, new int[]{10, 3}));
    public int mWaveShape = 0;

    public static class AlphaSet extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setAlpha(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class CustomSet extends TimeCycleSplineSet {
        public String mAttributeName;
        public float[] mCache;
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;
        public SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i2, float f, float f2, int i3, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            this.mCurveFit.getPos((double) f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            float f4 = (float) ((((double) this.last_cycle) + ((((double) (j - this.last_time)) * 1.0E-9d) * ((double) f2))) % 1.0d);
            this.last_cycle = f4;
            this.last_time = j;
            float calcWave = calcWave(f4);
            this.mContinue = false;
            for (int i2 = 0; i2 < this.mCache.length; i2++) {
                this.mContinue |= ((double) this.mTempValues[i2]) != 0.0d;
                this.mCache[i2] = (this.mTempValues[i2] * calcWave) + f3;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f2 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i3 = noOfInterpValues + 2;
            this.mTempValues = new float[i3];
            this.mCache = new float[noOfInterpValues];
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i4);
                float[] valueAt = this.mWaveProperties.valueAt(i4);
                dArr[i4] = ((double) keyAt) * 0.01d;
                this.mConstraintAttributeList.valueAt(i4).getValuesToInterpolate(this.mTempValues);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i5 >= fArr.length) {
                        break;
                    }
                    dArr2[i4][i5] = (double) fArr[i5];
                    i5++;
                }
                dArr2[i4][noOfInterpValues] = (double) valueAt[0];
                dArr2[i4][noOfInterpValues + 1] = (double) valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, ConstraintAttribute constraintAttribute, float f, int i3, float f2) {
            this.mConstraintAttributeList.append(i2, constraintAttribute);
            this.mWaveProperties.append(i2, new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, i3);
        }
    }

    public static class ElevationSet extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f, j, view, keyCache));
            }
            return this.mContinue;
        }
    }

    public static class PathRotate extends TimeCycleSplineSet {
        public boolean setPathRotate(View view, KeyCache keyCache, float f, long j, double d, double d2) {
            view.setRotation(get(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.mContinue;
        }

        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    public static class ProgressSet extends TimeCycleSplineSet {
        public boolean mNoMethod = false;

        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f, j, view, keyCache));
            } else if (this.mNoMethod) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f, j, view, keyCache))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.mContinue;
        }
    }

    public static class RotationSet extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotation(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class RotationXset extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class RotationYset extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class ScaleXset extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class ScaleYset extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class Sort {
        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i2, int i3) {
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

        public static int partition(int[] iArr, float[][] fArr, int i2, int i3) {
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

        public static void swap(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = fArr2;
        }
    }

    public static class TranslationXset extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class TranslationYset extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class TranslationZset extends TimeCycleSplineSet {
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f, j, view, keyCache));
            }
            return this.mContinue;
        }
    }

    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.constraintlayout.motion.widget.TimeCycleSplineSet makeSpline(java.lang.String r1, long r2) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x007d;
                case -1249320805: goto L_0x0073;
                case -1225497657: goto L_0x0068;
                case -1225497656: goto L_0x005d;
                case -1225497655: goto L_0x0052;
                case -1001078227: goto L_0x0047;
                case -908189618: goto L_0x003d;
                case -908189617: goto L_0x0033;
                case -40300674: goto L_0x0029;
                case -4379043: goto L_0x001f;
                case 37232917: goto L_0x0014;
                case 92909918: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0087
        L_0x0009:
            java.lang.String r0 = "alpha"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 0
            goto L_0x0088
        L_0x0014:
            java.lang.String r0 = "transitionPathRotate"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 5
            goto L_0x0088
        L_0x001f:
            java.lang.String r0 = "elevation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 1
            goto L_0x0088
        L_0x0029:
            java.lang.String r0 = "rotation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 2
            goto L_0x0088
        L_0x0033:
            java.lang.String r0 = "scaleY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 7
            goto L_0x0088
        L_0x003d:
            java.lang.String r0 = "scaleX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 6
            goto L_0x0088
        L_0x0047:
            java.lang.String r0 = "progress"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 11
            goto L_0x0088
        L_0x0052:
            java.lang.String r0 = "translationZ"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 10
            goto L_0x0088
        L_0x005d:
            java.lang.String r0 = "translationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 9
            goto L_0x0088
        L_0x0068:
            java.lang.String r0 = "translationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 8
            goto L_0x0088
        L_0x0073:
            java.lang.String r0 = "rotationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 4
            goto L_0x0088
        L_0x007d:
            java.lang.String r0 = "rotationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 3
            goto L_0x0088
        L_0x0087:
            r1 = -1
        L_0x0088:
            switch(r1) {
                case 0: goto L_0x00cf;
                case 1: goto L_0x00c9;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00b1;
                case 6: goto L_0x00ab;
                case 7: goto L_0x00a5;
                case 8: goto L_0x009f;
                case 9: goto L_0x0099;
                case 10: goto L_0x0093;
                case 11: goto L_0x008d;
                default: goto L_0x008b;
            }
        L_0x008b:
            r1 = 0
            return r1
        L_0x008d:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ProgressSet r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ProgressSet
            r1.<init>()
            goto L_0x00d4
        L_0x0093:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationZset r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationZset
            r1.<init>()
            goto L_0x00d4
        L_0x0099:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationYset r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationYset
            r1.<init>()
            goto L_0x00d4
        L_0x009f:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationXset r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationXset
            r1.<init>()
            goto L_0x00d4
        L_0x00a5:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ScaleYset r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ScaleYset
            r1.<init>()
            goto L_0x00d4
        L_0x00ab:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ScaleXset r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ScaleXset
            r1.<init>()
            goto L_0x00d4
        L_0x00b1:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate
            r1.<init>()
            goto L_0x00d4
        L_0x00b7:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationYset r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationYset
            r1.<init>()
            goto L_0x00d4
        L_0x00bd:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationXset r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationXset
            r1.<init>()
            goto L_0x00d4
        L_0x00c3:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationSet r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationSet
            r1.<init>()
            goto L_0x00d4
        L_0x00c9:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ElevationSet r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ElevationSet
            r1.<init>()
            goto L_0x00d4
        L_0x00cf:
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$AlphaSet r1 = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet$AlphaSet
            r1.<init>()
        L_0x00d4:
            r1.setStartTime(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TimeCycleSplineSet.makeSpline(java.lang.String, long):androidx.constraintlayout.motion.widget.TimeCycleSplineSet");
    }

    public float calcWave(float f) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f * VAL_2PI);
            case 2:
                abs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f * VAL_2PI));
            case 6:
                float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f * VAL_2PI));
        }
        return 1.0f - abs;
    }

    public float get(float f, long j, View view, KeyCache keyCache) {
        long j2 = j;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.mCurveFit.getPos((double) f, this.mCache);
        float[] fArr = this.mCache;
        float f2 = fArr[1];
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache2.getFloatValue(view2, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f3 = (float) ((((double) this.last_cycle) + ((((double) (j2 - this.last_time)) * 1.0E-9d) * ((double) f2))) % 1.0d);
        this.last_cycle = f3;
        keyCache2.setFloatValue(view2, this.mType, 0, f3);
        this.last_time = j2;
        float f4 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f4) + this.mCache[2];
        this.mContinue = (f4 == 0.0f && i2 == 0) ? false : true;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i2, float f, float f2, int i3, float f3) {
        int[] iArr = this.mTimePoints;
        int i4 = this.count;
        iArr[i4] = i2;
        float[][] fArr = this.mValues;
        fArr[i4][0] = f;
        fArr[i4][1] = f2;
        fArr[i4][2] = f3;
        this.mWaveShape = Math.max(this.mWaveShape, i3);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);

    public void setStartTime(long j) {
        this.last_time = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i2) {
        int i3 = this.count;
        if (i3 == 0) {
            "Error no points added to " + this.mType;
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i5;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr2);
        int i6 = 0;
        for (int i7 = 0; i7 < this.count; i7++) {
            if (i7 > 0) {
                int[] iArr3 = this.mTimePoints;
                if (iArr3[i7] == iArr3[i7 - 1]) {
                }
            }
            dArr[i6] = ((double) this.mTimePoints[i7]) * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[][] fArr = this.mValues;
            dArr3[0] = (double) fArr[i7][0];
            dArr2[i6][1] = (double) fArr[i7][1];
            dArr2[i6][2] = (double) fArr[i7][2];
            i6++;
        }
        this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.count; i2++) {
            str = str + "[" + this.mTimePoints[i2] + " , " + decimalFormat.format(this.mValues[i2]) + "] ";
        }
        return str;
    }
}
