package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.BrittleContainsOptimizationKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$2", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SequencesKt___SequencesKt$minus$2 implements Sequence<T> {
    public final /* synthetic */ T[] $elements;
    public final /* synthetic */ Sequence<T> $this_minus;

    public SequencesKt___SequencesKt$minus$2(T[] tArr, Sequence<? extends T> sequence) {
        this.$elements = tArr;
        this.$this_minus = sequence;
    }

    @NotNull
    public Iterator<T> iterator() {
        return SequencesKt___SequencesKt.filterNot(this.$this_minus, new SequencesKt___SequencesKt$minus$2$iterator$1(BrittleContainsOptimizationKt.convertToSetForSetOperation(this.$elements))).iterator();
    }
}
