package com.mars.kotlin.extension;

import android.content.ContentResolver;
import com.mars.kotlin.extension.fp.Either;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0006\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/ContentResolver;", "Lkotlin/Function1;", "Lcom/mars/kotlin/extension/ContentResolverScope;", "", "Lkotlin/ExtensionFunctionType;", "some", "invoke", "(Landroid/content/ContentResolver;Lkotlin/Function1;)Lcom/mars/kotlin/extension/ContentResolverScope;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ContentResolverKt {
    @NotNull
    public static final ContentResolverScope invoke(@Nullable ContentResolver contentResolver, @NotNull Function1<? super ContentResolverScope, Unit> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(function1, "some");
        ContentResolverScope contentResolverScope = new ContentResolverScope(contentResolver);
        try {
            function1.invoke(contentResolverScope);
            obj = ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th2);
        }
        if (obj instanceof Either.Left) {
            contentResolverScope.setError$x_release((Throwable) ((Either.Left) obj).getValue());
            new Either.Left(Unit.INSTANCE);
        } else if (!(obj instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
        return contentResolverScope;
    }
}
