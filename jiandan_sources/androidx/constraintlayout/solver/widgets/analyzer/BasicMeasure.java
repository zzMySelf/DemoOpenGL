package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    public static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    public static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    public ConstraintWidgetContainer constraintWidgetContainer;
    public Measure mMeasure = new Measure();
    public final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public enum MeasureType {
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z;
        boolean z2 = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.useCurrentDimensions = false;
        return measure2.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer2) {
        int size = constraintWidgetContainer2.mChildren.size();
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i2);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                boolean z = true;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    z = false;
                }
                if (!z) {
                    measure(measurer, constraintWidget, false);
                    Metrics metrics = constraintWidgetContainer2.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, String str, int i2, int i3) {
        int minWidth = constraintWidgetContainer2.getMinWidth();
        int minHeight = constraintWidgetContainer2.getMinHeight();
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.setWidth(i2);
        constraintWidgetContainer2.setHeight(i3);
        constraintWidgetContainer2.setMinWidth(minWidth);
        constraintWidgetContainer2.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        boolean z;
        boolean z2;
        boolean z3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z4;
        int i19;
        Metrics metrics;
        ConstraintWidgetContainer constraintWidgetContainer3 = constraintWidgetContainer2;
        int i20 = i2;
        int i21 = i5;
        int i22 = i7;
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        int size = constraintWidgetContainer3.mChildren.size();
        int width = constraintWidgetContainer2.getWidth();
        int height = constraintWidgetContainer2.getHeight();
        boolean enabled = Optimizer.enabled(i20, 128);
        boolean z5 = enabled || Optimizer.enabled(i20, 64);
        if (z5) {
            int i23 = 0;
            while (true) {
                if (i23 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetContainer3.mChildren.get(i23);
                boolean z6 = (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((!constraintWidget.isInHorizontalChain() || !z6) && ((!constraintWidget.isInVerticalChain() || !z6) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInHorizontalChain() && !constraintWidget.isInVerticalChain())) {
                    i23++;
                }
            }
            z5 = false;
        }
        if (z5 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        if (z5 && ((i21 == 1073741824 && i22 == 1073741824) || enabled)) {
            int min = Math.min(constraintWidgetContainer2.getMaxWidth(), i6);
            int min2 = Math.min(constraintWidgetContainer2.getMaxHeight(), i8);
            if (i21 == 1073741824 && constraintWidgetContainer2.getWidth() != min) {
                constraintWidgetContainer3.setWidth(min);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i22 == 1073741824 && constraintWidgetContainer2.getHeight() != min2) {
                constraintWidgetContainer3.setHeight(min2);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i21 == 1073741824 && i22 == 1073741824) {
                z = constraintWidgetContainer3.directMeasure(enabled);
                i11 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer3.directMeasureSetup(enabled);
                if (i21 == 1073741824) {
                    z4 = directMeasureSetup & constraintWidgetContainer3.directMeasureWithOrientation(enabled, 0);
                    i19 = 1;
                } else {
                    z4 = directMeasureSetup;
                    i19 = 0;
                }
                if (i22 == 1073741824) {
                    boolean directMeasureWithOrientation = constraintWidgetContainer3.directMeasureWithOrientation(enabled, 1) & z4;
                    i11 = i19 + 1;
                    z = directMeasureWithOrientation;
                } else {
                    i11 = i19;
                    z = z4;
                }
            }
            if (z) {
                constraintWidgetContainer3.updateFromRuns(i21 == 1073741824, i22 == 1073741824);
            }
        } else {
            z = false;
            i11 = 0;
        }
        if (z && i11 == 2) {
            return 0;
        }
        if (size > 0) {
            measureChildren(constraintWidgetContainer2);
        }
        int optimizationLevel = constraintWidgetContainer2.getOptimizationLevel();
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer3, "First pass", width, height);
        }
        if (size2 > 0) {
            boolean z7 = constraintWidgetContainer2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z8 = constraintWidgetContainer2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(constraintWidgetContainer2.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer2.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i24 = 0;
            boolean z9 = false;
            while (i24 < size2) {
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i24);
                if (!(constraintWidget2 instanceof VirtualLayout)) {
                    i16 = optimizationLevel;
                    i18 = width;
                    i17 = height;
                } else {
                    int width2 = constraintWidget2.getWidth();
                    int height2 = constraintWidget2.getHeight();
                    i16 = optimizationLevel;
                    boolean measure = z9 | measure(measurer, constraintWidget2, true);
                    Metrics metrics2 = constraintWidgetContainer3.mMetrics;
                    i18 = width;
                    i17 = height;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets++;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z7 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        measure = true;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z8 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        measure = true;
                    }
                    z9 = measure | ((VirtualLayout) constraintWidget2).needSolverPass();
                }
                i24++;
                optimizationLevel = i16;
                width = i18;
                height = i17;
            }
            int i25 = optimizationLevel;
            int i26 = width;
            int i27 = height;
            int i28 = 0;
            int i29 = 2;
            while (i28 < i29) {
                int i30 = 0;
                while (i30 < size2) {
                    ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i30);
                    if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!constraintWidget3.horizontalRun.dimension.resolved || !constraintWidget3.verticalRun.dimension.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        z9 |= measure(measurer, constraintWidget3, true);
                        Metrics metrics3 = constraintWidgetContainer3.mMetrics;
                        i15 = i28;
                        i14 = size2;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets++;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z7 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            z9 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z8 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            z9 = true;
                        }
                        if (constraintWidget3.hasBaseline() && baselineDistance != constraintWidget3.getBaselineDistance()) {
                            z9 = true;
                        }
                    } else {
                        i15 = i28;
                        i14 = size2;
                    }
                    i30++;
                    size2 = i14;
                    i28 = i15;
                }
                int i31 = i28;
                int i32 = size2;
                if (z9) {
                    i13 = i26;
                    i12 = i27;
                    solveLinearSystem(constraintWidgetContainer3, "intermediate pass", i13, i12);
                    z9 = false;
                } else {
                    i13 = i26;
                    i12 = i27;
                }
                i28 = i31 + 1;
                i26 = i13;
                i27 = i12;
                i29 = 2;
                size2 = i32;
            }
            int i33 = i26;
            int i34 = i27;
            if (z9) {
                solveLinearSystem(constraintWidgetContainer3, "2nd pass", i33, i34);
                if (constraintWidgetContainer2.getWidth() < max) {
                    constraintWidgetContainer3.setWidth(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (constraintWidgetContainer2.getHeight() < max2) {
                    constraintWidgetContainer3.setHeight(max2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    solveLinearSystem(constraintWidgetContainer3, "3rd pass", i33, i34);
                }
            }
            optimizationLevel = i25;
        }
        constraintWidgetContainer3.setOptimizationLevel(optimizationLevel);
        return 0;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer2.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i2);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer2.invalidateGraph();
    }
}
