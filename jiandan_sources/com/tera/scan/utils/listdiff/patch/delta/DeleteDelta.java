package com.tera.scan.utils.listdiff.patch.delta;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.tera.scan.utils.listdiff.patch.Chunk;
import com.tera.scan.utils.listdiff.updatecallback.ListUpdateCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/tera/scan/utils/listdiff/patch/delta/DeleteDelta;", "T", "Lcom/tera/scan/utils/listdiff/patch/delta/AbstractDelta;", "original", "Lcom/tera/scan/utils/listdiff/patch/Chunk;", "revised", "(Lcom/tera/scan/utils/listdiff/patch/Chunk;Lcom/tera/scan/utils/listdiff/patch/Chunk;)V", "applyTo", "", "target", "", "updateCallback", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateCallback;", "toString", "", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeleteDelta<T> extends AbstractDelta<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteDelta(@NotNull Chunk<T> chunk, @NotNull Chunk<T> chunk2) {
        super(DeltaType.DELETE, chunk, chunk2);
        Intrinsics.checkNotNullParameter(chunk, "original");
        Intrinsics.checkNotNullParameter(chunk2, "revised");
    }

    public void applyTo(@NotNull List<T> list, @NotNull ListUpdateCallback<?> listUpdateCallback) {
        Intrinsics.checkNotNullParameter(list, AnimatedVectorDrawableCompat.TARGET);
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        int position = getSource().getPosition();
        int size = getSource().size();
        for (int i2 = 0; i2 < size; i2++) {
            list.remove(position);
        }
        listUpdateCallback.onRemoved(position, size);
    }

    @NotNull
    public String toString() {
        return "[DeleteDelta, position: " + getSource().getPosition() + ", lines: " + getSource().getLines() + ']';
    }
}
