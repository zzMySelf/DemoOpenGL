package com.tera.scan.utils.listdiff.patch.delta;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.baidu.ubc.UBCManager;
import com.tera.scan.utils.listdiff.patch.Chunk;
import com.tera.scan.utils.listdiff.updatecallback.ListUpdateCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tera/scan/utils/listdiff/patch/delta/ChangeDelta;", "T", "Lcom/tera/scan/utils/listdiff/patch/delta/AbstractDelta;", "source", "Lcom/tera/scan/utils/listdiff/patch/Chunk;", "target", "(Lcom/tera/scan/utils/listdiff/patch/Chunk;Lcom/tera/scan/utils/listdiff/patch/Chunk;)V", "applyTo", "", "", "updateCallback", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateCallback;", "toString", "", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChangeDelta<T> extends AbstractDelta<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChangeDelta(@NotNull Chunk<T> chunk, @NotNull Chunk<T> chunk2) {
        super(DeltaType.CHANGE, chunk, chunk2);
        Intrinsics.checkNotNullParameter(chunk, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(chunk2, AnimatedVectorDrawableCompat.TARGET);
    }

    public void applyTo(@NotNull List<T> list, @NotNull ListUpdateCallback<?> listUpdateCallback) {
        Intrinsics.checkNotNullParameter(list, AnimatedVectorDrawableCompat.TARGET);
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        int position = getSource().getPosition();
        int size = getSource().size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            list.remove(position);
        }
        for (Object next : super.getTarget().getLines()) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            list.add(i2 + position, next);
            i2 = i4;
        }
        listUpdateCallback.onChanged(position, size, (Object) null);
    }

    @NotNull
    public String toString() {
        return "[ChangeDelta, position: " + getSource().getPosition() + ", lines: " + getSource().getLines() + " to " + getTarget().getLines() + ']';
    }
}
