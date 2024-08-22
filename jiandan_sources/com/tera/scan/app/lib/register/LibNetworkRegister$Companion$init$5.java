package com.tera.scan.app.lib.register;

import com.tera.scan.framework.kernel.BaseApplication;
import fe.mmm.qw.ad.ad.qw.ad;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lokhttp3/HttpUrl$Builder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$5 extends Lambda implements Function1<HttpUrl.Builder, String> {
    public static final LibNetworkRegister$Companion$init$5 INSTANCE = new LibNetworkRegister$Companion$init$5();

    public LibNetworkRegister$Companion$init$5() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull HttpUrl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "it");
        return ad.qw.qw(builder, BaseApplication.getInstance());
    }
}
