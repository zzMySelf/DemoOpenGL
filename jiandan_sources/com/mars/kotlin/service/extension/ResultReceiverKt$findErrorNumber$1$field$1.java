package com.mars.kotlin.service.extension;

import com.mars.kotlin.service.ErrorCode;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
public final class ResultReceiverKt$findErrorNumber$1$field$1 extends Lambda implements Function1<Field, Boolean> {
    public static final ResultReceiverKt$findErrorNumber$1$field$1 INSTANCE = new ResultReceiverKt$findErrorNumber$1$field$1();

    public ResultReceiverKt$findErrorNumber$1$field$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Field) obj));
    }

    public final boolean invoke(Field field) {
        return field.isAnnotationPresent(ErrorCode.class);
    }
}
