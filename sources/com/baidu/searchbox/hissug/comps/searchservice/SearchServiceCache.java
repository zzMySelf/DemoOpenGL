package com.baidu.searchbox.hissug.comps.searchservice;

import android.util.Log;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.hissug.model.SearchServiceItemModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0003J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/hissug/comps/searchservice/SearchServiceCache;", "", "()V", "CACHE_FILE_NAME", "", "SP_KEY_HAS_CACHE", "cacheFileLock", "", "memoryCache", "", "Lcom/baidu/searchbox/hissug/model/SearchServiceItemModel;", "cacheSearchServices", "serviceJson", "Lorg/json/JSONObject;", "getCachedJsonString", "getCachedSearchServices", "getMemoryCachedSearchServices", "hasCachedSearchServices", "", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchServiceCache.kt */
public final class SearchServiceCache {
    private static final String CACHE_FILE_NAME = "search_hissug_service_list_data";
    public static final SearchServiceCache INSTANCE = new SearchServiceCache();
    private static final String SP_KEY_HAS_CACHE = "search_hissug_has_search_service_cache";
    private static final byte[] cacheFileLock = new byte[0];
    private static volatile List<SearchServiceItemModel> memoryCache;

    private SearchServiceCache() {
    }

    /* Debug info: failed to restart local var, previous not found, register: 20 */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
        r5 = kotlin.Result.Companion;
        r0 = kotlin.Result.m8971constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010d, code lost:
        r5 = kotlin.Result.Companion;
        r0 = kotlin.Result.m8971constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.baidu.searchbox.hissug.model.SearchServiceItemModel> cacheSearchServices(org.json.JSONObject r21) {
        /*
            r20 = this;
            r1 = r21
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0063 }
            r0 = r20
            com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache r0 = (com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache) r0     // Catch:{ all -> 0x0063 }
            r3 = 0
            r4 = 0
            r4 = 1
            if (r1 == 0) goto L_0x005b
            java.lang.String r5 = "data"
            org.json.JSONArray r5 = r1.optJSONArray(r5)     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x005b
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0063 }
            r7.<init>()     // Catch:{ all -> 0x0063 }
            r8 = r5
            r9 = 0
            r10 = 0
            int r11 = r8.length()     // Catch:{ all -> 0x0063 }
        L_0x0022:
            if (r10 >= r11) goto L_0x0054
            org.json.JSONObject r12 = r8.optJSONObject(r10)     // Catch:{ all -> 0x0063 }
            r13 = 0
            r14 = r12
            r15 = 0
            com.baidu.searchbox.hissug.model.SearchServiceItemModel$Companion r2 = com.baidu.searchbox.hissug.model.SearchServiceItemModel.Companion     // Catch:{ all -> 0x0063 }
            com.baidu.searchbox.hissug.model.SearchServiceItemModel r2 = r2.fromJson(r14)     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0043
            r16 = r2
            r17 = 0
            int r18 = r4 + 1
            r19 = r0
            r0 = r16
            r0.setIndex(r4)     // Catch:{ all -> 0x0063 }
            r4 = r18
            goto L_0x0046
        L_0x0043:
            r19 = r0
            r2 = 0
        L_0x0046:
            if (r2 == 0) goto L_0x004e
            r0 = r2
            r2 = 0
            r7.add(r0)     // Catch:{ all -> 0x0063 }
            goto L_0x004f
        L_0x004e:
        L_0x004f:
            int r10 = r10 + 1
            r0 = r19
            goto L_0x0022
        L_0x0054:
            r19 = r0
            r0 = r7
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0063 }
            goto L_0x005e
        L_0x005b:
            r19 = r0
            r0 = 0
        L_0x005e:
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x0063 }
            goto L_0x006e
        L_0x0063:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x006e:
            boolean r2 = kotlin.Result.m8977isFailureimpl(r0)
            if (r2 == 0) goto L_0x0076
            r2 = 0
            goto L_0x0077
        L_0x0076:
            r2 = r0
        L_0x0077:
            java.util.List r2 = (java.util.List) r2
            r0 = r2
            java.util.Collection r0 = (java.util.Collection) r0
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x008a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            r0 = r3
            goto L_0x008b
        L_0x008a:
            r0 = r4
        L_0x008b:
            if (r0 == 0) goto L_0x00e3
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00b1 }
            r0 = r20
            com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache r0 = (com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache) r0     // Catch:{ all -> 0x00b1 }
            r5 = r0
            r6 = 0
            byte[] r7 = cacheFileLock     // Catch:{ all -> 0x00b1 }
            monitor-enter(r7)     // Catch:{ all -> 0x00b1 }
            r0 = 0
            android.content.Context r8 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x00ae }
            java.lang.String r9 = "search_hissug_service_list_data"
            boolean r8 = com.baidu.android.util.io.FileUtils.deleteCache(r8, r9)     // Catch:{ all -> 0x00ae }
            monitor-exit(r7)     // Catch:{ all -> 0x00b1 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x00b1 }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x00bc
        L_0x00ae:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00b1 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r0 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x00bc:
            java.lang.Throwable r0 = kotlin.Result.m8974exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x013e
            r5 = 0
            boolean r6 = com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCacheKt.DEBUG
            if (r6 == 0) goto L_0x00e1
            java.lang.String r6 = "SearchServiceCache"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "delete search service fail, error="
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            android.util.Log.w(r6, r7)
        L_0x00e1:
            goto L_0x013e
        L_0x00e3:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x010c }
            r0 = r20
            com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache r0 = (com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache) r0     // Catch:{ all -> 0x010c }
            r5 = r0
            r6 = 0
            java.lang.String r0 = java.lang.String.valueOf(r21)     // Catch:{ all -> 0x010c }
            r7 = r0
            byte[] r8 = cacheFileLock     // Catch:{ all -> 0x010c }
            monitor-enter(r8)     // Catch:{ all -> 0x010c }
            r0 = 0
            android.content.Context r9 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x0109 }
            java.lang.String r10 = "search_hissug_service_list_data"
            boolean r9 = com.baidu.android.util.io.FileUtils.cache((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r7, (int) r3)     // Catch:{ all -> 0x0109 }
            monitor-exit(r8)     // Catch:{ all -> 0x010c }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x010c }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x010c }
            goto L_0x0117
        L_0x0109:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x010c }
            throw r0     // Catch:{ all -> 0x010c }
        L_0x010c:
            r0 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x0117:
            java.lang.Throwable r0 = kotlin.Result.m8974exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x013e
            r5 = 0
            boolean r6 = com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCacheKt.DEBUG
            if (r6 == 0) goto L_0x013c
            java.lang.String r6 = "SearchServiceCache"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "cache search service fail, error="
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            android.util.Log.w(r6, r7)
        L_0x013c:
        L_0x013e:
            com.baidu.searchbox.config.DefaultSharedPrefsWrapper r0 = com.baidu.searchbox.config.DefaultSharedPrefsWrapper.getInstance()
            java.lang.String r5 = "search_hissug_has_search_service_cache"
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x0150
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0151
        L_0x0150:
            r3 = r4
        L_0x0151:
            r3 = r3 ^ r4
            r0.putBoolean(r5, r3)
            if (r2 != 0) goto L_0x015c
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x015d
        L_0x015c:
            r0 = r2
        L_0x015d:
            memoryCache = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache.cacheSearchServices(org.json.JSONObject):java.util.List");
    }

    /* Debug info: failed to restart local var, previous not found, register: 6 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r1 = kotlin.Result.Companion;
        r0 = kotlin.Result.m8971constructorimpl(kotlin.ResultKt.createFailure(r0));
        r1 = kotlin.Result.m8974exceptionOrNullimpl(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        android.util.Log.w("SearchServiceCache", "getCachedJsonString fail, error = " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (kotlin.Result.m8977isFailureimpl(r0) != false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        return (java.lang.String) r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getCachedJsonString() {
        /*
            r6 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x001a }
            r0 = r6
            com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache r0 = (com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache) r0     // Catch:{ all -> 0x001a }
            r1 = 0
            byte[] r2 = cacheFileLock     // Catch:{ all -> 0x001a }
            monitor-enter(r2)     // Catch:{ all -> 0x001a }
            r3 = 0
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x0017 }
            java.lang.String r5 = "search_hissug_service_list_data"
            java.lang.String r4 = com.baidu.android.util.io.FileUtils.readCacheData(r4, r5)     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            return r4
        L_0x0017:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            throw r3     // Catch:{ all -> 0x001a }
        L_0x001a:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
            java.lang.Throwable r1 = kotlin.Result.m8974exceptionOrNullimpl(r0)
            if (r1 == 0) goto L_0x004c
            r2 = 0
            boolean r3 = com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCacheKt.DEBUG
            if (r3 == 0) goto L_0x004a
            java.lang.String r3 = "SearchServiceCache"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getCachedJsonString fail, error = "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.w(r3, r4)
        L_0x004a:
        L_0x004c:
            boolean r1 = kotlin.Result.m8977isFailureimpl(r0)
            if (r1 == 0) goto L_0x0053
            r0 = 0
        L_0x0053:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.hissug.comps.searchservice.SearchServiceCache.getCachedJsonString():java.lang.String");
    }

    public final List<SearchServiceItemModel> getMemoryCachedSearchServices() {
        if (SearchServiceCacheKt.DEBUG) {
            Log.i("SearchServiceCache", "getCachedSearchServices from memory=" + memoryCache);
        }
        return memoryCache;
    }

    public final boolean hasCachedSearchServices() {
        return DefaultSharedPrefsWrapper.getInstance().getBoolean(SP_KEY_HAS_CACHE, false);
    }

    public final List<SearchServiceItemModel> getCachedSearchServices() {
        Object obj;
        List list;
        SearchServiceCache $this$getCachedSearchServices_u24lambda_u2d14;
        if (memoryCache != null) {
            if (SearchServiceCacheKt.DEBUG) {
                Log.i("SearchServiceCache", "getCachedSearchServices from memory");
            }
            return memoryCache;
        }
        if (SearchServiceCacheKt.DEBUG) {
            Log.i("SearchServiceCache", "getCachedSearchServices from disk");
        }
        String cachedJsonString = getCachedJsonString();
        if (cachedJsonString == null) {
            return null;
        }
        String jsonString = cachedJsonString;
        try {
            Result.Companion companion = Result.Companion;
            SearchServiceCache $this$getCachedSearchServices_u24lambda_u2d142 = this;
            int i2 = 1;
            JSONArray $this$mapObjectNotNull$iv = new JSONObject(jsonString).optJSONArray("data");
            if ($this$mapObjectNotNull$iv != null) {
                Intrinsics.checkNotNullExpressionValue($this$mapObjectNotNull$iv, "optJSONArray(\"data\")");
                ArrayList destination$iv = new ArrayList();
                JSONArray $this$forEachObject$iv$iv = $this$mapObjectNotNull$iv;
                int i$iv$iv = 0;
                int length = $this$forEachObject$iv$iv.length();
                while (i$iv$iv < length) {
                    SearchServiceItemModel $this$getCachedSearchServices_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12 = SearchServiceItemModel.Companion.fromJson($this$forEachObject$iv$iv.optJSONObject(i$iv$iv));
                    if ($this$getCachedSearchServices_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12 != null) {
                        $this$getCachedSearchServices_u24lambda_u2d14 = $this$getCachedSearchServices_u24lambda_u2d142;
                        $this$getCachedSearchServices_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.setIndex(i2);
                        i2++;
                    } else {
                        $this$getCachedSearchServices_u24lambda_u2d14 = $this$getCachedSearchServices_u24lambda_u2d142;
                        $this$getCachedSearchServices_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12 = null;
                    }
                    if ($this$getCachedSearchServices_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12 != null) {
                        destination$iv.add($this$getCachedSearchServices_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12);
                    }
                    i$iv$iv++;
                    $this$getCachedSearchServices_u24lambda_u2d142 = $this$getCachedSearchServices_u24lambda_u2d14;
                }
                list = destination$iv;
            } else {
                list = null;
            }
            obj = Result.m8971constructorimpl(list);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && SearchServiceCacheKt.DEBUG) {
            Log.w("SearchServiceCache", "getCachedSearchServices error = " + it);
        }
        List diskCache = (List) (Result.m8977isFailureimpl(obj) ? null : obj);
        memoryCache = diskCache == null ? CollectionsKt.emptyList() : diskCache;
        return diskCache;
    }
}
