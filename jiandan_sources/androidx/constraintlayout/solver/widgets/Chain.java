package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

public class Chain {
    public static final boolean DEBUG = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i2) {
        ChainHead[] chainHeadArr;
        int i3;
        int i4;
        if (i2 == 0) {
            int i5 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = i5;
            i4 = 0;
        } else {
            i4 = 2;
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            ChainHead chainHead = chainHeadArr[i6];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i2, i4, chainHead);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX WARNING: type inference failed for: r4v11, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0269 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02be A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x04dd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0501  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0520 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x03a8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:327:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r36, androidx.constraintlayout.solver.LinearSystem r37, int r38, int r39, androidx.constraintlayout.solver.widgets.ChainHead r40) {
        /*
            r0 = r36
            r9 = r37
            r1 = r40
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r1.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r38 != 0) goto L_0x0038
            int r8 = r2.mHorizontalChainStyle
            if (r8 != 0) goto L_0x002b
            r8 = 1
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r14 = r2.mHorizontalChainStyle
            if (r14 != r7) goto L_0x0032
            r14 = 1
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r2.mHorizontalChainStyle
            if (r15 != r5) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r8 = r2.mVerticalChainStyle
            if (r8 != 0) goto L_0x003e
            r8 = 1
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r14 = r2.mVerticalChainStyle
            if (r14 != r7) goto L_0x0045
            r14 = 1
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r2.mVerticalChainStyle
            if (r15 != r5) goto L_0x004c
        L_0x004a:
            r5 = 1
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            r7 = r10
            r15 = r14
            r14 = r8
            r8 = 0
        L_0x0051:
            r21 = 0
            if (r8 != 0) goto L_0x0131
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r39]
            if (r5 == 0) goto L_0x005e
            r19 = 1
            goto L_0x0060
        L_0x005e:
            r19 = 4
        L_0x0060:
            int r22 = r6.getMargin()
            r23 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r7.mListDimensionBehaviors
            r3 = r3[r38]
            r24 = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r8) goto L_0x0078
            int[] r3 = r7.mResolvedMatchConstraintDefault
            r3 = r3[r38]
            if (r3 != 0) goto L_0x0078
            r3 = 1
            goto L_0x0079
        L_0x0078:
            r3 = 0
        L_0x0079:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r6.mTarget
            if (r8 == 0) goto L_0x0085
            if (r7 == r10) goto L_0x0085
            int r8 = r8.getMargin()
            int r22 = r22 + r8
        L_0x0085:
            r8 = r22
            if (r5 == 0) goto L_0x0092
            if (r7 == r10) goto L_0x0092
            if (r7 == r12) goto L_0x0092
            r22 = r15
            r19 = 5
            goto L_0x0094
        L_0x0092:
            r22 = r15
        L_0x0094:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r6.mTarget
            if (r15 == 0) goto L_0x00c6
            if (r7 != r12) goto L_0x00a7
            r25 = r14
            androidx.constraintlayout.solver.SolverVariable r14 = r6.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r26 = r2
            r2 = 6
            r9.addGreaterThan(r14, r15, r8, r2)
            goto L_0x00b4
        L_0x00a7:
            r26 = r2
            r25 = r14
            androidx.constraintlayout.solver.SolverVariable r2 = r6.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r14 = r15.mSolverVariable
            r15 = 8
            r9.addGreaterThan(r2, r14, r8, r15)
        L_0x00b4:
            if (r3 == 0) goto L_0x00ba
            if (r5 != 0) goto L_0x00ba
            r2 = 5
            goto L_0x00bc
        L_0x00ba:
            r2 = r19
        L_0x00bc:
            androidx.constraintlayout.solver.SolverVariable r3 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r9.addEquality(r3, r6, r8, r2)
            goto L_0x00ca
        L_0x00c6:
            r26 = r2
            r25 = r14
        L_0x00ca:
            if (r4 == 0) goto L_0x0100
            int r2 = r7.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00ee
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r7.mListDimensionBehaviors
            r2 = r2[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00ee
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r39 + 1
            r3 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r2 = r2[r39]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r6 = 5
            r8 = 0
            r9.addGreaterThan(r3, r2, r8, r6)
            goto L_0x00ef
        L_0x00ee:
            r8 = 0
        L_0x00ef:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            r2 = r2[r39]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r39]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 8
            r9.addGreaterThan(r2, r3, r8, r6)
        L_0x0100:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x011f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r6 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x011f
            r3 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r7) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r21 = r2
        L_0x011f:
            if (r21 == 0) goto L_0x0126
            r7 = r21
            r8 = r24
            goto L_0x0127
        L_0x0126:
            r8 = 1
        L_0x0127:
            r15 = r22
            r3 = r23
            r14 = r25
            r2 = r26
            goto L_0x0051
        L_0x0131:
            r26 = r2
            r23 = r3
            r25 = r14
            r22 = r15
            if (r13 == 0) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r6 = r6[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0159
            int[] r6 = r13.mResolvedMatchConstraintDefault
            r6 = r6[r38]
            if (r6 != 0) goto L_0x0159
            r6 = 1
            goto L_0x015a
        L_0x0159:
            r6 = 0
        L_0x015a:
            if (r6 == 0) goto L_0x0172
            if (r5 != 0) goto L_0x0172
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x0172
            androidx.constraintlayout.solver.SolverVariable r7 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r14 = 5
            r9.addEquality(r7, r6, r8, r14)
            goto L_0x0188
        L_0x0172:
            r14 = 5
            if (r5 == 0) goto L_0x0188
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x0188
            androidx.constraintlayout.solver.SolverVariable r7 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r15 = 4
            r9.addEquality(r7, r6, r8, r15)
        L_0x0188:
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r3 = r7[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r7 = 6
            r9.addLowerThan(r6, r3, r2, r7)
            goto L_0x019d
        L_0x019c:
            r14 = 5
        L_0x019d:
            if (r4 == 0) goto L_0x01b8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r39 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r4 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r2 = r3[r2]
            int r2 = r2.getMargin()
            r3 = 8
            r9.addGreaterThan(r0, r4, r2, r3)
        L_0x01b8:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x0267
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0267
            boolean r4 = r1.mHasUndefinedWeights
            if (r4 == 0) goto L_0x01cf
            boolean r4 = r1.mHasComplexMatchWeights
            if (r4 != 0) goto L_0x01cf
            int r4 = r1.mWidgetsMatchCount
            float r4 = (float) r4
            goto L_0x01d1
        L_0x01cf:
            r4 = r23
        L_0x01d1:
            r6 = 0
            r7 = r21
            r8 = 0
            r28 = 0
        L_0x01d7:
            if (r8 >= r2) goto L_0x0267
            java.lang.Object r15 = r0.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            float[] r3 = r15.mWeight
            r3 = r3[r38]
            int r18 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r18 >= 0) goto L_0x0203
            boolean r3 = r1.mHasComplexMatchWeights
            if (r3 == 0) goto L_0x01fe
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r15 = r39 + 1
            r15 = r3[r15]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r3 = r3[r39]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 0
            r14 = 4
            r9.addEquality(r15, r3, r6, r14)
            r14 = 0
            goto L_0x021a
        L_0x01fe:
            r14 = 4
            r3 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            goto L_0x0204
        L_0x0203:
            r14 = 4
        L_0x0204:
            int r18 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r18 != 0) goto L_0x021f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r15 = r39 + 1
            r15 = r3[r15]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r3 = r3[r39]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 8
            r14 = 0
            r9.addEquality(r15, r3, r14, r6)
        L_0x021a:
            r23 = r0
            r17 = r2
            goto L_0x025c
        L_0x021f:
            r14 = 0
            if (r7 == 0) goto L_0x0255
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r7 = r6[r39]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r17 = r39 + 1
            r6 = r6[r17]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r14 = r15.mListAnchors
            r23 = r0
            r0 = r14[r39]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r14 = r14[r17]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r17 = r2
            androidx.constraintlayout.solver.ArrayRow r2 = r37.createRow()
            r27 = r2
            r29 = r4
            r30 = r3
            r31 = r7
            r32 = r6
            r33 = r0
            r34 = r14
            r27.createRowEqualMatchDimensions(r28, r29, r30, r31, r32, r33, r34)
            r9.addConstraint(r2)
            goto L_0x0259
        L_0x0255:
            r23 = r0
            r17 = r2
        L_0x0259:
            r28 = r3
            r7 = r15
        L_0x025c:
            int r8 = r8 + 1
            r2 = r17
            r0 = r23
            r3 = 1
            r6 = 0
            r14 = 5
            goto L_0x01d7
        L_0x0267:
            if (r12 == 0) goto L_0x02bc
            if (r12 == r13) goto L_0x026d
            if (r5 == 0) goto L_0x02bc
        L_0x026d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            int r2 = r39 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x027f
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r3 = r0
            goto L_0x0281
        L_0x027f:
            r3 = r21
        L_0x0281:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r1.mTarget
            if (r0 == 0) goto L_0x0289
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r5 = r0
            goto L_0x028b
        L_0x0289:
            r5 = r21
        L_0x028b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r2]
            if (r3 == 0) goto L_0x04db
            if (r5 == 0) goto L_0x04db
            if (r38 != 0) goto L_0x029e
            r2 = r26
            float r2 = r2.mHorizontalBiasPercent
            goto L_0x02a2
        L_0x029e:
            r2 = r26
            float r2 = r2.mVerticalBiasPercent
        L_0x02a2:
            r4 = r2
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 7
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04db
        L_0x02bc:
            if (r25 == 0) goto L_0x03ac
            if (r12 == 0) goto L_0x03ac
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02cb
            int r1 = r1.mWidgetsCount
            if (r1 != r0) goto L_0x02cb
            r16 = 1
            goto L_0x02cd
        L_0x02cb:
            r16 = 0
        L_0x02cd:
            r14 = r12
            r15 = r14
        L_0x02cf:
            if (r14 == 0) goto L_0x04db
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r38]
            r8 = r0
        L_0x02d6:
            if (r8 == 0) goto L_0x02e5
            int r0 = r8.getVisibility()
            r6 = 8
            if (r0 != r6) goto L_0x02e7
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r8 = r0[r38]
            goto L_0x02d6
        L_0x02e5:
            r6 = 8
        L_0x02e7:
            if (r8 != 0) goto L_0x02f0
            if (r14 != r13) goto L_0x02ec
            goto L_0x02f0
        L_0x02ec:
            r17 = r8
            goto L_0x039f
        L_0x02f0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x02fd
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x02ff
        L_0x02fd:
            r2 = r21
        L_0x02ff:
            if (r15 == r14) goto L_0x030a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x031f
        L_0x030a:
            if (r14 != r12) goto L_0x031f
            if (r15 != r14) goto L_0x031f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r3 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x031d
            r2 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x031f
        L_0x031d:
            r2 = r21
        L_0x031f:
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r39 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r8 == 0) goto L_0x0341
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r39]
            androidx.constraintlayout.solver.SolverVariable r7 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r4]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r35 = r7
            r7 = r6
            r6 = r35
            goto L_0x0354
        L_0x0341:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x034c
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x034e
        L_0x034c:
            r6 = r21
        L_0x034e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
        L_0x0354:
            if (r5 == 0) goto L_0x035b
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x035b:
            if (r15 == 0) goto L_0x0366
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
        L_0x0366:
            if (r1 == 0) goto L_0x02ec
            if (r2 == 0) goto L_0x02ec
            if (r6 == 0) goto L_0x02ec
            if (r7 == 0) goto L_0x02ec
            if (r14 != r12) goto L_0x0378
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            int r0 = r0.getMargin()
        L_0x0378:
            r5 = r0
            if (r14 != r13) goto L_0x0386
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r17 = r0
            goto L_0x0388
        L_0x0386:
            r17 = r3
        L_0x0388:
            if (r16 == 0) goto L_0x038d
            r18 = 8
            goto L_0x038f
        L_0x038d:
            r18 = 5
        L_0x038f:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r3 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            r17 = r8
            r8 = r18
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x039f:
            int r0 = r14.getVisibility()
            r8 = 8
            if (r0 == r8) goto L_0x03a8
            r15 = r14
        L_0x03a8:
            r14 = r17
            goto L_0x02cf
        L_0x03ac:
            r8 = 8
            if (r22 == 0) goto L_0x04db
            if (r12 == 0) goto L_0x04db
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03bd
            int r1 = r1.mWidgetsCount
            if (r1 != r0) goto L_0x03bd
            r16 = 1
            goto L_0x03bf
        L_0x03bd:
            r16 = 0
        L_0x03bf:
            r14 = r12
            r15 = r14
        L_0x03c1:
            if (r14 == 0) goto L_0x047d
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r38]
        L_0x03c7:
            if (r0 == 0) goto L_0x03d4
            int r1 = r0.getVisibility()
            if (r1 != r8) goto L_0x03d4
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r38]
            goto L_0x03c7
        L_0x03d4:
            if (r14 == r12) goto L_0x0468
            if (r14 == r13) goto L_0x0468
            if (r0 == 0) goto L_0x0468
            if (r0 != r13) goto L_0x03df
            r7 = r21
            goto L_0x03e0
        L_0x03df:
            r7 = r0
        L_0x03e0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x03ec
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
        L_0x03ec:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x0412
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r39]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            if (r8 == 0) goto L_0x040f
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            goto L_0x0423
        L_0x040f:
            r8 = r21
            goto L_0x0423
        L_0x0412:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            r5 = r5[r39]
            if (r5 == 0) goto L_0x041b
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x041d
        L_0x041b:
            r6 = r21
        L_0x041d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r3]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
        L_0x0423:
            if (r5 == 0) goto L_0x042a
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x042a:
            r17 = r4
            if (r15 == 0) goto L_0x0437
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r15.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r0 = r0 + r3
        L_0x0437:
            r3 = r0
            if (r16 == 0) goto L_0x043d
            r18 = 8
            goto L_0x043f
        L_0x043d:
            r18 = 4
        L_0x043f:
            if (r1 == 0) goto L_0x045d
            if (r2 == 0) goto L_0x045d
            if (r6 == 0) goto L_0x045d
            if (r8 == 0) goto L_0x045d
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r5 = r6
            r19 = 4
            r6 = r8
            r20 = r7
            r7 = r17
            r17 = r15
            r15 = 8
            r8 = r18
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0465
        L_0x045d:
            r20 = r7
            r17 = r15
            r15 = 8
            r19 = 4
        L_0x0465:
            r0 = r20
            goto L_0x046e
        L_0x0468:
            r17 = r15
            r15 = 8
            r19 = 4
        L_0x046e:
            int r1 = r14.getVisibility()
            if (r1 == r15) goto L_0x0475
            goto L_0x0477
        L_0x0475:
            r14 = r17
        L_0x0477:
            r15 = r14
            r8 = 8
            r14 = r0
            goto L_0x03c1
        L_0x047d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.mListAnchors
            r1 = r1[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r39 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r2.mTarget
            if (r1 == 0) goto L_0x04ca
            if (r12 == r13) goto L_0x04a4
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r15 = 5
            r9.addEquality(r2, r1, r0, r15)
            goto L_0x04cb
        L_0x04a4:
            r15 = 5
            if (r14 == 0) goto L_0x04cb
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r14.mSolverVariable
            int r8 = r10.getMargin()
            r16 = 5
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04cb
        L_0x04ca:
            r15 = 5
        L_0x04cb:
            if (r14 == 0) goto L_0x04db
            if (r12 == r13) goto L_0x04db
            androidx.constraintlayout.solver.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r14.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r15)
        L_0x04db:
            if (r25 != 0) goto L_0x04df
            if (r22 == 0) goto L_0x0543
        L_0x04df:
            if (r12 == 0) goto L_0x0543
            if (r12 == r13) goto L_0x0543
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r39 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x04f4
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x04f6
        L_0x04f4:
            r3 = r21
        L_0x04f6:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04fd
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x04ff
        L_0x04fd:
            r4 = r21
        L_0x04ff:
            if (r11 == r13) goto L_0x0510
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x050d
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r21 = r4
        L_0x050d:
            r5 = r21
            goto L_0x0511
        L_0x0510:
            r5 = r4
        L_0x0511:
            if (r12 != r13) goto L_0x051e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r1 = r0[r39]
            r0 = r0[r2]
            r35 = r1
            r1 = r0
            r0 = r35
        L_0x051e:
            if (r3 == 0) goto L_0x0543
            if (r5 == 0) goto L_0x0543
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.getMargin()
            if (r13 != 0) goto L_0x052b
            goto L_0x052c
        L_0x052b:
            r11 = r13
        L_0x052c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r2 = r7[r2]
            int r7 = r2.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0543:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
