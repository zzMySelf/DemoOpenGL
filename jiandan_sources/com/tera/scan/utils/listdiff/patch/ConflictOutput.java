package com.tera.scan.utils.listdiff.patch;

import com.tera.scan.utils.listdiff.patch.delta.AbstractDelta;
import com.tera.scan.utils.listdiff.patch.exception.PatchFailedException;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\ba\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/tera/scan/utils/listdiff/patch/ConflictOutput;", "T", "Ljava/io/Serializable;", "processConflict", "", "verifyChunk", "Lcom/tera/scan/utils/listdiff/patch/VerifyChunk;", "delta", "Lcom/tera/scan/utils/listdiff/patch/delta/AbstractDelta;", "result", "", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ConflictOutput<T> extends Serializable {
    void processConflict(@Nullable VerifyChunk verifyChunk, @Nullable AbstractDelta<T> abstractDelta, @Nullable List<T> list) throws PatchFailedException;
}
