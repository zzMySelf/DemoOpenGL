package com.tera.scan.utils.listdiff.patch.delta;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.baidu.ubc.UBCManager;
import com.tera.scan.utils.listdiff.patch.Chunk;
import com.tera.scan.utils.listdiff.patch.VerifyChunk;
import com.tera.scan.utils.listdiff.patch.exception.PatchFailedException;
import com.tera.scan.utils.listdiff.updatecallback.ListUpdateCallback;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\bJ\"\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H$J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u001a2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012J\u0016\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/tera/scan/utils/listdiff/patch/delta/AbstractDelta;", "T", "Ljava/io/Serializable;", "type", "Lcom/tera/scan/utils/listdiff/patch/delta/DeltaType;", "source", "Lcom/tera/scan/utils/listdiff/patch/Chunk;", "target", "(Lcom/tera/scan/utils/listdiff/patch/delta/DeltaType;Lcom/tera/scan/utils/listdiff/patch/Chunk;Lcom/tera/scan/utils/listdiff/patch/Chunk;)V", "getSource", "()Lcom/tera/scan/utils/listdiff/patch/Chunk;", "getTarget", "getType", "()Lcom/tera/scan/utils/listdiff/patch/delta/DeltaType;", "applyTo", "", "", "updateCallback", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateCallback;", "equals", "", "obj", "", "hashCode", "", "verifyAntApplyTo", "Lcom/tera/scan/utils/listdiff/patch/VerifyChunk;", "verifyChunkToFitTarget", "", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractDelta<T> implements Serializable {
    @NotNull
    public final Chunk<T> source;
    @NotNull
    public final Chunk<T> target;
    @NotNull
    public final DeltaType type;

    public AbstractDelta(@NotNull DeltaType deltaType, @NotNull Chunk<T> chunk, @NotNull Chunk<T> chunk2) {
        Intrinsics.checkNotNullParameter(deltaType, "type");
        Intrinsics.checkNotNullParameter(chunk, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(chunk2, AnimatedVectorDrawableCompat.TARGET);
        this.type = deltaType;
        this.source = chunk;
        this.target = chunk2;
    }

    public abstract void applyTo(@NotNull List<T> list, @NotNull ListUpdateCallback<?> listUpdateCallback) throws PatchFailedException;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        AbstractDelta abstractDelta = (AbstractDelta) obj;
        if (Intrinsics.areEqual((Object) this.source, (Object) abstractDelta.source) && Intrinsics.areEqual((Object) this.target, (Object) abstractDelta.target) && this.type == abstractDelta.type) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Chunk<T> getSource() {
        return this.source;
    }

    @NotNull
    public final Chunk<T> getTarget() {
        return this.target;
    }

    @NotNull
    public final DeltaType getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.source, this.target, this.type});
    }

    @NotNull
    public final VerifyChunk verifyAntApplyTo(@NotNull List<T> list, @NotNull ListUpdateCallback<?> listUpdateCallback) throws PatchFailedException {
        Intrinsics.checkNotNullParameter(list, AnimatedVectorDrawableCompat.TARGET);
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        VerifyChunk verifyChunkToFitTarget = verifyChunkToFitTarget(list);
        if (verifyChunkToFitTarget == VerifyChunk.OK) {
            applyTo(list, listUpdateCallback);
        }
        return verifyChunkToFitTarget;
    }

    @NotNull
    public final VerifyChunk verifyChunkToFitTarget(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, AnimatedVectorDrawableCompat.TARGET);
        return Chunk.verifyChunk$default(this.source, list, 0, 0, 6, (Object) null);
    }
}
