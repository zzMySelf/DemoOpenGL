package shark.internal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import shark.GcRoot;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HprofRecord;
import shark.IgnoredReferenceMatcher;
import shark.LeakTraceReference;
import shark.LibraryLeakReferenceMatcher;
import shark.OnAnalysisProgressListener;
import shark.PrimitiveType;
import shark.ReferenceMatcher;
import shark.ReferencePattern;
import shark.ValueHolder;
import shark.internal.ReferencePathNode;
import shark.internal.hppc.LongScatterSet;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0004:;<=B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c0\u0007H\u0002J\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007*\u00020\u00132\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0014\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\f\u0010&\u001a\u00020\"*\u00020#H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020#H\u0002J\u0014\u0010'\u001a\u00020\u0011*\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020%*\u00020#H\u0002J \u0010+\u001a\b\u0012\u0004\u0012\u00020-0,*\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007H\u0002J\u0012\u00100\u001a\u000201*\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u001c\u00102\u001a\u00020\"*\u00020#2\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020%H\u0002J\u001c\u00105\u001a\u00020\"*\u00020#2\u0006\u00106\u001a\u00020.2\u0006\u00104\u001a\u00020%H\u0002J\u001c\u00107\u001a\u00020\"*\u00020#2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020%H\u0002R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lshark/internal/PathFinder;", "", "graph", "Lshark/HeapGraph;", "listener", "Lshark/OnAnalysisProgressListener;", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "(Lshark/HeapGraph;Lshark/OnAnalysisProgressListener;Ljava/util/List;)V", "fieldNameByClassName", "", "", "jniGlobalReferenceMatchers", "staticFieldNameByClassName", "threadNameReferenceMatchers", "determineSizeOfObjectInstances", "", "objectClass", "Lshark/HeapObject$HeapClass;", "findPathsFromGcRoots", "Lshark/internal/PathFinder$PathFindingResults;", "leakingObjectIds", "", "", "computeRetainedHeapSize", "", "sortedGcRoots", "Lkotlin/Pair;", "Lshark/HeapObject;", "Lshark/GcRoot;", "classHierarchyWithoutJavaLangObject", "javaLangObjectId", "enqueue", "", "Lshark/internal/PathFinder$State;", "node", "Lshark/internal/ReferencePathNode;", "enqueueGcRoots", "getRecordSize", "field", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "poll", "readAllNonNullFieldsOfReferenceType", "", "Lshark/internal/PathFinder$InstanceRefField;", "Lshark/HeapObject$HeapInstance;", "classHierarchy", "toLongScatterSet", "Lshark/internal/hppc/LongScatterSet;", "visitClassRecord", "heapClass", "parent", "visitInstance", "instance", "visitObjectArray", "objectArray", "Lshark/HeapObject$HeapObjectArray;", "InstanceRefField", "PathFindingResults", "State", "VisitTracker", "shark"}, k = 1, mv = {1, 4, 1})
/* compiled from: PathFinder.kt */
public final class PathFinder {
    private final Map<String, Map<String, ReferenceMatcher>> fieldNameByClassName;
    private final HeapGraph graph;
    private final Map<String, ReferenceMatcher> jniGlobalReferenceMatchers;
    private final OnAnalysisProgressListener listener;
    private final Map<String, Map<String, ReferenceMatcher>> staticFieldNameByClassName;
    private final Map<String, ReferenceMatcher> threadNameReferenceMatchers;

