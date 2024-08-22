package com.tera.scan.utils.listdiff.patch;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J*\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/utils/listdiff/patch/Chunk;", "T", "Ljava/io/Serializable;", "position", "", "lines", "", "changePosition", "", "(ILjava/util/List;Ljava/util/List;)V", "getChangePosition", "()Ljava/util/List;", "getLines", "getPosition", "()I", "equals", "", "obj", "", "hashCode", "last", "size", "toString", "", "verifyChunk", "Lcom/tera/scan/utils/listdiff/patch/VerifyChunk;", "target", "fuzz", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Chunk<T> implements Serializable {
    @Nullable
    public final List<Integer> changePosition;
    @NotNull
    public final List<T> lines;
    public final int position;

    public Chunk(int i2, @NotNull List<T> list, @Nullable List<Integer> list2) {
        Intrinsics.checkNotNullParameter(list, "lines");
        this.position = i2;
        this.lines = list;
        this.changePosition = list2;
    }

    public static /* synthetic */ VerifyChunk verifyChunk$default(Chunk chunk, List list, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = chunk.position;
        }
        return chunk.verifyChunk(list, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Chunk.class, (Object) obj.getClass())) {
            return false;
        }
        Chunk chunk = (Chunk) obj;
        List<T> list = this.lines;
        if (list == null) {
            if (chunk.lines != null) {
                return false;
            }
        } else if (!Intrinsics.areEqual((Object) list, (Object) chunk.lines)) {
            return false;
        }
        if (this.position == chunk.position) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<Integer> getChangePosition() {
        return this.changePosition;
    }

    @NotNull
    public final List<T> getLines() {
        return this.lines;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.lines, Integer.valueOf(this.position), Integer.valueOf(size())});
    }

    public final int last() {
        return (this.position + size()) - 1;
    }

    public final int size() {
        return this.lines.size();
    }

    @NotNull
    public String toString() {
        return "[position: " + this.position + ", size: " + size() + ", lines: " + this.lines + ']';
    }

    @NotNull
    @JvmOverloads
    public final VerifyChunk verifyChunk(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, AnimatedVectorDrawableCompat.TARGET);
        return verifyChunk$default(this, list, 0, 0, 6, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final VerifyChunk verifyChunk(@NotNull List<? extends T> list, int i2) {
        Intrinsics.checkNotNullParameter(list, AnimatedVectorDrawableCompat.TARGET);
        return verifyChunk$default(this, list, i2, 0, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final VerifyChunk verifyChunk(@NotNull List<? extends T> list, int i2, int i3) {
        Intrinsics.checkNotNullParameter(list, AnimatedVectorDrawableCompat.TARGET);
        int size = size() - i2;
        int size2 = (size() + i3) - 1;
        if (i3 + i2 > list.size() || size2 - i2 > list.size()) {
            return VerifyChunk.POSITION_OUT_OF_TARGET;
        }
        while (i2 < size) {
            if (!Intrinsics.areEqual((Object) list.get(i3 + i2), (Object) this.lines.get(i2))) {
                return VerifyChunk.CONTENT_DOES_NOT_MATCH_TARGET;
            }
            i2++;
        }
        return VerifyChunk.OK;
    }
}
