package com.mars.kotlin.extension;

import android.content.ContentValues;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/mars/kotlin/extension/ContentValuesScope;", "", "value", "", "minus", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Landroid/content/ContentValues;", "values", "Landroid/content/ContentValues;", "<init>", "(Landroid/content/ContentValues;)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ContentValuesScope {
    public final ContentValues values;

    public ContentValuesScope(@NotNull ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, SavedStateHandle.VALUES);
        this.values = contentValues;
    }

    public final void minus(@NotNull Object obj, @Nullable Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "$this$minus");
        ContentValuesKt.set(this.values, obj.toString(), obj2);
    }
}
