package com.tera.scan.app.lib.register;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$4 extends Lambda implements Function1<String, Boolean> {
    public static final LibNetworkRegister$Companion$init$4 INSTANCE = new LibNetworkRegister$Companion$init$4();

    public LibNetworkRegister$Companion$init$4() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@Nullable String str) {
        boolean unused = LibNetworkRegister.qw.fe(str);
        return Boolean.TRUE;
    }
}
