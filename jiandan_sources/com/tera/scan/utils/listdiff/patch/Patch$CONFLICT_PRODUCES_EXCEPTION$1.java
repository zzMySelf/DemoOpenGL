package com.tera.scan.utils.listdiff.patch;

import com.tera.scan.utils.listdiff.patch.delta.AbstractDelta;
import com.tera.scan.utils.listdiff.patch.exception.PatchFailedException;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/tera/scan/utils/listdiff/patch/Patch$CONFLICT_PRODUCES_EXCEPTION$1", "Lcom/tera/scan/utils/listdiff/patch/ConflictOutput;", "processConflict", "", "verifyChunk", "Lcom/tera/scan/utils/listdiff/patch/VerifyChunk;", "delta", "Lcom/tera/scan/utils/listdiff/patch/delta/AbstractDelta;", "result", "", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Patch$CONFLICT_PRODUCES_EXCEPTION$1 implements ConflictOutput<T> {
    public void processConflict(@Nullable VerifyChunk verifyChunk, @Nullable AbstractDelta<T> abstractDelta, @Nullable List<T> list) {
        throw new PatchFailedException("could not apply patch due to " + verifyChunk);
    }
}
