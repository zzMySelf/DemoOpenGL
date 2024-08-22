package com.mars.united.core.os.database;

import android.database.Cursor;
import fe.ggg.ad.qw.de.rg.ad;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "T", "U", "cursor", "Landroid/database/Cursor;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class CursorDataKt$map$parser$1 extends Lambda implements Function1<Cursor, T> {
    public final /* synthetic */ ad<U> $rawArray;
    public final /* synthetic */ Function1<U, T> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CursorDataKt$map$parser$1(ad<U> adVar, Function1<? super U, ? extends T> function1) {
        super(1);
        this.$rawArray = adVar;
        this.$transform = function1;
    }

    public final T invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        this.$rawArray.qw();
        throw null;
    }
}
