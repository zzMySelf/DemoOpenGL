package com.mars.united.core.os;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class Temperature$getTemperature$1 extends Lambda implements Function1<String, Boolean> {
    public static final Temperature$getTemperature$1 INSTANCE = new Temperature$getTemperature$1();

    public Temperature$getTemperature$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "it");
        try {
            z = new File(str).exists();
        } catch (Exception unused) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
