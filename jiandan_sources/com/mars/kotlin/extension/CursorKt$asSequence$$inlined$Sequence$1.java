package com.mars.kotlin.extension;

import android.database.Cursor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CursorKt$asSequence$$inlined$Sequence$1 implements Sequence<Cursor> {
    public final /* synthetic */ Cursor $this_asSequence$inlined;

    public CursorKt$asSequence$$inlined$Sequence$1(Cursor cursor) {
        this.$this_asSequence$inlined = cursor;
    }

    @NotNull
    public Iterator<Cursor> iterator() {
        return new CursorKt$asSequence$$inlined$Sequence$1$lambda$1(this);
    }
}