    public PathFinder(HeapGraph graph2, OnAnalysisProgressListener listener2, List<? extends ReferenceMatcher> referenceMatchers) {
        List appliedRefMatchers;
        Map newMap;
        Map newMap2;
        HeapGraph heapGraph = graph2;
        OnAnalysisProgressListener onAnalysisProgressListener = listener2;
        List<? extends ReferenceMatcher> $this$filter$iv = referenceMatchers;
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        Intrinsics.checkParameterIsNotNull(onAnalysisProgressListener, "listener");
        Intrinsics.checkParameterIsNotNull($this$filter$iv, "referenceMatchers");
        this.graph = heapGraph;
        this.listener = onAnalysisProgressListener;
        Map fieldNameByClassName2 = new LinkedHashMap();
        Map staticFieldNameByClassName2 = new LinkedHashMap();
        Map threadNames = new LinkedHashMap();
        Map jniGlobals = new LinkedHashMap();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ReferenceMatcher it = (ReferenceMatcher) element$iv$iv;
            if ((it instanceof IgnoredReferenceMatcher) || ((it instanceof LibraryLeakReferenceMatcher) && ((LibraryLeakReferenceMatcher) it).getPatternApplies().invoke(this.graph).booleanValue())) {
                destination$iv$iv.add(element$iv$iv);
            }
            HeapGraph heapGraph2 = graph2;
            OnAnalysisProgressListener onAnalysisProgressListener2 = listener2;
        }
        List<ReferenceMatcher> appliedRefMatchers2 = (List) destination$iv$iv;
        for (ReferenceMatcher referenceMatcher : appliedRefMatchers2) {
            ReferencePattern pattern = referenceMatcher.getPattern();
            if (pattern instanceof ReferencePattern.JavaLocalPattern) {
                threadNames.put(((ReferencePattern.JavaLocalPattern) pattern).getThreadName(), referenceMatcher);
                appliedRefMatchers = appliedRefMatchers2;
            } else if (pattern instanceof ReferencePattern.StaticFieldPattern) {
                Map mapOrNull = staticFieldNameByClassName2.get(((ReferencePattern.StaticFieldPattern) pattern).getClassName());
                if (mapOrNull != null) {
                    appliedRefMatchers = appliedRefMatchers2;
                    newMap2 = mapOrNull;
                } else {
                    newMap2 = new LinkedHashMap();
                    appliedRefMatchers = appliedRefMatchers2;
                    staticFieldNameByClassName2.put(((ReferencePattern.StaticFieldPattern) pattern).getClassName(), newMap2);
                }
                newMap2.put(((ReferencePattern.StaticFieldPattern) pattern).getFieldName(), referenceMatcher);
            } else {
                appliedRefMatchers = appliedRefMatchers2;
                if (pattern instanceof ReferencePattern.InstanceFieldPattern) {
                    Map mapOrNull2 = fieldNameByClassName2.get(((ReferencePattern.InstanceFieldPattern) pattern).getClassName());
                    if (mapOrNull2 != null) {
                        newMap = mapOrNull2;
                    } else {
                        newMap = new LinkedHashMap();
                        fieldNameByClassName2.put(((ReferencePattern.InstanceFieldPattern) pattern).getClassName(), newMap);
                    }
                    newMap.put(((ReferencePattern.InstanceFieldPattern) pattern).getFieldName(), referenceMatcher);
                } else if (pattern instanceof ReferencePattern.NativeGlobalVariablePattern) {
                    jniGlobals.put(((ReferencePattern.NativeGlobalVariablePattern) pattern).getClassName(), referenceMatcher);
                }
            }
            appliedRefMatchers2 = appliedRefMatchers;
        }
        this.fieldNameByClassName = fieldNameByClassName2;
        this.staticFieldNameByClassName = staticFieldNameByClassName2;
        this.threadNameReferenceMatchers = threadNames;
        this.jniGlobalReferenceMatchers = jniGlobals;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lshark/internal/PathFinder$PathFindingResults;", "", "pathsToLeakingObjects", "", "Lshark/internal/ReferencePathNode;", "dominatorTree", "Lshark/internal/DominatorTree;", "(Ljava/util/List;Lshark/internal/DominatorTree;)V", "getDominatorTree", "()Lshark/internal/DominatorTree;", "getPathsToLeakingObjects", "()Ljava/util/List;", "shark"}, k = 1, mv = {1, 4, 1})
    /* compiled from: PathFinder.kt */
    public static final class PathFindingResults {
        private final DominatorTree dominatorTree;
        private final List<ReferencePathNode> pathsToLeakingObjects;

        public PathFindingResults(List<? extends ReferencePathNode> pathsToLeakingObjects2, DominatorTree dominatorTree2) {
            Intrinsics.checkParameterIsNotNull(pathsToLeakingObjects2, "pathsToLeakingObjects");
            this.pathsToLeakingObjects = pathsToLeakingObjects2;
            this.dominatorTree = dominatorTree2;
        }

        public final List<ReferencePathNode> getPathsToLeakingObjects() {
            return this.pathsToLeakingObjects;
        }

