package com.mars.kotlin.extension;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/Function1;", "Lcom/mars/kotlin/extension/BundleScope;", "", "Lkotlin/ExtensionFunctionType;", "init", "Landroid/os/Bundle;", "Bundle", "(Lkotlin/Function1;)Landroid/os/Bundle;", "invoke", "(Landroid/os/Bundle;Lkotlin/Function1;)Landroid/os/Bundle;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class BundleKt {
    @NotNull
    public static final Bundle Bundle(@NotNull Function1<? super BundleScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        return invoke(new Bundle(), function1);
    }

    @NotNull
    public static final Bundle invoke(@NotNull Bundle bundle, @NotNull Function1<? super BundleScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(bundle, "$this$invoke");
        Intrinsics.checkNotNullParameter(function1, "init");
        function1.invoke(new BundleScope(bundle));
        return bundle;
    }
}
