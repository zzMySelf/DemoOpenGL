package com.mars.kotlin.extension;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class Logger$tag$2$6 extends Lambda implements Function1<Method, Boolean> {
    public final /* synthetic */ String $methodName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Logger$tag$2$6(String str) {
        super(1);
        this.$methodName = str;
    }

    @NotNull
    public final Boolean invoke(Method method) {
        return Boolean.valueOf(Intrinsics.areEqual((Object) method.getName(), (Object) this.$methodName));
    }
}
