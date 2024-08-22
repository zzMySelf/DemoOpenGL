package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class KeyPosition extends KeyPositionBase {
    public static final int KEY_TYPE = 2;
    public static final String NAME = "KeyPosition";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX = Float.NaN;
    public float mAltPercentY = Float.NaN;
    public float mCalculatedPositionX = Float.NaN;
    public float mCalculatedPositionY = Float.NaN;
    public int mDrawPath = 0;
    public int mPathMotionArc = Key.UNSET;
    public float mPercentHeight = Float.NaN;
    public float mPercentWidth = Float.NaN;
    public float mPercentX = Float.NaN;
    public float mPercentY = Float.NaN;
    public int mPositionType = 0;
    public String mTransitionEasing = null;

    public static class Loader {
        public static final int CURVE_FIT = 4;
        public static final int DRAW_PATH = 5;
        public static final int FRAME_POSITION = 2;
        public static final int PATH_MOTION_ARC = 10;
        public static final int PERCENT_HEIGHT = 12;
        public static final int PERCENT_WIDTH = 11;
        public static final int PERCENT_X = 6;
        public static final int PERCENT_Y = 7;
        public static final int SIZE_PERCENT = 8;
        public static final int TARGET_ID = 1;
        public static final int TRANSITION_EASING = 3;
        public static final int TYPE = 9;
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f;
                        keyPosition.mPercentHeight = f;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index);
                        break;
                }
            }
            int i3 = keyPosition.mFramePosition;
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = 0.0f;
        float f8 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f9 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f10 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        if (!Float.isNaN(this.mAltPercentX)) {
            f7 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (float) ((int) (f + (f8 * f5) + (f7 * f6)));
        this.mCalculatedPositionY = (float) ((int) (f2 + (f5 * f9) + (f6 * f10)));
    }

    private void calcPathPosition(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = this.mPercentX;
        float f8 = this.mPercentY;
        this.mCalculatedPositionX = f + (f5 * f7) + ((-f6) * f8);
        this.mCalculatedPositionY = f2 + (f6 * f7) + (f5 * f8);
    }

    private void calcScreenPosition(int i2, int i3) {
        float f = this.mPercentX;
        float f2 = (float) 0;
        this.mCalculatedPositionX = (((float) (i2 - 0)) * f) + f2;
        this.mCalculatedPositionY = (((float) (i3 - 0)) * f) + f2;
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public void calcPosition(int i2, int i3, float f, float f2, float f3, float f4) {
        int i4 = this.mPositionType;
        if (i4 == 1) {
            calcPathPosition(f, f2, f3, f4);
        } else if (i4 != 2) {
            calcCartesianPosition(f, f2, f3, f4);
        } else {
            calcScreenPosition(i2, i3);
        }
    }

    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i2, int i3, RectF rectF, RectF rectF2, float f, float f2) {
        calcPosition(i2, i3, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return Math.abs(f - this.mCalculatedPositionX) < 20.0f && Math.abs(f2 - this.mCalculatedPositionY) < 20.0f;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        int i2 = this.mPositionType;
        if (i2 == 1) {
            positionPathAttributes(rectF, rectF2, f, f2, strArr, fArr);
        } else if (i2 != 2) {
            positionCartAttributes(rectF, rectF2, f, f2, strArr, fArr);
        } else {
            positionScreenAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
        }
    }

    public void positionCartAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        if (strArr[0] == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = (f - centerX) / centerX2;
            strArr[1] = PERCENT_Y;
            fArr[1] = (f2 - centerY) / centerY2;
        } else if (PERCENT_X.equals(strArr[0])) {
            fArr[0] = (f - centerX) / centerX2;
            fArr[1] = (f2 - centerY) / centerY2;
        } else {
            fArr[1] = (f - centerX) / centerX2;
            fArr[0] = (f2 - centerY) / centerY2;
        }
    }

    public void positionPathAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) Math.hypot((double) centerX2, (double) centerY2);
        if (((double) hypot) < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f3 = centerX2 / hypot;
        float f4 = centerY2 / hypot;
        float f5 = f2 - centerY;
        float f6 = f - centerX;
        float f7 = ((f3 * f5) - (f6 * f4)) / hypot;
        float f8 = ((f3 * f6) + (f4 * f5)) / hypot;
        if (strArr[0] == null) {
            strArr[0] = PERCENT_X;
            strArr[1] = PERCENT_Y;
            fArr[0] = f8;
            fArr[1] = f7;
        } else if (PERCENT_X.equals(strArr[0])) {
            fArr[0] = f8;
            fArr[1] = f7;
        }
    }

    public void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (strArr[0] == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = f / ((float) width);
            strArr[1] = PERCENT_Y;
            fArr[1] = f2 / ((float) height);
        } else if (PERCENT_X.equals(strArr[0])) {
            fArr[0] = f / ((float) width);
            fArr[1] = f2 / ((float) height);
        } else {
            fArr[1] = f / ((float) width);
            fArr[0] = f2 / ((float) height);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1812823328: goto L_0x0044;
                case -1127236479: goto L_0x003a;
                case -1017587252: goto L_0x0030;
                case -827014263: goto L_0x0026;
                case -200259324: goto L_0x001c;
                case 428090547: goto L_0x0012;
                case 428090548: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "percentY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 6
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "percentX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 5
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "sizePercent"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 4
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "drawPath"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 1
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "percentHeight"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 3
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "percentWidth"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 2
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "transitionEasing"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 0
            goto L_0x004f
        L_0x004e:
            r2 = -1
        L_0x004f:
            switch(r2) {
                case 0: goto L_0x007f;
                case 1: goto L_0x0078;
                case 2: goto L_0x0071;
                case 3: goto L_0x006a;
                case 4: goto L_0x0061;
                case 5: goto L_0x005a;
                case 6: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0085
        L_0x0053:
            float r2 = r1.toFloat(r3)
            r1.mPercentY = r2
            goto L_0x0085
        L_0x005a:
            float r2 = r1.toFloat(r3)
            r1.mPercentX = r2
            goto L_0x0085
        L_0x0061:
            float r2 = r1.toFloat(r3)
            r1.mPercentWidth = r2
            r1.mPercentHeight = r2
            goto L_0x0085
        L_0x006a:
            float r2 = r1.toFloat(r3)
            r1.mPercentHeight = r2
            goto L_0x0085
        L_0x0071:
            float r2 = r1.toFloat(r3)
            r1.mPercentWidth = r2
            goto L_0x0085
        L_0x0078:
            int r2 = r1.toInt(r3)
            r1.mDrawPath = r2
            goto L_0x0085
        L_0x007f:
            java.lang.String r2 = r3.toString()
            r1.mTransitionEasing = r2
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyPosition.setValue(java.lang.String, java.lang.Object):void");
    }
}