        public final DominatorTree getDominatorTree() {
            return this.dominatorTree;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lshark/internal/PathFinder$VisitTracker;", "", "()V", "visited", "", "objectId", "", "parentObjectId", "Dominated", "Visited", "Lshark/internal/PathFinder$VisitTracker$Dominated;", "Lshark/internal/PathFinder$VisitTracker$Visited;", "shark"}, k = 1, mv = {1, 4, 1})
    /* compiled from: PathFinder.kt */
    public static abstract class VisitTracker {
        public abstract boolean visited(long j2, long j3);

        private VisitTracker() {
        }

        public /* synthetic */ VisitTracker(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lshark/internal/PathFinder$VisitTracker$Dominated;", "Lshark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "dominatorTree", "Lshark/internal/DominatorTree;", "getDominatorTree", "()Lshark/internal/DominatorTree;", "visited", "", "objectId", "", "parentObjectId", "shark"}, k = 1, mv = {1, 4, 1})
        /* compiled from: PathFinder.kt */
        public static final class Dominated extends VisitTracker {
            private final DominatorTree dominatorTree;

            public Dominated(int expectedElements) {
                super((DefaultConstructorMarker) null);
                this.dominatorTree = new DominatorTree(expectedElements);
            }

            public final DominatorTree getDominatorTree() {
                return this.dominatorTree;
            }

            public boolean visited(long objectId, long parentObjectId) {
                return this.dominatorTree.updateDominated(objectId, parentObjectId);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lshark/internal/PathFinder$VisitTracker$Visited;", "Lshark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "visitedSet", "Lshark/internal/hppc/LongScatterSet;", "visited", "", "objectId", "", "parentObjectId", "shark"}, k = 1, mv = {1, 4, 1})
        /* compiled from: PathFinder.kt */
        public static final class Visited extends VisitTracker {
            private final LongScatterSet visitedSet;

            public Visited(int expectedElements) {
                super((DefaultConstructorMarker) null);
                this.visitedSet = new LongScatterSet(expectedElements);
            }

            public boolean visited(long objectId, long parentObjectId) {
                return !this.visitedSet.add(objectId);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lshark/internal/PathFinder$State;", "", "leakingObjectIds", "Lshark/internal/hppc/LongScatterSet;", "sizeOfObjectInstances", "", "computeRetainedHeapSize", "", "javaLangObjectId", "", "estimatedVisitedObjects", "(Lshark/internal/hppc/LongScatterSet;IZJI)V", "getComputeRetainedHeapSize", "()Z", "getJavaLangObjectId", "()J", "getLeakingObjectIds", "()Lshark/internal/hppc/LongScatterSet;", "queuesNotEmpty", "getQueuesNotEmpty", "getSizeOfObjectInstances", "()I", "toVisitLastQueue", "Ljava/util/Deque;", "Lshark/internal/ReferencePathNode;", "getToVisitLastQueue", "()Ljava/util/Deque;", "toVisitLastSet", "getToVisitLastSet", "toVisitQueue", "getToVisitQueue", "toVisitSet", "getToVisitSet", "visitTracker", "Lshark/internal/PathFinder$VisitTracker;", "getVisitTracker", "()Lshark/internal/PathFinder$VisitTracker;", "visitingLast", "getVisitingLast", "setVisitingLast", "(Z)V", "shark"}, k = 1, mv = {1, 4, 1})
    /* compiled from: PathFinder.kt */
    private static final class State {
        private final boolean computeRetainedHeapSize;
        private final long javaLangObjectId;
        private final LongScatterSet leakingObjectIds;
        private final int sizeOfObjectInstances;
        private final Deque<ReferencePathNode> toVisitLastQueue = new ArrayDeque();
        private final LongScatterSet toVisitLastSet = new LongScatterSet(0, 1, (DefaultConstructorMarker) null);
        private final Deque<ReferencePathNode> toVisitQueue = new ArrayDeque();
        private final LongScatterSet toVisitSet = new LongScatterSet(0, 1, (DefaultConstructorMarker) null);
        private final VisitTracker visitTracker;
        private boolean visitingLast;

        public State(LongScatterSet leakingObjectIds2, int sizeOfObjectInstances2, boolean computeRetainedHeapSize2, long javaLangObjectId2, int estimatedVisitedObjects) {
            VisitTracker visitTracker2;
            Intrinsics.checkParameterIsNotNull(leakingObjectIds2, "leakingObjectIds");
            this.leakingObjectIds = leakingObjectIds2;
            this.sizeOfObjectInstances = sizeOfObjectInstances2;
            this.computeRetainedHeapSize = computeRetainedHeapSize2;
            this.javaLangObjectId = javaLangObjectId2;
            if (computeRetainedHeapSize2) {
                visitTracker2 = new VisitTracker.Dominated(estimatedVisitedObjects);
            } else {
                visitTracker2 = new VisitTracker.Visited(estimatedVisitedObjects);
            }
            this.visitTracker = visitTracker2;
        }

        public final LongScatterSet getLeakingObjectIds() {
            return this.leakingObjectIds;
        }

        public final int getSizeOfObjectInstances() {
            return this.sizeOfObjectInstances;
        }

        public final boolean getComputeRetainedHeapSize() {
            return this.computeRetainedHeapSize;
        }

        public final long getJavaLangObjectId() {
            return this.javaLangObjectId;
        }

        public final Deque<ReferencePathNode> getToVisitQueue() {
            return this.toVisitQueue;
        }

        public final Deque<ReferencePathNode> getToVisitLastQueue() {
            return this.toVisitLastQueue;
        }

        public final LongScatterSet getToVisitSet() {
            return this.toVisitSet;
        }

        public final LongScatterSet getToVisitLastSet() {
            return this.toVisitLastSet;
        }

        public final boolean getQueuesNotEmpty() {
            return (this.toVisitQueue.isEmpty() ^ true) || (this.toVisitLastQueue.isEmpty() ^ true);
        }

        public final VisitTracker getVisitTracker() {
            return this.visitTracker;
        }

        public final boolean getVisitingLast() {
            return this.visitingLast;
        }

        public final void setVisitingLast(boolean z) {
            this.visitingLast = z;
        }
    }

    public final PathFindingResults findPathsFromGcRoots(Set<Long> leakingObjectIds, boolean computeRetainedHeapSize) {
        Intrinsics.checkParameterIsNotNull(leakingObjectIds, "leakingObjectIds");
        this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_PATHS_TO_RETAINED_OBJECTS);
        HeapObject.HeapClass objectClass = this.graph.findClassByName("java.lang.Object");
        return findPathsFromGcRoots(new State(toLongScatterSet(leakingObjectIds), determineSizeOfObjectInstances(objectClass, this.graph), computeRetainedHeapSize, objectClass != null ? objectClass.getObjectId() : -1, RangesKt.coerceAtLeast(this.graph.getInstanceCount() / 2, 4)));
    }

    private final int determineSizeOfObjectInstances(HeapObject.HeapClass objectClass, HeapGraph graph2) {
        int sizeOfObjectOnArt;
        if (objectClass == null || objectClass.readFieldsByteSize() != (sizeOfObjectOnArt = graph2.getIdentifierByteSize() + PrimitiveType.INT.getByteSize())) {
            return 0;
        }
        return sizeOfObjectOnArt;
    }

    private final LongScatterSet toLongScatterSet(Set<Long> $this$toLongScatterSet) {
        LongScatterSet longScatterSet = new LongScatterSet(0, 1, (DefaultConstructorMarker) null);
        longScatterSet.ensureCapacity($this$toLongScatterSet.size());
        for (Number longValue : $this$toLongScatterSet) {
            longScatterSet.add(longValue.longValue());
        }
        return longScatterSet;
    }

    private final PathFindingResults findPathsFromGcRoots(State $this$findPathsFromGcRoots) {
        enqueueGcRoots($this$findPathsFromGcRoots);
        List shortestPathsToLeakingObjects = new ArrayList();
        while ($this$findPathsFromGcRoots.getQueuesNotEmpty()) {
            ReferencePathNode node = poll($this$findPathsFromGcRoots);
            if ($this$findPathsFromGcRoots.getLeakingObjectIds().contains(node.getObjectId())) {
                shortestPathsToLeakingObjects.add(node);
                if (shortestPathsToLeakingObjects.size() == $this$findPathsFromGcRoots.getLeakingObjectIds().size()) {
                    if (!$this$findPathsFromGcRoots.getComputeRetainedHeapSize()) {
                        break;
                    }
                    this.listener.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_DOMINATORS);
                }
            }
            HeapObject heapObject = this.graph.findObjectById(node.getObjectId());
            if (heapObject instanceof HeapObject.HeapClass) {
                visitClassRecord($this$findPathsFromGcRoots, (HeapObject.HeapClass) heapObject, node);
            } else if (heapObject instanceof HeapObject.HeapInstance) {
                visitInstance($this$findPathsFromGcRoots, (HeapObject.HeapInstance) heapObject, node);
            } else if (heapObject instanceof HeapObject.HeapObjectArray) {
                visitObjectArray($this$findPathsFromGcRoots, (HeapObject.HeapObjectArray) heapObject, node);
            }
        }
        return new PathFindingResults(shortestPathsToLeakingObjects, $this$findPathsFromGcRoots.getVisitTracker() instanceof VisitTracker.Dominated ? ((VisitTracker.Dominated) $this$findPathsFromGcRoots.getVisitTracker()).getDominatorTree() : null);
    }

    private final ReferencePathNode poll(State $this$poll) {
        if ($this$poll.getVisitingLast() || $this$poll.getToVisitQueue().isEmpty()) {
            $this$poll.setVisitingLast(true);
            ReferencePathNode removedNode = $this$poll.getToVisitLastQueue().poll();
            $this$poll.getToVisitLastSet().remove(removedNode.getObjectId());
            Intrinsics.checkExpressionValueIsNotNull(removedNode, "removedNode");
            return removedNode;
        }
        ReferencePathNode removedNode2 = $this$poll.getToVisitQueue().poll();
        $this$poll.getToVisitSet().remove(removedNode2.getObjectId());
        Intrinsics.checkExpressionValueIsNotNull(removedNode2, "removedNode");
        return removedNode2;
    }

    private final void enqueueGcRoots(State $this$enqueueGcRoots) {
        Map threadsBySerialNumber;
        List gcRoots;
        ReferenceMatcher referenceMatcher;
        GcRoot gcRoot;
        ReferencePathNode.ChildNode childNode;
        State state = $this$enqueueGcRoots;
        List<Pair> gcRoots2 = sortedGcRoots();
        Map threadNames = new LinkedHashMap();
        Map threadsBySerialNumber2 = new LinkedHashMap();
        for (Pair $dstr$objectRecord$gcRoot : gcRoots2) {
            HeapObject objectRecord = (HeapObject) $dstr$objectRecord$gcRoot.component1();
            GcRoot gcRoot2 = (GcRoot) $dstr$objectRecord$gcRoot.component2();
            if (gcRoot2 instanceof GcRoot.ThreadObject) {
                Integer valueOf = Integer.valueOf(((GcRoot.ThreadObject) gcRoot2).getThreadSerialNumber());
                HeapObject.HeapInstance asInstance = objectRecord.getAsInstance();
                if (asInstance == null) {
                    Intrinsics.throwNpe();
                }
                threadsBySerialNumber2.put(valueOf, TuplesKt.to(asInstance, gcRoot2));
                enqueue(state, new ReferencePathNode.RootNode.NormalRootNode(gcRoot2.getId(), gcRoot2));
                gcRoots = gcRoots2;
                threadsBySerialNumber = threadsBySerialNumber2;
            } else if (gcRoot2 instanceof GcRoot.JavaFrame) {
                Pair threadPair = (Pair) threadsBySerialNumber2.get(Integer.valueOf(((GcRoot.JavaFrame) gcRoot2).getThreadSerialNumber()));
                if (threadPair == null) {
                    enqueue(state, new ReferencePathNode.RootNode.NormalRootNode(gcRoot2.getId(), gcRoot2));
                    gcRoots = gcRoots2;
                    threadsBySerialNumber = threadsBySerialNumber2;
                } else {
                    HeapObject.HeapInstance threadInstance = (HeapObject.HeapInstance) threadPair.component1();
                    GcRoot.ThreadObject threadRoot = (GcRoot.ThreadObject) threadPair.component2();
                    String threadName = (String) threadNames.get(threadInstance);
                    if (threadName != null) {
                        HeapObject.HeapInstance heapInstance = threadInstance;
                        gcRoots = gcRoots2;
                        threadsBySerialNumber = threadsBySerialNumber2;
                        gcRoot = gcRoot2;
                        HeapObject heapObject = objectRecord;
                    } else {
                        HeapObject.HeapInstance heapInstance2 = threadInstance;
                        gcRoots = gcRoots2;
                        gcRoot = gcRoot2;
                        Map map = threadsBySerialNumber2;
                        threadsBySerialNumber = threadsBySerialNumber2;
                        HeapObject heapObject2 = objectRecord;
                        threadName = (String) new PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1(threadInstance, this, $this$enqueueGcRoots, map, threadNames).invoke();
                    }
                    ReferenceMatcher referenceMatcher2 = this.threadNameReferenceMatchers.get(threadName);
                    if (!(referenceMatcher2 instanceof IgnoredReferenceMatcher)) {
                        ReferencePathNode.RootNode.NormalRootNode rootNode = new ReferencePathNode.RootNode.NormalRootNode(threadRoot.getId(), gcRoot);
                        LeakTraceReference.ReferenceType refFromParentType = LeakTraceReference.ReferenceType.LOCAL;
                        if (referenceMatcher2 instanceof LibraryLeakReferenceMatcher) {
                            childNode = new ReferencePathNode.ChildNode.LibraryLeakChildNode(gcRoot.getId(), rootNode, refFromParentType, "", (LibraryLeakReferenceMatcher) referenceMatcher2, 0, 32, (DefaultConstructorMarker) null);
                        } else {
                            childNode = new ReferencePathNode.ChildNode.NormalNode(gcRoot.getId(), rootNode, refFromParentType, "", 0, 16, (DefaultConstructorMarker) null);
                        }
                        String str = threadName;
                        enqueue(state, childNode);
                    }
                }
            } else {
                gcRoots = gcRoots2;
                threadsBySerialNumber = threadsBySerialNumber2;
                GcRoot gcRoot3 = gcRoot2;
                HeapObject objectRecord2 = objectRecord;
                if (gcRoot3 instanceof GcRoot.JniGlobal) {
                    if (objectRecord2 instanceof HeapObject.HeapClass) {
                        referenceMatcher = this.jniGlobalReferenceMatchers.get(((HeapObject.HeapClass) objectRecord2).getName());
                    } else if (objectRecord2 instanceof HeapObject.HeapInstance) {
                        referenceMatcher = this.jniGlobalReferenceMatchers.get(((HeapObject.HeapInstance) objectRecord2).getInstanceClassName());
                    } else if (objectRecord2 instanceof HeapObject.HeapObjectArray) {
                        referenceMatcher = this.jniGlobalReferenceMatchers.get(((HeapObject.HeapObjectArray) objectRecord2).getArrayClassName());
                    } else if (objectRecord2 instanceof HeapObject.HeapPrimitiveArray) {
                        referenceMatcher = this.jniGlobalReferenceMatchers.get(((HeapObject.HeapPrimitiveArray) objectRecord2).getArrayClassName());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                        if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                            enqueue(state, new ReferencePathNode.RootNode.LibraryLeakRootNode(gcRoot3.getId(), gcRoot3, (LibraryLeakReferenceMatcher) referenceMatcher));
                        } else {
                            enqueue(state, new ReferencePathNode.RootNode.NormalRootNode(gcRoot3.getId(), gcRoot3));
                        }
                    }
                } else {
                    enqueue(state, new ReferencePathNode.RootNode.NormalRootNode(gcRoot3.getId(), gcRoot3));
                }
            }
            gcRoots2 = gcRoots;
            threadsBySerialNumber2 = threadsBySerialNumber;
        }
    }

