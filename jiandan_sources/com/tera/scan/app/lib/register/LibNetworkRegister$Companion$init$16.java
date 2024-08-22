package com.tera.scan.app.lib.register;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "op", "", "argOne", "argTwo", "argThree", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$16 extends Lambda implements Function4<String, String, String, String, Unit> {
    public static final LibNetworkRegister$Companion$init$16 INSTANCE = new LibNetworkRegister$Companion$init$16();

    public LibNetworkRegister$Companion$init$16() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((String) obj, (String) obj2, (String) obj3, (String) obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "op");
        Intrinsics.checkNotNullParameter(str2, "argOne");
        Intrinsics.checkNotNullParameter(str3, "argTwo");
        Intrinsics.checkNotNullParameter(str4, "argThree");
    }
}
