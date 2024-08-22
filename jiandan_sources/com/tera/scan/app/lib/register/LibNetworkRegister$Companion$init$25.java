package com.tera.scan.app.lib.register;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "context", "Landroid/content/Context;", "url", "bduss", "uid", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$25 extends Lambda implements Function4<Context, String, String, String, String> {
    public static final LibNetworkRegister$Companion$init$25 INSTANCE = new LibNetworkRegister$Companion$init$25();

    public LibNetworkRegister$Companion$init$25() {
        super(4);
    }

    @NotNull
    public final String invoke(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "bduss");
        Intrinsics.checkNotNullParameter(str3, "uid");
        return str;
    }
}
