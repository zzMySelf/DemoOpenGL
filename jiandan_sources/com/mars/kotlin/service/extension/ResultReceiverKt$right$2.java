package com.mars.kotlin.service.extension;

import com.mars.kotlin.extension.BundleScope;
import com.mars.kotlin.service.Extra;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/mars/kotlin/extension/BundleScope;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
public final class ResultReceiverKt$right$2 extends Lambda implements Function1<BundleScope, Unit> {
    public final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResultReceiverKt$right$2(Object obj) {
        super(1);
        this.$value = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BundleScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BundleScope bundleScope) {
        bundleScope.minus(Extra.RESULT, this.$value);
    }
}
