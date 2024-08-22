package com.baidu.searchbox.hissug.his;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import com.baidu.searchbox.hissug.data.model.HisTagDataModel;
import com.baidu.searchbox.hissug.data.model.SearchHistory;
import com.baidu.searchbox.hissug.eventbus.model.HisCacheChangeEvent;
import com.baidu.searchbox.hissug.searchable.bean.Suggestion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0007J\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001d\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0006J8\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ \u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\b\u0010%\u001a\u00020\u0013H\u0002J\n\u0010&\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010'\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010(\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010*\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/hissug/his/NetHistoryCacheManager;", "", "()V", "DEBUG", "", "TAG", "", "cacheData", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/hissug/searchable/bean/Suggestion;", "Lkotlin/collections/ArrayList;", "cacheJsonData", "Lorg/json/JSONArray;", "fileName", "freqHisJson", "freqHisList", "freqHisfileName", "hisCacheFileLock", "clearWebHisCache", "", "coverAllCache", "data", "deleteSuggestion", "hisSug", "getCacheServerHistory", "", "Lcom/baidu/searchbox/hissug/data/model/SearchHistory;", "getCacheSuggestion", "isSyncEnable", "getHisCache", "indexOfNetHisInCache", "", "item", "insertNormalHis", "query", "parseData", "parseFreqHis", "postHisCacheChangeEvent", "readFile", "readFreqHisFile", "setCacheData", "freqHisData", "writeFile", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetHistoryCacheManager.kt */
public final class NetHistoryCacheManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final NetHistoryCacheManager INSTANCE = new NetHistoryCacheManager();
    private static final String TAG = "NetHistoryCacheManager";
    private static ArrayList<Suggestion> cacheData;
    private static JSONArray cacheJsonData;
    private static final String fileName = "nethistorycachefile";
    private static JSONArray freqHisJson;
    private static ArrayList<Suggestion> freqHisList = new ArrayList<>();
    private static final String freqHisfileName = "freqHisNethistorycachefile2";
    private static final Object hisCacheFileLock = new Object();

    private NetHistoryCacheManager() {
    }

    public final void coverAllCache(String data) {
        Object obj;
        if (data != null) {
            try {
                Result.Companion companion = Result.Companion;
                JSONObject json = new JSONObject(data);
                coverAllCache(json.optJSONArray("data"), json.optJSONArray("frequent_his"));
                obj = Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable it = Result.m8974exceptionOrNullimpl(obj);
            if (it != null && DEBUG) {
                it.printStackTrace();
            }
        }
    }

    public final void coverAllCache(JSONArray data, JSONArray freqHisList2) {
        if (DEBUG) {
            Log.i(TAG, "coverAllCache ");
        }
        if (HistoryConfig.isSyncEnable()) {
            if ((data == null || data.length() == 0) && (freqHisList2 == null || freqHisList2.length() <= 0)) {
                clearWebHisCache();
                return;
            }
            setCacheData(data, freqHisList2);
            writeFile();
        }
    }

    public final List<Suggestion> getCacheSuggestion(boolean isSyncEnable) {
        if (!isSyncEnable) {
            return null;
        }
        if (cacheData == null || cacheJsonData == null) {
            try {
                String hisData = readFile();
                String freqHisData = readFreqHisFile();
                JSONArray dataJsonArray = null;
                JSONArray freqHisJson2 = null;
                if (!TextUtils.isEmpty(hisData)) {
                    dataJsonArray = new JSONArray(hisData);
                }
                if (!TextUtils.isEmpty(freqHisData)) {
                    freqHisJson2 = new JSONArray(freqHisData);
                }
                setCacheData(dataJsonArray, freqHisJson2);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return cacheData;
    }

    public final List<SearchHistory> getCacheServerHistory() {
        List<SearchHistory> list;
        List cacheSuggestions = getCacheSuggestion(true);
        if (cacheSuggestions == null) {
            return null;
        }
        synchronized (hisCacheFileLock) {
            Iterable<Suggestion> $this$map$iv = cacheSuggestions;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Suggestion it : $this$map$iv) {
                SearchHistory searchHistory = r15;
                SearchHistory searchHistory2 = new SearchHistory((String) null, (String) null, (String) null, 0, 0, false, false, (String) null, 0, (String) null, (String) null, (String) null, FileWatcher.ALL_EVENTS, (DefaultConstructorMarker) null);
                SearchHistory $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2 = searchHistory;
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setType(it.getWebSuggestionType());
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setWord(it.getUserQuery());
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setImgKey(it.getQuery());
                com.baidu.searchbox.hissug.searchable.bean.SearchHistory searchHistory3 = it instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory ? (com.baidu.searchbox.hissug.searchable.bean.SearchHistory) it : null;
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setTag(searchHistory3 != null ? searchHistory3.getTag() : null);
                com.baidu.searchbox.hissug.searchable.bean.SearchHistory searchHistory4 = it instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory ? (com.baidu.searchbox.hissug.searchable.bean.SearchHistory) it : null;
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setUrl(searchHistory4 != null ? searchHistory4.getUrl() : null);
                com.baidu.searchbox.hissug.searchable.bean.SearchHistory searchHistory5 = it instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory ? (com.baidu.searchbox.hissug.searchable.bean.SearchHistory) it : null;
                boolean z = false;
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setDirectHis(searchHistory5 != null ? searchHistory5.isDirectHis() : false);
                com.baidu.searchbox.hissug.searchable.bean.SearchHistory searchHistory6 = it instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory ? (com.baidu.searchbox.hissug.searchable.bean.SearchHistory) it : null;
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setThumbUrl(searchHistory6 != null ? searchHistory6.getThumbUrl() : null);
                com.baidu.searchbox.hissug.searchable.bean.SearchHistory searchHistory7 = it instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory ? (com.baidu.searchbox.hissug.searchable.bean.SearchHistory) it : null;
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setSearchUrl(searchHistory7 != null ? searchHistory7.getSearchUrl() : null);
                com.baidu.searchbox.hissug.searchable.bean.SearchHistory searchHistory8 = it instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory ? (com.baidu.searchbox.hissug.searchable.bean.SearchHistory) it : null;
                $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setFreqHis(searchHistory8 != null ? searchHistory8.isFreqHis() : false);
                if ($this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.isFreqHis()) {
                    CharSequence word = $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getWord();
                    if (word == null || word.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setWord($this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getImgKey());
                    }
                    $this$getCacheServerHistory_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setSa(it.getSa());
                }
                destination$iv$iv.add(searchHistory);
            }
            list = (List) destination$iv$iv;
        }
        return list;
    }

    public final JSONArray getHisCache() {
        List list = getCacheSuggestion(HistoryConfig.isSyncEnable());
        JSONArray array = null;
        if (list != null && list.size() > 0) {
            int len = list.size();
            array = new JSONArray();
            for (int i2 = 0; i2 < len; i2++) {
                Suggestion suggestion = list.get(i2);
                if (suggestion != null) {
                    String query = suggestion.getText1();
                    if (!TextUtils.isEmpty(query)) {
                        array.put(query);
                    }
                }
            }
        }
        return array;
    }

    private final void setCacheData(JSONArray data, JSONArray freqHisData) {
        synchronized (hisCacheFileLock) {
            NetHistoryCacheManager netHistoryCacheManager = INSTANCE;
            freqHisJson = freqHisData;
            ArrayList<Suggestion> parseFreqHis = netHistoryCacheManager.parseFreqHis(freqHisData);
            freqHisList = parseFreqHis;
            cacheJsonData = data;
            cacheData = netHistoryCacheManager.parseData(data, parseFreqHis);
            Unit unit = Unit.INSTANCE;
        }
        postHisCacheChangeEvent();
    }

    private final String readFile() {
        return FileUtils.readCacheData(AppRuntime.getAppContext(), fileName);
    }

    private final String readFreqHisFile() {
        return FileUtils.readCacheData(AppRuntime.getAppContext(), freqHisfileName);
    }

    /* access modifiers changed from: private */
    /* renamed from: writeFile$lambda-7  reason: not valid java name */
    public static final void m19887writeFile$lambda7() {
        synchronized (hisCacheFileLock) {
            try {
                JSONArray jSONArray = cacheJsonData;
                if ((jSONArray != null ? jSONArray.length() : 0) > 0) {
                    FileUtils.cache(AppRuntime.getAppContext(), fileName, String.valueOf(cacheJsonData), 0);
                } else {
                    FileUtils.cache(AppRuntime.getAppContext(), fileName, "", 0);
                }
                if (freqHisJson != null) {
                    Context appContext = AppRuntime.getAppContext();
                    String str = freqHisfileName;
                    JSONArray jSONArray2 = freqHisJson;
                    Intrinsics.checkNotNull(jSONArray2);
                    FileUtils.cache(appContext, str, jSONArray2.toString(), 0);
                } else {
                    FileUtils.cache(AppRuntime.getAppContext(), freqHisfileName, "", 0);
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void writeFile() {
        ExecutorUtilsExt.postOnElastic(new NetHistoryCacheManager$$ExternalSyntheticLambda0(), "hissug_nethis_cache", 2);
    }

    public final void clearWebHisCache() {
        if (DEBUG) {
            Log.i(TAG, "clearWebHisCache ");
        }
        synchronized (hisCacheFileLock) {
            NetHistoryCacheManager netHistoryCacheManager = INSTANCE;
            cacheData = null;
            cacheJsonData = null;
            freqHisList.clear();
            freqHisJson = null;
            FileUtils.deleteCache(AppRuntime.getAppContext(), fileName);
            FileUtils.deleteCache(AppRuntime.getAppContext(), freqHisfileName);
            netHistoryCacheManager.postHisCacheChangeEvent();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A[Catch:{ Exception -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.baidu.searchbox.hissug.searchable.bean.Suggestion> parseData(org.json.JSONArray r18, java.util.ArrayList<com.baidu.searchbox.hissug.searchable.bean.Suggestion> r19) {
        /*
            r17 = this;
            java.lang.String r0 = "freqHisList"
            r1 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = r19
            r4 = 0
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r6 = 1
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x001e
            r3 = r1
            goto L_0x001f
        L_0x001e:
            r3 = 0
        L_0x001f:
            if (r3 == 0) goto L_0x002a
            r4 = 0
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5
            r2.addAll(r5)
        L_0x002a:
            if (r18 != 0) goto L_0x002e
            return r2
        L_0x002e:
            r3 = r18
            int r4 = r3.length()     // Catch:{ Exception -> 0x00eb }
            r5 = 0
        L_0x0036:
            if (r5 >= r4) goto L_0x00f3
            org.json.JSONObject r7 = r3.optJSONObject(r5)     // Catch:{ Exception -> 0x00eb }
            if (r7 != 0) goto L_0x0040
            goto L_0x00e6
        L_0x0040:
            java.lang.String r8 = "type"
            int r8 = r7.getInt(r8)     // Catch:{ Exception -> 0x00eb }
            r10 = 2000(0x7d0, float:2.803E-42)
            if (r8 == r10) goto L_0x0056
            r11 = 2016(0x7e0, float:2.825E-42)
            if (r8 == r11) goto L_0x0056
            r11 = 2001(0x7d1, float:2.804E-42)
            if (r8 != r11) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r11 = 0
            goto L_0x0057
        L_0x0056:
            r11 = r6
        L_0x0057:
            if (r11 == 0) goto L_0x00e6
            com.baidu.searchbox.hissug.searchable.bean.SearchHistory r12 = new com.baidu.searchbox.hissug.searchable.bean.SearchHistory     // Catch:{ Exception -> 0x00eb }
            r12.<init>(r7)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r13 = r12.getText1()     // Catch:{ Exception -> 0x00eb }
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ Exception -> 0x00eb }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x00eb }
            if (r13 == 0) goto L_0x0072
            java.lang.String r13 = r12.getUserQuery()     // Catch:{ Exception -> 0x00eb }
            r12.setText1(r13)     // Catch:{ Exception -> 0x00eb }
        L_0x0072:
            r12.setNetHistory()     // Catch:{ Exception -> 0x00eb }
            java.lang.String r13 = "history"
            r12.setSourceName(r13)     // Catch:{ Exception -> 0x00eb }
            boolean r13 = DEBUG     // Catch:{ Exception -> 0x00eb }
            if (r13 == 0) goto L_0x00a5
            java.lang.String r13 = TAG     // Catch:{ Exception -> 0x00eb }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb }
            r14.<init>()     // Catch:{ Exception -> 0x00eb }
            java.lang.String r15 = "HisSug "
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ Exception -> 0x00eb }
            java.lang.StringBuilder r14 = r14.append(r5)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r15 = " = "
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r15 = r12.getText1()     // Catch:{ Exception -> 0x00eb }
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x00eb }
            android.util.Log.d(r13, r14)     // Catch:{ Exception -> 0x00eb }
        L_0x00a5:
            r13 = 0
            java.util.Iterator r14 = r19.iterator()     // Catch:{ Exception -> 0x00eb }
        L_0x00aa:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x00eb }
            if (r15 == 0) goto L_0x00d3
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x00eb }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r0)     // Catch:{ Exception -> 0x00eb }
            com.baidu.searchbox.hissug.searchable.bean.Suggestion r15 = (com.baidu.searchbox.hissug.searchable.bean.Suggestion) r15     // Catch:{ Exception -> 0x00eb }
            java.lang.String r16 = r15.getText1()     // Catch:{ Exception -> 0x00eb }
            r6 = r16
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00eb }
            java.lang.String r16 = r12.getText1()     // Catch:{ Exception -> 0x00eb }
            r9 = r16
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x00eb }
            boolean r6 = android.text.TextUtils.equals(r6, r9)     // Catch:{ Exception -> 0x00eb }
            if (r6 == 0) goto L_0x00d1
            r13 = 1
            goto L_0x00d3
        L_0x00d1:
            r6 = 1
            goto L_0x00aa
        L_0x00d3:
            boolean r6 = r12.isDirectHis()     // Catch:{ Exception -> 0x00eb }
            if (r6 != 0) goto L_0x00df
            if (r8 != r10) goto L_0x00df
            if (r13 == 0) goto L_0x00df
            r9 = 1
            goto L_0x00e0
        L_0x00df:
            r9 = 0
        L_0x00e0:
            r6 = r9
            if (r6 != 0) goto L_0x00e6
            r2.add(r12)     // Catch:{ Exception -> 0x00eb }
        L_0x00e6:
            int r5 = r5 + 1
            r6 = 1
            goto L_0x0036
        L_0x00eb:
            r0 = move-exception
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x00f3
            r0.printStackTrace()
        L_0x00f3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.hissug.his.NetHistoryCacheManager.parseData(org.json.JSONArray, java.util.ArrayList):java.util.ArrayList");
    }

    public final ArrayList<Suggestion> parseFreqHis(JSONArray data) {
        if (data == null || data.length() <= 0) {
            return new ArrayList<>();
        }
        ArrayList resultList = new ArrayList();
        int length = data.length();
        for (int i2 = 0; i2 < length; i2++) {
            com.baidu.searchbox.hissug.searchable.bean.SearchHistory item = new com.baidu.searchbox.hissug.searchable.bean.SearchHistory(data.optJSONObject(i2), true);
            if (TextUtils.isEmpty(item.getUserQuery())) {
                item.setUserQuery(item.getQuery());
            }
            if (TextUtils.isEmpty(item.getText1())) {
                item.setText1(item.getUserQuery());
            }
            item.setNetHistory();
            item.setSourceName("history");
            resultList.add(item);
        }
        return resultList;
    }

    public final void insertNormalHis(String query) {
        JSONArray jSONArray;
        if (HistoryConfig.isSyncEnable()) {
            if (DEBUG) {
                Log.i(TAG, "insert normal his : " + query);
            }
            com.baidu.searchbox.hissug.searchable.bean.SearchHistory searchHistory = new com.baidu.searchbox.hissug.searchable.bean.SearchHistory((String) null, (String) null, (HisTagDataModel) null, false, false, 31, (DefaultConstructorMarker) null);
            com.baidu.searchbox.hissug.searchable.bean.SearchHistory $this$insertNormalHis_u24lambda_u2d11 = searchHistory;
            $this$insertNormalHis_u24lambda_u2d11.setWebSuggestionType(2000);
            $this$insertNormalHis_u24lambda_u2d11.setUserQuery(query);
            if (TextUtils.isEmpty($this$insertNormalHis_u24lambda_u2d11.getText1())) {
                $this$insertNormalHis_u24lambda_u2d11.setText1($this$insertNormalHis_u24lambda_u2d11.getUserQuery());
            }
            $this$insertNormalHis_u24lambda_u2d11.setNetHistory();
            $this$insertNormalHis_u24lambda_u2d11.setSourceName("history");
            synchronized (hisCacheFileLock) {
                NetHistoryCacheManager netHistoryCacheManager = INSTANCE;
                int index = netHistoryCacheManager.indexOfNetHisInCache(searchHistory);
                if (index != 0) {
                    if (index > 0) {
                        ArrayList<Suggestion> arrayList = cacheData;
                        if (index < (arrayList != null ? arrayList.size() : 0)) {
                            ArrayList<Suggestion> arrayList2 = cacheData;
                            if (arrayList2 != null) {
                                Suggestion remove = arrayList2.remove(index);
                            }
                            JSONArray jSONArray2 = cacheJsonData;
                            if (jSONArray2 != null) {
                                jSONArray2.remove(index);
                            }
                        }
                    }
                    ArrayList<Suggestion> arrayList3 = cacheData;
                    Suggestion suggestion = null;
                    if ((arrayList3 != null ? arrayList3.size() : 0) > 0) {
                        ArrayList<Suggestion> arrayList4 = cacheData;
                        if (arrayList4 != null) {
                            suggestion = arrayList4.get(0);
                        }
                    } else {
                        Suggestion suggestion2 = null;
                    }
                    Suggestion first = suggestion;
                    if (!(first instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory) || !((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) first).isFreqHis()) {
                        ArrayList<Suggestion> arrayList5 = cacheData;
                        if (arrayList5 != null) {
                            arrayList5.add(0, searchHistory);
                        }
                    } else {
                        ArrayList<Suggestion> arrayList6 = cacheData;
                        if (arrayList6 != null) {
                            arrayList6.add(1, searchHistory);
                        }
                    }
                    netHistoryCacheManager.postHisCacheChangeEvent();
                    JSONObject it = searchHistory.toJSON();
                    if (!(it == null || (jSONArray = cacheJsonData) == null)) {
                        jSONArray.put(0, it);
                    }
                    netHistoryCacheManager.writeFile();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final void deleteSuggestion(Suggestion hisSug) {
        JSONArray jSONArray;
        ArrayList<Suggestion> arrayList;
        if (HistoryConfig.isSyncEnable()) {
            if (DEBUG) {
                Log.i(TAG, "delete his : " + (hisSug != null ? hisSug.getUserQuery() : null));
            }
            synchronized (hisCacheFileLock) {
                if (hisSug != null) {
                    int index = INSTANCE.indexOfNetHisInCache(hisSug);
                    if (index >= 0) {
                        ArrayList<Suggestion> arrayList2 = cacheData;
                        int i2 = 0;
                        if ((arrayList2 != null ? arrayList2.size() : 0) > index && (arrayList = cacheData) != null) {
                            Suggestion remove = arrayList.remove(index);
                        }
                        JSONArray jSONArray2 = cacheJsonData;
                        if (jSONArray2 != null) {
                            i2 = jSONArray2.length();
                        }
                        if (i2 > index && (jSONArray = cacheJsonData) != null) {
                            jSONArray.remove(index);
                        }
                    }
                    if ((hisSug instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory) && ((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) hisSug).isFreqHis()) {
                        freqHisList.clear();
                        freqHisJson = null;
                    }
                }
                NetHistoryCacheManager netHistoryCacheManager = INSTANCE;
                netHistoryCacheManager.postHisCacheChangeEvent();
                netHistoryCacheManager.writeFile();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final int indexOfNetHisInCache(Suggestion item) {
        ArrayList<Suggestion> $this$forEachIndexed$iv = cacheData;
        if ($this$forEachIndexed$iv == null) {
            return -1;
        }
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Suggestion suggestion = (Suggestion) item$iv;
            if (TextUtils.equals(item.getUserQuery(), suggestion.getUserQuery())) {
                if (!TextUtils.isEmpty(item.getThumbUrl())) {
                    if (TextUtils.equals(item.getThumbUrl(), suggestion.getThumbUrl())) {
                        return index;
                    }
                } else if (!(item instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory) || TextUtils.isEmpty(((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) item).getTag()) || !(suggestion instanceof com.baidu.searchbox.hissug.searchable.bean.SearchHistory) || TextUtils.equals(((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) item).getTag(), ((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) suggestion).getTag())) {
                    return index;
                } else {
                    if (((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) suggestion).isFreqHis() && (TextUtils.isEmpty(((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) item).getUrl()) || TextUtils.equals(((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) item).getUrl(), ((com.baidu.searchbox.hissug.searchable.bean.SearchHistory) suggestion).getUrl()))) {
                        return index;
                    }
                }
            }
            index = index$iv;
        }
        return -1;
    }

    private final void postHisCacheChangeEvent() {
        BdEventBus.Companion.getDefault().post(new HisCacheChangeEvent());
    }
}
