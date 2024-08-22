package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.gridlayout.R;
import androidx.legacy.widget.Space;
import com.baidu.android.common.others.lang.StringUtil;
import com.dlife.ctaccountapi.x;
import com.tera.scan.widget.customrecyclerview.WrapperAdapter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class GridLayout extends ViewGroup {
    public static final int ALIGNMENT_MODE = R.styleable.GridLayout_alignmentMode;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE = new Alignment() {
        public int getAlignmentValue(View view, int i2, int i3) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            if (baseline == -1) {
                return Integer.MIN_VALUE;
            }
            return baseline;
        }

        public Bounds getBounds() {
            return new Bounds() {
                public int size;

                public int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i2, boolean z) {
                    return Math.max(0, super.getOffset(gridLayout, view, alignment, i2, z));
                }

                public void include(int i2, int i3) {
                    super.include(i2, i3);
                    this.size = Math.max(this.size, i2 + i3);
                }

                public void reset() {
                    super.reset();
                    this.size = Integer.MIN_VALUE;
                }

                public int size(boolean z) {
                    return Math.max(super.size(z), this.size);
                }
            };
        }

        public String getDebugString() {
            return "BASELINE";
        }

        public int getGravityOffset(View view, int i2) {
            return 0;
        }
    };
    public static final Alignment BOTTOM;
    public static final int CAN_STRETCH = 2;
    public static final Alignment CENTER = new Alignment() {
        public int getAlignmentValue(View view, int i2, int i3) {
            return i2 >> 1;
        }

        public String getDebugString() {
            return "CENTER";
        }

        public int getGravityOffset(View view, int i2) {
            return i2 >> 1;
        }
    };
    public static final int COLUMN_COUNT = R.styleable.GridLayout_columnCount;
    public static final int COLUMN_ORDER_PRESERVED = R.styleable.GridLayout_columnOrderPreserved;
    public static final int DEFAULT_ALIGNMENT_MODE = 1;
    public static final int DEFAULT_CONTAINER_MARGIN = 0;
    public static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    public static final boolean DEFAULT_ORDER_PRESERVED = true;
    public static final int DEFAULT_ORIENTATION = 0;
    public static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END;
    public static final Alignment FILL = new Alignment() {
        public int getAlignmentValue(View view, int i2, int i3) {
            return Integer.MIN_VALUE;
        }

        public String getDebugString() {
            return "FILL";
        }

        public int getGravityOffset(View view, int i2) {
            return 0;
        }

        public int getSizeInCell(View view, int i2, int i3) {
            return i3;
        }
    };
    public static final int HORIZONTAL = 0;
    public static final int INFLEXIBLE = 0;
    public static final Alignment LEADING = new Alignment() {
        public int getAlignmentValue(View view, int i2, int i3) {
            return 0;
        }

        public String getDebugString() {
            return "LEADING";
        }

        public int getGravityOffset(View view, int i2) {
            return 0;
        }
    };
    public static final Alignment LEFT;
    public static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    public static final int MAX_SIZE = 100000;
    public static final Printer NO_PRINTER = new Printer() {
        public void println(String str) {
        }
    };
    public static final int ORIENTATION = R.styleable.GridLayout_orientation;
    public static final Alignment RIGHT = createSwitchingAlignment(END, START);
    public static final int ROW_COUNT = R.styleable.GridLayout_rowCount;
    public static final int ROW_ORDER_PRESERVED = R.styleable.GridLayout_rowOrderPreserved;
    public static final Alignment START;
    public static final Alignment TOP;
    public static final Alignment TRAILING;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    public static final Alignment UNDEFINED_ALIGNMENT = new Alignment() {
        public int getAlignmentValue(View view, int i2, int i3) {
            return Integer.MIN_VALUE;
        }

        public String getDebugString() {
            return "UNDEFINED";
        }

        public int getGravityOffset(View view, int i2) {
            return Integer.MIN_VALUE;
        }
    };
    public static final int UNINITIALIZED_HASH = 0;
    public static final int USE_DEFAULT_MARGINS = R.styleable.GridLayout_useDefaultMargins;
    public static final int VERTICAL = 1;
    public int mAlignmentMode;
    public int mDefaultGap;
    public final Axis mHorizontalAxis;
    public int mLastLayoutParamsHashCode;
    public int mOrientation;
    public Printer mPrinter;
    public boolean mUseDefaultMargins;
    public final Axis mVerticalAxis;

    public static abstract class Alignment {
        public abstract int getAlignmentValue(View view, int i2, int i3);

        public Bounds getBounds() {
            return new Bounds();
        }

        public abstract String getDebugString();

        public abstract int getGravityOffset(View view, int i2);

        public int getSizeInCell(View view, int i2, int i3) {
            return i2;
        }

        public String toString() {
            return "Alignment:" + getDebugString();
        }
    }

    public static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.span = interval;
            this.value = mutableInt;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.span);
            sb.append(" ");
            sb.append(!this.valid ? "+>" : "->");
            sb.append(" ");
            sb.append(this.value);
            return sb.toString();
        }
    }

    public static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        public final Class<K> keyType;
        public final Class<V> valueType;

        public Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> of(Class<K> cls, Class<V> cls2) {
            return new Assoc<>(cls, cls2);
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance(this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance(this.valueType, size);
            for (int i2 = 0; i2 < size; i2++) {
                objArr[i2] = ((Pair) get(i2)).first;
                objArr2[i2] = ((Pair) get(i2)).second;
            }
            return new PackedMap<>(objArr, objArr2);
        }

        public void put(K k, V v) {
            add(Pair.create(k, v));
        }
    }

    public final class Axis {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int COMPLETE = 2;
        public static final int NEW = 0;
        public static final int PENDING = 1;
        public Arc[] arcs;
        public boolean arcsValid = false;
        public PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid = false;
        public int definedCount = Integer.MIN_VALUE;
        public int[] deltas;
        public PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid = false;
        public PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid = false;
        public boolean hasWeights;
        public boolean hasWeightsValid = false;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid = false;
        public int[] locations;
        public boolean locationsValid = false;
        public int maxIndex = Integer.MIN_VALUE;
        public boolean orderPreserved = true;
        public MutableInt parentMax = new MutableInt(-100000);
        public MutableInt parentMin = new MutableInt(0);
        public int[] trailingMargins;
        public boolean trailingMarginsValid = false;

        static {
            Class<GridLayout> cls = GridLayout.class;
        }

        public Axis(boolean z) {
            this.horizontal = z;
        }

        private void addComponentSizes(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            int i2 = 0;
            while (true) {
                K[] kArr = packedMap.keys;
                if (i2 < ((Interval[]) kArr).length) {
                    include(list, ((Interval[]) kArr)[i2], ((MutableInt[]) packedMap.values)[i2], false);
                    i2++;
                } else {
                    return;
                }
            }
        }

        private String arcsToString(List<Arc> list) {
            StringBuilder sb;
            String str = this.horizontal ? x.a : "y";
            StringBuilder sb2 = new StringBuilder();
            boolean z = true;
            for (Arc next : list) {
                if (z) {
                    z = false;
                } else {
                    sb2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                Interval interval = next.span;
                int i2 = interval.min;
                int i3 = interval.max;
                int i4 = next.value.value;
                if (i2 < i3) {
                    sb.append(str);
                    sb.append(i3);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i2);
                    sb.append(">=");
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i2);
                    sb.append("-");
                    sb.append(str);
                    sb.append(i3);
                    sb.append("<=");
                    i4 = -i4;
                }
                sb.append(i4);
                sb2.append(sb.toString());
            }
            return sb2.toString();
        }

        private int calculateMaxIndex() {
            int childCount = GridLayout.this.getChildCount();
            int i2 = -1;
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i3));
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                i2 = Math.max(Math.max(Math.max(i2, interval.min), interval.max), interval.size());
            }
            if (i2 == -1) {
                return Integer.MIN_VALUE;
            }
            return i2;
        }

        private float calculateTotalWeight() {
            int childCount = GridLayout.this.getChildCount();
            float f = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    f += (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                }
            }
            return f;
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        private void computeGroupBounds() {
            int i2;
            Bounds[] boundsArr = (Bounds[]) this.groupBounds.values;
            for (Bounds reset : boundsArr) {
                reset.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = GridLayout.this.getChildAt(i3);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                int measurementIncludingMargin = GridLayout.this.getMeasurementIncludingMargin(childAt, this.horizontal);
                if (spec.weight == 0.0f) {
                    i2 = 0;
                } else {
                    i2 = getDeltas()[i3];
                }
                this.groupBounds.getValue(i3).include(GridLayout.this, childAt, spec, this, measurementIncludingMargin + i2);
            }
        }

        private boolean computeHasWeights() {
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void computeLinks(PackedMap<Interval, MutableInt> packedMap, boolean z) {
            MutableInt[] mutableIntArr = (MutableInt[]) packedMap.values;
            for (MutableInt reset : mutableIntArr) {
                reset.reset();
            }
            Bounds[] boundsArr = (Bounds[]) getGroupBounds().values;
            for (int i2 = 0; i2 < boundsArr.length; i2++) {
                int size = boundsArr[i2].size(z);
                MutableInt value = packedMap.getValue(i2);
                int i3 = value.value;
                if (!z) {
                    size = -size;
                }
                value.value = Math.max(i3, size);
            }
        }

        private void computeLocations(int[] iArr) {
            if (!hasWeights()) {
                solve(iArr);
            } else {
                solveAndDistributeSpace(iArr);
            }
            if (!this.orderPreserved) {
                int i2 = iArr[0];
                int length = iArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = iArr[i3] - i2;
                }
            }
        }

        private void computeMargins(boolean z) {
            int[] iArr = z ? this.leadingMargins : this.trailingMargins;
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                    int i3 = z ? interval.min : interval.max;
                    iArr[i3] = Math.max(iArr[i3], GridLayout.this.getMargin1(childAt, this.horizontal, z));
                }
            }
        }

        private Arc[] createArcs() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                int i2 = 0;
                while (i2 < getCount()) {
                    int i3 = i2 + 1;
                    include(arrayList, new Interval(i2, i3), new MutableInt(0));
                    i2 = i3;
                }
            }
            int count = getCount();
            include(arrayList, new Interval(0, count), this.parentMin, false);
            include(arrayList2, new Interval(count, 0), this.parentMax, false);
            return (Arc[]) GridLayout.append(topologicalSort((List<Arc>) arrayList), topologicalSort((List<Arc>) arrayList2));
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc<K, V> of = Assoc.of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                Spec spec = this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec;
                of.put(spec, spec.getAbsoluteAlignment(this.horizontal).getBounds());
            }
            return of.pack();
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean z) {
            Assoc<K, V> of = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = (Spec[]) getGroupBounds().keys;
            int length = specArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                of.put(z ? specArr[i2].span : specArr[i2].span.inverse(), new MutableInt());
            }
            return of.pack();
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        private int getMeasure(int i2, int i3) {
            setParentConstraints(i2, i3);
            return size(getLocations());
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z) {
            if (interval.size() != 0) {
                if (z) {
                    for (Arc arc : list) {
                        if (arc.span.equals(interval)) {
                            return;
                        }
                    }
                }
                list.add(new Arc(interval, mutableInt));
            }
        }

        private void init(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private void logError(String str, Arc[] arcArr, boolean[] zArr) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arcArr.length; i2++) {
                Arc arc = arcArr[i2];
                if (zArr[i2]) {
                    arrayList.add(arc);
                }
                if (!arc.valid) {
                    arrayList2.add(arc);
                }
            }
            Printer printer = GridLayout.this.mPrinter;
            printer.println(str + " constraints: " + arcsToString(arrayList) + " are inconsistent; permanently removing: " + arcsToString(arrayList2) + ". ");
        }

        private boolean relax(int[] iArr, Arc arc) {
            if (!arc.valid) {
                return false;
            }
            Interval interval = arc.span;
            int i2 = interval.min;
            int i3 = interval.max;
            int i4 = iArr[i2] + arc.value.value;
            if (i4 <= iArr[i3]) {
                return false;
            }
            iArr[i3] = i4;
            return true;
        }

        private void setParentConstraints(int i2, int i3) {
            this.parentMin.value = i2;
            this.parentMax.value = -i3;
            this.locationsValid = false;
        }

        private void shareOutDelta(int i2, float f) {
            Arrays.fill(this.deltas, 0);
            int childCount = GridLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = GridLayout.this.getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    float f2 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                    if (f2 != 0.0f) {
                        int round = Math.round((((float) i2) * f2) / f);
                        this.deltas[i3] = round;
                        i2 -= round;
                        f -= f2;
                    }
                }
            }
        }

        private int size(int[] iArr) {
            return iArr[getCount()];
        }

        private boolean solve(Arc[] arcArr, int[] iArr) {
            return solve(arcArr, iArr, true);
        }

        private void solveAndDistributeSpace(int[] iArr) {
            Arrays.fill(getDeltas(), 0);
            solve(iArr);
            boolean z = true;
            int childCount = (this.parentMin.value * GridLayout.this.getChildCount()) + 1;
            if (childCount >= 2) {
                float calculateTotalWeight = calculateTotalWeight();
                int i2 = -1;
                int i3 = 0;
                while (i3 < childCount) {
                    int i4 = (int) ((((long) i3) + ((long) childCount)) / 2);
                    invalidateValues();
                    shareOutDelta(i4, calculateTotalWeight);
                    boolean solve = solve(getArcs(), iArr, false);
                    if (solve) {
                        i3 = i4 + 1;
                        i2 = i4;
                    } else {
                        childCount = i4;
                    }
                    z = solve;
                }
                if (i2 > 0 && !z) {
                    invalidateValues();
                    shareOutDelta(i2, calculateTotalWeight);
                    solve(iArr);
                }
            }
        }

        private Arc[] topologicalSort(final Arc[] arcArr) {
            return new Object() {
                public static final /* synthetic */ boolean $assertionsDisabled = false;
                public Arc[][] arcsByVertex;
                public int cursor;
                public Arc[] result;
                public int[] visited = new int[(Axis.this.getCount() + 1)];

                static {
                    Class<GridLayout> cls = GridLayout.class;
                }

                {
                    Arc[] arcArr = arcArr;
                    Arc[] arcArr2 = new Arc[arcArr.length];
                    this.result = arcArr2;
                    this.cursor = arcArr2.length - 1;
                    this.arcsByVertex = Axis.this.groupArcsByFirstVertex(arcArr);
                }

                public Arc[] sort() {
                    int length = this.arcsByVertex.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        walk(i2);
                    }
                    return this.result;
                }

                public void walk(int i2) {
                    int[] iArr = this.visited;
                    if (iArr[i2] == 0) {
                        iArr[i2] = 1;
                        for (Arc arc : this.arcsByVertex[i2]) {
                            walk(arc.span.max);
                            Arc[] arcArr = this.result;
                            int i3 = this.cursor;
                            this.cursor = i3 - 1;
                            arcArr[i3] = arc;
                        }
                        this.visited[i2] = 2;
                    }
                }
            }.sort();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[(getCount() + 1)];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[(getCount() + 1)];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[(getCount() + 1)];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        public Arc[][] groupArcsByFirstVertex(Arc[] arcArr) {
            int count = getCount() + 1;
            Arc[][] arcArr2 = new Arc[count][];
            int[] iArr = new int[count];
            for (Arc arc : arcArr) {
                int i2 = arc.span.min;
                iArr[i2] = iArr[i2] + 1;
            }
            for (int i3 = 0; i3 < count; i3++) {
                arcArr2[i3] = new Arc[iArr[i3]];
            }
            Arrays.fill(iArr, 0);
            for (Arc arc2 : arcArr) {
                int i4 = arc2.span.min;
                Arc[] arcArr3 = arcArr2[i4];
                int i5 = iArr[i4];
                iArr[i4] = i5 + 1;
                arcArr3[i5] = arc2;
            }
            return arcArr2;
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void layout(int i2) {
            setParentConstraints(i2, i2);
            getLocations();
        }

        public void setCount(int i2) {
            if (i2 != Integer.MIN_VALUE && i2 < getMaxIndex()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.horizontal ? "column" : "row");
                sb.append("Count must be greater than or equal to the maximum of all grid indices ");
                sb.append("(and spans) defined in the LayoutParams of each child");
                GridLayout.handleInvalidParams(sb.toString());
            }
            this.definedCount = i2;
        }

        public void setOrderPreserved(boolean z) {
            this.orderPreserved = z;
            invalidateStructure();
        }

        private boolean solve(Arc[] arcArr, int[] iArr, boolean z) {
            String str = this.horizontal ? "horizontal" : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i2 = 0; i2 < arcArr.length; i2++) {
                init(iArr);
                for (int i3 = 0; i3 < count; i3++) {
                    boolean z2 = false;
                    for (Arc relax : arcArr) {
                        z2 |= relax(iArr, relax);
                    }
                    if (!z2) {
                        if (zArr != null) {
                            logError(str, arcArr, zArr);
                        }
                        return true;
                    }
                }
                if (!z) {
                    return false;
                }
                boolean[] zArr2 = new boolean[arcArr.length];
                for (int i4 = 0; i4 < count; i4++) {
                    int length = arcArr.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        zArr2[i5] = zArr2[i5] | relax(iArr, arcArr[i5]);
                    }
                }
                if (i2 == 0) {
                    zArr = zArr2;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= arcArr.length) {
                        break;
                    }
                    if (zArr2[i6]) {
                        Arc arc = arcArr[i6];
                        Interval interval = arc.span;
                        if (interval.min >= interval.max) {
                            arc.valid = false;
                            break;
                        }
                    }
                    i6++;
                }
            }
            return true;
        }

        private Arc[] topologicalSort(List<Arc> list) {
            return topologicalSort((Arc[]) list.toArray(new Arc[list.size()]));
        }

        public int getMeasure(int i2) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE) {
                return getMeasure(0, size);
            }
            if (mode == 0) {
                return getMeasure(0, 100000);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return getMeasure(size, size);
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt) {
            include(list, interval, mutableInt, true);
        }

        private boolean solve(int[] iArr) {
            return solve(getArcs(), iArr);
        }
    }

    public static final class Interval {
        public final int max;
        public final int min;

        public Interval(int i2, int i3) {
            this.min = i2;
            this.max = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Interval.class != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.max == interval.max && this.min == interval.min;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        public Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public int size() {
            return this.max - this.min;
        }

        public String toString() {
            return "[" + this.min + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.max + "]";
        }
    }

    public static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        public PackedMap(K[] kArr, V[] vArr) {
            int[] createIndex = createIndex(kArr);
            this.index = createIndex;
            this.keys = compact(kArr, createIndex);
            this.values = compact(vArr, this.index);
        }

        public static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1);
            for (int i2 = 0; i2 < length; i2++) {
                kArr2[iArr[i2]] = kArr[i2];
            }
            return kArr2;
        }

        public static <K> int[] createIndex(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                Integer num = (Integer) hashMap.get(k);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(k, num);
                }
                iArr[i2] = num.intValue();
            }
            return iArr;
        }

        public V getValue(int i2) {
            return this.values[this.index[i2]];
        }
    }

    static {
        AnonymousClass4 r0 = new Alignment() {
            public int getAlignmentValue(View view, int i2, int i3) {
                return i2;
            }

            public String getDebugString() {
                return "TRAILING";
            }

            public int getGravityOffset(View view, int i2) {
                return i2;
            }
        };
        TRAILING = r0;
        Alignment alignment = LEADING;
        TOP = alignment;
        BOTTOM = r0;
        START = alignment;
        END = r0;
        LEFT = createSwitchingAlignment(alignment, r0);
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(R.dimen.default_gap);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(ROW_COUNT, Integer.MIN_VALUE));
            setColumnCount(obtainStyledAttributes.getInt(COLUMN_COUNT, Integer.MIN_VALUE));
            setOrientation(obtainStyledAttributes.getInt(ORIENTATION, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(USE_DEFAULT_MARGINS, false));
            setAlignmentMode(obtainStyledAttributes.getInt(ALIGNMENT_MODE, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(ROW_ORDER_PRESERVED, true));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(COLUMN_ORDER_PRESERVED, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int adjust(int i2, int i3) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3 + i2), View.MeasureSpec.getMode(i2));
    }

    public static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static boolean canStretch(int i2) {
        return (i2 & 2) != 0;
    }

    private void checkLayoutParams(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        int i2 = interval.min;
        if (i2 != Integer.MIN_VALUE && i2 < 0) {
            handleInvalidParams(str + " indices must be positive");
        }
        int i3 = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i3 != Integer.MIN_VALUE) {
            if (interval.max > i3) {
                handleInvalidParams(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (interval.size() > i3) {
                handleInvalidParams(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    public static int clip(Interval interval, boolean z, int i2) {
        int size = interval.size();
        if (i2 == 0) {
            return size;
        }
        return Math.min(size, i2 - (z ? Math.min(interval.min, i2) : 0));
    }

    private int computeLayoutParamsHashCode() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                i2 = (i2 * 31) + ((LayoutParams) childAt.getLayoutParams()).hashCode();
            }
        }
        return i2;
    }

    private void consistencyCheck() {
        int i2 = this.mLastLayoutParamsHashCode;
        if (i2 == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (i2 != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    public static Alignment createSwitchingAlignment(final Alignment alignment, final Alignment alignment2) {
        return new Alignment() {
            public int getAlignmentValue(View view, int i2, int i3) {
                boolean z = true;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    z = false;
                }
                return (!z ? alignment : alignment2).getAlignmentValue(view, i2, i3);
            }

            public String getDebugString() {
                return "SWITCHING[L:" + alignment.getDebugString() + ", R:" + alignment2.getDebugString() + "]";
            }

            public int getGravityOffset(View view, int i2) {
                boolean z = true;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    z = false;
                }
                return (!z ? alignment : alignment2).getGravityOffset(view, i2);
            }
        };
    }

    private void drawLine(Canvas canvas, int i2, int i3, int i4, int i5, Paint paint) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        if (isLayoutRtlCompat()) {
            int width = getWidth();
            canvas.drawLine((float) (width - i6), (float) i7, (float) (width - i8), (float) i9, paint);
            return;
        }
        canvas.drawLine((float) i6, (float) i7, (float) i8, (float) i9, paint);
    }

    public static boolean fits(int[] iArr, int i2, int i3, int i4) {
        if (i4 > iArr.length) {
            return false;
        }
        while (i3 < i4) {
            if (iArr[i3] > i2) {
                return false;
            }
            i3++;
        }
        return true;
    }

    public static Alignment getAlignment(int i2, boolean z) {
        int i3 = (i2 & (z ? 7 : 112)) >> (z ? 0 : 4);
        if (i3 == 1) {
            return CENTER;
        }
        if (i3 == 3) {
            return z ? LEFT : TOP;
        }
        if (i3 == 5) {
            return z ? RIGHT : BOTTOM;
        }
        if (i3 == 7) {
            return FILL;
        }
        if (i3 == 8388611) {
            return START;
        }
        if (i3 != 8388613) {
            return UNDEFINED_ALIGNMENT;
        }
        return END;
    }

    private int getDefaultMargin(View view, boolean z, boolean z2) {
        if (view.getClass() == Space.class || view.getClass() == android.widget.Space.class) {
            return 0;
        }
        return this.mDefaultGap / 2;
    }

    private int getMargin(View view, boolean z, boolean z2) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, z, z2);
        }
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = z2 ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = getLayoutParams(view);
        Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        return leadingMargins[z2 ? interval.min : interval.max];
    }

    private int getMeasurement(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int getTotalMargin(View view, boolean z) {
        return getMargin(view, z, true) + getMargin(view, z, false);
    }

    public static void handleInvalidParams(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        Axis axis = this.mHorizontalAxis;
        if (axis != null) {
            axis.invalidateStructure();
        }
        Axis axis2 = this.mVerticalAxis;
        if (axis2 != null) {
            axis2.invalidateStructure();
        }
        invalidateValues();
    }

    private void invalidateValues() {
        Axis axis = this.mHorizontalAxis;
        if (axis != null && this.mVerticalAxis != null) {
            axis.invalidateValues();
            this.mVerticalAxis.invalidateValues();
        }
    }

    private boolean isLayoutRtlCompat() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public static int max2(int[] iArr, int i2) {
        for (int max : iArr) {
            i2 = Math.max(i2, max);
        }
        return i2;
    }

    private void measureChildWithMargins2(View view, int i2, int i3, int i4, int i5) {
        view.measure(ViewGroup.getChildMeasureSpec(i2, getTotalMargin(view, true), i4), ViewGroup.getChildMeasureSpec(i3, getTotalMargin(view, false), i5));
    }

    private void measureChildrenWithMargins(int i2, int i3, boolean z) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z) {
                    measureChildWithMargins2(childAt, i2, i3, layoutParams.width, layoutParams.height);
                } else {
                    boolean z2 = this.mOrientation == 0;
                    Spec spec = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
                    if (spec.getAbsoluteAlignment(z2) == FILL) {
                        Interval interval = spec.span;
                        int[] locations = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        int totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z2);
                        if (z2) {
                            measureChildWithMargins2(childAt, i2, i3, totalMargin, layoutParams.height);
                        } else {
                            measureChildWithMargins2(childAt, i2, i3, layoutParams.width, totalMargin);
                        }
                    }
                }
            }
        }
    }

    public static void procrusteanFill(int[] iArr, int i2, int i3, int i4) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i2, length), Math.min(i3, length), i4);
    }

    public static void setCellGroup(LayoutParams layoutParams, int i2, int i3, int i4, int i5) {
        layoutParams.setRowSpecSpan(new Interval(i2, i3 + i2));
        layoutParams.setColumnSpecSpan(new Interval(i4, i5 + i4));
    }

    public static Spec spec(int i2, int i3, Alignment alignment, float f) {
        return new Spec(i2 != Integer.MIN_VALUE, i2, i3, alignment, f);
    }

    private void validateLayoutParams() {
        boolean z = this.mOrientation == 0;
        int i2 = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i2 == Integer.MIN_VALUE) {
            i2 = 0;
        }
        int[] iArr = new int[i2];
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
            Spec spec = z ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z2 = spec.startDefined;
            int size = interval.size();
            if (z2) {
                i3 = interval.min;
            }
            Spec spec2 = z ? layoutParams.columnSpec : layoutParams.rowSpec;
            Interval interval2 = spec2.span;
            boolean z3 = spec2.startDefined;
            int clip = clip(interval2, z3, i2);
            if (z3) {
                i4 = interval2.min;
            }
            if (i2 != 0) {
                if (!z2 || !z3) {
                    while (true) {
                        int i6 = i4 + clip;
                        if (fits(iArr, i3, i4, i6)) {
                            break;
                        } else if (z3) {
                            i3++;
                        } else if (i6 <= i2) {
                            i4++;
                        } else {
                            i3++;
                            i4 = 0;
                        }
                    }
                }
                procrusteanFill(iArr, i4, i4 + clip, i3 + size);
            }
            if (z) {
                setCellGroup(layoutParams, i3, size, i4, clip);
            } else {
                setCellGroup(layoutParams, i4, clip, i3, size);
            }
            i4 += clip;
        }
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    public final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    public int getMargin1(View view, boolean z, boolean z2) {
        LayoutParams layoutParams = getLayoutParams(view);
        int i2 = z ? z2 ? layoutParams.leftMargin : layoutParams.rightMargin : z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        return i2 == Integer.MIN_VALUE ? getDefaultMargin(view, layoutParams, z, z2) : i2;
    }

    public final int getMeasurementIncludingMargin(View view, boolean z) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(view, z) + getTotalMargin(view, z);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int[] iArr;
        int[] iArr2;
        GridLayout gridLayout = this;
        consistencyCheck();
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        gridLayout.mHorizontalAxis.layout((i6 - paddingLeft) - paddingRight);
        gridLayout.mVerticalAxis.layout(((i5 - i3) - paddingTop) - paddingBottom);
        int[] locations = gridLayout.mHorizontalAxis.getLocations();
        int[] locations2 = gridLayout.mVerticalAxis.getLocations();
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = gridLayout.getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                iArr2 = locations;
                iArr = locations2;
            } else {
                LayoutParams layoutParams = gridLayout.getLayoutParams(childAt);
                Spec spec = layoutParams.columnSpec;
                Spec spec2 = layoutParams.rowSpec;
                Interval interval = spec.span;
                Interval interval2 = spec2.span;
                int i8 = locations[interval.min];
                int i9 = locations2[interval2.min];
                int i10 = locations[interval.max] - i8;
                int i11 = locations2[interval2.max] - i9;
                int measurement = gridLayout.getMeasurement(childAt, true);
                int measurement2 = gridLayout.getMeasurement(childAt, z2);
                Alignment absoluteAlignment = spec.getAbsoluteAlignment(true);
                Alignment absoluteAlignment2 = spec2.getAbsoluteAlignment(z2);
                Bounds value = gridLayout.mHorizontalAxis.getGroupBounds().getValue(i7);
                Bounds value2 = gridLayout.mVerticalAxis.getGroupBounds().getValue(i7);
                int i12 = measurement2;
                iArr2 = locations;
                int gravityOffset = absoluteAlignment.getGravityOffset(childAt, i10 - value.size(true));
                int gravityOffset2 = absoluteAlignment2.getGravityOffset(childAt, i11 - value2.size(true));
                int margin = gridLayout.getMargin(childAt, true, true);
                int margin2 = gridLayout.getMargin(childAt, false, true);
                int margin3 = gridLayout.getMargin(childAt, true, false);
                int i13 = margin + margin3;
                int margin4 = margin2 + gridLayout.getMargin(childAt, false, false);
                Alignment alignment = absoluteAlignment2;
                Bounds bounds = value;
                Alignment alignment2 = absoluteAlignment;
                int i14 = i12;
                Alignment alignment3 = alignment;
                View view = childAt;
                int offset = bounds.getOffset(this, childAt, alignment2, measurement + i13, true);
                int i15 = i14;
                View view2 = view;
                iArr = locations2;
                int offset2 = value2.getOffset(this, view2, alignment3, i15 + margin4, false);
                int sizeInCell = alignment2.getSizeInCell(view2, measurement, i10 - i13);
                int sizeInCell2 = alignment3.getSizeInCell(view2, i15, i11 - margin4);
                int i16 = i8 + gravityOffset + offset;
                int i17 = !isLayoutRtlCompat() ? paddingLeft + margin + i16 : (((i6 - sizeInCell) - paddingRight) - margin3) - i16;
                int i18 = paddingTop + i9 + gravityOffset2 + offset2 + margin2;
                if (!(sizeInCell == view2.getMeasuredWidth() && sizeInCell2 == view2.getMeasuredHeight())) {
                    view2.measure(View.MeasureSpec.makeMeasureSpec(sizeInCell, 1073741824), View.MeasureSpec.makeMeasureSpec(sizeInCell2, 1073741824));
                }
                view2.layout(i17, i18, sizeInCell + i17, sizeInCell2 + i18);
            }
            i7++;
            z2 = false;
            gridLayout = this;
            locations = iArr2;
            locations2 = iArr;
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        consistencyCheck();
        invalidateValues();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int adjust = adjust(i2, -paddingLeft);
        int adjust2 = adjust(i3, -paddingTop);
        measureChildrenWithMargins(adjust, adjust2, true);
        if (this.mOrientation == 0) {
            i4 = this.mHorizontalAxis.getMeasure(adjust);
            measureChildrenWithMargins(adjust, adjust2, false);
            i5 = this.mVerticalAxis.getMeasure(adjust2);
        } else {
            int measure = this.mVerticalAxis.getMeasure(adjust2);
            measureChildrenWithMargins(adjust, adjust2, false);
            int i6 = measure;
            i4 = this.mHorizontalAxis.getMeasure(adjust);
            i5 = i6;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i4 + paddingLeft, getSuggestedMinimumWidth()), i2, 0), View.resolveSizeAndState(Math.max(i5 + paddingTop, getSuggestedMinimumHeight()), i3, 0));
    }

    public void requestLayout() {
        super.requestLayout();
        invalidateStructure();
    }

    public void setAlignmentMode(int i2) {
        this.mAlignmentMode = i2;
        requestLayout();
    }

    public void setColumnCount(int i2) {
        this.mHorizontalAxis.setCount(i2);
        invalidateStructure();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.mHorizontalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public void setOrientation(int i2) {
        if (this.mOrientation != i2) {
            this.mOrientation = i2;
            invalidateStructure();
            requestLayout();
        }
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    public void setRowCount(int i2) {
        this.mVerticalAxis.setCount(i2);
        invalidateStructure();
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z) {
        this.mVerticalAxis.setOrderPreserved(z);
        invalidateStructure();
        requestLayout();
    }

    public void setUseDefaultMargins(boolean z) {
        this.mUseDefaultMargins = z;
        requestLayout();
    }

    public static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        public Bounds() {
            reset();
        }

        public int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i2, boolean z) {
            return this.before - alignment.getAlignmentValue(view, i2, ViewGroupCompat.getLayoutMode(gridLayout));
        }

        public void include(int i2, int i3) {
            this.before = Math.max(this.before, i2);
            this.after = Math.max(this.after, i3);
        }

        public void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        public int size(boolean z) {
            if (z || !GridLayout.canStretch(this.flexibility)) {
                return this.before + this.after;
            }
            return 100000;
        }

        public String toString() {
            return "Bounds{before=" + this.before + ", after=" + this.after + ExtendedMessageFormat.END_FE;
        }

        public final void include(GridLayout gridLayout, View view, Spec spec, Axis axis, int i2) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(view, i2, ViewGroupCompat.getLayoutMode(gridLayout));
            include(alignmentValue, i2 - alignmentValue);
        }
    }

    public static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }

        public MutableInt(int i2) {
            this.value = i2;
        }
    }

    public static Spec spec(int i2, Alignment alignment, float f) {
        return spec(i2, 1, alignment, f);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public static Spec spec(int i2, int i3, float f) {
        return spec(i2, i3, UNDEFINED_ALIGNMENT, f);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private int getDefaultMargin(View view, boolean z, boolean z2, boolean z3) {
        return getDefaultMargin(view, z2, z3);
    }

    public static Spec spec(int i2, float f) {
        return spec(i2, 1, f);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class Spec {
        public static final float DEFAULT_WEIGHT = 0.0f;
        public static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        public final Alignment alignment;
        public final Interval span;
        public final boolean startDefined;
        public final float weight;

        public Spec(boolean z, Interval interval, Alignment alignment2, float f) {
            this.startDefined = z;
            this.span = interval;
            this.alignment = alignment2;
            this.weight = f;
        }

        public final Spec copyWriteAlignment(Alignment alignment2) {
            return new Spec(this.startDefined, this.span, alignment2, this.weight);
        }

        public final Spec copyWriteSpan(Interval interval) {
            return new Spec(this.startDefined, interval, this.alignment, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Spec.class != obj.getClass()) {
                return false;
            }
            Spec spec = (Spec) obj;
            return this.alignment.equals(spec.alignment) && this.span.equals(spec.span);
        }

        public Alignment getAbsoluteAlignment(boolean z) {
            Alignment alignment2 = this.alignment;
            if (alignment2 != GridLayout.UNDEFINED_ALIGNMENT) {
                return alignment2;
            }
            if (this.weight == 0.0f) {
                return z ? GridLayout.START : GridLayout.BASELINE;
            }
            return GridLayout.FILL;
        }

        public final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public int hashCode() {
            return (this.span.hashCode() * 31) + this.alignment.hashCode();
        }

        public Spec(boolean z, int i2, int i3, Alignment alignment2, float f) {
            this(z, new Interval(i2, i3 + i2), alignment2, f);
        }
    }

    private int getDefaultMargin(View view, LayoutParams layoutParams, boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.mUseDefaultMargins) {
            return 0;
        }
        Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
        Axis axis = z ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval interval = spec.span;
        if (!((!z || !isLayoutRtlCompat()) ? z2 : !z2) ? interval.max == axis.getCount() : interval.min == 0) {
            z3 = true;
        }
        return getDefaultMargin(view, z3, z, z2);
    }

    public static Spec spec(int i2, int i3, Alignment alignment) {
        return spec(i2, i3, alignment, 0.0f);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BOTTOM_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginBottom;
        public static final int COLUMN = R.styleable.GridLayout_Layout_layout_column;
        public static final int COLUMN_SPAN = R.styleable.GridLayout_Layout_layout_columnSpan;
        public static final int COLUMN_WEIGHT = R.styleable.GridLayout_Layout_layout_columnWeight;
        public static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        public static final int DEFAULT_HEIGHT = -2;
        public static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        public static final int DEFAULT_ROW = Integer.MIN_VALUE;
        public static final Interval DEFAULT_SPAN;
        public static final int DEFAULT_SPAN_SIZE;
        public static final int DEFAULT_WIDTH = -2;
        public static final int GRAVITY = R.styleable.GridLayout_Layout_layout_gravity;
        public static final int LEFT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginLeft;
        public static final int MARGIN = R.styleable.GridLayout_Layout_android_layout_margin;
        public static final int RIGHT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginRight;
        public static final int ROW = R.styleable.GridLayout_Layout_layout_row;
        public static final int ROW_SPAN = R.styleable.GridLayout_Layout_layout_rowSpan;
        public static final int ROW_WEIGHT = R.styleable.GridLayout_Layout_layout_rowWeight;
        public static final int TOP_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginTop;
        public Spec columnSpec;
        public Spec rowSpec;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, WrapperAdapter.HEADER);
            DEFAULT_SPAN = interval;
            DEFAULT_SPAN_SIZE = interval.size();
        }

        public LayoutParams(int i2, int i3, int i4, int i5, int i6, int i7, Spec spec, Spec spec2) {
            super(i2, i3);
            Spec spec3 = Spec.UNDEFINED;
            this.rowSpec = spec3;
            this.columnSpec = spec3;
            setMargins(i4, i5, i6, i7);
            this.rowSpec = spec;
            this.columnSpec = spec2;
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int i2 = obtainStyledAttributes.getInt(GRAVITY, 0);
                this.columnSpec = GridLayout.spec(obtainStyledAttributes.getInt(COLUMN, Integer.MIN_VALUE), obtainStyledAttributes.getInt(COLUMN_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i2, true), obtainStyledAttributes.getFloat(COLUMN_WEIGHT, 0.0f));
                this.rowSpec = GridLayout.spec(obtainStyledAttributes.getInt(ROW, Integer.MIN_VALUE), obtainStyledAttributes.getInt(ROW_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(i2, false), obtainStyledAttributes.getFloat(ROW_WEIGHT, 0.0f));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        private void reInitSuper(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(MARGIN, Integer.MIN_VALUE);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(LEFT_MARGIN, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(TOP_MARGIN, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(RIGHT_MARGIN, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(BOTTOM_MARGIN, dimensionPixelSize);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || LayoutParams.class != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            return this.columnSpec.equals(layoutParams.columnSpec) && this.rowSpec.equals(layoutParams.rowSpec);
        }

        public int hashCode() {
            return (this.rowSpec.hashCode() * 31) + this.columnSpec.hashCode();
        }

        public void setBaseAttributes(TypedArray typedArray, int i2, int i3) {
            this.width = typedArray.getLayoutDimension(i2, -2);
            this.height = typedArray.getLayoutDimension(i3, -2);
        }

        public final void setColumnSpecSpan(Interval interval) {
            this.columnSpec = this.columnSpec.copyWriteSpan(interval);
        }

        public void setGravity(int i2) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(i2, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(i2, true));
        }

        public final void setRowSpecSpan(Interval interval) {
            this.rowSpec = this.rowSpec.copyWriteSpan(interval);
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, spec, spec2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams() {
            /*
                r1 = this;
                androidx.gridlayout.widget.GridLayout$Spec r0 = androidx.gridlayout.widget.GridLayout.Spec.UNDEFINED
                r1.<init>((androidx.gridlayout.widget.GridLayout.Spec) r0, (androidx.gridlayout.widget.GridLayout.Spec) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.gridlayout.widget.GridLayout.LayoutParams.<init>():void");
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            this.rowSpec = layoutParams.rowSpec;
            this.columnSpec = layoutParams.columnSpec;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            reInitSuper(context, attributeSet);
            init(context, attributeSet);
        }
    }

    public static Spec spec(int i2, Alignment alignment) {
        return spec(i2, 1, alignment);
    }

    public static Spec spec(int i2, int i3) {
        return spec(i2, i3, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i2) {
        return spec(i2, 1);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        checkLayoutParams(layoutParams2, true);
        checkLayoutParams(layoutParams2, false);
        return true;
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context) {
        this(context, (AttributeSet) null);
    }
}
