package com.mars.kotlin.database.extension;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.alipay.sdk.m.n.a;
import com.google.android.gms.actions.SearchIntents;
import com.mars.kotlin.database.Column;
import com.mars.kotlin.database.ColumnKt;
import com.mars.kotlin.database.Delete;
import com.mars.kotlin.database.Query;
import com.mars.kotlin.database.QueryParams;
import com.mars.kotlin.extension.LoggerKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u001b\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0011\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b\u0010\u0010\u0006\u001a%\u0010\u0011\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0006\u001a+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0016*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001af\u0010\"\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010 j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`!0\u0016\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a|\u0010)\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010(0\u0016\"\n\b\u0000\u0010%\u0018\u0001*\u00020$\"\n\b\u0001\u0010&\u0018\u0001*\u00020$*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142%\b\b\u0010\u001f\u001a\u001f\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\b)\u0010#\u001aT\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0016\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\b*\u0010#\u001af\u0010-\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010+j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`,0\u0016\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\b-\u0010#\u001aT\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0016\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\b.\u0010#\u001a\u001b\u0010/\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b/\u00100\u001a!\u00104\u001a\u00020\u0000*\u00020\u00002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0007¢\u0006\u0004\b2\u00103\u001a%\u00104\u001a\u00020\u0000*\u00020\u00002\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0001\"\u00020\u0000¢\u0006\u0004\b4\u00103\u001a\u001b\u00107\u001a\u00020\u0000*\u00020\u00002\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108\u001a\u001b\u0010:\u001a\u00020\u0000*\u00020\u00002\b\b\u0001\u00109\u001a\u00020\n¢\u0006\u0004\b:\u0010;\u001a!\u0010>\u001a\u00020\u0004*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0004\b=\u0010\u0006\u001a%\u0010>\u001a\u00020\u0004*\u00020\u00002\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b>\u0010\u0006\u001a\u0019\u0010A\u001a\u00020\u0004*\u00020\u00002\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010B\u001a\u0019\u0010C\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020?¢\u0006\u0004\bC\u0010B\u001a`\u0010G\u001a\u0004\u0018\u00018\u0001\"\u0006\b\u0000\u0010\u001c\u0018\u0001\"\u0012\b\u0001\u0010E\u0018\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000D*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010F\u001a\u00028\u00012\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a\u001d\u0010I\u001a\u0004\u0018\u00010\u0019*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\bI\u0010J\u001aJ\u0010L\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010K\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001al\u0010N\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010(\"\n\b\u0000\u0010%\u0018\u0001*\u00020$\"\n\b\u0001\u0010&\u0018\u0001*\u00020$*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2%\b\b\u0010\u001f\u001a\u001f\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001aD\u0010P\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001aV\u0010R\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010+j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`,\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0019\b\b\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a$\u0010@\u001a\u00020U*\u00020\u00002\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007ø\u0001\u0001¢\u0006\u0004\bV\u0010\u0006\u001a(\u0010@\u001a\u00020U*\u00020\u00002\u0012\u0010T\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002ø\u0001\u0001¢\u0006\u0004\b@\u0010\u0006\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006W"}, d2 = {"Landroid/net/Uri;", "", "Lcom/mars/kotlin/database/Column;", "orderBy", "Lcom/mars/kotlin/database/Query;", "ascByArray", "(Landroid/net/Uri;[Lcom/mars/kotlin/database/Column;)Lcom/mars/kotlin/database/Query;", "asc", "Landroid/content/Context;", "context", "", "count", "(Landroid/net/Uri;Landroid/content/Context;)I", "Lcom/mars/kotlin/database/Delete;", "delete", "(Landroid/net/Uri;Landroid/content/Context;)Lcom/mars/kotlin/database/Delete;", "descByArray", "desc", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "oneShot", "Landroidx/lifecycle/LiveData;", "fetchCount", "(Landroid/net/Uri;Landroidx/lifecycle/LifecycleOwner;Z)Landroidx/lifecycle/LiveData;", "Landroid/database/Cursor;", "fetchCursor", "(Landroid/net/Uri;Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LiveData;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "something", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fetchList", "(Landroid/net/Uri;Landroidx/lifecycle/LifecycleOwner;ZLkotlin/Function1;)Landroidx/lifecycle/LiveData;", "", "K", "V", "Lkotlin/Pair;", "", "fetchMap", "fetchOne", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "fetchSet", "fetchSomething", "isNotEmpty", "(Landroid/net/Uri;Landroid/content/Context;)Z", "uris", "mapByArray", "(Landroid/net/Uri;[Landroid/net/Uri;)Landroid/net/Uri;", "map", "Lcom/mars/kotlin/database/extension/Disable;", "disable", "notify", "(Landroid/net/Uri;Lcom/mars/kotlin/database/extension/Disable;)Landroid/net/Uri;", "conflict", "onConflict", "(Landroid/net/Uri;I)Landroid/net/Uri;", "columns", "selectByArray", "select", "", "where", "singleWhere", "(Landroid/net/Uri;Ljava/lang/String;)Lcom/mars/kotlin/database/Query;", "sort", "", "C", "destination", "toCollection", "(Landroid/net/Uri;Landroid/content/Context;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "toCursor", "(Landroid/net/Uri;Landroid/content/Context;)Landroid/database/Cursor;", "", "toList", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/Function1;)Ljava/util/List;", "toMap", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/Function1;)Ljava/util/Map;", "toOne", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toSet", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/Function1;)Ljava/util/LinkedHashSet;", "args", "Lcom/mars/kotlin/database/WhereArgs;", "whereByArray", "database_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class UriKt {
    @NotNull
    public static final Query asc(@NotNull Uri uri, @NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$asc");
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).asc((Column[]) Arrays.copyOf(columnArr, columnArr.length));
    }

    @NotNull
    @JvmName(name = "ascByArray")
    public static final Query ascByArray(@NotNull Uri uri, @NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$asc");
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).ascByArray(columnArr);
    }

    @WorkerThread
    public static final int count(@NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, "$this$count");
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = (Integer) QueryKt.toOne(select(uri, ColumnKt.getANY().count()), context, UriKt$count$1.INSTANCE);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @NotNull
    public static final Delete delete(@NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, "$this$delete");
        Intrinsics.checkNotNullParameter(context, "context");
        return new Delete(uri, context);
    }

    @NotNull
    public static final Query desc(@NotNull Uri uri, @NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$desc");
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).desc((Column[]) Arrays.copyOf(columnArr, columnArr.length));
    }

    @NotNull
    @JvmName(name = "descByArray")
    public static final Query descByArray(@NotNull Uri uri, @NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$desc");
        Intrinsics.checkNotNullParameter(columnArr, "orderBy");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).descByArray(columnArr);
    }

    @NotNull
    @MainThread
    public static final LiveData<Integer> fetchCount(@NotNull Uri uri, @NotNull LifecycleOwner lifecycleOwner, boolean z) {
        Intrinsics.checkNotNullParameter(uri, "$this$fetchCount");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Query select = select(uri, ColumnKt.getANY().count());
        UriKt$fetchCount$1 uriKt$fetchCount$1 = UriKt$fetchCount$1.INSTANCE;
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(select.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(uriKt$fetchCount$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Integer.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(select), mutableLiveData, uriKt$fetchCount$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        LiveData<Integer> map = Transformations.map(mutableLiveData, UriKt$fetchCount$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(\n   …)\n        }) { it ?: -1 }");
        return map;
    }

    public static /* synthetic */ LiveData fetchCount$default(Uri uri, LifecycleOwner lifecycleOwner, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return fetchCount(uri, lifecycleOwner, z);
    }

    @NotNull
    @MainThread
    public static final LiveData<Cursor> fetchCursor(@NotNull Uri uri, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(uri, "$this$fetchCursor");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        return QueryKt.fetchCursor(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), lifecycleOwner);
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T> LiveData<ArrayList<T>> fetchList(@NotNull Uri uri, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$fetchList");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        QueryKt$fetchList$1 queryKt$fetchList$1 = new QueryKt$fetchList$1(function1);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchList$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(ArrayList.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchList$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    public static /* synthetic */ LiveData fetchList$default(Uri uri, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(uri, "$this$fetchList");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        QueryKt$fetchList$1 queryKt$fetchList$1 = new QueryKt$fetchList$1(function1);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchList$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(ArrayList.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchList$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <K, V> LiveData<Map<K, V>> fetchMap(@NotNull Uri uri, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull Function1<? super Cursor, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$fetchMap");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        return QueryKt.fetchMap(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), lifecycleOwner, z, function1);
    }

    public static /* synthetic */ LiveData fetchMap$default(Uri uri, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(uri, "$this$fetchMap");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        return QueryKt.fetchMap(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), lifecycleOwner, z, function1);
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T> LiveData<T> fetchOne(@NotNull Uri uri, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$fetchOne");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        QueryKt$fetchOne$1 queryKt$fetchOne$1 = new QueryKt$fetchOne$1(function1);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            Intrinsics.reifiedOperationMarker(4, "T?");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchOne$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Object.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchOne$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    public static /* synthetic */ LiveData fetchOne$default(Uri uri, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(uri, "$this$fetchOne");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        QueryKt$fetchOne$1 queryKt$fetchOne$1 = new QueryKt$fetchOne$1(function1);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            Intrinsics.reifiedOperationMarker(4, "T?");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchOne$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Object.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchOne$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T> LiveData<LinkedHashSet<T>> fetchSet(@NotNull Uri uri, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$fetchSet");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        QueryKt$fetchSet$1 queryKt$fetchSet$1 = new QueryKt$fetchSet$1(function1);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchSet$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(LinkedHashSet.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchSet$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    public static /* synthetic */ LiveData fetchSet$default(Uri uri, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(uri, "$this$fetchSet");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        QueryKt$fetchSet$1 queryKt$fetchSet$1 = new QueryKt$fetchSet$1(function1);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchSet$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(LinkedHashSet.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchSet$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T> LiveData<T> fetchSomething(@NotNull Uri uri, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$fetchSomething");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(function1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Object.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, function1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    public static /* synthetic */ LiveData fetchSomething$default(Uri uri, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(uri, "$this$fetchSomething");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Query query = new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null);
        Context context = QueryKt.getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(function1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Object.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, function1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    @WorkerThread
    public static final boolean isNotEmpty(@NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, "$this$isNotEmpty");
        Intrinsics.checkNotNullParameter(context, "context");
        return count(uri, context) > 0;
    }

    @NotNull
    public static final Uri map(@NotNull Uri uri, @NotNull Uri... uriArr) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(uri, "$this$map");
        Intrinsics.checkNotNullParameter(uriArr, "uris");
        String queryParameter = uri.getQueryParameter("__map__");
        StringBuilder sb = new StringBuilder();
        if (uriArr.length == 1) {
            str = uriArr[0].toString();
        } else {
            str = ArraysKt___ArraysKt.joinToString$default((Object[]) uriArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) UriKt$map$urisMap$2.INSTANCE, 31, (Object) null) + "@@@";
        }
        sb.append(str);
        if (queryParameter == null) {
            str2 = "";
        } else {
            str2 = "@@@" + queryParameter;
        }
        sb.append(str2);
        Uri build = uri.buildUpon().appendQueryParameter("__map__", sb.toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "buildUpon().appendQueryP…ter(key, urisMap).build()");
        return build;
    }

    @NotNull
    @JvmName(name = "mapByArray")
    public static final Uri mapByArray(@NotNull Uri uri, @NotNull Uri[] uriArr) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(uri, "$this$map");
        Intrinsics.checkNotNullParameter(uriArr, "uris");
        String queryParameter = uri.getQueryParameter("__map__");
        StringBuilder sb = new StringBuilder();
        if (uriArr.length == 1) {
            str = uriArr[0].toString();
        } else {
            str = ArraysKt___ArraysKt.joinToString$default((Object[]) uriArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) UriKt$map$urisMap$1.INSTANCE, 31, (Object) null) + "@@@";
        }
        sb.append(str);
        if (queryParameter == null) {
            str2 = "";
        } else {
            str2 = "@@@" + queryParameter;
        }
        sb.append(str2);
        Uri build = uri.buildUpon().appendQueryParameter("__map__", sb.toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "buildUpon().appendQueryP…ter(key, urisMap).build()");
        return build;
    }

    @NotNull
    public static final Uri notify(@NotNull Uri uri, @Nullable Disable disable) {
        Uri uri2;
        Uri uri3 = uri;
        Intrinsics.checkNotNullParameter(uri3, "$this$notify");
        String queryParameter = uri3.getQueryParameter("__notify__");
        if (disable == null) {
            if (queryParameter != null && !Intrinsics.areEqual((Object) queryParameter, (Object) "")) {
                String uri4 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "toString()");
                String replace$default = StringsKt__StringsJVMKt.replace$default(uri4, a.h + Disable.ALL.getValue(), "=", false, 4, (Object) null);
                uri3 = Uri.parse(StringsKt__StringsJVMKt.replace$default(replace$default, a.h + Disable.EMPTY.getValue(), "=", false, 4, (Object) null));
            }
            Intrinsics.checkNotNullExpressionValue(uri2, "if (old == null || old =…)\n            )\n        }");
        } else {
            if (queryParameter == null) {
                uri2 = uri.buildUpon().appendQueryParameter("__notify__", disable.getValue()).build();
            } else {
                String uri5 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri5, "toString()");
                String replace$default2 = StringsKt__StringsJVMKt.replace$default(uri5, a.h + Disable.ALL.getValue(), disable.getValue(), false, 4, (Object) null);
                uri2 = Uri.parse(StringsKt__StringsJVMKt.replace$default(replace$default2, a.h + Disable.EMPTY.getValue(), disable.getValue(), false, 4, (Object) null));
            }
            Intrinsics.checkNotNullExpressionValue(uri2, "if (old == null) {\n     …)\n            )\n        }");
        }
        return uri2;
    }

    @NotNull
    public static final Uri onConflict(@NotNull Uri uri, @ConflictType int i2) {
        Intrinsics.checkNotNullParameter(uri, "$this$onConflict");
        Uri build = uri.buildUpon().appendQueryParameter("__onconflict__", String.valueOf(i2)).build();
        Intrinsics.checkNotNullExpressionValue(build, "buildUpon().appendQueryP…flict.toString()).build()");
        return build;
    }

    @NotNull
    public static final Query select(@NotNull Uri uri, @NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$select");
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        return new Query(uri, columnArr);
    }

    @NotNull
    @JvmName(name = "selectByArray")
    public static final Query selectByArray(@NotNull Uri uri, @NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$select");
        Intrinsics.checkNotNullParameter(columnArr, "columns");
        return new Query(uri, columnArr);
    }

    @NotNull
    public static final Query singleWhere(@NotNull Uri uri, @NotNull String str) {
        Intrinsics.checkNotNullParameter(uri, "$this$singleWhere");
        Intrinsics.checkNotNullParameter(str, "where");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).singleWhere(str);
    }

    @NotNull
    public static final Query sort(@NotNull Uri uri, @NotNull String str) {
        Intrinsics.checkNotNullParameter(uri, "$this$sort");
        Intrinsics.checkNotNullParameter(str, "orderBy");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).sort(str);
    }

    @WorkerThread
    @Nullable
    public static final /* synthetic */ <T, C extends Collection<? super T>> C toCollection(@NotNull Uri uri, @NotNull Context context, @NotNull C c, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$toCollection");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "something");
        return QueryKt.toCollection(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), context, c, function1);
    }

    @WorkerThread
    @Nullable
    public static final Cursor toCursor(@NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, "$this$toCursor");
        Intrinsics.checkNotNullParameter(context, "context");
        return QueryKt.toCursor(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), context);
    }

    @WorkerThread
    @Nullable
    public static final /* synthetic */ <T> List<T> toList(@NotNull Uri uri, @NotNull Context context, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$toList");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "something");
        return QueryKt.toList(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), context, function1);
    }

    @WorkerThread
    @Nullable
    public static final /* synthetic */ <K, V> Map<K, V> toMap(@NotNull Uri uri, @NotNull Context context, @NotNull Function1<? super Cursor, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$toMap");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "something");
        return QueryKt.toMap(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), context, function1);
    }

    @WorkerThread
    @Nullable
    public static final /* synthetic */ <T> T toOne(@NotNull Uri uri, @NotNull Context context, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$toOne");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "something");
        return QueryKt.toOne(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), context, function1);
    }

    @WorkerThread
    @Nullable
    public static final /* synthetic */ <T> LinkedHashSet<T> toSet(@NotNull Uri uri, @NotNull Context context, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(uri, "$this$toSet");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "something");
        return QueryKt.toSet(new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null), context, function1);
    }

    @NotNull
    public static final Query where(@NotNull Uri uri, @NotNull Column... columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$where");
        Intrinsics.checkNotNullParameter(columnArr, "args");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).m680whereqFVhEZo((Column[]) Arrays.copyOf(columnArr, columnArr.length));
    }

    @NotNull
    @JvmName(name = "whereByArray")
    public static final Query whereByArray(@NotNull Uri uri, @NotNull Column[] columnArr) {
        Intrinsics.checkNotNullParameter(uri, "$this$where");
        Intrinsics.checkNotNullParameter(columnArr, "args");
        return new Query(uri, (Column[]) null, 2, (DefaultConstructorMarker) null).whereByArray(columnArr);
    }
}
