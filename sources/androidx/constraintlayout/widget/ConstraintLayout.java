package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.4";
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    protected ConstraintLayoutStates mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    /* access modifiers changed from: protected */
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    Measurer mMeasurer = new Measurer(this);
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    /* access modifiers changed from: private */
    public int mOptimizationLevel = 257;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    public void setDesignInformation(int type, Object value1, Object value2) {
        if (type == 0 && (value1 instanceof String) && (value2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String name = (String) value1;
            int index = name.indexOf("/");
            if (index != -1) {
                name = name.substring(index + 1);
            }
            this.mDesignIds.put(name, Integer.valueOf(((Integer) value2).intValue()));
        }
    }

    public Object getDesignInformation(int type, Object value) {
        if (type != 0 || !(value instanceof String)) {
            return null;
        }
        String name = (String) value;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(name)) {
            return null;
        }
        return this.mDesignIds.get(name);
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr, defStyleRes);
    }

    public void setId(int id) {
        this.mChildrenByIds.remove(getId());
        super.setId(id);
        this.mChildrenByIds.put(getId(), this);
    }

    class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;

        public void captureLayoutInfos(int widthSpec, int heightSpec, int top, int bottom, int width, int height) {
            this.paddingTop = top;
            this.paddingBottom = bottom;
            this.paddingWidth = width;
            this.paddingHeight = height;
            this.layoutWidthSpec = widthSpec;
            this.layoutHeightSpec = heightSpec;
        }

        public Measurer(ConstraintLayout l) {
            this.layout = l;
        }

        /* JADX WARNING: Removed duplicated region for block: B:127:0x01f4  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x01fe  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x0203 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x0204  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void measure(androidx.constraintlayout.solver.widgets.ConstraintWidget r29, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure r30) {
            /*
                r28 = this;
                r0 = r28
                r1 = r29
                r2 = r30
                if (r1 != 0) goto L_0x0009
                return
            L_0x0009:
                int r3 = r29.getVisibility()
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x001f
                boolean r3 = r29.isInPlaceholder()
                if (r3 != 0) goto L_0x001f
                r2.measuredWidth = r5
                r2.measuredHeight = r5
                r2.measuredBaseline = r5
                return
            L_0x001f:
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r29.getParent()
                if (r3 != 0) goto L_0x0026
                return
            L_0x0026:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.horizontalBehavior
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r2.verticalBehavior
                int r6 = r2.horizontalDimension
                int r7 = r2.verticalDimension
                r8 = 0
                r9 = 0
                int r10 = r0.paddingTop
                int r11 = r0.paddingBottom
                int r10 = r10 + r11
                int r11 = r0.paddingWidth
                java.lang.Object r12 = r29.getCompanionWidget()
                android.view.View r12 = (android.view.View) r12
                int[] r13 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour
                int r14 = r3.ordinal()
                r13 = r13[r14]
                r15 = -2
                r14 = 1
                switch(r13) {
                    case 1: goto L_0x00b3;
                    case 2: goto L_0x00ab;
                    case 3: goto L_0x009e;
                    case 4: goto L_0x004c;
                    default: goto L_0x004a;
                }
            L_0x004a:
                goto L_0x00ba
            L_0x004c:
                int r13 = r0.layoutWidthSpec
                int r8 = android.view.ViewGroup.getChildMeasureSpec(r13, r11, r15)
                int r13 = r1.mMatchConstraintDefaultWidth
                if (r13 != r14) goto L_0x0058
                r13 = r14
                goto L_0x0059
            L_0x0058:
                r13 = 0
            L_0x0059:
                int r14 = r2.measureStrategy
                int r15 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS
                if (r14 == r15) goto L_0x0065
                int r14 = r2.measureStrategy
                int r15 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r14 != r15) goto L_0x00ba
            L_0x0065:
                int r14 = r12.getMeasuredHeight()
                int r15 = r29.getHeight()
                if (r14 != r15) goto L_0x0071
                r14 = 1
                goto L_0x0072
            L_0x0071:
                r14 = 0
            L_0x0072:
                int r15 = r2.measureStrategy
                int r5 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r15 == r5) goto L_0x008b
                if (r13 == 0) goto L_0x008b
                if (r13 == 0) goto L_0x007e
                if (r14 != 0) goto L_0x008b
            L_0x007e:
                boolean r5 = r12 instanceof androidx.constraintlayout.widget.Placeholder
                if (r5 != 0) goto L_0x008b
                boolean r5 = r29.isResolvedHorizontally()
                if (r5 == 0) goto L_0x0089
                goto L_0x008b
            L_0x0089:
                r5 = 0
                goto L_0x008c
            L_0x008b:
                r5 = 1
            L_0x008c:
                if (r5 == 0) goto L_0x009b
                int r15 = r29.getWidth()
                r17 = r5
                r5 = 1073741824(0x40000000, float:2.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
                goto L_0x00ba
            L_0x009b:
                r17 = r5
                goto L_0x00ba
            L_0x009e:
                int r5 = r0.layoutWidthSpec
                int r13 = r29.getHorizontalMargin()
                int r13 = r13 + r11
                r14 = -1
                int r8 = android.view.ViewGroup.getChildMeasureSpec(r5, r13, r14)
                goto L_0x00ba
            L_0x00ab:
                int r5 = r0.layoutWidthSpec
                r13 = -2
                int r8 = android.view.ViewGroup.getChildMeasureSpec(r5, r11, r13)
                goto L_0x00ba
            L_0x00b3:
                r5 = 1073741824(0x40000000, float:2.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r5)
            L_0x00ba:
                int[] r5 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour
                int r13 = r4.ordinal()
                r5 = r5[r13]
                switch(r5) {
                    case 1: goto L_0x0130;
                    case 2: goto L_0x0128;
                    case 3: goto L_0x011b;
                    case 4: goto L_0x00c7;
                    default: goto L_0x00c5;
                }
            L_0x00c5:
                goto L_0x0137
            L_0x00c7:
                int r5 = r0.layoutHeightSpec
                r13 = -2
                int r9 = android.view.ViewGroup.getChildMeasureSpec(r5, r10, r13)
                int r5 = r1.mMatchConstraintDefaultHeight
                r13 = 1
                if (r5 != r13) goto L_0x00d5
                r5 = 1
                goto L_0x00d6
            L_0x00d5:
                r5 = 0
            L_0x00d6:
                int r13 = r2.measureStrategy
                int r14 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS
                if (r13 == r14) goto L_0x00e2
                int r13 = r2.measureStrategy
                int r14 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r13 != r14) goto L_0x0137
            L_0x00e2:
                int r13 = r12.getMeasuredWidth()
                int r14 = r29.getWidth()
                if (r13 != r14) goto L_0x00ee
                r13 = 1
                goto L_0x00ef
            L_0x00ee:
                r13 = 0
            L_0x00ef:
                int r14 = r2.measureStrategy
                int r15 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r14 == r15) goto L_0x0108
                if (r5 == 0) goto L_0x0108
                if (r5 == 0) goto L_0x00fb
                if (r13 != 0) goto L_0x0108
            L_0x00fb:
                boolean r14 = r12 instanceof androidx.constraintlayout.widget.Placeholder
                if (r14 != 0) goto L_0x0108
                boolean r14 = r29.isResolvedVertically()
                if (r14 == 0) goto L_0x0106
                goto L_0x0108
            L_0x0106:
                r14 = 0
                goto L_0x0109
            L_0x0108:
                r14 = 1
            L_0x0109:
                if (r14 == 0) goto L_0x0118
                int r15 = r29.getHeight()
                r16 = r5
                r5 = 1073741824(0x40000000, float:2.0)
                int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
                goto L_0x0137
            L_0x0118:
                r16 = r5
                goto L_0x0137
            L_0x011b:
                int r5 = r0.layoutHeightSpec
                int r13 = r29.getVerticalMargin()
                int r13 = r13 + r10
                r14 = -1
                int r9 = android.view.ViewGroup.getChildMeasureSpec(r5, r13, r14)
                goto L_0x0137
            L_0x0128:
                int r5 = r0.layoutHeightSpec
                r13 = -2
                int r9 = android.view.ViewGroup.getChildMeasureSpec(r5, r10, r13)
                goto L_0x0137
            L_0x0130:
                r5 = 1073741824(0x40000000, float:2.0)
                int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
            L_0x0137:
                androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r29.getParent()
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r5 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r5
                if (r5 == 0) goto L_0x01b9
                androidx.constraintlayout.widget.ConstraintLayout r13 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r13 = r13.mOptimizationLevel
                r14 = 256(0x100, float:3.59E-43)
                boolean r13 = androidx.constraintlayout.solver.widgets.Optimizer.enabled(r13, r14)
                if (r13 == 0) goto L_0x01b9
                int r13 = r12.getMeasuredWidth()
                int r14 = r29.getWidth()
                if (r13 != r14) goto L_0x01b9
                int r13 = r12.getMeasuredWidth()
                int r14 = r5.getWidth()
                if (r13 >= r14) goto L_0x01b9
                int r13 = r12.getMeasuredHeight()
                int r14 = r29.getHeight()
                if (r13 != r14) goto L_0x01b9
                int r13 = r12.getMeasuredHeight()
                int r14 = r5.getHeight()
                if (r13 >= r14) goto L_0x01b9
                int r13 = r12.getBaseline()
                int r14 = r29.getBaselineDistance()
                if (r13 != r14) goto L_0x01b9
                boolean r13 = r29.isMeasureRequested()
                if (r13 != 0) goto L_0x01b9
                int r13 = r29.getLastHorizontalMeasureSpec()
                int r14 = r29.getWidth()
                boolean r13 = r0.isSimilarSpec(r13, r8, r14)
                if (r13 == 0) goto L_0x01a3
                int r13 = r29.getLastVerticalMeasureSpec()
                int r14 = r29.getHeight()
                boolean r13 = r0.isSimilarSpec(r13, r9, r14)
                if (r13 == 0) goto L_0x01a3
                r13 = 1
                goto L_0x01a4
            L_0x01a3:
                r13 = 0
            L_0x01a4:
                if (r13 == 0) goto L_0x01b9
                int r14 = r29.getWidth()
                r2.measuredWidth = r14
                int r14 = r29.getHeight()
                r2.measuredHeight = r14
                int r14 = r29.getBaselineDistance()
                r2.measuredBaseline = r14
                return
            L_0x01b9:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r3 != r13) goto L_0x01bf
                r13 = 1
                goto L_0x01c0
            L_0x01bf:
                r13 = 0
            L_0x01c0:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r4 != r14) goto L_0x01c6
                r14 = 1
                goto L_0x01c7
            L_0x01c6:
                r14 = 0
            L_0x01c7:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r4 == r15) goto L_0x01d2
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r4 != r15) goto L_0x01d0
                goto L_0x01d2
            L_0x01d0:
                r15 = 0
                goto L_0x01d3
            L_0x01d2:
                r15 = 1
            L_0x01d3:
                r16 = r4
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r3 == r4) goto L_0x01e0
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r3 != r4) goto L_0x01de
                goto L_0x01e0
            L_0x01de:
                r4 = 0
                goto L_0x01e1
            L_0x01e0:
                r4 = 1
            L_0x01e1:
                r17 = 0
                if (r13 == 0) goto L_0x01ef
                r18 = r3
                float r3 = r1.mDimensionRatio
                int r3 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
                if (r3 <= 0) goto L_0x01f1
                r3 = 1
                goto L_0x01f2
            L_0x01ef:
                r18 = r3
            L_0x01f1:
                r3 = 0
            L_0x01f2:
                if (r14 == 0) goto L_0x01fe
                r19 = r5
                float r5 = r1.mDimensionRatio
                int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
                if (r5 <= 0) goto L_0x0200
                r5 = 1
                goto L_0x0201
            L_0x01fe:
                r19 = r5
            L_0x0200:
                r5 = 0
            L_0x0201:
                if (r12 != 0) goto L_0x0204
                return
            L_0x0204:
                android.view.ViewGroup$LayoutParams r17 = r12.getLayoutParams()
                r20 = r6
                r6 = r17
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r6 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6
                r17 = 0
                r21 = 0
                r22 = 0
                r23 = r7
                int r7 = r2.measureStrategy
                r24 = r10
                int r10 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS
                if (r7 == r10) goto L_0x023d
                int r7 = r2.measureStrategy
                int r10 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS
                if (r7 == r10) goto L_0x023d
                if (r13 == 0) goto L_0x023d
                int r7 = r1.mMatchConstraintDefaultWidth
                if (r7 != 0) goto L_0x023d
                if (r14 == 0) goto L_0x023d
                int r7 = r1.mMatchConstraintDefaultHeight
                if (r7 == 0) goto L_0x0231
                goto L_0x023d
            L_0x0231:
                r27 = r3
                r25 = r11
                r0 = r17
                r11 = r21
                r3 = r22
                goto L_0x0313
            L_0x023d:
                boolean r7 = r12 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r7 == 0) goto L_0x024f
                boolean r7 = r1 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout
                if (r7 == 0) goto L_0x024f
                r7 = r1
                androidx.constraintlayout.solver.widgets.VirtualLayout r7 = (androidx.constraintlayout.solver.widgets.VirtualLayout) r7
                r10 = r12
                androidx.constraintlayout.widget.VirtualLayout r10 = (androidx.constraintlayout.widget.VirtualLayout) r10
                r10.onMeasure(r7, r8, r9)
                goto L_0x0252
            L_0x024f:
                r12.measure(r8, r9)
            L_0x0252:
                r1.setLastMeasureSpec(r8, r9)
                int r7 = r12.getMeasuredWidth()
                int r10 = r12.getMeasuredHeight()
                int r22 = r12.getBaseline()
                r25 = r7
                r17 = r10
                r21 = r8
                int r8 = r1.mMatchConstraintMinWidth
                if (r8 <= 0) goto L_0x0278
                int r8 = r1.mMatchConstraintMinWidth
                r26 = r9
                r9 = r25
                int r25 = java.lang.Math.max(r8, r9)
                r9 = r25
                goto L_0x027c
            L_0x0278:
                r26 = r9
                r9 = r25
            L_0x027c:
                int r8 = r1.mMatchConstraintMaxWidth
                if (r8 <= 0) goto L_0x0286
                int r8 = r1.mMatchConstraintMaxWidth
                int r9 = java.lang.Math.min(r8, r9)
            L_0x0286:
                int r8 = r1.mMatchConstraintMinHeight
                if (r8 <= 0) goto L_0x0297
                int r8 = r1.mMatchConstraintMinHeight
                r25 = r11
                r11 = r17
                int r17 = java.lang.Math.max(r8, r11)
                r11 = r17
                goto L_0x029b
            L_0x0297:
                r25 = r11
                r11 = r17
            L_0x029b:
                int r8 = r1.mMatchConstraintMaxHeight
                if (r8 <= 0) goto L_0x02a5
                int r8 = r1.mMatchConstraintMaxHeight
                int r11 = java.lang.Math.min(r8, r11)
            L_0x02a5:
                androidx.constraintlayout.widget.ConstraintLayout r8 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r8 = r8.mOptimizationLevel
                r0 = 1
                boolean r8 = androidx.constraintlayout.solver.widgets.Optimizer.enabled(r8, r0)
                if (r8 != 0) goto L_0x02d4
                if (r3 == 0) goto L_0x02c3
                if (r15 == 0) goto L_0x02c3
                float r0 = r1.mDimensionRatio
                r27 = r3
                float r3 = (float) r11
                float r3 = r3 * r0
                r17 = 1056964608(0x3f000000, float:0.5)
                float r3 = r3 + r17
                int r0 = (int) r3
                r9 = r0
                goto L_0x02d6
            L_0x02c3:
                r27 = r3
                if (r5 == 0) goto L_0x02d6
                if (r4 == 0) goto L_0x02d6
                float r0 = r1.mDimensionRatio
                float r3 = (float) r9
                float r3 = r3 / r0
                r17 = 1056964608(0x3f000000, float:0.5)
                float r3 = r3 + r17
                int r3 = (int) r3
                r11 = r3
                goto L_0x02d6
            L_0x02d4:
                r27 = r3
            L_0x02d6:
                if (r7 != r9) goto L_0x02e3
                if (r10 == r11) goto L_0x02db
                goto L_0x02e3
            L_0x02db:
                r0 = r9
                r8 = r21
                r3 = r22
                r9 = r26
                goto L_0x0313
            L_0x02e3:
                if (r7 == r9) goto L_0x02ec
                r0 = 1073741824(0x40000000, float:2.0)
                int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r0)
                goto L_0x02f0
            L_0x02ec:
                r0 = 1073741824(0x40000000, float:2.0)
                r3 = r21
            L_0x02f0:
                if (r10 == r11) goto L_0x02f7
                int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
                goto L_0x02f9
            L_0x02f7:
                r0 = r26
            L_0x02f9:
                r12.measure(r3, r0)
                r1.setLastMeasureSpec(r3, r0)
                int r17 = r12.getMeasuredWidth()
                int r21 = r12.getMeasuredHeight()
                int r22 = r12.getBaseline()
                r9 = r0
                r8 = r3
                r0 = r17
                r11 = r21
                r3 = r22
            L_0x0313:
                r7 = -1
                if (r3 == r7) goto L_0x0318
                r7 = 1
                goto L_0x0319
            L_0x0318:
                r7 = 0
            L_0x0319:
                int r10 = r2.horizontalDimension
                if (r0 != r10) goto L_0x0324
                int r10 = r2.verticalDimension
                if (r11 == r10) goto L_0x0322
                goto L_0x0324
            L_0x0322:
                r10 = 0
                goto L_0x0325
            L_0x0324:
                r10 = 1
            L_0x0325:
                r2.measuredNeedsSolverPass = r10
                boolean r10 = r6.needsBaseline
                if (r10 == 0) goto L_0x032c
                r7 = 1
            L_0x032c:
                if (r7 == 0) goto L_0x033a
                r10 = -1
                if (r3 == r10) goto L_0x033a
                int r10 = r29.getBaselineDistance()
                if (r10 == r3) goto L_0x033a
                r10 = 1
                r2.measuredNeedsSolverPass = r10
            L_0x033a:
                r2.measuredWidth = r0
                r2.measuredHeight = r11
                r2.measuredHasBaseline = r7
                r2.measuredBaseline = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.Measurer.measure(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure):void");
        }

        private boolean isSimilarSpec(int lastMeasureSpec, int spec, int widgetSize) {
            if (lastMeasureSpec == spec) {
                return true;
            }
            int lastMode = View.MeasureSpec.getMode(lastMeasureSpec);
            int size = View.MeasureSpec.getSize(lastMeasureSpec);
            int mode = View.MeasureSpec.getMode(spec);
            int size2 = View.MeasureSpec.getSize(spec);
            if (mode != 1073741824) {
                return false;
            }
            if ((lastMode == Integer.MIN_VALUE || lastMode == 0) && widgetSize == size2) {
                return true;
            }
            return false;
        }

        public final void didMeasures() {
            int widgetsCount = this.layout.getChildCount();
            for (int i2 = 0; i2 < widgetsCount; i2++) {
                View child = this.layout.getChildAt(i2);
                if (child instanceof Placeholder) {
                    ((Placeholder) child).updatePostMeasure(this.layout);
                }
            }
            int helperCount = this.layout.mConstraintHelpers.size();
            if (helperCount > 0) {
                for (int i3 = 0; i3 < helperCount; i3++) {
                    ((ConstraintHelper) this.layout.mConstraintHelpers.get(i3)).updatePostMeasure(this.layout);
                }
            }
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attrs != null) {
            TypedArray a2 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout, defStyleAttr, defStyleRes);
            int N = a2.getIndexCount();
            for (int i2 = 0; i2 < N; i2++) {
                int attr = a2.getIndex(i2);
                if (attr == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = a2.getDimensionPixelOffset(attr, this.mMinWidth);
                } else if (attr == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = a2.getDimensionPixelOffset(attr, this.mMinHeight);
                } else if (attr == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = a2.getDimensionPixelOffset(attr, this.mMaxWidth);
                } else if (attr == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = a2.getDimensionPixelOffset(attr, this.mMaxHeight);
                } else if (attr == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = a2.getInt(attr, this.mOptimizationLevel);
                } else if (attr == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int id = a2.getResourceId(attr, 0);
                    if (id != 0) {
                        try {
                            parseLayoutDescription(id);
                        } catch (Resources.NotFoundException e2) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (attr == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int id2 = a2.getResourceId(attr, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), id2);
                    } catch (Resources.NotFoundException e3) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = id2;
                }
            }
            a2.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int id) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, id);
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(child);
        }
    }

    public void removeView(View view2) {
        super.removeView(view2);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view2);
        }
    }

    public void onViewAdded(View view2) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view2);
        }
        ConstraintWidget widget = getViewWidget(view2);
        if ((view2 instanceof Guideline) && !(widget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            layoutParams.widget = new Guideline();
            layoutParams.isGuideline = true;
            ((Guideline) layoutParams.widget).setOrientation(layoutParams.orientation);
        }
        if (view2 instanceof ConstraintHelper) {
            ConstraintHelper helper = (ConstraintHelper) view2;
            helper.validateParams();
            ((LayoutParams) view2.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(helper)) {
                this.mConstraintHelpers.add(helper);
            }
        }
        this.mChildrenByIds.put(view2.getId(), view2);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view2) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view2);
        }
        this.mChildrenByIds.remove(view2.getId());
        this.mLayoutWidget.remove(getViewWidget(view2));
        this.mConstraintHelpers.remove(view2);
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int value) {
        if (value != this.mMinWidth) {
            this.mMinWidth = value;
            requestLayout();
        }
    }

    public void setMinHeight(int value) {
        if (value != this.mMinHeight) {
            this.mMinHeight = value;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int value) {
        if (value != this.mMaxWidth) {
            this.mMaxWidth = value;
            requestLayout();
        }
    }

    public void setMaxHeight(int value) {
        if (value != this.mMaxHeight) {
            this.mMaxHeight = value;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private boolean updateHierarchy() {
        int count = getChildCount();
        boolean recompute = false;
        int i2 = 0;
        while (true) {
            if (i2 >= count) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                recompute = true;
                break;
            } else {
                i2++;
            }
        }
        if (recompute) {
            setChildrenConstraints();
        }
        return recompute;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            ConstraintWidget widget = getViewWidget(getChildAt(i2));
            if (widget != null) {
                widget.reset();
            }
        }
        if (isInEditMode) {
            for (int i3 = 0; i3 < count; i3++) {
                View view2 = getChildAt(i3);
                try {
                    String IdAsString = getResources().getResourceName(view2.getId());
                    setDesignInformation(0, IdAsString, Integer.valueOf(view2.getId()));
                    int slashIndex = IdAsString.indexOf(47);
                    if (slashIndex != -1) {
                        IdAsString = IdAsString.substring(slashIndex + 1);
                    }
                    getTargetWidget(view2.getId()).setDebugName(IdAsString);
                } catch (Resources.NotFoundException e2) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i4 = 0; i4 < count; i4++) {
                View child = getChildAt(i4);
                if (child.getId() == this.mConstraintSetId && (child instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) child).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        int helperCount = this.mConstraintHelpers.size();
        if (helperCount > 0) {
            for (int i5 = 0; i5 < helperCount; i5++) {
                this.mConstraintHelpers.get(i5).updatePreLayout(this);
            }
        }
        for (int i6 = 0; i6 < count; i6++) {
            View child2 = getChildAt(i6);
            if (child2 instanceof Placeholder) {
                ((Placeholder) child2).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i7 = 0; i7 < count; i7++) {
            View child3 = getChildAt(i7);
            this.mTempMapIdToWidget.put(child3.getId(), getViewWidget(child3));
        }
        for (int i8 = 0; i8 < count; i8++) {
            View child4 = getChildAt(i8);
            ConstraintWidget widget2 = getViewWidget(child4);
            if (widget2 != null) {
                this.mLayoutWidget.add(widget2);
                applyConstraintsFromLayoutParams(isInEditMode, child4, widget2, (LayoutParams) child4.getLayoutParams(), this.mTempMapIdToWidget);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void applyConstraintsFromLayoutParams(boolean r22, android.view.View r23, androidx.constraintlayout.solver.widgets.ConstraintWidget r24, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r25, android.util.SparseArray<androidx.constraintlayout.solver.widgets.ConstraintWidget> r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r25.validate()
            r11 = 0
            r9.helped = r11
            int r2 = r23.getVisibility()
            r8.setVisibility(r2)
            boolean r2 = r9.isInPlaceholder
            r12 = 1
            if (r2 == 0) goto L_0x0024
            r8.setInPlaceholder(r12)
            r2 = 8
            r8.setVisibility(r2)
        L_0x0024:
            r8.setCompanionWidget(r1)
            boolean r2 = r1 instanceof androidx.constraintlayout.widget.ConstraintHelper
            if (r2 == 0) goto L_0x0037
            r2 = r1
            androidx.constraintlayout.widget.ConstraintHelper r2 = (androidx.constraintlayout.widget.ConstraintHelper) r2
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.isRtl()
            r2.resolveRtl(r8, r3)
        L_0x0037:
            boolean r2 = r9.isGuideline
            r3 = 17
            r13 = -1
            if (r2 == 0) goto L_0x0068
            r2 = r8
            androidx.constraintlayout.solver.widgets.Guideline r2 = (androidx.constraintlayout.solver.widgets.Guideline) r2
            int r4 = r9.resolvedGuideBegin
            int r5 = r9.resolvedGuideEnd
            float r6 = r9.resolvedGuidePercent
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 >= r3) goto L_0x0051
            int r4 = r9.guideBegin
            int r5 = r9.guideEnd
            float r6 = r9.guidePercent
        L_0x0051:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x005b
            r2.setGuidePercent((float) r6)
            goto L_0x0066
        L_0x005b:
            if (r4 == r13) goto L_0x0061
            r2.setGuideBegin(r4)
            goto L_0x0066
        L_0x0061:
            if (r5 == r13) goto L_0x0066
            r2.setGuideEnd(r5)
        L_0x0066:
            goto L_0x032e
        L_0x0068:
            int r2 = r9.resolvedLeftToLeft
            int r4 = r9.resolvedLeftToRight
            int r5 = r9.resolvedRightToLeft
            int r6 = r9.resolvedRightToRight
            int r7 = r9.resolveGoneLeftMargin
            int r14 = r9.resolveGoneRightMargin
            float r15 = r9.resolvedHorizontalBias
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 >= r3) goto L_0x00cb
            int r2 = r9.leftToLeft
            int r3 = r9.leftToRight
            int r5 = r9.rightToLeft
            int r6 = r9.rightToRight
            int r7 = r9.goneLeftMargin
            int r14 = r9.goneRightMargin
            float r15 = r9.horizontalBias
            if (r2 != r13) goto L_0x009c
            if (r3 != r13) goto L_0x009c
            int r4 = r9.startToStart
            if (r4 == r13) goto L_0x0094
            int r2 = r9.startToStart
            r4 = r3
            goto L_0x009d
        L_0x0094:
            int r4 = r9.startToEnd
            if (r4 == r13) goto L_0x009c
            int r3 = r9.startToEnd
            r4 = r3
            goto L_0x009d
        L_0x009c:
            r4 = r3
        L_0x009d:
            if (r5 != r13) goto L_0x00c1
            if (r6 != r13) goto L_0x00c1
            int r3 = r9.endToStart
            if (r3 == r13) goto L_0x00b1
            int r5 = r9.endToStart
            r11 = r2
            r16 = r7
            r17 = r14
            r14 = r4
            r7 = r6
            r6 = r15
            r15 = r5
            goto L_0x00d4
        L_0x00b1:
            int r3 = r9.endToEnd
            if (r3 == r13) goto L_0x00c1
            int r6 = r9.endToEnd
            r11 = r2
            r16 = r7
            r17 = r14
            r14 = r4
            r7 = r6
            r6 = r15
            r15 = r5
            goto L_0x00d4
        L_0x00c1:
            r11 = r2
            r16 = r7
            r17 = r14
            r14 = r4
            r7 = r6
            r6 = r15
            r15 = r5
            goto L_0x00d4
        L_0x00cb:
            r11 = r2
            r16 = r7
            r17 = r14
            r14 = r4
            r7 = r6
            r6 = r15
            r15 = r5
        L_0x00d4:
            int r2 = r9.circleConstraint
            if (r2 == r13) goto L_0x00ed
            int r2 = r9.circleConstraint
            java.lang.Object r2 = r10.get(r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00e9
            float r3 = r9.circleAngle
            int r4 = r9.circleRadius
            r8.connectCircularConstraint(r2, r3, r4)
        L_0x00e9:
            r2 = r6
            r12 = r7
            goto L_0x025b
        L_0x00ed:
            if (r11 == r13) goto L_0x0114
            java.lang.Object r2 = r10.get(r11)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x0110
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            int r4 = r9.leftMargin
            r2 = r24
            r19 = r4
            r4 = r18
            r20 = r6
            r6 = r19
            r12 = r7
            r7 = r16
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x0133
        L_0x0110:
            r20 = r6
            r12 = r7
            goto L_0x0133
        L_0x0114:
            r20 = r6
            r12 = r7
            if (r14 == r13) goto L_0x0133
            java.lang.Object r2 = r10.get(r14)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x0134
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r6 = r9.leftMargin
            r2 = r24
            r4 = r18
            r7 = r16
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x0134
        L_0x0133:
        L_0x0134:
            if (r15 == r13) goto L_0x0150
            java.lang.Object r2 = r10.get(r15)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x016c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            int r6 = r9.rightMargin
            r2 = r24
            r4 = r18
            r7 = r17
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x016c
        L_0x0150:
            if (r12 == r13) goto L_0x016c
            java.lang.Object r2 = r10.get(r12)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x016d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r6 = r9.rightMargin
            r2 = r24
            r4 = r18
            r7 = r17
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x016d
        L_0x016c:
        L_0x016d:
            int r2 = r9.topToTop
            if (r2 == r13) goto L_0x018d
            int r2 = r9.topToTop
            java.lang.Object r2 = r10.get(r2)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x01ad
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            int r6 = r9.topMargin
            int r7 = r9.goneTopMargin
            r2 = r24
            r4 = r18
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x01ad
        L_0x018d:
            int r2 = r9.topToBottom
            if (r2 == r13) goto L_0x01ad
            int r2 = r9.topToBottom
            java.lang.Object r2 = r10.get(r2)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x01ae
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            int r6 = r9.topMargin
            int r7 = r9.goneTopMargin
            r2 = r24
            r4 = r18
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x01ae
        L_0x01ad:
        L_0x01ae:
            int r2 = r9.bottomToTop
            if (r2 == r13) goto L_0x01ce
            int r2 = r9.bottomToTop
            java.lang.Object r2 = r10.get(r2)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x01ee
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            int r6 = r9.bottomMargin
            int r7 = r9.goneBottomMargin
            r2 = r24
            r4 = r18
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x01ee
        L_0x01ce:
            int r2 = r9.bottomToBottom
            if (r2 == r13) goto L_0x01ee
            int r2 = r9.bottomToBottom
            java.lang.Object r2 = r10.get(r2)
            r18 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r18 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r18
            if (r18 == 0) goto L_0x01ef
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            int r6 = r9.bottomMargin
            int r7 = r9.goneBottomMargin
            r2 = r24
            r4 = r18
            r2.immediateConnect(r3, r4, r5, r6, r7)
            goto L_0x01ef
        L_0x01ee:
        L_0x01ef:
            int r2 = r9.baselineToBaseline
            if (r2 == r13) goto L_0x0246
            android.util.SparseArray<android.view.View> r2 = r0.mChildrenByIds
            int r3 = r9.baselineToBaseline
            java.lang.Object r2 = r2.get(r3)
            android.view.View r2 = (android.view.View) r2
            int r3 = r9.baselineToBaseline
            java.lang.Object r3 = r10.get(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x0246
            if (r2 == 0) goto L_0x0246
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            boolean r4 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r4 == 0) goto L_0x0246
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            r5 = 1
            r9.needsBaseline = r5
            r4.needsBaseline = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r8.getAnchor(r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r3.getAnchor(r7)
            r0 = 0
            r6.connect(r7, r0, r13, r5)
            r8.setHasBaseline(r5)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r4.widget
            r0.setHasBaseline(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.getAnchor(r0)
            r0.reset()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.getAnchor(r0)
            r0.reset()
        L_0x0246:
            r0 = 0
            r2 = r20
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 < 0) goto L_0x0250
            r8.setHorizontalBiasPercent(r2)
        L_0x0250:
            float r3 = r9.verticalBias
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x025b
            float r0 = r9.verticalBias
            r8.setVerticalBiasPercent(r0)
        L_0x025b:
            if (r22 == 0) goto L_0x026c
            int r0 = r9.editorAbsoluteX
            if (r0 != r13) goto L_0x0265
            int r0 = r9.editorAbsoluteY
            if (r0 == r13) goto L_0x026c
        L_0x0265:
            int r0 = r9.editorAbsoluteX
            int r3 = r9.editorAbsoluteY
            r8.setOrigin(r0, r3)
        L_0x026c:
            boolean r0 = r9.horizontalDimensionFixed
            r3 = -2
            if (r0 != 0) goto L_0x02a3
            int r0 = r9.width
            if (r0 != r13) goto L_0x0299
            boolean r0 = r9.constrainedWidth
            if (r0 == 0) goto L_0x027f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r8.setHorizontalDimensionBehaviour(r0)
            goto L_0x0284
        L_0x027f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r8.setHorizontalDimensionBehaviour(r0)
        L_0x0284:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.getAnchor(r0)
            int r4 = r9.leftMargin
            r0.mMargin = r4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.getAnchor(r0)
            int r4 = r9.rightMargin
            r0.mMargin = r4
            goto L_0x02b6
        L_0x0299:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r8.setHorizontalDimensionBehaviour(r0)
            r0 = 0
            r8.setWidth(r0)
            goto L_0x02b6
        L_0x02a3:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8.setHorizontalDimensionBehaviour(r0)
            int r0 = r9.width
            r8.setWidth(r0)
            int r0 = r9.width
            if (r0 != r3) goto L_0x02b6
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8.setHorizontalDimensionBehaviour(r0)
        L_0x02b6:
            boolean r0 = r9.verticalDimensionFixed
            if (r0 != 0) goto L_0x02ec
            int r0 = r9.height
            if (r0 != r13) goto L_0x02e2
            boolean r0 = r9.constrainedHeight
            if (r0 == 0) goto L_0x02c8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r8.setVerticalDimensionBehaviour(r0)
            goto L_0x02cd
        L_0x02c8:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r8.setVerticalDimensionBehaviour(r0)
        L_0x02cd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.getAnchor(r0)
            int r3 = r9.topMargin
            r0.mMargin = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.getAnchor(r0)
            int r3 = r9.bottomMargin
            r0.mMargin = r3
            goto L_0x02ff
        L_0x02e2:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r8.setVerticalDimensionBehaviour(r0)
            r0 = 0
            r8.setHeight(r0)
            goto L_0x02ff
        L_0x02ec:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8.setVerticalDimensionBehaviour(r0)
            int r0 = r9.height
            r8.setHeight(r0)
            int r0 = r9.height
            if (r0 != r3) goto L_0x02ff
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8.setVerticalDimensionBehaviour(r0)
        L_0x02ff:
            java.lang.String r0 = r9.dimensionRatio
            r8.setDimensionRatio(r0)
            float r0 = r9.horizontalWeight
            r8.setHorizontalWeight(r0)
            float r0 = r9.verticalWeight
            r8.setVerticalWeight(r0)
            int r0 = r9.horizontalChainStyle
            r8.setHorizontalChainStyle(r0)
            int r0 = r9.verticalChainStyle
            r8.setVerticalChainStyle(r0)
            int r0 = r9.matchConstraintDefaultWidth
            int r3 = r9.matchConstraintMinWidth
            int r4 = r9.matchConstraintMaxWidth
            float r5 = r9.matchConstraintPercentWidth
            r8.setHorizontalMatchStyle(r0, r3, r4, r5)
            int r0 = r9.matchConstraintDefaultHeight
            int r3 = r9.matchConstraintMinHeight
            int r4 = r9.matchConstraintMaxHeight
            float r5 = r9.matchConstraintPercentHeight
            r8.setVerticalMatchStyle(r0, r3, r4, r5)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    private final ConstraintWidget getTargetWidget(int id) {
        if (id == 0) {
            return this.mLayoutWidget;
        }
        View view2 = this.mChildrenByIds.get(id);
        if (view2 == null && (view2 = findViewById(id)) != null && view2 != this && view2.getParent() == this) {
            onViewAdded(view2);
        }
        if (view2 == this) {
            return this.mLayoutWidget;
        }
        if (view2 == null) {
            return null;
        }
        return ((LayoutParams) view2.getLayoutParams()).widget;
    }

    public final ConstraintWidget getViewWidget(View view2) {
        if (view2 == this) {
            return this.mLayoutWidget;
        }
        if (view2 == null) {
            return null;
        }
        return ((LayoutParams) view2.getLayoutParams()).widget;
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    /* access modifiers changed from: protected */
    public void resolveSystem(ConstraintWidgetContainer layout, int optimizationLevel, int widthMeasureSpec, int heightMeasureSpec) {
        int paddingX;
        int paddingX2;
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int paddingY = Math.max(0, getPaddingTop());
        int paddingBottom = Math.max(0, getPaddingBottom());
        int paddingHeight = paddingY + paddingBottom;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(widthMeasureSpec, heightMeasureSpec, paddingY, paddingBottom, paddingWidth, paddingHeight);
        if (Build.VERSION.SDK_INT >= 17) {
            int paddingStart = Math.max(0, getPaddingStart());
            int paddingEnd = Math.max(0, getPaddingEnd());
            if (paddingStart <= 0 && paddingEnd <= 0) {
                paddingX2 = Math.max(0, getPaddingLeft());
            } else if (isRtl() != 0) {
                paddingX2 = paddingEnd;
            } else {
                paddingX2 = paddingStart;
            }
            paddingX = paddingX2;
        } else {
            paddingX = Math.max(0, getPaddingLeft());
        }
        int widthSize2 = widthSize - paddingWidth;
        int heightSize2 = heightSize - paddingHeight;
        setSelfDimensionBehaviour(layout, widthMode, widthSize2, heightMode, heightSize2);
        layout.measure(optimizationLevel, widthMode, widthSize2, heightMode, heightSize2, this.mLastMeasureWidth, this.mLastMeasureHeight, paddingX, paddingY);
    }

    /* access modifiers changed from: protected */
    public void resolveMeasuredDimension(int widthMeasureSpec, int heightMeasureSpec, int measuredWidth, int measuredHeight, boolean isWidthMeasuredTooSmall, boolean isHeightMeasuredTooSmall) {
        int heightPadding = this.mMeasurer.paddingHeight;
        int androidLayoutWidth = measuredWidth + this.mMeasurer.paddingWidth;
        int androidLayoutHeight = measuredHeight + heightPadding;
        if (Build.VERSION.SDK_INT >= 11) {
            int resolvedWidthSize = resolveSizeAndState(androidLayoutWidth, widthMeasureSpec, 0);
            int resolvedWidthSize2 = Math.min(this.mMaxWidth, resolvedWidthSize & 16777215);
            int resolvedHeightSize = Math.min(this.mMaxHeight, resolveSizeAndState(androidLayoutHeight, heightMeasureSpec, 0 << 16) & 16777215);
            if (isWidthMeasuredTooSmall) {
                resolvedWidthSize2 |= 16777216;
            }
            if (isHeightMeasuredTooSmall) {
                resolvedHeightSize |= 16777216;
            }
            setMeasuredDimension(resolvedWidthSize2, resolvedHeightSize);
            this.mLastMeasureWidth = resolvedWidthSize2;
            this.mLastMeasureHeight = resolvedHeightSize;
            return;
        }
        setMeasuredDimension(androidLayoutWidth, androidLayoutHeight);
        this.mLastMeasureWidth = androidLayoutWidth;
        this.mLastMeasureHeight = androidLayoutHeight;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!this.mDirtyHierarchy) {
            int count = getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    break;
                } else if (getChildAt(i2).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (this.mDirtyHierarchy == 0) {
            int i3 = this.mOnMeasureWidthMeasureSpec;
            if (i3 == widthMeasureSpec && this.mOnMeasureHeightMeasureSpec == heightMeasureSpec) {
                resolveMeasuredDimension(widthMeasureSpec, heightMeasureSpec, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                return;
            } else if (i3 == widthMeasureSpec && View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824 && View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getSize(heightMeasureSpec) >= this.mLayoutWidget.getHeight()) {
                this.mOnMeasureWidthMeasureSpec = widthMeasureSpec;
                this.mOnMeasureHeightMeasureSpec = heightMeasureSpec;
                resolveMeasuredDimension(widthMeasureSpec, heightMeasureSpec, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                return;
            }
        }
        this.mOnMeasureWidthMeasureSpec = widthMeasureSpec;
        this.mOnMeasureHeightMeasureSpec = heightMeasureSpec;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, widthMeasureSpec, heightMeasureSpec);
        resolveMeasuredDimension(widthMeasureSpec, heightMeasureSpec, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    /* access modifiers changed from: protected */
    public boolean isRtl() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((getContext().getApplicationInfo().flags & 4194304) != 0) || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    private int getPaddingWidth() {
        int widthPadding = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int rtlPadding = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            rtlPadding = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        }
        if (rtlPadding > 0) {
            return rtlPadding;
        }
        return widthPadding;
    }

    /* access modifiers changed from: protected */
    public void setSelfDimensionBehaviour(ConstraintWidgetContainer layout, int widthMode, int widthSize, int heightMode, int heightSize) {
        int heightPadding = this.mMeasurer.paddingHeight;
        int widthPadding = this.mMeasurer.paddingWidth;
        ConstraintWidget.DimensionBehaviour widthBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour heightBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        int desiredWidth = 0;
        int desiredHeight = 0;
        int childCount = getChildCount();
        switch (widthMode) {
            case Integer.MIN_VALUE:
                widthBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                desiredWidth = widthSize;
                if (childCount == 0) {
                    desiredWidth = Math.max(0, this.mMinWidth);
                    break;
                }
                break;
            case 0:
                widthBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    desiredWidth = Math.max(0, this.mMinWidth);
                    break;
                }
                break;
            case 1073741824:
                desiredWidth = Math.min(this.mMaxWidth - widthPadding, widthSize);
                break;
        }
        switch (heightMode) {
            case Integer.MIN_VALUE:
                heightBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                desiredHeight = heightSize;
                if (childCount == 0) {
                    desiredHeight = Math.max(0, this.mMinHeight);
                    break;
                }
                break;
            case 0:
                heightBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    desiredHeight = Math.max(0, this.mMinHeight);
                    break;
                }
                break;
            case 1073741824:
                desiredHeight = Math.min(this.mMaxHeight - heightPadding, heightSize);
                break;
        }
        if (!(desiredWidth == layout.getWidth() && desiredHeight == layout.getHeight())) {
            layout.invalidateMeasures();
        }
        layout.setX(0);
        layout.setY(0);
        layout.setMaxWidth(this.mMaxWidth - widthPadding);
        layout.setMaxHeight(this.mMaxHeight - heightPadding);
        layout.setMinWidth(0);
        layout.setMinHeight(0);
        layout.setHorizontalDimensionBehaviour(widthBehaviour);
        layout.setWidth(desiredWidth);
        layout.setVerticalDimensionBehaviour(heightBehaviour);
        layout.setHeight(desiredHeight);
        layout.setMinWidth(this.mMinWidth - widthPadding);
        layout.setMinHeight(this.mMinHeight - heightPadding);
    }

    public void setState(int id, int screenWidth, int screenHeight) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(id, (float) screenWidth, (float) screenHeight);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View content;
        int widgetsCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i2 = 0; i2 < widgetsCount; i2++) {
            View child = getChildAt(i2);
            LayoutParams params = (LayoutParams) child.getLayoutParams();
            ConstraintWidget widget = params.widget;
            if ((child.getVisibility() != 8 || params.isGuideline || params.isHelper || params.isVirtualGroup || isInEditMode) && !params.isInPlaceholder) {
                int l = widget.getX();
                int t = widget.getY();
                int r = widget.getWidth() + l;
                int b2 = widget.getHeight() + t;
                child.layout(l, t, r, b2);
                if ((child instanceof Placeholder) && (content = ((Placeholder) child).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(l, t, r, b2);
                }
            }
        }
        int helperCount = this.mConstraintHelpers.size();
        if (helperCount > 0) {
            for (int i3 = 0; i3 < helperCount; i3++) {
                this.mConstraintHelpers.get(i3).updatePostLayout(this);
            }
        }
    }

    public void setOptimizationLevel(int level) {
        this.mOptimizationLevel = level;
        this.mLayoutWidget.setOptimizationLevel(level);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet set) {
        this.mConstraintSet = set;
    }

    public View getViewById(int id) {
        return this.mChildrenByIds.get(id);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        float ch;
        float cw;
        int count;
        int helperCount;
        ConstraintLayout constraintLayout = this;
        ArrayList<ConstraintHelper> arrayList = constraintLayout.mConstraintHelpers;
        if (arrayList != null && (helperCount = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < helperCount; i2++) {
                constraintLayout.mConstraintHelpers.get(i2).updatePreDraw(constraintLayout);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int count2 = getChildCount();
            float cw2 = (float) getWidth();
            float ch2 = (float) getHeight();
            int i3 = 0;
            while (i3 < count2) {
                View child = constraintLayout.getChildAt(i3);
                if (child.getVisibility() == 8) {
                    count = count2;
                    cw = cw2;
                    ch = ch2;
                } else {
                    Object tag = child.getTag();
                    if (tag == null || !(tag instanceof String)) {
                        count = count2;
                        cw = cw2;
                        ch = ch2;
                    } else {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int x = Integer.parseInt(split[0]);
                            int y = Integer.parseInt(split[1]);
                            int x2 = (int) ((((float) x) / 1080.0f) * cw2);
                            int y2 = (int) ((((float) y) / 1920.0f) * ch2);
                            int w = (int) ((((float) Integer.parseInt(split[2])) / 1080.0f) * cw2);
                            int h2 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * ch2);
                            Paint paint = new Paint();
                            paint.setColor(SupportMenu.CATEGORY_MASK);
                            count = count2;
                            cw = cw2;
                            ch = ch2;
                            Canvas canvas2 = canvas;
                            Paint paint2 = paint;
                            canvas2.drawLine((float) x2, (float) y2, (float) (x2 + w), (float) y2, paint2);
                            canvas2.drawLine((float) (x2 + w), (float) y2, (float) (x2 + w), (float) (y2 + h2), paint2);
                            canvas2.drawLine((float) (x2 + w), (float) (y2 + h2), (float) x2, (float) (y2 + h2), paint2);
                            canvas2.drawLine((float) x2, (float) (y2 + h2), (float) x2, (float) y2, paint2);
                            paint.setColor(-16711936);
                            canvas2.drawLine((float) x2, (float) y2, (float) (x2 + w), (float) (y2 + h2), paint2);
                            canvas2.drawLine((float) x2, (float) (y2 + h2), (float) (x2 + w), (float) y2, paint2);
                        } else {
                            count = count2;
                            cw = cw2;
                            ch = ch2;
                        }
                    }
                }
                i3++;
                constraintLayout = this;
                count2 = count;
                cw2 = cw;
                ch2 = ch;
            }
            float f2 = cw2;
            float f3 = ch2;
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void loadLayoutDescription(int layoutDescription) {
        if (layoutDescription != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, layoutDescription);
            } catch (Resources.NotFoundException e2) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        ConstraintWidget widget;

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void setWidgetDebugName(String text) {
            this.widget.setDebugName(text);
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        public LayoutParams(LayoutParams source) {
            super(source);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = source.guideBegin;
            this.guideEnd = source.guideEnd;
            this.guidePercent = source.guidePercent;
            this.leftToLeft = source.leftToLeft;
            this.leftToRight = source.leftToRight;
            this.rightToLeft = source.rightToLeft;
            this.rightToRight = source.rightToRight;
            this.topToTop = source.topToTop;
            this.topToBottom = source.topToBottom;
            this.bottomToTop = source.bottomToTop;
            this.bottomToBottom = source.bottomToBottom;
            this.baselineToBaseline = source.baselineToBaseline;
            this.circleConstraint = source.circleConstraint;
            this.circleRadius = source.circleRadius;
            this.circleAngle = source.circleAngle;
            this.startToEnd = source.startToEnd;
            this.startToStart = source.startToStart;
            this.endToStart = source.endToStart;
            this.endToEnd = source.endToEnd;
            this.goneLeftMargin = source.goneLeftMargin;
            this.goneTopMargin = source.goneTopMargin;
            this.goneRightMargin = source.goneRightMargin;
            this.goneBottomMargin = source.goneBottomMargin;
            this.goneStartMargin = source.goneStartMargin;
            this.goneEndMargin = source.goneEndMargin;
            this.horizontalBias = source.horizontalBias;
            this.verticalBias = source.verticalBias;
            this.dimensionRatio = source.dimensionRatio;
            this.dimensionRatioValue = source.dimensionRatioValue;
            this.dimensionRatioSide = source.dimensionRatioSide;
            this.horizontalWeight = source.horizontalWeight;
            this.verticalWeight = source.verticalWeight;
            this.horizontalChainStyle = source.horizontalChainStyle;
            this.verticalChainStyle = source.verticalChainStyle;
            this.constrainedWidth = source.constrainedWidth;
            this.constrainedHeight = source.constrainedHeight;
            this.matchConstraintDefaultWidth = source.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = source.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = source.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = source.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = source.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = source.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = source.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = source.matchConstraintPercentHeight;
            this.editorAbsoluteX = source.editorAbsoluteX;
            this.editorAbsoluteY = source.editorAbsoluteY;
            this.orientation = source.orientation;
            this.horizontalDimensionFixed = source.horizontalDimensionFixed;
            this.verticalDimensionFixed = source.verticalDimensionFixed;
            this.needsBaseline = source.needsBaseline;
            this.isGuideline = source.isGuideline;
            this.resolvedLeftToLeft = source.resolvedLeftToLeft;
            this.resolvedLeftToRight = source.resolvedLeftToRight;
            this.resolvedRightToLeft = source.resolvedRightToLeft;
            this.resolvedRightToRight = source.resolvedRightToRight;
            this.resolveGoneLeftMargin = source.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = source.resolveGoneRightMargin;
            this.resolvedHorizontalBias = source.resolvedHorizontalBias;
            this.constraintTag = source.constraintTag;
            this.widget = source.widget;
        }

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            private Table() {
            }

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context c2, AttributeSet attrs) {
            super(c2, attrs);
            int i2;
            int value;
            int commaIndex;
            int i3 = -1;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            int i4 = 0;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray a2 = c2.obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int N = a2.getIndexCount();
            int i5 = 0;
            while (i5 < N) {
                int attr = a2.getIndex(i5);
                switch (Table.map.get(attr)) {
                    case 0:
                        int i6 = i4;
                        i2 = i3;
                        value = i6;
                        break;
                    case 1:
                        int i7 = i4;
                        i2 = i3;
                        value = i7;
                        this.orientation = a2.getInt(attr, this.orientation);
                        break;
                    case 2:
                        value = i4;
                        int resourceId = a2.getResourceId(attr, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        i2 = -1;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.circleConstraint = a2.getInt(attr, -1);
                            break;
                        }
                    case 3:
                        value = i4;
                        this.circleRadius = a2.getDimensionPixelSize(attr, this.circleRadius);
                        i2 = -1;
                        break;
                    case 4:
                        value = i4;
                        float f2 = a2.getFloat(attr, this.circleAngle) % 360.0f;
                        this.circleAngle = f2;
                        if (f2 >= 0.0f) {
                            i2 = -1;
                            break;
                        } else {
                            this.circleAngle = (360.0f - f2) % 360.0f;
                            i2 = -1;
                            break;
                        }
                    case 5:
                        value = i4;
                        this.guideBegin = a2.getDimensionPixelOffset(attr, this.guideBegin);
                        i2 = -1;
                        break;
                    case 6:
                        value = i4;
                        this.guideEnd = a2.getDimensionPixelOffset(attr, this.guideEnd);
                        i2 = -1;
                        break;
                    case 7:
                        value = i4;
                        this.guidePercent = a2.getFloat(attr, this.guidePercent);
                        i2 = -1;
                        break;
                    case 8:
                        int i8 = i4;
                        int i9 = i3;
                        value = i8;
                        int resourceId2 = a2.getResourceId(attr, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 != i9) {
                            i2 = -1;
                            break;
                        } else {
                            this.leftToLeft = a2.getInt(attr, i9);
                            i2 = -1;
                            break;
                        }
                    case 9:
                        int i10 = i4;
                        i2 = i3;
                        value = i10;
                        int resourceId3 = a2.getResourceId(attr, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 != i2) {
                            break;
                        } else {
                            this.leftToRight = a2.getInt(attr, i2);
                            break;
                        }
                    case 10:
                        int i11 = i4;
                        i2 = i3;
                        value = i11;
                        int resourceId4 = a2.getResourceId(attr, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 != i2) {
                            break;
                        } else {
                            this.rightToLeft = a2.getInt(attr, i2);
                            break;
                        }
                    case 11:
                        int i12 = i4;
                        i2 = i3;
                        value = i12;
                        int resourceId5 = a2.getResourceId(attr, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 != i2) {
                            break;
                        } else {
                            this.rightToRight = a2.getInt(attr, i2);
                            break;
                        }
                    case 12:
                        int i13 = i4;
                        i2 = i3;
                        value = i13;
                        int resourceId6 = a2.getResourceId(attr, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 != i2) {
                            break;
                        } else {
                            this.topToTop = a2.getInt(attr, i2);
                            break;
                        }
                    case 13:
                        int i14 = i4;
                        i2 = i3;
                        value = i14;
                        int resourceId7 = a2.getResourceId(attr, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 != i2) {
                            break;
                        } else {
                            this.topToBottom = a2.getInt(attr, i2);
                            break;
                        }
                    case 14:
                        int i15 = i4;
                        i2 = i3;
                        value = i15;
                        int resourceId8 = a2.getResourceId(attr, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 != i2) {
                            break;
                        } else {
                            this.bottomToTop = a2.getInt(attr, i2);
                            break;
                        }
                    case 15:
                        int i16 = i4;
                        i2 = i3;
                        value = i16;
                        int resourceId9 = a2.getResourceId(attr, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 != i2) {
                            break;
                        } else {
                            this.bottomToBottom = a2.getInt(attr, i2);
                            break;
                        }
                    case 16:
                        int i17 = i4;
                        i2 = i3;
                        value = i17;
                        int resourceId10 = a2.getResourceId(attr, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 != i2) {
                            break;
                        } else {
                            this.baselineToBaseline = a2.getInt(attr, i2);
                            break;
                        }
                    case 17:
                        int i18 = i4;
                        i2 = i3;
                        value = i18;
                        int resourceId11 = a2.getResourceId(attr, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 != i2) {
                            break;
                        } else {
                            this.startToEnd = a2.getInt(attr, i2);
                            break;
                        }
                    case 18:
                        int i19 = i4;
                        i2 = i3;
                        value = i19;
                        int resourceId12 = a2.getResourceId(attr, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 != i2) {
                            break;
                        } else {
                            this.startToStart = a2.getInt(attr, i2);
                            break;
                        }
                    case 19:
                        int i20 = i4;
                        i2 = i3;
                        value = i20;
                        int resourceId13 = a2.getResourceId(attr, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 != i2) {
                            break;
                        } else {
                            this.endToStart = a2.getInt(attr, i2);
                            break;
                        }
                    case 20:
                        value = i4;
                        int resourceId14 = a2.getResourceId(attr, this.endToEnd);
                        this.endToEnd = resourceId14;
                        i2 = -1;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.endToEnd = a2.getInt(attr, -1);
                            break;
                        }
                    case 21:
                        value = i4;
                        this.goneLeftMargin = a2.getDimensionPixelSize(attr, this.goneLeftMargin);
                        i2 = -1;
                        break;
                    case 22:
                        value = i4;
                        this.goneTopMargin = a2.getDimensionPixelSize(attr, this.goneTopMargin);
                        i2 = -1;
                        break;
                    case 23:
                        value = i4;
                        this.goneRightMargin = a2.getDimensionPixelSize(attr, this.goneRightMargin);
                        i2 = -1;
                        break;
                    case 24:
                        value = i4;
                        this.goneBottomMargin = a2.getDimensionPixelSize(attr, this.goneBottomMargin);
                        i2 = -1;
                        break;
                    case 25:
                        value = i4;
                        this.goneStartMargin = a2.getDimensionPixelSize(attr, this.goneStartMargin);
                        i2 = -1;
                        break;
                    case 26:
                        value = i4;
                        this.goneEndMargin = a2.getDimensionPixelSize(attr, this.goneEndMargin);
                        i2 = -1;
                        break;
                    case 27:
                        value = i4;
                        this.constrainedWidth = a2.getBoolean(attr, this.constrainedWidth);
                        i2 = -1;
                        break;
                    case 28:
                        value = i4;
                        this.constrainedHeight = a2.getBoolean(attr, this.constrainedHeight);
                        i2 = -1;
                        break;
                    case 29:
                        value = i4;
                        this.horizontalBias = a2.getFloat(attr, this.horizontalBias);
                        i2 = -1;
                        break;
                    case 30:
                        value = i4;
                        this.verticalBias = a2.getFloat(attr, this.verticalBias);
                        i2 = -1;
                        break;
                    case 31:
                        value = i4;
                        int i21 = a2.getInt(attr, value);
                        this.matchConstraintDefaultWidth = i21;
                        if (i21 != 1) {
                            i2 = -1;
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            i2 = -1;
                            break;
                        }
                    case 32:
                        value = 0;
                        int i22 = a2.getInt(attr, 0);
                        this.matchConstraintDefaultHeight = i22;
                        if (i22 != 1) {
                            i2 = -1;
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            i2 = -1;
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = a2.getDimensionPixelSize(attr, this.matchConstraintMinWidth);
                            value = 0;
                            i2 = -1;
                            break;
                        } catch (Exception e2) {
                            if (a2.getInt(attr, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                            }
                            value = 0;
                            i2 = -1;
                            break;
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = a2.getDimensionPixelSize(attr, this.matchConstraintMaxWidth);
                            value = 0;
                            i2 = -1;
                            break;
                        } catch (Exception e3) {
                            if (a2.getInt(attr, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                            }
                            value = 0;
                            i2 = -1;
                            break;
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, a2.getFloat(attr, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        value = 0;
                        i2 = -1;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = a2.getDimensionPixelSize(attr, this.matchConstraintMinHeight);
                            value = 0;
                            i2 = -1;
                            break;
                        } catch (Exception e4) {
                            if (a2.getInt(attr, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                            }
                            value = 0;
                            i2 = -1;
                            break;
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = a2.getDimensionPixelSize(attr, this.matchConstraintMaxHeight);
                            value = 0;
                            i2 = -1;
                            break;
                        } catch (Exception e5) {
                            if (a2.getInt(attr, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                            }
                            value = 0;
                            i2 = -1;
                            break;
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, a2.getFloat(attr, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        value = 0;
                        i2 = -1;
                        break;
                    case 39:
                        value = 0;
                        i2 = -1;
                        break;
                    case 40:
                        value = 0;
                        i2 = -1;
                        break;
                    case 41:
                        value = 0;
                        i2 = -1;
                        break;
                    case 42:
                        value = 0;
                        i2 = -1;
                        break;
                    case 44:
                        String string = a2.getString(attr);
                        this.dimensionRatio = string;
                        this.dimensionRatioValue = Float.NaN;
                        this.dimensionRatioSide = i3;
                        if (string == null) {
                            value = 0;
                            i2 = -1;
                            break;
                        } else {
                            int len = string.length();
                            int commaIndex2 = this.dimensionRatio.indexOf(44);
                            if (commaIndex2 <= 0 || commaIndex2 >= len - 1) {
                                commaIndex = 0;
                            } else {
                                String dimension = this.dimensionRatio.substring(i4, commaIndex2);
                                if (dimension.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                                    this.dimensionRatioSide = i4;
                                } else if (dimension.equalsIgnoreCase(IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
                                    this.dimensionRatioSide = 1;
                                }
                                commaIndex = commaIndex2 + 1;
                            }
                            int colonIndex = this.dimensionRatio.indexOf(58);
                            if (colonIndex < 0 || colonIndex >= len - 1) {
                                String r = this.dimensionRatio.substring(commaIndex);
                                if (r.length() > 0) {
                                    try {
                                        this.dimensionRatioValue = Float.parseFloat(r);
                                    } catch (NumberFormatException e6) {
                                    }
                                }
                            } else {
                                String nominator = this.dimensionRatio.substring(commaIndex, colonIndex);
                                String denominator = this.dimensionRatio.substring(colonIndex + 1);
                                if (nominator.length() > 0 && denominator.length() > 0) {
                                    try {
                                        float nominatorValue = Float.parseFloat(nominator);
                                        float denominatorValue = Float.parseFloat(denominator);
                                        if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                                            if (this.dimensionRatioSide == 1) {
                                                this.dimensionRatioValue = Math.abs(denominatorValue / nominatorValue);
                                            } else {
                                                this.dimensionRatioValue = Math.abs(nominatorValue / denominatorValue);
                                            }
                                        }
                                    } catch (NumberFormatException e7) {
                                    }
                                }
                            }
                            value = 0;
                            i2 = -1;
                            break;
                        }
                    case 45:
                        this.horizontalWeight = a2.getFloat(attr, this.horizontalWeight);
                        int i23 = i4;
                        i2 = i3;
                        value = i23;
                        break;
                    case 46:
                        this.verticalWeight = a2.getFloat(attr, this.verticalWeight);
                        int i24 = i4;
                        i2 = i3;
                        value = i24;
                        break;
                    case 47:
                        this.horizontalChainStyle = a2.getInt(attr, i4);
                        int i25 = i4;
                        i2 = i3;
                        value = i25;
                        break;
                    case 48:
                        this.verticalChainStyle = a2.getInt(attr, i4);
                        int i26 = i4;
                        i2 = i3;
                        value = i26;
                        break;
                    case 49:
                        this.editorAbsoluteX = a2.getDimensionPixelOffset(attr, this.editorAbsoluteX);
                        int i27 = i4;
                        i2 = i3;
                        value = i27;
                        break;
                    case 50:
                        this.editorAbsoluteY = a2.getDimensionPixelOffset(attr, this.editorAbsoluteY);
                        int i28 = i4;
                        i2 = i3;
                        value = i28;
                        break;
                    case 51:
                        this.constraintTag = a2.getString(attr);
                        int i29 = i4;
                        i2 = i3;
                        value = i29;
                        break;
                    default:
                        int i30 = i4;
                        i2 = i3;
                        value = i30;
                        break;
                }
                i5++;
                int i31 = i2;
                i4 = value;
                i3 = i31;
            }
            a2.recycle();
            validate();
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (this.width == 0 || this.width == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public void resolveLayoutDirection(int layoutDirection) {
            int preLeftMargin = this.leftMargin;
            int preRightMargin = this.rightMargin;
            boolean isRtl = false;
            if (Build.VERSION.SDK_INT >= 17) {
                super.resolveLayoutDirection(layoutDirection);
                isRtl = 1 == getLayoutDirection();
            }
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float f2 = this.horizontalBias;
            this.resolvedHorizontalBias = f2;
            int i2 = this.guideBegin;
            this.resolvedGuideBegin = i2;
            int i3 = this.guideEnd;
            this.resolvedGuideEnd = i3;
            float f3 = this.guidePercent;
            this.resolvedGuidePercent = f3;
            if (isRtl) {
                boolean startEndDefined = false;
                int i4 = this.startToEnd;
                if (i4 != -1) {
                    this.resolvedRightToLeft = i4;
                    startEndDefined = true;
                } else {
                    int i5 = this.startToStart;
                    if (i5 != -1) {
                        this.resolvedRightToRight = i5;
                        startEndDefined = true;
                    }
                }
                int i6 = this.endToStart;
                if (i6 != -1) {
                    this.resolvedLeftToRight = i6;
                    startEndDefined = true;
                }
                int i7 = this.endToEnd;
                if (i7 != -1) {
                    this.resolvedLeftToLeft = i7;
                    startEndDefined = true;
                }
                int i8 = this.goneStartMargin;
                if (i8 != -1) {
                    this.resolveGoneRightMargin = i8;
                }
                int i9 = this.goneEndMargin;
                if (i9 != -1) {
                    this.resolveGoneLeftMargin = i9;
                }
                if (startEndDefined) {
                    this.resolvedHorizontalBias = 1.0f - f2;
                }
                if (this.isGuideline && this.orientation == 1) {
                    if (f3 != -1.0f) {
                        this.resolvedGuidePercent = 1.0f - f3;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuideEnd = -1;
                    } else if (i2 != -1) {
                        this.resolvedGuideEnd = i2;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuidePercent = -1.0f;
                    } else if (i3 != -1) {
                        this.resolvedGuideBegin = i3;
                        this.resolvedGuideEnd = -1;
                        this.resolvedGuidePercent = -1.0f;
                    }
                }
            } else {
                int i10 = this.startToEnd;
                if (i10 != -1) {
                    this.resolvedLeftToRight = i10;
                }
                int i11 = this.startToStart;
                if (i11 != -1) {
                    this.resolvedLeftToLeft = i11;
                }
                int i12 = this.endToStart;
                if (i12 != -1) {
                    this.resolvedRightToLeft = i12;
                }
                int i13 = this.endToEnd;
                if (i13 != -1) {
                    this.resolvedRightToRight = i13;
                }
                int i14 = this.goneStartMargin;
                if (i14 != -1) {
                    this.resolveGoneLeftMargin = i14;
                }
                int i15 = this.goneEndMargin;
                if (i15 != -1) {
                    this.resolveGoneRightMargin = i15;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i16 = this.rightToLeft;
                if (i16 != -1) {
                    this.resolvedRightToLeft = i16;
                    if (this.rightMargin <= 0 && preRightMargin > 0) {
                        this.rightMargin = preRightMargin;
                    }
                } else {
                    int i17 = this.rightToRight;
                    if (i17 != -1) {
                        this.resolvedRightToRight = i17;
                        if (this.rightMargin <= 0 && preRightMargin > 0) {
                            this.rightMargin = preRightMargin;
                        }
                    }
                }
                int i18 = this.leftToLeft;
                if (i18 != -1) {
                    this.resolvedLeftToLeft = i18;
                    if (this.leftMargin <= 0 && preLeftMargin > 0) {
                        this.leftMargin = preLeftMargin;
                        return;
                    }
                    return;
                }
                int i19 = this.leftToRight;
                if (i19 != -1) {
                    this.resolvedLeftToRight = i19;
                    if (this.leftMargin <= 0 && preLeftMargin > 0) {
                        this.leftMargin = preLeftMargin;
                    }
                }
            }
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
