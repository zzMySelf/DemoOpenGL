package com.tera.scan.vip.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VipWebActivity$initWebView$client$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public VipWebActivity$initWebView$client$1(Object obj) {
        super(2, obj, VipWebActivity.class, "onTitleChanged", "onTitleChanged(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(str2, "p1");
        ((VipWebActivity) this.receiver).onTitleChanged(str, str2);
    }
}
