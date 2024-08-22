package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int i2, int i3) {
        String str;
        if (!(i2 > 0 && i3 > 0)) {
            if (i2 != i3) {
                str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
            } else {
                str = "size " + i2 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    @NotNull
    public static final <T> Iterator<List<T>> windowedIterator(@NotNull Iterator<? extends T> it, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(it, "iterator");
        if (!it.hasNext()) {
            return EmptyIterator.INSTANCE;
        }
        return SequencesKt__SequenceBuilderKt.iterator(new SlidingWindowKt$windowedIterator$1(i2, i3, it, z2, z, (Continuation<? super SlidingWindowKt$windowedIterator$1>) null));
    }

    @NotNull
    public static final <T> Sequence<List<T>> windowedSequence(@NotNull Sequence<? extends T> sequence, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        checkWindowSizeStep(i2, i3);
        return new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(sequence, i2, i3, z, z2);
    }
}
