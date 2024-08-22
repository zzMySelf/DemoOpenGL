package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    public static final String NAME = "KeyTrigger";
    public static final String TAG = "KeyTrigger";
    public RectF mCollisionRect;
    public String mCross = null;
    public int mCurveFit = -1;
    public Method mFireCross;
    public boolean mFireCrossReset;
    public float mFireLastPos;
    public Method mFireNegativeCross;
    public boolean mFireNegativeReset;
    public Method mFirePositiveCross;
    public boolean mFirePositiveReset;
    public float mFireThreshold;
    public String mNegativeCross;
    public String mPositiveCross;
    public boolean mPostLayout;
    public RectF mTargetRect;
    public int mTriggerCollisionId;
    public View mTriggerCollisionView;
    public int mTriggerID;
    public int mTriggerReceiver;
    public float mTriggerSlack;

    public static class Loader {
        public static final int COLLISION = 9;
        public static final int CROSS = 4;
        public static final int FRAME_POS = 8;
        public static final int NEGATIVE_CROSS = 1;
        public static final int POSITIVE_CROSS = 2;
        public static final int POST_LAYOUT = 10;
        public static final int TARGET_ID = 7;
        public static final int TRIGGER_ID = 6;
        public static final int TRIGGER_RECEIVER = 11;
        public static final int TRIGGER_SLACK = 5;
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (mAttrMap.get(index)) {
                    case 1:
                        String unused = keyTrigger.mNegativeCross = typedArray.getString(index);
                        continue;
                    case 2:
                        String unused2 = keyTrigger.mPositiveCross = typedArray.getString(index);
                        continue;
                    case 4:
                        String unused3 = keyTrigger.mCross = typedArray.getString(index);
                        continue;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        continue;
                    case 6:
                        int unused4 = keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        continue;
                    case 7:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                                break;
                            } else {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            keyTrigger.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                continue;
                            }
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFramePosition = integer;
                        float unused5 = keyTrigger.mFireThreshold = (((float) integer) + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        int unused6 = keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        continue;
                    case 10:
                        boolean unused7 = keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        continue;
                    case 11:
                        int unused8 = keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                }
                "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index);
            }
        }
    }

    public KeyTrigger() {
        int i2 = Key.UNSET;
        this.mTriggerReceiver = i2;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i2;
        this.mTriggerCollisionId = i2;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    private void setUpRect(RectF rectF, View view, boolean z) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0118 A[SYNTHETIC, Splitter:B:73:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0189 A[SYNTHETIC, Splitter:B:86:0x0189] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void conditionallyFire(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.mTriggerCollisionId
            int r1 = androidx.constraintlayout.motion.widget.Key.UNSET
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0062
            android.view.View r0 = r9.mTriggerCollisionView
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r9.mTriggerCollisionId
            android.view.View r0 = r0.findViewById(r1)
            r9.mTriggerCollisionView = r0
        L_0x001a:
            android.graphics.RectF r0 = r9.mCollisionRect
            android.view.View r1 = r9.mTriggerCollisionView
            boolean r4 = r9.mPostLayout
            r9.setUpRect(r0, r1, r4)
            android.graphics.RectF r0 = r9.mTargetRect
            boolean r1 = r9.mPostLayout
            r9.setUpRect(r0, r11, r1)
            android.graphics.RectF r0 = r9.mCollisionRect
            android.graphics.RectF r1 = r9.mTargetRect
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r9.mFireCrossReset
            if (r0 == 0) goto L_0x003c
            r9.mFireCrossReset = r3
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            boolean r1 = r9.mFirePositiveReset
            if (r1 == 0) goto L_0x0045
            r9.mFirePositiveReset = r3
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            r9.mFireNegativeReset = r2
            r2 = r1
            r1 = 0
            goto L_0x00e0
        L_0x004c:
            boolean r0 = r9.mFireCrossReset
            if (r0 != 0) goto L_0x0054
            r9.mFireCrossReset = r2
            r0 = 1
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            boolean r1 = r9.mFireNegativeReset
            if (r1 == 0) goto L_0x005d
            r9.mFireNegativeReset = r3
            r1 = 1
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            r9.mFirePositiveReset = r2
            goto L_0x00df
        L_0x0062:
            boolean r0 = r9.mFireCrossReset
            r1 = 0
            if (r0 == 0) goto L_0x0078
            float r0 = r9.mFireThreshold
            float r4 = r10 - r0
            float r5 = r9.mFireLastPos
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0088
            r9.mFireCrossReset = r3
            r0 = 1
            goto L_0x0089
        L_0x0078:
            float r0 = r9.mFireThreshold
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r9.mTriggerSlack
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            r9.mFireCrossReset = r2
        L_0x0088:
            r0 = 0
        L_0x0089:
            boolean r4 = r9.mFireNegativeReset
            if (r4 == 0) goto L_0x00a2
            float r4 = r9.mFireThreshold
            float r5 = r10 - r4
            float r6 = r9.mFireLastPos
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            r9.mFireNegativeReset = r3
            r4 = 1
            goto L_0x00b3
        L_0x00a2:
            float r4 = r9.mFireThreshold
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r9.mTriggerSlack
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b2
            r9.mFireNegativeReset = r2
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            boolean r5 = r9.mFirePositiveReset
            if (r5 == 0) goto L_0x00ce
            float r5 = r9.mFireThreshold
            float r6 = r10 - r5
            float r7 = r9.mFireLastPos
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00cb
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cb
            r9.mFirePositiveReset = r3
            goto L_0x00cc
        L_0x00cb:
            r2 = 0
        L_0x00cc:
            r1 = r4
            goto L_0x00e0
        L_0x00ce:
            float r1 = r9.mFireThreshold
            float r1 = r10 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r9.mTriggerSlack
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00de
            r9.mFirePositiveReset = r2
        L_0x00de:
            r1 = r4
        L_0x00df:
            r2 = 0
        L_0x00e0:
            r9.mFireLastPos = r10
            if (r1 != 0) goto L_0x00e8
            if (r0 != 0) goto L_0x00e8
            if (r2 == 0) goto L_0x00f3
        L_0x00e8:
            android.view.ViewParent r4 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r4 = (androidx.constraintlayout.motion.widget.MotionLayout) r4
            int r5 = r9.mTriggerID
            r4.fireTrigger(r5, r2, r10)
        L_0x00f3:
            int r10 = r9.mTriggerReceiver
            int r4 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r10 != r4) goto L_0x00fa
            goto L_0x0106
        L_0x00fa:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r11 = r9.mTriggerReceiver
            android.view.View r11 = r10.findViewById(r11)
        L_0x0106:
            java.lang.String r10 = "Could not find method \""
            java.lang.String r4 = "Exception in call \""
            java.lang.String r5 = " "
            java.lang.String r6 = "\"on class "
            if (r1 == 0) goto L_0x017f
            java.lang.String r1 = r9.mNegativeCross
            if (r1 == 0) goto L_0x017f
            java.lang.reflect.Method r1 = r9.mFireNegativeCross
            if (r1 != 0) goto L_0x014f
            java.lang.Class r1 = r11.getClass()     // Catch:{ NoSuchMethodException -> 0x0127 }
            java.lang.String r7 = r9.mNegativeCross     // Catch:{ NoSuchMethodException -> 0x0127 }
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0127 }
            java.lang.reflect.Method r1 = r1.getMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0127 }
            r9.mFireNegativeCross = r1     // Catch:{ NoSuchMethodException -> 0x0127 }
            goto L_0x014f
        L_0x0127:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r7 = r9.mNegativeCross
            r1.append(r7)
            r1.append(r6)
            java.lang.Class r7 = r11.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r1.append(r7)
            r1.append(r5)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.Debug.getName(r11)
            r1.append(r7)
            r1.toString()
        L_0x014f:
            java.lang.reflect.Method r1 = r9.mFireNegativeCross     // Catch:{ Exception -> 0x0157 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0157 }
            r1.invoke(r11, r7)     // Catch:{ Exception -> 0x0157 }
            goto L_0x017f
        L_0x0157:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r7 = r9.mNegativeCross
            r1.append(r7)
            r1.append(r6)
            java.lang.Class r7 = r11.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r1.append(r7)
            r1.append(r5)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.Debug.getName(r11)
            r1.append(r7)
            r1.toString()
        L_0x017f:
            if (r2 == 0) goto L_0x01f0
            java.lang.String r1 = r9.mPositiveCross
            if (r1 == 0) goto L_0x01f0
            java.lang.reflect.Method r1 = r9.mFirePositiveCross
            if (r1 != 0) goto L_0x01c0
            java.lang.Class r1 = r11.getClass()     // Catch:{ NoSuchMethodException -> 0x0198 }
            java.lang.String r2 = r9.mPositiveCross     // Catch:{ NoSuchMethodException -> 0x0198 }
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0198 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r7)     // Catch:{ NoSuchMethodException -> 0x0198 }
            r9.mFirePositiveCross = r1     // Catch:{ NoSuchMethodException -> 0x0198 }
            goto L_0x01c0
        L_0x0198:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r2 = r9.mPositiveCross
            r1.append(r2)
            r1.append(r6)
            java.lang.Class r2 = r11.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getName(r11)
            r1.append(r2)
            r1.toString()
        L_0x01c0:
            java.lang.reflect.Method r1 = r9.mFirePositiveCross     // Catch:{ Exception -> 0x01c8 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01c8 }
            r1.invoke(r11, r2)     // Catch:{ Exception -> 0x01c8 }
            goto L_0x01f0
        L_0x01c8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r9.mPositiveCross
            r1.append(r2)
            r1.append(r6)
            java.lang.Class r2 = r11.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getName(r11)
            r1.append(r2)
            r1.toString()
        L_0x01f0:
            if (r0 == 0) goto L_0x0261
            java.lang.String r0 = r9.mCross
            if (r0 == 0) goto L_0x0261
            java.lang.reflect.Method r0 = r9.mFireCross
            if (r0 != 0) goto L_0x0231
            java.lang.Class r0 = r11.getClass()     // Catch:{ NoSuchMethodException -> 0x0209 }
            java.lang.String r1 = r9.mCross     // Catch:{ NoSuchMethodException -> 0x0209 }
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0209 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0209 }
            r9.mFireCross = r0     // Catch:{ NoSuchMethodException -> 0x0209 }
            goto L_0x0231
        L_0x0209:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = r9.mCross
            r0.append(r10)
            r0.append(r6)
            java.lang.Class r10 = r11.getClass()
            java.lang.String r10 = r10.getSimpleName()
            r0.append(r10)
            r0.append(r5)
            java.lang.String r10 = androidx.constraintlayout.motion.widget.Debug.getName(r11)
            r0.append(r10)
            r0.toString()
        L_0x0231:
            java.lang.reflect.Method r10 = r9.mFireCross     // Catch:{ Exception -> 0x0239 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0239 }
            r10.invoke(r11, r0)     // Catch:{ Exception -> 0x0239 }
            goto L_0x0261
        L_0x0239:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            java.lang.String r0 = r9.mCross
            r10.append(r0)
            r10.append(r6)
            java.lang.Class r0 = r11.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            r10.append(r5)
            java.lang.String r11 = androidx.constraintlayout.motion.widget.Debug.getName(r11)
            r10.append(r11)
            r10.toString()
        L_0x0261:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.conditionallyFire(float, android.view.View):void");
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    public void setValue(String str, Object obj) {
    }
}
