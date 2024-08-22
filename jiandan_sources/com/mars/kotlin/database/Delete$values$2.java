package com.mars.kotlin.database;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class Delete$values$2 extends Lambda implements Function1<Object, CharSequence> {
    public static final Delete$values$2 INSTANCE = new Delete$values$2();

    public Delete$values$2() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (!(obj instanceof String)) {
            return obj.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ExtendedMessageFormat.QUOTE);
        sb.append(obj);
        sb.append(ExtendedMessageFormat.QUOTE);
        return sb.toString();
    }
}
