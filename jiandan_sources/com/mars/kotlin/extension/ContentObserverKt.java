package com.mars.kotlin.extension;

import android.content.Context;
import android.database.ContentObserver;
import com.mars.kotlin.extension.fp.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0005`\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/database/ContentObserver;", "Landroid/content/Context;", "context", "Lcom/mars/kotlin/extension/fp/Either;", "", "", "Lcom/mars/kotlin/extension/MaybeOccurException;", "destroy", "(Landroid/database/ContentObserver;Landroid/content/Context;)Lcom/mars/kotlin/extension/fp/Either;", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ContentObserverKt {
    @NotNull
    public static final Either<Throwable, Unit> destroy(@NotNull ContentObserver contentObserver, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(contentObserver, "$this$destroy");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.getContentResolver().unregisterContentObserver(contentObserver);
            return ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            return ExpectKt.failure(th2);
        }
    }
}
