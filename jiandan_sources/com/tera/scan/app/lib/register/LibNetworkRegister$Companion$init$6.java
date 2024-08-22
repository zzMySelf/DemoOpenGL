package com.tera.scan.app.lib.register;

import fe.mmm.qw.ad.ad.qw.qw;
import fe.mmm.qw.nn.de.o.de;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/tera/scan/network/network/request/HttpRequest;", "kotlin.jvm.PlatformType", "request", "ignoreRand", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$6 extends Lambda implements Function2<de, Boolean, de> {
    public static final LibNetworkRegister$Companion$init$6 INSTANCE = new LibNetworkRegister$Companion$init$6();

    public LibNetworkRegister$Companion$init$6() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((de) obj, ((Boolean) obj2).booleanValue());
    }

    public final de invoke(@Nullable de deVar, boolean z) {
        qw.qw(deVar, z);
        Intrinsics.checkNotNullExpressionValue(deVar, "appendParams(request, ignoreRand)");
        return deVar;
    }
}
