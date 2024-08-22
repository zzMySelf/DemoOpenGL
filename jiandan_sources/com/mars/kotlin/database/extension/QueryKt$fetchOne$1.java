package com.mars.kotlin.database.extension;

import android.database.Cursor;
import com.mars.kotlin.extension.CursorIterator;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Landroid/database/Cursor;", "invoke", "(Landroid/database/Cursor;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class QueryKt$fetchOne$1 extends Lambda implements Function1<Cursor, T> {
    public final /* synthetic */ Function1 $something;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QueryKt$fetchOne$1(Function1 function1) {
        super(1);
        this.$something = function1;
    }

    @Nullable
    public final T invoke(@NotNull Cursor cursor) {
        Either either;
        Intrinsics.checkNotNullParameter(cursor, "$this$fetchSomething");
        try {
            either = ExpectKt.success(cursor.getCount() > 0 ? SequencesKt___SequencesKt.firstOrNull(SequencesKt__SequencesKt.asSequence(new CursorIterator(cursor, this.$something))) : null);
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
        return ExpectKt.successOrNull(either);
    }
}
