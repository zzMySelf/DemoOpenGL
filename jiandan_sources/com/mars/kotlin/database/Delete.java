package com.mars.kotlin.database;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.WorkerThread;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000B\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u00020\u00032\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000b\u0010\rJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u000b\u0010\u0011J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u000b\u0010\u0013J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u000b\u0010\u0015J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u000b\u0010\u0017J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u000b\u0010\u0019J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u000b\u0010\u001bJ\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0007¢\u0006\u0004\b\u000b\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\b \u0010#R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010$R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/mars/kotlin/database/Delete;", "", "joinString", "", "deleteByIn", "(Ljava/lang/String;)I", "", "", "value", "valuesByArray", "([Ljava/lang/Object;)I", "values", "", "([Z)I", "", "([B)I", "", "([C)I", "", "([D)I", "", "([F)I", "", "([I)I", "", "([J)I", "", "([S)I", "", "(Ljava/lang/Iterable;)I", "Lcom/mars/kotlin/database/Column;", "column", "where", "(Lcom/mars/kotlin/database/Column;)Lcom/mars/kotlin/database/Delete;", "condition", "(Ljava/lang/String;)Lcom/mars/kotlin/database/Delete;", "Lcom/mars/kotlin/database/Column;", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;Landroid/content/Context;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Tag("Delete")
public final class Delete {
    public Column column;
    public String condition;
    public final Context context;
    public final Uri uri;

    public Delete(@NotNull Uri uri2, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.uri = uri2;
        this.context = context2;
    }

    @WorkerThread
    private final int deleteByIn(String str) {
        Either either;
        Column column2 = this.column;
        if (column2 == null) {
            return 0;
        }
        if (str.length() == 0) {
            LoggerKt.w$default("in condition must be setting at least one value", (Object) null, 1, (Object) null);
            return 0;
        }
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            Uri uri2 = this.uri;
            either = ExpectKt.success(Integer.valueOf(contentResolver.delete(uri2, (String) LoggerKt.d$default(column2 + " IN (" + str + ')', (Object) null, 1, (Object) null), (String[]) null)));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        return ((Number) ExpectKt.successOrDefault(either, -1)).intValue();
    }

    @WorkerThread
    public final int values(@NotNull Iterable<? extends Object> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "value");
        return deleteByIn(CollectionsKt___CollectionsKt.joinToString$default(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, Delete$values$joinString$1.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    @JvmName(name = "valuesByArray")
    public final int valuesByArray(@NotNull Object[] objArr) {
        Either either;
        Intrinsics.checkNotNullParameter(objArr, "value");
        String str = null;
        if (this.condition == null) {
            if (objArr.length != 1 || !(objArr[0] instanceof Object[])) {
                str = ArraysKt___ArraysKt.joinToString$default(objArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$6.INSTANCE, 31, (Object) null);
            } else {
                Object[] objArr2 = objArr[0];
                if (!(objArr2 instanceof Object[])) {
                    objArr2 = null;
                }
                Object[] objArr3 = objArr2;
                if (objArr3 != null) {
                    str = ArraysKt___ArraysKt.joinToString$default(objArr3, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$5.INSTANCE, 31, (Object) null);
                }
            }
            if (str != null) {
                return deleteByIn((String) LoggerKt.d(str, "joinString"));
            }
            return -1;
        }
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            Uri uri2 = this.uri;
            String str2 = this.condition;
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList.add(obj.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                either = ExpectKt.success(Integer.valueOf(contentResolver.delete(uri2, str2, (String[]) array)));
                return ((Number) ExpectKt.successOrDefault(either, -1)).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
    }

    @NotNull
    public final Delete where(@NotNull Column column2) {
        Intrinsics.checkNotNullParameter(column2, "column");
        this.column = column2;
        return this;
    }

    @NotNull
    public final Delete where(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "condition");
        this.condition = str;
        return this;
    }

    @WorkerThread
    public final int values(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(jArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$2.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(iArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$3.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(dArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$4.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(fArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$5.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(zArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$6.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(bArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$7.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(sArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$8.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "value");
        return deleteByIn(ArraysKt___ArraysKt.joinToString$default(cArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$joinString$9.INSTANCE, 31, (Object) null));
    }

    @WorkerThread
    public final int values(@NotNull Object... objArr) {
        Either either;
        Intrinsics.checkNotNullParameter(objArr, "value");
        String str = null;
        if (this.condition == null) {
            if (objArr.length != 1 || !(objArr[0] instanceof Object[])) {
                str = ArraysKt___ArraysKt.joinToString$default(objArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$2.INSTANCE, 31, (Object) null);
            } else {
                Object[] objArr2 = objArr[0];
                if (!(objArr2 instanceof Object[])) {
                    objArr2 = null;
                }
                Object[] objArr3 = objArr2;
                if (objArr3 != null) {
                    str = ArraysKt___ArraysKt.joinToString$default(objArr3, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) Delete$values$1.INSTANCE, 31, (Object) null);
                }
            }
            if (str != null) {
                return deleteByIn((String) LoggerKt.d(str, "joinString"));
            }
            return -1;
        }
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            Uri uri2 = this.uri;
            String str2 = this.condition;
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList.add(obj.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                either = ExpectKt.success(Integer.valueOf(contentResolver.delete(uri2, str2, (String[]) array)));
                return ((Number) ExpectKt.successOrDefault(either, -1)).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
    }
}
