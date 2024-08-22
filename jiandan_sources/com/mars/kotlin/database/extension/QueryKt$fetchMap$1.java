package com.mars.kotlin.database.extension;

import android.database.Cursor;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "K", "V", "", "Landroid/database/Cursor;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class QueryKt$fetchMap$1 extends Lambda implements Function1<Cursor, Map<K, ? extends V>> {
    public final /* synthetic */ Function1 $something;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QueryKt$fetchMap$1(Function1 function1) {
        super(1);
        this.$something = function1;
    }

    @Nullable
    public final Map<K, V> invoke(@NotNull Cursor cursor) {
        Either either;
        Intrinsics.checkNotNullParameter(cursor, "$receiver");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            try {
                Pair pair = (Pair) this.$something.invoke(cursor);
                linkedHashMap.put(pair.component1(), pair.component2());
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                either = ExpectKt.failure(th2);
            }
        }
        either = ExpectKt.success(linkedHashMap);
        if (either instanceof Either.Left) {
            Throwable th3 = (Throwable) ((Either.Left) either).getValue();
            cursor.close();
            either = new Either.Left(Unit.INSTANCE);
        } else if (!(either instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
        return (Map) ExpectKt.successOrNull(either);
    }
}
