package com.mars.kotlin.extension;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.lifecycle.SavedStateHandle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u0011\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b.\u0010/J0\u0010\b\u001a\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\u00020\r*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0010\u001a\u00020\r*\u00020\r2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\b\u0013H\u0002¢\u0006\u0004\b\u0010\u0010\u0015J$\u0010\u0010\u001a\u00020\r*\u00020\r2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0010\u0010\u0018J&\u0010\u001b\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001b\u001a\u00020\r*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u001f\"\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010!JI\u0010\u001b\u001a\u00020\r*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u001f\"\u00020\u00192\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\b\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\"J\u0014\u0010#\u001a\u00020\r*\u00020\rH\u0002¢\u0006\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/mars/kotlin/extension/ContentResolverScope;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "e", "", "callback", "fail", "(Lkotlin/Function1;)Lcom/mars/kotlin/extension/ContentResolverScope;", "", "isSuccess", "()Z", "Landroid/net/Uri;", "Landroid/content/ContentValues;", "value", "plus", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "Lcom/mars/kotlin/extension/ContentValuesScope;", "Lkotlin/ExtensionFunctionType;", "init", "(Landroid/net/Uri;Lkotlin/Function1;)Landroid/net/Uri;", "", "values", "(Landroid/net/Uri;Ljava/util/List;)Landroid/net/Uri;", "", "column", "set", "(Landroid/net/Uri;Ljava/lang/Object;Ljava/lang/Object;)Landroid/net/Uri;", "", "where", "", "args", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/Object;Landroid/content/ContentValues;)Landroid/net/Uri;", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/net/Uri;", "unaryMinus", "(Landroid/net/Uri;)Landroid/net/Uri;", "error", "Ljava/lang/Throwable;", "getError$x_release", "()Ljava/lang/Throwable;", "setError$x_release", "(Ljava/lang/Throwable;)V", "Landroid/content/ContentResolver;", "resolver", "Landroid/content/ContentResolver;", "<init>", "(Landroid/content/ContentResolver;)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ContentResolverScope {
    @Nullable
    public Throwable error;
    public final ContentResolver resolver;

    public ContentResolverScope(@Nullable ContentResolver contentResolver) {
        this.resolver = contentResolver;
    }

    @NotNull
    public final ContentResolverScope fail(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Throwable th2 = this.error;
        if (th2 != null) {
            function1.invoke(th2);
        }
        return this;
    }

    @Nullable
    public final Throwable getError$x_release() {
        return this.error;
    }

    public final boolean isSuccess() {
        return this.error == null;
    }

    @NotNull
    public final Uri plus(@NotNull Uri uri, @Nullable List<ContentValues> list) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(uri, "$this$plus");
        if (!(list == null || !(!list.isEmpty()) || (contentResolver = this.resolver) == null)) {
            Object[] array = list.toArray(new ContentValues[0]);
            if (array != null) {
                contentResolver.bulkInsert(uri, (ContentValues[]) array);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return uri;
    }

    @NotNull
    public final Uri set(@NotNull Uri uri, @NotNull String str, @NotNull Object[] objArr, @NotNull Function1<? super ContentValuesScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$set");
        Intrinsics.checkNotNullParameter(str, "where");
        Intrinsics.checkNotNullParameter(objArr, "args");
        Intrinsics.checkNotNullParameter(function1, "init");
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            ContentValues ContentValues = ContentValuesKt.ContentValues(function1);
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList.add(obj.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                contentResolver.update(uri, ContentValues, str, (String[]) array);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return uri;
    }

    public final void setError$x_release(@Nullable Throwable th2) {
        this.error = th2;
    }

    @NotNull
    public final Uri unaryMinus(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$unaryMinus");
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            contentResolver.delete(uri, (String) null, (String[]) null);
        }
        return uri;
    }

    @NotNull
    public final Uri plus(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(uri, "$this$plus");
        if (!(contentValues == null || contentValues.size() <= 0 || (contentResolver = this.resolver) == null)) {
            contentResolver.bulkInsert(uri, new ContentValues[]{contentValues});
        }
        return uri;
    }

    @NotNull
    public final Uri plus(@NotNull Uri uri, @NotNull Function1<? super ContentValuesScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$plus");
        Intrinsics.checkNotNullParameter(function1, "init");
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            contentResolver.bulkInsert(uri, new ContentValues[]{ContentValuesKt.ContentValues(function1)});
        }
        return uri;
    }

    @NotNull
    public final Uri set(@NotNull Uri uri, @NotNull String str, @NotNull Object[] objArr, @NotNull ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "$this$set");
        Intrinsics.checkNotNullParameter(str, "where");
        Intrinsics.checkNotNullParameter(objArr, "args");
        Intrinsics.checkNotNullParameter(contentValues, SavedStateHandle.VALUES);
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList.add(obj.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                contentResolver.update(uri, contentValues, str, (String[]) array);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return uri;
    }

    @NotNull
    public final Uri set(@NotNull Uri uri, @NotNull Object obj, @Nullable Object obj2) {
        Intrinsics.checkNotNullParameter(uri, "$this$set");
        Intrinsics.checkNotNullParameter(obj, "column");
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            contentResolver.update(uri, ContentValuesKt.ContentValues(new ContentResolverScope$set$$inlined$apply$lambda$1(this, obj, obj2)), (String) null, (String[]) null);
        }
        return uri;
    }
}
