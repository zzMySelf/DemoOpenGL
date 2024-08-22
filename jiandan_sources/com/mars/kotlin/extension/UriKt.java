package com.mars.kotlin.extension;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.mars.kotlin.extension.fp.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00000\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a@\u0010\u0015\u001a\u0004\u0018\u00010\u0010*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2#\b\u0001\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u0018\u0010\u0003\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroid/net/Uri;", "", "value", "contentId", "(Landroid/net/Uri;J)Landroid/net/Uri;", "", "term", "Lkotlin/Function1;", "", "invoke", "(Landroid/net/Uri;Ljava/lang/String;)Lkotlin/Function1;", "Landroid/content/Context;", "context", "", "notifyChange", "(Landroid/net/Uri;Landroid/content/Context;)Lkotlin/Unit;", "Landroid/database/ContentObserver;", "Lkotlin/ParameterName;", "name", "observer", "callback", "observe", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/Function1;)Landroid/database/ContentObserver;", "getContentId", "(Landroid/net/Uri;)J", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class UriKt {
    @NotNull
    public static final Uri contentId(@NotNull Uri uri, long j) {
        Intrinsics.checkNotNullParameter(uri, "$this$contentId");
        Uri withAppendedId = ContentUris.withAppendedId(uri, j);
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "ContentUris.withAppendedId(this, value)");
        return withAppendedId;
    }

    public static final long getContentId(@NotNull Uri uri) {
        Either either;
        Intrinsics.checkNotNullParameter(uri, "$this$contentId");
        try {
            either = ExpectKt.success(Long.valueOf(ContentUris.parseId(uri)));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        return ((Number) ExpectKt.successOrDefault(either, -1L)).longValue();
    }

    @NotNull
    public static final Function1<Object, Uri> invoke(@NotNull Uri uri, @NotNull String str) {
        Intrinsics.checkNotNullParameter(uri, "$this$invoke");
        Intrinsics.checkNotNullParameter(str, "term");
        return new UriKt$invoke$1(uri, str);
    }

    @Nullable
    public static final Unit notifyChange(@NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, "$this$notifyChange");
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        contentResolver.notifyChange(uri, (ContentObserver) null, false);
        return Unit.INSTANCE;
    }

    @Nullable
    public static final ContentObserver observe(@NotNull Uri uri, @NotNull Context context, @NotNull @MainThread Function1<? super ContentObserver, Unit> function1) {
        Either either;
        Intrinsics.checkNotNullParameter(uri, "$this$observe");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "callback");
        UriKt$observe$1 uriKt$observe$1 = new UriKt$observe$1(function1, new Handler(Looper.getMainLooper()));
        try {
            context.getContentResolver().registerContentObserver(uri, false, uriKt$observe$1);
            either = ExpectKt.success(uriKt$observe$1);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        return (UriKt$observe$1) ExpectKt.successOrNull(either);
    }
}
