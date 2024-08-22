package com.mars.kotlin.database.extension;

import android.database.Cursor;
import com.mars.kotlin.extension.CursorIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/sequences/Sequence;", "T", "Landroid/database/Cursor;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class QueryKt$fetchSequence$1 extends Lambda implements Function1<Cursor, Sequence<? extends T>> {
    public final /* synthetic */ Function1 $something;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QueryKt$fetchSequence$1(Function1 function1) {
        super(1);
        this.$something = function1;
    }

    @NotNull
    public final Sequence<T> invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "$receiver");
        return SequencesKt__SequencesKt.asSequence(new CursorIterator(cursor, this.$something));
    }
}