    private final List<Pair<HeapObject, GcRoot>> sortedGcRoots() {
        Function1 rootClassName = PathFinder$sortedGcRoots$rootClassName$1.INSTANCE;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : this.graph.getGcRoots()) {
            if (this.graph.objectExists(((GcRoot) element$iv$iv).getId())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<GcRoot> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (GcRoot it : $this$map$iv) {
            destination$iv$iv2.add(TuplesKt.to(this.graph.findObjectById(it.getId()), it));
        }
        return CollectionsKt.sortedWith((List) destination$iv$iv2, new PathFinder$sortedGcRoots$3(rootClassName));
    }

    private final void visitClassRecord(State $this$visitClassRecord, HeapObject.HeapClass heapClass, ReferencePathNode parent) {
        Map ignoredStaticFields;
        ReferencePathNode.ChildNode childNode;
        Map ignoredStaticFields2 = this.staticFieldNameByClassName.get(heapClass.getName());
        if (ignoredStaticFields2 == null) {
            ignoredStaticFields2 = MapsKt.emptyMap();
        }
        for (HeapField staticField : heapClass.readStaticFields()) {
            if (!staticField.getValue().isNonNullReference()) {
                State state = $this$visitClassRecord;
                ignoredStaticFields = ignoredStaticFields2;
            } else {
                String fieldName = staticField.getName();
                if (Intrinsics.areEqual((Object) fieldName, (Object) "$staticOverhead")) {
                    State state2 = $this$visitClassRecord;
                    ignoredStaticFields = ignoredStaticFields2;
                } else if (Intrinsics.areEqual((Object) fieldName, (Object) "$classOverhead")) {
                    State state3 = $this$visitClassRecord;
                    ignoredStaticFields = ignoredStaticFields2;
                } else {
                    ValueHolder holder = staticField.getValue().getHolder();
                    if (holder != null) {
                        long objectId = ((ValueHolder.ReferenceHolder) holder).getValue();
                        ReferenceMatcher referenceMatcher = (ReferenceMatcher) ignoredStaticFields2.get(fieldName);
                        if (referenceMatcher == null) {
                            childNode = new ReferencePathNode.ChildNode.NormalNode(objectId, parent, LeakTraceReference.ReferenceType.STATIC_FIELD, fieldName, 0, 16, (DefaultConstructorMarker) null);
                            ignoredStaticFields = ignoredStaticFields2;
                        } else if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                            ignoredStaticFields = ignoredStaticFields2;
                            ReferenceMatcher referenceMatcher2 = referenceMatcher;
                            childNode = new ReferencePathNode.ChildNode.LibraryLeakChildNode(objectId, parent, LeakTraceReference.ReferenceType.STATIC_FIELD, fieldName, (LibraryLeakReferenceMatcher) referenceMatcher, 0, 32, (DefaultConstructorMarker) null);
                        } else {
                            ignoredStaticFields = ignoredStaticFields2;
                            if (referenceMatcher instanceof IgnoredReferenceMatcher) {
                                childNode = null;
                            } else {
                                State state4 = $this$visitClassRecord;
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        ReferencePathNode.ChildNode node = childNode;
                        if (node != null) {
                            enqueue($this$visitClassRecord, node);
                        } else {
                            State state5 = $this$visitClassRecord;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type shark.ValueHolder.ReferenceHolder");
                    }
                }
            }
            ignoredStaticFields2 = ignoredStaticFields;
        }
    }

    private final void visitInstance(State $this$visitInstance, HeapObject.HeapInstance instance, ReferencePathNode parent) {
        ReferencePathNode.ChildNode childNode;
        LinkedHashMap fieldReferenceMatchers = new LinkedHashMap();
        for (HeapObject.HeapClass it : instance.getInstanceClass().getClassHierarchy()) {
            Map referenceMatcherByField = this.fieldNameByClassName.get(it.getName());
            if (referenceMatcherByField != null) {
                for (Map.Entry entry : referenceMatcherByField.entrySet()) {
                    String fieldName = (String) entry.getKey();
                    ReferenceMatcher referenceMatcher = (ReferenceMatcher) entry.getValue();
                    if (!fieldReferenceMatchers.containsKey(fieldName)) {
                        fieldReferenceMatchers.put(fieldName, referenceMatcher);
                    }
                }
            }
        }
        List<InstanceRefField> $this$sortBy$iv = readAllNonNullFieldsOfReferenceType(instance, classHierarchyWithoutJavaLangObject(instance.getInstanceClass(), $this$visitInstance.getJavaLangObjectId()));
        List $this$sortBy$iv2 = $this$sortBy$iv;
        if ($this$sortBy$iv2.size() > 1) {
            CollectionsKt.sortWith($this$sortBy$iv2, new PathFinder$visitInstance$$inlined$sortBy$1());
        }
        for (InstanceRefField instanceRefField : $this$sortBy$iv) {
            ReferenceMatcher referenceMatcher2 = (ReferenceMatcher) fieldReferenceMatchers.get(instanceRefField.getFieldName());
            if (referenceMatcher2 == null) {
                childNode = new ReferencePathNode.ChildNode.NormalNode(instanceRefField.getRefObjectId(), parent, LeakTraceReference.ReferenceType.INSTANCE_FIELD, instanceRefField.getFieldName(), instanceRefField.getDeclaringClassId());
            } else if (referenceMatcher2 instanceof LibraryLeakReferenceMatcher) {
                childNode = new ReferencePathNode.ChildNode.LibraryLeakChildNode(instanceRefField.getRefObjectId(), parent, LeakTraceReference.ReferenceType.INSTANCE_FIELD, instanceRefField.getFieldName(), (LibraryLeakReferenceMatcher) referenceMatcher2, instanceRefField.getDeclaringClassId());
            } else if (referenceMatcher2 instanceof IgnoredReferenceMatcher) {
                childNode = null;
            } else {
                State state = $this$visitInstance;
                throw new NoWhenBranchMatchedException();
            }
            ReferencePathNode.ChildNode node = childNode;
            if (node != null) {
                enqueue($this$visitInstance, node);
            } else {
                State state2 = $this$visitInstance;
            }
        }
        State state3 = $this$visitInstance;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lshark/internal/PathFinder$InstanceRefField;", "", "declaringClassId", "", "refObjectId", "fieldName", "", "(JJLjava/lang/String;)V", "getDeclaringClassId", "()J", "getFieldName", "()Ljava/lang/String;", "getRefObjectId", "shark"}, k = 1, mv = {1, 4, 1})
    /* compiled from: PathFinder.kt */
    private static final class InstanceRefField {
        private final long declaringClassId;
        private final String fieldName;
        private final long refObjectId;

        public InstanceRefField(long declaringClassId2, long refObjectId2, String fieldName2) {
            Intrinsics.checkParameterIsNotNull(fieldName2, "fieldName");
            this.declaringClassId = declaringClassId2;
            this.refObjectId = refObjectId2;
            this.fieldName = fieldName2;
        }

        public final long getDeclaringClassId() {
            return this.declaringClassId;
        }

        public final long getRefObjectId() {
            return this.refObjectId;
        }

        public final String getFieldName() {
            return this.fieldName;
        }
    }

    private final List<InstanceRefField> readAllNonNullFieldsOfReferenceType(HeapObject.HeapInstance $this$readAllNonNullFieldsOfReferenceType, List<HeapObject.HeapClass> classHierarchy) {
        HeapGraph hprofGraph;
        HeapGraph hprofGraph2 = $this$readAllNonNullFieldsOfReferenceType.getGraph();
        FieldIdReader fieldReader = null;
        List result = new ArrayList();
        int skipBytesCount = 0;
        for (HeapObject.HeapClass heapClass : classHierarchy) {
            for (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord : heapClass.readRecordFields()) {
                if (fieldRecord.getType() != 2) {
                    skipBytesCount += getRecordSize(hprofGraph2, fieldRecord);
                    hprofGraph = hprofGraph2;
                } else {
                    if (fieldReader == null) {
                        fieldReader = new FieldIdReader($this$readAllNonNullFieldsOfReferenceType.readRecord(), hprofGraph2.getIdentifierByteSize());
                    }
                    fieldReader.skipBytes(skipBytesCount);
                    skipBytesCount = 0;
                    long objectId = fieldReader.readId();
                    if (objectId != 0) {
                        hprofGraph = hprofGraph2;
                        InstanceRefField instanceRefField = r9;
                        InstanceRefField instanceRefField2 = new InstanceRefField(heapClass.getObjectId(), objectId, heapClass.instanceFieldName(fieldRecord));
                        result.add(instanceRefField);
                    } else {
                        hprofGraph = hprofGraph2;
                    }
                }
                hprofGraph2 = hprofGraph;
            }
            HeapGraph heapGraph = hprofGraph2;
        }
        return result;
    }

    private final List<HeapObject.HeapClass> classHierarchyWithoutJavaLangObject(HeapObject.HeapClass $this$classHierarchyWithoutJavaLangObject, long javaLangObjectId) {
        List<HeapObject.HeapClass> arrayList = new ArrayList<>();
        HeapObject.HeapClass parent = $this$classHierarchyWithoutJavaLangObject;
        while (parent != null && parent.getObjectId() != javaLangObjectId) {
            arrayList.add(parent);
            parent = parent.getSuperclass();
        }
        return arrayList;
    }

    private final int getRecordSize(HeapGraph $this$getRecordSize, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord field) {
        int type = field.getType();
        if (type == 2) {
            return $this$getRecordSize.getIdentifierByteSize();
        }
        if (type == PrimitiveType.BOOLEAN.getHprofType()) {
            return 1;
        }
        if (type == PrimitiveType.CHAR.getHprofType()) {
            return 2;
        }
        if (type == PrimitiveType.FLOAT.getHprofType()) {
            return 4;
        }
        if (type == PrimitiveType.DOUBLE.getHprofType()) {
            return 8;
        }
        if (type == PrimitiveType.BYTE.getHprofType()) {
            return 1;
        }
        if (type == PrimitiveType.SHORT.getHprofType()) {
            return 2;
        }
        if (type == PrimitiveType.INT.getHprofType()) {
            return 4;
        }
        if (type == PrimitiveType.LONG.getHprofType()) {
            return 8;
        }
        throw new IllegalStateException("Unknown type " + field.getType());
    }

    private final void visitObjectArray(State $this$visitObjectArray, HeapObject.HeapObjectArray objectArray, ReferencePathNode parent) {
        long[] $this$filter$iv = objectArray.readRecord().getElementIds();
        Collection destination$iv$iv = new ArrayList();
        for (long element$iv$iv : $this$filter$iv) {
            long objectId = element$iv$iv;
            if (objectId != 0 && this.graph.objectExists(objectId)) {
                destination$iv$iv.add(Long.valueOf(element$iv$iv));
            }
        }
        int index = 0;
        for (Object item$iv : (List) destination$iv$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            enqueue($this$visitObjectArray, new ReferencePathNode.ChildNode.NormalNode(((Number) item$iv).longValue(), parent, LeakTraceReference.ReferenceType.ARRAY_ENTRY, String.valueOf(index), 0, 16, (DefaultConstructorMarker) null));
            index = index$iv;
        }
        State state = $this$visitObjectArray;
    }

    private final void enqueue(State $this$enqueue, ReferencePathNode node) {
        Sequence $this$all$iv;
        HeapObject.HeapClass heapClass;
        ReferencePathNode it;
        ReferencePathNode referencePathNode = node;
        long parentObjectId = 0;
        if (node.getObjectId() != 0) {
            boolean skip = false;
            boolean visitLast = $this$enqueue.getVisitingLast() || (referencePathNode instanceof ReferencePathNode.LibraryLeakNode) || ((referencePathNode instanceof ReferencePathNode.RootNode) && (((ReferencePathNode.RootNode) referencePathNode).getGcRoot() instanceof GcRoot.ThreadObject)) || ((referencePathNode instanceof ReferencePathNode.ChildNode.NormalNode) && (((ReferencePathNode.ChildNode.NormalNode) referencePathNode).getParent() instanceof ReferencePathNode.RootNode) && (((ReferencePathNode.RootNode) ((ReferencePathNode.ChildNode.NormalNode) referencePathNode).getParent()).getGcRoot() instanceof GcRoot.JavaFrame));
            if (!(referencePathNode instanceof ReferencePathNode.RootNode)) {
                if (referencePathNode != null) {
                    parentObjectId = ((ReferencePathNode.ChildNode) referencePathNode).getParent().getObjectId();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type shark.internal.ReferencePathNode.ChildNode");
                }
            }
            boolean alreadyEnqueued = $this$enqueue.getVisitTracker().visited(node.getObjectId(), parentObjectId);
            if (alreadyEnqueued && (visitLast || $this$enqueue.getToVisitSet().contains(node.getObjectId()) || !$this$enqueue.getToVisitLastSet().contains(node.getObjectId()))) {
                return;
            }
            if (alreadyEnqueued) {
                $this$enqueue.getToVisitQueue().add(referencePathNode);
                $this$enqueue.getToVisitSet().add(node.getObjectId());
                for (Object element$iv : $this$enqueue.getToVisitLastQueue()) {
                    if (((ReferencePathNode) element$iv).getObjectId() == node.getObjectId()) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        $this$enqueue.getToVisitLastQueue().remove((ReferencePathNode) element$iv);
                        $this$enqueue.getToVisitLastSet().remove(node.getObjectId());
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            if (!$this$enqueue.getLeakingObjectIds().contains(node.getObjectId())) {
                HeapObject graphObject = this.graph.findObjectById(node.getObjectId());
                if (!(graphObject instanceof HeapObject.HeapClass)) {
                    if (graphObject instanceof HeapObject.HeapInstance) {
                        if (((HeapObject.HeapInstance) graphObject).isPrimitiveWrapper()) {
                            skip = true;
                        } else if (Intrinsics.areEqual((Object) ((HeapObject.HeapInstance) graphObject).getInstanceClassName(), (Object) "java.lang.String")) {
                            skip = true;
                        } else if (((HeapObject.HeapInstance) graphObject).getInstanceClass().getInstanceByteSize() <= $this$enqueue.getSizeOfObjectInstances()) {
                            skip = true;
                        } else {
                            Iterator<HeapObject.HeapClass> it2 = ((HeapObject.HeapInstance) graphObject).getInstanceClass().getClassHierarchy().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    $this$all$iv = 1;
                                    break;
                                }
                                HeapObject.HeapClass heapClass2 = it2.next();
                                if (heapClass2.getObjectId() == $this$enqueue.getJavaLangObjectId() || !heapClass2.getHasReferenceInstanceFields()) {
                                    heapClass = 1;
                                    continue;
                                } else {
                                    heapClass = null;
                                    continue;
                                }
                                if (heapClass == null) {
                                    $this$all$iv = null;
                                    break;
                                }
                            }
                            if ($this$all$iv != null) {
                                skip = true;
                            }
                        }
                    } else if (graphObject instanceof HeapObject.HeapObjectArray) {
                        if (PathFinderKt.isSkippablePrimitiveWrapperArray((HeapObject.HeapObjectArray) graphObject)) {
                            skip = true;
                        }
                    } else if (graphObject instanceof HeapObject.HeapPrimitiveArray) {
                        skip = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (skip) {
                    return;
                }
            }
            if (visitLast) {
                $this$enqueue.getToVisitLastQueue().add(referencePathNode);
                $this$enqueue.getToVisitLastSet().add(node.getObjectId());
                return;
            }
            $this$enqueue.getToVisitQueue().add(referencePathNode);
            $this$enqueue.getToVisitSet().add(node.getObjectId());
        }
    }
}
