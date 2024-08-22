package com.mars.kotlin.database.extension;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.actions.SearchIntents;
import com.mars.kotlin.database.Query;
import com.mars.kotlin.database.QueryParams;
import com.mars.kotlin.extension.CursorKt;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000b\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001al\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011\"\u0006\b\u0000\u0010\u0006\u0018\u0001\"\f\b\u0001\u0010\t*\u00020\u0007*\u00020\b*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00028\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0019\b\t\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011*\u00020\u00002\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0011*\u00020\u00002\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001af\u0010\u001a\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00190\u0011\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0019\b\t\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001at\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010 0\u0011\"\b\b\u0000\u0010\u001d*\u00020\u001c\"\b\b\u0001\u0010\u001e*\u00020\u001c*\u00020\u00002\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2%\b\u0001\u0010\u0010\u001a\u001f\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b!\u0010\u001b\u001aT\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0019\b\b\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001b\u001aR\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#0\u0011\"\u0004\b\u0000\u0010\u0006*\u00020\u00002\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b$\u0010\u001b\u001af\u0010'\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010%j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`&0\u0011\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0019\b\t\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u001b\u001aT\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0019\b\t\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u001b\u001a\u001b\u0010)\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b)\u0010*\u001aV\u0010.\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0006\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u00028\u00000+*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010-\u001a\u00028\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b.\u0010/\u001a\u001d\u00100\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b0\u00101\u001aB\u00103\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000102\"\u0004\b\u0000\u0010\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b3\u00104\u001ab\u00105\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010 \"\b\b\u0000\u0010\u001d*\u00020\u001c\"\b\b\u0001\u0010\u001e*\u00020\u001c*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012#\u0010\u0010\u001a\u001f\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b5\u00106\u001a<\u00107\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b7\u00108\u001aN\u00109\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010%j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`&\"\u0004\b\u0000\u0010\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b9\u0010:\"\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b;\u0010<\u0002\u0007\n\u0005\b20\u0001¨\u0006="}, d2 = {"Lcom/mars/kotlin/database/Query;", "Landroid/content/Context;", "context", "", "count", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;)I", "T", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "R", "owner", "", "oneShot", "Lkotlin/Function1;", "Landroid/database/Cursor;", "Lkotlin/ExtensionFunctionType;", "something", "Landroidx/lifecycle/LiveData;", "fetch", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;Landroidx/lifecycle/ViewModelStoreOwner;ZLkotlin/jvm/functions/Function1;)Landroidx/lifecycle/LiveData;", "fetchCount", "(Lcom/mars/kotlin/database/Query;Landroidx/lifecycle/LifecycleOwner;Z)Landroidx/lifecycle/LiveData;", "fetchCursor", "(Lcom/mars/kotlin/database/Query;Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fetchList", "(Lcom/mars/kotlin/database/Query;Landroidx/lifecycle/LifecycleOwner;ZLkotlin/Function1;)Landroidx/lifecycle/LiveData;", "", "K", "V", "Lkotlin/Pair;", "", "fetchMap", "fetchOne", "Lkotlin/sequences/Sequence;", "fetchSequence", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "fetchSet", "fetchSomething", "isNotEmpty", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;)Z", "", "C", "destination", "toCollection", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "toCursor", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;)Landroid/database/Cursor;", "", "toList", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;Lkotlin/Function1;)Ljava/util/List;", "toMap", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;Lkotlin/Function1;)Ljava/util/Map;", "toOne", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toSet", "(Lcom/mars/kotlin/database/Query;Landroid/content/Context;Lkotlin/Function1;)Ljava/util/LinkedHashSet;", "getContext", "(Landroidx/lifecycle/LifecycleOwner;)Landroid/content/Context;", "database_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class QueryKt {
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        throw r1;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int count(@org.jetbrains.annotations.NotNull com.mars.kotlin.database.Query r2, @org.jetbrains.annotations.NotNull android.content.Context r3) {
        /*
            java.lang.String r0 = "$this$count"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.mars.kotlin.database.Column[] r0 = r2.getWhereColumns()
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = r2.getSingleWhere()
            if (r0 != 0) goto L_0x0025
            java.lang.Object[] r0 = r2.getWhereArgs()
            if (r0 != 0) goto L_0x0025
            android.net.Uri r2 = r2.getUri()
            int r2 = com.mars.kotlin.database.extension.UriKt.count(r2, r3)
            goto L_0x005d
        L_0x0025:
            android.database.Cursor r2 = toCursor(r2, r3)
            if (r2 == 0) goto L_0x005c
            r3 = 0
            int r0 = r2.getCount()     // Catch:{ all -> 0x003e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x003e }
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x003c }
            com.mars.kotlin.extension.fp.Either$Right r2 = com.mars.kotlin.extension.ExpectKt.success(r0)     // Catch:{ all -> 0x003c }
            goto L_0x004d
        L_0x003c:
            r2 = move-exception
            goto L_0x0045
        L_0x003e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x003c }
            throw r1     // Catch:{ all -> 0x003c }
        L_0x0045:
            r0 = 1
            com.mars.kotlin.extension.LoggerKt.e$default(r2, r3, r0, r3)
            com.mars.kotlin.extension.fp.Either$Left r2 = com.mars.kotlin.extension.ExpectKt.failure(r2)
        L_0x004d:
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = com.mars.kotlin.extension.ExpectKt.successOrNull(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x005c
            int r2 = r2.intValue()
            goto L_0x005d
        L_0x005c:
            r2 = -1
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.database.extension.QueryKt.count(com.mars.kotlin.database.Query, android.content.Context):int");
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T, R extends ViewModelStoreOwner & LifecycleOwner> LiveData<T> fetch(@NotNull Query query, @Nullable Context context, @NotNull R r, boolean z, @NotNull @WorkerThread Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$fetch");
        Intrinsics.checkNotNullParameter(r, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) r;
            LoaderManager instance = LoaderManager.getInstance(lifecycleOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(function1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Object.class).hashCode()), "type")).intValue();
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

    public static /* synthetic */ LiveData fetch$default(Query query, Context context, ViewModelStoreOwner viewModelStoreOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(query, "$this$fetch");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) viewModelStoreOwner;
            LoaderManager instance = LoaderManager.getInstance(lifecycleOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(function1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Object.class).hashCode()), "type")).intValue();
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

    @NotNull
    @MainThread
    public static final LiveData<Integer> fetchCount(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner, boolean z) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchCount");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        QueryKt$fetchCount$1 queryKt$fetchCount$1 = QueryKt$fetchCount$1.INSTANCE;
        Context context = getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchCount$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Integer.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchCount$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        LiveData<Integer> map = Transformations.map(mutableLiveData, QueryKt$fetchCount$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(fetc…       it ?: -1\n        }");
        return map;
    }

    public static /* synthetic */ LiveData fetchCount$default(Query query, LifecycleOwner lifecycleOwner, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return fetchCount(query, lifecycleOwner, z);
    }

    @NotNull
    @MainThread
    public static final LiveData<Cursor> fetchCursor(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchCursor");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        QueryKt$fetchCursor$1 queryKt$fetchCursor$1 = QueryKt$fetchCursor$1.INSTANCE;
        Context context = getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchCursor$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Cursor.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchCursor$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback((LoaderManager) null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T> LiveData<ArrayList<T>> fetchList(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull @WorkerThread Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchList");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchList$1 queryKt$fetchList$1 = new QueryKt$fetchList$1(function1);
        Context context = getContext(lifecycleOwner);
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

    public static /* synthetic */ LiveData fetchList$default(Query query, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(query, "$this$fetchList");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchList$1 queryKt$fetchList$1 = new QueryKt$fetchList$1(function1);
        Context context = getContext(lifecycleOwner);
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
    public static final <K, V> LiveData<Map<K, V>> fetchMap(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull @WorkerThread Function1<? super Cursor, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchMap");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchMap$1 queryKt$fetchMap$1 = new QueryKt$fetchMap$1(function1);
        Context context = getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchMap$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Map.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchMap$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    public static /* synthetic */ LiveData fetchMap$default(Query query, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return fetchMap(query, lifecycleOwner, z, function1);
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T> LiveData<T> fetchOne(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchOne");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchOne$1 queryKt$fetchOne$1 = new QueryKt$fetchOne$1(function1);
        Context context = getContext(lifecycleOwner);
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

    public static /* synthetic */ LiveData fetchOne$default(Query query, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(query, "$this$fetchOne");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchOne$1 queryKt$fetchOne$1 = new QueryKt$fetchOne$1(function1);
        Context context = getContext(lifecycleOwner);
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
    public static final <T> LiveData<Sequence<T>> fetchSequence(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchSequence");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchSequence$1 queryKt$fetchSequence$1 = new QueryKt$fetchSequence$1(function1);
        Context context = getContext(lifecycleOwner);
        LifecycleViewModelStoreOwner lifecycleViewModelStoreOwner = new LifecycleViewModelStoreOwner(lifecycleOwner);
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (context != null) {
            LoaderManager instance = LoaderManager.getInstance(lifecycleViewModelStoreOwner);
            Intrinsics.checkNotNullExpressionValue(instance, "LoaderManager.getInstance(owner)");
            int hashCode = ((Lifecycle) LoggerKt.d(lifecycleViewModelStoreOwner.getLifecycle(), "lifecycle")).hashCode() + ((Number) LoggerKt.d(Integer.valueOf(query.hashCode()), SearchIntents.EXTRA_QUERY)).intValue() + ((Number) LoggerKt.d(Integer.valueOf(queryKt$fetchSequence$1.getClass().hashCode()), "lambda")).intValue() + ((Number) LoggerKt.d(Integer.valueOf(Reflection.getOrCreateKotlinClass(Sequence.class).hashCode()), "type")).intValue();
            Loader loader = instance.getLoader(hashCode);
            if (loader == null) {
                FetchLoader fetchLoader = new FetchLoader(context, QueryParams.m683constructorimpl(query), mutableLiveData, queryKt$fetchSequence$1, (DefaultConstructorMarker) null);
                fetchLoader.setUpdateThrottle(1000);
                Intrinsics.checkNotNullExpressionValue(instance.initLoader(((Number) LoggerKt.d(Integer.valueOf(hashCode), "loaderId")).intValue(), (Bundle) null, new CursorLoaderCallback(z ? instance : null, fetchLoader)), "loaderManager.initLoader…aderId\"), null, callback)");
            } else {
                loader.forceLoad();
            }
        }
        return mutableLiveData;
    }

    public static /* synthetic */ LiveData fetchSequence$default(Query query, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return fetchSequence(query, lifecycleOwner, z, function1);
    }

    @NotNull
    @MainThread
    public static final /* synthetic */ <T> LiveData<LinkedHashSet<T>> fetchSet(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull @WorkerThread Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchSet");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchSet$1 queryKt$fetchSet$1 = new QueryKt$fetchSet$1(function1);
        Context context = getContext(lifecycleOwner);
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

    public static /* synthetic */ LiveData fetchSet$default(Query query, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(query, "$this$fetchSet");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        QueryKt$fetchSet$1 queryKt$fetchSet$1 = new QueryKt$fetchSet$1(function1);
        Context context = getContext(lifecycleOwner);
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
    public static final /* synthetic */ <T> LiveData<T> fetchSomething(@NotNull Query query, @NotNull LifecycleOwner lifecycleOwner, boolean z, @NotNull @WorkerThread Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$fetchSomething");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Context context = getContext(lifecycleOwner);
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

    public static /* synthetic */ LiveData fetchSomething$default(Query query, LifecycleOwner lifecycleOwner, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(query, "$this$fetchSomething");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "something");
        Context context = getContext(lifecycleOwner);
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

    @Nullable
    public static final Context getContext(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$this$context");
        if (lifecycleOwner instanceof Fragment) {
            return ((Fragment) lifecycleOwner).getContext();
        }
        if (lifecycleOwner instanceof ComponentActivity) {
            return ((ComponentActivity) lifecycleOwner).getApplicationContext();
        }
        LoggerKt.e$default("owner must be Fragment or ComponentActivity", (Object) null, 1, (Object) null);
        return null;
    }

    @WorkerThread
    public static final boolean isNotEmpty(@NotNull Query query, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(query, "$this$isNotEmpty");
        Intrinsics.checkNotNullParameter(context, "context");
        return count(query, context) > 0;
    }

    @WorkerThread
    @Nullable
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Query query, @NotNull Context context, @NotNull C c, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$toCollection");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "something");
        Cursor cursor = toCursor(query, context);
        if (cursor != null) {
            return CursorKt.toCollection(cursor, c, function1);
        }
        return null;
    }

    @WorkerThread
    @Nullable
    @SuppressLint({"Recycle"})
    public static final Cursor toCursor(@NotNull Query query, @NotNull Context context) {
        Either either;
        Object obj;
        Intrinsics.checkNotNullParameter(query, "$this$toCursor");
        Intrinsics.checkNotNullParameter(context, "context");
        Query r8 = QueryParams.m683constructorimpl(query);
        try {
            ContentResolver contentResolver = context.getContentResolver();
            either = ExpectKt.success(contentResolver != null ? contentResolver.query(QueryParams.m682buildUriimpl(r8), QueryParams.m687projectionimpl(r8), QueryParams.m690whereimpl(r8), QueryParams.m691whereArgsimpl(r8), QueryParams.m688sortimpl(r8)) : null);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        Cursor cursor = (Cursor) ExpectKt.successOrNull(either);
        if (cursor == null) {
            return null;
        }
        try {
            obj = ExpectKt.success(Integer.valueOf(cursor.getCount()));
        } catch (Throwable th3) {
            LoggerKt.e$default(th3, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th3);
        }
        if (obj instanceof Either.Left) {
            Throwable th4 = (Throwable) ((Either.Left) obj).getValue();
            if (!cursor.isClosed()) {
                cursor.close();
            }
            new Either.Left(Unit.INSTANCE);
        } else if (!(obj instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
        return cursor;
    }

    @WorkerThread
    @Nullable
    public static final <T> List<T> toList(@NotNull Query query, @NotNull Context context, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$toList");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "something");
        return (List) toCollection(query, context, new ArrayList(), function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        throw r0;
     */
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <K, V> java.util.Map<K, V> toMap(@org.jetbrains.annotations.NotNull com.mars.kotlin.database.Query r3, @org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends kotlin.Pair<? extends K, ? extends V>> r5) {
        /*
            java.lang.String r0 = "$this$toMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "something"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.database.Cursor r3 = toCursor(r3, r4)
            r4 = 0
            if (r3 == 0) goto L_0x0052
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ all -> 0x003b }
            r0.<init>()     // Catch:{ all -> 0x003b }
        L_0x001b:
            boolean r1 = r3.moveToNext()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r5.invoke(r3)     // Catch:{ all -> 0x003b }
            kotlin.Pair r1 = (kotlin.Pair) r1     // Catch:{ all -> 0x003b }
            java.lang.Object r2 = r1.component1()     // Catch:{ all -> 0x003b }
            java.lang.Object r1 = r1.component2()     // Catch:{ all -> 0x003b }
            r0.put(r2, r1)     // Catch:{ all -> 0x003b }
            goto L_0x001b
        L_0x0033:
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x0042 }
            com.mars.kotlin.extension.fp.Either$Right r3 = com.mars.kotlin.extension.ExpectKt.success(r0)     // Catch:{ all -> 0x0042 }
            goto L_0x004b
        L_0x003b:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r5)     // Catch:{ all -> 0x0042 }
            throw r0     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r3 = move-exception
            r5 = 1
            com.mars.kotlin.extension.LoggerKt.e$default(r3, r4, r5, r4)
            com.mars.kotlin.extension.fp.Either$Left r3 = com.mars.kotlin.extension.ExpectKt.failure(r3)
        L_0x004b:
            java.lang.Object r3 = com.mars.kotlin.extension.ExpectKt.successOrNull(r3)
            r4 = r3
            java.util.Map r4 = (java.util.Map) r4
        L_0x0052:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.database.extension.QueryKt.toMap(com.mars.kotlin.database.Query, android.content.Context, kotlin.jvm.functions.Function1):java.util.Map");
    }

    @WorkerThread
    @Nullable
    public static final <T> T toOne(@NotNull Query query, @NotNull Context context, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$toOne");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "something");
        Cursor cursor = toCursor(query, context);
        if (cursor != null) {
            return CursorKt.toOne(cursor, function1);
        }
        return null;
    }

    @WorkerThread
    @Nullable
    public static final <T> LinkedHashSet<T> toSet(@NotNull Query query, @NotNull Context context, @NotNull Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(query, "$this$toSet");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "something");
        return (LinkedHashSet) toCollection(query, context, new LinkedHashSet(), function1);
    }
}
