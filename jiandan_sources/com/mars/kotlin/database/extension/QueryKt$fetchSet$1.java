package com.mars.kotlin.database.extension;

import android.database.Cursor;
import com.mars.kotlin.extension.CursorIterator;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u0003\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/LinkedHashSet;", "T", "Lkotlin/collections/LinkedHashSet;", "Landroid/database/Cursor;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class QueryKt$fetchSet$1 extends Lambda implements Function1<Cursor, LinkedHashSet<T>> {
    public final /* synthetic */ Function1 $something;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QueryKt$fetchSet$1(Function1 function1) {
        super(1);
        this.$something = function1;
    }

    @Nullable
    public final LinkedHashSet<T> invoke(@NotNull Cursor cursor) {
        Either either;
        Intrinsics.checkNotNullParameter(cursor, "$this$fetchSomething");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            if (cursor.getCount() > 0) {
                linkedHashSet = (LinkedHashSet) SequencesKt___SequencesKt.toCollection(SequencesKt__SequencesKt.asSequence(new CursorIterator(cursor, this.$something)), linkedHashSet);
            }
            either = ExpectKt.success(linkedHashSet);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        if (either instanceof Either.Left) {
            Throwable th3 = (Throwable) ((Either.Left) either).getValue();
            cursor.close();
            either = new Either.Left(Unit.INSTANCE);
        } else if (!(either instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
        return (LinkedHashSet) ExpectKt.successOrNull(either);
    }
}
