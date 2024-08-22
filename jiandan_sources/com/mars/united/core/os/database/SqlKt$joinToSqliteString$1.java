package com.mars.united.core.os.database;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class SqlKt$joinToSqliteString$1 extends Lambda implements Function1<String, CharSequence> {
    public static final SqlKt$joinToSqliteString$1 INSTANCE = new SqlKt$joinToSqliteString$1();

    public SqlKt$joinToSqliteString$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return ExtendedMessageFormat.QUOTE + str + ExtendedMessageFormat.QUOTE;
    }
}
