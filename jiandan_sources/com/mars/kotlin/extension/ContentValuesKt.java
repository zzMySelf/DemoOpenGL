package com.mars.kotlin.extension;

import android.content.ContentValues;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a&\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u001a&\u0010\r\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/Function1;", "Lcom/mars/kotlin/extension/ContentValuesScope;", "", "Lkotlin/ExtensionFunctionType;", "init", "Landroid/content/ContentValues;", "ContentValues", "(Lkotlin/Function1;)Landroid/content/ContentValues;", "invoke", "(Landroid/content/ContentValues;Lkotlin/Function1;)Landroid/content/ContentValues;", "", "key", "value", "set", "(Landroid/content/ContentValues;Ljava/lang/Object;Ljava/lang/Object;)V", "x_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues ContentValues(@NotNull Function1<? super ContentValuesScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        ContentValues contentValues = new ContentValues();
        function1.invoke(new ContentValuesScope(contentValues));
        return contentValues;
    }

    @NotNull
    @Deprecated(message = "use ContentValues() instead of", replaceWith = @ReplaceWith(expression = "ContentValues(init:ContentValuesScope.() -> Unit)", imports = {"com.mars.kotlin.extension.ContentValuesScope"}))
    public static final ContentValues invoke(@NotNull ContentValues contentValues, @NotNull Function1<? super ContentValuesScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(contentValues, "$this$invoke");
        Intrinsics.checkNotNullParameter(function1, "init");
        function1.invoke(new ContentValuesScope(contentValues));
        return contentValues;
    }

    public static final void set(@NotNull ContentValues contentValues, @NotNull Object obj, @Nullable Object obj2) {
        Intrinsics.checkNotNullParameter(contentValues, "$this$set");
        Intrinsics.checkNotNullParameter(obj, "key");
        if (obj2 == null) {
            contentValues.putNull(obj.toString());
        } else if (obj2 instanceof Boolean) {
            contentValues.put(obj.toString(), Integer.valueOf(((Boolean) obj2).booleanValue() ? 1 : 0));
        } else if (obj2 instanceof Integer) {
            contentValues.put(obj.toString(), (Integer) obj2);
        } else if (obj2 instanceof String) {
            contentValues.put(obj.toString(), (String) obj2);
        } else if (obj2 instanceof Byte) {
            contentValues.put(obj.toString(), (Byte) obj2);
        } else if (obj2 instanceof Short) {
            contentValues.put(obj.toString(), (Short) obj2);
        } else if (obj2 instanceof Long) {
            contentValues.put(obj.toString(), (Long) obj2);
        } else if (obj2 instanceof Float) {
            contentValues.put(obj.toString(), (Float) obj2);
        } else if (obj2 instanceof Double) {
            contentValues.put(obj.toString(), (Double) obj2);
        } else if (obj2 instanceof byte[]) {
            contentValues.put(obj.toString(), (byte[]) obj2);
        } else {
            LoggerKt.e$default("ContentValues cannot set " + obj2, (Object) null, 1, (Object) null);
        }
    }
}
