package com.tera.scan.file.selector.ui;

import com.mars.kotlin.extension.BundleScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/mars/kotlin/extension/BundleScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LocalImageSelectActivity$initFragment$1$1 extends Lambda implements Function1<BundleScope, Unit> {
    public final /* synthetic */ LocalImageSelectActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectActivity$initFragment$1$1(LocalImageSelectActivity localImageSelectActivity) {
        super(1);
        this.this$0 = localImageSelectActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BundleScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BundleScope bundleScope) {
        Intrinsics.checkNotNullParameter(bundleScope, "$this$Bundle");
        bundleScope.minus("extra_show_all_bucket", Boolean.TRUE);
        bundleScope.minus("extra_max_count", Integer.valueOf(this.this$0.maxCount));
        bundleScope.minus("extra_ubc_source", this.this$0.getUbcSource());
    }
}
