package com.mars.kotlin.extension;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/Function1;", "Lcom/mars/kotlin/extension/IntentScope;", "", "Lkotlin/ExtensionFunctionType;", "init", "Landroid/content/Intent;", "Intent", "(Lkotlin/Function1;)Landroid/content/Intent;", "invoke", "(Landroid/content/Intent;Lkotlin/Function1;)Landroid/content/Intent;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class IntentKt {
    @NotNull
    public static final Intent Intent(@NotNull Function1<? super IntentScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        return invoke(new Intent(), function1);
    }

    @NotNull
    public static final Intent invoke(@NotNull Intent intent, @NotNull Function1<? super IntentScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(intent, "$this$invoke");
        Intrinsics.checkNotNullParameter(function1, "init");
        function1.invoke(new IntentScope(intent));
        return intent;
    }
}
