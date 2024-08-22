package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MotionController {
    public static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    public static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    public int MAX_DIMENSION = 4;
    public String[] attributeTable;
    public CurveFit mArcSpline;
    public int[] mAttributeInterpCount;
    public String[] mAttributeNames;
    public HashMap<String, SplineSet> mAttributesMap;
    public String mConstraintTag;
    public int mCurveFitType = -1;
    public HashMap<String, KeyCycleOscillator> mCycleMap;
    public MotionPaths mEndMotionPath = new MotionPaths();
    public MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    public int mId;
    public double[] mInterpolateData;
    public int[] mInterpolateVariables;
    public double[] mInterpolateVelocity;
    public ArrayList<Key> mKeyList = new ArrayList<>();
    public KeyTrigger[] mKeyTriggers;
    public ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    public float mMotionStagger = Float.NaN;
    public int mPathMotionArc = Key.UNSET;
    public CurveFit[] mSpline;
    public float mStaggerOffset = 0.0f;
    public float mStaggerScale = 1.0f;
    public MotionPaths mStartMotionPath = new MotionPaths();
    public MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    public HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    public float[] mValuesBuff = new float[4];
    public float[] mVelocity = new float[1];
    public View mView;

    public MotionController(View view) {
        setView(view);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f2 = 0.0f;
        float f3 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else if (((double) this.mStaggerScale) != 1.0d) {
            if (f < this.mStaggerOffset) {
                f = 0.0f;
            }
            float f4 = this.mStaggerOffset;
            if (f > f4 && ((double) f) < 1.0d) {
                f = (f - f4) * this.mStaggerScale;
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f5 = Float.NaN;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f6 = next.time;
                if (f6 < f) {
                    easing = easing2;
                    f2 = f6;
                } else if (Float.isNaN(f5)) {
                    f5 = next.time;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f5)) {
                f3 = f5;
            }
            float f7 = f3 - f2;
            double d = (double) ((f - f2) / f7);
            f = (((float) easing.get(d)) * f7) + f2;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f;
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f = 1.0f / ((float) 99);
        double d = 0.0d;
        double d2 = 0.0d;
        int i2 = 0;
        float f2 = 0.0f;
        while (i2 < 100) {
            float f3 = ((float) i2) * f;
            double d3 = (double) f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f4 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f5 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                float f6 = f;
                if (easing2 != null) {
                    float f7 = next.time;
                    if (f7 < f3) {
                        f5 = f7;
                        easing = easing2;
                    } else if (Float.isNaN(f4)) {
                        f4 = next.time;
                    }
                }
                f = f6;
            }
            float f8 = f;
            if (easing != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                float f9 = f4 - f5;
                d3 = (double) ((((float) easing.get((double) ((f3 - f5) / f9))) * f9) + f5);
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i2 > 0) {
                f2 = (float) (((double) f2) + Math.hypot(d2 - ((double) fArr[1]), d - ((double) fArr[0])));
            }
            d = (double) fArr[0];
            d2 = (double) fArr[1];
            i2++;
            f = f8;
        }
        return f2;
    }

    private void insertKey(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            " KeyPath positon \"" + motionPaths.position + "\" outside of range";
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float) ((int) this.mView.getX()), (float) ((int) this.mView.getY()), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i2) {
        int i3 = i2;
        float f = 1.0f / ((float) (i3 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get(Key.TRANSLATION_X);
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get(Key.TRANSLATION_Y);
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            KeyCycleOscillator keyCycleOscillator = hashMap3.get(Key.TRANSLATION_X);
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            KeyCycleOscillator keyCycleOscillator2 = hashMap4.get(Key.TRANSLATION_Y);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            float f2 = ((float) i4) * f;
            float f3 = 0.0f;
            if (this.mStaggerScale != 1.0f) {
                if (f2 < this.mStaggerOffset) {
                    f2 = 0.0f;
                }
                float f4 = this.mStaggerOffset;
                if (f2 > f4 && ((double) f2) < 1.0d) {
                    f2 = (f2 - f4) * this.mStaggerScale;
                }
            }
            double d = (double) f2;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f5 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f6 = next.time;
                    if (f6 < f2) {
                        easing = easing2;
                        f3 = f6;
                    } else if (Float.isNaN(f5)) {
                        f5 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                float f7 = f5 - f3;
                d = (double) ((((float) easing.get((double) ((f2 - f3) / f7))) * f7) + f3);
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i4 * 2);
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().mMode;
                i2++;
            }
        }
        int i3 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().mMode;
                i2++;
            }
        }
        int i3 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public void buildPath(float[] fArr, int i2) {
        float[] fArr2 = fArr;
        int i3 = i2;
        float f = 1.0f;
        float f2 = 1.0f / ((float) (i3 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get(Key.TRANSLATION_X);
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get(Key.TRANSLATION_Y);
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap3 == null ? null : hashMap3.get(Key.TRANSLATION_X);
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            keyCycleOscillator = hashMap4.get(Key.TRANSLATION_Y);
        }
        int i4 = 0;
        while (i4 < i3) {
            float f3 = ((float) i4) * f2;
            float f4 = 0.0f;
            if (this.mStaggerScale != f) {
                if (f3 < this.mStaggerOffset) {
                    f3 = 0.0f;
                }
                float f5 = this.mStaggerOffset;
                if (f3 > f5 && ((double) f3) < 1.0d) {
                    f3 = (f3 - f5) * this.mStaggerScale;
                }
            }
            double d = (double) f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f6 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    Easing easing3 = easing2;
                    float f7 = next.time;
                    if (f7 < f3) {
                        f4 = f7;
                        easing = easing3;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.time;
                    }
                }
                int i5 = i2;
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                float f8 = f6 - f4;
                d = (double) ((((float) easing.get((double) ((f3 - f4) / f8))) * f8) + f4);
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i6 = i4 * 2;
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr2, i6);
            if (keyCycleOscillator2 != null) {
                fArr2[i6] = fArr2[i6] + keyCycleOscillator2.get(f3);
            } else if (splineSet != null) {
                fArr2[i6] = fArr2[i6] + splineSet.get(f3);
            }
            if (keyCycleOscillator != null) {
                int i7 = i6 + 1;
                fArr2[i7] = fArr2[i7] + keyCycleOscillator.get(f3);
            } else if (splineSet2 != null) {
                int i8 = i6 + 1;
                fArr2[i8] = fArr2[i8] + splineSet2.get(f3);
            }
            i4++;
            i3 = i2;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i2) {
        this.mSpline[0].getPos((double) getAdjustedPosition(f, (float[]) null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
    }

    public void buildRectangles(float[] fArr, int i2) {
        float f = 1.0f / ((float) (i2 - 1));
        for (int i3 = 0; i3 < i2; i3++) {
            this.mSpline[0].getPos((double) getAdjustedPosition(((float) i3) * f, (float[]) null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 8);
        }
    }

    public int getAttributeValues(String str, float[] fArr, int i2) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = splineSet.get((float) (i3 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i2 = 0;
        if (curveFitArr != null) {
            double d = (double) adjustedPosition;
            curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d, this.mInterpolateData);
            float f4 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * ((double) f4);
                i2++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d, dArr2);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        float f5 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f6 = f5 - motionPaths2.x;
        float f7 = motionPaths.y - motionPaths2.y;
        float f8 = (motionPaths.width - motionPaths2.width) + f6;
        float f9 = (motionPaths.height - motionPaths2.height) + f7;
        fArr[0] = (f6 * (1.0f - f2)) + (f8 * f2);
        fArr[1] = (f7 * (1.0f - f3)) + (f9 * f3);
    }

    public int getDrawPath() {
        int i2 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i2 = Math.max(i2, it.next().mDrawPath);
        }
        return Math.max(i2, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    public MotionPaths getKeyFrame(int i2) {
        return this.mMotionPaths.get(i2);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            if (next.mType == i2 || i2 != -1) {
                iArr[i4] = 0;
                int i5 = i4 + 1;
                iArr[i5] = next.mType;
                int i6 = i5 + 1;
                int i7 = next.mFramePosition;
                iArr[i6] = i7;
                this.mSpline[0].getPos((double) (((float) i7) / 100.0f), this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i8 = i6 + 1;
                iArr[i8] = Float.floatToIntBits(fArr[0]);
                int i9 = i8 + 1;
                iArr[i9] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i10 = i9 + 1;
                    iArr[i10] = keyPosition.mPositionType;
                    int i11 = i10 + 1;
                    iArr[i11] = Float.floatToIntBits(keyPosition.mPercentX);
                    i9 = i11 + 1;
                    iArr[i9] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i12 = i9 + 1;
                iArr[i4] = i12 - i4;
                i3++;
                i4 = i12;
            }
        }
        return i3;
    }

    public float getKeyFrameParameter(int i2, float f, float f2) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f3 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f4 = motionPaths2.x;
        float f5 = f3 - f4;
        float f6 = motionPaths.y;
        float f7 = motionPaths2.y;
        float f8 = f6 - f7;
        float f9 = f4 + (motionPaths2.width / 2.0f);
        float f10 = f7 + (motionPaths2.height / 2.0f);
        float hypot = (float) Math.hypot((double) f5, (double) f8);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f11 = f - f9;
        float f12 = f2 - f10;
        if (((float) Math.hypot((double) f11, (double) f12)) == 0.0f) {
            return 0.0f;
        }
        float f13 = (f11 * f5) + (f12 * f8);
        if (i2 == 0) {
            return f13 / hypot;
        }
        if (i2 == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f13 * f13)));
        }
        if (i2 == 2) {
            return f11 / f5;
        }
        if (i2 == 3) {
            return f12 / f5;
        }
        if (i2 == 4) {
            return f11 / f8;
        }
        if (i2 != 5) {
            return 0.0f;
        }
        return f12 / f8;
    }

    public KeyPositionBase getPositionKeyframe(int i2, int i3, float f, float f2) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f3 = motionPaths.x;
        rectF.left = f3;
        float f4 = motionPaths.y;
        rectF.top = f4;
        rectF.right = f3 + motionPaths.width;
        rectF.bottom = f4 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f5 = motionPaths2.x;
        rectF2.left = f5;
        float f6 = motionPaths2.y;
        rectF2.top = f6;
        rectF2.right = f5 + motionPaths2.width;
        rectF2.bottom = f6 + motionPaths2.height;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.intersects(i2, i3, rectF, rectF2, f, f2)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i2, int i3, float f2, float f3, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get(Key.TRANSLATION_X);
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get(Key.TRANSLATION_Y);
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get(Key.ROTATION);
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get(Key.SCALE_X);
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get(Key.SCALE_Y);
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap6 == null ? null : hashMap6.get(Key.TRANSLATION_X);
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = hashMap7 == null ? null : hashMap7.get(Key.TRANSLATION_Y);
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = hashMap8 == null ? null : hashMap8.get(Key.ROTATION);
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = hashMap9 == null ? null : hashMap9.get(Key.SCALE_X);
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            keyCycleOscillator = hashMap10.get(Key.SCALE_Y);
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator4, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator2, keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator5, keyCycleOscillator, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = (double) adjustedPosition;
                curveFit.getPos(d, dArr);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f2, f3, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = (double) getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f4 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * ((double) f4);
                    i4++;
                } else {
                    float f5 = f2;
                    float f6 = f3;
                    this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f5, f6, i2, i3, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f7 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f8 = f7 - motionPaths2.x;
            float f9 = motionPaths.y - motionPaths2.y;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator5;
            float f10 = (motionPaths.height - motionPaths2.height) + f9;
            fArr[0] = (f8 * (1.0f - f2)) + (((motionPaths.width - motionPaths2.width) + f8) * f2);
            fArr[1] = (f9 * (1.0f - f3)) + (f10 * f3);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator4, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator2, keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator6, keyCycleOscillator, adjustedPosition);
            velocityMatrix.applyTransform(f2, f3, i2, i3, fArr);
        }
    }

    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i4 = next.mFramePosition;
            iArr[i2] = (next.mType * 1000) + i4;
            this.mSpline[0].getPos((double) (((float) i4) / 100.0f), this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: androidx.constraintlayout.motion.widget.TimeCycleSplineSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean interpolate(android.view.View r23, float r24, long r25, androidx.constraintlayout.motion.widget.KeyCache r27) {
        /*
            r22 = this;
            r0 = r22
            r11 = r23
            r1 = 0
            r2 = r24
            float r12 = r0.getAdjustedPosition(r2, r1)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r2 = r0.mAttributesMap
            if (r2 == 0) goto L_0x0027
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.SplineSet r3 = (androidx.constraintlayout.motion.widget.SplineSet) r3
            r3.setProperty(r11, r12)
            goto L_0x0017
        L_0x0027:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r2 = r0.mTimeCycleAttributesMap
            r13 = 0
            if (r2 == 0) goto L_0x0059
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = 0
        L_0x0036:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet r1 = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate
            if (r2 == 0) goto L_0x004a
            r8 = r1
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate r8 = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate) r8
            goto L_0x0036
        L_0x004a:
            r2 = r23
            r3 = r12
            r4 = r25
            r6 = r27
            boolean r1 = r1.setProperty(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x0036
        L_0x0057:
            r14 = r9
            goto L_0x005b
        L_0x0059:
            r8 = r1
            r14 = 0
        L_0x005b:
            androidx.constraintlayout.motion.utils.CurveFit[] r1 = r0.mSpline
            r15 = 1
            if (r1 == 0) goto L_0x013f
            r1 = r1[r13]
            double r9 = (double) r12
            double[] r2 = r0.mInterpolateData
            r1.getPos((double) r9, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit[] r1 = r0.mSpline
            r1 = r1[r13]
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r9, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit r1 = r0.mArcSpline
            if (r1 == 0) goto L_0x0084
            double[] r2 = r0.mInterpolateData
            int r3 = r2.length
            if (r3 <= 0) goto L_0x0084
            r1.getPos((double) r9, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit r1 = r0.mArcSpline
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r9, (double[]) r2)
        L_0x0084:
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            int[] r3 = r0.mInterpolateVariables
            double[] r4 = r0.mInterpolateData
            double[] r5 = r0.mInterpolateVelocity
            r6 = 0
            r2 = r23
            r1.setView(r2, r3, r4, r5, r6)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r1 = r0.mAttributesMap
            if (r1 == 0) goto L_0x00bd
            java.util.Collection r1 = r1.values()
            java.util.Iterator r16 = r1.iterator()
        L_0x009e:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x00bd
            java.lang.Object r1 = r16.next()
            androidx.constraintlayout.motion.widget.SplineSet r1 = (androidx.constraintlayout.motion.widget.SplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.SplineSet.PathRotate
            if (r2 == 0) goto L_0x009e
            androidx.constraintlayout.motion.widget.SplineSet$PathRotate r1 = (androidx.constraintlayout.motion.widget.SplineSet.PathRotate) r1
            double[] r2 = r0.mInterpolateVelocity
            r4 = r2[r13]
            r6 = r2[r15]
            r2 = r23
            r3 = r12
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x009e
        L_0x00bd:
            if (r8 == 0) goto L_0x00da
            double[] r1 = r0.mInterpolateVelocity
            r16 = r1[r13]
            r18 = r1[r15]
            r1 = r8
            r2 = r23
            r3 = r27
            r4 = r12
            r5 = r25
            r7 = r16
            r20 = r9
            r9 = r18
            boolean r1 = r1.setPathRotate(r2, r3, r4, r5, r7, r9)
            r1 = r1 | r14
            r14 = r1
            goto L_0x00dc
        L_0x00da:
            r20 = r9
        L_0x00dc:
            r1 = 1
        L_0x00dd:
            androidx.constraintlayout.motion.utils.CurveFit[] r2 = r0.mSpline
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0103
            r2 = r2[r1]
            float[] r3 = r0.mValuesBuff
            r4 = r20
            r2.getPos((double) r4, (float[]) r3)
            androidx.constraintlayout.motion.widget.MotionPaths r2 = r0.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.attributes
            java.lang.String[] r3 = r0.mAttributeNames
            int r6 = r1 + -1
            r3 = r3[r6]
            java.lang.Object r2 = r2.get(r3)
            androidx.constraintlayout.widget.ConstraintAttribute r2 = (androidx.constraintlayout.widget.ConstraintAttribute) r2
            float[] r3 = r0.mValuesBuff
            r2.setInterpolatedValue(r11, r3)
            int r1 = r1 + 1
            goto L_0x00dd
        L_0x0103:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mStartPoint
            int r2 = r1.mVisibilityMode
            if (r2 != 0) goto L_0x012d
            r2 = 0
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0114
            int r1 = r1.visibility
            r11.setVisibility(r1)
            goto L_0x012d
        L_0x0114:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0122
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mEndPoint
            int r1 = r1.visibility
            r11.setVisibility(r1)
            goto L_0x012d
        L_0x0122:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r2 = r0.mEndPoint
            int r2 = r2.visibility
            int r1 = r1.visibility
            if (r2 == r1) goto L_0x012d
            r11.setVisibility(r13)
        L_0x012d:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.mKeyTriggers
            if (r1 == 0) goto L_0x018b
            r1 = 0
        L_0x0132:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r2 = r0.mKeyTriggers
            int r3 = r2.length
            if (r1 >= r3) goto L_0x018b
            r2 = r2[r1]
            r2.conditionallyFire(r12, r11)
            int r1 = r1 + 1
            goto L_0x0132
        L_0x013f:
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            float r2 = r1.x
            androidx.constraintlayout.motion.widget.MotionPaths r3 = r0.mEndMotionPath
            float r4 = r3.x
            float r4 = r4 - r2
            float r4 = r4 * r12
            float r2 = r2 + r4
            float r4 = r1.y
            float r5 = r3.y
            float r5 = r5 - r4
            float r5 = r5 * r12
            float r4 = r4 + r5
            float r5 = r1.width
            float r6 = r3.width
            float r7 = r6 - r5
            float r7 = r7 * r12
            float r7 = r7 + r5
            float r1 = r1.height
            float r3 = r3.height
            float r8 = r3 - r1
            float r8 = r8 * r12
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x017b
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0188
        L_0x017b:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
        L_0x0188:
            r11.layout(r10, r9, r2, r4)
        L_0x018b:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r1 = r0.mCycleMap
            if (r1 == 0) goto L_0x01ba
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0197:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x01ba
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.widget.KeyCycleOscillator r1 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet
            if (r2 == 0) goto L_0x01b6
            androidx.constraintlayout.motion.widget.KeyCycleOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet) r1
            double[] r2 = r0.mInterpolateVelocity
            r4 = r2[r13]
            r6 = r2[r15]
            r2 = r23
            r3 = r12
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x0197
        L_0x01b6:
            r1.setProperty(r11, r12)
            goto L_0x0197
        L_0x01ba:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.interpolate(android.view.View, float, long, androidx.constraintlayout.motion.widget.KeyCache):boolean");
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f2, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f3 = motionPaths.x;
        rectF.left = f3;
        float f4 = motionPaths.y;
        rectF.top = f4;
        rectF.right = f3 + motionPaths.width;
        rectF.bottom = f4 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f5 = motionPaths2.x;
        rectF2.left = f5;
        float f6 = motionPaths2.y;
        rectF2.top = f6;
        rectF2.right = f5 + motionPaths2.width;
        rectF2.bottom = f6 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
    }

    public void setDrawPath(int i2) {
        this.mStartMotionPath.mDrawPath = i2;
    }

    public void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds((float) constraintWidget.getX(), (float) constraintWidget.getY(), (float) constraintWidget.getWidth(), (float) constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int i2) {
        this.mPathMotionArc = i2;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds((float) constraintWidget.getX(), (float) constraintWidget.getY(), (float) constraintWidget.getWidth(), (float) constraintWidget.getHeight());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i2, int i3, float f, long j) {
        ArrayList arrayList;
        TimeCycleSplineSet timeCycleSplineSet;
        ConstraintAttribute constraintAttribute;
        SplineSet splineSet;
        ConstraintAttribute constraintAttribute2;
        Class<double> cls = double.class;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        int i4 = this.mPathMotionArc;
        if (i4 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i4;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i2, i3, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i5 = keyPosition.mCurveFit;
                    if (i5 != Key.UNSET) {
                        this.mCurveFitType = i5;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        char c = 0;
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c2 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[c2];
                    Iterator<Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        Key next2 = it3.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next2.mCustomConstraints;
                        if (!(hashMap2 == null || (constraintAttribute2 = hashMap2.get(str2)) == null)) {
                            sparseArray.append(next2.mFramePosition, constraintAttribute2);
                        }
                    }
                    splineSet = SplineSet.makeCustomSpline(str, sparseArray);
                } else {
                    splineSet = SplineSet.makeSpline(str);
                }
                if (splineSet != null) {
                    splineSet.setType(str);
                    this.mAttributesMap.put(str, splineSet);
                }
                c2 = 1;
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    Key next3 = it4.next();
                    if (next3 instanceof KeyAttributes) {
                        next3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String next4 : this.mAttributesMap.keySet()) {
                this.mAttributesMap.get(next4).setup(hashMap.containsKey(next4) ? ((Integer) hashMap.get(next4)).intValue() : 0);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String str3 = (String) it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(str3)) {
                    if (str3.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str4 = str3.split(",")[1];
                        Iterator<Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            Key next5 = it6.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next5.mCustomConstraints;
                            if (!(hashMap3 == null || (constraintAttribute = hashMap3.get(str4)) == null)) {
                                sparseArray2.append(next5.mFramePosition, constraintAttribute);
                            }
                        }
                        timeCycleSplineSet = TimeCycleSplineSet.makeCustomSpline(str3, sparseArray2);
                        long j2 = j;
                    } else {
                        timeCycleSplineSet = TimeCycleSplineSet.makeSpline(str3, j);
                    }
                    if (timeCycleSplineSet != null) {
                        timeCycleSplineSet.setType(str3);
                        this.mTimeCycleAttributesMap.put(str3, timeCycleSplineSet);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next6 = it7.next();
                    if (next6 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next6).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String next7 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(next7).setup(hashMap.containsKey(next7) ? ((Integer) hashMap.get(next7)).intValue() : 0);
            }
        }
        int i6 = 2;
        int size = this.mMotionPaths.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i7 = 1;
        while (it8.hasNext()) {
            motionPathsArr[i7] = it8.next();
            i7++;
        }
        HashSet hashSet4 = new HashSet();
        for (String next8 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(next8)) {
                if (!hashSet2.contains("CUSTOM," + next8)) {
                    hashSet4.add(next8);
                }
            }
        }
        String[] strArr = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr;
        this.mAttributeInterpCount = new int[strArr.length];
        int i8 = 0;
        while (true) {
            String[] strArr2 = this.mAttributeNames;
            if (i8 >= strArr2.length) {
                break;
            }
            String str5 = strArr2[i8];
            this.mAttributeInterpCount[i8] = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    break;
                } else if (motionPathsArr[i9].attributes.containsKey(str5)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i8] = iArr[i8] + motionPathsArr[i9].attributes.get(str5).noOfInterpValues();
                    break;
                } else {
                    i9++;
                }
            }
            i8++;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != Key.UNSET;
        int length = 18 + this.mAttributeNames.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 1; i10 < size; i10++) {
            motionPathsArr[i10].different(motionPathsArr[i10 - 1], zArr, this.mAttributeNames, z);
        }
        int i11 = 0;
        for (int i12 = 1; i12 < length; i12++) {
            if (zArr[i12]) {
                i11++;
            }
        }
        int[] iArr2 = new int[i11];
        this.mInterpolateVariables = iArr2;
        this.mInterpolateData = new double[iArr2.length];
        this.mInterpolateVelocity = new double[iArr2.length];
        int i13 = 0;
        for (int i14 = 1; i14 < length; i14++) {
            if (zArr[i14]) {
                this.mInterpolateVariables[i13] = i14;
                i13++;
            }
        }
        int[] iArr3 = new int[2];
        iArr3[1] = this.mInterpolateVariables.length;
        iArr3[0] = size;
        double[][] dArr = (double[][]) Array.newInstance(cls, iArr3);
        double[] dArr2 = new double[size];
        for (int i15 = 0; i15 < size; i15++) {
            motionPathsArr[i15].fillStandard(dArr[i15], this.mInterpolateVariables);
            dArr2[i15] = (double) motionPathsArr[i15].time;
        }
        int i16 = 0;
        while (true) {
            int[] iArr4 = this.mInterpolateVariables;
            if (i16 >= iArr4.length) {
                break;
            }
            if (iArr4[i16] < MotionPaths.names.length) {
                String str6 = MotionPaths.names[this.mInterpolateVariables[i16]] + " [";
                for (int i17 = 0; i17 < size; i17++) {
                    str6 = str6 + dArr[i17][i16];
                }
            }
            i16++;
        }
        this.mSpline = new CurveFit[(this.mAttributeNames.length + 1)];
        int i18 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i18 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i18];
            int i19 = 0;
            double[] dArr3 = null;
            int i20 = 0;
            double[][] dArr4 = null;
            while (i19 < size) {
                if (motionPathsArr[i19].hasCustomData(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr5 = new int[i6];
                        iArr5[1] = motionPathsArr[i19].getCustomDataCount(str7);
                        iArr5[c] = size;
                        dArr4 = (double[][]) Array.newInstance(cls, iArr5);
                    }
                    dArr3[i20] = (double) motionPathsArr[i19].time;
                    motionPathsArr[i19].getCustomData(str7, dArr4[i20], 0);
                    i20++;
                }
                i19++;
                i6 = 2;
                c = 0;
            }
            i18++;
            this.mSpline[i18] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i20), (double[][]) Arrays.copyOf(dArr4, i20));
            i6 = 2;
            c = 0;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr6 = new int[size];
            double[] dArr5 = new double[size];
            int[] iArr7 = new int[2];
            iArr7[1] = 2;
            iArr7[0] = size;
            double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr7);
            for (int i21 = 0; i21 < size; i21++) {
                iArr6[i21] = motionPathsArr[i21].mPathMotionArc;
                dArr5[i21] = (double) motionPathsArr[i21].time;
                dArr6[i21][0] = (double) motionPathsArr[i21].x;
                dArr6[i21][1] = (double) motionPathsArr[i21].y;
            }
            this.mArcSpline = CurveFit.getArc(iArr6, dArr5, dArr6);
        }
        float f2 = Float.NaN;
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator it9 = hashSet3.iterator();
            while (it9.hasNext()) {
                String str8 = (String) it9.next();
                KeyCycleOscillator makeSpline = KeyCycleOscillator.makeSpline(str8);
                if (makeSpline != null) {
                    if (makeSpline.variesByPath() && Float.isNaN(f2)) {
                        f2 = getPreCycleDistance();
                    }
                    makeSpline.setType(str8);
                    this.mCycleMap.put(str8, makeSpline);
                }
            }
            Iterator<Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                Key next9 = it10.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            for (KeyCycleOscillator upVar : this.mCycleMap.values()) {
                upVar.setup(f2);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
