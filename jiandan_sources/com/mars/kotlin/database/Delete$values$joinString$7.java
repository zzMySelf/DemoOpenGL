package com.mars.kotlin.database;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class Delete$values$joinString$7 extends Lambda implements Function1<Byte, CharSequence> {
    public static final Delete$values$joinString$7 INSTANCE = new Delete$values$joinString$7();

    public Delete$values$joinString$7() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).byteValue());
    }

    @NotNull
    public final CharSequence invoke(byte b) {
        return String.valueOf(b);
    }
}
