package shark.internal;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import shark.internal.hppc.LongLongScatterMap;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"shark/internal/DominatorTree$computeRetainedSizes$2", "Lshark/internal/hppc/LongLongScatterMap$ForEachCallback;", "onEntry", "", "key", "", "value", "shark"}, k = 1, mv = {1, 4, 1})
/* compiled from: DominatorTree.kt */
public final class DominatorTree$computeRetainedSizes$2 implements LongLongScatterMap.ForEachCallback {
    final /* synthetic */ Function1 $computeSize;
    final /* synthetic */ Map $nodeRetainedSizes;
    final /* synthetic */ DominatorTree this$0;

    DominatorTree$computeRetainedSizes$2(DominatorTree this$02, Map $captured_local_variable$1, Function1 $captured_local_variable$2) {
        this.this$0 = this$02;
        this.$nodeRetainedSizes = $captured_local_variable$1;
        this.$computeSize = $captured_local_variable$2;
    }

    public void onEntry(long key, long value) {
        int instanceSize = -1;
        Pair $dstr$currentRetainedSize$currentRetainedCount = (Pair) this.$nodeRetainedSizes.get(Long.valueOf(key));
        if ($dstr$currentRetainedSize$currentRetainedCount != null) {
            int currentRetainedSize = ((Number) $dstr$currentRetainedSize$currentRetainedCount.component1()).intValue();
            int currentRetainedCount = ((Number) $dstr$currentRetainedSize$currentRetainedCount.component2()).intValue();
            instanceSize = ((Number) this.$computeSize.invoke(Long.valueOf(key))).intValue();
            this.$nodeRetainedSizes.put(Long.valueOf(key), TuplesKt.to(Integer.valueOf(currentRetainedSize + instanceSize), Integer.valueOf(currentRetainedCount + 1)));
        }
        if (value != 0) {
            List<Number> dominatedByNextNode = CollectionsKt.mutableListOf(Long.valueOf(key));
            for (long dominator = value; dominator != 0; dominator = this.this$0.dominated.get(dominator)) {
                if (this.$nodeRetainedSizes.containsKey(Long.valueOf(dominator))) {
                    for (Number longValue : dominatedByNextNode) {
                        this.this$0.dominated.set(longValue.longValue(), dominator);
                    }
                    if (instanceSize == -1) {
                        instanceSize = ((Number) this.$computeSize.invoke(Long.valueOf(key))).intValue();
                    }
                    Pair pair = (Pair) MapsKt.getValue(this.$nodeRetainedSizes, Long.valueOf(dominator));
                    this.$nodeRetainedSizes.put(Long.valueOf(dominator), TuplesKt.to(Integer.valueOf(((Number) pair.component1()).intValue() + instanceSize), Integer.valueOf(((Number) pair.component2()).intValue() + 1)));
                    dominatedByNextNode.clear();
                } else {
                    dominatedByNextNode.add(Long.valueOf(dominator));
                }
            }
            for (Number longValue2 : dominatedByNextNode) {
                this.this$0.dominated.set(longValue2.longValue(), 0);
            }
        }
    }
}
